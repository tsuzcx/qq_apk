package com.tencent.qmsp.sdk.a;

import android.content.Context;
import com.tencent.qmsp.sdk.app.QmspSDK;
import com.tencent.qmsp.sdk.f.k;
import java.io.File;

public class b
{
  private static final byte[] a = { 52, 125, -96, 80 };
  private static final byte[] b = { 107, 124, -70, 66, 61 };
  private static final byte[] c = { 107, 67, -107, 117, 97 };
  
  public static String a()
  {
    Context localContext = QmspSDK.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(com.tencent.qmsp.sdk.c.b.a);
    localStringBuilder.append(k.a(a));
    return localContext.getDir(localStringBuilder.toString(), 0).toString();
  }
  
  public static String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(k.a(b));
    return localStringBuilder.toString();
  }
  
  public static String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(k.a(c));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qmsp.sdk.a.b
 * JD-Core Version:    0.7.0.1
 */