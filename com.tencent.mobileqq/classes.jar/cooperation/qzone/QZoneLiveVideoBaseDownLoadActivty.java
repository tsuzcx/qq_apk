package cooperation.qzone;

import Override;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import anvx;
import biwn;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_dc01500;
import cooperation.qzone.video.QzoneLiveVideoPluginProxyActivity;
import cooperation.qzone.video.QzoneVideoBeaconReport;
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
  protected boolean mDownloadingSo;
  private boolean mEnterScreenRecord;
  private String mFeedsType;
  private String mGamePackgeName;
  protected Handler mHandler = new QZoneLiveVideoBaseDownLoadActivty.1(this);
  private long mHostUin;
  protected boolean mInstalling;
  private String mInvited_uin;
  protected volatile boolean mIsCanceled;
  protected boolean mIsDownloadSoTimeout;
  private boolean mIsFromGame;
  protected boolean mIsInstallTimeout;
  private AtomicBoolean mIsUIInited = new AtomicBoolean(false);
  private boolean mIsVertical;
  protected long mLaunchTime;
  private ImageView mLiveVideoImgIv;
  protected int mMode;
  private String mRealFrom;
  protected BroadcastReceiver mReceiver;
  private String mRepostUin;
  private String mRoomId;
  private String mShuoId;
  private boolean mStopLive;
  private TextView mTxtPluginSize;
  private URLDrawable mURLDrawable;
  private String mVideoPlayScene;
  private String mVideoSourceType;
  private View mWaitingView;
  private int progress;
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
    Intent localIntent = getIntent();
    if (localIntent == null)
    {
      QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, "intent is null");
      Toast.makeText(getApplicationContext(), anvx.a(2131711405), 1).show();
      QzoneVideoBeaconReport.reportVideoEvent(this.account, "live_video_entry", "6", null);
      LpReportInfo_dc01500.reportLaunch("qzone_live_video_plugin_hack.apk", "", 0.0D, 3, "0");
      finish();
      return false;
    }
    this.mMode = localIntent.getIntExtra("mode", 0);
    this.mLaunchTime = localIntent.getLongExtra("launch_time", System.currentTimeMillis());
    if ((3 != this.mMode) && (1 != this.mMode))
    {
      QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, "mode invalid, mMode=" + this.mMode);
      Toast.makeText(getApplicationContext(), anvx.a(2131711407) + this.mMode, 1).show();
      QzoneVideoBeaconReport.reportVideoEvent(this.account, "live_video_entry", "6", null);
      LpReportInfo_dc01500.reportLaunch("qzone_live_video_plugin_hack.apk", "", (System.currentTimeMillis() - this.mLaunchTime) / 1000.0D, 3, this.mMode + "");
      finish();
      return false;
    }
    if (!NetworkUtil.isNetworkAvailable(getApplicationContext()))
    {
      QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, "onCreate, no network available");
      QQToast.a(this, anvx.a(2131711411), 0).a();
      if (this.mMode == 1) {
        QzoneVideoBeaconReport.reportVideoEvent(this.account, "live_video_entry", "2", null);
      }
      LpReportInfo_dc01500.reportLaunch("qzone_live_video_plugin_hack.apk", "", (System.currentTimeMillis() - this.mLaunchTime) / 1000.0D, 4, this.mMode + "");
      finish();
      return false;
    }
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime != null) && (((QQAppInterface)localAppRuntime).isVideoChatting()))
    {
      QQToast.a(this, anvx.a(2131711415), 0).a();
      if (this.mMode == 1) {
        QzoneVideoBeaconReport.reportVideoEvent(this.account, "live_video_entry", "7", null);
      }
      LpReportInfo_dc01500.reportLaunch("qzone_live_video_plugin_hack.apk", "", (System.currentTimeMillis() - this.mLaunchTime) / 1000.0D, 2, this.mMode + ",1");
      finish();
      return false;
    }
    this.mBackupUrl = localIntent.getStringExtra("backup");
    this.mRoomId = localIntent.getStringExtra("room_id");
    this.mCurrentUin = localIntent.getStringExtra("current_uin");
    QLog.d("QZoneLiveVideoBaseDownLoadActivty", 1, "mRoomId=" + this.mRoomId + ", mBackUrl=" + this.mBackupUrl + ", mCurrentUin=" + this.mCurrentUin);
    this.mHostUin = localIntent.getLongExtra("host_uin", 0L);
    this.mVideoSourceType = localIntent.getStringExtra("video_play_source");
    this.mFeedsType = localIntent.getStringExtra("feeds_type");
    this.mShuoId = localIntent.getStringExtra("shuo_id");
    this.mRepostUin = localIntent.getStringExtra("repost_uin");
    this.mVideoPlayScene = localIntent.getStringExtra("video_play_scene");
    this.entranceReferId = localIntent.getStringExtra("entranceReferId");
    this.mRealFrom = localIntent.getStringExtra("realFrom");
    this.mStopLive = localIntent.getBooleanExtra("stopLive", false);
    this.mEnterScreenRecord = localIntent.getBooleanExtra("enterScreenRecord", false);
    this.mIsFromGame = localIntent.getBooleanExtra("isFromGame", false);
    this.mIsVertical = localIntent.getBooleanExtra("isVertical", true);
    this.mGamePackgeName = localIntent.getStringExtra("gamePackgeName");
    this.mInvited_uin = localIntent.getStringExtra("invitefriend_opuin");
    return true;
  }
  
  protected void cancelInstall()
  {
    this.mInstalling = false;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
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
      if (QLog.isColorLevel()) {
        QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, "handlePluginInfo, STATE_DOWNLOADING, progress=" + i);
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
  
  public void handlePluginInfo(String paramString, PluginBaseInfo paramPluginBaseInfo)
  {
    if (!validate(paramPluginBaseInfo)) {
      return;
    }
    switch (paramPluginBaseInfo.mState)
    {
    case -1: 
    default: 
      QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, "handlePluginInfo, STATE=" + paramPluginBaseInfo.mState);
      return;
    case 0: 
      QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, "handlePluginInfo, STATE_NODOWNLOAD");
    case 1: 
      QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, "handlePluginInfo, STATE_DOWNLOADING");
    case 2: 
      handleDownloadPlugin(paramPluginBaseInfo);
      return;
    case 3: 
    case 5: 
      QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, "handlePluginInfo, state=" + paramPluginBaseInfo.mState);
      this.mHandler.sendEmptyMessageDelayed(1005, 500L);
      return;
    case 4: 
      QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, "handlePluginInfo, STATE_INSTALLED");
      launchLiveVideo();
      return;
    }
    QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, "handlePluginInfo, STATE_ERROR");
    this.mHandler.sendEmptyMessage(1003);
  }
  
  public void initUI(int paramInt)
  {
    this.mWaitingView.setVisibility(8);
    this.mDownloadRoot.setVisibility(0);
    this.mTxtPluginSize = ((TextView)findViewById(2131372970));
    this.mDownloadingBar = ((ProgressBar)findViewById(2131365849));
    this.mBtnAction = ((TextView)findViewById(2131363813));
    this.mBtnClose = ((ImageView)findViewById(2131363866));
    this.mLiveVideoImgIv = ((ImageView)findViewById(2131375624));
    Boolean localBoolean = Boolean.valueOf(false);
    if (getIntent() != null) {
      localBoolean = Boolean.valueOf(getIntent().getBooleanExtra("isEcLive", false));
    }
    if (localBoolean.booleanValue())
    {
      this.mLiveVideoImgIv.setVisibility(8);
      this.mBtnClose.setOnClickListener(this.cancelInstallListener);
      if (paramInt != 0) {
        break label239;
      }
      this.mBtnAction.setText(anvx.a(2131711402));
    }
    for (;;)
    {
      for (;;)
      {
        this.mBtnAction.setOnClickListener(this.installListener);
        return;
        this.mLiveVideoImgIv.setVisibility(0);
        try
        {
          this.mURLDrawable = URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_live_video_download_bg.png", null);
          if (this.mURLDrawable == null) {
            break;
          }
          this.mLiveVideoImgIv.setImageDrawable(this.mURLDrawable);
          this.mURLDrawable.setURLDrawableListener(new QZoneLiveVideoBaseDownLoadActivty.2(this));
        }
        catch (Exception localException)
        {
          QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, "initUI", localException);
        }
      }
      break;
      label239:
      this.mBtnAction.setText(anvx.a(2131711409));
    }
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
    if (this.mDownloadRoot != null) {
      this.mDownloadRoot.setVisibility(8);
    }
    if (this.mWaitingView != null) {
      this.mWaitingView.setVisibility(0);
    }
    String str1 = "";
    if (getAppRuntime() != null) {
      str1 = getAppRuntime().getAccount();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, "launchLiveVideo, account=" + str1);
      }
      if (!TextUtils.isEmpty(str1)) {
        break;
      }
      QQToast.a(this, anvx.a(2131711395), 0).a();
      LpReportInfo_dc01500.reportLaunch("qzone_live_video_plugin_hack.apk", "", (System.currentTimeMillis() - this.mLaunchTime) / 1000.0D, 6, this.mMode + "");
      doFinish();
      return;
      if (!TextUtils.isEmpty(this.mCurrentUin))
      {
        QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, "launchLiveVideo, getAppRuntime is null");
        str1 = this.mCurrentUin;
      }
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
    String str3 = "com.qzone.adapter.livevideo.QZoneLiveVideoActivity";
    String str2 = str3;
    if (getIntent() != null)
    {
      Boolean localBoolean = Boolean.valueOf(getIntent().getBooleanExtra("isEcLive", false));
      localIntent.putExtra("isEcLive", localBoolean);
      str2 = str3;
      if (localBoolean.booleanValue())
      {
        if (!versionEnable()) {
          break label704;
        }
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
      }
    }
    for (str2 = "com.qzone.adapter.livevideo.ECLiveVideoActivity";; str2 = str3)
    {
      QzoneLiveVideoPluginProxyActivity.launchPluginActivityForResult(this, str1, localIntent, -1, str2);
      biwn.a(BaseApplicationImpl.getContext(), false, 5);
      return;
      label704:
      QQToast.a(this, anvx.a(2131711393), 0).a();
      doFinish();
    }
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
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (this.mSystemBarComp != null) {
      this.mSystemBarComp.mDrawStatus = false;
    }
    setContentView(2131562389);
    this.mDownloadRoot = ((ViewGroup)findViewById(2131365860));
    this.mWaitingView = findViewById(2131381329);
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
        QLog.d("QZoneLiveVideoBaseDownLoadActivty", 1, "unregisterReceiver");
      }
      unregisterReceiver(this.mReceiver);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, "", localException);
      }
    }
    this.mReceiver = null;
  }
  
  protected void onHandleMessage(Handler paramHandler, Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, "MSG_INIT_UI, mIsUIInited=" + this.mIsUIInited);
        }
        if (!this.mIsUIInited.get())
        {
          initUI(paramMessage.arg1);
          this.mIsUIInited.set(true);
        }
        paramHandler.sendEmptyMessage(1005);
        return;
        QLog.d("QZoneLiveVideoBaseDownLoadActivty", 2, "MSG_QUERY_PLUGIN_STATE");
      } while (isFinishing());
      paramHandler = queryPlugin(getPluginid());
      handlePluginInfo(getPluginid(), paramHandler);
      return;
      updateProgress(paramMessage.arg1);
      return;
      this.mInstalling = false;
      int i = QzoneConfig.getInstance().getConfig("LiveSetting", "PluginRetryDownloadTimes", 1);
      QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, "MSG_INSTALL_PLUGIN_ERROR, retryDownloadNum=" + this.retryDownloadNum);
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
      this.mDownloadingSo = false;
      i = QzoneConfig.getInstance().getConfig("LiveSetting", "PluginRetryDownloadSoTimes", 1);
      QLog.w("QZoneLiveVideoBaseDownLoadActivty", 1, "MSG_DOWNLOAD_SO_ERROR, retryDownloadSoNum=" + i);
      if (this.retryDownloadSoNum < i)
      {
        this.retryDownloadSoNum += 1;
        downloadLivePluginSo();
        return;
      }
      this.mIsDownloadSoTimeout = true;
      this.mDownloadingSo = false;
      updateTextProgress(true, true);
      return;
      this.mIsDownloadSoTimeout = true;
      this.mDownloadingSo = false;
      return;
    } while (!(paramMessage.obj instanceof String));
    paramHandler.removeMessages(1006);
    paramHandler.removeMessages(1005);
    paramHandler.removeMessages(1004);
    this.mBtnAction.setText((String)paramMessage.obj);
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
    if (this.mDownloadingBar != null) {
      this.mDownloadingBar.setProgress(paramInt);
    }
  }
  
  public void updateTextProgress(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mBtnAction == null) {
      return;
    }
    if (paramBoolean1)
    {
      this.mBtnAction.setText(anvx.a(2131711401));
      return;
    }
    if (paramBoolean2)
    {
      this.mBtnAction.setText(anvx.a(2131711412));
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
      this.mBtnAction.setText(anvx.a(2131711394));
      continue;
      this.mBtnAction.setText(anvx.a(2131711403));
      continue;
      this.mBtnAction.setText(anvx.a(2131711406));
    }
  }
  
  protected boolean validate(PluginBaseInfo paramPluginBaseInfo)
  {
    return paramPluginBaseInfo != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QZoneLiveVideoBaseDownLoadActivty
 * JD-Core Version:    0.7.0.1
 */