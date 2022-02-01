package com.tencent.mobileqq.kandian.biz.message.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.app.QIphoneTitleBarActivity;
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
  extends QIphoneTitleBarActivity
  implements OnTabRedNumsChangeListenner
{
  protected QQAppInterface a;
  protected KandianMergeManager b;
  protected ReadInJoyBaseFragment c;
  
  private void a()
  {
    ReadInJoyWebDataManager.a().d(this.a.getCurrentAccountUin());
    if (this.b != null) {
      ReadInJoyWebDataManager.a().a(this.a.getCurrentAccountUin(), this.b.P() ^ true);
    }
    setContentView(2131624037);
    b();
    FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
    String str;
    if (StudyModeManager.h()) {
      str = "3";
    } else {
      str = "1";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://viola.qq.com/js/usercenter.js?_rij_violaUrl=1&hideNav=1&v_nav_immer=1&v_tid=6&v_bundleName=usercenter&v_bid=3740&jump_source=");
    localStringBuilder.append(str);
    this.c = ReadInJoySelfCenterViolaFragment.a(localStringBuilder.toString());
    localFragmentTransaction.add(2131433667, this.c);
    localFragmentTransaction.show(this.c);
    localFragmentTransaction.commitAllowingStateLoss();
  }
  
  public static void a(Activity paramActivity) {}
  
  private void b()
  {
    hideTitleBar();
    setImmersiveStatus();
    this.titleRoot = ((RelativeLayout)findViewById(2131447595));
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
  
  public void da_()
  {
    ThreadManager.getUIHandler().post(new ReadInJoySelfActivity.1(this));
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.a = ((QQAppInterface)ReadInJoyUtils.b());
    this.b = ((KandianMergeManager)this.a.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER));
    this.b.a(this);
    a();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    KandianMergeManager localKandianMergeManager = this.b;
    if (localKandianMergeManager != null) {
      localKandianMergeManager.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.message.activity.ReadInJoySelfActivity
 * JD-Core Version:    0.7.0.1
 */