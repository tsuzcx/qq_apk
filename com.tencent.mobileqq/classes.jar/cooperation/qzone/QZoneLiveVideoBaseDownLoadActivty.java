package cooperation.qzone;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_dc01500;
import cooperation.qzone.video.QzoneLiveVideoPluginProxyActivity;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public abstract class QZoneLiveVideoBaseDownLoadActivty
  extends BaseActivity
{
  public static final int ARG_AUTO_DOWNLOAD = 0;
  public static final int ARG_MANUL_DOWNLOAD = 1;
  public static final int LAUNCH_LIVE_VIDEO = 1;
  public static final int MSG_DOWNLOAD_PLUGIN_ERROR = 1010;
  public static final int MSG_DOWNLOAD_PLUGIN_PROGRESS = 1004;
  public static final int MSG_DOWNLOAD_SO_ERROR = 1008;
  public static final int MSG_DOWNLOAD_SO_START = 1007;
  public static final int MSG_DOWNLOAD_SO_TIMEOUT = 1009;
  public static final int MSG_INIT_UI = 1000;
  public static final int MSG_INSTALL_PLUGIN_ERROR = 1003;
  public static final int MSG_INSTALL_PLUGIN_TIMEOUT = 1006;
  public static final int MSG_QUERY_PLUGIN_STATE = 1005;
  protected static final int PERIOD_QUERY = 500;
  public static final String TAG = "QZoneLiveVideoBaseDownLoadActivty";
  public static final int WATCH_LIVE_VIDEO = 3;
  protected String account;
  private View.OnClickListener cancelInstallListener = new QZoneLiveVideoBaseDownLoadActivty.4(this);
  private String entranceReferId;
  private View.OnClickListener installListener = new QZoneLiveVideoBaseDownLoadActivty.3(this);
  protected String mBackupUrl;
  private TextView mBtnAction;
  private ImageView mBtnClose;
  private String mCurrentUin;
  private ViewGroup mDownloadRoot;
  private ProgressBar mDownloadingBar;
  protected boolean mDownloadingSo = false;
  private boolean mEnterScreenRecord = false;
  private String mFeedsType;
  private String mGamePackgeName;
  protected Handler mHandler = new QZoneLiveVideoBaseDownLoadActivty.1(this);
  private long mHostUin;
  protected boolean mInstalling = false;
  private String mInvited_uin;
  protected volatile boolean mIsCanceled = false;
  protected boolean mIsDownloadSoTimeout = false;
  private boolean mIsFromGame;
  protected boolean mIsInstallTimeout = false;
  private AtomicBoolean mIsUIInited = new AtomicBoolean(false);
  private boolean mIsVertical;
  protected long mLaunchTime;
  private ImageView mLiveVideoImgIv;
  protected int mMode;
  private String mRealFrom;
  protected BroadcastReceiver mReceiver = null;
  private String mRepostUin;
  private String mRoomId;
  private String mShuoId;
  private boolean mStopLive = false;
  private TextView mTxtPluginSize;
  private URLDrawable mURLDrawable;
  private String mVideoPlayScene;
  private String mVideoSourceType;
  private View mWaitingView;
  private int progress = 0;
  protected int retryDownloadNum;
  protected int retryDownloadSoNum;
  
  private boolean versionEnable()
  {
    return Build.VERSION.SDK_INT > 20;
  }
  
  public boolean canEnterLiveVideo()
  {
    if (getAppRuntime() != null) {
      this.account = getAppRuntime().getAccount();
    }
    Object localObject1 = getIntent();
    if (localObject1 == null)
    {
      QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, "intent is null");
      Toast.makeText(getApplicationContext(), HardCodeUtil.a(2131711895), 1).show();
      QzoneVideoBeaconReport.reportVideoEvent(this.account, "live_video_entry", "6", null);
      LpReportInfo_dc01500.reportLaunch("qzone_live_video_plugin_hack.apk", "", 0.0D, 3, "0");
      finish();
      return false;
    }
    this.mMode = ((Intent)localObject1).getIntExtra("mode", 0);
    this.mLaunchTime = ((Intent)localObject1).getLongExtra("launch_time", System.currentTimeMillis());
    int i = this.mMode;
    double d;
    if ((3 != i) && (1 != i))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("mode invalid, mMode=");
      ((StringBuilder)localObject1).append(this.mMode);
      QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, ((StringBuilder)localObject1).toString());
      localObject1 = getApplicationContext();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131711897));
      ((StringBuilder)localObject2).append(this.mMode);
      Toast.makeText((Context)localObject1, ((StringBuilder)localObject2).toString(), 1).show();
      QzoneVideoBeaconReport.reportVideoEvent(this.account, "live_video_entry", "6", null);
      d = System.currentTimeMillis() - this.mLaunchTime;
      Double.isNaN(d);
      d /= 1000.0D;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.mMode);
      ((StringBuilder)localObject1).append("");
      LpReportInfo_dc01500.reportLaunch("qzone_live_video_plugin_hack.apk", "", d, 3, ((StringBuilder)localObject1).toString());
      finish();
      return false;
    }
    if (!NetworkUtil.isNetworkAvailable(getApplicationContext()))
    {
      QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, "onCreate, no network available");
      QQToast.a(this, HardCodeUtil.a(2131711901), 0).a();
      if (this.mMode == 1) {
        QzoneVideoBeaconReport.reportVideoEvent(this.account, "live_video_entry", "2", null);
      }
      d = System.currentTimeMillis() - this.mLaunchTime;
      Double.isNaN(d);
      d /= 1000.0D;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.mMode);
      ((StringBuilder)localObject1).append("");
      LpReportInfo_dc01500.reportLaunch("qzone_live_video_plugin_hack.apk", "", d, 4, ((StringBuilder)localObject1).toString());
      finish();
      return false;
    }
    Object localObject2 = getAppRuntime();
    if ((localObject2 != null) && (((QQAppInterface)localObject2).isVideoChatting()))
    {
      QQToast.a(this, HardCodeUtil.a(2131711905), 0).a();
      if (this.mMode == 1) {
        QzoneVideoBeaconReport.reportVideoEvent(this.account, "live_video_entry", "7", null);
      }
      d = System.currentTimeMillis() - this.mLaunchTime;
      Double.isNaN(d);
      d /= 1000.0D;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.mMode);
      ((StringBuilder)localObject1).append(",1");
      LpReportInfo_dc01500.reportLaunch("qzone_live_video_plugin_hack.apk", "", d, 2, ((StringBuilder)localObject1).toString());
      finish();
      return false;
    }
    this.mBackupUrl = ((Intent)localObject1).getStringExtra("backup");
    this.mRoomId = ((Intent)localObject1).getStringExtra("room_id");
    this.mCurrentUin = ((Intent)localObject1).getStringExtra("current_uin");
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("mRoomId=");
    ((StringBuilder)localObject2).append(this.mRoomId);
    ((StringBuilder)localObject2).append(", mBackUrl=");
    ((StringBuilder)localObject2).append(this.mBackupUrl);
    ((StringBuilder)localObject2).append(", mCurrentUin=");
    ((StringBuilder)localObject2).append(this.mCurrentUin);
    QLog.d("QZoneLiveVideoBaseDownLoadActivty", 1, ((StringBuilder)localObject2).toString());
    this.mHostUin = ((Intent)localObject1).getLongExtra("host_uin", 0L);
    this.mVideoSourceType = ((Intent)localObject1).getStringExtra("video_play_source");
    this.mFeedsType = ((Intent)localObject1).getStringExtra("feeds_type");
    this.mShuoId = ((Intent)localObject1).getStringExtra("shuo_id");
    this.mRepostUin = ((Intent)localObject1).getStringExtra("repost_uin");
    this.mVideoPlayScene = ((Intent)localObject1).getStringExtra("video_play_scene");
    this.entranceReferId = ((Intent)localObject1).getStringExtra("entranceReferId");
    this.mRealFrom = ((Intent)localObject1).getStringExtra("realFrom");
    this.mStopLive = ((Intent)localObject1).getBooleanExtra("stopLive", false);
    this.mEnterScreenRecord = ((Intent)localObject1).getBooleanExtra("enterScreenRecord", false);
    this.mIsFromGame = ((Intent)localObject1).getBooleanExtra("isFromGame", false);
    this.mIsVertical = ((Intent)localObject1).getBooleanExtra("isVertical", true);
    this.mGamePackgeName = ((Intent)localObject1).getStringExtra("gamePackgeName");
    this.mInvited_uin = ((Intent)localObject1).getStringExtra("invitefriend_opuin");
    return true;
  }
  
  protected void cancelInstall()
  {
    this.mInstalling = false;
  }
  
  protected void doFinish()
  {
    finish();
  }
  
  protected void downloadLivePluginSo() {}
  
  protected abstract String getPluginid();
  
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
        QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, paramPluginBaseInfo.toString());
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
  
  public void handlePluginInfo(String paramString, PluginBaseInfo paramPluginBaseInfo)
  {
    if (!validate(paramPluginBaseInfo)) {
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
            break label167;
          }
          if (i != 3) {
            if (i != 4)
            {
              if (i != 5)
              {
                paramString = new StringBuilder();
                paramString.append("handlePluginInfo, STATE=");
                paramString.append(paramPluginBaseInfo.mState);
                QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, paramString.toString());
              }
            }
            else
            {
              QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, "handlePluginInfo, STATE_INSTALLED");
              launchLiveVideo();
              return;
            }
          }
          paramString = new StringBuilder();
          paramString.append("handlePluginInfo, state=");
          paramString.append(paramPluginBaseInfo.mState);
          QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, paramString.toString());
          this.mHandler.sendEmptyMessageDelayed(1005, 500L);
        }
      }
      else {
        QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, "handlePluginInfo, STATE_NODOWNLOAD");
      }
      QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, "handlePluginInfo, STATE_DOWNLOADING");
      label167:
      handleDownloadPlugin(paramPluginBaseInfo);
      return;
    }
    QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, "handlePluginInfo, STATE_ERROR");
    this.mHandler.sendEmptyMessage(1003);
  }
  
  public void initUI(int paramInt)
  {
    this.mWaitingView.setVisibility(8);
    this.mDownloadRoot.setVisibility(0);
    this.mTxtPluginSize = ((TextView)findViewById(2131372876));
    this.mDownloadingBar = ((ProgressBar)findViewById(2131365848));
    this.mBtnAction = ((TextView)findViewById(2131363840));
    this.mBtnClose = ((ImageView)findViewById(2131363890));
    this.mLiveVideoImgIv = ((ImageView)findViewById(2131375517));
    Boolean localBoolean = Boolean.valueOf(false);
    if (getIntent() != null) {
      localBoolean = Boolean.valueOf(getIntent().getBooleanExtra("isEcLive", false));
    }
    if (localBoolean.booleanValue())
    {
      this.mLiveVideoImgIv.setVisibility(8);
    }
    else
    {
      this.mLiveVideoImgIv.setVisibility(0);
      try
      {
        this.mURLDrawable = URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_live_video_download_bg.png", null);
        if (this.mURLDrawable != null)
        {
          this.mLiveVideoImgIv.setImageDrawable(this.mURLDrawable);
          this.mURLDrawable.setURLDrawableListener(new QZoneLiveVideoBaseDownLoadActivty.2(this));
        }
      }
      catch (Exception localException)
      {
        QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, "initUI", localException);
      }
    }
    this.mBtnClose.setOnClickListener(this.cancelInstallListener);
    if (paramInt == 0) {
      this.mBtnAction.setText(HardCodeUtil.a(2131711892));
    } else {
      this.mBtnAction.setText(HardCodeUtil.a(2131711899));
    }
    this.mBtnAction.setOnClickListener(this.installListener);
  }
  
  protected void installPlugin()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, "installPlugin");
    }
    this.mIsInstallTimeout = false;
    this.mInstalling = true;
    Message localMessage = Message.obtain();
    localMessage.what = 1000;
    localMessage.arg1 = 0;
    this.mHandler.sendMessage(localMessage);
    int i = QzoneConfig.getInstance().getConfig("LiveSetting", "PluginInstallTimeout", 60000);
    this.mHandler.sendEmptyMessageDelayed(1006, i);
  }
  
  protected abstract void installPluginSilence();
  
  protected void launchLiveVideo()
  {
    if (this.mIsCanceled)
    {
      QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, "launch has canceled");
      return;
    }
    Object localObject1 = this.mDownloadRoot;
    if (localObject1 != null) {
      ((ViewGroup)localObject1).setVisibility(8);
    }
    localObject1 = this.mWaitingView;
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(0);
    }
    if (getAppRuntime() != null)
    {
      localObject1 = getAppRuntime().getAccount();
    }
    else if (!TextUtils.isEmpty(this.mCurrentUin))
    {
      QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, "launchLiveVideo, getAppRuntime is null");
      localObject1 = this.mCurrentUin;
    }
    else
    {
      localObject1 = "";
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("launchLiveVideo, account=");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, ((StringBuilder)localObject2).toString());
    }
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      QQToast.a(this, HardCodeUtil.a(2131711885), 0).a();
      double d = System.currentTimeMillis() - this.mLaunchTime;
      Double.isNaN(d);
      d /= 1000.0D;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.mMode);
      ((StringBuilder)localObject1).append("");
      LpReportInfo_dc01500.reportLaunch("qzone_live_video_plugin_hack.apk", "", d, 6, ((StringBuilder)localObject1).toString());
      doFinish();
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("room_id", this.mRoomId);
    localIntent.putExtra("mode", this.mMode);
    localIntent.putExtra("video_play_source", this.mVideoSourceType);
    localIntent.putExtra("feeds_type", this.mFeedsType);
    localIntent.putExtra("shuo_id", this.mShuoId);
    localIntent.putExtra("repost_uin", this.mRepostUin);
    localIntent.putExtra("video_play_scene", this.mVideoPlayScene);
    localIntent.putExtra("entranceReferId", this.entranceReferId);
    localIntent.putExtra("launch_time", this.mLaunchTime);
    localIntent.putExtra("realFrom", this.mRealFrom);
    localIntent.putExtra("stopLive", this.mStopLive);
    localIntent.putExtra("enterScreenRecord", this.mEnterScreenRecord);
    localIntent.putExtra("isFromGame", this.mIsFromGame);
    localIntent.putExtra("isVertical", this.mIsVertical);
    localIntent.putExtra("gamePackgeName", this.mGamePackgeName);
    localIntent.putExtra("invitefriend_opuin", this.mInvited_uin);
    if (getIntent() != null)
    {
      localObject2 = Boolean.valueOf(getIntent().getBooleanExtra("isEcLive", false));
      localIntent.putExtra("isEcLive", (Serializable)localObject2);
      if (((Boolean)localObject2).booleanValue())
      {
        if (versionEnable())
        {
          localIntent.putExtra("ec_uin", getIntent().getStringExtra("ec_uin"));
          localIntent.putExtra("ec_room_type", getIntent().getIntExtra("ec_room_type", 0));
          localIntent.putExtra("ec_room_id", getIntent().getStringExtra("ec_room_id"));
          localIntent.putExtra("ec_room_owner_id", getIntent().getStringExtra("ec_room_owner_id"));
          localIntent.putExtra("ec_room_from_type", getIntent().getIntExtra("ec_room_from_type", 0));
          localIntent.putExtra("ec_room_part_flags", getIntent().getIntExtra("ec_room_part_flags", 0));
          localIntent.putExtra("ec_room_create_name", getIntent().getStringExtra("ec_room_create_name"));
          localIntent.putExtra("ec_room_init_type", getIntent().getIntExtra("ec_room_init_type", 1));
          localIntent.putExtra("ec_room_is_owner", getIntent().getBooleanExtra("ec_room_is_owner", false));
          localIntent.putExtra("ec_title", getIntent().getStringExtra("ec_title"));
          localIntent.putExtra("ec_content", getIntent().getStringExtra("ec_content"));
          localObject2 = "com.qzone.adapter.livevideo.ECLiveVideoActivity";
          break label732;
        }
        QQToast.a(this, HardCodeUtil.a(2131711883), 0).a();
        doFinish();
      }
    }
    Object localObject2 = "com.qzone.adapter.livevideo.QZoneLiveVideoActivity";
    label732:
    QzoneLiveVideoPluginProxyActivity.launchPluginActivityForResult(this, (String)localObject1, localIntent, -1, (String)localObject2);
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), false, 5);
  }
  
  public void launchLiveVideoWhetherDownloadSo()
  {
    if (this.mMode == 1)
    {
      downloadLivePluginSo();
      return;
    }
    launchLiveVideo();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (this.mSystemBarComp != null) {
      this.mSystemBarComp.mDrawStatus = false;
    }
    setContentView(2131562363);
    this.mDownloadRoot = ((ViewGroup)findViewById(2131365857));
    this.mWaitingView = findViewById(2131381014);
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
          QLog.d("QZoneLiveVideoBaseDownLoadActivty", 1, "unregisterReceiver");
        }
        unregisterReceiver(this.mReceiver);
      }
      catch (Exception localException)
      {
        QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, "", localException);
      }
      this.mReceiver = null;
    }
  }
  
  protected void onHandleMessage(Handler paramHandler, Message paramMessage)
  {
    int i;
    int j;
    switch (paramMessage.what)
    {
    case 1001: 
    case 1002: 
    case 1007: 
    default: 
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
    case 1009: 
      this.mIsDownloadSoTimeout = true;
      this.mDownloadingSo = false;
      return;
    case 1008: 
      this.mDownloadingSo = false;
      i = QzoneConfig.getInstance().getConfig("LiveSetting", "PluginRetryDownloadSoTimes", 1);
      paramHandler = new StringBuilder();
      paramHandler.append("MSG_DOWNLOAD_SO_ERROR, retryDownloadSoNum=");
      paramHandler.append(i);
      QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, paramHandler.toString());
      j = this.retryDownloadSoNum;
      if (j < i)
      {
        this.retryDownloadSoNum = (j + 1);
        downloadLivePluginSo();
        return;
      }
      this.mIsDownloadSoTimeout = true;
      this.mDownloadingSo = false;
      updateTextProgress(true, true);
      return;
    case 1006: 
      this.mIsInstallTimeout = true;
      this.mInstalling = false;
      return;
    case 1005: 
      QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, "MSG_QUERY_PLUGIN_STATE");
      if (!isFinishing())
      {
        paramHandler = queryPlugin(getPluginid());
        handlePluginInfo(getPluginid(), paramHandler);
        return;
      }
      break;
    case 1004: 
      updateProgress(paramMessage.arg1);
      return;
    case 1003: 
      this.mInstalling = false;
      i = QzoneConfig.getInstance().getConfig("LiveSetting", "PluginRetryDownloadTimes", 1);
      paramHandler = new StringBuilder();
      paramHandler.append("MSG_INSTALL_PLUGIN_ERROR, retryDownloadNum=");
      paramHandler.append(this.retryDownloadNum);
      QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, paramHandler.toString());
      j = this.retryDownloadNum;
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("MSG_INIT_UI, mIsUIInited=");
        localStringBuilder.append(this.mIsUIInited);
        QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, localStringBuilder.toString());
      }
      if (!this.mIsUIInited.get())
      {
        initUI(paramMessage.arg1);
        this.mIsUIInited.set(true);
      }
      paramHandler.sendEmptyMessage(1005);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (4 == paramInt) {
      this.mIsCanceled = true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected abstract PluginBaseInfo queryPlugin(String paramString);
  
  protected void updateProgress(int paramInt)
  {
    ProgressBar localProgressBar = this.mDownloadingBar;
    if (localProgressBar != null) {
      localProgressBar.setProgress(paramInt);
    }
  }
  
  public void updateTextProgress(boolean paramBoolean1, boolean paramBoolean2)
  {
    TextView localTextView = this.mBtnAction;
    if (localTextView == null) {
      return;
    }
    if (paramBoolean1)
    {
      localTextView.setText(HardCodeUtil.a(2131711891));
      return;
    }
    if (paramBoolean2)
    {
      localTextView.setText(HardCodeUtil.a(2131711902));
      return;
    }
    this.progress %= 3;
    int i = this.progress;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2) {
          localTextView.setText(HardCodeUtil.a(2131711896));
        }
      }
      else {
        localTextView.setText(HardCodeUtil.a(2131711893));
      }
    }
    else {
      localTextView.setText(HardCodeUtil.a(2131711884));
    }
    this.progress += 1;
  }
  
  protected boolean validate(PluginBaseInfo paramPluginBaseInfo)
  {
    return paramPluginBaseInfo != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.QZoneLiveVideoBaseDownLoadActivty
 * JD-Core Version:    0.7.0.1
 */