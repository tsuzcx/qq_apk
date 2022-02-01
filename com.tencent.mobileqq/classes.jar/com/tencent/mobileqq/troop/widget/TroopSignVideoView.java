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
  private String a;
  private VideoSprite b;
  private int c = 0;
  private VideoSprite.OnOnPlayedListener d;
  private boolean e = false;
  
  public TroopSignVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    VideoSprite localVideoSprite = this.b;
    if (localVideoSprite != null)
    {
      b(localVideoSprite);
      this.b = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SpriteGLView", 2, "SpriteGLView->stop");
    }
  }
  
  public void a(String paramString)
  {
    VideoSprite localVideoSprite = this.b;
    if ((localVideoSprite == null) || (localVideoSprite.s()) || (!paramString.equals(this.a)))
    {
      localVideoSprite = this.b;
      if (localVideoSprite != null) {
        b(localVideoSprite);
      }
      this.a = paramString;
      this.b = new TroopSignVideoView.SignVideoSprite(this, this, getContext(), true);
      localVideoSprite = this.b;
      localVideoSprite.s = true;
      localVideoSprite.t = true;
      a(localVideoSprite);
    }
    this.b.a(true);
    this.b.c(paramString);
    this.b.a(new TroopSignVideoView.1(this));
    if (QLog.isColorLevel()) {
      QLog.d("SpriteGLView", 2, "SpriteGLView->play");
    }
  }
  
  public void m()
  {
    VideoSprite localVideoSprite = this.b;
    if (localVideoSprite != null) {
      localVideoSprite.g();
    }
    if (QLog.isColorLevel()) {
      QLog.d("SpriteGLView", 2, "SpriteGLView->pause");
    }
  }
  
  public void n()
  {
    Object localObject = this.b;
    if ((localObject != null) && (!((VideoSprite)localObject).s()))
    {
      this.b.h();
    }
    else
    {
      localObject = this.a;
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
      n();
    } else if (paramInt == 4) {
      m();
    } else if (paramInt == 8) {
      o();
    }
    super.onVisibilityChanged(paramView, paramInt);
  }
  
  public void setFilePath(String paramString)
  {
    this.a = paramString;
  }
  
  public void setOnPlayedListener(VideoSprite.OnOnPlayedListener paramOnOnPlayedListener)
  {
    this.d = paramOnOnPlayedListener;
  }
  
  public void setShowCover(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopSignVideoView
 * JD-Core Version:    0.7.0.1
 */