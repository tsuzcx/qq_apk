package com.tencent.mobileqq.onlinestatus.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.support.v4.util.MQLruCache;
import android.view.View;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.qphone.base.util.QLog;
import java.io.FileInputStream;
import mqq.os.MqqHandler;

public class LottieHelper
{
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, LottieHelper.LottieDrawableLoadedListener paramLottieDrawableLoadedListener)
  {
    try
    {
      LottieComposition.Factory.fromAssetFileName(paramContext, paramString1, new LottieHelper.3(paramInt1, paramInt2, paramInt3, paramString2, paramContext, paramLottieDrawableLoadedListener));
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("onlinestate.LottieHelper", 1, "fromAssetFileName fail", paramContext);
      ThreadManager.getUIHandler().post(new LottieHelper.4(paramLottieDrawableLoadedListener));
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, LottieHelper.LottieDrawableLoadedListener paramLottieDrawableLoadedListener)
  {
    try
    {
      LottieComposition.Factory.fromInputStream(paramContext, new FileInputStream(paramString1), new LottieHelper.1(paramInt1, paramInt2, paramString2, paramLottieDrawableLoadedListener));
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("onlinestate.LottieHelper", 1, "fromAssetFileName fail", paramContext);
      ThreadManager.getUIHandler().post(new LottieHelper.2(paramLottieDrawableLoadedListener));
    }
  }
  
  @TargetApi(11)
  public static void a(View paramView, float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      paramView.setAlpha(paramFloat);
    }
  }
  
  private static Bitmap b(String paramString)
  {
    Object localObject = GlobalImageCache.a.get(paramString);
    if ((localObject != null) && ((localObject instanceof Bitmap))) {
      return (Bitmap)localObject;
    }
    try
    {
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inScaled = false;
      localObject = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
      GlobalImageCache.a.put(paramString, localObject);
      return localObject;
    }
    catch (Throwable paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getBitmap error ");
      ((StringBuilder)localObject).append(paramString.getMessage());
      QLog.i("onlinestate.LottieHelper", 1, ((StringBuilder)localObject).toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.utils.LottieHelper
 * JD-Core Version:    0.7.0.1
 */