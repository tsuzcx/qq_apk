package com.tencent.smtt.sdk;

import android.content.Context;

public class TbsVideoUtils
{
  private static TbsVideoUtilsWizard tbsVideoUtilsWizard = null;
  
  public static void deleteVideoCache(Context paramContext, String paramString)
  {
    initUtilsWizard(paramContext);
    if (tbsVideoUtilsWizard != null) {
      tbsVideoUtilsWizard.deleteVideoCache(paramContext, paramString);
    }
  }
  
  public static String getCurWDPDecodeType(Context paramContext)
  {
    initUtilsWizard(paramContext);
    if (tbsVideoUtilsWizard != null) {
      return tbsVideoUtilsWizard.getCurWDPDecodeType(paramContext);
    }
    return "";
  }
  
  private static void initUtilsWizard(Context paramContext)
  {
    Object localObject = null;
    try
    {
      if (tbsVideoUtilsWizard == null)
      {
        SDKEngine.getInstance(true).init(paramContext, false, false, null);
        TbsWizard localTbsWizard = SDKEngine.getInstance(true).wizard();
        paramContext = localObject;
        if (localTbsWizard != null) {
          paramContext = localTbsWizard.dexLoader();
        }
        if (paramContext != null) {
          tbsVideoUtilsWizard = new TbsVideoUtilsWizard(paramContext);
        }
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsVideoUtils
 * JD-Core Version:    0.7.0.1
 */