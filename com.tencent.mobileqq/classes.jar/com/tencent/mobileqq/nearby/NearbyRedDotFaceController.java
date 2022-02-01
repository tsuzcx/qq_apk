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
  protected int a;
  protected Drawable a;
  protected Handler a;
  protected ImageView a;
  protected ArrayList<String> a;
  protected int b;
  
  protected void a(String paramString)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localDrawable;
    int i = this.b;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = i;
    ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "nearby_reddot_face";
    paramString = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
    i = this.b;
    paramString.setTag(URLDrawableDecodeHandler.a(i, i));
    paramString.setDecodeHandler(URLDrawableDecodeHandler.a);
    if (this.jdField_a_of_type_JavaUtilArrayList.size() != 1)
    {
      localObject = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "alpha", new float[] { 1.0F, 0.1F });
      ((ObjectAnimator)localObject).addListener(new NearbyRedDotFaceController.1(this, paramString));
      ((ObjectAnimator)localObject).setDuration(1500L).start();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyRedDotFaceController
 * JD-Core Version:    0.7.0.1
 */