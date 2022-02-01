package com.tencent.mobileqq.search.fragment.searchentry;

import com.google.gson.Gson;
import com.tencent.mobileqq.search.fragment.searchresult.KDSearchResultHeader;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.Map;

final class SearchEntryFragmentFactory$1
  implements Runnable
{
  public void run()
  {
    Map localMap = KDSearchResultHeader.a();
    ReadInJoyHelper.a("KDSearchResultHeader", new Gson().toJson(localMap, new SearchEntryFragmentFactory.1.1(this).getType()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.searchentry.SearchEntryFragmentFactory.1
 * JD-Core Version:    0.7.0.1
 */