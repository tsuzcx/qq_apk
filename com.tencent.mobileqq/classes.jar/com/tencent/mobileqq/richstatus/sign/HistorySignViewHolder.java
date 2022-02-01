package com.tencent.mobileqq.richstatus.sign;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.comment.widget.CommentsView;
import com.tencent.mobileqq.richstatus.comment.widget.LikesView;

public class HistorySignViewHolder
  extends BaseSignViewHolder
{
  public int a;
  public CheckBox a;
  QQAppInterface a;
  public CommentsView a;
  public LikesView a;
  public RichStatus b;
  
  public HistorySignViewHolder(Context paramContext, AppInterface paramAppInterface, View paramView, String paramString)
  {
    super(paramContext, paramAppInterface, paramView, paramString);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramAppInterface);
    this.e = 1;
  }
  
  public View a(RichStatus paramRichStatus)
  {
    return super.a(paramRichStatus);
  }
  
  protected void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setMinimumHeight(0);
  }
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    int i;
    label49:
    label77:
    label98:
    LikesView localLikesView;
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetCommentsView != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetCommentsView;
      if (paramBoolean)
      {
        i = jdField_a_of_type_ArrayOfInt[14];
        ((CommentsView)localObject).setNormalTextColor(i);
        localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetCommentsView;
        if (!paramBoolean) {
          break label162;
        }
        i = jdField_a_of_type_ArrayOfInt[13];
        ((CommentsView)localObject).setItemColor(i);
      }
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetLikesView != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetLikesView;
      if (!paramBoolean) {
        break label172;
      }
      i = jdField_a_of_type_ArrayOfInt[14];
      ((LikesView)localObject).setNormalTextColor(i);
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetLikesView;
      if (!paramBoolean) {
        break label182;
      }
      i = jdField_a_of_type_ArrayOfInt[13];
      ((LikesView)localObject).setItemColor(i);
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetLikesView.a();
      if ((this.jdField_a_of_type_AndroidContentContext != null) && (localObject != null))
      {
        localLikesView = this.jdField_a_of_type_ComTencentMobileqqRichstatusCommentWidgetLikesView;
        if (!paramBoolean) {
          break label192;
        }
      }
    }
    label162:
    label172:
    label182:
    label192:
    for (Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847805);; localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847806))
    {
      localLikesView.setLikSpanDrawable((Drawable)localObject);
      return;
      i = jdField_a_of_type_ArrayOfInt[16];
      break;
      i = jdField_a_of_type_ArrayOfInt[15];
      break label49;
      i = jdField_a_of_type_ArrayOfInt[15];
      break label77;
      i = jdField_a_of_type_ArrayOfInt[15];
      break label98;
    }
  }
  
  protected int b()
  {
    return jdField_a_of_type_ArrayOfInt[12];
  }
  
  protected boolean d()
  {
    return true;
  }
  
  protected boolean e()
  {
    return false;
  }
  
  protected void i() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.sign.HistorySignViewHolder
 * JD-Core Version:    0.7.0.1
 */