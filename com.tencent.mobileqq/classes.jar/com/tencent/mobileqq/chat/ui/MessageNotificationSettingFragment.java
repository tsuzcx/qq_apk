package com.tencent.mobileqq.chat.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager.RingCallback;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.troopsetting.api.ITroopSettingHandler;
import com.tencent.mobileqq.troop.troopsetting.api.TroopSettingObserver;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class MessageNotificationSettingFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, MessageNotificationSettingManager.RingCallback
{
  private int jdField_a_of_type_Int;
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
  private FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopManager jdField_a_of_type_ComTencentMobileqqAppTroopManager;
  private MessageNotificationSettingManager jdField_a_of_type_ComTencentMobileqqChatMessageNotificationSettingManager;
  private ITroopSettingHandler jdField_a_of_type_ComTencentMobileqqTroopTroopsettingApiITroopSettingHandler;
  private TroopSettingObserver jdField_a_of_type_ComTencentMobileqqTroopTroopsettingApiTroopSettingObserver;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private String jdField_a_of_type_JavaLangString;
  private FormSwitchItem b;
  private FormSwitchItem c;
  
  private void a()
  {
    Object localObject = getBaseActivity().getIntent();
    if (localObject != null)
    {
      this.jdField_a_of_type_JavaLangString = ((Intent)localObject).getStringExtra("uin");
      this.jdField_a_of_type_Int = ((Intent)localObject).getIntExtra("uintype", -1);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" mUin: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" mUinType: ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.e("MessageNotificationSettingFragment", 2, new Object[] { "initData . ", localObject, localStringBuilder.toString() });
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      i = this.jdField_a_of_type_Int;
    }
    this.jdField_a_of_type_ComTencentMobileqqChatMessageNotificationSettingManager.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    int i = this.jdField_a_of_type_Int;
    if (i == 0)
    {
      ReportController.b(null, "dc00898", "", "", "0X800A3C7", "0X800A3C7", 1, 0, "", "", "", "");
      return;
    }
    if (i == 1) {
      ReportController.b(null, "dc00898", "", "", "0X800A3C7", "0X800A3C7", 2, 0, "", "", "", "");
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).a();
  }
  
  public static void a(Activity paramActivity, Intent paramIntent)
  {
    PublicFragmentActivity.a(paramActivity, paramIntent, MessageNotificationSettingFragment.class);
  }
  
  private void a(CompoundButton paramCompoundButton, boolean paramBoolean1, String[] paramArrayOfString, boolean[] paramArrayOfBoolean, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      a(2131692183, 1);
      this.c.setOnCheckedChangeListener(null);
      this.c.setChecked(true ^ paramCompoundButton.isChecked());
      this.c.setOnCheckedChangeListener(this);
      return;
    }
    if (paramBoolean2)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingApiITroopSettingHandler.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), paramInt1, 4096, paramInt2);
      if (paramBoolean1) {
        paramInt1 = 1;
      } else {
        paramInt1 = 2;
      }
      ReportController.b(null, "dc00898", "", "", "0X800A3CD", "0X800A3CD", paramInt1, 0, "", "", "", "");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.setMessageNotificationSetting(3, paramArrayOfString, paramArrayOfBoolean);
    if (paramBoolean1) {
      paramInt1 = 1;
    } else {
      paramInt1 = 2;
    }
    ReportController.b(null, "dc00898", "", "", "0X800A3CA", "0X800A3CA", paramInt1, 0, "", "", "", "");
  }
  
  private boolean a(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo != null) {
      return TroopInfo.isCmdUinFlagEx2Open(paramTroopInfo.cmdUinFlagEx2, 4096) ^ true;
    }
    return true;
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new MessageNotificationSettingFragment.1(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingApiTroopSettingObserver = new MessageNotificationSettingFragment.2(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingApiTroopSettingObserver);
    this.jdField_a_of_type_ComTencentMobileqqChatMessageNotificationSettingManager.a(this);
  }
  
  private void b(CompoundButton paramCompoundButton, boolean paramBoolean1, String[] paramArrayOfString, boolean[] paramArrayOfBoolean, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      a(2131692183, 1);
      this.b.setOnCheckedChangeListener(null);
      this.b.setChecked(true ^ paramCompoundButton.isChecked());
      this.b.setOnCheckedChangeListener(this);
      return;
    }
    if (paramBoolean1) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
    }
    if (paramBoolean2)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingApiITroopSettingHandler.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), paramInt1, 2048, paramInt2);
      if (paramBoolean1) {
        paramInt1 = 1;
      } else {
        paramInt1 = 2;
      }
      ReportController.b(null, "dc00898", "", "", "0X800A3CC", "0X800A3CC", paramInt1, 0, "", "", "", "");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.setMessageNotificationSetting(2, paramArrayOfString, paramArrayOfBoolean);
    if (paramBoolean1) {
      paramInt1 = 1;
    } else {
      paramInt1 = 2;
    }
    ReportController.b(null, "dc00898", "", "", "0X800A3C9", "0X800A3C9", paramInt1, 0, "", "", "", "");
  }
  
  private boolean b(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo != null) {
      return TroopInfo.isCmdUinFlagEx2Open(paramTroopInfo.cmdUinFlagEx2, 2048) ^ true;
    }
    return true;
  }
  
  private void c()
  {
    setTitle(getString(2131694518));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)a(2131377301));
    this.b = ((FormSwitchItem)a(2131377302));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)a(2131377303));
    this.c = ((FormSwitchItem)a(2131377304));
    int i = this.jdField_a_of_type_Int;
    if (i == 0) {
      e();
    } else if (i == 1) {
      d();
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
    this.b.setOnCheckedChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
    this.c.setOnCheckedChangeListener(this);
    if (Build.VERSION.SDK_INT >= 29)
    {
      this.c.setVisibility(8);
      this.b.setBgType(3);
    }
    i = this.jdField_a_of_type_Int;
    if (i == 0)
    {
      VasWebviewUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "bell", "C2C_show", "", 1, 0, 0, "", "", "");
      return;
    }
    if (i == 1) {
      VasWebviewUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "bell", "group_show", "", 1, 0, 0, "", "", "");
    }
  }
  
  private void c(CompoundButton paramCompoundButton, boolean paramBoolean1, String[] paramArrayOfString, boolean[] paramArrayOfBoolean, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      a(2131692183, 1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(true ^ paramCompoundButton.isChecked());
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
      return;
    }
    if (paramBoolean2)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingApiITroopSettingHandler.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), paramInt1, 1024, paramInt2);
      if (paramBoolean1) {
        paramInt1 = 1;
      } else {
        paramInt1 = 2;
      }
      ReportController.b(null, "dc00898", "", "", "0X800A3CB", "0X800A3CB", paramInt1, 0, "", "", "", "");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.setMessageNotificationSetting(1, paramArrayOfString, paramArrayOfBoolean);
    if (paramBoolean1) {
      paramInt1 = 1;
    } else {
      paramInt1 = 2;
    }
    ReportController.b(null, "dc00898", "", "", "0X800A3C8", "0X800A3C8", paramInt1, 0, "", "", "", "");
  }
  
  private boolean c(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo != null) {
      return TroopInfo.isCmdUinFlagEx2Open(paramTroopInfo.cmdUinFlagEx2, 1024) ^ true;
    }
    return true;
  }
  
  private void d()
  {
    TroopInfo localTroopInfo = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(this.jdField_a_of_type_JavaLangString);
    if (localTroopInfo == null)
    {
      QLog.d("MessageNotificationSettingFragment", 1, new Object[] { "initViews: invoked. ", " troopInfo: ", localTroopInfo });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MessageNotificationSettingFragment", 2, new Object[] { "initViews: invoked. ", " troopInfo.cmdUinFlagEx2: ", Long.valueOf(localTroopInfo.cmdUinFlagEx2) });
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(c(localTroopInfo));
    this.b.setChecked(b(localTroopInfo));
    this.c.setChecked(a(localTroopInfo));
    if (b(localTroopInfo))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
  }
  
  private void e()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
    Object localObject2 = this.jdField_a_of_type_JavaLangString;
    boolean bool2 = true;
    localObject1 = ((FriendsManager)localObject1).a((String)localObject2, true);
    if (localObject1 == null)
    {
      QLog.d("MessageNotificationSettingFragment", 1, new Object[] { "initViews: invoked. ", " extensionInfo: ", localObject1 });
      return;
    }
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
    boolean bool1;
    if (((ExtensionInfo)localObject1).messageEnablePreviewNew == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((FormSwitchItem)localObject2).setChecked(bool1);
    localObject2 = this.b;
    if (((ExtensionInfo)localObject1).messageEnableSoundNew == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((FormSwitchItem)localObject2).setChecked(bool1);
    localObject2 = this.c;
    if (((ExtensionInfo)localObject1).messageEnableVibrateNew == 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    ((FormSwitchItem)localObject2).setChecked(bool1);
    if (((ExtensionInfo)localObject1).messageEnableSoundNew == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
  }
  
  protected final <T extends View> T a(int paramInt)
  {
    return this.mContentView.findViewById(paramInt);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqChatMessageNotificationSettingManager.a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem, paramInt, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
  }
  
  protected int getContentLayoutId()
  {
    return 2131559132;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131377303)
    {
      int j = this.jdField_a_of_type_Int;
      int i = 1;
      if (j == 0)
      {
        ReportController.b(null, "dc00898", "", "", "0X800A3C5", "0X800A3C5", 1, 0, "", "", "", "");
        VasWebviewUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "bell", "C2C_click", "", 1, 0, 0, "", "", "");
      }
      else if (j == 1)
      {
        ReportController.b(null, "dc00898", "", "", "0X800A3C5", "0X800A3C5", 3, 0, "", "", "", "");
        VasWebviewUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "bell", "group_click", "", 1, 0, 0, "", "", "");
      }
      Intent localIntent = new Intent(getBaseActivity(), QQBrowserActivity.class);
      String str2 = IndividuationUrlHelper.a("specialCareRingUrl");
      if (this.jdField_a_of_type_Int != 1) {
        i = 0;
      }
      String str1;
      if (i != 0) {
        str1 = "3";
      } else {
        str1 = "2";
      }
      localIntent.putExtra("url", str2.replace("[uid]", this.jdField_a_of_type_JavaLangString).replace("[lType]", str1));
      startActivity(localIntent);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingApiTroopSettingObserver);
    this.jdField_a_of_type_ComTencentMobileqqChatMessageNotificationSettingManager.b(this);
  }
  
  public void onResume()
  {
    super.onResume();
    int k = this.jdField_a_of_type_Int;
    int j = 0;
    int i = 0;
    Object localObject;
    if (k == 0)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(this.jdField_a_of_type_JavaLangString, false);
      if (localObject == null) {
        QLog.d("MessageNotificationSettingFragment", 1, new Object[] { "onResume: invoked. ", " extensionInfo: ", localObject });
      } else {
        i = ((ExtensionInfo)localObject).friendRingId;
      }
      this.jdField_a_of_type_ComTencentMobileqqChatMessageNotificationSettingManager.a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem, i, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      return;
    }
    if (k == 1)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(this.jdField_a_of_type_JavaLangString);
      if (localObject == null)
      {
        QLog.d("MessageNotificationSettingFragment", 1, new Object[] { "onResume: invoked. ", " troopInfo: ", localObject });
        i = j;
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("MessageNotificationSettingFragment", 2, new Object[] { "onResume: invoked. ", " troopInfo.cmdUinFlagEx2: ", Long.valueOf(((TroopInfo)localObject).cmdUinFlagEx2) });
        }
        i = (int)((TroopInfo)localObject).udwCmdUinRingtoneID;
      }
      this.jdField_a_of_type_ComTencentMobileqqChatMessageNotificationSettingManager.a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem, i);
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getBaseActivity().app;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER));
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingApiITroopSettingHandler = ((ITroopSettingHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_SETTING_HANDLER));
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqChatMessageNotificationSettingManager = MessageNotificationSettingManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    a();
    c();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.chat.ui.MessageNotificationSettingFragment
 * JD-Core Version:    0.7.0.1
 */