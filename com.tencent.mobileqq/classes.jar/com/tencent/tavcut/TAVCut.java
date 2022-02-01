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
  private static final String TAG = TAVCut.class.getSimpleName();
  private static final String TAVKIT_SO_NAME = "libtav.so";
  private static boolean isDebug = false;
  private static String lightBundleResPath = null;
  
  public static String getLightBundleResPath()
  {
    if (isDebug()) {
      return Environment.getExternalStorageDirectory().getAbsolutePath() + "/light_assets/";
    }
    return lightBundleResPath;
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
      if ((!TextUtils.isEmpty(paramString1)) && (!ResourceLoadUtil.loadSoSync(paramString1 + "libtav.so")))
      {
        Logger.e(TAG, "tavkit so init failed");
        if (paramCallback != null)
        {
          paramCallback.onDone(-1);
          return;
        }
      }
      if ((!TextUtils.isEmpty(paramString2)) && (!PAGSOLoadUtil.loadSoSync(paramString2 + "liblibpag.so")))
      {
        Logger.e(TAG, "pag so init failed");
        if (paramCallback != null)
        {
          paramCallback.onDone(-2);
          return;
        }
      }
    }
    catch (Exception paramContext)
    {
      Logger.e(paramContext);
      if (paramCallback != null)
      {
        paramCallback.onDone(-1);
        return;
        if (!TextUtils.isEmpty(paramString3))
        {
          AEStaticDetector.initDetector(paramString3);
          lightBundleResPath = new File(paramString3).getParent();
          if ((TextUtils.isEmpty(lightBundleResPath)) && (paramCallback != null))
          {
            paramCallback.onDone(-3);
            return;
          }
        }
        if (paramCallback != null) {
          paramCallback.onDone(0);
        }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavcut.TAVCut
 * JD-Core Version:    0.7.0.1
 */