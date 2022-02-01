package com.tencent.mobileqq.kandian.biz.common.widget;

import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataFetchManager;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyListViewGroup$10
  extends ReadInJoyObserver
{
  ReadInJoyListViewGroup$10(ReadInJoyListViewGroup paramReadInJoyListViewGroup) {}
  
  public void e_(String paramString)
  {
    boolean bool = StudyModeManager.a();
    if (bool) {
      this.a.a.b(true, 3, false);
    }
    paramString = new StringBuilder();
    paramString.append("onRefreshArticles! isLearnModelNow=");
    paramString.append(bool);
    QLog.d("ReadInJoyListViewGroup", 1, paramString.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyListViewGroup.10
 * JD-Core Version:    0.7.0.1
 */