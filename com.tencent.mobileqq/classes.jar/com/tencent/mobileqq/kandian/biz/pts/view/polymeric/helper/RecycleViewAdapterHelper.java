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
  private static List<Integer> jdField_a_of_type_JavaUtilList = new ArrayList();
  private static int jdField_b_of_type_Int = 0;
  private static Map<Long, List<AbsBaseArticleInfo>> c = new HashMap();
  protected int a;
  private EventCallback jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerPolymericEventCallback = new RecycleViewAdapterHelper.5(this);
  protected PolymericContainerHelper a;
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  private IAdSmallGameReportManager jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIAdSmallGameReportManager = ((IRIJAdService)QRoute.api(IRIJAdService.class)).createAdSmallGameReportManager();
  private ProteusRecycleView jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericProteusRecycleView;
  private RecycleViewAdapterHelper.OnErrorListener jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericHelperRecycleViewAdapterHelper$OnErrorListener;
  private RecycleViewAdapterHelper.OnItemClickListener jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericHelperRecycleViewAdapterHelper$OnItemClickListener;
  protected IReadInJoyModel a;
  private Object jdField_a_of_type_JavaLangObject;
  protected Map<String, Integer> a;
  private boolean jdField_a_of_type_Boolean = true;
  private List<AbsBaseArticleInfo> jdField_b_of_type_JavaUtilList;
  protected Map<Integer, String> b;
  private Map<Object, Object> d = new HashMap();
  
  public RecycleViewAdapterHelper(VafContext paramVafContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerPolymericPolymericContainerHelper = new PolymericContainerHelper();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = paramVafContext;
    jdField_a_of_type_JavaUtilList.add(Integer.valueOf(0));
  }
  
  private View a()
  {
    View localView = new View(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getContext());
    localView.setLayoutParams(new RecyclerView.LayoutParams(0, 0));
    localView.setVisibility(8);
    return localView;
  }
  
  public static List<Integer> a()
  {
    return jdField_a_of_type_JavaUtilList;
  }
  
  public static List<AbsBaseArticleInfo> a(long paramLong)
  {
    return (List)c.get(Long.valueOf(paramLong));
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
  
  public static void a()
  {
    jdField_a_of_type_JavaUtilList.clear();
    jdField_a_of_type_JavaUtilList.add(Integer.valueOf(jdField_b_of_type_Int));
  }
  
  private void a(int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("addExportItem curPosition: ");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append("  model :");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel);
    QLog.d("RecycleViewAdapterHelper", 1, ((StringBuilder)localObject1).toString());
    TemplateBean localTemplateBean = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerPolymericPolymericContainerHelper.getCellData(paramInt);
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel;
    if ((localObject1 != null) && (((IReadInJoyModel)localObject1).a() != null) && (localTemplateBean != null))
    {
      try
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a().mGroupSubArticleList != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a().mGroupSubArticleList.size() > paramInt) && (RIJFeedsType.h(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a())) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a().mNewPolymericInfo.jdField_a_of_type_Boolean))
        {
          a((AbsBaseArticleInfo)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a().mGroupSubArticleList.get(paramInt), paramInt);
        }
        else
        {
          Object localObject2 = (List)c.get(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a().mArticleID));
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new ArrayList();
            c.put(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a().mArticleID), localObject1);
          }
          if (paramInt < ((List)localObject1).size()) {
            return;
          }
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a().clone();
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
    b(paramInt);
  }
  
  private void a(int paramInt1, ViewBase paramViewBase, int paramInt2)
  {
    paramViewBase.setOnClickListener(new RecycleViewAdapterHelper.4(this, paramInt2, paramInt1));
  }
  
  public static void a(long paramLong)
  {
    c.remove(Long.valueOf(paramLong));
  }
  
  private void a(RecycleViewAdapterHelper.SimpleHolder paramSimpleHolder, int paramInt, TemplateBean paramTemplateBean)
  {
    ViewFactory.findClickableViewListener(((Container)paramSimpleHolder.itemView).getVirtualView(), new RecycleViewAdapterHelper.3(this, paramInt, paramTemplateBean));
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    if ((paramAbsBaseArticleInfo instanceof BaseArticleInfo))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a().getContext();
      int j = getItemViewType(paramInt);
      int k = (int)paramAbsBaseArticleInfo.mChannelID;
      int i;
      if (paramAbsBaseArticleInfo.mChannelID == 3L) {
        i = 1;
      } else {
        i = 0;
      }
      localObject = new ReadInJoyModelImpl((Context)localObject, paramAbsBaseArticleInfo, j, k, i, paramInt, false, a(), null, (ReadInJoyBaseAdapter)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a());
      ((ReadInJoyBaseAdapter)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a()).a(paramAbsBaseArticleInfo, (IReadInJoyModel)localObject, System.currentTimeMillis(), paramInt);
    }
  }
  
  private void a(Runnable paramRunnable)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericProteusRecycleView.isComputingLayout())
    {
      paramRunnable.run();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericProteusRecycleView.postDelayed(new RecycleViewAdapterHelper.6(this, paramRunnable), 100L);
  }
  
  private void a(String paramString, int paramInt)
  {
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), paramString);
    this.jdField_a_of_type_JavaUtilMap.put(paramString, Integer.valueOf(paramInt));
  }
  
  private void b(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    if (!(localObject instanceof RIJFollowPackUtils.RIJFollowPackData)) {
      return;
    }
    localObject = ((RIJFollowPackUtils.RIJFollowPackData)localObject).a();
    if (((AbsBaseArticleInfo)localObject).mRecommendFollowInfos == null) {
      return;
    }
    if (paramInt < 0) {
      ((AbsBaseArticleInfo)localObject).mRecommendFollowInfos.jdField_a_of_type_JavaUtilList.size();
    }
    RecommendFollowInfo localRecommendFollowInfo = (RecommendFollowInfo)((AbsBaseArticleInfo)localObject).mRecommendFollowInfos.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localRecommendFollowInfo != null)
    {
      if (this.d.containsKey(localRecommendFollowInfo)) {
        return;
      }
      this.d.put(localRecommendFollowInfo, Long.valueOf(localRecommendFollowInfo.uin));
      paramInt = ((AbsBaseArticleInfo)localObject).mRecommendFollowInfos.jdField_b_of_type_Int;
      RIJFollowPackUtils.a.a("0X800B96C", Integer.valueOf(paramInt), localRecommendFollowInfo, null);
      RIJFollowPackUtils.a.a("0X800B1A6", Integer.valueOf(paramInt), localRecommendFollowInfo, RIJFollowPackUtils.a.a(localRecommendFollowInfo, false, Integer.valueOf(paramInt)));
    }
  }
  
  private void b(IReadInJoyModel paramIReadInJoyModel)
  {
    IReadInJoyModel localIReadInJoyModel = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel;
    if ((localIReadInJoyModel != null) && (localIReadInJoyModel != paramIReadInJoyModel) && (localIReadInJoyModel.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a().getId() != paramIReadInJoyModel.a().getId()))
    {
      paramIReadInJoyModel = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericProteusRecycleView;
      if (paramIReadInJoyModel != null) {
        paramIReadInJoyModel.smoothScrollToPosition(0);
      }
    }
  }
  
  private void c(int paramInt)
  {
    IAdSmallGameReportManager localIAdSmallGameReportManager = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIAdSmallGameReportManager;
    if (localIAdSmallGameReportManager != null)
    {
      VafContext localVafContext = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
      if ((localVafContext != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel != null)) {
        localIAdSmallGameReportManager.a(localVafContext.getContext(), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel, paramInt, 2);
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerPolymericPolymericContainerHelper.childs.size();
  }
  
  public int a(int paramInt)
  {
    int i = paramInt;
    if (this.jdField_a_of_type_Boolean)
    {
      int j = a();
      i = paramInt;
      if (j > 0) {
        i = paramInt % j;
      }
    }
    return i;
  }
  
  public void a(ProteusRecycleView paramProteusRecycleView)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericProteusRecycleView = paramProteusRecycleView;
  }
  
  public void a(RecycleViewAdapterHelper.OnErrorListener paramOnErrorListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericHelperRecycleViewAdapterHelper$OnErrorListener = paramOnErrorListener;
  }
  
  public void a(RecycleViewAdapterHelper.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericHelperRecycleViewAdapterHelper$OnItemClickListener = paramOnItemClickListener;
    a(new RecycleViewAdapterHelper.1(this));
  }
  
  public void a(IReadInJoyModel paramIReadInJoyModel)
  {
    if (paramIReadInJoyModel == null) {
      return;
    }
    b(paramIReadInJoyModel);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel = paramIReadInJoyModel;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a() != null) {
      a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a().mGroupSubArticleList);
    }
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public void a(List<AbsBaseArticleInfo> paramList)
  {
    this.jdField_b_of_type_JavaUtilList = paramList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public EventCallback getEventCallback()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerPolymericEventCallback;
  }
  
  public int getItemCount()
  {
    if ((this.jdField_a_of_type_Boolean) && (a() > 1)) {
      return 2147483647;
    }
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerPolymericPolymericContainerHelper.childs.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    paramInt = a(paramInt);
    TemplateBean localTemplateBean = (TemplateBean)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerPolymericPolymericContainerHelper.childs.get(paramInt);
    Integer localInteger2 = (Integer)this.jdField_a_of_type_JavaUtilMap.get(localTemplateBean.getStyleName());
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null)
    {
      localInteger1 = Integer.valueOf(this.jdField_a_of_type_Int);
      a(localTemplateBean.getStyleName(), localInteger1.intValue());
      this.jdField_a_of_type_Int += 1;
    }
    return localInteger1.intValue();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    paramInt = a(paramInt);
    Object localObject;
    if ((paramViewHolder instanceof RecycleViewAdapterHelper.SimpleHolder))
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerPolymericPolymericContainerHelper.getCellData(paramInt);
      if (localObject == null)
      {
        QLog.e("RecycleViewAdapterHelper", 2, "data == null");
        return;
      }
      a(paramInt);
      c(paramInt);
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
    paramViewGroup = (String)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getTemplateFactory().getTemplate(paramViewGroup);
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getViewFactory().inflate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, (TemplateBean)localObject);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("styleName : ");
      ((StringBuilder)localObject).append(paramViewGroup);
      QLog.e("RecycleViewAdapterHelper", 1, ((StringBuilder)localObject).toString());
      ProteusReportUtil.a("error", "", paramViewGroup);
      a(new RecycleViewAdapterHelper.2(this));
      return new RecycleViewAdapterHelper.ErrorHolder(this, a());
    }
    paramViewGroup = ((Container)localObject).getVirtualView().getComLayoutParams();
    ((Container)localObject).setLayoutParams(new RecyclerView.LayoutParams(paramViewGroup.mLayoutWidth, paramViewGroup.mLayoutHeight));
    return new RecycleViewAdapterHelper.SimpleHolder(this, (Container)localObject, null);
  }
  
  public void setCellArray(BaseTemplateFactory paramBaseTemplateFactory, JSONArray paramJSONArray)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerPolymericPolymericContainerHelper.setCellArray(paramBaseTemplateFactory, paramJSONArray);
  }
  
  public void setEventCallback(EventCallback paramEventCallback)
  {
    if (paramEventCallback == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerPolymericEventCallback = paramEventCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.polymeric.helper.RecycleViewAdapterHelper
 * JD-Core Version:    0.7.0.1
 */