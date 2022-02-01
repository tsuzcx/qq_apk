package com.tencent.mobileqq.nearby.now.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

class CommentsAdapter$1
  implements View.OnClickListener
{
  CommentsAdapter$1(CommentsAdapter paramCommentsAdapter, long paramLong1, long paramLong2, long paramLong3) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getContext();
    if ((localObject instanceof BaseActivity))
    {
      localObject = (BaseActivity)localObject;
      if ((((BaseActivity)localObject).app != null) && (this.jdField_a_of_type_Long == Long.parseLong(((BaseActivity)localObject).app.getCurrentAccountUin())))
      {
        i = 2;
        break label49;
      }
    }
    int i = 3;
    label49:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("&from=3");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("&mode=");
    localStringBuilder.append(i);
    ((StringBuilder)localObject).append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("&now_id=");
    localStringBuilder.append(this.b);
    ((StringBuilder)localObject).append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("&now_user_type=");
    localStringBuilder.append(this.c);
    ((StringBuilder)localObject).append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mqq://card/show_pslcard/?uin=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("&card_type=nearby");
    localStringBuilder.append(((StringBuilder)localObject).toString());
    localObject = localStringBuilder.toString();
    paramView.getContext().startActivity(new Intent(paramView.getContext(), JumpActivity.class).setData(Uri.parse((String)localObject)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.CommentsAdapter.1
 * JD-Core Version:    0.7.0.1
 */