package com.tencent.mobileqq.search.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.UnifySearchHandler;
import com.tencent.mobileqq.app.UniteSearchHandler;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig;
import com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig.SimpleMiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppLocalSearchEntity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.LocationInterface;
import com.tencent.mobileqq.search.SearchFragmentInfoInterface;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.adapter.GroupSearchAdapter;
import com.tencent.mobileqq.search.base.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.base.api.SearchEntryConfigManager;
import com.tencent.mobileqq.search.base.engine.ISearchEngine;
import com.tencent.mobileqq.search.base.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.base.model.SearchRequest;
import com.tencent.mobileqq.search.base.model.SearchRespData;
import com.tencent.mobileqq.search.base.model.SearchResultModelForEntrance;
import com.tencent.mobileqq.search.base.util.ObjectTransfer;
import com.tencent.mobileqq.search.base.util.VADHelper;
import com.tencent.mobileqq.search.business.contact.model.GroupSearchModelLocalContactApproximate;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelFooter;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelFunction;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelLocalContact;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelMiniProgram;
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelMostUsed;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateBaseItem;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateHorizontalBaseItem;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateUniversalItem;
import com.tencent.mobileqq.search.business.net.model.RichSearchModelNode;
import com.tencent.mobileqq.search.config.SearchConfig;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModel;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.mobileqq.search.model.GroupSearchModeTitle;
import com.tencent.mobileqq.search.model.GroupSearchModelLocalTroop;
import com.tencent.mobileqq.search.model.GroupSearchModelRichNode;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.MiniProgramSearchResultModel;
import com.tencent.mobileqq.search.model.NetSearchTemplateHorSlidingContainerItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateHorizontalContainerItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateMiniAppItem;
import com.tencent.mobileqq.search.model.PublicAccountSearchResultModel;
import com.tencent.mobileqq.search.mostused.MostUsedFilterForMultiGroupResultLists;
import com.tencent.mobileqq.search.mostused.MostUsedSearchResultManager;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine;
import com.tencent.mobileqq.search.util.SearchCostStat;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.SearchUtils.ObjectItemInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.dropframe.DropFrameMonitor;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.search.model.IModel;>;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class GroupSearchFragment
  extends BaseSearchFragment
  implements SearchFragmentInfoInterface, AbsListView.OnScrollListener
{
  public static volatile String a;
  public volatile int a;
  public long a;
  protected SearchResultModelForEntrance a;
  public boolean a;
  byte[] a;
  public int b;
  protected long b;
  public Handler b;
  protected SearchResultModelForEntrance b;
  public String b;
  public volatile int c;
  private long c;
  private long d;
  public volatile int e;
  private long e;
  int f = 0;
  int g;
  public boolean g;
  int h;
  public boolean h;
  private int i;
  public boolean i;
  private int j;
  public boolean j;
  private boolean k = true;
  private volatile boolean l = false;
  
  public GroupSearchFragment()
  {
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_i_of_type_Boolean = false;
    this.jdField_j_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqSearchBaseModelSearchResultModelForEntrance = new SearchResultModelForEntrance("", -1, 2130840429, true);
    this.jdField_b_of_type_Long = 0L;
    this.jdField_g_of_type_Int = 0;
    this.jdField_i_of_type_Int = -1;
    this.jdField_j_of_type_Int = 0;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_b_of_type_AndroidOsHandler = new GroupSearchFragment.1(this, Looper.getMainLooper());
    this.jdField_e_of_type_Long = 0L;
  }
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 1;
    case 5: 
      return 5;
    case 4: 
      return 4;
    case 3: 
      return 3;
    case 2: 
      return 2;
    }
    return 1;
  }
  
  private int a(List<IModel> paramList)
  {
    if (paramList == null) {
      return -1;
    }
    if (paramList.size() == 0) {
      return 0;
    }
    Object localObject2 = null;
    int n = 0;
    while (n < paramList.size())
    {
      Object localObject3 = (IModel)paramList.get(n);
      Object localObject1;
      if ((localObject3 instanceof GroupSearchModeTitle))
      {
        localObject1 = (GroupSearchModeTitle)localObject3;
        ISearchResultGroupModel localISearchResultGroupModel = ((GroupSearchModeTitle)localObject1).a();
        if (localISearchResultGroupModel == null)
        {
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("getFuzzyPotision error, groupmodel is null:");
            ((StringBuilder)localObject1).append(localObject3);
            QLog.e("Q.uniteSearch.GroupSearchFragment", 2, ((StringBuilder)localObject1).toString());
            localObject1 = localObject2;
          }
        }
        else
        {
          localObject2 = localISearchResultGroupModel.a();
          localObject3 = ((GroupSearchModeTitle)localObject1).a();
          if (HardCodeUtil.a(2131705477).equals(localObject3))
          {
            localObject1 = localObject2;
          }
          else if (HardCodeUtil.a(2131705474).equals(localObject3))
          {
            localObject1 = localObject2;
          }
          else if (HardCodeUtil.a(2131705459).equals(localObject3))
          {
            localObject1 = localObject2;
          }
          else if (GroupSearchModelMostUsed.jdField_a_of_type_JavaLangString.equals(localObject3))
          {
            localObject1 = localObject2;
          }
          else if (HardCodeUtil.a(2131705455).equals(localObject3))
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
                QLog.e("Q.uniteSearch.GroupSearchFragment", 2, "getFuzzyPotision error, only has title， miniprogram");
                localObject1 = localObject2;
              }
            }
          }
          else if (((GroupSearchModeTitle)localObject1).b)
          {
            localObject1 = localObject2;
          }
          else
          {
            localObject3 = SearchEntryConfigManager.a();
            int m;
            if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (((String)localObject3).equals(((GroupSearchModeTitle)localObject1).a()))) {
              m = 1;
            } else {
              m = 0;
            }
            if (m == 0) {
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
                  localObject1 = ((GroupBaseNetSearchModelItem)localObject3).jdField_c_of_type_JavaLangString;
                  localObject3 = ((GroupBaseNetSearchModelItem)localObject3).b();
                  if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).equals(localObject3))) {
                    m = 1;
                  } else {
                    m = 0;
                  }
                }
                if (m == 0) {
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
          break label603;
          if (!(localObject3 instanceof SearchResultModelForEntrance)) {
            break;
          }
          if (!((SearchResultModelForEntrance)localObject3).b()) {
            return n;
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
        else if (((localObject3 instanceof NetSearchTemplateUniversalItem)) && (((NetSearchTemplateUniversalItem)localObject3).jdField_c_of_type_Boolean))
        {
          localObject1 = localObject2;
        }
        else
        {
          if ((localObject2 == null) || (!((List)localObject2).contains(localObject3))) {
            break label614;
          }
          localObject1 = localObject2;
        }
      }
      label603:
      n += 1;
      localObject2 = localObject1;
      continue;
      label614:
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("getFuzzyPotision, break:");
        paramList.append(localObject3);
        QLog.d("Q.uniteSearch.GroupSearchFragment", 2, paramList.toString());
      }
    }
    return n;
  }
  
  public static GroupSearchFragment a(int paramInt1, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("fromType", paramInt1);
    localBundle.putInt("source", paramInt2);
    GroupSearchFragment localGroupSearchFragment = new GroupSearchFragment();
    localGroupSearchFragment.setArguments(localBundle);
    return localGroupSearchFragment;
  }
  
  public static GroupSearchFragment a(int paramInt1, int paramInt2, long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("fromType", paramInt1);
    localBundle.putInt("source", paramInt2);
    localBundle.putLong("searchEngineKey", paramLong);
    GroupSearchFragment localGroupSearchFragment = new GroupSearchFragment();
    localGroupSearchFragment.setArguments(localBundle);
    return localGroupSearchFragment;
  }
  
  private List<Long> a()
  {
    List localList1 = new PublicAccountSearchEngine((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_i_of_type_Int).a(new SearchRequest(this.jdField_c_of_type_JavaLangString));
    if ((localList1 != null) && (localList1.size() != 0))
    {
      List localList2 = ((IPublicAccountDataManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all")).getPublicAccountList();
      ArrayList localArrayList = new ArrayList();
      int m;
      if ((localList2 != null) && (!localList2.isEmpty())) {
        m = 0;
      }
      while (m < localList1.size())
      {
        PublicAccountSearchResultModel localPublicAccountSearchResultModel = (PublicAccountSearchResultModel)localList1.get(m);
        int n = 0;
        while (n < localList2.size())
        {
          PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)localList2.get(n);
          if (TextUtils.equals(String.valueOf(localPublicAccountInfo.uin), String.valueOf(localPublicAccountSearchResultModel.a.uin))) {
            localArrayList.add(Long.valueOf(localPublicAccountInfo.uin));
          }
          n += 1;
        }
        m += 1;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "all publicAccountInfoList is null or empty");
        }
      }
      return localArrayList;
    }
    return null;
  }
  
  private void a(int paramInt, String paramString, List<IModel> paramList)
  {
    Object localObject1 = new HashMap();
    int m = 1;
    if (paramList != null) {}
    for (;;)
    {
      try
      {
        if (paramList.size() > 0)
        {
          paramList = paramList.iterator();
          if (paramList.hasNext())
          {
            localObject2 = (IModel)paramList.next();
            if (!(localObject2 instanceof GroupSearchModeTitle)) {
              continue;
            }
            localObject2 = ((GroupSearchModeTitle)localObject2).a();
            if (HardCodeUtil.a(2131705475).equals(localObject2))
            {
              ((HashMap)localObject1).put(Integer.valueOf(1), Integer.valueOf(1));
              continue;
            }
            if (HardCodeUtil.a(2131705462).equals(localObject2))
            {
              ((HashMap)localObject1).put(Integer.valueOf(2), Integer.valueOf(2));
              continue;
            }
            if (HardCodeUtil.a(2131705456).equals(localObject2))
            {
              ((HashMap)localObject1).put(Integer.valueOf(3), Integer.valueOf(3));
              continue;
            }
            if (HardCodeUtil.a(2131705454).equals(localObject2))
            {
              ((HashMap)localObject1).put(Integer.valueOf(4), Integer.valueOf(4));
              continue;
            }
            if (HardCodeUtil.a(2131705486).equals(localObject2))
            {
              ((HashMap)localObject1).put(Integer.valueOf(5), Integer.valueOf(5));
              continue;
            }
            if (HardCodeUtil.a(2131693524).equals(localObject2))
            {
              ((HashMap)localObject1).put(Integer.valueOf(6), Integer.valueOf(6));
              continue;
            }
            if (HardCodeUtil.a(2131705466).equals(localObject2))
            {
              ((HashMap)localObject1).put(Integer.valueOf(7), Integer.valueOf(7));
              continue;
            }
            if (HardCodeUtil.a(2131719439).equals(localObject2))
            {
              ((HashMap)localObject1).put(Integer.valueOf(8), Integer.valueOf(8));
              continue;
            }
            if (HardCodeUtil.a(2131705467).equals(localObject2))
            {
              ((HashMap)localObject1).put(Integer.valueOf(9), Integer.valueOf(9));
              continue;
            }
            if (HardCodeUtil.a(2131705471).equals(localObject2))
            {
              ((HashMap)localObject1).put(Integer.valueOf(10), Integer.valueOf(10));
              continue;
            }
            ((HashMap)localObject1).put(Integer.valueOf(11), Integer.valueOf(11));
            continue;
          }
        }
        if (((HashMap)localObject1).size() > 0)
        {
          paramList = new StringBuilder();
          localObject1 = ((HashMap)localObject1).values().iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (Integer)((Iterator)localObject1).next();
            if (m != 0) {
              break label551;
            }
            paramList.append("_");
            paramList.append(localObject2);
            continue;
          }
          paramList = paramList.toString();
        }
        else
        {
          paramList = "";
        }
        Object localObject2 = BaseApplicationImpl.getApplication().getRuntime();
        localObject1 = null;
        if ((localObject2 instanceof QQAppInterface)) {
          localObject1 = (QQAppInterface)localObject2;
        }
        ReportController.b((AppRuntime)localObject1, "dc00898", "", "", "0X800973C", "0X800973C", paramInt, 0, "", "", paramString, paramList);
        return;
      }
      catch (Throwable paramString)
      {
        return;
      }
      label551:
      m = 0;
    }
  }
  
  private int b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 1;
    case 5: 
      return 5;
    case 4: 
      return 4;
    case 3: 
      return 3;
    case 2: 
      return 2;
    }
    return 1;
  }
  
  private void b(List<IModel> paramList, int paramInt)
  {
    if ((paramList != null) && (paramInt == 1)) {
      paramList.remove(this.jdField_a_of_type_ComTencentMobileqqSearchBaseModelSearchResultModelForEntrance);
    }
  }
  
  private void e(List<IModel> paramList)
  {
    MostUsedFilterForMultiGroupResultLists.a(paramList, this.jdField_c_of_type_JavaLangString);
    f(paramList);
  }
  
  private void f(List<IModel> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      ArrayList localArrayList3 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList1 = new ArrayList();
      int i1 = 0;
      Object localObject;
      for (int m = 0; m < paramList.size(); m = n + 1)
      {
        IModel localIModel1 = (IModel)paramList.get(m);
        if ((localIModel1 instanceof RichSearchModelNode))
        {
          if (((RichSearchModelNode)localIModel1).c()) {
            localObject = localArrayList2;
          } else {
            localObject = localArrayList1;
          }
          if (m > 0)
          {
            IModel localIModel2 = (IModel)paramList.get(m - 1);
            if ((localIModel2 instanceof GroupSearchModeTitle))
            {
              ((List)localObject).add(localIModel2);
              localArrayList3.remove(localIModel2);
            }
          }
          ((List)localObject).add(localIModel1);
          int i2 = m + 1;
          n = m;
          if (i2 > paramList.size())
          {
            localIModel1 = (IModel)paramList.get(i2);
            n = m;
            if ((localIModel1 instanceof GroupSearchModelFooter))
            {
              ((List)localObject).add(localIModel1);
              n = i2;
            }
          }
        }
        else
        {
          if (((localIModel1 instanceof GroupSearchModelRichNode)) && (QLog.isColorLevel())) {
            QLog.e("Q.uniteSearch.GroupSearchFragment", 2, "adjustRichNodePosition, error, GroupSearchModelRichNode.");
          }
          localArrayList3.add(localIModel1);
          n = m;
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
        QLog.d("Q.uniteSearch.GroupSearchFragment", 2, ((StringBuilder)localObject).toString());
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
      int n = a(localArrayList3);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("adjustRichNodePosition, fuzzy pos:");
        ((StringBuilder)localObject).append(n);
        QLog.d("Q.uniteSearch.GroupSearchFragment", 2, ((StringBuilder)localObject).toString());
      }
      m = i1;
      if (n <= 0)
      {
        paramList.addAll(localArrayList1);
        paramList.addAll(localArrayList3);
        return;
      }
      while (m < n)
      {
        paramList.add(localArrayList3.get(m));
        m += 1;
      }
      paramList.addAll(localArrayList1);
      m = n;
      while (m < localArrayList3.size())
      {
        paramList.add(localArrayList3.get(m));
        m += 1;
      }
    }
  }
  
  protected int a()
  {
    return 0;
  }
  
  protected BaseMvpAdapter a()
  {
    return new GroupSearchAdapter(this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, this, this.jdField_i_of_type_Int);
  }
  
  protected ISearchEngine a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchEngine != null) {
      return this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchEngine;
    }
    if (this.jdField_e_of_type_Long > 0L)
    {
      Object localObject = ObjectTransfer.a().a(this.jdField_e_of_type_Long);
      if ((localObject != null) && ((localObject instanceof GroupSearchEngine)))
      {
        if (QLog.isColorLevel()) {
          QLog.i("GroupSearchFragment", 2, " use VADActivity cache engine...");
        }
        this.jdField_d_of_type_Boolean = true;
        return (GroupSearchEngine)localObject;
      }
    }
    return new GroupSearchEngine((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_i_of_type_Int);
  }
  
  public ArrayList a(List paramList)
  {
    if (paramList == null) {
      return null;
    }
    if (paramList.size() == 0) {
      return new ArrayList(paramList);
    }
    ArrayList localArrayList = ((MostUsedSearchResultManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.MOST_USE_SEARCH_MANAGER)).a(jdField_a_of_type_JavaLangString);
    return MostUsedFilterForMultiGroupResultLists.a(jdField_a_of_type_JavaLangString, localArrayList, paramList);
  }
  
  public void a(AppInterface paramAppInterface)
  {
    ThreadManager.postImmediately(new GroupSearchFragment.4(this, paramAppInterface), null, true);
  }
  
  public void a(String paramString)
  {
    QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "GroupSearchFragment log for search  startSearch   isLocalSearch");
    VADHelper.a("voice_search_als_cost");
    a(paramString, 1);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    paramString2 = new StringBuilder();
    paramString2.append("log for search onResultError, keyword = ");
    paramString2.append(paramString1);
    QLog.i("Q.uniteSearch.GroupSearchFragment", 2, paramString2.toString());
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    c();
    this.jdField_i_of_type_Boolean = false;
    this.jdField_j_of_type_Boolean = true;
    if ((this.jdField_c_of_type_JavaUtilList.size() != 1) || (!(this.jdField_c_of_type_JavaUtilList.get(0) instanceof SearchResultModelForEntrance)) || (!((SearchResultModelForEntrance)this.jdField_c_of_type_JavaUtilList.get(0)).b()))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new GroupSearchFragment.5(this));
    }
  }
  
  public void a(String paramString, boolean paramBoolean1, byte[] paramArrayOfByte, boolean paramBoolean2, List<IModel> paramList, int paramInt)
  {
    Object localObject = paramList;
    paramList = new StringBuilder();
    paramList.append("log for search onResultSuc, keyword = ");
    paramList.append(paramString);
    paramList.append(", isFirstReq = ");
    paramList.append(paramBoolean1);
    QLog.i("Q.uniteSearch.GroupSearchFragment", 2, paramList.toString());
    SearchCostStat.a();
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("onResultSuc, keyword = ");
      paramList.append(paramString);
      paramList.append(", isFirstReq = ");
      paramList.append(paramBoolean1);
      paramList.append(", cookie = ");
      paramList.append(paramArrayOfByte);
      paramList.append(", isEnd = ");
      paramList.append(paramBoolean2);
      paramList.append(", netResultItemList = ");
      paramList.append(localObject);
      QLog.d("Q.uniteSearch.GroupSearchFragment", 2, paramList.toString());
    }
    paramList = (List<IModel>)localObject;
    if (localObject == null) {
      paramList = new ArrayList();
    }
    int n;
    int i1;
    if (paramBoolean1)
    {
      m = 0;
      for (n = 0; m < paramList.size(); n = i1)
      {
        i1 = n;
        if (!(paramList.get(m) instanceof GroupSearchModeTitle)) {
          i1 = n + 1;
        }
        m += 1;
      }
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("project", UniteSearchReportController.a());
        ((JSONObject)localObject).put("event_src", "client");
        ((JSONObject)localObject).put("web_num", n);
      }
      catch (JSONException localJSONException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("e = ");
        localStringBuilder.append(localJSONException);
        QLog.e("Q.uniteSearch.GroupSearchFragment", 2, localStringBuilder.toString());
      }
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject = new ReportModelDC02528().module("all_result").action("exp_items").ver1(paramString).ver2(UniteSearchReportController.a(this.jdField_i_of_type_Int)).ver7(((JSONObject)localObject).toString());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localQQAppInterface.getCurrentAccountUin());
      localStringBuilder.append(SearchUtils.jdField_d_of_type_Long);
      UniteSearchReportController.a(localQQAppInterface, ((ReportModelDC02528)localObject).session_id(localStringBuilder.toString()));
    }
    if (paramBoolean1)
    {
      i1 = 0;
      m = 0;
      int i3;
      for (n = 0; i1 < paramList.size(); n = i3)
      {
        int i2 = m;
        i3 = n;
        if ((paramList.get(i1) instanceof GroupBaseNetSearchModelItem))
        {
          if (((GroupBaseNetSearchModelItem)paramList.get(i1)).d() == 1001) {
            m = 1;
          }
          i2 = m;
          i3 = n;
          if (((GroupBaseNetSearchModelItem)paramList.get(i1)).d() == 1001)
          {
            i3 = 1;
            i2 = m;
          }
        }
        i1 += 1;
        m = i2;
      }
      if ((m != 0) && (n != 0)) {
        m = 90;
      } else if (m != 0) {
        m = 70;
      } else if (n != 0) {
        m = 80;
      } else {
        m = 0;
      }
      if (m != 0) {
        ReportController.b(null, "CliOper", "", "", "0X8005ECF", "0X8005ECF", m, 0, "", "", "", "");
      }
    }
    this.jdField_i_of_type_Boolean = false;
    a(paramArrayOfByte);
    this.jdField_j_of_type_Boolean = paramBoolean2;
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    paramArrayOfByte = paramList.iterator();
    int m = 0;
    while (paramArrayOfByte.hasNext())
    {
      localObject = (IModel)paramArrayOfByte.next();
      if ((localObject instanceof ISearchResultGroupModel))
      {
        localObject = (ISearchResultGroupModel)localObject;
        if (((ISearchResultGroupModel)localObject).a() != null) {
          m += ((ISearchResultGroupModel)localObject).a().size();
        }
      }
      else
      {
        m += 1;
      }
    }
    if (paramBoolean1) {
      if (m > 0)
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("");
        paramArrayOfByte.append(paramString);
        SearchUtils.a("all_result", "exp_net_result", new String[] { paramArrayOfByte.toString() });
      }
      else
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("");
        paramArrayOfByte.append(paramString);
        SearchUtils.a("all_result", "noresult_net", new String[] { paramArrayOfByte.toString() });
      }
    }
    if (QLog.isColorLevel())
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("handleTabSearchResult isFirstReq==");
      paramArrayOfByte.append(paramBoolean1);
      paramArrayOfByte.append(" newSearchDataCount:");
      paramArrayOfByte.append(this.jdField_g_of_type_Int);
      paramArrayOfByte.append("   newSearchIndex:");
      paramArrayOfByte.append(this.f);
      paramArrayOfByte.append(" result.size():");
      paramArrayOfByte.append(m);
      QLog.i("Q.uniteSearch.GroupSearchFragment", 2, paramArrayOfByte.toString());
    }
    if (!this.jdField_j_of_type_Boolean)
    {
      this.jdField_g_of_type_Int += m;
      this.f += 1;
      m = 10;
      if (UniteSearchActivity.a(this.jdField_j_of_type_Int, this.jdField_i_of_type_Int)) {
        m = 20;
      }
      if (this.jdField_g_of_type_Int > m)
      {
        this.f = 0;
        this.jdField_g_of_type_Int = 0;
        this.jdField_c_of_type_Boolean = paramBoolean1;
      }
      else if (this.f >= 3)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "handleTabSearchResult 触发限频逻辑");
        }
        this.jdField_j_of_type_Boolean = true;
      }
      else
      {
        j();
        m = 1;
        break label1052;
      }
    }
    m = 0;
    label1052:
    if (m != 0)
    {
      if (this.jdField_d_of_type_JavaUtilList == null)
      {
        this.jdField_c_of_type_Boolean = paramBoolean1;
        this.jdField_d_of_type_JavaUtilList = paramList;
      }
      else
      {
        b(this.jdField_d_of_type_JavaUtilList, paramInt);
        this.jdField_d_of_type_JavaUtilList.addAll(paramList);
      }
    }
    else
    {
      c_(true);
      if ((this.jdField_d_of_type_JavaUtilList != null) && (this.jdField_d_of_type_JavaUtilList.size() > 0)) {
        paramList.addAll(0, this.jdField_d_of_type_JavaUtilList);
      } else {
        this.jdField_c_of_type_Boolean = paramBoolean1;
      }
      a(paramList, this.jdField_c_of_type_Boolean, paramInt);
      this.jdField_d_of_type_JavaUtilList = null;
      this.jdField_c_of_type_Boolean = false;
    }
    this.jdField_b_of_type_Int += 1;
    a(this.jdField_i_of_type_Int, paramString, this.jdField_c_of_type_JavaUtilList);
  }
  
  public void a(List paramList)
  {
    if (isDetached()) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate, resultList = ");
      localStringBuilder.append(paramList);
      QLog.e("Q.uniteSearch.GroupSearchFragment", 2, localStringBuilder.toString());
    }
    paramList = a(paramList);
    paramList = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(13, paramList);
    this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramList);
  }
  
  public void a(List paramList, int paramInt)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    if (isDetached()) {
      return;
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("onFinish, resultList = ");
      paramList.append(localObject);
      paramList.append(", status = ");
      paramList.append(paramInt);
      QLog.e("Q.uniteSearch.GroupSearchFragment", 2, paramList.toString());
    }
    if ((paramInt != 4) && (paramInt != 5))
    {
      if (localObject != null) {
        paramList = new ArrayList((Collection)localObject);
      } else {
        paramList = new ArrayList();
      }
    }
    else {
      paramList = a((List)localObject);
    }
    paramList = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(14, paramList);
    paramList.arg1 = paramInt;
    this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramList);
  }
  
  public void a(List paramList, SearchRespData paramSearchRespData)
  {
    if (paramSearchRespData.a(this.jdField_c_of_type_JavaLangString))
    {
      a(paramList, paramSearchRespData.jdField_a_of_type_Int);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.GroupSearchFragment", 2, new Object[] { "onFinish not match keyword1:", paramSearchRespData.jdField_a_of_type_JavaLangString, " keyword2:", this.jdField_c_of_type_JavaLangString });
    }
  }
  
  public void a(List<IModel> paramList, boolean paramBoolean, int paramInt)
  {
    c();
    Object localObject1;
    Object localObject2;
    int m;
    if (paramList.size() > 0)
    {
      n = SearchUtils.b.size();
      long l2 = -1L;
      int i2 = 0;
      while (i2 < paramList.size())
      {
        localObject1 = (IModel)paramList.get(i2);
        Object localObject3;
        long l1;
        SearchUtils.ObjectItemInfo localObjectItemInfo;
        if ((localObject1 instanceof GroupBaseNetSearchModel))
        {
          localObject2 = (GroupBaseNetSearchModel)localObject1;
          int i1 = n;
          if (((GroupBaseNetSearchModel)localObject2).a() != null)
          {
            i1 = n;
            if (((GroupBaseNetSearchModel)localObject2).a().size() > 0)
            {
              m = n;
              n = 0;
              while (n < ((GroupBaseNetSearchModel)localObject2).a().size())
              {
                localObject3 = (IModel)((GroupBaseNetSearchModel)localObject2).a().get(i2);
                if ((localObject3 instanceof NetSearchTemplateBaseItem))
                {
                  localObject1 = (NetSearchTemplateBaseItem)localObject3;
                  l1 = ((NetSearchTemplateBaseItem)localObject1).jdField_a_of_type_Long;
                  localObject1 = ((NetSearchTemplateBaseItem)localObject1).d;
                }
                else if ((localObject3 instanceof GroupBaseNetSearchModelItem))
                {
                  localObject1 = (GroupBaseNetSearchModelItem)localObject3;
                  l1 = ((GroupBaseNetSearchModelItem)localObject1).d();
                  localObject1 = ((GroupBaseNetSearchModelItem)localObject1).jdField_b_of_type_JavaLangString;
                }
                else
                {
                  localObject1 = "";
                  l1 = 0L;
                }
                localObjectItemInfo = new SearchUtils.ObjectItemInfo();
                m += 1;
                localObjectItemInfo.jdField_a_of_type_Int = m;
                localObjectItemInfo.jdField_a_of_type_Long = l1;
                localObjectItemInfo.jdField_b_of_type_JavaLangString = ((String)localObject1);
                localObjectItemInfo.jdField_a_of_type_JavaLangString = ((GroupBaseNetSearchModel)localObject2).b();
                SearchUtils.b.put(localObject3, localObjectItemInfo);
                n += 1;
              }
              i1 = m;
            }
          }
          m = i1;
          l1 = l2;
          if (l2 == -1L)
          {
            l1 = ((GroupBaseNetSearchModel)localObject2).jdField_a_of_type_Long;
            m = i1;
          }
        }
        else if ((localObject1 instanceof NetSearchTemplateHorizontalContainerItem))
        {
          n += 1;
          localObject2 = ((NetSearchTemplateHorizontalContainerItem)localObject1).a;
          m = n;
          l1 = l2;
          if (localObject2 != null)
          {
            localObject2 = ((ArrayList)localObject2).iterator();
            for (;;)
            {
              m = n;
              l1 = l2;
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localObject3 = (NetSearchTemplateHorizontalBaseItem)((Iterator)localObject2).next();
              localObjectItemInfo = new SearchUtils.ObjectItemInfo();
              localObjectItemInfo.jdField_a_of_type_Int = n;
              localObjectItemInfo.jdField_a_of_type_JavaLangString = ((NetSearchTemplateBaseItem)localObject1).b();
              SearchUtils.b.put(localObject3, localObjectItemInfo);
            }
          }
        }
        else if ((localObject1 instanceof NetSearchTemplateHorSlidingContainerItem))
        {
          n += 1;
          localObject2 = ((NetSearchTemplateHorSlidingContainerItem)localObject1).a;
          m = n;
          l1 = l2;
          if (localObject2 != null)
          {
            localObject2 = ((ArrayList)localObject2).iterator();
            for (;;)
            {
              m = n;
              l1 = l2;
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localObject3 = (NetSearchTemplateHorizontalBaseItem)((Iterator)localObject2).next();
              localObjectItemInfo = new SearchUtils.ObjectItemInfo();
              localObjectItemInfo.jdField_a_of_type_Int = n;
              localObjectItemInfo.jdField_a_of_type_JavaLangString = ((NetSearchTemplateBaseItem)localObject1).b();
              SearchUtils.b.put(localObject3, localObjectItemInfo);
            }
          }
        }
        else if ((localObject1 instanceof NetSearchTemplateBaseItem))
        {
          localObject2 = new SearchUtils.ObjectItemInfo();
          m = n + 1;
          ((SearchUtils.ObjectItemInfo)localObject2).jdField_a_of_type_Int = m;
          localObject3 = (NetSearchTemplateBaseItem)localObject1;
          ((SearchUtils.ObjectItemInfo)localObject2).jdField_a_of_type_Long = ((NetSearchTemplateBaseItem)localObject3).jdField_a_of_type_Long;
          ((SearchUtils.ObjectItemInfo)localObject2).jdField_b_of_type_JavaLangString = ((NetSearchTemplateBaseItem)localObject3).d;
          ((SearchUtils.ObjectItemInfo)localObject2).jdField_a_of_type_JavaLangString = ((NetSearchTemplateBaseItem)localObject3).b();
          SearchUtils.b.put(localObject1, localObject2);
          l1 = l2;
        }
        else if ((localObject1 instanceof GroupBaseNetSearchModelItem))
        {
          localObject2 = (GroupBaseNetSearchModelItem)localObject1;
          l1 = ((GroupBaseNetSearchModelItem)localObject2).d();
          localObject3 = ((GroupBaseNetSearchModelItem)localObject2).jdField_b_of_type_JavaLangString;
          localObjectItemInfo = new SearchUtils.ObjectItemInfo();
          m = n + 1;
          localObjectItemInfo.jdField_a_of_type_Int = m;
          localObjectItemInfo.jdField_a_of_type_Long = l1;
          localObjectItemInfo.jdField_b_of_type_JavaLangString = ((String)localObject3);
          localObjectItemInfo.jdField_a_of_type_JavaLangString = ((GroupBaseNetSearchModelItem)localObject2).b();
          SearchUtils.b.put(localObject1, localObjectItemInfo);
          l1 = l2;
        }
        else
        {
          if ((localObject1 instanceof SearchResultModelForEntrance))
          {
            localObject2 = (SearchResultModelForEntrance)localObject1;
            if (((SearchResultModelForEntrance)localObject2).jdField_a_of_type_Int == -4)
            {
              localObject3 = new SearchUtils.ObjectItemInfo();
              m = n + 1;
              ((SearchUtils.ObjectItemInfo)localObject3).jdField_a_of_type_Int = m;
              ((SearchUtils.ObjectItemInfo)localObject3).jdField_a_of_type_Long = 2073745984L;
              ((SearchUtils.ObjectItemInfo)localObject3).jdField_a_of_type_JavaLangString = ((SearchResultModelForEntrance)localObject2).c().toString();
              SearchUtils.b.put(localObject1, localObject3);
              l1 = l2;
              break label881;
            }
          }
          m = n;
          l1 = l2;
          if ((localObject1 instanceof GroupSearchModelFooter))
          {
            localObject2 = new SearchUtils.ObjectItemInfo();
            localObject3 = (GroupSearchModelFooter)localObject1;
            ((SearchUtils.ObjectItemInfo)localObject2).jdField_a_of_type_Long = ((GroupSearchModelFooter)localObject3).jdField_a_of_type_Long;
            ((SearchUtils.ObjectItemInfo)localObject2).jdField_b_of_type_JavaLangString = ((GroupSearchModelFooter)localObject3).jdField_c_of_type_JavaLangString;
            SearchUtils.b.put(localObject1, localObject2);
            l1 = l2;
            m = n;
          }
        }
        label881:
        i2 += 1;
        n = m;
        l2 = l1;
      }
    }
    if ((paramBoolean) && (this.jdField_c_of_type_JavaUtilList.isEmpty())) {
      m = 1;
    } else {
      m = 0;
    }
    this.jdField_c_of_type_JavaUtilList.addAll(paramList);
    e(this.jdField_c_of_type_JavaUtilList);
    int n = 0;
    while (n < this.jdField_c_of_type_JavaUtilList.size())
    {
      if ((this.jdField_c_of_type_JavaUtilList.get(n) instanceof NetSearchTemplateMiniAppItem))
      {
        localObject1 = new SimpleMiniAppConfig.SimpleMiniAppInfo();
        ((SimpleMiniAppConfig.SimpleMiniAppInfo)localObject1).appId = ((NetSearchTemplateMiniAppItem)this.jdField_c_of_type_JavaUtilList.get(n)).a.a.appId;
        localObject2 = new SimpleMiniAppConfig((SimpleMiniAppConfig.SimpleMiniAppInfo)localObject1);
        if (((NetSearchTemplateMiniAppItem)this.jdField_c_of_type_JavaUtilList.get(n)).a.a.showMask == 1) {
          localObject1 = "used";
        } else {
          localObject1 = "unused";
        }
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).report4239Async((SimpleMiniAppConfig)localObject2, "search", "click_button", (String)localObject1, this.jdField_c_of_type_JavaLangString);
      }
      n += 1;
    }
    if (!this.jdField_c_of_type_JavaUtilList.isEmpty())
    {
      b(this.jdField_c_of_type_JavaUtilList, paramInt);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqSearchBaseAdapterBaseMvpAdapter.a(this.jdField_c_of_type_JavaUtilList, paramBoolean);
      if (m != 0) {
        this.jdField_a_of_type_ComTencentWidgetListView.setSelection(0);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchBaseAdapterBaseMvpAdapter.a(paramList);
      this.jdField_c_of_type_JavaUtilList = paramList;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public void b(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
    jdField_a_of_type_JavaLangString = paramString;
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("GroupSearchFragment isViewCreated ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject).append(" startSearch:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("  forceRequestStatus=");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Int);
      QLog.i("Q.uniteSearch.GroupSearchFragment", 2, ((StringBuilder)localObject).toString());
    }
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null))
    {
      SearchUtils.jdField_d_of_type_Long = System.currentTimeMillis();
      SearchUtils.b.clear();
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("project", UniteSearchReportController.a());
        ((JSONObject)localObject).put("event_src", "client");
      }
      catch (JSONException localJSONException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("e = ");
        localStringBuilder.append(localJSONException);
        QLog.e("Q.uniteSearch.GroupSearchFragment", 2, localStringBuilder.toString());
      }
      SearchCostStat.a("preInitEngineCost", String.valueOf(this.jdField_c_of_type_Long));
      SearchCostStat.a("preLoadFavCost", String.valueOf(this.jdField_d_of_type_Long));
      QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface;
      localObject = new ReportModelDC02528().module("all_result").action("search_request").ver1(paramString).ver2(UniteSearchReportController.a(this.jdField_i_of_type_Int)).ver7(((JSONObject)localObject).toString());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
      localStringBuilder.append(SearchUtils.jdField_d_of_type_Long);
      UniteSearchReportController.a(localQQAppInterface, ((ReportModelDC02528)localObject).session_id(localStringBuilder.toString()));
      if ((this.jdField_i_of_type_Int == 21) && (SearchEntryConfigManager.a() == 0))
      {
        SearchUtils.a("all_result", "exp_pure_net_result", new String[] { paramString });
        this.jdField_c_of_type_Int = 6;
        b();
        a(new ArrayList(), 4);
        return;
      }
      c();
      SearchCostStat.a("isEngineInit", String.valueOf(this.jdField_d_of_type_Boolean));
      paramString = new GroupSearchFragment.2(this);
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidOsHandler.removeMessages(100);
        this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(100);
        return;
      }
      ThreadManager.postImmediately(paramString, null, true);
      return;
    }
    QLog.w("Q.uniteSearch.GroupSearchFragment", 1, "startSearchForHotWord called  isViewCreated == false!! ");
  }
  
  public boolean b()
  {
    return this.k;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_i_of_type_Boolean = false;
    this.jdField_j_of_type_Boolean = false;
    a(false);
    if (this.jdField_a_of_type_Boolean)
    {
      c_(false);
      b();
      this.jdField_a_of_type_ComTencentMobileqqSearchBaseAdapterBaseMvpAdapter.notifyDataSetChanged();
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_b_of_type_Int = 0;
  }
  
  protected boolean d()
  {
    return true;
  }
  
  public void e()
  {
    if (this.jdField_c_of_type_JavaUtilList != null) {
      this.jdField_c_of_type_JavaUtilList.clear();
    }
    if (this.jdField_d_of_type_JavaUtilList != null) {
      this.jdField_d_of_type_JavaUtilList.clear();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSearchBaseAdapterBaseMvpAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchBaseAdapterBaseMvpAdapter.a(this.jdField_c_of_type_JavaUtilList);
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchEngine == null)
    {
      QLog.i("Q.uniteSearch.GroupSearchFragment", 1, "preInitEngine searchEngine == null");
      return;
    }
    ThreadManager.postImmediately(new GroupSearchFragment.3(this), null, true);
  }
  
  public void g()
  {
    try
    {
      if (!this.jdField_d_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchEngine.a();
        this.jdField_d_of_type_Boolean = true;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void h()
  {
    c();
    this.jdField_a_of_type_ComTencentMobileqqSearchBaseAdapterBaseMvpAdapter.a(this.jdField_c_of_type_JavaUtilList);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void i()
  {
    Object localObject1;
    if (this.jdField_c_of_type_JavaLangString != null) {
      localObject1 = this.jdField_c_of_type_JavaLangString;
    } else {
      localObject1 = "";
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("log for search startNetSearch ");
    ((StringBuilder)localObject2).append((String)localObject1);
    QLog.i("Q.uniteSearch.GroupSearchFragment", 2, ((StringBuilder)localObject2).toString());
    if (!UniteSearchActivity.a(this.jdField_j_of_type_Int, this.jdField_i_of_type_Int))
    {
      localObject1 = (UniteSearchHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.UNITE_SEARCH_HANDLER);
      localObject2 = null;
    }
    else
    {
      localObject2 = (UnifySearchHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.UNIFY_SEARCH_UNITE_HANDLER);
      localObject1 = null;
    }
    double d1;
    double d2;
    if ((getQBaseActivity() instanceof LocationInterface))
    {
      d1 = ((LocationInterface)getQBaseActivity()).a();
      d2 = ((LocationInterface)getQBaseActivity()).b();
    }
    else
    {
      d1 = 0.0D;
      d2 = d1;
    }
    this.jdField_g_of_type_Int = 0;
    this.f = 0;
    boolean bool = true;
    this.jdField_i_of_type_Boolean = true;
    this.jdField_j_of_type_Boolean = false;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(System.currentTimeMillis());
    ((StringBuilder)localObject3).append("");
    this.jdField_b_of_type_JavaLangString = ((StringBuilder)localObject3).toString();
    if (!UniteSearchActivity.a(this.jdField_j_of_type_Int, this.jdField_i_of_type_Int))
    {
      if (this.jdField_c_of_type_Int == 0) {
        this.jdField_c_of_type_Int = 4;
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(this.jdField_c_of_type_JavaLangString);
      localObject3 = ((StringBuilder)localObject3).toString();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("");
      ((StringBuilder)localObject4).append(a(this.jdField_c_of_type_Int));
      SearchUtils.a("all_result", "active_net", new String[] { localObject3, ((StringBuilder)localObject4).toString() });
    }
    else
    {
      if (this.jdField_c_of_type_Int == 0) {
        this.jdField_c_of_type_Int = 4;
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(this.jdField_c_of_type_JavaLangString);
      localObject3 = ((StringBuilder)localObject3).toString();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("");
      ((StringBuilder)localObject4).append(b(this.jdField_c_of_type_Int));
      SearchUtils.a("all_result", "active_net", new String[] { localObject3, ((StringBuilder)localObject4).toString() });
    }
    localObject3 = new Bundle();
    ((Bundle)localObject3).putInt("matchCount", this.jdField_e_of_type_Int);
    ((Bundle)localObject3).putInt("source", this.jdField_j_of_type_Int);
    Object localObject4 = a();
    String str;
    List localList;
    int m;
    if (localObject1 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "log for search startNetSearch use old protocl");
      }
      localObject2 = this.jdField_c_of_type_JavaLangString;
      str = this.jdField_b_of_type_JavaLangString;
      localList = SearchUtils.a(UniteSearchHandler.b);
      m = this.jdField_c_of_type_Int;
      if (this.jdField_a_of_type_Int != 2) {
        bool = false;
      }
      ((UniteSearchHandler)localObject1).a((String)localObject2, str, 20, localList, (List)localObject4, m, null, d1, d2, false, bool, this.jdField_i_of_type_Int, (Bundle)localObject3);
    }
    else if (localObject2 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "log for search startNetSearch use new protocl");
      }
      localObject1 = this.jdField_c_of_type_JavaLangString;
      str = this.jdField_b_of_type_JavaLangString;
      localList = SearchUtils.a(UnifySearchHandler.b);
      m = this.jdField_c_of_type_Int;
      if (this.jdField_a_of_type_Int == 2) {
        bool = true;
      } else {
        bool = false;
      }
      ((UnifySearchHandler)localObject2).a((String)localObject1, str, 20, localList, (List)localObject4, m, null, d1, d2, false, bool, this.jdField_i_of_type_Int, (Bundle)localObject3);
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "log for search startNetSearch error");
    }
    SearchCostStat.a(8);
    SearchCostStat.a("NetSend");
    this.jdField_c_of_type_Int = 0;
  }
  
  public void j()
  {
    this.jdField_i_of_type_Boolean = true;
    c_(false);
    Object localObject2;
    if (!UniteSearchActivity.a(this.jdField_j_of_type_Int, this.jdField_i_of_type_Int))
    {
      localObject2 = (UniteSearchHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.UNITE_SEARCH_HANDLER);
      localObject1 = null;
    }
    else
    {
      localObject1 = (UnifySearchHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.UNIFY_SEARCH_UNITE_HANDLER);
      localObject2 = null;
    }
    c();
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    double d1;
    double d2;
    if ((getQBaseActivity() instanceof LocationInterface))
    {
      d1 = ((LocationInterface)getQBaseActivity()).a();
      d2 = ((LocationInterface)getQBaseActivity()).b();
    }
    else
    {
      d1 = 0.0D;
      d2 = d1;
    }
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(System.currentTimeMillis());
    ((StringBuilder)localObject3).append("");
    this.jdField_b_of_type_JavaLangString = ((StringBuilder)localObject3).toString();
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("start search index=");
      ((StringBuilder)localObject3).append(this.jdField_b_of_type_Int);
      QLog.i("Q.uniteSearch.GroupSearchFragmentGroupSearchFragment", 2, ((StringBuilder)localObject3).toString());
    }
    if (!UniteSearchActivity.a(this.jdField_j_of_type_Int, this.jdField_i_of_type_Int))
    {
      if (this.jdField_c_of_type_Int == 0) {
        this.jdField_c_of_type_Int = 5;
      }
    }
    else if (this.jdField_c_of_type_Int == 0) {
      this.jdField_c_of_type_Int = 5;
    }
    localObject3 = new Bundle();
    ((Bundle)localObject3).putInt("matchCount", this.jdField_e_of_type_Int);
    List localList = a();
    if (localObject2 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "startNetNewSearch use old protocol");
      }
      ((UniteSearchHandler)localObject2).a(this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, 20, SearchUtils.a(UniteSearchHandler.b), localList, this.jdField_c_of_type_Int, this.jdField_a_of_type_ArrayOfByte, d1, d2, true, this.jdField_i_of_type_Int, (Bundle)localObject3);
    }
    else
    {
      localObject2 = "Q.uniteSearch.GroupSearchFragment";
      if (localObject1 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d((String)localObject2, 2, "startNetNewSearch use new protocol");
        }
        ((UnifySearchHandler)localObject1).a(this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, 20, SearchUtils.a(UnifySearchHandler.b), localList, this.jdField_c_of_type_Int, this.jdField_a_of_type_ArrayOfByte, d1, d2, true, this.jdField_i_of_type_Int, (Bundle)localObject3);
      }
      else if (QLog.isColorLevel())
      {
        QLog.d((String)localObject2, 2, "startNetNewSearch error");
      }
    }
    this.jdField_c_of_type_Int = 0;
    Object localObject1 = new JSONObject();
    try
    {
      ((JSONObject)localObject1).put("project", UniteSearchReportController.a());
      ((JSONObject)localObject1).put("event_src", "client");
      ((JSONObject)localObject1).put("get_src", "web");
    }
    catch (JSONException localJSONException)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("e = ");
      ((StringBuilder)localObject3).append(localJSONException);
      QLog.e("Q.uniteSearch.GroupSearchFragment", 2, ((StringBuilder)localObject3).toString());
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    localObject1 = new ReportModelDC02528().module("all_result").action("load_more").ver1(this.jdField_c_of_type_JavaLangString).ver2(UniteSearchReportController.a(UniteSearchActivity.jdField_d_of_type_Int)).ver7(((JSONObject)localObject1).toString());
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(localQQAppInterface.getCurrentAccountUin());
    ((StringBuilder)localObject3).append(SearchUtils.jdField_d_of_type_Long);
    UniteSearchReportController.a(localQQAppInterface, ((ReportModelDC02528)localObject1).session_id(((StringBuilder)localObject3).toString()));
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchEngine != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchEngine.b();
      this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchEngine.e();
    }
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      this.jdField_i_of_type_Int = localBundle.getInt("fromType", -1);
      this.jdField_j_of_type_Int = localBundle.getInt("source", 0);
      this.jdField_e_of_type_Long = localBundle.getLong("searchEngineKey", 0L);
    }
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
    }
    ReportController.b(null, "CliOper", "", "", "0X8005ECE", "0X8005ECE", a(), 0, String.valueOf(this.jdField_d_of_type_Int), "", this.jdField_c_of_type_JavaLangString, "");
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_ComTencentMobileqqSearchBaseAdapterBaseMvpAdapter.notifyDataSetChanged();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramAbsListView = new StringBuilder();
    paramAbsListView.append(" onScroll");
    paramAbsListView.append(paramInt1);
    QLog.d("Q.uniteSearch.GroupSearchFragment arend ", 4, paramAbsListView.toString());
    if (this.jdField_h_of_type_Int == 0) {
      return;
    }
    if ((getQBaseActivity() instanceof UniteSearchActivity)) {
      paramAbsListView = (UniteSearchActivity)getQBaseActivity();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSearchBaseAdapterBaseMvpAdapter != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqSearchBaseAdapterBaseMvpAdapter.getCount() == 0) {
        return;
      }
      if (this.jdField_a_of_type_Int == 0) {
        return;
      }
      if ((paramInt3 - paramInt1 - paramInt2 < 10) && (!this.jdField_i_of_type_Boolean) && (!this.jdField_j_of_type_Boolean))
      {
        if (this.jdField_a_of_type_ArrayOfByte == null)
        {
          this.jdField_c_of_type_Int = 3;
          if (UniteSearchActivity.a(this.jdField_j_of_type_Int, this.jdField_i_of_type_Int)) {
            this.jdField_c_of_type_Int = 3;
          }
          i();
          c_(false);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        else
        {
          j();
        }
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    paramAbsListView = new StringBuilder();
    paramAbsListView.append(" onScrollStateChanged");
    paramAbsListView.append(paramInt);
    QLog.d("Q.uniteSearch.GroupSearchFragment", 4, paramAbsListView.toString());
    if ((getQBaseActivity() instanceof UniteSearchActivity)) {
      paramAbsListView = (UniteSearchActivity)getQBaseActivity();
    }
    this.jdField_h_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqSearchBaseAdapterBaseMvpAdapter != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqSearchBaseAdapterBaseMvpAdapter.getCount() == 0) {
        return;
      }
      if (this.jdField_a_of_type_Int == 0) {
        return;
      }
      if ((this.jdField_h_of_type_Int != 0) && (this.jdField_a_of_type_Boolean) && (!this.jdField_i_of_type_Boolean) && (!this.jdField_j_of_type_Boolean) && ((this.jdField_c_of_type_JavaUtilList == null) || (this.jdField_c_of_type_JavaUtilList.size() < 20)))
      {
        if (this.jdField_a_of_type_ArrayOfByte == null)
        {
          this.jdField_c_of_type_Int = 3;
          if (UniteSearchActivity.a(this.jdField_j_of_type_Int, this.jdField_i_of_type_Int)) {
            this.jdField_c_of_type_Int = 3;
          }
          i();
          c_(false);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        else
        {
          j();
        }
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      }
      if (paramInt == 0)
      {
        DropFrameMonitor.a().a("list_unite_search", false);
        return;
      }
      DropFrameMonitor.a().a("list_unite_search");
    }
  }
  
  public void onStart()
  {
    super.onStart();
    ((GroupSearchEngine)this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchEngine).f();
  }
  
  public void onStop()
  {
    super.onStop();
    ((GroupSearchEngine)this.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchEngine).g();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)super.getQBaseActivity().getAppRuntime().getRuntimeService(IQQAvatarService.class, "")).getInstance((AppInterface)getQBaseActivity().getAppRuntime());
    this.jdField_a_of_type_ComTencentMobileqqSearchBaseAdapterBaseMvpAdapter = a();
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqSearchBaseAdapterBaseMvpAdapter);
    b();
    this.jdField_c_of_type_AndroidWidgetTextView.setText("");
    h();
    this.jdField_a_of_type_Boolean = true;
    if ((getQBaseActivity() instanceof UniteSearchActivity))
    {
      ((UniteSearchActivity)getQBaseActivity()).a(((UniteSearchActivity)getQBaseActivity()).f, this.jdField_g_of_type_Boolean, this.jdField_h_of_type_Boolean);
      this.jdField_g_of_type_Boolean = false;
      this.jdField_h_of_type_Boolean = false;
    }
    if (SearchConfig.isUseOptimize)
    {
      f();
      a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.GroupSearchFragment
 * JD-Core Version:    0.7.0.1
 */