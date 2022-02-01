package com.tencent.mobileqq.kandian.biz.fastweb.item;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.biz.fastweb.entity.BaseItemViewHolder;
import com.tencent.mobileqq.kandian.biz.feeds.entity.RecommendTitleData;
import com.tencent.mobileqq.kandian.repo.fastweb.entity.CommentHeaderData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;

class SimpleViewCreator$TitleHeaderViewHolder
  extends BaseItemViewHolder
{
  private TextView b;
  private View c;
  private View d;
  
  public SimpleViewCreator$TitleHeaderViewHolder(SimpleViewCreator paramSimpleViewCreator, View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    this.b = ((TextView)paramView.findViewById(2131448814));
    this.c = paramView.findViewById(2131432025);
    this.d = paramView.findViewById(2131446201);
  }
  
  public void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    if (paramBaseData2.aP == 7)
    {
      paramBaseData1 = ((RecommendTitleData)paramBaseData2).a;
      this.c.setVisibility(0);
    }
    else if (paramBaseData2.aP == 13)
    {
      paramBaseData1 = ((CommentHeaderData)paramBaseData2).a;
      this.c.setVisibility(8);
    }
    else
    {
      paramBaseData1 = "";
    }
    this.b.setText(paramBaseData1);
    this.b.setVisibility(8);
    if ((paramBaseData2.aP == 7) && (((RecommendTitleData)paramBaseData2).b))
    {
      this.d.setVisibility(8);
      return;
    }
    this.d.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.item.SimpleViewCreator.TitleHeaderViewHolder
 * JD-Core Version:    0.7.0.1
 */