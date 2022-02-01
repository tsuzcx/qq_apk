package com.tencent.mobileqq.troop.widget;

import ahxp;
import android.content.Context;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import bfmd;
import bfpx;
import bftx;
import bfwg;
import bfwi;
import bfwj;
import bfwn;
import bfwo;
import bfwp;
import bfwq;
import bgsg;
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
  
  private String a(String paramString1, String paramString2, String paramString3, bfwi parambfwi, bftx parambftx)
  {
    int i;
    if (parambfwi.jdField_b_of_type_Boolean)
    {
      parambfwi.jdField_b_of_type_Boolean = false;
      parambftx.a();
      i = parambfwi.jdField_b_of_type_Bfwj.c.indexOf("content=");
      if (i <= 0) {
        break label193;
      }
    }
    label193:
    for (paramString3 = parambfwi.jdField_b_of_type_Bfwj.c.substring(i + 8);; paramString3 = "")
    {
      String str = parambfwi.jdField_b_of_type_Bfwj.jdField_a_of_type_JavaLangString;
      bftx.a("panel", "talk_out", paramString2, paramString2, "1", "");
      try
      {
        parambftx.b(Long.parseLong(paramString1), Long.parseLong(paramString2), paramString3, new bfwp(this, parambfwi));
        return str;
      }
      catch (Exception paramString1)
      {
        return str;
      }
      str = parambfwi.a.jdField_a_of_type_JavaLangString;
      parambfwi.jdField_b_of_type_Boolean = true;
      parambftx.b(paramString1, paramString2, paramString3);
      i = parambfwi.a.c.indexOf("content=");
      if (i > 0) {}
      for (paramString3 = parambfwi.a.c.substring(i + 8);; paramString3 = "")
      {
        bftx.a("panel", "talk_in", paramString2, paramString2, "", "");
        break;
      }
    }
  }
  
  private void a(ahxp paramahxp, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramahxp == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    SpannableString localSpannableString = bfmd.a(paramahxp.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getContext(), paramString1, paramString1, paramString2, false, true);
    if (localSpannableString != null)
    {
      if (paramBoolean) {
        break label93;
      }
      paramahxp.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(localSpannableString);
    }
    for (;;)
    {
      paramahxp.jdField_a_of_type_ComTencentWidgetXEditTextEx.append(" ");
      paramahxp.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(paramahxp.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length());
      paramahxp.a(paramString1, paramString2, true, 0);
      return;
      label93:
      paramahxp.jdField_a_of_type_ComTencentWidgetXEditTextEx.append(localSpannableString);
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, bftx parambftx, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (String str = "off";; str = "on")
    {
      int j = b();
      if (j <= 0) {
        return;
      }
      int i = 0;
      bfwi localbfwi;
      if (i < j)
      {
        localbfwi = (bfwi)a(i);
        if ((localbfwi != null) && (!TextUtils.isEmpty(localbfwi.jdField_b_of_type_Bfwj.jdField_a_of_type_JavaLangString)))
        {
          localbfwi.jdField_b_of_type_Boolean = paramBoolean;
          if (!paramBoolean)
          {
            i = localbfwi.jdField_b_of_type_Bfwj.c.indexOf("content=");
            if (i > 0) {
              str = localbfwi.jdField_b_of_type_Bfwj.c.substring(i + 8);
            }
          }
        }
      }
      for (;;)
      {
        label111:
        if (paramBoolean) {
          parambftx.b(paramString1, paramString2, paramString3);
        }
        for (;;)
        {
          try
          {
            parambftx.b(Long.parseLong(paramString1), Long.parseLong(paramString2), str, new bfwq(this));
            return;
          }
          catch (Exception paramString1)
          {
            return;
          }
          i = localbfwi.a.c.indexOf("content=");
          if (i > 0) {
            str = localbfwi.a.c.substring(i + 8);
          }
          break label111;
          i += 1;
          break;
          parambftx.a();
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
  
  public String a(bfwi parambfwi)
  {
    Object localObject = a();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAIORobotLayout", 2, "troopRobotManager = null");
      }
      parambfwi = null;
    }
    do
    {
      return parambfwi;
      localObject = a(this.c, this.jdField_a_of_type_JavaLangString, this.b, parambfwi, (bftx)localObject);
      parambfwi = (bfwi)localObject;
    } while (!QLog.isColorLevel());
    QLog.d("TroopAIORobotLayout", 2, "talking: " + (String)localObject);
    return localObject;
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(bfwi parambfwi)
  {
    bftx localbftx = a();
    if (localbftx == null) {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAIORobotLayout", 2, "troopRobotManager = null");
      }
    }
    for (;;)
    {
      return;
      if (b())
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.append(parambfwi.a.jdField_a_of_type_JavaLangString);
        ((ahxp)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).Y = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c();
        ((ahxp)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).Y = false;
        if (!localbftx.a()) {
          a((ahxp)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_a_of_type_JavaLangString, this.b, false);
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d("TroopAIORobotLayout", 2, "send to robot: " + parambfwi.a.jdField_a_of_type_JavaLangString);
        return;
        a(getContext(), parambfwi.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, false, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      }
    }
  }
  
  public void a(bfwi parambfwi, String paramString)
  {
    bfpx.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8009FA2", this.jdField_a_of_type_JavaLangString, paramString);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, ahxp paramahxp, bfwg parambfwg)
  {
    super.a(paramString2, paramString3, paramahxp, parambfwg);
    paramahxp = a();
    if (paramahxp == null)
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
    i = bgsg.ao(getContext(), paramString1 + "_" + paramString2);
    paramahxp.a(l2, l1, i, new bfwn(this, i, paramString2, paramString1, paramString3, parambfwg));
  }
  
  public void b(bfwi parambfwi)
  {
    bftx localbftx = a();
    if (localbftx == null)
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
        int i = parambfwi.a.c.indexOf("content=");
        if (i > 0) {
          str = parambfwi.a.c.substring(i + 8);
        }
        if (!b()) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.append(parambfwi.a.jdField_a_of_type_JavaLangString);
        ((ahxp)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).Y = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.I = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c();
        ((ahxp)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).Y = false;
        if (!localbftx.a()) {
          a((ahxp)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_a_of_type_JavaLangString, this.b, false);
        }
        localbftx.a(l1, l2, str, new bfwo(this, parambfwi));
      }
      catch (Exception localException)
      {
        continue;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TroopAIORobotLayout", 2, "send to server: " + parambfwi.a.jdField_a_of_type_JavaLangString);
      return;
      a(getContext(), parambfwi.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, true, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
    }
  }
  
  public void b(bfwi parambfwi, String paramString)
  {
    bftx.a("panel", "clk", this.c, this.jdField_a_of_type_JavaLangString, paramString, "");
  }
  
  public void d(bfwi parambfwi, String paramString)
  {
    bftx.a("panel", "clk", this.c, this.jdField_a_of_type_JavaLangString, paramString, "");
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