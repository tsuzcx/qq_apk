package com.tencent.mobileqq.fragment;

import adic;
import aexb;
import ajsd;
import ajti;
import ajxj;
import ajya;
import akaw;
import akfy;
import aknj;
import akpb;
import aktf;
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
import aqjb;
import aqjc;
import aqjd;
import aqje;
import aqjf;
import aqyw;
import arau;
import asfd;
import awgy;
import axqy;
import aywm;
import bbfj;
import bbqd;
import bbrd;
import bcln;
import bcqf;
import bcql;
import bfnz;
import bfpc;
import bfpp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.hiddenchat.HiddenChatFragment;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import whj;
import yob;

public class QQSettingChatOperationFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, Observer
{
  private long jdField_a_of_type_Long;
  ajxj jdField_a_of_type_Ajxj = new aqje(this);
  private akfy jdField_a_of_type_Akfy = new aqjd(this);
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public bcqf a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private String jdField_a_of_type_JavaLangString = "";
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private bcqf jdField_b_of_type_Bcqf;
  
  public QQSettingChatOperationFragment()
  {
    this.jdField_a_of_type_AndroidOsHandler = new aqjf(this);
  }
  
  private int a()
  {
    Object localObject = HiddenChatFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(), asfd.a().c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
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
    if (aywm.a != null)
    {
      b(aywm.a.getAbsolutePath());
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
    while (i < ajti.jdField_a_of_type_JavaUtilVector.size())
    {
      b(ajti.jdField_a_of_type_JavaLangString + ((Integer)ajti.jdField_a_of_type_JavaUtilVector.get(i)).intValue() + "/");
      i += 1;
    }
    b(ajti.jdField_a_of_type_JavaLangString + "background" + "/");
    b(ajsd.aW + "temp" + "/");
    b(ajti.jdField_a_of_type_JavaLangString + "temp" + "/");
    b(ajti.jdField_a_of_type_JavaLangString + "HDAvatar" + "/");
    b(ajsd.cn);
    b(ajti.jdField_a_of_type_JavaLangString + "voice" + "/");
    b(yob.a() + "/");
    b(ajsd.cy);
    b(aqyw.jdField_a_of_type_JavaLangString);
    b(arau.jdField_a_of_type_JavaLangString);
    b(awgy.a());
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bcqf != null)
    {
      if ((!paramBoolean) || (this.jdField_a_of_type_Bcqf.isShowing())) {
        break label29;
      }
      this.jdField_a_of_type_Bcqf.show();
    }
    label29:
    while ((paramBoolean) || (!this.jdField_a_of_type_Bcqf.isShowing())) {
      return;
    }
    this.jdField_a_of_type_Bcqf.dismiss();
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
    b(ajsd.aW + "photo/");
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.mContentView.findViewById(2131375654));
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    Object localObject = this.mContentView.findViewById(2131367516);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131378650));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    ((View)localObject).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131373103));
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.e() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ((FormSwitchItem)localObject).setChecked(bool);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.mContentView.findViewById(2131369942));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(2);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131377208));
      this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131364975);
      this.jdField_b_of_type_AndroidViewView = this.mContentView.findViewById(2131364972);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.setContentDescription(getString(2131691496));
      this.jdField_b_of_type_AndroidViewView.setContentDescription(getString(2131691482));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajxj);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akfy);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
      h();
      if (bfnz.c()) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOverScrollMode(0);
      }
      if (this.jdField_a_of_type_Bcqf == null)
      {
        this.jdField_a_of_type_Bcqf = new bcqf(getActivity(), getActivity().getTitleBarHeight());
        this.jdField_a_of_type_Bcqf.a(getString(2131690811));
        this.jdField_a_of_type_Bcqf.setCanceledOnTouchOutside(true);
        this.jdField_a_of_type_Bcqf.c(true);
        this.jdField_a_of_type_Bcqf.a(false);
        this.jdField_a_of_type_Bcqf.b(true);
      }
      return;
    }
  }
  
  private void f()
  {
    if (!aknj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), getActivity()))
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
        localObject = getResources().getString(2131717284);
        continue;
        localObject = getResources().getString(2131717282);
        continue;
        localObject = getResources().getString(2131717283);
        continue;
        localObject = getResources().getString(2131717285);
        continue;
        localObject = getResources().getString(2131717302);
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
    b(ajsd.aW + this.jdField_a_of_type_JavaLangString + "/" + "ptt/");
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
      if (this.jdField_b_of_type_Bcqf != null)
      {
        this.jdField_b_of_type_Bcqf.dismiss();
        this.jdField_b_of_type_Bcqf.cancel();
        this.jdField_b_of_type_Bcqf = null;
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
    if (this.jdField_b_of_type_Bcqf == null) {
      this.jdField_b_of_type_Bcqf = new bcqf(getActivity(), getActivity().getTitleBarHeight());
    }
    this.jdField_b_of_type_Bcqf.setCancelable(true);
    this.jdField_b_of_type_Bcqf.a(paramString);
    this.jdField_b_of_type_Bcqf.show();
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
    aexb.f();
    MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.sendEmptyMessage(1009);
    }
  }
  
  void c()
  {
    akaw localakaw = (akaw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92);
    localakaw.j();
    localakaw.b();
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
    return 2131562337;
  }
  
  public boolean onBackEvent()
  {
    boolean bool = super.onBackEvent();
    adic.b(getActivity(), GeneralSettingActivity.class);
    return bool;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = false;
    int j = 1;
    if (!bbfj.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()))
    {
      bcql.a(getActivity().getApplicationContext(), 2131694610, 1).a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
      paramCompoundButton = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      paramBoolean = bool;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.e() == 1) {
        paramBoolean = true;
      }
      paramCompoundButton.setChecked(paramBoolean);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      return;
    }
    paramCompoundButton = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (paramBoolean)
    {
      i = 1;
      axqy.b(paramCompoundButton, "CliOper", "", "", "Setting_tab", "Latest_chatlog_syn", 0, i, "0", "0", "", "");
      a(getActivity().getApplication().getResources().getString(2131719318));
      if (!paramBoolean) {
        break label164;
      }
    }
    label164:
    for (int i = j;; i = 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.g(i);
      return;
      i = 0;
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    Intent localIntent = null;
    int j = 0;
    if (paramView.getId() == 2131369942)
    {
      localIntent = new Intent(getActivity(), QQBrowserActivity.class);
      paramView = bbqd.a("vipRoamChatCell");
      if (TextUtils.isEmpty(paramView)) {
        QLog.e("QQSettingChatOperationFragment", 1, "gotoRoamMessageSettingUrl ! url empty");
      }
    }
    long l1;
    long l2;
    do
    {
      do
      {
        return;
        if (paramView.contains("?")) {}
        for (paramView = paramView + "&ADTAG=msgRoam";; paramView = paramView + "?ADTAG=msgRoam")
        {
          localIntent.putExtra("url", paramView);
          startActivity(localIntent);
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history", "ChatHistory", "Clk_RoamMsgSetting", 2, 0, new String[] { "0", "0", "msgRoam" });
          return;
        }
        if (paramView.getId() == 2131367516)
        {
          HiddenChatFragment.a(getActivity(), 1, 0, new Intent());
          return;
        }
        if (paramView.getId() != 2131364972) {
          break;
        }
        l1 = System.currentTimeMillis();
        l2 = this.jdField_a_of_type_Long;
      } while ((getActivity().isFinishing()) || (l1 - l2 < 500L));
      this.jdField_a_of_type_Long = l1;
      paramView = new bcln(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
      paramView.a(new aqjb(this));
      paramView.a(ajya.a(2131710750));
      paramView.b(ajya.a(2131710739));
      paramView.a(4);
      return;
      l1 = System.currentTimeMillis();
      l2 = this.jdField_a_of_type_Long;
    } while ((getActivity().isFinishing()) || (l1 - l2 < 500L));
    this.jdField_a_of_type_Long = l1;
    bfpc localbfpc = (bfpc)bfpp.a(getActivity(), null);
    int i;
    switch (paramView.getId())
    {
    default: 
      i = 0;
    }
    for (paramView = localIntent;; paramView = new aqjc(this, localbfpc))
    {
      localbfpc.a(i, 3);
      localbfpc.d(getString(2131690596));
      localbfpc.a(paramView);
      localbfpc.a(j);
      localbfpc.show();
      return;
      i = 2131691496;
      j = 2131690810;
    }
  }
  
  protected View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getActivity().getString(2131689494));
    return localView;
  }
  
  public void onDestroy()
  {
    if ((this.jdField_a_of_type_Bcqf != null) && (this.jdField_a_of_type_Bcqf.isShowing())) {
      a(false);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajxj);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akfy);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    super.onDestroy();
    QQSettingMsgHistoryActivity.a();
    whj.a(getActivity());
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
      ((bbrd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).a(new String[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() }, new int[] { 42255 });
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (!aknj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), getActivity())) {}
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof MessageRecord));
      paramObservable = (MessageRecord)paramObject;
    } while (!adic.a(paramObservable.frienduin, paramObservable.istroop, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QQSettingChatOperationFragment
 * JD-Core Version:    0.7.0.1
 */