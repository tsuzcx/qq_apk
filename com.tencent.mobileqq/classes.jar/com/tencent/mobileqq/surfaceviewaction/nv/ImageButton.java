package com.tencent.mobileqq.surfaceviewaction.nv;

import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.surfaceviewaction.IImageButton;
import com.tencent.mobileqq.widget.presseffect.PressEffectImageView;

public class ImageButton
  extends Sprite
  implements IImageButton
{
  protected String s;
  
  public ImageButton(SpriteNativeView paramSpriteNativeView, String paramString)
  {
    super(paramSpriteNativeView);
    this.s = paramString;
  }
  
  public String a()
  {
    return this.s;
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.v.setOnClickListener(paramOnClickListener);
  }
  
  protected ImageView dt_()
  {
    return new PressEffectImageView(this.t.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.nv.ImageButton
 * JD-Core Version:    0.7.0.1
 */