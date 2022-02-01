package com.tencent.mobileqq.hotchat.ui;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;

public class PayLikeFloatViewBuilder$AnimationView
  extends TextView
{
  protected BaseFloatViewBuilder a;
  protected QQAppInterface b;
  protected AnimationDrawable c;
  
  public PayLikeFloatViewBuilder$AnimationView(Context paramContext, QQAppInterface paramQQAppInterface, BaseFloatViewBuilder paramBaseFloatViewBuilder)
  {
    super(paramContext);
    super.setGravity(17);
    this.b = paramQQAppInterface;
    this.a = paramBaseFloatViewBuilder;
    if (super.getVisibility() == 0) {
      setVisibility(0);
    }
  }
  
  public void a()
  {
    super.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    Object localObject = this.c;
    if (localObject != null)
    {
      ((AnimationDrawable)localObject).stop();
      int i = 0;
      while (i < this.c.getNumberOfFrames())
      {
        localObject = this.c.getFrame(i);
        if (localObject != null) {
          ((Drawable)localObject).setCallback(null);
        }
        i += 1;
      }
      this.c.setCallback(null);
      this.c = null;
    }
  }
  
  public void b()
  {
    Object localObject = this.c;
    if ((localObject == null) || (((AnimationDrawable)localObject).getNumberOfFrames() != 20))
    {
      this.c = new AnimationDrawable();
      localObject = this.a.a(this.b);
      if (localObject == null) {
        return;
      }
      int i = 0;
      while (i < 20)
      {
        this.c.addFrame(localObject[i], 50);
        i += 1;
      }
      this.c.setOneShot(false);
      super.setCompoundDrawablesWithIntrinsicBounds(null, this.c, null, null);
    }
    this.c.start();
  }
  
  public void setVisibility(int paramInt)
  {
    if (super.getVisibility() != paramInt) {
      super.setVisibility(paramInt);
    }
    if (paramInt == 0)
    {
      b();
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.ui.PayLikeFloatViewBuilder.AnimationView
 * JD-Core Version:    0.7.0.1
 */