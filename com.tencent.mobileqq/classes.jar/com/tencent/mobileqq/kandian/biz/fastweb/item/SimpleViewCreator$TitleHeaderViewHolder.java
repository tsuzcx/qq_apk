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
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private View b;
  private View c;
  
  public SimpleViewCreator$TitleHeaderViewHolder(SimpleViewCreator paramSimpleViewCreator, View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379930));
    this.b = paramView.findViewById(2131365768);
    this.c = paramView.findViewById(2131377743);
  }
  
  public void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    if (paramBaseData2.u == 7)
    {
      paramBaseData1 = ((RecommendTitleData)paramBaseData2).jdField_a_of_type_JavaLangString;
      this.b.setVisibility(0);
    }
    else if (paramBaseData2.u == 13)
    {
      paramBaseData1 = ((CommentHeaderData)paramBaseData2).jdField_a_of_type_JavaLangString;
      this.b.setVisibility(8);
    }
    else
    {
      paramBaseData1 = "";
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramBaseData1);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    if ((paramBaseData2.u == 7) && (((RecommendTitleData)paramBaseData2).jdField_a_of_type_Boolean))
    {
      this.c.setVisibility(8);
      return;
    }
    this.c.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.item.SimpleViewCreator.TitleHeaderViewHolder
 * JD-Core Version:    0.7.0.1
 */