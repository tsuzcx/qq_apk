package cooperation.qzone;

import Override;
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
import anni;
import bceg;
import bcfe;
import bcfg;
import bcls;
import bctj;
import bgnt;
import blsb;
import blsi;
import bltm;
import bmks;
import bnpt;
import bnpu;
import bnpw;
import bnpy;
import bnqf;
import bnzd;
import com.tencent.biz.qqstory.takevideo.EditLocalGifSource;
import com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.shortvideo.PreviewVideoActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import ljj;
import mqq.app.AppRuntime;

public class QZoneVideoDownloadActivity
  extends IphoneTitleBarActivity
  implements bcfe, bcfg, bnpw
{
  public int a;
  public long a;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  Handler jdField_a_of_type_AndroidOsHandler = new bltm(this);
  public ProgressBar a;
  public TextView a;
  public URLImageView a;
  private LocalMediaInfo jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
  public String a;
  private HashMap<Integer, String> jdField_a_of_type_JavaUtilHashMap;
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
  private long jdField_d_of_type_Long;
  private String jdField_d_of_type_JavaLangString;
  public boolean d;
  private int jdField_e_of_type_Int;
  private long jdField_e_of_type_Long;
  private String jdField_e_of_type_JavaLangString;
  public boolean e;
  private long jdField_f_of_type_Long;
  private String jdField_f_of_type_JavaLangString;
  public boolean f;
  private long jdField_g_of_type_Long;
  private String jdField_g_of_type_JavaLangString;
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
  private boolean s = true;
  private boolean t = true;
  private boolean u = true;
  private boolean v = true;
  
  public static Intent a(Activity paramActivity, String paramString, ArrayList<String> paramArrayList, LocalMediaInfo paramLocalMediaInfo, long paramLong, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity.getIntent());
    Bundle localBundle = new Bundle();
    localBundle.putString("extra_publish_text", anni.a(2131711360));
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
      QQToast.a(paramActivity, anni.a(2131711364), 0).a();
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
  
  private boolean a()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("checkIsOK()=");
    if ((this.s) && (this.t) && (this.u) && (this.v)) {}
    for (boolean bool = true;; bool = false)
    {
      VideoEnvironment.a("QZoneVideoDownloadActivity", bool, null);
      if ((!this.s) || (!this.t) || (!this.u) || (!this.v)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  private boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = VideoEnvironment.e(paramQQAppInterface);
    int i1;
    if (bnpy.a(bnpt.jdField_b_of_type_Bnpt) == 2)
    {
      i1 = 0;
      paramQQAppInterface = new StringBuilder().append("isAllReady()=");
      if ((!bool2) || (i1 == 0)) {
        break label72;
      }
    }
    label72:
    for (boolean bool1 = true;; bool1 = false)
    {
      VideoEnvironment.a("QZoneVideoDownloadActivity", bool1, null);
      if ((!bool2) || (i1 == 0)) {
        break label77;
      }
      return true;
      i1 = 1;
      break;
    }
    label77:
    return false;
  }
  
  private void b(String paramString1, int paramInt, String paramString2)
  {
    if ((paramString1.startsWith("new_qq_android_native_short_video_")) && (paramInt != 0))
    {
      a(anni.a(2131711326) + a(paramInt) + "]");
      bceg.b(2, paramInt);
    }
    if ((paramString1.startsWith(bnpt.jdField_b_of_type_Bnpt.jdField_b_of_type_JavaLangString)) && (paramInt != 0))
    {
      a(anni.a(2131711238) + a(paramInt) + "]");
      bceg.b(2, paramInt);
    }
    if ((!isFinishing()) && (a(this.app)) && (a())) {
      e();
    }
    for (;;)
    {
      VideoEnvironment.a("QZoneVideoDownloadActivity", "name=" + paramString1 + ",result=" + paramInt + ",filePath=" + paramString2, null);
      return;
      VideoEnvironment.a("QZoneVideoDownloadActivity", "!isFinishing() && isAllReady(app) && checkIsOK() = false", null);
    }
  }
  
  private void c()
  {
    if ((bgnt.g(null)) && (this.app != null))
    {
      this.jdField_g_of_type_Long = 0L;
      this.jdField_f_of_type_Long = 0L;
      this.jdField_e_of_type_Long = 0L;
      this.jdField_d_of_type_Long = 0L;
      ShortVideoResourceManager.b(this.app, this);
      if (bnpy.a(bnpt.jdField_b_of_type_Bnpt) == 2)
      {
        this.t = false;
        bnpu.a().a(bnpt.jdField_b_of_type_Bnpt, this, false);
      }
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1002);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-1), anni.a(2131711338));
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-2), anni.a(2131711245));
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-2), anni.a(2131711311));
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-3), anni.a(2131711361));
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-4), anni.a(2131711327));
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-100), anni.a(2131711332));
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-101), anni.a(2131711306));
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-105), anni.a(2131711340));
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-106), "MD5为空错误");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-107), anni.a(2131711353));
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-108), "MD5校验错误");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-117), anni.a(2131711255));
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-118), anni.a(2131711231));
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-125), anni.a(2131711335));
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-126), anni.a(2131711305));
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-127), "UTF-8编码错误");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-127), "UTF-8编码错误");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-128), anni.a(2131711234));
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-1000), anni.a(2131711367));
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-1500), anni.a(2131711352));
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-1501), anni.a(2131711351));
  }
  
  private void e()
  {
    if ((getAppRuntime() == null) && (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("QZoneVideoDownloadActivity", 2, "startQZoneVideo, getAppRunime and uin are null");
      }
      QQToast.a(this, anni.a(2131711321), 0).a();
      bmks.a(null, "qzone_video_recordtrim", "1000", null);
      finish();
      return;
    }
    Object localObject2 = blsi.a();
    Object localObject1;
    Bundle localBundle;
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      localObject1 = getAppRuntime().getAccount();
      ((blsi)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject1);
      localObject1 = getIntent().getStringExtra("refer");
      QLog.i("QZoneVideoDownloadActivity", 1, "isSupportRecord=" + this.jdField_a_of_type_Boolean + ",isSupportTrim=" + this.jdField_b_of_type_Boolean + ",isPreviewVideo" + this.r + ",refer=" + (String)localObject1 + ",videoRefer=" + this.jdField_e_of_type_JavaLangString);
      localBundle = new Bundle();
      if ((!getIntent().hasExtra("support_pic")) || (getIntent().getBooleanExtra("support_pic", false))) {
        break label837;
      }
      localBundle.putBoolean("flow_camera_capture_mode", false);
      localBundle.putBoolean("flow_camera_capture_mode", false);
      label233:
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
      if (this.jdField_b_of_type_Int != 3) {
        break label859;
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
        break label889;
      }
      blsb.a(this.app, this, (blsi)localObject2, 10009, this.jdField_b_of_type_Boolean, this.jdField_f_of_type_Boolean, (String)localObject1, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_Boolean, this.jdField_h_of_type_Boolean, this.jdField_c_of_type_JavaLangString, this.jdField_i_of_type_Boolean, this.jdField_f_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.j, this.n, this.k, this.l, this.jdField_d_of_type_JavaLangString, this.m, this.o, this.p, this.jdField_b_of_type_Int, this.q, localBundle);
      bmks.a(((blsi)localObject2).jdField_a_of_type_JavaLangString, "qzone_video_recordtrim", "0", "record");
      f();
      finish();
      return;
      localObject1 = this.jdField_a_of_type_JavaLangString;
      break;
      label837:
      localBundle.putBoolean("flow_camera_capture_mode", getIntent().getBooleanExtra("flow_camera_capture_mode", true));
      break label233;
      label859:
      if (this.jdField_b_of_type_Int == 5) {
        localBundle.putBoolean("enable_local_video", getIntent().getBooleanExtra("enable_local_video", false));
      }
    }
    label889:
    if (this.jdField_b_of_type_Boolean)
    {
      blsb.a(this, (blsi)localObject2, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long, 10009, this.jdField_a_of_type_Int, (String)localObject1, this.jdField_e_of_type_JavaLangString);
      bmks.a(((blsi)localObject2).jdField_a_of_type_JavaLangString, "qzone_video_recordtrim", "1", "trim");
      finish();
      return;
    }
    if (this.r)
    {
      localObject1 = new Intent(getApplicationContext(), PreviewVideoActivity.class);
      ((Intent)localObject1).putExtra("video_source_path", this.jdField_b_of_type_JavaLangString);
      ((Intent)localObject1).putExtra("video_type", this.jdField_d_of_type_Int);
      ((Intent)localObject1).putExtra("start_time", this.jdField_b_of_type_Long);
      ((Intent)localObject1).putExtra("end_time", this.jdField_c_of_type_Long);
      ((Intent)localObject1).putExtra("encode_video_params", this.jdField_a_of_type_AndroidOsBundle);
      startActivity((Intent)localObject1);
      overridePendingTransition(2130771997, 2130772001);
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
      blsb.a(this, "", (Intent)localObject1, -1);
      finish();
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
  
  public void B_()
  {
    VideoEnvironment.a("QZoneVideoDownloadActivity", "onNetWorkNone...", null);
    this.jdField_a_of_type_AndroidWidgetProgressBar.post(new QZoneVideoDownloadActivity.2(this));
    bceg.b(3, -1500);
  }
  
  public void a()
  {
    setTitle(anni.a(2131711308));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131372690));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372689));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131372693));
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageURL("https://qzs.qq.com/qzone/photo/v7/js/common/images/mini_video_cover_7.png");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    VideoEnvironment.a("QZoneVideoDownloadActivity", "result=" + paramInt1 + ",serverError=" + paramInt2, null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0)
      {
        a(anni.a(2131711239) + a(paramInt2) + "]");
        bceg.b(1, paramInt2);
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
        VideoEnvironment.a("QZoneVideoDownloadActivity", "onConfigResult| check config success...", null);
        this.s = false;
        ShortVideoResourceManager.a(this.app, localArrayList, this);
        if (bcls.c())
        {
          this.u = false;
          ShortVideoResourceManager.b(this.app, localArrayList, this);
        }
      } while (!bcls.g());
      this.v = false;
      ShortVideoResourceManager.c(this.app, localArrayList, this);
      return;
      a(anni.a(2131711328) + a(paramInt1) + "]");
      bceg.b(1, paramInt1);
      return;
    }
    a(anni.a(2131711263) + a(paramInt2) + "]");
    bceg.b(1, paramInt2);
  }
  
  public void a(bnpt parambnpt, long paramLong1, long paramLong2)
  {
    if (parambnpt == bnpt.jdField_b_of_type_Bnpt)
    {
      this.jdField_f_of_type_Long = paramLong1;
      this.jdField_g_of_type_Long = paramLong2;
      if (this.jdField_e_of_type_Long + this.jdField_g_of_type_Long <= 0L) {
        break label147;
      }
    }
    label147:
    for (int i1 = (int)((float)(this.jdField_d_of_type_Long + this.jdField_f_of_type_Long) * 100.0F / (float)(this.jdField_e_of_type_Long + this.jdField_g_of_type_Long));; i1 = 0)
    {
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1004, i1, 0);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      VideoEnvironment.a("QZoneVideoDownloadActivity", "packageIdx=" + parambnpt.jdField_a_of_type_Int + ",totalLen=" + paramLong2 + ",curOffset=" + paramLong1 + ",localProgress=" + i1, null);
      return;
    }
  }
  
  public void a(bnpt parambnpt, String paramString, boolean paramBoolean, int paramInt)
  {
    if (parambnpt == bnpt.jdField_b_of_type_Bnpt)
    {
      if (!paramBoolean) {
        break label56;
      }
      this.t = true;
      if ((!isFinishing()) && (a(this.app)) && (a())) {
        e();
      }
    }
    else
    {
      return;
    }
    VideoEnvironment.a("QZoneVideoDownloadActivity", "!isFinishing() && isAllReady(app) && checkIsOK() = false", null);
    return;
    label56:
    a(anni.a(2131711275) + a(paramInt) + "]");
    bceg.b(2, paramInt);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    VideoEnvironment.a("QZoneVideoDownloadActivity", "onDownloadFinish| name=" + paramString1 + ",result=" + paramInt + ",filePath=" + paramString2, null);
    if (paramString1.startsWith("new_qq_android_native_short_video_")) {
      this.s = true;
    }
    for (;;)
    {
      b(paramString1, paramInt, paramString2);
      return;
      if (paramString1.startsWith("new_qq_android_native_art_filter_")) {
        this.u = true;
      } else if (paramString1.startsWith("new_qq_android_native_object_tracking_")) {
        this.v = true;
      }
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    this.jdField_d_of_type_Long = paramLong1;
    this.jdField_e_of_type_Long = paramLong2;
    if (this.jdField_e_of_type_Long + this.jdField_g_of_type_Long > 0L) {}
    for (int i1 = (int)((float)(this.jdField_d_of_type_Long + this.jdField_f_of_type_Long) * 100.0F / (float)(this.jdField_e_of_type_Long + this.jdField_g_of_type_Long));; i1 = 0)
    {
      if (paramString.startsWith("new_qq_android_native_short_video_"))
      {
        Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1004, i1, 0);
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      }
      VideoEnvironment.a("QZoneVideoDownloadActivity", "name=" + paramString + ",totalLen=" + paramLong2 + ",curOffset=" + paramLong1 + ",localProgress=" + i1, null);
      return;
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.app != null) {
      ShortVideoResourceManager.a(this.app, this);
    }
    bnpu.a().a(this);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    finish();
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
      Toast.makeText(getApplicationContext(), anni.a(2131711331), 1).show();
      bmks.a(null, "qzone_video_recordtrim", "1002", null);
      return;
    }
    this.jdField_a_of_type_Boolean = localIntent.getBooleanExtra("support_record", false);
    this.jdField_b_of_type_Boolean = localIntent.getBooleanExtra("support_trim", false);
    this.jdField_c_of_type_Boolean = localIntent.getBooleanExtra("support_edit_video", false);
    this.jdField_d_of_type_Boolean = localIntent.getBooleanExtra("support_jump_gif_chooser", false);
    this.jdField_f_of_type_Boolean = localIntent.getBooleanExtra("support_pic", false);
    this.jdField_e_of_type_Boolean = localIntent.getBooleanExtra("support_dynamic_video", false);
    this.jdField_b_of_type_Int = localIntent.getIntExtra("entry_source", 0);
    this.jdField_g_of_type_Boolean = localIntent.getBooleanExtra("is_qzone_vip", false);
    this.jdField_h_of_type_Boolean = localIntent.getBooleanExtra("enable_edit_video", false);
    this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("uin");
    this.jdField_b_of_type_JavaLangString = localIntent.getStringExtra("file_send_path");
    this.jdField_a_of_type_Long = localIntent.getLongExtra("PhotoConst.VIDEO_SIZE", 0L);
    this.jdField_a_of_type_Int = localIntent.getIntExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 2);
    this.r = localIntent.getBooleanExtra("preview_video", false);
    this.jdField_d_of_type_Int = localIntent.getIntExtra("video_type", 0);
    this.jdField_b_of_type_Long = localIntent.getLongExtra("start_time", 0L);
    this.jdField_c_of_type_Long = localIntent.getLongExtra("end_time", 0L);
    this.jdField_e_of_type_JavaLangString = localIntent.getStringExtra("video_refer");
    this.jdField_a_of_type_AndroidOsBundle = localIntent.getBundleExtra("encode_video_params");
    this.jdField_c_of_type_JavaLangString = localIntent.getStringExtra("topicId");
    this.jdField_i_of_type_Boolean = localIntent.getBooleanExtra("enterPtu", false);
    this.jdField_f_of_type_JavaLangString = localIntent.getStringExtra("callback");
    this.jdField_g_of_type_JavaLangString = localIntent.getStringExtra("dongxiao_id");
    this.n = localIntent.getBooleanExtra("enable_priv_list", true);
    this.j = localIntent.getBooleanExtra("enable_input_text", true);
    this.k = localIntent.getBooleanExtra("enable_sync_qzone", false);
    this.l = localIntent.getBooleanExtra("enable_origin_video", false);
    this.jdField_d_of_type_JavaLangString = localIntent.getStringExtra("confirm_text");
    this.m = localIntent.getBooleanExtra("enable_edit_button", true);
    this.o = localIntent.getBooleanExtra("enable_local_button", true);
    this.p = localIntent.getBooleanExtra("is_glance_video", false);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = ((LocalMediaInfo)localIntent.getSerializableExtra("gif_media_info"));
    this.jdField_e_of_type_Int = localIntent.getIntExtra("gif_photoplus_pos", -1);
    this.jdField_h_of_type_JavaLangString = localIntent.getStringExtra("gif_path");
    this.jdField_i_of_type_JavaLangString = localIntent.getStringExtra("gif_class_name");
    this.q = localIntent.getBooleanExtra("go_publish_activity", false);
    this.jdField_c_of_type_Int = localIntent.getIntExtra("isGoCreateAlbumShortcut", 0);
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface)))
    {
      int i1;
      long l1;
      Object localObject;
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        paramBundle = getAppRuntime().getAccount();
        this.jdField_a_of_type_JavaLangString = paramBundle;
        if (!localIntent.getBooleanExtra("from_qcircle", false)) {
          break label880;
        }
        i1 = localIntent.getIntExtra("key_qcircle_entrance_type", 0);
        paramBundle = new Bundle();
        paramBundle.putString("PhotoConst.INIT_ACTIVITY_CLASS_NAME", "com.tencent.qcircle.QCirclePublishFeedActivity");
        paramBundle.putString("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        paramBundle.putString("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
        paramBundle.putBoolean("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
        paramBundle.putBoolean("PhotoConst.IS_CALL_IN_PLUGIN", true);
        paramBundle.putString("PhotoConst.UIN", this.jdField_a_of_type_JavaLangString);
        l1 = System.currentTimeMillis() - getIntent().getLongExtra("PhotoConst.timestamp_last_activity", System.currentTimeMillis());
        if (l1 >= 0L)
        {
          localObject = new HashMap();
          ((HashMap)localObject).put("VideoDownloadTime", String.valueOf(l1));
          bctj.a(BaseApplicationImpl.getContext()).a(((QQAppInterface)localAppRuntime).c(), "call_pitu_camera", true, 0L, 0L, (HashMap)localObject, null, true);
          QZLog.d("QZoneVideoDownloadActivity", 1, new Object[] { "oncreate... qcircle qzone->videoDownload time cost:", Long.valueOf(System.currentTimeMillis() - getIntent().getLongExtra("PhotoConst.timestamp_last_activity", System.currentTimeMillis())) });
        }
        paramBundle.putString("qq_camera_from_qcircle_scheme", localIntent.getStringExtra("key_scheme"));
        paramBundle.putLong("PhotoConst.timestamp", localIntent.getLongExtra("PhotoConst.timestamp", System.currentTimeMillis()));
        paramBundle.putLong("PhotoConst.timestamp_last_activity", System.currentTimeMillis());
        if (i1 != 1) {
          break label854;
        }
        localIntent = new Intent();
        localIntent.putExtras(paramBundle);
        bnzd.a(this, localIntent);
      }
      for (;;)
      {
        finish();
        return;
        paramBundle = this.jdField_a_of_type_JavaLangString;
        break;
        label854:
        if (i1 == 2) {
          bnqf.a(this, paramBundle);
        } else if (i1 == 3) {
          bnqf.b(this, paramBundle);
        }
      }
      label880:
      if ((this.jdField_c_of_type_Int == 1) || (this.jdField_c_of_type_Int == 2) || (this.jdField_c_of_type_Int == 3))
      {
        paramBundle = localIntent.getStringExtra("UploadPhoto.key_album_id");
        localObject = localIntent.getStringExtra("UploadPhoto.key_album_name");
        Bitmap localBitmap = (Bitmap)localIntent.getParcelableExtra("UploadPhoto.key_album_cover");
        l1 = localIntent.getLongExtra("UploadPhoto.key_album_owner_uin", 0L);
        if (this.jdField_c_of_type_Int == 1) {
          blsb.a((QQAppInterface)localAppRuntime, paramBundle, (String)localObject, localBitmap, l1);
        }
        for (;;)
        {
          finish();
          return;
          if ((this.jdField_c_of_type_Int == 2) || (this.jdField_c_of_type_Int == 3)) {
            blsb.b((QQAppInterface)localAppRuntime, paramBundle, (String)localObject, localBitmap, l1);
          }
        }
      }
      if (((QQAppInterface)localAppRuntime).d())
      {
        Toast.makeText(getApplicationContext(), anni.a(2131711323), 1).show();
        bmks.a(this.jdField_a_of_type_JavaLangString, "qzone_video_recordtrim", "1003", null);
        finish();
        return;
      }
      if (ljj.b(BaseApplicationImpl.getContext()))
      {
        bmks.a(this.jdField_a_of_type_JavaLangString, "qzone_video_recordtrim", "1004", null);
        finish();
        return;
      }
      if (!a((QQAppInterface)localAppRuntime))
      {
        setContentView(2131563107);
        a();
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        d();
        c();
        return;
      }
      if (this.jdField_e_of_type_Boolean)
      {
        setContentView(2131563107);
        a();
      }
    }
    for (;;)
    {
      e();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QZoneVideoDownloadActivity", 2, "app is not QQAppInterface");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QZoneVideoDownloadActivity
 * JD-Core Version:    0.7.0.1
 */