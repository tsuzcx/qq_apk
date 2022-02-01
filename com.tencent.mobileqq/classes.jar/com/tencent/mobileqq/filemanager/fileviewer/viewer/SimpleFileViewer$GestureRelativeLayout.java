package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

public class SimpleFileViewer$GestureRelativeLayout
  extends RelativeLayout
{
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, new SimpleFileViewer.GestureRelativeLayout.InnerGestureListener(this, null));
  
  public SimpleFileViewer$GestureRelativeLayout(SimpleFileViewer paramSimpleFileViewer, Context paramContext)
  {
    this(paramSimpleFileViewer, paramContext, null);
  }
  
  public SimpleFileViewer$GestureRelativeLayout(SimpleFileViewer paramSimpleFileViewer, Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidViewGestureDetector != null) {
      this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer.GestureRelativeLayout
 * JD-Core Version:    0.7.0.1
 */