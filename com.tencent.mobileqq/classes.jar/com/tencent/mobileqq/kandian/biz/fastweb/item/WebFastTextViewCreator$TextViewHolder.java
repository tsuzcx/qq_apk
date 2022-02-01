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
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379920));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131363680);
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131380154);
    paramView.setOnLongClickListener(this);
  }
  
  private void a(TextData paramTextData)
  {
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    localTextView.setTextColor(localTextView.getResources().getColor(2131166921));
    if (paramTextData.jdField_b_of_type_Int == 3)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#999999"));
      return;
    }
    if (paramTextData.jdField_b_of_type_Int == 2)
    {
      if ((this.jdField_c_of_type_AndroidViewView.getLayoutParams() instanceof LinearLayout.LayoutParams))
      {
        paramTextData = new TextPaint();
        paramTextData.setTextSize(this.jdField_a_of_type_Float);
        double d2 = paramTextData.getFontMetrics().descent - paramTextData.getFontMetrics().ascent;
        double d1 = d2;
        if (d2 <= 0.0D) {
          d1 = this.jdField_a_of_type_Float;
        }
        paramTextData = (LinearLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
        d1 /= 2.0D;
        d2 = this.jdField_c_of_type_Int;
        Double.isNaN(d2);
        paramTextData.setMargins(0, (int)(d1 + 0.5D + d2), AIOUtils.b(12.0F, this.jdField_a_of_type_AndroidWidgetTextView.getResources()), 0);
      }
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    if (paramBaseData2.u != 1) {
      return;
    }
    paramBaseData1 = (TextData)paramBaseData2;
    if (this.jdField_a_of_type_Float > 0.0F) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_Float);
    }
    if ((this.d > 0) && (this.jdField_c_of_type_Int > 0))
    {
      this.jdField_c_of_type_Int = Utils.dp2px(Double.valueOf(this.jdField_c_of_type_Int).doubleValue());
      this.d = Utils.dp2px(Double.valueOf(this.d).doubleValue());
      this.jdField_a_of_type_AndroidViewView.setPadding(this.d, 0, this.d, 0);
      this.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, this.jdField_c_of_type_Int, 0, this.jdField_c_of_type_Int);
    }
    if (this.jdField_b_of_type_Float > 0.0F)
    {
      this.jdField_b_of_type_Float = Utils.dp2px(Double.valueOf(this.jdField_b_of_type_Float).doubleValue());
      this.jdField_a_of_type_AndroidWidgetTextView.setLineSpacing(this.jdField_b_of_type_Float, 1.0F);
    }
    if (this.jdField_b_of_type_Int != 0) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_b_of_type_Int);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramBaseData1.jdField_a_of_type_JavaLangCharSequence);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(paramBaseData1.jdField_a_of_type_Int);
    a(paramBaseData1);
  }
  
  public boolean onLongClick(View paramView)
  {
    new QQCustomMenu().a(0, HardCodeUtil.a(2131716362));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebOnItemClickListener.a(this);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.item.WebFastTextViewCreator.TextViewHolder
 * JD-Core Version:    0.7.0.1
 */