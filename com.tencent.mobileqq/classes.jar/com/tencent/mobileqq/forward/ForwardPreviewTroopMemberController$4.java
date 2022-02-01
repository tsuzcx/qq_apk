package com.tencent.mobileqq.forward;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.qphone.base.util.QLog;

class ForwardPreviewTroopMemberController$4
  extends RecyclerView.OnScrollListener
{
  ForwardPreviewTroopMemberController$4(ForwardPreviewTroopMemberController paramForwardPreviewTroopMemberController) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    paramRecyclerView = new StringBuilder();
    paramRecyclerView.append("onScrollStateChanged state: ");
    paramRecyclerView.append(paramInt);
    QLog.i("Forward.Preview.Dialog", 1, paramRecyclerView.toString());
    if (paramInt != 0)
    {
      ForwardPreviewTroopMemberController.e(this.a).pause();
      return;
    }
    if (ForwardPreviewTroopMemberController.e(this.a).isPausing())
    {
      ForwardPreviewTroopMemberController.e(this.a).resume();
      ForwardPreviewTroopMemberController.b(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardPreviewTroopMemberController.4
 * JD-Core Version:    0.7.0.1
 */