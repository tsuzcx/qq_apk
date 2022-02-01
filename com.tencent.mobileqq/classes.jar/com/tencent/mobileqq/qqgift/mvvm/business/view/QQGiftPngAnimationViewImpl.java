package com.tencent.mobileqq.qqgift.mvvm.business.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.mobileqq.qqgift.callback.IQQGiftAnimationListener;
import com.tencent.mobileqq.qqgift.mvvm.business.anim.GiftAnimData;
import com.tencent.mobileqq.qqgift.utils.ThreadManager;
import com.tencent.widget.immersive.ImmersiveUtils;

public class QQGiftPngAnimationViewImpl
  implements IQQGiftAnimationView
{
  private final ImageView a;
  private IQQGiftAnimationListener b = null;
  private Bitmap c = null;
  private volatile String d = "";
  private boolean e = false;
  
  public QQGiftPngAnimationViewImpl(Context paramContext)
  {
    this.a = new ImageView(paramContext);
  }
  
  public FrameLayout.LayoutParams a(GiftAnimData paramGiftAnimData)
  {
    int i = ImmersiveUtils.dpToPx(250.0F);
    paramGiftAnimData = new FrameLayout.LayoutParams(i, i);
    paramGiftAnimData.gravity = 81;
    paramGiftAnimData.bottomMargin = ImmersiveUtils.dpToPx(100.0F);
    return paramGiftAnimData;
  }
  
  public void a()
  {
    try
    {
      this.e = true;
      this.d = "";
      this.a.clearAnimation();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(IQQGiftAnimationListener paramIQQGiftAnimationListener)
  {
    this.b = paramIQQGiftAnimationListener;
  }
  
  public void a(String paramString)
  {
    try
    {
      this.e = false;
      this.d = paramString;
      ThreadManager.a(new QQGiftPngAnimationViewImpl.1(this, paramString), true);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public View b()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.view.QQGiftPngAnimationViewImpl
 * JD-Core Version:    0.7.0.1
 */