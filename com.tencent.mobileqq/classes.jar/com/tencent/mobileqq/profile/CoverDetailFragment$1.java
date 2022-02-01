package com.tencent.mobileqq.profile;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;

class CoverDetailFragment$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  CoverDetailFragment$1(CoverDetailFragment paramCoverDetailFragment) {}
  
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      CoverDetailFragment.a(this.a).getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
    for (;;)
    {
      Object localObject = this.a.getActivity().getResources().getDrawable(2130851250);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = CoverDetailFragment.a(this.a).getWidth();
      localURLDrawableOptions.mRequestHeight = CoverDetailFragment.a(this.a).getHeight();
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
      localObject = URLDrawable.getDrawable(CoverDetailFragment.a(this.a).d, localURLDrawableOptions);
      ((URLDrawable)localObject).setURLDrawableListener(CoverDetailFragment.a(this.a));
      CoverDetailFragment.a(this.a).setImageDrawable((Drawable)localObject);
      CoverDetailFragment.b(this.a).setImageDrawable(this.a.a((Drawable)localObject));
      return;
      CoverDetailFragment.a(this.a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.CoverDetailFragment.1
 * JD-Core Version:    0.7.0.1
 */