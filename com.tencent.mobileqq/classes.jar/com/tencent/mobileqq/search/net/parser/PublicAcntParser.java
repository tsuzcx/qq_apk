package com.tencent.mobileqq.search.net.parser;

import com.tencent.mobileqq.activity.contact.addcontact.SearchResult;
import com.tencent.mobileqq.search.model.GroupNetSearchModelPublicAcnt;
import com.tencent.mobileqq.search.model.GroupNetSearchModelPublicAcntItem;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.util.SearchStatisticsConstants;
import com.tencent.pb.addcontacts.AccountSearchPb.hotwordrecord;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import java.util.List;

public class PublicAcntParser
  extends BaseParser
{
  ISearchResultGroupModel a(SearchResult paramSearchResult, List<ISearchResultModel> paramList, String paramString1, boolean paramBoolean, String paramString2)
  {
    SearchStatisticsConstants.a(90);
    return new GroupNetSearchModelPublicAcnt(paramSearchResult, paramList, paramString1);
  }
  
  ISearchResultModel a(AccountSearchPb.hotwordrecord paramhotwordrecord, String paramString1, CharSequence paramCharSequence1, String paramString2, CharSequence paramCharSequence2)
  {
    return null;
  }
  
  ISearchResultModel a(AccountSearchPb.record paramrecord, String paramString, CharSequence paramCharSequence)
  {
    return new GroupNetSearchModelPublicAcntItem(paramrecord, paramString, paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.net.parser.PublicAcntParser
 * JD-Core Version:    0.7.0.1
 */