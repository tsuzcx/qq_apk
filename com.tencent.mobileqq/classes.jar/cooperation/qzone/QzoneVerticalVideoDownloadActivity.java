package cooperation.qzone;

import Override;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import anzj;
import bjuh;
import bmgk;
import bmst;
import bmtd;
import bmvs;
import bmvt;
import bmvu;
import bmvv;
import bmvw;
import bnlv;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import cooperation.plugin.PluginInfo;
import cooperation.qzone.report.lp.LpReportInfo_dc01500;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.video.QzoneVerticalVideoConst;
import cooperation.qzone.video.QzoneVerticalVideoPluginProxyActivity;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import nnr;
import unx;

public class QzoneVerticalVideoDownloadActivity
  extends BaseActivity
  implements PluginManagerHelper.OnPluginManagerLoadedListener
{
  public static final int ARG_AUTO_DOWNLOAD = 0;
  public static final int ARG_MANUL_DOWNLOAD = 1;
  public static final String KEY_BACKUP_URL = "key_backup_url";
  public static final String KEY_CURRENT_FEEDUIN = "key_current_feeduin";
  public static final String KEY_CURRENT_FEED_CELLID = "key_current_feed_cellid";
  public static final String KEY_CURRENT_FEED_NICK = "key_current_feed_nick";
  public static final String KEY_CURRENT_LOGIN_UIN = "key_current_login_uin";
  public static final String KEY_LANDSCAPE_MODE = "key_video_float_layer_landscape_mode";
  public static final String KEY_LANDSCAPE_MODE_REQ_TYPE = "key_video_float_layer_landscape_mode_req_type";
  public static final String KEY_LAUNCH_TIME = "key_launch_time";
  public static final String KEY_MODE = "key_mode";
  public static final String KEY_PLUGIN_ID = "key_plugin_id";
  public static final String KEY_REQUEST_FROM = "key_request_from";
  public static final String KEY_VIDEO_STORY_JUMP_POSITION = "key_video_story_jump_position";
  public static final String KEY_VIDEO_STORY_SHARE_DATA_SOURCE_ID = "key_video_story_share_data_source_id";
  public static final String KEY_VIDEO_STORY_TRANPARENT_CELL_USER_INFO = "key_video_story_tranparent_cell_user_info";
  public static final String KEY_VIDEO_STORY_TRANPARENT_STORY_BANNER_DATA = "key_video_story_tranparent_story_banner_data";
  public static final String KEY_VIDEO_STORY_TRANPARENT_STORY_FEED = "key_video_story_tranparent_story_feed";
  public static final String KEY_VIDEO_STORY_TRANPARENT_VIDEO_RECOMMEND_INFO = "key_video_story_tranparent_video_recommend_info";
  public static final String KEY_VIDEO_WEISHI_FEEDS_TRACE_ID = "key_video_weishi_feeds_trace_id";
  public static final String KEY_VIDEO_WEISHI_LABEL_MY_VIDEO_INFO = "key_video_weishi_label_my_video_info";
  public static final String KEY_VIDEO_WEISHI_PUBLIC_ACCOUNT_FEED = "key_video_weishi_public_account_feed";
  public static final String KEY_VIDEO_WEISHI_PUBLIC_ACCOUNT_GLOBAL_CONFIG = "key_video_weishi_public_account_global_config";
  public static final String KEY_VIDEO_WEISHI_SERVER_RESPONSE_HEADER_MAP = "key_video_weishi_server_response_header_map";
  public static final String KEY_WEISHI_AGGREGATE_ID = "key_weishi_aggregate_id";
  public static final String KEY_WEISHI_AGGREGATE_NAME = "key_weishi_aggregate_name";
  public static final String KEY_WEISHI_ENTRANCE_TYPE = "key_weishi_entrance_type";
  public static final String KEY_WEISHI_FEEDS_BUSI_PARAMS = "key_weishi_feeds_busi_params";
  public static final String KEY_WEISHI_FEEDS_ID = "key_weishi_feeds_id";
  public static final String KEY_WEISHI_FEEDS_UGCKEY = "key_weisi_feeds_ugckey";
  public static final String KEY_WEISHI_FEEDS_UIN = "key_weisi_feeds_uin";
  public static final String KEY_WEISHI_FEED_APPID = "key_weishi_feed_appid";
  public static final String KEY_WEISHI_FUNCTIONID = "key_weishi_functionid";
  public static final String KEY_WEISHI_ROOFTOP_FEEDS_ID = "key_weishi_rooftop_feeds_id";
  public static final String KEY_WEISHI_SCENE_TYPE = "key_weishi_scene_type";
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
  private View.OnClickListener cancelInstallListener = new bmvv(this);
  private View.OnClickListener installListener = new bmvu(this);
  private String mBackupUrl;
  private TextView mBtnAction;
  private ImageView mBtnClose;
  private String mCurrentUin;
  private boolean mDoNotCheckQZonePlugin;
  private ViewGroup mDownloadRoot;
  private ProgressBar mDownloadingBar;
  private Handler mHandler = new bmvs(this);
  private boolean mInstalling;
  private boolean mIsCanceled;
  private boolean mIsFromVideoStory;
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
  private int progress;
  private int retryDownloadNum;
  
  private void cancelInstall()
  {
    this.mInstalling = false;
    if (QzoneConfig.getInstance().getConfig("VerticalVideoLayer", "PluginDownloadCanceledOnCloseBtn", 0) == 1) {
      this.manger.cancelInstall(this.mPluginId);
    }
    bnlv.a(this.account, "vertical_video_entry", "9", null);
  }
  
  private boolean checkEnvironment()
  {
    if (getAppRuntime() != null) {
      this.account = getAppRuntime().getAccount();
    }
    return true;
  }
  
  private String getPluginName()
  {
    return "QZoneVerticalVideo";
  }
  
  private int getQzonePluginStatus()
  {
    int j = -2;
    int i;
    if (PluginStatic.getClassLoader("qzone_plugin.apk") != null)
    {
      QLog.d("QzoneVerticalVideoDownloadActivity", 1, " qzone_plugin dexLoaded");
      i = 4;
      return i;
    }
    QLog.d("QzoneVerticalVideoDownloadActivity", 1, " qzone_plugin dex not Loaded");
    if (this.app != null)
    {
      Object localObject = (bmgk)this.app.getManager(27);
      if (localObject != null)
      {
        localObject = ((bmgk)localObject).a("qzone_plugin.apk");
        StringBuilder localStringBuilder = new StringBuilder().append(" qzone_plugin info.mState = ");
        if (localObject != null) {}
        for (i = ((PluginInfo)localObject).mState;; i = -2)
        {
          QLog.d("QzoneVerticalVideoDownloadActivity", 1, i);
          i = j;
          if (localObject == null) {
            break;
          }
          return ((PluginInfo)localObject).mState;
        }
      }
    }
    return 4;
  }
  
  private void handlePluginInfo(PluginBaseInfo paramPluginBaseInfo)
  {
    if (paramPluginBaseInfo == null)
    {
      installPlugin();
      this.mHandler.sendEmptyMessageDelayed(1005, 500L);
    }
    do
    {
      return;
      switch (paramPluginBaseInfo.mState)
      {
      }
    } while (!QLog.isColorLevel());
    QLog.d("QzoneVerticalVideoDownloadActivity", 2, "handlePluginInfo, STATE=" + paramPluginBaseInfo.mState);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("QzoneVerticalVideoDownloadActivity", 2, "handlePluginInfo, STATE_NODOWNLOAD");
    }
    if (QLog.isColorLevel()) {
      QLog.d("QzoneVerticalVideoDownloadActivity", 2, "handlePluginInfo, STATE_DOWNLOADING");
    }
    handleDownloadPlugin(paramPluginBaseInfo);
    return;
    QLog.d("QzoneVerticalVideoDownloadActivity", 2, "handlePluginInfo, state=" + paramPluginBaseInfo.mState);
    this.mHandler.sendEmptyMessageDelayed(1005, 500L);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("QzoneVerticalVideoDownloadActivity", 2, "handlePluginInfo, STATE_INSTALLED");
    }
    launchVerticalVideoLayer();
    return;
    if (QLog.isColorLevel()) {
      QLog.d("QzoneVerticalVideoDownloadActivity", 2, "handlePluginInfo, STATE_ERROR");
    }
    this.mHandler.sendEmptyMessage(1003);
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
      bjuh.a().a(anzj.a(2131711317));
      QLog.e("QzoneVerticalVideoDownloadActivity", 1, " installQzonePlugin, app == null");
      finish();
    }
    bmgk localbmgk;
    do
    {
      return;
      localbmgk = (bmgk)this.app.getManager(27);
    } while (localbmgk == null);
    localbmgk.installPlugin("qzone_plugin.apk", new bmvw(this, l));
  }
  
  private void launchVerticalVideoLayer()
  {
    if (!this.mDoNotCheckQZonePlugin)
    {
      int i = getQzonePluginStatus();
      if (i != 4)
      {
        QZLog.d("QzoneVerticalVideoDownloadActivity", 1, "qzone_plugin is not installed yet, status = " + i);
        switch (i)
        {
        case 1: 
        case 2: 
        case 4: 
        default: 
          bjuh.a().a(anzj.a(2131711326));
          finish();
        }
        for (;;)
        {
          if (this.app != null)
          {
            localObject = new HashMap();
            ((HashMap)localObject).put("status", "not_ready_" + i);
            reportToBeacon(this.app, "vertical_layer_plugin_depend", (HashMap)localObject);
          }
          return;
          bjuh.a().a(anzj.a(2131711324));
          finish();
          continue;
          installQzonePlugin();
        }
      }
    }
    QZLog.d("plugin_tag", 1, "QVVideoDownloadActivity launchVerticalVideoLayer timeDelay:" + (System.currentTimeMillis() - this.mLaunchTime) + "ms");
    if (QZLog.isColorLevel()) {
      QZLog.i("QzoneVerticalVideoDownloadActivity", 2, "VerticalVideoLayer starttime launchVerticalVideoLayer:" + System.currentTimeMillis());
    }
    if (this.mIsCanceled)
    {
      QLog.w("QzoneVerticalVideoDownloadActivity", 1, "launch has canceled");
      return;
    }
    if (this.mDownloadRoot != null) {
      this.mDownloadRoot.setVisibility(8);
    }
    if (this.mWaitingView != null) {
      this.mWaitingView.setVisibility(0);
    }
    Object localObject = "";
    if (getAppRuntime() != null) {
      localObject = getAppRuntime().getAccount();
    }
    while (TextUtils.isEmpty((CharSequence)localObject))
    {
      QQToast.a(this, anzj.a(2131711308), 0).a();
      LpReportInfo_dc01500.reportLaunch(this.mPluginId, "", (System.currentTimeMillis() - this.mLaunchTime) / 1000.0D, 6, this.mMode + "");
      finish();
      return;
      if (!TextUtils.isEmpty(this.mCurrentUin))
      {
        QLog.w("QzoneVerticalVideoDownloadActivity", 1, "launchVerticalVideoLayer, getAppRuntime is null");
        localObject = this.mCurrentUin;
      }
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("mode", this.mMode);
    localIntent.putExtras(getIntent());
    localIntent.putExtra("launch_time", System.currentTimeMillis());
    QzoneVerticalVideoPluginProxyActivity.a(this, (String)localObject, localIntent, -1);
    finish();
  }
  
  private void parseIntent()
  {
    for (boolean bool = true;; bool = false) {
      try
      {
        Intent localIntent = getIntent();
        if (localIntent == null) {
          return;
        }
        this.mMode = localIntent.getIntExtra("key_mode", 1);
        this.mLaunchTime = localIntent.getLongExtra("key_launch_time", System.currentTimeMillis());
        QZLog.d("plugin_tag", 1, "QVVideoDownloadActivity parseIntent timeDelay:" + (System.currentTimeMillis() - this.mLaunchTime) + "ms");
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
    }
  }
  
  private static void reportTimeCostToBeacon(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    QzoneHandlerThreadFactory.getHandlerThread("Report_HandlerThread").post(new QzoneVerticalVideoDownloadActivity.6(paramString2, paramString3, paramQQAppInterface, paramString1, paramInt));
  }
  
  private static void reportToBeacon(QQAppInterface paramQQAppInterface, String paramString, HashMap paramHashMap)
  {
    QzoneHandlerThreadFactory.getHandlerThread("Report_HandlerThread").post(new QzoneVerticalVideoDownloadActivity.7(paramQQAppInterface, paramString, paramHashMap));
  }
  
  private void updateProgress(int paramInt)
  {
    if (this.mDownloadingBar != null) {
      this.mDownloadingBar.setProgress(paramInt);
    }
  }
  
  private void updateTextProgress(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mBtnAction == null) {
      return;
    }
    if (paramBoolean1)
    {
      this.mBtnAction.setText(anzj.a(2131711309));
      return;
    }
    if (paramBoolean2)
    {
      this.mBtnAction.setText(anzj.a(2131711313));
      return;
    }
    this.progress %= 3;
    switch (this.progress)
    {
    }
    for (;;)
    {
      this.progress += 1;
      return;
      this.mBtnAction.setText(anzj.a(2131711314));
      continue;
      this.mBtnAction.setText(anzj.a(2131711311));
      continue;
      this.mBtnAction.setText(anzj.a(2131711323));
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  protected void handleDownloadPlugin(PluginBaseInfo paramPluginBaseInfo)
  {
    if (this.mIsUIInited.get())
    {
      int i = (int)(paramPluginBaseInfo.mDownloadProgress * 100.0F);
      if (QLog.isColorLevel()) {
        QLog.d("QzoneVerticalVideoDownloadActivity", 2, "handlePluginInfo, STATE_DOWNLOADING, progress=" + i);
      }
      if (i <= 0) {
        break label102;
      }
      this.mHandler.removeMessages(1006);
      this.mHandler.obtainMessage(1004, i, 0).sendToTarget();
      updateTextProgress(false, false);
    }
    for (;;)
    {
      this.mHandler.sendEmptyMessageDelayed(1005, 500L);
      return;
      label102:
      if (this.mIsInstallTimeout)
      {
        this.mHandler.removeMessages(1006);
        updateTextProgress(true, false);
      }
    }
  }
  
  public void initUI(int paramInt)
  {
    QLog.i("QzoneVerticalVideoDownloadActivity", 1, "### initUI reportVideoPlayUpdateExp mSceneType = " + this.mSceneType);
    unx.c(this.mSceneType);
    WSPublicAccReport.getInstance().reportVideoPlayUpdateExp(this.mSceneType);
    this.mWaitingView.setVisibility(8);
    this.mDownloadRoot.setVisibility(0);
    this.mTxtPluginSize = ((TextView)findViewById(2131372809));
    String str = QzoneConfig.getInstance().getConfig("VerticalVideoLayer", "VerticalVideoPluginSizeText", "插件约1M");
    this.mTxtPluginSize.setText(str);
    ((TextView)findViewById(2131380454)).setText(QzoneConfig.getInstance().getConfig("VerticalVideoLayer", "VerticalVideoPluginUpdateTips", "升级插件，体验精彩小视频"));
    this.mDownloadingBar = ((ProgressBar)findViewById(2131365721));
    this.mBtnAction = ((TextView)findViewById(2131363713));
    this.mBtnClose = ((ImageView)findViewById(2131363765));
    this.mLiveVideoImgIv = ((ImageView)findViewById(2131375614));
    try
    {
      str = QzoneConfig.getInstance().getConfig("VerticalVideoLayer", "VerticalDownloadProgressBackgroundUrl", "https://qzonestyle.gtimg.cn/aoi/sola/20180412205352_WOHxRvJEI2.png");
      if (this.mIsFromVideoStory) {
        str = QzoneConfig.getInstance().getConfig("VerticalVideoLayer", "VerticalDownloadProgressBackgroundUrlFromVS", "https://qzonestyle.gtimg.cn/aoi/sola/20190319155945_1kfosfdfO0.png");
      }
      this.mURLDrawable = URLDrawable.getDrawable(str, null);
      if (this.mURLDrawable != null) {
        this.mLiveVideoImgIv.setImageDrawable(this.mURLDrawable);
      }
      this.mURLDrawable.setURLDrawableListener(new bmvt(this));
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.w("QzoneVerticalVideoDownloadActivity", 1, "initUI", localException);
        continue;
        this.mBtnAction.setText(anzj.a(2131711310));
      }
    }
    this.mBtnClose.setOnClickListener(this.cancelInstallListener);
    if (paramInt == 0)
    {
      this.mBtnAction.setText(anzj.a(2131711325));
      this.mBtnAction.setOnClickListener(this.installListener);
      return;
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131562445);
    this.mDownloadRoot = ((FrameLayout)findViewById(2131365730));
    this.mWaitingView = findViewById(2131381259);
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
      PluginManagerHelper.getPluginInterface(this, this);
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        QLog.w("QzoneVerticalVideoDownloadActivity", 1, "", paramBundle);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mHandler.removeMessages(1005);
    this.mHandler.removeMessages(1006);
    if (this.mReceiver != null) {}
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QzoneVerticalVideoDownloadActivity", 1, "unregisterReceiver");
      }
      unregisterReceiver(this.mReceiver);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.w("QzoneVerticalVideoDownloadActivity", 1, "", localException);
      }
    }
    this.mReceiver = null;
    this.manger = null;
    bmst.b(this);
  }
  
  public void onHandleMessage(Handler paramHandler, Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 1001: 
    case 1002: 
    case 1007: 
    case 1008: 
    case 1009: 
    default: 
    case 1000: 
    case 1005: 
    case 1004: 
    case 1003: 
    case 1006: 
    case 1010: 
      do
      {
        do
        {
          return;
          QLog.i("QzoneVerticalVideoDownloadActivity", 1, "MSG_INIT_UI, mIsUIInited=" + this.mIsUIInited);
          if (!this.mIsUIInited.get())
          {
            initUI(paramMessage.arg1);
            this.mIsUIInited.set(true);
          }
          paramHandler.sendEmptyMessage(1005);
          return;
          if (QLog.isDevelopLevel()) {
            QLog.d("QzoneVerticalVideoDownloadActivity", 4, "MSG_QUERY_PLUGIN_STATE");
          }
        } while (isFinishing());
        handlePluginInfo(this.manger.queryPlugin(this.mPluginId));
        return;
        updateProgress(paramMessage.arg1);
        return;
        this.mInstalling = false;
        int i = QzoneConfig.getInstance().getConfig("LiveSetting", "PluginRetryDownloadTimes", 1);
        QLog.w("QzoneVerticalVideoDownloadActivity", 4, "MSG_INSTALL_PLUGIN_ERROR, retryDownloadNum=" + this.retryDownloadNum);
        if (this.retryDownloadNum < i)
        {
          this.retryDownloadNum += 1;
          installPlugin();
          return;
        }
        this.mIsInstallTimeout = true;
        this.mInstalling = false;
        updateTextProgress(true, false);
        return;
        this.mIsInstallTimeout = true;
        this.mInstalling = false;
        return;
      } while (!(paramMessage.obj instanceof String));
      paramHandler.removeMessages(1006);
      paramHandler.removeMessages(1005);
      paramHandler.removeMessages(1004);
      this.mBtnAction.setText((String)paramMessage.obj);
      return;
    case 1011: 
      if (!isFinishing())
      {
        launchVerticalVideoLayer();
        return;
      }
      QLog.d("QzoneVerticalVideoDownloadActivity", 1, "activity is finished");
      return;
    }
    bjuh.a().a(anzj.a(2131711320));
    finish();
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
      QZLog.i("QzoneVerticalVideoDownloadActivity", 1, "[onPluginManagerLoaded] record.mState=" + paramPluginManagerClient.mState);
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
      LpReportInfo_dc01500.reportLaunch(this.mPluginId, "", (System.currentTimeMillis() - this.mLaunchTime) / 1000.0D, 7, this.mMode + "");
      if ((!TextUtils.isEmpty(this.mBackupUrl)) && (nnr.a(this.mBackupUrl)))
      {
        paramPluginManagerClient = this.mBackupUrl + "&stayin=1";
        QLog.d("QzoneVerticalVideoDownloadActivity", 1, "watch mode, jump to H5, " + paramPluginManagerClient);
        bmtd.a(this, paramPluginManagerClient, -1, null, null);
        finish();
        return;
      }
      int i = NetworkState.getNetworkType();
      QLog.d("QzoneVerticalVideoDownloadActivity", 1, "network type = " + i);
      if ((1 == i) || (4 == i) || (5 == i) || (3 == i))
      {
        installPlugin();
        return;
      }
      paramPluginManagerClient = Message.obtain();
      paramPluginManagerClient.what = 1000;
      paramPluginManagerClient.arg1 = 1;
      this.mHandler.sendMessage(paramPluginManagerClient);
      return;
    }
    installPlugin();
    QZLog.e("QzoneVerticalVideoDownloadActivity", 1, new Object[] { "[onPluginManagerLoaded] no PluginManagerClient" });
    bjuh.a().a(anzj.a(2131711315));
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QzoneVerticalVideoDownloadActivity
 * JD-Core Version:    0.7.0.1
 */