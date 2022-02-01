package com.tencent.mobileqq.pic;

import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.mobileqq.transfile.TransFileUtil;
import com.tencent.qphone.base.util.QLog;

public class Logger
{
  public static String a(int paramInt1, int paramInt2, int paramInt3)
  {
    String str = RichMediaUtil.getActionDesc(paramInt2);
    return TransFileUtil.buildTag(TransFileUtil.getUinDesc(paramInt1), RichMediaUtil.getFileTypeDesc(paramInt3), str, "L");
  }
  
  public static void a(Object paramObject, String paramString1, String paramString2)
  {
    TransFileUtil.printRichMediaDebug(paramObject, paramString1, paramString2);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    a(paramString1, paramString2, paramString3, paramString4, 1);
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    StringBuilder localStringBuilder;
    if (paramInt == 1)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("id:");
        localStringBuilder.append(paramString2);
        localStringBuilder.append(" \tstep:");
        localStringBuilder.append(paramString3);
        localStringBuilder.append(" \tcont:");
        localStringBuilder.append(paramString4);
        QLog.d(paramString1, 2, localStringBuilder.toString());
      }
    }
    else if (paramInt == 2)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("id:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" \tstep:");
      localStringBuilder.append(paramString3);
      localStringBuilder.append(" \tcont:");
      localStringBuilder.append(paramString4);
      QLog.e(paramString1, 1, localStringBuilder.toString());
    }
  }
  
  public static void b(Object paramObject, String paramString1, String paramString2)
  {
    TransFileUtil.printRichMediaError(paramObject, paramString1, paramString2);
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    a(paramString1, paramString2, paramString3, paramString4, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.Logger
 * JD-Core Version:    0.7.0.1
 */