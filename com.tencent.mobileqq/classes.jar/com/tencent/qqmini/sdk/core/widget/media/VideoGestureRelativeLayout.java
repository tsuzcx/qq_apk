package com.tencent.qqmini.sdk.core.widget.media;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.widget.FrameLayout;
import bdke;
import bdkf;
import bdkg;

public class VideoGestureRelativeLayout
  extends FrameLayout
{
  private int jdField_a_of_type_Int = 0;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private bdkf jdField_a_of_type_Bdkf;
  private bdkg jdField_a_of_type_Bdkg;
  private boolean jdField_a_of_type_Boolean;
  private int b = 1;
  
  public VideoGestureRelativeLayout(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public VideoGestureRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_Bdkg = new bdkg(this, this);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, this.jdField_a_of_type_Bdkg);
    this.jdField_a_of_type_AndroidViewGestureDetector.setIsLongpressEnabled(false);
    setOnTouchListener(new bdke(this));
  }
  
  public void setVideoGestureListener(bdkf parambdkf)
  {
    this.jdField_a_of_type_Bdkf = parambdkf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.media.VideoGestureRelativeLayout
 * JD-Core Version:    0.7.0.1
 */