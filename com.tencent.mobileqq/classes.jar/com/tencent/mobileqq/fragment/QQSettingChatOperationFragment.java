package com.tencent.mobileqq.fragment;

import aacu;
import abol;
import afai;
import agug;
import aljq;
import alkv;
import alox;
import alpo;
import alsl;
import alxo;
import amey;
import amjk;
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
import ascq;
import ascr;
import ascs;
import asct;
import ascu;
import aspk;
import asri;
import atwd;
import aycc;
import azmj;
import baul;
import bdee;
import bdox;
import bdpx;
import beko;
import bepp;
import bhou;
import bhpy;
import bhql;
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
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import xwb;

public class QQSettingChatOperationFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, Observer
{
  private long jdField_a_of_type_Long;
  alox jdField_a_of_type_Alox = new asct(this);
  private alxo jdField_a_of_type_Alxo = new ascs(this);
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public bepp a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private String jdField_a_of_type_JavaLangString = "";
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private bepp jdField_b_of_type_Bepp;
  
  public QQSettingChatOperationFragment()
  {
    this.jdField_a_of_type_AndroidOsHandler = new ascu(this);
  }
  
  private int a()
  {
    Object localObject = HiddenChatFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(), atwd.a().c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
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
    if (baul.a != null)
    {
      b(baul.a.getAbsolutePath());
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
    while (i < alkv.jdField_a_of_type_JavaUtilVector.size())
    {
      b(alkv.jdField_a_of_type_JavaLangString + ((Integer)alkv.jdField_a_of_type_JavaUtilVector.get(i)).intValue() + "/");
      i += 1;
    }
    b(alkv.jdField_a_of_type_JavaLangString + "background" + "/");
    b(aljq.aX + "temp" + "/");
    b(alkv.jdField_a_of_type_JavaLangString + "temp" + "/");
    b(alkv.jdField_a_of_type_JavaLangString + "HDAvatar" + "/");
    b(aljq.co);
    b(alkv.jdField_a_of_type_JavaLangString + "voice" + "/");
    b(aacu.a() + "/");
    b(aljq.cz);
    b(aspk.jdField_a_of_type_JavaLangString);
    b(asri.jdField_a_of_type_JavaLangString);
    b(aycc.a());
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bepp != null)
    {
      if ((!paramBoolean) || (this.jdField_a_of_type_Bepp.isShowing())) {
        break label29;
      }
      this.jdField_a_of_type_Bepp.show();
    }
    label29:
    while ((paramBoolean) || (!this.jdField_a_of_type_Bepp.isShowing())) {
      return;
    }
    this.jdField_a_of_type_Bepp.dismiss();
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
    b(aljq.aX + "photo/");
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.mContentView.findViewById(2131376146));
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    Object localObject = this.mContentView.findViewById(2131367644);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131379267));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    ((View)localObject).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131373540));
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.e() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ((FormSwitchItem)localObject).setChecked(bool);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.mContentView.findViewById(2131370207));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(2);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131377729));
      this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131365060);
      this.jdField_b_of_type_AndroidViewView = this.mContentView.findViewById(2131365057);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.setContentDescription(getString(2131691550));
      this.jdField_b_of_type_AndroidViewView.setContentDescription(getString(2131691536));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alox);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alxo);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
      h();
      if (bhou.c()) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOverScrollMode(0);
      }
      if (this.jdField_a_of_type_Bepp == null)
      {
        this.jdField_a_of_type_Bepp = new bepp(getActivity(), getActivity().getTitleBarHeight());
        this.jdField_a_of_type_Bepp.a(getString(2131690863));
        this.jdField_a_of_type_Bepp.setCanceledOnTouchOutside(true);
        this.jdField_a_of_type_Bepp.c(true);
        this.jdField_a_of_type_Bepp.a(false);
        this.jdField_a_of_type_Bepp.b(true);
      }
      return;
    }
  }
  
  private void f()
  {
    if (!amey.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), getActivity()))
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
        localObject = getResources().getString(2131717656);
        continue;
        localObject = getResources().getString(2131717654);
        continue;
        localObject = getResources().getString(2131717655);
        continue;
        localObject = getResources().getString(2131717657);
        continue;
        localObject = getResources().getString(2131717674);
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
    b(aljq.aX + this.jdField_a_of_type_JavaLangString + "/" + "ptt/");
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
      if (this.jdField_b_of_type_Bepp != null)
      {
        this.jdField_b_of_type_Bepp.dismiss();
        this.jdField_b_of_type_Bepp.cancel();
        this.jdField_b_of_type_Bepp = null;
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
    if (this.jdField_b_of_type_Bepp == null) {
      this.jdField_b_of_type_Bepp = new bepp(getActivity(), getActivity().getTitleBarHeight());
    }
    this.jdField_b_of_type_Bepp.setCancelable(true);
    this.jdField_b_of_type_Bepp.a(paramString);
    this.jdField_b_of_type_Bepp.show();
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
    agug.f();
    MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.sendEmptyMessage(1009);
    }
  }
  
  void c()
  {
    alsl localalsl = (alsl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(92);
    localalsl.j();
    localalsl.b();
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
    return 2131562541;
  }
  
  public boolean onBackEvent()
  {
    boolean bool = super.onBackEvent();
    afai.b(getActivity(), GeneralSettingActivity.class);
    return bool;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = false;
    int j = 1;
    if (!bdee.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()))
    {
      QQToast.a(getActivity().getApplicationContext(), 2131694766, 1).a();
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
      azmj.b(paramCompoundButton, "CliOper", "", "", "Setting_tab", "Latest_chatlog_syn", 0, i, "0", "0", "", "");
      a(getActivity().getApplication().getResources().getString(2131719799));
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
    if (paramView.getId() == 2131370207)
    {
      localIntent = new Intent(getActivity(), QQBrowserActivity.class);
      paramView = bdox.a("vipRoamChatCell");
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
        if (paramView.getId() == 2131367644)
        {
          HiddenChatFragment.a(getActivity(), 1, 0, new Intent());
          return;
        }
        if (paramView.getId() != 2131365057) {
          break;
        }
        l1 = System.currentTimeMillis();
        l2 = this.jdField_a_of_type_Long;
      } while ((getActivity().isFinishing()) || (l1 - l2 < 500L));
      this.jdField_a_of_type_Long = l1;
      paramView = new beko(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
      paramView.a(new ascq(this));
      paramView.a(alpo.a(2131711122));
      paramView.b(alpo.a(2131711111));
      paramView.a(4);
      return;
      l1 = System.currentTimeMillis();
      l2 = this.jdField_a_of_type_Long;
    } while ((getActivity().isFinishing()) || (l1 - l2 < 500L));
    this.jdField_a_of_type_Long = l1;
    bhpy localbhpy = (bhpy)bhql.a(getActivity(), null);
    int i;
    switch (paramView.getId())
    {
    default: 
      i = 0;
    }
    for (paramView = localIntent;; paramView = new ascr(this, localbhpy))
    {
      localbhpy.a(i, 3);
      localbhpy.d(getString(2131690648));
      localbhpy.a(paramView);
      localbhpy.a(j);
      localbhpy.show();
      return;
      i = 2131691550;
      j = 2131690862;
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
    if ((this.jdField_a_of_type_Bepp != null) && (this.jdField_a_of_type_Bepp.isShowing())) {
      a(false);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alox);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alxo);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    super.onDestroy();
    QQSettingMsgHistoryActivity.a();
    xwb.a(getActivity());
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
      ((bdpx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).a(new String[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() }, new int[] { 42255 });
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (!amey.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), getActivity())) {}
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof MessageRecord));
      paramObservable = (MessageRecord)paramObject;
    } while (!afai.a(paramObservable.frienduin, paramObservable.istroop, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QQSettingChatOperationFragment
 * JD-Core Version:    0.7.0.1
 */