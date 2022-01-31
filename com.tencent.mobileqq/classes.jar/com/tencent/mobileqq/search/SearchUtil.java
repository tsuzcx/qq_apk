package com.tencent.mobileqq.search;

import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.search.GroupSearchModelFileEntity;
import com.tencent.mobileqq.search.ftsmsg.FTSGroupSearchModelMessage;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModel;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.mobileqq.search.model.GroupSearchModeTitle;
import com.tencent.mobileqq.search.model.GroupSearchModelFooter;
import com.tencent.mobileqq.search.model.GroupSearchModelFunction;
import com.tencent.mobileqq.search.model.GroupSearchModelLocalContact;
import com.tencent.mobileqq.search.model.GroupSearchModelLocalContactApproximate;
import com.tencent.mobileqq.search.model.GroupSearchModelMessage;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.model.NetSearchTemplateBaseItem;
import com.tencent.mobileqq.search.model.SearchResultModelForEntrance;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.SearchViewUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.globalsearch.GroupSearchModelFavorite;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import pb.unite.search.DynamicSearch.SubItem;

public class SearchUtil
{
  public static long a;
  public static HashMap a;
  public static boolean a;
  public static HashMap b;
  public static boolean b;
  public static final HashMap c = new HashMap();
  protected static final HashMap d = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static int a(IModel paramIModel)
  {
    if (paramIModel == null) {
      return -1;
    }
    if (d.size() == 0)
    {
      d.put(GroupSearchModelLocalContact.class.getSimpleName(), Integer.valueOf(101));
      d.put(GroupSearchModelLocalContactApproximate.class.getSimpleName(), Integer.valueOf(101));
      d.put(FTSGroupSearchModelMessage.class.getSimpleName(), Integer.valueOf(102));
      d.put(GroupSearchModelMessage.class.getSimpleName(), Integer.valueOf(102));
      d.put(GroupSearchModelFavorite.class.getSimpleName(), Integer.valueOf(103));
      d.put(GroupSearchModelFileEntity.class.getSimpleName(), Integer.valueOf(104));
      d.put(GroupSearchModelFunction.class.getSimpleName(), Integer.valueOf(105));
      d.put(SearchResultModelForEntrance.class.getSimpleName(), Integer.valueOf(106));
    }
    Integer localInteger = (Integer)d.get(paramIModel.getClass().getSimpleName());
    if (localInteger == null) {
      return -1;
    }
    if ((paramIModel instanceof SearchResultModelForEntrance))
    {
      if (((SearchResultModelForEntrance)paramIModel).jdField_a_of_type_Int == -1) {
        return localInteger.intValue();
      }
      return -1;
    }
    return localInteger.intValue();
  }
  
  public static List a(List paramList, boolean paramBoolean)
  {
    return a(paramList, paramBoolean, false, true);
  }
  
  public static List a(List paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramList, paramBoolean1, paramBoolean2, false);
  }
  
  public static List a(List paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramList == null)
    {
      QLog.d("Q.uniteSearch.SearchUtil", 2, "getItemListFromGroupResult  result is null.");
      return null;
    }
    ArrayList localArrayList1 = new ArrayList();
    Object localObject3 = new HashMap();
    Object localObject2 = paramList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = ((Iterator)localObject2).next();
      if ((localObject1 instanceof GroupBaseNetSearchModel))
      {
        localObject4 = (GroupBaseNetSearchModel)localObject1;
        localObject1 = (Integer)((HashMap)localObject3).get(Long.valueOf(((GroupBaseNetSearchModel)localObject4).jdField_a_of_type_Long));
        if (localObject1 == null) {}
        for (localObject1 = Integer.valueOf(1);; localObject1 = Integer.valueOf(((Integer)localObject1).intValue() + 1))
        {
          ((HashMap)localObject3).put(Long.valueOf(((GroupBaseNetSearchModel)localObject4).jdField_a_of_type_Long), localObject1);
          break;
        }
      }
    }
    ((HashMap)localObject3).size();
    localObject2 = new ArrayList();
    ((List)localObject2).addAll(((HashMap)localObject3).keySet());
    Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    localObject3 = new ArrayList();
    Object localObject4 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    jdField_a_of_type_JavaUtilHashMap.clear();
    jdField_b_of_type_JavaUtilHashMap.clear();
    localObject1 = "";
    Iterator localIterator = paramList.iterator();
    paramList = (List)localObject1;
    label277:
    int i;
    if (localIterator.hasNext())
    {
      localObject1 = localIterator.next();
      if (!(localObject1 instanceof GroupBaseNetSearchModel)) {
        break label1253;
      }
      GroupBaseNetSearchModel localGroupBaseNetSearchModel = (GroupBaseNetSearchModel)localObject1;
      if (!TextUtils.isEmpty(paramList)) {
        break label1250;
      }
      paramList = localGroupBaseNetSearchModel.b();
      Object localObject5;
      if (paramBoolean3)
      {
        if (!paramBoolean1) {
          break label936;
        }
        if (SearchUtils.a(localGroupBaseNetSearchModel.jdField_a_of_type_Long))
        {
          ((List)localObject3).add(Long.valueOf(localGroupBaseNetSearchModel.jdField_a_of_type_Long));
          if (localGroupBaseNetSearchModel.a() != null)
          {
            i = 0;
            while (i < localGroupBaseNetSearchModel.a().size())
            {
              localObject5 = (ISearchResultModel)localGroupBaseNetSearchModel.a().get(i);
              Object localObject6 = new SearchUtil.ObjectItemInfo();
              ((SearchUtil.ObjectItemInfo)localObject6).jdField_a_of_type_JavaLangString = paramList;
              if ((localObject5 instanceof NetSearchTemplateBaseItem))
              {
                ((SearchUtil.ObjectItemInfo)localObject6).jdField_a_of_type_Long = ((NetSearchTemplateBaseItem)localObject5).jdField_a_of_type_Long;
                ((SearchUtil.ObjectItemInfo)localObject6).jdField_a_of_type_Int = (i + 1);
                ((SearchUtil.ObjectItemInfo)localObject6).jdField_a_of_type_Boolean = false;
                localObject1 = "";
                if (!(localObject5 instanceof GroupBaseNetSearchModelItem)) {
                  break label593;
                }
                localObject1 = ((GroupBaseNetSearchModelItem)localObject5).jdField_b_of_type_JavaLangString;
              }
              SearchUtil.SubItemInfo localSubItemInfo;
              for (;;)
              {
                ((SearchUtil.ObjectItemInfo)localObject6).jdField_b_of_type_JavaLangString = ((String)localObject1);
                ((SearchUtil.ObjectItemInfo)localObject6).jdField_b_of_type_Boolean = jdField_a_of_type_Boolean;
                jdField_a_of_type_JavaUtilHashMap.put(localObject5, localObject6);
                if ((!(localObject5 instanceof NetSearchTemplateBaseItem)) || (((NetSearchTemplateBaseItem)localObject5).c == null)) {
                  break label614;
                }
                localObject1 = ((NetSearchTemplateBaseItem)localObject5).c.iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  localObject6 = (DynamicSearch.SubItem)((Iterator)localObject1).next();
                  localSubItemInfo = new SearchUtil.SubItemInfo();
                  localSubItemInfo.jdField_a_of_type_JavaLangString = paramList;
                  localSubItemInfo.jdField_a_of_type_Long = localGroupBaseNetSearchModel.jdField_a_of_type_Long;
                  localSubItemInfo.jdField_a_of_type_Boolean = false;
                  jdField_b_of_type_JavaUtilHashMap.put(localObject6, localSubItemInfo);
                }
                if ((localObject5 instanceof GroupBaseNetSearchModelItem))
                {
                  ((SearchUtil.ObjectItemInfo)localObject6).jdField_a_of_type_Long = ((GroupBaseNetSearchModelItem)localObject5).b();
                  break;
                }
                ((SearchUtil.ObjectItemInfo)localObject6).jdField_a_of_type_Long = localGroupBaseNetSearchModel.jdField_a_of_type_Long;
                break;
                label593:
                if ((localObject5 instanceof NetSearchTemplateBaseItem)) {
                  localObject1 = ((NetSearchTemplateBaseItem)localObject5).d;
                }
              }
              label614:
              if ((localObject5 instanceof GroupBaseNetSearchModelItem))
              {
                if (((GroupBaseNetSearchModelItem)localObject5).jdField_b_of_type_JavaUtilList != null)
                {
                  localObject1 = ((GroupBaseNetSearchModelItem)localObject5).jdField_b_of_type_JavaUtilList.iterator();
                  while (((Iterator)localObject1).hasNext())
                  {
                    localObject6 = (DynamicSearch.SubItem)((Iterator)localObject1).next();
                    localSubItemInfo = new SearchUtil.SubItemInfo();
                    localSubItemInfo.jdField_a_of_type_JavaLangString = paramList;
                    localSubItemInfo.jdField_a_of_type_Long = localGroupBaseNetSearchModel.jdField_a_of_type_Long;
                    localSubItemInfo.jdField_a_of_type_Boolean = false;
                    jdField_b_of_type_JavaUtilHashMap.put(localObject6, localSubItemInfo);
                  }
                }
                ((GroupBaseNetSearchModelItem)localObject5).d = localGroupBaseNetSearchModel.c;
              }
              i += 1;
            }
          }
        }
        else
        {
          jdField_b_of_type_Boolean = jdField_a_of_type_Boolean;
          ((List)localObject4).add(Long.valueOf(localGroupBaseNetSearchModel.jdField_a_of_type_Long));
        }
      }
      localObject1 = localGroupBaseNetSearchModel.a();
      if (((List)localObject1).size() > 0)
      {
        boolean bool1;
        label790:
        label810:
        label836:
        int j;
        if (!TextUtils.isEmpty(localGroupBaseNetSearchModel.c()))
        {
          bool1 = true;
          boolean bool2 = localGroupBaseNetSearchModel.jdField_b_of_type_Boolean;
          if (TextUtils.isEmpty(localGroupBaseNetSearchModel.d)) {
            break label961;
          }
          paramBoolean2 = true;
          localObject5 = new GroupSearchModeTitle(localGroupBaseNetSearchModel, bool1, bool2);
          if (localGroupBaseNetSearchModel.jdField_a_of_type_Boolean) {
            break label966;
          }
          bool1 = true;
          ((GroupSearchModeTitle)localObject5).b(bool1);
          localArrayList1.add(localObject5);
          j = ((List)localObject1).size();
          i = 0;
          label865:
          if (i >= j) {
            break label1072;
          }
          localObject5 = (ISearchResultModel)((List)localObject1).get(i);
          if (!(localObject5 instanceof GroupBaseNetSearchModelItem)) {
            break label972;
          }
          localObject5 = (GroupBaseNetSearchModelItem)localObject5;
          SearchViewUtils.a((ISearchResultModel)localObject5, j, i);
          localArrayList1.add(localObject5);
          ((GroupBaseNetSearchModelItem)localObject5).a(localArrayList1);
        }
        for (;;)
        {
          i += 1;
          break label865;
          label936:
          localArrayList2.add(Long.valueOf(localGroupBaseNetSearchModel.jdField_a_of_type_Long));
          break;
          bool1 = false;
          break label790;
          label961:
          paramBoolean2 = false;
          break label810;
          label966:
          bool1 = false;
          break label836;
          label972:
          if ((localObject5 instanceof NetSearchTemplateBaseItem))
          {
            localObject5 = (NetSearchTemplateBaseItem)localObject5;
            SearchViewUtils.a((ISearchResultModel)localObject5, j, i);
            localArrayList1.add(localObject5);
            ((NetSearchTemplateBaseItem)localObject5).a(localArrayList1);
          }
          else if ((localObject5 instanceof SearchResultModelForEntrance))
          {
            localObject5 = (SearchResultModelForEntrance)localObject5;
            localArrayList1.add(localObject5);
            ((SearchResultModelForEntrance)localObject5).a(localArrayList1);
          }
          else if ((localObject5 instanceof ISearchResultModel))
          {
            localArrayList1.add(localObject5);
          }
        }
        label1072:
        if (!TextUtils.isEmpty(localGroupBaseNetSearchModel.d))
        {
          localObject1 = new GroupSearchModelFooter(localGroupBaseNetSearchModel.d, localGroupBaseNetSearchModel.e, localGroupBaseNetSearchModel.jdField_a_of_type_Long);
          ((GroupSearchModelFooter)localObject1).a(paramBoolean2);
          localArrayList1.add(localObject1);
        }
      }
    }
    label1244:
    label1250:
    label1253:
    for (;;)
    {
      break;
      if (((List)localObject4).size() > 0) {
        if (!jdField_b_of_type_Boolean) {
          break label1244;
        }
      }
      for (i = 2;; i = 1)
      {
        SearchUtils.a("all_result", "exp_content", i, 0, new String[] { paramList, SearchUtils.a((List)localObject4), "", SearchUtils.a("dynamic_unite_search.1", (List)localObject2) });
        if (localArrayList2.size() > 0) {
          SearchUtils.a("all_result", "load_content", new String[] { paramList, SearchUtils.a(localArrayList2), "", SearchUtils.a("dynamic_unite_search.1", (List)localObject2) });
        }
        jdField_a_of_type_Boolean = false;
        return localArrayList1;
      }
      break label277;
    }
  }
  
  public static List a(long[] paramArrayOfLong)
  {
    ArrayList localArrayList = new ArrayList(paramArrayOfLong.length);
    int i = 0;
    while (i < paramArrayOfLong.length)
    {
      localArrayList.add(Long.valueOf(paramArrayOfLong[i]));
      i += 1;
    }
    return localArrayList;
  }
  
  public static void a()
  {
    jdField_a_of_type_JavaUtilHashMap.clear();
    jdField_b_of_type_JavaUtilHashMap.clear();
    c.clear();
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.SearchUtil", 2, "clearCache");
    }
  }
  
  public static void a(TextView paramTextView)
  {
    float f = paramTextView.getResources().getDimensionPixelSize(2131559124) / paramTextView.getResources().getDisplayMetrics().densityDpi * FontSettingManager.a.densityDpi;
    if (f > 0.0F) {
      paramTextView.setMaxWidth((int)f);
    }
  }
  
  public static long[] a(List paramList)
  {
    long[] arrayOfLong = new long[paramList.size()];
    int i = 0;
    while (i < paramList.size())
    {
      arrayOfLong[i] = ((Long)paramList.get(i)).longValue();
      i += 1;
    }
    return arrayOfLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.SearchUtil
 * JD-Core Version:    0.7.0.1
 */