package com.tencent.mobileqq.kandian.biz.fastweb.item;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint.FontMetrics;
import android.text.TextPaint;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.fastweb.OnItemClickListener;
import com.tencent.mobileqq.kandian.biz.fastweb.data.TextData;
import com.tencent.mobileqq.kandian.biz.fastweb.entity.BaseItemViewHolder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;

class WebFastTextViewCreator$TextViewHolder
  extends BaseItemViewHolder
  implements View.OnLongClickListener
{
  private TextView a;
  private View b;
  private View c;
  
  public WebFastTextViewCreator$TextViewHolder(View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    this.a = ((TextView)paramView.findViewById(2131448801));
    this.b = paramView.findViewById(2131429593);
    this.c = paramView.findViewById(2131449070);
    paramView.setOnLongClickListener(this);
  }
  
  private void a(TextData paramTextData)
  {
    this.b.setVisibility(8);
    this.c.setVisibility(8);
    TextView localTextView = this.a;
    localTextView.setTextColor(localTextView.getResources().getColor(2131167842));
    if (paramTextData.c == 3)
    {
      this.b.setVisibility(0);
      this.a.setTextColor(Color.parseColor("#999999"));
      return;
    }
    if (paramTextData.c == 2)
    {
      if ((this.c.getLayoutParams() instanceof LinearLayout.LayoutParams))
      {
        paramTextData = new TextPaint();
        paramTextData.setTextSize(this.i);
        double d2 = paramTextData.getFontMetrics().descent - paramTextData.getFontMetrics().ascent;
        double d1 = d2;
        if (d2 <= 0.0D) {
          d1 = this.i;
        }
        paramTextData = (LinearLayout.LayoutParams)this.c.getLayoutParams();
        d1 /= 2.0D;
        d2 = this.l;
        Double.isNaN(d2);
        paramTextData.setMargins(0, (int)(d1 + 0.5D + d2), AIOUtils.b(12.0F, this.a.getResources()), 0);
      }
      this.c.setVisibility(0);
    }
  }
  
  public void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    if (paramBaseData2.aP != 1) {
      return;
    }
    paramBaseData1 = (TextData)paramBaseData2;
    if (this.i > 0.0F) {
      this.a.setTextSize(0, this.i);
    }
    if ((this.m > 0) && (this.l > 0))
    {
      this.l = Utils.dp2px(Double.valueOf(this.l).doubleValue());
      this.m = Utils.dp2px(Double.valueOf(this.m).doubleValue());
      this.f.setPadding(this.m, 0, this.m, 0);
      this.a.setPadding(0, this.l, 0, this.l);
    }
    if (this.j > 0.0F)
    {
      this.j = Utils.dp2px(Double.valueOf(this.j).doubleValue());
      this.a.setLineSpacing(this.j, 1.0F);
    }
    if (this.k != 0) {
      this.a.setTextColor(this.k);
    }
    this.a.setText(paramBaseData1.a);
    this.a.setGravity(paramBaseData1.b);
    a(paramBaseData1);
  }
  
  public boolean onLongClick(View paramView)
  {
    new QQCustomMenu().a(0, HardCodeUtil.a(2131913803));
    this.h.a(this);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.item.WebFastTextViewCreator.TextViewHolder
 * JD-Core Version:    0.7.0.1
 */