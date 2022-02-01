package com.tencent.mobileqq.kandian.biz.fastweb.item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mobileqq.kandian.biz.fastweb.entity.BaseItemViewHolder;
import com.tencent.mobileqq.kandian.biz.pts.ItemCreator;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;

public class WebFastAttachedAdCreator
  implements ItemCreator
{
  public BaseItemViewHolder a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup)
  {
    return new WebFastAttachedAdCreator.AdViewHolder(LayoutInflater.from(paramContext).inflate(2131626231, paramViewGroup, false), paramBaseData);
  }
  
  public boolean a(BaseData paramBaseData)
  {
    return paramBaseData.aP == 11;
  }
  
  public int b(BaseData paramBaseData)
  {
    return 11;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.item.WebFastAttachedAdCreator
 * JD-Core Version:    0.7.0.1
 */