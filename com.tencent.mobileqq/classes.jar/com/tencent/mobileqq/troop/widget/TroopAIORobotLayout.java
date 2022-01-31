package com.tencent.mobileqq.troop.widget;

import aebg;
import android.content.Context;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import azef;
import azgu;
import azks;
import azna;
import aznc;
import aznd;
import aznh;
import azni;
import aznj;
import aznk;
import baig;
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
  
  private String a(String paramString1, String paramString2, String paramString3, aznc paramaznc, azks paramazks)
  {
    int i;
    if (paramaznc.jdField_b_of_type_Boolean)
    {
      paramaznc.jdField_b_of_type_Boolean = false;
      paramazks.a();
      i = paramaznc.jdField_b_of_type_Aznd.c.indexOf("content=");
      if (i <= 0) {
        break label193;
      }
    }
    label193:
    for (paramString3 = paramaznc.jdField_b_of_type_Aznd.c.substring(i + 8);; paramString3 = "")
    {
      String str = paramaznc.jdField_b_of_type_Aznd.jdField_a_of_type_JavaLangString;
      azks.a("panel", "talk_out", paramString2, paramString2, "1", "");
      try
      {
        paramazks.b(Long.parseLong(paramString1), Long.parseLong(paramString2), paramString3, new aznj(this, paramaznc));
        return str;
      }
      catch (Exception paramString1)
      {
        return str;
      }
      str = paramaznc.a.jdField_a_of_type_JavaLangString;
      paramaznc.jdField_b_of_type_Boolean = true;
      paramazks.b(paramString1, paramString2, paramString3);
      i = paramaznc.a.c.indexOf("content=");
      if (i > 0) {}
      for (paramString3 = paramaznc.a.c.substring(i + 8);; paramString3 = "")
      {
        azks.a("panel", "talk_in", paramString2, paramString2, "", "");
        break;
      }
    }
  }
  
  private void a(aebg paramaebg, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramaebg == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    SpannableString localSpannableString = azef.a(paramaebg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getContext(), paramString1, paramString1, paramString2, false, true);
    if (localSpannableString != null)
    {
      if (paramBoolean) {
        break label93;
      }
      paramaebg.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(localSpannableString);
    }
    for (;;)
    {
      paramaebg.jdField_a_of_type_ComTencentWidgetXEditTextEx.append(" ");
      paramaebg.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(paramaebg.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length());
      paramaebg.a(paramString1, paramString2, true, 0);
      return;
      label93:
      paramaebg.jdField_a_of_type_ComTencentWidgetXEditTextEx.append(localSpannableString);
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, azks paramazks, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (String str = "off";; str = "on")
    {
      int j = b();
      if (j <= 0) {
        return;
      }
      int i = 0;
      aznc localaznc;
      if (i < j)
      {
        localaznc = (aznc)a(i);
        if ((localaznc != null) && (!TextUtils.isEmpty(localaznc.jdField_b_of_type_Aznd.jdField_a_of_type_JavaLangString)))
        {
          localaznc.jdField_b_of_type_Boolean = paramBoolean;
          if (!paramBoolean)
          {
            i = localaznc.jdField_b_of_type_Aznd.c.indexOf("content=");
            if (i > 0) {
              str = localaznc.jdField_b_of_type_Aznd.c.substring(i + 8);
            }
          }
        }
      }
      for (;;)
      {
        label111:
        if (paramBoolean) {
          paramazks.b(paramString1, paramString2, paramString3);
        }
        for (;;)
        {
          try
          {
            paramazks.b(Long.parseLong(paramString1), Long.parseLong(paramString2), str, new aznk(this));
            return;
          }
          catch (Exception paramString1)
          {
            return;
          }
          i = localaznc.a.c.indexOf("content=");
          if (i > 0) {
            str = localaznc.a.c.substring(i + 8);
          }
          break label111;
          i += 1;
          break;
          paramazks.a();
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
  
  public String a(aznc paramaznc)
  {
    Object localObject = a();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAIORobotLayout", 2, "troopRobotManager = null");
      }
      paramaznc = null;
    }
    do
    {
      return paramaznc;
      localObject = a(this.c, this.jdField_a_of_type_JavaLangString, this.b, paramaznc, (azks)localObject);
      paramaznc = (aznc)localObject;
    } while (!QLog.isColorLevel());
    QLog.d("TroopAIORobotLayout", 2, "talking: " + (String)localObject);
    return localObject;
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(aznc paramaznc)
  {
    azks localazks = a();
    if (localazks == null) {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAIORobotLayout", 2, "troopRobotManager = null");
      }
    }
    for (;;)
    {
      return;
      if (b())
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.append(paramaznc.a.jdField_a_of_type_JavaLangString);
        ((aebg)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).Z = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c();
        ((aebg)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).Z = false;
        if (!localazks.a()) {
          a((aebg)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_a_of_type_JavaLangString, this.b, false);
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d("TroopAIORobotLayout", 2, "send to robot: " + paramaznc.a.jdField_a_of_type_JavaLangString);
        return;
        a(getContext(), paramaznc.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, false, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      }
    }
  }
  
  public void a(aznc paramaznc, String paramString)
  {
    azgu.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8009FA2", this.jdField_a_of_type_JavaLangString, paramString);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, aebg paramaebg, azna paramazna)
  {
    super.a(paramString2, paramString3, paramaebg, paramazna);
    paramaebg = a();
    if (paramaebg == null)
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
    i = baig.an(getContext(), paramString1 + "_" + paramString2);
    paramaebg.a(l2, l1, i, new aznh(this, i, paramString2, paramString1, paramString3, paramazna));
  }
  
  public void b(aznc paramaznc)
  {
    azks localazks = a();
    if (localazks == null)
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
        int i = paramaznc.a.c.indexOf("content=");
        if (i > 0) {
          str = paramaznc.a.c.substring(i + 8);
        }
        if (!b()) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.append(paramaznc.a.jdField_a_of_type_JavaLangString);
        ((aebg)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).Z = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.J = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c();
        ((aebg)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie).Z = false;
        if (!localazks.a()) {
          a((aebg)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.jdField_a_of_type_JavaLangString, this.b, false);
        }
        localazks.a(l1, l2, str, new azni(this, paramaznc));
      }
      catch (Exception localException)
      {
        continue;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TroopAIORobotLayout", 2, "send to server: " + paramaznc.a.jdField_a_of_type_JavaLangString);
      return;
      a(getContext(), paramaznc.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, true, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
    }
  }
  
  public void b(aznc paramaznc, String paramString)
  {
    azks.a("panel", "clk", this.c, this.jdField_a_of_type_JavaLangString, paramString, "");
  }
  
  public void d(aznc paramaznc, String paramString)
  {
    azks.a("panel", "clk", this.c, this.jdField_a_of_type_JavaLangString, paramString, "");
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