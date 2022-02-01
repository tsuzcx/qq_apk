package com.tencent.mobileqq.doc;

import android.content.Context;

public class TencentDocPref
  extends MyPref
{
  public static boolean a(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TencentDoc_USER_");
    localStringBuilder.append(paramString);
    return MyPref.a(paramContext, localStringBuilder.toString(), false);
  }
  
  public static void b(Context paramContext, String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TencentDoc_USER_");
    localStringBuilder.append(paramString);
    MyPref.a(paramContext, localStringBuilder.toString(), paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.doc.TencentDocPref
 * JD-Core Version:    0.7.0.1
 */