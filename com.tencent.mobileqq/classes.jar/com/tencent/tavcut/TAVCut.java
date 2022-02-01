package com.tencent.tavcut;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.oscar.app.PAGSOLoadUtil;
import com.tencent.tav.ResourceLoadUtil;
import com.tencent.tavcut.util.Logger;
import com.tencent.tavsticker.TAVStickerHelper;
import com.tencent.ttpic.openapi.util.AEStaticDetector;
import java.io.File;

public class TAVCut
{
  private static final String PAG_SO_NAME = "liblibpag.so";
  private static final String TAG = "TAVCut";
  private static final String TAVKIT_SO_NAME = "libtav.so";
  private static String frameEmptyResPath;
  private static boolean isDebug = false;
  private static String lightBundleResPath;
  
  public static String getLightBundleResPath()
  {
    if (isDebug())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(Environment.getExternalStorageDirectory().getAbsolutePath());
      localStringBuilder.append("/light_assets/");
      return localStringBuilder.toString();
    }
    return lightBundleResPath;
  }
  
  public static String getPlaceHolderTemplatePath()
  {
    if (isDebug()) {
      return "/sdcard/tavcut/frame/none";
    }
    return frameEmptyResPath;
  }
  
  public static void initTAVCut(Context paramContext, TAVCut.Callback paramCallback)
  {
    initTAVCut(paramContext, "", "", paramCallback);
  }
  
  public static void initTAVCut(Context paramContext, String paramString1, String paramString2, TAVCut.Callback paramCallback)
  {
    initTAVCut(paramContext, paramString1, paramString2, "", paramCallback);
  }
  
  public static void initTAVCut(Context paramContext, String paramString1, String paramString2, String paramString3, TAVCut.Callback paramCallback)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString1))
      {
        paramContext = new StringBuilder();
        paramContext.append(paramString1);
        paramContext.append("libtav.so");
        if (!ResourceLoadUtil.loadSoSync(paramContext.toString()))
        {
          Logger.e(TAG, "tavkit so init failed");
          if (paramCallback != null)
          {
            paramCallback.onDone(-1);
            return;
          }
        }
      }
      if (!TextUtils.isEmpty(paramString2))
      {
        paramContext = new StringBuilder();
        paramContext.append(paramString2);
        paramContext.append("liblibpag.so");
        if (!PAGSOLoadUtil.loadSoSync(paramContext.toString()))
        {
          Logger.e(TAG, "pag so init failed");
          if (paramCallback != null)
          {
            paramCallback.onDone(-2);
            return;
          }
        }
      }
      if (!TextUtils.isEmpty(paramString3))
      {
        AEStaticDetector.initDetector(paramString3);
        lightBundleResPath = new File(paramString3).getParent();
        paramContext = new StringBuilder();
        paramContext.append(lightBundleResPath);
        paramContext.append("/material/frame_empty");
        frameEmptyResPath = paramContext.toString();
        if ((TextUtils.isEmpty(lightBundleResPath)) && (paramCallback != null))
        {
          paramCallback.onDone(-3);
          return;
        }
      }
      if (paramCallback != null)
      {
        paramCallback.onDone(0);
        return;
      }
    }
    catch (Exception paramContext)
    {
      Logger.e(paramContext);
      if (paramCallback != null) {
        paramCallback.onDone(-1);
      }
    }
  }
  
  public static boolean isDebug()
  {
    return isDebug;
  }
  
  public static void setDebug(boolean paramBoolean)
  {
    isDebug = paramBoolean;
    TAVStickerHelper.setDebugMode(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.TAVCut
 * JD-Core Version:    0.7.0.1
 */