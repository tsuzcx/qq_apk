package com.tencent.mobileqq.tofumsg;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

public class TofuConst
{
  public static final int[] a = { 1, 2, 3, 4, 5 };
  
  public static final int a(int paramInt)
  {
    if (paramInt >= 0)
    {
      int[] arrayOfInt = a;
      if (paramInt < arrayOfInt.length) {
        return arrayOfInt[paramInt];
      }
    }
    return -1;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    ReportController.b(paramQQAppInterface, "dc00898", "", paramQQAppInterface.getCurrentAccountUin(), paramString, paramString, paramInt, 0, "0", "0", "", "");
  }
  
  public static final String b(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return "unknown";
            }
            return "BUSID_ASK_ANONYMOUSLY";
          }
          return "BUSID_NEWFRD_MINI_CARD";
        }
        return "BUSID_NICE_PICS";
      }
      return "BUSID_BASE_PROFILE";
    }
    return "BUSID_INTIMATE_ANNIVERSARY";
  }
  
  public static final int c(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      int[] arrayOfInt = a;
      if (i >= arrayOfInt.length) {
        break;
      }
      if (arrayOfInt[i] == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tofumsg.TofuConst
 * JD-Core Version:    0.7.0.1
 */