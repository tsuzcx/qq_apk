package com.tencent.mobileqq.search.searchengine;

import android.os.Bundle;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.base.engine.ISearchEngine;
import com.tencent.mobileqq.search.base.model.SearchRequest;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelFavorite;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelFileEntity;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelLocalContact;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelLocalGuild;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelMiniProgram;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelPublicAcnt;
import com.tencent.mobileqq.search.ftsmsg.FTSGroupSearchModelMessage;
import com.tencent.mobileqq.search.model.GroupSearchModeTitle;
import com.tencent.mobileqq.search.model.GroupSearchModelLocalTroop;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils;
import java.util.ArrayList;
import java.util.List;

public abstract class GroupSearchEngine$SearchEngineEntity
{
  public final ISearchEngine c;
  public long d;
  public int e;
  public String f;
  public int g;
  
  public GroupSearchEngine$SearchEngineEntity(GroupSearchEngine paramGroupSearchEngine, ISearchEngine paramISearchEngine, String paramString, int paramInt)
  {
    this.c = paramISearchEngine;
    this.f = paramString;
    this.g = paramInt;
  }
  
  protected abstract ISearchResultGroupModel a(List<ISearchResultModel> paramList, String paramString);
  
  public List<ISearchResultGroupModel> a(SearchRequest paramSearchRequest)
  {
    long l = System.currentTimeMillis();
    if (paramSearchRequest.b == null) {
      paramSearchRequest.b = new Bundle();
    }
    paramSearchRequest.b.putBoolean("searchRequestFromHome", true);
    ArrayList localArrayList = new ArrayList();
    List localList = this.c.a(paramSearchRequest);
    this.d = (System.currentTimeMillis() - l);
    boolean bool2 = false;
    if ((localList != null) && (!localList.isEmpty()))
    {
      ISearchResultGroupModel localISearchResultGroupModel = a(localList, paramSearchRequest.a);
      if (((localISearchResultGroupModel instanceof GroupSearchModelLocalContact)) && (localISearchResultGroupModel.b() != null) && (localISearchResultGroupModel.b().size() > 0)) {
        paramSearchRequest.b.putBoolean("hasLocalPeopleOrTroop", true);
      }
      Object localObject = null;
      if (localISearchResultGroupModel != null)
      {
        int i = SearchUtil.a();
        boolean bool1 = bool2;
        if (localISearchResultGroupModel.b() != null)
        {
          bool1 = bool2;
          if (localISearchResultGroupModel.b().size() > localISearchResultGroupModel.d()) {
            bool1 = true;
          }
        }
        if (!(localISearchResultGroupModel instanceof GroupSearchModelFavorite)) {
          if ((localISearchResultGroupModel instanceof GroupSearchModelFileEntity))
          {
            localObject = new GroupSearchModeTitle(localISearchResultGroupModel, HardCodeUtil.a(2131903368), bool1);
          }
          else if (SQLiteFTSUtils.d(GroupSearchEngine.a(this.h)) == 1)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(localISearchResultGroupModel.a().toString());
            ((StringBuilder)localObject).append(" ");
            ((StringBuilder)localObject).append(this.d);
            ((StringBuilder)localObject).append("ms");
            localObject = new GroupSearchModeTitle(localISearchResultGroupModel, ((StringBuilder)localObject).toString(), bool1);
          }
          else if ((localISearchResultGroupModel instanceof GroupSearchModelPublicAcnt))
          {
            localObject = new GroupSearchModeTitle(localISearchResultGroupModel, HardCodeUtil.a(2131903348), true);
          }
          else if ((localISearchResultGroupModel instanceof GroupSearchModelMiniProgram))
          {
            localObject = new GroupSearchModeTitle(localISearchResultGroupModel, localISearchResultGroupModel.a(), bool1);
          }
          else if ((localISearchResultGroupModel instanceof FTSGroupSearchModelMessage))
          {
            localObject = new GroupSearchModeTitle(localISearchResultGroupModel, HardCodeUtil.a(2131903356), bool1);
          }
          else
          {
            localObject = new GroupSearchModeTitle(localISearchResultGroupModel);
          }
        }
        if (localObject != null)
        {
          ((GroupSearchModeTitle)localObject).d(i);
          localArrayList.add(localObject);
        }
        localISearchResultGroupModel.d(i);
        localArrayList.add(localISearchResultGroupModel);
      }
      localObject = b(localList, paramSearchRequest.a);
      if (((localObject instanceof GroupSearchModelLocalContact)) && (((ISearchResultGroupModel)localObject).b() != null) && (((ISearchResultGroupModel)localObject).b().size() > 0)) {
        paramSearchRequest.b.putBoolean("hasLocalPeopleOrTroop", true);
      }
      if (localObject != null) {
        a((ISearchResultGroupModel)localObject, localArrayList);
      }
      localObject = c(localList, paramSearchRequest.a);
      if (((localObject instanceof GroupSearchModelLocalTroop)) && (((ISearchResultGroupModel)localObject).b() != null) && (((ISearchResultGroupModel)localObject).b().size() > 0)) {
        paramSearchRequest.b.putBoolean("hasLocalPeopleOrTroop", true);
      }
      if (localObject != null) {
        a((ISearchResultGroupModel)localObject, localArrayList);
      }
      localObject = d(localList, paramSearchRequest.a);
      if (((localObject instanceof GroupSearchModelLocalGuild)) && (((ISearchResultGroupModel)localObject).b() != null) && (((ISearchResultGroupModel)localObject).b().size() > 0)) {
        paramSearchRequest.b.putBoolean("hasLocalPeopleOrTroop", true);
      }
      if (localObject != null)
      {
        localArrayList.add(new GroupSearchModeTitle((ISearchResultGroupModel)localObject));
        localArrayList.add(localObject);
      }
      this.e = localList.size();
      return localArrayList;
    }
    this.e = 0;
    return localArrayList;
  }
  
  protected void a(ISearchResultGroupModel paramISearchResultGroupModel, List<ISearchResultGroupModel> paramList)
  {
    int i = SearchUtil.a();
    GroupSearchModeTitle localGroupSearchModeTitle = new GroupSearchModeTitle(paramISearchResultGroupModel);
    localGroupSearchModeTitle.d(i);
    paramISearchResultGroupModel.d(i);
    paramList.add(localGroupSearchModeTitle);
    paramList.add(paramISearchResultGroupModel);
  }
  
  protected ISearchResultGroupModel b(List<ISearchResultModel> paramList, String paramString)
  {
    return null;
  }
  
  protected ISearchResultGroupModel c(List<ISearchResultModel> paramList, String paramString)
  {
    return null;
  }
  
  protected ISearchResultGroupModel d(List<ISearchResultModel> paramList, String paramString)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.GroupSearchEngine.SearchEngineEntity
 * JD-Core Version:    0.7.0.1
 */