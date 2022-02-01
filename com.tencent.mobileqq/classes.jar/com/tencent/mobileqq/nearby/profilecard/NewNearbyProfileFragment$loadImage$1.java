package com.tencent.mobileqq.nearby.profilecard;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/nearby/profilecard/NewNearbyProfileFragment$loadImage$1", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "onLoadCanceled", "", "urlDrawable", "Lcom/tencent/image/URLDrawable;", "onLoadFialed", "throwable", "", "onLoadProgressed", "i", "", "onLoadSuccessed", "qqnearby_impl_release"}, k=1, mv={1, 1, 16})
public final class NewNearbyProfileFragment$loadImage$1
  implements URLDrawable.URLDrawableListener
{
  NewNearbyProfileFragment$loadImage$1(ImageView paramImageView) {}
  
  public void onLoadCanceled(@NotNull URLDrawable paramURLDrawable)
  {
    Intrinsics.checkParameterIsNotNull(paramURLDrawable, "urlDrawable");
    QLog.i("NewNearbyProfileFragmen", 1, "onLoadCanceled");
  }
  
  public void onLoadFialed(@NotNull URLDrawable paramURLDrawable, @NotNull Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramURLDrawable, "urlDrawable");
    Intrinsics.checkParameterIsNotNull(paramThrowable, "throwable");
    if (NewNearbyProfileFragment.a(this.a)) {
      this.b.setVisibility(8);
    }
    QLog.i("NewNearbyProfileFragmen", 1, "onLoadFialed");
  }
  
  public void onLoadProgressed(@NotNull URLDrawable paramURLDrawable, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramURLDrawable, "urlDrawable");
    QLog.i("NewNearbyProfileFragmen", 1, "onLoadProgressed");
  }
  
  public void onLoadSuccessed(@NotNull URLDrawable paramURLDrawable)
  {
    Intrinsics.checkParameterIsNotNull(paramURLDrawable, "urlDrawable");
    if (NewNearbyProfileFragment.a(this.a))
    {
      this.b.setImageDrawable((Drawable)paramURLDrawable);
      this.b.setVisibility(0);
    }
    QLog.i("NewNearbyProfileFragmen", 1, "onLoadSuccessed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NewNearbyProfileFragment.loadImage.1
 * JD-Core Version:    0.7.0.1
 */