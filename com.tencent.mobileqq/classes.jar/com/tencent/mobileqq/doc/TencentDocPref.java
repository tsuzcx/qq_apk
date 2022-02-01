package com.tencent.mobileqq.doc;

import android.content.Context;
import com.tencent.av.smallscreen.MyPref;

public class TencentDocPref
  extends MyPref
{
  public static boolean a(Context paramContext, String paramString)
  {
    return a(paramContext, "TencentDoc_USER_" + paramString, false);
  }
  
  public static void b(Context paramContext, String paramString, boolean paramBoolean)
  {
    a(paramContext, "TencentDoc_USER_" + paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doc.TencentDocPref
 * JD-Core Version:    0.7.0.1
 */