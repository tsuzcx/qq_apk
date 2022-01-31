package com.tencent.mobileqq.troop.activity;

import android.widget.ImageView;
import aydq;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;

public class PublicCommentWindow$1
  implements Runnable
{
  public PublicCommentWindow$1(aydq paramaydq) {}
  
  public void run()
  {
    this.this$0.b = false;
    if ((this.this$0.isShowing()) && (this.this$0.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel != null))
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.setVisibility(0);
      this.this$0.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846793);
      this.this$0.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131630831));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.PublicCommentWindow.1
 * JD-Core Version:    0.7.0.1
 */