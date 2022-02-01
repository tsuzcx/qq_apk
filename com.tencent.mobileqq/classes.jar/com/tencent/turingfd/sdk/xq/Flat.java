package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

public class Flat
  extends Thread
{
  public Flat(Foxnut paramFoxnut, Context paramContext) {}
  
  public void run()
  {
    Context localContext = this.a;
    Object localObject2 = Date.a;
    try
    {
      l = Long.valueOf(Date.b(localContext, "801")).longValue();
    }
    finally
    {
      long l;
      label26:
      StringBuilder localStringBuilder;
      break label26;
    }
    l = 0L;
    if (l == 0L)
    {
      localContext = this.a;
      localObject2 = new HashMap();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(System.currentTimeMillis());
      ((HashMap)localObject2).put("801", localStringBuilder.toString());
      Date.a(localContext, (Map)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Flat
 * JD-Core Version:    0.7.0.1
 */