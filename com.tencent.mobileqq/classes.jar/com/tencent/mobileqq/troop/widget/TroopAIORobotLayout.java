package com.tencent.mobileqq.troop.widget;

import aemf;
import android.content.Context;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import bafh;
import bahx;
import balw;
import baoe;
import baog;
import baoh;
import baol;
import baom;
import baon;
import baoo;
import bbjn;
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
  
  private String a(String paramString1, String paramString2, String paramString3, baog parambaog, balw parambalw)
  {
    int i;
    if (parambaog.jdField_b_of_type_Boolean)
    {
      parambaog.jdField_b_of_type_Boolean = false;
      parambalw.a();
      i = parambaog.jdField_b_of_type_Baoh.c.indexOf("content=");
      if (i <= 0) {
        break label193;
      }
    }
    label193:
    for (paramString3 = parambaog.jdField_b_of_type_Baoh.c.substring(i + 8);; paramString3 = "")
    {
      String str = parambaog.jdField_b_of_type_Baoh.jdField_a_of_type_JavaLangString;
      balw.a("panel", "talk_out", paramString2, paramString2, "1", "");
      try
      {
        parambalw.b(Long.parseLong(paramString1), Long.parseLong(paramString2), paramString3, new baon(this, parambaog));
        return str;
      }
      catch (Exception paramString1)
      {
        return str;
      }
      str = parambaog.a.jdField_a_of_type_JavaLangString;
      parambaog.jdField_b_of_type_Boolean = true;
      parambalw.b(paramString1, paramString2, paramString3);
      i = parambaog.a.c.indexOf("content=");
      if (i > 0) {}
      for (paramString3 = parambaog.a.c.substring(i + 8);; paramString3 = "")
      {
        balw.a("panel", "talk_in", paramString2, paramString2, "", "");
        break;
      }
    }
  }
  
  private void a(aemf paramaemf, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramaemf == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    SpannableString localSpannableString = bafh.a(paramaemf.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getContext(), paramString1, paramString1, paramString2, false, true);
    if (localSpannableString != null)
    {
      if (paramBoolean) {
        break label93;
      }
      paramaemf.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(localSpannableString);
    }
    for (;;)
    {
      paramaemf.jdField_a_of_type_ComTencentWidgetXEditTextEx.append(" ");
      paramaemf.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(paramaemf.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length());
      paramaemf.a(paramString1, paramString2, true, 0);
      return;
      label93:
      paramaemf.jdField_a_of_type_ComTencentWidgetXEditTextEx.append(localSpannableString);
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, balw parambalw, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (String str = "off";; str = "on")
    {
      int j = b();
      if (j <= 0) {
        return;
      }
      int i = 0;
      baog localbaog;
      if (i < j)
      {
        localbaog = (baog)a(i);
        if ((localbaog != null) && (!TextUtils.isEmpty(localbaog.jdField_b_of_type_Baoh.jdField_a_of_type_JavaLangString)))
        {
          localbaog.jdField_b_of_type_Boolean = paramBoolean;
          if (!paramBoolean)
          {
            i = localbaog.jdField_b_of_type_Baoh.c.indexOf("content=");
            if (i > 0) {
              str = localbaog.jdField_b_of_type_Baoh.c.substring(i + 8);
            }
          }
        }
      }
      for (;;)
      {
        label111:
        if (paramBoolean) {
          parambalw.b(paramString1, paramString2, paramString3);
        }
        for (;;)
        {
          try
          {
            parambalw.b(Long.parseLong(paramString1), Long.parseLong(paramString2), str, new baoo(this));
            return;
          }
          catch (Exception paramString1)
          {
            return;
          }
          i = localbaog.a.c.indexOf("content=");
          if (i > 0) {
            str = localbaog.a.c.substring(i + 8);
          }
          break label111;
          i += 1;
          break;
          parambalw.a();
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
  
  public String a(baog parambaog)
  {
    Object localObject = a();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAIORobotLayout", 2, "troopRobotManager = null");
      }
      parambaog = null;
    }
    do
    {
      return parambaog;
      localObject = a(this.c, this.jdField_a_of_type_JavaLangString, this.b, parambaog, (balw)localObject);
      parambaog = (baog)localObject;
    } while (!QLog.isColorLevel());
    QLog.d("TroopAIORobotLayout", 2, "talking: " + (String)localObject);
    return localObject;
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(baog parambaog)
  {
    balw localbalw = a();
    if (localbalw == null) {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAIORobotLayout", 2, "troopRobotManager = null");
      }
    }
    for (;;)
    {
      return;
      if (b())
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.append(parambaog.a.jdField_a_of_type_JavaLangString);
        ((aemf)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).Z = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c();
        ((aemf)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).Z = false;
        if (!localbalw.a()) {
          a((aemf)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_a_of_type_JavaLangString, this.b, false);
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d("TroopAIORobotLayout", 2, "send to robot: " + parambaog.a.jdField_a_of_type_JavaLangString);
        return;
        a(getContext(), parambaog.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, false, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      }
    }
  }
  
  public void a(baog parambaog, String paramString)
  {
    bahx.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8009FA2", this.jdField_a_of_type_JavaLangString, paramString);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, aemf paramaemf, baoe parambaoe)
  {
    super.a(paramString2, paramString3, paramaemf, parambaoe);
    paramaemf = a();
    if (paramaemf == null)
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
    i = bbjn.an(getContext(), paramString1 + "_" + paramString2);
    paramaemf.a(l2, l1, i, new baol(this, i, paramString2, paramString1, paramString3, parambaoe));
  }
  
  public void b(baog parambaog)
  {
    balw localbalw = a();
    if (localbalw == null)
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
        int i = parambaog.a.c.indexOf("content=");
        if (i > 0) {
          str = parambaog.a.c.substring(i + 8);
        }
        if (!b()) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.append(parambaog.a.jdField_a_of_type_JavaLangString);
        ((aemf)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).Z = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.J = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c();
        ((aemf)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).Z = false;
        if (!localbalw.a()) {
          a((aemf)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_a_of_type_JavaLangString, this.b, false);
        }
        localbalw.a(l1, l2, str, new baom(this, parambaog));
      }
      catch (Exception localException)
      {
        continue;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TroopAIORobotLayout", 2, "send to server: " + parambaog.a.jdField_a_of_type_JavaLangString);
      return;
      a(getContext(), parambaog.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, true, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
    }
  }
  
  public void b(baog parambaog, String paramString)
  {
    balw.a("panel", "clk", this.c, this.jdField_a_of_type_JavaLangString, paramString, "");
  }
  
  public void d(baog parambaog, String paramString)
  {
    balw.a("panel", "clk", this.c, this.jdField_a_of_type_JavaLangString, paramString, "");
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