package com.tencent.mobileqq.emosm;

import android.os.Bundle;

public class DataFactory$EmojiPayRespData
{
  public int a = -1;
  public int b = 0;
  public int c = -1;
  public int d = -1;
  public int e = -1;
  public String f = "";
  
  public DataFactory$EmojiPayRespData(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramInt5;
    this.f = paramString;
  }
  
  public static EmojiPayRespData a(Bundle paramBundle)
  {
    int m;
    int n;
    int j;
    int k;
    int i;
    if (paramBundle != null)
    {
      m = paramBundle.getInt("result", -1);
      n = paramBundle.getInt("realSaveNum", 0);
      j = paramBundle.getInt("payChannel", -1);
      k = paramBundle.getInt("payState", -1);
      i = paramBundle.getInt("provideState", -1);
      paramBundle = paramBundle.getString("message");
    }
    else
    {
      paramBundle = "";
      m = -1;
      n = 0;
      j = -1;
      k = -1;
      i = -1;
    }
    return new EmojiPayRespData(m, n, j, k, i, paramBundle);
  }
  
  public Bundle a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("result", this.a);
    localBundle.putInt("realSaveNum", this.b);
    localBundle.putInt("payChannel", this.c);
    localBundle.putInt("payState", this.d);
    localBundle.putInt("provideState", this.e);
    localBundle.putString("message", this.f);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.DataFactory.EmojiPayRespData
 * JD-Core Version:    0.7.0.1
 */