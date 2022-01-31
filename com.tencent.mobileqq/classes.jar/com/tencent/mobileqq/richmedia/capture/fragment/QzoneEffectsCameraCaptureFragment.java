package com.tencent.mobileqq.richmedia.capture.fragment;

import ahow;
import ahox;
import ahoy;
import ahoz;
import ahpa;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.EditPicActivity;
import com.tencent.biz.qqstory.takevideo.EditTakeGifSource;
import com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import com.tencent.biz.qqstory.takevideo.EditVideoActivity;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;
import com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import com.tencent.mobileqq.activity.richmedia.FlowComponentInterface;
import com.tencent.mobileqq.activity.richmedia.MediaCodecSendTask;
import com.tencent.mobileqq.activity.richmedia.MediaCodecSendTask.VideoSendPublicParam;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter;
import com.tencent.mobileqq.activity.richmedia.NewFlowEditVideoActivity;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.activity.shortvideo.PreviewVideoActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.util.CameraHelper;
import com.tencent.mobileqq.richmedia.capture.util.ReportUtil;
import com.tencent.mobileqq.richmedia.capture.util.SVParamManager;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureButtonLayout;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.CaptureParam;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.PhotoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.ProviderContainerView;
import com.tencent.mobileqq.richmedia.mediacodec.utils.MediaUtil;
import com.tencent.mobileqq.richmedia.mediacodec.utils.ShortVideoExceptionReporter;
import com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.GpsComplementUtil;
import cooperation.qzone.util.gifCoderWnsConfig;
import cooperation.qzone.video.VideoComponentCallback;
import java.io.File;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class QzoneEffectsCameraCaptureFragment
  extends EffectsCameraCaptureFragment
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = -1;
  private ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private LocalMediaInfo jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
  private FlowComponentInterface jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface;
  private CameraCaptureView.VideoCaptureResult jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult;
  private int c;
  private int d;
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString;
  private String f;
  private String g;
  private String h;
  private String jdField_i_of_type_JavaLangString;
  private boolean jdField_i_of_type_Boolean;
  private String jdField_j_of_type_JavaLangString;
  private boolean jdField_j_of_type_Boolean;
  private String jdField_k_of_type_JavaLangString;
  private boolean jdField_k_of_type_Boolean;
  private String jdField_l_of_type_JavaLangString;
  private boolean jdField_l_of_type_Boolean;
  private String jdField_m_of_type_JavaLangString;
  private boolean jdField_m_of_type_Boolean;
  private String jdField_n_of_type_JavaLangString;
  private boolean jdField_n_of_type_Boolean;
  private boolean o;
  private boolean p;
  private boolean q;
  private boolean r;
  private boolean s;
  private boolean t;
  private boolean u;
  private boolean v;
  private boolean w;
  
  /* Error */
  private Bitmap a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_1
    //   7: ifnonnull +9 -> 16
    //   10: aconst_null
    //   11: astore 5
    //   13: aload 5
    //   15: areturn
    //   16: aload_1
    //   17: invokevirtual 53	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   20: astore 6
    //   22: aload 6
    //   24: getstatic 59	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   27: aconst_null
    //   28: aconst_null
    //   29: aconst_null
    //   30: aconst_null
    //   31: invokevirtual 65	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   34: astore_1
    //   35: aload_1
    //   36: ifnull +232 -> 268
    //   39: aload_1
    //   40: invokeinterface 71 1 0
    //   45: istore_3
    //   46: iload_3
    //   47: ifeq +221 -> 268
    //   50: aload_1
    //   51: aload_1
    //   52: ldc 73
    //   54: invokeinterface 77 2 0
    //   59: invokeinterface 81 2 0
    //   64: istore_2
    //   65: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   68: ifeq +28 -> 96
    //   71: ldc 88
    //   73: iconst_2
    //   74: new 90	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   81: ldc 93
    //   83: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: iload_2
    //   87: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   90: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokestatic 107	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   96: aload 6
    //   98: iload_2
    //   99: i2l
    //   100: iconst_3
    //   101: aconst_null
    //   102: invokestatic 113	android/provider/MediaStore$Video$Thumbnails:getThumbnail	(Landroid/content/ContentResolver;JILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   105: astore 4
    //   107: aload 4
    //   109: ifnull +16 -> 125
    //   112: aload_1
    //   113: ifnull +9 -> 122
    //   116: aload_1
    //   117: invokeinterface 116 1 0
    //   122: aload 4
    //   124: areturn
    //   125: aload_1
    //   126: invokeinterface 119 1 0
    //   131: istore_3
    //   132: iload_3
    //   133: ifne +128 -> 261
    //   136: aload 4
    //   138: astore 5
    //   140: aload_1
    //   141: ifnull -128 -> 13
    //   144: aload_1
    //   145: invokeinterface 116 1 0
    //   150: aload 4
    //   152: areturn
    //   153: astore 5
    //   155: aconst_null
    //   156: astore_1
    //   157: aload 5
    //   159: invokevirtual 122	java/lang/Exception:printStackTrace	()V
    //   162: aload_1
    //   163: astore 5
    //   165: aload 4
    //   167: ifnull -154 -> 13
    //   170: aload 4
    //   172: invokeinterface 116 1 0
    //   177: aload_1
    //   178: areturn
    //   179: astore 4
    //   181: aconst_null
    //   182: astore_1
    //   183: aload_1
    //   184: ifnull +9 -> 193
    //   187: aload_1
    //   188: invokeinterface 116 1 0
    //   193: aload 4
    //   195: athrow
    //   196: astore 4
    //   198: goto -15 -> 183
    //   201: astore 5
    //   203: aload 4
    //   205: astore_1
    //   206: aload 5
    //   208: astore 4
    //   210: goto -27 -> 183
    //   213: astore 5
    //   215: aconst_null
    //   216: astore 6
    //   218: aload_1
    //   219: astore 4
    //   221: aload 6
    //   223: astore_1
    //   224: goto -67 -> 157
    //   227: astore 5
    //   229: aload_1
    //   230: astore 6
    //   232: aload 4
    //   234: astore_1
    //   235: aload 6
    //   237: astore 4
    //   239: goto -82 -> 157
    //   242: astore 4
    //   244: aload_1
    //   245: astore 6
    //   247: aload 5
    //   249: astore_1
    //   250: aload 4
    //   252: astore 5
    //   254: aload 6
    //   256: astore 4
    //   258: goto -101 -> 157
    //   261: aload 4
    //   263: astore 5
    //   265: goto -215 -> 50
    //   268: aconst_null
    //   269: astore 4
    //   271: goto -135 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	274	0	this	QzoneEffectsCameraCaptureFragment
    //   0	274	1	paramContext	android.content.Context
    //   64	35	2	i1	int
    //   45	88	3	bool	boolean
    //   1	170	4	localBitmap1	Bitmap
    //   179	15	4	localObject1	Object
    //   196	8	4	localObject2	Object
    //   208	30	4	localObject3	Object
    //   242	9	4	localException1	Exception
    //   256	14	4	localObject4	Object
    //   4	135	5	localBitmap2	Bitmap
    //   153	5	5	localException2	Exception
    //   163	1	5	localContext	android.content.Context
    //   201	6	5	localObject5	Object
    //   213	1	5	localException3	Exception
    //   227	21	5	localException4	Exception
    //   252	12	5	localObject6	Object
    //   20	235	6	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   22	35	153	java/lang/Exception
    //   22	35	179	finally
    //   39	46	196	finally
    //   50	96	196	finally
    //   96	107	196	finally
    //   125	132	196	finally
    //   157	162	201	finally
    //   39	46	213	java/lang/Exception
    //   125	132	227	java/lang/Exception
    //   50	96	242	java/lang/Exception
    //   96	107	242	java/lang/Exception
  }
  
  private void a(int paramInt, Intent paramIntent)
  {
    if (paramInt == 0)
    {
      o();
      a("608", "2", "0", true);
    }
    while ((paramInt != -1) || (paramIntent == null)) {
      return;
    }
    Object localObject2 = paramIntent.getStringExtra("key_content");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    int i1 = paramIntent.getIntExtra("key_priv", 1);
    localObject2 = (ArrayList)paramIntent.getSerializableExtra("key_priv_uin_list");
    if (localObject2 == null) {
      localObject2 = new ArrayList();
    }
    for (;;)
    {
      this.jdField_i_of_type_Boolean = paramIntent.getBooleanExtra("key_topic_sync_qzone", this.jdField_i_of_type_Boolean);
      int i2 = paramIntent.getIntExtra("key_font_id", -1);
      this.jdField_c_of_type_Int = paramIntent.getIntExtra("key_font_format_type", 0);
      this.jdField_i_of_type_JavaLangString = paramIntent.getStringExtra("key_font_url");
      this.jdField_d_of_type_Int = paramIntent.getIntExtra("key_super_font_id", -1);
      this.jdField_j_of_type_JavaLangString = paramIntent.getStringExtra("key_super_font_info");
      boolean bool1 = paramIntent.getBooleanExtra("key_generate_gif", false);
      boolean bool2 = paramIntent.getBooleanExtra("key_timer_delete", false);
      boolean bool3 = paramIntent.getBooleanExtra("key_sync_to_qqstory", false);
      paramIntent = (PublishParam)paramIntent.getParcelableExtra(PublishParam.jdField_a_of_type_JavaLangString);
      if (paramIntent.jdField_f_of_type_Int <= 5) {}
      for (paramInt = paramIntent.jdField_f_of_type_Int;; paramInt = 0)
      {
        int i3 = (int)paramIntent.jdField_a_of_type_Long;
        a(paramIntent.jdField_k_of_type_JavaLangString, paramInt, paramIntent.jdField_j_of_type_JavaLangString, paramIntent.jdField_c_of_type_JavaLangString, paramIntent.jdField_b_of_type_JavaLangString, i3, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface, (String)localObject1, i1, (ArrayList)localObject2, this.jdField_i_of_type_Boolean, i2, this.jdField_c_of_type_Int, this.jdField_i_of_type_JavaLangString, this.jdField_d_of_type_Int, this.jdField_j_of_type_JavaLangString, bool1, bool2, bool3);
        this.q = true;
        return;
      }
    }
  }
  
  private void a(Bundle paramBundle)
  {
    if ((getActivity() == null) || (getActivity().isFinishing())) {
      return;
    }
    this.jdField_e_of_type_JavaLangString = paramBundle.getString("topic_id");
    this.jdField_f_of_type_JavaLangString = paramBundle.getString("short_video_refer");
    a(paramBundle, this.jdField_f_of_type_JavaLangString);
    this.jdField_j_of_type_Boolean = paramBundle.getBoolean("is_glance_video", false);
    this.jdField_g_of_type_JavaLangString = paramBundle.getString("confirm_text");
    this.jdField_k_of_type_Boolean = paramBundle.getBoolean("enable_priv_list", true);
    this.jdField_l_of_type_Boolean = paramBundle.getBoolean("enable_input_text", true);
    this.jdField_m_of_type_Boolean = paramBundle.getBoolean("enable_sync_qzone", false);
    this.jdField_n_of_type_Boolean = paramBundle.getBoolean("is_qzone_vip", false);
    this.jdField_h_of_type_JavaLangString = getActivity().getAppRuntime().getAccount();
    this.o = paramBundle.getBoolean("enable_edit_video", false);
    this.p = this.jdField_a_of_type_AndroidOsBundle.getBoolean("enable_local_video", false);
    if (this.jdField_j_of_type_Boolean) {
      this.p = false;
    }
    this.w = paramBundle.getBoolean("enter_ptu", false);
    this.t = this.jdField_a_of_type_AndroidOsBundle.getBoolean("PeakConstants.ARG_SUPPORT_FILTER", true);
    this.u = this.jdField_a_of_type_AndroidOsBundle.getBoolean("PeakConstants.ARG_SUPPORT_DD", true);
    this.v = this.jdField_a_of_type_AndroidOsBundle.getBoolean("PeakConstants.ARG_BEAUTY", true);
    this.jdField_e_of_type_Boolean = this.t;
    this.jdField_f_of_type_Boolean = this.u;
    this.jdField_d_of_type_Boolean = this.v;
    this.r = this.jdField_a_of_type_AndroidOsBundle.getBoolean("PeakConstants.ARG_UNFOLD_DD", false);
    this.jdField_k_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("PeakConstants.ARG_DD_CATEGORY_NAME");
    this.jdField_l_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("PeakConstants.ARG_DD_ITEM_ID");
    if (this.w == true) {
      this.r = true;
    }
    this.s = this.jdField_a_of_type_AndroidOsBundle.getBoolean("PeakConstants.ARG_UNFOLD_FILTER", false);
    this.jdField_m_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("PeakConstants.ARG_FILTER_CATEGORY_NAME");
    this.jdField_n_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("PeakConstants.ARG_FILTER_ITEM_ID");
    this.jdField_e_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("PeakConstants.ARG_FORCE_CAMERA", 0);
    if ((this.jdField_j_of_type_Boolean) || (!this.o)) {
      this.jdField_g_of_type_Boolean = false;
    }
    this.jdField_c_of_type_Boolean = false;
  }
  
  private void a(Bundle paramBundle, String paramString)
  {
    paramBundle = paramBundle.getString("set_user_callback");
    if (paramBundle == null) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          paramBundle = Class.forName(paramBundle).newInstance();
          if ((paramBundle instanceof FlowComponentInterface))
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface = ((FlowComponentInterface)paramBundle);
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface.c_(paramString);
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface instanceof VideoComponentCallback))
            {
              ((VideoComponentCallback)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface).a(this);
              return;
            }
          }
        }
        catch (Throwable paramBundle)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface = null;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("QzoneEffectsCameraCaptureFragment", 2, "initComponentParamData:exp =" + paramBundle);
  }
  
  private void a(String paramString)
  {
    if ((getActivity() == null) || (getActivity().isFinishing())) {
      return;
    }
    Intent localIntent = new Intent(getActivity(), EditVideoActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putString("extra_publish_text", "确认");
    paramString = new EditVideoParams(3, 4109, new EditTakeGifSource(paramString, null, null), localBundle);
    localIntent.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", NewFlowCameraActivity.class.getName());
    localIntent.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    localIntent.putExtra(EditVideoParams.class.getName(), paramString);
    localIntent.putExtra("op_type", "gif_edit");
    localIntent.putExtra("op_department", "grp_qzone");
    localIntent.putExtra("PhotoConst.PLUGIN_APK", "qzone_plugin.apk");
    localIntent.putExtra("DirectBackToQzone", true);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.publish.ui.activity.QZonePublishMoodActivity");
    startActivityForResult(localIntent, 1014);
  }
  
  private String b()
  {
    String str = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + Environment.DIRECTORY_DCIM + File.separator + "Camera";
    File localFile = new File(str + File.separator + "gif");
    if ((localFile.exists()) && (!localFile.isDirectory())) {
      localFile.delete();
    }
    if (!localFile.exists()) {
      localFile.mkdir();
    }
    return str + File.separator + "gif" + File.separator + System.currentTimeMillis() + ".gif";
  }
  
  private void b(int paramInt)
  {
    if (paramInt == -1) {
      s();
    }
  }
  
  private void b(int paramInt, Intent paramIntent)
  {
    boolean bool1;
    boolean bool2;
    Object localObject2;
    Object localObject1;
    if ((paramInt == -1) && (paramIntent != null))
    {
      bool1 = paramIntent.getBooleanExtra("go_publish_activity", false);
      bool2 = paramIntent.getBooleanExtra("extra_directly_back", false);
      if (!bool1) {
        break label242;
      }
      localObject2 = paramIntent.getStringExtra("key_content");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      paramInt = paramIntent.getIntExtra("key_priv", 1);
      localObject2 = (ArrayList)paramIntent.getSerializableExtra("key_priv_uin_list");
      if (localObject2 != null) {
        break label264;
      }
      localObject2 = new ArrayList();
    }
    label264:
    for (;;)
    {
      this.jdField_i_of_type_Boolean = paramIntent.getBooleanExtra("key_topic_sync_qzone", this.jdField_i_of_type_Boolean);
      int i1 = paramIntent.getIntExtra("key_font_id", -1);
      this.jdField_c_of_type_Int = paramIntent.getIntExtra("key_font_format_type", 0);
      this.jdField_i_of_type_JavaLangString = paramIntent.getStringExtra("key_font_url");
      this.jdField_d_of_type_Int = paramIntent.getIntExtra("key_super_font_id", -1);
      this.jdField_j_of_type_JavaLangString = paramIntent.getStringExtra("key_super_font_info");
      ArrayList localArrayList = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      bool1 = paramIntent.getBooleanExtra("key_timer_delete", false);
      bool2 = paramIntent.getBooleanExtra("key_sync_to_qqstory", false);
      QLog.i("QzoneEffectsCameraCaptureFragment", 2, "get mSetTimerDelete: " + bool1);
      QZoneHelper.a((String)localObject1, localArrayList, paramInt, (ArrayList)localObject2, i1, this.jdField_c_of_type_Int, this.jdField_i_of_type_JavaLangString, bool1, bool2, i1, this.jdField_j_of_type_JavaLangString);
      getActivity().finish();
      label242:
      do
      {
        return;
      } while (!bool2);
      getActivity().setResult(-1, paramIntent);
      getActivity().finish();
      return;
    }
  }
  
  private void b(Intent paramIntent)
  {
    try
    {
      Intent localIntent = new Intent(BaseApplicationImpl.getContext(), EditLocalVideoActivity.class);
      localIntent.putExtras(paramIntent);
      localIntent.putExtra("is_qzone_vip", this.jdField_n_of_type_Boolean);
      localIntent.putExtra("param.topicId", this.jdField_e_of_type_JavaLangString);
      localIntent.putExtra("param.topicSyncQzone", this.jdField_i_of_type_Boolean);
      localIntent.putExtra("extra_key_font_id", this.jdField_a_of_type_Int);
      localIntent.putExtra("extra_key_font_format_type", this.jdField_c_of_type_Int);
      localIntent.putExtra("extra_key_font_url", this.jdField_i_of_type_JavaLangString);
      localIntent.putExtra("extra_key_super_font_id", this.jdField_d_of_type_Int);
      localIntent.putExtra("extra_key_super_font_info", this.jdField_j_of_type_JavaLangString);
      localIntent.putExtra("short_video_refer", this.jdField_f_of_type_JavaLangString);
      localIntent.putExtra("set_user_callback", this.jdField_a_of_type_AndroidOsBundle.getString("set_user_callback"));
      ThreadManager.getUIHandler().postDelayed(new ahpa(this, localIntent), 0L);
      return;
    }
    catch (Exception paramIntent)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("QzoneEffectsCameraCaptureFragment", 2, "handleOnNewIntent error ", paramIntent);
    }
  }
  
  private void b(Bundle paramBundle)
  {
    int i2 = 3;
    boolean bool1 = paramBundle.getBoolean("flow_camera_video_mode", true);
    boolean bool2 = paramBundle.getBoolean("flow_camera_capture_mode", true);
    int i1;
    if ((bool1) && (bool2))
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout.setRecordTipsWording(getResources().getString(2131438700));
      i1 = 1;
    }
    for (;;)
    {
      int i3;
      if (this.jdField_j_of_type_Boolean)
      {
        b(QzoneConfig.getInstance().getConfig("MiniVideo", "QzoneGifMiniFrame", 5));
        i3 = QzoneConfig.getInstance().getConfig("MiniVideo", "GlanceVideoMaxTime", 1);
        LpReportInfo_pf00064.allReport(627, 1);
        i1 = i2;
      }
      for (i2 = i3;; i2 = QzoneConfig.getInstance().getConfig("MiniVideo", "QzoneVideoMaxTime", 7))
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout.setMaxDuration(i2 * 1000 + 100);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout.setFunctionFlag(i1);
        return;
        if ((bool1) && (!bool2))
        {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout.setRecordTipsWording(getResources().getString(2131438698));
          i1 = 3;
          break;
        }
        if ((bool1) || (!bool2)) {
          break label229;
        }
        i1 = 2;
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout.setRecordTipsWording(getResources().getString(2131438699));
        break;
        b(QzoneConfig.getInstance().getConfig("MiniVideo", "QzoneVideoMiniFrame", 6));
      }
      label229:
      i1 = 1;
    }
  }
  
  private void b(CameraCaptureView.PhotoCaptureResult paramPhotoCaptureResult)
  {
    try
    {
      if (getActivity() == null) {
        break label539;
      }
      if (getActivity().isFinishing()) {
        return;
      }
      if ((paramPhotoCaptureResult == null) || (TextUtils.isEmpty(paramPhotoCaptureResult.jdField_a_of_type_JavaLangString)))
      {
        ToastUtil.a().a("拍照出错");
        getActivity().finish();
        return;
      }
    }
    catch (Exception paramPhotoCaptureResult)
    {
      QLog.d("QzoneEffectsCameraCaptureFragment", 2, "handlePic exception", paramPhotoCaptureResult);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QzoneEffectsCameraCaptureFragment", 2, "finishShotPhoto " + paramPhotoCaptureResult.jdField_a_of_type_JavaLangString);
    }
    boolean bool1;
    Intent localIntent;
    if (this.jdField_a_of_type_AndroidOsBundle.getInt("edit_video_type", 0) != 10002)
    {
      bool1 = true;
      i1 = this.jdField_a_of_type_AndroidOsBundle.getInt("extra.busi_type", 2);
      boolean bool2 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("go_publish_activity", false);
      if (getActivity() != null)
      {
        if (i1 == 3)
        {
          double d1 = this.jdField_a_of_type_AndroidOsBundle.getDouble("key_longtitude", 4.9E-324D);
          double d2 = this.jdField_a_of_type_AndroidOsBundle.getDouble("key_latitude", 4.9E-324D);
          GpsComplementUtil.b(paramPhotoCaptureResult.jdField_a_of_type_JavaLangString, d1, d2);
        }
        localIntent = EditPicActivity.a(getActivity(), paramPhotoCaptureResult.jdField_a_of_type_JavaLangString, true, true, true, bool1, true, i1, c(), 0, bool2, null);
        localIntent.putExtra("qcamera_photo_filepath", paramPhotoCaptureResult.jdField_a_of_type_JavaLangString);
        localIntent.putExtra("qcamera_rotate", paramPhotoCaptureResult.jdField_c_of_type_Int);
        localIntent.putExtra("PhotoConst.EDIT_COME_FROM_NEWFLOW", true);
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a() != 2) {
          break label546;
        }
      }
    }
    label536:
    label539:
    label546:
    for (int i1 = 0;; i1 = 1)
    {
      localIntent.putExtra("camera_type", 103);
      localIntent.putExtra("camera_front_back", i1);
      localIntent.putExtra("camera_capture_method", paramPhotoCaptureResult.jdField_a_of_type_Int);
      localIntent.putExtra("babyq_ability", this.jdField_a_of_type_AndroidOsBundle.getLong("babyq_ability", 0L));
      FlowCameraMqqAction.a(this.jdField_a_of_type_AndroidOsBundle.getInt("edit_video_type", -1), "", "0X8007818", null);
      i1 = this.jdField_a_of_type_AndroidOsBundle.getInt("edit_video_type", 0);
      String str;
      if (i1 == 10004)
      {
        localIntent.putExtra("sub_business_id", 101);
        paramPhotoCaptureResult = SplashActivity.class.getName();
        str = this.jdField_a_of_type_AndroidOsBundle.getString("f_a_a_n");
        if ((str == null) || (!str.equals(ChatActivity.class.getName()))) {
          break label536;
        }
        paramPhotoCaptureResult = str;
      }
      for (;;)
      {
        NewFlowCameraReporter.a("finish");
        NewFlowCameraReporter.a(localIntent);
        str = localIntent.getStringExtra("pic_confirm_text");
        if (str != null) {
          localIntent.putExtra("extra_publish_text", str);
        }
        localIntent.putExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME", paramPhotoCaptureResult);
        localIntent.putExtra("key_activity_code", this.jdField_a_of_type_AndroidOsBundle.getString("key_activity_code"));
        startActivityForResult(localIntent, 1012);
        FlowCameraMqqAction.a("", "0X80075C1", "", "", "", "");
        return;
        if (i1 != 10010) {
          break;
        }
        localIntent.putExtra("sub_business_id", 104);
        break;
      }
      return;
      bool1 = false;
      break;
    }
  }
  
  private void b(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult)
  {
    r();
    if (getActivity() != null)
    {
      Intent localIntent = new Intent(getActivity(), PreviewVideoActivity.class);
      localIntent.putExtra("from_qzone_camera", true);
      localIntent.putExtra("video_path", paramVideoCaptureResult.videoMp4FilePath);
      localIntent.putExtra("audio_path", paramVideoCaptureResult.audioDataFilePath);
      startActivityForResult(localIntent, 1016);
    }
  }
  
  private void b(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    boolean bool1 = true;
    if (QLog.isColorLevel()) {
      QLog.d("QzoneEffectsCameraCaptureFragment", 2, "intentToEditVideoActivityFromQzone start!");
    }
    for (;;)
    {
      try
      {
        localBundle = new Bundle();
        localBundle.putInt("entrance_type", c());
        localBundle.putString("extra_publish_text", this.jdField_g_of_type_JavaLangString);
        localBundle.putBoolean("enable_hw_encode", true);
        int i3 = 105;
        int i4 = this.jdField_a_of_type_AndroidOsBundle.getInt("entry_source", 0);
        if (paramLocalMediaInfo.mDuration > QzoneConfig.getInstance().getConfig("MiniVideo", "QzoneVideoMaxTime", 7) * 1000 + 200) {
          break label599;
        }
        i2 = 1;
        i1 = i3;
        if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
        {
          i1 = i3;
          if (!"ref_h5_record_video".equals(this.jdField_f_of_type_JavaLangString))
          {
            i1 = i3;
            if (i4 != 3)
            {
              i1 = i3;
              if (i4 != 5)
              {
                i1 = i3;
                if (i2 != 0)
                {
                  i1 = i3;
                  if (!gifCoderWnsConfig.a()) {
                    i1 = 8297;
                  }
                }
              }
            }
          }
        }
        boolean bool2 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("enable_edit_button", true);
        paramVideoCaptureResult = new EditTakeVideoSource(paramVideoCaptureResult.videoMp4FilePath, paramVideoCaptureResult.audioDataFilePath, paramLocalMediaInfo);
        if (!bool2) {
          break label605;
        }
        paramLocalMediaInfo = new EditVideoParams(3, i1, paramVideoCaptureResult, localBundle);
        paramLocalMediaInfo.jdField_a_of_type_AndroidOsBundle.putBoolean("enable_hw_encode", true);
        a("608", "8", "0", true);
        if (QLog.isColorLevel()) {
          QLog.d("QzoneEffectsCameraCaptureFragment", 2, "intentToEditVideoActivityFromQzone startActivityForResult---> EditVideoParams params:" + paramLocalMediaInfo.toString() + ", recordFinish---startEdit");
        }
        if (getActivity() == null) {
          break label598;
        }
        if (getActivity().isFinishing()) {
          return;
        }
        paramVideoCaptureResult = new Intent(getActivity(), NewFlowEditVideoActivity.class);
        paramVideoCaptureResult.putExtra(EditVideoParams.class.getName(), paramLocalMediaInfo);
        paramVideoCaptureResult.putExtra("key_font_id", this.jdField_a_of_type_Int);
        paramVideoCaptureResult.putExtra("op_department", "grp_qzone");
        paramVideoCaptureResult.putExtra("op_type", "video_edit");
        paramVideoCaptureResult.putExtra("topic_id", this.jdField_e_of_type_JavaLangString);
        paramVideoCaptureResult.putExtra("enable_priv_list", this.jdField_k_of_type_Boolean);
        paramVideoCaptureResult.putExtra("enable_input_text", this.jdField_l_of_type_Boolean);
        paramVideoCaptureResult.putExtra("enable_sync_qzone", this.jdField_m_of_type_Boolean);
        paramVideoCaptureResult.putExtra("stop_record_time", System.currentTimeMillis());
        paramVideoCaptureResult.putExtra("lastLoginUin", this.jdField_h_of_type_JavaLangString);
        paramVideoCaptureResult.putExtra("mIsQzoneVip", this.jdField_n_of_type_Boolean);
        paramVideoCaptureResult.putExtra("UseQQCameraCompression", QzoneConfig.getInstance().getConfig("PhotoAlbum", "UseQQCameraCompression", 2));
        paramVideoCaptureResult.putExtra("entry_source", this.jdField_a_of_type_AndroidOsBundle.getInt("entry_source", 0));
        if (i2 != 0) {
          continue;
        }
      }
      catch (Exception paramVideoCaptureResult)
      {
        Bundle localBundle;
        if (!QLog.isColorLevel()) {
          break label598;
        }
        QLog.d("QzoneEffectsCameraCaptureFragment", 2, "intentToEditVideoActivityFromQzone exception:" + paramVideoCaptureResult);
        return;
        bool1 = false;
        continue;
      }
      paramVideoCaptureResult.putExtra("TAKE_DANCING_VIDEO", bool1);
      paramLocalMediaInfo = a(true);
      if (paramLocalMediaInfo != null) {
        localBundle.putByteArray("extra_subtile_data", paramLocalMediaInfo);
      }
      startActivityForResult(paramVideoCaptureResult, 1011);
      getActivity().overridePendingTransition(0, 0);
      if (QLog.isColorLevel())
      {
        QLog.d("QzoneEffectsCameraCaptureFragment", 2, "intentToEditVideoActivityFromQzone ---> finish startActivityForResult");
        return;
      }
      label598:
      return;
      label599:
      int i2 = 0;
      continue;
      label605:
      int i1 = 0;
    }
  }
  
  private void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("QzoneEffectsCameraCaptureFragment", 2, "showProgressDialog " + paramString);
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_AndroidAppProgressDialog == null) {
          continue;
        }
        p();
        localTextView = (TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131363418);
        if (!StringUtil.a(paramString)) {
          continue;
        }
        localTextView.setText(2131434330);
      }
      catch (Throwable paramString)
      {
        TextView localTextView;
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.e("QzoneEffectsCameraCaptureFragment", 2, "showProgressDialog", paramString);
        return;
        localTextView.setText(paramString);
        continue;
      }
      if (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing()) {
        return;
      }
      this.jdField_a_of_type_AndroidAppProgressDialog.show();
      return;
      this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(getActivity(), 2131624516);
      this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(false);
      this.jdField_a_of_type_AndroidAppProgressDialog.show();
      this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2130969178);
    }
  }
  
  private void b(boolean paramBoolean, String paramString)
  {
    if ((getActivity() == null) || (getActivity().isFinishing())) {
      return;
    }
    getActivity().runOnUiThread(new ahoz(this, paramBoolean, paramString));
  }
  
  private int c()
  {
    int i2 = this.jdField_a_of_type_AndroidOsBundle.getInt("entrance_type", 99);
    int i1 = i2;
    SessionInfo localSessionInfo;
    if (i2 == 100)
    {
      localSessionInfo = (SessionInfo)this.jdField_a_of_type_AndroidOsBundle.getParcelable("PhotoConst.SEND_SESSION_INFO");
      if (localSessionInfo == null) {
        break label94;
      }
    }
    label94:
    for (i1 = localSessionInfo.jdField_a_of_type_Int;; i1 = 0)
    {
      switch (i1)
      {
      default: 
        i1 = 11;
        return i1;
      case 0: 
        return 11;
      case 1: 
        return 9;
      }
      return 10;
    }
  }
  
  private void c(int paramInt)
  {
    if ((paramInt != -1) || (getActivity() == null) || (getActivity().isFinishing())) {
      return;
    }
    getActivity().finish();
  }
  
  private void c(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    if (getActivity() != null) {
      getActivity().runOnUiThread(new ahox(this));
    }
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread", false).post(new ahoy(this, paramVideoCaptureResult, paramLocalMediaInfo));
  }
  
  private void d(int paramInt)
  {
    o();
    if (paramInt == 0) {
      a("608", "2", "0", true);
    }
    while (paramInt != -1) {
      return;
    }
    QLog.i("QzoneEffectsCameraCaptureFragment", 2, "REQ_PREVIEW_EDIT_GIF_ACTIVITY result ok");
    getActivity().finish();
  }
  
  private void n()
  {
    if (this.p)
    {
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)getView().findViewById(2131370125));
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    }
  }
  
  private void o()
  {
    try
    {
      FileUtils.a(a());
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("QzoneEffectsCameraCaptureFragment", 2, "Delete file error", localException);
    }
  }
  
  private void p()
  {
    if (QLog.isColorLevel()) {
      QLog.e("QzoneEffectsCameraCaptureFragment", 2, "cancelProgressDialog");
    }
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
        this.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void q()
  {
    if (this.p)
    {
      Bitmap localBitmap = a(getActivity());
      if (localBitmap != null) {
        this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(new BitmapDrawable(localBitmap));
      }
    }
  }
  
  private void r()
  {
    String str = a() + File.separator + "videoThumb.jpg";
    MediaUtil.a(this.b.videoMp4FilePath, str);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.thumbnailPath = str;
  }
  
  private void s()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo != null)) {
      a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.audioDataFilePath, 0, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.videoMp4FilePath, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.thumbnailPath, null, (int)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface, null, -1, null, this.jdField_i_of_type_Boolean, this.jdField_a_of_type_Int, this.jdField_c_of_type_Int, this.jdField_i_of_type_JavaLangString, this.jdField_d_of_type_Int, this.jdField_j_of_type_JavaLangString, false, false, false);
    }
  }
  
  public int a()
  {
    return 10001;
  }
  
  protected CameraCaptureView.CaptureParam a()
  {
    if ((!this.jdField_j_of_type_Boolean) && (this.o)) {}
    for (int i1 = QzoneConfig.getInstance().getConfig("PhotoAlbum", "UseQQCameraCompression", 2);; i1 = 1)
    {
      if (this.jdField_e_of_type_Int != 0) {}
      for (;;)
      {
        Size localSize = SVParamManager.a().a(this.jdField_e_of_type_Int);
        CameraCaptureView.CaptureParam localCaptureParam = new CameraCaptureView.CaptureParam();
        localCaptureParam.a(localSize.a());
        localCaptureParam.b(localSize.b());
        localCaptureParam.a(SVParamManager.a().a(this.jdField_e_of_type_Int));
        i1 *= SVParamManager.a().a(this.jdField_e_of_type_Int) * 1000;
        localCaptureParam.h(i1);
        com.tencent.mobileqq.shortvideo.mediadevice.CodecParam.r = i1;
        localCaptureParam.i(1);
        localCaptureParam.g(this.jdField_e_of_type_Int);
        return localCaptureParam;
        if (this.r) {
          this.jdField_e_of_type_Int = 1;
        } else {
          this.jdField_e_of_type_Int = CameraHelper.b();
        }
      }
    }
  }
  
  public void a(Intent paramIntent)
  {
    b(paramIntent);
  }
  
  public void a(CameraCaptureView.PhotoCaptureResult paramPhotoCaptureResult)
  {
    i();
    b(paramPhotoCaptureResult);
  }
  
  protected void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    if ((getActivity() == null) || (getActivity().isFinishing())) {}
    for (;;)
    {
      return;
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult = paramVideoCaptureResult;
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = paramLocalMediaInfo;
        if ((paramVideoCaptureResult == null) || (paramVideoCaptureResult.videoMp4FilePath == null) || (paramLocalMediaInfo == null))
        {
          ToastUtil.a().a("录制出错");
          if (getActivity() == null) {
            continue;
          }
          getActivity().finish();
        }
      }
      catch (Exception paramVideoCaptureResult)
      {
        QLog.d("QzoneEffectsCameraCaptureFragment", 2, "handleVideo exception!", paramVideoCaptureResult);
        return;
      }
    }
    if (this.jdField_j_of_type_Boolean)
    {
      c(paramVideoCaptureResult, paramLocalMediaInfo);
      return;
    }
    if (this.o)
    {
      b(paramVideoCaptureResult, paramLocalMediaInfo);
      return;
    }
    b(paramVideoCaptureResult);
  }
  
  protected void a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, FlowComponentInterface paramFlowComponentInterface, String paramString5, int paramInt3, ArrayList paramArrayList, boolean paramBoolean1, int paramInt4, int paramInt5, String paramString6, int paramInt6, String paramString7, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    String str = new File(paramString2).getParent();
    if (!TextUtils.isEmpty(paramString4)) {
      PtvFilterUtils.a(str, paramString4);
    }
    MediaCodecSendTask.VideoSendPublicParam localVideoSendPublicParam = new MediaCodecSendTask.VideoSendPublicParam();
    localVideoSendPublicParam.jdField_a_of_type_AndroidAppActivity = getActivity();
    localVideoSendPublicParam.jdField_a_of_type_JavaLangString = str;
    localVideoSendPublicParam.jdField_b_of_type_JavaLangString = paramString1;
    localVideoSendPublicParam.jdField_a_of_type_Int = paramInt1;
    localVideoSendPublicParam.jdField_c_of_type_JavaLangString = paramString2;
    localVideoSendPublicParam.jdField_f_of_type_JavaLangString = paramString3;
    localVideoSendPublicParam.jdField_c_of_type_Int = 0;
    localVideoSendPublicParam.jdField_d_of_type_Int = 0;
    localVideoSendPublicParam.jdField_k_of_type_JavaLangString = paramString4;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult == null)
    {
      ShortVideoExceptionReporter.a(new RuntimeException("videoCaptureResult == null"));
      QLog.e("QzoneEffectsCameraCaptureFragment", 2, "videoCaptureResult == null");
    }
    for (localVideoSendPublicParam.jdField_i_of_type_Int = 0;; localVideoSendPublicParam.jdField_i_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.videoFrameCount)
    {
      localVideoSendPublicParam.jdField_j_of_type_Int = paramInt2;
      localVideoSendPublicParam.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface = paramFlowComponentInterface;
      localVideoSendPublicParam.jdField_g_of_type_JavaLangString = paramString5;
      localVideoSendPublicParam.jdField_e_of_type_Int = paramInt3;
      localVideoSendPublicParam.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
      localVideoSendPublicParam.jdField_a_of_type_Boolean = this.o;
      localVideoSendPublicParam.jdField_j_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
      localVideoSendPublicParam.jdField_b_of_type_Boolean = paramBoolean1;
      localVideoSendPublicParam.jdField_f_of_type_Int = paramInt4;
      localVideoSendPublicParam.jdField_g_of_type_Int = paramInt5;
      localVideoSendPublicParam.jdField_h_of_type_JavaLangString = paramString6;
      localVideoSendPublicParam.jdField_h_of_type_Int = paramInt6;
      localVideoSendPublicParam.jdField_i_of_type_JavaLangString = paramString7;
      localVideoSendPublicParam.jdField_e_of_type_Boolean = paramBoolean2;
      localVideoSendPublicParam.jdField_f_of_type_Boolean = paramBoolean3;
      localVideoSendPublicParam.jdField_g_of_type_Boolean = paramBoolean4;
      localVideoSendPublicParam.jdField_k_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("entry_source", 0);
      localVideoSendPublicParam.jdField_d_of_type_JavaLangString = "";
      localVideoSendPublicParam.jdField_b_of_type_Int = 0;
      localVideoSendPublicParam.jdField_e_of_type_JavaLangString = "";
      new MediaCodecSendTask(localVideoSendPublicParam).execute(new Void[0]);
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    QZoneClickReport.ReportInfo localReportInfo = new QZoneClickReport.ReportInfo();
    localReportInfo.jdField_c_of_type_JavaLangString = paramString1;
    localReportInfo.jdField_d_of_type_JavaLangString = paramString2;
    localReportInfo.jdField_e_of_type_JavaLangString = paramString3;
    paramString1 = "";
    if (getActivity().getAppInterface() != null) {
      paramString1 = getActivity().getAppInterface().getCurrentAccountUin();
    }
    QZoneClickReport.report(paramString1, localReportInfo, paramBoolean);
  }
  
  public boolean a()
  {
    return this.o;
  }
  
  protected int b()
  {
    return 2130971193;
  }
  
  protected boolean c()
  {
    return false;
  }
  
  protected void d()
  {
    super.d();
    if (this.r) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView.a(102, this.jdField_k_of_type_JavaLangString, this.jdField_l_of_type_JavaLangString);
    }
    while (!this.s) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView.a(101, this.jdField_m_of_type_JavaLangString, this.jdField_n_of_type_JavaLangString);
  }
  
  protected void l()
  {
    super.l();
    if ((!this.p) || (getActivity() == null) || (getActivity().isFinishing())) {
      return;
    }
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetButton, "translationY", new float[] { 0.0F, UIUtils.a(getActivity(), 100.0F) });
    localObjectAnimator.setDuration(150L);
    localObjectAnimator.start();
  }
  
  protected void m()
  {
    super.m();
    if ((!this.p) || (getActivity() == null) || (getActivity().isFinishing())) {
      return;
    }
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetButton, "translationY", new float[] { UIUtils.a(getActivity(), 100.0F), 0.0F });
    localObjectAnimator.setDuration(150L);
    localObjectAnimator.start();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing())) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QzoneEffectsCameraCaptureFragment", 2, "onActivityResult:requestCode=" + paramInt1 + "  resultCode=" + paramInt2);
      }
      ReportUtil.a(localFragmentActivity, paramInt1, paramInt2);
      switch (paramInt1)
      {
      }
      while (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface.a(getActivity(), paramInt1, paramInt2, paramIntent);
        return;
        b(paramInt2, paramIntent);
        continue;
        d(paramInt2);
        continue;
        a(paramInt2, paramIntent);
        continue;
        c(paramInt2);
        continue;
        b(paramInt2);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.e("QzoneEffectsCameraCaptureFragment", 2, "flow_camera_btn_video_local");
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface.a(getActivity());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidOsBundle = getArguments();
    a(this.jdField_a_of_type_AndroidOsBundle);
    if (paramBundle != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult = ((CameraCaptureView.VideoCaptureResult)paramBundle.getSerializable("KEY_VIDEO_RESULT"));
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.q)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.onPause();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout.d();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView.f();
      this.q = false;
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putSerializable("KEY_VIDEO_RESULT", this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    n();
    b(this.jdField_a_of_type_AndroidOsBundle);
    ThreadManager.getUIHandler().postDelayed(new ahow(this), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.fragment.QzoneEffectsCameraCaptureFragment
 * JD-Core Version:    0.7.0.1
 */