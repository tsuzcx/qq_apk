package com.tencent.mobileqq.tianshu.api;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IRedTouchTempApi
  extends QRouteApi
{
  public abstract URLDrawable getApngDrawable(Context paramContext, String paramString);
  
  public abstract Bitmap getDefaultFaceBitmap();
  
  public abstract Drawable getFaceDrawable(Context paramContext, String paramString);
  
  public abstract void onProcessAddRedPoint(View paramView);
  
  public abstract void removeLebaIconAnim(ImageView paramImageView1, ImageView paramImageView2, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3);
  
  public abstract void startLebaIconAnim(ImageView paramImageView1, ImageView paramImageView2, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3, TextView paramTextView4, boolean paramBoolean, long paramLong1, long paramLong2, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.api.IRedTouchTempApi
 * JD-Core Version:    0.7.0.1
 */