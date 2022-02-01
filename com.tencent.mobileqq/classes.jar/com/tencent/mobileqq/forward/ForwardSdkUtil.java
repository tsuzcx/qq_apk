package com.tencent.mobileqq.forward;

import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import java.io.Closeable;
import java.io.IOException;

public class ForwardSdkUtil
{
  public static void a(Context paramContext, String paramString) {}
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable == null) {
      return;
    }
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      label12:
      break label12;
    }
    QLog.e("ForwardSdkUtil", 1, " requestShareMessage net error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkUtil
 * JD-Core Version:    0.7.0.1
 */