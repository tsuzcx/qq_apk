package com.tencent.mobileqq.newfriend.ui.builder;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.LinearLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.ThemeImageWrapper;

public class NewFriendTabEmptyBuilder
  extends NewFriendBaseBuilder
  implements View.OnClickListener
{
  private boolean a = false;
  
  public NewFriendTabEmptyBuilder(Context paramContext, AppInterface paramAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage)
  {
    super(paramContext, paramAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
  }
  
  public View a(int paramInt, View paramView)
  {
    NewFriendTabEmptyBuilder.NewFriendTabEmptyHolder localNewFriendTabEmptyHolder;
    if ((paramView != null) && ((paramView.getTag() instanceof NewFriendTabEmptyBuilder.NewFriendTabEmptyHolder)))
    {
      localNewFriendTabEmptyHolder = (NewFriendTabEmptyBuilder.NewFriendTabEmptyHolder)paramView.getTag();
    }
    else
    {
      localNewFriendTabEmptyHolder = new NewFriendTabEmptyBuilder.NewFriendTabEmptyHolder();
      paramView = LayoutInflater.from(this.c).inflate(2131627604, null);
      localNewFriendTabEmptyHolder.a = ((LinearLayout)paramView.findViewById(2131431306));
      localNewFriendTabEmptyHolder.b = ((LinearLayout)paramView.findViewById(2131431298));
      localObject = (ThemeImageView)paramView.findViewById(2131432513);
      ((ThemeImageView)localObject).setSupportMaskView(true);
      ((ThemeImageView)localObject).setMaskShape(ThemeImageWrapper.MODE_SQURE);
      paramView.setTag(localNewFriendTabEmptyHolder);
    }
    paramView.setOnClickListener(this);
    Object localObject = new Rect();
    ((Activity)this.c).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
    paramInt = ((Rect)localObject).height() - this.c.getResources().getDimensionPixelSize(2131299920) - ViewUtils.dip2px(80.0F);
    if (this.a)
    {
      a(paramView, paramInt);
      localNewFriendTabEmptyHolder.a.setVisibility(8);
      localNewFriendTabEmptyHolder.b.setVisibility(0);
      return paramView;
    }
    a(paramView, paramInt);
    localNewFriendTabEmptyHolder.a.setVisibility(0);
    localNewFriendTabEmptyHolder.b.setVisibility(8);
    return paramView;
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.builder.NewFriendTabEmptyBuilder
 * JD-Core Version:    0.7.0.1
 */