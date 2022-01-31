package com.tencent.mobileqq.videoplatform;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import bbvn;
import bbvo;
import bbvs;
import bbvy;
import com.tencent.qphone.base.util.QLog;

public class BaseVideoView
  extends FrameLayout
  implements bbvo
{
  private long jdField_a_of_type_Long;
  Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  bbvy jdField_a_of_type_Bbvy;
  private boolean jdField_a_of_type_Boolean;
  
  public BaseVideoView(Context paramContext, long paramLong, bbvs parambbvs)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Bbvy = new bbvy(paramContext, paramLong, parambbvs, this);
    d();
    e();
  }
  
  private String a()
  {
    return "[VideoPlatForm]BaseVideoView[" + b() + "]";
  }
  
  private long b()
  {
    return this.jdField_a_of_type_Long;
  }
  
  private void d()
  {
    try
    {
      if (findViewById(2131373172) != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(a(), 2, "addVideoView, videoView is exist");
        }
        removeView(findViewById(2131373172));
      }
      View localView2 = this.jdField_a_of_type_Bbvy.a();
      View localView1 = localView2;
      if (localView2 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(a(), 2, "addVideoView, videoView == null， set fake view");
        }
        localView1 = new View(this.jdField_a_of_type_AndroidContentContext);
      }
      localView1.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      localView1.setId(2131373172);
      addView(localView1, 0);
      if (QLog.isColorLevel()) {
        QLog.d(a(), 2, "addVideoView. ");
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e(a(), 1, "addVideoView error。", localThrowable);
    }
  }
  
  private void e()
  {
    try
    {
      if (findViewById(2131373170) != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(a(), 2, "addCoverImageView, imageView is exist");
        }
        removeView(findViewById(2131373170));
      }
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetImageView.setId(2131373170);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      addView(this.jdField_a_of_type_AndroidWidgetImageView, 1);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e(a(), 1, "addCoverImageView error。", localThrowable);
    }
  }
  
  private void f() {}
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(a(), 2, "setCoverVisible");
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(a(), 2, "setCoverInVisible");
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    }
  }
  
  public long a()
  {
    long l2 = -1L;
    long l1 = l2;
    try
    {
      if (this.jdField_a_of_type_Bbvy != null) {
        l1 = this.jdField_a_of_type_Bbvy.a();
      }
      if (QLog.isColorLevel()) {
        QLog.d(a(), 2, "getCurPlayingPos() curPosi = " + l1);
      }
      return l1;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        l1 = l2;
      }
    }
  }
  
  public Drawable a()
  {
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(a(), 2, "play");
    }
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Bbvy != null) {
      this.jdField_a_of_type_Bbvy.a();
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a(), 2, "onStateChange , state = " + bbvn.a(paramInt));
    }
    switch (paramInt)
    {
    }
    do
    {
      return;
      h();
      return;
      g();
      return;
      d();
    } while (!this.jdField_a_of_type_Boolean);
    a();
  }
  
  public void a(Drawable paramDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a(), 2, "showCover");
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    a(false);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a(), 2, "releasePlayer");
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Bbvy != null) {
      this.jdField_a_of_type_Bbvy.a(paramBoolean, false);
    }
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d(a(), 2, "resume , mIsPlayVideo is false , do nothing.");
      }
      return;
    }
    a();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Bbvy != null) {
      this.jdField_a_of_type_Bbvy.b();
    }
  }
  
  public void setCoverDrawable(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
    }
  }
  
  public void setID(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    f();
  }
  
  public void setVideoParam(bbvs parambbvs)
  {
    bbvs localbbvs = this.jdField_a_of_type_Bbvy.a();
    if (localbbvs == null)
    {
      this.jdField_a_of_type_Bbvy.a(parambbvs);
      return;
    }
    if (parambbvs.a(localbbvs))
    {
      if (QLog.isColorLevel()) {
        QLog.d(a(), 2, "setVideoParam, same video, do noting.");
      }
      parambbvs.c = localbbvs.c;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(a(), 2, "setVideoParam, different video, addVideoView.");
    }
    this.jdField_a_of_type_Bbvy.a(false, false);
    this.jdField_a_of_type_Bbvy = new bbvy(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Long, parambbvs, this);
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.BaseVideoView
 * JD-Core Version:    0.7.0.1
 */