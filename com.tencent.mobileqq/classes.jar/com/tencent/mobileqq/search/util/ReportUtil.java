package com.tencent.mobileqq.search.util;

import addcontacts.AccountSearchPb.record;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.search.business.addcontact.model.SearchResult;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModel;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.model.PublicAccountSearchResultModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReportUtil
{
  public static int a;
  public static String a;
  public static long[] a;
  public static String b;
  
  public static int a(ArrayList<SearchResult> paramArrayList, String paramString)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return 2;
      }
      Iterator localIterator1 = paramArrayList.iterator();
      paramArrayList = "";
      int i = 2;
      while (localIterator1.hasNext())
      {
        Object localObject1 = (SearchResult)localIterator1.next();
        if (localObject1 != null)
        {
          int j = i;
          if (((SearchResult)localObject1).jdField_a_of_type_Int == 80000001)
          {
            j = i;
            if (((SearchResult)localObject1).b != null)
            {
              j = i;
              if (((SearchResult)localObject1).b.size() > 0)
              {
                Iterator localIterator2 = ((SearchResult)localObject1).b.iterator();
                for (;;)
                {
                  j = i;
                  if (!localIterator2.hasNext()) {
                    break;
                  }
                  Object localObject2 = (AccountSearchPb.record)localIterator2.next();
                  if (localObject2 != null)
                  {
                    localObject2 = String.valueOf(((AccountSearchPb.record)localObject2).code.get());
                    if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).equals(paramString))) {
                      i = 1;
                    } else {
                      i = 2;
                    }
                    SearchUtils.a("add_page", "all_result", "exp_grp", 0, i, new String[] { localObject2, "", paramString, "" });
                  }
                }
              }
            }
          }
          switch (((SearchResult)localObject1).jdField_a_of_type_Int)
          {
          default: 
            i = j;
            break;
          case 80000003: 
            if (TextUtils.isEmpty(paramArrayList))
            {
              paramArrayList = "4";
              i = j;
            }
            else
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(paramArrayList);
              ((StringBuilder)localObject1).append("::4");
              paramArrayList = ((StringBuilder)localObject1).toString();
              i = j;
            }
            break;
          case 80000002: 
            if (TextUtils.isEmpty(paramArrayList))
            {
              paramArrayList = "3";
              i = j;
            }
            else
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(paramArrayList);
              ((StringBuilder)localObject1).append("::3");
              paramArrayList = ((StringBuilder)localObject1).toString();
              i = j;
            }
            break;
          case 80000001: 
            if (TextUtils.isEmpty(paramArrayList))
            {
              paramArrayList = "2";
              i = j;
            }
            else
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(paramArrayList);
              ((StringBuilder)localObject1).append("::2");
              paramArrayList = ((StringBuilder)localObject1).toString();
              i = j;
            }
            break;
          case 80000000: 
            if (TextUtils.isEmpty(paramArrayList))
            {
              paramArrayList = "1";
              i = j;
            }
            else
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(paramArrayList);
              ((StringBuilder)localObject1).append("::1");
              paramArrayList = ((StringBuilder)localObject1).toString();
              i = j;
            }
            break;
          }
        }
      }
      SearchUtils.a("add_page", "all_result", "exp", 0, i, new String[] { "", paramArrayList, paramString, "" });
      return i;
    }
    return 2;
  }
  
  public static int a(List<ISearchResultModel> paramList, String paramString)
  {
    int j = 2;
    int i = j;
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return 2;
      }
      paramList = paramList.iterator();
      Object localObject;
      do
      {
        do
        {
          i = j;
          if (!paramList.hasNext()) {
            break;
          }
          localObject = (ISearchResultModel)paramList.next();
        } while (!(localObject instanceof GroupBaseNetSearchModelItem));
        localObject = (GroupBaseNetSearchModelItem)localObject;
      } while ((((GroupBaseNetSearchModelItem)localObject).d() != 1002) || (TextUtils.isEmpty(paramString)) || (!paramString.equals(((GroupBaseNetSearchModelItem)localObject).a())));
      i = 1;
    }
    return i;
  }
  
  public static String a(List<ISearchResultModel> paramList, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      int i = Math.min(paramList.size(), paramInt);
      if (i <= 0) {
        return localStringBuilder.toString();
      }
      paramInt = 0;
      while (paramInt < i)
      {
        ISearchResultModel localISearchResultModel = (ISearchResultModel)paramList.get(paramInt);
        if (localISearchResultModel != null)
        {
          String str = null;
          if ((localISearchResultModel instanceof GroupBaseNetSearchModelItem)) {
            str = ((GroupBaseNetSearchModelItem)localISearchResultModel).b;
          } else if ((localISearchResultModel instanceof PublicAccountSearchResultModel)) {
            str = ((PublicAccountSearchResultModel)localISearchResultModel).a();
          }
          if (!TextUtils.isEmpty(str))
          {
            if (localStringBuilder.length() != 0) {
              localStringBuilder.append("，");
            }
            localStringBuilder.append(str);
          }
        }
        paramInt += 1;
      }
      return localStringBuilder.toString();
    }
    return localStringBuilder.toString();
  }
  
  public static void a()
  {
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_ArrayOfLong = null;
    jdField_a_of_type_JavaLangString = null;
    b = null;
  }
  
  public static void a(int paramInt, long[] paramArrayOfLong, String paramString1, String paramString2)
  {
    jdField_a_of_type_Int = paramInt;
    jdField_a_of_type_ArrayOfLong = paramArrayOfLong;
    jdField_a_of_type_JavaLangString = paramString1;
    b = paramString2;
  }
  
  public static void a(GroupBaseNetSearchModelItem paramGroupBaseNetSearchModelItem)
  {
    if (paramGroupBaseNetSearchModelItem != null)
    {
      if (paramGroupBaseNetSearchModelItem.d() != 1002) {
        return;
      }
      String str1 = paramGroupBaseNetSearchModelItem.b();
      String str2 = paramGroupBaseNetSearchModelItem.a();
      String str3 = paramGroupBaseNetSearchModelItem.d();
      int i = paramGroupBaseNetSearchModelItem.k;
      paramGroupBaseNetSearchModelItem = new StringBuilder();
      paramGroupBaseNetSearchModelItem.append(i + 1);
      paramGroupBaseNetSearchModelItem.append("");
      paramGroupBaseNetSearchModelItem = paramGroupBaseNetSearchModelItem.toString();
      if ((!TextUtils.isEmpty(str1)) && (str1.equals(str2))) {
        i = 1;
      } else {
        i = 2;
      }
      long[] arrayOfLong = jdField_a_of_type_ArrayOfLong;
      if ((arrayOfLong != null) && (arrayOfLong.length == 2) && (arrayOfLong[0] == 1001L) && (arrayOfLong[1] == 1002L))
      {
        SearchUtils.a("all_search", "user_grp", "clk_grp", 0, i, new String[] { str2, paramGroupBaseNetSearchModelItem, str1, str3 });
        return;
      }
      if ((arrayOfLong != null) && (arrayOfLong.length == 1) && (arrayOfLong[0] == 1002L)) {
        SearchUtils.a("all_search", "more_grp", "clk_grp", 0, i, new String[] { str2, paramGroupBaseNetSearchModelItem, str1, str3 });
      }
    }
  }
  
  public static void a(List<ISearchResultModel> paramList, String paramString)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      long[] arrayOfLong = jdField_a_of_type_ArrayOfLong;
      if ((arrayOfLong != null) && (arrayOfLong.length == 2) && (arrayOfLong[0] == 1001L) && (arrayOfLong[1] == 1002L)) {
        SearchUtils.a("all_search", "user_grp", "clk_more_grp", 0, a(paramList, paramString), new String[] { "", "", paramString, "" });
      }
    }
  }
  
  public static void a(List<IModel> paramList, List<ISearchResultGroupModel> paramList1, boolean paramBoolean, long[] paramArrayOfLong, String paramString1, String paramString2)
  {
    if ((paramList1 != null) && (paramList1.size() > 0)) {
      paramString1 = "1";
    } else {
      paramString1 = "2";
    }
    int i;
    int j;
    if ((paramArrayOfLong != null) && (paramArrayOfLong.length == 2) && (paramArrayOfLong[0] == 1001L) && (paramArrayOfLong[1] == 1002L))
    {
      if (paramBoolean) {
        return;
      }
      if ((paramList1 != null) && (paramList1.size() > 0))
      {
        paramArrayOfLong = paramList1.iterator();
        paramList1 = "";
        for (i = 2; paramArrayOfLong.hasNext(); i = j)
        {
          paramString1 = (ISearchResultGroupModel)paramArrayOfLong.next();
          paramList = paramList1;
          j = i;
          if ((paramString1 instanceof GroupBaseNetSearchModel))
          {
            paramList = paramList1;
            j = i;
            if (paramString1.a() != null)
            {
              paramString1 = (GroupBaseNetSearchModel)paramString1;
              if (paramString1.a == 1001L)
              {
                if (TextUtils.isEmpty(paramList1))
                {
                  paramList = "1";
                  j = i;
                }
                else
                {
                  paramList = new StringBuilder();
                  paramList.append(paramList1);
                  paramList.append("::1");
                  paramList = paramList.toString();
                  j = i;
                }
              }
              else
              {
                paramList = paramList1;
                j = i;
                if (paramString1.a == 1002L)
                {
                  if (TextUtils.isEmpty(paramList1))
                  {
                    paramList = "2";
                  }
                  else
                  {
                    paramList = new StringBuilder();
                    paramList.append(paramList1);
                    paramList.append("::2");
                    paramList = paramList.toString();
                  }
                  paramList1 = paramString1.a();
                  j = a(paramList1, paramString2);
                  paramList1 = paramList1.iterator();
                  while (paramList1.hasNext())
                  {
                    paramString1 = (ISearchResultModel)paramList1.next();
                    if ((paramString1 instanceof GroupBaseNetSearchModelItem))
                    {
                      paramString1 = (GroupBaseNetSearchModelItem)paramString1;
                      if (paramString1.d() == 1002)
                      {
                        i = paramString1.k;
                        Object localObject = new StringBuilder();
                        ((StringBuilder)localObject).append(i + 1);
                        ((StringBuilder)localObject).append("");
                        localObject = ((StringBuilder)localObject).toString();
                        SearchUtils.a("all_search", "user_grp", "exp_grp", 0, j, new String[] { paramString1.a(), localObject, paramString2, paramString1.d() });
                      }
                    }
                  }
                }
              }
            }
          }
          paramList1 = paramList;
        }
      }
      else
      {
        paramList1 = "";
        i = 2;
      }
      SearchUtils.a("all_search", "user_grp", "exp", 0, i, new String[] { "", paramList1, paramString2, "" });
      return;
    }
    if ((paramArrayOfLong != null) && (paramArrayOfLong.length == 1) && (paramArrayOfLong[0] == 1002L))
    {
      if ((paramBoolean) && (paramList != null) && (!paramList.isEmpty()))
      {
        paramList = paramList.iterator();
        i = 0;
        for (;;)
        {
          j = i;
          if (!paramList.hasNext()) {
            break;
          }
          if (((IModel)paramList.next() instanceof GroupBaseNetSearchModelItem)) {
            i += 1;
          }
        }
      }
      j = 0;
      if ((paramList1 != null) && (paramList1.size() > 0))
      {
        paramList = paramList1.iterator();
        while (paramList.hasNext())
        {
          paramList1 = (ISearchResultGroupModel)paramList.next();
          if (((paramList1 instanceof GroupBaseNetSearchModel)) && (paramList1.a() != null))
          {
            paramList1 = (GroupBaseNetSearchModel)paramList1;
            if (paramList1.a == 1002L)
            {
              paramList = paramList1.a();
              i = a(paramList, paramString2);
              if (paramList != null)
              {
                paramList = paramList.iterator();
                while (paramList.hasNext())
                {
                  paramList1 = (ISearchResultModel)paramList.next();
                  if ((paramList1 instanceof GroupBaseNetSearchModelItem))
                  {
                    paramList1 = (GroupBaseNetSearchModelItem)paramList1;
                    if (paramList1.d() == 1002)
                    {
                      paramList1.k += j;
                      int k = paramList1.k;
                      paramArrayOfLong = new StringBuilder();
                      paramArrayOfLong.append(k + 1);
                      paramArrayOfLong.append("");
                      paramArrayOfLong = paramArrayOfLong.toString();
                      SearchUtils.a("all_search", "more_grp", "exp_grp", 0, i, new String[] { paramList1.a(), paramArrayOfLong, paramString2, paramList1.d() });
                    }
                  }
                }
              }
              break label785;
            }
          }
        }
      }
      i = 2;
      label785:
      if (paramBoolean)
      {
        SearchUtils.a("all_search", "more_grp", "load_more", 0, i, new String[] { paramString1, "", paramString2, "" });
        return;
      }
      SearchUtils.a("all_search", "more_grp", "exp", 0, i, new String[] { paramString1, "", paramString2, "" });
    }
  }
  
  public static void b(int paramInt, long[] paramArrayOfLong, String paramString1, String paramString2)
  {
    a(paramInt, paramArrayOfLong, paramString1, paramString2);
    if (paramInt == 2) {
      paramString1 = "2";
    } else {
      paramString1 = "1";
    }
    if ((paramArrayOfLong != null) && (paramArrayOfLong.length == 2) && (paramArrayOfLong[0] == 1001L) && (paramArrayOfLong[1] == 1002L))
    {
      SearchUtils.a("all_search", "user_grp", "search_cnt", 0, 0, new String[] { "", paramString1, paramString2, "" });
      return;
    }
    if ((paramArrayOfLong != null) && (paramArrayOfLong.length == 1) && (paramArrayOfLong[0] == 1002L)) {
      SearchUtils.a("all_search", "more_grp", "search_cnt", 0, 0, new String[] { "", paramString1, paramString2, "" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.util.ReportUtil
 * JD-Core Version:    0.7.0.1
 */