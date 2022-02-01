package com.tencent.mobileqq.filebrowser.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

public class DocFileBrowserView$GestureRelativeLayout
  extends RelativeLayout
{
  private final GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  
  public DocFileBrowserView$GestureRelativeLayout(DocFileBrowserView paramDocFileBrowserView, Context paramContext)
  {
    this(paramDocFileBrowserView, paramContext, null);
  }
  
  public DocFileBrowserView$GestureRelativeLayout(DocFileBrowserView paramDocFileBrowserView, Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, new DocFileBrowserView.GestureRelativeLayout.1(this, paramDocFileBrowserView));
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    GestureDetector localGestureDetector = this.jdField_a_of_type_AndroidViewGestureDetector;
    if (localGestureDetector != null) {
      localGestureDetector.onTouchEvent(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.view.DocFileBrowserView.GestureRelativeLayout
 * JD-Core Version:    0.7.0.1
 */