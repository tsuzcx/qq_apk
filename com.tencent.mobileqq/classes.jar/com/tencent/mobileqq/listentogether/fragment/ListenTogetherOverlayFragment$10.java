package com.tencent.mobileqq.listentogether.fragment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.lyrics.LyricsController;

class ListenTogetherOverlayFragment$10
  implements DialogInterface.OnDismissListener
{
  ListenTogetherOverlayFragment$10(ListenTogetherOverlayFragment paramListenTogetherOverlayFragment, ListenTogetherManager paramListenTogetherManager, LyricsController paramLyricsController) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.d();
    this.b.b(false);
    if (!ListenTogetherOverlayFragment.a(this.c).isFinishing()) {
      ListenTogetherOverlayFragment.a(this.c).finish();
    }
    ListenTogetherOverlayFragment.b(this.c, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.fragment.ListenTogetherOverlayFragment.10
 * JD-Core Version:    0.7.0.1
 */