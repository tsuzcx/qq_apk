package com.tencent.mobileqq.search.fragment.searchentry.hotword;

import android.support.annotation.NonNull;
import com.google.gson.Gson;
import java.util.List;

public class SearchFEHotwordItems
{
  private final List<SmartBox_HotWordsItem> items;
  
  public SearchFEHotwordItems(@NonNull List<SmartBox_HotWordsItem> paramList)
  {
    this.items = paramList;
  }
  
  @NonNull
  public String getJsonArrayStr()
  {
    try
    {
      String str = new Gson().toJson(this.items);
      return str;
    }
    catch (Exception localException)
    {
      label17:
      break label17;
    }
    return "[]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.searchentry.hotword.SearchFEHotwordItems
 * JD-Core Version:    0.7.0.1
 */