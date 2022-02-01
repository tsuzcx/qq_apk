package com.tencent.mobileqq.colornote.settings;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.colornote.ColorNoteHelper;
import com.tencent.mobileqq.colornote.data.ColorNoteUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class HistoryFormItem$1
  implements View.OnClickListener
{
  HistoryFormItem$1(HistoryFormItem paramHistoryFormItem) {}
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    int i;
    HistoryFormItem localHistoryFormItem;
    if (ColorNoteHelper.a())
    {
      i = 1;
      if ((i != 0) && (this.a.a()))
      {
        localHistoryFormItem = this.a;
        if (HistoryFormItem.a(this.a)) {
          break label119;
        }
      }
    }
    for (;;)
    {
      HistoryFormItem.a(localHistoryFormItem, bool);
      this.a.a(paramView, HistoryFormItem.a(this.a));
      if (HistoryFormItem.a(this.a) != null) {
        HistoryFormItem.a(this.a).a(paramView, HistoryFormItem.a(this.a), HistoryFormItem.a(this.a));
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ColorNoteUtils.a(paramView.getContext());
      i = 0;
      break;
      label119:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.settings.HistoryFormItem.1
 * JD-Core Version:    0.7.0.1
 */