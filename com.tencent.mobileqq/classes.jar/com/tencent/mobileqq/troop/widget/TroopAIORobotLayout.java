package com.tencent.mobileqq.troop.widget;

import afii;
import android.content.Context;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import bevq;
import bezm;
import bfdm;
import bfft;
import bffv;
import bffw;
import bfga;
import bfgb;
import bfgc;
import bfgd;
import bfyz;
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
  
  private String a(String paramString1, String paramString2, String paramString3, bffv parambffv, bfdm parambfdm)
  {
    int i;
    if (parambffv.jdField_b_of_type_Boolean)
    {
      parambffv.jdField_b_of_type_Boolean = false;
      parambfdm.a();
      i = parambffv.jdField_b_of_type_Bffw.c.indexOf("content=");
      if (i <= 0) {
        break label193;
      }
    }
    label193:
    for (paramString3 = parambffv.jdField_b_of_type_Bffw.c.substring(i + 8);; paramString3 = "")
    {
      String str = parambffv.jdField_b_of_type_Bffw.jdField_a_of_type_JavaLangString;
      bfdm.a("panel", "talk_out", paramString2, paramString2, "1", "");
      try
      {
        parambfdm.b(Long.parseLong(paramString1), Long.parseLong(paramString2), paramString3, new bfgc(this, parambffv));
        return str;
      }
      catch (Exception paramString1)
      {
        return str;
      }
      str = parambffv.a.jdField_a_of_type_JavaLangString;
      parambffv.jdField_b_of_type_Boolean = true;
      parambfdm.b(paramString1, paramString2, paramString3);
      i = parambffv.a.c.indexOf("content=");
      if (i > 0) {}
      for (paramString3 = parambffv.a.c.substring(i + 8);; paramString3 = "")
      {
        bfdm.a("panel", "talk_in", paramString2, paramString2, "", "");
        break;
      }
    }
  }
  
  private void a(afii paramafii, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramafii == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    SpannableString localSpannableString = bevq.a(paramafii.app, getContext(), paramString1, paramString1, paramString2, false, true);
    if (localSpannableString != null)
    {
      if (paramBoolean) {
        break label93;
      }
      paramafii.input.setText(localSpannableString);
    }
    for (;;)
    {
      paramafii.input.append(" ");
      paramafii.input.setSelection(paramafii.input.getText().length());
      paramafii.a(paramString1, paramString2, true, 0);
      return;
      label93:
      paramafii.input.append(localSpannableString);
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, bfdm parambfdm, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (String str = "off";; str = "on")
    {
      int j = b();
      if (j <= 0) {
        return;
      }
      int i = 0;
      bffv localbffv;
      if (i < j)
      {
        localbffv = (bffv)a(i);
        if ((localbffv != null) && (!TextUtils.isEmpty(localbffv.jdField_b_of_type_Bffw.jdField_a_of_type_JavaLangString)))
        {
          localbffv.jdField_b_of_type_Boolean = paramBoolean;
          if (!paramBoolean)
          {
            i = localbffv.jdField_b_of_type_Bffw.c.indexOf("content=");
            if (i > 0) {
              str = localbffv.jdField_b_of_type_Bffw.c.substring(i + 8);
            }
          }
        }
      }
      for (;;)
      {
        label111:
        if (paramBoolean) {
          parambfdm.b(paramString1, paramString2, paramString3);
        }
        for (;;)
        {
          try
          {
            parambfdm.b(Long.parseLong(paramString1), Long.parseLong(paramString2), str, new bfgd(this));
            return;
          }
          catch (Exception paramString1)
          {
            return;
          }
          i = localbffv.a.c.indexOf("content=");
          if (i > 0) {
            str = localbffv.a.c.substring(i + 8);
          }
          break label111;
          i += 1;
          break;
          parambfdm.a();
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
  
  public String a(bffv parambffv)
  {
    Object localObject = a();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAIORobotLayout", 2, "troopRobotManager = null");
      }
      parambffv = null;
    }
    do
    {
      return parambffv;
      localObject = a(this.c, this.jdField_a_of_type_JavaLangString, this.b, parambffv, (bfdm)localObject);
      parambffv = (bffv)localObject;
    } while (!QLog.isColorLevel());
    QLog.d("TroopAIORobotLayout", 2, "talking: " + (String)localObject);
    return localObject;
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(bffv parambffv)
  {
    bfdm localbfdm = a();
    if (localbfdm == null) {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAIORobotLayout", 2, "troopRobotManager = null");
      }
    }
    for (;;)
    {
      return;
      if (b())
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.append(parambffv.a.jdField_a_of_type_JavaLangString);
        ((afii)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie).h = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.send();
        ((afii)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie).h = false;
        if (!localbfdm.a()) {
          a((afii)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_JavaLangString, this.b, false);
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d("TroopAIORobotLayout", 2, "send to robot: " + parambffv.a.jdField_a_of_type_JavaLangString);
        return;
        a(getContext(), parambffv.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, false, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
      }
    }
  }
  
  public void a(bffv parambffv, String paramString)
  {
    bezm.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, "0X8009FA2", this.jdField_a_of_type_JavaLangString, paramString);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, afii paramafii, bfft parambfft)
  {
    super.a(paramString2, paramString3, paramafii, parambfft);
    paramafii = a();
    if (paramafii == null)
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
    i = bfyz.ap(getContext(), paramString1 + "_" + paramString2);
    paramafii.a(l2, l1, i, new bfga(this, i, paramString2, paramString1, paramString3, parambfft));
  }
  
  public void b(bffv parambffv)
  {
    bfdm localbfdm = a();
    if (localbfdm == null)
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
        int i = parambffv.a.c.indexOf("content=");
        if (i > 0) {
          str = parambffv.a.c.substring(i + 8);
        }
        if (!b()) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.append(parambffv.a.jdField_a_of_type_JavaLangString);
        ((afii)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie).h = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.isSendToRobotServer = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.send();
        ((afii)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie).h = false;
        if (!localbfdm.a()) {
          a((afii)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this.jdField_a_of_type_JavaLangString, this.b, false);
        }
        localbfdm.a(l1, l2, str, new bfgb(this, parambffv));
      }
      catch (Exception localException)
      {
        continue;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TroopAIORobotLayout", 2, "send to server: " + parambffv.a.jdField_a_of_type_JavaLangString);
      return;
      a(getContext(), parambffv.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, this.b, true, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    }
  }
  
  public void b(bffv parambffv, String paramString)
  {
    bfdm.a("panel", "clk", this.c, this.jdField_a_of_type_JavaLangString, paramString, "");
  }
  
  public void d(bffv parambffv, String paramString)
  {
    bfdm.a("panel", "clk", this.c, this.jdField_a_of_type_JavaLangString, paramString, "");
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