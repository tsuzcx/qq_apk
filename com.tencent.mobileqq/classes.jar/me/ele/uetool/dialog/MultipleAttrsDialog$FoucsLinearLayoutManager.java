package me.ele.uetool.dialog;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

class MultipleAttrsDialog$FoucsLinearLayoutManager
  extends LinearLayoutManager
{
  public MultipleAttrsDialog$FoucsLinearLayoutManager(MultipleAttrsDialog paramMultipleAttrsDialog, Context paramContext)
  {
    super(paramContext);
  }
  
  public MultipleAttrsDialog$FoucsLinearLayoutManager(MultipleAttrsDialog paramMultipleAttrsDialog, Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramInt, paramBoolean);
  }
  
  public boolean requestChildRectangleOnScreen(RecyclerView paramRecyclerView, View paramView, Rect paramRect, boolean paramBoolean)
  {
    return false;
  }
  
  public boolean requestChildRectangleOnScreen(RecyclerView paramRecyclerView, View paramView, Rect paramRect, boolean paramBoolean1, boolean paramBoolean2)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     me.ele.uetool.dialog.MultipleAttrsDialog.FoucsLinearLayoutManager
 * JD-Core Version:    0.7.0.1
 */