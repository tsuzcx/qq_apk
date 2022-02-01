package cooperation.qzone;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.biz.qqstory.takevideo.EditLocalGifSource;
import com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.shortvideo.PreviewVideoActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.shortvideo.ShortVideoErrorReport;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.INet_ShortVideoResource;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceStatus.ISVConfig;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import dov.com.qq.im.ae.download.AEResInfo;
import dov.com.qq.im.ae.download.AEResManager;
import dov.com.qq.im.ae.download.AEResManager.AEDownloadCallBack;
import dov.com.qq.im.ae.download.AEResUtil;
import dov.com.qq.im.ae.entry.AECameraLauncher;
import dov.com.qq.im.ae.entry.AELaunchParamsBuilder;
import dov.com.qq.im.ae.util.PicChooseJumpUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public class QZoneVideoDownloadActivity
  extends IphoneTitleBarActivity
  implements ShortVideoResourceManager.INet_ShortVideoResource, ShortVideoResourceStatus.ISVConfig, AEResManager.AEDownloadCallBack
{
  private static final String EXTRA_FROM_TAKE_PHOTO_USING_QQ_CAMERA = "extra_from_take_photo_using_qq_camera";
  public static final String KEY_SUPPORTPIC = "support_pic";
  public static final String KEY_SUPPORT_DYNAMIC_VIDEO = "support_dynamic_video";
  public static final int MSG_DOWNLOAD_PLUGIN_PROGRESS = 1004;
  public static final int MSG_DOWNLOAD_SO_ERROR = 1002;
  public static final int MSG_DOWNLOAD_SO_PROGRESS = 1001;
  public static final int MSG_INIT_UI = 1000;
  public static final int MSG_INSTALL_PLUGIN_ERROR = 1003;
  public static final String TAG = "QZoneVideoDownloadActivity";
  public static final String VideoIntroduceImageUrl = "https://qzs.qq.com/qzone/photo/v7/js/common/images/mini_video_cover_7.png";
  private long aekitCurOffset = 0L;
  private long aekitTotalLen = 0L;
  private long avCodecCurOffset = 0L;
  private long avCodecTotalLen = 0L;
  private String className;
  private String confirmText;
  private int doQZoneAlbumShortcut = 0;
  private String donaXiaoCallback;
  private String dongXiaoId;
  private HashMap<Integer, String> downloadError;
  private boolean enableEditButton;
  private boolean enableInputText;
  private boolean enableLocalButton;
  private boolean enableOriginVideo;
  private boolean enablePrivList;
  private boolean enableQzoneSync;
  private long endTime;
  private boolean enterPtu;
  private int entrySource;
  public int filerType;
  private String gifPath;
  private boolean isAEBaseSoDownloadOk = true;
  private boolean isAVCodecDownloadOk = true;
  private boolean isArtSoDownloadOk = true;
  public boolean isEditVideo = false;
  private boolean isGlanceVideo;
  private boolean isGoPublish = false;
  private boolean isLightBaseSoDownloadOk = true;
  private boolean isPreviewVideo;
  public boolean isQzoneVip;
  public boolean isSupportDynamicVideo;
  public boolean isSupportEditVideo;
  public boolean isSupportJumpToGifChooser;
  public boolean isSupportPic;
  public boolean isSupportRecord;
  public boolean isSupportTrim;
  private boolean isTrackingDownloadOk = true;
  private long lightSDKCurOffset = 0L;
  private long lightSDKTotalLen = 0L;
  public ProgressBar mDownloadingBar;
  public URLImageView mDownloadingImage;
  public TextView mDownloadingText;
  Handler mHandler = new QZoneVideoDownloadActivity.1(this);
  private AtomicBoolean mIsUIInited = new AtomicBoolean(false);
  private int mPhotoPlusPos;
  public PluginManagerClient mPluginManager;
  private Bundle mVideoExtras;
  private LocalMediaInfo mediaInfo;
  private long startTime;
  private String topicId;
  public String uin;
  public String videoPath;
  private String videoRefer;
  public long videoSize;
  private int videoType;
  
  private boolean checkIsOK()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("checkIsOK()=");
    if ((this.isAVCodecDownloadOk) && (this.isAEBaseSoDownloadOk) && (this.isLightBaseSoDownloadOk) && (this.isArtSoDownloadOk) && (this.isTrackingDownloadOk)) {}
    for (boolean bool = true;; bool = false)
    {
      VideoEnvironment.LogDownLoad("QZoneVideoDownloadActivity", bool, null);
      if ((!this.isAVCodecDownloadOk) || (!this.isAEBaseSoDownloadOk) || (!this.isLightBaseSoDownloadOk) || (!this.isArtSoDownloadOk) || (!this.isTrackingDownloadOk)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  private void entrySourceReport()
  {
    switch (this.entrySource)
    {
    }
    do
    {
      do
      {
        return;
        LpReportInfo_pf00064.allReport(612, 1, 1);
      } while (!QLog.isColorLevel());
      QLog.i("QZoneVideoDownloadActivity", 2, "entry source plus report");
      return;
      LpReportInfo_pf00064.allReport(612, 1, 2);
    } while (!QLog.isColorLevel());
    QLog.i("QZoneVideoDownloadActivity", 2, "entry source quick left slide report");
  }
  
  private String getDownloadErrorConfig(int paramInt)
  {
    Object localObject;
    if (this.downloadError == null) {
      localObject = String.valueOf(paramInt);
    }
    String str;
    do
    {
      return localObject;
      str = (String)this.downloadError.get(Integer.valueOf(paramInt));
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    return String.valueOf(paramInt);
  }
  
  private void initDownloadErrorConfig()
  {
    if (this.downloadError == null) {
      this.downloadError = new HashMap();
    }
    this.downloadError.put(Integer.valueOf(-1), HardCodeUtil.a(2131712541));
    this.downloadError.put(Integer.valueOf(-2), HardCodeUtil.a(2131712448));
    this.downloadError.put(Integer.valueOf(-2), HardCodeUtil.a(2131712514));
    this.downloadError.put(Integer.valueOf(-3), HardCodeUtil.a(2131712564));
    this.downloadError.put(Integer.valueOf(-4), HardCodeUtil.a(2131712530));
    this.downloadError.put(Integer.valueOf(-100), HardCodeUtil.a(2131712535));
    this.downloadError.put(Integer.valueOf(-101), HardCodeUtil.a(2131712509));
    this.downloadError.put(Integer.valueOf(-105), HardCodeUtil.a(2131712543));
    this.downloadError.put(Integer.valueOf(-106), "MD5为空错误");
    this.downloadError.put(Integer.valueOf(-107), HardCodeUtil.a(2131712556));
    this.downloadError.put(Integer.valueOf(-108), "MD5校验错误");
    this.downloadError.put(Integer.valueOf(-117), HardCodeUtil.a(2131712458));
    this.downloadError.put(Integer.valueOf(-118), HardCodeUtil.a(2131712434));
    this.downloadError.put(Integer.valueOf(-125), HardCodeUtil.a(2131712538));
    this.downloadError.put(Integer.valueOf(-126), HardCodeUtil.a(2131712508));
    this.downloadError.put(Integer.valueOf(-127), "UTF-8编码错误");
    this.downloadError.put(Integer.valueOf(-127), "UTF-8编码错误");
    this.downloadError.put(Integer.valueOf(-128), HardCodeUtil.a(2131712437));
    this.downloadError.put(Integer.valueOf(-1000), HardCodeUtil.a(2131712570));
    this.downloadError.put(Integer.valueOf(-1500), HardCodeUtil.a(2131712555));
    this.downloadError.put(Integer.valueOf(-1501), HardCodeUtil.a(2131712554));
  }
  
  private boolean isAllReady(QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = VideoEnvironment.checkAndLoadAVCodec();
    int i = AEResUtil.a(AEResInfo.jdField_b_of_type_DovComQqImAeDownloadAEResInfo);
    int j = AEResUtil.a(AEResInfo.c);
    if ((i == 2) || (j == 2))
    {
      i = 0;
      paramQQAppInterface = new StringBuilder().append("isAllReady()=");
      if ((!bool2) || (i == 0)) {
        break label88;
      }
    }
    label88:
    for (boolean bool1 = true;; bool1 = false)
    {
      VideoEnvironment.LogDownLoad("QZoneVideoDownloadActivity", bool1, null);
      if ((!bool2) || (i == 0)) {
        break label94;
      }
      return true;
      i = 1;
      break;
    }
    label94:
    return false;
  }
  
  private void onDownloadFinishAndJudge(String paramString1, int paramInt, String paramString2)
  {
    if ((paramString1.startsWith("new_qq_android_native_short_video_")) && (paramInt != 0))
    {
      sendErrorMessage(HardCodeUtil.a(2131712529) + getDownloadErrorConfig(paramInt) + "]");
      ShortVideoErrorReport.b(2, paramInt);
    }
    if ((paramString1.startsWith(AEResInfo.jdField_b_of_type_DovComQqImAeDownloadAEResInfo.jdField_b_of_type_JavaLangString)) && (paramInt != 0))
    {
      sendErrorMessage(HardCodeUtil.a(2131712441) + getDownloadErrorConfig(paramInt) + "]");
      ShortVideoErrorReport.b(2, paramInt);
    }
    if ((!isFinishing()) && (isAllReady(this.app)) && (checkIsOK())) {
      startQZoneVideo();
    }
    for (;;)
    {
      VideoEnvironment.LogDownLoad("QZoneVideoDownloadActivity", "name=" + paramString1 + ",result=" + paramInt + ",filePath=" + paramString2, null);
      return;
      VideoEnvironment.LogDownLoad("QZoneVideoDownloadActivity", "!isFinishing() && isAllReady(app) && checkIsOK() = false", null);
    }
  }
  
  private void sendErrorMessage(String paramString)
  {
    Message localMessage = this.mHandler.obtainMessage(1002);
    localMessage.obj = paramString;
    this.mHandler.sendMessage(localMessage);
  }
  
  private void startDownloadConfig()
  {
    if ((NetworkUtil.g(null)) && (this.app != null))
    {
      this.aekitTotalLen = 0L;
      this.aekitCurOffset = 0L;
      this.avCodecTotalLen = 0L;
      this.avCodecCurOffset = 0L;
      ShortVideoResourceManager.b(this.app, this);
      if (AEResUtil.a(AEResInfo.jdField_b_of_type_DovComQqImAeDownloadAEResInfo) == 2)
      {
        this.isAEBaseSoDownloadOk = false;
        AEResManager.a().a(AEResInfo.jdField_b_of_type_DovComQqImAeDownloadAEResInfo, this, false);
      }
      if (AEResUtil.a(AEResInfo.c) == 2)
      {
        this.isLightBaseSoDownloadOk = false;
        AEResManager.a().a(AEResInfo.c, this, false);
      }
      return;
    }
    this.mHandler.sendEmptyMessage(1002);
  }
  
  public static Intent startGifEditVideoActivity(Activity paramActivity, String paramString, ArrayList<String> paramArrayList, LocalMediaInfo paramLocalMediaInfo, long paramLong, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity.getIntent());
    Bundle localBundle = new Bundle();
    localBundle.putString("extra_publish_text", HardCodeUtil.a(2131712563));
    try
    {
      paramString = new EditLocalGifSource(paramString, paramArrayList, paramLocalMediaInfo, paramLong);
      paramString = new EditVideoParams(3, 4109, paramString, localBundle);
      localIntent.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", paramActivity.getClass().getName());
      localIntent.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      localIntent.putExtra(EditVideoParams.class.getName(), paramString);
      localIntent.putExtra("op_type", "gif_edit");
      if (paramInt == 3) {
        localIntent.putExtra("op_department", "grp_qzone");
      }
      return localIntent;
    }
    catch (Exception paramString)
    {
      QLog.e("QZoneVideoDownloadActivity", 1, paramString, new Object[0]);
      QQToast.a(paramActivity, HardCodeUtil.a(2131712567), 0).a();
    }
    return null;
  }
  
  private void startQZoneVideo()
  {
    if ((getAppRuntime() == null) && (TextUtils.isEmpty(this.uin)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("QZoneVideoDownloadActivity", 2, "startQZoneVideo, getAppRunime and uin are null");
      }
      QQToast.a(this, HardCodeUtil.a(2131712524), 0).a();
      QzoneVideoBeaconReport.reportVideoEvent(null, "qzone_video_recordtrim", "1000", null);
      finish();
      return;
    }
    Object localObject2 = QZoneHelper.UserInfo.getInstance();
    Object localObject1;
    Bundle localBundle;
    if (TextUtils.isEmpty(this.uin))
    {
      localObject1 = getAppRuntime().getAccount();
      ((QZoneHelper.UserInfo)localObject2).qzone_uin = ((String)localObject1);
      localObject1 = getIntent().getStringExtra("refer");
      QLog.i("QZoneVideoDownloadActivity", 1, "isSupportRecord=" + this.isSupportRecord + ",isSupportTrim=" + this.isSupportTrim + ",isPreviewVideo" + this.isPreviewVideo + ",refer=" + (String)localObject1 + ",videoRefer=" + this.videoRefer);
      localBundle = new Bundle();
      if ((!getIntent().hasExtra("support_pic")) || (getIntent().getBooleanExtra("support_pic", false))) {
        break label831;
      }
      localBundle.putBoolean("flow_camera_capture_mode", false);
      localBundle.putBoolean("flow_camera_capture_mode", false);
      label231:
      if (getIntent().hasExtra("enable_local_button")) {
        localBundle.putBoolean("enable_local_video", getIntent().getBooleanExtra("enable_local_button", true));
      }
      localBundle.putBoolean("flow_camera_video_mode", getIntent().getBooleanExtra("flow_camera_video_mode", true));
      localBundle.putString("sv_config", getIntent().getStringExtra("sv_config"));
      localBundle.putInt("UseQQCameraCompression", getIntent().getIntExtra("UseQQCameraCompression", 0));
      localBundle.putBoolean("PeakConstants.ARG_BEAUTY", getIntent().getBooleanExtra("PeakConstants.ARG_BEAUTY", true));
      localBundle.putBoolean("PeakConstants.ARG_SUPPORT_FILTER", getIntent().getBooleanExtra("PeakConstants.ARG_SUPPORT_FILTER", true));
      localBundle.putBoolean("PeakConstants.ARG_SUPPORT_DD", getIntent().getBooleanExtra("PeakConstants.ARG_SUPPORT_DD", true));
      localBundle.putBoolean("PeakConstants.ARG_UNFOLD_DD", getIntent().getBooleanExtra("PeakConstants.ARG_UNFOLD_DD", false));
      localBundle.putString("PeakConstants.ARG_DD_CATEGORY_NAME", getIntent().getStringExtra("PeakConstants.ARG_DD_CATEGORY_NAME"));
      localBundle.putString("PeakConstants.ARG_DD_ITEM_ID", getIntent().getStringExtra("PeakConstants.ARG_DD_ITEM_ID"));
      localBundle.putBoolean("PeakConstants.ARG_UNFOLD_FILTER", getIntent().getBooleanExtra("PeakConstants.ARG_UNFOLD_FILTER", false));
      localBundle.putString("PeakConstants.ARG_FILTER_CATEGORY_NAME", getIntent().getStringExtra("PeakConstants.ARG_FILTER_CATEGORY_NAME"));
      localBundle.putString("PeakConstants.ARG_FILTER_ITEM_ID", getIntent().getStringExtra("PeakConstants.ARG_FILTER_ITEM_ID"));
      localBundle.putInt("PeakConstants.ARG_FORCE_CAMERA", getIntent().getIntExtra("PeakConstants.ARG_FORCE_CAMERA", 0));
      localBundle.putBoolean("extra_directly_back", getIntent().getBooleanExtra("extra_directly_back", false));
      localBundle.putDouble("key_latitude", getIntent().getDoubleExtra("key_latitude", 4.9E-324D));
      localBundle.putDouble("key_longtitude", getIntent().getDoubleExtra("key_longtitude", 4.9E-324D));
      localBundle.putParcelable("key_qzone_topic", getIntent().getParcelableExtra("key_qzone_topic"));
      if (this.entrySource != 3) {
        break label853;
      }
      localBundle.putString("qcamera_photo_filepath", getIntent().getStringExtra("qcamera_photo_filepath"));
      localBundle.putBoolean("support_pic", getIntent().getBooleanExtra("support_pic", false));
      localBundle.putBoolean("go_publish_activity", getIntent().getBooleanExtra("go_publish_activity", false));
      localBundle.putBoolean("enable_local_video", getIntent().getBooleanExtra("enable_local_video", false));
      localBundle.putString("qzone_plugin_activity_name", getIntent().getStringExtra("qzone_plugin_activity_name"));
      localBundle.putBoolean("extra_from_take_photo_using_qq_camera", getIntent().getBooleanExtra("extra_from_take_photo_using_qq_camera", false));
    }
    for (;;)
    {
      if (!this.isSupportRecord) {
        break label943;
      }
      QZoneHelper.forwardToQzoneVideoCaptureNew(this.app, this, (QZoneHelper.UserInfo)localObject2, 10009, this.isSupportTrim, this.isSupportPic, (String)localObject1, this.videoRefer, this.isQzoneVip, this.isEditVideo, this.topicId, this.enterPtu, this.donaXiaoCallback, this.dongXiaoId, this.enableInputText, this.enablePrivList, this.enableQzoneSync, this.enableOriginVideo, this.confirmText, this.enableEditButton, this.enableLocalButton, this.isGlanceVideo, this.entrySource, this.isGoPublish, localBundle);
      QzoneVideoBeaconReport.reportVideoEvent(((QZoneHelper.UserInfo)localObject2).qzone_uin, "qzone_video_recordtrim", "0", "record");
      entrySourceReport();
      finish();
      return;
      localObject1 = this.uin;
      break;
      label831:
      localBundle.putBoolean("flow_camera_capture_mode", getIntent().getBooleanExtra("flow_camera_capture_mode", true));
      break label231;
      label853:
      if (this.entrySource == 5)
      {
        localBundle.putBoolean("enable_local_video", getIntent().getBooleanExtra("enable_local_video", false));
      }
      else if (this.entrySource == 7)
      {
        localBundle.putInt("ability_flag", 3);
        localBundle.putBoolean("PeakConstants.ARG_ALBUM", false);
      }
      else if (this.entrySource == 9)
      {
        localBundle.putBoolean("PeakConstants.ARG_ALBUM", false);
        localBundle.putInt("ability_flag", 3);
      }
    }
    label943:
    if (this.isSupportTrim)
    {
      QZoneHelper.forwardToQzoneVideoTrim(this, (QZoneHelper.UserInfo)localObject2, this.videoPath, this.videoSize, 10009, this.filerType, (String)localObject1, this.videoRefer);
      QzoneVideoBeaconReport.reportVideoEvent(((QZoneHelper.UserInfo)localObject2).qzone_uin, "qzone_video_recordtrim", "1", "trim");
      finish();
      return;
    }
    if (this.isPreviewVideo)
    {
      localObject1 = new Intent(getApplicationContext(), PreviewVideoActivity.class);
      ((Intent)localObject1).putExtra("video_source_path", this.videoPath);
      ((Intent)localObject1).putExtra("video_type", this.videoType);
      ((Intent)localObject1).putExtra("start_time", this.startTime);
      ((Intent)localObject1).putExtra("end_time", this.endTime);
      ((Intent)localObject1).putExtra("encode_video_params", this.mVideoExtras);
      startActivity((Intent)localObject1);
      overridePendingTransition(2130771999, 2130772003);
      finish();
      return;
    }
    if (this.isSupportEditVideo)
    {
      localObject1 = (ArrayList)getIntent().getSerializableExtra("PhotoConst.GIF_PHOTO_PATHS");
      int i = getIntent().getIntExtra("PhotoConst.GIF_DELAY", 150);
      localObject1 = startGifEditVideoActivity(this, this.gifPath, (ArrayList)localObject1, this.mediaInfo, i, 3);
      if (localObject1 != null)
      {
        ((Intent)localObject1).setClass(getApplicationContext(), EditVideoActivity.class);
        ((Intent)localObject1).putExtras(getIntent());
        QzonePluginProxyActivity.setActivityNameToIntent((Intent)localObject1, this.className);
        ((Intent)localObject1).putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", this.className);
        ((Intent)localObject1).putExtra("cleartop", true);
        ((Intent)localObject1).putExtra("PhotoConst.IS_CALL_IN_PLUGIN", true);
        ((Intent)localObject1).putExtra("PhotoConst.PLUGIN_NAME", "QZone");
        ((Intent)localObject1).putExtra("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
        ((Intent)localObject1).putExtra("DirectBackToQzone", true);
        startActivity((Intent)localObject1);
      }
      finish();
      return;
    }
    if (this.isSupportJumpToGifChooser)
    {
      localObject1 = getIntent();
      localObject2 = getIntent().getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME");
      ((Intent)localObject1).setClassName(getIntent().getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME"), (String)localObject2);
      ((Intent)localObject1).addFlags(603979776);
      QZoneHelper.launchQZone(this, "", (Intent)localObject1, -1);
      finish();
      return;
    }
    finish();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.app != null) {
      ShortVideoResourceManager.b(this.app, this);
    }
    AEResManager.a().a(this);
  }
  
  public void initUI()
  {
    setTitle(HardCodeUtil.a(2131712511));
    this.mDownloadingBar = ((ProgressBar)findViewById(2131373289));
    this.mDownloadingText = ((TextView)findViewById(2131373288));
    this.mDownloadingImage = ((URLImageView)findViewById(2131373292));
    this.mDownloadingImage.setImageURL("https://qzs.qq.com/qzone/photo/v7/js/common/images/mini_video_cover_7.png");
  }
  
  public void onAEDownloadFinish(AEResInfo paramAEResInfo, String paramString, boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      if (paramAEResInfo == AEResInfo.jdField_b_of_type_DovComQqImAeDownloadAEResInfo) {
        this.isAEBaseSoDownloadOk = true;
      }
      while ((!isFinishing()) && (isAllReady(this.app)) && (checkIsOK()))
      {
        startQZoneVideo();
        return;
        if (paramAEResInfo == AEResInfo.c) {
          this.isLightBaseSoDownloadOk = true;
        }
      }
      VideoEnvironment.LogDownLoad("QZoneVideoDownloadActivity", "!isFinishing() && isAllReady(app) && checkIsOK() = false", null);
      return;
    }
    sendErrorMessage(HardCodeUtil.a(2131712478) + getDownloadErrorConfig(paramInt) + "]");
    ShortVideoErrorReport.b(2, paramInt);
  }
  
  public void onAEProgressUpdate(AEResInfo paramAEResInfo, long paramLong1, long paramLong2)
  {
    Message localMessage;
    if (paramAEResInfo == AEResInfo.jdField_b_of_type_DovComQqImAeDownloadAEResInfo)
    {
      this.aekitCurOffset = paramLong1;
      this.aekitTotalLen = paramLong2;
      if (this.avCodecTotalLen + this.aekitTotalLen + this.lightSDKTotalLen > 0L)
      {
        i = (int)((float)(this.avCodecCurOffset + this.aekitCurOffset + this.lightSDKCurOffset) * 100.0F / (float)(this.avCodecTotalLen + this.aekitTotalLen + this.lightSDKTotalLen));
        localMessage = this.mHandler.obtainMessage(1004, i, 0);
        this.mHandler.sendMessage(localMessage);
        VideoEnvironment.LogDownLoad("QZoneVideoDownloadActivity", "packageIdx=" + paramAEResInfo.a + ",totalLen=" + paramLong2 + ",curOffset=" + paramLong1 + ",localProgress=" + i, null);
      }
    }
    while (paramAEResInfo != AEResInfo.c) {
      for (;;)
      {
        return;
        i = 0;
      }
    }
    this.lightSDKCurOffset = paramLong1;
    this.lightSDKTotalLen = paramLong2;
    if (this.avCodecTotalLen + this.aekitTotalLen + this.lightSDKTotalLen > 0L) {}
    for (int i = (int)((float)(this.avCodecCurOffset + this.aekitCurOffset + this.lightSDKCurOffset) * 100.0F / (float)(this.avCodecTotalLen + this.aekitTotalLen + this.lightSDKTotalLen));; i = 0)
    {
      localMessage = this.mHandler.obtainMessage(1004, i, 0);
      this.mHandler.sendMessage(localMessage);
      VideoEnvironment.LogDownLoad("QZoneVideoDownloadActivity", "packageIdx=" + paramAEResInfo.a + ",totalLen=" + paramLong2 + ",curOffset=" + paramLong1 + ",localProgress=" + i, null);
      return;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    finish();
  }
  
  public void onConfigResult(int paramInt1, int paramInt2)
  {
    VideoEnvironment.LogDownLoad("QZoneVideoDownloadActivity", "result=" + paramInt1 + ",serverError=" + paramInt2, null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0)
      {
        sendErrorMessage(HardCodeUtil.a(2131712442) + getDownloadErrorConfig(paramInt2) + "]");
        ShortVideoErrorReport.b(1, paramInt2);
      }
      ArrayList localArrayList;
      do
      {
        return;
        localArrayList = new ArrayList(1);
        paramInt1 = ShortVideoResourceManager.a(this.app, localArrayList);
        if (paramInt1 != 0) {
          break;
        }
        VideoEnvironment.LogDownLoad("QZoneVideoDownloadActivity", "onConfigResult| check config success...", null);
        this.isAVCodecDownloadOk = false;
        ShortVideoResourceManager.a(this.app, localArrayList, this);
        if (PtvFilterSoLoad.c())
        {
          this.isArtSoDownloadOk = false;
          ShortVideoResourceManager.b(this.app, localArrayList, this);
        }
      } while (!PtvFilterSoLoad.g());
      this.isTrackingDownloadOk = false;
      ShortVideoResourceManager.c(this.app, localArrayList, this);
      return;
      sendErrorMessage(HardCodeUtil.a(2131712531) + getDownloadErrorConfig(paramInt1) + "]");
      ShortVideoErrorReport.b(1, paramInt1);
      return;
    }
    sendErrorMessage(HardCodeUtil.a(2131712466) + getDownloadErrorConfig(paramInt2) + "]");
    ShortVideoErrorReport.b(1, paramInt2);
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
    getWindow().getDecorView().setBackgroundColor(-16777216);
    Intent localIntent = getIntent();
    if (localIntent == null)
    {
      Toast.makeText(getApplicationContext(), HardCodeUtil.a(2131712534), 1).show();
      QzoneVideoBeaconReport.reportVideoEvent(null, "qzone_video_recordtrim", "1002", null);
      return;
    }
    this.isSupportRecord = localIntent.getBooleanExtra("support_record", false);
    this.isSupportTrim = localIntent.getBooleanExtra("support_trim", false);
    this.isSupportEditVideo = localIntent.getBooleanExtra("support_edit_video", false);
    this.isSupportJumpToGifChooser = localIntent.getBooleanExtra("support_jump_gif_chooser", false);
    this.isSupportPic = localIntent.getBooleanExtra("support_pic", false);
    this.isSupportDynamicVideo = localIntent.getBooleanExtra("support_dynamic_video", false);
    this.entrySource = localIntent.getIntExtra("entry_source", 0);
    this.isQzoneVip = localIntent.getBooleanExtra("is_qzone_vip", false);
    this.isEditVideo = localIntent.getBooleanExtra("enable_edit_video", false);
    this.uin = localIntent.getStringExtra("uin");
    this.videoPath = localIntent.getStringExtra("file_send_path");
    this.videoSize = localIntent.getLongExtra("PhotoConst.VIDEO_SIZE", 0L);
    this.filerType = localIntent.getIntExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 2);
    this.isPreviewVideo = localIntent.getBooleanExtra("preview_video", false);
    this.videoType = localIntent.getIntExtra("video_type", 0);
    this.startTime = localIntent.getLongExtra("start_time", 0L);
    this.endTime = localIntent.getLongExtra("end_time", 0L);
    this.videoRefer = localIntent.getStringExtra("video_refer");
    this.mVideoExtras = localIntent.getBundleExtra("encode_video_params");
    this.topicId = localIntent.getStringExtra("topicId");
    this.enterPtu = localIntent.getBooleanExtra("enterPtu", false);
    this.donaXiaoCallback = localIntent.getStringExtra("callback");
    this.dongXiaoId = localIntent.getStringExtra("dongxiao_id");
    this.enablePrivList = localIntent.getBooleanExtra("enable_priv_list", true);
    this.enableInputText = localIntent.getBooleanExtra("enable_input_text", true);
    this.enableQzoneSync = localIntent.getBooleanExtra("enable_sync_qzone", false);
    this.enableOriginVideo = localIntent.getBooleanExtra("enable_origin_video", false);
    this.confirmText = localIntent.getStringExtra("confirm_text");
    this.enableEditButton = localIntent.getBooleanExtra("enable_edit_button", true);
    this.enableLocalButton = localIntent.getBooleanExtra("enable_local_button", true);
    this.isGlanceVideo = localIntent.getBooleanExtra("is_glance_video", false);
    this.mediaInfo = ((LocalMediaInfo)localIntent.getSerializableExtra("gif_media_info"));
    this.mPhotoPlusPos = localIntent.getIntExtra("gif_photoplus_pos", -1);
    this.gifPath = localIntent.getStringExtra("gif_path");
    this.className = localIntent.getStringExtra("gif_class_name");
    this.isGoPublish = localIntent.getBooleanExtra("go_publish_activity", false);
    this.doQZoneAlbumShortcut = localIntent.getIntExtra("isGoCreateAlbumShortcut", 0);
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface)))
    {
      int i;
      long l;
      Object localObject;
      if (TextUtils.isEmpty(this.uin))
      {
        paramBundle = getAppRuntime().getAccount();
        this.uin = paramBundle;
        if (!localIntent.getBooleanExtra("from_qcircle", false)) {
          break label967;
        }
        i = localIntent.getIntExtra("key_qcircle_entrance_type", 0);
        paramBundle = new Bundle();
        paramBundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", "com.tencent.qcircle.QCirclePublishFeedActivity");
        paramBundle.putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        paramBundle.putString("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
        paramBundle.putBoolean("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", false);
        paramBundle.putBoolean("PhotoConst.IS_CALL_IN_PLUGIN", true);
        paramBundle.putString("PhotoConst.UIN", this.uin);
        l = System.currentTimeMillis() - getIntent().getLongExtra("PhotoConst.timestamp_last_activity", System.currentTimeMillis());
        if (l >= 0L)
        {
          localObject = new HashMap();
          ((HashMap)localObject).put("VideoDownloadTime", String.valueOf(l));
          StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(((QQAppInterface)localAppRuntime).getCurrentUin(), "call_pitu_camera", true, 0L, 0L, (HashMap)localObject, null, true);
          QZLog.d("QZoneVideoDownloadActivity", 1, new Object[] { "oncreate... qcircle qzone->videoDownload time cost:", Long.valueOf(System.currentTimeMillis() - getIntent().getLongExtra("PhotoConst.timestamp_last_activity", System.currentTimeMillis())) });
        }
        paramBundle.putString("qq_camera_from_qcircle_scheme", localIntent.getStringExtra("key_scheme"));
        paramBundle.putLong("PhotoConst.timestamp", localIntent.getLongExtra("PhotoConst.timestamp", System.currentTimeMillis()));
        paramBundle.putLong("PhotoConst.timestamp_last_activity", System.currentTimeMillis());
        int j = localIntent.getIntExtra("BUNDLE_KEY_CIRCLE_HAS_PICKED_NUM", 0);
        paramBundle.putInt("BUNDLE_KEY_CIRCLE_HAS_PICKED_NUM", j);
        paramBundle.putBoolean("BUNDLE_KEY_CIRCLE_CAN_PICK_VIDEO", localIntent.getBooleanExtra("BUNDLE_KEY_CIRCLE_CAN_PICK_VIDEO", true));
        if (j <= 0) {
          break label914;
        }
        paramBundle = new AELaunchParamsBuilder(paramBundle).a(false).b(false).a();
        label874:
        if (i != 1) {
          break label937;
        }
        localIntent = new Intent();
        localIntent.putExtras(paramBundle);
        PicChooseJumpUtil.a(this, localIntent);
      }
      for (;;)
      {
        finish();
        return;
        paramBundle = this.uin;
        break;
        label914:
        paramBundle = new AELaunchParamsBuilder(paramBundle).a(false).b(true).a();
        break label874;
        label937:
        if (i == 2) {
          AECameraLauncher.b(this, paramBundle);
        } else if ((i == 3) || (i == 0)) {
          AECameraLauncher.c(this, paramBundle);
        }
      }
      label967:
      if ((this.doQZoneAlbumShortcut == 1) || (this.doQZoneAlbumShortcut == 2) || (this.doQZoneAlbumShortcut == 3))
      {
        paramBundle = localIntent.getStringExtra("UploadPhoto.key_album_id");
        localObject = localIntent.getStringExtra("UploadPhoto.key_album_name");
        Bitmap localBitmap = (Bitmap)localIntent.getParcelableExtra("UploadPhoto.key_album_cover");
        l = localIntent.getLongExtra("UploadPhoto.key_album_owner_uin", 0L);
        if (this.doQZoneAlbumShortcut == 1) {
          QZoneHelper.createAlbumShortCut((QQAppInterface)localAppRuntime, paramBundle, (String)localObject, localBitmap, l);
        }
        for (;;)
        {
          finish();
          return;
          if ((this.doQZoneAlbumShortcut == 2) || (this.doQZoneAlbumShortcut == 3)) {
            QZoneHelper.updateAlbumShortCut((QQAppInterface)localAppRuntime, paramBundle, (String)localObject, localBitmap, l);
          }
        }
      }
      if (((QQAppInterface)localAppRuntime).isVideoChatting())
      {
        Toast.makeText(getApplicationContext(), HardCodeUtil.a(2131712526), 1).show();
        QzoneVideoBeaconReport.reportVideoEvent(this.uin, "qzone_video_recordtrim", "1003", null);
        finish();
        return;
      }
      if (QavCameraUsage.b(BaseApplicationImpl.getContext()))
      {
        QzoneVideoBeaconReport.reportVideoEvent(this.uin, "qzone_video_recordtrim", "1004", null);
        finish();
        return;
      }
      if (!isAllReady((QQAppInterface)localAppRuntime))
      {
        setContentView(2131563263);
        initUI();
        this.mIsUIInited.set(true);
        initDownloadErrorConfig();
        startDownloadConfig();
        return;
      }
      if (this.isSupportDynamicVideo)
      {
        setContentView(2131563263);
        initUI();
      }
    }
    for (;;)
    {
      startQZoneVideo();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QZoneVideoDownloadActivity", 2, "app is not QQAppInterface");
      }
    }
  }
  
  public void onDownloadFinish(String paramString1, int paramInt, String paramString2)
  {
    VideoEnvironment.LogDownLoad("QZoneVideoDownloadActivity", "onDownloadFinish| name=" + paramString1 + ",result=" + paramInt + ",filePath=" + paramString2, null);
    if (paramString1.startsWith("new_qq_android_native_short_video_")) {
      this.isAVCodecDownloadOk = true;
    }
    for (;;)
    {
      onDownloadFinishAndJudge(paramString1, paramInt, paramString2);
      return;
      if (paramString1.startsWith("new_qq_android_native_art_filter_")) {
        this.isArtSoDownloadOk = true;
      } else if (paramString1.startsWith("new_qq_android_native_object_tracking_")) {
        this.isTrackingDownloadOk = true;
      }
    }
  }
  
  public void onNetWorkNone()
  {
    VideoEnvironment.LogDownLoad("QZoneVideoDownloadActivity", "onNetWorkNone...", null);
    this.mDownloadingBar.post(new QZoneVideoDownloadActivity.2(this));
    ShortVideoErrorReport.b(3, -1500);
  }
  
  public void onUpdateProgress(String paramString, long paramLong1, long paramLong2)
  {
    this.avCodecCurOffset = paramLong1;
    this.avCodecTotalLen = paramLong2;
    if (this.avCodecTotalLen + this.aekitTotalLen > 0L) {}
    for (int i = (int)((float)(this.avCodecCurOffset + this.aekitCurOffset) * 100.0F / (float)(this.avCodecTotalLen + this.aekitTotalLen));; i = 0)
    {
      if (paramString.startsWith("new_qq_android_native_short_video_"))
      {
        Message localMessage = this.mHandler.obtainMessage(1004, i, 0);
        this.mHandler.sendMessage(localMessage);
      }
      VideoEnvironment.LogDownLoad("QZoneVideoDownloadActivity", "name=" + paramString + ",totalLen=" + paramLong2 + ",curOffset=" + paramLong1 + ",localProgress=" + i, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.QZoneVideoDownloadActivity
 * JD-Core Version:    0.7.0.1
 */