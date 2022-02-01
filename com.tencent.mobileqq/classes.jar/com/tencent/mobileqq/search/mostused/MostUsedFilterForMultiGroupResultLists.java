package com.tencent.mobileqq.search.mostused;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.entry.MiniAppLocalSearchEntity;
import com.tencent.mobileqq.search.ftsmsg.FTSGroupSearchModelMessage;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModel;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.mobileqq.search.model.GroupSearchModeTitle;
import com.tencent.mobileqq.search.model.GroupSearchModelFooter;
import com.tencent.mobileqq.search.model.GroupSearchModelFunction;
import com.tencent.mobileqq.search.model.GroupSearchModelLocalContact;
import com.tencent.mobileqq.search.model.GroupSearchModelLocalTroop;
import com.tencent.mobileqq.search.model.GroupSearchModelMessage;
import com.tencent.mobileqq.search.model.GroupSearchModelMiniProgram;
import com.tencent.mobileqq.search.model.GroupSearchModelMostUsed;
import com.tencent.mobileqq.search.model.IContactSearchModel;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.model.MiniProgramSearchResultModel;
import com.tencent.mobileqq.search.model.NetSearchTemplateMiniAppItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateUniversalItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateUniversalItem.NormalWord;
import com.tencent.mobileqq.search.model.SearchResultModelForEntrance;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MostUsedFilterForMultiGroupResultLists
{
  public static int a = 3;
  
  public static int a(ISearchResultGroupModel paramISearchResultGroupModel)
  {
    int j = 1;
    int i;
    if ((paramISearchResultGroupModel instanceof GroupSearchModelMiniProgram)) {
      i = 2;
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while ((paramISearchResultGroupModel instanceof GroupSearchModelLocalContact));
      i = j;
    } while ((paramISearchResultGroupModel instanceof GroupSearchModelLocalTroop));
    if ((paramISearchResultGroupModel instanceof GroupSearchModelFunction)) {
      return 3;
    }
    return 0;
  }
  
  private static int a(MostUsedCache.MostUsedSearchItemModel paramMostUsedSearchItemModel, List<ISearchResultModel> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return -1;
    }
    int j = 0;
    while (j < paramList.size())
    {
      ISearchResultModel localISearchResultModel = (ISearchResultModel)paramList.get(j);
      String str = "";
      Object localObject;
      int i;
      if ((localISearchResultModel instanceof IContactSearchModel))
      {
        localObject = (IContactSearchModel)localISearchResultModel;
        if ((((IContactSearchModel)localObject).a() instanceof String)) {
          str = (String)((IContactSearchModel)localObject).a();
        }
        i = ((IContactSearchModel)localObject).e();
      }
      while ((str.equals(paramMostUsedSearchItemModel.jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.identify)) && (i == paramMostUsedSearchItemModel.jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.identifyType))
      {
        paramMostUsedSearchItemModel.jdField_a_of_type_Boolean = true;
        paramMostUsedSearchItemModel.jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultModel = localISearchResultModel;
        QLog.d("MostUsedFilterForMultiGroupResultListsMostUsedSearchResultManager", 2, "bEffective ");
        return j;
        if ((localISearchResultModel instanceof GroupBaseNetSearchModelItem))
        {
          localObject = (GroupBaseNetSearchModelItem)localISearchResultModel;
          str = ((GroupBaseNetSearchModelItem)localObject).e();
          i = ((GroupBaseNetSearchModelItem)localObject).e();
        }
        else
        {
          QLog.e("MostUsedFilterForMultiGroupResultListsMostUsedSearchResultManager", 2, "unknown type extends ISearchResultModel");
          i = -1;
        }
      }
      j += 1;
    }
    return -1;
  }
  
  private static ISearchResultGroupModel a(Object paramObject)
  {
    if ((paramObject instanceof GroupSearchModelMiniProgram))
    {
      paramObject = (GroupSearchModelMiniProgram)paramObject;
      return new GroupSearchModelMiniProgram(new ArrayList(paramObject.jdField_a_of_type_JavaUtilList), paramObject.b(), paramObject.b());
    }
    if ((paramObject instanceof GroupSearchModelLocalContact))
    {
      paramObject = (GroupSearchModelLocalContact)paramObject;
      return new GroupSearchModelLocalContact(new ArrayList(paramObject.jdField_a_of_type_JavaUtilList), paramObject.b(), paramObject.b());
    }
    if ((paramObject instanceof GroupSearchModelLocalTroop))
    {
      paramObject = (GroupSearchModelLocalTroop)paramObject;
      return new GroupSearchModelLocalTroop(new ArrayList(paramObject.jdField_a_of_type_JavaUtilList), paramObject.b(), paramObject.b());
    }
    if ((paramObject instanceof GroupSearchModelFunction))
    {
      paramObject = (GroupSearchModelFunction)paramObject;
      return new GroupSearchModelFunction(new ArrayList(paramObject.jdField_a_of_type_JavaUtilList), paramObject.b(), paramObject.b());
    }
    return null;
  }
  
  public static ArrayList a(String paramString, ArrayList<MostUsedCache.MostUsedSearchItemModel> paramArrayList, List paramList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return new ArrayList(paramList);
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    Object localObject2;
    if (i < paramList.size())
    {
      localObject1 = paramList.get(i);
      localObject2 = a(localObject1);
      if (localObject2 != null) {
        localArrayList.add(localObject2);
      }
      for (;;)
      {
        QLog.d("MostUsedFilterForMultiGroupResultListsMostUsed", 2, "the i name " + localArrayList.get(i).getClass().getName());
        i += 1;
        break;
        localArrayList.add(localObject1);
      }
    }
    Object localObject1 = new ArrayList();
    int j = 0;
    i = 0;
    int k;
    label161:
    boolean bool;
    if (j < paramArrayList.size())
    {
      localObject2 = (MostUsedCache.MostUsedSearchItemModel)paramArrayList.get(j);
      k = 0;
      if (k < localArrayList.size())
      {
        if ((localArrayList.get(k) instanceof ISearchResultGroupModel))
        {
          int m = a((ISearchResultGroupModel)localArrayList.get(k));
          if ((m == 0) || (((MostUsedCache.MostUsedSearchItemModel)localObject2).jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.businessType != m)) {
            break label465;
          }
          bool = a((MostUsedCache.MostUsedSearchItemModel)localObject2, (ISearchResultGroupModel)localArrayList.get(k));
          label234:
          if (!bool) {}
        }
      }
      else
      {
        if (((MostUsedCache.MostUsedSearchItemModel)localObject2).jdField_a_of_type_Boolean != true) {
          break label456;
        }
        if ((((MostUsedCache.MostUsedSearchItemModel)localObject2).jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultModel instanceof IContactSearchModel)) {
          ((IContactSearchModel)((MostUsedCache.MostUsedSearchItemModel)localObject2).jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultModel).a(((MostUsedCache.MostUsedSearchItemModel)localObject2).jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.searchKey);
        }
        if ((((MostUsedCache.MostUsedSearchItemModel)localObject2).jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultModel instanceof GroupBaseNetSearchModelItem)) {
          ((GroupBaseNetSearchModelItem)((MostUsedCache.MostUsedSearchItemModel)localObject2).jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultModel).a(((MostUsedCache.MostUsedSearchItemModel)localObject2).jdField_a_of_type_ComTencentMobileqqSearchMostusedMostUsedSearchItem.searchKey);
        }
        ((ArrayList)localObject1).add(((MostUsedCache.MostUsedSearchItemModel)localObject2).jdField_a_of_type_ComTencentMobileqqSearchModelISearchResultModel);
        k = i + 1;
        i = k;
        if (k != 3) {
          break label456;
        }
      }
    }
    for (;;)
    {
      a(localArrayList);
      if (k > 0)
      {
        paramString = new GroupSearchModelMostUsed((List)localObject1, paramString);
        localArrayList.add(0, paramString);
        localArrayList.add(0, new GroupSearchModeTitle(paramString, paramString.a(), false));
        QLog.d("MostUsedFilterForMultiGroupResultListsMostUsedSearchResultManager", 2, "add GroupSearchModelMostUsed");
      }
      QLog.d("MostUsedFilterForMultiGroupResultListsMostUsedSearchResultManager", 2, "the finish Wash orgList size " + paramList.size() + " match mostUsedList size" + paramArrayList.size() + " resultlist " + localArrayList.size());
      return localArrayList;
      k += 1;
      break label161;
      label456:
      j += 1;
      break;
      label465:
      bool = false;
      break label234;
      k = i;
    }
  }
  
  private static ArrayList<String> a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    Object localObject;
    do
    {
      if (!paramList.hasNext()) {
        break;
      }
      localObject = paramList.next();
    } while (!(localObject instanceof GroupSearchModelMostUsed));
    for (paramList = (GroupSearchModelMostUsed)localObject;; paramList = null)
    {
      if (paramList != null)
      {
        paramList = paramList.a();
        if ((paramList != null) && (paramList.size() > 0))
        {
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            localObject = (ISearchResultModel)paramList.next();
            if ((localObject != null) && ((localObject instanceof MiniProgramSearchResultModel)))
            {
              localObject = (MiniProgramSearchResultModel)localObject;
              if ((localObject != null) && (((MiniProgramSearchResultModel)localObject).a != null))
              {
                localObject = ((MiniProgramSearchResultModel)localObject).a.appId;
                if ((localObject != null) && (!TextUtils.isEmpty((CharSequence)localObject))) {
                  localArrayList.add(localObject);
                }
              }
            }
          }
        }
      }
      return localArrayList;
    }
  }
  
  private static void a(List paramList, int paramInt1, List<ISearchResultModel> paramList1, GroupBaseNetSearchModel paramGroupBaseNetSearchModel, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    if ((paramList == null) || (paramList1 == null) || (paramList1.size() == 0))
    {
      QLog.e("MostUsedFilterForMultiGroupResultLists", 2, " no list to add");
      return;
    }
    int i = paramInt1;
    if (paramList.size() < paramInt1)
    {
      i = paramList.size();
      QLog.e("MostUsedFilterForMultiGroupResultLists", 2, " INDEX OUT OF RANGE");
    }
    QLog.d("MostUsedFilterForMultiGroupResultLists", 2, "addListAndTitleToIndex " + paramList1.size());
    if ((paramInt2 > 0) && (paramList1.size() > paramInt2))
    {
      paramInt1 = paramList1.size() - 1;
      while (paramInt1 >= paramInt2)
      {
        paramList1.remove(paramInt1);
        paramInt1 -= 1;
      }
    }
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramGroupBaseNetSearchModel != null)
      {
        paramGroupBaseNetSearchModel = new GroupBaseNetSearchModel(paramGroupBaseNetSearchModel.b(), paramGroupBaseNetSearchModel.jdField_a_of_type_Long, paramGroupBaseNetSearchModel.a(), paramList1, paramList1.size(), paramGroupBaseNetSearchModel.d(), paramGroupBaseNetSearchModel.c(), paramGroupBaseNetSearchModel.jdField_b_of_type_JavaUtilList, paramGroupBaseNetSearchModel.jdField_a_of_type_Boolean, paramGroupBaseNetSearchModel.jdField_b_of_type_Boolean, paramGroupBaseNetSearchModel.c, paramGroupBaseNetSearchModel.d, paramGroupBaseNetSearchModel.e);
        if ((!paramBoolean1) || (paramInt1 == 0)) {
          break label303;
        }
        if (TextUtils.isEmpty(paramGroupBaseNetSearchModel.d())) {
          break label288;
        }
        paramBoolean1 = true;
      }
      for (;;)
      {
        if (paramList1.size() <= 0) {
          break label307;
        }
        paramInt1 = paramList1.size() - 1;
        while (paramInt1 >= 0)
        {
          paramList.add(i, paramList1.get(paramInt1));
          paramInt1 -= 1;
        }
        paramGroupBaseNetSearchModel = new GroupBaseNetSearchModel();
        paramGroupBaseNetSearchModel.jdField_a_of_type_JavaUtilList = paramList1;
        QLog.e("MostUsedFilterForMultiGroupResultLists", 2, "oldTitleGroupMode is empty");
        break;
        label288:
        paramBoolean1 = false;
        QLog.e("MostUsedFilterForMultiGroupResultLists", 2, "newModel.getMoreUrl() is empty");
        continue;
        label303:
        paramBoolean1 = false;
      }
      label307:
      break;
      paramList1 = new GroupSearchModeTitle(paramGroupBaseNetSearchModel, paramBoolean1, paramGroupBaseNetSearchModel.jdField_b_of_type_Boolean);
      if (paramBoolean2) {
        paramList1.jdField_b_of_type_Boolean = true;
      }
      paramList.add(i, paramList1);
      return;
    }
  }
  
  public static void a(List paramList, String paramString)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    ArrayList localArrayList5 = a(paramList);
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject2 = null;
    Object localObject1 = null;
    int i = paramList.size() - 1;
    Object localObject5;
    Object localObject3;
    if (i >= 0)
    {
      localObject5 = paramList.get(i);
      if ((localObject5 instanceof GroupSearchModeTitle))
      {
        localObject3 = ((GroupSearchModeTitle)localObject5).a();
        if (((localObject3 instanceof GroupBaseNetSearchModel)) && (((GroupBaseNetSearchModel)localObject3).jdField_a_of_type_Long == 1701L))
        {
          localObject3 = (GroupBaseNetSearchModel)localObject3;
          paramList.remove(i);
          localObject2 = localObject1;
          localObject1 = localObject3;
        }
      }
    }
    for (;;)
    {
      label148:
      localObject3 = localObject1;
      Object localObject4 = localObject2;
      for (;;)
      {
        i -= 1;
        localObject1 = localObject4;
        localObject2 = localObject3;
        break;
        if ((!(localObject3 instanceof GroupBaseNetSearchModel)) || (((GroupBaseNetSearchModel)localObject3).jdField_a_of_type_Long != 1003L)) {
          break label1020;
        }
        localObject3 = (GroupBaseNetSearchModel)localObject3;
        paramList.remove(i);
        localObject1 = localObject2;
        localObject2 = localObject3;
        break label148;
        if (((localObject5 instanceof GroupSearchModelFooter)) && ((((GroupSearchModelFooter)localObject5).jdField_a_of_type_Long == 1701L) || (((GroupSearchModelFooter)localObject5).jdField_a_of_type_Long == 1003L)))
        {
          paramList.remove(i);
          localObject4 = localObject1;
          localObject3 = localObject2;
        }
        else if ((localObject5 instanceof NetSearchTemplateMiniAppItem))
        {
          localObject5 = (NetSearchTemplateMiniAppItem)localObject5;
          localObject4 = localObject1;
          localObject3 = localObject2;
          if (((NetSearchTemplateMiniAppItem)localObject5).a != null)
          {
            localObject4 = localObject1;
            localObject3 = localObject2;
            if (((NetSearchTemplateMiniAppItem)localObject5).a.a != null)
            {
              String str = ((NetSearchTemplateMiniAppItem)localObject5).a.a.appId;
              paramList.remove(i);
              localObject4 = localObject1;
              localObject3 = localObject2;
              if (!a(str, localArrayList5)) {
                if (((NetSearchTemplateMiniAppItem)localObject5).jdField_b_of_type_Boolean)
                {
                  localArrayList3.add(0, localObject5);
                  localObject4 = localObject1;
                  localObject3 = localObject2;
                }
                else
                {
                  localArrayList4.add(0, localObject5);
                  localObject4 = localObject1;
                  localObject3 = localObject2;
                }
              }
            }
          }
        }
        else
        {
          localObject4 = localObject1;
          localObject3 = localObject2;
          if ((localObject5 instanceof NetSearchTemplateUniversalItem))
          {
            localObject5 = (NetSearchTemplateUniversalItem)localObject5;
            localObject4 = localObject1;
            localObject3 = localObject2;
            if (((NetSearchTemplateUniversalItem)localObject5).jdField_a_of_type_Long == 1003L)
            {
              paramList.remove(i);
              if ((a((NetSearchTemplateUniversalItem)localObject5, paramString)) && (localArrayList1.size() == 0))
              {
                ((NetSearchTemplateUniversalItem)localObject5).c = true;
                localArrayList1.add(0, localObject5);
                ReportController.b(null, "dc00898", "", "", "0X800AC11", "0X800AC11", 0, 0, "", "", "", "");
                localObject4 = localObject1;
                localObject3 = localObject2;
              }
              else
              {
                localArrayList2.add(0, localObject5);
                localObject4 = localObject1;
                localObject3 = localObject2;
              }
            }
          }
        }
      }
      int k = 0;
      i = 0;
      int j = 0;
      label568:
      if (k < paramList.size())
      {
        localObject3 = paramList.get(k);
        if (!(localObject3 instanceof GroupSearchModelMostUsed)) {
          break label1017;
        }
        j = k + 1;
      }
      label1008:
      label1017:
      for (;;)
      {
        if ((((localObject3 instanceof GroupSearchModelFunction)) && (a((GroupSearchModelFunction)localObject3, paramString))) || ((((localObject3 instanceof GroupSearchModelMostUsed)) || ((localObject3 instanceof GroupSearchModelLocalContact)) || ((localObject3 instanceof GroupSearchModelLocalTroop)) || ((localObject3 instanceof SearchResultModelForEntrance))) && (i <= k))) {
          i = k + 1;
        }
        for (;;)
        {
          k += 1;
          break label568;
          if (localArrayList3.size() > 0)
          {
            a(paramList, j, localArrayList3, localObject2, false, a, true);
            j = localArrayList3.size() + i + 1;
            if (paramList.size() >= j)
            {
              QLog.e("MostUsedFilterForMultiGroupResultLists", 2, "OUT OF INDEX OF MINI");
              i = j;
            }
          }
          for (;;)
          {
            if (localArrayList4.size() > 0) {
              a(paramList, i, localArrayList4, localObject2, true, a, false);
            }
            k = 0;
            i = 0;
            j = 0;
            label762:
            if (k < paramList.size())
            {
              localObject2 = paramList.get(k);
              if ((!(localObject2 instanceof GroupSearchModelMostUsed)) && ((!(localObject2 instanceof NetSearchTemplateMiniAppItem)) || (((NetSearchTemplateMiniAppItem)localObject2).jdField_b_of_type_Boolean != true)) && ((!(localObject2 instanceof GroupSearchModelFunction)) || (!a((GroupSearchModelFunction)localObject2, paramString)))) {
                break label1008;
              }
              j = k + 1;
            }
            for (;;)
            {
              if ((((localObject2 instanceof GroupSearchModelFunction)) || ((localObject2 instanceof GroupSearchModelMostUsed)) || ((localObject2 instanceof GroupSearchModelLocalContact)) || ((localObject2 instanceof GroupSearchModelLocalTroop)) || ((localObject2 instanceof SearchResultModelForEntrance)) || ((localObject2 instanceof NetSearchTemplateMiniAppItem)) || ((localObject2 instanceof GroupSearchModelMessage)) || ((localObject2 instanceof FTSGroupSearchModelMessage))) && (i <= k)) {
                i = k + 1;
              }
              for (;;)
              {
                k += 1;
                break label762;
                if (localArrayList1.size() > 0)
                {
                  a(paramList, j, localArrayList1, localObject1, false, a, true);
                  j = localArrayList1.size() + i + 1;
                  if (paramList.size() >= j)
                  {
                    QLog.e("MostUsedFilterForMultiGroupResultLists", 2, "OUT OF INDEX OF PUBLLIC");
                    i = j;
                  }
                }
                while (localArrayList2.size() > 0)
                {
                  a(paramList, i, localArrayList2, localObject1, true, a, false);
                  return;
                }
                break;
              }
            }
          }
        }
      }
      label1020:
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
  }
  
  private static boolean a(GroupSearchModelFunction paramGroupSearchModelFunction, String paramString)
  {
    return (paramGroupSearchModelFunction != null) && (paramGroupSearchModelFunction.jdField_a_of_type_JavaUtilList != null) && (paramGroupSearchModelFunction.jdField_a_of_type_JavaUtilList.size() > 0) && ((paramGroupSearchModelFunction.jdField_a_of_type_JavaUtilList.get(0) instanceof GroupBaseNetSearchModelItem)) && (((GroupBaseNetSearchModelItem)paramGroupSearchModelFunction.jdField_a_of_type_JavaUtilList.get(0)).c.equals(paramString));
  }
  
  private static boolean a(NetSearchTemplateUniversalItem paramNetSearchTemplateUniversalItem, String paramString)
  {
    if ((paramNetSearchTemplateUniversalItem == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    if ((paramNetSearchTemplateUniversalItem.jdField_a_of_type_JavaUtilArrayList != null) && (paramNetSearchTemplateUniversalItem.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      paramNetSearchTemplateUniversalItem = (NetSearchTemplateUniversalItem.NormalWord)paramNetSearchTemplateUniversalItem.jdField_a_of_type_JavaUtilArrayList.get(0);
      if ((paramNetSearchTemplateUniversalItem != null) && (paramNetSearchTemplateUniversalItem.a.toString().equalsIgnoreCase(paramString))) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean a(MostUsedCache.MostUsedSearchItemModel paramMostUsedSearchItemModel, ISearchResultGroupModel paramISearchResultGroupModel)
  {
    if (paramISearchResultGroupModel == null) {}
    int i;
    do
    {
      return false;
      i = a(paramMostUsedSearchItemModel, paramISearchResultGroupModel.a());
    } while (i < 0);
    paramISearchResultGroupModel.a().remove(i);
    return true;
  }
  
  public static boolean a(String paramString, ArrayList<String> paramArrayList)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramArrayList == null) || (paramArrayList.size() == 0)) {
      return false;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      if (paramString.equalsIgnoreCase((String)paramArrayList.next())) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(ArrayList paramArrayList)
  {
    boolean bool2;
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      bool2 = false;
    }
    int i;
    boolean bool1;
    do
    {
      return bool2;
      i = paramArrayList.size() - 1;
      bool1 = false;
      bool2 = bool1;
    } while (i < 0);
    ISearchResultGroupModel localISearchResultGroupModel;
    if ((paramArrayList.get(i) instanceof ISearchResultGroupModel))
    {
      localISearchResultGroupModel = (ISearchResultGroupModel)paramArrayList.get(i);
      if ((localISearchResultGroupModel.a() != null) && (localISearchResultGroupModel.a().size() == 0)) {
        if ((i - 1 < 0) || (!(paramArrayList.get(i - 1) instanceof GroupSearchModeTitle)) || (!((GroupSearchModeTitle)paramArrayList.get(i - 1)).a().equals(localISearchResultGroupModel.a()))) {
          break label323;
        }
      }
    }
    label323:
    for (int j = 1;; j = 0)
    {
      paramArrayList.remove(i);
      if (j != 0)
      {
        i -= 1;
        paramArrayList.remove(i);
      }
      for (;;)
      {
        bool1 = true;
        for (;;)
        {
          i -= 1;
          break;
          if ((a(localISearchResultGroupModel) != 0) && (i - 1 >= 0) && ((paramArrayList.get(i - 1) instanceof GroupSearchModeTitle)) && (((GroupSearchModeTitle)paramArrayList.get(i - 1)).a().equals(localISearchResultGroupModel.a())))
          {
            GroupSearchModeTitle localGroupSearchModeTitle = (GroupSearchModeTitle)paramArrayList.get(i - 1);
            if ((localGroupSearchModeTitle.a() != null) && (localISearchResultGroupModel.a() != null)) {
              if (localGroupSearchModeTitle.a().a() != null) {
                if (localGroupSearchModeTitle.a().a().size() != localISearchResultGroupModel.a().size())
                {
                  QLog.d("MostUsedFilterForMultiGroupResultLists", 2, "add new group title");
                  paramArrayList.remove(i - 1);
                  paramArrayList.add(i - 1, new GroupSearchModeTitle(localISearchResultGroupModel));
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.mostused.MostUsedFilterForMultiGroupResultLists
 * JD-Core Version:    0.7.0.1
 */