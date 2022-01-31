package com.tencent.mobileqq.troop.widget;

import ajgg;
import ajgh;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite;
import com.tencent.mobileqq.surfaceviewaction.gl.VideoSprite.OnOnPlayedListener;
import com.tencent.qphone.base.util.QLog;

public class TroopSignVideoView
  extends SpriteGLView
{
  private int jdField_a_of_type_Int;
  private VideoSprite.OnOnPlayedListener jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite$OnOnPlayedListener;
  private VideoSprite jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite;
  private String jdField_a_of_type_JavaLangString;
  private boolean c;
  
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
    if ((this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite == null) || (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.a()) || (!paramString.equals(this.jdField_a_of_type_JavaLangString)))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite != null) {
        b(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite);
      }
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite = new ajgh(this, this, getContext(), true);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.a = true;
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.c = true;
      a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite);
    }
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.a(true);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.b(paramString);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.a(new ajgg(this));
    if (QLog.isColorLevel()) {
      QLog.d("SpriteGLView", 2, "SpriteGLView->play");
    }
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite != null) {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.d();
    }
    if (QLog.isColorLevel()) {
      QLog.d("SpriteGLView", 2, "SpriteGLView->pause");
    }
  }
  
  public void m()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite != null) && (!this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.a())) {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.e();
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
  
  public void setOnPlayedListener(VideoSprite.OnOnPlayedListener paramOnOnPlayedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite$OnOnPlayedListener = paramOnOnPlayedListener;
  }
  
  public void setShowCover(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopSignVideoView
 * JD-Core Version:    0.7.0.1
 */