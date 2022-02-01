package com.tencent.mobileqq.search.mostused;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.entry.MiniAppLocalSearchEntity;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.base.model.SearchResultModelForEntrance;
import com.tencent.mobileqq.search.business.contact.model.IContactSearchModel;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelFooter;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelFunction;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelLocalContact;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelMessage;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelMiniProgram;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelMostUsed;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateUniversalItem;
import com.tencent.mobileqq.search.ftsmsg.FTSGroupSearchModelMessage;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModel;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.mobileqq.search.model.GroupSearchModeTitle;
import com.tencent.mobileqq.search.model.GroupSearchModelLocalTroop;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.model.ISearchResultPositionModel;
import com.tencent.mobileqq.search.model.MiniProgramSearchResultModel;
import com.tencent.mobileqq.search.model.NetSearchTemplateHorSlidingContainerItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateIndividuateContainerItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateMiniAppItem;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MostUsedFilterForMultiGroupResultLists
{
  public static int a = 3;
  
  public static int a(ISearchResultGroupModel paramISearchResultGroupModel)
  {
    if ((paramISearchResultGroupModel instanceof GroupSearchModelMiniProgram)) {
      return 2;
    }
    if ((paramISearchResultGroupModel instanceof GroupSearchModelLocalContact)) {
      return 1;
    }
    if ((paramISearchResultGroupModel instanceof GroupSearchModelLocalTroop)) {
      return 1;
    }
    if ((paramISearchResultGroupModel instanceof GroupSearchModelFunction)) {
      return 3;
    }
    return 0;
  }
  
  private static int a(MostUsedCache.MostUsedSearchItemModel paramMostUsedSearchItemModel, List<ISearchResultModel> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
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
          if ((((IContactSearchModel)localObject).i() instanceof String)) {
            str = (String)((IContactSearchModel)localObject).i();
          }
          i = ((IContactSearchModel)localObject).o();
        }
        else if ((localISearchResultModel instanceof GroupBaseNetSearchModelItem))
        {
          localObject = (GroupBaseNetSearchModelItem)localISearchResultModel;
          str = ((GroupBaseNetSearchModelItem)localObject).o();
          i = ((GroupBaseNetSearchModelItem)localObject).p();
        }
        else
        {
          QLog.e("MostUsedFilterForMultiGroupResultListsMostUsedSearchResultManager", 2, "unknown type extends ISearchResultModel");
          i = -1;
        }
        if ((str.equals(paramMostUsedSearchItemModel.a.identify)) && (i == paramMostUsedSearchItemModel.a.identifyType))
        {
          paramMostUsedSearchItemModel.d = true;
          paramMostUsedSearchItemModel.b = localISearchResultModel;
          QLog.d("MostUsedFilterForMultiGroupResultListsMostUsedSearchResultManager", 2, "bEffective ");
          return j;
        }
        j += 1;
      }
    }
    return -1;
  }
  
  private static ISearchResultGroupModel a(Object paramObject)
  {
    Object localObject;
    if ((paramObject instanceof GroupSearchModelMiniProgram))
    {
      paramObject = (GroupSearchModelMiniProgram)paramObject;
      localObject = new GroupSearchModelMiniProgram(new ArrayList(paramObject.a), paramObject.c(), paramObject.e());
      ((GroupSearchModelMiniProgram)localObject).d(paramObject.y());
      return localObject;
    }
    if ((paramObject instanceof GroupSearchModelLocalContact))
    {
      paramObject = (GroupSearchModelLocalContact)paramObject;
      localObject = new GroupSearchModelLocalContact(new ArrayList(paramObject.a), paramObject.c(), paramObject.f());
      ((GroupSearchModelLocalContact)localObject).d(paramObject.y());
      return localObject;
    }
    if ((paramObject instanceof GroupSearchModelLocalTroop))
    {
      paramObject = (GroupSearchModelLocalTroop)paramObject;
      localObject = new GroupSearchModelLocalTroop(new ArrayList(paramObject.a), paramObject.c(), paramObject.f());
      ((GroupSearchModelLocalTroop)localObject).d(paramObject.y());
      return localObject;
    }
    if ((paramObject instanceof GroupSearchModelFunction))
    {
      paramObject = (GroupSearchModelFunction)paramObject;
      localObject = new GroupSearchModelFunction(new ArrayList(paramObject.a), paramObject.c(), paramObject.e());
      ((GroupSearchModelFunction)localObject).d(paramObject.y());
      return localObject;
    }
    return null;
  }
  
  public static ArrayList a(String paramString, ArrayList<MostUsedCache.MostUsedSearchItemModel> paramArrayList, List paramList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      Object localObject2;
      while (i < paramList.size())
      {
        localObject1 = paramList.get(i);
        localObject2 = a(localObject1);
        if (localObject2 != null) {
          localArrayList.add(localObject2);
        } else {
          localArrayList.add(localObject1);
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("the i name ");
        ((StringBuilder)localObject1).append(localArrayList.get(i).getClass().getName());
        QLog.d("MostUsedFilterForMultiGroupResultListsMostUsed", 2, ((StringBuilder)localObject1).toString());
        i += 1;
      }
      Object localObject1 = new ArrayList();
      int j = 0;
      int k;
      for (i = 0;; i = k)
      {
        k = i;
        if (j >= paramArrayList.size()) {
          break;
        }
        localObject2 = (MostUsedCache.MostUsedSearchItemModel)paramArrayList.get(j);
        k = 0;
        while (k < localArrayList.size())
        {
          if ((localArrayList.get(k) instanceof ISearchResultGroupModel))
          {
            int m = a((ISearchResultGroupModel)localArrayList.get(k));
            boolean bool;
            if ((m != 0) && (((MostUsedCache.MostUsedSearchItemModel)localObject2).a.businessType == m)) {
              bool = a((MostUsedCache.MostUsedSearchItemModel)localObject2, (ISearchResultGroupModel)localArrayList.get(k));
            } else {
              bool = false;
            }
            if (bool) {
              break;
            }
          }
          k += 1;
        }
        k = i;
        if (((MostUsedCache.MostUsedSearchItemModel)localObject2).d == true)
        {
          if ((((MostUsedCache.MostUsedSearchItemModel)localObject2).b instanceof IContactSearchModel)) {
            ((IContactSearchModel)((MostUsedCache.MostUsedSearchItemModel)localObject2).b).c(((MostUsedCache.MostUsedSearchItemModel)localObject2).a.searchKey);
          }
          if ((((MostUsedCache.MostUsedSearchItemModel)localObject2).b instanceof GroupBaseNetSearchModelItem)) {
            ((GroupBaseNetSearchModelItem)((MostUsedCache.MostUsedSearchItemModel)localObject2).b).b(((MostUsedCache.MostUsedSearchItemModel)localObject2).a.searchKey);
          }
          if ((((MostUsedCache.MostUsedSearchItemModel)localObject2).b instanceof ISearchResultPositionModel)) {
            ((ISearchResultPositionModel)((MostUsedCache.MostUsedSearchItemModel)localObject2).b).c(true);
          }
          ((ArrayList)localObject1).add(((MostUsedCache.MostUsedSearchItemModel)localObject2).b);
          i += 1;
          k = i;
          if (i == 3)
          {
            k = i;
            break;
          }
        }
        j += 1;
      }
      a(localArrayList);
      if (k > 0)
      {
        paramString = new GroupSearchModelMostUsed((List)localObject1, paramString);
        localObject1 = new GroupSearchModeTitle(paramString, paramString.a(), false);
        i = SearchUtil.a();
        paramString.d(i);
        ((GroupSearchModeTitle)localObject1).d(i);
        localArrayList.add(0, paramString);
        localArrayList.add(0, localObject1);
        QLog.d("MostUsedFilterForMultiGroupResultListsMostUsedSearchResultManager", 2, "add GroupSearchModelMostUsed");
      }
      paramString = new StringBuilder();
      paramString.append("the finish Wash orgList size ");
      paramString.append(paramList.size());
      paramString.append(" match mostUsedList size");
      paramString.append(paramArrayList.size());
      paramString.append(" resultlist ");
      paramString.append(localArrayList.size());
      QLog.d("MostUsedFilterForMultiGroupResultListsMostUsedSearchResultManager", 2, paramString.toString());
      return localArrayList;
    }
    return new ArrayList(paramList);
  }
  
  private static ArrayList<String> a(List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    Object localObject;
    while (paramList.hasNext())
    {
      localObject = paramList.next();
      if ((localObject instanceof GroupSearchModelMostUsed))
      {
        paramList = (GroupSearchModelMostUsed)localObject;
        break label48;
      }
    }
    paramList = null;
    label48:
    if (paramList != null)
    {
      paramList = paramList.b();
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
  
  private static void a(List paramList, int paramInt1, List<ISearchResultModel> paramList1, GroupBaseNetSearchModel paramGroupBaseNetSearchModel, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    if ((paramList != null) && (paramList1 != null) && (paramList1.size() != 0))
    {
      if (paramList.size() < paramInt1)
      {
        paramInt1 = paramList.size();
        QLog.e("MostUsedFilterForMultiGroupResultLists", 2, " INDEX OUT OF RANGE");
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addListAndTitleToIndex ");
      ((StringBuilder)localObject).append(paramList1.size());
      QLog.d("MostUsedFilterForMultiGroupResultLists", 2, ((StringBuilder)localObject).toString());
      if ((paramInt2 > 0) && (paramList1.size() > paramInt2))
      {
        i = paramList1.size() - 1;
        while (i >= paramInt2)
        {
          paramList1.remove(i);
          i -= 1;
        }
        paramInt2 = 1;
      }
      else
      {
        paramInt2 = 0;
      }
      if (paramGroupBaseNetSearchModel != null)
      {
        paramGroupBaseNetSearchModel = new GroupBaseNetSearchModel(paramGroupBaseNetSearchModel.c(), paramGroupBaseNetSearchModel.a, paramGroupBaseNetSearchModel.a(), paramList1, paramList1.size(), paramGroupBaseNetSearchModel.g(), paramGroupBaseNetSearchModel.f(), paramGroupBaseNetSearchModel.l, paramGroupBaseNetSearchModel.m, paramGroupBaseNetSearchModel.n, paramGroupBaseNetSearchModel.o, paramGroupBaseNetSearchModel.j, paramGroupBaseNetSearchModel.k);
      }
      else
      {
        paramGroupBaseNetSearchModel = new GroupBaseNetSearchModel();
        paramGroupBaseNetSearchModel.c = paramList1;
        QLog.e("MostUsedFilterForMultiGroupResultLists", 2, "oldTitleGroupMode is empty");
      }
      int i = paramInt1;
      localObject = paramList1;
      if ((paramBoolean1) && (paramInt2 != 0))
      {
        if (!TextUtils.isEmpty(paramGroupBaseNetSearchModel.g())) {
          paramBoolean1 = true;
        } else {
          QLog.e("MostUsedFilterForMultiGroupResultLists", 2, "newModel.getMoreUrl() is empty");
        }
      }
      else {
        paramBoolean1 = false;
      }
      if (paramList1.size() > 0)
      {
        paramInt1 = paramList1.size() - 1;
        while (paramInt1 >= 0)
        {
          paramList.add(i, ((List)localObject).get(paramInt1));
          paramInt1 -= 1;
        }
        paramInt1 = ((ISearchResultModel)((List)localObject).get(0)).y();
        paramList1 = new GroupSearchModeTitle(paramGroupBaseNetSearchModel, paramBoolean1, paramGroupBaseNetSearchModel.n);
        paramList1.d(paramInt1);
        paramGroupBaseNetSearchModel.d(paramInt1);
        if (paramBoolean2) {
          paramList1.c = true;
        }
        paramList.add(i, paramList1);
      }
      return;
    }
    QLog.e("MostUsedFilterForMultiGroupResultLists", 2, " no list to add");
  }
  
  public static void a(List paramList, String paramString)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      ArrayList localArrayList5 = a(paramList);
      ArrayList localArrayList4 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList1 = new ArrayList();
      int i = paramList.size() - 1;
      Object localObject1 = null;
      Object localObject4 = localObject1;
      Object localObject3 = localObject4;
      Object localObject2 = localObject3;
      boolean bool;
      Object localObject5;
      while (i >= 0)
      {
        Object localObject8 = paramList.get(i);
        Object localObject7;
        Object localObject6;
        if ((localObject8 instanceof GroupSearchModeTitle))
        {
          localObject8 = ((GroupSearchModeTitle)localObject8).k();
          bool = localObject8 instanceof GroupBaseNetSearchModel;
          if (bool)
          {
            localObject5 = (GroupBaseNetSearchModel)localObject8;
            if (((GroupBaseNetSearchModel)localObject5).a == 1701L)
            {
              paramList.remove(i);
              localObject4 = localObject5;
              break label681;
            }
          }
          if (bool)
          {
            localObject7 = (GroupBaseNetSearchModel)localObject8;
            if (((GroupBaseNetSearchModel)localObject7).a == 1003L)
            {
              paramList.remove(i);
              localObject5 = localObject1;
              localObject6 = localObject3;
              break label669;
            }
          }
          localObject5 = localObject1;
          localObject6 = localObject3;
          localObject7 = localObject2;
          if (bool)
          {
            localObject8 = (GroupBaseNetSearchModel)localObject8;
            localObject5 = localObject1;
            localObject6 = localObject3;
            localObject7 = localObject2;
            if (((GroupBaseNetSearchModel)localObject8).a == 1105L)
            {
              paramList.remove(i);
              localObject5 = localObject8;
              localObject6 = localObject3;
              localObject7 = localObject2;
            }
          }
        }
        else
        {
          if ((localObject8 instanceof GroupSearchModelFooter))
          {
            localObject5 = (GroupSearchModelFooter)localObject8;
            if ((((GroupSearchModelFooter)localObject5).d == 1701L) || (((GroupSearchModelFooter)localObject5).d == 1003L))
            {
              paramList.remove(i);
              localObject5 = localObject1;
              localObject6 = localObject3;
              localObject7 = localObject2;
              break label669;
            }
          }
          if ((localObject8 instanceof NetSearchTemplateMiniAppItem))
          {
            localObject8 = (NetSearchTemplateMiniAppItem)localObject8;
            localObject5 = localObject1;
            localObject6 = localObject3;
            localObject7 = localObject2;
            if (((NetSearchTemplateMiniAppItem)localObject8).a != null)
            {
              localObject5 = localObject1;
              localObject6 = localObject3;
              localObject7 = localObject2;
              if (((NetSearchTemplateMiniAppItem)localObject8).a.a != null)
              {
                String str = ((NetSearchTemplateMiniAppItem)localObject8).a.a.appId;
                paramList.remove(i);
                localObject5 = localObject1;
                localObject6 = localObject3;
                localObject7 = localObject2;
                if (!a(str, localArrayList5)) {
                  if (((NetSearchTemplateMiniAppItem)localObject8).b)
                  {
                    localArrayList4.add(0, localObject8);
                    localObject5 = localObject1;
                    localObject6 = localObject3;
                    localObject7 = localObject2;
                  }
                  else
                  {
                    localArrayList3.add(0, localObject8);
                    localObject5 = localObject1;
                    localObject6 = localObject3;
                    localObject7 = localObject2;
                  }
                }
              }
            }
          }
          else if ((localObject8 instanceof NetSearchTemplateUniversalItem))
          {
            localObject8 = (NetSearchTemplateUniversalItem)localObject8;
            localObject5 = localObject1;
            localObject6 = localObject3;
            localObject7 = localObject2;
            if (((NetSearchTemplateUniversalItem)localObject8).i == 1003L)
            {
              paramList.remove(i);
              if ((((NetSearchTemplateUniversalItem)localObject8).q()) && (localArrayList2.size() == 0))
              {
                localArrayList2.add(0, localObject8);
                UniteSearchReportController.a(null, 0, ((NetSearchTemplateUniversalItem)localObject8).p, "0X800AC11", 0, 0, "", "");
                localObject5 = localObject1;
                localObject6 = localObject3;
                localObject7 = localObject2;
              }
              else
              {
                localArrayList1.add(0, localObject8);
                localObject5 = localObject1;
                localObject6 = localObject3;
                localObject7 = localObject2;
              }
            }
          }
          else
          {
            localObject5 = localObject1;
            localObject6 = localObject3;
            localObject7 = localObject2;
            if ((localObject8 instanceof NetSearchTemplateHorSlidingContainerItem))
            {
              localObject6 = (NetSearchTemplateHorSlidingContainerItem)localObject8;
              paramList.remove(i);
              localObject7 = localObject2;
              localObject5 = localObject1;
            }
          }
        }
        label669:
        localObject2 = localObject7;
        localObject3 = localObject6;
        localObject1 = localObject5;
        label681:
        i -= 1;
      }
      int j = 0;
      int k = 0;
      for (i = 0; j < paramList.size(); i = m)
      {
        localObject5 = paramList.get(j);
        bool = localObject5 instanceof GroupSearchModelMostUsed;
        if (bool) {
          k = j + 1;
        }
        if (((!(localObject5 instanceof GroupSearchModelFunction)) || (!a((GroupSearchModelFunction)localObject5, paramString))) && (!bool) && (!(localObject5 instanceof GroupSearchModelLocalContact)) && (!(localObject5 instanceof GroupSearchModelLocalTroop)))
        {
          m = i;
          if (!(localObject5 instanceof SearchResultModelForEntrance)) {}
        }
        else
        {
          m = i;
          if (i <= j) {
            m = j + 1;
          }
        }
        j += 1;
      }
      if (localArrayList4.size() > 0)
      {
        a(paramList, k, localArrayList4, localObject4, false, a, true);
        j = localArrayList4.size() + i + 1;
        if (paramList.size() >= j)
        {
          QLog.e("MostUsedFilterForMultiGroupResultLists", 2, "OUT OF INDEX OF MINI");
          i = j;
        }
        else {}
      }
      if (localArrayList3.size() > 0) {
        a(paramList, i, localArrayList3, localObject4, true, a, false);
      }
      j = 0;
      int m = 0;
      int n;
      for (i = 0; j < paramList.size(); i = n)
      {
        localObject4 = paramList.get(j);
        bool = localObject4 instanceof GroupSearchModelMostUsed;
        if ((!bool) && ((!(localObject4 instanceof NetSearchTemplateMiniAppItem)) || (((NetSearchTemplateMiniAppItem)localObject4).b != true)))
        {
          k = m;
          if ((localObject4 instanceof GroupSearchModelFunction))
          {
            k = m;
            if (!a((GroupSearchModelFunction)localObject4, paramString)) {}
          }
        }
        else
        {
          k = j + 1;
        }
        if ((!(localObject4 instanceof GroupSearchModelFunction)) && (!bool) && (!(localObject4 instanceof GroupSearchModelLocalContact)) && (!(localObject4 instanceof GroupSearchModelLocalTroop)) && (!(localObject4 instanceof SearchResultModelForEntrance)) && (!(localObject4 instanceof NetSearchTemplateMiniAppItem)) && (!(localObject4 instanceof GroupSearchModelMessage)) && (!(localObject4 instanceof FTSGroupSearchModelMessage)))
        {
          n = i;
          if (!(localObject4 instanceof NetSearchTemplateIndividuateContainerItem)) {}
        }
        else
        {
          n = i;
          if (i <= j) {
            n = j + 1;
          }
        }
        j += 1;
        m = k;
      }
      if (localArrayList2.size() > 0)
      {
        a(paramList, m, localArrayList2, localObject2, false, a, true);
        j = localArrayList2.size() + i + 1;
        if (paramList.size() >= j)
        {
          QLog.e("MostUsedFilterForMultiGroupResultLists", 2, "OUT OF INDEX OF PUBLLIC");
          i = j;
        }
      }
      j = i;
      if (localObject3 != null)
      {
        paramList.add(i, localObject3);
        paramString = new GroupSearchModeTitle(localObject1, true, localObject1.n);
        paramString.d(localObject3.y());
        paramList.add(i, paramString);
        j = i + 2;
      }
      if (localArrayList1.size() > 0) {
        a(paramList, j, localArrayList1, localObject2, true, a, false);
      }
    }
  }
  
  private static boolean a(GroupSearchModelFunction paramGroupSearchModelFunction, String paramString)
  {
    return (paramGroupSearchModelFunction != null) && (paramGroupSearchModelFunction.a != null) && (paramGroupSearchModelFunction.a.size() > 0) && ((paramGroupSearchModelFunction.a.get(0) instanceof GroupBaseNetSearchModelItem)) && (((GroupBaseNetSearchModelItem)paramGroupSearchModelFunction.a.get(0)).c.equals(paramString));
  }
  
  private static boolean a(MostUsedCache.MostUsedSearchItemModel paramMostUsedSearchItemModel, ISearchResultGroupModel paramISearchResultGroupModel)
  {
    boolean bool = false;
    if (paramISearchResultGroupModel == null) {
      return false;
    }
    int i = a(paramMostUsedSearchItemModel, paramISearchResultGroupModel.b());
    if (i >= 0)
    {
      paramISearchResultGroupModel.b().remove(i);
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(String paramString, ArrayList<String> paramArrayList)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramArrayList != null))
    {
      if (paramArrayList.size() == 0) {
        return false;
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        if (paramString.equalsIgnoreCase((String)paramArrayList.next())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean a(ArrayList paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return false;
      }
      int i = paramArrayList.size() - 1;
      boolean bool2;
      for (boolean bool1 = false; i >= 0; bool1 = bool2)
      {
        int j = i;
        bool2 = bool1;
        if ((paramArrayList.get(i) instanceof ISearchResultGroupModel))
        {
          ISearchResultGroupModel localISearchResultGroupModel = (ISearchResultGroupModel)paramArrayList.get(i);
          int k;
          if ((localISearchResultGroupModel.b() != null) && (localISearchResultGroupModel.b().size() == 0))
          {
            k = i - 1;
            if ((k >= 0) && ((paramArrayList.get(k) instanceof GroupSearchModeTitle)) && (((GroupSearchModeTitle)paramArrayList.get(k)).a().equals(localISearchResultGroupModel.a()))) {
              j = 1;
            } else {
              j = 0;
            }
            paramArrayList.remove(i);
            if (j != 0)
            {
              paramArrayList.remove(k);
              i = k;
            }
            bool2 = true;
            j = i;
          }
          else
          {
            j = i;
            bool2 = bool1;
            if (a(localISearchResultGroupModel) != 0)
            {
              k = i - 1;
              j = i;
              bool2 = bool1;
              if (k >= 0)
              {
                j = i;
                bool2 = bool1;
                if ((paramArrayList.get(k) instanceof GroupSearchModeTitle))
                {
                  j = i;
                  bool2 = bool1;
                  if (((GroupSearchModeTitle)paramArrayList.get(k)).a().equals(localISearchResultGroupModel.a()))
                  {
                    GroupSearchModeTitle localGroupSearchModeTitle = (GroupSearchModeTitle)paramArrayList.get(k);
                    j = i;
                    bool2 = bool1;
                    if (localGroupSearchModeTitle.k() != null)
                    {
                      j = i;
                      bool2 = bool1;
                      if (localISearchResultGroupModel.b() != null) {
                        if (localGroupSearchModeTitle.k().b() == null)
                        {
                          j = i;
                          bool2 = bool1;
                        }
                        else
                        {
                          j = i;
                          bool2 = bool1;
                          if (localGroupSearchModeTitle.k().b().size() != localISearchResultGroupModel.b().size())
                          {
                            QLog.d("MostUsedFilterForMultiGroupResultLists", 2, "add new group title");
                            paramArrayList.remove(k);
                            localGroupSearchModeTitle = new GroupSearchModeTitle(localISearchResultGroupModel);
                            localGroupSearchModeTitle.d(localISearchResultGroupModel.y());
                            paramArrayList.add(k, localGroupSearchModeTitle);
                            bool2 = bool1;
                            j = i;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        i = j - 1;
      }
      return bool1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.mostused.MostUsedFilterForMultiGroupResultLists
 * JD-Core Version:    0.7.0.1
 */