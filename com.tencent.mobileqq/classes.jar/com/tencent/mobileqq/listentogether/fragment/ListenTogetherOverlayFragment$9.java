package com.tencent.mobileqq.listentogether.fragment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.lyrics.LyricsController;

class ListenTogetherOverlayFragment$9
  implements DialogInterface.OnClickListener
{
  ListenTogetherOverlayFragment$9(ListenTogetherOverlayFragment paramListenTogetherOverlayFragment, ListenTogetherManager paramListenTogetherManager, LyricsController paramLyricsController) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.d();
    this.b.b(false);
    if (!ListenTogetherOverlayFragment.a(this.c).isFinishing()) {
      ListenTogetherOverlayFragment.a(this.c).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.fragment.ListenTogetherOverlayFragment.9
 * JD-Core Version:    0.7.0.1
 */