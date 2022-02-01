package com.tencent.mobileqq.kandian.biz.feeds.controller;

import com.tencent.mobileqq.app.UniteSearchObserver;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel;
import com.tencent.mobileqq.search.model.SearchEntryDataModel;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class ReadInJoyFeedsHeaderViewController$2
  extends UniteSearchObserver
{
  ReadInJoyFeedsHeaderViewController$2(ReadInJoyFeedsHeaderViewController paramReadInJoyFeedsHeaderViewController) {}
  
  public void handleSearchDiscoveryError(int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleKandianSearchHotwordError, resultCode = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("， errorMsg = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", fromType = ");
      localStringBuilder.append(paramInt2);
      QLog.e("ReadInJoyFeedsHeaderVie", 2, localStringBuilder.toString());
    }
  }
  
  public void handleSearchDiscoveryResult(List<SearchEntryDataModel> paramList, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleKandianSearchHotwordResult, result = ");
      localStringBuilder.append(paramList);
      localStringBuilder.append(", fromType = ");
      localStringBuilder.append(paramInt);
      QLog.d("ReadInJoyFeedsHeaderVie", 2, localStringBuilder.toString());
    }
    if (paramInt != 6) {
      return;
    }
    if (((this.a.b == null) || (this.a.b.b == null) || (this.a.b.b.size() == 0)) && (paramList != null) && (paramList.size() > 0) && ((paramList.get(0) instanceof HotWordSearchEntryDataModel)))
    {
      this.a.b = ((HotWordSearchEntryDataModel)paramList.get(0));
      ReadInJoyFeedsHeaderViewController.e = 0;
      this.a.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyFeedsHeaderViewController.2
 * JD-Core Version:    0.7.0.1
 */