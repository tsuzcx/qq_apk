package com.tencent.qqmini.sdk.core.widget.media;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.widget.FrameLayout;
import bgti;
import bgtj;
import bgtk;

public class VideoGestureRelativeLayout
  extends FrameLayout
{
  private int jdField_a_of_type_Int = 0;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private bgtj jdField_a_of_type_Bgtj;
  private bgtk jdField_a_of_type_Bgtk;
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
    this.jdField_a_of_type_Bgtk = new bgtk(this, this);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, this.jdField_a_of_type_Bgtk);
    this.jdField_a_of_type_AndroidViewGestureDetector.setIsLongpressEnabled(false);
    setOnTouchListener(new bgti(this));
  }
  
  public void setVideoGestureListener(bgtj parambgtj)
  {
    this.jdField_a_of_type_Bgtj = parambgtj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.media.VideoGestureRelativeLayout
 * JD-Core Version:    0.7.0.1
 */