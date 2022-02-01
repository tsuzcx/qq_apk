package com.tencent.mobileqq.fragment;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DeleteFaceFragment$1
  implements View.OnClickListener
{
  DeleteFaceFragment$1(DeleteFaceFragment paramDeleteFaceFragment) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DeleteFaceFragment", 2, "user cancel delete");
    }
    if ((DeleteFaceFragment.a(this.a) != null) && (DeleteFaceFragment.a(this.a).isShowing())) {
      DeleteFaceFragment.a(this.a).dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.DeleteFaceFragment.1
 * JD-Core Version:    0.7.0.1
 */