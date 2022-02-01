package com.tencent.mobileqq.search.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.PublicAccountDataManager;
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
import com.tencent.mobileqq.search.SearchEntryConfigManager;
import com.tencent.mobileqq.search.SearchFragmentInfoInterface;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.SearchUtil.ObjectItemInfo;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.adapter.GroupSearchAdapter;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModel;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.mobileqq.search.model.GroupSearchModeTitle;
import com.tencent.mobileqq.search.model.GroupSearchModelFooter;
import com.tencent.mobileqq.search.model.GroupSearchModelFunction;
import com.tencent.mobileqq.search.model.GroupSearchModelLocalContact;
import com.tencent.mobileqq.search.model.GroupSearchModelLocalContactApproximate;
import com.tencent.mobileqq.search.model.GroupSearchModelLocalTroop;
import com.tencent.mobileqq.search.model.GroupSearchModelMiniProgram;
import com.tencent.mobileqq.search.model.GroupSearchModelMostUsed;
import com.tencent.mobileqq.search.model.GroupSearchModelRichNode;
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.MiniProgramSearchResultModel;
import com.tencent.mobileqq.search.model.NetSearchTemplateBaseItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateHorSlidingContainerItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateHorizontalBaseItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateHorizontalContainerItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateMiniAppItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateUniversalItem;
import com.tencent.mobileqq.search.model.PublicAccountSearchResultModel;
import com.tencent.mobileqq.search.model.RichSearchModelNode;
import com.tencent.mobileqq.search.model.SearchResultModelForEntrance;
import com.tencent.mobileqq.search.mostused.MostUsedFilterForMultiGroupResultLists;
import com.tencent.mobileqq.search.mostused.MostUsedSearchResultManager;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import com.tencent.mobileqq.search.searchengine.ISearchEngine;
import com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine;
import com.tencent.mobileqq.search.searchengine.SearchRequest;
import com.tencent.mobileqq.search.searchengine.SearchRespData;
import com.tencent.mobileqq.search.util.ObjectTransfer;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.VADHelper;
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
  public volatile int e = 0;
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
  
  static
  {
    jdField_a_of_type_JavaLangString = null;
  }
  
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
    this.jdField_a_of_type_ComTencentMobileqqSearchModelSearchResultModelForEntrance = new SearchResultModelForEntrance("", -1, 2130840560, true);
    this.jdField_b_of_type_Long = 0L;
    this.jdField_g_of_type_Int = 0;
    this.jdField_i_of_type_Int = -1;
    this.jdField_j_of_type_Int = 0;
    this.jdField_b_of_type_AndroidOsHandler = new GroupSearchFragment.1(this, Looper.getMainLooper());
    this.jdField_c_of_type_Long = 0L;
  }
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 6: 
    default: 
      return 1;
    case 2: 
      return 2;
    case 3: 
      return 3;
    case 4: 
      return 4;
    }
    return 5;
  }
  
  private int a(List<IModel> paramList)
  {
    int m = 0;
    if (paramList == null) {
      m = -1;
    }
    while (paramList.size() == 0) {
      return m;
    }
    int n = 0;
    Object localObject1 = null;
    Object localObject3;
    Object localObject2;
    if (n < paramList.size())
    {
      localObject3 = (IModel)paramList.get(n);
      if ((localObject3 instanceof GroupSearchModeTitle))
      {
        localObject2 = ((GroupSearchModeTitle)localObject3).a();
        if (localObject2 == null)
        {
          localObject2 = localObject1;
          if (!QLog.isColorLevel()) {
            break label576;
          }
          QLog.e("Q.uniteSearch.GroupSearchFragment", 2, "getFuzzyPotision error, groupmodel is null:" + localObject3);
        }
      }
    }
    for (;;)
    {
      n += 1;
      break;
      localObject1 = ((ISearchResultGroupModel)localObject2).a();
      localObject2 = ((GroupSearchModeTitle)localObject3).a();
      if ((!HardCodeUtil.a(2131705404).equals(localObject2)) && (!HardCodeUtil.a(2131705401).equals(localObject2)) && (!HardCodeUtil.a(2131705386).equals(localObject2)) && (!GroupSearchModelMostUsed.jdField_a_of_type_JavaLangString.equals(localObject2)))
      {
        if (HardCodeUtil.a(2131705382).equals(localObject2))
        {
          if (localObject1 != null)
          {
            localObject2 = localObject1;
            if (((List)localObject1).size() != 0) {}
          }
          else
          {
            localObject2 = localObject1;
            if (QLog.isColorLevel()) {
              QLog.e("Q.uniteSearch.GroupSearchFragment", 2, "getFuzzyPotision error, only has title， miniprogram");
            }
          }
        }
        else
        {
          if (((GroupSearchModeTitle)localObject3).b) {
            continue;
          }
          localObject2 = SearchEntryConfigManager.a();
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).equals(((GroupSearchModeTitle)localObject3).a()))) {
            m = 1;
          }
          for (;;)
          {
            if (m != 0)
            {
              localObject2 = localObject1;
              if (localObject1 == null) {
                break label576;
              }
              if (((List)localObject1).size() == 0)
              {
                break;
                m = 0;
                continue;
              }
              if ((((List)localObject1).get(0) instanceof GroupBaseNetSearchModelItem))
              {
                localObject3 = (GroupBaseNetSearchModelItem)((List)localObject1).get(0);
                localObject2 = ((GroupBaseNetSearchModelItem)localObject3).jdField_c_of_type_JavaLangString;
                localObject3 = ((GroupBaseNetSearchModelItem)localObject3).a();
                if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!((String)localObject2).equals(localObject3))) {
                  break label390;
                }
                m = 1;
              }
              for (;;)
              {
                if (m != 0)
                {
                  break;
                  label390:
                  m = 0;
                  continue;
                  if ((localObject3 instanceof GroupSearchModelFooter))
                  {
                    localObject1 = null;
                    break;
                  }
                  if ((localObject3 instanceof SearchResultModelForEntrance))
                  {
                    if (!((SearchResultModelForEntrance)localObject3).b()) {
                      break label574;
                    }
                    localObject1 = null;
                    break;
                  }
                  if (((localObject3 instanceof GroupSearchModelMostUsed)) || ((localObject3 instanceof GroupSearchModelLocalContact)) || ((localObject3 instanceof GroupSearchModelMiniProgram)) || ((localObject3 instanceof GroupSearchModelFunction)) || ((localObject3 instanceof GroupSearchModelLocalContactApproximate)) || ((localObject3 instanceof GroupSearchModelLocalTroop)) || (((localObject3 instanceof NetSearchTemplateUniversalItem)) && (((NetSearchTemplateUniversalItem)localObject3).jdField_c_of_type_Boolean)) || ((localObject1 != null) && (((List)localObject1).contains(localObject3)))) {
                    break;
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "getFuzzyPotision, break:" + localObject3);
                  }
                }
              }
            }
          }
          label574:
          return n;
        }
        label576:
        localObject1 = localObject2;
      }
    }
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
    List localList = new PublicAccountSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_i_of_type_Int).a(new SearchRequest(this.jdField_c_of_type_JavaLangString));
    if ((localList == null) || (localList.size() == 0)) {
      return null;
    }
    ArrayList localArrayList1 = ((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).a();
    ArrayList localArrayList2 = new ArrayList();
    if ((localArrayList1 == null) || (localArrayList1.isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "all publicAccountInfoList is null or empty");
      }
    }
    for (;;)
    {
      return localArrayList2;
      int m = 0;
      while (m < localList.size())
      {
        PublicAccountSearchResultModel localPublicAccountSearchResultModel = (PublicAccountSearchResultModel)localList.get(m);
        int n = 0;
        while (n < localArrayList1.size())
        {
          PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)localArrayList1.get(n);
          if (TextUtils.equals(String.valueOf(localPublicAccountInfo.uin), String.valueOf(localPublicAccountSearchResultModel.a.uin))) {
            localArrayList2.add(Long.valueOf(localPublicAccountInfo.uin));
          }
          n += 1;
        }
        m += 1;
      }
    }
  }
  
  private void a(int paramInt, String paramString, List<IModel> paramList)
  {
    int m = 1;
    Object localObject1 = "";
    Object localObject2 = new HashMap();
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
            Object localObject3 = (IModel)paramList.next();
            if (!(localObject3 instanceof GroupSearchModeTitle)) {
              continue;
            }
            localObject3 = ((GroupSearchModeTitle)localObject3).a();
            if (HardCodeUtil.a(2131705402).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(1), Integer.valueOf(1));
              continue;
            }
            if (HardCodeUtil.a(2131705389).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(2), Integer.valueOf(2));
              continue;
            }
            if (HardCodeUtil.a(2131705383).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(3), Integer.valueOf(3));
              continue;
            }
            if (HardCodeUtil.a(2131705381).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(4), Integer.valueOf(4));
              continue;
            }
            if (HardCodeUtil.a(2131705413).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(5), Integer.valueOf(5));
              continue;
            }
            if (HardCodeUtil.a(2131693569).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(6), Integer.valueOf(6));
              continue;
            }
            if (HardCodeUtil.a(2131705393).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(7), Integer.valueOf(7));
              continue;
            }
            if (HardCodeUtil.a(2131719716).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(8), Integer.valueOf(8));
              continue;
            }
            if (HardCodeUtil.a(2131705394).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(9), Integer.valueOf(9));
              continue;
            }
            if (HardCodeUtil.a(2131705398).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(10), Integer.valueOf(10));
              continue;
            }
            ((HashMap)localObject2).put(Integer.valueOf(11), Integer.valueOf(11));
            continue;
          }
        }
        paramList = (List<IModel>)localObject1;
        if (((HashMap)localObject2).size() > 0)
        {
          paramList = new StringBuilder();
          localObject1 = ((HashMap)localObject2).values().iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (Integer)((Iterator)localObject1).next();
            if (m == 0)
            {
              paramList.append("_");
              paramList.append(localObject2);
            }
          }
          else
          {
            paramList = paramList.toString();
          }
        }
        else
        {
          localObject1 = BaseApplicationImpl.getApplication().getRuntime();
          if ((localObject1 instanceof QQAppInterface))
          {
            localObject1 = (QQAppInterface)localObject1;
            ReportController.b((AppRuntime)localObject1, "dc00898", "", "", "0X800973C", "0X800973C", paramInt, 0, "", "", paramString, paramList);
            return;
          }
          localObject1 = null;
          continue;
        }
        m = 0;
      }
      catch (Throwable paramString)
      {
        return;
      }
    }
  }
  
  private int b(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 6: 
    default: 
      return 1;
    case 2: 
      return 2;
    case 3: 
      return 3;
    case 4: 
      return 4;
    }
    return 5;
  }
  
  private void b(List<IModel> paramList, int paramInt)
  {
    if ((paramList != null) && (paramInt == 1)) {
      paramList.remove(this.jdField_a_of_type_ComTencentMobileqqSearchModelSearchResultModelForEntrance);
    }
  }
  
  private void e(List<IModel> paramList)
  {
    MostUsedFilterForMultiGroupResultLists.a(paramList, this.jdField_c_of_type_JavaLangString);
    f(paramList);
  }
  
  private void f(List<IModel> paramList)
  {
    int i1 = 0;
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      ArrayList localArrayList4 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      int m = 0;
      label91:
      int n;
      if (m < paramList.size())
      {
        IModel localIModel1 = (IModel)paramList.get(m);
        ArrayList localArrayList1;
        if ((localIModel1 instanceof RichSearchModelNode)) {
          if (((RichSearchModelNode)localIModel1).c())
          {
            localArrayList1 = localArrayList2;
            if (m > 0)
            {
              IModel localIModel2 = (IModel)paramList.get(m - 1);
              if ((localIModel2 instanceof GroupSearchModeTitle))
              {
                localArrayList1.add(localIModel2);
                localArrayList4.remove(localIModel2);
              }
            }
            localArrayList1.add(localIModel1);
            n = m;
            if (m + 1 > paramList.size())
            {
              localIModel1 = (IModel)paramList.get(m + 1);
              n = m;
              if ((localIModel1 instanceof GroupSearchModelFooter)) {
                localArrayList1.add(localIModel1);
              }
            }
          }
        }
        for (n = m + 1;; n = m)
        {
          m = n + 1;
          break;
          localArrayList1 = localArrayList3;
          break label91;
          if (((localIModel1 instanceof GroupSearchModelRichNode)) && (QLog.isColorLevel())) {
            QLog.e("Q.uniteSearch.GroupSearchFragment", 2, "adjustRichNodePosition, error, GroupSearchModelRichNode.");
          }
          localArrayList4.add(localIModel1);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "adjustRichNodePosition, total:" + paramList.size() + " exact:" + localArrayList2.size() + " fuzzy:" + localArrayList3.size() + " other:" + localArrayList4.size());
      }
      if ((localArrayList2.size() != 0) || (localArrayList3.size() != 0))
      {
        if (localArrayList3.size() == 0)
        {
          paramList.clear();
          paramList.addAll(localArrayList2);
          paramList.addAll(localArrayList4);
          return;
        }
        paramList.clear();
        paramList.addAll(localArrayList2);
        if (localArrayList4.size() == 0)
        {
          paramList.addAll(localArrayList3);
          return;
        }
        n = a(localArrayList4);
        if (QLog.isColorLevel()) {
          QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "adjustRichNodePosition, fuzzy pos:" + n);
        }
        m = i1;
        if (n <= 0)
        {
          paramList.addAll(localArrayList3);
          paramList.addAll(localArrayList4);
          return;
        }
        while (m < n)
        {
          paramList.add(localArrayList4.get(m));
          m += 1;
        }
        paramList.addAll(localArrayList3);
        m = n;
        while (m < localArrayList4.size())
        {
          paramList.add(localArrayList4.get(m));
          m += 1;
        }
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
    if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine != null) {
      return this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine;
    }
    if (this.jdField_c_of_type_Long > 0L)
    {
      Object localObject = ObjectTransfer.a().a(this.jdField_c_of_type_Long);
      if ((localObject != null) && ((localObject instanceof GroupSearchEngine)))
      {
        if (QLog.isColorLevel()) {
          QLog.i("GroupSearchFragment", 2, " use VADActivity cache engine...");
        }
        this.jdField_d_of_type_Boolean = true;
        return (GroupSearchEngine)localObject;
      }
    }
    return new GroupSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_i_of_type_Int);
  }
  
  public ArrayList a(List paramList)
  {
    if (paramList == null) {
      return null;
    }
    if (paramList.size() == 0) {
      return new ArrayList(paramList);
    }
    ArrayList localArrayList = ((MostUsedSearchResultManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MOST_USE_SEARCH_MANAGER)).a(jdField_a_of_type_JavaLangString);
    return MostUsedFilterForMultiGroupResultLists.a(jdField_a_of_type_JavaLangString, localArrayList, paramList);
  }
  
  public void a(String paramString)
  {
    QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "GroupSearchFragment log for search  startSearch   isLocalSearch");
    VADHelper.a("voice_search_als_cost");
    a(paramString, 1);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "log for search onResultError, keyword = " + paramString1);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    c();
    this.jdField_i_of_type_Boolean = false;
    this.jdField_j_of_type_Boolean = true;
    if ((this.jdField_c_of_type_JavaUtilList.size() != 1) || (!(this.jdField_c_of_type_JavaUtilList.get(0) instanceof SearchResultModelForEntrance)) || (!((SearchResultModelForEntrance)this.jdField_c_of_type_JavaUtilList.get(0)).b()))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new GroupSearchFragment.3(this));
    }
  }
  
  public void a(String paramString, boolean paramBoolean1, byte[] paramArrayOfByte, boolean paramBoolean2, List<IModel> paramList, int paramInt)
  {
    QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "log for search onResultSuc, keyword = " + paramString + ", isFirstReq = " + paramBoolean1);
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "onResultSuc, keyword = " + paramString + ", isFirstReq = " + paramBoolean1 + ", cookie = " + paramArrayOfByte + ", isEnd = " + paramBoolean2 + ", netResultItemList = " + paramList);
    }
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    int n;
    int m;
    int i1;
    if (paramBoolean1)
    {
      n = 0;
      m = 0;
      while (m < ((List)localObject).size())
      {
        i1 = n;
        if (!(((List)localObject).get(m) instanceof GroupSearchModeTitle)) {
          i1 = n + 1;
        }
        m += 1;
        n = i1;
      }
      paramList = new JSONObject();
    }
    try
    {
      paramList.put("project", UniteSearchReportController.a());
      paramList.put("event_src", "client");
      paramList.put("web_num", n);
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      UniteSearchReportController.a(localQQAppInterface, new ReportModelDC02528().module("all_result").action("exp_items").ver1(paramString).ver2(UniteSearchReportController.a(this.jdField_i_of_type_Int)).ver7(paramList.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + SearchUtil.jdField_a_of_type_Long));
      if (!paramBoolean1) {
        break label523;
      }
      m = 0;
      n = 0;
      i1 = 0;
      while (i1 < ((List)localObject).size())
      {
        int i3 = n;
        int i2 = m;
        if ((((List)localObject).get(i1) instanceof GroupBaseNetSearchModelItem))
        {
          if (((GroupBaseNetSearchModelItem)((List)localObject).get(i1)).d() == 1001) {
            m = 1;
          }
          i3 = n;
          i2 = m;
          if (((GroupBaseNetSearchModelItem)((List)localObject).get(i1)).d() == 1001)
          {
            i3 = 1;
            i2 = m;
          }
        }
        i1 += 1;
        n = i3;
        m = i2;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("Q.uniteSearch.GroupSearchFragment", 2, "e = " + localJSONException);
      }
      i1 = 0;
      if (m == 0) {
        break label632;
      }
    }
    if (n != 0)
    {
      m = 90;
      if (m != 0) {
        ReportController.b(null, "CliOper", "", "", "0X8005ECF", "0X8005ECF", m, 0, "", "", "", "");
      }
      label523:
      this.jdField_i_of_type_Boolean = false;
      a(paramArrayOfByte);
      this.jdField_j_of_type_Boolean = paramBoolean2;
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramArrayOfByte = ((List)localObject).iterator();
      m = 0;
      label568:
      if (!paramArrayOfByte.hasNext()) {
        break label669;
      }
      paramList = (IModel)paramArrayOfByte.next();
      if (!(paramList instanceof ISearchResultGroupModel)) {
        break label660;
      }
      if (((ISearchResultGroupModel)paramList).a() == null) {
        break label1089;
      }
      m = ((ISearchResultGroupModel)paramList).a().size() + m;
    }
    label660:
    label669:
    label944:
    label1083:
    label1089:
    for (;;)
    {
      break label568;
      label632:
      if (m != 0)
      {
        m = 70;
        break;
      }
      m = i1;
      if (n == 0) {
        break;
      }
      m = 80;
      break;
      m += 1;
      continue;
      if (paramBoolean1)
      {
        if (m > 0) {
          SearchUtils.a("all_result", "exp_net_result", new String[] { "" + paramString });
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "handleTabSearchResult isFirstReq==" + paramBoolean1 + " newSearchDataCount:" + this.jdField_g_of_type_Int + "   newSearchIndex:" + this.f + " result.size():" + m);
        }
        if (this.jdField_j_of_type_Boolean) {
          break label1083;
        }
        this.jdField_g_of_type_Int += m;
        this.f += 1;
        m = 10;
        if (UniteSearchActivity.a(this.jdField_j_of_type_Int, this.jdField_i_of_type_Int)) {
          m = 20;
        }
        if (this.jdField_g_of_type_Int <= m) {
          break label944;
        }
        this.f = 0;
        this.jdField_g_of_type_Int = 0;
        this.jdField_c_of_type_Boolean = paramBoolean1;
        m = 0;
      }
      for (;;)
      {
        label859:
        if (m != 0)
        {
          if (this.jdField_d_of_type_JavaUtilList == null)
          {
            this.jdField_c_of_type_Boolean = paramBoolean1;
            this.jdField_d_of_type_JavaUtilList = ((List)localObject);
          }
          for (;;)
          {
            this.jdField_b_of_type_Int += 1;
            a(this.jdField_i_of_type_Int, paramString, this.jdField_c_of_type_JavaUtilList);
            return;
            SearchUtils.a("all_result", "noresult_net", new String[] { "" + paramString });
            break;
            if (this.f >= 3)
            {
              if (QLog.isColorLevel()) {
                QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "handleTabSearchResult 触发限频逻辑");
              }
              this.jdField_j_of_type_Boolean = true;
              m = 0;
              break label859;
            }
            m = 1;
            h();
            break label859;
            b(this.jdField_d_of_type_JavaUtilList, paramInt);
            this.jdField_d_of_type_JavaUtilList.addAll((Collection)localObject);
          }
        }
        g_(true);
        if ((this.jdField_d_of_type_JavaUtilList != null) && (this.jdField_d_of_type_JavaUtilList.size() > 0)) {
          ((List)localObject).addAll(0, this.jdField_d_of_type_JavaUtilList);
        }
        for (;;)
        {
          a((List)localObject, this.jdField_c_of_type_Boolean, paramInt);
          this.jdField_d_of_type_JavaUtilList = null;
          this.jdField_c_of_type_Boolean = false;
          break;
          this.jdField_c_of_type_Boolean = paramBoolean1;
        }
        m = 0;
      }
    }
  }
  
  public void a(List paramList)
  {
    if (isDetached()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.uniteSearch.GroupSearchFragment", 2, "onUpdate, resultList = " + paramList);
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
    if (QLog.isColorLevel()) {
      QLog.e("Q.uniteSearch.GroupSearchFragment", 2, "onFinish, resultList = " + localObject + ", status = " + paramInt);
    }
    if ((paramInt == 4) || (paramInt == 5)) {
      paramList = a((List)localObject);
    }
    for (;;)
    {
      paramList = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(14, paramList);
      paramList.arg1 = paramInt;
      this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramList);
      return;
      if (localObject != null) {
        paramList = new ArrayList((Collection)localObject);
      } else {
        paramList = new ArrayList();
      }
    }
  }
  
  public void a(List paramList, SearchRespData paramSearchRespData)
  {
    if (paramSearchRespData.a(this.jdField_c_of_type_JavaLangString)) {
      a(paramList, paramSearchRespData.jdField_a_of_type_Int);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("Q.uniteSearch.GroupSearchFragment", 2, new Object[] { "onFinish not match keyword1:", paramSearchRespData.jdField_a_of_type_JavaLangString, " keyword2:", this.jdField_c_of_type_JavaLangString });
  }
  
  public void a(List<IModel> paramList, boolean paramBoolean, int paramInt)
  {
    c();
    int m;
    Object localObject2;
    int n;
    if (paramList.size() > 0)
    {
      m = SearchUtil.b.size();
      int i1 = 0;
      long l1 = -1L;
      if (i1 < paramList.size())
      {
        localObject2 = (IModel)paramList.get(i1);
        Object localObject3;
        Object localObject4;
        long l2;
        if ((localObject2 instanceof GroupBaseNetSearchModel))
        {
          localObject3 = (GroupBaseNetSearchModel)localObject2;
          n = m;
          if (((GroupBaseNetSearchModel)localObject3).a() != null)
          {
            n = m;
            if (((GroupBaseNetSearchModel)localObject3).a().size() > 0)
            {
              n = 0;
              if (n < ((GroupBaseNetSearchModel)localObject3).a().size())
              {
                localObject4 = (IModel)((GroupBaseNetSearchModel)localObject3).a().get(i1);
                l2 = 0L;
                localObject1 = "";
                if ((localObject4 instanceof NetSearchTemplateBaseItem))
                {
                  l2 = ((NetSearchTemplateBaseItem)localObject4).jdField_a_of_type_Long;
                  localObject1 = ((NetSearchTemplateBaseItem)localObject4).d;
                }
                for (;;)
                {
                  SearchUtil.ObjectItemInfo localObjectItemInfo = new SearchUtil.ObjectItemInfo();
                  m += 1;
                  localObjectItemInfo.jdField_a_of_type_Int = m;
                  localObjectItemInfo.jdField_a_of_type_Long = l2;
                  localObjectItemInfo.jdField_b_of_type_JavaLangString = ((String)localObject1);
                  localObjectItemInfo.jdField_a_of_type_JavaLangString = ((GroupBaseNetSearchModel)localObject2).b();
                  SearchUtil.b.put(localObject4, localObjectItemInfo);
                  n += 1;
                  break;
                  if ((localObject4 instanceof GroupBaseNetSearchModelItem))
                  {
                    l2 = ((GroupBaseNetSearchModelItem)localObject4).d();
                    localObject1 = ((GroupBaseNetSearchModelItem)localObject4).jdField_b_of_type_JavaLangString;
                  }
                }
              }
              n = m;
            }
          }
          l2 = l1;
          if (l1 == -1L) {
            l2 = ((GroupBaseNetSearchModel)localObject3).jdField_a_of_type_Long;
          }
          m = n;
          l1 = l2;
        }
        for (;;)
        {
          i1 += 1;
          break;
          if ((localObject2 instanceof NetSearchTemplateHorizontalContainerItem))
          {
            m += 1;
            localObject1 = ((NetSearchTemplateHorizontalContainerItem)localObject2).a;
            if (localObject1 != null)
            {
              localObject1 = ((ArrayList)localObject1).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject3 = (NetSearchTemplateHorizontalBaseItem)((Iterator)localObject1).next();
                localObject4 = new SearchUtil.ObjectItemInfo();
                ((SearchUtil.ObjectItemInfo)localObject4).jdField_a_of_type_Int = m;
                ((SearchUtil.ObjectItemInfo)localObject4).jdField_a_of_type_JavaLangString = ((NetSearchTemplateBaseItem)localObject2).a();
                SearchUtil.b.put(localObject3, localObject4);
              }
            }
          }
          else if ((localObject2 instanceof NetSearchTemplateHorSlidingContainerItem))
          {
            m += 1;
            localObject1 = ((NetSearchTemplateHorSlidingContainerItem)localObject2).a;
            if (localObject1 != null)
            {
              localObject1 = ((ArrayList)localObject1).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject3 = (NetSearchTemplateHorizontalBaseItem)((Iterator)localObject1).next();
                localObject4 = new SearchUtil.ObjectItemInfo();
                ((SearchUtil.ObjectItemInfo)localObject4).jdField_a_of_type_Int = m;
                ((SearchUtil.ObjectItemInfo)localObject4).jdField_a_of_type_JavaLangString = ((NetSearchTemplateBaseItem)localObject2).a();
                SearchUtil.b.put(localObject3, localObject4);
              }
            }
          }
          else if ((localObject2 instanceof NetSearchTemplateBaseItem))
          {
            localObject1 = new SearchUtil.ObjectItemInfo();
            m += 1;
            ((SearchUtil.ObjectItemInfo)localObject1).jdField_a_of_type_Int = m;
            ((SearchUtil.ObjectItemInfo)localObject1).jdField_a_of_type_Long = ((NetSearchTemplateBaseItem)localObject2).jdField_a_of_type_Long;
            ((SearchUtil.ObjectItemInfo)localObject1).jdField_b_of_type_JavaLangString = ((NetSearchTemplateBaseItem)localObject2).d;
            ((SearchUtil.ObjectItemInfo)localObject1).jdField_a_of_type_JavaLangString = ((NetSearchTemplateBaseItem)localObject2).a();
            SearchUtil.b.put(localObject2, localObject1);
          }
          else if ((localObject2 instanceof GroupBaseNetSearchModelItem))
          {
            l2 = ((GroupBaseNetSearchModelItem)localObject2).d();
            localObject1 = ((GroupBaseNetSearchModelItem)localObject2).jdField_b_of_type_JavaLangString;
            localObject3 = new SearchUtil.ObjectItemInfo();
            m += 1;
            ((SearchUtil.ObjectItemInfo)localObject3).jdField_a_of_type_Int = m;
            ((SearchUtil.ObjectItemInfo)localObject3).jdField_a_of_type_Long = l2;
            ((SearchUtil.ObjectItemInfo)localObject3).jdField_b_of_type_JavaLangString = ((String)localObject1);
            ((SearchUtil.ObjectItemInfo)localObject3).jdField_a_of_type_JavaLangString = ((GroupBaseNetSearchModelItem)localObject2).a();
            SearchUtil.b.put(localObject2, localObject3);
          }
          else if (((localObject2 instanceof SearchResultModelForEntrance)) && (((SearchResultModelForEntrance)localObject2).jdField_a_of_type_Int == -4))
          {
            localObject1 = new SearchUtil.ObjectItemInfo();
            m += 1;
            ((SearchUtil.ObjectItemInfo)localObject1).jdField_a_of_type_Int = m;
            ((SearchUtil.ObjectItemInfo)localObject1).jdField_a_of_type_Long = 2073745984L;
            ((SearchUtil.ObjectItemInfo)localObject1).jdField_a_of_type_JavaLangString = ((SearchResultModelForEntrance)localObject2).b().toString();
            SearchUtil.b.put(localObject2, localObject1);
          }
          else if ((localObject2 instanceof GroupSearchModelFooter))
          {
            localObject1 = new SearchUtil.ObjectItemInfo();
            ((SearchUtil.ObjectItemInfo)localObject1).jdField_a_of_type_Long = ((GroupSearchModelFooter)localObject2).jdField_a_of_type_Long;
            ((SearchUtil.ObjectItemInfo)localObject1).jdField_b_of_type_JavaLangString = ((GroupSearchModelFooter)localObject2).jdField_c_of_type_JavaLangString;
            SearchUtil.b.put(localObject2, localObject1);
          }
        }
      }
    }
    if ((paramBoolean) && (this.jdField_c_of_type_JavaUtilList.isEmpty()))
    {
      m = 1;
      this.jdField_c_of_type_JavaUtilList.addAll(paramList);
      e(this.jdField_c_of_type_JavaUtilList);
      n = 0;
      label873:
      if (n >= this.jdField_c_of_type_JavaUtilList.size()) {
        break label1035;
      }
      if ((this.jdField_c_of_type_JavaUtilList.get(n) instanceof NetSearchTemplateMiniAppItem))
      {
        localObject1 = new SimpleMiniAppConfig.SimpleMiniAppInfo();
        ((SimpleMiniAppConfig.SimpleMiniAppInfo)localObject1).appId = ((NetSearchTemplateMiniAppItem)this.jdField_c_of_type_JavaUtilList.get(n)).a.a.appId;
        localObject2 = new SimpleMiniAppConfig((SimpleMiniAppConfig.SimpleMiniAppInfo)localObject1);
        if (((NetSearchTemplateMiniAppItem)this.jdField_c_of_type_JavaUtilList.get(n)).a.a.showMask != 1) {
          break label1027;
        }
      }
    }
    label1027:
    for (Object localObject1 = "used";; localObject1 = "unused")
    {
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).report4239Async((SimpleMiniAppConfig)localObject2, "search", "click_button", (String)localObject1, this.jdField_c_of_type_JavaLangString);
      n += 1;
      break label873;
      m = 0;
      break;
    }
    label1035:
    if (!this.jdField_c_of_type_JavaUtilList.isEmpty())
    {
      b(this.jdField_c_of_type_JavaUtilList, paramInt);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter.a(this.jdField_c_of_type_JavaUtilList, paramBoolean);
      if (m != 0) {
        this.jdField_a_of_type_ComTencentWidgetListView.setSelection(0);
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter.a(paramList);
    this.jdField_c_of_type_JavaUtilList = paramList;
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
    if (QLog.isColorLevel()) {
      QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "GroupSearchFragment isViewCreated " + this.jdField_a_of_type_Boolean + " startSearch:" + paramString + "  forceRequestStatus=" + this.jdField_c_of_type_Int);
    }
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
    {
      QLog.w("Q.uniteSearch.GroupSearchFragment", 1, "startSearchForHotWord called  isViewCreated == false!! ");
      return;
    }
    SearchUtil.jdField_a_of_type_Long = System.currentTimeMillis();
    SearchUtil.b.clear();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("project", UniteSearchReportController.a());
      localJSONObject.put("event_src", "client");
      UniteSearchReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new ReportModelDC02528().module("all_result").action("search_request").ver1(paramString).ver2(UniteSearchReportController.a(this.jdField_i_of_type_Int)).ver7(localJSONObject.toString()).session_id(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + SearchUtil.jdField_a_of_type_Long));
      if ((this.jdField_i_of_type_Int == 21) && (SearchEntryConfigManager.a() == 0))
      {
        SearchUtils.a("all_result", "exp_pure_net_result", new String[] { paramString });
        this.jdField_c_of_type_Int = 6;
        b();
        a(new ArrayList(), 4);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("Q.uniteSearch.GroupSearchFragment", 2, "e = " + localJSONException);
      }
      c();
      paramString = new GroupSearchFragment.2(this);
      if (this.jdField_d_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidOsHandler.removeMessages(100);
        this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(100);
        return;
      }
      ThreadManager.postImmediately(paramString, null, true);
    }
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
      g_(false);
      b();
      this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter.notifyDataSetChanged();
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_b_of_type_Int = 0;
  }
  
  public void e()
  {
    if (this.jdField_c_of_type_JavaUtilList != null) {
      this.jdField_c_of_type_JavaUtilList.clear();
    }
    if (this.jdField_d_of_type_JavaUtilList != null) {
      this.jdField_d_of_type_JavaUtilList.clear();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter.a(this.jdField_c_of_type_JavaUtilList);
    }
  }
  
  public void f()
  {
    c();
    this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter.a(this.jdField_c_of_type_JavaUtilList);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void g()
  {
    Object localObject1 = "";
    if (this.jdField_c_of_type_JavaLangString != null) {
      localObject1 = this.jdField_c_of_type_JavaLangString;
    }
    QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "log for search startNetSearch " + (String)localObject1);
    Object localObject2;
    double d1;
    double d2;
    label254:
    Bundle localBundle;
    List localList1;
    String str;
    List localList2;
    int m;
    boolean bool;
    if (!UniteSearchActivity.a(this.jdField_j_of_type_Int, this.jdField_i_of_type_Int))
    {
      localObject1 = (UniteSearchHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.UNITE_SEARCH_HANDLER);
      localObject2 = null;
      d1 = 0.0D;
      d2 = 0.0D;
      if ((getActivity() instanceof LocationInterface))
      {
        d1 = ((LocationInterface)getActivity()).a();
        d2 = ((LocationInterface)getActivity()).b();
      }
      this.jdField_g_of_type_Int = 0;
      this.f = 0;
      this.jdField_i_of_type_Boolean = true;
      this.jdField_j_of_type_Boolean = false;
      this.jdField_b_of_type_JavaLangString = (System.currentTimeMillis() + "");
      if (UniteSearchActivity.a(this.jdField_j_of_type_Int, this.jdField_i_of_type_Int)) {
        break label405;
      }
      if (this.jdField_c_of_type_Int == 0) {
        this.jdField_c_of_type_Int = 4;
      }
      SearchUtils.a("all_result", "active_net", new String[] { "" + this.jdField_c_of_type_JavaLangString, "" + a(this.jdField_c_of_type_Int) });
      localBundle = new Bundle();
      localBundle.putInt("matchCount", this.e);
      localBundle.putInt("source", this.jdField_j_of_type_Int);
      localList1 = a();
      if (localObject1 == null) {
        break label493;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "log for search startNetSearch use old protocl");
      }
      localObject2 = this.jdField_c_of_type_JavaLangString;
      str = this.jdField_b_of_type_JavaLangString;
      localList2 = SearchUtils.a(UniteSearchHandler.b);
      m = this.jdField_c_of_type_Int;
      if (this.jdField_a_of_type_Int != 2) {
        break label487;
      }
      bool = true;
      label349:
      ((UniteSearchHandler)localObject1).a((String)localObject2, str, 20, localList2, localList1, m, null, d1, d2, false, bool, this.jdField_i_of_type_Int, localBundle);
    }
    for (;;)
    {
      this.jdField_c_of_type_Int = 0;
      return;
      localObject2 = (UnifySearchHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.UNIFY_SEARCH_UNITE_HANDLER);
      localObject1 = null;
      break;
      label405:
      if (this.jdField_c_of_type_Int == 0) {
        this.jdField_c_of_type_Int = 4;
      }
      SearchUtils.a("all_result", "active_net", new String[] { "" + this.jdField_c_of_type_JavaLangString, "" + b(this.jdField_c_of_type_Int) });
      break label254;
      label487:
      bool = false;
      break label349;
      label493:
      if (localObject2 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "log for search startNetSearch use new protocl");
        }
        localObject1 = this.jdField_c_of_type_JavaLangString;
        str = this.jdField_b_of_type_JavaLangString;
        localList2 = SearchUtils.a(UnifySearchHandler.b);
        m = this.jdField_c_of_type_Int;
        if (this.jdField_a_of_type_Int == 2) {}
        for (bool = true;; bool = false)
        {
          ((UnifySearchHandler)localObject2).a((String)localObject1, str, 20, localList2, localList1, m, null, d1, d2, false, bool, this.jdField_i_of_type_Int, localBundle);
          break;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "log for search startNetSearch error");
      }
    }
  }
  
  public void h()
  {
    this.jdField_i_of_type_Boolean = true;
    g_(false);
    Object localObject1;
    Object localObject2;
    if (!UniteSearchActivity.a(this.jdField_j_of_type_Int, this.jdField_i_of_type_Int))
    {
      localObject1 = (UniteSearchHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.UNITE_SEARCH_HANDLER);
      localObject2 = null;
    }
    for (;;)
    {
      c();
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      double d1 = 0.0D;
      double d2 = 0.0D;
      if ((getActivity() instanceof LocationInterface))
      {
        d1 = ((LocationInterface)getActivity()).a();
        d2 = ((LocationInterface)getActivity()).b();
      }
      this.jdField_b_of_type_JavaLangString = (System.currentTimeMillis() + "");
      if (QLog.isColorLevel()) {
        QLog.i("Q.uniteSearch.GroupSearchFragmentGroupSearchFragment", 2, "start search index=" + this.jdField_b_of_type_Int);
      }
      label190:
      Bundle localBundle;
      List localList;
      if (!UniteSearchActivity.a(this.jdField_j_of_type_Int, this.jdField_i_of_type_Int))
      {
        if (this.jdField_c_of_type_Int == 0) {
          this.jdField_c_of_type_Int = 5;
        }
        localBundle = new Bundle();
        localBundle.putInt("matchCount", this.e);
        localList = a();
        if (localObject1 == null) {
          break label450;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "startNetNewSearch use old protocol");
        }
        ((UniteSearchHandler)localObject1).a(this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, 20, SearchUtils.a(UniteSearchHandler.b), localList, this.jdField_c_of_type_Int, this.jdField_a_of_type_ArrayOfByte, d1, d2, true, this.jdField_i_of_type_Int, localBundle);
        label277:
        this.jdField_c_of_type_Int = 0;
        localObject1 = new JSONObject();
      }
      try
      {
        ((JSONObject)localObject1).put("project", UniteSearchReportController.a());
        ((JSONObject)localObject1).put("event_src", "client");
        ((JSONObject)localObject1).put("get_src", "web");
        localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        UniteSearchReportController.a((QQAppInterface)localObject2, new ReportModelDC02528().module("all_result").action("load_more").ver1(this.jdField_c_of_type_JavaLangString).ver2(UniteSearchReportController.a(UniteSearchActivity.jdField_d_of_type_Int)).ver7(((JSONObject)localObject1).toString()).session_id(((QQAppInterface)localObject2).getCurrentAccountUin() + SearchUtil.jdField_a_of_type_Long));
        return;
        localObject2 = (UnifySearchHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.UNIFY_SEARCH_UNITE_HANDLER);
        localObject1 = null;
        continue;
        if (this.jdField_c_of_type_Int != 0) {
          break label190;
        }
        this.jdField_c_of_type_Int = 5;
        break label190;
        label450:
        if (localObject2 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "startNetNewSearch use new protocol");
          }
          ((UnifySearchHandler)localObject2).a(this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, 20, SearchUtils.a(UnifySearchHandler.b), localList, this.jdField_c_of_type_Int, this.jdField_a_of_type_ArrayOfByte, d1, d2, true, this.jdField_i_of_type_Int, localBundle);
          break label277;
        }
        if (!QLog.isColorLevel()) {
          break label277;
        }
        QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "startNetNewSearch error");
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QLog.e("Q.uniteSearch.GroupSearchFragment", 2, "e = " + localJSONException);
        }
      }
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine.b();
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine.e();
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
      this.jdField_c_of_type_Long = localBundle.getLong("searchEngineKey", 0L);
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
    this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter.notifyDataSetChanged();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.d("Q.uniteSearch.GroupSearchFragment arend ", 4, " onScroll" + paramInt1);
    if (this.jdField_h_of_type_Int == 0) {}
    do
    {
      return;
      if ((getActivity() instanceof UniteSearchActivity)) {
        paramAbsListView = (UniteSearchActivity)getActivity();
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter.getCount() == 0) || (this.jdField_a_of_type_Int == 0) || (paramInt3 - paramInt1 - paramInt2 >= 10) || (this.jdField_i_of_type_Boolean) || (this.jdField_j_of_type_Boolean));
    if (this.jdField_a_of_type_ArrayOfByte == null)
    {
      this.jdField_c_of_type_Int = 3;
      if (UniteSearchActivity.a(this.jdField_j_of_type_Int, this.jdField_i_of_type_Int)) {
        this.jdField_c_of_type_Int = 3;
      }
      g();
      g_(false);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      return;
      h();
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    QLog.d("Q.uniteSearch.GroupSearchFragment", 4, " onScrollStateChanged" + paramInt);
    if ((getActivity() instanceof UniteSearchActivity)) {
      paramAbsListView = (UniteSearchActivity)getActivity();
    }
    this.jdField_h_of_type_Int = paramInt;
    if ((this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter.getCount() == 0)) {}
    while (this.jdField_a_of_type_Int == 0) {
      return;
    }
    if ((this.jdField_h_of_type_Int != 0) && (this.jdField_a_of_type_Boolean) && (!this.jdField_i_of_type_Boolean) && (!this.jdField_j_of_type_Boolean) && ((this.jdField_c_of_type_JavaUtilList == null) || (this.jdField_c_of_type_JavaUtilList.size() < 20)))
    {
      if (this.jdField_a_of_type_ArrayOfByte != null) {
        break label195;
      }
      this.jdField_c_of_type_Int = 3;
      if (UniteSearchActivity.a(this.jdField_j_of_type_Int, this.jdField_i_of_type_Int)) {
        this.jdField_c_of_type_Int = 3;
      }
      g();
      g_(false);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      if (paramInt != 0) {
        break;
      }
      DropFrameMonitor.a().a("list_unite_search", false);
      return;
      label195:
      h();
    }
    DropFrameMonitor.a().a("list_unite_search");
  }
  
  public void onStart()
  {
    super.onStart();
    ((GroupSearchEngine)this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine).f();
  }
  
  public void onStop()
  {
    super.onStop();
    ((GroupSearchEngine)this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine).g();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)super.getActivity().app.getRuntimeService(IQQAvatarService.class, "")).getInstance(super.getActivity().app);
    this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter = a();
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter);
    b();
    this.jdField_c_of_type_AndroidWidgetTextView.setText("");
    f();
    this.jdField_a_of_type_Boolean = true;
    if ((getActivity() instanceof UniteSearchActivity))
    {
      ((UniteSearchActivity)getActivity()).a(((UniteSearchActivity)getActivity()).f, this.jdField_g_of_type_Boolean, this.jdField_h_of_type_Boolean);
      this.jdField_g_of_type_Boolean = false;
      this.jdField_h_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.GroupSearchFragment
 * JD-Core Version:    0.7.0.1
 */