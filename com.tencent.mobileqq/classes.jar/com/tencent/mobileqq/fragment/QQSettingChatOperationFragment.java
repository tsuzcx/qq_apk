package com.tencent.mobileqq.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.common.util.GCCommon;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.activity.aio.helper.HiddenChatHelper;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecManager;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
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
import com.tencent.mobileqq.qrscan.utils.QRUtils;
import com.tencent.mobileqq.scribble.ScribbleMsgConstants;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.roamsetting.RoamSettingObserver;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.DeleteRecordDialog;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
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
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class QQSettingChatOperationFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, Observer
{
  private long jdField_a_of_type_Long = 0L;
  Handler jdField_a_of_type_AndroidOsHandler = new QQSettingChatOperationFragment.6(this);
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new QQSettingChatOperationFragment.5(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private SVIPObserver jdField_a_of_type_ComTencentMobileqqAppSVIPObserver = new QQSettingChatOperationFragment.3(this);
  RoamSettingObserver jdField_a_of_type_ComTencentMobileqqTroopRoamsettingRoamSettingObserver = new QQSettingChatOperationFragment.4(this);
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
    int j = 0;
    int i = 0;
    if (localObject != null)
    {
      if (((List)localObject).isEmpty()) {
        return 0;
      }
      localObject = ((List)localObject).iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        RecentUser localRecentUser = (RecentUser)((Iterator)localObject).next();
        i += this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(localRecentUser.uin, localRecentUser.getType());
      }
    }
    return j;
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
      paramString = new StringBuilder();
      paramString.append(CardHandler.jdField_a_of_type_JavaLangString);
      paramString.append(((Integer)CardHandler.jdField_a_of_type_JavaUtilVector.get(i)).intValue());
      paramString.append("/");
      b(paramString.toString());
      i += 1;
    }
    paramString = new StringBuilder();
    paramString.append(CardHandler.jdField_a_of_type_JavaLangString);
    paramString.append("background");
    paramString.append("/");
    b(paramString.toString());
    paramString = new StringBuilder();
    paramString.append(AppConstants.SDCARD_PATH);
    paramString.append("temp");
    paramString.append("/");
    b(paramString.toString());
    paramString = new StringBuilder();
    paramString.append(CardHandler.jdField_a_of_type_JavaLangString);
    paramString.append("temp");
    paramString.append("/");
    b(paramString.toString());
    paramString = new StringBuilder();
    paramString.append(CardHandler.jdField_a_of_type_JavaLangString);
    paramString.append("HDAvatar");
    paramString.append("/");
    b(paramString.toString());
    b(AppConstants.PATH_CARD_QZONE);
    paramString = new StringBuilder();
    paramString.append(CardHandler.jdField_a_of_type_JavaLangString);
    paramString.append("voice");
    paramString.append("/");
    b(paramString.toString());
    paramString = new StringBuilder();
    paramString.append(GCCommon.a());
    paramString.append("/");
    b(paramString.toString());
    b(AppConstants.SDCARD_PATH_PUBLIC_ACCOUNT_SCREENSHOTS);
    b(HotPicDownLoader.jdField_a_of_type_JavaLangString);
    b(HotVideoPreviewDownloader.jdField_a_of_type_JavaLangString);
    b(ScribbleMsgConstants.a());
  }
  
  private void a(boolean paramBoolean)
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if (localQQProgressDialog != null)
    {
      if ((paramBoolean) && (!localQQProgressDialog.isShowing()))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        return;
      }
      if ((!paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
    }
  }
  
  private static void b(String paramString)
  {
    paramString = new File(paramString).listFiles();
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
  
  static void d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("photo/");
    b(localStringBuilder.toString());
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.mContentView.findViewById(2131376998));
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    Object localObject = this.mContentView.findViewById(2131368175);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131380207));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    ((View)localObject).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)this.mContentView.findViewById(2131374327));
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    boolean bool;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getC2CRoamingSetting() == 1) {
      bool = true;
    } else {
      bool = false;
    }
    ((FormSwitchItem)localObject).setChecked(bool);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)this.mContentView.findViewById(2131370827));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightTextColor(2);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131378632));
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131365471);
    this.jdField_b_of_type_AndroidViewView = this.mContentView.findViewById(2131365468);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setContentDescription(getString(2131691469));
    this.jdField_b_of_type_AndroidViewView.setContentDescription(getString(2131691459));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopRoamsettingRoamSettingObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSVIPObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addObserver(this);
    h();
    if (VersionUtils.c()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOverScrollMode(0);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getBaseActivity(), getBaseActivity().getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getString(2131690861));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCanceledOnTouchOutside(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(true);
    }
  }
  
  private void f()
  {
    if (!HiddenChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), getBaseActivity()))
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
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(i);
      localStringBuilder.append("");
      localTextView.setText(localStringBuilder.toString());
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void g()
  {
    if (getBaseActivity() == null)
    {
      QLog.e("QQSettingChatOperationFragment", 1, "syncMessageRoamFlag: activity is null");
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("message_roam_flag");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    int i = ((SharedPreferences)localObject).getInt(localStringBuilder.toString(), 0);
    localObject = null;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i == 5) {
              localObject = getResources().getString(2131716751);
            }
          }
          else {
            localObject = getResources().getString(2131716749);
          }
        }
        else {
          localObject = getResources().getString(2131716750);
        }
      }
      else {
        localObject = getResources().getString(2131716752);
      }
    }
    else {
      localObject = getResources().getString(2131716759);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)localObject);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("messge roam flag is error ,is : ");
      ((StringBuilder)localObject).append(i);
      QLog.d("QQSettingMsgHistoryActivity", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void h()
  {
    Intent localIntent = getBaseActivity().getIntent();
    int i;
    if ((localIntent != null) && (localIntent.hasExtra("set_display_type"))) {
      i = localIntent.getIntExtra("set_display_type", 0);
    } else {
      i = 0;
    }
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
  }
  
  private void i()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("/");
    localStringBuilder.append("ptt/");
    b(localStringBuilder.toString());
  }
  
  private void j()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().j();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b();
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
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  void a(String paramString)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getBaseActivity(), getBaseActivity().getTitleBarHeight());
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(true);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().j();
    a(this.jdField_a_of_type_JavaLangString, true);
    i();
    d();
    j();
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    c();
    ((IStickerRecManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IStickerRecManager.class)).deletePicCache();
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
    if ((getBaseActivity().getAppRuntime() instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getBaseActivity().getAppRuntime());
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        e();
      }
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131562743;
  }
  
  public boolean onBackEvent()
  {
    boolean bool = super.onBackEvent();
    HiddenChatHelper.b(getBaseActivity(), GeneralSettingActivity.class);
    return bool;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void onClick(View paramView)
  {
    int j = paramView.getId();
    int i = 0;
    Object localObject2;
    Object localObject1;
    if (j == 2131370827)
    {
      localObject2 = new Intent(getBaseActivity(), QQBrowserActivity.class);
      localObject1 = IndividuationUrlHelper.a("vipRoamChatCell");
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        QLog.e("QQSettingChatOperationFragment", 1, "gotoRoamMessageSettingUrl ! url empty");
      }
      else
      {
        StringBuilder localStringBuilder;
        if (((String)localObject1).contains("?"))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append("&ADTAG=msgRoam");
          localObject1 = localStringBuilder.toString();
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append("?ADTAG=msgRoam");
          localObject1 = localStringBuilder.toString();
        }
        ((Intent)localObject2).putExtra("url", (String)localObject1);
        startActivity((Intent)localObject2);
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history", "ChatHistory", "Clk_RoamMsgSetting", 2, 0, new String[] { "0", "0", "msgRoam" });
      }
    }
    else if (paramView.getId() == 2131368175)
    {
      HiddenChatFragment.a(getBaseActivity(), 1, 0, new Intent());
    }
    else
    {
      long l1;
      long l2;
      if (paramView.getId() == 2131365468)
      {
        l1 = System.currentTimeMillis();
        l2 = this.jdField_a_of_type_Long;
        if ((!getBaseActivity().isFinishing()) && (l1 - l2 >= 500L))
        {
          this.jdField_a_of_type_Long = l1;
          localObject1 = new DeleteRecordDialog(getBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
          ((DeleteRecordDialog)localObject1).a(new QQSettingChatOperationFragment.1(this));
          ((DeleteRecordDialog)localObject1).a(HardCodeUtil.a(2131710691));
          ((DeleteRecordDialog)localObject1).b(HardCodeUtil.a(2131710680));
          ((DeleteRecordDialog)localObject1).a(4);
        }
      }
      else
      {
        l1 = System.currentTimeMillis();
        l2 = this.jdField_a_of_type_Long;
        if ((!getBaseActivity().isFinishing()) && (l1 - l2 >= 500L))
        {
          this.jdField_a_of_type_Long = l1;
          localObject2 = getBaseActivity();
          localObject1 = null;
          localObject2 = (ActionSheet)ActionSheetHelper.a((Context)localObject2, null);
          if (paramView.getId() != 2131365471)
          {
            j = 0;
          }
          else
          {
            i = 2131691469;
            localObject1 = new QQSettingChatOperationFragment.2(this, (ActionSheet)localObject2);
            j = 2131690860;
          }
          ((ActionSheet)localObject2).addButton(i, 3);
          ((ActionSheet)localObject2).addCancelButton(getString(2131690728));
          ((ActionSheet)localObject2).setOnButtonClickListener((ActionSheet.OnButtonClickListener)localObject1);
          ((ActionSheet)localObject2).setMainTitle(j);
          ((ActionSheet)localObject2).show();
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getBaseActivity().getString(2131689475));
    return localView;
  }
  
  public void onDestroy()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localObject != null) && (((QQProgressDialog)localObject).isShowing())) {
      a(false);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject != null)
    {
      ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopRoamsettingRoamSettingObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSVIPObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().deleteObserver(this);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    super.onDestroy();
    QQSettingMsgHistoryActivity.a();
    QRUtils.a(getBaseActivity());
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
    if (!HiddenChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), getBaseActivity())) {
      return;
    }
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if (!HiddenChatHelper.a(paramObservable.frienduin, paramObservable.istroop, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        return;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QQSettingChatOperationFragment
 * JD-Core Version:    0.7.0.1
 */