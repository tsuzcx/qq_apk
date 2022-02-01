package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarContext;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper.AIOShortcutBarEvent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.troop.utils.RobotUtils;
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
  
  private String a(String paramString1, String paramString2, String paramString3, RobotPanelLayoutBase.RobotPanelItemData paramRobotPanelItemData, ITroopRobotService paramITroopRobotService)
  {
    boolean bool = paramRobotPanelItemData.jdField_b_of_type_Boolean;
    Object localObject = "";
    int i;
    if (bool)
    {
      paramRobotPanelItemData.jdField_b_of_type_Boolean = false;
      paramITroopRobotService.closeTalking();
      i = paramRobotPanelItemData.jdField_b_of_type_ComTencentMobileqqTroopWidgetRobotPanelLayoutBase$RobotPanelItemInfoData.c.indexOf("content=");
      paramString3 = (String)localObject;
      if (i > 0) {
        paramString3 = paramRobotPanelItemData.jdField_b_of_type_ComTencentMobileqqTroopWidgetRobotPanelLayoutBase$RobotPanelItemInfoData.c.substring(i + 8);
      }
      localObject = paramRobotPanelItemData.jdField_b_of_type_ComTencentMobileqqTroopWidgetRobotPanelLayoutBase$RobotPanelItemInfoData.jdField_a_of_type_JavaLangString;
      paramITroopRobotService.report("panel", "talk_out", paramString2, paramString2, "1", "");
    }
    else
    {
      String str = paramRobotPanelItemData.a.jdField_a_of_type_JavaLangString;
      paramRobotPanelItemData.jdField_b_of_type_Boolean = true;
      paramITroopRobotService.openTalking(paramString1, paramString2, paramString3);
      i = paramRobotPanelItemData.a.c.indexOf("content=");
      paramString3 = (String)localObject;
      if (i > 0) {
        paramString3 = paramRobotPanelItemData.a.c.substring(i + 8);
      }
      paramITroopRobotService.report("panel", "talk_in", paramString2, paramString2, "", "");
      localObject = str;
    }
    try
    {
      l1 = Long.parseLong(paramString1);
      l2 = Long.parseLong(paramString2);
    }
    catch (Exception paramString1)
    {
      long l1;
      long l2;
      label223:
      break label223;
    }
    try
    {
      paramITroopRobotService.reqGrayTips(l1, l2, paramString3, new TroopAIORobotLayout.3(this, paramRobotPanelItemData));
      return localObject;
    }
    catch (Exception paramString1) {}
    return localObject;
    return localObject;
  }
  
  private void a(AIOShortcutBarContext paramAIOShortcutBarContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramAIOShortcutBarContext != null) && (!TextUtils.isEmpty(paramString1)))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      SpannableString localSpannableString = null;
      if ((paramAIOShortcutBarContext.a() instanceof QQAppInterface)) {
        localSpannableString = AtTroopMemberSpan.a((QQAppInterface)paramAIOShortcutBarContext.a(), getContext(), paramString1, paramString1, paramString2, false, true);
      }
      if (localSpannableString != null) {
        if (!paramBoolean) {
          paramAIOShortcutBarContext.a().setText(localSpannableString);
        } else {
          paramAIOShortcutBarContext.a().append(localSpannableString);
        }
      }
      paramAIOShortcutBarContext.a().append(" ");
      paramAIOShortcutBarContext.a().setSelection(paramAIOShortcutBarContext.a().getText().length());
      paramAIOShortcutBarContext.a(paramString1, paramString2, true, 0);
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, ITroopRobotService paramITroopRobotService, boolean paramBoolean)
  {
    String str1;
    if (!paramBoolean) {
      str1 = "off";
    } else {
      str1 = "on";
    }
    int j = b();
    if (j <= 0) {
      return;
    }
    int i = 0;
    String str2;
    for (;;)
    {
      str2 = str1;
      if (i >= j) {
        break;
      }
      RobotPanelLayoutBase.RobotPanelItemData localRobotPanelItemData = (RobotPanelLayoutBase.RobotPanelItemData)a(i);
      if ((localRobotPanelItemData != null) && (!TextUtils.isEmpty(localRobotPanelItemData.jdField_b_of_type_ComTencentMobileqqTroopWidgetRobotPanelLayoutBase$RobotPanelItemInfoData.jdField_a_of_type_JavaLangString)))
      {
        localRobotPanelItemData.jdField_b_of_type_Boolean = paramBoolean;
        if (!paramBoolean)
        {
          i = localRobotPanelItemData.jdField_b_of_type_ComTencentMobileqqTroopWidgetRobotPanelLayoutBase$RobotPanelItemInfoData.c.indexOf("content=");
          str2 = str1;
          if (i <= 0) {
            break;
          }
          str2 = localRobotPanelItemData.jdField_b_of_type_ComTencentMobileqqTroopWidgetRobotPanelLayoutBase$RobotPanelItemInfoData.c.substring(i + 8);
          break;
        }
        i = localRobotPanelItemData.a.c.indexOf("content=");
        str2 = str1;
        if (i <= 0) {
          break;
        }
        str2 = localRobotPanelItemData.a.c.substring(i + 8);
        break;
      }
      i += 1;
    }
    if (paramBoolean) {
      paramITroopRobotService.openTalking(paramString1, paramString2, paramString3);
    } else {
      paramITroopRobotService.closeTalking();
    }
    try
    {
      paramITroopRobotService.reqGrayTips(Long.parseLong(paramString1), Long.parseLong(paramString2), str2, new TroopAIORobotLayout.4(this));
      return;
    }
    catch (Exception paramString1) {}
  }
  
  private boolean b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.a() == null) {
        return true;
      }
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.a().getEditableText().toString();
      if (TextUtils.isEmpty(str)) {
        return true;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("@");
      localStringBuilder.append(this.b);
      return TextUtils.isEmpty(str.replaceFirst(localStringBuilder.toString(), "").trim());
    }
    return true;
  }
  
  public String a(RobotPanelLayoutBase.RobotPanelItemData paramRobotPanelItemData)
  {
    Object localObject = a();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAIORobotLayout", 2, "troopRobotService = null");
      }
      return null;
    }
    paramRobotPanelItemData = a(this.c, this.jdField_a_of_type_JavaLangString, this.b, paramRobotPanelItemData, (ITroopRobotService)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("talking: ");
      ((StringBuilder)localObject).append(paramRobotPanelItemData);
      QLog.d("TroopAIORobotLayout", 2, ((StringBuilder)localObject).toString());
    }
    return paramRobotPanelItemData;
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(RobotPanelLayoutBase.RobotPanelItemData paramRobotPanelItemData)
  {
    Object localObject = a();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAIORobotLayout", 2, "troopRobotService = null");
      }
      return;
    }
    if (b())
    {
      AIOShortcutBarHelper localAIOShortcutBarHelper = (AIOShortcutBarHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.a(52);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.a().append(paramRobotPanelItemData.a.jdField_a_of_type_JavaLangString);
      AIOShortcutBarHelper.AIOShortcutBarEvent localAIOShortcutBarEvent = new AIOShortcutBarHelper.AIOShortcutBarEvent(25);
      localAIOShortcutBarEvent.a().putBoolean("isSending", true);
      localAIOShortcutBarHelper.a(localAIOShortcutBarEvent);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.c();
      localAIOShortcutBarEvent.a().putBoolean("isSending", false);
      localAIOShortcutBarHelper.a(localAIOShortcutBarEvent);
      if (!((ITroopRobotService)localObject).isTalking()) {
        a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext, this.jdField_a_of_type_JavaLangString, this.b, false);
      }
    }
    else
    {
      a(getContext(), paramRobotPanelItemData.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, false, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("send to robot: ");
      ((StringBuilder)localObject).append(paramRobotPanelItemData.a.jdField_a_of_type_JavaLangString);
      QLog.d("TroopAIORobotLayout", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(RobotPanelLayoutBase.RobotPanelItemData paramRobotPanelItemData, String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.a() instanceof QQAppInterface)) {
      RobotUtils.a((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.a(), "0X8009FA2", this.jdField_a_of_type_JavaLangString, paramString);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, AIOShortcutBarContext paramAIOShortcutBarContext, RobotPanelLayoutBase.GetListDataCallback paramGetListDataCallback)
  {
    super.a(paramString1, paramString3, paramAIOShortcutBarContext, paramGetListDataCallback);
    paramAIOShortcutBarContext = a();
    if (paramAIOShortcutBarContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAIORobotLayout", 2, "troopRobotManager = null");
      }
      return;
    }
    long l1 = 0L;
    try
    {
      l2 = Long.parseLong(paramString1);
    }
    catch (Exception localException1)
    {
      long l2;
      long l3;
      label58:
      Context localContext;
      StringBuilder localStringBuilder;
      int i;
      break label58;
    }
    try
    {
      l3 = Long.parseLong(paramString2);
      l1 = l3;
    }
    catch (Exception localException2)
    {
      break label61;
    }
    l2 = 0L;
    label61:
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_JavaLangString.equals(paramString2))) {
      a(false);
    }
    localContext = getContext();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    i = SharedPreUtils.ak(localContext, localStringBuilder.toString());
    paramAIOShortcutBarContext.reqPanelList(l2, l1, i, new TroopAIORobotLayout.1(this, i, paramString2, paramString1, paramString3, paramGetListDataCallback));
  }
  
  public void b(RobotPanelLayoutBase.RobotPanelItemData paramRobotPanelItemData)
  {
    ITroopRobotService localITroopRobotService = a();
    if (localITroopRobotService == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAIORobotLayout", 2, "troopRobotService = null");
      }
      return;
    }
    try
    {
      long l1 = Long.parseLong(this.c);
      long l2 = Long.parseLong(this.jdField_a_of_type_JavaLangString);
      localObject = null;
      int i = paramRobotPanelItemData.a.c.indexOf("content=");
      if (i > 0) {
        localObject = paramRobotPanelItemData.a.c.substring(i + 8);
      }
      AIOShortcutBarHelper localAIOShortcutBarHelper = (AIOShortcutBarHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.a(52);
      if (b())
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.a().append(paramRobotPanelItemData.a.jdField_a_of_type_JavaLangString);
        AIOShortcutBarHelper.AIOShortcutBarEvent localAIOShortcutBarEvent = new AIOShortcutBarHelper.AIOShortcutBarEvent(25);
        if (localAIOShortcutBarHelper != null)
        {
          localAIOShortcutBarEvent.a().putBoolean("isSending", true);
          localAIOShortcutBarHelper.a(localAIOShortcutBarEvent);
          localAIOShortcutBarEvent.a().clear();
          localAIOShortcutBarEvent.a().putBoolean("isSendToRobotServer", true);
          localAIOShortcutBarEvent.a = 18;
          localAIOShortcutBarHelper.a(localAIOShortcutBarEvent);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.c();
        localAIOShortcutBarEvent.a().putBoolean("isSending", false);
        localAIOShortcutBarEvent.a = 25;
        if (localAIOShortcutBarHelper != null) {
          localAIOShortcutBarHelper.a(localAIOShortcutBarEvent);
        }
        if (!localITroopRobotService.isTalking()) {
          a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext, this.jdField_a_of_type_JavaLangString, this.b, false);
        }
      }
      else
      {
        a(getContext(), paramRobotPanelItemData.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, true, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext);
      }
      localITroopRobotService.sendContent(l1, l2, (String)localObject, new TroopAIORobotLayout.2(this, paramRobotPanelItemData));
    }
    catch (Exception localException)
    {
      Object localObject;
      label299:
      break label299;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("send to server: ");
      ((StringBuilder)localObject).append(paramRobotPanelItemData.a.jdField_a_of_type_JavaLangString);
      QLog.d("TroopAIORobotLayout", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void b(RobotPanelLayoutBase.RobotPanelItemData paramRobotPanelItemData, String paramString)
  {
    paramRobotPanelItemData = a();
    if (paramRobotPanelItemData != null) {
      paramRobotPanelItemData.report("panel", "clk", this.c, this.jdField_a_of_type_JavaLangString, paramString, "");
    }
  }
  
  public void d(RobotPanelLayoutBase.RobotPanelItemData paramRobotPanelItemData, String paramString)
  {
    paramRobotPanelItemData = a();
    if (paramRobotPanelItemData != null) {
      paramRobotPanelItemData.report("panel", "clk", this.c, this.jdField_a_of_type_JavaLangString, paramString, "");
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt != 0) {
      this.c = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopAIORobotLayout
 * JD-Core Version:    0.7.0.1
 */