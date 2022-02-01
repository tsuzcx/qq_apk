package com.tencent.mobileqq.search.util;

import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.search.base.api.SearchEntryConfigManager;
import com.tencent.mobileqq.search.base.model.SearchResultModelForEntrance;
import com.tencent.mobileqq.search.business.contact.model.GroupSearchModelLocalContactApproximate;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelFavorite;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelFileEntity;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelFooter;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelFunction;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelLocalContact;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelLocalGuild;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelMessage;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelMiniProgram;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelMostUsed;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelMultiChat;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateBaseItem;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateUniversalItem;
import com.tencent.mobileqq.search.business.net.model.RichSearchModelNode;
import com.tencent.mobileqq.search.config.GroupSearchResultConfigBean;
import com.tencent.mobileqq.search.config.GroupSearchResultConfigBean.SearchResultConfig;
import com.tencent.mobileqq.search.ftsmsg.FTSGroupSearchModelMessage;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.mobileqq.search.model.GroupSearchModeTitle;
import com.tencent.mobileqq.search.model.GroupSearchModelLocalTroop;
import com.tencent.mobileqq.search.model.GroupSearchModelRichNode;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.model.ISearchResultPositionModel;
import com.tencent.mobileqq.search.model.NetSearchTemplateMiniAppItem;
import com.tencent.mobileqq.search.mostused.MostUsedFilterForMultiGroupResultLists;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class GroupSearchResultHandler
{
  private static final HashSet<Integer> a = new HashSet(Arrays.asList(new Integer[] { Integer.valueOf(1106), Integer.valueOf(1000000) }));
  private GroupSearchResultConfigBean b;
  
  private void a(List<IModel> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      ArrayList localArrayList3 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList1 = new ArrayList();
      int k = 0;
      Object localObject;
      for (int i = 0; i < paramList.size(); i = j + 1)
      {
        IModel localIModel1 = (IModel)paramList.get(i);
        if ((localIModel1 instanceof RichSearchModelNode))
        {
          if (((RichSearchModelNode)localIModel1).x()) {
            localObject = localArrayList2;
          } else {
            localObject = localArrayList1;
          }
          if (i > 0)
          {
            IModel localIModel2 = (IModel)paramList.get(i - 1);
            if ((localIModel2 instanceof GroupSearchModeTitle))
            {
              ((List)localObject).add(localIModel2);
              localArrayList3.remove(localIModel2);
            }
          }
          ((List)localObject).add(localIModel1);
          int m = i + 1;
          j = i;
          if (m > paramList.size())
          {
            localIModel1 = (IModel)paramList.get(m);
            j = i;
            if ((localIModel1 instanceof GroupSearchModelFooter))
            {
              ((List)localObject).add(localIModel1);
              j = m;
            }
          }
        }
        else
        {
          if (((localIModel1 instanceof GroupSearchModelRichNode)) && (QLog.isColorLevel())) {
            QLog.e("GroupSearchResultHandler", 2, "adjustRichNodePosition, error, GroupSearchModelRichNode.");
          }
          localArrayList3.add(localIModel1);
          j = i;
        }
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("adjustRichNodePosition, total:");
        ((StringBuilder)localObject).append(paramList.size());
        ((StringBuilder)localObject).append(" exact:");
        ((StringBuilder)localObject).append(localArrayList2.size());
        ((StringBuilder)localObject).append(" fuzzy:");
        ((StringBuilder)localObject).append(localArrayList1.size());
        ((StringBuilder)localObject).append(" other:");
        ((StringBuilder)localObject).append(localArrayList3.size());
        QLog.d("GroupSearchResultHandler", 2, ((StringBuilder)localObject).toString());
      }
      if ((localArrayList2.size() == 0) && (localArrayList1.size() == 0)) {
        return;
      }
      if (localArrayList1.size() == 0)
      {
        paramList.clear();
        paramList.addAll(localArrayList2);
        paramList.addAll(localArrayList3);
        return;
      }
      paramList.clear();
      paramList.addAll(localArrayList2);
      if (localArrayList3.size() == 0)
      {
        paramList.addAll(localArrayList1);
        return;
      }
      int j = b(localArrayList3);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("adjustRichNodePosition, fuzzy pos:");
        ((StringBuilder)localObject).append(j);
        QLog.d("GroupSearchResultHandler", 2, ((StringBuilder)localObject).toString());
      }
      i = k;
      if (j <= 0)
      {
        paramList.addAll(localArrayList1);
        paramList.addAll(localArrayList3);
        return;
      }
      while (i < j)
      {
        paramList.add(localArrayList3.get(i));
        i += 1;
      }
      paramList.addAll(localArrayList1);
      i = j;
      while (i < localArrayList3.size())
      {
        paramList.add(localArrayList3.get(i));
        i += 1;
      }
    }
  }
  
  private int b(List<IModel> paramList)
  {
    if (paramList == null) {
      return -1;
    }
    if (paramList.size() == 0) {
      return 0;
    }
    Object localObject2 = null;
    int j = 0;
    while (j < paramList.size())
    {
      Object localObject3 = (IModel)paramList.get(j);
      Object localObject1;
      if ((localObject3 instanceof GroupSearchModeTitle))
      {
        localObject1 = (GroupSearchModeTitle)localObject3;
        ISearchResultGroupModel localISearchResultGroupModel = ((GroupSearchModeTitle)localObject1).k();
        if (localISearchResultGroupModel == null)
        {
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("getFuzzyPotision error, groupmodel is null:");
            ((StringBuilder)localObject1).append(localObject3);
            QLog.e("GroupSearchResultHandler", 2, ((StringBuilder)localObject1).toString());
            localObject1 = localObject2;
          }
        }
        else
        {
          localObject2 = localISearchResultGroupModel.b();
          localObject3 = ((GroupSearchModeTitle)localObject1).a();
          if (HardCodeUtil.a(2131903365).equals(localObject3))
          {
            localObject1 = localObject2;
          }
          else if (HardCodeUtil.a(2131903362).equals(localObject3))
          {
            localObject1 = localObject2;
          }
          else if (HardCodeUtil.a(2131903347).equals(localObject3))
          {
            localObject1 = localObject2;
          }
          else if (GroupSearchModelMostUsed.a.equals(localObject3))
          {
            localObject1 = localObject2;
          }
          else if (HardCodeUtil.a(2131903343).equals(localObject3))
          {
            if (localObject2 != null)
            {
              localObject1 = localObject2;
              if (((List)localObject2).size() != 0) {}
            }
            else
            {
              localObject1 = localObject2;
              if (QLog.isColorLevel())
              {
                QLog.e("GroupSearchResultHandler", 2, "getFuzzyPotision error, only has title， miniprogram");
                localObject1 = localObject2;
              }
            }
          }
          else if (((GroupSearchModeTitle)localObject1).c)
          {
            localObject1 = localObject2;
          }
          else
          {
            localObject3 = SearchEntryConfigManager.b();
            int i;
            if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (((String)localObject3).equals(((GroupSearchModeTitle)localObject1).a()))) {
              i = 1;
            } else {
              i = 0;
            }
            if (i == 0) {
              break;
            }
            localObject1 = localObject2;
            if (localObject2 != null) {
              if (((List)localObject2).size() == 0)
              {
                localObject1 = localObject2;
              }
              else
              {
                if ((((List)localObject2).get(0) instanceof GroupBaseNetSearchModelItem))
                {
                  localObject3 = (GroupBaseNetSearchModelItem)((List)localObject2).get(0);
                  localObject1 = ((GroupBaseNetSearchModelItem)localObject3).c;
                  localObject3 = ((GroupBaseNetSearchModelItem)localObject3).g();
                  if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).equals(localObject3))) {
                    i = 1;
                  } else {
                    i = 0;
                  }
                }
                if (i == 0) {
                  break;
                }
                localObject1 = localObject2;
              }
            }
          }
        }
      }
      else
      {
        if ((localObject3 instanceof GroupSearchModelFooter)) {}
        for (;;)
        {
          localObject1 = null;
          break label616;
          if (!(localObject3 instanceof SearchResultModelForEntrance)) {
            break;
          }
          if (!((SearchResultModelForEntrance)localObject3).i()) {
            return j;
          }
        }
        if ((localObject3 instanceof GroupSearchModelMostUsed))
        {
          localObject1 = localObject2;
        }
        else if ((localObject3 instanceof GroupSearchModelLocalContact))
        {
          localObject1 = localObject2;
        }
        else if ((localObject3 instanceof GroupSearchModelMiniProgram))
        {
          localObject1 = localObject2;
        }
        else if ((localObject3 instanceof GroupSearchModelFunction))
        {
          localObject1 = localObject2;
        }
        else if ((localObject3 instanceof GroupSearchModelLocalContactApproximate))
        {
          localObject1 = localObject2;
        }
        else if ((localObject3 instanceof GroupSearchModelLocalTroop))
        {
          localObject1 = localObject2;
        }
        else if ((localObject3 instanceof GroupSearchModelLocalGuild))
        {
          localObject1 = localObject2;
        }
        else if (((localObject3 instanceof NetSearchTemplateUniversalItem)) && (((NetSearchTemplateUniversalItem)localObject3).s()))
        {
          localObject1 = localObject2;
        }
        else
        {
          if ((localObject2 == null) || (!((List)localObject2).contains(localObject3))) {
            break label627;
          }
          localObject1 = localObject2;
        }
      }
      label616:
      j += 1;
      localObject2 = localObject1;
      continue;
      label627:
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("getFuzzyPotision, break:");
        paramList.append(localObject3);
        QLog.d("GroupSearchResultHandler", 2, paramList.toString());
      }
    }
    return j;
  }
  
  private GroupSearchResultHandler.GroupPosition c(List<IModel> paramList, int paramInt)
  {
    int j = ((IModel)paramList.get(paramInt)).y();
    int i = paramInt;
    do
    {
      i -= 1;
    } while ((i >= 0) && (((IModel)paramList.get(i)).y() == j));
    do
    {
      paramInt += 1;
    } while ((paramInt < paramList.size()) && (((IModel)paramList.get(paramInt)).y() == j));
    return new GroupSearchResultHandler.GroupPosition(i + 1, paramInt);
  }
  
  public int a(IModel paramIModel)
  {
    if ((paramIModel instanceof ISearchResultPositionModel))
    {
      if ((paramIModel instanceof NetSearchTemplateBaseItem))
      {
        if (((paramIModel instanceof RichSearchModelNode)) && (((RichSearchModelNode)paramIModel).x())) {
          return 1250;
        }
        if (((paramIModel instanceof NetSearchTemplateMiniAppItem)) && (((NetSearchTemplateMiniAppItem)paramIModel).b)) {
          return 1251;
        }
        paramIModel = (NetSearchTemplateBaseItem)paramIModel;
        if ((paramIModel.i == 1003L) && (paramIModel.q())) {
          return 1252;
        }
        return (int)paramIModel.i;
      }
      if ((paramIModel instanceof GroupBaseNetSearchModelItem))
      {
        paramIModel = (GroupBaseNetSearchModelItem)paramIModel;
        if ((paramIModel.j() == 268435456) && (paramIModel.q())) {
          return 1253;
        }
        return paramIModel.j();
      }
      if (((paramIModel instanceof SearchResultModelForEntrance)) && (((SearchResultModelForEntrance)paramIModel).c == -4)) {
        return 2073745984;
      }
    }
    if ((paramIModel instanceof ISearchResultGroupModel))
    {
      if ((paramIModel instanceof GroupSearchModelMostUsed)) {
        return 1200;
      }
      if ((paramIModel instanceof GroupSearchModelLocalContact)) {
        return 1201;
      }
      if ((paramIModel instanceof GroupSearchModelLocalTroop)) {
        return 1202;
      }
      if ((paramIModel instanceof GroupSearchModelMultiChat)) {
        return 1207;
      }
      if ((paramIModel instanceof GroupSearchModelMiniProgram)) {
        return 1701;
      }
      if ((paramIModel instanceof GroupSearchModelLocalContactApproximate)) {
        return 1201;
      }
      if ((paramIModel instanceof GroupSearchModelFunction))
      {
        paramIModel = ((GroupSearchModelFunction)paramIModel).a.iterator();
        while (paramIModel.hasNext())
        {
          Object localObject = (ISearchResultModel)paramIModel.next();
          if ((localObject instanceof GroupBaseNetSearchModelItem))
          {
            localObject = (GroupBaseNetSearchModelItem)localObject;
            if ((((GroupBaseNetSearchModelItem)localObject).j() == 268435456) && (((GroupBaseNetSearchModelItem)localObject).q())) {
              return 1253;
            }
          }
        }
        return 268435456;
      }
      if ((!(paramIModel instanceof GroupSearchModelMessage)) && (!(paramIModel instanceof FTSGroupSearchModelMessage)))
      {
        if ((paramIModel instanceof GroupSearchModelFavorite)) {
          return 1205;
        }
        if ((paramIModel instanceof GroupSearchModelFileEntity)) {
          return 1206;
        }
      }
      else
      {
        return 1204;
      }
    }
    if (((paramIModel instanceof SearchResultModelForEntrance)) && (((SearchResultModelForEntrance)paramIModel).c == -1)) {
      return 1203;
    }
    return -2147483648;
  }
  
  public GroupSearchResultConfigBean.SearchResultConfig a(int paramInt)
  {
    if (this.b == null) {
      this.b = ((GroupSearchResultConfigBean)QConfigManager.b().b(749));
    }
    if (this.b != null)
    {
      String str;
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 21) {
            return GroupSearchResultConfigBean.a();
          }
          str = "leba";
        }
        else
        {
          str = "contact";
        }
      }
      else {
        str = "conversation";
      }
      return this.b.a(str);
    }
    return GroupSearchResultConfigBean.a();
  }
  
  public List<IModel> a(List<IModel> paramList, int paramInt)
  {
    QLog.d("GroupSearchResultHandler", 1, "filterStudyModeNetworkResult");
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return paramList;
      }
      if ((paramInt != 1) && (paramInt != 2) && (paramInt != 21))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("filterStudyModeNetworkResult fromType pass ");
        ((StringBuilder)localObject).append(paramInt);
        QLog.d("GroupSearchResultHandler", 1, ((StringBuilder)localObject).toString());
        return paramList;
      }
      if (!StudyModeManager.h()) {
        return paramList;
      }
      Object localObject = new ArrayList();
      int i;
      for (paramInt = 0; paramInt < paramList.size(); paramInt = i + 1)
      {
        int j = a((IModel)paramList.get(paramInt));
        i = paramInt;
        if (a.contains(Integer.valueOf(j)))
        {
          GroupSearchResultHandler.GroupPosition localGroupPosition = c(paramList, paramInt);
          ((List)localObject).addAll(paramList.subList(localGroupPosition.a, localGroupPosition.b));
          i = localGroupPosition.b - 1;
        }
      }
      return localObject;
    }
    return paramList;
  }
  
  public void a(List<IModel> paramList, String paramString)
  {
    MostUsedFilterForMultiGroupResultLists.a(paramList, paramString);
    a(paramList);
  }
  
  public List<IModel> b(List<IModel> paramList, int paramInt)
  {
    QLog.d("GroupSearchResultHandler", 1, "preProcessByConfig");
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return paramList;
      }
      Object localObject1;
      if ((paramInt != 1) && (paramInt != 2) && (paramInt != 21))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("preProcessByConfig fromType pass ");
        ((StringBuilder)localObject1).append(paramInt);
        QLog.d("GroupSearchResultHandler", 1, ((StringBuilder)localObject1).toString());
        return paramList;
      }
      Object localObject3 = a(paramInt);
      if ((localObject3 != null) && (((GroupSearchResultConfigBean.SearchResultConfig)localObject3).a() != null))
      {
        if (((GroupSearchResultConfigBean.SearchResultConfig)localObject3).a().length == 0)
        {
          QLog.d("GroupSearchResultHandler", 1, "preProcessByConfig sortId is empty");
          return new ArrayList();
        }
        localObject1 = new ArrayList(paramList.size());
        paramInt = 0;
        while (paramInt < paramList.size())
        {
          localObject2 = (IModel)paramList.get(paramInt);
          if (((IModel)localObject2).y() == -1)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("preProcessByConfig: groupId not set!: ");
            ((StringBuilder)localObject1).append(localObject2.getClass().getSimpleName());
            QLog.e("GroupSearchResultHandler", 1, ((StringBuilder)localObject1).toString());
            return paramList;
          }
          ((List)localObject1).add(paramInt, Integer.valueOf(a((IModel)paramList.get(paramInt))));
          paramInt += 1;
        }
        Object localObject2 = new boolean[paramList.size()];
        paramInt = 0;
        while (paramInt < paramList.size())
        {
          localObject2[paramInt] = 0;
          paramInt += 1;
        }
        ArrayList localArrayList = new ArrayList(paramList.size());
        localObject3 = ((GroupSearchResultConfigBean.SearchResultConfig)localObject3).a();
        int k = localObject3.length;
        int i = 0;
        while (i < k)
        {
          int m = localObject3[i];
          paramInt = 0;
          int j = 1;
          while (paramInt < paramList.size())
          {
            if (localObject2[paramInt] == 0)
            {
              if (((Integer)((List)localObject1).get(paramInt)).intValue() != m) {}
              for (;;)
              {
                j = 0;
                break;
                GroupSearchResultHandler.GroupPosition localGroupPosition = c(paramList, paramInt);
                localArrayList.addAll(paramList.subList(localGroupPosition.a, localGroupPosition.b));
                paramInt = localGroupPosition.a;
                while (paramInt < localGroupPosition.b)
                {
                  localObject2[paramInt] = 1;
                  paramInt += 1;
                }
                paramInt = localGroupPosition.b - 1;
              }
            }
            paramInt += 1;
          }
          if (j != 0) {
            return localArrayList;
          }
          i += 1;
        }
        return localArrayList;
      }
      QLog.d("GroupSearchResultHandler", 1, "preProcessByConfig config is null");
    }
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.util.GroupSearchResultHandler
 * JD-Core Version:    0.7.0.1
 */