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
      localView = LayoutInflater.from(this.a.a).inflate(2131626658, null);
    }
    paramView = (TroopFeedViewFactory.VoteViewProvider.ViewHolder)localView.getTag();
    Object localObject = paramView;
    if (paramView == null)
    {
      localObject = new TroopFeedViewFactory.VoteViewProvider.ViewHolder(this);
      ((TroopFeedViewFactory.VoteViewProvider.ViewHolder)localObject).a = ((ImageView)localView.findViewById(2131440242));
      ((TroopFeedViewFactory.VoteViewProvider.ViewHolder)localObject).b = ((TextView)localView.findViewById(2131447463));
      ((TroopFeedViewFactory.VoteViewProvider.ViewHolder)localObject).c = ((LinearLayout)localView.findViewById(2131449990));
      ((TroopFeedViewFactory.VoteViewProvider.ViewHolder)localObject).d = ((TextView)localView.findViewById(2131449993));
      ((TroopFeedViewFactory.VoteViewProvider.ViewHolder)localObject).e = ((TextView)localView.findViewById(2131449994));
      localView.setOnClickListener(this.a);
      localView.setTag(localObject);
    }
    ((TroopFeedViewFactory.VoteViewProvider.ViewHolder)localObject).g = paramInt;
    ((TroopFeedViewFactory.VoteViewProvider.ViewHolder)localObject).f = paramTroopFeedItem;
    paramView = new StringBuilder();
    paramView.append("[");
    paramView.append(paramTroopFeedItem.tag);
    paramView.append("] ");
    paramView.append(paramTroopFeedItem.title);
    paramView = paramView.toString();
    ((TroopFeedViewFactory.VoteViewProvider.ViewHolder)localObject).b.setText(paramView);
    ((TroopFeedViewFactory.VoteViewProvider.ViewHolder)localObject).d.setText(paramTroopFeedItem.content);
    ((TroopFeedViewFactory.VoteViewProvider.ViewHolder)localObject).c.setVisibility(0);
    paramView = new StringBuilder();
    paramView.append(HardCodeUtil.a(2131912579));
    paramView.append(paramTroopFeedItem.tag);
    paramView.append(" ");
    paramView.append(paramTroopFeedItem.title);
    paramView.append(" ");
    paramView.append(paramTroopFeedItem.content);
    paramView = paramView.toString();
    if (!StringUtil.isEmpty(paramTroopFeedItem.ex_1))
    {
      ((TroopFeedViewFactory.VoteViewProvider.ViewHolder)localObject).e.setText(paramTroopFeedItem.ex_1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramView);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramTroopFeedItem.ex_1);
      paramView = localStringBuilder.toString();
    }
    else
    {
      ((TroopFeedViewFactory.VoteViewProvider.ViewHolder)localObject).c.setVisibility(8);
    }
    ((TroopFeedViewFactory.VoteViewProvider.ViewHolder)localObject).a.setImageResource(2130844751);
    paramTroopFeedItem = paramView;
    if (!paramBoolean)
    {
      paramTroopFeedItem = new StringBuilder();
      paramTroopFeedItem.append(paramView);
      paramTroopFeedItem.append(" ");
      paramTroopFeedItem.append(HardCodeUtil.a(2131912575));
      paramTroopFeedItem = paramTroopFeedItem.toString();
    }
    localView.setContentDescription(paramTroopFeedItem);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopFeedViewFactory.VoteViewProvider
 * JD-Core Version:    0.7.0.1
 */