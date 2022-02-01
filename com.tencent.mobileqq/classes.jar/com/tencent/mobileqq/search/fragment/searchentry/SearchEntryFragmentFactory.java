package com.tencent.mobileqq.search.fragment.searchentry;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.search.fragment.SearchEntryFragment;
import com.tencent.mobileqq.search.fragment.searchentry.hippy.SearchEntryHippyEngine;

public class SearchEntryFragmentFactory
{
  public static ISearchEntryFragment create(@NonNull String paramString)
  {
    if (("kSearchReadInJoyTab".equals(paramString)) && (SearchEntryHippyEngine.isHippyOn()) && (!SearchEntryHippyEngine.hippyError)) {
      return new SearchHippyEntryFragment();
    }
    SearchEntryHippyEngine.hippyError = false;
    return new SearchEntryFragment();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.searchentry.SearchEntryFragmentFactory
 * JD-Core Version:    0.7.0.1
 */