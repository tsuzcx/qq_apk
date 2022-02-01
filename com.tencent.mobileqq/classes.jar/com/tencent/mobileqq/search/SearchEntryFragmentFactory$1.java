package com.tencent.mobileqq.search;

import com.google.gson.Gson;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.search.api.IKDSearchResultHeader;
import com.tencent.mobileqq.qroute.QRoute;

final class SearchEntryFragmentFactory$1
  implements Runnable
{
  public void run()
  {
    Object localObject = ((IKDSearchResultHeader)QRoute.api(IKDSearchResultHeader.class)).handleForHeader();
    localObject = new Gson().toJson(localObject, new SearchEntryFragmentFactory.1.1(this).getType());
    ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).updateReadInJoySpValue("KDSearchResultHeader", localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.SearchEntryFragmentFactory.1
 * JD-Core Version:    0.7.0.1
 */