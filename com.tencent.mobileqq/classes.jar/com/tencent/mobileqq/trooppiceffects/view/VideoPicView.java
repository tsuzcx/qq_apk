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
  protected SpriteVideoView a;
  protected String a;
  
  public VideoPicView(Context paramContext, int paramInt)
  {
    this(paramContext, paramInt, -1, -1);
  }
  
  public VideoPicView(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangString = TroopGiftUtil.a(paramInt1);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView = new SpriteVideoView(getContext(), true);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView.setLooping(true);
    addView(this.jdField_a_of_type_AndroidWidgetImageView, -1, -1);
    addView(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView, paramInt2, paramInt3);
  }
  
  public View a()
  {
    return this;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView.a(this.jdField_a_of_type_JavaLangString, null);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteVideoView.n();
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.trooppiceffects.view.VideoPicView
 * JD-Core Version:    0.7.0.1
 */