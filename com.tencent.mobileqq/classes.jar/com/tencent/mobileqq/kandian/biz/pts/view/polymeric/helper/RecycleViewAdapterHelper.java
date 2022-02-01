package com.tencent.mobileqq.kandian.biz.pts.view.polymeric.helper;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.BaseTemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.polymeric.EventCallback;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.polymeric.PolymericContainer;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.polymeric.PolymericContainerHelper;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.BindDataUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.entity.IAdSmallGameReportManager;
import com.tencent.mobileqq.kandian.biz.follow.popup.RIJFollowPackUtils;
import com.tencent.mobileqq.kandian.biz.follow.popup.RIJFollowPackUtils.RIJFollowPackData;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.pts.ReadInJoyModelImpl;
import com.tencent.mobileqq.kandian.biz.pts.view.polymeric.ProteusRecycleView;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.RecommendFollowInfos;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.follow.RecommendFollowInfo;
import com.tencent.mobileqq.kandian.repo.pts.ProteusReportUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class RecycleViewAdapterHelper
  extends RecyclerView.Adapter
  implements PolymericContainer
{
  private static List<Integer> f = new ArrayList();
  private static int g = 0;
  private static Map<Long, List<AbsBaseArticleInfo>> i = new HashMap();
  protected PolymericContainerHelper a = new PolymericContainerHelper();
  protected int b = 0;
  protected Map<String, Integer> c = new HashMap();
  protected Map<Integer, String> d = new HashMap();
  protected IReadInJoyModel e;
  private List<AbsBaseArticleInfo> h;
  private boolean j = true;
  private RecycleViewAdapterHelper.OnErrorListener k;
  private ProteusRecycleView l;
  private RecycleViewAdapterHelper.OnItemClickListener m;
  private IAdSmallGameReportManager n = ((IRIJAdService)QRoute.api(IRIJAdService.class)).createAdSmallGameReportManager();
  private Object o;
  private Map<Object, Object> p = new HashMap();
  private VafContext q;
  private EventCallback r = new RecycleViewAdapterHelper.5(this);
  
  public RecycleViewAdapterHelper(VafContext paramVafContext)
  {
    this.q = paramVafContext;
    f.add(Integer.valueOf(0));
  }
  
  public static List<AbsBaseArticleInfo> a(long paramLong)
  {
    return (List)i.get(Long.valueOf(paramLong));
  }
  
  private JSONObject a(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = new JSONObject(paramJSONObject.toString());
      paramJSONObject.put("style_ID", "ReadInjoy_daily_check_share");
      return paramJSONObject;
    }
    catch (Exception paramJSONObject)
    {
      QLog.e("RecycleViewAdapterHelper", 1, paramJSONObject, new Object[0]);
    }
    return null;
  }
  
  private void a(int paramInt1, ViewBase paramViewBase, int paramInt2)
  {
    paramViewBase.setOnClickListener(new RecycleViewAdapterHelper.4(this, paramInt2, paramInt1));
  }
  
  private void a(RecycleViewAdapterHelper.SimpleHolder paramSimpleHolder, int paramInt, TemplateBean paramTemplateBean)
  {
    ViewFactory.findClickableViewListener(((Container)paramSimpleHolder.itemView).getVirtualView(), new RecycleViewAdapterHelper.3(this, paramInt, paramTemplateBean));
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    if ((paramAbsBaseArticleInfo instanceof BaseArticleInfo))
    {
      Object localObject = this.e.t().getContext();
      int i2 = getItemViewType(paramInt);
      int i3 = (int)paramAbsBaseArticleInfo.mChannelID;
      int i1;
      if (paramAbsBaseArticleInfo.mChannelID == 3L) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      localObject = new ReadInJoyModelImpl((Context)localObject, paramAbsBaseArticleInfo, i2, i3, i1, paramInt, false, a(), null, (ReadInJoyBaseAdapter)this.e.u());
      ((ReadInJoyBaseAdapter)this.e.u()).a(paramAbsBaseArticleInfo, (IReadInJoyModel)localObject, System.currentTimeMillis(), paramInt);
    }
  }
  
  private void a(Runnable paramRunnable)
  {
    if (!this.l.isComputingLayout())
    {
      paramRunnable.run();
      return;
    }
    this.l.postDelayed(new RecycleViewAdapterHelper.6(this, paramRunnable), 100L);
  }
  
  private void a(String paramString, int paramInt)
  {
    this.d.put(Integer.valueOf(paramInt), paramString);
    this.c.put(paramString, Integer.valueOf(paramInt));
  }
  
  public static void b()
  {
    f.clear();
    f.add(Integer.valueOf(g));
  }
  
  public static void b(long paramLong)
  {
    i.remove(Long.valueOf(paramLong));
  }
  
  private void b(IReadInJoyModel paramIReadInJoyModel)
  {
    IReadInJoyModel localIReadInJoyModel = this.e;
    if ((localIReadInJoyModel != null) && (localIReadInJoyModel != paramIReadInJoyModel) && (localIReadInJoyModel.k() != null) && (this.e.k().getId() != paramIReadInJoyModel.k().getId()))
    {
      paramIReadInJoyModel = this.l;
      if (paramIReadInJoyModel != null) {
        paramIReadInJoyModel.smoothScrollToPosition(0);
      }
    }
  }
  
  public static List<Integer> c()
  {
    return f;
  }
  
  private void c(int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("addExportItem curPosition: ");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append("  model :");
    ((StringBuilder)localObject1).append(this.e);
    QLog.d("RecycleViewAdapterHelper", 1, ((StringBuilder)localObject1).toString());
    TemplateBean localTemplateBean = this.a.getCellData(paramInt);
    localObject1 = this.e;
    if ((localObject1 != null) && (((IReadInJoyModel)localObject1).k() != null) && (localTemplateBean != null))
    {
      try
      {
        if ((this.e.k().mGroupSubArticleList != null) && (this.e.k().mGroupSubArticleList.size() > paramInt) && (RIJFeedsType.l(this.e.k())) && (this.e.k().mNewPolymericInfo.a))
        {
          a((AbsBaseArticleInfo)this.e.k().mGroupSubArticleList.get(paramInt), paramInt);
        }
        else
        {
          Object localObject2 = (List)i.get(Long.valueOf(this.e.k().mArticleID));
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new ArrayList();
            i.put(Long.valueOf(this.e.k().mArticleID), localObject1);
          }
          if (paramInt < ((List)localObject1).size()) {
            return;
          }
          localObject2 = this.e.k().clone();
          ((AbsBaseArticleInfo)localObject2).mProteusTemplateBean = localTemplateBean;
          if ((localObject2 instanceof BaseArticleInfo)) {
            ((List)localObject1).add(localObject2);
          }
        }
      }
      catch (Exception localException)
      {
        QLog.d("RecycleViewAdapterHelper", 2, localException.getMessage());
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addExportItem added curPosition: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("  data :");
      localStringBuilder.append(localTemplateBean);
      localStringBuilder.append("   ");
      localStringBuilder.append(localTemplateBean.getDataAttribute(null));
      QLog.d("RecycleViewAdapterHelper", 1, localStringBuilder.toString());
    }
    d(paramInt);
  }
  
  private void d(int paramInt)
  {
    Object localObject = this.o;
    if (!(localObject instanceof RIJFollowPackUtils.RIJFollowPackData)) {
      return;
    }
    localObject = ((RIJFollowPackUtils.RIJFollowPackData)localObject).c();
    if (((AbsBaseArticleInfo)localObject).mRecommendFollowInfos == null) {
      return;
    }
    if (paramInt < 0) {
      ((AbsBaseArticleInfo)localObject).mRecommendFollowInfos.c.size();
    }
    RecommendFollowInfo localRecommendFollowInfo = (RecommendFollowInfo)((AbsBaseArticleInfo)localObject).mRecommendFollowInfos.c.get(paramInt);
    if (localRecommendFollowInfo != null)
    {
      if (this.p.containsKey(localRecommendFollowInfo)) {
        return;
      }
      this.p.put(localRecommendFollowInfo, Long.valueOf(localRecommendFollowInfo.uin));
      paramInt = ((AbsBaseArticleInfo)localObject).mRecommendFollowInfos.j;
      RIJFollowPackUtils.a.a("0X800B96C", Integer.valueOf(paramInt), localRecommendFollowInfo, null);
      RIJFollowPackUtils.a.a("0X800B1A6", Integer.valueOf(paramInt), localRecommendFollowInfo, RIJFollowPackUtils.a.a(localRecommendFollowInfo, false, Integer.valueOf(paramInt)));
    }
  }
  
  private View e()
  {
    View localView = new View(this.q.getContext());
    localView.setLayoutParams(new RecyclerView.LayoutParams(0, 0));
    localView.setVisibility(8);
    return localView;
  }
  
  private void e(int paramInt)
  {
    IAdSmallGameReportManager localIAdSmallGameReportManager = this.n;
    if (localIAdSmallGameReportManager != null)
    {
      VafContext localVafContext = this.q;
      if ((localVafContext != null) && (this.e != null)) {
        localIAdSmallGameReportManager.a(localVafContext.getContext(), this.e, paramInt, 2);
      }
    }
  }
  
  public int a()
  {
    return this.a.childs.size();
  }
  
  public int a(int paramInt)
  {
    int i1 = paramInt;
    if (this.j)
    {
      int i2 = a();
      i1 = paramInt;
      if (i2 > 0) {
        i1 = paramInt % i2;
      }
    }
    return i1;
  }
  
  public void a(ProteusRecycleView paramProteusRecycleView)
  {
    this.l = paramProteusRecycleView;
  }
  
  public void a(RecycleViewAdapterHelper.OnErrorListener paramOnErrorListener)
  {
    this.k = paramOnErrorListener;
  }
  
  public void a(RecycleViewAdapterHelper.OnItemClickListener paramOnItemClickListener)
  {
    this.m = paramOnItemClickListener;
    a(new RecycleViewAdapterHelper.1(this));
  }
  
  public void a(IReadInJoyModel paramIReadInJoyModel)
  {
    if (paramIReadInJoyModel == null) {
      return;
    }
    b(paramIReadInJoyModel);
    this.e = paramIReadInJoyModel;
    if (this.e.k() != null) {
      a(this.e.k().mGroupSubArticleList);
    }
  }
  
  public void a(Object paramObject)
  {
    this.o = paramObject;
  }
  
  public void a(List<AbsBaseArticleInfo> paramList)
  {
    this.h = paramList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public EventCallback getEventCallback()
  {
    return this.r;
  }
  
  public int getItemCount()
  {
    if ((this.j) && (a() > 1)) {
      return 2147483647;
    }
    return this.a.childs.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    paramInt = a(paramInt);
    TemplateBean localTemplateBean = (TemplateBean)this.a.childs.get(paramInt);
    Integer localInteger2 = (Integer)this.c.get(localTemplateBean.getStyleName());
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null)
    {
      localInteger1 = Integer.valueOf(this.b);
      a(localTemplateBean.getStyleName(), localInteger1.intValue());
      this.b += 1;
    }
    return localInteger1.intValue();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    paramInt = a(paramInt);
    Object localObject;
    if ((paramViewHolder instanceof RecycleViewAdapterHelper.SimpleHolder))
    {
      localObject = this.a.getCellData(paramInt);
      if (localObject == null)
      {
        QLog.e("RecycleViewAdapterHelper", 2, "data == null");
        return;
      }
      c(paramInt);
      e(paramInt);
      paramViewHolder = (RecycleViewAdapterHelper.SimpleHolder)paramViewHolder;
      Container localContainer = (Container)paramViewHolder.itemView;
      BindDataUtil.bindDynamicValueWithoutRecursion(localContainer, paramViewHolder.a, (TemplateBean)localObject);
      Layout.Params localParams = localContainer.getVirtualView().getComLayoutParams();
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localContainer.getLayoutParams();
      if ((localParams.mLayoutWidth > 0) && (localParams.mLayoutHeight > 0) && ((localLayoutParams.width != localParams.mLayoutWidth) || (localLayoutParams.height != localParams.mLayoutHeight)))
      {
        localLayoutParams.width = localParams.mLayoutWidth;
        localLayoutParams.height = localParams.mLayoutHeight;
        localContainer.setLayoutParams(localLayoutParams);
      }
      a(paramViewHolder, paramInt, (TemplateBean)localObject);
      return;
    }
    if ((paramViewHolder instanceof RecycleViewAdapterHelper.ErrorHolder))
    {
      paramViewHolder = (RecycleViewAdapterHelper.ErrorHolder)paramViewHolder;
      localObject = paramViewHolder.itemView.getLayoutParams();
      if (localObject != null)
      {
        ((ViewGroup.LayoutParams)localObject).width = 0;
        ((ViewGroup.LayoutParams)localObject).height = 0;
        paramViewHolder.itemView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = (String)this.d.get(Integer.valueOf(paramInt));
    Object localObject = this.q.getTemplateFactory().getTemplate(paramViewGroup);
    localObject = this.q.getViewFactory().inflate(this.q, (TemplateBean)localObject);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("styleName : ");
      ((StringBuilder)localObject).append(paramViewGroup);
      QLog.e("RecycleViewAdapterHelper", 1, ((StringBuilder)localObject).toString());
      ProteusReportUtil.a("error", "", paramViewGroup);
      a(new RecycleViewAdapterHelper.2(this));
      return new RecycleViewAdapterHelper.ErrorHolder(this, e());
    }
    paramViewGroup = ((Container)localObject).getVirtualView().getComLayoutParams();
    ((Container)localObject).setLayoutParams(new RecyclerView.LayoutParams(paramViewGroup.mLayoutWidth, paramViewGroup.mLayoutHeight));
    return new RecycleViewAdapterHelper.SimpleHolder(this, (Container)localObject, null);
  }
  
  public void setCellArray(BaseTemplateFactory paramBaseTemplateFactory, JSONArray paramJSONArray)
  {
    this.a.setCellArray(paramBaseTemplateFactory, paramJSONArray);
  }
  
  public void setEventCallback(EventCallback paramEventCallback)
  {
    if (paramEventCallback == null) {
      return;
    }
    this.r = paramEventCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.polymeric.helper.RecycleViewAdapterHelper
 * JD-Core Version:    0.7.0.1
 */