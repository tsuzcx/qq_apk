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
    PopupWindowWithMask localPopupWindowWithMask = new PopupWindowWithMask(this.a);
    View localView = LayoutInflater.from(this.a).inflate(2131625838, null, false);
    ImageView localImageView1 = (ImageView)localView.findViewById(2131429234);
    ImageView localImageView2 = (ImageView)localView.findViewById(2131428795);
    ImageView localImageView3 = (ImageView)localView.findViewById(2131428782);
    TextView localTextView1 = (TextView)localView.findViewById(2131430272);
    TextView localTextView2 = (TextView)localView.findViewById(2131431714);
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      localImageView1.setBackgroundColor(Color.parseColor("#0b1d35"));
      localImageView2.setImageResource(2130843367);
      localImageView3.setImageResource(2130843367);
      localTextView1.setBackgroundResource(2130847681);
    }
    else
    {
      localImageView1.setImageResource(2130839439);
      localImageView2.setImageResource(2130843368);
      localImageView3.setImageResource(2130843368);
      localTextView1.setBackgroundResource(2130843358);
    }
    localPopupWindowWithMask.setContentView(localView);
    localPopupWindowWithMask.setHeight(UIUtils.a(this.a, 96.0F));
    localPopupWindowWithMask.setWidth(UIUtils.a(this.a, 224.0F));
    localTextView1.setOnClickListener(new SearchWordHistoryEntryModel.2.1(this, localPopupWindowWithMask));
    localTextView2.setOnClickListener(new SearchWordHistoryEntryModel.2.2(this, localPopupWindowWithMask));
    localView.post(new SearchWordHistoryEntryModel.2.3(this, new int[2], localView, new int[2]));
    localPopupWindowWithMask.showAsDropDown(paramView, 0, 0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.SearchWordHistoryEntryModel.2
 * JD-Core Version:    0.7.0.1
 */