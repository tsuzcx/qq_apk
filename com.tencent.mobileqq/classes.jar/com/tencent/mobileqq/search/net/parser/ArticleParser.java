package com.tencent.mobileqq.search.net.parser;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.activity.contact.addcontact.SearchResult;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.model.GroupNetSearchModelArticle;
import com.tencent.mobileqq.search.model.GroupNetSearchModelArticleItem;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.util.SearchStatisticsConstants;
import com.tencent.pb.addcontacts.AccountSearchPb.hotwordrecord;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import java.util.List;

public class ArticleParser
  extends BaseParser
{
  String a = null;
  
  ISearchResultGroupModel a(SearchResult paramSearchResult, List<ISearchResultModel> paramList, String paramString1, boolean paramBoolean, String paramString2)
  {
    GroupNetSearchModelArticleItem localGroupNetSearchModelArticleItem;
    if (paramList != null)
    {
      localGroupNetSearchModelArticleItem = (GroupNetSearchModelArticleItem)paramList.get(0);
      if ((localGroupNetSearchModelArticleItem != null) && (localGroupNetSearchModelArticleItem.a() != null))
      {
        String str1 = localGroupNetSearchModelArticleItem.a().hotword.get();
        String str2 = localGroupNetSearchModelArticleItem.a();
        int i = localGroupNetSearchModelArticleItem.a().hotword_type.get();
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8006F74", "0X8006F74", 0, 0, str2, str1, String.valueOf(i), "");
      }
      if ((localGroupNetSearchModelArticleItem == null) || (localGroupNetSearchModelArticleItem.a() == null)) {
        break label194;
      }
    }
    for (;;)
    {
      if ((localGroupNetSearchModelArticleItem != null) && (localGroupNetSearchModelArticleItem.a() != null)) {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X8006535", "0X8006535", 0, 0, "", "", paramString1, String.valueOf(localGroupNetSearchModelArticleItem.a().account_id.get()));
      }
      SearchStatisticsConstants.a(110);
      this.a = paramString2;
      return new GroupNetSearchModelArticle(paramSearchResult, paramList, paramString1, paramString2);
      label194:
      if (paramList.size() > 1) {
        localGroupNetSearchModelArticleItem = (GroupNetSearchModelArticleItem)paramList.get(1);
      } else {
        localGroupNetSearchModelArticleItem = null;
      }
    }
  }
  
  ISearchResultModel a(AccountSearchPb.hotwordrecord paramhotwordrecord, String paramString1, CharSequence paramCharSequence1, String paramString2, CharSequence paramCharSequence2)
  {
    return new GroupNetSearchModelArticleItem(paramhotwordrecord, paramString1, paramCharSequence1, paramString2, paramCharSequence2);
  }
  
  ISearchResultModel a(AccountSearchPb.record paramrecord, String paramString, CharSequence paramCharSequence)
  {
    return new GroupNetSearchModelArticleItem(paramrecord, paramString, paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.net.parser.ArticleParser
 * JD-Core Version:    0.7.0.1
 */