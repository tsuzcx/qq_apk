package com.tencent.mobileqq.qwallet.utils.impl;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.richmedia.Size;
import java.lang.reflect.Method;
import mqq.app.MobileQQ;

public class QWalletUIUtils
{
  @Nullable
  public static Typeface a()
  {
    AssetManager localAssetManager = MobileQQ.sMobileQQ.getAssets();
    if (localAssetManager != null) {
      return Typeface.createFromAsset(localAssetManager, "fonts/DIN Alternate.ttf");
    }
    return null;
  }
  
  public static Size a(Context paramContext)
  {
    Object localObject = new DisplayMetrics();
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    try
    {
      if (Build.VERSION.SDK_INT >= 17)
      {
        paramContext.getRealMetrics((DisplayMetrics)localObject);
        return new Size(((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels);
      }
      Method localMethod1 = Display.class.getMethod("getRawWidth", new Class[0]);
      Method localMethod2 = Display.class.getMethod("getRawHeight", new Class[0]);
      try
      {
        localObject = new Size(((Integer)localMethod1.invoke(localObject, new Object[0])).intValue(), ((Integer)localMethod2.invoke(localObject, new Object[0])).intValue());
        return localObject;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        paramContext = new Size(paramContext.getWidth(), paramContext.getHeight());
        return paramContext;
      }
      return null;
    }
    catch (NoSuchMethodException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.utils.impl.QWalletUIUtils
 * JD-Core Version:    0.7.0.1
 */