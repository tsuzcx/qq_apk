package com.tencent.mobileqq.troop.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.utils.StringUtil;

class TroopFeedViewFactory$VoteViewProvider
  extends TroopFeedViewFactory.ViewProvider
{
  TroopFeedViewFactory$VoteViewProvider(TroopFeedViewFactory paramTroopFeedViewFactory)
  {
    super(paramTroopFeedViewFactory);
  }
  
  protected View a(View paramView, TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(this.a.a).inflate(2131560725, null);
    }
    paramView = (TroopFeedViewFactory.VoteViewProvider.ViewHolder)localView.getTag();
    Object localObject = paramView;
    if (paramView == null)
    {
      localObject = new TroopFeedViewFactory.VoteViewProvider.ViewHolder(this);
      ((TroopFeedViewFactory.VoteViewProvider.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131373117));
      ((TroopFeedViewFactory.VoteViewProvider.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379432));
      ((TroopFeedViewFactory.VoteViewProvider.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131381766));
      ((TroopFeedViewFactory.VoteViewProvider.ViewHolder)localObject).b = ((TextView)localView.findViewById(2131381769));
      ((TroopFeedViewFactory.VoteViewProvider.ViewHolder)localObject).c = ((TextView)localView.findViewById(2131381770));
      localView.setOnClickListener(this.a);
      localView.setTag(localObject);
    }
    ((TroopFeedViewFactory.VoteViewProvider.ViewHolder)localObject).jdField_a_of_type_Int = paramInt;
    ((TroopFeedViewFactory.VoteViewProvider.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = paramTroopFeedItem;
    paramView = "[" + paramTroopFeedItem.tag + "] " + paramTroopFeedItem.title;
    ((TroopFeedViewFactory.VoteViewProvider.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
    ((TroopFeedViewFactory.VoteViewProvider.ViewHolder)localObject).b.setText(paramTroopFeedItem.content);
    ((TroopFeedViewFactory.VoteViewProvider.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    paramView = HardCodeUtil.a(2131715168) + paramTroopFeedItem.tag + " " + paramTroopFeedItem.title + " " + paramTroopFeedItem.content;
    if (!StringUtil.a(paramTroopFeedItem.ex_1))
    {
      ((TroopFeedViewFactory.VoteViewProvider.ViewHolder)localObject).c.setText(paramTroopFeedItem.ex_1);
      paramView = paramView + " " + paramTroopFeedItem.ex_1;
    }
    for (;;)
    {
      ((TroopFeedViewFactory.VoteViewProvider.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843877);
      paramTroopFeedItem = paramView;
      if (!paramBoolean) {
        paramTroopFeedItem = paramView + " " + HardCodeUtil.a(2131715164);
      }
      localView.setContentDescription(paramTroopFeedItem);
      return localView;
      ((TroopFeedViewFactory.VoteViewProvider.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopFeedViewFactory.VoteViewProvider
 * JD-Core Version:    0.7.0.1
 */