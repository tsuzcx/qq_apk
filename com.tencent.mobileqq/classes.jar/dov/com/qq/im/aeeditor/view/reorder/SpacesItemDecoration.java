package dov.com.qq.im.aeeditor.view.reorder;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

public class SpacesItemDecoration
  extends RecyclerView.ItemDecoration
{
  private int a;
  
  public SpacesItemDecoration(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    paramRect.left = this.a;
    int i = 0;
    if (paramRecyclerView.getAdapter() != null) {
      i = paramRecyclerView.getAdapter().getItemCount();
    }
    if ((i != 0) && (paramRecyclerView.getChildLayoutPosition(paramView) == i - 1)) {
      paramRect.right = this.a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.view.reorder.SpacesItemDecoration
 * JD-Core Version:    0.7.0.1
 */