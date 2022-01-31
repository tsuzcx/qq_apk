package com.tencent.mobileqq.troop.widget;

import agiu;
import android.content.Context;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import bceh;
import bcgx;
import bckx;
import bcnf;
import bcnh;
import bcni;
import bcnm;
import bcnn;
import bcno;
import bcnp;
import bdiv;
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
  
  private String a(String paramString1, String paramString2, String paramString3, bcnh parambcnh, bckx parambckx)
  {
    int i;
    if (parambcnh.jdField_b_of_type_Boolean)
    {
      parambcnh.jdField_b_of_type_Boolean = false;
      parambckx.a();
      i = parambcnh.jdField_b_of_type_Bcni.c.indexOf("content=");
      if (i <= 0) {
        break label193;
      }
    }
    label193:
    for (paramString3 = parambcnh.jdField_b_of_type_Bcni.c.substring(i + 8);; paramString3 = "")
    {
      String str = parambcnh.jdField_b_of_type_Bcni.jdField_a_of_type_JavaLangString;
      bckx.a("panel", "talk_out", paramString2, paramString2, "1", "");
      try
      {
        parambckx.b(Long.parseLong(paramString1), Long.parseLong(paramString2), paramString3, new bcno(this, parambcnh));
        return str;
      }
      catch (Exception paramString1)
      {
        return str;
      }
      str = parambcnh.a.jdField_a_of_type_JavaLangString;
      parambcnh.jdField_b_of_type_Boolean = true;
      parambckx.b(paramString1, paramString2, paramString3);
      i = parambcnh.a.c.indexOf("content=");
      if (i > 0) {}
      for (paramString3 = parambcnh.a.c.substring(i + 8);; paramString3 = "")
      {
        bckx.a("panel", "talk_in", paramString2, paramString2, "", "");
        break;
      }
    }
  }
  
  private void a(agiu paramagiu, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramagiu == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    SpannableString localSpannableString = bceh.a(paramagiu.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getContext(), paramString1, paramString1, paramString2, false, true);
    if (localSpannableString != null)
    {
      if (paramBoolean) {
        break label93;
      }
      paramagiu.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(localSpannableString);
    }
    for (;;)
    {
      paramagiu.jdField_a_of_type_ComTencentWidgetXEditTextEx.append(" ");
      paramagiu.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(paramagiu.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length());
      paramagiu.a(paramString1, paramString2, true, 0);
      return;
      label93:
      paramagiu.jdField_a_of_type_ComTencentWidgetXEditTextEx.append(localSpannableString);
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, bckx parambckx, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (String str = "off";; str = "on")
    {
      int j = b();
      if (j <= 0) {
        return;
      }
      int i = 0;
      bcnh localbcnh;
      if (i < j)
      {
        localbcnh = (bcnh)a(i);
        if ((localbcnh != null) && (!TextUtils.isEmpty(localbcnh.jdField_b_of_type_Bcni.jdField_a_of_type_JavaLangString)))
        {
          localbcnh.jdField_b_of_type_Boolean = paramBoolean;
          if (!paramBoolean)
          {
            i = localbcnh.jdField_b_of_type_Bcni.c.indexOf("content=");
            if (i > 0) {
              str = localbcnh.jdField_b_of_type_Bcni.c.substring(i + 8);
            }
          }
        }
      }
      for (;;)
      {
        label111:
        if (paramBoolean) {
          parambckx.b(paramString1, paramString2, paramString3);
        }
        for (;;)
        {
          try
          {
            parambckx.b(Long.parseLong(paramString1), Long.parseLong(paramString2), str, new bcnp(this));
            return;
          }
          catch (Exception paramString1)
          {
            return;
          }
          i = localbcnh.a.c.indexOf("content=");
          if (i > 0) {
            str = localbcnh.a.c.substring(i + 8);
          }
          break label111;
          i += 1;
          break;
          parambckx.a();
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
  
  public String a(bcnh parambcnh)
  {
    Object localObject = a();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAIORobotLayout", 2, "troopRobotManager = null");
      }
      parambcnh = null;
    }
    do
    {
      return parambcnh;
      localObject = a(this.c, this.jdField_a_of_type_JavaLangString, this.b, parambcnh, (bckx)localObject);
      parambcnh = (bcnh)localObject;
    } while (!QLog.isColorLevel());
    QLog.d("TroopAIORobotLayout", 2, "talking: " + (String)localObject);
    return localObject;
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(bcnh parambcnh)
  {
    bckx localbckx = a();
    if (localbckx == null) {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAIORobotLayout", 2, "troopRobotManager = null");
      }
    }
    for (;;)
    {
      return;
      if (b())
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.append(parambcnh.a.jdField_a_of_type_JavaLangString);
        ((agiu)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).Z = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c();
        ((agiu)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).Z = false;
        if (!localbckx.a()) {
          a((agiu)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_a_of_type_JavaLangString, this.b, false);
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d("TroopAIORobotLayout", 2, "send to robot: " + parambcnh.a.jdField_a_of_type_JavaLangString);
        return;
        a(getContext(), parambcnh.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, false, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      }
    }
  }
  
  public void a(bcnh parambcnh, String paramString)
  {
    bcgx.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8009FA2", this.jdField_a_of_type_JavaLangString, paramString);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, agiu paramagiu, bcnf parambcnf)
  {
    super.a(paramString2, paramString3, paramagiu, parambcnf);
    paramagiu = a();
    if (paramagiu == null)
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
    i = bdiv.ao(getContext(), paramString1 + "_" + paramString2);
    paramagiu.a(l2, l1, i, new bcnm(this, i, paramString2, paramString1, paramString3, parambcnf));
  }
  
  public void b(bcnh parambcnh)
  {
    bckx localbckx = a();
    if (localbckx == null)
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
        int i = parambcnh.a.c.indexOf("content=");
        if (i > 0) {
          str = parambcnh.a.c.substring(i + 8);
        }
        if (!b()) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.append(parambcnh.a.jdField_a_of_type_JavaLangString);
        ((agiu)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).Z = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.J = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c();
        ((agiu)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).Z = false;
        if (!localbckx.a()) {
          a((agiu)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_a_of_type_JavaLangString, this.b, false);
        }
        localbckx.a(l1, l2, str, new bcnn(this, parambcnh));
      }
      catch (Exception localException)
      {
        continue;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TroopAIORobotLayout", 2, "send to server: " + parambcnh.a.jdField_a_of_type_JavaLangString);
      return;
      a(getContext(), parambcnh.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, true, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
    }
  }
  
  public void b(bcnh parambcnh, String paramString)
  {
    bckx.a("panel", "clk", this.c, this.jdField_a_of_type_JavaLangString, paramString, "");
  }
  
  public void d(bcnh parambcnh, String paramString)
  {
    bckx.a("panel", "clk", this.c, this.jdField_a_of_type_JavaLangString, paramString, "");
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