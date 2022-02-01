package com.tencent.mobileqq.fragment;

import abug;
import acmw;
import agij;
import aiin;
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
import anri;
import anvi;
import anvx;
import anzc;
import aodb;
import aomh;
import aoxz;
import auxm;
import auxn;
import auxo;
import auxp;
import auxq;
import avlz;
import avnw;
import awtz;
import bbxw;
import bdla;
import bhnp;
import bint;
import bisl;
import bkzi;
import bkzq;
import bkzz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.hiddenchat.HiddenChatFragment;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.NetworkUtil;
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
import zmk;

public class QQSettingChatOperationFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, Observer
{
  private long jdField_a_of_type_Long;
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  anvi jdField_a_of_type_Anvi = new auxp(this);
  private aodb jdField_a_of_type_Aodb = new auxo(this);
  public bisl a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private String jdField_a_of_type_JavaLangString = "";
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private bisl jdField_b_of_type_Bisl;
  
  public QQSettingChatOperationFragment()
  {
    this.jdField_a_of_type_AndroidOsHandler = new auxq(this);
  }
  
  private int a()
  {
    Object localObject = HiddenChatFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a(), awtz.a().c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    int j;
    if ((localObject == null) || (((List)localObject).isEmpty()))
    {
      j = 0;
      return j;
    }
    localObject = ((List)localObject).iterator();
    RecentUser localRecentUser;
    for (int i = 0;; i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(localRecentUser.uin, localRecentUser.getType()) + i)
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
    if (URLDrawableHelper.diskCachePath != null)
    {
      b(URLDrawableHelper.diskCachePath.getAbsolutePath());
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
    while (i < anri.jdField_a_of_type_JavaUtilVector.size())
    {
      b(anri.jdField_a_of_type_JavaLangString + ((Integer)anri.jdField_a_of_type_JavaUtilVector.get(i)).intValue() + "/");
      i += 1;
    }
    b(anri.jdField_a_of_type_JavaLangString + "background" + "/");
    b(AppConstants.SDCARD_PATH + "temp" + "/");
    b(anri.jdField_a_of_type_JavaLangString + "temp" + "/");
    b(anri.jdField_a_of_type_JavaLangString + "HDAvatar" + "/");
    b(AppConstants.PATH_CARD_QZONE);
    b(anri.jdField_a_of_type_JavaLangString + "voice" + "/");
    b(abug.a() + "/");
    b(AppConstants.SDCARD_PATH_PUBLIC_ACCOUNT_SCREENSHOTS);
    b(avlz.jdField_a_of_type_JavaLangString);
    b(avnw.jdField_a_of_type_JavaLangString);
    b(bbxw.a());
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bisl != null)
    {
      if ((!paramBoolean) || (this.jdField_a_of_type_Bisl.isShowing())) {
        break label29;
      }
      this.jdField_a_of_type_Bisl.show();
    }
    label29:
    while ((paramBoolean) || (!this.jdField_a_of_type_Bisl.isShowing())) {
      return;
    }
    this.jdField_a_of_type_Bisl.dismiss();
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
    b(AppConstants.SDCARD_PATH + "photo/");
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.mContentView.findViewById(2131377134));
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    Object localObject = this.mContentView.findViewById(2131368201);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131380498));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    ((View)localObject).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131374437));
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getC2CRoamingSetting() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ((FormSwitchItem)localObject).setChecked(bool);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.mContentView.findViewById(2131370924));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(2);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131378837));
      this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131365466);
      this.jdField_b_of_type_AndroidViewView = this.mContentView.findViewById(2131365463);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.setContentDescription(getString(2131691438));
      this.jdField_b_of_type_AndroidViewView.setContentDescription(getString(2131691428));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anvi);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aodb);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addObserver(this);
      h();
      if (VersionUtils.isGingerBread()) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOverScrollMode(0);
      }
      if (this.jdField_a_of_type_Bisl == null)
      {
        this.jdField_a_of_type_Bisl = new bisl(getActivity(), getActivity().getTitleBarHeight());
        this.jdField_a_of_type_Bisl.a(getString(2131690828));
        this.jdField_a_of_type_Bisl.setCanceledOnTouchOutside(true);
        this.jdField_a_of_type_Bisl.c(true);
        this.jdField_a_of_type_Bisl.a(false);
        this.jdField_a_of_type_Bisl.b(true);
      }
      return;
    }
  }
  
  private void f()
  {
    if (!aomh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), getActivity()))
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
        localObject = getResources().getString(2131716597);
        continue;
        localObject = getResources().getString(2131716595);
        continue;
        localObject = getResources().getString(2131716596);
        continue;
        localObject = getResources().getString(2131716598);
        continue;
        localObject = getResources().getString(2131716605);
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
    b(AppConstants.SDCARD_PATH + this.jdField_a_of_type_JavaLangString + "/" + "ptt/");
  }
  
  private void j()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().clearAllHistory();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().clearRecentUserList();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().clearMessageCache();
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
      if (this.jdField_b_of_type_Bisl != null)
      {
        this.jdField_b_of_type_Bisl.dismiss();
        this.jdField_b_of_type_Bisl.cancel();
        this.jdField_b_of_type_Bisl = null;
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
    if (this.jdField_b_of_type_Bisl == null) {
      this.jdField_b_of_type_Bisl = new bisl(getActivity(), getActivity().getTitleBarHeight());
    }
    this.jdField_b_of_type_Bisl.setCancelable(true);
    this.jdField_b_of_type_Bisl.a(paramString);
    this.jdField_b_of_type_Bisl.show();
  }
  
  void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().clearRecentUserList();
    a(this.jdField_a_of_type_JavaLangString, true);
    i();
    d();
    j();
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    c();
    aiin.f();
    MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.sendEmptyMessage(1009);
    }
  }
  
  void c()
  {
    anzc localanzc = (anzc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
    localanzc.j();
    localanzc.b();
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
    return 2131562781;
  }
  
  public boolean onBackEvent()
  {
    boolean bool = super.onBackEvent();
    agij.b(getActivity(), GeneralSettingActivity.class);
    return bool;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = false;
    int j = 1;
    if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()))
    {
      QQToast.a(getActivity().getApplicationContext(), 2131694255, 1).a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getC2CRoamingSetting() == 1) {
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
      bdla.b((QQAppInterface)localObject, "CliOper", "", "", "Setting_tab", "Latest_chatlog_syn", 0, i, "0", "0", "", "");
      a(getActivity().getApplication().getResources().getString(2131718545));
      if (!paramBoolean) {
        break label177;
      }
    }
    label177:
    for (int i = j;; i = 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setC2CRoamingSetting(i);
      break;
      i = 0;
      break label104;
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = null;
    int j = 0;
    if (paramView.getId() == 2131370924)
    {
      localObject2 = new Intent(getActivity(), QQBrowserActivity.class);
      localObject1 = bhnp.a("vipRoamChatCell");
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
        if (paramView.getId() == 2131368201)
        {
          HiddenChatFragment.a(getActivity(), 1, 0, new Intent());
        }
        else
        {
          if (paramView.getId() != 2131365463) {
            break;
          }
          l1 = System.currentTimeMillis();
          l2 = this.jdField_a_of_type_Long;
          if ((getActivity().isFinishing()) || (l1 - l2 >= 500L))
          {
            this.jdField_a_of_type_Long = l1;
            localObject1 = new bint(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
            ((bint)localObject1).a(new auxm(this));
            ((bint)localObject1).a(anvx.a(2131710198));
            ((bint)localObject1).b(anvx.a(2131710187));
            ((bint)localObject1).a(4);
          }
        }
      }
      l1 = System.currentTimeMillis();
      l2 = this.jdField_a_of_type_Long;
    } while ((!getActivity().isFinishing()) && (l1 - l2 < 500L));
    this.jdField_a_of_type_Long = l1;
    Object localObject2 = (bkzi)bkzz.a(getActivity(), null);
    int i;
    switch (paramView.getId())
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      ((bkzi)localObject2).a(i, 3);
      ((bkzi)localObject2).d(getString(2131690697));
      ((bkzi)localObject2).a((bkzq)localObject1);
      ((bkzi)localObject2).a(j);
      ((bkzi)localObject2).show();
      break;
      i = 2131691438;
      j = 2131690827;
      localObject1 = new auxn(this, (bkzi)localObject2);
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
    if ((this.jdField_a_of_type_Bisl != null) && (this.jdField_a_of_type_Bisl.isShowing())) {
      a(false);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anvi);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aodb);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().deleteObserver(this);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    super.onDestroy();
    QQSettingMsgHistoryActivity.a();
    zmk.a(getActivity());
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
      ((VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.VAS_EXTENSION_HANDLER)).a(new String[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() }, new int[] { 42255 });
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (!aomh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), getActivity())) {}
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof MessageRecord));
      paramObservable = (MessageRecord)paramObject;
    } while (!agij.a(paramObservable.frienduin, paramObservable.istroop, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QQSettingChatOperationFragment
 * JD-Core Version:    0.7.0.1
 */