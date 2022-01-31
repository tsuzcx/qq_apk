package com.tencent.mobileqq.onlinestatus;

import alkv;
import allb;
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
import avyj;
import avyk;
import avyl;
import avym;
import avyn;
import avzg;
import avzp;
import awad;
import awae;
import awaf;
import awai;
import awak;
import awam;
import awan;
import awap;
import awaq;
import azmj;
import bdee;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.QQToast;
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
  implements avzp, awan, awaq
{
  private long jdField_a_of_type_Long;
  private allb jdField_a_of_type_Allb = new avyl(this);
  private volatile FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private avzg jdField_a_of_type_Avzg;
  private awae jdField_a_of_type_Awae = new avyn(this);
  private awap jdField_a_of_type_Awap;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AutoReplyText jdField_a_of_type_ComTencentMobileqqDataAutoReplyText;
  private AppRuntime.Status jdField_a_of_type_MqqAppAppRuntime$Status;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new avym(this);
  private boolean jdField_a_of_type_Boolean;
  private AutoReplyText b;
  
  private void a()
  {
    setRightButton(2131694951, new avyj(this));
    setTitle(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131720305));
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setBackgroundDrawable(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDrawable(2130839216));
    Object localObject = getResources().getDrawable(2130844247);
    this.jdField_a_of_type_Awap = new awap(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localLinearLayout, this, 7);
    this.jdField_a_of_type_Awap.a();
    this.jdField_a_of_type_Avzg = new avzg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, (Drawable)localObject);
    this.jdField_a_of_type_Avzg.a(this);
    this.jdField_a_of_type_MqqAppAppRuntime$Status = ((AppRuntime.Status)getActivity().getIntent().getSerializableExtra("KEY_ONLINE_STATUS"));
    this.jdField_a_of_type_Long = getActivity().getIntent().getLongExtra("KEY_ONLINE_EXT_STATUS", 0L);
    if (this.jdField_a_of_type_MqqAppAppRuntime$Status == null)
    {
      this.jdField_a_of_type_MqqAppAppRuntime$Status = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatus();
      this.jdField_a_of_type_Long = awaf.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    this.jdField_a_of_type_Awap.a(this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long, this);
    localObject = (ListView)this.mContentView.findViewById(2131361875);
    if ((localObject instanceof SwipListView))
    {
      ((SwipListView)localObject).setDragEnable(true);
      ((SwipListView)localObject).setRightIconMenuListener(new avyk(this));
    }
    ((ListView)localObject).addHeaderView(localLinearLayout);
    ((ListView)localObject).setAdapter(this.jdField_a_of_type_Avzg);
    ((ListView)localObject).setDividerHeight(0);
  }
  
  private void a(boolean paramBoolean)
  {
    int j = 0;
    ArrayList localArrayList;
    if (this.jdField_a_of_type_Avzg != null)
    {
      localArrayList = this.jdField_a_of_type_Avzg.a();
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
      ((alkv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).a(localArrayList, i, j, paramBoolean);
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
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, 2131720294, 1).a();
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setResult(-1);
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, 2131720292, 1).a();
  }
  
  private boolean a(awam paramawam, AppRuntime.Status paramStatus)
  {
    return (paramStatus == this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatus()) && (awaf.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == paramawam.jdField_a_of_type_Long);
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountOnlineStateActivity", 2, "onSubmit online status " + this.jdField_a_of_type_MqqAppAppRuntime$Status);
    }
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) {
      return;
    }
    if (!bdee.g(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity))
    {
      QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 1, 2131720293, 1).a();
      return;
    }
    if (this.jdField_a_of_type_Avzg.a()) {
      a(true);
    }
    for (;;)
    {
      awak.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long);
      awak.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqDataAutoReplyText);
      return;
      awam localawam = this.jdField_a_of_type_Awap.a();
      AppRuntime.Status localStatus = awaf.a().a(localawam);
      if ((localStatus != null) && (!a(localawam, localStatus)))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localStatus, localawam.jdField_a_of_type_Long);
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
    List localList = ((awad)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(319)).a();
    if ((localList != null) && (localList.size() > 0) && (this.jdField_a_of_type_Avzg != null)) {
      this.jdField_a_of_type_Avzg.a(localList);
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
  
  public void a(awam paramawam)
  {
    if (paramawam != null)
    {
      this.jdField_a_of_type_MqqAppAppRuntime$Status = awaf.a().a(paramawam);
      this.jdField_a_of_type_Long = paramawam.jdField_a_of_type_Long;
    }
    this.jdField_a_of_type_Avzg.a(awai.a(this.jdField_a_of_type_MqqAppAppRuntime$Status));
  }
  
  public void a(awam paramawam1, awam paramawam2)
  {
    if (paramawam2 != null)
    {
      this.jdField_a_of_type_MqqAppAppRuntime$Status = awaf.a().a(paramawam2);
      this.jdField_a_of_type_Long = paramawam2.jdField_a_of_type_Long;
    }
    this.jdField_a_of_type_Avzg.a(awai.a(this.jdField_a_of_type_MqqAppAppRuntime$Status));
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
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009E88", "0X8009E88", 0, 0, "", "", "", "");
  }
  
  public void b(AutoReplyText paramAutoReplyText, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountOnlineStateActivity", 2, paramAutoReplyText + " is click");
    }
    if ((paramAutoReplyText != null) && (paramAutoReplyText.getExtra().getBoolean("addFlag", false))) {
      awak.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) {
      AutoReplyEditActivity.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 325, paramAutoReplyText);
    }
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009E87", "0X8009E87", 0, 0, "", "", "", "");
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app;
      a();
      c();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Allb);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Awae);
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
        this.jdField_a_of_type_Avzg.a(localAutoReplyText);
        this.jdField_a_of_type_Avzg.a(localAutoReplyText.getTextId());
      }
    } while ((!paramIntent.getBooleanExtra("AutoReplyEditActivity:new_text", false)) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null));
    QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2, 2131690370, 1).a();
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Avzg.a()) {
      if (bdee.g(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)) {
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Allb);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Awae);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity
 * JD-Core Version:    0.7.0.1
 */