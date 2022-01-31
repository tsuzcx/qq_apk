package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.VideoDrawable;
import com.tencent.image.VideoDrawable.OnAudioPlayOnceListener;
import com.tencent.qphone.base.util.QLog;

public class CircleVideoDrawableView
  extends CircleBubbleImageView
  implements VideoDrawable.OnAudioPlayOnceListener
{
  public URLDrawable a;
  CircleVideoDrawableView.VideoListener a;
  public String a;
  
  public CircleVideoDrawableView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void onFinish()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessPTVActivity", 2, " onFinish ");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetCircleVideoDrawableView$VideoListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleVideoDrawableView$VideoListener.b();
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (paramURLDrawable == this.jdField_a_of_type_ComTencentImageURLDrawable)
    {
      setURLDrawable(paramURLDrawable);
      return;
    }
    super.onLoadFialed(paramURLDrawable, paramThrowable);
  }
  
  @TargetApi(11)
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable == this.jdField_a_of_type_ComTencentImageURLDrawable) {
      setURLDrawable(paramURLDrawable);
    }
    super.onLoadSuccessed(paramURLDrawable);
    paramURLDrawable = this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable();
    if ((paramURLDrawable != null) && ((paramURLDrawable instanceof VideoDrawable)))
    {
      paramURLDrawable = (VideoDrawable)paramURLDrawable;
      paramURLDrawable.resetAndPlayAudioOnce();
      paramURLDrawable.setOnAudioPlayOnceListener(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetCircleVideoDrawableView$VideoListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleVideoDrawableView$VideoListener.a();
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return;
    }
    super.setImageDrawable(paramDrawable);
  }
  
  public void setURLDrawable(URLDrawable paramURLDrawable)
  {
    if (this.jdField_a_of_type_ComTencentImageURLDrawable != null)
    {
      this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(null);
      Object localObject = this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable();
      if ((localObject != null) && ((localObject instanceof VideoDrawable)))
      {
        localObject = (VideoDrawable)localObject;
        ((VideoDrawable)localObject).stopAudio();
        ((VideoDrawable)localObject).setOnAudioPlayOnceListener(null);
      }
    }
    paramURLDrawable.setURLDrawableListener(this);
    setImageDrawable(paramURLDrawable);
    this.jdField_a_of_type_ComTencentImageURLDrawable = paramURLDrawable;
    paramURLDrawable = this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable();
    if ((paramURLDrawable != null) && ((paramURLDrawable instanceof VideoDrawable))) {
      ((VideoDrawable)paramURLDrawable).setOnAudioPlayOnceListener(this);
    }
  }
  
  public void setVideoListener(CircleVideoDrawableView.VideoListener paramVideoListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleVideoDrawableView$VideoListener = paramVideoListener;
  }
  
  public void setVideoPath(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CircleVideoDrawableView
 * JD-Core Version:    0.7.0.1
 */