package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;

public class Date
{
  public static final long ei = ;
  
  public static String a(Context paramContext, boolean paramBoolean1, int paramInt1, boolean paramBoolean2, boolean paramBoolean3, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("T:");
    localStringBuilder.append(ei);
    localStringBuilder.append(",");
    localStringBuilder.append("LT:");
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(System.currentTimeMillis() - ei);
    localStringBuilder.append(((StringBuilder)localObject1).toString());
    localStringBuilder.append(",");
    localStringBuilder.append("F:");
    Object localObject2 = "1";
    if (paramBoolean1) {
      localObject1 = "1";
    } else {
      localObject1 = "0";
    }
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(",");
    localStringBuilder.append("PT:");
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(paramInt1);
    localStringBuilder.append(((StringBuilder)localObject1).toString());
    localStringBuilder.append(",");
    localStringBuilder.append("PKG:");
    if (paramBoolean2) {
      localObject1 = "1";
    } else {
      localObject1 = "0";
    }
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(",");
    localStringBuilder.append("SC:");
    if (paramBoolean3) {
      localObject1 = "1";
    } else {
      localObject1 = "0";
    }
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(",");
    localStringBuilder.append("SRT:");
    localStringBuilder.append(paramInt2);
    localObject1 = Codlin.Tg.ca(paramContext);
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localStringBuilder.append(",");
      localStringBuilder.append("CL:");
      localStringBuilder.append((String)localObject1);
    }
    Object localObject3 = Cascara.e(paramContext, "204");
    localObject1 = localObject3;
    if (TextUtils.isEmpty((CharSequence)localObject3))
    {
      localObject3 = do.b("0_");
      if (paramBoolean1) {
        localObject1 = localObject2;
      } else {
        localObject1 = "0";
      }
      ((StringBuilder)localObject3).append((String)localObject1);
      localObject1 = ((StringBuilder)localObject3).toString();
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localStringBuilder.append(",");
      localStringBuilder.append("R:");
      localStringBuilder.append((String)localObject1);
    }
    localObject1 = Damson.getInstance().k("3");
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = abstract.j((String)localObject1);
      if (localObject2.length != 0) {
        localObject2 = void.a((byte[])localObject2, ".turingdebug".getBytes());
      }
    }
    try
    {
      new File((String)localObject1).deleteOnExit();
      try
      {
        label471:
        localObject1 = new String((byte[])localObject2);
      }
      catch (Throwable localThrowable2)
      {
        label485:
        break label485;
      }
      localObject1 = "";
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localStringBuilder.append(",");
        localStringBuilder.append("RD:");
        localStringBuilder.append((String)localObject1);
      }
      localStringBuilder.append(",");
      localStringBuilder.append("US:");
      localStringBuilder.append(Cascara.S(paramContext));
      paramContext = Cascara.e(paramContext, "111");
      if (!TextUtils.isEmpty(paramContext))
      {
        localStringBuilder.append(",");
        localStringBuilder.append("ND:");
        localStringBuilder.append(paramContext);
      }
      return localStringBuilder.toString();
    }
    catch (Throwable localThrowable1)
    {
      break label471;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Date
 * JD-Core Version:    0.7.0.1
 */