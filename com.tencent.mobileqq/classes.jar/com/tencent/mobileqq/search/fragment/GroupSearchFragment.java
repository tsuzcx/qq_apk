package com.tencent.mobileqq.search.fragment;

import ahtc;
import ahtd;
import ahte;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.UniteSearchHandler;
import com.tencent.mobileqq.data.PublicAccountInfo;
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
import com.tencent.mobileqq.search.model.IModel;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.model.NetSearchTemplateBaseItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateHorizontalBaseItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateHorizontalContainerItem;
import com.tencent.mobileqq.search.model.PublicAccountSearchResultModel;
import com.tencent.mobileqq.search.model.SearchResultModelForEntrance;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import com.tencent.mobileqq.search.searchengine.ISearchEngine;
import com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine;
import com.tencent.mobileqq.search.searchengine.SearchRequest;
import com.tencent.mobileqq.search.util.ObjectTransfer;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.VADHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class GroupSearchFragment
  extends BaseSearchFragment
  implements SearchFragmentInfoInterface, AbsListView.OnScrollListener
{
  public static volatile String a;
  public long a;
  public SearchResultModelForEntrance a;
  byte[] a;
  public volatile int b;
  public long b;
  public Handler b;
  public int c;
  private long c;
  public String c;
  int d = 0;
  int e;
  public boolean e;
  int f;
  public boolean f;
  public volatile int g;
  public boolean g;
  public volatile int h;
  public boolean h;
  private int i;
  public boolean i;
  private int jdField_j_of_type_Int;
  private boolean jdField_j_of_type_Boolean = true;
  
  public GroupSearchFragment()
  {
    this.jdField_i_of_type_Int = -1;
    this.jdField_b_of_type_AndroidOsHandler = new ahtc(this, Looper.getMainLooper());
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_e_of_type_Int = 0;
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
  
  private List a()
  {
    List localList = new PublicAccountSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_i_of_type_Int).a(new SearchRequest(this.jdField_b_of_type_JavaLangString));
    if ((localList == null) || (localList.size() == 0)) {
      return null;
    }
    ArrayList localArrayList1 = ((PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55)).a();
    ArrayList localArrayList2 = new ArrayList();
    if ((localArrayList1 == null) || (localArrayList1.isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "all publicAccountInfoList is null or empty");
      }
    }
    for (;;)
    {
      return localArrayList2;
      int k = 0;
      while (k < localList.size())
      {
        PublicAccountSearchResultModel localPublicAccountSearchResultModel = (PublicAccountSearchResultModel)localList.get(k);
        int m = 0;
        while (m < localArrayList1.size())
        {
          PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)localArrayList1.get(m);
          if (TextUtils.equals(String.valueOf(localPublicAccountInfo.uin), String.valueOf(localPublicAccountSearchResultModel.a.uin))) {
            localArrayList2.add(Long.valueOf(localPublicAccountInfo.uin));
          }
          m += 1;
        }
        k += 1;
      }
    }
  }
  
  protected int a()
  {
    return 0;
  }
  
  protected BaseMvpAdapter a()
  {
    return new GroupSearchAdapter(this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder, this, this.jdField_i_of_type_Int);
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
        this.jdField_c_of_type_Boolean = true;
        return (GroupSearchEngine)localObject;
      }
    }
    return new GroupSearchEngine(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_i_of_type_Int);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    QLog.d("Q.uniteSearch.GroupSearchFragment arend ", 4, " onScrollStateChanged" + paramInt);
    if ((getActivity() instanceof UniteSearchActivity)) {
      paramAbsListView = (UniteSearchActivity)getActivity();
    }
    this.jdField_f_of_type_Int = paramInt;
    if ((this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter.getCount() == 0)) {}
    while ((this.jdField_b_of_type_Int == 0) || (this.jdField_f_of_type_Int == 0) || (!this.jdField_e_of_type_Boolean) || (this.jdField_h_of_type_Boolean) || (this.jdField_i_of_type_Boolean) || ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() >= 20))) {
      return;
    }
    if (this.jdField_a_of_type_ArrayOfByte == null)
    {
      this.jdField_g_of_type_Int = 3;
      g();
      b(false);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      return;
      h();
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.d("Q.uniteSearch.GroupSearchFragment arend ", 4, " onScroll" + paramInt1);
    if (this.jdField_f_of_type_Int == 0) {}
    do
    {
      return;
      if ((getActivity() instanceof UniteSearchActivity)) {
        paramAbsListView = (UniteSearchActivity)getActivity();
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter.getCount() == 0) || (this.jdField_b_of_type_Int == 0) || (paramInt3 - paramInt1 - paramInt2 >= 10) || (this.jdField_h_of_type_Boolean) || (this.jdField_i_of_type_Boolean));
    if (this.jdField_a_of_type_ArrayOfByte == null)
    {
      this.jdField_g_of_type_Int = 3;
      g();
      b(false);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      return;
      h();
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "GroupSearchFragment startSearch   isLocalSearch");
    }
    VADHelper.a("voice_search_als_cost");
    a(paramString, 1);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    c();
    this.jdField_h_of_type_Boolean = false;
    this.jdField_i_of_type_Boolean = true;
    if ((this.jdField_b_of_type_JavaUtilList.size() != 1) || (!(this.jdField_b_of_type_JavaUtilList.get(0) instanceof SearchResultModelForEntrance)) || (!((SearchResultModelForEntrance)this.jdField_b_of_type_JavaUtilList.get(0)).b()))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new ahte(this));
    }
  }
  
  public void a(String paramString, boolean paramBoolean1, byte[] paramArrayOfByte, boolean paramBoolean2, List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "onResultSuc, keyword = " + paramString + ", isFirstReq = " + paramBoolean1 + ", cookie = " + paramArrayOfByte + ", isEnd = " + paramBoolean2 + ", netResultItemList = " + paramList);
    }
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    int m;
    int k;
    int n;
    if (paramBoolean1)
    {
      m = 0;
      k = 0;
      while (k < ((List)localObject).size())
      {
        n = m;
        if (!(((List)localObject).get(k) instanceof GroupSearchModeTitle)) {
          n = m + 1;
        }
        k += 1;
        m = n;
      }
      paramList = new JSONObject();
    }
    try
    {
      paramList.put("project", UniteSearchReportController.a());
      paramList.put("event_src", "client");
      paramList.put("web_num", m);
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      UniteSearchReportController.a(localQQAppInterface, new ReportModelDC02528().module("all_result").action("exp_items").ver1(paramString).ver2(UniteSearchReportController.a(this.jdField_i_of_type_Int)).ver7(paramList.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + SearchUtil.jdField_a_of_type_Long));
      if (!paramBoolean1) {
        break label487;
      }
      k = 0;
      m = 0;
      n = 0;
      while (n < ((List)localObject).size())
      {
        int i2 = m;
        int i1 = k;
        if ((((List)localObject).get(n) instanceof GroupBaseNetSearchModelItem))
        {
          if (((GroupBaseNetSearchModelItem)((List)localObject).get(n)).b() == 1001) {
            k = 1;
          }
          i2 = m;
          i1 = k;
          if (((GroupBaseNetSearchModelItem)((List)localObject).get(n)).b() == 1001)
          {
            i2 = 1;
            i1 = k;
          }
        }
        n += 1;
        m = i2;
        k = i1;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("Q.uniteSearch.GroupSearchFragment", 2, "e = " + localJSONException);
      }
      n = 0;
      if (k == 0) {
        break label596;
      }
    }
    if (m != 0)
    {
      k = 90;
      if (k != 0) {
        ReportController.b(null, "CliOper", "", "", "0X8005ECF", "0X8005ECF", k, 0, "", "", "", "");
      }
      label487:
      this.jdField_h_of_type_Boolean = false;
      a(paramArrayOfByte);
      this.jdField_i_of_type_Boolean = paramBoolean2;
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramArrayOfByte = ((List)localObject).iterator();
      k = 0;
      label532:
      if (!paramArrayOfByte.hasNext()) {
        break label633;
      }
      paramList = (IModel)paramArrayOfByte.next();
      if (!(paramList instanceof ISearchResultGroupModel)) {
        break label624;
      }
      if (((ISearchResultGroupModel)paramList).a() == null) {
        break label1009;
      }
      k = ((ISearchResultGroupModel)paramList).a().size() + k;
    }
    label596:
    label624:
    label1009:
    for (;;)
    {
      break label532;
      if (k != 0)
      {
        k = 70;
        break;
      }
      k = n;
      if (m == 0) {
        break;
      }
      k = 80;
      break;
      k += 1;
      continue;
      label633:
      if (paramBoolean1)
      {
        if (k > 0) {
          SearchUtils.a("all_result", "exp_net_result", new String[] { "" + paramString });
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "handleTabSearchResult isFirstReq==" + paramBoolean1 + " newSearchDataCount:" + this.jdField_e_of_type_Int + "   newSearchIndex:" + this.d + " result.size():" + k);
        }
        n = 0;
        m = n;
        if (!this.jdField_i_of_type_Boolean)
        {
          this.jdField_e_of_type_Int += k;
          this.d += 1;
          if (this.jdField_e_of_type_Int <= 10) {
            break label881;
          }
          this.d = 0;
          this.jdField_e_of_type_Int = 0;
          this.jdField_b_of_type_Boolean = paramBoolean1;
          m = n;
        }
        if (m == 0) {
          break label941;
        }
        if (this.jdField_c_of_type_JavaUtilList != null) {
          break label926;
        }
        this.jdField_b_of_type_Boolean = paramBoolean1;
        this.jdField_c_of_type_JavaUtilList = ((List)localObject);
      }
      for (;;)
      {
        this.jdField_c_of_type_Int += 1;
        return;
        SearchUtils.a("all_result", "noresult_net", new String[] { "" + paramString });
        break;
        label881:
        if (this.d >= 3)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "handleTabSearchResult 触发限频逻辑");
          }
          this.jdField_i_of_type_Boolean = true;
          m = n;
          break label809;
        }
        m = 1;
        h();
        break label809;
        this.jdField_c_of_type_JavaUtilList.addAll((Collection)localObject);
      }
      b(true);
      if ((this.jdField_c_of_type_JavaUtilList != null) && (this.jdField_c_of_type_JavaUtilList.size() > 0)) {
        ((List)localObject).addAll(0, this.jdField_c_of_type_JavaUtilList);
      }
      for (;;)
      {
        a((List)localObject, this.jdField_b_of_type_Boolean);
        this.jdField_c_of_type_JavaUtilList = null;
        this.jdField_b_of_type_Boolean = false;
        break;
        this.jdField_b_of_type_Boolean = paramBoolean1;
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
    paramList = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(13, new ArrayList(paramList));
    this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramList);
  }
  
  public void a(List paramList, int paramInt)
  {
    if (isDetached()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.uniteSearch.GroupSearchFragment", 2, "onFinish, resultList = " + paramList + ", status = " + paramInt);
    }
    paramList = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(14, new ArrayList(paramList));
    paramList.arg1 = paramInt;
    this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramList);
  }
  
  public void a(List paramList, boolean paramBoolean)
  {
    c();
    if (paramList.size() > 0)
    {
      k = SearchUtil.c.size();
      int n = 0;
      long l1 = -1L;
      if (n < paramList.size())
      {
        IModel localIModel = (IModel)paramList.get(n);
        Object localObject2;
        Object localObject3;
        long l2;
        Object localObject1;
        if ((localIModel instanceof GroupBaseNetSearchModel))
        {
          localObject2 = (GroupBaseNetSearchModel)localIModel;
          int m = k;
          if (((GroupBaseNetSearchModel)localObject2).a() != null)
          {
            m = k;
            if (((GroupBaseNetSearchModel)localObject2).a().size() > 0)
            {
              m = 0;
              if (m < ((GroupBaseNetSearchModel)localObject2).a().size())
              {
                localObject3 = (IModel)((GroupBaseNetSearchModel)localObject2).a().get(n);
                l2 = 0L;
                localObject1 = "";
                if ((localObject3 instanceof NetSearchTemplateBaseItem))
                {
                  l2 = ((NetSearchTemplateBaseItem)localObject3).jdField_a_of_type_Long;
                  localObject1 = ((NetSearchTemplateBaseItem)localObject3).d;
                }
                for (;;)
                {
                  SearchUtil.ObjectItemInfo localObjectItemInfo = new SearchUtil.ObjectItemInfo();
                  k += 1;
                  localObjectItemInfo.jdField_a_of_type_Int = k;
                  localObjectItemInfo.jdField_a_of_type_Long = l2;
                  localObjectItemInfo.jdField_b_of_type_JavaLangString = ((String)localObject1);
                  localObjectItemInfo.jdField_a_of_type_JavaLangString = ((GroupBaseNetSearchModel)localIModel).b();
                  SearchUtil.c.put((ISearchResultModel)localObject3, localObjectItemInfo);
                  m += 1;
                  break;
                  if ((localObject3 instanceof GroupBaseNetSearchModelItem))
                  {
                    l2 = ((GroupBaseNetSearchModelItem)localObject3).b();
                    localObject1 = ((GroupBaseNetSearchModelItem)localObject3).jdField_b_of_type_JavaLangString;
                  }
                }
              }
              m = k;
            }
          }
          l2 = l1;
          if (l1 == -1L) {
            l2 = ((GroupBaseNetSearchModel)localObject2).jdField_a_of_type_Long;
          }
          k = m;
          l1 = l2;
        }
        for (;;)
        {
          n += 1;
          break;
          if ((localIModel instanceof NetSearchTemplateHorizontalContainerItem))
          {
            k += 1;
            localObject1 = ((NetSearchTemplateHorizontalContainerItem)localIModel).a;
            if (localObject1 != null)
            {
              localObject1 = ((ArrayList)localObject1).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (NetSearchTemplateHorizontalBaseItem)((Iterator)localObject1).next();
                localObject3 = new SearchUtil.ObjectItemInfo();
                ((SearchUtil.ObjectItemInfo)localObject3).jdField_a_of_type_Int = k;
                ((SearchUtil.ObjectItemInfo)localObject3).jdField_a_of_type_JavaLangString = ((NetSearchTemplateBaseItem)localIModel).b();
                SearchUtil.c.put(localObject2, localObject3);
              }
            }
          }
          else if ((localIModel instanceof NetSearchTemplateBaseItem))
          {
            localObject1 = new SearchUtil.ObjectItemInfo();
            k += 1;
            ((SearchUtil.ObjectItemInfo)localObject1).jdField_a_of_type_Int = k;
            ((SearchUtil.ObjectItemInfo)localObject1).jdField_a_of_type_Long = ((NetSearchTemplateBaseItem)localIModel).jdField_a_of_type_Long;
            ((SearchUtil.ObjectItemInfo)localObject1).jdField_b_of_type_JavaLangString = ((NetSearchTemplateBaseItem)localIModel).d;
            ((SearchUtil.ObjectItemInfo)localObject1).jdField_a_of_type_JavaLangString = ((NetSearchTemplateBaseItem)localIModel).b();
            SearchUtil.c.put((ISearchResultModel)localIModel, localObject1);
          }
          else if ((localIModel instanceof GroupBaseNetSearchModelItem))
          {
            l2 = ((GroupBaseNetSearchModelItem)localIModel).b();
            localObject1 = ((GroupBaseNetSearchModelItem)localIModel).jdField_b_of_type_JavaLangString;
            localObject2 = new SearchUtil.ObjectItemInfo();
            k += 1;
            ((SearchUtil.ObjectItemInfo)localObject2).jdField_a_of_type_Int = k;
            ((SearchUtil.ObjectItemInfo)localObject2).jdField_a_of_type_Long = l2;
            ((SearchUtil.ObjectItemInfo)localObject2).jdField_b_of_type_JavaLangString = ((String)localObject1);
            ((SearchUtil.ObjectItemInfo)localObject2).jdField_a_of_type_JavaLangString = ((GroupBaseNetSearchModelItem)localIModel).b();
            SearchUtil.c.put((ISearchResultModel)localIModel, localObject2);
          }
          else if (((localIModel instanceof SearchResultModelForEntrance)) && (((SearchResultModelForEntrance)localIModel).jdField_a_of_type_Int == -4))
          {
            localObject1 = new SearchUtil.ObjectItemInfo();
            k += 1;
            ((SearchUtil.ObjectItemInfo)localObject1).jdField_a_of_type_Int = k;
            ((SearchUtil.ObjectItemInfo)localObject1).jdField_a_of_type_Long = 2073745984L;
            ((SearchUtil.ObjectItemInfo)localObject1).jdField_a_of_type_JavaLangString = ((SearchResultModelForEntrance)localIModel).b().toString();
            SearchUtil.c.put((ISearchResultModel)localIModel, localObject1);
          }
          else if ((localIModel instanceof GroupSearchModelFooter))
          {
            localObject1 = new SearchUtil.ObjectItemInfo();
            ((SearchUtil.ObjectItemInfo)localObject1).jdField_a_of_type_Long = ((GroupSearchModelFooter)localIModel).jdField_a_of_type_Long;
            ((SearchUtil.ObjectItemInfo)localObject1).jdField_b_of_type_JavaLangString = ((GroupSearchModelFooter)localIModel).jdField_c_of_type_JavaLangString;
            SearchUtil.c.put(localIModel, localObject1);
          }
        }
      }
    }
    if ((paramBoolean) && (this.jdField_b_of_type_JavaUtilList.isEmpty())) {}
    for (int k = 1;; k = 0)
    {
      this.jdField_b_of_type_JavaUtilList.addAll(paramList);
      if (this.jdField_b_of_type_JavaUtilList.isEmpty()) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter.a(this.jdField_b_of_type_JavaUtilList, paramBoolean);
      if (k != 0) {
        this.jdField_a_of_type_ComTencentWidgetListView.setSelection(0);
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter.a(paramList);
    this.jdField_b_of_type_JavaUtilList = paramList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_j_of_type_Boolean = paramBoolean;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public boolean a()
  {
    return this.jdField_j_of_type_Boolean;
  }
  
  public void b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    jdField_a_of_type_JavaLangString = paramString;
    if (QLog.isColorLevel()) {
      QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "GroupSearchFragment isViewCreated " + this.jdField_e_of_type_Boolean + " startSearch:" + paramString + "  forceRequestStatus=" + this.jdField_g_of_type_Int);
    }
    if ((!this.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
    {
      QLog.w("Q.uniteSearch.GroupSearchFragment", 1, "startSearchForHotWord called  isViewCreated == false!! ");
      return;
    }
    SearchUtil.jdField_a_of_type_Long = System.currentTimeMillis();
    SearchUtil.c.clear();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("project", UniteSearchReportController.a());
      localJSONObject.put("event_src", "client");
      UniteSearchReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new ReportModelDC02528().module("all_result").action("search_request").ver2(UniteSearchReportController.a(this.jdField_i_of_type_Int)).ver7(localJSONObject.toString()).session_id(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + SearchUtil.jdField_a_of_type_Long));
      if ((this.jdField_i_of_type_Int == 21) && (SearchEntryConfigManager.a() == 0))
      {
        SearchUtils.a("all_result", "exp_pure_net_result", new String[] { paramString });
        this.jdField_g_of_type_Int = 6;
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
      paramString = new ahtd(this);
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidOsHandler.removeMessages(100);
        this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(100);
        return;
      }
      ThreadManager.postImmediately(paramString, null, true);
    }
  }
  
  protected boolean b()
  {
    return false;
  }
  
  public void d()
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_h_of_type_Boolean = false;
    this.jdField_i_of_type_Boolean = false;
    a(false);
    if (this.jdField_e_of_type_Boolean)
    {
      b(false);
      b();
      this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter.notifyDataSetChanged();
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_c_of_type_Int = 0;
  }
  
  public void e()
  {
    if (this.jdField_b_of_type_JavaUtilList != null) {
      this.jdField_b_of_type_JavaUtilList.clear();
    }
    if (this.jdField_c_of_type_JavaUtilList != null) {
      this.jdField_c_of_type_JavaUtilList.clear();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter.a(this.jdField_b_of_type_JavaUtilList);
    }
  }
  
  public void f()
  {
    c();
    this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter.a(this.jdField_b_of_type_JavaUtilList);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void g()
  {
    UniteSearchHandler localUniteSearchHandler = (UniteSearchHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(111);
    double d1 = 0.0D;
    double d2 = 0.0D;
    if ((getActivity() instanceof LocationInterface))
    {
      d1 = ((LocationInterface)getActivity()).a();
      d2 = ((LocationInterface)getActivity()).b();
    }
    this.jdField_e_of_type_Int = 0;
    this.d = 0;
    this.jdField_h_of_type_Boolean = true;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_c_of_type_JavaLangString = (System.currentTimeMillis() + "");
    if (this.jdField_g_of_type_Int == 0) {
      this.jdField_g_of_type_Int = 4;
    }
    SearchUtils.a("all_result", "active_net", new String[] { "" + this.jdField_b_of_type_JavaLangString, "" + a(this.jdField_g_of_type_Int) });
    Bundle localBundle = new Bundle();
    localBundle.putInt("matchCount", this.jdField_h_of_type_Int);
    localBundle.putInt("source", this.jdField_j_of_type_Int);
    List localList1 = a();
    String str1 = this.jdField_b_of_type_JavaLangString;
    String str2 = this.jdField_c_of_type_JavaLangString;
    List localList2 = SearchUtils.a(UniteSearchHandler.b);
    int k = this.jdField_g_of_type_Int;
    if (this.jdField_b_of_type_Int == 2) {}
    for (boolean bool = true;; bool = false)
    {
      localUniteSearchHandler.a(str1, str2, 20, localList2, localList1, k, null, d1, d2, false, bool, this.jdField_i_of_type_Int, localBundle);
      this.jdField_g_of_type_Int = 0;
      return;
    }
  }
  
  public void h()
  {
    this.jdField_h_of_type_Boolean = true;
    b(false);
    UniteSearchHandler localUniteSearchHandler = (UniteSearchHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(111);
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
    this.jdField_c_of_type_JavaLangString = (System.currentTimeMillis() + "");
    if (QLog.isColorLevel()) {
      QLog.i("Q.uniteSearch.GroupSearchFragmentGroupSearchFragment", 2, "start search index=" + this.jdField_c_of_type_Int);
    }
    if (this.jdField_g_of_type_Int == 0) {
      this.jdField_g_of_type_Int = 5;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("matchCount", this.jdField_h_of_type_Int);
    List localList = a();
    localUniteSearchHandler.a(this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, 20, SearchUtils.a(UniteSearchHandler.b), localList, this.jdField_g_of_type_Int, this.jdField_a_of_type_ArrayOfByte, d1, d2, true, this.jdField_i_of_type_Int, localBundle);
    this.jdField_g_of_type_Int = 0;
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine.b();
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine.e();
    }
    this.jdField_c_of_type_Boolean = false;
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
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
    ReportController.b(null, "CliOper", "", "", "0X8005ECE", "0X8005ECE", a(), 0, String.valueOf(this.jdField_a_of_type_Int), "", this.jdField_b_of_type_JavaLangString, "");
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.jdField_e_of_type_Boolean = false;
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter.notifyDataSetChanged();
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
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(super.getActivity(), super.getActivity().app);
    this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter = a();
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqSearchAdapterBaseMvpAdapter);
    b();
    this.jdField_c_of_type_AndroidWidgetTextView.setText("");
    f();
    this.jdField_e_of_type_Boolean = true;
    if ((getActivity() instanceof UniteSearchActivity))
    {
      ((UniteSearchActivity)getActivity()).a(((UniteSearchActivity)getActivity()).jdField_c_of_type_JavaLangString, this.jdField_f_of_type_Boolean, this.jdField_g_of_type_Boolean);
      this.jdField_f_of_type_Boolean = false;
      this.jdField_g_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.GroupSearchFragment
 * JD-Core Version:    0.7.0.1
 */