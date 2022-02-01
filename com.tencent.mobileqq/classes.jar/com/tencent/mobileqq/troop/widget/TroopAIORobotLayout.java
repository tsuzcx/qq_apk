package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.BaseTroopChatPie;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;

public class TroopAIORobotLayout
  extends RobotPanelLayoutBase
{
  protected String c;
  
  public TroopAIORobotLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public TroopAIORobotLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TroopAIORobotLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private String a(String paramString1, String paramString2, String paramString3, RobotPanelLayoutBase.RobotPanelItemData paramRobotPanelItemData, TroopRobotManager paramTroopRobotManager)
  {
    int i;
    if (paramRobotPanelItemData.jdField_b_of_type_Boolean)
    {
      paramRobotPanelItemData.jdField_b_of_type_Boolean = false;
      paramTroopRobotManager.a();
      i = paramRobotPanelItemData.jdField_b_of_type_ComTencentMobileqqTroopWidgetRobotPanelLayoutBase$RobotPanelItemInfoData.c.indexOf("content=");
      if (i <= 0) {
        break label193;
      }
    }
    label193:
    for (paramString3 = paramRobotPanelItemData.jdField_b_of_type_ComTencentMobileqqTroopWidgetRobotPanelLayoutBase$RobotPanelItemInfoData.c.substring(i + 8);; paramString3 = "")
    {
      String str = paramRobotPanelItemData.jdField_b_of_type_ComTencentMobileqqTroopWidgetRobotPanelLayoutBase$RobotPanelItemInfoData.jdField_a_of_type_JavaLangString;
      TroopRobotManager.a("panel", "talk_out", paramString2, paramString2, "1", "");
      try
      {
        paramTroopRobotManager.b(Long.parseLong(paramString1), Long.parseLong(paramString2), paramString3, new TroopAIORobotLayout.3(this, paramRobotPanelItemData));
        return str;
      }
      catch (Exception paramString1)
      {
        return str;
      }
      str = paramRobotPanelItemData.a.jdField_a_of_type_JavaLangString;
      paramRobotPanelItemData.jdField_b_of_type_Boolean = true;
      paramTroopRobotManager.b(paramString1, paramString2, paramString3);
      i = paramRobotPanelItemData.a.c.indexOf("content=");
      if (i > 0) {}
      for (paramString3 = paramRobotPanelItemData.a.c.substring(i + 8);; paramString3 = "")
      {
        TroopRobotManager.a("panel", "talk_in", paramString2, paramString2, "", "");
        break;
      }
    }
  }
  
  private void a(BaseTroopChatPie paramBaseTroopChatPie, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramBaseTroopChatPie == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    SpannableString localSpannableString = AtTroopMemberSpan.a(paramBaseTroopChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getContext(), paramString1, paramString1, paramString2, false, true);
    if (localSpannableString != null)
    {
      if (paramBoolean) {
        break label93;
      }
      paramBaseTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(localSpannableString);
    }
    for (;;)
    {
      paramBaseTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.append(" ");
      paramBaseTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(paramBaseTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length());
      paramBaseTroopChatPie.a(paramString1, paramString2, true, 0);
      return;
      label93:
      paramBaseTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.append(localSpannableString);
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, TroopRobotManager paramTroopRobotManager, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (String str = "off";; str = "on")
    {
      int j = b();
      if (j <= 0) {
        return;
      }
      int i = 0;
      RobotPanelLayoutBase.RobotPanelItemData localRobotPanelItemData;
      if (i < j)
      {
        localRobotPanelItemData = (RobotPanelLayoutBase.RobotPanelItemData)a(i);
        if ((localRobotPanelItemData != null) && (!TextUtils.isEmpty(localRobotPanelItemData.jdField_b_of_type_ComTencentMobileqqTroopWidgetRobotPanelLayoutBase$RobotPanelItemInfoData.jdField_a_of_type_JavaLangString)))
        {
          localRobotPanelItemData.jdField_b_of_type_Boolean = paramBoolean;
          if (!paramBoolean)
          {
            i = localRobotPanelItemData.jdField_b_of_type_ComTencentMobileqqTroopWidgetRobotPanelLayoutBase$RobotPanelItemInfoData.c.indexOf("content=");
            if (i > 0) {
              str = localRobotPanelItemData.jdField_b_of_type_ComTencentMobileqqTroopWidgetRobotPanelLayoutBase$RobotPanelItemInfoData.c.substring(i + 8);
            }
          }
        }
      }
      for (;;)
      {
        label111:
        if (paramBoolean) {
          paramTroopRobotManager.b(paramString1, paramString2, paramString3);
        }
        for (;;)
        {
          try
          {
            paramTroopRobotManager.b(Long.parseLong(paramString1), Long.parseLong(paramString2), str, new TroopAIORobotLayout.4(this));
            return;
          }
          catch (Exception paramString1)
          {
            return;
          }
          i = localRobotPanelItemData.a.c.indexOf("content=");
          if (i > 0) {
            str = localRobotPanelItemData.a.c.substring(i + 8);
          }
          break label111;
          i += 1;
          break;
          paramTroopRobotManager.a();
        }
      }
    }
  }
  
  private boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx == null)) {}
    String str;
    do
    {
      return true;
      str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().toString();
    } while ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(str.replaceFirst("@" + this.b, "").trim())));
    return false;
  }
  
  public String a(RobotPanelLayoutBase.RobotPanelItemData paramRobotPanelItemData)
  {
    Object localObject = a();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAIORobotLayout", 2, "troopRobotManager = null");
      }
      paramRobotPanelItemData = null;
    }
    do
    {
      return paramRobotPanelItemData;
      localObject = a(this.c, this.jdField_a_of_type_JavaLangString, this.b, paramRobotPanelItemData, (TroopRobotManager)localObject);
      paramRobotPanelItemData = (RobotPanelLayoutBase.RobotPanelItemData)localObject;
    } while (!QLog.isColorLevel());
    QLog.d("TroopAIORobotLayout", 2, "talking: " + (String)localObject);
    return localObject;
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(RobotPanelLayoutBase.RobotPanelItemData paramRobotPanelItemData)
  {
    TroopRobotManager localTroopRobotManager = a();
    if (localTroopRobotManager == null) {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAIORobotLayout", 2, "troopRobotManager = null");
      }
    }
    for (;;)
    {
      return;
      if (b())
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.append(paramRobotPanelItemData.a.jdField_a_of_type_JavaLangString);
        ((BaseTroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie).T = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.ao();
        ((BaseTroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie).T = false;
        if (!localTroopRobotManager.a()) {
          a((BaseTroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_JavaLangString, this.b, false);
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d("TroopAIORobotLayout", 2, "send to robot: " + paramRobotPanelItemData.a.jdField_a_of_type_JavaLangString);
        return;
        a(getContext(), paramRobotPanelItemData.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, false, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
      }
    }
  }
  
  public void a(RobotPanelLayoutBase.RobotPanelItemData paramRobotPanelItemData, String paramString)
  {
    RobotUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8009FA2", this.jdField_a_of_type_JavaLangString, paramString);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, BaseTroopChatPie paramBaseTroopChatPie, RobotPanelLayoutBase.GetListDataCallback paramGetListDataCallback)
  {
    super.a(paramString2, paramString3, paramBaseTroopChatPie, paramGetListDataCallback);
    paramBaseTroopChatPie = a();
    if (paramBaseTroopChatPie == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAIORobotLayout", 2, "troopRobotManager = null");
      }
      return;
    }
    l1 = 0L;
    try
    {
      l2 = Long.parseLong(paramString1);
      l1 = l2;
      l3 = Long.parseLong(paramString2);
      l1 = l3;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        long l3 = 0L;
        long l2 = l1;
        l1 = l3;
      }
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_JavaLangString.equals(paramString2))) {
      a(false);
    }
    i = SharedPreUtils.ap(getContext(), paramString1 + "_" + paramString2);
    paramBaseTroopChatPie.a(l2, l1, i, new TroopAIORobotLayout.1(this, i, paramString2, paramString1, paramString3, paramGetListDataCallback));
  }
  
  public void b(RobotPanelLayoutBase.RobotPanelItemData paramRobotPanelItemData)
  {
    TroopRobotManager localTroopRobotManager = a();
    if (localTroopRobotManager == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAIORobotLayout", 2, "troopRobotManager = null");
      }
      return;
    }
    for (;;)
    {
      try
      {
        long l1 = Long.parseLong(this.c);
        long l2 = Long.parseLong(this.jdField_a_of_type_JavaLangString);
        String str = null;
        int i = paramRobotPanelItemData.a.c.indexOf("content=");
        if (i > 0) {
          str = paramRobotPanelItemData.a.c.substring(i + 8);
        }
        if (!b()) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.append(paramRobotPanelItemData.a.jdField_a_of_type_JavaLangString);
        ((BaseTroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie).T = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.E = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.ao();
        ((BaseTroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie).T = false;
        if (!localTroopRobotManager.a()) {
          a((BaseTroopChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_JavaLangString, this.b, false);
        }
        localTroopRobotManager.a(l1, l2, str, new TroopAIORobotLayout.2(this, paramRobotPanelItemData));
      }
      catch (Exception localException)
      {
        continue;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TroopAIORobotLayout", 2, "send to server: " + paramRobotPanelItemData.a.jdField_a_of_type_JavaLangString);
      return;
      a(getContext(), paramRobotPanelItemData.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, true, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    }
  }
  
  public void b(RobotPanelLayoutBase.RobotPanelItemData paramRobotPanelItemData, String paramString)
  {
    TroopRobotManager.a("panel", "clk", this.c, this.jdField_a_of_type_JavaLangString, paramString, "");
  }
  
  public void d(RobotPanelLayoutBase.RobotPanelItemData paramRobotPanelItemData, String paramString)
  {
    TroopRobotManager.a("panel", "clk", this.c, this.jdField_a_of_type_JavaLangString, paramString, "");
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt != 0) {
      this.c = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopAIORobotLayout
 * JD-Core Version:    0.7.0.1
 */