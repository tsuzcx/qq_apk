package com.tencent.qapmsdk.impl.instrumentation;

import android.text.TextUtils;

public class a
{
  private String a;
  private String b;
  private String c;
  
  private boolean b(String paramString1, String paramString2)
  {
    return (!TextUtils.isEmpty(paramString1)) && (paramString1.equals(paramString2));
  }
  
  void a(String paramString1, String paramString2)
  {
    this.b = paramString1;
    this.c = paramString2;
    if (b(paramString1, paramString2)) {
      this.a = paramString1;
    }
  }
  
  public boolean a()
  {
    if (b(this.b, this.c)) {
      return true;
    }
    return TextUtils.isEmpty(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.a
 * JD-Core Version:    0.7.0.1
 */