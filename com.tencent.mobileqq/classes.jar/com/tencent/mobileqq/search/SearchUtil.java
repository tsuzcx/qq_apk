package com.tencent.mobileqq.search;

import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.filemanager.data.search.GroupSearchModelFileEntity;
import com.tencent.mobileqq.search.ftsmsg.FTSGroupSearchModelMessage;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModel;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.mobileqq.search.model.GroupSearchModeTitle;
import com.tencent.mobileqq.search.model.GroupSearchModelFooter;
import com.tencent.mobileqq.search.model.GroupSearchModelFunction;
import com.tencent.mobileqq.search.model.GroupSearchModelLocalContact;
import com.tencent.mobileqq.search.model.GroupSearchModelLocalContactApproximate;
import com.tencent.mobileqq.search.model.GroupSearchModelLocalTroop;
import com.tencent.mobileqq.search.model.GroupSearchModelMessage;
import com.tencent.mobileqq.search.model.GroupSearchModelMiniProgram;
import com.tencent.mobileqq.search.model.GroupSearchModelMostUsed;
import com.tencent.mobileqq.search.model.GroupSearchModelPublicAcnt;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.model.NetSearchTemplateBaseItem;
import com.tencent.mobileqq.search.model.SearchResultModelForEntrance;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.SearchViewUtils;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.globalsearch.GroupSearchModelFavorite;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.search.model.ISearchResultGroupModel;>;

public class SearchUtil
{
  public static long a;
  public static HashMap<ISearchResultModel, SearchUtil.ObjectItemInfo> a;
  public static boolean a;
  public static final HashMap<IModel, SearchUtil.ObjectItemInfo> b;
  public static boolean b;
  protected static final HashMap<String, Integer> c = new HashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Boolean = false;
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static int a(IModel paramIModel)
  {
    if (paramIModel == null) {
      return -1;
    }
    if (c.size() == 0)
    {
      c.put(GroupSearchModelLocalContact.class.getSimpleName(), Integer.valueOf(101));
      c.put(GroupSearchModelLocalTroop.class.getSimpleName(), Integer.valueOf(101));
      c.put(GroupSearchModelLocalContactApproximate.class.getSimpleName(), Integer.valueOf(101));
      c.put(FTSGroupSearchModelMessage.class.getSimpleName(), Integer.valueOf(102));
      c.put(GroupSearchModelMessage.class.getSimpleName(), Integer.valueOf(102));
      c.put(GroupSearchModelFavorite.class.getSimpleName(), Integer.valueOf(103));
      c.put(GroupSearchModelFileEntity.class.getSimpleName(), Integer.valueOf(104));
      c.put(GroupSearchModelFunction.class.getSimpleName(), Integer.valueOf(105));
      c.put(SearchResultModelForEntrance.class.getSimpleName(), Integer.valueOf(106));
      c.put(GroupSearchModelPublicAcnt.class.getSimpleName(), Integer.valueOf(107));
      c.put(GroupSearchModelMiniProgram.class.getSimpleName(), Integer.valueOf(108));
      c.put(GroupSearchModelMostUsed.class.getSimpleName(), Integer.valueOf(109));
    }
    Integer localInteger = (Integer)c.get(paramIModel.getClass().getSimpleName());
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
  
  public static List<IModel> a(List<ISearchResultGroupModel> paramList, boolean paramBoolean)
  {
    return a(paramList, paramBoolean, false, true);
  }
  
  public static List<IModel> a(List<ISearchResultGroupModel> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramList, paramBoolean1, paramBoolean2, false);
  }
  
  public static List<IModel> a(List<ISearchResultGroupModel> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
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
    localObject1 = "";
    Iterator localIterator = paramList.iterator();
    paramList = (List<ISearchResultGroupModel>)localObject1;
    label271:
    int i;
    if (localIterator.hasNext())
    {
      localObject1 = localIterator.next();
      if (!(localObject1 instanceof GroupBaseNetSearchModel)) {
        break label1026;
      }
      GroupBaseNetSearchModel localGroupBaseNetSearchModel = (GroupBaseNetSearchModel)localObject1;
      if (!TextUtils.isEmpty(paramList)) {
        break label1023;
      }
      paramList = localGroupBaseNetSearchModel.b();
      Object localObject5;
      if (paramBoolean3)
      {
        if (!paramBoolean1) {
          break label729;
        }
        if (SearchUtils.a(localGroupBaseNetSearchModel.jdField_a_of_type_Long))
        {
          ((List)localObject3).add(Long.valueOf(localGroupBaseNetSearchModel.jdField_a_of_type_Long));
          if (localGroupBaseNetSearchModel.a() != null)
          {
            i = 0;
            if (i < localGroupBaseNetSearchModel.a().size())
            {
              localObject5 = (ISearchResultModel)localGroupBaseNetSearchModel.a().get(i);
              SearchUtil.ObjectItemInfo localObjectItemInfo = new SearchUtil.ObjectItemInfo();
              localObjectItemInfo.jdField_a_of_type_JavaLangString = paramList;
              if ((localObject5 instanceof NetSearchTemplateBaseItem))
              {
                localObjectItemInfo.jdField_a_of_type_Long = ((NetSearchTemplateBaseItem)localObject5).jdField_a_of_type_Long;
                label385:
                localObjectItemInfo.jdField_a_of_type_Int = (i + 1);
                localObjectItemInfo.jdField_a_of_type_Boolean = false;
                localObject1 = "";
                if (!(localObject5 instanceof GroupBaseNetSearchModelItem)) {
                  break label516;
                }
                localObject1 = ((GroupBaseNetSearchModelItem)localObject5).jdField_b_of_type_JavaLangString;
              }
              for (;;)
              {
                localObjectItemInfo.jdField_b_of_type_JavaLangString = ((String)localObject1);
                localObjectItemInfo.jdField_b_of_type_Boolean = jdField_a_of_type_Boolean;
                jdField_a_of_type_JavaUtilHashMap.put(localObject5, localObjectItemInfo);
                if ((localObject5 instanceof GroupBaseNetSearchModelItem)) {
                  ((GroupBaseNetSearchModelItem)localObject5).e = localGroupBaseNetSearchModel.c;
                }
                i += 1;
                break;
                if ((localObject5 instanceof GroupBaseNetSearchModelItem))
                {
                  localObjectItemInfo.jdField_a_of_type_Long = ((GroupBaseNetSearchModelItem)localObject5).d();
                  break label385;
                }
                localObjectItemInfo.jdField_a_of_type_Long = localGroupBaseNetSearchModel.jdField_a_of_type_Long;
                break label385;
                label516:
                if ((localObject5 instanceof NetSearchTemplateBaseItem)) {
                  localObject1 = ((NetSearchTemplateBaseItem)localObject5).d;
                }
              }
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
        label590:
        label610:
        label636:
        int j;
        if (!TextUtils.isEmpty(localGroupBaseNetSearchModel.d()))
        {
          bool1 = true;
          boolean bool2 = localGroupBaseNetSearchModel.jdField_b_of_type_Boolean;
          if (TextUtils.isEmpty(localGroupBaseNetSearchModel.d)) {
            break label754;
          }
          paramBoolean2 = true;
          localObject5 = new GroupSearchModeTitle(localGroupBaseNetSearchModel, bool1, bool2);
          if (localGroupBaseNetSearchModel.jdField_a_of_type_Boolean) {
            break label759;
          }
          bool1 = true;
          ((GroupSearchModeTitle)localObject5).a(bool1);
          localArrayList1.add(localObject5);
          j = ((List)localObject1).size();
          i = 0;
          label665:
          if (i >= j) {
            break label847;
          }
          localObject5 = (ISearchResultModel)((List)localObject1).get(i);
          if (!(localObject5 instanceof GroupBaseNetSearchModelItem)) {
            break label765;
          }
          localObject5 = (GroupBaseNetSearchModelItem)localObject5;
          SearchViewUtils.a((ISearchResultModel)localObject5, j, i);
          localArrayList1.add(localObject5);
        }
        for (;;)
        {
          i += 1;
          break label665;
          label729:
          localArrayList2.add(Long.valueOf(localGroupBaseNetSearchModel.jdField_a_of_type_Long));
          break;
          bool1 = false;
          break label590;
          label754:
          paramBoolean2 = false;
          break label610;
          label759:
          bool1 = false;
          break label636;
          label765:
          if ((localObject5 instanceof NetSearchTemplateBaseItem))
          {
            localObject5 = (NetSearchTemplateBaseItem)localObject5;
            SearchViewUtils.a((ISearchResultModel)localObject5, j, i);
            localArrayList1.add(localObject5);
          }
          else if ((localObject5 instanceof SearchResultModelForEntrance))
          {
            localArrayList1.add((SearchResultModelForEntrance)localObject5);
          }
          else if ((localObject5 instanceof ISearchResultModel))
          {
            localArrayList1.add(localObject5);
          }
        }
        label847:
        if (!TextUtils.isEmpty(localGroupBaseNetSearchModel.d))
        {
          localObject1 = new GroupSearchModelFooter(localGroupBaseNetSearchModel.d, localGroupBaseNetSearchModel.e, localGroupBaseNetSearchModel.jdField_a_of_type_Long);
          ((GroupSearchModelFooter)localObject1).a(paramBoolean2);
          localArrayList1.add(localObject1);
        }
      }
    }
    label1026:
    for (;;)
    {
      break;
      if (((List)localObject4).size() > 0) {
        if (!jdField_b_of_type_Boolean) {
          break label1017;
        }
      }
      label1017:
      for (i = 2;; i = 1)
      {
        SearchUtils.a("all_result", "exp_content", i, 0, new String[] { paramList, SearchUtils.a((List)localObject4), "", SearchUtils.a("dynamic_unite_search.1", (List)localObject2) });
        if (localArrayList2.size() > 0) {
          SearchUtils.a("all_result", "load_content", new String[] { paramList, SearchUtils.a(localArrayList2), "", SearchUtils.a("dynamic_unite_search.1", (List)localObject2) });
        }
        jdField_a_of_type_Boolean = false;
        return localArrayList1;
      }
      label1023:
      break label271;
    }
  }
  
  public static List<Long> a(long[] paramArrayOfLong)
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
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.SearchUtil", 2, "clearCache");
    }
  }
  
  public static void a(TextView paramTextView)
  {
    float f = paramTextView.getResources().getDimensionPixelSize(2131298461) / paramTextView.getResources().getDisplayMetrics().densityDpi * FontSettingManager.systemMetrics.densityDpi;
    if (f > 0.0F) {
      paramTextView.setMaxWidth((int)f);
    }
  }
  
  public static boolean a(String paramString)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject != null) && (!TextUtils.isEmpty(paramString)))
    {
      localObject = (TroopRobotManager)((QQAppInterface)localObject).getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
      if ((localObject != null) && (((TroopRobotManager)localObject).b(paramString))) {
        return true;
      }
    }
    return false;
  }
  
  public static long[] a(List<Long> paramList)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.SearchUtil
 * JD-Core Version:    0.7.0.1
 */