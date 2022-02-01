package com.tencent.mobileqq.search.net.parser;

import addcontacts.AccountSearchPb.hotwordrecord;
import addcontacts.AccountSearchPb.record;
import addcontacts.AccountSearchPb.search;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.search.business.addcontact.model.SearchResult;
import com.tencent.mobileqq.search.model.GroupSearchModeTitle;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.pb.profilecard.SummaryCardBusiEntry.comm;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class BaseParser
  implements INetSearchResultParser<ISearchResultGroupModel>
{
  abstract ISearchResultGroupModel a(SearchResult paramSearchResult, List<ISearchResultModel> paramList, String paramString1, boolean paramBoolean, String paramString2);
  
  abstract ISearchResultModel a(AccountSearchPb.hotwordrecord paramhotwordrecord, String paramString1, CharSequence paramCharSequence1, String paramString2, CharSequence paramCharSequence2);
  
  abstract ISearchResultModel a(AccountSearchPb.record paramrecord, String paramString, CharSequence paramCharSequence);
  
  public List<ISearchResultGroupModel> a(Object... paramVarArgs)
  {
    String str = null;
    Object localObject4 = str;
    Object localObject1;
    Object localObject3;
    SearchResult localSearchResult;
    if (paramVarArgs != null)
    {
      if (paramVarArgs.length < 3) {
        return null;
      }
      if ((paramVarArgs[0] instanceof SummaryCardBusiEntry.comm)) {
        localObject1 = (SummaryCardBusiEntry.comm)paramVarArgs[0];
      } else {
        localObject1 = null;
      }
      if ((paramVarArgs[1] instanceof byte[])) {
        localObject3 = (byte[])paramVarArgs[1];
      } else {
        localObject3 = null;
      }
      if ((paramVarArgs[2] instanceof String)) {
        paramVarArgs = (String)paramVarArgs[2];
      } else {
        paramVarArgs = null;
      }
      localObject4 = str;
      if (localObject1 != null)
      {
        if (localObject3 == null) {
          return null;
        }
        localObject4 = new AccountSearchPb.search();
        localSearchResult = new SearchResult();
      }
    }
    for (;;)
    {
      try
      {
        ((AccountSearchPb.search)localObject4).mergeFrom((byte[])localObject3);
        localSearchResult.a = ((SummaryCardBusiEntry.comm)localObject1).service.get();
        localSearchResult.b = ((AccountSearchPb.search)localObject4).start.get();
        if (((AccountSearchPb.search)localObject4).end.get() != 1) {
          break label816;
        }
        bool = true;
        localSearchResult.c = bool;
        localSearchResult.e = ((AccountSearchPb.search)localObject4).list.get();
        localSearchResult.f = ((AccountSearchPb.hotwordrecord)((AccountSearchPb.search)localObject4).hotword_record.get());
        localSearchResult.d = ((AccountSearchPb.search)localObject4).highlight.get();
        localSearchResult.g = ((AccountSearchPb.search)localObject4).article_more_url.get();
        localSearchResult.j = ((AccountSearchPb.search)localObject4).bool_keyword_suicide.get();
        localSearchResult.k = ((AccountSearchPb.search)localObject4).bool_exact_search.get();
        if ((localSearchResult.e != null) && (localSearchResult.e.size() > 0)) {
          if (localSearchResult.a == 80000000)
          {
            localObject1 = ((AccountSearchPb.search)localObject4).list.get().iterator();
            if (((Iterator)localObject1).hasNext())
            {
              localObject3 = (AccountSearchPb.record)((Iterator)localObject1).next();
              if (((AccountSearchPb.record)localObject3).sign.get() == null) {
                continue;
              }
              ((AccountSearchPb.record)localObject3).richStatus = RichStatus.parseStatus(((AccountSearchPb.record)localObject3).sign.get().toByteArray());
              continue;
            }
          }
          else if ((localSearchResult.a == 80000001) && (((AccountSearchPb.search)localObject4).bool_location_group.has()))
          {
            if (!((AccountSearchPb.search)localObject4).bool_location_group.get()) {
              break label822;
            }
            i = 1;
            localSearchResult.h = i;
          }
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
      localObject4 = str;
      if (localSearchResult.e != null)
      {
        if (localSearchResult.e.size() == 0) {
          return null;
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("recordList size ");
          ((StringBuilder)localObject2).append(localSearchResult.e.size());
          QLog.d("search", 2, ((StringBuilder)localObject2).toString());
        }
        new ArrayList().add(localSearchResult);
        localObject3 = new ArrayList(3);
        int j = localSearchResult.e.size();
        str = localSearchResult.g;
        Object localObject2 = (AccountSearchPb.hotwordrecord)localSearchResult.f.get();
        if ((localObject2 != null) && (((AccountSearchPb.hotwordrecord)localObject2).hotword.has())) {
          ((List)localObject3).add(a((AccountSearchPb.hotwordrecord)localObject2, paramVarArgs, SearchUtils.a(((AccountSearchPb.hotwordrecord)localObject2).hotword.get(), (ArrayList)localSearchResult.d, 255), str, SearchUtils.a(((AccountSearchPb.hotwordrecord)localObject2).hotword_title.get(), (ArrayList)localSearchResult.d, 255)));
        }
        i = 0;
        while (i < j)
        {
          localObject4 = (AccountSearchPb.record)localSearchResult.e.get(i);
          if (localSearchResult.a == 80000003) {
            localObject2 = SearchUtils.a(((AccountSearchPb.record)localObject4).name.get(), (ArrayList)localSearchResult.d, 255);
          } else {
            localObject2 = SearchBaseFragment.a(((AccountSearchPb.record)localObject4).name.get(), localSearchResult.d);
          }
          ((List)localObject3).add(a((AccountSearchPb.record)localObject4, paramVarArgs, (CharSequence)localObject2));
          i += 1;
        }
        if (localSearchResult.a == 80000001)
        {
          if (localSearchResult.h == 2) {
            bool = true;
          } else {
            bool = false;
          }
        }
        else {
          bool = false;
        }
        localObject4 = new ArrayList(3);
        paramVarArgs = a(localSearchResult, (List)localObject3, paramVarArgs, bool, str);
        ((List)localObject4).add(new GroupSearchModeTitle(paramVarArgs));
        ((List)localObject4).add(paramVarArgs);
      }
      return localObject4;
      label816:
      boolean bool = false;
      continue;
      label822:
      int i = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.net.parser.BaseParser
 * JD-Core Version:    0.7.0.1
 */