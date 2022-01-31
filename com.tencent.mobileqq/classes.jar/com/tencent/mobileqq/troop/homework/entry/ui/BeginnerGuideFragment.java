package com.tencent.mobileqq.troop.homework.entry.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import bbzc;
import bbze;
import bbzf;
import bbzj;
import bcbe;
import bety;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.troop.homework.entry.ui.view.ComplexGuidViewPager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;

public class BeginnerGuideFragment
  extends PublicBaseFragment
  implements bcbe
{
  private int jdField_a_of_type_Int;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private View jdField_a_of_type_AndroidViewView;
  private bbzj jdField_a_of_type_Bbzj;
  private bety jdField_a_of_type_Bety;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected ComplexGuidViewPager a;
  private boolean jdField_a_of_type_Boolean;
  
  public static void a(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    Intent localIntent = new Intent();
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    localIntent.putExtra("BeginnerGuideFragment:page_type", true);
    localIntent.putExtra("BeginnerGuideFragment:hw_type", paramInt);
    PublicFragmentActivity.a(paramActivity, localIntent, BeginnerGuideFragment.class);
    paramActivity.overridePendingTransition(2130772293, 2130771990);
  }
  
  private void a(String paramString, int paramInt)
  {
    c();
    if (QLog.isColorLevel()) {
      QLog.d("BeginnerGuideFragment", 2, "onBeginnerGuidePrepared, " + paramString + ", " + paramInt);
    }
    d();
  }
  
  private boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BeginnerGuideFragment", 2, "BeginnerGuideFragment prepareBeginnerGuideForSubmit");
    }
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int >= 0)) {
      switch (this.jdField_a_of_type_Int)
      {
      case 5: 
      case 6: 
      default: 
        str2 = "";
        str1 = "";
        i = -1000;
        if ((i < 0) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str1))) {
          b(-1000);
        }
        break;
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        String str2;
        String str1;
        int i;
        for (;;)
        {
          return false;
          str2 = "https://sqimg.qq.com/qq_product_operations/qq_troop_homework/beginner_guide_src/submit_arithmetic.zip";
          str1 = "986db0ad9ec2954f958193a7c819463f";
          i = this.jdField_a_of_type_Int;
          continue;
          str2 = "https://sqimg.qq.com/qq_product_operations/qq_troop_homework/beginner_guide_src/submit_recite.zip";
          str1 = "df711d27a3d4a9de6cce3e1eb2254878";
          i = this.jdField_a_of_type_Int;
        }
        try
        {
          String str3 = new File(new URL(str2).getFile()).getName();
          new bbzc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2, str3, str1).a(this.jdField_a_of_type_Bbzj, i, false);
          return true;
        }
        catch (Exception localException) {}
      } while (!QLog.isColorLevel());
      QLog.d("BeginnerGuideFragment", 2, "download manager init error ", localException);
      return false;
    }
    QLog.d("BeginnerGuideFragment", 2, "BeginnerGuideFragment prepareBeginnerGuideForSubmit failed");
    return false;
  }
  
  private void b(int paramInt)
  {
    c();
    if (QLog.isColorLevel()) {
      QLog.d("BeginnerGuideFragment", 2, new Object[] { "onBeginnerGuidePreparedFailed (" + paramInt + ") ", Log.getStackTraceString(new RuntimeException("trace")) });
    }
    getActivity().finish();
  }
  
  public static void b(Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    Intent localIntent = new Intent();
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    localIntent.putExtra("BeginnerGuideFragment:page_type", false);
    localIntent.putExtra("BeginnerGuideFragment:hw_type", paramInt);
    PublicFragmentActivity.a(paramActivity, localIntent, BeginnerGuideFragment.class);
    paramActivity.overridePendingTransition(2130772293, 2130771990);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewComplexGuidViewPager == null) {
      return;
    }
    bbze localbbze = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localbbze != null)
    {
      if (!this.jdField_a_of_type_Boolean) {
        break label135;
      }
      localObject1 = localObject2;
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        localObject1 = localObject2;
      }
    }
    while ((localObject1 != null) && (((bbzf)localObject1).jdField_a_of_type_JavaLangString != null) && (((bbzf)localObject1).jdField_a_of_type_JavaUtilArrayList != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewComplexGuidViewPager.setData(((bbzf)localObject1).jdField_a_of_type_JavaLangString, ((bbzf)localObject1).jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewComplexGuidViewPager.invalidate();
      return;
      localObject1 = localbbze.b;
      continue;
      localObject1 = localbbze.a;
      continue;
      label135:
      switch (this.jdField_a_of_type_Int)
      {
      case 5: 
      case 6: 
      default: 
        localObject1 = localObject2;
        break;
      case 4: 
        localObject1 = localbbze.c;
        break;
      case 7: 
        localObject1 = localbbze.d;
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BeginnerGuideFragment", 2, "BeginnerGuideFragment onActionBtnClicked");
    }
    getActivity().doOnBackPressed();
  }
  
  protected void a(int paramInt)
  {
    try
    {
      if (!getActivity().isFinishing())
      {
        if (this.jdField_a_of_type_Bety == null)
        {
          this.jdField_a_of_type_Bety = new bety(getActivity(), getActivity().getTitleBarHeight());
          this.jdField_a_of_type_Bety.setCancelable(false);
          this.jdField_a_of_type_Bety.show();
        }
        this.jdField_a_of_type_Bety.c(paramInt);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewComplexGuidViewPager != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewComplexGuidViewPager.setVisibility(4);
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BeginnerGuideFragment", 2, "BeginnerGuideFragment onSkitBtnClicked");
    }
    a();
  }
  
  protected void c()
  {
    if ((this.jdField_a_of_type_Bety != null) && (this.jdField_a_of_type_Bety.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bety.dismiss();
      label24:
      this.jdField_a_of_type_Bety = null;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewComplexGuidViewPager != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewComplexGuidViewPager.setVisibility(0);
      }
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    getActivity().getWindow().addFlags(67108864);
    super.onActivityCreated(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BeginnerGuideFragment", 2, "BeginnerGuideFragment create view");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    this.jdField_a_of_type_Bbzj = new bbzj(this, Looper.myLooper());
    this.jdField_a_of_type_AndroidOsBundle = getArguments();
    if (this.jdField_a_of_type_AndroidOsBundle != null)
    {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("BeginnerGuideFragment:hw_type", -1000);
      if (!this.jdField_a_of_type_AndroidOsBundle.containsKey("BeginnerGuideFragment:page_type")) {
        break label177;
      }
      this.jdField_a_of_type_Boolean = this.jdField_a_of_type_AndroidOsBundle.getBoolean("BeginnerGuideFragment:page_type", true);
    }
    for (;;)
    {
      boolean bool = a();
      this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131560450, paramViewGroup, false);
      if (this.jdField_a_of_type_AndroidViewView == null) {
        getActivity().finish();
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewComplexGuidViewPager = ((ComplexGuidViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131364667));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewComplexGuidViewPager.setOnActionBtnClickListener(this);
      d();
      if (bool) {
        a(2131697870);
      }
      return this.jdField_a_of_type_AndroidViewView;
      label177:
      if (QLog.isColorLevel()) {
        QLog.d("BeginnerGuideFragment", 2, "BeginnerGuideFragment create view failed, cannot determine which page to show");
      }
      getActivity().finish();
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (this.jdField_a_of_type_Bbzj != null) {
      this.jdField_a_of_type_Bbzj.removeCallbacksAndMessages(null);
    }
  }
  
  public void onFinish()
  {
    super.onFinish();
    getActivity().overridePendingTransition(2130771990, 2130772295);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.BeginnerGuideFragment
 * JD-Core Version:    0.7.0.1
 */