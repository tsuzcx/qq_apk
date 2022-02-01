package com.tencent.mobileqq.chat.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import anmu;
import anmw;
import anwd;
import anxg;
import aqbp;
import aqbs;
import aqbw;
import aqbx;
import bcst;
import bgnt;
import bgyg;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class MessageNotificationSettingFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, aqbs
{
  private int jdField_a_of_type_Int;
  private anmu jdField_a_of_type_Anmu;
  private anmw jdField_a_of_type_Anmw;
  private anwd jdField_a_of_type_Anwd;
  private anxg jdField_a_of_type_Anxg;
  private aqbp jdField_a_of_type_Aqbp;
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopManager jdField_a_of_type_ComTencentMobileqqAppTroopManager;
  private FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private String jdField_a_of_type_JavaLangString;
  private FormSwitchItem b;
  private FormSwitchItem c;
  
  private void a()
  {
    Intent localIntent = getActivity().getIntent();
    if (localIntent != null)
    {
      this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("uin");
      this.jdField_a_of_type_Int = localIntent.getIntExtra("uintype", -1);
    }
    if (QLog.isColorLevel()) {
      QLog.e("MessageNotificationSettingFragment", 2, new Object[] { "initData . ", " mUin: " + this.jdField_a_of_type_JavaLangString, " mUinType: " + this.jdField_a_of_type_Int });
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Int == -1)) {}
    this.jdField_a_of_type_Aqbp.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Int == 0) {
      bcst.b(null, "dc00898", "", "", "0X800A3C7", "0X800A3C7", 1, 0, "", "", "", "");
    }
    while (this.jdField_a_of_type_Int != 1) {
      return;
    }
    bcst.b(null, "dc00898", "", "", "0X800A3C7", "0X800A3C7", 2, 0, "", "", "", "");
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).a();
  }
  
  public static void a(Activity paramActivity, Intent paramIntent)
  {
    PublicFragmentActivity.a(paramActivity, paramIntent, MessageNotificationSettingFragment.class);
  }
  
  private void b()
  {
    this.jdField_a_of_type_Anmu = new aqbw(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anmu);
    this.jdField_a_of_type_Anxg = new aqbx(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anxg);
    this.jdField_a_of_type_Aqbp.a(this);
  }
  
  private void c()
  {
    setTitle(getString(2131694028));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)a(2131377281));
    this.b = ((FormSwitchItem)a(2131377282));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)a(2131377283));
    this.c = ((FormSwitchItem)a(2131377284));
    Object localObject;
    if (this.jdField_a_of_type_Int == 0)
    {
      localObject = this.jdField_a_of_type_Anmw.a(this.jdField_a_of_type_JavaLangString, true);
      if (localObject == null)
      {
        QLog.d("MessageNotificationSettingFragment", 1, new Object[] { "initViews: invoked. ", " extensionInfo: ", localObject });
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
        this.b.setOnCheckedChangeListener(this);
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this);
        this.c.setOnCheckedChangeListener(this);
        if (Build.VERSION.SDK_INT >= 29)
        {
          this.c.setVisibility(8);
          this.b.setBgType(3);
        }
        if (this.jdField_a_of_type_Int != 0) {
          break label454;
        }
        VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "bell", "C2C_show", "", 1, 0, 0, "", "", "");
      }
    }
    label214:
    label233:
    while (this.jdField_a_of_type_Int != 1)
    {
      return;
      FormSwitchItem localFormSwitchItem = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (((ExtensionInfo)localObject).messageEnablePreviewNew == 0)
      {
        bool = true;
        localFormSwitchItem.setChecked(bool);
        localFormSwitchItem = this.b;
        if (((ExtensionInfo)localObject).messageEnableSoundNew != 0) {
          break label280;
        }
        bool = true;
        localFormSwitchItem.setChecked(bool);
        localFormSwitchItem = this.c;
        if (((ExtensionInfo)localObject).messageEnableVibrateNew != 0) {
          break label285;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        localFormSwitchItem.setChecked(bool);
        if (((ExtensionInfo)localObject).messageEnableSoundNew != 0) {
          break label290;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
        break;
        bool = false;
        break label214;
        bool = false;
        break label233;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      break;
      if (this.jdField_a_of_type_Int != 1) {
        break;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(this.jdField_a_of_type_JavaLangString);
      if (localObject == null)
      {
        QLog.d("MessageNotificationSettingFragment", 1, new Object[] { "initViews: invoked. ", " troopInfo: ", localObject });
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MessageNotificationSettingFragment", 2, new Object[] { "initViews: invoked. ", " troopInfo.cmdUinFlagEx2: ", Long.valueOf(((TroopInfo)localObject).cmdUinFlagEx2) });
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(((TroopInfo)localObject).messageEnablePreview());
      this.b.setChecked(((TroopInfo)localObject).messageEnableSound());
      this.c.setChecked(((TroopInfo)localObject).messageEnableVibrate());
      if (((TroopInfo)localObject).messageEnableSound())
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      break;
    }
    label280:
    label285:
    label290:
    label454:
    VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "bell", "group_show", "", 1, 0, 0, "", "", "");
  }
  
  protected final <T extends View> T a(int paramInt)
  {
    return this.mContentView.findViewById(paramInt);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Aqbp.a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem, paramInt, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
  }
  
  public int getContentLayoutId()
  {
    return 2131559184;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int k = 1;
    int m = 1;
    boolean bool2 = true;
    int n = 1;
    int i1 = 1;
    boolean bool3 = true;
    int i2 = 1;
    int i3 = 1;
    boolean bool1 = true;
    Object localObject = new String[1];
    localObject[0] = this.jdField_a_of_type_JavaLangString;
    boolean[] arrayOfBoolean = new boolean[1];
    arrayOfBoolean[0] = paramBoolean;
    int j;
    label68:
    int i4;
    if (this.jdField_a_of_type_Int == 1)
    {
      i = 1;
      if (!paramBoolean) {
        break label152;
      }
      j = 1;
      i4 = (int)NetConnInfoCenter.getServerTime();
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.a() != paramCompoundButton) {
        break label287;
      }
      if (bgnt.d(BaseApplication.getContext())) {
        break label164;
      }
      a(2131691985, 1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(null);
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
      if (paramCompoundButton.isChecked()) {
        break label158;
      }
      label123:
      ((FormSwitchItem)localObject).setChecked(bool1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(this);
    }
    label152:
    label158:
    label164:
    label376:
    do
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      i = 0;
      break;
      j = 0;
      break label68;
      bool1 = false;
      break label123;
      if (i != 0)
      {
        this.jdField_a_of_type_Anwd.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), j, 1024, i4);
        if (paramBoolean) {}
        for (i = k;; i = 2)
        {
          bcst.b(null, "dc00898", "", "", "0X800A3CB", "0X800A3CB", i, 0, "", "", "", "");
          break;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(1, (String[])localObject, arrayOfBoolean);
      if (paramBoolean) {}
      for (i = m;; i = 2)
      {
        bcst.b(null, "dc00898", "", "", "0X800A3C8", "0X800A3C8", i, 0, "", "", "", "");
        break;
      }
      if (this.b.a() == paramCompoundButton)
      {
        if (!bgnt.d(BaseApplication.getContext()))
        {
          a(2131691985, 1);
          this.b.setOnCheckedChangeListener(null);
          localObject = this.b;
          if (!paramCompoundButton.isChecked()) {}
          for (bool1 = bool2;; bool1 = false)
          {
            ((FormSwitchItem)localObject).setChecked(bool1);
            this.b.setOnCheckedChangeListener(this);
            break;
          }
        }
        if (paramBoolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
          if (i == 0) {
            break label458;
          }
          this.jdField_a_of_type_Anwd.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), j, 2048, i4);
          if (!paramBoolean) {
            break label453;
          }
        }
        for (i = n;; i = 2)
        {
          bcst.b(null, "dc00898", "", "", "0X800A3CC", "0X800A3CC", i, 0, "", "", "", "");
          break;
          this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
          break label376;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(2, (String[])localObject, arrayOfBoolean);
        if (paramBoolean) {}
        for (i = i1;; i = 2)
        {
          bcst.b(null, "dc00898", "", "", "0X800A3C9", "0X800A3C9", i, 0, "", "", "", "");
          break;
        }
      }
    } while (this.c.a() != paramCompoundButton);
    label287:
    label453:
    label458:
    if (!bgnt.d(BaseApplication.getContext()))
    {
      a(2131691985, 1);
      this.c.setOnCheckedChangeListener(null);
      localObject = this.c;
      if (!paramCompoundButton.isChecked()) {}
      for (bool1 = bool3;; bool1 = false)
      {
        ((FormSwitchItem)localObject).setChecked(bool1);
        this.c.setOnCheckedChangeListener(this);
        break;
      }
    }
    if (i != 0)
    {
      this.jdField_a_of_type_Anwd.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), j, 4096, i4);
      if (paramBoolean) {}
      for (i = i2;; i = 2)
      {
        bcst.b(null, "dc00898", "", "", "0X800A3CD", "0X800A3CD", i, 0, "", "", "", "");
        break;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(3, (String[])localObject, arrayOfBoolean);
    if (paramBoolean) {}
    for (int i = i3;; i = 2)
    {
      bcst.b(null, "dc00898", "", "", "0X800A3CA", "0X800A3CA", i, 0, "", "", "", "");
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    label91:
    Intent localIntent;
    String str2;
    int i;
    if (this.jdField_a_of_type_Int == 0)
    {
      bcst.b(null, "dc00898", "", "", "0X800A3C5", "0X800A3C5", 1, 0, "", "", "", "");
      VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "bell", "C2C_click", "", 1, 0, 0, "", "", "");
      localIntent = new Intent(getActivity(), QQBrowserActivity.class);
      str2 = bgyg.a("specialCareRingUrl");
      if (this.jdField_a_of_type_Int != 1) {
        break label233;
      }
      i = 1;
      label125:
      if (i == 0) {
        break label238;
      }
    }
    label233:
    label238:
    for (String str1 = "3";; str1 = "2")
    {
      localIntent.putExtra("url", str2.replace("[uid]", this.jdField_a_of_type_JavaLangString).replace("[lType]", str1));
      startActivity(localIntent);
      break;
      if (this.jdField_a_of_type_Int != 1) {
        break label91;
      }
      bcst.b(null, "dc00898", "", "", "0X800A3C5", "0X800A3C5", 3, 0, "", "", "", "");
      VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "bell", "group_click", "", 1, 0, 0, "", "", "");
      break label91;
      i = 0;
      break label125;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anmu);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anxg);
    this.jdField_a_of_type_Aqbp.b(this);
  }
  
  public void onResume()
  {
    int j = 0;
    int i = 0;
    super.onResume();
    if (this.jdField_a_of_type_Int == 0)
    {
      localObject = this.jdField_a_of_type_Anmw.a(this.jdField_a_of_type_JavaLangString, false);
      if (localObject == null)
      {
        QLog.d("MessageNotificationSettingFragment", 1, new Object[] { "onResume: invoked. ", " extensionInfo: ", localObject });
        this.jdField_a_of_type_Aqbp.a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem, i, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      }
    }
    while (this.jdField_a_of_type_Int != 1) {
      for (;;)
      {
        return;
        i = ((ExtensionInfo)localObject).friendRingId;
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(this.jdField_a_of_type_JavaLangString);
    if (localObject == null) {
      QLog.d("MessageNotificationSettingFragment", 1, new Object[] { "onResume: invoked. ", " troopInfo: ", localObject });
    }
    for (i = j;; i = (int)((TroopInfo)localObject).udwCmdUinRingtoneID)
    {
      this.jdField_a_of_type_Aqbp.a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem, i);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MessageNotificationSettingFragment", 2, new Object[] { "onResume: invoked. ", " troopInfo.cmdUinFlagEx2: ", Long.valueOf(((TroopInfo)localObject).cmdUinFlagEx2) });
      }
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1));
    this.jdField_a_of_type_Anwd = ((anwd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20));
    this.jdField_a_of_type_Anmw = ((anmw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51));
    this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52));
    this.jdField_a_of_type_Aqbp = aqbp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    a();
    c();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.chat.ui.MessageNotificationSettingFragment
 * JD-Core Version:    0.7.0.1
 */