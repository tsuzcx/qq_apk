package com.tencent.mobileqq.troop.widget;

import aihd;
import android.content.Context;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import bgme;
import bgpy;
import bgty;
import bgwh;
import bgwj;
import bgwk;
import bgwo;
import bgwp;
import bgwq;
import bgwr;
import bhsi;
import com.tencent.mobileqq.activity.BaseChatPie;
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
  
  private String a(String paramString1, String paramString2, String paramString3, bgwj parambgwj, bgty parambgty)
  {
    int i;
    if (parambgwj.jdField_b_of_type_Boolean)
    {
      parambgwj.jdField_b_of_type_Boolean = false;
      parambgty.a();
      i = parambgwj.jdField_b_of_type_Bgwk.c.indexOf("content=");
      if (i <= 0) {
        break label193;
      }
    }
    label193:
    for (paramString3 = parambgwj.jdField_b_of_type_Bgwk.c.substring(i + 8);; paramString3 = "")
    {
      String str = parambgwj.jdField_b_of_type_Bgwk.jdField_a_of_type_JavaLangString;
      bgty.a("panel", "talk_out", paramString2, paramString2, "1", "");
      try
      {
        parambgty.b(Long.parseLong(paramString1), Long.parseLong(paramString2), paramString3, new bgwq(this, parambgwj));
        return str;
      }
      catch (Exception paramString1)
      {
        return str;
      }
      str = parambgwj.a.jdField_a_of_type_JavaLangString;
      parambgwj.jdField_b_of_type_Boolean = true;
      parambgty.b(paramString1, paramString2, paramString3);
      i = parambgwj.a.c.indexOf("content=");
      if (i > 0) {}
      for (paramString3 = parambgwj.a.c.substring(i + 8);; paramString3 = "")
      {
        bgty.a("panel", "talk_in", paramString2, paramString2, "", "");
        break;
      }
    }
  }
  
  private void a(aihd paramaihd, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramaihd == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    SpannableString localSpannableString = bgme.a(paramaihd.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getContext(), paramString1, paramString1, paramString2, false, true);
    if (localSpannableString != null)
    {
      if (paramBoolean) {
        break label93;
      }
      paramaihd.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(localSpannableString);
    }
    for (;;)
    {
      paramaihd.jdField_a_of_type_ComTencentWidgetXEditTextEx.append(" ");
      paramaihd.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(paramaihd.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length());
      paramaihd.a(paramString1, paramString2, true, 0);
      return;
      label93:
      paramaihd.jdField_a_of_type_ComTencentWidgetXEditTextEx.append(localSpannableString);
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, bgty parambgty, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (String str = "off";; str = "on")
    {
      int j = b();
      if (j <= 0) {
        return;
      }
      int i = 0;
      bgwj localbgwj;
      if (i < j)
      {
        localbgwj = (bgwj)a(i);
        if ((localbgwj != null) && (!TextUtils.isEmpty(localbgwj.jdField_b_of_type_Bgwk.jdField_a_of_type_JavaLangString)))
        {
          localbgwj.jdField_b_of_type_Boolean = paramBoolean;
          if (!paramBoolean)
          {
            i = localbgwj.jdField_b_of_type_Bgwk.c.indexOf("content=");
            if (i > 0) {
              str = localbgwj.jdField_b_of_type_Bgwk.c.substring(i + 8);
            }
          }
        }
      }
      for (;;)
      {
        label111:
        if (paramBoolean) {
          parambgty.b(paramString1, paramString2, paramString3);
        }
        for (;;)
        {
          try
          {
            parambgty.b(Long.parseLong(paramString1), Long.parseLong(paramString2), str, new bgwr(this));
            return;
          }
          catch (Exception paramString1)
          {
            return;
          }
          i = localbgwj.a.c.indexOf("content=");
          if (i > 0) {
            str = localbgwj.a.c.substring(i + 8);
          }
          break label111;
          i += 1;
          break;
          parambgty.a();
        }
      }
    }
  }
  
  private boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx == null)) {}
    String str;
    do
    {
      return true;
      str = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().toString();
    } while ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(str.replaceFirst("@" + this.b, "").trim())));
    return false;
  }
  
  public String a(bgwj parambgwj)
  {
    Object localObject = a();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAIORobotLayout", 2, "troopRobotManager = null");
      }
      parambgwj = null;
    }
    do
    {
      return parambgwj;
      localObject = a(this.c, this.jdField_a_of_type_JavaLangString, this.b, parambgwj, (bgty)localObject);
      parambgwj = (bgwj)localObject;
    } while (!QLog.isColorLevel());
    QLog.d("TroopAIORobotLayout", 2, "talking: " + (String)localObject);
    return localObject;
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(bgwj parambgwj)
  {
    bgty localbgty = a();
    if (localbgty == null) {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAIORobotLayout", 2, "troopRobotManager = null");
      }
    }
    for (;;)
    {
      return;
      if (b())
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.append(parambgwj.a.jdField_a_of_type_JavaLangString);
        ((aihd)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).Y = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c();
        ((aihd)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).Y = false;
        if (!localbgty.a()) {
          a((aihd)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_a_of_type_JavaLangString, this.b, false);
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d("TroopAIORobotLayout", 2, "send to robot: " + parambgwj.a.jdField_a_of_type_JavaLangString);
        return;
        a(getContext(), parambgwj.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, false, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      }
    }
  }
  
  public void a(bgwj parambgwj, String paramString)
  {
    bgpy.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8009FA2", this.jdField_a_of_type_JavaLangString, paramString);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, aihd paramaihd, bgwh parambgwh)
  {
    super.a(paramString2, paramString3, paramaihd, parambgwh);
    paramaihd = a();
    if (paramaihd == null)
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
    i = bhsi.ao(getContext(), paramString1 + "_" + paramString2);
    paramaihd.a(l2, l1, i, new bgwo(this, i, paramString2, paramString1, paramString3, parambgwh));
  }
  
  public void b(bgwj parambgwj)
  {
    bgty localbgty = a();
    if (localbgty == null)
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
        int i = parambgwj.a.c.indexOf("content=");
        if (i > 0) {
          str = parambgwj.a.c.substring(i + 8);
        }
        if (!b()) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.append(parambgwj.a.jdField_a_of_type_JavaLangString);
        ((aihd)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).Y = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.I = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c();
        ((aihd)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).Y = false;
        if (!localbgty.a()) {
          a((aihd)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_a_of_type_JavaLangString, this.b, false);
        }
        localbgty.a(l1, l2, str, new bgwp(this, parambgwj));
      }
      catch (Exception localException)
      {
        continue;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TroopAIORobotLayout", 2, "send to server: " + parambgwj.a.jdField_a_of_type_JavaLangString);
      return;
      a(getContext(), parambgwj.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, true, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
    }
  }
  
  public void b(bgwj parambgwj, String paramString)
  {
    bgty.a("panel", "clk", this.c, this.jdField_a_of_type_JavaLangString, paramString, "");
  }
  
  public void d(bgwj parambgwj, String paramString)
  {
    bgty.a("panel", "clk", this.c, this.jdField_a_of_type_JavaLangString, paramString, "");
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