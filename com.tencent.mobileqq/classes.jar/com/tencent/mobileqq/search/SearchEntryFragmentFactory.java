package com.tencent.mobileqq.search;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.search.fragment.SearchEntryFragment;
import com.tencent.mobileqq.search.fragment.searchentry.ISearchEntryFragment;
import com.tencent.mobileqq.search.fragment.searchentry.SearchHippyEntryFragment;
import com.tencent.mobileqq.search.fragment.searchentry.hippy.SearchEntryHippyEngine;

public class SearchEntryFragmentFactory
{
  public static ISearchEntryFragment a(@NonNull String paramString)
  {
    
    if (("kSearchReadInJoyTab".equals(paramString)) && (SearchEntryHippyEngine.isHippyOn()) && (!SearchEntryHippyEngine.hippyError)) {
      return new SearchHippyEntryFragment();
    }
    SearchEntryHippyEngine.hippyError = false;
    return new SearchEntryFragment();
  }
  
  public static void a()
  {
    ThreadManager.executeOnNetWorkThread(new SearchEntryFragmentFactory.1());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.SearchEntryFragmentFactory
 * JD-Core Version:    0.7.0.1
 */