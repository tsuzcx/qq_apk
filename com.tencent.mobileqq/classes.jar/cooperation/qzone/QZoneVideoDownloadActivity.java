package cooperation.qzone;

import amzu;
import amzv;
import amzx;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
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
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ShortVideoErrorReport;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager.INet_ShortVideoResource;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceStatus.ISVConfig;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public class QZoneVideoDownloadActivity
  extends IphoneTitleBarActivity
  implements ShortVideoResourceManager.INet_ShortVideoResource, ShortVideoResourceStatus.ISVConfig
{
  public int a;
  public long a;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  Handler jdField_a_of_type_AndroidOsHandler = new amzu(this);
  public ProgressBar a;
  public TextView a;
  public URLImageView a;
  private LocalMediaInfo jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
  public String a;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public boolean a;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  public String b;
  public boolean b;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  public boolean c;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  public boolean d;
  private String e;
  public boolean e;
  private String f;
  public boolean f;
  private String g;
  public boolean g;
  private String h;
  public boolean h;
  private String jdField_i_of_type_JavaLangString;
  private boolean jdField_i_of_type_Boolean;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m;
  private boolean n;
  private boolean o;
  private boolean p;
  private boolean q;
  private boolean r;
  
  public static Intent a(Activity paramActivity, String paramString, ArrayList paramArrayList, LocalMediaInfo paramLocalMediaInfo, long paramLong, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity.getIntent());
    Bundle localBundle = new Bundle();
    localBundle.putString("extra_publish_text", "确认");
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
      QQToast.a(paramActivity, "参数错误", 0).a();
    }
    return null;
  }
  
  private String a(int paramInt)
  {
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      localObject = String.valueOf(paramInt);
    }
    String str;
    do
    {
      return localObject;
      str = (String)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    return String.valueOf(paramInt);
  }
  
  private void a(String paramString)
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1002);
    localMessage.obj = paramString;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  private boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool = VideoEnvironment.e(paramQQAppInterface);
    if (PtvFilterSoLoad.a(BaseApplicationImpl.getContext()) == 2) {}
    for (int i1 = 0; (bool) && (i1 != 0); i1 = 1) {
      return true;
    }
    return false;
  }
  
  private void b(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1.startsWith("new_qq_android_native_short_video_"))
    {
      if (paramInt != 0)
      {
        a("短视频插件下载失败[" + a(paramInt) + "]");
        ShortVideoErrorReport.b(2, paramInt);
      }
    }
    else if (paramString1.startsWith("new_qq_android_native_short_filter_"))
    {
      if (paramInt == 0) {
        break label181;
      }
      a("挂件资源下载失败[" + a(paramInt) + "]");
      ShortVideoErrorReport.b(2, paramInt);
    }
    for (;;)
    {
      VideoEnvironment.a("QZoneVideoDownloadActivity", "name=" + paramString1 + ",result=" + paramInt + ",filePath=" + paramString2, null);
      return;
      if ((!isFinishing()) && (a(this.app)))
      {
        e();
        break;
      }
      VideoEnvironment.a("QZoneVideoDownloadActivity", "isFinishing= true", null);
      break;
      label181:
      if ((!isFinishing()) && (a(this.app))) {
        e();
      } else {
        VideoEnvironment.a("QZoneVideoDownloadActivity", "isFinishing= true", null);
      }
    }
  }
  
  private void c()
  {
    if ((NetworkUtil.g(null)) && (this.app != null))
    {
      ShortVideoResourceManager.a(this.app, this);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1002);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-1), "未知错误");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-2), "配置版本错误");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-2), "配置版本错误");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-3), "重命名验证错误");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-4), "文件名验证错误");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-100), "解析配置错误");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-101), "配置文件为空");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-105), "路径错误");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-106), "MD5为空错误");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-107), "资源错误");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-108), "MD5校验错误");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-117), "下载错误");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-118), "解压错误");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-125), "配置信息错误");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-126), "解压错误");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-127), "UTF-8编码错误");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-127), "UTF-8编码错误");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-128), "配置存储错误");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-1000), "不支持下载");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-1500), "下载中断");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-1501), "AppInterface 参数为空");
  }
  
  private void e()
  {
    if ((getAppRuntime() == null) && (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("QZoneVideoDownloadActivity", 2, "startQZoneVideo, getAppRunime and uin are null");
      }
      QQToast.a(this, "短视频启动失败", 0).a();
      QzoneVideoBeaconReport.a(null, "qzone_video_recordtrim", "1000", null);
      finish();
      return;
    }
    Object localObject2 = QZoneHelper.UserInfo.a();
    Object localObject1;
    Bundle localBundle;
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      localObject1 = getAppRuntime().getAccount();
      ((QZoneHelper.UserInfo)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject1);
      localObject1 = getIntent().getStringExtra("refer");
      QLog.i("QZoneVideoDownloadActivity", 1, "isSupportRecord=" + this.jdField_a_of_type_Boolean + ",isSupportTrim=" + this.jdField_b_of_type_Boolean + ",isPreviewVideo" + this.r + ",refer=" + (String)localObject1 + ",videoRefer=" + this.jdField_e_of_type_JavaLangString);
      localBundle = new Bundle();
      if ((!getIntent().hasExtra("support_pic")) || (getIntent().getBooleanExtra("support_pic", false))) {
        break label784;
      }
      localBundle.putBoolean("flow_camera_capture_mode", false);
      localBundle.putBoolean("flow_camera_capture_mode", false);
      label230:
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
      if (this.jdField_b_of_type_Int != 3) {
        break label806;
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
      if (!this.jdField_a_of_type_Boolean) {
        break label836;
      }
      QZoneHelper.a(this.app, this, (QZoneHelper.UserInfo)localObject2, 10009, this.jdField_b_of_type_Boolean, this.jdField_f_of_type_Boolean, (String)localObject1, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_Boolean, this.jdField_h_of_type_Boolean, this.jdField_c_of_type_JavaLangString, this.jdField_i_of_type_Boolean, this.jdField_f_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.j, this.n, this.k, this.l, this.jdField_d_of_type_JavaLangString, this.m, this.o, this.p, this.jdField_b_of_type_Int, this.q, localBundle);
      QzoneVideoBeaconReport.a(((QZoneHelper.UserInfo)localObject2).jdField_a_of_type_JavaLangString, "qzone_video_recordtrim", "0", "record");
      f();
      finish();
      return;
      localObject1 = this.jdField_a_of_type_JavaLangString;
      break;
      label784:
      localBundle.putBoolean("flow_camera_capture_mode", getIntent().getBooleanExtra("flow_camera_capture_mode", true));
      break label230;
      label806:
      if (this.jdField_b_of_type_Int == 5) {
        localBundle.putBoolean("enable_local_video", getIntent().getBooleanExtra("enable_local_video", false));
      }
    }
    label836:
    if (this.jdField_b_of_type_Boolean)
    {
      QZoneHelper.a(this, (QZoneHelper.UserInfo)localObject2, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long, 10009, this.jdField_a_of_type_Int, (String)localObject1, this.jdField_e_of_type_JavaLangString);
      QzoneVideoBeaconReport.a(((QZoneHelper.UserInfo)localObject2).jdField_a_of_type_JavaLangString, "qzone_video_recordtrim", "1", "trim");
      finish();
      return;
    }
    if (this.r)
    {
      localObject1 = new Intent(getApplicationContext(), PreviewVideoActivity.class);
      ((Intent)localObject1).putExtra("video_source_path", this.jdField_b_of_type_JavaLangString);
      ((Intent)localObject1).putExtra("video_type", this.jdField_c_of_type_Int);
      ((Intent)localObject1).putExtra("start_time", this.jdField_b_of_type_Long);
      ((Intent)localObject1).putExtra("end_time", this.jdField_c_of_type_Long);
      ((Intent)localObject1).putExtra("encode_video_params", this.jdField_a_of_type_AndroidOsBundle);
      startActivity((Intent)localObject1);
      overridePendingTransition(2131034134, 2131034135);
      finish();
      return;
    }
    if (this.jdField_c_of_type_Boolean)
    {
      localObject1 = (ArrayList)getIntent().getSerializableExtra("PhotoConst.GIF_PHOTO_PATHS");
      int i1 = getIntent().getIntExtra("PhotoConst.GIF_DELAY", 150);
      localObject1 = a(this, this.jdField_h_of_type_JavaLangString, (ArrayList)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, i1, 3);
      if (localObject1 != null)
      {
        ((Intent)localObject1).setClass(getApplicationContext(), EditVideoActivity.class);
        ((Intent)localObject1).putExtras(getIntent());
        QzonePluginProxyActivity.a((Intent)localObject1, this.jdField_i_of_type_JavaLangString);
        ((Intent)localObject1).putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", this.jdField_i_of_type_JavaLangString);
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
    if (this.jdField_d_of_type_Boolean)
    {
      localObject1 = getIntent();
      localObject2 = getIntent().getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME");
      ((Intent)localObject1).setClassName(getIntent().getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME"), (String)localObject2);
      ((Intent)localObject1).addFlags(603979776);
      QZoneHelper.a(this, "", (Intent)localObject1, -1);
      finish();
      return;
    }
    if (this.jdField_e_of_type_Boolean)
    {
      ThreadManager.postImmediately(new amzv(this), null, false);
      return;
    }
    finish();
  }
  
  private void f()
  {
    switch (this.jdField_b_of_type_Int)
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
  
  public void C_()
  {
    VideoEnvironment.a("QZoneVideoDownloadActivity", "onNetWorkNone...", null);
    this.jdField_a_of_type_AndroidWidgetProgressBar.post(new amzx(this));
    ShortVideoErrorReport.b(3, -1500);
  }
  
  public void a()
  {
    setTitle("短视频");
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131375624));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131375623));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131375625));
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageURL("http://qzs.qq.com/qzone/photo/v7/js/common/images/mini_video_cover_7.png");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    VideoEnvironment.a("QZoneVideoDownloadActivity", "result=" + paramInt1 + ",serverError=" + paramInt2, null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0)
      {
        a("短视频配置解压失败[" + a(paramInt2) + "]");
        ShortVideoErrorReport.b(1, paramInt2);
        return;
      }
      ArrayList localArrayList = new ArrayList(1);
      paramInt1 = ShortVideoResourceManager.a(this.app, localArrayList);
      if (paramInt1 == 0)
      {
        ShortVideoResourceManager.a(this.app, localArrayList, this);
        if (PtvFilterSoLoad.a(VideoEnvironment.a()) == 2)
        {
          ShortVideoResourceManager.b(this.app, localArrayList, this);
          return;
        }
        VideoEnvironment.a("QZoneVideoDownloadActivity", "onConfigResult| getFilterSoState != 2", null);
        return;
      }
      a("短视频配置校验失败[" + a(paramInt1) + "]");
      ShortVideoErrorReport.b(1, paramInt1);
      return;
    }
    a("短视频配置下载失败[" + a(paramInt2) + "]");
    ShortVideoErrorReport.b(1, paramInt2);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    b(paramString1, paramInt, paramString2);
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    int i1 = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    if (paramString.startsWith("new_qq_android_native_short_video_"))
    {
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1004, i1, 0);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
    }
    for (;;)
    {
      VideoEnvironment.a("QZoneVideoDownloadActivity", "name=" + paramString + ",totalLen=" + paramLong2 + ",curOffset=" + paramLong1 + ",localProgress=" + i1, null);
      return;
      if (!paramString.startsWith("new_qq_android_native_short_filter_")) {}
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.app != null)
    {
      ShortVideoResourceManager.a(this.app, this);
      ShortVideoResourceManager.b(this.app, this);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().getDecorView().setBackgroundColor(-16777216);
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      Toast.makeText(getApplicationContext(), "参数错误，无法启动", 1).show();
      QzoneVideoBeaconReport.a(null, "qzone_video_recordtrim", "1002", null);
      return;
    }
    this.jdField_a_of_type_Boolean = paramBundle.getBooleanExtra("support_record", false);
    this.jdField_b_of_type_Boolean = paramBundle.getBooleanExtra("support_trim", false);
    this.jdField_c_of_type_Boolean = paramBundle.getBooleanExtra("support_edit_video", false);
    this.jdField_d_of_type_Boolean = paramBundle.getBooleanExtra("support_jump_gif_chooser", false);
    this.jdField_f_of_type_Boolean = paramBundle.getBooleanExtra("support_pic", false);
    this.jdField_e_of_type_Boolean = paramBundle.getBooleanExtra("support_dynamic_video", false);
    this.jdField_b_of_type_Int = paramBundle.getIntExtra("entry_source", 0);
    this.jdField_g_of_type_Boolean = paramBundle.getBooleanExtra("is_qzone_vip", false);
    this.jdField_h_of_type_Boolean = paramBundle.getBooleanExtra("enable_edit_video", false);
    this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("uin");
    this.jdField_b_of_type_JavaLangString = paramBundle.getStringExtra("file_send_path");
    this.jdField_a_of_type_Long = paramBundle.getLongExtra("PhotoConst.VIDEO_SIZE", 0L);
    this.jdField_a_of_type_Int = paramBundle.getIntExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 2);
    this.r = paramBundle.getBooleanExtra("preview_video", false);
    this.jdField_c_of_type_Int = paramBundle.getIntExtra("video_type", 0);
    this.jdField_b_of_type_Long = paramBundle.getLongExtra("start_time", 0L);
    this.jdField_c_of_type_Long = paramBundle.getLongExtra("end_time", 0L);
    this.jdField_e_of_type_JavaLangString = paramBundle.getStringExtra("video_refer");
    this.jdField_a_of_type_AndroidOsBundle = paramBundle.getBundleExtra("encode_video_params");
    this.jdField_c_of_type_JavaLangString = paramBundle.getStringExtra("topicId");
    this.jdField_i_of_type_Boolean = paramBundle.getBooleanExtra("enterPtu", false);
    this.jdField_f_of_type_JavaLangString = paramBundle.getStringExtra("callback");
    this.jdField_g_of_type_JavaLangString = paramBundle.getStringExtra("dongxiao_id");
    this.n = paramBundle.getBooleanExtra("enable_priv_list", true);
    this.j = paramBundle.getBooleanExtra("enable_input_text", true);
    this.k = paramBundle.getBooleanExtra("enable_sync_qzone", false);
    this.l = paramBundle.getBooleanExtra("enable_origin_video", false);
    this.jdField_d_of_type_JavaLangString = paramBundle.getStringExtra("confirm_text");
    this.m = paramBundle.getBooleanExtra("enable_edit_button", true);
    this.o = paramBundle.getBooleanExtra("enable_local_button", true);
    this.p = paramBundle.getBooleanExtra("is_glance_video", false);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = ((LocalMediaInfo)paramBundle.getSerializableExtra("gif_media_info"));
    this.jdField_d_of_type_Int = paramBundle.getIntExtra("gif_photoplus_pos", -1);
    this.jdField_h_of_type_JavaLangString = paramBundle.getStringExtra("gif_path");
    this.jdField_i_of_type_JavaLangString = paramBundle.getStringExtra("gif_class_name");
    this.q = paramBundle.getBooleanExtra("go_publish_activity", false);
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface)))
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
      for (paramBundle = getAppRuntime().getAccount();; paramBundle = this.jdField_a_of_type_JavaLangString)
      {
        this.jdField_a_of_type_JavaLangString = paramBundle;
        if (!((QQAppInterface)localAppRuntime).c()) {
          break;
        }
        Toast.makeText(getApplicationContext(), "正在通话中，请结束通话后再试", 1).show();
        QzoneVideoBeaconReport.a(this.jdField_a_of_type_JavaLangString, "qzone_video_recordtrim", "1003", null);
        finish();
        return;
      }
      if (QavCameraUsage.b(BaseApplicationImpl.getContext()))
      {
        QzoneVideoBeaconReport.a(this.jdField_a_of_type_JavaLangString, "qzone_video_recordtrim", "1004", null);
        finish();
        return;
      }
      if (!a((QQAppInterface)localAppRuntime))
      {
        setContentView(2130971776);
        a();
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        d();
        c();
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("QZoneVideoDownloadActivity", 2, "app is not QQAppInterface");
    }
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.QZoneVideoDownloadActivity
 * JD-Core Version:    0.7.0.1
 */