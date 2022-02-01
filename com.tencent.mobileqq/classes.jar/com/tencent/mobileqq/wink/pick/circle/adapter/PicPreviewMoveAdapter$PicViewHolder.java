package com.tencent.mobileqq.wink.pick.circle.adapter;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.pick.RoundCorneredRelativeLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PicPreviewMoveAdapter$PicViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  public TextView a;
  private URLImageView c;
  private ImageView d;
  private RoundCorneredRelativeLayout e;
  
  public PicPreviewMoveAdapter$PicViewHolder(PicPreviewMoveAdapter paramPicPreviewMoveAdapter, View paramView)
  {
    super(paramView);
    this.c = ((URLImageView)paramView.findViewById(2131436489));
    this.d = ((ImageView)paramView.findViewById(2131436339));
    this.a = ((TextView)paramView.findViewById(2131448418));
    this.e = ((RoundCorneredRelativeLayout)paramView.findViewById(2131444195));
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    int i = ViewUtils.dip2px(3.0F);
    paramPicPreviewMoveAdapter = this.e;
    float f = i;
    paramPicPreviewMoveAdapter.setRadius(f, f, f, f);
  }
  
  public void onClick(View paramView)
  {
    int i = getAdapterPosition();
    if (paramView == this.c)
    {
      if (PicPreviewMoveAdapter.a(this.b) != null) {
        PicPreviewMoveAdapter.a(this.b).a(paramView, i);
      }
    }
    else if (paramView == this.d) {
      PicPreviewMoveAdapter.a(this.b, i);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.adapter.PicPreviewMoveAdapter.PicViewHolder
 * JD-Core Version:    0.7.0.1
 */