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
import bfzh;
import bfzj;
import bfzk;
import bfzo;
import bgbj;
import bjbs;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.troop.homework.entry.ui.view.ComplexGuidViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.io.File;
import java.net.URL;

public class BeginnerGuideFragment
  extends PublicBaseFragment
  implements bgbj
{
  private int jdField_a_of_type_Int;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private View jdField_a_of_type_AndroidViewView;
  private bfzo jdField_a_of_type_Bfzo;
  private bjbs jdField_a_of_type_Bjbs;
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
    paramActivity.overridePendingTransition(2130772302, 2130771990);
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
          new bfzh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2, str3, str1).a(this.jdField_a_of_type_Bfzo, i, false);
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
    paramActivity.overridePendingTransition(2130772302, 2130771990);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewComplexGuidViewPager == null) {
      return;
    }
    bfzj localbfzj = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).a;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localbfzj != null)
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
    while ((localObject1 != null) && (((bfzk)localObject1).jdField_a_of_type_JavaLangString != null) && (((bfzk)localObject1).jdField_a_of_type_JavaUtilArrayList != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewComplexGuidViewPager.setData(((bfzk)localObject1).jdField_a_of_type_JavaLangString, ((bfzk)localObject1).jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewComplexGuidViewPager.invalidate();
      return;
      localObject1 = localbfzj.b;
      continue;
      localObject1 = localbfzj.a;
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
        localObject1 = localbfzj.c;
        break;
      case 7: 
        localObject1 = localbfzj.d;
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
        if (this.jdField_a_of_type_Bjbs == null)
        {
          this.jdField_a_of_type_Bjbs = new bjbs(getActivity(), getActivity().getTitleBarHeight());
          this.jdField_a_of_type_Bjbs.setCancelable(false);
          this.jdField_a_of_type_Bjbs.show();
        }
        this.jdField_a_of_type_Bjbs.c(paramInt);
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
    if ((this.jdField_a_of_type_Bjbs != null) && (this.jdField_a_of_type_Bjbs.isShowing())) {}
    try
    {
      this.jdField_a_of_type_Bjbs.dismiss();
      label24:
      this.jdField_a_of_type_Bjbs = null;
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
    this.jdField_a_of_type_Bfzo = new bfzo(this, Looper.myLooper());
    this.jdField_a_of_type_AndroidOsBundle = getArguments();
    if (this.jdField_a_of_type_AndroidOsBundle != null)
    {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("BeginnerGuideFragment:hw_type", -1000);
      if (!this.jdField_a_of_type_AndroidOsBundle.containsKey("BeginnerGuideFragment:page_type")) {
        break label184;
      }
      this.jdField_a_of_type_Boolean = this.jdField_a_of_type_AndroidOsBundle.getBoolean("BeginnerGuideFragment:page_type", true);
    }
    for (;;)
    {
      boolean bool = a();
      this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131560620, paramViewGroup, false);
      if (this.jdField_a_of_type_AndroidViewView == null) {
        getActivity().finish();
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewComplexGuidViewPager = ((ComplexGuidViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131364929));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewComplexGuidViewPager.setOnActionBtnClickListener(this);
      d();
      if (bool) {
        a(2131696763);
      }
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      label184:
      if (QLog.isColorLevel()) {
        QLog.d("BeginnerGuideFragment", 2, "BeginnerGuideFragment create view failed, cannot determine which page to show");
      }
      getActivity().finish();
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (this.jdField_a_of_type_Bfzo != null) {
      this.jdField_a_of_type_Bfzo.removeCallbacksAndMessages(null);
    }
  }
  
  public void onFinish()
  {
    super.onFinish();
    getActivity().overridePendingTransition(2130771990, 2130772304);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.BeginnerGuideFragment
 * JD-Core Version:    0.7.0.1
 */