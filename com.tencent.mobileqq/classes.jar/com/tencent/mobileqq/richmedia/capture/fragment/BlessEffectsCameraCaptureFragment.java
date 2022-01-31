package com.tencent.mobileqq.richmedia.capture.fragment;

import ahhy;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager;
import com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager;
import com.tencent.mobileqq.richmedia.capture.data.FilterCategoryItem;
import com.tencent.mobileqq.richmedia.capture.util.JumpUtil;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureButtonLayout;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.CaptureParam;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.PhotoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.ProviderContainerView;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.qphone.base.util.QLog;

public class BlessEffectsCameraCaptureFragment
  extends AIOEffectsCameraCaptureFragment
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new ahhy(this);
  private View jdField_a_of_type_AndroidViewView;
  private String jdField_a_of_type_JavaLangString;
  private int c;
  private String f;
  private String g;
  private String h;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m;
  private boolean n;
  private boolean o;
  
  public static Bundle a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3, boolean paramBoolean4, String paramString1, String paramString2, boolean paramBoolean5, boolean paramBoolean6, String paramString3, String paramString4)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("ARG_SUPPORT_VIDEO", paramBoolean1);
    localBundle.putBoolean("ARG_SUPPORT_PHOTO", paramBoolean2);
    localBundle.putInt("ARG_CAMERA_MODE", paramInt);
    localBundle.putBoolean("ARG_SUPPORT_DD", paramBoolean3);
    localBundle.putBoolean("ARG_UNFOLD_DD", paramBoolean4);
    localBundle.putString("ARG_DD_CATEGORY_NAME", paramString1);
    localBundle.putString("ARG_DD_ITEM_ID", paramString2);
    localBundle.putBoolean("ARG_SUPPORT_FILTER", paramBoolean5);
    localBundle.putBoolean("ARG_UNFOLD_FILTER", paramBoolean6);
    localBundle.putString("ARG_FILTER_CATEGORY_NAME", paramString3);
    localBundle.putString("ARG_FILTER_ITEM_ID", paramString4);
    return localBundle;
  }
  
  public int a()
  {
    return 10003;
  }
  
  protected CameraCaptureView.CaptureParam a()
  {
    CameraCaptureView.CaptureParam localCaptureParam = super.a();
    localCaptureParam.c(this.c);
    return localCaptureParam;
  }
  
  public void a(CameraCaptureView.PhotoCaptureResult paramPhotoCaptureResult)
  {
    i();
    JumpUtil.a(this, paramPhotoCaptureResult, 5, 10003, null, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.a(), null, 0L);
  }
  
  protected void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult = paramVideoCaptureResult;
    a(paramLocalMediaInfo);
    JumpUtil.a(this, paramVideoCaptureResult, paramLocalMediaInfo, a(true), 5, 10003, 0, null, null, null);
  }
  
  protected void e()
  {
    super.e();
    Object localObject;
    boolean bool;
    if ((this.o) && (this.l))
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView.a(102, this.jdField_a_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString);
      localObject = CapturePtvTemplateManager.a().a();
      if (localObject != null)
      {
        com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil.jdField_b_of_type_JavaLangString = ((PtvTemplateManager.PtvTemplateInfo)localObject).categoryId + "";
        com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil.c = ((PtvTemplateManager.PtvTemplateInfo)localObject).id;
        com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil.a = ((PtvTemplateManager.PtvTemplateInfo)localObject).hasGesture();
        if (((PtvTemplateManager.PtvTemplateInfo)localObject).kind != 3) {
          break label100;
        }
        bool = true;
        com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil.jdField_b_of_type_Boolean = bool;
      }
    }
    label100:
    do
    {
      do
      {
        return;
        bool = false;
        break;
      } while ((!this.n) || (!this.m));
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView.a(101, this.g, this.h);
      localObject = CaptureVideoFilterManager.a().a;
    } while (localObject == null);
    com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil.d = ((FilterCategoryItem)localObject).b + "";
    com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil.e = ((FilterCategoryItem)localObject).jdField_a_of_type_JavaLangString;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing())) {}
    do
    {
      do
      {
        do
        {
          return;
          switch (paramInt1)
          {
          default: 
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("AIOEffectsCameraCaptureFragment", 2, "aio onActivityResult:requestCode=" + paramInt1 + "  resultCode=" + paramInt2);
          }
        } while ((paramInt2 != -1) || (paramIntent == null));
        paramIntent = (PublishParam)paramIntent.getParcelableExtra(PublishParam.jdField_a_of_type_JavaLangString);
      } while (paramIntent == null);
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        this.jdField_a_of_type_AndroidViewView = new ImageView(localFragmentActivity);
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-16777216);
        ((ViewGroup)getView()).addView(this.jdField_a_of_type_AndroidViewView, -1, -1);
      }
    } while (paramIntent.j != 1);
    Object localObject = paramIntent.c;
    if (QLog.isColorLevel())
    {
      QLog.d("AIOEffectsCameraCaptureFragment", 2, "hwEncodeVideo videoMergeThumbPath =" + (String)localObject);
      QLog.d("AIOEffectsCameraCaptureFragment", 2, "publishParam =" + paramIntent.toString());
    }
    localFragmentActivity.getIntent().putExtra("ab_test_send_btn_click_time", SystemClock.uptimeMillis());
    localObject = new AIOEffectsCameraCaptureFragment.Session("0", "", 0, "");
    localFragmentActivity.getIntent().putExtra("param_entrance", 15);
    localFragmentActivity.getIntent().putExtra("fake_id", paramIntent.jdField_b_of_type_JavaLangString);
    a((AIOEffectsCameraCaptureFragment.Session)localObject, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    this.j = paramBundle.getBoolean("ARG_SUPPORT_VIDEO");
    this.k = paramBundle.getBoolean("ARG_SUPPORT_PHOTO");
    this.c = paramBundle.getInt("ARG_CAMERA_MODE");
    this.o = paramBundle.getBoolean("ARG_SUPPORT_DD");
    this.l = paramBundle.getBoolean("ARG_UNFOLD_DD");
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("ARG_DD_CATEGORY_NAME");
    this.jdField_f_of_type_JavaLangString = paramBundle.getString("ARG_DD_ITEM_ID");
    this.n = paramBundle.getBoolean("ARG_SUPPORT_FILTER");
    this.m = paramBundle.getBoolean("ARG_UNFOLD_FILTER");
    this.g = paramBundle.getString("ARG_FILTER_CATEGORY_NAME");
    this.h = paramBundle.getString("ARG_FILTER_ITEM_ID");
    this.e = this.n;
    this.jdField_f_of_type_Boolean = this.o;
    paramBundle = new IntentFilter();
    paramBundle.addAction("tencent.video.q2v.startUploadPTV");
    getActivity().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    getActivity().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.i)
    {
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        ((ViewGroup)getView()).removeView(this.jdField_a_of_type_AndroidViewView);
        this.jdField_a_of_type_AndroidViewView = null;
      }
      this.i = false;
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    int i2 = 1;
    super.onViewCreated(paramView, paramBundle);
    int i1;
    if ((this.j) && (this.k)) {
      i1 = i2;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureButtonLayout.setFunctionFlag(i1);
      return;
      if ((this.j) && (!this.k))
      {
        i1 = 3;
      }
      else
      {
        i1 = i2;
        if (!this.j)
        {
          i1 = i2;
          if (this.k) {
            i1 = 2;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.fragment.BlessEffectsCameraCaptureFragment
 * JD-Core Version:    0.7.0.1
 */