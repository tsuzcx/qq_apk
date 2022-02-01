package cooperation.qzone;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.utils.IQzoneVideoHelper;
import common.config.service.QzoneConfig;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.PluginInfo;
import cooperation.qzone.report.lp.LpReportInfo_dc01500;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.video.QzoneVerticalVideoConst;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class QzoneVerticalVideoDownloadActivity
  extends BaseActivity
  implements PluginManagerHelper.OnPluginManagerLoadedListener
{
  public static final int ARG_AUTO_DOWNLOAD = 0;
  public static final int ARG_MANUL_DOWNLOAD = 1;
  public static final int MSG_DOWNLOAD_PLUGIN_ERROR = 1010;
  public static final int MSG_DOWNLOAD_PLUGIN_PROGRESS = 1004;
  public static final int MSG_DOWNLOAD_SO_ERROR = 1008;
  public static final int MSG_DOWNLOAD_SO_START = 1007;
  public static final int MSG_DOWNLOAD_SO_TIMEOUT = 1009;
  public static final int MSG_INIT_UI = 1000;
  public static final int MSG_INSTALL_PLUGIN_ERROR = 1003;
  public static final int MSG_INSTALL_PLUGIN_TIMEOUT = 1006;
  public static final int MSG_QUERY_PLUGIN_STATE = 1005;
  public static final int MSG_QZONE_PLUGIN_INSTALL_ERROR = 1012;
  public static final int MSG_QZONE_PLUGIN_INSTALL_SUCCESS = 1011;
  private static final int PERIOD_QUERY = 500;
  private static final String TAG = "QzoneVerticalVideoDownloadActivity";
  private String account;
  private View.OnClickListener cancelInstallListener = new QzoneVerticalVideoDownloadActivity.4(this);
  private View.OnClickListener installListener = new QzoneVerticalVideoDownloadActivity.3(this);
  private String mBackupUrl;
  private TextView mBtnAction;
  private ImageView mBtnClose;
  private String mCurrentUin;
  private boolean mDoNotCheckQZonePlugin = false;
  private ViewGroup mDownloadRoot;
  private ProgressBar mDownloadingBar;
  private Handler mHandler = new QzoneVerticalVideoDownloadActivity.1(this);
  private boolean mInstalling;
  private boolean mIsCanceled;
  private boolean mIsFromVideoStory = false;
  private boolean mIsInstallTimeout;
  private AtomicBoolean mIsUIInited = new AtomicBoolean(false);
  private long mLaunchTime;
  private ImageView mLiveVideoImgIv;
  private int mMode;
  private String mPluginId;
  private BroadcastReceiver mReceiver;
  private int mSceneType = -1;
  private TextView mTxtPluginSize;
  private URLDrawable mURLDrawable;
  private View mWaitingView;
  private PluginManagerClient manger;
  private int progress = 0;
  private int retryDownloadNum;
  
  private void cancelInstall()
  {
    this.mInstalling = false;
    if (QzoneConfig.getInstance().getConfig("VerticalVideoLayer", "PluginDownloadCanceledOnCloseBtn", 0) == 1) {
      this.manger.cancelInstall(this.mPluginId);
    }
    QzoneVideoBeaconReport.reportVideoEvent(this.account, "vertical_video_entry", "9", null);
  }
  
  private boolean checkEnvironment()
  {
    if (getAppRuntime() != null) {
      this.account = getAppRuntime().getAccount();
    }
    return true;
  }
  
  private void doLaunchVerticalVideo()
  {
    Object localObject = this.mDownloadRoot;
    if (localObject != null) {
      ((ViewGroup)localObject).setVisibility(8);
    }
    localObject = this.mWaitingView;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("mode", this.mMode);
    ((Intent)localObject).putExtras(getIntent());
    ((Intent)localObject).putExtra("launch_time", System.currentTimeMillis());
    ((IQzoneVideoHelper)QRoute.api(IQzoneVideoHelper.class)).launchPluginActivityForResult(this, this.account, (Intent)localObject, -1);
    finish();
  }
  
  private String getPluginName()
  {
    return "QZoneVerticalVideo";
  }
  
  private int getQzonePluginStatus()
  {
    Object localObject = PluginStatic.getClassLoader("qzone_plugin.apk");
    int j = 4;
    if (localObject != null)
    {
      QLog.d("QzoneVerticalVideoDownloadActivity", 1, " qzone_plugin dexLoaded");
      return 4;
    }
    QLog.d("QzoneVerticalVideoDownloadActivity", 1, " qzone_plugin dex not Loaded");
    int i = j;
    if (this.app != null)
    {
      localObject = (IPluginManager)this.app.getManager(QQManagerFactory.MGR_PLUGIN);
      i = j;
      if (localObject != null)
      {
        localObject = ((IPluginManager)localObject).d("qzone_plugin.apk");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" qzone_plugin info.mState = ");
        j = -2;
        if (localObject != null) {
          i = ((PluginInfo)localObject).mState;
        } else {
          i = -2;
        }
        localStringBuilder.append(i);
        QLog.d("QzoneVerticalVideoDownloadActivity", 1, localStringBuilder.toString());
        i = j;
        if (localObject != null) {
          i = ((PluginInfo)localObject).mState;
        }
      }
    }
    return i;
  }
  
  private void handlePluginInfo(PluginBaseInfo paramPluginBaseInfo)
  {
    if (paramPluginBaseInfo == null)
    {
      installPlugin();
      this.mHandler.sendEmptyMessageDelayed(1005, 500L);
      return;
    }
    int i = paramPluginBaseInfo.mState;
    if (i != -2)
    {
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 2) {
            break label205;
          }
          if (i != 3) {
            if (i != 4)
            {
              if (i != 5)
              {
                if (!QLog.isColorLevel()) {
                  return;
                }
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("handlePluginInfo, STATE=");
                localStringBuilder.append(paramPluginBaseInfo.mState);
                QLog.d("QzoneVerticalVideoDownloadActivity", 2, localStringBuilder.toString());
              }
            }
            else
            {
              if (QLog.isColorLevel()) {
                QLog.d("QzoneVerticalVideoDownloadActivity", 2, "handlePluginInfo, STATE_INSTALLED");
              }
              launchVerticalVideoLayer();
              return;
            }
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("handlePluginInfo, state=");
          localStringBuilder.append(paramPluginBaseInfo.mState);
          QLog.d("QzoneVerticalVideoDownloadActivity", 2, localStringBuilder.toString());
          this.mHandler.sendEmptyMessageDelayed(1005, 500L);
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.d("QzoneVerticalVideoDownloadActivity", 2, "handlePluginInfo, STATE_NODOWNLOAD");
      }
      if (QLog.isColorLevel()) {
        QLog.d("QzoneVerticalVideoDownloadActivity", 2, "handlePluginInfo, STATE_DOWNLOADING");
      }
      label205:
      handleDownloadPlugin(paramPluginBaseInfo);
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("QzoneVerticalVideoDownloadActivity", 2, "handlePluginInfo, STATE_ERROR");
      }
      this.mHandler.sendEmptyMessage(1003);
    }
  }
  
  private void installPlugin()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QzoneVerticalVideoDownloadActivity", 2, "installPlugin");
    }
    this.mIsInstallTimeout = false;
    this.mInstalling = true;
    Message localMessage = Message.obtain();
    localMessage.what = 1000;
    localMessage.arg1 = 0;
    this.mHandler.sendMessage(localMessage);
    int i = QzoneConfig.getInstance().getConfig("LiveSetting", "PluginInstallTimeout", 60000);
    this.mHandler.sendEmptyMessageDelayed(1006, i);
    this.manger.installPlugin(this.mPluginId);
  }
  
  private void installPluginSilence()
  {
    QLog.d("QzoneVerticalVideoDownloadActivity", 1, "installPluginSilence");
    this.manger.installPlugin(this.mPluginId);
  }
  
  private void installQzonePlugin()
  {
    long l = System.currentTimeMillis();
    QLog.i("QzoneVerticalVideoDownloadActivity", 1, " installQzonePlugin");
    if (this.app == null)
    {
      ToastUtil.a().a(HardCodeUtil.a(2131909981));
      QLog.e("QzoneVerticalVideoDownloadActivity", 1, " installQzonePlugin, app == null");
      finish();
      return;
    }
    IPluginManager localIPluginManager = (IPluginManager)this.app.getManager(QQManagerFactory.MGR_PLUGIN);
    if (localIPluginManager != null) {
      localIPluginManager.installPlugin("qzone_plugin.apk", new QzoneVerticalVideoDownloadActivity.5(this, l));
    }
  }
  
  private void launchVerticalVideoLayer()
  {
    StringBuilder localStringBuilder;
    if (!this.mDoNotCheckQZonePlugin)
    {
      int i = getQzonePluginStatus();
      if (i != 4)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("qzone_plugin is not installed yet, status = ");
        ((StringBuilder)localObject).append(i);
        QZLog.d("QzoneVerticalVideoDownloadActivity", 1, ((StringBuilder)localObject).toString());
        if (i != 0)
        {
          if ((i != 3) && (i != 5))
          {
            ToastUtil.a().a(HardCodeUtil.a(2131909990));
            finish();
          }
          else
          {
            ToastUtil.a().a(HardCodeUtil.a(2131909988));
            finish();
          }
        }
        else {
          installQzonePlugin();
        }
        if (this.app != null)
        {
          localObject = new HashMap();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("not_ready_");
          localStringBuilder.append(i);
          ((HashMap)localObject).put("status", localStringBuilder.toString());
          reportToBeacon(this.app, "vertical_layer_plugin_depend", (HashMap)localObject);
        }
        return;
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("QVVideoDownloadActivity launchVerticalVideoLayer timeDelay:");
    ((StringBuilder)localObject).append(System.currentTimeMillis() - this.mLaunchTime);
    ((StringBuilder)localObject).append("ms");
    QZLog.d("plugin_tag", 1, ((StringBuilder)localObject).toString());
    if (QZLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("VerticalVideoLayer starttime launchVerticalVideoLayer:");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      QZLog.i("QzoneVerticalVideoDownloadActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (this.mIsCanceled)
    {
      QLog.w("QzoneVerticalVideoDownloadActivity", 1, "launch has canceled");
      return;
    }
    if (getAppRuntime() != null)
    {
      localObject = getAppRuntime().getAccount();
    }
    else if (!TextUtils.isEmpty(this.mCurrentUin))
    {
      QLog.w("QzoneVerticalVideoDownloadActivity", 1, "launchVerticalVideoLayer, getAppRuntime is null");
      localObject = this.mCurrentUin;
    }
    else
    {
      localObject = "";
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QQToast.makeText(this, HardCodeUtil.a(2131909972), 0).show();
      localObject = this.mPluginId;
      double d = System.currentTimeMillis() - this.mLaunchTime;
      Double.isNaN(d);
      d /= 1000.0D;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.mMode);
      localStringBuilder.append("");
      LpReportInfo_dc01500.reportLaunch((String)localObject, "", d, 6, localStringBuilder.toString());
      finish();
      return;
    }
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      doLaunchVerticalVideo();
      return;
    }
    ThreadManager.getUIHandler().post(new QzoneVerticalVideoDownloadActivity.6(this));
  }
  
  private void parseIntent()
  {
    for (;;)
    {
      try
      {
        Intent localIntent = getIntent();
        if (localIntent == null) {
          return;
        }
        bool = true;
        this.mMode = localIntent.getIntExtra("key_mode", 1);
        this.mLaunchTime = localIntent.getLongExtra("key_launch_time", System.currentTimeMillis());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("QVVideoDownloadActivity parseIntent timeDelay:");
        localStringBuilder.append(System.currentTimeMillis() - this.mLaunchTime);
        localStringBuilder.append("ms");
        QZLog.d("plugin_tag", 1, localStringBuilder.toString());
        this.mBackupUrl = localIntent.getStringExtra("key_backup_url");
        this.mCurrentUin = localIntent.getStringExtra("key_current_login_uin");
        this.mIsFromVideoStory = QzoneVerticalVideoConst.isRequestVideoStoryBusiness(localIntent);
        this.mSceneType = localIntent.getIntExtra("key_weishi_scene_type", -1);
        this.mPluginId = "qzone_vertical_video_plugin.apk";
        if (QzoneConfig.getInstance().getConfig("LiveSetting", "VerticalPluginDoNotCheckQZonePlugin", 0) == 1)
        {
          this.mDoNotCheckQZonePlugin = bool;
          return;
        }
      }
      catch (Exception localException)
      {
        QZLog.e("QzoneVerticalVideoDownloadActivity", "parseIntent error", localException);
        return;
      }
      boolean bool = false;
    }
  }
  
  private static void reportTimeCostToBeacon(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    QzoneHandlerThreadFactory.getHandlerThread("Report_HandlerThread").post(new QzoneVerticalVideoDownloadActivity.7(paramString2, paramString3, paramQQAppInterface, paramString1, paramInt));
  }
  
  private static void reportToBeacon(QQAppInterface paramQQAppInterface, String paramString, HashMap paramHashMap)
  {
    QzoneHandlerThreadFactory.getHandlerThread("Report_HandlerThread").post(new QzoneVerticalVideoDownloadActivity.8(paramQQAppInterface, paramString, paramHashMap));
  }
  
  private void updateProgress(int paramInt)
  {
    ProgressBar localProgressBar = this.mDownloadingBar;
    if (localProgressBar != null) {
      localProgressBar.setProgress(paramInt);
    }
  }
  
  private void updateTextProgress(boolean paramBoolean1, boolean paramBoolean2)
  {
    TextView localTextView = this.mBtnAction;
    if (localTextView == null) {
      return;
    }
    if (paramBoolean1)
    {
      localTextView.setText(HardCodeUtil.a(2131909973));
      return;
    }
    if (paramBoolean2)
    {
      localTextView.setText(HardCodeUtil.a(2131909977));
      return;
    }
    this.progress %= 3;
    int i = this.progress;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2) {
          localTextView.setText(HardCodeUtil.a(2131909987));
        }
      }
      else {
        localTextView.setText(HardCodeUtil.a(2131909975));
      }
    }
    else {
      localTextView.setText(HardCodeUtil.a(2131909978));
    }
    this.progress += 1;
  }
  
  protected void handleDownloadPlugin(PluginBaseInfo paramPluginBaseInfo)
  {
    if (this.mIsUIInited.get())
    {
      int i = (int)(paramPluginBaseInfo.mDownloadProgress * 100.0F);
      if (QLog.isColorLevel())
      {
        paramPluginBaseInfo = new StringBuilder();
        paramPluginBaseInfo.append("handlePluginInfo, STATE_DOWNLOADING, progress=");
        paramPluginBaseInfo.append(i);
        QLog.d("QzoneVerticalVideoDownloadActivity", 2, paramPluginBaseInfo.toString());
      }
      if (i > 0)
      {
        this.mHandler.removeMessages(1006);
        this.mHandler.obtainMessage(1004, i, 0).sendToTarget();
        updateTextProgress(false, false);
      }
      else if (this.mIsInstallTimeout)
      {
        this.mHandler.removeMessages(1006);
        updateTextProgress(true, false);
      }
    }
    this.mHandler.sendEmptyMessageDelayed(1005, 500L);
  }
  
  public void initUI(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("### initUI reportVideoPlayUpdateExp mSceneType = ");
    ((StringBuilder)localObject).append(this.mSceneType);
    QLog.i("QzoneVerticalVideoDownloadActivity", 1, ((StringBuilder)localObject).toString());
    this.mWaitingView.setVisibility(8);
    this.mDownloadRoot.setVisibility(0);
    this.mTxtPluginSize = ((TextView)findViewById(2131440439));
    localObject = QzoneConfig.getInstance().getConfig("VerticalVideoLayer", "VerticalVideoPluginSizeText", "插件约1M");
    this.mTxtPluginSize.setText((CharSequence)localObject);
    ((TextView)findViewById(2131449143)).setText(QzoneConfig.getInstance().getConfig("VerticalVideoLayer", "VerticalVideoPluginUpdateTips", "升级插件，体验精彩小视频"));
    this.mDownloadingBar = ((ProgressBar)findViewById(2131432106));
    this.mBtnAction = ((TextView)findViewById(2131429786));
    this.mBtnClose = ((ImageView)findViewById(2131429840));
    this.mLiveVideoImgIv = ((ImageView)findViewById(2131443708));
    try
    {
      localObject = QzoneConfig.getInstance().getConfig("VerticalVideoLayer", "VerticalDownloadProgressBackgroundUrl", "https://qzonestyle.gtimg.cn/aoi/sola/20180412205352_WOHxRvJEI2.png");
      if (this.mIsFromVideoStory) {
        localObject = QzoneConfig.getInstance().getConfig("VerticalVideoLayer", "VerticalDownloadProgressBackgroundUrlFromVS", "https://qzonestyle.gtimg.cn/aoi/sola/20190319155945_1kfosfdfO0.png");
      }
      this.mURLDrawable = URLDrawable.getDrawable((String)localObject, null);
      if (this.mURLDrawable != null)
      {
        this.mLiveVideoImgIv.setImageDrawable(this.mURLDrawable);
        this.mURLDrawable.setURLDrawableListener(new QzoneVerticalVideoDownloadActivity.2(this));
      }
    }
    catch (Exception localException)
    {
      QLog.w("QzoneVerticalVideoDownloadActivity", 1, "initUI", localException);
    }
    this.mBtnClose.setOnClickListener(this.cancelInstallListener);
    if (paramInt == 0) {
      this.mBtnAction.setText(HardCodeUtil.a(2131909989));
    } else {
      this.mBtnAction.setText(HardCodeUtil.a(2131909974));
    }
    this.mBtnAction.setOnClickListener(this.installListener);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131628794);
    this.mDownloadRoot = ((FrameLayout)findViewById(2131432116));
    this.mWaitingView = findViewById(2131450023);
    if (!checkEnvironment())
    {
      finish();
      return;
    }
    parseIntent();
    try
    {
      paramBundle = new IntentFilter();
      paramBundle.addAction("action_launch_completed");
      this.mReceiver = new QzoneVerticalVideoDownloadActivity.LaunchCompletedObserver(this, getPluginName(), this.mPluginId);
      registerReceiver(this.mReceiver, paramBundle);
    }
    catch (Exception paramBundle)
    {
      QLog.w("QzoneVerticalVideoDownloadActivity", 1, "", paramBundle);
    }
    PluginManagerHelper.getPluginInterface(this, this);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.mHandler.removeMessages(1005);
    this.mHandler.removeMessages(1006);
    if (this.mReceiver != null)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("QzoneVerticalVideoDownloadActivity", 1, "unregisterReceiver");
        }
        unregisterReceiver(this.mReceiver);
      }
      catch (Exception localException)
      {
        QLog.w("QzoneVerticalVideoDownloadActivity", 1, "", localException);
      }
      this.mReceiver = null;
    }
    this.manger = null;
    LeakUtil.fixOnPauseListenersLeak(this);
  }
  
  protected void onHandleMessage(Handler paramHandler, Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 1001: 
    case 1002: 
    case 1007: 
    case 1008: 
    case 1009: 
    default: 
    case 1012: 
      ToastUtil.a().a(HardCodeUtil.a(2131909984));
      finish();
      return;
    case 1011: 
      if (!isFinishing())
      {
        launchVerticalVideoLayer();
        return;
      }
      QLog.d("QzoneVerticalVideoDownloadActivity", 1, "activity is finished");
      return;
    case 1010: 
      if ((paramMessage.obj instanceof String))
      {
        paramHandler.removeMessages(1006);
        paramHandler.removeMessages(1005);
        paramHandler.removeMessages(1004);
        this.mBtnAction.setText((String)paramMessage.obj);
        return;
      }
      break;
    case 1006: 
      this.mIsInstallTimeout = true;
      this.mInstalling = false;
      return;
    case 1005: 
      if (QLog.isDevelopLevel()) {
        QLog.d("QzoneVerticalVideoDownloadActivity", 4, "MSG_QUERY_PLUGIN_STATE");
      }
      if (!isFinishing())
      {
        handlePluginInfo(this.manger.queryPlugin(this.mPluginId));
        return;
      }
      break;
    case 1004: 
      updateProgress(paramMessage.arg1);
      return;
    case 1003: 
      this.mInstalling = false;
      int i = QzoneConfig.getInstance().getConfig("LiveSetting", "PluginRetryDownloadTimes", 1);
      paramHandler = new StringBuilder();
      paramHandler.append("MSG_INSTALL_PLUGIN_ERROR, retryDownloadNum=");
      paramHandler.append(this.retryDownloadNum);
      QLog.w("QzoneVerticalVideoDownloadActivity", 4, paramHandler.toString());
      int j = this.retryDownloadNum;
      if (j < i)
      {
        this.retryDownloadNum = (j + 1);
        installPlugin();
        return;
      }
      this.mIsInstallTimeout = true;
      this.mInstalling = false;
      updateTextProgress(true, false);
      return;
    case 1000: 
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MSG_INIT_UI, mIsUIInited=");
      localStringBuilder.append(this.mIsUIInited);
      QLog.i("QzoneVerticalVideoDownloadActivity", 1, localStringBuilder.toString());
      if (!this.mIsUIInited.get())
      {
        initUI(paramMessage.arg1);
        this.mIsUIInited.set(true);
      }
      paramHandler.sendEmptyMessage(1005);
    }
  }
  
  public void onPluginManagerLoaded(PluginManagerClient paramPluginManagerClient)
  {
    if (paramPluginManagerClient == null)
    {
      PluginManagerHelper.getPluginInterface(this, this);
      return;
    }
    this.manger = paramPluginManagerClient;
    paramPluginManagerClient = this.manger.queryPlugin(this.mPluginId);
    if (paramPluginManagerClient != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onPluginManagerLoaded] record.mState=");
      localStringBuilder.append(paramPluginManagerClient.mState);
      QZLog.i("QzoneVerticalVideoDownloadActivity", 1, localStringBuilder.toString());
      if (paramPluginManagerClient.mState == 4)
      {
        launchVerticalVideoLayer();
        return;
      }
      if (paramPluginManagerClient.mState == 2)
      {
        this.manger.installPlugin(this.mPluginId);
        return;
      }
      QLog.d("QzoneVerticalVideoDownloadActivity", 1, "[onPluginManagerLoaded] plugin has not installed");
      paramPluginManagerClient = this.mPluginId;
      double d = System.currentTimeMillis() - this.mLaunchTime;
      Double.isNaN(d);
      d /= 1000.0D;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.mMode);
      localStringBuilder.append("");
      LpReportInfo_dc01500.reportLaunch(paramPluginManagerClient, "", d, 7, localStringBuilder.toString());
      if ((!TextUtils.isEmpty(this.mBackupUrl)) && (HttpUtil.isValidUrl(this.mBackupUrl)))
      {
        paramPluginManagerClient = new StringBuilder();
        paramPluginManagerClient.append(this.mBackupUrl);
        paramPluginManagerClient.append("&stayin=1");
        paramPluginManagerClient = paramPluginManagerClient.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("watch mode, jump to H5, ");
        localStringBuilder.append(paramPluginManagerClient);
        QLog.d("QzoneVerticalVideoDownloadActivity", 1, localStringBuilder.toString());
        QZoneHelper.forwardToBrowser(this, paramPluginManagerClient, -1, null, null);
        finish();
        return;
      }
      int i = NetworkState.getNetworkType();
      paramPluginManagerClient = new StringBuilder();
      paramPluginManagerClient.append("network type = ");
      paramPluginManagerClient.append(i);
      QLog.d("QzoneVerticalVideoDownloadActivity", 1, paramPluginManagerClient.toString());
      if ((1 != i) && (4 != i) && (5 != i) && (3 != i))
      {
        paramPluginManagerClient = Message.obtain();
        paramPluginManagerClient.what = 1000;
        paramPluginManagerClient.arg1 = 1;
        this.mHandler.sendMessage(paramPluginManagerClient);
        return;
      }
      installPlugin();
      return;
    }
    installPlugin();
    QZLog.e("QzoneVerticalVideoDownloadActivity", 1, new Object[] { "[onPluginManagerLoaded] no PluginManagerClient" });
    ToastUtil.a().a(HardCodeUtil.a(2131909979));
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.QzoneVerticalVideoDownloadActivity
 * JD-Core Version:    0.7.0.1
 */