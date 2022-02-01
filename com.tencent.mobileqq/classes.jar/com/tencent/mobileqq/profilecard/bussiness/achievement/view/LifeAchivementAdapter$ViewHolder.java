package com.tencent.mobileqq.profilecard.bussiness.achievement.view;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.TextView;
import com.tencent.widget.AlphaClickableRelativeLayout;
import com.tencent.widget.AlphaClickableTextView;

class LifeAchivementAdapter$ViewHolder
  extends RecyclerView.ViewHolder
{
  public TextView content;
  public AlphaClickableRelativeLayout imageWrapper;
  public LayerImageView imageview;
  public TextView moreNum;
  public AlphaClickableTextView praiseCount;
  
  public LifeAchivementAdapter$ViewHolder(View paramView)
  {
    super(paramView);
    this.imageWrapper = ((AlphaClickableRelativeLayout)paramView.findViewById(2131368577));
    this.imageview = ((LayerImageView)paramView.findViewById(2131361939));
    this.moreNum = ((TextView)paramView.findViewById(2131361940));
    this.content = ((TextView)paramView.findViewById(2131361938));
    this.praiseCount = ((AlphaClickableTextView)paramView.findViewById(2131361941));
    this.imageWrapper.enableAlphaClick(false);
    this.praiseCount.setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.achievement.view.LifeAchivementAdapter.ViewHolder
 * JD-Core Version:    0.7.0.1
 */