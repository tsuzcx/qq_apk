package dov.com.qq.im.capture.part;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class RecyclerViewItemTouchListener
  implements RecyclerView.OnItemTouchListener
{
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private RecyclerViewItemTouchListener.ItemClickListener jdField_a_of_type_DovComQqImCapturePartRecyclerViewItemTouchListener$ItemClickListener;
  
  public boolean onInterceptTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    return this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
  }
  
  public void onRequestDisallowInterceptTouchEvent(boolean paramBoolean) {}
  
  public void onTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.part.RecyclerViewItemTouchListener
 * JD-Core Version:    0.7.0.1
 */