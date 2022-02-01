package com.tencent.mobileqq.studymode;

import com.etrump.mixlayout.ETTextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vas.VasResEngine.VasRes;
import com.tencent.qphone.base.util.QLog;

public class AlphabeticFontHelper
{
  private VasRes a;
  
  public static boolean a(AppInterface paramAppInterface)
  {
    try
    {
      boolean bool = ((Boolean)SharedPreUtils.b(BaseApplicationImpl.context, paramAppInterface.getCurrentAccountUin(), "key_alphabetic_font_switch_status_", Boolean.valueOf(false))).booleanValue();
      return bool;
    }
    catch (Throwable paramAppInterface)
    {
      QLog.e("AlphabeticFontHelper", 1, paramAppInterface, new Object[0]);
    }
    return false;
  }
  
  public void a()
  {
    VasRes localVasRes = this.a;
    if (localVasRes != null) {
      localVasRes.a();
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, ETTextView paramETTextView, int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.AlphabeticFontHelper
 * JD-Core Version:    0.7.0.1
 */