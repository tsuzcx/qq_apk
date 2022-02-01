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
      localView = LayoutInflater.from(this.a.a).inflate(2131560613, null);
    }
    paramView = (TroopFeedViewFactory.VoteViewProvider.ViewHolder)localView.getTag();
    Object localObject = paramView;
    if (paramView == null)
    {
      localObject = new TroopFeedViewFactory.VoteViewProvider.ViewHolder(this);
      ((TroopFeedViewFactory.VoteViewProvider.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131372696));
      ((TroopFeedViewFactory.VoteViewProvider.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378784));
      ((TroopFeedViewFactory.VoteViewProvider.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131380995));
      ((TroopFeedViewFactory.VoteViewProvider.ViewHolder)localObject).b = ((TextView)localView.findViewById(2131380998));
      ((TroopFeedViewFactory.VoteViewProvider.ViewHolder)localObject).c = ((TextView)localView.findViewById(2131380999));
      localView.setOnClickListener(this.a);
      localView.setTag(localObject);
    }
    ((TroopFeedViewFactory.VoteViewProvider.ViewHolder)localObject).jdField_a_of_type_Int = paramInt;
    ((TroopFeedViewFactory.VoteViewProvider.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = paramTroopFeedItem;
    paramView = new StringBuilder();
    paramView.append("[");
    paramView.append(paramTroopFeedItem.tag);
    paramView.append("] ");
    paramView.append(paramTroopFeedItem.title);
    paramView = paramView.toString();
    ((TroopFeedViewFactory.VoteViewProvider.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
    ((TroopFeedViewFactory.VoteViewProvider.ViewHolder)localObject).b.setText(paramTroopFeedItem.content);
    ((TroopFeedViewFactory.VoteViewProvider.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    paramView = new StringBuilder();
    paramView.append(HardCodeUtil.a(2131715091));
    paramView.append(paramTroopFeedItem.tag);
    paramView.append(" ");
    paramView.append(paramTroopFeedItem.title);
    paramView.append(" ");
    paramView.append(paramTroopFeedItem.content);
    paramView = paramView.toString();
    if (!StringUtil.a(paramTroopFeedItem.ex_1))
    {
      ((TroopFeedViewFactory.VoteViewProvider.ViewHolder)localObject).c.setText(paramTroopFeedItem.ex_1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramView);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramTroopFeedItem.ex_1);
      paramView = localStringBuilder.toString();
    }
    else
    {
      ((TroopFeedViewFactory.VoteViewProvider.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    ((TroopFeedViewFactory.VoteViewProvider.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843797);
    paramTroopFeedItem = paramView;
    if (!paramBoolean)
    {
      paramTroopFeedItem = new StringBuilder();
      paramTroopFeedItem.append(paramView);
      paramTroopFeedItem.append(" ");
      paramTroopFeedItem.append(HardCodeUtil.a(2131715087));
      paramTroopFeedItem = paramTroopFeedItem.toString();
    }
    localView.setContentDescription(paramTroopFeedItem);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopFeedViewFactory.VoteViewProvider
 * JD-Core Version:    0.7.0.1
 */