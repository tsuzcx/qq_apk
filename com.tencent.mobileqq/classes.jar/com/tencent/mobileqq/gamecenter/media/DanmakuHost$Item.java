package com.tencent.mobileqq.gamecenter.media;

import android.graphics.Color;
import android.text.TextUtils;

public class DanmakuHost$Item
{
  public final String a;
  public final double b;
  public final long c;
  public double d;
  public int e = -1;
  public int f = 0;
  
  public DanmakuHost$Item(String paramString, double paramDouble)
  {
    this(paramString, paramDouble, 0.0D, -1, 0);
  }
  
  public DanmakuHost$Item(String paramString, double paramDouble1, double paramDouble2, int paramInt1, int paramInt2)
  {
    this.a = paramString;
    this.b = paramDouble1;
    this.c = ((paramDouble1 * 1000.0D));
    this.d = paramDouble2;
    this.e = paramInt1;
    this.f = paramInt2;
  }
  
  public DanmakuHost$Item(String paramString1, double paramDouble1, double paramDouble2, String paramString2, String paramString3)
  {
    this.a = paramString1;
    this.b = paramDouble1;
    this.c = ((paramDouble1 * 1000.0D));
    this.d = paramDouble2;
    if (!TextUtils.isEmpty(paramString2)) {}
    try
    {
      this.e = Color.parseColor(paramString2);
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        try
        {
          this.f = Color.parseColor(paramString3);
          return;
        }
        catch (Exception paramString1) {}
        paramString1 = paramString1;
      }
    }
    if (!TextUtils.isEmpty(paramString3)) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.media.DanmakuHost.Item
 * JD-Core Version:    0.7.0.1
 */