package com.tencent.mobileqq.search.searchengine;

import android.os.Bundle;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.data.search.GroupSearchModelFileEntity;
import com.tencent.mobileqq.search.ftsmsg.FTSGroupSearchModelMessage;
import com.tencent.mobileqq.search.model.GroupSearchModeTitle;
import com.tencent.mobileqq.search.model.GroupSearchModelLocalContact;
import com.tencent.mobileqq.search.model.GroupSearchModelLocalTroop;
import com.tencent.mobileqq.search.model.GroupSearchModelMiniProgram;
import com.tencent.mobileqq.search.model.GroupSearchModelPublicAcnt;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils;
import cooperation.qqfav.globalsearch.GroupSearchModelFavorite;
import java.util.ArrayList;
import java.util.List;

public abstract class GroupSearchEngine$SearchEngineEntity
{
  public long a;
  public final ISearchEngine a;
  public String a;
  public int b;
  public int c;
  
  public GroupSearchEngine$SearchEngineEntity(GroupSearchEngine paramGroupSearchEngine, ISearchEngine paramISearchEngine, String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine = paramISearchEngine;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.c = paramInt;
  }
  
  protected abstract ISearchResultGroupModel a(List<ISearchResultModel> paramList, String paramString);
  
  public List<ISearchResultGroupModel> a(SearchRequest paramSearchRequest)
  {
    boolean bool2 = false;
    long l = System.currentTimeMillis();
    if (paramSearchRequest.jdField_a_of_type_AndroidOsBundle == null) {
      paramSearchRequest.jdField_a_of_type_AndroidOsBundle = new Bundle();
    }
    paramSearchRequest.jdField_a_of_type_AndroidOsBundle.putBoolean("searchRequestFromHome", true);
    ArrayList localArrayList = new ArrayList();
    List localList = this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine.a(paramSearchRequest);
    this.jdField_a_of_type_Long = (System.currentTimeMillis() - l);
    if ((localList != null) && (!localList.isEmpty()))
    {
      ISearchResultGroupModel localISearchResultGroupModel = a(localList, paramSearchRequest.jdField_a_of_type_JavaLangString);
      if (((localISearchResultGroupModel instanceof GroupSearchModelLocalContact)) && (localISearchResultGroupModel.a() != null) && (localISearchResultGroupModel.a().size() > 0)) {
        paramSearchRequest.jdField_a_of_type_AndroidOsBundle.putBoolean("hasLocalPeopleOrTroop", true);
      }
      boolean bool1;
      if (localISearchResultGroupModel != null)
      {
        bool1 = bool2;
        if (localISearchResultGroupModel.a() != null)
        {
          bool1 = bool2;
          if (localISearchResultGroupModel.a().size() > localISearchResultGroupModel.a()) {
            bool1 = true;
          }
        }
        if (!(localISearchResultGroupModel instanceof GroupSearchModelFavorite)) {
          break label385;
        }
      }
      for (;;)
      {
        localArrayList.add(localISearchResultGroupModel);
        localISearchResultGroupModel = b(localList, paramSearchRequest.jdField_a_of_type_JavaLangString);
        if (((localISearchResultGroupModel instanceof GroupSearchModelLocalContact)) && (localISearchResultGroupModel.a() != null) && (localISearchResultGroupModel.a().size() > 0)) {
          paramSearchRequest.jdField_a_of_type_AndroidOsBundle.putBoolean("hasLocalPeopleOrTroop", true);
        }
        if (localISearchResultGroupModel != null)
        {
          localArrayList.add(new GroupSearchModeTitle(localISearchResultGroupModel));
          localArrayList.add(localISearchResultGroupModel);
        }
        localISearchResultGroupModel = c(localList, paramSearchRequest.jdField_a_of_type_JavaLangString);
        if (((localISearchResultGroupModel instanceof GroupSearchModelLocalTroop)) && (localISearchResultGroupModel.a() != null) && (localISearchResultGroupModel.a().size() > 0)) {
          paramSearchRequest.jdField_a_of_type_AndroidOsBundle.putBoolean("hasLocalPeopleOrTroop", true);
        }
        if (localISearchResultGroupModel != null)
        {
          localArrayList.add(new GroupSearchModeTitle(localISearchResultGroupModel));
          localArrayList.add(localISearchResultGroupModel);
        }
        this.jdField_b_of_type_Int = localList.size();
        return localArrayList;
        label385:
        if ((localISearchResultGroupModel instanceof GroupSearchModelFileEntity)) {
          localArrayList.add(new GroupSearchModeTitle(localISearchResultGroupModel, HardCodeUtil.a(2131705407), bool1));
        } else if (SQLiteFTSUtils.e(GroupSearchEngine.a(this.jdField_b_of_type_ComTencentMobileqqSearchSearchengineGroupSearchEngine)) == 1) {
          localArrayList.add(new GroupSearchModeTitle(localISearchResultGroupModel, localISearchResultGroupModel.a().toString() + " " + this.jdField_a_of_type_Long + "ms", bool1));
        } else if ((localISearchResultGroupModel instanceof GroupSearchModelPublicAcnt)) {
          localArrayList.add(new GroupSearchModeTitle(localISearchResultGroupModel, HardCodeUtil.a(2131705387), true));
        } else if ((localISearchResultGroupModel instanceof GroupSearchModelMiniProgram)) {
          localArrayList.add(new GroupSearchModeTitle(localISearchResultGroupModel, localISearchResultGroupModel.a(), bool1));
        } else if ((localISearchResultGroupModel instanceof FTSGroupSearchModelMessage)) {
          localArrayList.add(new GroupSearchModeTitle(localISearchResultGroupModel, HardCodeUtil.a(2131705395), bool1));
        } else {
          localArrayList.add(new GroupSearchModeTitle(localISearchResultGroupModel));
        }
      }
    }
    this.jdField_b_of_type_Int = 0;
    return localArrayList;
  }
  
  protected ISearchResultGroupModel b(List<ISearchResultModel> paramList, String paramString)
  {
    return null;
  }
  
  protected ISearchResultGroupModel c(List<ISearchResultModel> paramList, String paramString)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.GroupSearchEngine.SearchEngineEntity
 * JD-Core Version:    0.7.0.1
 */