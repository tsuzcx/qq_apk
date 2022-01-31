package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import aozc;

public class SimpleFileViewer$GestureRelativeLayout
  extends RelativeLayout
{
  private GestureDetector a;
  
  public SimpleFileViewer$GestureRelativeLayout(SimpleFileViewer paramSimpleFileViewer, Context paramContext)
  {
    this(paramSimpleFileViewer, paramContext, null);
  }
  
  public SimpleFileViewer$GestureRelativeLayout(SimpleFileViewer paramSimpleFileViewer, Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, new aozc(this, null));
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidViewGestureDetector != null) {
      this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer.GestureRelativeLayout
 * JD-Core Version:    0.7.0.1
 */