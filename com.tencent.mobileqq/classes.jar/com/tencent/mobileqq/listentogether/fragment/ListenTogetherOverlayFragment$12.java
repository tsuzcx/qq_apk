package com.tencent.mobileqq.listentogether.fragment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.listentogether.lyrics.LyricsController;

class ListenTogetherOverlayFragment$12
  implements DialogInterface.OnDismissListener
{
  ListenTogetherOverlayFragment$12(ListenTogetherOverlayFragment paramListenTogetherOverlayFragment, LyricsController paramLyricsController) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsLyricsController.b(false);
    this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsLyricsController.d = false;
    if (!ListenTogetherOverlayFragment.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherFragmentListenTogetherOverlayFragment).isFinishing()) {
      ListenTogetherOverlayFragment.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherFragmentListenTogetherOverlayFragment).finish();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsLyricsController.e) {
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsLyricsController.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.fragment.ListenTogetherOverlayFragment.12
 * JD-Core Version:    0.7.0.1
 */