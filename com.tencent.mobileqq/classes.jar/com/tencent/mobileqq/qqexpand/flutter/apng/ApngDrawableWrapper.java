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
  public static IBitmapAnimatorFactory a;
  private int jdField_a_of_type_Int = 0;
  private final Bitmap jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
  private final Canvas jdField_a_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
  private final Drawable.Callback jdField_a_of_type_AndroidGraphicsDrawableDrawable$Callback = new ApngDrawableWrapper.2(this);
  private final Size jdField_a_of_type_ComPeterlmengAnimate_imageSize;
  private IBitmapAnimator.AnimatorState jdField_a_of_type_ComPeterlmengAnimate_imageSupportCommonIBitmapAnimator$AnimatorState = IBitmapAnimator.AnimatorState.NotLoad;
  private IInvalidateCallback<Bitmap> jdField_a_of_type_ComPeterlmengAnimate_imageSupportCommonIInvalidateCallback;
  private ILoadAnimatorCallback jdField_a_of_type_ComPeterlmengAnimate_imageSupportCommonILoadAnimatorCallback;
  final URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private ApngDrawableWrapper.ScaleRectSet jdField_a_of_type_ComTencentMobileqqQqexpandFlutterApngApngDrawableWrapper$ScaleRectSet = null;
  private final String jdField_a_of_type_JavaLangString;
  
  static
  {
    jdField_a_of_type_ComPeterlmengAnimate_imageSupportCommonIBitmapAnimatorFactory = new ApngDrawableWrapper.1();
  }
  
  public ApngDrawableWrapper(String paramString, Size paramSize)
  {
    this.jdField_a_of_type_ComPeterlmengAnimate_imageSize = paramSize;
    this.jdField_a_of_type_JavaLangString = paramString;
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mUseApngImage = true;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.jdField_a_of_type_ComPeterlmengAnimate_imageSize.width;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.jdField_a_of_type_ComPeterlmengAnimate_imageSize.height;
    ((URLDrawable.URLDrawableOptions)localObject).mExtraInfo = new Bundle();
    if (paramString.startsWith("/")) {
      localObject = URLDrawable.getDrawable(new File(paramString), (URLDrawable.URLDrawableOptions)localObject);
    } else {
      localObject = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject);
    this.jdField_a_of_type_ComTencentImageURLDrawable.setCallback(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable$Callback);
    this.jdField_a_of_type_ComTencentImageURLDrawable.setDownloadListener(this);
    this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(this);
    this.jdField_a_of_type_ComTencentImageURLDrawable.setBounds(0, 0, this.jdField_a_of_type_ComPeterlmengAnimate_imageSize.width, this.jdField_a_of_type_ComPeterlmengAnimate_imageSize.height);
    int i = this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus();
    if (i != 0)
    {
      if ((i != 1) && (i != 4))
      {
        this.jdField_a_of_type_ComPeterlmengAnimate_imageSupportCommonIBitmapAnimator$AnimatorState = IBitmapAnimator.AnimatorState.Loading;
        ((URLDrawable)localObject).restartDownload();
      }
      else
      {
        this.jdField_a_of_type_ComPeterlmengAnimate_imageSupportCommonIBitmapAnimator$AnimatorState = IBitmapAnimator.AnimatorState.Loaded;
        new Handler().post(new ApngDrawableWrapper.3(this));
      }
    }
    else {
      this.jdField_a_of_type_ComPeterlmengAnimate_imageSupportCommonIBitmapAnimator$AnimatorState = IBitmapAnimator.AnimatorState.Loading;
    }
    QLog.d("ApngDrawableWrapper", 1, String.format("[%d]ApngDrawableWrapper() %s %d %d status=%s/%d", new Object[] { Integer.valueOf(hashCode()), paramString, Integer.valueOf(paramSize.width), Integer.valueOf(paramSize.height), this.jdField_a_of_type_ComPeterlmengAnimate_imageSupportCommonIBitmapAnimator$AnimatorState, Integer.valueOf(i) }));
  }
  
  private ApngImage a()
  {
    Drawable localDrawable = this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable();
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
      ApngDrawableWrapper.ScaleRectSet localScaleRectSet = this.jdField_a_of_type_ComTencentMobileqqQqexpandFlutterApngApngDrawableWrapper$ScaleRectSet;
      if ((localScaleRectSet == null) || (!TextUtils.equals(localScaleRectSet.jdField_a_of_type_JavaLangString, str))) {
        this.jdField_a_of_type_ComTencentMobileqqQqexpandFlutterApngApngDrawableWrapper$ScaleRectSet = ApngDrawableWrapper.ScaleRectSet.a(localRect1, localRect2, 0);
      }
      if ((QLog.isColorLevel()) && (this.jdField_a_of_type_Int % 600 == 0)) {
        QLog.d("ApngDrawableWrapper", 2, String.format(Locale.getDefault(), "drawBitmap() %s %s -> %s (%d)", new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqQqexpandFlutterApngApngDrawableWrapper$ScaleRectSet.jdField_a_of_type_AndroidGraphicsRect.toShortString(), this.jdField_a_of_type_ComTencentMobileqqQqexpandFlutterApngApngDrawableWrapper$ScaleRectSet.b.toShortString(), Integer.valueOf(0) }));
      }
      this.jdField_a_of_type_Int += 1;
      paramCanvas.drawColor(0, PorterDuff.Mode.MULTIPLY);
      paramCanvas.drawBitmap(localBitmap, this.jdField_a_of_type_ComTencentMobileqqQqexpandFlutterApngApngDrawableWrapper$ScaleRectSet.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_ComTencentMobileqqQqexpandFlutterApngApngDrawableWrapper$ScaleRectSet.b, null);
    }
  }
  
  public int getHeight()
  {
    return this.jdField_a_of_type_ComPeterlmengAnimate_imageSize.height;
  }
  
  public IBitmapAnimator.AnimatorState getState()
  {
    return this.jdField_a_of_type_ComPeterlmengAnimate_imageSupportCommonIBitmapAnimator$AnimatorState;
  }
  
  public int getWidth()
  {
    return this.jdField_a_of_type_ComPeterlmengAnimate_imageSize.width;
  }
  
  public void load()
  {
    this.jdField_a_of_type_ComTencentImageURLDrawable.setVisible(true, true);
    int i = this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus();
    if (QLog.isColorLevel()) {
      QLog.d("ApngDrawableWrapper", 2, String.format("load() %s status=%d", new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(i) }));
    }
    if ((i == 1) || (i == 4)) {
      this.jdField_a_of_type_ComPeterlmengAnimate_imageSupportCommonIBitmapAnimator$AnimatorState = IBitmapAnimator.AnimatorState.Loaded;
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable.downloadImediatly();
  }
  
  public void onFileDownloadFailed(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
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
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
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
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
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
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
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
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append("] ");
      QLog.d("ApngDrawableWrapper", 2, new Object[] { localStringBuilder.toString(), "onLoadFialed() ", paramURLDrawable, " ", paramThrowable });
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append("] ");
    QLog.d("ApngDrawableWrapper", 1, new Object[] { ((StringBuilder)localObject).toString(), "onLoadSuccessed() ", paramURLDrawable });
    localObject = a();
    if (localObject != null) {
      ((ApngImage)localObject).setSupportGlobalPasued(false);
    }
    this.jdField_a_of_type_ComPeterlmengAnimate_imageSupportCommonIBitmapAnimator$AnimatorState = IBitmapAnimator.AnimatorState.Loaded;
    localObject = this.jdField_a_of_type_ComPeterlmengAnimate_imageSupportCommonILoadAnimatorCallback;
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
      QLog.d("ApngDrawableWrapper", 2, String.format("pause() %s", new Object[] { this.jdField_a_of_type_JavaLangString }));
    }
    ApngImage localApngImage = a();
    this.jdField_a_of_type_ComPeterlmengAnimate_imageSupportCommonIBitmapAnimator$AnimatorState = IBitmapAnimator.AnimatorState.Paused;
    if (localApngImage == null) {
      return;
    }
    localApngImage.pause();
  }
  
  public void play()
  {
    this.jdField_a_of_type_ComTencentImageURLDrawable.setVisible(true, true);
    this.jdField_a_of_type_ComTencentImageURLDrawable.invalidateSelf();
    ApngImage localApngImage = a();
    this.jdField_a_of_type_ComPeterlmengAnimate_imageSupportCommonIBitmapAnimator$AnimatorState = IBitmapAnimator.AnimatorState.Playing;
    if (localApngImage == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApngDrawableWrapper", 2, String.format("play() %s, but apngImage not ready", new Object[] { this.jdField_a_of_type_JavaLangString }));
      }
      return;
    }
    localApngImage.replay();
    if (QLog.isColorLevel()) {
      QLog.d("ApngDrawableWrapper", 2, String.format("play() %s -> called replay", new Object[] { this.jdField_a_of_type_JavaLangString }));
    }
  }
  
  public void setInvalidateCallback(IInvalidateCallback<Bitmap> paramIInvalidateCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApngDrawableWrapper", 2, String.format("setInvalidateCallback() %s", new Object[] { this.jdField_a_of_type_JavaLangString }));
    }
    this.jdField_a_of_type_ComPeterlmengAnimate_imageSupportCommonIInvalidateCallback = paramIInvalidateCallback;
  }
  
  public void setLoadResultCallback(ILoadAnimatorCallback paramILoadAnimatorCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApngDrawableWrapper", 2, String.format("setLoadResultCallback() %s", new Object[] { this.jdField_a_of_type_JavaLangString }));
    }
    this.jdField_a_of_type_ComPeterlmengAnimate_imageSupportCommonILoadAnimatorCallback = paramILoadAnimatorCallback;
  }
  
  public void stop()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApngDrawableWrapper", 2, String.format("stop() %s", new Object[] { this.jdField_a_of_type_JavaLangString }));
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable.setVisible(false, true);
    ApngImage localApngImage = a();
    this.jdField_a_of_type_ComPeterlmengAnimate_imageSupportCommonIBitmapAnimator$AnimatorState = IBitmapAnimator.AnimatorState.Paused;
    if (localApngImage == null) {
      return;
    }
    localApngImage.pause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.apng.ApngDrawableWrapper
 * JD-Core Version:    0.7.0.1
 */