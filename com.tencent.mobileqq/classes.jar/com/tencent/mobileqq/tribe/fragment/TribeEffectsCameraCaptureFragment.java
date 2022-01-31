package com.tencent.mobileqq.tribe.fragment;

import aixr;
import aixs;
import aixt;
import aixu;
import aixv;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.richmedia.FlowComponentInterface;
import com.tencent.mobileqq.activity.richmedia.MX3FlowNewCameraActivity;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.NewPreFlowCamera;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.richmedia.capture.activity.CameraCaptureActivity;
import com.tencent.mobileqq.richmedia.capture.activity.CaptureSoDownloadActivity;
import com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager;
import com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager;
import com.tencent.mobileqq.richmedia.capture.data.FilterCategoryItem;
import com.tencent.mobileqq.richmedia.capture.fragment.EffectsCameraCaptureFragment;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.richmedia.capture.util.JumpUtil;
import com.tencent.mobileqq.richmedia.capture.view.BeautyProviderView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureButtonLayout;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.CaptureParam;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.ProviderContainerView;
import com.tencent.mobileqq.richmedia.capture.view.ProviderContainerView.ContainerViewListener;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.shortvideo.util.NativeSoLoader;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tribe.TribeFlowComponentInterface;
import com.tencent.mobileqq.tribe.TribeVideoPublishParams;
import com.tencent.mobileqq.tribe.TribeVideoPublishParams.ChangeFace;
import com.tencent.mobileqq.tribe.TribeVideoPublishParams.Filter;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import org.json.JSONObject;

public class TribeEffectsCameraCaptureFragment
  extends EffectsCameraCaptureFragment
{
  public static int a;
  public Button a;
  public FlowComponentInterface a;
  private ProviderContainerView.ContainerViewListener a;
  public int c = -1;
  public String e = "barIndex";
  public String f = "";
  public boolean i;
  public boolean j;
  public boolean k;
  
  static
  {
    jdField_a_of_type_Int = 1001;
  }
  
  public static void a(UiApiPlugin paramUiApiPlugin, Activity paramActivity, AppInterface paramAppInterface, String paramString1, byte paramByte, String paramString2)
  {
    if (!VideoEnvironment.b(paramAppInterface))
    {
      DialogUtil.a(paramActivity, 230).setMessage("系统版本过低，不支持短视频功能").setPositiveButton(2131433030, new aixv()).show();
      return;
    }
    boolean bool1 = VideoEnvironment.e(paramAppInterface);
    boolean bool2 = CaptureUtil.a();
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureFragment", 2, new Object[] { "launch, videoSoUsable=%s, supportMediaCodec=%s", Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    }
    if ((!bool1) && (!NetworkUtil.g(paramActivity)))
    {
      QQToast.a(paramActivity, 2131432992, 0).a();
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("flow_camera_video_mode", true);
    localBundle.putBoolean("flow_camera_capture_mode", false);
    localBundle.putBoolean("isFromTribePublish", false);
    localBundle.putString("options", paramString1);
    localBundle.putLong("ACTIVITY_START_TIME", System.currentTimeMillis());
    paramUiApiPlugin.f();
    if (bool2) {
      if (bool1)
      {
        localBundle.putLong("ACTIVITY_START_TIME", System.currentTimeMillis());
        paramUiApiPlugin.startActivityForResult(CameraCaptureActivity.a(paramActivity, TribeEffectsCameraCaptureFragment.class.getName(), localBundle), paramByte);
        if (!"barindex".equals(paramString2)) {
          break label610;
        }
      }
    }
    label536:
    label610:
    for (int m = 1;; m = 2)
    {
      ReportController.b(null, "dc00899", "Grp_tribe", "", "video_shoot", "exp_findview", m, 0, "", "", "", "");
      return;
      paramActivity = new Intent(paramActivity, CaptureSoDownloadActivity.class);
      paramActivity.putExtras(localBundle);
      paramActivity.putExtra("pendingIntentClass", TribeEffectsCameraCaptureFragment.class.getName());
      paramActivity.putExtra("pendingIntentRequest", paramByte);
      paramUiApiPlugin.startActivityForResult(paramActivity, paramByte);
      break;
      SystemClock.uptimeMillis();
      if ((bool1) && (PtvFilterSoLoad.a(paramActivity) == 0)) {}
      for (m = 1;; m = 0)
      {
        if (m == 0) {
          break label536;
        }
        paramAppInterface = NewFlowCameraActivity.class;
        if (CameraCompatibleList.d(CameraCompatibleList.c)) {
          paramAppInterface = MX3FlowNewCameraActivity.class;
        }
        paramActivity = new Intent(paramActivity, paramAppInterface);
        paramActivity.putExtra("support_photo_merge", false);
        paramActivity.putExtra("activity_start_time", SystemClock.elapsedRealtime());
        paramActivity.putExtra("video_min_frame_count", 3);
        paramActivity.putExtra("sv_config", DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.SV658Cfg.name(), null));
        paramActivity.putExtra("sv_whitelist", DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name()));
        paramActivity.putExtra("flow_show_filter_red", false);
        paramActivity.putExtra("flow_show_filter_red_pkg", false);
        paramActivity.putExtra("edit_video_type", 10012);
        paramActivity.putExtra("set_user_callback", TribeFlowComponentInterface.class.getCanonicalName());
        paramActivity.putExtra("enable_local_video", true);
        paramActivity.putExtra("short_video_refer", "tribe");
        paramActivity.putExtra("flow_camera_video_mode", true);
        paramActivity.putExtra("flow_camera_use_filter_function", false);
        paramActivity.putExtra("flow_camera_use_3dfilter_function", NativeSoLoader.a(false));
        paramActivity.putExtra("ignore_dpc_duration", true);
        paramActivity.putExtra("video_duration", 10);
        paramActivity.putExtras(localBundle);
        paramUiApiPlugin.startActivityForResult(paramActivity, paramByte);
        break;
      }
      paramActivity = new Intent(paramActivity, NewPreFlowCamera.class);
      paramActivity.putExtra("support_photo_merge", false);
      paramActivity.putExtra("video_min_frame_count", 3);
      paramActivity.putExtra("edit_video_type", 10012);
      paramActivity.putExtra("flow_show_filter_red", false);
      paramActivity.putExtra("flow_show_filter_red_pkg", false);
      paramActivity.putExtras(localBundle);
      paramUiApiPlugin.startActivityForResult(paramActivity, paramByte);
      break;
    }
  }
  
  public int a()
  {
    return 10012;
  }
  
  protected CameraCaptureView.CaptureParam a()
  {
    CameraCaptureView.CaptureParam localCaptureParam = super.a();
    if (CodecParam.r > 2000000)
    {
      localCaptureParam.h(2000000);
      CodecParam.r = 2000000;
      QLog.d("CameraCaptureFragment", 4, "maxrate:" + CodecParam.r);
    }
    return localCaptureParam;
  }
  
  public void a()
  {
    QQToast.a(getActivity(), "拍摄时间过短，请重新拍摄。", 0).a();
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    this.jdField_a_of_type_AndroidOsHandler.post(new aixu(this));
  }
  
  protected void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    a(paramLocalMediaInfo);
    JumpUtil.a(this, paramVideoCaptureResult, paramLocalMediaInfo, a(true), 10, a(), 0, null, null, null);
  }
  
  public void al_()
  {
    super.al_();
    this.jdField_a_of_type_AndroidOsHandler.post(new aixt(this));
  }
  
  protected int b()
  {
    return 2130971193;
  }
  
  /* Error */
  protected void n()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokevirtual 343	com/tencent/mobileqq/tribe/fragment/TribeEffectsCameraCaptureFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   7: invokevirtual 394	android/support/v4/app/FragmentActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   10: astore 7
    //   12: aload 7
    //   14: getstatic 400	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   17: aconst_null
    //   18: aconst_null
    //   19: aconst_null
    //   20: aconst_null
    //   21: invokevirtual 406	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   24: astore_3
    //   25: aload_3
    //   26: ifnull +254 -> 280
    //   29: aload_3
    //   30: invokeinterface 411 1 0
    //   35: istore_2
    //   36: iload_2
    //   37: ifeq +243 -> 280
    //   40: aconst_null
    //   41: astore 6
    //   43: aload 6
    //   45: astore 5
    //   47: aload_3
    //   48: aload_3
    //   49: ldc_w 413
    //   52: invokeinterface 417 2 0
    //   57: invokeinterface 421 2 0
    //   62: istore_1
    //   63: aload 6
    //   65: astore 5
    //   67: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   70: ifeq +33 -> 103
    //   73: aload 6
    //   75: astore 5
    //   77: ldc 80
    //   79: iconst_2
    //   80: new 323	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 324	java/lang/StringBuilder:<init>	()V
    //   87: ldc_w 423
    //   90: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: iload_1
    //   94: invokevirtual 333	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   97: invokevirtual 336	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 339	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: aload 6
    //   105: astore 5
    //   107: aload 7
    //   109: iload_1
    //   110: i2l
    //   111: iconst_3
    //   112: aconst_null
    //   113: invokestatic 429	android/provider/MediaStore$Video$Thumbnails:getThumbnail	(Landroid/content/ContentResolver;JILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   116: astore 4
    //   118: aload 4
    //   120: ifnull +49 -> 169
    //   123: aload 4
    //   125: astore 5
    //   127: aload_3
    //   128: ifnull +13 -> 141
    //   131: aload_3
    //   132: invokeinterface 432 1 0
    //   137: aload 4
    //   139: astore 5
    //   141: aload 5
    //   143: ifnull +25 -> 168
    //   146: new 434	android/graphics/drawable/BitmapDrawable
    //   149: dup
    //   150: aload_0
    //   151: invokevirtual 438	com/tencent/mobileqq/tribe/fragment/TribeEffectsCameraCaptureFragment:getResources	()Landroid/content/res/Resources;
    //   154: aload 5
    //   156: invokespecial 441	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   159: astore_3
    //   160: aload_0
    //   161: getfield 443	com/tencent/mobileqq/tribe/fragment/TribeEffectsCameraCaptureFragment:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   164: aload_3
    //   165: invokevirtual 449	android/widget/Button:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   168: return
    //   169: aload 4
    //   171: astore 5
    //   173: aload_3
    //   174: invokeinterface 452 1 0
    //   179: istore_2
    //   180: aload 4
    //   182: astore 6
    //   184: iload_2
    //   185: ifne -142 -> 43
    //   188: goto -65 -> 123
    //   191: astore 6
    //   193: aconst_null
    //   194: astore_3
    //   195: aload 6
    //   197: invokevirtual 455	java/lang/Exception:printStackTrace	()V
    //   200: aload_3
    //   201: astore 5
    //   203: aload 4
    //   205: ifnull -64 -> 141
    //   208: aload 4
    //   210: invokeinterface 432 1 0
    //   215: aload_3
    //   216: astore 5
    //   218: goto -77 -> 141
    //   221: astore 4
    //   223: aconst_null
    //   224: astore_3
    //   225: aload_3
    //   226: ifnull +9 -> 235
    //   229: aload_3
    //   230: invokeinterface 432 1 0
    //   235: aload 4
    //   237: athrow
    //   238: astore 4
    //   240: goto -15 -> 225
    //   243: astore 5
    //   245: aload 4
    //   247: astore_3
    //   248: aload 5
    //   250: astore 4
    //   252: goto -27 -> 225
    //   255: astore 6
    //   257: aconst_null
    //   258: astore 5
    //   260: aload_3
    //   261: astore 4
    //   263: aload 5
    //   265: astore_3
    //   266: goto -71 -> 195
    //   269: astore 6
    //   271: aload_3
    //   272: astore 4
    //   274: aload 5
    //   276: astore_3
    //   277: goto -82 -> 195
    //   280: aconst_null
    //   281: astore 4
    //   283: goto -160 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	286	0	this	TribeEffectsCameraCaptureFragment
    //   62	48	1	m	int
    //   35	150	2	bool	boolean
    //   24	253	3	localObject1	Object
    //   1	208	4	localBitmap1	android.graphics.Bitmap
    //   221	15	4	localObject2	Object
    //   238	8	4	localObject3	Object
    //   250	32	4	localObject4	Object
    //   45	172	5	localObject5	Object
    //   243	6	5	localObject6	Object
    //   258	17	5	localObject7	Object
    //   41	142	6	localBitmap2	android.graphics.Bitmap
    //   191	5	6	localException1	Exception
    //   255	1	6	localException2	Exception
    //   269	1	6	localException3	Exception
    //   10	98	7	localContentResolver	android.content.ContentResolver
    // Exception table:
    //   from	to	target	type
    //   12	25	191	java/lang/Exception
    //   12	25	221	finally
    //   29	36	238	finally
    //   47	63	238	finally
    //   67	73	238	finally
    //   77	103	238	finally
    //   107	118	238	finally
    //   173	180	238	finally
    //   195	200	243	finally
    //   29	36	255	java/lang/Exception
    //   47	63	269	java/lang/Exception
    //   67	73	269	java/lang/Exception
    //   77	103	269	java/lang/Exception
    //   107	118	269	java/lang/Exception
    //   173	180	269	java/lang/Exception
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing())) {}
    Object localObject1;
    label82:
    do
    {
      do
      {
        return;
        if (paramInt1 != jdField_a_of_type_Int) {
          break label82;
        }
        if (paramInt2 != -1) {
          break;
        }
      } while (paramIntent == null);
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("result", paramIntent.getStringExtra("result"));
      localFragmentActivity.setResult(-1, (Intent)localObject1);
      localFragmentActivity.finish();
      return;
    } while (paramInt1 != 10012);
    if ((paramInt2 == -1) && (paramIntent != null))
    {
      paramInt1 = paramIntent.getIntExtra("theme_id", -1);
      Object localObject2 = paramIntent.getStringExtra("theme_name");
      PublishParam localPublishParam = (PublishParam)paramIntent.getParcelableExtra(PublishParam.a);
      localObject1 = (TribeVideoPublishParams)paramIntent.getSerializableExtra(TribeVideoPublishParams.BUNDLE_EXTRA_KEY);
      paramIntent = new Intent();
      paramIntent.putExtra("thumbPath", localPublishParam.c);
      paramIntent.putExtra("videoPath", localPublishParam.j);
      paramIntent.putExtra("fakeVid", localPublishParam.b);
      paramIntent.putExtra("videoDoodleDescription", localPublishParam.f);
      paramIntent.putExtra("theme_id", paramInt1);
      paramIntent.putExtra("theme_name", (String)localObject2);
      localObject2 = CapturePtvTemplateManager.a().a();
      if (localObject2 != null)
      {
        ((TribeVideoPublishParams)localObject1).changeFace = new TribeVideoPublishParams.ChangeFace();
        ((TribeVideoPublishParams)localObject1).changeFace.id = ((PtvTemplateManager.PtvTemplateInfo)localObject2).id;
        ((TribeVideoPublishParams)localObject1).changeFace.type = ((PtvTemplateManager.PtvTemplateInfo)localObject2).categoryName;
      }
      localObject2 = (BeautyProviderView)this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView.a(BeautyProviderView.class);
      if (localObject2 != null) {
        ((TribeVideoPublishParams)localObject1).beauty = ((BeautyProviderView)localObject2).b();
      }
      paramIntent.putExtra(TribeVideoPublishParams.BUNDLE_EXTRA_KEY, (Serializable)localObject1);
      localObject2 = CaptureVideoFilterManager.a().a;
      if ((localObject2 != null) && (!((FilterCategoryItem)localObject2).a()))
      {
        ((TribeVideoPublishParams)localObject1).filter = new TribeVideoPublishParams.Filter();
        ((TribeVideoPublishParams)localObject1).filter.id = ((FilterCategoryItem)localObject2).a;
        ((TribeVideoPublishParams)localObject1).filter.typeId = String.valueOf(((FilterCategoryItem)localObject2).b);
      }
      localObject1 = localFragmentActivity.getIntent().getExtras().getString("options");
      paramIntent.setClass(localFragmentActivity, TroopBarPublishActivity.class);
      paramIntent.putExtra("options", (String)localObject1);
      localFragmentActivity.startActivityForResult(paramIntent, jdField_a_of_type_Int);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
  }
  
  public void onClick(View paramView)
  {
    int n = 1;
    int i1 = 1;
    int m = 1;
    super.onClick(paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131366953: 
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.a() == 1)
      {
        if ("barindex".equals(this.e)) {}
        for (;;)
        {
          ReportController.b(null, "dc00899", "Grp_tribe", "", "video_shoot", "camera_front", m, 0, "", "", "", "");
          return;
          m = 2;
        }
      }
      if ("barindex".equals(this.e)) {}
      for (m = n;; m = 2)
      {
        ReportController.b(null, "dc00899", "Grp_tribe", "", "video_shoot", "camera_back", m, 0, "", "", "", "");
        return;
      }
    }
    if ("barindex".equals(this.e)) {}
    for (m = i1;; m = 2)
    {
      ReportController.b(null, "dc00899", "Grp_tribe", "", "video_shoot", "Clk_left", m, 0, "", "", "", "");
      return;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.g = false;
    Object localObject = getActivity().getIntent().getExtras();
    if (localObject != null)
    {
      localObject = ((Bundle)localObject).getString("options");
      if (QLog.isColorLevel()) {
        QLog.d("CameraCaptureFragment", 2, "onVideoCaptured option: " + (String)localObject);
      }
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      this.i = ((JSONObject)localObject).optBoolean("needTheme", false);
      this.j = ((JSONObject)localObject).optBoolean("needVideoDoodle", false);
      this.k = ((JSONObject)localObject).optBoolean("needVideoWording", false);
      this.e = ((JSONObject)localObject).optString("from", "");
      this.c = ((JSONObject)localObject).optInt("theme_id", -1);
      this.f = ((JSONObject)localObject).optString("theme_name", "");
      TribeFlowComponentInterface.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("needVideoTimeLimit", 10) * 1000;
      paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout.a();
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramLayoutInflater.findViewById(2131370125));
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new aixr(this));
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface = new TribeFlowComponentInterface();
      n();
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView$ContainerViewListener == null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView$ContainerViewListener = new aixs(this);
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView$ContainerViewListener);
      return paramLayoutInflater;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("CameraCaptureFragment", 2, "onVideoCaptured: " + localException);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView.b(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView$ContainerViewListener);
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout.setMaxDuration(TribeFlowComponentInterface.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.fragment.TribeEffectsCameraCaptureFragment
 * JD-Core Version:    0.7.0.1
 */