package com.tencent.qqmini.sdk.utils;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.utils.ImageUtil;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.File;

public class SaveCaptureImageUitl
{
  public static final String TAG = "SaveCaptureImageUitl";
  
  public static Bitmap buildBitmapFromView(View paramView)
  {
    if (paramView != null) {
      try
      {
        paramView.setDrawingCacheEnabled(true);
        paramView.buildDrawingCache();
        Bitmap localBitmap = Bitmap.createBitmap(paramView.getDrawingCache());
        paramView.setDrawingCacheEnabled(false);
        return localBitmap;
      }
      catch (Throwable paramView)
      {
        QMLog.e("SaveCaptureImageUitl", "buildBitmapFromView failed ", paramView);
      }
    }
    return null;
  }
  
  public static String cutAndSaveShareScreenshot(IMiniAppContext paramIMiniAppContext, Bitmap paramBitmap)
  {
    if (paramIMiniAppContext == null) {
      return null;
    }
    int i;
    double d;
    if (paramIMiniAppContext.getAttachedActivity() != null)
    {
      localObject = paramIMiniAppContext.getAttachedActivity().getResources().getDisplayMetrics();
      i = ((DisplayMetrics)localObject).widthPixels;
      d = ((DisplayMetrics)localObject).widthPixels;
      Double.isNaN(d);
    }
    else
    {
      i = (int)DeviceInfoUtil.getWidth();
      d = DeviceInfoUtil.getHeight();
      Double.isNaN(d);
    }
    int j = (int)(d * 0.8D);
    paramBitmap = ImageUtil.cutOutImg(Bitmap.createBitmap(paramBitmap), i, j);
    Object localObject = ImageUtil.compressImage(paramBitmap, 1044480);
    paramIMiniAppContext = new File(((MiniAppFileManager)paramIMiniAppContext.getManager(MiniAppFileManager.class)).getTmpPath("png"));
    boolean bool = ImageUtil.saveBitmapToFile((byte[])localObject, paramIMiniAppContext);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
      paramBitmap.recycle();
    }
    if (bool) {
      return paramIMiniAppContext.getAbsolutePath();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.SaveCaptureImageUitl
 * JD-Core Version:    0.7.0.1
 */