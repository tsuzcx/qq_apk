package com.tencent.mobileqq.qqexpand.flutter.apng;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.peterlmeng.animate_image.Size;
import com.peterlmeng.animate_image.support.common.IBitmapAnimator;
import com.peterlmeng.animate_image.support.common.IBitmapAnimator.AnimatorState;
import com.peterlmeng.animate_image.support.common.IBitmapAnimatorFactory;
import com.peterlmeng.animate_image.support.common.IInvalidateCallback;
import com.peterlmeng.animate_image.support.common.ILoadAnimatorCallback;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Locale;

public class ApngDrawableWrapper
  implements IBitmapAnimator, URLDrawable.DownloadListener, URLDrawable.URLDrawableListener
{
  public static IBitmapAnimatorFactory a = new ApngDrawableWrapper.1();
  final URLDrawable b;
  private final Size c;
  private final String d;
  private IInvalidateCallback<Bitmap> e;
  private ILoadAnimatorCallback f;
  private IBitmapAnimator.AnimatorState g = IBitmapAnimator.AnimatorState.NotLoad;
  private final Bitmap h = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
  private final Canvas i = new Canvas(this.h);
  private int j = 0;
  private ApngDrawableWrapper.ScaleRectSet k = null;
  private final Drawable.Callback l = new ApngDrawableWrapper.2(this);
  
  public ApngDrawableWrapper(String paramString, Size paramSize)
  {
    this.c = paramSize;
    this.d = paramString;
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mUseApngImage = true;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.c.width;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.c.height;
    ((URLDrawable.URLDrawableOptions)localObject).mExtraInfo = new Bundle();
    if (paramString.startsWith("/")) {
      localObject = URLDrawable.getDrawable(new File(paramString), (URLDrawable.URLDrawableOptions)localObject);
    } else {
      localObject = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
    }
    this.b = ((URLDrawable)localObject);
    this.b.setCallback(this.l);
    this.b.setDownloadListener(this);
    this.b.setURLDrawableListener(this);
    this.b.setBounds(0, 0, this.c.width, this.c.height);
    int m = this.b.getStatus();
    if (m != 0)
    {
      if ((m != 1) && (m != 4))
      {
        this.g = IBitmapAnimator.AnimatorState.Loading;
        ((URLDrawable)localObject).restartDownload();
      }
      else
      {
        this.g = IBitmapAnimator.AnimatorState.Loaded;
        new Handler().post(new ApngDrawableWrapper.3(this));
      }
    }
    else {
      this.g = IBitmapAnimator.AnimatorState.Loading;
    }
    QLog.d("ApngDrawableWrapper", 1, String.format("[%d]ApngDrawableWrapper() %s %d %d status=%s/%d", new Object[] { Integer.valueOf(hashCode()), paramString, Integer.valueOf(paramSize.width), Integer.valueOf(paramSize.height), this.g, Integer.valueOf(m) }));
  }
  
  private ApngImage a()
  {
    Drawable localDrawable = this.b.getCurrDrawable();
    if (!(localDrawable instanceof ApngDrawable)) {
      return null;
    }
    return ((ApngDrawable)localDrawable).getImage();
  }
  
  public Bitmap currentFrame()
  {
    ApngImage localApngImage = a();
    if (localApngImage == null) {
      return null;
    }
    return localApngImage.getCurrentFrame();
  }
  
  public void draw(Canvas paramCanvas)
  {
    Bitmap localBitmap = currentFrame();
    if (localBitmap != null)
    {
      Rect localRect1 = new Rect(0, 0, localBitmap.getWidth(), localBitmap.getHeight());
      Rect localRect2 = new Rect(0, 0, paramCanvas.getWidth(), paramCanvas.getHeight());
      String str = ApngDrawableWrapper.ScaleRectSet.a(localRect1, localRect2, 0);
      ApngDrawableWrapper.ScaleRectSet localScaleRectSet = this.k;
      if ((localScaleRectSet == null) || (!TextUtils.equals(localScaleRectSet.c, str))) {
        this.k = ApngDrawableWrapper.ScaleRectSet.b(localRect1, localRect2, 0);
      }
      if ((QLog.isColorLevel()) && (this.j % 600 == 0)) {
        QLog.d("ApngDrawableWrapper", 2, String.format(Locale.getDefault(), "drawBitmap() %s %s -> %s (%d)", new Object[] { this.d, this.k.a.toShortString(), this.k.b.toShortString(), Integer.valueOf(0) }));
      }
      this.j += 1;
      paramCanvas.drawColor(0, PorterDuff.Mode.MULTIPLY);
      paramCanvas.drawBitmap(localBitmap, this.k.a, this.k.b, null);
    }
  }
  
  public int getHeight()
  {
    return this.c.height;
  }
  
  public IBitmapAnimator.AnimatorState getState()
  {
    return this.g;
  }
  
  public int getWidth()
  {
    return this.c.width;
  }
  
  public void load()
  {
    this.b.setVisible(true, true);
    int m = this.b.getStatus();
    if (QLog.isColorLevel()) {
      QLog.d("ApngDrawableWrapper", 2, String.format("load() %s status=%d", new Object[] { this.d, Integer.valueOf(m) }));
    }
    if ((m == 1) || (m == 4)) {
      this.g = IBitmapAnimator.AnimatorState.Loaded;
    }
    this.b.downloadImediatly();
  }
  
  public void onFileDownloadFailed(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(this.d);
      localStringBuilder.append("] ");
      QLog.d("ApngDrawableWrapper", 2, new Object[] { localStringBuilder.toString(), "onFileDownloadFailed()" });
    }
  }
  
  public void onFileDownloadStarted()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(this.d);
      localStringBuilder.append("] ");
      QLog.d("ApngDrawableWrapper", 2, new Object[] { localStringBuilder.toString(), "onFileDownloadStarted()" });
    }
  }
  
  public void onFileDownloadSucceed(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(this.d);
      localStringBuilder.append("] ");
      QLog.d("ApngDrawableWrapper", 2, new Object[] { localStringBuilder.toString(), "onFileDownloadSucceed()" });
    }
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(this.d);
      localStringBuilder.append("] ");
      QLog.d("ApngDrawableWrapper", 2, new Object[] { localStringBuilder.toString(), "onLoadCanceled() ", paramURLDrawable });
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(this.d);
      localStringBuilder.append("] ");
      QLog.d("ApngDrawableWrapper", 2, new Object[] { localStringBuilder.toString(), "onLoadFialed() ", paramURLDrawable, " ", paramThrowable });
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append("] ");
    QLog.d("ApngDrawableWrapper", 1, new Object[] { ((StringBuilder)localObject).toString(), "onLoadSuccessed() ", paramURLDrawable });
    localObject = a();
    if (localObject != null) {
      ((ApngImage)localObject).setSupportGlobalPasued(false);
    }
    this.g = IBitmapAnimator.AnimatorState.Loaded;
    localObject = this.f;
    if (localObject != null) {
      ((ILoadAnimatorCallback)localObject).onLoaded(this);
    }
    if ((paramURLDrawable.getCurrDrawable() instanceof ApngDrawable))
    {
      paramURLDrawable = (ApngDrawable)paramURLDrawable.getCurrDrawable();
      paramURLDrawable.resume();
      paramURLDrawable.setVisible(true, true);
    }
  }
  
  public void pause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApngDrawableWrapper", 2, String.format("pause() %s", new Object[] { this.d }));
    }
    ApngImage localApngImage = a();
    this.g = IBitmapAnimator.AnimatorState.Paused;
    if (localApngImage == null) {
      return;
    }
    localApngImage.pause();
  }
  
  public void play()
  {
    this.b.setVisible(true, true);
    this.b.invalidateSelf();
    ApngImage localApngImage = a();
    this.g = IBitmapAnimator.AnimatorState.Playing;
    if (localApngImage == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApngDrawableWrapper", 2, String.format("play() %s, but apngImage not ready", new Object[] { this.d }));
      }
      return;
    }
    localApngImage.replay();
    if (QLog.isColorLevel()) {
      QLog.d("ApngDrawableWrapper", 2, String.format("play() %s -> called replay", new Object[] { this.d }));
    }
  }
  
  public void setInvalidateCallback(IInvalidateCallback<Bitmap> paramIInvalidateCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApngDrawableWrapper", 2, String.format("setInvalidateCallback() %s", new Object[] { this.d }));
    }
    this.e = paramIInvalidateCallback;
  }
  
  public void setLoadResultCallback(ILoadAnimatorCallback paramILoadAnimatorCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApngDrawableWrapper", 2, String.format("setLoadResultCallback() %s", new Object[] { this.d }));
    }
    this.f = paramILoadAnimatorCallback;
  }
  
  public void stop()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApngDrawableWrapper", 2, String.format("stop() %s", new Object[] { this.d }));
    }
    this.b.setVisible(false, true);
    ApngImage localApngImage = a();
    this.g = IBitmapAnimator.AnimatorState.Paused;
    if (localApngImage == null) {
      return;
    }
    localApngImage.pause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.apng.ApngDrawableWrapper
 * JD-Core Version:    0.7.0.1
 */