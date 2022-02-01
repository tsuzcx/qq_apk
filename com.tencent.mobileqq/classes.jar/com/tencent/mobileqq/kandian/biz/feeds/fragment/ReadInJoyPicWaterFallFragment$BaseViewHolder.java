package com.tencent.mobileqq.kandian.biz.feeds.fragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

class ReadInJoyPicWaterFallFragment$BaseViewHolder
  extends RecyclerView.ViewHolder
{
  Context d;
  URLImageView e;
  TextView f;
  AbsBaseArticleInfo g;
  
  ReadInJoyPicWaterFallFragment$BaseViewHolder(ReadInJoyPicWaterFallFragment paramReadInJoyPicWaterFallFragment, View paramView)
  {
    super(paramView);
  }
  
  protected int a()
  {
    return getAdapterPosition() - 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyPicWaterFallFragment.BaseViewHolder
 * JD-Core Version:    0.7.0.1
 */