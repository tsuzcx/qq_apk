package com.tencent.mobileqq.kandian.biz.fastweb.item;

import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.data.LinkData;
import com.tencent.mobileqq.kandian.biz.fastweb.entity.BaseItemViewHolder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;

class WebFastLinkViewCreator$TextViewHolder
  extends BaseItemViewHolder
  implements View.OnClickListener
{
  private TextView a;
  
  public WebFastLinkViewCreator$TextViewHolder(View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    this.a = ((TextView)paramView.findViewById(2131448801));
    paramView.setOnClickListener(this);
  }
  
  public void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    if (paramBaseData2.aP != 4) {
      return;
    }
    paramBaseData1 = (LinkData)paramBaseData2;
    this.a.setText(Html.fromHtml(paramBaseData1.a));
  }
  
  public void onClick(View paramView)
  {
    paramView = (LinkData)this.g;
    ReadInJoyUtils.a(this.a.getContext(), paramView.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.item.WebFastLinkViewCreator.TextViewHolder
 * JD-Core Version:    0.7.0.1
 */