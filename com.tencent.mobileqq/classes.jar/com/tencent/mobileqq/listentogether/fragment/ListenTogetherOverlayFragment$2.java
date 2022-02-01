package com.tencent.mobileqq.listentogether.fragment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.listentogether.lyrics.LyricsController;

class ListenTogetherOverlayFragment$2
  implements DialogInterface.OnCancelListener
{
  ListenTogetherOverlayFragment$2(ListenTogetherOverlayFragment paramListenTogetherOverlayFragment, LyricsController paramLyricsController) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.b(false);
    if (!ListenTogetherOverlayFragment.a(this.b).isFinishing()) {
      ListenTogetherOverlayFragment.a(this.b).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.fragment.ListenTogetherOverlayFragment.2
 * JD-Core Version:    0.7.0.1
 */