package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Bundle;
import com.tencent.smtt.export.external.DexLoader;

class TbsVideoUtilsWizard
{
  private static final String TBS_VIDEO_UTILS_CLASS_NAME = "com.tencent.tbs.utils.TbsVideoUtilsProxy";
  private DexLoader mDexLoader = null;
  
  public TbsVideoUtilsWizard(DexLoader paramDexLoader)
  {
    this.mDexLoader = paramDexLoader;
  }
  
  public void deleteVideoCache(Context paramContext, String paramString)
  {
    if (this.mDexLoader != null)
    {
      Object localObject = this.mDexLoader.newInstance("com.tencent.tbs.utils.TbsVideoUtilsProxy", new Class[0], new Object[0]);
      if (localObject != null) {
        this.mDexLoader.invokeMethod(localObject, "com.tencent.tbs.utils.TbsVideoUtilsProxy", "deleteVideoCache", new Class[] { Context.class, String.class }, new Object[] { paramContext, paramString });
      }
    }
  }
  
  public String getCurWDPDecodeType(Context paramContext)
  {
    if (this.mDexLoader != null)
    {
      Object localObject = this.mDexLoader.newInstance("com.tencent.tbs.utils.TbsVideoUtilsProxy", new Class[0], new Object[0]);
      if (localObject != null)
      {
        paramContext = this.mDexLoader.invokeMethod(localObject, "com.tencent.tbs.utils.TbsVideoUtilsProxy", "getCurWDPDecodeType", new Class[] { Context.class }, new Object[] { paramContext });
        if (paramContext != null) {
          return String.valueOf(paramContext);
        }
      }
    }
    return "";
  }
  
  public Bundle getVideoAttribute(Context paramContext, String paramString, Bundle paramBundle)
  {
    if (this.mDexLoader != null)
    {
      Object localObject = this.mDexLoader.newInstance("com.tencent.tbs.utils.TbsVideoUtilsProxy", new Class[0], new Object[0]);
      if (localObject != null) {
        return (Bundle)this.mDexLoader.invokeMethod(localObject, "com.tencent.tbs.utils.TbsVideoUtilsProxy", "getVideoGetAttribute", new Class[] { Context.class, String.class, Bundle.class }, new Object[] { paramContext, paramString, paramBundle });
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsVideoUtilsWizard
 * JD-Core Version:    0.7.0.1
 */