package com.tencent.mobileqq.troop.widget;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.qphone.base.util.QLog;

class AddedRobotView$2
  extends RecyclerView.OnScrollListener
{
  AddedRobotView$2(AddedRobotView paramAddedRobotView) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    paramRecyclerView = new StringBuilder();
    paramRecyclerView.append("onScrollStateChanged state: ");
    paramRecyclerView.append(paramInt);
    QLog.i("AddedRobotView", 1, paramRecyclerView.toString());
    if (paramInt != 0)
    {
      AddedRobotView.a(this.a).pause();
      return;
    }
    if (AddedRobotView.a(this.a).isPausing())
    {
      AddedRobotView.a(this.a).resume();
      AddedRobotView.a(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.AddedRobotView.2
 * JD-Core Version:    0.7.0.1
 */