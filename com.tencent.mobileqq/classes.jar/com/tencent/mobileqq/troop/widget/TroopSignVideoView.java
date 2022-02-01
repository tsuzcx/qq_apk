package com.tencent.mobileqq.troop.widget;

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
  private int jdField_a_of_type_Int = 0;
  private VideoSprite.OnOnPlayedListener jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite$OnOnPlayedListener;
  private VideoSprite jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite;
  private String jdField_a_of_type_JavaLangString;
  private boolean d = false;
  
  public TroopSignVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    VideoSprite localVideoSprite = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite;
    if (localVideoSprite != null)
    {
      b(localVideoSprite);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SpriteGLView", 2, "SpriteGLView->stop");
    }
  }
  
  public void a(String paramString)
  {
    VideoSprite localVideoSprite = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite;
    if ((localVideoSprite == null) || (localVideoSprite.c()) || (!paramString.equals(this.jdField_a_of_type_JavaLangString)))
    {
      localVideoSprite = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite;
      if (localVideoSprite != null) {
        b(localVideoSprite);
      }
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite = new TroopSignVideoView.SignVideoSprite(this, this, getContext(), true);
      localVideoSprite = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite;
      localVideoSprite.b = true;
      localVideoSprite.c = true;
      a(localVideoSprite);
    }
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.a(true);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.c(paramString);
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.a(new TroopSignVideoView.1(this));
    if (QLog.isColorLevel()) {
      QLog.d("SpriteGLView", 2, "SpriteGLView->play");
    }
  }
  
  public void l()
  {
    VideoSprite localVideoSprite = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite;
    if (localVideoSprite != null) {
      localVideoSprite.b();
    }
    if (QLog.isColorLevel()) {
      QLog.d("SpriteGLView", 2, "SpriteGLView->pause");
    }
  }
  
  public void m()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite;
    if ((localObject != null) && (!((VideoSprite)localObject).c()))
    {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlVideoSprite.c();
    }
    else
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      if (localObject != null) {
        a((String)localObject);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("SpriteGLView", 2, "SpriteGLView->resume");
    }
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onVisibilityChanged: visibility = ");
      localStringBuilder.append(paramInt);
      QLog.d("SpriteGLView", 2, localStringBuilder.toString());
    }
    if (paramInt == 0) {
      m();
    } else if (paramInt == 4) {
      l();
    } else if (paramInt == 8) {
      n();
    }
    super.onVisibilityChanged(paramView, paramInt);
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
    this.d = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopSignVideoView
 * JD-Core Version:    0.7.0.1
 */