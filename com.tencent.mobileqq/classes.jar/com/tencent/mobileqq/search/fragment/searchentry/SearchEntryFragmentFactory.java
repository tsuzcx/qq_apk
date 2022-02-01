package com.tencent.mobileqq.search.fragment.searchentry;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.search.fragment.SearchEntryFragment;
import com.tencent.mobileqq.search.fragment.searchentry.hippy.SearchEntryHippyEngine;

public class SearchEntryFragmentFactory
{
  public static final String KD_SEARCH_RESULT_HEADER = "KDSearchResultHeader";
  
  public static ISearchEntryFragment create(@NonNull String paramString)
  {
    
    if (("kSearchReadInJoyTab".equals(paramString)) && (SearchEntryHippyEngine.isHippyOn()) && (!SearchEntryHippyEngine.hippyError)) {
      return new SearchHippyEntryFragment();
    }
    SearchEntryHippyEngine.hippyError = false;
    return new SearchEntryFragment();
  }
  
  public static void preloadResultHeaderInfo()
  {
    ThreadManager.executeOnNetWorkThread(new SearchEntryFragmentFactory.1());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.searchentry.SearchEntryFragmentFactory
 * JD-Core Version:    0.7.0.1
 */