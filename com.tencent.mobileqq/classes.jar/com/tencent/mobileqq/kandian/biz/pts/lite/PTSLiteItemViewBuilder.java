package com.tencent.mobileqq.kandian.biz.pts.lite;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.pts.ReadInJoyModelImpl;
import com.tencent.mobileqq.kandian.biz.pts.util.DynamicItemViewHelper;
import com.tencent.mobileqq.kandian.biz.pts.util.PTSLiteItemViewUtil;
import com.tencent.mobileqq.kandian.biz.pts.util.PTSLiteItemViewUtil.Companion;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.pts.PTSPreLayoutHandler;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.pts.PTSStyleManager;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class PTSLiteItemViewBuilder
{
  private static int jdField_a_of_type_Int = 151;
  private static int jdField_b_of_type_Int = jdField_a_of_type_Int;
  private static HashMap<String, Integer> c = new HashMap();
  private Context jdField_a_of_type_AndroidContentContext;
  private ReadInJoyBaseAdapter jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter;
  private PTSLiteSwiperEventDispatcher jdField_a_of_type_ComTencentMobileqqKandianBizPtsLitePTSLiteSwiperEventDispatcher;
  private PTSLiteTapEventDispatcher jdField_a_of_type_ComTencentMobileqqKandianBizPtsLitePTSLiteTapEventDispatcher;
  private IPTSLiteEventListener jdField_a_of_type_ComTencentPtsCoreLiteIPTSLiteEventListener;
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<String> jdField_a_of_type_JavaUtilList;
  private HashMap<String, AbsBaseArticleInfo> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  
  public PTSLiteItemViewBuilder(Context paramContext, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter = paramReadInJoyBaseAdapter;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    c();
    b();
  }
  
  public static int a()
  {
    int i = jdField_b_of_type_Int;
    int j = jdField_a_of_type_Int;
    if (i > j) {
      return i - j + 1;
    }
    return 0;
  }
  
  public static int a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.ptsItemData != null) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.ptsLitePageName)))
    {
      paramAbsBaseArticleInfo = (Integer)c.get(paramAbsBaseArticleInfo.ptsLitePageName);
      if (paramAbsBaseArticleInfo != null) {
        return paramAbsBaseArticleInfo.intValue();
      }
      return jdField_a_of_type_Int;
    }
    return jdField_a_of_type_Int;
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramAbsBaseArticleInfo.innerUniqueID, Integer.valueOf(paramInt));
    if ((paramAbsBaseArticleInfo.mSubArticleList != null) && (paramAbsBaseArticleInfo.mSubArticleList.size() > 0))
    {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mSubArticleList.iterator();
      while (paramAbsBaseArticleInfo.hasNext())
      {
        AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)paramAbsBaseArticleInfo.next();
        this.jdField_a_of_type_JavaUtilHashMap.put(localAbsBaseArticleInfo.innerUniqueID, Integer.valueOf(paramInt));
      }
    }
  }
  
  private void a(PTSItemData paramPTSItemData)
  {
    ThreadManager.executeOnSubThread(new PTSLiteItemViewBuilder.2(this, paramPTSItemData));
  }
  
  private void a(String paramString1, HashMap<String, String> paramHashMap, View paramView, String paramString2)
  {
    paramView = new StringBuilder();
    paramView.append("identifier = ");
    paramView.append(paramString1);
    paramView.append("\n");
    if (paramHashMap != null)
    {
      paramString1 = paramHashMap.entrySet().iterator();
      while (paramString1.hasNext())
      {
        paramHashMap = (Map.Entry)paramString1.next();
        paramView.append("dataSet [ ");
        paramView.append((String)paramHashMap.getKey());
        paramView.append(" ] =");
        paramView.append((String)paramHashMap.getValue());
        paramView.append("\n");
      }
    }
    paramString1 = new StringBuilder();
    paramString1.append(paramString2);
    paramString1.append(", ");
    paramString1.append(paramView.toString());
    QLog.i("PTSLiteItemViewBuilder", 1, paramString1.toString());
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt >= jdField_a_of_type_Int) && (paramInt <= jdField_b_of_type_Int);
  }
  
  public static boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return true;
    }
    if (b(paramAbsBaseArticleInfo)) {
      return a(paramAbsBaseArticleInfo) == jdField_a_of_type_Int;
    }
    return false;
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsLitePTSLiteTapEventDispatcher = new PTSLiteTapEventDispatcher.Builder().a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter).a(this.jdField_a_of_type_JavaUtilHashMap).b(this.jdField_b_of_type_JavaUtilHashMap).a();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsLitePTSLiteSwiperEventDispatcher = new PTSLiteSwiperEventDispatcher.Builder().a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter).a(this.jdField_a_of_type_JavaUtilHashMap).b(this.jdField_b_of_type_JavaUtilHashMap).a();
    this.jdField_a_of_type_ComTencentPtsCoreLiteIPTSLiteEventListener = new PTSLiteItemViewBuilder.1(this);
  }
  
  public static <T extends AbsBaseArticleInfo> boolean b(T paramT)
  {
    return (paramT != null) && (!TextUtils.isEmpty(paramT.ptsLitePageName)) && (paramT.ptsItemData != null);
  }
  
  private void c()
  {
    c.clear();
    Object localObject = PTSStyleManager.a().a("default_feeds");
    if (localObject == null)
    {
      QLog.i("PTSLiteItemViewBuilder", 1, "[initViewTypeCount], pageNameList is null.");
      return;
    }
    jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.a().a() + 151;
    int i = jdField_a_of_type_Int;
    localObject = new ArrayList((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      int j = i + 1;
      i = j;
      if (!c.containsKey(str))
      {
        c.put(str, Integer.valueOf(j));
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[initViewTypeCount], pageName = ");
        localStringBuilder.append(str);
        localStringBuilder.append(", viewType = ");
        localStringBuilder.append(j);
        QLog.i("PTSLiteItemViewBuilder", 1, localStringBuilder.toString());
        i = j;
      }
    }
    jdField_b_of_type_Int = i;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[initViewType], type_pts_lite_gone = ");
    ((StringBuilder)localObject).append(jdField_a_of_type_Int);
    ((StringBuilder)localObject).append(", type_pts_lite_end = ");
    ((StringBuilder)localObject).append(jdField_b_of_type_Int);
    QLog.i("PTSLiteItemViewBuilder", 1, ((StringBuilder)localObject).toString());
  }
  
  public View a(View paramView, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt, ReadInJoyModelImpl paramReadInJoyModelImpl)
  {
    if (paramAbsBaseArticleInfo == null)
    {
      QLog.e("PTSLiteItemViewBuilder", 1, "[getView], articleInfo is null.");
      return paramView;
    }
    PTSItemData localPTSItemData = paramAbsBaseArticleInfo.ptsItemData;
    PTSComposer localPTSComposer = paramAbsBaseArticleInfo.ptsComposer;
    if ((localPTSItemData != null) && (localPTSComposer != null))
    {
      if ((paramView instanceof PTSLitePlayableCardView)) {
        paramView = (PTSLitePlayableCardView)paramView;
      } else {
        paramView = new PTSLitePlayableCardView(this.jdField_a_of_type_AndroidContentContext);
      }
      localPTSComposer.layoutToView(paramView.a(), this.jdField_a_of_type_ComTencentPtsCoreLiteIPTSLiteEventListener);
      PTSLiteItemViewUtil.a.a(paramView.a());
      PTSLiteItemViewUtil.a.a(paramReadInJoyModelImpl, paramView, this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter);
      a(paramAbsBaseArticleInfo, paramInt);
      this.jdField_b_of_type_JavaUtilHashMap.put(paramAbsBaseArticleInfo.innerUniqueID, paramAbsBaseArticleInfo);
      a(localPTSItemData);
    }
    else
    {
      paramView = new StringBuilder();
      paramView.append("[getView] error, ptsItemData is null or ptsComposer is null, hide the itemView, ");
      paramView.append(PTSPreLayoutHandler.a(paramAbsBaseArticleInfo));
      QLog.e("PTSLiteItemViewBuilder", 1, paramView.toString());
      paramView = new PTSLitePlayableCardView(this.jdField_a_of_type_AndroidContentContext);
      paramView.setVisibility(8);
    }
    paramView.setTag(2131369613, this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.a());
    return paramView;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    int i = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.a();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[destroy] channelId = ");
    ((StringBuilder)localObject).append(i);
    QLog.i("PTSLiteItemViewBuilder", 1, ((StringBuilder)localObject).toString());
    if ((i != 41505) && (i != 41697))
    {
      PTSPreLayoutHandler.b(ReadInJoyLogicEngine.a().b(Integer.valueOf(i)));
    }
    else
    {
      PTSPreLayoutHandler.b(ReadInJoyLogicEngine.a().b(Integer.valueOf(41505)));
      PTSPreLayoutHandler.b(ReadInJoyLogicEngine.a().b(Integer.valueOf(41697)));
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsLitePTSLiteSwiperEventDispatcher;
    if (localObject != null) {
      ((PTSLiteSwiperEventDispatcher)localObject).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.lite.PTSLiteItemViewBuilder
 * JD-Core Version:    0.7.0.1
 */