package dov.com.qq.im.ae.camera.ui.panel;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

class AEGridView$SpacingItemDecoration
  extends RecyclerView.ItemDecoration
{
  private int jdField_a_of_type_Int;
  private int b;
  
  public AEGridView$SpacingItemDecoration(AEGridView paramAEGridView, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    paramRect.top = this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEGridView.SpacingItemDecoration
 * JD-Core Version:    0.7.0.1
 */