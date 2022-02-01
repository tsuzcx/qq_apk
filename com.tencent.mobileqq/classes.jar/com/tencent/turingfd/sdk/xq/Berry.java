package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;

public class Berry
{
  public static final long lh = ;
  
  public static String a(Context paramContext, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("T:");
    localStringBuilder.append(lh);
    localStringBuilder.append(",");
    localStringBuilder.append("LT:");
    localStringBuilder.append("" + (System.currentTimeMillis() - lh));
    localStringBuilder.append(",");
    localStringBuilder.append("F:");
    Object localObject1;
    label170:
    label203:
    Object localObject2;
    if (paramBoolean1)
    {
      localObject1 = "1";
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(",");
      localStringBuilder.append("PT:");
      localStringBuilder.append("" + paramInt);
      localStringBuilder.append(",");
      localStringBuilder.append("PKG:");
      if (!paramBoolean2) {
        break label461;
      }
      localObject1 = "1";
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(",");
      localStringBuilder.append("SC:");
      if (!paramBoolean3) {
        break label468;
      }
      localObject1 = "1";
      localStringBuilder.append((String)localObject1);
      localObject1 = Avocado.zg.K(paramContext);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localStringBuilder.append(",");
        localStringBuilder.append("CL:");
        localStringBuilder.append((String)localObject1);
      }
      localObject2 = Almond.c(paramContext, "204");
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject2 = do.a("0_");
        if (!paramBoolean1) {
          break label475;
        }
        localObject1 = "1";
        label287:
        localObject1 = (String)localObject1;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localStringBuilder.append(",");
        localStringBuilder.append("R:");
        localStringBuilder.append((String)localObject1);
      }
      localObject1 = Bergamot.getInstance().o("3");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label482;
      }
    }
    for (;;)
    {
      localObject1 = "";
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localStringBuilder.append(",");
        localStringBuilder.append("RD:");
        localStringBuilder.append((String)localObject1);
      }
      localStringBuilder.append(",");
      localStringBuilder.append("US:");
      localStringBuilder.append(Almond.B(paramContext));
      paramContext = Almond.c(paramContext, "111");
      if (!TextUtils.isEmpty(paramContext))
      {
        localStringBuilder.append(",");
        localStringBuilder.append("ND:");
        localStringBuilder.append(paramContext);
      }
      return localStringBuilder.toString();
      localObject1 = "0";
      break;
      label461:
      localObject1 = "0";
      break label170;
      label468:
      localObject1 = "0";
      break label203;
      label475:
      localObject1 = "0";
      break label287;
      label482:
      localObject2 = extends.i((String)localObject1);
      if (localObject2.length == 0) {
        continue;
      }
      localObject2 = this.a((byte[])localObject2, ".turingdebug".getBytes());
      try
      {
        for (;;)
        {
          new File((String)localObject1).deleteOnExit();
          try
          {
            label519:
            localObject1 = new String((byte[])localObject2);
          }
          catch (Throwable localThrowable1) {}
        }
      }
      catch (Throwable localThrowable2)
      {
        break label519;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Berry
 * JD-Core Version:    0.7.0.1
 */