package dov.com.qq.im.aeeditor.module.filter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView.SmoothScroller;
import dov.com.qq.im.ae.util.AEQLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class AdapterUtil$scrollToPositionAndLayoutCenter$1
  implements Runnable
{
  AdapterUtil$scrollToPositionAndLayoutCenter$1(LinearSmoothScroller paramLinearSmoothScroller, int paramInt, LinearLayoutManager paramLinearLayoutManager) {}
  
  public final void run()
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearSmoothScroller.setTargetPosition(this.jdField_a_of_type_Int);
    if (!this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.isSmoothScrolling())
    {
      AEQLog.d("shiweizhang", "[startSmoothScroll] index is " + this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.startSmoothScroll((RecyclerView.SmoothScroller)this.jdField_a_of_type_AndroidSupportV7WidgetLinearSmoothScroller);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.filter.AdapterUtil.scrollToPositionAndLayoutCenter.1
 * JD-Core Version:    0.7.0.1
 */