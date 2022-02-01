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
import com.tencent.mobileqq.kandian.biz.pts.util.PTSReport;
import com.tencent.mobileqq.kandian.biz.pts.util.PTSReport.R5Builder;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.pts.PTSPreLayoutHandler;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.pts.PTSStyleManager;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class PTSLiteItemViewBuilder
{
  private static HashMap<String, Integer> i = new HashMap();
  private static int j = 154;
  private static int k = j;
  private List<String> a;
  private Context b;
  private ReadInJoyBaseAdapter c;
  private HashMap<String, Integer> d = new HashMap();
  private HashMap<String, AbsBaseArticleInfo> e = new HashMap();
  private IPTSLiteEventListener f;
  private PTSLiteTapEventDispatcher g;
  private PTSLiteSwiperEventDispatcher h;
  
  public PTSLiteItemViewBuilder(Context paramContext, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    this.b = paramContext;
    this.c = paramReadInJoyBaseAdapter;
    this.a = new ArrayList();
    d();
    c();
  }
  
  public static int a()
  {
    int m = k;
    int n = j;
    if (m > n) {
      return m - n + 1;
    }
    return 0;
  }
  
  public static int a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.ptsItemData != null) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.ptsLitePageName)))
    {
      paramAbsBaseArticleInfo = (Integer)i.get(paramAbsBaseArticleInfo.ptsLitePageName);
      if (paramAbsBaseArticleInfo != null) {
        return paramAbsBaseArticleInfo.intValue();
      }
      return j;
    }
    return j;
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    this.d.put(paramAbsBaseArticleInfo.innerUniqueID, Integer.valueOf(paramInt));
    if ((paramAbsBaseArticleInfo.mSubArticleList != null) && (paramAbsBaseArticleInfo.mSubArticleList.size() > 0))
    {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mSubArticleList.iterator();
      while (paramAbsBaseArticleInfo.hasNext())
      {
        AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)paramAbsBaseArticleInfo.next();
        this.d.put(localAbsBaseArticleInfo.innerUniqueID, Integer.valueOf(paramInt));
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
    return (paramInt >= j) && (paramInt <= k);
  }
  
  public static boolean b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return true;
    }
    if (c(paramAbsBaseArticleInfo)) {
      return a(paramAbsBaseArticleInfo) == j;
    }
    return false;
  }
  
  private void c()
  {
    this.g = new PTSLiteTapEventDispatcher.Builder().a(this.c).a(this.d).b(this.e).a();
    this.h = new PTSLiteSwiperEventDispatcher.Builder().a(this.c).a(this.d).b(this.e).a();
    this.f = new PTSLiteItemViewBuilder.1(this);
  }
  
  public static <T extends AbsBaseArticleInfo> boolean c(T paramT)
  {
    return (paramT != null) && (!TextUtils.isEmpty(paramT.ptsLitePageName)) && (paramT.ptsItemData != null);
  }
  
  private void d()
  {
    i.clear();
    Object localObject = PTSStyleManager.a().a("default_feeds");
    if (localObject == null)
    {
      QLog.i("PTSLiteItemViewBuilder", 1, "[initViewTypeCount], pageNameList is null.");
      return;
    }
    j = this.c.G().a() + 154;
    int m = j;
    localObject = new ArrayList((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      int n = m + 1;
      m = n;
      if (!i.containsKey(str))
      {
        i.put(str, Integer.valueOf(n));
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[initViewTypeCount], pageName = ");
        localStringBuilder.append(str);
        localStringBuilder.append(", viewType = ");
        localStringBuilder.append(n);
        QLog.i("PTSLiteItemViewBuilder", 1, localStringBuilder.toString());
        m = n;
      }
    }
    k = m;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[initViewType], type_pts_lite_gone = ");
    ((StringBuilder)localObject).append(j);
    ((StringBuilder)localObject).append(", type_pts_lite_end = ");
    ((StringBuilder)localObject).append(k);
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
        paramView = new PTSLitePlayableCardView(this.b);
      }
      localPTSComposer.layoutToView(paramView.getPtsItemView(), this.f);
      PTSLiteItemViewUtil.a.a(paramView.getPtsItemView());
      PTSLiteItemViewUtil.a.a(paramReadInJoyModelImpl, paramView, this.c);
      a(paramAbsBaseArticleInfo, paramInt);
      this.e.put(paramAbsBaseArticleInfo.innerUniqueID, paramAbsBaseArticleInfo);
      a(localPTSItemData);
    }
    else
    {
      paramView = new StringBuilder();
      paramView.append("[getView] error, ptsItemData is null or ptsComposer is null, hide the itemView, ");
      paramView.append(PTSPreLayoutHandler.b(paramAbsBaseArticleInfo));
      paramView = paramView.toString();
      QLog.e("PTSLiteItemViewBuilder", 1, paramView);
      PTSReport.a("0X800BC8A", "", "", "", new PTSReport.R5Builder().a("msg", paramView).a());
      paramView = new PTSLitePlayableCardView(this.b);
      paramView.setLayoutParams(new AbsListView.LayoutParams(0, 0));
      paramView.setVisibility(8);
    }
    paramView.setTag(2131436721, this.c.k());
    return paramView;
  }
  
  public void b()
  {
    this.a.clear();
    int m = this.c.c();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[destroy] channelId = ");
    ((StringBuilder)localObject).append(m);
    QLog.i("PTSLiteItemViewBuilder", 1, ((StringBuilder)localObject).toString());
    if ((m != 41505) && (m != 41697))
    {
      PTSPreLayoutHandler.b(ReadInJoyLogicEngine.a().d(Integer.valueOf(m)));
    }
    else
    {
      PTSPreLayoutHandler.b(ReadInJoyLogicEngine.a().d(Integer.valueOf(41505)));
      PTSPreLayoutHandler.b(ReadInJoyLogicEngine.a().d(Integer.valueOf(41697)));
    }
    localObject = this.h;
    if (localObject != null) {
      ((PTSLiteSwiperEventDispatcher)localObject).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.lite.PTSLiteItemViewBuilder
 * JD-Core Version:    0.7.0.1
 */