package com.tencent.mobileqq.listentogether.fragment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.listentogether.lyrics.LyricsController;

class ListenTogetherOverlayFragment$12
  implements DialogInterface.OnDismissListener
{
  ListenTogetherOverlayFragment$12(ListenTogetherOverlayFragment paramListenTogetherOverlayFragment, LyricsController paramLyricsController) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.b(false);
    this.a.r = false;
    if (!ListenTogetherOverlayFragment.a(this.b).isFinishing()) {
      ListenTogetherOverlayFragment.a(this.b).finish();
    }
    if (this.a.s) {
      this.a.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.fragment.ListenTogetherOverlayFragment.12
 * JD-Core Version:    0.7.0.1
 */