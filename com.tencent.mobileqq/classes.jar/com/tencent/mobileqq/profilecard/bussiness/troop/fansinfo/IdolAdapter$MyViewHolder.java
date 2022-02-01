package com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.TextView;
import com.tencent.image.URLImageView;

public class IdolAdapter$MyViewHolder
  extends RecyclerView.ViewHolder
{
  public URLImageView ivHead;
  public TextView tvName;
  public TextView tvQscore;
  public TextView tvQscoretitle;
  public TextView tvRank;
  
  IdolAdapter$MyViewHolder(View paramView)
  {
    super(paramView);
    this.ivHead = ((URLImageView)paramView.findViewById(2131434878));
    this.tvQscoretitle = ((TextView)paramView.findViewById(2131442909));
    this.tvQscore = ((TextView)paramView.findViewById(2131442908));
    this.tvRank = ((TextView)paramView.findViewById(2131444159));
    this.tvName = ((TextView)paramView.findViewById(2131439121));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.troop.fansinfo.IdolAdapter.MyViewHolder
 * JD-Core Version:    0.7.0.1
 */