package com.tencent.mobileqq.filemanager.fileviewer.viewer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

public class SimpleFileViewer$GestureRelativeLayout
  extends RelativeLayout
{
  private GestureDetector b = new GestureDetector(paramContext, new SimpleFileViewer.GestureRelativeLayout.InnerGestureListener(this, null));
  
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
    GestureDetector localGestureDetector = this.b;
    if (localGestureDetector != null) {
      localGestureDetector.onTouchEvent(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer.GestureRelativeLayout
 * JD-Core Version:    0.7.0.1
 */