package com.tencent.mobileqq.winkpublish.part;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import cooperation.qzone.model.LabelInfo;

public class PublishLabelPart$LabelAdapter$ViewHolder
  extends RecyclerView.ViewHolder
{
  TextView a;
  
  public PublishLabelPart$LabelAdapter$ViewHolder(PublishLabelPart.LabelAdapter paramLabelAdapter, View paramView)
  {
    super(paramView);
    this.a = ((TextView)paramView);
  }
  
  public void a(LabelInfo paramLabelInfo)
  {
    this.a.setText(paramLabelInfo.name);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.part.PublishLabelPart.LabelAdapter.ViewHolder
 * JD-Core Version:    0.7.0.1
 */