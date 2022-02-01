package com.tencent.mobileqq.search;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.PopupWindowWithMask;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SearchWordHistoryEntryModel$2
  implements View.OnClickListener
{
  SearchWordHistoryEntryModel$2(SearchWordHistoryEntryModel paramSearchWordHistoryEntryModel, Context paramContext, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(View paramView)
  {
    PopupWindowWithMask localPopupWindowWithMask = new PopupWindowWithMask(this.jdField_a_of_type_AndroidContentContext);
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559795, null, false);
    ImageView localImageView1 = (ImageView)localView.findViewById(2131363349);
    ImageView localImageView2 = (ImageView)localView.findViewById(2131362993);
    ImageView localImageView3 = (ImageView)localView.findViewById(2131362981);
    TextView localTextView1 = (TextView)localView.findViewById(2131364259);
    TextView localTextView2 = (TextView)localView.findViewById(2131365499);
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      localImageView1.setBackgroundColor(Color.parseColor("#0b1d35"));
      localImageView2.setImageResource(2130842414);
      localImageView3.setImageResource(2130842414);
      localTextView1.setBackgroundResource(2130846211);
    }
    else
    {
      localImageView1.setImageResource(2130839263);
      localImageView2.setImageResource(2130842415);
      localImageView3.setImageResource(2130842415);
      localTextView1.setBackgroundResource(2130842405);
    }
    localPopupWindowWithMask.setContentView(localView);
    localPopupWindowWithMask.setHeight(UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 96.0F));
    localPopupWindowWithMask.setWidth(UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 224.0F));
    localTextView1.setOnClickListener(new SearchWordHistoryEntryModel.2.1(this, localPopupWindowWithMask));
    localTextView2.setOnClickListener(new SearchWordHistoryEntryModel.2.2(this, localPopupWindowWithMask));
    localView.post(new SearchWordHistoryEntryModel.2.3(this, new int[2], localView, new int[2]));
    localPopupWindowWithMask.showAsDropDown(paramView, 0, 0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.SearchWordHistoryEntryModel.2
 * JD-Core Version:    0.7.0.1
 */