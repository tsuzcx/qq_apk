package com.tencent.mobileqq.kandian.biz.fastweb.item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.entity.BaseItemViewHolder;
import com.tencent.mobileqq.kandian.biz.pts.ItemCreator;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.widget.HorizontalLabelLayout;

public class SimpleViewCreator
  implements ItemCreator
{
  public int a(BaseData paramBaseData)
  {
    int i = paramBaseData.u;
    if (i != 7)
    {
      if (i != 8) {}
      switch (i)
      {
      default: 
        throw new IllegalArgumentException();
      case 16: 
        return 14;
      case 15: 
        return 13;
      case 14: 
        return 8;
      }
    }
    return 7;
  }
  
  public BaseItemViewHolder a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup)
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramContext);
    int i = a(paramBaseData);
    if (i != 7)
    {
      if (i != 8)
      {
        if (i != 13)
        {
          if (i == 14) {
            return new SimpleViewCreator.NoCommentBgViewHolder(this, localLayoutInflater.inflate(2131560118, paramViewGroup, false), paramBaseData);
          }
          throw new IllegalArgumentException();
        }
        paramViewGroup = new HorizontalLabelLayout(paramContext);
        i = AIOUtils.b(15.0F, paramContext.getResources());
        paramViewGroup.setPadding(i, 0, i, 0);
        return new SimpleViewCreator.ArticleTopicFlagViewHolder(this, paramViewGroup, paramBaseData);
      }
      return new SimpleViewCreator.CommonBottomViewHolder(this, localLayoutInflater.inflate(2131560188, paramViewGroup, false), paramBaseData);
    }
    return new SimpleViewCreator.TitleHeaderViewHolder(this, localLayoutInflater.inflate(2131560191, paramViewGroup, false), paramBaseData);
  }
  
  public boolean a(BaseData paramBaseData)
  {
    return (paramBaseData.u == 7) || (paramBaseData.u == 8) || (paramBaseData.u == 13) || (paramBaseData.u == 14) || (paramBaseData.u == 15) || (paramBaseData.u == 16);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.item.SimpleViewCreator
 * JD-Core Version:    0.7.0.1
 */