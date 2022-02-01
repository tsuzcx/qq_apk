package com.tencent.mobileqq.kandian.biz.comment.ui;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.PopupWindow;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentListAdapter;
import com.tencent.mobileqq.kandian.biz.comment.ReadinjoyCommentListBaseAdapter;

public class ReadInJoyCommentPopUpWindow
  extends PopupWindow
  implements View.OnClickListener
{
  private static final int jdField_a_of_type_Int = Color.parseColor("#376099");
  protected Activity a;
  private View jdField_a_of_type_AndroidViewView;
  private ReadinjoyCommentListBaseAdapter jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter;
  private ReadInJoyCommentPopUpWindow.OnCommentTypeChangedListener jdField_a_of_type_ComTencentMobileqqKandianBizCommentUiReadInJoyCommentPopUpWindow$OnCommentTypeChangedListener;
  private boolean jdField_a_of_type_Boolean;
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidAppActivity.getWindowManager().removeView(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_AndroidViewView = null;
    }
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Boolean = false;
    dismiss();
    int i = paramView.getId();
    if ((i != 2131364628) && (i == 2131364630)) {
      i = 2;
    } else {
      i = 3;
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentUiReadInJoyCommentPopUpWindow$OnCommentTypeChangedListener;
    if (paramView != null) {
      paramView.b(i);
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter;
    if (paramView != null)
    {
      paramView.c();
      if (i == 3)
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentReadinjoyCommentListBaseAdapter;
        if ((paramView instanceof ReadInJoyCommentListAdapter)) {
          ((ReadInJoyCommentListAdapter)paramView).g();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ui.ReadInJoyCommentPopUpWindow
 * JD-Core Version:    0.7.0.1
 */