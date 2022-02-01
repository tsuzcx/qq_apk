package com.tencent.mobileqq.listentogether.fragment;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.listentogether.lyrics.LyricsController;
import com.tencent.widget.ActionSheet.OnDismissListener;

class ListenTogetherOverlayFragment$1
  implements ActionSheet.OnDismissListener
{
  ListenTogetherOverlayFragment$1(ListenTogetherOverlayFragment paramListenTogetherOverlayFragment, LyricsController paramLyricsController) {}
  
  public void onDismiss()
  {
    this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsLyricsController.b(false);
    if (!ListenTogetherOverlayFragment.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherFragmentListenTogetherOverlayFragment).isFinishing()) {
      ListenTogetherOverlayFragment.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherFragmentListenTogetherOverlayFragment).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.fragment.ListenTogetherOverlayFragment.1
 * JD-Core Version:    0.7.0.1
 */