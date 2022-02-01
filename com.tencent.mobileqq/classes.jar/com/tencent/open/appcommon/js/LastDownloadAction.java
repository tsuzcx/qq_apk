package com.tencent.open.appcommon.js;

import android.text.TextUtils;

public class LastDownloadAction
{
  String a;
  String b;
  int c;
  long d;
  
  public LastDownloadAction(String paramString1, String paramString2, int paramInt)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramInt;
    this.d = System.currentTimeMillis();
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt)
  {
    boolean bool3 = TextUtils.isEmpty(paramString1);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3) {
      if (TextUtils.isEmpty(this.a))
      {
        bool1 = bool2;
      }
      else
      {
        bool1 = bool2;
        if (this.c == paramInt)
        {
          bool1 = bool2;
          if (this.a.equals(paramString1))
          {
            bool1 = bool2;
            if (this.b.equals(paramString2))
            {
              bool1 = bool2;
              if (System.currentTimeMillis() - this.d < 1000L) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    if (!bool1)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramInt;
      this.d = System.currentTimeMillis();
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appcommon.js.LastDownloadAction
 * JD-Core Version:    0.7.0.1
 */