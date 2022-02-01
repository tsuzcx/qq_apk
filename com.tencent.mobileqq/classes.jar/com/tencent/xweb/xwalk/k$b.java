package com.tencent.xweb.xwalk;

import org.xwalk.core.Log;

public class k$b
{
  public String a;
  public String b;
  public String c;
  public int d;
  public int e;
  public int f;
  public int g;
  public String h;
  public String i;
  
  public static b a(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4)
  {
    b localb = new b();
    localb.a = paramString1;
    localb.i = paramString2;
    localb.d = paramInt1;
    localb.f = paramInt2;
    localb.b = paramString3;
    localb.c = paramString4;
    int m = 1;
    int i1 = 0;
    if (paramInt1 > 0) {}
    try
    {
      paramString2 = new StringBuffer(paramString3).reverse().toString();
      k = 0;
      j = paramInt1;
    }
    catch (Exception paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("SelectInfo getSelectInfo error:");
      paramString2.append(paramString1.getMessage());
      Log.e("XWWebView", paramString2.toString());
      return localb;
    }
    int j = paramInt1 * -1;
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append(paramString4);
    paramString2 = paramString2.toString();
    int k = 1;
    break label415;
    int n = paramInt2 * -1;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(new StringBuffer(paramString1).reverse().toString());
    ((StringBuilder)localObject).append(new StringBuffer(paramString3).reverse().toString());
    localObject = ((StringBuilder)localObject).toString();
    break label429;
    label184:
    if (paramInt1 <= paramString2.length()) {
      if (j <= paramString2.substring(0, paramInt1).getBytes().length)
      {
        paramInt2 = paramInt1;
        break label445;
        label212:
        if (paramInt1 > ((String)localObject).length()) {
          break label463;
        }
        if (n > ((String)localObject).substring(0, paramInt1).getBytes().length) {
          break label453;
        }
        break label466;
        label240:
        if (paramString1.length() + j + paramInt2 > 0) {
          break label493;
        }
        paramString2 = new StringBuilder();
        paramString2.append("getSelectInfo error prefixIndex:");
        paramString2.append(j);
        paramString2.append(",suffixIndex:");
        paramString2.append(paramInt2);
        Log.e("XWWebView", paramString2.toString());
        paramInt2 = 0;
        paramInt1 = i1;
      }
    }
    for (;;)
    {
      localb.e = paramInt1;
      localb.g = paramInt2;
      paramString2 = new StringBuilder();
      paramString2.append(paramString3);
      paramString2.append(paramString1);
      paramString2.append(paramString4);
      localb.h = paramString2.toString().substring(paramString3.length() - paramInt1, paramString3.length() + paramString1.length() + paramInt2);
      return localb;
      label415:
      if (paramInt2 <= 0) {
        break;
      }
      localObject = paramString4;
      m = 0;
      n = paramInt2;
      label429:
      paramInt1 = 0;
      paramInt2 = 0;
      break label184;
      paramInt2 = paramInt1;
      paramInt1 += 1;
      break label184;
      label445:
      paramInt1 = 0;
      j = 0;
      break label212;
      label453:
      j = paramInt1;
      paramInt1 += 1;
      break label212;
      label463:
      paramInt1 = j;
      label466:
      j = paramInt2;
      if (k != 0) {
        j = paramInt2 * -1;
      }
      paramInt2 = paramInt1;
      if (m == 0) {
        break label240;
      }
      paramInt2 = paramInt1 * -1;
      break label240;
      label493:
      paramInt1 = j;
    }
  }
  
  public String toString()
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SelectInfo PickedWord:");
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append(",PrefixText:");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append(",SuffixText:");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append(",PrefixOffset:");
      ((StringBuilder)localObject).append(this.d);
      ((StringBuilder)localObject).append(",prefixIndex:");
      ((StringBuilder)localObject).append(this.e);
      ((StringBuilder)localObject).append(",SuffixOffset:");
      ((StringBuilder)localObject).append(this.f);
      ((StringBuilder)localObject).append(",SuffixIndex:");
      ((StringBuilder)localObject).append(this.g);
      ((StringBuilder)localObject).append(",ResultPickedWord:");
      ((StringBuilder)localObject).append(this.i);
      ((StringBuilder)localObject).append(",OffsetedPickedWord:");
      ((StringBuilder)localObject).append(this.h);
      localObject = ((StringBuilder)localObject).toString();
      return localObject;
    }
    catch (Exception localException)
    {
      label159:
      break label159;
    }
    return "SelectInfo toString error";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.k.b
 * JD-Core Version:    0.7.0.1
 */