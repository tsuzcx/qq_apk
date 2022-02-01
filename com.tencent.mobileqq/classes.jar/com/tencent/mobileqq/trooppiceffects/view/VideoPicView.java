package com.tencent.mobileqq.trooppiceffects.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;

public class VideoPicView
  extends FrameLayout
  implements IPicView
{
  protected ImageView a;
  protected SpriteVideoView b;
  protected String c;
  
  public VideoPicView(Context paramContext, int paramInt)
  {
    this(paramContext, paramInt, -1, -1);
  }
  
  public VideoPicView(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext);
    this.c = TroopGiftUtil.a(paramInt1);
    this.a = new ImageView(getContext());
    this.b = new SpriteVideoView(getContext(), true);
    this.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.b.setLooping(true);
    addView(this.a, -1, -1);
    addView(this.b, paramInt2, paramInt3);
  }
  
  public void a()
  {
    this.b.a(this.c, null);
  }
  
  public void b()
  {
    this.b.o();
  }
  
  public View getView()
  {
    return this;
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    this.a.setImageBitmap(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.trooppiceffects.view.VideoPicView
 * JD-Core Version:    0.7.0.1
 */