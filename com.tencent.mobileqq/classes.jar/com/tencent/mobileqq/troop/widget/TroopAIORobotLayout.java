package com.tencent.mobileqq.troop.widget;

import agnj;
import android.content.Context;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import bciq;
import bclg;
import bcpg;
import bcro;
import bcrq;
import bcrr;
import bcrv;
import bcrw;
import bcrx;
import bcry;
import bdne;
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
  
  private String a(String paramString1, String paramString2, String paramString3, bcrq parambcrq, bcpg parambcpg)
  {
    int i;
    if (parambcrq.jdField_b_of_type_Boolean)
    {
      parambcrq.jdField_b_of_type_Boolean = false;
      parambcpg.a();
      i = parambcrq.jdField_b_of_type_Bcrr.c.indexOf("content=");
      if (i <= 0) {
        break label193;
      }
    }
    label193:
    for (paramString3 = parambcrq.jdField_b_of_type_Bcrr.c.substring(i + 8);; paramString3 = "")
    {
      String str = parambcrq.jdField_b_of_type_Bcrr.jdField_a_of_type_JavaLangString;
      bcpg.a("panel", "talk_out", paramString2, paramString2, "1", "");
      try
      {
        parambcpg.b(Long.parseLong(paramString1), Long.parseLong(paramString2), paramString3, new bcrx(this, parambcrq));
        return str;
      }
      catch (Exception paramString1)
      {
        return str;
      }
      str = parambcrq.a.jdField_a_of_type_JavaLangString;
      parambcrq.jdField_b_of_type_Boolean = true;
      parambcpg.b(paramString1, paramString2, paramString3);
      i = parambcrq.a.c.indexOf("content=");
      if (i > 0) {}
      for (paramString3 = parambcrq.a.c.substring(i + 8);; paramString3 = "")
      {
        bcpg.a("panel", "talk_in", paramString2, paramString2, "", "");
        break;
      }
    }
  }
  
  private void a(agnj paramagnj, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramagnj == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    SpannableString localSpannableString = bciq.a(paramagnj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getContext(), paramString1, paramString1, paramString2, false, true);
    if (localSpannableString != null)
    {
      if (paramBoolean) {
        break label93;
      }
      paramagnj.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(localSpannableString);
    }
    for (;;)
    {
      paramagnj.jdField_a_of_type_ComTencentWidgetXEditTextEx.append(" ");
      paramagnj.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(paramagnj.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length());
      paramagnj.a(paramString1, paramString2, true, 0);
      return;
      label93:
      paramagnj.jdField_a_of_type_ComTencentWidgetXEditTextEx.append(localSpannableString);
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, bcpg parambcpg, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (String str = "off";; str = "on")
    {
      int j = b();
      if (j <= 0) {
        return;
      }
      int i = 0;
      bcrq localbcrq;
      if (i < j)
      {
        localbcrq = (bcrq)a(i);
        if ((localbcrq != null) && (!TextUtils.isEmpty(localbcrq.jdField_b_of_type_Bcrr.jdField_a_of_type_JavaLangString)))
        {
          localbcrq.jdField_b_of_type_Boolean = paramBoolean;
          if (!paramBoolean)
          {
            i = localbcrq.jdField_b_of_type_Bcrr.c.indexOf("content=");
            if (i > 0) {
              str = localbcrq.jdField_b_of_type_Bcrr.c.substring(i + 8);
            }
          }
        }
      }
      for (;;)
      {
        label111:
        if (paramBoolean) {
          parambcpg.b(paramString1, paramString2, paramString3);
        }
        for (;;)
        {
          try
          {
            parambcpg.b(Long.parseLong(paramString1), Long.parseLong(paramString2), str, new bcry(this));
            return;
          }
          catch (Exception paramString1)
          {
            return;
          }
          i = localbcrq.a.c.indexOf("content=");
          if (i > 0) {
            str = localbcrq.a.c.substring(i + 8);
          }
          break label111;
          i += 1;
          break;
          parambcpg.a();
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
  
  public String a(bcrq parambcrq)
  {
    Object localObject = a();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAIORobotLayout", 2, "troopRobotManager = null");
      }
      parambcrq = null;
    }
    do
    {
      return parambcrq;
      localObject = a(this.c, this.jdField_a_of_type_JavaLangString, this.b, parambcrq, (bcpg)localObject);
      parambcrq = (bcrq)localObject;
    } while (!QLog.isColorLevel());
    QLog.d("TroopAIORobotLayout", 2, "talking: " + (String)localObject);
    return localObject;
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(bcrq parambcrq)
  {
    bcpg localbcpg = a();
    if (localbcpg == null) {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAIORobotLayout", 2, "troopRobotManager = null");
      }
    }
    for (;;)
    {
      return;
      if (b())
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.append(parambcrq.a.jdField_a_of_type_JavaLangString);
        ((agnj)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).Z = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c();
        ((agnj)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).Z = false;
        if (!localbcpg.a()) {
          a((agnj)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_a_of_type_JavaLangString, this.b, false);
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d("TroopAIORobotLayout", 2, "send to robot: " + parambcrq.a.jdField_a_of_type_JavaLangString);
        return;
        a(getContext(), parambcrq.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, false, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      }
    }
  }
  
  public void a(bcrq parambcrq, String paramString)
  {
    bclg.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8009FA2", this.jdField_a_of_type_JavaLangString, paramString);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, agnj paramagnj, bcro parambcro)
  {
    super.a(paramString2, paramString3, paramagnj, parambcro);
    paramagnj = a();
    if (paramagnj == null)
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
    i = bdne.ao(getContext(), paramString1 + "_" + paramString2);
    paramagnj.a(l2, l1, i, new bcrv(this, i, paramString2, paramString1, paramString3, parambcro));
  }
  
  public void b(bcrq parambcrq)
  {
    bcpg localbcpg = a();
    if (localbcpg == null)
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
        int i = parambcrq.a.c.indexOf("content=");
        if (i > 0) {
          str = parambcrq.a.c.substring(i + 8);
        }
        if (!b()) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.append(parambcrq.a.jdField_a_of_type_JavaLangString);
        ((agnj)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).Z = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.J = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c();
        ((agnj)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).Z = false;
        if (!localbcpg.a()) {
          a((agnj)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_a_of_type_JavaLangString, this.b, false);
        }
        localbcpg.a(l1, l2, str, new bcrw(this, parambcrq));
      }
      catch (Exception localException)
      {
        continue;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TroopAIORobotLayout", 2, "send to server: " + parambcrq.a.jdField_a_of_type_JavaLangString);
      return;
      a(getContext(), parambcrq.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, true, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
    }
  }
  
  public void b(bcrq parambcrq, String paramString)
  {
    bcpg.a("panel", "clk", this.c, this.jdField_a_of_type_JavaLangString, paramString, "");
  }
  
  public void d(bcrq parambcrq, String paramString)
  {
    bcpg.a("panel", "clk", this.c, this.jdField_a_of_type_JavaLangString, paramString, "");
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