package com.tencent.mobileqq.nearby;

import android.animation.ObjectAnimator;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import java.util.ArrayList;

public class NearbyRedDotFaceController
{
  protected Handler a;
  protected ImageView b;
  protected ArrayList<String> c;
  protected int d;
  protected int e;
  protected Drawable f;
  
  protected void a(String paramString)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    Drawable localDrawable = this.f;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localDrawable;
    int i = this.e;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = i;
    ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "nearby_reddot_face";
    paramString = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
    i = this.e;
    paramString.setTag(URLDrawableDecodeHandler.a(i, i));
    paramString.setDecodeHandler(URLDrawableDecodeHandler.b);
    if (this.c.size() != 1)
    {
      localObject = ObjectAnimator.ofFloat(this.b, "alpha", new float[] { 1.0F, 0.1F });
      ((ObjectAnimator)localObject).addListener(new NearbyRedDotFaceController.1(this, paramString));
      ((ObjectAnimator)localObject).setDuration(1500L).start();
      return;
    }
    this.b.setImageDrawable(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyRedDotFaceController
 * JD-Core Version:    0.7.0.1
 */