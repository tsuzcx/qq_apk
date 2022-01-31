package com.tencent.mobileqq.troop.widget;

import aemd;
import android.content.Context;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import bafv;
import bail;
import bamk;
import baos;
import baou;
import baov;
import baoz;
import bapa;
import bapb;
import bapc;
import bbkb;
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
  
  private String a(String paramString1, String paramString2, String paramString3, baou parambaou, bamk parambamk)
  {
    int i;
    if (parambaou.jdField_b_of_type_Boolean)
    {
      parambaou.jdField_b_of_type_Boolean = false;
      parambamk.a();
      i = parambaou.jdField_b_of_type_Baov.c.indexOf("content=");
      if (i <= 0) {
        break label193;
      }
    }
    label193:
    for (paramString3 = parambaou.jdField_b_of_type_Baov.c.substring(i + 8);; paramString3 = "")
    {
      String str = parambaou.jdField_b_of_type_Baov.jdField_a_of_type_JavaLangString;
      bamk.a("panel", "talk_out", paramString2, paramString2, "1", "");
      try
      {
        parambamk.b(Long.parseLong(paramString1), Long.parseLong(paramString2), paramString3, new bapb(this, parambaou));
        return str;
      }
      catch (Exception paramString1)
      {
        return str;
      }
      str = parambaou.a.jdField_a_of_type_JavaLangString;
      parambaou.jdField_b_of_type_Boolean = true;
      parambamk.b(paramString1, paramString2, paramString3);
      i = parambaou.a.c.indexOf("content=");
      if (i > 0) {}
      for (paramString3 = parambaou.a.c.substring(i + 8);; paramString3 = "")
      {
        bamk.a("panel", "talk_in", paramString2, paramString2, "", "");
        break;
      }
    }
  }
  
  private void a(aemd paramaemd, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramaemd == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    SpannableString localSpannableString = bafv.a(paramaemd.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getContext(), paramString1, paramString1, paramString2, false, true);
    if (localSpannableString != null)
    {
      if (paramBoolean) {
        break label93;
      }
      paramaemd.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(localSpannableString);
    }
    for (;;)
    {
      paramaemd.jdField_a_of_type_ComTencentWidgetXEditTextEx.append(" ");
      paramaemd.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(paramaemd.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length());
      paramaemd.a(paramString1, paramString2, true, 0);
      return;
      label93:
      paramaemd.jdField_a_of_type_ComTencentWidgetXEditTextEx.append(localSpannableString);
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, bamk parambamk, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (String str = "off";; str = "on")
    {
      int j = b();
      if (j <= 0) {
        return;
      }
      int i = 0;
      baou localbaou;
      if (i < j)
      {
        localbaou = (baou)a(i);
        if ((localbaou != null) && (!TextUtils.isEmpty(localbaou.jdField_b_of_type_Baov.jdField_a_of_type_JavaLangString)))
        {
          localbaou.jdField_b_of_type_Boolean = paramBoolean;
          if (!paramBoolean)
          {
            i = localbaou.jdField_b_of_type_Baov.c.indexOf("content=");
            if (i > 0) {
              str = localbaou.jdField_b_of_type_Baov.c.substring(i + 8);
            }
          }
        }
      }
      for (;;)
      {
        label111:
        if (paramBoolean) {
          parambamk.b(paramString1, paramString2, paramString3);
        }
        for (;;)
        {
          try
          {
            parambamk.b(Long.parseLong(paramString1), Long.parseLong(paramString2), str, new bapc(this));
            return;
          }
          catch (Exception paramString1)
          {
            return;
          }
          i = localbaou.a.c.indexOf("content=");
          if (i > 0) {
            str = localbaou.a.c.substring(i + 8);
          }
          break label111;
          i += 1;
          break;
          parambamk.a();
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
  
  public String a(baou parambaou)
  {
    Object localObject = a();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAIORobotLayout", 2, "troopRobotManager = null");
      }
      parambaou = null;
    }
    do
    {
      return parambaou;
      localObject = a(this.c, this.jdField_a_of_type_JavaLangString, this.b, parambaou, (bamk)localObject);
      parambaou = (baou)localObject;
    } while (!QLog.isColorLevel());
    QLog.d("TroopAIORobotLayout", 2, "talking: " + (String)localObject);
    return localObject;
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(baou parambaou)
  {
    bamk localbamk = a();
    if (localbamk == null) {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAIORobotLayout", 2, "troopRobotManager = null");
      }
    }
    for (;;)
    {
      return;
      if (b())
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.append(parambaou.a.jdField_a_of_type_JavaLangString);
        ((aemd)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).Z = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c();
        ((aemd)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).Z = false;
        if (!localbamk.a()) {
          a((aemd)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_a_of_type_JavaLangString, this.b, false);
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d("TroopAIORobotLayout", 2, "send to robot: " + parambaou.a.jdField_a_of_type_JavaLangString);
        return;
        a(getContext(), parambaou.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, false, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      }
    }
  }
  
  public void a(baou parambaou, String paramString)
  {
    bail.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8009FA2", this.jdField_a_of_type_JavaLangString, paramString);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, aemd paramaemd, baos parambaos)
  {
    super.a(paramString2, paramString3, paramaemd, parambaos);
    paramaemd = a();
    if (paramaemd == null)
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
    i = bbkb.an(getContext(), paramString1 + "_" + paramString2);
    paramaemd.a(l2, l1, i, new baoz(this, i, paramString2, paramString1, paramString3, parambaos));
  }
  
  public void b(baou parambaou)
  {
    bamk localbamk = a();
    if (localbamk == null)
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
        int i = parambaou.a.c.indexOf("content=");
        if (i > 0) {
          str = parambaou.a.c.substring(i + 8);
        }
        if (!b()) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.append(parambaou.a.jdField_a_of_type_JavaLangString);
        ((aemd)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).Z = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.J = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c();
        ((aemd)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).Z = false;
        if (!localbamk.a()) {
          a((aemd)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_a_of_type_JavaLangString, this.b, false);
        }
        localbamk.a(l1, l2, str, new bapa(this, parambaou));
      }
      catch (Exception localException)
      {
        continue;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TroopAIORobotLayout", 2, "send to server: " + parambaou.a.jdField_a_of_type_JavaLangString);
      return;
      a(getContext(), parambaou.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, true, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
    }
  }
  
  public void b(baou parambaou, String paramString)
  {
    bamk.a("panel", "clk", this.c, this.jdField_a_of_type_JavaLangString, paramString, "");
  }
  
  public void d(baou parambaou, String paramString)
  {
    bamk.a("panel", "clk", this.c, this.jdField_a_of_type_JavaLangString, paramString, "");
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