package com.tencent.mobileqq.kandian.biz.fastweb.item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mobileqq.kandian.biz.fastweb.entity.BaseItemViewHolder;
import com.tencent.mobileqq.kandian.biz.pts.ItemCreator;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;

public class WebFastTextViewCreator
  implements ItemCreator
{
  public BaseItemViewHolder a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup)
  {
    return new WebFastTextViewCreator.TextViewHolder(LayoutInflater.from(paramContext).inflate(2131626241, null), paramBaseData);
  }
  
  public boolean a(BaseData paramBaseData)
  {
    return paramBaseData.aP == 1;
  }
  
  public int b(BaseData paramBaseData)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.item.WebFastTextViewCreator
 * JD-Core Version:    0.7.0.1
 */