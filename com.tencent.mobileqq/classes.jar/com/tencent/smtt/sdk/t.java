package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.export.external.DexLoader;

class t
{
  private DexLoader a = null;
  
  public t(DexLoader paramDexLoader)
  {
    this.a = paramDexLoader;
  }
  
  public String a(Context paramContext)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((DexLoader)localObject).newInstance("com.tencent.tbs.utils.TbsVideoUtilsProxy", new Class[0], new Object[0]);
      if (localObject != null)
      {
        paramContext = this.a.invokeMethod(localObject, "com.tencent.tbs.utils.TbsVideoUtilsProxy", "getCurWDPDecodeType", new Class[] { Context.class }, new Object[] { paramContext });
        if (paramContext != null) {
          return String.valueOf(paramContext);
        }
      }
    }
    return "";
  }
  
  public void a(Context paramContext, String paramString)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((DexLoader)localObject).newInstance("com.tencent.tbs.utils.TbsVideoUtilsProxy", new Class[0], new Object[0]);
      if (localObject != null) {
        this.a.invokeMethod(localObject, "com.tencent.tbs.utils.TbsVideoUtilsProxy", "deleteVideoCache", new Class[] { Context.class, String.class }, new Object[] { paramContext, paramString });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.t
 * JD-Core Version:    0.7.0.1
 */