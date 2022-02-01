package com.tencent.mobileqq.winkpublish.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.mobileqq.winkpublish.widget.PublishAssociateTagWidget;

public class PublishAssociateLabelAdapter$QCircleAssociateTagVH
  extends RecyclerView.ViewHolder
{
  public PublishAssociateLabelAdapter$QCircleAssociateTagVH(PublishAssociateLabelAdapter paramPublishAssociateLabelAdapter, View paramView)
  {
    super(paramView);
  }
  
  public void a(Object paramObject, int paramInt)
  {
    if ((this.itemView instanceof PublishAssociateTagWidget)) {
      ((PublishAssociateTagWidget)this.itemView).setData(paramObject, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.adapter.PublishAssociateLabelAdapter.QCircleAssociateTagVH
 * JD-Core Version:    0.7.0.1
 */