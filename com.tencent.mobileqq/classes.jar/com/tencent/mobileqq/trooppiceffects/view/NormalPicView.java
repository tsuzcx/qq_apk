package com.tencent.mobileqq.trooppiceffects.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import bcxg;

public class NormalPicView
  extends ImageView
  implements bcxg
{
  public NormalPicView(Context paramContext)
  {
    super(paramContext);
    setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
  
  public View a()
  {
    return this;
  }
  
  public void a() {}
  
  public void b() {}
  
  public void setBitmap(Bitmap paramBitmap)
  {
    setImageBitmap(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.trooppiceffects.view.NormalPicView
 * JD-Core Version:    0.7.0.1
 */