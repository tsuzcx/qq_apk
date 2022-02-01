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
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
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
import com.tencent.mobileqq.search.business.group.model.GroupSearchModelFooter;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateBaseItem;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateHorizontalBaseItem;
import com.tencent.mobileqq.search.config.SearchConfig;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModel;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.mobileqq.search.model.GroupSearchModeTitle;
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
import com.tencent.mobileqq.search.util.GroupSearchResultHandler;
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
  public boolean G = false;
  public volatile int H = 0;
  public volatile int I = 0;
  protected SearchResultModelForEntrance J = new SearchResultModelForEntrance("", -1, 2130841185, true);
  protected SearchResultModelForEntrance K;
  protected long L = 0L;
  byte[] M;
  int N = 0;
  int O = 0;
  int P;
  public Handler Q = new GroupSearchFragment.1(this, Looper.getMainLooper());
  private int R = -1;
  private int S = 0;
  private boolean T;
  private GroupSearchResultHandler U;
  private long V = 0L;
  private long W = 0L;
  private long X = 0L;
  private boolean Y = true;
  private volatile boolean Z = false;
  public volatile int b;
  public boolean c;
  public boolean d = false;
  public boolean e = false;
  public long f = 0L;
  public int g = 0;
  public String h = "";
  public boolean i = false;
  
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
  
  private void a(int paramInt, String paramString, List<IModel> paramList)
  {
    Object localObject1 = new HashMap();
    int j = 1;
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
            if (HardCodeUtil.a(2131903363).equals(localObject2))
            {
              ((HashMap)localObject1).put(Integer.valueOf(1), Integer.valueOf(1));
              continue;
            }
            if (HardCodeUtil.a(2131903350).equals(localObject2))
            {
              ((HashMap)localObject1).put(Integer.valueOf(2), Integer.valueOf(2));
              continue;
            }
            if (HardCodeUtil.a(2131903344).equals(localObject2))
            {
              ((HashMap)localObject1).put(Integer.valueOf(3), Integer.valueOf(3));
              continue;
            }
            if (HardCodeUtil.a(2131903342).equals(localObject2))
            {
              ((HashMap)localObject1).put(Integer.valueOf(4), Integer.valueOf(4));
              continue;
            }
            if (HardCodeUtil.a(2131903374).equals(localObject2))
            {
              ((HashMap)localObject1).put(Integer.valueOf(5), Integer.valueOf(5));
              continue;
            }
            if (HardCodeUtil.a(2131891080).equals(localObject2))
            {
              ((HashMap)localObject1).put(Integer.valueOf(6), Integer.valueOf(6));
              continue;
            }
            if (HardCodeUtil.a(2131903354).equals(localObject2))
            {
              ((HashMap)localObject1).put(Integer.valueOf(7), Integer.valueOf(7));
              continue;
            }
            if (HardCodeUtil.a(2131916999).equals(localObject2))
            {
              ((HashMap)localObject1).put(Integer.valueOf(8), Integer.valueOf(8));
              continue;
            }
            if (HardCodeUtil.a(2131903355).equals(localObject2))
            {
              ((HashMap)localObject1).put(Integer.valueOf(9), Integer.valueOf(9));
              continue;
            }
            if (HardCodeUtil.a(2131903359).equals(localObject2))
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
            if (j != 0) {
              break label537;
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
      label537:
      j = 0;
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
      paramList.remove(this.J);
    }
  }
  
  private void f(List<IModel> paramList)
  {
    Object localObject = paramList;
    if (this.T) {
      localObject = this.U.b(paramList, this.R);
    }
    this.r = ((List)localObject);
    this.m.a(this.r);
  }
  
  private boolean t()
  {
    return ((IFeatureRuntimeService)this.p.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("Search_Manage749_864531067");
  }
  
  private List<Long> u()
  {
    List localList1 = new PublicAccountSearchEngine((QQAppInterface)this.p, this.R).a(new SearchRequest(this.q));
    if ((localList1 != null) && (localList1.size() != 0))
    {
      List localList2 = ((IPublicAccountDataManager)this.p.getRuntimeService(IPublicAccountDataManager.class, "all")).getPublicAccountList();
      ArrayList localArrayList = new ArrayList();
      int j;
      if ((localList2 != null) && (!localList2.isEmpty())) {
        j = 0;
      }
      while (j < localList1.size())
      {
        PublicAccountSearchResultModel localPublicAccountSearchResultModel = (PublicAccountSearchResultModel)localList1.get(j);
        int k = 0;
        while (k < localList2.size())
        {
          PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)localList2.get(k);
          if (TextUtils.equals(String.valueOf(localPublicAccountInfo.uin), String.valueOf(localPublicAccountSearchResultModel.a.uin))) {
            localArrayList.add(Long.valueOf(localPublicAccountInfo.uin));
          }
          k += 1;
        }
        j += 1;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "all publicAccountInfoList is null or empty");
        }
      }
      return localArrayList;
    }
    return null;
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
    this.y.setVisibility(8);
    i();
    this.i = false;
    this.G = true;
    if ((this.r.size() != 1) || (!(this.r.get(0) instanceof SearchResultModelForEntrance)) || (!((SearchResultModelForEntrance)this.r.get(0)).i()))
    {
      this.z.setVisibility(0);
      this.z.setOnClickListener(new GroupSearchFragment.5(this));
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
    int k;
    int m;
    if (paramBoolean1)
    {
      j = 0;
      for (k = 0; j < paramList.size(); k = m)
      {
        m = k;
        if (!(paramList.get(j) instanceof GroupSearchModeTitle)) {
          m = k + 1;
        }
        j += 1;
      }
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("project", UniteSearchReportController.a());
        ((JSONObject)localObject).put("event_src", "client");
        ((JSONObject)localObject).put("web_num", k);
      }
      catch (JSONException localJSONException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("e = ");
        localStringBuilder.append(localJSONException);
        QLog.e("Q.uniteSearch.GroupSearchFragment", 2, localStringBuilder.toString());
      }
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject = new ReportModelDC02528().module("all_result").action("exp_items").ver1(paramString).ver2(UniteSearchReportController.a(this.R)).ver7(((JSONObject)localObject).toString());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localQQAppInterface.getCurrentAccountUin());
      localStringBuilder.append(SearchUtils.j);
      UniteSearchReportController.a(localQQAppInterface, ((ReportModelDC02528)localObject).session_id(localStringBuilder.toString()));
    }
    if (paramBoolean1)
    {
      m = 0;
      j = 0;
      int i1;
      for (k = 0; m < paramList.size(); k = i1)
      {
        int n = j;
        i1 = k;
        if ((paramList.get(m) instanceof GroupBaseNetSearchModelItem))
        {
          if (((GroupBaseNetSearchModelItem)paramList.get(m)).j() == 1001) {
            j = 1;
          }
          n = j;
          i1 = k;
          if (((GroupBaseNetSearchModelItem)paramList.get(m)).j() == 1001)
          {
            i1 = 1;
            n = j;
          }
        }
        m += 1;
        j = n;
      }
      if ((j != 0) && (k != 0)) {
        j = 90;
      } else if (j != 0) {
        j = 70;
      } else if (k != 0) {
        j = 80;
      } else {
        j = 0;
      }
      if (j != 0) {
        ReportController.b(null, "CliOper", "", "", "0X8005ECF", "0X8005ECF", j, 0, "", "", "", "");
      }
    }
    this.i = false;
    a(paramArrayOfByte);
    this.G = paramBoolean2;
    this.y.setVisibility(8);
    this.z.setVisibility(8);
    paramArrayOfByte = paramList.iterator();
    int j = 0;
    while (paramArrayOfByte.hasNext())
    {
      localObject = (IModel)paramArrayOfByte.next();
      if ((localObject instanceof ISearchResultGroupModel))
      {
        localObject = (ISearchResultGroupModel)localObject;
        if (((ISearchResultGroupModel)localObject).b() != null) {
          j += ((ISearchResultGroupModel)localObject).b().size();
        }
      }
      else
      {
        j += 1;
      }
    }
    if (paramBoolean1) {
      if (j > 0)
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
      paramArrayOfByte.append(this.O);
      paramArrayOfByte.append("   newSearchIndex:");
      paramArrayOfByte.append(this.N);
      paramArrayOfByte.append(" result.size():");
      paramArrayOfByte.append(j);
      QLog.i("Q.uniteSearch.GroupSearchFragment", 2, paramArrayOfByte.toString());
    }
    if (!this.G)
    {
      this.O += j;
      this.N += 1;
      j = 10;
      if (UniteSearchActivity.a(this.S, this.R)) {
        j = 20;
      }
      if (this.O > j)
      {
        this.N = 0;
        this.O = 0;
        this.t = paramBoolean1;
      }
      else if (this.N >= 3)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "handleTabSearchResult 触发限频逻辑");
        }
        this.G = true;
      }
      else
      {
        r();
        j = 1;
        break label1050;
      }
    }
    j = 0;
    label1050:
    if (j != 0)
    {
      if (this.s == null)
      {
        this.t = paramBoolean1;
        this.s = paramList;
      }
      else
      {
        b(this.s, paramInt);
        this.s.addAll(paramList);
      }
    }
    else
    {
      h_(true);
      if ((this.s != null) && (this.s.size() > 0)) {
        paramList.addAll(0, this.s);
      } else {
        this.t = paramBoolean1;
      }
      a(this.U.a(paramList, this.R), this.t, paramInt);
      this.s = null;
      this.t = false;
    }
    this.g += 1;
    SearchCostStat.a();
    a(this.R, paramString, this.r);
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
    paramList = e(paramList);
    paramList = this.Q.obtainMessage(13, paramList);
    this.Q.sendMessage(paramList);
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
      paramList = e((List)localObject);
    }
    paramList = this.Q.obtainMessage(14, paramList);
    paramList.arg1 = paramInt;
    this.Q.sendMessage(paramList);
  }
  
  public void a(List paramList, SearchRespData paramSearchRespData)
  {
    if (paramSearchRespData.a(this.q))
    {
      a(paramList, paramSearchRespData.b);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.GroupSearchFragment", 2, new Object[] { "onFinish not match keyword1:", paramSearchRespData.a, " keyword2:", this.q });
    }
  }
  
  public void a(List<IModel> paramList, boolean paramBoolean, int paramInt)
  {
    i();
    Object localObject1;
    Object localObject2;
    int j;
    if (paramList.size() > 0)
    {
      k = SearchUtils.l.size();
      long l2 = -1L;
      int n = 0;
      while (n < paramList.size())
      {
        localObject1 = (IModel)paramList.get(n);
        Object localObject3;
        long l1;
        SearchUtils.ObjectItemInfo localObjectItemInfo;
        if ((localObject1 instanceof GroupBaseNetSearchModel))
        {
          localObject2 = (GroupBaseNetSearchModel)localObject1;
          int m = k;
          if (((GroupBaseNetSearchModel)localObject2).b() != null)
          {
            m = k;
            if (((GroupBaseNetSearchModel)localObject2).b().size() > 0)
            {
              j = k;
              k = 0;
              while (k < ((GroupBaseNetSearchModel)localObject2).b().size())
              {
                localObject3 = (IModel)((GroupBaseNetSearchModel)localObject2).b().get(n);
                if ((localObject3 instanceof NetSearchTemplateBaseItem))
                {
                  localObject1 = (NetSearchTemplateBaseItem)localObject3;
                  l1 = ((NetSearchTemplateBaseItem)localObject1).i;
                  localObject1 = ((NetSearchTemplateBaseItem)localObject1).h;
                }
                else if ((localObject3 instanceof GroupBaseNetSearchModelItem))
                {
                  localObject1 = (GroupBaseNetSearchModelItem)localObject3;
                  l1 = ((GroupBaseNetSearchModelItem)localObject1).j();
                  localObject1 = ((GroupBaseNetSearchModelItem)localObject1).b;
                }
                else
                {
                  localObject1 = "";
                  l1 = 0L;
                }
                localObjectItemInfo = new SearchUtils.ObjectItemInfo();
                j += 1;
                localObjectItemInfo.c = j;
                localObjectItemInfo.b = l1;
                localObjectItemInfo.e = ((String)localObject1);
                localObjectItemInfo.a = ((GroupBaseNetSearchModel)localObject2).c();
                SearchUtils.l.put(localObject3, localObjectItemInfo);
                k += 1;
              }
              m = j;
            }
          }
          j = m;
          l1 = l2;
          if (l2 == -1L)
          {
            l1 = ((GroupBaseNetSearchModel)localObject2).a;
            j = m;
          }
        }
        else if ((localObject1 instanceof NetSearchTemplateHorizontalContainerItem))
        {
          k += 1;
          localObject2 = ((NetSearchTemplateHorizontalContainerItem)localObject1).c;
          j = k;
          l1 = l2;
          if (localObject2 != null)
          {
            localObject2 = ((ArrayList)localObject2).iterator();
            for (;;)
            {
              j = k;
              l1 = l2;
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localObject3 = (NetSearchTemplateHorizontalBaseItem)((Iterator)localObject2).next();
              localObjectItemInfo = new SearchUtils.ObjectItemInfo();
              localObjectItemInfo.c = k;
              localObjectItemInfo.a = ((NetSearchTemplateBaseItem)localObject1).g();
              SearchUtils.l.put(localObject3, localObjectItemInfo);
            }
          }
        }
        else if ((localObject1 instanceof NetSearchTemplateHorSlidingContainerItem))
        {
          k += 1;
          localObject2 = ((NetSearchTemplateHorSlidingContainerItem)localObject1).v;
          j = k;
          l1 = l2;
          if (localObject2 != null)
          {
            localObject2 = ((ArrayList)localObject2).iterator();
            for (;;)
            {
              j = k;
              l1 = l2;
              if (!((Iterator)localObject2).hasNext()) {
                break;
              }
              localObject3 = (NetSearchTemplateHorizontalBaseItem)((Iterator)localObject2).next();
              localObjectItemInfo = new SearchUtils.ObjectItemInfo();
              localObjectItemInfo.c = k;
              localObjectItemInfo.a = ((NetSearchTemplateBaseItem)localObject1).g();
              SearchUtils.l.put(localObject3, localObjectItemInfo);
            }
          }
        }
        else if ((localObject1 instanceof NetSearchTemplateBaseItem))
        {
          localObject2 = new SearchUtils.ObjectItemInfo();
          j = k + 1;
          ((SearchUtils.ObjectItemInfo)localObject2).c = j;
          localObject3 = (NetSearchTemplateBaseItem)localObject1;
          ((SearchUtils.ObjectItemInfo)localObject2).b = ((NetSearchTemplateBaseItem)localObject3).i;
          ((SearchUtils.ObjectItemInfo)localObject2).e = ((NetSearchTemplateBaseItem)localObject3).h;
          ((SearchUtils.ObjectItemInfo)localObject2).a = ((NetSearchTemplateBaseItem)localObject3).g();
          SearchUtils.l.put(localObject1, localObject2);
          l1 = l2;
        }
        else if ((localObject1 instanceof GroupBaseNetSearchModelItem))
        {
          localObject2 = (GroupBaseNetSearchModelItem)localObject1;
          l1 = ((GroupBaseNetSearchModelItem)localObject2).j();
          localObject3 = ((GroupBaseNetSearchModelItem)localObject2).b;
          localObjectItemInfo = new SearchUtils.ObjectItemInfo();
          j = k + 1;
          localObjectItemInfo.c = j;
          localObjectItemInfo.b = l1;
          localObjectItemInfo.e = ((String)localObject3);
          localObjectItemInfo.a = ((GroupBaseNetSearchModelItem)localObject2).g();
          SearchUtils.l.put(localObject1, localObjectItemInfo);
          l1 = l2;
        }
        else
        {
          if ((localObject1 instanceof SearchResultModelForEntrance))
          {
            localObject2 = (SearchResultModelForEntrance)localObject1;
            if (((SearchResultModelForEntrance)localObject2).c == -4)
            {
              localObject3 = new SearchUtils.ObjectItemInfo();
              j = k + 1;
              ((SearchUtils.ObjectItemInfo)localObject3).c = j;
              ((SearchUtils.ObjectItemInfo)localObject3).b = 2073745984L;
              ((SearchUtils.ObjectItemInfo)localObject3).a = ((SearchResultModelForEntrance)localObject2).e().toString();
              SearchUtils.l.put(localObject1, localObject3);
              l1 = l2;
              break label881;
            }
          }
          j = k;
          l1 = l2;
          if ((localObject1 instanceof GroupSearchModelFooter))
          {
            localObject2 = new SearchUtils.ObjectItemInfo();
            localObject3 = (GroupSearchModelFooter)localObject1;
            ((SearchUtils.ObjectItemInfo)localObject2).b = ((GroupSearchModelFooter)localObject3).d;
            ((SearchUtils.ObjectItemInfo)localObject2).e = ((GroupSearchModelFooter)localObject3).e;
            SearchUtils.l.put(localObject1, localObject2);
            l1 = l2;
            j = k;
          }
        }
        label881:
        n += 1;
        k = j;
        l2 = l1;
      }
    }
    if ((paramBoolean) && (this.r.isEmpty())) {
      j = 1;
    } else {
      j = 0;
    }
    this.r.addAll(paramList);
    this.U.a(this.r, this.q);
    int k = 0;
    while (k < this.r.size())
    {
      if ((this.r.get(k) instanceof NetSearchTemplateMiniAppItem))
      {
        localObject1 = new SimpleMiniAppConfig.SimpleMiniAppInfo();
        ((SimpleMiniAppConfig.SimpleMiniAppInfo)localObject1).appId = ((NetSearchTemplateMiniAppItem)this.r.get(k)).a.a.appId;
        localObject2 = new SimpleMiniAppConfig((SimpleMiniAppConfig.SimpleMiniAppInfo)localObject1);
        if (((NetSearchTemplateMiniAppItem)this.r.get(k)).a.a.showMask == 1) {
          localObject1 = "used";
        } else {
          localObject1 = "unused";
        }
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).report4239Async((SimpleMiniAppConfig)localObject2, "search", "click_button", (String)localObject1, this.q);
      }
      k += 1;
    }
    if (!this.r.isEmpty())
    {
      b(this.r, paramInt);
      this.x.setVisibility(8);
      f(this.r);
      if (j != 0) {
        this.l.setSelection(0);
      }
    }
    else
    {
      f(paramList);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.Y = paramBoolean;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.M = paramArrayOfByte;
  }
  
  protected BaseMvpAdapter b()
  {
    return new GroupSearchAdapter(this.l, this.n, this, this.R);
  }
  
  public void b(String paramString)
  {
    this.q = paramString;
    a = paramString;
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("GroupSearchFragment isViewCreated ");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append(" startSearch:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("  forceRequestStatus=");
      ((StringBuilder)localObject).append(this.H);
      QLog.i("Q.uniteSearch.GroupSearchFragment", 2, ((StringBuilder)localObject).toString());
    }
    if ((this.c) && (this.p != null))
    {
      SearchUtils.j = System.currentTimeMillis();
      SearchUtils.l.clear();
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
      SearchCostStat.a("preInitEngineCost", String.valueOf(this.V));
      SearchCostStat.a("preLoadFavCost", String.valueOf(this.W));
      QQAppInterface localQQAppInterface = (QQAppInterface)this.p;
      localObject = new ReportModelDC02528().module("all_result").action("search_request").ver1(paramString).ver2(UniteSearchReportController.a(this.R)).ver7(((JSONObject)localObject).toString());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.p.getCurrentAccountUin());
      localStringBuilder.append(SearchUtils.j);
      UniteSearchReportController.a(localQQAppInterface, ((ReportModelDC02528)localObject).session_id(localStringBuilder.toString()));
      if ((this.R == 21) && (SearchEntryConfigManager.a() == 0))
      {
        SearchUtils.a("all_result", "exp_pure_net_result", new String[] { paramString });
        this.H = 6;
        h();
        a(new ArrayList(), 4);
        return;
      }
      i();
      SearchCostStat.a("isEngineInit", String.valueOf(this.u));
      paramString = new GroupSearchFragment.2(this);
      if (this.u)
      {
        this.Q.removeMessages(100);
        this.Q.sendEmptyMessage(100);
        return;
      }
      ThreadManager.postImmediately(paramString, null, true);
      return;
    }
    QLog.w("Q.uniteSearch.GroupSearchFragment", 1, "startSearchForHotWord called  isViewCreated == false!! ");
  }
  
  protected ISearchEngine c()
  {
    if (this.o != null) {
      return this.o;
    }
    if (this.X > 0L)
    {
      Object localObject = ObjectTransfer.a().a(this.X);
      if ((localObject != null) && ((localObject instanceof GroupSearchEngine)))
      {
        if (QLog.isColorLevel()) {
          QLog.i("GroupSearchFragment", 2, " use VADActivity cache engine...");
        }
        this.u = true;
        return (GroupSearchEngine)localObject;
      }
    }
    return new GroupSearchEngine((QQAppInterface)this.p, this.R);
  }
  
  protected boolean cj_()
  {
    return false;
  }
  
  public boolean dm_()
  {
    return this.Y;
  }
  
  public ArrayList e(List paramList)
  {
    if (paramList == null) {
      return null;
    }
    if (paramList.size() == 0) {
      return new ArrayList(paramList);
    }
    ArrayList localArrayList = ((MostUsedSearchResultManager)this.p.getManager(QQManagerFactory.MOST_USE_SEARCH_MANAGER)).a(a);
    return MostUsedFilterForMultiGroupResultLists.a(a, localArrayList, paramList);
  }
  
  public void f()
  {
    this.b = 0;
    this.h = "";
    this.i = false;
    this.G = false;
    a(false);
    if (this.c)
    {
      h_(false);
      h();
      this.m.notifyDataSetChanged();
      this.y.setVisibility(8);
      this.z.setVisibility(8);
    }
    this.g = 0;
  }
  
  protected boolean k()
  {
    return true;
  }
  
  protected int l()
  {
    return 0;
  }
  
  public void m()
  {
    if (this.r != null) {
      this.r.clear();
    }
    if (this.s != null) {
      this.s.clear();
    }
    if (this.m != null) {
      f(this.r);
    }
  }
  
  public void n()
  {
    if (this.o == null)
    {
      QLog.i("Q.uniteSearch.GroupSearchFragment", 1, "preInitEngine searchEngine == null");
      return;
    }
    ThreadManager.postImmediately(new GroupSearchFragment.3(this), null, true);
  }
  
  public void o()
  {
    try
    {
      if (!this.u)
      {
        this.o.a();
        this.u = true;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      this.R = localBundle.getInt("fromType", -1);
      this.S = localBundle.getInt("source", 0);
      this.X = localBundle.getLong("searchEngineKey", 0L);
    }
    super.onCreate(paramBundle);
    this.T = t();
    this.U = new GroupSearchResultHandler();
  }
  
  public void onDestroy()
  {
    if (this.n != null) {
      this.n.destory();
    }
    ReportController.b(null, "CliOper", "", "", "0X8005ECE", "0X8005ECE", l(), 0, String.valueOf(this.D), "", this.q, "");
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.c = false;
  }
  
  public void onResume()
  {
    super.onResume();
    this.m.notifyDataSetChanged();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramAbsListView = new StringBuilder();
    paramAbsListView.append(" onScroll");
    paramAbsListView.append(paramInt1);
    QLog.d("Q.uniteSearch.GroupSearchFragment arend ", 4, paramAbsListView.toString());
    if (this.P == 0) {
      return;
    }
    if ((getQBaseActivity() instanceof UniteSearchActivity)) {
      paramAbsListView = (UniteSearchActivity)getQBaseActivity();
    }
    if (this.m != null)
    {
      if (this.m.getCount() == 0) {
        return;
      }
      if (this.b == 0) {
        return;
      }
      if ((paramInt3 - paramInt1 - paramInt2 < 10) && (!this.i) && (!this.G))
      {
        if (this.M == null)
        {
          this.H = 3;
          if (UniteSearchActivity.a(this.S, this.R)) {
            this.H = 3;
          }
          q();
          h_(false);
          this.z.setVisibility(8);
        }
        else
        {
          r();
        }
        this.y.setVisibility(0);
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
    this.P = paramInt;
    if (this.m != null)
    {
      if (this.m.getCount() == 0) {
        return;
      }
      if (this.b == 0) {
        return;
      }
      if ((this.P != 0) && (this.c) && (!this.i) && (!this.G) && ((this.r == null) || (this.r.size() < 20)))
      {
        if (this.M == null)
        {
          this.H = 3;
          if (UniteSearchActivity.a(this.S, this.R)) {
            this.H = 3;
          }
          q();
          h_(false);
          this.z.setVisibility(8);
        }
        else
        {
          r();
        }
        this.y.setVisibility(0);
      }
      if (paramInt == 0)
      {
        DropFrameMonitor.b().a("list_unite_search", false);
        return;
      }
      DropFrameMonitor.b().a("list_unite_search");
    }
  }
  
  public void onStart()
  {
    super.onStart();
    ((GroupSearchEngine)this.o).f();
  }
  
  public void onStop()
  {
    super.onStop();
    ((GroupSearchEngine)this.o).g();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    this.n = ((IQQAvatarService)super.getQBaseActivity().getAppRuntime().getRuntimeService(IQQAvatarService.class, "")).getInstance((AppInterface)getQBaseActivity().getAppRuntime());
    this.m = b();
    this.l.setAdapter(this.m);
    h();
    this.B.setText("");
    p();
    this.c = true;
    if ((getQBaseActivity() instanceof UniteSearchActivity))
    {
      ((UniteSearchActivity)getQBaseActivity()).a(((UniteSearchActivity)getQBaseActivity()).p, this.d, this.e);
      this.d = false;
      this.e = false;
    }
    if (SearchConfig.isUseOptimize)
    {
      n();
      a(this.p);
    }
  }
  
  public void p()
  {
    i();
    f(this.r);
    this.x.setVisibility(8);
  }
  
  public void q()
  {
    Object localObject1;
    if (this.q != null) {
      localObject1 = this.q;
    } else {
      localObject1 = "";
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("log for search startNetSearch ");
    ((StringBuilder)localObject2).append((String)localObject1);
    QLog.i("Q.uniteSearch.GroupSearchFragment", 2, ((StringBuilder)localObject2).toString());
    if (!UniteSearchActivity.a(this.S, this.R))
    {
      localObject1 = (UniteSearchHandler)this.p.getBusinessHandler(BusinessHandlerFactory.UNITE_SEARCH_HANDLER);
      localObject2 = null;
    }
    else
    {
      localObject2 = (UnifySearchHandler)this.p.getBusinessHandler(BusinessHandlerFactory.UNIFY_SEARCH_UNITE_HANDLER);
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
    this.O = 0;
    this.N = 0;
    boolean bool = true;
    this.i = true;
    this.G = false;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(System.currentTimeMillis());
    ((StringBuilder)localObject3).append("");
    this.h = ((StringBuilder)localObject3).toString();
    if (!UniteSearchActivity.a(this.S, this.R))
    {
      if (this.H == 0) {
        this.H = 4;
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(this.q);
      localObject3 = ((StringBuilder)localObject3).toString();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("");
      ((StringBuilder)localObject4).append(a(this.H));
      SearchUtils.a("all_result", "active_net", new String[] { localObject3, ((StringBuilder)localObject4).toString() });
    }
    else
    {
      if (this.H == 0) {
        this.H = 4;
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(this.q);
      localObject3 = ((StringBuilder)localObject3).toString();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("");
      ((StringBuilder)localObject4).append(b(this.H));
      SearchUtils.a("all_result", "active_net", new String[] { localObject3, ((StringBuilder)localObject4).toString() });
    }
    localObject3 = new Bundle();
    ((Bundle)localObject3).putInt("matchCount", this.I);
    ((Bundle)localObject3).putInt("source", this.S);
    Object localObject4 = u();
    String str;
    List localList;
    int j;
    if (localObject1 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "log for search startNetSearch use old protocl");
      }
      localObject2 = this.q;
      str = this.h;
      localList = SearchUtils.b(UniteSearchHandler.b);
      j = this.H;
      if (this.b != 2) {
        bool = false;
      }
      ((UniteSearchHandler)localObject1).a((String)localObject2, str, 20, localList, (List)localObject4, j, null, d1, d2, false, bool, this.R, (Bundle)localObject3);
    }
    else if (localObject2 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "log for search startNetSearch use new protocl");
      }
      localObject1 = this.q;
      str = this.h;
      localList = SearchUtils.b(UnifySearchHandler.b);
      j = this.H;
      if (this.b == 2) {
        bool = true;
      } else {
        bool = false;
      }
      ((UnifySearchHandler)localObject2).a((String)localObject1, str, 20, localList, (List)localObject4, j, null, d1, d2, false, bool, this.R, (Bundle)localObject3);
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "log for search startNetSearch error");
    }
    SearchCostStat.a(8);
    SearchCostStat.a("NetSend");
    this.H = 0;
  }
  
  public void r()
  {
    this.i = true;
    h_(false);
    Object localObject2;
    if (!UniteSearchActivity.a(this.S, this.R))
    {
      localObject2 = (UniteSearchHandler)this.p.getBusinessHandler(BusinessHandlerFactory.UNITE_SEARCH_HANDLER);
      localObject1 = null;
    }
    else
    {
      localObject1 = (UnifySearchHandler)this.p.getBusinessHandler(BusinessHandlerFactory.UNIFY_SEARCH_UNITE_HANDLER);
      localObject2 = null;
    }
    i();
    this.y.setVisibility(0);
    this.z.setVisibility(8);
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
    this.h = ((StringBuilder)localObject3).toString();
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("start search index=");
      ((StringBuilder)localObject3).append(this.g);
      QLog.i("Q.uniteSearch.GroupSearchFragmentGroupSearchFragment", 2, ((StringBuilder)localObject3).toString());
    }
    if (!UniteSearchActivity.a(this.S, this.R))
    {
      if (this.H == 0) {
        this.H = 5;
      }
    }
    else if (this.H == 0) {
      this.H = 5;
    }
    localObject3 = new Bundle();
    ((Bundle)localObject3).putInt("matchCount", this.I);
    List localList = u();
    if (localObject2 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "startNetNewSearch use old protocol");
      }
      ((UniteSearchHandler)localObject2).a(this.q, this.h, 20, SearchUtils.b(UniteSearchHandler.b), localList, this.H, this.M, d1, d2, true, this.R, (Bundle)localObject3);
    }
    else
    {
      localObject2 = "Q.uniteSearch.GroupSearchFragment";
      if (localObject1 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d((String)localObject2, 2, "startNetNewSearch use new protocol");
        }
        ((UnifySearchHandler)localObject1).a(this.q, this.h, 20, SearchUtils.b(UnifySearchHandler.b), localList, this.H, this.M, d1, d2, true, this.R, (Bundle)localObject3);
      }
      else if (QLog.isColorLevel())
      {
        QLog.d((String)localObject2, 2, "startNetNewSearch error");
      }
    }
    this.H = 0;
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
    localObject1 = new ReportModelDC02528().module("all_result").action("load_more").ver1(this.q).ver2(UniteSearchReportController.a(UniteSearchActivity.f)).ver7(((JSONObject)localObject1).toString());
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(localQQAppInterface.getCurrentAccountUin());
    ((StringBuilder)localObject3).append(SearchUtils.j);
    UniteSearchReportController.a(localQQAppInterface, ((ReportModelDC02528)localObject1).session_id(((StringBuilder)localObject3).toString()));
  }
  
  public void s()
  {
    if (this.o != null)
    {
      this.o.b();
      this.o.e();
    }
    this.u = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.GroupSearchFragment
 * JD-Core Version:    0.7.0.1
 */