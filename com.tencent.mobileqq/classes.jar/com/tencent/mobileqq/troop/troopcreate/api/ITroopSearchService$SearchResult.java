package com.tencent.mobileqq.troop.troopcreate.api;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.troop.TroopInfo;

public class ITroopSearchService$SearchResult
  implements Comparable<SearchResult>
{
  public TroopInfo a;
  public int b;
  public String c;
  public int d;
  
  public int a(@NonNull SearchResult paramSearchResult)
  {
    int i = this.d;
    int j = paramSearchResult.d;
    if (i != j) {
      return i - j;
    }
    if (this.a.lastMsgTime != paramSearchResult.a.lastMsgTime) {
      return (int)(paramSearchResult.a.lastMsgTime - this.a.lastMsgTime);
    }
    if (paramSearchResult.a.troopCreateTime != this.a.troopCreateTime) {
      return (int)(paramSearchResult.a.troopCreateTime - this.a.troopCreateTime);
    }
    i = this.b;
    j = paramSearchResult.b;
    if (i != j) {
      return i - j;
    }
    return this.c.compareTo(paramSearchResult.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.api.ITroopSearchService.SearchResult
 * JD-Core Version:    0.7.0.1
 */