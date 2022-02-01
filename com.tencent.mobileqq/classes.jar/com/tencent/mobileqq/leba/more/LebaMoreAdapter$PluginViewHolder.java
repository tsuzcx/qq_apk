package com.tencent.mobileqq.leba.more;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.leba.utils.LebaPluginViewUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.widget.ThemeImageView;

public class LebaMoreAdapter$PluginViewHolder
  extends RecyclerView.ViewHolder
{
  public ImageView a;
  public TextView b;
  public ThemeImageView c;
  public RelativeLayout d;
  
  public LebaMoreAdapter$PluginViewHolder(View paramView, Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramView);
    this.b = ((TextView)paramView.findViewById(2131448598));
    this.a = ((ImageView)paramView.findViewById(2131436420));
    this.c = ((ThemeImageView)paramView.findViewById(2131436248));
    this.d = ((RelativeLayout)paramView.findViewById(2131444918));
    if (paramBoolean)
    {
      if (paramInt == 2) {
        this.a.setColorFilter(LebaPluginViewUtil.c);
      } else {
        this.a.setColorFilter(QQTheme.NIGHTMODE_MASKCOLOR);
      }
      this.d.setBackgroundColor(paramContext.getResources().getColor(2131166369));
      this.b.setTextColor(paramContext.getResources().getColor(2131166371));
      return;
    }
    this.a.setColorFilter(0);
    this.d.setBackgroundColor(paramContext.getResources().getColor(2131166368));
    this.b.setTextColor(paramContext.getResources().getColor(2131166370));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.more.LebaMoreAdapter.PluginViewHolder
 * JD-Core Version:    0.7.0.1
 */