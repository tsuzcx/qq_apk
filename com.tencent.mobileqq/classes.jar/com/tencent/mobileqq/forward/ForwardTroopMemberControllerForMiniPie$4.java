package com.tencent.mobileqq.forward;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.qphone.base.util.QLog;

class ForwardTroopMemberControllerForMiniPie$4
  extends RecyclerView.OnScrollListener
{
  ForwardTroopMemberControllerForMiniPie$4(ForwardTroopMemberControllerForMiniPie paramForwardTroopMemberControllerForMiniPie) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    paramRecyclerView = new StringBuilder();
    paramRecyclerView.append("onScrollStateChanged state: ");
    paramRecyclerView.append(paramInt);
    QLog.i("ForwardTroopMemberControllerForMiniPie", 1, paramRecyclerView.toString());
    if (paramInt != 0)
    {
      ForwardTroopMemberControllerForMiniPie.a(this.a).pause();
      return;
    }
    if (ForwardTroopMemberControllerForMiniPie.a(this.a).isPausing())
    {
      ForwardTroopMemberControllerForMiniPie.a(this.a).resume();
      ForwardTroopMemberControllerForMiniPie.a(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardTroopMemberControllerForMiniPie.4
 * JD-Core Version:    0.7.0.1
 */