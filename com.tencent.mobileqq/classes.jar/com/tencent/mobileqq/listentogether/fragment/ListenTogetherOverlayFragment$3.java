package com.tencent.mobileqq.listentogether.fragment;

import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.listentogether.ListenTogetherUtils;
import com.tencent.mobileqq.listentogether.lyrics.FloatParams;
import com.tencent.mobileqq.listentogether.lyrics.LyricsController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ListenTogetherOverlayFragment$3
  implements ActionSheet.OnButtonClickListener
{
  ListenTogetherOverlayFragment$3(ListenTogetherOverlayFragment paramListenTogetherOverlayFragment, boolean paramBoolean, LyricsController paramLyricsController) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    ListenTogetherOverlayFragment.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherFragmentListenTogetherOverlayFragment).dismiss();
    if (this.jdField_a_of_type_Boolean)
    {
      if (paramInt != 0)
      {
        if (paramInt == 1) {
          this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsLyricsController.h();
        }
      }
      else {
        ListenTogetherUtils.a(ListenTogetherOverlayFragment.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherFragmentListenTogetherOverlayFragment), this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsLyricsController.a().e, this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsLyricsController.a().b);
      }
    }
    else {
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsLyricsController.h();
    }
    this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsLyricsController.b(false);
    if (!ListenTogetherOverlayFragment.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherFragmentListenTogetherOverlayFragment).isFinishing()) {
      ListenTogetherOverlayFragment.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherFragmentListenTogetherOverlayFragment).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.fragment.ListenTogetherOverlayFragment.3
 * JD-Core Version:    0.7.0.1
 */