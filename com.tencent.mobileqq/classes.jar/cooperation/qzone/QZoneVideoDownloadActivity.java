package cooperation.qzone;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEDownloadCallBack;
import com.tencent.aelight.camera.download.api.IAEResDownload;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.entry.api.AELaunchParamsBuilder;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.aelight.camera.util.api.IPicChooseJumpUtil;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.shortvideo.PreviewVideoActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.qroute.QRoute;
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
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public class QZoneVideoDownloadActivity
  extends IphoneTitleBarActivity
  implements IAEDownloadCallBack, ShortVideoResourceManager.INet_ShortVideoResource, ShortVideoResourceStatus.ISVConfig
{
  private static final String EXTRA_FROM_TAKE_PHOTO_USING_QQ_CAMERA = "extra_from_take_photo_using_qq_camera";
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkIsOK()=");
    boolean bool;
    if ((this.isAVCodecDownloadOk) && (this.isAEBaseSoDownloadOk) && (this.isLightBaseSoDownloadOk) && (this.isArtSoDownloadOk)) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    VideoEnvironment.LogDownLoad("QZoneVideoDownloadActivity", localStringBuilder.toString(), null);
    return (this.isAVCodecDownloadOk) && (this.isAEBaseSoDownloadOk) && (this.isLightBaseSoDownloadOk) && (this.isArtSoDownloadOk);
  }
  
  private void entrySourceReport()
  {
    int i = this.entrySource;
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      LpReportInfo_pf00064.allReport(612, 1, 2);
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoDownloadActivity", 2, "entry source quick left slide report");
      }
    }
    else
    {
      LpReportInfo_pf00064.allReport(612, 1, 1);
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoDownloadActivity", 2, "entry source plus report");
      }
    }
  }
  
  private String getDownloadErrorConfig(int paramInt)
  {
    Object localObject = this.downloadError;
    if (localObject == null) {
      return String.valueOf(paramInt);
    }
    localObject = (String)((HashMap)localObject).get(Integer.valueOf(paramInt));
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return String.valueOf(paramInt);
    }
    return localObject;
  }
  
  private void initDownloadErrorConfig()
  {
    if (this.downloadError == null) {
      this.downloadError = new HashMap();
    }
    this.downloadError.put(Integer.valueOf(-1), HardCodeUtil.a(2131910104));
    this.downloadError.put(Integer.valueOf(-2), HardCodeUtil.a(2131910017));
    this.downloadError.put(Integer.valueOf(-2), HardCodeUtil.a(2131910079));
    this.downloadError.put(Integer.valueOf(-3), HardCodeUtil.a(2131910127));
    this.downloadError.put(Integer.valueOf(-4), HardCodeUtil.a(2131910093));
    this.downloadError.put(Integer.valueOf(-100), HardCodeUtil.a(2131910098));
    this.downloadError.put(Integer.valueOf(-101), HardCodeUtil.a(2131910074));
    this.downloadError.put(Integer.valueOf(-105), HardCodeUtil.a(2131910106));
    this.downloadError.put(Integer.valueOf(-106), "MD5为空错误");
    this.downloadError.put(Integer.valueOf(-107), HardCodeUtil.a(2131910119));
    this.downloadError.put(Integer.valueOf(-108), "MD5校验错误");
    this.downloadError.put(Integer.valueOf(-117), HardCodeUtil.a(2131910026));
    this.downloadError.put(Integer.valueOf(-118), HardCodeUtil.a(2131910004));
    this.downloadError.put(Integer.valueOf(-125), HardCodeUtil.a(2131910101));
    this.downloadError.put(Integer.valueOf(-126), HardCodeUtil.a(2131910073));
    this.downloadError.put(Integer.valueOf(-127), "UTF-8编码错误");
    this.downloadError.put(Integer.valueOf(-127), "UTF-8编码错误");
    this.downloadError.put(Integer.valueOf(-128), HardCodeUtil.a(2131910006));
    this.downloadError.put(Integer.valueOf(-1000), HardCodeUtil.a(2131910132));
    this.downloadError.put(Integer.valueOf(-1500), HardCodeUtil.a(2131910118));
    this.downloadError.put(Integer.valueOf(-1501), HardCodeUtil.a(2131910117));
  }
  
  private boolean isAllReady(QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = VideoEnvironment.checkAndLoadAVCodec();
    int i = ((IAEResUtil)QRoute.api(IAEResUtil.class)).getAEResStatus(AEResInfo.AE_RES_BASE_PACKAGE);
    int j = ((IAEResUtil)QRoute.api(IAEResUtil.class)).getAEResStatus(AEResInfo.LIGHT_RES_BASE_PACKAGE);
    paramQQAppInterface = (IAEResUtil)QRoute.api(IAEResUtil.class);
    if (i != 2)
    {
      paramQQAppInterface = (IAEResUtil)QRoute.api(IAEResUtil.class);
      if (j != 2)
      {
        i = 1;
        break label81;
      }
    }
    i = 0;
    label81:
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("isAllReady()=");
    boolean bool1;
    if ((bool2) && (i != 0)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramQQAppInterface.append(bool1);
    VideoEnvironment.LogDownLoad("QZoneVideoDownloadActivity", paramQQAppInterface.toString(), null);
    return (bool2) && (i != 0);
  }
  
  private void onDownloadFinishAndJudge(String paramString1, int paramInt, String paramString2)
  {
    if ((paramString1.startsWith("new_qq_android_native_short_video_")) && (paramInt != 0))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131910092));
      localStringBuilder.append(getDownloadErrorConfig(paramInt));
      localStringBuilder.append("]");
      sendErrorMessage(localStringBuilder.toString());
      ShortVideoErrorReport.b(2, paramInt);
    }
    if ((paramString1.startsWith(AEResInfo.AE_RES_BASE_PACKAGE.resPrefix)) && (paramInt != 0))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131910010));
      localStringBuilder.append(getDownloadErrorConfig(paramInt));
      localStringBuilder.append("]");
      sendErrorMessage(localStringBuilder.toString());
      ShortVideoErrorReport.b(2, paramInt);
    }
    if ((!isFinishing()) && (isAllReady(this.app)) && (checkIsOK())) {
      startQZoneVideo();
    } else {
      VideoEnvironment.LogDownLoad("QZoneVideoDownloadActivity", "!isFinishing() && isAllReady(app) && checkIsOK() = false", null);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("name=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(",result=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",filePath=");
    localStringBuilder.append(paramString2);
    VideoEnvironment.LogDownLoad("QZoneVideoDownloadActivity", localStringBuilder.toString(), null);
  }
  
  private void sendErrorMessage(String paramString)
  {
    Message localMessage = this.mHandler.obtainMessage(1002);
    localMessage.obj = paramString;
    this.mHandler.sendMessage(localMessage);
  }
  
  private void startDownloadConfig()
  {
    if ((NetworkUtil.isNetworkAvailable(null)) && (this.app != null))
    {
      this.aekitTotalLen = 0L;
      this.aekitCurOffset = 0L;
      this.avCodecTotalLen = 0L;
      this.avCodecCurOffset = 0L;
      ShortVideoResourceManager.b(this.app, this);
      if (((IAEResUtil)QRoute.api(IAEResUtil.class)).getAEResStatus(AEResInfo.AE_RES_BASE_PACKAGE) == 2)
      {
        this.isAEBaseSoDownloadOk = false;
        ((IAEResDownload)QRoute.api(IAEResDownload.class)).requestDownload(AEResInfo.AE_RES_BASE_PACKAGE, this, false);
      }
      if (((IAEResUtil)QRoute.api(IAEResUtil.class)).getAEResStatus(AEResInfo.LIGHT_RES_BASE_PACKAGE) == 2)
      {
        this.isLightBaseSoDownloadOk = false;
        ((IAEResDownload)QRoute.api(IAEResDownload.class)).requestDownload(AEResInfo.LIGHT_RES_BASE_PACKAGE, this, false);
      }
    }
    else
    {
      this.mHandler.sendEmptyMessage(1002);
    }
  }
  
  private void startQZoneVideo()
  {
    if ((getAppRuntime() == null) && (TextUtils.isEmpty(this.uin)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("QZoneVideoDownloadActivity", 2, "startQZoneVideo, getAppRunime and uin are null");
      }
      QQToast.makeText(this, HardCodeUtil.a(2131910087), 0).show();
      QzoneVideoBeaconReport.reportVideoEvent(null, "qzone_video_recordtrim", "1000", null);
      finish();
      return;
    }
    Object localObject2 = QZoneHelper.UserInfo.getInstance();
    if (TextUtils.isEmpty(this.uin)) {
      localObject1 = getAppRuntime().getAccount();
    } else {
      localObject1 = this.uin;
    }
    ((QZoneHelper.UserInfo)localObject2).qzone_uin = ((String)localObject1);
    Object localObject1 = getIntent().getStringExtra("refer");
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("isSupportRecord=");
    ((StringBuilder)localObject3).append(this.isSupportRecord);
    ((StringBuilder)localObject3).append(",isSupportTrim=");
    ((StringBuilder)localObject3).append(this.isSupportTrim);
    ((StringBuilder)localObject3).append(",isPreviewVideo");
    ((StringBuilder)localObject3).append(this.isPreviewVideo);
    ((StringBuilder)localObject3).append(",refer=");
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(",videoRefer=");
    ((StringBuilder)localObject3).append(this.videoRefer);
    QLog.i("QZoneVideoDownloadActivity", 1, ((StringBuilder)localObject3).toString());
    localObject3 = new Bundle();
    if ((getIntent().hasExtra("support_pic")) && (!getIntent().getBooleanExtra("support_pic", false)))
    {
      ((Bundle)localObject3).putBoolean("flow_camera_capture_mode", false);
      ((Bundle)localObject3).putBoolean("flow_camera_capture_mode", false);
    }
    else
    {
      ((Bundle)localObject3).putBoolean("flow_camera_capture_mode", getIntent().getBooleanExtra("flow_camera_capture_mode", true));
    }
    if (getIntent().hasExtra("enable_local_button")) {
      ((Bundle)localObject3).putBoolean("enable_local_video", getIntent().getBooleanExtra("enable_local_button", true));
    }
    ((Bundle)localObject3).putBoolean("flow_camera_video_mode", getIntent().getBooleanExtra("flow_camera_video_mode", true));
    ((Bundle)localObject3).putString("sv_config", getIntent().getStringExtra("sv_config"));
    ((Bundle)localObject3).putInt("UseQQCameraCompression", getIntent().getIntExtra("UseQQCameraCompression", 0));
    ((Bundle)localObject3).putBoolean("PeakConstants.ARG_BEAUTY", getIntent().getBooleanExtra("PeakConstants.ARG_BEAUTY", true));
    ((Bundle)localObject3).putBoolean("PeakConstants.ARG_SUPPORT_FILTER", getIntent().getBooleanExtra("PeakConstants.ARG_SUPPORT_FILTER", true));
    ((Bundle)localObject3).putBoolean("PeakConstants.ARG_SUPPORT_DD", getIntent().getBooleanExtra("PeakConstants.ARG_SUPPORT_DD", true));
    ((Bundle)localObject3).putBoolean("PeakConstants.ARG_UNFOLD_DD", getIntent().getBooleanExtra("PeakConstants.ARG_UNFOLD_DD", false));
    ((Bundle)localObject3).putString("PeakConstants.ARG_DD_CATEGORY_NAME", getIntent().getStringExtra("PeakConstants.ARG_DD_CATEGORY_NAME"));
    ((Bundle)localObject3).putString("PeakConstants.ARG_DD_ITEM_ID", getIntent().getStringExtra("PeakConstants.ARG_DD_ITEM_ID"));
    ((Bundle)localObject3).putBoolean("PeakConstants.ARG_UNFOLD_FILTER", getIntent().getBooleanExtra("PeakConstants.ARG_UNFOLD_FILTER", false));
    ((Bundle)localObject3).putString("PeakConstants.ARG_FILTER_CATEGORY_NAME", getIntent().getStringExtra("PeakConstants.ARG_FILTER_CATEGORY_NAME"));
    ((Bundle)localObject3).putString("PeakConstants.ARG_FILTER_ITEM_ID", getIntent().getStringExtra("PeakConstants.ARG_FILTER_ITEM_ID"));
    ((Bundle)localObject3).putInt("PeakConstants.ARG_FORCE_CAMERA", getIntent().getIntExtra("PeakConstants.ARG_FORCE_CAMERA", 0));
    ((Bundle)localObject3).putBoolean("extra_directly_back", getIntent().getBooleanExtra("extra_directly_back", false));
    ((Bundle)localObject3).putDouble("key_latitude", getIntent().getDoubleExtra("key_latitude", 4.9E-324D));
    ((Bundle)localObject3).putDouble("key_longtitude", getIntent().getDoubleExtra("key_longtitude", 4.9E-324D));
    ((Bundle)localObject3).putParcelable("key_qzone_topic", getIntent().getParcelableExtra("key_qzone_topic"));
    int i = this.entrySource;
    if (i == 3)
    {
      ((Bundle)localObject3).putString("qcamera_photo_filepath", getIntent().getStringExtra("qcamera_photo_filepath"));
      ((Bundle)localObject3).putBoolean("support_pic", getIntent().getBooleanExtra("support_pic", false));
      ((Bundle)localObject3).putBoolean("go_publish_activity", getIntent().getBooleanExtra("go_publish_activity", false));
      ((Bundle)localObject3).putBoolean("enable_local_video", getIntent().getBooleanExtra("enable_local_video", false));
      ((Bundle)localObject3).putString("qzone_plugin_activity_name", getIntent().getStringExtra("qzone_plugin_activity_name"));
      ((Bundle)localObject3).putBoolean("extra_from_take_photo_using_qq_camera", getIntent().getBooleanExtra("extra_from_take_photo_using_qq_camera", false));
    }
    else if (i == 5)
    {
      ((Bundle)localObject3).putBoolean("enable_local_video", getIntent().getBooleanExtra("enable_local_video", false));
    }
    else if (i == 7)
    {
      ((Bundle)localObject3).putInt("ability_flag", 3);
      ((Bundle)localObject3).putBoolean("PeakConstants.ARG_ALBUM", false);
    }
    else if (i == 9)
    {
      ((Bundle)localObject3).putBoolean("PeakConstants.ARG_ALBUM", false);
      ((Bundle)localObject3).putInt("ability_flag", 3);
    }
    if (this.isSupportRecord)
    {
      QZoneHelper.forwardToQzoneVideoCaptureNew(this.app, this, (QZoneHelper.UserInfo)localObject2, 10009, this.isSupportTrim, this.isSupportPic, (String)localObject1, this.videoRefer, this.isQzoneVip, this.isEditVideo, this.topicId, this.enterPtu, this.donaXiaoCallback, this.dongXiaoId, this.enableInputText, this.enablePrivList, this.enableQzoneSync, this.enableOriginVideo, this.confirmText, this.enableEditButton, this.enableLocalButton, this.isGlanceVideo, this.entrySource, this.isGoPublish, (Bundle)localObject3);
      QzoneVideoBeaconReport.reportVideoEvent(((QZoneHelper.UserInfo)localObject2).qzone_uin, "qzone_video_recordtrim", "0", "record");
      entrySourceReport();
      finish();
      return;
    }
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
      overridePendingTransition(2130772014, 2130772018);
      finish();
      return;
    }
    if (this.isSupportEditVideo) {
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
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.app != null) {
      ShortVideoResourceManager.b(this.app, this);
    }
    ((IAEResDownload)QRoute.api(IAEResDownload.class)).removeCallBack(this);
  }
  
  public void initUI()
  {
    setTitle(HardCodeUtil.a(2131910076));
    this.mDownloadingBar = ((ProgressBar)findViewById(2131440431));
    this.mDownloadingText = ((TextView)findViewById(2131440430));
    this.mDownloadingImage = ((URLImageView)findViewById(2131440434));
    this.mDownloadingImage.setImageURL("https://qzs.qq.com/qzone/photo/v7/js/common/images/mini_video_cover_7.png");
  }
  
  public void onAEDownloadFinish(AEResInfo paramAEResInfo, String paramString, boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      if (paramAEResInfo == AEResInfo.AE_RES_BASE_PACKAGE) {
        this.isAEBaseSoDownloadOk = true;
      } else if (paramAEResInfo == AEResInfo.LIGHT_RES_BASE_PACKAGE) {
        this.isLightBaseSoDownloadOk = true;
      }
      if ((!isFinishing()) && (isAllReady(this.app)) && (checkIsOK()))
      {
        startQZoneVideo();
        return;
      }
      VideoEnvironment.LogDownLoad("QZoneVideoDownloadActivity", "!isFinishing() && isAllReady(app) && checkIsOK() = false", null);
      return;
    }
    paramAEResInfo = new StringBuilder();
    paramAEResInfo.append(HardCodeUtil.a(2131910043));
    paramAEResInfo.append(getDownloadErrorConfig(paramInt));
    paramAEResInfo.append("]");
    sendErrorMessage(paramAEResInfo.toString());
    ShortVideoErrorReport.b(2, paramInt);
  }
  
  public void onAEProgressUpdate(AEResInfo paramAEResInfo, long paramLong1, long paramLong2)
  {
    long l1;
    long l2;
    long l3;
    int i;
    Object localObject;
    if (paramAEResInfo == AEResInfo.AE_RES_BASE_PACKAGE)
    {
      this.aekitCurOffset = paramLong1;
      this.aekitTotalLen = paramLong2;
      l1 = this.avCodecTotalLen;
      l2 = this.aekitTotalLen;
      l3 = this.lightSDKTotalLen;
      if (l1 + l2 + l3 > 0L) {
        i = (int)((float)(this.avCodecCurOffset + this.aekitCurOffset + this.lightSDKCurOffset) * 100.0F / (float)(l1 + l2 + l3));
      } else {
        i = 0;
      }
      localObject = this.mHandler.obtainMessage(1004, i, 0);
      this.mHandler.sendMessage((Message)localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("packageIdx=");
      ((StringBuilder)localObject).append(paramAEResInfo.index);
      ((StringBuilder)localObject).append(",totalLen=");
      ((StringBuilder)localObject).append(paramLong2);
      ((StringBuilder)localObject).append(",curOffset=");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append(",localProgress=");
      ((StringBuilder)localObject).append(i);
      VideoEnvironment.LogDownLoad("QZoneVideoDownloadActivity", ((StringBuilder)localObject).toString(), null);
      return;
    }
    if (paramAEResInfo == AEResInfo.LIGHT_RES_BASE_PACKAGE)
    {
      this.lightSDKCurOffset = paramLong1;
      this.lightSDKTotalLen = paramLong2;
      l1 = this.avCodecTotalLen;
      l2 = this.aekitTotalLen;
      l3 = this.lightSDKTotalLen;
      if (l1 + l2 + l3 > 0L) {
        i = (int)((float)(this.avCodecCurOffset + this.aekitCurOffset + this.lightSDKCurOffset) * 100.0F / (float)(l1 + l2 + l3));
      } else {
        i = 0;
      }
      localObject = this.mHandler.obtainMessage(1004, i, 0);
      this.mHandler.sendMessage((Message)localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("packageIdx=");
      ((StringBuilder)localObject).append(paramAEResInfo.index);
      ((StringBuilder)localObject).append(",totalLen=");
      ((StringBuilder)localObject).append(paramLong2);
      ((StringBuilder)localObject).append(",curOffset=");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append(",localProgress=");
      ((StringBuilder)localObject).append(i);
      VideoEnvironment.LogDownLoad("QZoneVideoDownloadActivity", ((StringBuilder)localObject).toString(), null);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    finish();
  }
  
  public void onConfigResult(int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("result=");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(",serverError=");
    ((StringBuilder)localObject).append(paramInt2);
    VideoEnvironment.LogDownLoad("QZoneVideoDownloadActivity", ((StringBuilder)localObject).toString(), null);
    if ((paramInt1 != 1) && (paramInt1 != 0))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131910033));
      ((StringBuilder)localObject).append(getDownloadErrorConfig(paramInt2));
      ((StringBuilder)localObject).append("]");
      sendErrorMessage(((StringBuilder)localObject).toString());
      ShortVideoErrorReport.b(1, paramInt2);
      return;
    }
    if (paramInt2 != 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131910011));
      ((StringBuilder)localObject).append(getDownloadErrorConfig(paramInt2));
      ((StringBuilder)localObject).append("]");
      sendErrorMessage(((StringBuilder)localObject).toString());
      ShortVideoErrorReport.b(1, paramInt2);
      return;
    }
    localObject = new ArrayList(1);
    paramInt1 = ShortVideoResourceManager.a(this.app, (List)localObject);
    if (paramInt1 == 0)
    {
      VideoEnvironment.LogDownLoad("QZoneVideoDownloadActivity", "onConfigResult| check config success...", null);
      this.isAVCodecDownloadOk = false;
      ShortVideoResourceManager.a(this.app, (List)localObject, this);
      if (PtvFilterSoLoad.e())
      {
        this.isArtSoDownloadOk = false;
        ShortVideoResourceManager.b(this.app, (List)localObject, this);
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131910094));
      ((StringBuilder)localObject).append(getDownloadErrorConfig(paramInt1));
      ((StringBuilder)localObject).append("]");
      sendErrorMessage(((StringBuilder)localObject).toString());
      ShortVideoErrorReport.b(1, paramInt1);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().getDecorView().setBackgroundColor(-16777216);
    Intent localIntent = getIntent();
    if (localIntent == null)
    {
      Toast.makeText(getApplicationContext(), HardCodeUtil.a(2131910097), 1).show();
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
      if (TextUtils.isEmpty(this.uin)) {
        paramBundle = getAppRuntime().getAccount();
      } else {
        paramBundle = this.uin;
      }
      this.uin = paramBundle;
      long l;
      Object localObject;
      if (localIntent.getBooleanExtra("from_qcircle", false))
      {
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
        if (j > 0) {
          paramBundle = new AELaunchParamsBuilder(paramBundle).canMixPickPhotoAndVideo(false).canSwitchSelectionMode(false).build();
        } else {
          paramBundle = new AELaunchParamsBuilder(paramBundle).canMixPickPhotoAndVideo(false).canSwitchSelectionMode(true).build();
        }
        if (i == 1)
        {
          localIntent = new Intent();
          localIntent.putExtras(paramBundle);
          ((IPicChooseJumpUtil)QRoute.api(IPicChooseJumpUtil.class)).jumpForAECircle(this, localIntent);
        }
        else if (i == 2)
        {
          ((IAECameraLauncher)QRoute.api(IAECameraLauncher.class)).launchAECameraFromCircle(this, paramBundle);
        }
        else if ((i == 3) || (i == 0))
        {
          ((IAECameraLauncher)QRoute.api(IAECameraLauncher.class)).launchAEMutiCameraFromCircle(this, paramBundle);
        }
        finish();
        return;
      }
      int i = this.doQZoneAlbumShortcut;
      if ((i != 1) && (i != 2) && (i != 3))
      {
        paramBundle = (QQAppInterface)localAppRuntime;
        if (paramBundle.isVideoChatting())
        {
          Toast.makeText(getApplicationContext(), HardCodeUtil.a(2131910089), 1).show();
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
        if (!isAllReady(paramBundle))
        {
          setContentView(2131629727);
          initUI();
          this.mIsUIInited.set(true);
          initDownloadErrorConfig();
          startDownloadConfig();
          return;
        }
        if (this.isSupportDynamicVideo)
        {
          setContentView(2131629727);
          initUI();
        }
      }
      else
      {
        paramBundle = localIntent.getStringExtra("UploadPhoto.key_album_id");
        localObject = localIntent.getStringExtra("UploadPhoto.key_album_name");
        Bitmap localBitmap = (Bitmap)localIntent.getParcelableExtra("UploadPhoto.key_album_cover");
        l = localIntent.getLongExtra("UploadPhoto.key_album_owner_uin", 0L);
        i = this.doQZoneAlbumShortcut;
        if (i == 1) {
          QZoneHelper.createAlbumShortCut((QQAppInterface)localAppRuntime, paramBundle, (String)localObject, localBitmap, l);
        } else if ((i == 2) || (i == 3)) {
          QZoneHelper.updateAlbumShortCut((QQAppInterface)localAppRuntime, paramBundle, (String)localObject, localBitmap, l);
        }
        finish();
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("QZoneVideoDownloadActivity", 2, "app is not QQAppInterface");
    }
    startQZoneVideo();
  }
  
  public void onDownloadFinish(String paramString1, int paramInt, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDownloadFinish| name=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(",result=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",filePath=");
    localStringBuilder.append(paramString2);
    VideoEnvironment.LogDownLoad("QZoneVideoDownloadActivity", localStringBuilder.toString(), null);
    if (paramString1.startsWith("new_qq_android_native_short_video_")) {
      this.isAVCodecDownloadOk = true;
    } else if (paramString1.startsWith("new_qq_android_native_art_filter_")) {
      this.isArtSoDownloadOk = true;
    }
    onDownloadFinishAndJudge(paramString1, paramInt, paramString2);
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
    long l1 = this.avCodecTotalLen;
    long l2 = this.aekitTotalLen;
    int i;
    if (l1 + l2 > 0L) {
      i = (int)((float)(this.avCodecCurOffset + this.aekitCurOffset) * 100.0F / (float)(l1 + l2));
    } else {
      i = 0;
    }
    if (paramString.startsWith("new_qq_android_native_short_video_"))
    {
      localObject = this.mHandler.obtainMessage(1004, i, 0);
      this.mHandler.sendMessage((Message)localObject);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("name=");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(",totalLen=");
    ((StringBuilder)localObject).append(paramLong2);
    ((StringBuilder)localObject).append(",curOffset=");
    ((StringBuilder)localObject).append(paramLong1);
    ((StringBuilder)localObject).append(",localProgress=");
    ((StringBuilder)localObject).append(i);
    VideoEnvironment.LogDownLoad("QZoneVideoDownloadActivity", ((StringBuilder)localObject).toString(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.QZoneVideoDownloadActivity
 * JD-Core Version:    0.7.0.1
 */