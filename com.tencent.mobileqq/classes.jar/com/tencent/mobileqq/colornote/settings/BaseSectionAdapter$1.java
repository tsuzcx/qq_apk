package com.tencent.mobileqq.colornote.settings;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.colornote.api.impl.ColorNoteControllerImpl;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNoteUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class BaseSectionAdapter$1
  implements View.OnClickListener
{
  BaseSectionAdapter$1(BaseSectionAdapter paramBaseSectionAdapter, HistoryFormItem paramHistoryFormItem) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (ColorNote)BaseSectionAdapter.a(this.b).get(this.a.getIndex());
    Bundle localBundle = new Bundle();
    if ((BaseSectionAdapter.b(this.b) == 17104896) && ((((ColorNote)localObject).getServiceType() == 16908288) || (((ColorNote)localObject).getServiceType() == 16908290))) {
      localBundle.putBoolean("isFromFavourite", true);
    }
    ColorNoteControllerImpl.launch(paramView.getContext(), (ColorNote)localObject, localBundle);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getAllViews#onClick: index: ");
      ((StringBuilder)localObject).append(this.a.getIndex());
      QLog.d("BaseSectionAdapter", 2, ((StringBuilder)localObject).toString());
    }
    ReportController.b(null, "dc00898", "", "", "0X800AA7F", "0X800AA7F", ColorNoteUtils.d(BaseSectionAdapter.b(this.b)), 0, String.valueOf(this.a.getIndex() + 1), "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.settings.BaseSectionAdapter.1
 * JD-Core Version:    0.7.0.1
 */