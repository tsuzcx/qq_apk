package com.tencent.mobileqq.colornote.settings;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.colornote.data.IColorNoteHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class HistoryFormItem$1
  implements View.OnClickListener
{
  HistoryFormItem$1(HistoryFormItem paramHistoryFormItem) {}
  
  public void onClick(View paramView)
  {
    int i;
    if (((IColorNoteHelper)MobileQQ.getMobileQQ().waitAppRuntime(null).getRuntimeService(IColorNoteHelper.class, "all")).canAddColorNote())
    {
      i = 1;
    }
    else
    {
      ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).showFullDialog(paramView.getContext());
      i = 0;
    }
    if ((i != 0) && (this.a.a()))
    {
      HistoryFormItem localHistoryFormItem = this.a;
      HistoryFormItem.a(localHistoryFormItem, true ^ HistoryFormItem.a(localHistoryFormItem));
      localHistoryFormItem = this.a;
      localHistoryFormItem.a(paramView, HistoryFormItem.a(localHistoryFormItem));
      if (HistoryFormItem.a(this.a) != null) {
        HistoryFormItem.a(this.a).a(paramView, HistoryFormItem.a(this.a), HistoryFormItem.a(this.a));
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.settings.HistoryFormItem.1
 * JD-Core Version:    0.7.0.1
 */