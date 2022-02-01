package com.tencent.mobileqq.newfriend.ui.builder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.newfriend.msg.NewFriendTabInfoMessage;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import java.util.ArrayList;

public class NewFriendTabInfoBuilder
  extends NewFriendBaseBuilder
  implements View.OnClickListener
{
  public NewFriendTabInfoBuilder(Context paramContext, AppInterface paramAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage)
  {
    super(paramContext, paramAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
  }
  
  private void a(TextView paramTextView, NewFriendMessage paramNewFriendMessage)
  {
    if (paramNewFriendMessage != null)
    {
      if (!(paramNewFriendMessage instanceof NewFriendTabInfoMessage)) {
        return;
      }
      paramNewFriendMessage = (NewFriendTabInfoMessage)paramNewFriendMessage;
      if (paramNewFriendMessage.a != null)
      {
        if (paramNewFriendMessage.a.size() == 0) {
          return;
        }
        paramNewFriendMessage = this.jdField_a_of_type_AndroidContentContext.getString(2131699049);
        paramTextView.setVisibility(0);
        paramTextView.setText(paramNewFriendMessage);
        paramTextView.setPadding(0, ViewUtils.a(16.0F), 0, ViewUtils.a(6.0F));
      }
    }
  }
  
  public View a(int paramInt, View paramView)
  {
    NewFriendTabInfoBuilder.NewFriendTabInfoHolder localNewFriendTabInfoHolder;
    if ((paramView != null) && ((paramView.getTag() instanceof NewFriendTabInfoBuilder.NewFriendTabInfoHolder)))
    {
      localNewFriendTabInfoHolder = (NewFriendTabInfoBuilder.NewFriendTabInfoHolder)paramView.getTag();
    }
    else
    {
      localNewFriendTabInfoHolder = new NewFriendTabInfoBuilder.NewFriendTabInfoHolder();
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561250, null);
      localNewFriendTabInfoHolder.a = ((TextView)paramView.findViewById(2131378220));
      paramView.setTag(localNewFriendTabInfoHolder);
    }
    c(localNewFriendTabInfoHolder.a);
    a(localNewFriendTabInfoHolder.a, this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendMessage);
    paramView.setOnClickListener(this);
    return paramView;
  }
  
  public void c(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (ThemeUtil.isDefaultTheme())
    {
      paramView.setBackgroundResource(2130839393);
      return;
    }
    paramView.setBackgroundResource(2130850578);
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.builder.NewFriendTabInfoBuilder
 * JD-Core Version:    0.7.0.1
 */