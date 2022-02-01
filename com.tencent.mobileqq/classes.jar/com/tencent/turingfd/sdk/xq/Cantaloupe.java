package com.tencent.turingfd.sdk.xq;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class Cantaloupe
{
  public String a;
  public int b;
  public Pyxis c;
  
  public Cantaloupe(String paramString, int paramInt, Pyxis paramPyxis)
  {
    this.a = paramString;
    this.b = paramInt;
    this.c = paramPyxis;
  }
  
  public static String a(String paramString)
  {
    String str = paramString;
    if (paramString.indexOf(".") > 0) {
      str = paramString.replaceAll("0+?$", "").replaceAll("[.]$", "");
    }
    return str;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    String str = paramString3;
    if (!TextUtils.isEmpty(paramString3)) {
      str = paramString3.replace(paramString1, paramString2);
    }
    return str;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject2 = this.a;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localStringBuilder.append(a("&", "%0A", a(",", "%54", a("_", "%5F", a(";", "%3B", a(":", "%3A", (String)localObject1))))));
    localStringBuilder.append("_");
    localStringBuilder.append(this.b);
    localStringBuilder.append("_");
    localStringBuilder.append(this.c.b);
    localStringBuilder.append(":");
    localStringBuilder.append(this.c.c);
    localStringBuilder.append(":");
    localObject1 = this.c.d.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Sagittarius)((Iterator)localObject1).next();
      localStringBuilder.append(((Sagittarius)localObject2).a);
      localStringBuilder.append(",");
      localStringBuilder.append(a(String.format("%.5f", new Object[] { Float.valueOf(((Sagittarius)localObject2).b) })));
      localStringBuilder.append(",");
      localStringBuilder.append(a(String.format("%.5f", new Object[] { Float.valueOf(((Sagittarius)localObject2).c) })));
      localStringBuilder.append(",");
      localStringBuilder.append(a(String.format("%.5f", new Object[] { Float.valueOf(((Sagittarius)localObject2).d) })));
      localStringBuilder.append(",");
      localStringBuilder.append(a(String.format("%.5f", new Object[] { Float.valueOf(((Sagittarius)localObject2).e) })));
      if (((Iterator)localObject1).hasNext()) {
        localStringBuilder.append(";");
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Cantaloupe
 * JD-Core Version:    0.7.0.1
 */