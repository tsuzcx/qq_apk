package com.tencent.mobileqq.listentogether.fragment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.v4.app.FragmentActivity;

class ListenTogetherOverlayFragment$7
  implements DialogInterface.OnDismissListener
{
  ListenTogetherOverlayFragment$7(ListenTogetherOverlayFragment paramListenTogetherOverlayFragment) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((!ListenTogetherOverlayFragment.a(this.a)) && (!ListenTogetherOverlayFragment.a(this.a).isFinishing())) {
      ListenTogetherOverlayFragment.a(this.a).finish();
    }
    ListenTogetherOverlayFragment.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.fragment.ListenTogetherOverlayFragment.7
 * JD-Core Version:    0.7.0.1
 */