package com.tencent.mobileqq.winkpublish.part;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkpublish.viewmodel.PublishLabelViewModel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.model.LabelInfo;
import java.util.ArrayList;

class PublishLabelPart$LabelAdapter
  extends RecyclerView.Adapter<PublishLabelPart.LabelAdapter.ViewHolder>
  implements View.OnClickListener
{
  PublishLabelPart.OnMyItemClickListener a;
  
  public PublishLabelPart$LabelAdapter(PublishLabelPart paramPublishLabelPart) {}
  
  public PublishLabelPart.LabelAdapter.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new TextView(this.b.g());
    paramViewGroup.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    paramViewGroup.setGravity(16);
    paramViewGroup.setPadding(0, 0, ViewUtils.dip2px(16.0F), 0);
    paramViewGroup.setTextSize(2, 14.0F);
    paramViewGroup.setTextColor(this.b.c().getResources().getColor(2131167465));
    paramViewGroup.setOnClickListener(this);
    return new PublishLabelPart.LabelAdapter.ViewHolder(this, paramViewGroup);
  }
  
  public void a(int paramInt)
  {
    PublishLabelPart.a(this.b).a(paramInt);
    notifyItemRemoved(paramInt);
  }
  
  public void a(PublishLabelPart.LabelAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    if ((PublishLabelPart.a(this.b).g != null) && (paramInt >= 0))
    {
      if (paramInt >= PublishLabelPart.a(this.b).g.size()) {
        return;
      }
      paramViewHolder.a((LabelInfo)PublishLabelPart.a(this.b).g.get(paramInt));
    }
  }
  
  public void a(PublishLabelPart.OnMyItemClickListener paramOnMyItemClickListener)
  {
    this.a = paramOnMyItemClickListener;
  }
  
  public int getItemCount()
  {
    if (PublishLabelPart.a(this.b).g == null) {
      return 0;
    }
    return PublishLabelPart.a(this.b).g.size();
  }
  
  public void onClick(View paramView)
  {
    if ((PublishLabelPart.k(this.b) != null) && (this.a != null))
    {
      int i = PublishLabelPart.k(this.b).getChildAdapterPosition(paramView);
      this.a.a(PublishLabelPart.k(this.b), paramView, i, "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.part.PublishLabelPart.LabelAdapter
 * JD-Core Version:    0.7.0.1
 */