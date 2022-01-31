package com.tencent.mobileqq.onlinestatus;

import ajti;
import ajto;
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
import auhf;
import auhg;
import auhh;
import auhi;
import auhj;
import auid;
import auim;
import auja;
import aujb;
import aujc;
import aujf;
import aujh;
import aujj;
import aujk;
import aujm;
import aujn;
import axqy;
import bbfj;
import bcql;
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
  implements auim, aujk, aujn
{
  private long jdField_a_of_type_Long;
  private ajto jdField_a_of_type_Ajto = new auhh(this);
  private volatile FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private auid jdField_a_of_type_Auid;
  private aujb jdField_a_of_type_Aujb = new auhj(this);
  private aujm jdField_a_of_type_Aujm;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AutoReplyText jdField_a_of_type_ComTencentMobileqqDataAutoReplyText;
  private AppRuntime.Status jdField_a_of_type_MqqAppAppRuntime$Status;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new auhi(this);
  private boolean jdField_a_of_type_Boolean;
  private AutoReplyText b;
  
  private void a()
  {
    setRightButton(2131694794, new auhf(this));
    setTitle(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131719779));
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDrawable(2130839132));
    Object localObject = getResources().getDrawable(2130843904);
    this.jdField_a_of_type_Aujm = new aujm(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localLinearLayout, this, 7);
    this.jdField_a_of_type_Aujm.a();
    this.jdField_a_of_type_Auid = new auid(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, (Drawable)localObject);
    this.jdField_a_of_type_Auid.a(this);
    this.jdField_a_of_type_MqqAppAppRuntime$Status = ((AppRuntime.Status)getActivity().getIntent().getSerializableExtra("KEY_ONLINE_STATUS"));
    this.jdField_a_of_type_Long = getActivity().getIntent().getLongExtra("KEY_ONLINE_EXT_STATUS", 0L);
    if (this.jdField_a_of_type_MqqAppAppRuntime$Status == null)
    {
      this.jdField_a_of_type_MqqAppAppRuntime$Status = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatus();
      this.jdField_a_of_type_Long = aujc.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    this.jdField_a_of_type_Aujm.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long, this);
    localObject = (ListView)this.mContentView.findViewById(2131361875);
    if ((localObject instanceof SwipListView))
    {
      ((SwipListView)localObject).setDragEnable(true);
      ((SwipListView)localObject).setRightIconMenuListener(new auhg(this));
    }
    ((ListView)localObject).addHeaderView(localLinearLayout);
    ((ListView)localObject).setAdapter(this.jdField_a_of_type_Auid);
    ((ListView)localObject).setDividerHeight(0);
  }
  
  private void a(boolean paramBoolean)
  {
    int j = 0;
    ArrayList localArrayList;
    if (this.jdField_a_of_type_Auid != null)
    {
      localArrayList = this.jdField_a_of_type_Auid.a();
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
      ((ajti)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).a(localArrayList, i, j, paramBoolean);
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
      bcql.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, 2131719768, 1).a();
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setResult(-1);
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
      return;
    }
    bcql.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, 2131719766, 1).a();
  }
  
  private boolean a(aujj paramaujj, AppRuntime.Status paramStatus)
  {
    if ((paramStatus == AppRuntime.Status.online) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatus() == AppRuntime.Status.online)) {
      if (aujc.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != paramaujj.jdField_a_of_type_Long) {}
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
    if (!bbfj.g(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity))
    {
      bcql.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, 2131719767, 1).a();
      return;
    }
    if (this.jdField_a_of_type_Auid.a()) {
      a(true);
    }
    for (;;)
    {
      aujh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
      aujh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqDataAutoReplyText);
      return;
      aujj localaujj = this.jdField_a_of_type_Aujm.a();
      AppRuntime.Status localStatus = aujc.a().a(localaujj);
      if ((localStatus != null) && (!a(localaujj, localStatus)))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localStatus, localaujj.jdField_a_of_type_Long);
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
    List localList = ((auja)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(319)).a();
    if ((localList != null) && (localList.size() > 0) && (this.jdField_a_of_type_Auid != null)) {
      this.jdField_a_of_type_Auid.a(localList);
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
  
  public void a(aujj paramaujj)
  {
    if (paramaujj != null)
    {
      this.jdField_a_of_type_MqqAppAppRuntime$Status = aujc.a().a(paramaujj);
      this.jdField_a_of_type_Long = paramaujj.jdField_a_of_type_Long;
    }
    this.jdField_a_of_type_Auid.a(aujf.a(this.jdField_a_of_type_MqqAppAppRuntime$Status));
  }
  
  public void a(aujj paramaujj1, aujj paramaujj2)
  {
    if (paramaujj2 != null)
    {
      this.jdField_a_of_type_MqqAppAppRuntime$Status = aujc.a().a(paramaujj2);
      this.jdField_a_of_type_Long = paramaujj2.jdField_a_of_type_Long;
    }
    this.jdField_a_of_type_Auid.a(aujf.a(this.jdField_a_of_type_MqqAppAppRuntime$Status));
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
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009E88", "0X8009E88", 0, 0, "", "", "", "");
  }
  
  public void b(AutoReplyText paramAutoReplyText, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountOnlineStateActivity", 2, paramAutoReplyText + " is click");
    }
    if ((paramAutoReplyText != null) && (paramAutoReplyText.getExtra().getBoolean("addFlag", false))) {
      aujh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) {
      AutoReplyEditActivity.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 325, paramAutoReplyText);
    }
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009E87", "0X8009E87", 0, 0, "", "", "", "");
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app;
      a();
      c();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajto);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Aujb);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131558420;
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
        this.jdField_a_of_type_Auid.a(localAutoReplyText);
        this.jdField_a_of_type_Auid.a(localAutoReplyText.getTextId());
      }
    } while ((!paramIntent.getBooleanExtra("AutoReplyEditActivity:new_text", false)) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null));
    bcql.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, 2131690319, 1).a();
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Auid.a()) {
      if (bbfj.g(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)) {
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajto);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Aujb);
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