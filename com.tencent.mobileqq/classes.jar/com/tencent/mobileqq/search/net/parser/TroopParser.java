package com.tencent.mobileqq.search.net.parser;

import addcontacts.AccountSearchPb.hotwordrecord;
import addcontacts.AccountSearchPb.record;
import com.tencent.mobileqq.search.base.util.SearchStatisticsConstants;
import com.tencent.mobileqq.search.business.addcontact.model.SearchResult;
import com.tencent.mobileqq.search.model.GroupNetSearchModelTroop;
import com.tencent.mobileqq.search.model.GroupNetSearchModelTroopItem;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import java.util.List;

public class TroopParser
  extends BaseParser
{
  ISearchResultGroupModel a(SearchResult paramSearchResult, List<ISearchResultModel> paramList, String paramString1, boolean paramBoolean, String paramString2)
  {
    SearchStatisticsConstants.a(80);
    return new GroupNetSearchModelTroop(paramSearchResult, paramList, paramString1, paramBoolean);
  }
  
  ISearchResultModel a(AccountSearchPb.hotwordrecord paramhotwordrecord, String paramString1, CharSequence paramCharSequence1, String paramString2, CharSequence paramCharSequence2)
  {
    return null;
  }
  
  ISearchResultModel a(AccountSearchPb.record paramrecord, String paramString, CharSequence paramCharSequence)
  {
    return new GroupNetSearchModelTroopItem(paramrecord, paramString, paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.net.parser.TroopParser
 * JD-Core Version:    0.7.0.1
 */