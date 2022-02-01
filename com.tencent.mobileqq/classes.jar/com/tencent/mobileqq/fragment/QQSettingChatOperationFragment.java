package com.tencent.mobileqq.fragment;

import acil;
import adab;
import aguy;
import aiti;
import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import antf;
import anum;
import anyu;
import anzj;
import aocm;
import aogx;
import aorf;
import apaw;
import avfm;
import avfn;
import avfo;
import avfp;
import avfq;
import avte;
import avvc;
import axan;
import bbxm;
import bdll;
import beyq;
import bhnv;
import bhyk;
import biwz;
import bjbs;
import blir;
import bliz;
import blji;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.hiddenchat.HiddenChatFragment;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import zxx;

public class QQSettingChatOperationFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, Observer
{
  private long jdField_a_of_type_Long;
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  anyu jdField_a_of_type_Anyu = new avfp(this);
  private aogx jdField_a_of_type_Aogx = new avfo(this);
  public bjbs a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private String jdField_a_of_type_JavaLangString = "";
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private bjbs jdField_b_of_type_Bjbs;
  
  public QQSettingChatOperationFragment()
  {
    this.jdField_a_of_type_AndroidOsHandler = new avfq(this);
  }
  
  private int a()
  {
    Object localObject = HiddenChatFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(), axan.a().c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    int j;
    if ((localObject == null) || (((List)localObject).isEmpty()))
    {
      j = 0;
      return j;
    }
    localObject = ((List)localObject).iterator();
    RecentUser localRecentUser;
    for (int i = 0;; i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localRecentUser.uin, localRecentUser.getType()) + i)
    {
      j = i;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localRecentUser = (RecentUser)((Iterator)localObject).next();
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface)
  {
    if (beyq.a != null)
    {
      b(beyq.a.getAbsolutePath());
      if ((paramQQAppInterface.getApp() instanceof BaseApplicationImpl))
      {
        BaseApplicationImpl.getApplication();
        if (BaseApplicationImpl.sImageCache != null)
        {
          BaseApplicationImpl.getApplication();
          BaseApplicationImpl.sImageCache.evictAll();
        }
      }
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    int i = 0;
    while (i < anum.jdField_a_of_type_JavaUtilVector.size())
    {
      b(anum.jdField_a_of_type_JavaLangString + ((Integer)anum.jdField_a_of_type_JavaUtilVector.get(i)).intValue() + "/");
      i += 1;
    }
    b(anum.jdField_a_of_type_JavaLangString + "background" + "/");
    b(antf.ba + "temp" + "/");
    b(anum.jdField_a_of_type_JavaLangString + "temp" + "/");
    b(anum.jdField_a_of_type_JavaLangString + "HDAvatar" + "/");
    b(antf.cr);
    b(anum.jdField_a_of_type_JavaLangString + "voice" + "/");
    b(acil.a() + "/");
    b(antf.cC);
    b(avte.jdField_a_of_type_JavaLangString);
    b(avvc.jdField_a_of_type_JavaLangString);
    b(bbxm.a());
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bjbs != null)
    {
      if ((!paramBoolean) || (this.jdField_a_of_type_Bjbs.isShowing())) {
        break label29;
      }
      this.jdField_a_of_type_Bjbs.show();
    }
    label29:
    while ((paramBoolean) || (!this.jdField_a_of_type_Bjbs.isShowing())) {
      return;
    }
    this.jdField_a_of_type_Bjbs.dismiss();
  }
  
  private static void b(String paramString)
  {
    paramString = new File(paramString);
    if (paramString != null)
    {
      paramString = paramString.listFiles();
      if (paramString != null)
      {
        int i = 0;
        while (i < paramString.length)
        {
          paramString[i].delete();
          i += 1;
        }
      }
    }
  }
  
  static void d()
  {
    b(antf.ba + "photo/");
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.mContentView.findViewById(2131377110));
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    Object localObject = this.mContentView.findViewById(2131368031);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131380439));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    ((View)localObject).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131374434));
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.e() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ((FormSwitchItem)localObject).setChecked(bool);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.mContentView.findViewById(2131370771));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(2);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131378781));
      this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131365343);
      this.jdField_b_of_type_AndroidViewView = this.mContentView.findViewById(2131365340);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.setContentDescription(getString(2131691315));
      this.jdField_b_of_type_AndroidViewView.setContentDescription(getString(2131691305));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anyu);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aogx);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
      h();
      if (VersionUtils.isGingerBread()) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOverScrollMode(0);
      }
      if (this.jdField_a_of_type_Bjbs == null)
      {
        this.jdField_a_of_type_Bjbs = new bjbs(getActivity(), getActivity().getTitleBarHeight());
        this.jdField_a_of_type_Bjbs.a(getString(2131690711));
        this.jdField_a_of_type_Bjbs.setCanceledOnTouchOutside(true);
        this.jdField_a_of_type_Bjbs.c(true);
        this.jdField_a_of_type_Bjbs.a(false);
        this.jdField_a_of_type_Bjbs.b(true);
      }
      return;
    }
  }
  
  private void f()
  {
    if (!aorf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), getActivity()))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    int i = a();
    if (i > 99)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("99+");
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    if (i > 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(i + "");
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void g()
  {
    if (getActivity() == null) {
      QLog.e("QQSettingChatOperationFragment", 1, "syncMessageRoamFlag: activity is null");
    }
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).getInt("message_roam_flag" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
      Object localObject = null;
      switch (i)
      {
      }
      while (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)localObject);
        return;
        localObject = getResources().getString(2131716002);
        continue;
        localObject = getResources().getString(2131716000);
        continue;
        localObject = getResources().getString(2131716001);
        continue;
        localObject = getResources().getString(2131716003);
        continue;
        localObject = getResources().getString(2131716010);
      }
    } while (!QLog.isColorLevel());
    QLog.d("QQSettingMsgHistoryActivity", 2, "messge roam flag is error ,is : " + i);
  }
  
  private void h()
  {
    Intent localIntent = getActivity().getIntent();
    if ((localIntent != null) && (localIntent.hasExtra("set_display_type"))) {}
    for (int i = localIntent.getIntExtra("set_display_type", 0);; i = 0)
    {
      if (i == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
  }
  
  private void i()
  {
    b(antf.ba + this.jdField_a_of_type_JavaLangString + "/" + "ptt/");
  }
  
  private void j()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().f();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().h();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().i();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_b_of_type_Bjbs != null)
      {
        this.jdField_b_of_type_Bjbs.dismiss();
        this.jdField_b_of_type_Bjbs.cancel();
        this.jdField_b_of_type_Bjbs = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  void a(String paramString)
  {
    if (this.jdField_b_of_type_Bjbs == null) {
      this.jdField_b_of_type_Bjbs = new bjbs(getActivity(), getActivity().getTitleBarHeight());
    }
    this.jdField_b_of_type_Bjbs.setCancelable(true);
    this.jdField_b_of_type_Bjbs.a(paramString);
    this.jdField_b_of_type_Bjbs.show();
  }
  
  void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().h();
    a(this.jdField_a_of_type_JavaLangString, true);
    i();
    d();
    j();
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    c();
    aiti.f();
    MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.sendEmptyMessage(1009);
    }
  }
  
  void c()
  {
    aocm localaocm = (aocm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92);
    localaocm.j();
    localaocm.b();
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((getActivity().getAppRuntime() instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getActivity().getAppRuntime());
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        e();
      }
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131562831;
  }
  
  public boolean onBackEvent()
  {
    boolean bool = super.onBackEvent();
    aguy.b(getActivity(), GeneralSettingActivity.class);
    return bool;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = false;
    int j = 1;
    if (!bhnv.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()))
    {
      QQToast.a(getActivity().getApplicationContext(), 2131693965, 1).a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.e() == 1) {
        bool = true;
      }
      ((FormSwitchItem)localObject).setChecked(bool);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (paramBoolean)
    {
      i = 1;
      label104:
      bdll.b((QQAppInterface)localObject, "CliOper", "", "", "Setting_tab", "Latest_chatlog_syn", 0, i, "0", "0", "", "");
      a(getActivity().getApplication().getResources().getString(2131717920));
      if (!paramBoolean) {
        break label177;
      }
    }
    label177:
    for (int i = j;; i = 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.g(i);
      break;
      i = 0;
      break label104;
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = null;
    int j = 0;
    if (paramView.getId() == 2131370771)
    {
      localObject2 = new Intent(getActivity(), QQBrowserActivity.class);
      localObject1 = bhyk.a("vipRoamChatCell");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        QLog.e("QQSettingChatOperationFragment", 1, "gotoRoamMessageSettingUrl ! url empty");
      }
    }
    long l1;
    long l2;
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (((String)localObject1).contains("?")) {}
        for (localObject1 = (String)localObject1 + "&ADTAG=msgRoam";; localObject1 = (String)localObject1 + "?ADTAG=msgRoam")
        {
          ((Intent)localObject2).putExtra("url", (String)localObject1);
          startActivity((Intent)localObject2);
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history", "ChatHistory", "Clk_RoamMsgSetting", 2, 0, new String[] { "0", "0", "msgRoam" });
          break;
        }
        if (paramView.getId() == 2131368031)
        {
          HiddenChatFragment.a(getActivity(), 1, 0, new Intent());
        }
        else
        {
          if (paramView.getId() != 2131365340) {
            break;
          }
          l1 = System.currentTimeMillis();
          l2 = this.jdField_a_of_type_Long;
          if ((getActivity().isFinishing()) || (l1 - l2 >= 500L))
          {
            this.jdField_a_of_type_Long = l1;
            localObject1 = new biwz(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
            ((biwz)localObject1).a(new avfm(this));
            ((biwz)localObject1).a(anzj.a(2131709619));
            ((biwz)localObject1).b(anzj.a(2131709608));
            ((biwz)localObject1).a(4);
          }
        }
      }
      l1 = System.currentTimeMillis();
      l2 = this.jdField_a_of_type_Long;
    } while ((!getActivity().isFinishing()) && (l1 - l2 < 500L));
    this.jdField_a_of_type_Long = l1;
    Object localObject2 = (blir)blji.a(getActivity(), null);
    int i;
    switch (paramView.getId())
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      ((blir)localObject2).a(i, 3);
      ((blir)localObject2).d(getString(2131690580));
      ((blir)localObject2).a((bliz)localObject1);
      ((blir)localObject2).a(j);
      ((blir)localObject2).show();
      break;
      i = 2131691315;
      j = 2131690710;
      localObject1 = new avfn(this, (blir)localObject2);
    }
  }
  
  protected View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getActivity().getString(2131689475));
    return localView;
  }
  
  public void onDestroy()
  {
    if ((this.jdField_a_of_type_Bjbs != null) && (this.jdField_a_of_type_Bjbs.isShowing())) {
      a(false);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anyu);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aogx);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    super.onDestroy();
    QQSettingMsgHistoryActivity.a();
    zxx.a(getActivity());
  }
  
  public void onResume()
  {
    super.onResume();
    f();
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      g();
      ((VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).a(new String[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() }, new int[] { 42255 });
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (!aorf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), getActivity())) {}
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof MessageRecord));
      paramObservable = (MessageRecord)paramObject;
    } while (!aguy.a(paramObservable.frienduin, paramObservable.istroop, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QQSettingChatOperationFragment
 * JD-Core Version:    0.7.0.1
 */