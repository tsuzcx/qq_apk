package com.tencent.mobileqq.kandian.biz.comment;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDeliverUGCActivity;

class ReadInJoyCommentComponentFragment$8$1
  implements Runnable
{
  ReadInJoyCommentComponentFragment$8$1(ReadInJoyCommentComponentFragment.8 param8) {}
  
  public void run()
  {
    ReadInJoyCommentComponentFragment.b(this.a.a);
    this.a.a.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(ReadInJoyDeliverUGCActivity.a(this.a.a.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData));
    this.a.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    ReadInJoyCommentComponentFragment.a(this.a.a);
    if (this.a.a.jdField_a_of_type_Boolean)
    {
      this.a.a.g.setImageResource(2130842947);
      ReadInJoyCommentComponentFragment.a(this.a.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentComponentFragment.8.1
 * JD-Core Version:    0.7.0.1
 */