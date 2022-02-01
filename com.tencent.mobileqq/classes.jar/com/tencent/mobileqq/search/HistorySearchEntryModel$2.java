package com.tencent.mobileqq.search;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class HistorySearchEntryModel$2
  implements View.OnClickListener
{
  HistorySearchEntryModel$2(HistorySearchEntryModel paramHistorySearchEntryModel) {}
  
  public void onClick(View paramView)
  {
    long l = ((Long)paramView.getTag(-1)).longValue();
    Object localObject = this.a;
    int i = HistorySearchEntryModel.a((HistorySearchEntryModel)localObject, ((HistorySearchEntryModel)localObject).e, l);
    if (i != -1)
    {
      localObject = (SearchHistory)((IContactSearchable)this.a.e.get(i)).l();
      if (localObject != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(i);
        SearchUtils.a("home_page", "del_history", new String[] { localStringBuilder.toString() });
        ThreadManager.postImmediately(new HistorySearchEntryModel.2.1(this, (SearchHistory)localObject, l), null, true);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.HistorySearchEntryModel.2
 * JD-Core Version:    0.7.0.1
 */