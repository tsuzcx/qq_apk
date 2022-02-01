package com.tencent.mobileqq.fragment;

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
import com.tencent.biz.qrcode.activity.ScannerUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.common.util.GCCommon;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.activity.aio.helper.HiddenChatHelper;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.apollo.api.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.app.hiddenchat.HiddenChatFragment;
import com.tencent.mobileqq.app.hiddenchat.HiddenChatUtil;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpic.HotPicDownLoader;
import com.tencent.mobileqq.hotpic.HotVideoPreviewDownloader;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.scribble.ScribbleMsgUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.DeleteRecordDialog;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.ActionSheetHelper;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class QQSettingChatOperationFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, Observer
{
  private long jdField_a_of_type_Long = 0L;
  Handler jdField_a_of_type_AndroidOsHandler = new QQSettingChatOperationFragment.5(this);
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new QQSettingChatOperationFragment.4(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private SVIPObserver jdField_a_of_type_ComTencentMobileqqAppSVIPObserver = new QQSettingChatOperationFragment.3(this);
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private String jdField_a_of_type_JavaLangString = "";
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private QQProgressDialog jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  
  private int a()
  {
    Object localObject = HiddenChatFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a(), TroopAssistantManager.a().c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
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
      if (((paramQQAppInterface.getApp() instanceof BaseApplicationImpl)) && (GlobalImageCache.a != null)) {
        GlobalImageCache.a.evictAll();
      }
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    int i = 0;
    while (i < CardHandler.jdField_a_of_type_JavaUtilVector.size())
    {
      b(CardHandler.jdField_a_of_type_JavaLangString + ((Integer)CardHandler.jdField_a_of_type_JavaUtilVector.get(i)).intValue() + "/");
      i += 1;
    }
    b(CardHandler.jdField_a_of_type_JavaLangString + "background" + "/");
    b(AppConstants.SDCARD_PATH + "temp" + "/");
    b(CardHandler.jdField_a_of_type_JavaLangString + "temp" + "/");
    b(CardHandler.jdField_a_of_type_JavaLangString + "HDAvatar" + "/");
    b(AppConstants.PATH_CARD_QZONE);
    b(CardHandler.jdField_a_of_type_JavaLangString + "voice" + "/");
    b(GCCommon.a() + "/");
    b(AppConstants.SDCARD_PATH_PUBLIC_ACCOUNT_SCREENSHOTS);
    b(HotPicDownLoader.jdField_a_of_type_JavaLangString);
    b(HotVideoPreviewDownloader.jdField_a_of_type_JavaLangString);
    b(ScribbleMsgUtils.a());
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
    {
      if ((!paramBoolean) || (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        break label29;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
    label29:
    while ((paramBoolean) || (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.mContentView.findViewById(2131377554));
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    Object localObject = this.mContentView.findViewById(2131368424);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131380941));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    ((View)localObject).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131374792));
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getC2CRoamingSetting() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ((FormSwitchItem)localObject).setChecked(bool);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.mContentView.findViewById(2131371202));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(2);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131379271));
      this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131365627);
      this.jdField_b_of_type_AndroidViewView = this.mContentView.findViewById(2131365624);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.setContentDescription(getString(2131691548));
      this.jdField_b_of_type_AndroidViewView.setContentDescription(getString(2131691538));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSVIPObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addObserver(this);
      h();
      if (VersionUtils.c()) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOverScrollMode(0);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity(), getActivity().getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getString(2131690933));
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCanceledOnTouchOutside(true);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(true);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(true);
      }
      return;
    }
  }
  
  private void f()
  {
    if (!HiddenChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), getActivity()))
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
        localObject = getResources().getString(2131717092);
        continue;
        localObject = getResources().getString(2131717090);
        continue;
        localObject = getResources().getString(2131717091);
        continue;
        localObject = getResources().getString(2131717093);
        continue;
        localObject = getResources().getString(2131717100);
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().f();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().h();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().i();
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
  
  void a()
  {
    try
    {
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
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
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity(), getActivity().getTitleBarHeight());
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(true);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().h();
    a(this.jdField_a_of_type_JavaLangString, true);
    i();
    d();
    j();
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    c();
    StickerRecManager.f();
    MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.sendEmptyMessage(1009);
    }
  }
  
  void c()
  {
    MessageRoamManager localMessageRoamManager = (MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
    localMessageRoamManager.j();
    localMessageRoamManager.b();
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
    return 2131562928;
  }
  
  public boolean onBackEvent()
  {
    boolean bool = super.onBackEvent();
    HiddenChatHelper.b(getActivity(), GeneralSettingActivity.class);
    return bool;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = false;
    int j = 1;
    if (!NetworkUtil.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext()))
    {
      QQToast.a(getActivity().getApplicationContext(), 2131694459, 1).a();
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
      ReportController.b((AppRuntime)localObject, "CliOper", "", "", "Setting_tab", "Latest_chatlog_syn", 0, i, "0", "0", "", "");
      a(getActivity().getApplication().getResources().getString(2131719068));
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
    if (paramView.getId() == 2131371202)
    {
      localObject2 = new Intent(getActivity(), QQBrowserActivity.class);
      localObject1 = IndividuationUrlHelper.a("vipRoamChatCell");
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
        if (paramView.getId() == 2131368424)
        {
          HiddenChatFragment.a(getActivity(), 1, 0, new Intent());
        }
        else
        {
          if (paramView.getId() != 2131365624) {
            break;
          }
          l1 = System.currentTimeMillis();
          l2 = this.jdField_a_of_type_Long;
          if ((getActivity().isFinishing()) || (l1 - l2 >= 500L))
          {
            this.jdField_a_of_type_Long = l1;
            localObject1 = new DeleteRecordDialog(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
            ((DeleteRecordDialog)localObject1).a(new QQSettingChatOperationFragment.1(this));
            ((DeleteRecordDialog)localObject1).a(HardCodeUtil.a(2131710714));
            ((DeleteRecordDialog)localObject1).b(HardCodeUtil.a(2131710703));
            ((DeleteRecordDialog)localObject1).a(4);
          }
        }
      }
      l1 = System.currentTimeMillis();
      l2 = this.jdField_a_of_type_Long;
    } while ((!getActivity().isFinishing()) && (l1 - l2 < 500L));
    this.jdField_a_of_type_Long = l1;
    Object localObject2 = (ActionSheet)ActionSheetHelper.a(getActivity(), null);
    int i;
    switch (paramView.getId())
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      ((ActionSheet)localObject2).addButton(i, 3);
      ((ActionSheet)localObject2).addCancelButton(getString(2131690800));
      ((ActionSheet)localObject2).setOnButtonClickListener((ActionSheet.OnButtonClickListener)localObject1);
      ((ActionSheet)localObject2).setMainTitle(j);
      ((ActionSheet)localObject2).show();
      break;
      i = 2131691548;
      j = 2131690932;
      localObject1 = new QQSettingChatOperationFragment.2(this, (ActionSheet)localObject2);
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
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      a(false);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSVIPObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().deleteObserver(this);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    super.onDestroy();
    QQSettingMsgHistoryActivity.a();
    ScannerUtils.a(getActivity());
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
      ((IApolloExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(new String[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() }, new int[] { 42255 });
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (!HiddenChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), getActivity())) {}
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof MessageRecord));
      paramObservable = (MessageRecord)paramObject;
    } while (!HiddenChatHelper.a(paramObservable.frienduin, paramObservable.istroop, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QQSettingChatOperationFragment
 * JD-Core Version:    0.7.0.1
 */