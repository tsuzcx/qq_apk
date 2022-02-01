package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import com.tencent.mobileqq.widget.QQBlur.BackgroundViewDirtyListener;
import com.tencent.mobileqq.widget.QQBlurView;

public class BlurUtil
{
  public static Bitmap a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return null;
    }
    if (paramDrawable.getOpacity() != -1) {
      localObject = Bitmap.Config.ARGB_8888;
    } else {
      localObject = Bitmap.Config.RGB_565;
    }
    Object localObject = Bitmap.createBitmap(2, 2, (Bitmap.Config)localObject);
    Canvas localCanvas = new Canvas((Bitmap)localObject);
    paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
    paramDrawable.draw(localCanvas);
    return localObject;
  }
  
  public static void a(QQBlurView paramQQBlurView, View paramView, int paramInt, QQBlur.BackgroundViewDirtyListener paramBackgroundViewDirtyListener)
  {
    if ((QQTheme.isSimpleWhite()) && (a()))
    {
      Context localContext = paramView.getContext();
      paramQQBlurView.setVisibility(0);
      paramQQBlurView.a(paramView);
      paramQQBlurView.b(paramQQBlurView);
      paramQQBlurView.a(8);
      paramQQBlurView.c(-1);
      paramQQBlurView.a(new ColorDrawable(localContext.getResources().getColor(paramInt)));
      paramQQBlurView.setEnableBlur(true);
      if (paramBackgroundViewDirtyListener != null) {
        paramQQBlurView.setDirtyListener(paramBackgroundViewDirtyListener);
      }
      paramQQBlurView.d();
      return;
    }
    paramQQBlurView.setVisibility(8);
  }
  
  public static boolean a()
  {
    return Build.VERSION.SDK_INT >= 24;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.BlurUtil
 * JD-Core Version:    0.7.0.1
 */