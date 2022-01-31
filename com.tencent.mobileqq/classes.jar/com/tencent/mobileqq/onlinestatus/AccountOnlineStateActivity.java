package com.tencent.mobileqq.onlinestatus;

import ajfi;
import ajfo;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import atje;
import atjf;
import atjg;
import atjh;
import atji;
import atkc;
import atkl;
import atkz;
import atla;
import atlb;
import atlf;
import atlh;
import atlj;
import atlk;
import atlm;
import atln;
import awqx;
import badq;
import bbmy;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.SwipListView;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime.Status;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;

public class AccountOnlineStateActivity
  extends IphoneTitleBarFragment
  implements atkl, atlk, atln
{
  private long jdField_a_of_type_Long;
  private ajfo jdField_a_of_type_Ajfo = new atjg(this);
  private volatile FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private atkc jdField_a_of_type_Atkc;
  private atla jdField_a_of_type_Atla = new atji(this);
  private atlm jdField_a_of_type_Atlm;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AutoReplyText jdField_a_of_type_ComTencentMobileqqDataAutoReplyText;
  private AppRuntime.Status jdField_a_of_type_MqqAppAppRuntime$Status;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new atjh(this);
  private boolean jdField_a_of_type_Boolean;
  private AutoReplyText b;
  
  private void a()
  {
    setRightButton(2131629116, new atje(this));
    setTitle(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131653884));
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDrawable(2130839104));
    Object localObject = getResources().getDrawable(2130843825);
    this.jdField_a_of_type_Atlm = new atlm(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localLinearLayout, this, 7);
    this.jdField_a_of_type_Atlm.a();
    this.jdField_a_of_type_Atkc = new atkc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, (Drawable)localObject);
    this.jdField_a_of_type_Atkc.a(this);
    this.jdField_a_of_type_MqqAppAppRuntime$Status = ((AppRuntime.Status)getActivity().getIntent().getSerializableExtra("KEY_ONLINE_STATUS"));
    this.jdField_a_of_type_Long = getActivity().getIntent().getLongExtra("KEY_ONLINE_EXT_STATUS", 0L);
    if (this.jdField_a_of_type_MqqAppAppRuntime$Status == null)
    {
      this.jdField_a_of_type_MqqAppAppRuntime$Status = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatus();
      this.jdField_a_of_type_Long = atlb.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    this.jdField_a_of_type_Atlm.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long, this);
    localObject = (ListView)this.mContentView.findViewById(2131296340);
    if ((localObject instanceof SwipListView))
    {
      ((SwipListView)localObject).setDragEnable(true);
      ((SwipListView)localObject).setRightIconMenuListener(new atjf(this));
    }
    ((ListView)localObject).addHeaderView(localLinearLayout);
    ((ListView)localObject).setAdapter(this.jdField_a_of_type_Atkc);
    ((ListView)localObject).setDividerHeight(0);
  }
  
  private void a(boolean paramBoolean)
  {
    int j = 0;
    ArrayList localArrayList;
    if (this.jdField_a_of_type_Atkc != null)
    {
      localArrayList = this.jdField_a_of_type_Atkc.a();
      if (this.jdField_a_of_type_ComTencentMobileqqDataAutoReplyText == null) {
        break label68;
      }
    }
    label68:
    for (int i = this.jdField_a_of_type_ComTencentMobileqqDataAutoReplyText.mTextId;; i = 0)
    {
      if (this.b != null) {
        j = this.b.mTextId;
      }
      ((ajfi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).a(localArrayList, i, j, paramBoolean);
      return;
    }
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountOnlineStateActivity", 2, "onSubmitted online status " + paramBoolean + ", retCode = " + paramInt);
    }
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) {
      return;
    }
    if (paramBoolean)
    {
      bbmy.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, 2131653873, 1).a();
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setResult(-1);
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
      return;
    }
    bbmy.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, 2131653871, 1).a();
  }
  
  private boolean a(atlj paramatlj, AppRuntime.Status paramStatus)
  {
    if ((paramStatus == AppRuntime.Status.online) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatus() == AppRuntime.Status.online)) {
      if (atlb.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != paramatlj.jdField_a_of_type_Long) {}
    }
    while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatus() == paramStatus)
    {
      return true;
      return false;
    }
    return false;
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountOnlineStateActivity", 2, "onSubmit online status " + this.jdField_a_of_type_MqqAppAppRuntime$Status);
    }
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) {
      return;
    }
    if (!badq.g(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity))
    {
      bbmy.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, 2131653872, 1).a();
      return;
    }
    if (this.jdField_a_of_type_Atkc.a()) {
      a(true);
    }
    for (;;)
    {
      atlh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
      atlh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqDataAutoReplyText);
      return;
      atlj localatlj = this.jdField_a_of_type_Atlm.a();
      AppRuntime.Status localStatus = atlb.a().a(localatlj);
      if ((localStatus != null) && (!a(localatlj, localStatus)))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localStatus, localatlj.jdField_a_of_type_Long);
        this.jdField_a_of_type_Boolean = true;
      }
      else
      {
        a(true, 0);
      }
    }
  }
  
  private void c()
  {
    List localList = ((atkz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(319)).a();
    if ((localList != null) && (localList.size() > 0) && (this.jdField_a_of_type_Atkc != null)) {
      this.jdField_a_of_type_Atkc.a(localList);
    }
    ThreadManager.getSubThreadHandler().post(new AccountOnlineStateActivity.3(this));
  }
  
  TopGestureLayout a(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    for (paramView = paramView.getParent(); paramView != null; paramView = paramView.getParent()) {
      if ((paramView instanceof TopGestureLayout)) {
        return (TopGestureLayout)paramView;
      }
    }
    return null;
  }
  
  public void a(atlj paramatlj)
  {
    if (paramatlj != null)
    {
      this.jdField_a_of_type_MqqAppAppRuntime$Status = atlb.a().a(paramatlj);
      this.jdField_a_of_type_Long = paramatlj.jdField_a_of_type_Long;
    }
    this.jdField_a_of_type_Atkc.a(atlf.a(this.jdField_a_of_type_MqqAppAppRuntime$Status));
  }
  
  public void a(atlj paramatlj1, atlj paramatlj2)
  {
    if (paramatlj2 != null)
    {
      this.jdField_a_of_type_MqqAppAppRuntime$Status = atlb.a().a(paramatlj2);
      this.jdField_a_of_type_Long = paramatlj2.jdField_a_of_type_Long;
    }
    this.jdField_a_of_type_Atkc.a(atlf.a(this.jdField_a_of_type_MqqAppAppRuntime$Status));
  }
  
  public void a(AutoReplyText paramAutoReplyText)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountOnlineStateActivity", 2, "text is added, text = " + paramAutoReplyText);
    }
  }
  
  public void a(AutoReplyText paramAutoReplyText1, AutoReplyText paramAutoReplyText2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountOnlineStateActivity", 2, paramAutoReplyText1 + " is checked, lastChecked is " + paramAutoReplyText2);
    }
    this.jdField_a_of_type_ComTencentMobileqqDataAutoReplyText = paramAutoReplyText1;
    this.b = paramAutoReplyText2;
  }
  
  public void a(AutoReplyText paramAutoReplyText, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountOnlineStateActivity", 2, paramAutoReplyText + " is delete");
    }
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009E88", "0X8009E88", 0, 0, "", "", "", "");
  }
  
  public void b(AutoReplyText paramAutoReplyText, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountOnlineStateActivity", 2, paramAutoReplyText + " is click");
    }
    if ((paramAutoReplyText != null) && (paramAutoReplyText.getExtra().getBoolean("addFlag", false))) {
      atlh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) {
      AutoReplyEditActivity.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 325, paramAutoReplyText);
    }
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009E87", "0X8009E87", 0, 0, "", "", "", "");
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app;
      a();
      c();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajfo);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Atla);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131492884;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent == null) {}
    do
    {
      do
      {
        return;
      } while ((paramInt1 != 325) || (paramInt2 != 325));
      AutoReplyText localAutoReplyText = (AutoReplyText)paramIntent.getParcelableExtra("AutoReplyEditActivity:text");
      if (localAutoReplyText != null)
      {
        this.jdField_a_of_type_Atkc.a(localAutoReplyText);
        this.jdField_a_of_type_Atkc.a(localAutoReplyText.getTextId());
      }
    } while ((!paramIntent.getBooleanExtra("AutoReplyEditActivity:new_text", false)) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null));
    bbmy.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, 2131624758, 1).a();
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Atkc.a()) {
      if (badq.g(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)) {
        a(false);
      }
    }
    for (;;)
    {
      super.onBackEvent();
      return true;
      QLog.d("AccountOnlineStateActivity", 2, "onBackEvent network is not available");
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("AccountOnlineStateActivity", 2, "onBackEvent auto reply list not changed!");
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajfo);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Atla);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = null;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity
 * JD-Core Version:    0.7.0.1
 */