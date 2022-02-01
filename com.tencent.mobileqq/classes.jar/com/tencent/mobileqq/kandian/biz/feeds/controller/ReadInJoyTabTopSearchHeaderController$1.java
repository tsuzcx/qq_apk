package com.tencent.mobileqq.kandian.biz.feeds.controller;

import android.text.TextUtils;
import com.tencent.mobileqq.app.UniteSearchObserver;
import com.tencent.mobileqq.search.base.api.SearchEntryConfigManager;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel;
import com.tencent.mobileqq.search.model.SearchEntryDataModel;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class ReadInJoyTabTopSearchHeaderController$1
  extends UniteSearchObserver
{
  ReadInJoyTabTopSearchHeaderController$1(ReadInJoyTabTopSearchHeaderController paramReadInJoyTabTopSearchHeaderController) {}
  
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
      QLog.e("ReadInJoyTabTopSearchHeaderController", 2, localStringBuilder.toString());
    }
  }
  
  public void handleSearchDiscoveryResult(List<SearchEntryDataModel> paramList, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleKandianSearchHotwordResult, result = ");
      ((StringBuilder)localObject).append(paramList);
      ((StringBuilder)localObject).append(", fromType = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("ReadInJoyTabTopSearchHeaderController", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt != 10) {
      return;
    }
    Object localObject = SearchEntryConfigManager.c;
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        SearchEntryDataModel localSearchEntryDataModel = (SearchEntryDataModel)paramList.next();
        if (localSearchEntryDataModel.g == 1) {
          this.a.b = ((HotWordSearchEntryDataModel)localSearchEntryDataModel);
        }
        if ((localSearchEntryDataModel.g == 7) && (TextUtils.equals((CharSequence)localObject, "Recom_word"))) {
          this.a.b = ((HotWordSearchEntryDataModel)localSearchEntryDataModel);
        }
      }
      com.tencent.mobileqq.kandian.biz.search.entity.ReadInJoySearchWord.a = 0;
      this.a.a(true, -1, -1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyTabTopSearchHeaderController.1
 * JD-Core Version:    0.7.0.1
 */