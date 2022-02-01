package com.tencent.mobileqq.listentogether.lyrics;

import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.listentogether.ListenTogetherUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class LyricsController$10
  implements ActionSheet.OnButtonClickListener
{
  LyricsController$10(LyricsController paramLyricsController, ActionSheet paramActionSheet, boolean paramBoolean) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    if (this.jdField_a_of_type_Boolean)
    {
      if (paramInt != 0)
      {
        if (paramInt == 1) {
          this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsLyricsController.h();
        }
      }
      else {
        ListenTogetherUtils.a(BaseActivity.sTopActivity, this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsLyricsController.a().e, this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsLyricsController.a().b);
      }
    }
    else {
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsLyricsController.h();
    }
    this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsLyricsController.b(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.lyrics.LyricsController.10
 * JD-Core Version:    0.7.0.1
 */