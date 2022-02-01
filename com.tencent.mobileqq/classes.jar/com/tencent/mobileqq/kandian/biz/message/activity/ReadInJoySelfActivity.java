package com.tencent.mobileqq.kandian.biz.message.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.fragment.ReadInJoyBaseFragment;
import com.tencent.mobileqq.kandian.biz.push.OnTabRedNumsChangeListenner;
import com.tencent.mobileqq.kandian.biz.video.ReadInJoyWebDataManager;
import com.tencent.mobileqq.kandian.biz.viola.ReadInJoySelfCenterViolaFragment;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import mqq.os.MqqHandler;

public class ReadInJoySelfActivity
  extends IphoneTitleBarActivity
  implements OnTabRedNumsChangeListenner
{
  protected QQAppInterface a;
  protected ReadInJoyBaseFragment a;
  protected KandianMergeManager a;
  
  private void a()
  {
    this.app = ((QQAppInterface)super.getAppRuntime());
    if (this.app == null) {
      return;
    }
    ReadInJoyWebDataManager.a().d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager != null) {
      ReadInJoyWebDataManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager.i() ^ true);
    }
    setContentView(2131558488);
    b();
    FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
    String str;
    if (StudyModeManager.a()) {
      str = "3";
    } else {
      str = "1";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://viola.qq.com/js/usercenter.js?_rij_violaUrl=1&hideNav=1&v_nav_immer=1&v_tid=6&v_bundleName=usercenter&v_bid=3740&jump_source=");
    localStringBuilder.append(str);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonFragmentReadInJoyBaseFragment = ReadInJoySelfCenterViolaFragment.a(localStringBuilder.toString());
    localFragmentTransaction.add(2131367211, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonFragmentReadInJoyBaseFragment);
    localFragmentTransaction.show(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonFragmentReadInJoyBaseFragment);
    localFragmentTransaction.commitAllowingStateLoss();
  }
  
  public static void a(Activity paramActivity) {}
  
  private void b()
  {
    hideTitleBar();
    setImmersiveStatus();
    this.titleRoot = ((RelativeLayout)findViewById(2131378893));
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      super.getWindow().addFlags(67108864);
      ImmersiveUtils.clearCoverForStatus(getWindow(), this.isClearCoverLayer);
      this.titleRoot.setFitsSystemWindows(false);
      this.titleRoot.setPadding(0, 0, 0, 0);
      if (this.mSystemBarComp == null) {
        this.mSystemBarComp = new SystemBarCompact(this, true, -1);
      }
      this.mSystemBarComp.init();
      this.mSystemBarComp.setStatusBarColor(0);
      this.mSystemBarComp.setStatusBarDarkMode(true);
    }
  }
  
  public void aD_()
  {
    ThreadManager.getUIHandler().post(new ReadInJoySelfActivity.1(this));
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)ReadInJoyUtils.a());
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager.a(this);
    a();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    KandianMergeManager localKandianMergeManager = this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineKandianMergeManager;
    if (localKandianMergeManager != null) {
      localKandianMergeManager.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.message.activity.ReadInJoySelfActivity
 * JD-Core Version:    0.7.0.1
 */