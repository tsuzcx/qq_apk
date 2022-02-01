package dov.com.qq.im.capture.view;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

class CustomSnapHelper$1
  extends RecyclerView.OnScrollListener
{
  boolean jdField_a_of_type_Boolean = false;
  
  CustomSnapHelper$1(CustomSnapHelper paramCustomSnapHelper) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    if ((paramInt == 0) && (this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_DovComQqImCaptureViewCustomSnapHelper.a();
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      this.jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.view.CustomSnapHelper.1
 * JD-Core Version:    0.7.0.1
 */