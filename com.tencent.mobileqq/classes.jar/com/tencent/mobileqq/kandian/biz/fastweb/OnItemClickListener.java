package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.mobileqq.kandian.biz.fastweb.entity.BaseItemViewHolder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;

public abstract interface OnItemClickListener
{
  public abstract void a(BaseItemViewHolder paramBaseItemViewHolder);
  
  public abstract void a(BaseData paramBaseData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.OnItemClickListener
 * JD-Core Version:    0.7.0.1
 */