package com.tencent.mobileqq.wink.pick.circle.widget;

import android.graphics.Matrix;
import android.view.ViewParent;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;

class PhotoViewAttacher$1
  implements OnGestureListener
{
  PhotoViewAttacher$1(PhotoViewAttacher paramPhotoViewAttacher) {}
  
  public void a(float paramFloat1, float paramFloat2)
  {
    if (PhotoViewAttacher.a(this.a).a()) {
      return;
    }
    PhotoViewAttacher.b(this.a).postTranslate(paramFloat1, paramFloat2);
    PhotoViewAttacher.c(this.a);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onDrag dx:");
    ((StringBuilder)localObject).append(paramFloat1);
    ((StringBuilder)localObject).append(" dy:");
    ((StringBuilder)localObject).append(paramFloat2);
    ((StringBuilder)localObject).append(" mAllowParentInterceptOnEdge:");
    ((StringBuilder)localObject).append(PhotoViewAttacher.d(this.a));
    ((StringBuilder)localObject).append(" mBlockParentIntercept:");
    ((StringBuilder)localObject).append(PhotoViewAttacher.e(this.a));
    ((StringBuilder)localObject).append(" mHorizontalScrollEdge:");
    ((StringBuilder)localObject).append(PhotoViewAttacher.f(this.a));
    ((StringBuilder)localObject).append(" mVerticalScrollEdge:");
    ((StringBuilder)localObject).append(PhotoViewAttacher.g(this.a));
    ((StringBuilder)localObject).append(" imageviewHashCode:");
    ((StringBuilder)localObject).append(PhotoViewAttacher.h(this.a).hashCode());
    QLog.d("PhotoViewAttacher", 4, ((StringBuilder)localObject).toString());
    localObject = PhotoViewAttacher.h(this.a).getParent();
    if (localObject != null) {
      ((ViewParent)localObject).requestDisallowInterceptTouchEvent(this.a.a(paramFloat1, paramFloat2));
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onScale scalefactor:");
    localStringBuilder.append(paramFloat1);
    localStringBuilder.append(" curScale:");
    localStringBuilder.append(this.a.b());
    localStringBuilder.append(" focusX:");
    localStringBuilder.append(paramFloat2);
    localStringBuilder.append(" focusY:");
    localStringBuilder.append(paramFloat3);
    QLog.d("PhotoViewAttacher", 4, localStringBuilder.toString());
    float f = this.a.b();
    PhotoViewAttacher.a(this.a, paramFloat2);
    PhotoViewAttacher.b(this.a, paramFloat3);
    if (((f > PhotoViewAttacher.f()) && (paramFloat1 > 1.0F)) || ((f < PhotoViewAttacher.g()) && (paramFloat1 < 1.0F))) {
      return;
    }
    PhotoViewAttacher.b(this.a).postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
    PhotoViewAttacher.c(this.a);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onFling startX:");
    ((StringBuilder)localObject).append(paramFloat1);
    ((StringBuilder)localObject).append(" startY:");
    ((StringBuilder)localObject).append(paramFloat2);
    ((StringBuilder)localObject).append(" getScale:");
    ((StringBuilder)localObject).append(this.a.b());
    ((StringBuilder)localObject).append(" velocityX:");
    ((StringBuilder)localObject).append(paramFloat3);
    ((StringBuilder)localObject).append(" velocityY:");
    ((StringBuilder)localObject).append(paramFloat4);
    QLog.d("PhotoViewAttacher", 2, ((StringBuilder)localObject).toString());
    if (this.a.b() == 1.0F) {
      return;
    }
    localObject = this.a;
    PhotoViewAttacher.a((PhotoViewAttacher)localObject, new PhotoViewAttacher.FlingRunnable((PhotoViewAttacher)localObject, PhotoViewAttacher.h((PhotoViewAttacher)localObject).getContext()));
    localObject = PhotoViewAttacher.i(this.a);
    PhotoViewAttacher localPhotoViewAttacher = this.a;
    int i = PhotoViewAttacher.a(localPhotoViewAttacher, PhotoViewAttacher.h(localPhotoViewAttacher));
    localPhotoViewAttacher = this.a;
    ((PhotoViewAttacher.FlingRunnable)localObject).a(i, PhotoViewAttacher.b(localPhotoViewAttacher, PhotoViewAttacher.h(localPhotoViewAttacher)), (int)paramFloat3, (int)paramFloat4);
    PhotoViewAttacher.h(this.a).post(PhotoViewAttacher.i(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.widget.PhotoViewAttacher.1
 * JD-Core Version:    0.7.0.1
 */