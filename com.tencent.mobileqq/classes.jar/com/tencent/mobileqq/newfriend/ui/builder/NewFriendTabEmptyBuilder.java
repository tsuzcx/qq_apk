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
  private boolean a;
  
  public NewFriendTabEmptyBuilder(Context paramContext, AppInterface paramAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage)
  {
    super(paramContext, paramAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
    this.jdField_a_of_type_Boolean = false;
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
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561248, null);
      localNewFriendTabEmptyHolder.a = ((LinearLayout)paramView.findViewById(2131365154));
      localNewFriendTabEmptyHolder.b = ((LinearLayout)paramView.findViewById(2131365149));
      localObject = (ThemeImageView)paramView.findViewById(2131366225);
      ((ThemeImageView)localObject).setSupportMaskView(true);
      ((ThemeImageView)localObject).setMaskShape(ThemeImageWrapper.MODE_SQURE);
      paramView.setTag(localNewFriendTabEmptyHolder);
    }
    paramView.setOnClickListener(this);
    Object localObject = new Rect();
    ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
    paramInt = ((Rect)localObject).height() - this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168) - ViewUtils.a(80.0F);
    if (this.jdField_a_of_type_Boolean)
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
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.builder.NewFriendTabEmptyBuilder
 * JD-Core Version:    0.7.0.1
 */