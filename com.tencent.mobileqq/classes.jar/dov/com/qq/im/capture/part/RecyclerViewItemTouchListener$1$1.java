package dov.com.qq.im.capture.part;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class RecyclerViewItemTouchListener$1$1
  implements View.OnClickListener
{
  RecyclerViewItemTouchListener$1$1(RecyclerViewItemTouchListener.1 param1, View paramView) {}
  
  public void onClick(View paramView)
  {
    RecyclerViewItemTouchListener.a(this.jdField_a_of_type_DovComQqImCapturePartRecyclerViewItemTouchListener$1.a).a(this.jdField_a_of_type_AndroidViewView, RecyclerViewItemTouchListener.a(this.jdField_a_of_type_DovComQqImCapturePartRecyclerViewItemTouchListener$1.a).getChildLayoutPosition(this.jdField_a_of_type_AndroidViewView));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.part.RecyclerViewItemTouchListener.1.1
 * JD-Core Version:    0.7.0.1
 */