package com.tencent.mobileqq.troop.homework.entry.ui;

import ajgk;
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
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.troop.homework.config.BeginnerGuideDownloadManager;
import com.tencent.mobileqq.troop.homework.config.HomeworkConfig;
import com.tencent.mobileqq.troop.homework.config.HomeworkConfig.HomeWorkGuideInfo;
import com.tencent.mobileqq.troop.homework.entry.ui.view.ComplexGuidViewPager;
import com.tencent.mobileqq.troop.homework.entry.ui.view.ComplexGuidViewPager.OnGuideBtnClickListener;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;

public class BeginnerGuideFragment
  extends PublicBaseFragment
  implements ComplexGuidViewPager.OnGuideBtnClickListener
{
  private int jdField_a_of_type_Int;
  private ajgk jdField_a_of_type_Ajgk;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private View jdField_a_of_type_AndroidViewView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected ComplexGuidViewPager a;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
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
    paramActivity.overridePendingTransition(2131034380, 2131034131);
  }
  
  private void a(String paramString, int paramInt)
  {
    d();
    if (QLog.isColorLevel()) {
      QLog.d("BeginnerGuideFragment", 2, "onBeginnerGuidePrepared, " + paramString + ", " + paramInt);
    }
    e();
  }
  
  private void b(int paramInt)
  {
    d();
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
    paramActivity.overridePendingTransition(2131034380, 2131034131);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewComplexGuidViewPager == null) {
      return;
    }
    HomeworkConfig localHomeworkConfig = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localHomeworkConfig != null)
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
    while ((localObject1 != null) && (((HomeworkConfig.HomeWorkGuideInfo)localObject1).jdField_a_of_type_JavaLangString != null) && (((HomeworkConfig.HomeWorkGuideInfo)localObject1).jdField_a_of_type_JavaUtilArrayList != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewComplexGuidViewPager.setData(((HomeworkConfig.HomeWorkGuideInfo)localObject1).jdField_a_of_type_JavaLangString, ((HomeworkConfig.HomeWorkGuideInfo)localObject1).jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewComplexGuidViewPager.invalidate();
      return;
      localObject1 = localHomeworkConfig.b;
      continue;
      localObject1 = localHomeworkConfig.a;
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
        localObject1 = localHomeworkConfig.c;
        break;
      case 7: 
        localObject1 = localHomeworkConfig.d;
      }
    }
  }
  
  private boolean e()
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
          new BeginnerGuideDownloadManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2, str3, str1).a(this.jdField_a_of_type_Ajgk, i, false);
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
  
  protected void a(int paramInt)
  {
    try
    {
      if (!getActivity().isFinishing())
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity(), getActivity().getTitleBarHeight());
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(paramInt);
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
  
  public boolean a()
  {
    return false;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BeginnerGuideFragment", 2, "BeginnerGuideFragment onActionBtnClicked");
    }
    getActivity().doOnBackPressed();
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BeginnerGuideFragment", 2, "BeginnerGuideFragment onSkitBtnClicked");
    }
    b();
  }
  
  public boolean c()
  {
    return false;
  }
  
  protected void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      label24:
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
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
    this.jdField_a_of_type_Ajgk = new ajgk(this, Looper.myLooper());
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
      boolean bool = e();
      this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2130969900, paramViewGroup, false);
      if (this.jdField_a_of_type_AndroidViewView == null) {
        getActivity().finish();
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewComplexGuidViewPager = ((ComplexGuidViewPager)this.jdField_a_of_type_AndroidViewView.findViewById(2131368405));
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkEntryUiViewComplexGuidViewPager.setOnActionBtnClickListener(this);
      e();
      if (bool) {
        a(2131430663);
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
    if (this.jdField_a_of_type_Ajgk != null) {
      this.jdField_a_of_type_Ajgk.removeCallbacksAndMessages(null);
    }
  }
  
  public void u_()
  {
    super.u_();
    getActivity().overridePendingTransition(2131034131, 2131034382);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.BeginnerGuideFragment
 * JD-Core Version:    0.7.0.1
 */