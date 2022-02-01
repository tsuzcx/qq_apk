package com.tencent.mobileqq.listentogether.fragment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.listentogether.lyrics.LyricsController;

class ListenTogetherOverlayFragment$2
  implements DialogInterface.OnCancelListener
{
  ListenTogetherOverlayFragment$2(ListenTogetherOverlayFragment paramListenTogetherOverlayFragment, LyricsController paramLyricsController) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsLyricsController.b(false);
    if (!ListenTogetherOverlayFragment.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherFragmentListenTogetherOverlayFragment).isFinishing()) {
      ListenTogetherOverlayFragment.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherFragmentListenTogetherOverlayFragment).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.fragment.ListenTogetherOverlayFragment.2
 * JD-Core Version:    0.7.0.1
 */