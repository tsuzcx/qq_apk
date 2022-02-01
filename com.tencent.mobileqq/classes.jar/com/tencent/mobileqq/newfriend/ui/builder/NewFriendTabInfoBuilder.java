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
        paramNewFriendMessage = this.c.getString(2131897058);
        paramTextView.setVisibility(0);
        paramTextView.setText(paramNewFriendMessage);
        paramTextView.setPadding(0, ViewUtils.dip2px(16.0F), 0, ViewUtils.dip2px(6.0F));
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
      paramView = LayoutInflater.from(this.c).inflate(2131627606, null);
      localNewFriendTabInfoHolder.a = ((TextView)paramView.findViewById(2131446738));
      paramView.setTag(localNewFriendTabInfoHolder);
    }
    c(localNewFriendTabInfoHolder.a);
    a(localNewFriendTabInfoHolder.a, this.g);
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
      paramView.setBackgroundResource(2130839577);
      return;
    }
    paramView.setBackgroundResource(2130852374);
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.builder.NewFriendTabInfoBuilder
 * JD-Core Version:    0.7.0.1
 */