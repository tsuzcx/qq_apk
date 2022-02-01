package dov.com.qq.im;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;
import com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import com.tencent.mobileqq.activity.richmedia.FlowComponentInterface;
import com.tencent.mobileqq.activity.richmedia.MediaCodecSendTask;
import com.tencent.mobileqq.activity.richmedia.MediaCodecSendTask.VideoSendPublicParam;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter;
import com.tencent.mobileqq.activity.shortvideo.PreviewVideoActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.mediacodec.utils.MediaUtil;
import com.tencent.mobileqq.richmedia.mediacodec.utils.ShortVideoExceptionReporter;
import com.tencent.mobileqq.shortvideo.AIOShortVideoUtil;
import com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.util.GpsComplementUtil;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.video.QzoneVerticalVideoTopicInfo;
import cooperation.qzone.video.VideoComponentCallback;
import dov.com.qq.im.ae.AEPituCameraUnit;
import dov.com.qq.im.ae.camera.AEPhotoCaptureResult;
import dov.com.qq.im.ae.camera.AEVideoCaptureResult;
import dov.com.qq.im.setting.CaptureEntranceParams;
import dov.com.qq.im.setting.ICameraEntrance;
import dov.com.qq.im.setting.IQIMCameraContainer;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.activity.richmedia.QzoneEditPictureActivity;
import dov.com.tencent.mobileqq.activity.richmedia.QzoneEditVideoActivity;
import java.io.File;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class AEPituQzoneCameraUnit
  extends AEPituCameraUnit
{
  public static long a;
  private static final String c;
  private int jdField_a_of_type_Int = 10001;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private FlowComponentInterface jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface = null;
  private QzoneVerticalVideoTopicInfo jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo;
  public String a;
  public boolean a;
  private int b;
  public long b;
  private String d;
  private String e;
  private String f;
  private int jdField_g_of_type_Int;
  private String jdField_g_of_type_JavaLangString;
  private int jdField_h_of_type_Int;
  private String jdField_h_of_type_JavaLangString;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int = 0;
  private boolean jdField_i_of_type_Boolean;
  private boolean j;
  private boolean k;
  
  static
  {
    jdField_c_of_type_JavaLangString = AEPituQzoneCameraUnit.class.getSimpleName();
    jdField_a_of_type_Long = -1L;
  }
  
  public AEPituQzoneCameraUnit(IQIMCameraContainer paramIQIMCameraContainer, ICameraEntrance paramICameraEntrance)
  {
    super(paramIQIMCameraContainer, paramICameraEntrance);
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_JavaLangString = (BaseApplicationImpl.getContext().getFilesDir().getPath() + "/Android/data/com.tencent.mobileqq/qq/video/Source/" + this.jdField_b_of_type_Long);
    this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams = new CaptureEntranceParams(10001, 122, 3);
    this.jdField_d_of_type_Int = 12;
  }
  
  private void A()
  {
    String str = this.jdField_a_of_type_JavaLangString + File.separator + "videoThumb.jpg";
    try
    {
      FileUtils.b(this.jdField_a_of_type_JavaLangString);
      MediaUtil.a(this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.videoMp4FilePath, str);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = new LocalMediaInfo();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.thumbnailPath = str;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_c_of_type_JavaLangString, 2, "createDirectory error", localException);
        }
      }
    }
  }
  
  private void B()
  {
    try
    {
      FileUtils.a(this.jdField_a_of_type_JavaLangString);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i(jdField_c_of_type_JavaLangString, 2, "Delete file error", localException);
    }
  }
  
  private void C()
  {
    if ((this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo != null)) {
      a(this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.audioDataFilePath, 0, this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.videoMp4FilePath, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.thumbnailPath, null, (int)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface, null, -1, null, false, this.jdField_b_of_type_Int, this.jdField_g_of_type_Int, this.jdField_e_of_type_JavaLangString, this.jdField_h_of_type_Int, this.jdField_f_of_type_JavaLangString, false, false, false, false);
    }
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 0) {}
    while (paramInt != -1) {
      return;
    }
    QLog.i(jdField_c_of_type_JavaLangString, 2, "REQ_PREVIEW_EDIT_GIF_ACTIVITY result ok");
    a().finish();
  }
  
  private void a(int paramInt, Intent paramIntent)
  {
    if (this.jdField_i_of_type_Int == 3) {
      super.a(1012, paramInt, paramIntent);
    }
    while ((paramInt != -1) || (paramIntent == null)) {
      return;
    }
    boolean bool1 = paramIntent.getBooleanExtra("go_publish_activity", false);
    boolean bool2 = paramIntent.getBooleanExtra("extra_directly_back", false);
    Object localObject2;
    Object localObject1;
    if (bool1)
    {
      localObject2 = paramIntent.getStringExtra("key_content");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      paramInt = paramIntent.getIntExtra("key_priv", 1);
      localObject2 = (ArrayList)paramIntent.getSerializableExtra("key_priv_uin_list");
      if (localObject2 != null) {
        break label265;
      }
      localObject2 = new ArrayList();
    }
    label265:
    for (;;)
    {
      int m = paramIntent.getIntExtra("key_font_id", -1);
      this.jdField_g_of_type_Int = paramIntent.getIntExtra("key_font_format_type", 0);
      this.jdField_e_of_type_JavaLangString = paramIntent.getStringExtra("key_font_url");
      this.jdField_h_of_type_Int = paramIntent.getIntExtra("key_super_font_id", -1);
      this.jdField_f_of_type_JavaLangString = paramIntent.getStringExtra("key_super_font_info");
      ArrayList localArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      bool1 = paramIntent.getBooleanExtra("key_timer_delete", false);
      bool2 = paramIntent.getBooleanExtra("key_sync_to_qqstory", false);
      QLog.i(jdField_c_of_type_JavaLangString, 2, "get mSetTimerDelete: " + bool1);
      QZoneHelper.publishPictureMoodSilently((String)localObject1, localArrayList, paramInt, (ArrayList)localObject2, m, this.jdField_g_of_type_Int, this.jdField_e_of_type_JavaLangString, bool1, bool2, m, this.jdField_f_of_type_JavaLangString);
      a().finish();
      return;
      if (!bool2) {
        break;
      }
      a().setResult(-1, paramIntent);
      a().finish();
      return;
    }
  }
  
  private void a(AEPhotoCaptureResult paramAEPhotoCaptureResult)
  {
    boolean bool1 = true;
    try
    {
      if (a() == null) {
        break label598;
      }
      if (a().isFinishing()) {
        return;
      }
      if ((paramAEPhotoCaptureResult == null) || (TextUtils.isEmpty(paramAEPhotoCaptureResult.jdField_a_of_type_JavaLangString)))
      {
        ToastUtil.a().a(HardCodeUtil.a(2131709808));
        a().finish();
        return;
      }
    }
    catch (Exception paramAEPhotoCaptureResult)
    {
      QLog.d(jdField_c_of_type_JavaLangString, 2, "handlePic exception", paramAEPhotoCaptureResult);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_c_of_type_JavaLangString, 2, "finishShotPhoto " + paramAEPhotoCaptureResult.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_AndroidOsBundle.getInt("edit_video_type", 0) != 10002) {}
    for (;;)
    {
      int m = this.jdField_a_of_type_AndroidOsBundle.getInt("extra.busi_type", 2);
      boolean bool2 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("go_publish_activity", false);
      if (a() != null)
      {
        if (m == 3)
        {
          double d1 = this.jdField_a_of_type_AndroidOsBundle.getDouble("key_longtitude", 4.9E-324D);
          double d2 = this.jdField_a_of_type_AndroidOsBundle.getDouble("key_latitude", 4.9E-324D);
          GpsComplementUtil.complementByLocal(paramAEPhotoCaptureResult.jdField_a_of_type_JavaLangString, d1, d2);
        }
        Intent localIntent;
        String str;
        if (bool2)
        {
          localIntent = QzoneEditPictureActivity.a(a(), paramAEPhotoCaptureResult.jdField_a_of_type_JavaLangString, bool1, m, c(), 0);
          localIntent.putExtra("TEMP_PARAM", localIntent.getLongExtra("TEMP_PARAM", 0L) & 0xFFFFFFBF & 0xFFFFFF7F);
          localIntent.putExtra("go_publish_activity", bool2);
          localIntent.putExtra("extra_directly_back", this.jdField_a_of_type_AndroidOsBundle.getBoolean("extra_directly_back", false));
          localIntent.putExtra("qcamera_photo_filepath", paramAEPhotoCaptureResult.jdField_a_of_type_JavaLangString);
          localIntent.putExtra("qcamera_rotate", paramAEPhotoCaptureResult.jdField_c_of_type_Int);
          localIntent.putExtra("PhotoConst.EDIT_COME_FROM_NEWFLOW", true);
          localIntent.putExtra("camera_type", 103);
          localIntent.putExtra("camera_capture_method", paramAEPhotoCaptureResult.jdField_a_of_type_Int);
          localIntent.putExtra("babyq_ability", this.jdField_a_of_type_AndroidOsBundle.getLong("babyq_ability", 0L));
          if (this.jdField_a_of_type_AndroidOsBundle.getInt("entry_source", 0) == 5) {
            localIntent.putExtra("pic_entrance_type", 13);
          }
          FlowCameraMqqAction.a(this.jdField_a_of_type_AndroidOsBundle.getInt("edit_video_type", -1), "", "0X8007818", null);
          paramAEPhotoCaptureResult = SplashActivity.class.getName();
          str = this.jdField_a_of_type_AndroidOsBundle.getString("f_a_a_n");
          if ((str == null) || (!str.equals(ChatActivity.class.getName()))) {
            break label595;
          }
          paramAEPhotoCaptureResult = str;
        }
        label595:
        for (;;)
        {
          NewFlowCameraReporter.a("finish");
          NewFlowCameraReporter.a(localIntent);
          str = localIntent.getStringExtra("pic_confirm_text");
          if (!TextUtils.isEmpty(str)) {
            localIntent.putExtra("extra_publish_text", str);
          }
          if (bool2) {
            localIntent.putExtra("extra_publish_text", this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().getString(2131695273));
          }
          localIntent.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", paramAEPhotoCaptureResult);
          localIntent.putExtra("key_activity_code", this.jdField_a_of_type_AndroidOsBundle.getString("key_activity_code"));
          this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().startActivityForResult(localIntent, 1012);
          FlowCameraMqqAction.a("", "0X80075C1", "", "", "", "");
          return;
          localIntent = QzoneEditPictureActivity.a(a(), paramAEPhotoCaptureResult.jdField_a_of_type_JavaLangString);
          break;
        }
      }
      label598:
      return;
      bool1 = false;
    }
  }
  
  private void a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, FlowComponentInterface paramFlowComponentInterface, String paramString5, int paramInt3, ArrayList<String> paramArrayList, boolean paramBoolean1, int paramInt4, int paramInt5, String paramString6, int paramInt6, String paramString7, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    String str = new File(paramString2).getParent();
    if (!TextUtils.isEmpty(paramString4)) {
      PtvFilterUtils.a(str, paramString4);
    }
    MediaCodecSendTask.VideoSendPublicParam localVideoSendPublicParam = new MediaCodecSendTask.VideoSendPublicParam();
    localVideoSendPublicParam.jdField_a_of_type_AndroidAppActivity = a();
    localVideoSendPublicParam.jdField_a_of_type_JavaLangString = str;
    localVideoSendPublicParam.jdField_b_of_type_JavaLangString = paramString1;
    localVideoSendPublicParam.jdField_a_of_type_Int = paramInt1;
    localVideoSendPublicParam.jdField_c_of_type_JavaLangString = paramString2;
    localVideoSendPublicParam.jdField_f_of_type_JavaLangString = paramString3;
    localVideoSendPublicParam.jdField_c_of_type_Int = 0;
    localVideoSendPublicParam.jdField_d_of_type_Int = 0;
    localVideoSendPublicParam.jdField_k_of_type_JavaLangString = paramString4;
    if (this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult == null)
    {
      ShortVideoExceptionReporter.a(new RuntimeException("videoCaptureResult == null"));
      QLog.e(jdField_c_of_type_JavaLangString, 2, "videoCaptureResult == null");
    }
    for (localVideoSendPublicParam.jdField_i_of_type_Int = 0;; localVideoSendPublicParam.jdField_i_of_type_Int = this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.videoFrameCount)
    {
      localVideoSendPublicParam.jdField_j_of_type_Int = paramInt2;
      localVideoSendPublicParam.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface = paramFlowComponentInterface;
      localVideoSendPublicParam.jdField_g_of_type_JavaLangString = paramString5;
      localVideoSendPublicParam.jdField_e_of_type_Int = paramInt3;
      localVideoSendPublicParam.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
      localVideoSendPublicParam.jdField_a_of_type_Boolean = this.k;
      localVideoSendPublicParam.jdField_j_of_type_JavaLangString = this.jdField_g_of_type_JavaLangString;
      localVideoSendPublicParam.jdField_b_of_type_Boolean = paramBoolean1;
      localVideoSendPublicParam.jdField_f_of_type_Int = paramInt4;
      localVideoSendPublicParam.jdField_g_of_type_Int = paramInt5;
      localVideoSendPublicParam.jdField_h_of_type_JavaLangString = paramString6;
      localVideoSendPublicParam.jdField_h_of_type_Int = paramInt6;
      localVideoSendPublicParam.jdField_i_of_type_JavaLangString = paramString7;
      localVideoSendPublicParam.jdField_e_of_type_Boolean = paramBoolean2;
      localVideoSendPublicParam.jdField_f_of_type_Boolean = paramBoolean3;
      localVideoSendPublicParam.jdField_g_of_type_Boolean = paramBoolean4;
      localVideoSendPublicParam.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo = this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo;
      localVideoSendPublicParam.jdField_h_of_type_Boolean = paramBoolean5;
      localVideoSendPublicParam.jdField_k_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("entry_source", 0);
      localVideoSendPublicParam.jdField_d_of_type_JavaLangString = "";
      localVideoSendPublicParam.jdField_b_of_type_Int = 0;
      localVideoSendPublicParam.jdField_e_of_type_JavaLangString = "";
      new MediaCodecSendTask(localVideoSendPublicParam).execute(new Void[0]);
      return;
    }
  }
  
  private void b(int paramInt)
  {
    if ((paramInt != -1) || (a() == null) || (a().isFinishing())) {
      return;
    }
    a().finish();
  }
  
  private void b(int paramInt, Intent paramIntent)
  {
    if (paramInt == 0) {
      B();
    }
    while ((paramInt != -1) || (paramIntent == null)) {
      return;
    }
    Object localObject2 = paramIntent.getStringExtra("key_content");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    int m = paramIntent.getIntExtra("key_priv", 1);
    localObject2 = (ArrayList)paramIntent.getSerializableExtra("key_priv_uin_list");
    if (localObject2 == null) {
      localObject2 = new ArrayList();
    }
    for (;;)
    {
      int n = paramIntent.getIntExtra("key_font_id", -1);
      this.jdField_g_of_type_Int = paramIntent.getIntExtra("key_font_format_type", 0);
      this.jdField_e_of_type_JavaLangString = paramIntent.getStringExtra("key_font_url");
      this.jdField_h_of_type_Int = paramIntent.getIntExtra("key_super_font_id", -1);
      this.jdField_f_of_type_JavaLangString = paramIntent.getStringExtra("key_super_font_info");
      boolean bool1 = paramIntent.getBooleanExtra("key_generate_gif", false);
      boolean bool2 = paramIntent.getBooleanExtra("key_timer_delete", false);
      PublishParam localPublishParam = (PublishParam)paramIntent.getParcelableExtra(PublishParam.jdField_a_of_type_JavaLangString);
      if (localPublishParam.jdField_f_of_type_Int <= 5) {}
      for (paramInt = localPublishParam.jdField_f_of_type_Int;; paramInt = 0)
      {
        int i1 = (int)localPublishParam.jdField_a_of_type_Long;
        boolean bool3 = paramIntent.getBooleanExtra("param.isUploadOrigin", false);
        a(localPublishParam.jdField_k_of_type_JavaLangString, paramInt, localPublishParam.jdField_j_of_type_JavaLangString, localPublishParam.jdField_c_of_type_JavaLangString, localPublishParam.jdField_b_of_type_JavaLangString, i1, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface, (String)localObject1, m, (ArrayList)localObject2, false, n, this.jdField_g_of_type_Int, this.jdField_e_of_type_JavaLangString, this.jdField_h_of_type_Int, this.jdField_f_of_type_JavaLangString, bool1, bool2, false, bool3);
        return;
      }
    }
  }
  
  private void b(Intent paramIntent)
  {
    int m;
    int n;
    String str1;
    int i1;
    String str2;
    if (paramIntent != null)
    {
      m = paramIntent.getIntExtra("key_font_id", -1);
      n = paramIntent.getIntExtra("key_font_format_type", 0);
      str1 = paramIntent.getStringExtra("key_font_url");
      i1 = paramIntent.getIntExtra("key_super_font_id", -1);
      str2 = paramIntent.getStringExtra("key_super_font_info");
      paramIntent = (PublishParam)paramIntent.getParcelableExtra(PublishParam.jdField_a_of_type_JavaLangString);
      if (paramIntent != null) {
        break label77;
      }
      if (QLog.isColorLevel()) {
        QLog.e("PhotoListActivity", 2, "handleQzoneEditVideoResult: publishParam == null");
      }
    }
    return;
    label77:
    a(this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.audioDataFilePath, 0, this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult.videoMp4FilePath, paramIntent.jdField_c_of_type_JavaLangString, null, (int)paramIntent.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface, null, -1, null, false, m, n, str1, i1, str2, false, false, false, false);
  }
  
  private void b(AEVideoCaptureResult paramAEVideoCaptureResult)
  {
    A();
    if (a() != null)
    {
      Intent localIntent = new Intent(a(), PreviewVideoActivity.class);
      localIntent.putExtra("from_qzone_camera", true);
      localIntent.putExtra("video_path", paramAEVideoCaptureResult.videoMp4FilePath);
      localIntent.putExtra("audio_path", paramAEVideoCaptureResult.audioDataFilePath);
      this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().startActivityForResult(localIntent, 1016);
    }
  }
  
  private int c()
  {
    int n = this.jdField_a_of_type_AndroidOsBundle.getInt("entrance_type", 99);
    int m = n;
    SessionInfo localSessionInfo;
    if (n == 100)
    {
      localSessionInfo = (SessionInfo)this.jdField_a_of_type_AndroidOsBundle.getParcelable("PhotoConst.SEND_SESSION_INFO");
      if (localSessionInfo == null) {
        break label51;
      }
    }
    label51:
    for (m = localSessionInfo.jdField_a_of_type_Int;; m = 0)
    {
      m = AIOShortVideoUtil.a(m);
      return m;
    }
  }
  
  private void c(Bundle paramBundle)
  {
    if ((a() == null) || (a().isFinishing())) {
      return;
    }
    this.jdField_g_of_type_JavaLangString = paramBundle.getString("topic_id");
    this.jdField_h_of_type_JavaLangString = paramBundle.getString("short_video_refer");
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface = new VideoComponentCallback();
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface.setRefer(this.jdField_h_of_type_JavaLangString);
    this.jdField_d_of_type_JavaLangString = paramBundle.getString("confirm_text");
    this.jdField_h_of_type_Boolean = paramBundle.getBoolean("enable_priv_list", true);
    this.jdField_i_of_type_Boolean = paramBundle.getBoolean("enable_input_text", true);
    this.j = paramBundle.getBoolean("is_qzone_vip", false);
    this.k = paramBundle.getBoolean("enable_edit_video", false);
    this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo = ((QzoneVerticalVideoTopicInfo)paramBundle.getParcelable("key_qzone_topic"));
    this.jdField_i_of_type_Int = paramBundle.getInt("entry_source", 0);
  }
  
  private void c(AEVideoCaptureResult paramAEVideoCaptureResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_c_of_type_JavaLangString, 2, "intentToEditVideoActivityFromQzone start!");
    }
    for (;;)
    {
      try
      {
        Object localObject = new Bundle();
        ((Bundle)localObject).putInt("entrance_type", c());
        ((Bundle)localObject).putString("extra_publish_text", this.jdField_d_of_type_JavaLangString);
        ((Bundle)localObject).putBoolean("enable_hw_encode", true);
        int n = 1123;
        ((Bundle)localObject).putBoolean("extra_enable_revert", true);
        ((Bundle)localObject).putBoolean("extra_enable_slow", true);
        m = n;
        if (this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo != null)
        {
          m = n;
          if (this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo.hasMusic()) {
            m = 1121;
          }
        }
        boolean bool = this.jdField_a_of_type_AndroidOsBundle.getBoolean("enable_edit_button", true);
        paramAEVideoCaptureResult = new EditTakeVideoSource(paramAEVideoCaptureResult.videoMp4FilePath, paramAEVideoCaptureResult.audioDataFilePath, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
        if (!bool) {
          break label485;
        }
        paramAEVideoCaptureResult = new EditVideoParams(3, m, paramAEVideoCaptureResult, (Bundle)localObject);
        paramAEVideoCaptureResult.jdField_a_of_type_AndroidOsBundle.putBoolean("enable_hw_encode", true);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_c_of_type_JavaLangString, 2, "intentToEditVideoActivityFromQzone startActivityForResult---> EditVideoParams params:" + paramAEVideoCaptureResult.toString() + ", recordFinish---startEdit");
        }
        if (a() != null)
        {
          if (a().isFinishing()) {
            return;
          }
          localObject = new Intent(a(), QzoneEditVideoActivity.class);
          ((Intent)localObject).putExtra(EditVideoParams.class.getName(), paramAEVideoCaptureResult);
          ((Intent)localObject).putExtra("key_font_id", this.jdField_b_of_type_Int);
          ((Intent)localObject).putExtra("op_department", "grp_qzone");
          ((Intent)localObject).putExtra("op_type", "video_edit");
          ((Intent)localObject).putExtra("topic_id", this.jdField_g_of_type_JavaLangString);
          ((Intent)localObject).putExtra("enable_priv_list", this.jdField_h_of_type_Boolean);
          ((Intent)localObject).putExtra("enable_input_text", this.jdField_i_of_type_Boolean);
          ((Intent)localObject).putExtra("stop_record_time", System.currentTimeMillis());
          ((Intent)localObject).putExtra("UseQQCameraCompression", QzoneConfig.getInstance().getConfig("PhotoAlbum", "UseQQCameraCompression", 2));
          ((Intent)localObject).putExtra("entry_source", this.jdField_a_of_type_AndroidOsBundle.getInt("entry_source", 0));
          ((Intent)localObject).putExtra("TAKE_DANCING_VIDEO", false);
          ((Intent)localObject).putExtra("key_qzone_topic", this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo);
          this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().startActivityForResult((Intent)localObject, 1011);
          this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().overridePendingTransition(0, 0);
          if (QLog.isColorLevel())
          {
            QLog.d(jdField_c_of_type_JavaLangString, 2, "intentToEditVideoActivityFromQzone ---> finish startActivityForResult");
            return;
          }
        }
      }
      catch (Exception paramAEVideoCaptureResult)
      {
        QLog.e(jdField_c_of_type_JavaLangString, 1, "intentToEditVideoActivityFromQzone exception:" + paramAEVideoCaptureResult);
      }
      return;
      label485:
      int m = 0;
    }
  }
  
  private void f(int paramInt)
  {
    if (paramInt == 0) {
      B();
    }
    while (paramInt != -1) {
      return;
    }
    C();
  }
  
  public View a()
  {
    if ((this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer != null) && (this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a() != null) && (this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().getIntent() != null))
    {
      this.jdField_a_of_type_AndroidOsBundle = this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a().getIntent().getExtras();
      c(this.jdField_a_of_type_AndroidOsBundle);
    }
    return super.a();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Activity localActivity = this.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a();
    if ((localActivity == null) || (localActivity.isFinishing())) {}
    for (;;)
    {
      return;
      switch (paramInt1)
      {
      }
      while (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface.onActivityResult(a(), paramInt1, paramInt2, paramIntent);
        return;
        a(paramInt2, paramIntent);
        continue;
        a(paramInt2);
        continue;
        b(paramInt2, paramIntent);
        continue;
        b(paramInt2);
        continue;
        f(paramInt2);
        continue;
        b(paramIntent);
      }
    }
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    try
    {
      Intent localIntent = new Intent(BaseApplicationImpl.getContext(), EditLocalVideoActivity.class);
      localIntent.putExtras(paramIntent);
      localIntent.putExtra("short_video_refer", getClass().getName());
      localIntent.putExtra("is_qzone_vip", this.j);
      localIntent.putExtra("param.topicId", this.jdField_g_of_type_JavaLangString);
      localIntent.putExtra("param.topicSyncQzone", false);
      localIntent.putExtra("extra_key_font_id", this.jdField_b_of_type_Int);
      localIntent.putExtra("extra_key_font_format_type", this.jdField_g_of_type_Int);
      localIntent.putExtra("extra_key_font_url", this.jdField_e_of_type_JavaLangString);
      localIntent.putExtra("extra_key_super_font_id", this.jdField_h_of_type_Int);
      localIntent.putExtra("extra_key_super_font_info", this.jdField_f_of_type_JavaLangString);
      localIntent.putExtra("short_video_refer", this.jdField_h_of_type_JavaLangString);
      localIntent.putExtra("set_user_callback", this.jdField_a_of_type_AndroidOsBundle.getString("set_user_callback"));
      localIntent.putExtra("key_qzone_topic", this.jdField_a_of_type_CooperationQzoneVideoQzoneVerticalVideoTopicInfo);
      ThreadManager.getUIHandler().postDelayed(new AEPituQzoneCameraUnit.1(this, localIntent), 0L);
      return;
    }
    catch (Exception paramIntent)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i(jdField_c_of_type_JavaLangString, 2, "handleOnNewIntent error ", paramIntent);
    }
  }
  
  public void h()
  {
    super.h();
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onMediaInfoChanged(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    if (this.k)
    {
      c(this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult);
      return;
    }
    b(this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult);
  }
  
  public void onPhotoCaptured(AEPhotoCaptureResult paramAEPhotoCaptureResult)
  {
    super.onPhotoCaptured(paramAEPhotoCaptureResult);
    if (this.jdField_i_of_type_Int != 3) {
      a(paramAEPhotoCaptureResult);
    }
  }
  
  public void onVideoCaptured(AEVideoCaptureResult paramAEVideoCaptureResult)
  {
    if (paramAEVideoCaptureResult != null) {}
    try
    {
      if (paramAEVideoCaptureResult.videoMp4FilePath == null)
      {
        ToastUtil.a().a(HardCodeUtil.a(2131709806));
        if (a() != null) {
          a().finish();
        }
      }
      else
      {
        this.jdField_a_of_type_DovComQqImAeCameraAEVideoCaptureResult = paramAEVideoCaptureResult;
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = new LocalMediaInfo();
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path = paramAEVideoCaptureResult.videoMp4FilePath;
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mMimeType = "video";
        MediaScanner.getInstance(BaseApplicationImpl.getContext()).queryMediaInfoAsync(this, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
        return;
      }
    }
    catch (Exception paramAEVideoCaptureResult)
    {
      QZLog.d(jdField_c_of_type_JavaLangString, 2, "onVideoCaptured exception!", paramAEVideoCaptureResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.AEPituQzoneCameraUnit
 * JD-Core Version:    0.7.0.1
 */