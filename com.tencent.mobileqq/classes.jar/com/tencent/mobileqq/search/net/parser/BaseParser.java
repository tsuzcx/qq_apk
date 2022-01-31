package com.tencent.mobileqq.search.net.parser;

import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment;
import com.tencent.mobileqq.activity.contact.addcontact.SearchResult;
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
import com.tencent.mobileqq.search.model.GroupSearchModeTitle;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.pb.addcontacts.AccountSearchPb.hotwordrecord;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import com.tencent.pb.addcontacts.AccountSearchPb.search;
import com.tencent.pb.profilecard.SummaryCardBusiEntry.comm;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class BaseParser
  implements INetSearchResultParser
{
  abstract ISearchResultGroupModel a(SearchResult paramSearchResult, List paramList, String paramString1, boolean paramBoolean, String paramString2);
  
  abstract ISearchResultModel a(AccountSearchPb.hotwordrecord paramhotwordrecord, String paramString1, CharSequence paramCharSequence1, String paramString2, CharSequence paramCharSequence2);
  
  abstract ISearchResultModel a(AccountSearchPb.record paramrecord, String paramString, CharSequence paramCharSequence);
  
  public List a(Object... paramVarArgs)
  {
    boolean bool2 = false;
    if ((paramVarArgs == null) || (paramVarArgs.length < 3)) {
      return null;
    }
    if ((paramVarArgs[0] instanceof SummaryCardBusiEntry.comm)) {}
    label145:
    label315:
    Object localObject2;
    for (Object localObject1 = (SummaryCardBusiEntry.comm)paramVarArgs[0];; localObject2 = null)
    {
      if ((paramVarArgs[1] instanceof byte[])) {}
      for (Object localObject3 = (byte[])paramVarArgs[1];; localObject3 = null)
      {
        if ((paramVarArgs[2] instanceof String)) {}
        for (paramVarArgs = (String)paramVarArgs[2];; paramVarArgs = null)
        {
          Object localObject4;
          SearchResult localSearchResult;
          for (;;)
          {
            if ((localObject1 == null) || (localObject3 == null)) {
              break label750;
            }
            localObject4 = new AccountSearchPb.search();
            localSearchResult = new SearchResult();
            try
            {
              ((AccountSearchPb.search)localObject4).mergeFrom((byte[])localObject3);
              localSearchResult.jdField_a_of_type_Int = ((SummaryCardBusiEntry.comm)localObject1).service.get();
              localSearchResult.jdField_b_of_type_Int = ((AccountSearchPb.search)localObject4).start.get();
              if (((AccountSearchPb.search)localObject4).end.get() != 1) {
                break label588;
              }
              bool1 = true;
              localSearchResult.jdField_a_of_type_Boolean = bool1;
              localSearchResult.jdField_b_of_type_JavaUtilList = ((AccountSearchPb.search)localObject4).list.get();
              localSearchResult.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord = ((AccountSearchPb.hotwordrecord)((AccountSearchPb.search)localObject4).hotword_record.get());
              localSearchResult.jdField_a_of_type_JavaUtilList = ((AccountSearchPb.search)localObject4).highlight.get();
              localSearchResult.jdField_a_of_type_JavaLangString = ((AccountSearchPb.search)localObject4).article_more_url.get();
              if ((localSearchResult.jdField_b_of_type_JavaUtilList != null) && (localSearchResult.jdField_b_of_type_JavaUtilList.size() > 0))
              {
                if (localSearchResult.jdField_a_of_type_Int != 80000000) {
                  break label594;
                }
                localObject1 = ((AccountSearchPb.search)localObject4).list.get().iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  localObject3 = (AccountSearchPb.record)((Iterator)localObject1).next();
                  if (((AccountSearchPb.record)localObject3).sign.get() != null) {
                    ((AccountSearchPb.record)localObject3).richStatus = RichStatus.parseStatus(((AccountSearchPb.record)localObject3).sign.get().toByteArray());
                  }
                }
              }
              if (localSearchResult.jdField_b_of_type_JavaUtilList == null) {
                break;
              }
            }
            catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
            {
              localInvalidProtocolBufferMicroException.printStackTrace();
            }
          }
          int i;
          label509:
          AccountSearchPb.record localrecord;
          if (localSearchResult.jdField_b_of_type_JavaUtilList.size() != 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("search", 2, "recordList size " + localSearchResult.jdField_b_of_type_JavaUtilList.size());
            }
            new ArrayList().add(localSearchResult);
            localObject3 = new ArrayList(3);
            int j = localSearchResult.jdField_b_of_type_JavaUtilList.size();
            localObject4 = localSearchResult.jdField_a_of_type_JavaLangString;
            localObject2 = (AccountSearchPb.hotwordrecord)localSearchResult.jdField_a_of_type_ComTencentPbAddcontactsAccountSearchPb$hotwordrecord.get();
            if ((localObject2 != null) && (((AccountSearchPb.hotwordrecord)localObject2).hotword.has())) {
              ((List)localObject3).add(a((AccountSearchPb.hotwordrecord)localObject2, paramVarArgs, SearchUtils.a(((AccountSearchPb.hotwordrecord)localObject2).hotword.get(), (ArrayList)localSearchResult.jdField_a_of_type_JavaUtilList, 255), (String)localObject4, SearchUtils.a(((AccountSearchPb.hotwordrecord)localObject2).hotword_title.get(), (ArrayList)localSearchResult.jdField_a_of_type_JavaUtilList, 255)));
            }
            i = 0;
            if (i >= j) {
              break label663;
            }
            localrecord = (AccountSearchPb.record)localSearchResult.jdField_b_of_type_JavaUtilList.get(i);
            if (localSearchResult.jdField_a_of_type_Int != 80000003) {
              break label642;
            }
          }
          label642:
          for (localObject2 = SearchUtils.a(localrecord.name.get(), (ArrayList)localSearchResult.jdField_a_of_type_JavaUtilList, 255);; localObject2 = SearchBaseFragment.a(localrecord.name.get(), localSearchResult.jdField_a_of_type_JavaUtilList))
          {
            ((List)localObject3).add(a(localrecord, paramVarArgs, (CharSequence)localObject2));
            i += 1;
            break label509;
            label588:
            bool1 = false;
            break label145;
            label594:
            if ((localSearchResult.jdField_a_of_type_Int != 80000001) || (!((AccountSearchPb.search)localObject4).bool_location_group.has())) {
              break label315;
            }
            if (((AccountSearchPb.search)localObject4).bool_location_group.get()) {}
            for (i = 1;; i = 2)
            {
              localSearchResult.c = i;
              break label315;
              break;
            }
          }
          label663:
          boolean bool1 = bool2;
          if (localSearchResult.jdField_a_of_type_Int == 80000001) {
            if (localSearchResult.c != 2) {
              break label741;
            }
          }
          label741:
          for (bool1 = true;; bool1 = false)
          {
            localObject2 = new ArrayList(3);
            paramVarArgs = a(localSearchResult, (List)localObject3, paramVarArgs, bool1, (String)localObject4);
            ((List)localObject2).add(new GroupSearchModeTitle(paramVarArgs));
            ((List)localObject2).add(paramVarArgs);
            return localObject2;
          }
        }
        label750:
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.net.parser.BaseParser
 * JD-Core Version:    0.7.0.1
 */