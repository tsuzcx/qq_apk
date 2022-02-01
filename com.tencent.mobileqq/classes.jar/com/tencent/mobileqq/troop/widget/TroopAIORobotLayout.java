package com.tencent.mobileqq.troop.widget;

import afzn;
import android.content.Context;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import bgcz;
import bghs;
import bgls;
import bgoa;
import bgoc;
import bgod;
import bgoi;
import bgoj;
import bgok;
import bgol;
import bhhr;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;

public class TroopAIORobotLayout
  extends RobotPanelLayoutBase
{
  public String c;
  
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
  
  private String a(String paramString1, String paramString2, String paramString3, bgoc parambgoc, bgls parambgls)
  {
    int i;
    if (parambgoc.jdField_b_of_type_Boolean)
    {
      parambgoc.jdField_b_of_type_Boolean = false;
      parambgls.a();
      i = parambgoc.jdField_b_of_type_Bgod.c.indexOf("content=");
      if (i <= 0) {
        break label193;
      }
    }
    label193:
    for (paramString3 = parambgoc.jdField_b_of_type_Bgod.c.substring(i + 8);; paramString3 = "")
    {
      String str = parambgoc.jdField_b_of_type_Bgod.jdField_a_of_type_JavaLangString;
      bgls.a("panel", "talk_out", paramString2, paramString2, "1", "");
      try
      {
        parambgls.b(Long.parseLong(paramString1), Long.parseLong(paramString2), paramString3, new bgok(this, parambgoc));
        return str;
      }
      catch (Exception paramString1)
      {
        return str;
      }
      str = parambgoc.a.jdField_a_of_type_JavaLangString;
      parambgoc.jdField_b_of_type_Boolean = true;
      parambgls.b(paramString1, paramString2, paramString3);
      i = parambgoc.a.c.indexOf("content=");
      if (i > 0) {}
      for (paramString3 = parambgoc.a.c.substring(i + 8);; paramString3 = "")
      {
        bgls.a("panel", "talk_in", paramString2, paramString2, "", "");
        break;
      }
    }
  }
  
  private void a(afzn paramafzn, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramafzn == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    SpannableString localSpannableString = bgcz.a(paramafzn.app, getContext(), paramString1, paramString1, paramString2, false, true);
    if (localSpannableString != null)
    {
      if (paramBoolean) {
        break label93;
      }
      paramafzn.input.setText(localSpannableString);
    }
    for (;;)
    {
      paramafzn.input.append(" ");
      paramafzn.input.setSelection(paramafzn.input.getText().length());
      paramafzn.a(paramString1, paramString2, true, 0);
      return;
      label93:
      paramafzn.input.append(localSpannableString);
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, bgls parambgls, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (String str = "off";; str = "on")
    {
      int j = b();
      if (j <= 0) {
        return;
      }
      int i = 0;
      bgoc localbgoc;
      if (i < j)
      {
        localbgoc = (bgoc)a(i);
        if ((localbgoc != null) && (!TextUtils.isEmpty(localbgoc.jdField_b_of_type_Bgod.jdField_a_of_type_JavaLangString)))
        {
          localbgoc.jdField_b_of_type_Boolean = paramBoolean;
          if (!paramBoolean)
          {
            i = localbgoc.jdField_b_of_type_Bgod.c.indexOf("content=");
            if (i > 0) {
              str = localbgoc.jdField_b_of_type_Bgod.c.substring(i + 8);
            }
          }
        }
      }
      for (;;)
      {
        label111:
        if (paramBoolean) {
          parambgls.b(paramString1, paramString2, paramString3);
        }
        for (;;)
        {
          try
          {
            parambgls.b(Long.parseLong(paramString1), Long.parseLong(paramString2), str, new bgol(this));
            return;
          }
          catch (Exception paramString1)
          {
            return;
          }
          i = localbgoc.a.c.indexOf("content=");
          if (i > 0) {
            str = localbgoc.a.c.substring(i + 8);
          }
          break label111;
          i += 1;
          break;
          parambgls.a();
        }
      }
    }
  }
  
  private boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input == null)) {}
    String str;
    do
    {
      return true;
      str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.getEditableText().toString();
    } while ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(str.replaceFirst("@" + this.b, "").trim())));
    return false;
  }
  
  public String a(bgoc parambgoc)
  {
    Object localObject = a();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAIORobotLayout", 2, "troopRobotManager = null");
      }
      parambgoc = null;
    }
    do
    {
      return parambgoc;
      localObject = a(this.c, this.jdField_a_of_type_JavaLangString, this.b, parambgoc, (bgls)localObject);
      parambgoc = (bgoc)localObject;
    } while (!QLog.isColorLevel());
    QLog.d("TroopAIORobotLayout", 2, "talking: " + (String)localObject);
    return localObject;
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(bgoc parambgoc)
  {
    bgls localbgls = a();
    if (localbgls == null) {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAIORobotLayout", 2, "troopRobotManager = null");
      }
    }
    for (;;)
    {
      return;
      if (b())
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.append(parambgoc.a.jdField_a_of_type_JavaLangString);
        ((afzn)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie).h = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.send();
        ((afzn)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie).h = false;
        if (!localbgls.a()) {
          a((afzn)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_JavaLangString, this.b, false);
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d("TroopAIORobotLayout", 2, "send to robot: " + parambgoc.a.jdField_a_of_type_JavaLangString);
        return;
        a(getContext(), parambgoc.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, false, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
      }
    }
  }
  
  public void a(bgoc parambgoc, String paramString)
  {
    bghs.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, "0X8009FA2", this.jdField_a_of_type_JavaLangString, paramString);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, afzn paramafzn, bgoa parambgoa)
  {
    super.a(paramString2, paramString3, paramafzn, parambgoa);
    paramafzn = a();
    if (paramafzn == null)
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
    i = bhhr.ap(getContext(), paramString1 + "_" + paramString2);
    paramafzn.a(l2, l1, i, new bgoi(this, i, paramString2, paramString1, paramString3, parambgoa));
  }
  
  public void b(bgoc parambgoc)
  {
    bgls localbgls = a();
    if (localbgls == null)
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
        int i = parambgoc.a.c.indexOf("content=");
        if (i > 0) {
          str = parambgoc.a.c.substring(i + 8);
        }
        if (!b()) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.append(parambgoc.a.jdField_a_of_type_JavaLangString);
        ((afzn)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie).h = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.isSendToRobotServer = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.send();
        ((afzn)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie).h = false;
        if (!localbgls.a()) {
          a((afzn)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_JavaLangString, this.b, false);
        }
        localbgls.a(l1, l2, str, new bgoj(this, parambgoc));
      }
      catch (Exception localException)
      {
        continue;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TroopAIORobotLayout", 2, "send to server: " + parambgoc.a.jdField_a_of_type_JavaLangString);
      return;
      a(getContext(), parambgoc.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, true, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    }
  }
  
  public void b(bgoc parambgoc, String paramString)
  {
    bgls.a("panel", "clk", this.c, this.jdField_a_of_type_JavaLangString, paramString, "");
  }
  
  public void d(bgoc parambgoc, String paramString)
  {
    bgls.a("panel", "clk", this.c, this.jdField_a_of_type_JavaLangString, paramString, "");
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