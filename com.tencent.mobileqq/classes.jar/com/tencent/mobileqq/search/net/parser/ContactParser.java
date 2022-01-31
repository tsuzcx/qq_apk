package com.tencent.mobileqq.search.net.parser;

import com.tencent.mobileqq.activity.contact.addcontact.SearchResult;
import com.tencent.mobileqq.search.model.GroupNetSearchModelPeople;
import com.tencent.mobileqq.search.model.GroupNetSearchModelPeopleItem;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.util.SearchStatisticsConstants;
import com.tencent.pb.addcontacts.AccountSearchPb.hotwordrecord;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import java.util.List;

public class ContactParser
  extends BaseParser
{
  ISearchResultGroupModel a(SearchResult paramSearchResult, List paramList, String paramString1, boolean paramBoolean, String paramString2)
  {
    SearchStatisticsConstants.a(70);
    return new GroupNetSearchModelPeople(paramSearchResult, paramList, paramString1);
  }
  
  ISearchResultModel a(AccountSearchPb.hotwordrecord paramhotwordrecord, String paramString1, CharSequence paramCharSequence1, String paramString2, CharSequence paramCharSequence2)
  {
    return null;
  }
  
  ISearchResultModel a(AccountSearchPb.record paramrecord, String paramString, CharSequence paramCharSequence)
  {
    return new GroupNetSearchModelPeopleItem(paramrecord, paramString, paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.net.parser.ContactParser
 * JD-Core Version:    0.7.0.1
 */