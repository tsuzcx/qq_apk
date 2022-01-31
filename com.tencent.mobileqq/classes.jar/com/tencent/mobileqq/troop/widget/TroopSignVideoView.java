package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import aycs;
import baqc;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;
import com.tencent.qphone.base.util.QLog;

public class TroopSignVideoView
  extends SpriteGLView
{
  private int jdField_a_of_type_Int;
  private aycs jdField_a_of_type_Aycs;
  private VideoSprite jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite;
  private String jdField_a_of_type_JavaLangString;
  private boolean d;
  
  public TroopSignVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite != null)
    {
      b(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SpriteGLView", 2, "SpriteGLView->stop");
    }
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite == null) || (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.c()) || (!paramString.equals(this.jdField_a_of_type_JavaLangString)))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite != null) {
        b(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite);
      }
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite = new TroopSignVideoView.SignVideoSprite(this, this, getContext(), true);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.b = true;
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.c = true;
      a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite);
    }
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.a(true);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.c(paramString);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.a(new baqc(this));
    if (QLog.isColorLevel()) {
      QLog.d("SpriteGLView", 2, "SpriteGLView->play");
    }
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite != null) {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.b();
    }
    if (QLog.isColorLevel()) {
      QLog.d("SpriteGLView", 2, "SpriteGLView->pause");
    }
  }
  
  public void m()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite != null) && (!this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.c())) {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.c();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SpriteGLView", 2, "SpriteGLView->resume");
      }
      return;
      if (this.jdField_a_of_type_JavaLangString != null) {
        a(this.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SpriteGLView", 2, "onVisibilityChanged: visibility = " + paramInt);
    }
    if (paramInt == 0) {
      m();
    }
    for (;;)
    {
      super.onVisibilityChanged(paramView, paramInt);
      return;
      if (paramInt == 4) {
        l();
      } else if (paramInt == 8) {
        n();
      }
    }
  }
  
  public void setFilePath(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void setOnPlayedListener(aycs paramaycs)
  {
    this.jdField_a_of_type_Aycs = paramaycs;
  }
  
  public void setShowCover(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopSignVideoView
 * JD-Core Version:    0.7.0.1
 */