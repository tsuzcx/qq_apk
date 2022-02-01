package com.tencent.mobileqq.trooppiceffects.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class NormalPicView
  extends ImageView
  implements IPicView
{
  public NormalPicView(Context paramContext)
  {
    super(paramContext);
    setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
  
  public void a() {}
  
  public void b() {}
  
  public View getView()
  {
    return this;
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    setImageBitmap(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.trooppiceffects.view.NormalPicView
 * JD-Core Version:    0.7.0.1
 */