package com.tencent.mobileqq.leba.mgr.table;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

public class LebaTableMgrFragment$MyItemDecoration
  extends RecyclerView.ItemDecoration
{
  int jdField_a_of_type_Int = ViewUtils.a(1.0F);
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  LebaTableMgrAdpter jdField_a_of_type_ComTencentMobileqqLebaMgrTableLebaTableMgrAdpter;
  
  public LebaTableMgrFragment$MyItemDecoration(Context paramContext, LebaTableMgrAdpter paramLebaTableMgrAdpter, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqLebaMgrTableLebaTableMgrAdpter = paramLebaTableMgrAdpter;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramContext.getResources().getColor(2131165764));
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramContext.getResources().getColor(2131165763));
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    super.getItemOffsets(paramRect, paramView, paramRecyclerView, paramState);
    if (this.jdField_a_of_type_ComTencentMobileqqLebaMgrTableLebaTableMgrAdpter == null)
    {
      QLog.i("LebaTableMgrFragment", 1, "MyItemDecoration getItemOffsets mAdapter == null");
      return;
    }
    if (paramRecyclerView.getChildAdapterPosition(paramView) < 0) {
      return;
    }
    int i = this.jdField_a_of_type_Int;
    paramRect.bottom = i;
    paramRect.right = i;
  }
  
  public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    super.onDraw(paramCanvas, paramRecyclerView, paramState);
    int j = paramRecyclerView.getChildCount();
    int i = 0;
    while (i < j)
    {
      paramState = paramRecyclerView.getChildAt(i);
      Object localObject = paramState.getTag(2131369919);
      if ((localObject != null) && ((localObject instanceof Integer)) && (((Integer)localObject).intValue() == 2)) {
        paramCanvas.drawRect(paramState.getLeft(), paramState.getTop(), paramState.getRight(), paramState.getBottom(), this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.mgr.table.LebaTableMgrFragment.MyItemDecoration
 * JD-Core Version:    0.7.0.1
 */