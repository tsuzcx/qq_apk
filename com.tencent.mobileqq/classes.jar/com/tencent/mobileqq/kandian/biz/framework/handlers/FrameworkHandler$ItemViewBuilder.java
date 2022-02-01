package com.tencent.mobileqq.kandian.biz.framework.handlers;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.kandian.biz.account.api.ICellFactory;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.feeds.ark.FeedItemCellArk;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.pts.ReadInJoyModelImpl;
import com.tencent.mobileqq.kandian.biz.pts.api.IReadInJoyPTSCostHelper;
import com.tencent.mobileqq.kandian.biz.pts.item.ProteusItemView;
import com.tencent.mobileqq.kandian.biz.pts.util.DynamicItemViewHelper;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;

public class FrameworkHandler$ItemViewBuilder
{
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  private DynamicItemViewHelper jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilDynamicItemViewHelper;
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  public FrameworkHandler$ItemViewBuilder(FrameworkHandler paramFrameworkHandler) {}
  
  private View a(View paramView, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    View localView = paramView;
    if (paramAbsBaseArticleInfo != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FrameworkHandler", 2, new Object[] { "getArkAppView, position: ", Integer.valueOf(paramInt), ", articleInfo: ", paramAbsBaseArticleInfo, ", arkAppMessage: ", null });
      }
      localView = a(paramAbsBaseArticleInfo, paramView, null);
    }
    return localView;
  }
  
  private View a(View paramView, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, int paramInt2)
  {
    Object localObject = new ReadInJoyModelImpl(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersFrameworkHandler.a(), paramAbsBaseArticleInfo, paramInt1, this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersFrameworkHandler.a(), this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersFrameworkHandler.b(), paramInt2, this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersFrameworkHandler.a(), this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersFrameworkHandler.c(), null, this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersFrameworkHandler.a());
    View localView = ((ICellFactory)QRoute.api(ICellFactory.class)).getView(paramInt2, localObject, paramInt1, paramView, this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersFrameworkHandler.a(), this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersFrameworkHandler.a(), this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersFrameworkHandler.a());
    if (localView != null)
    {
      localView.setTag(2131380884, localObject);
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("CellFactoryImpl.getView = ");
        paramView.append(localView.getTag().getClass().getSimpleName());
        QLog.d("FrameworkHandler", 2, paramView.toString());
      }
      localView.setTag(2131369613, this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersFrameworkHandler.a());
      if (paramAbsBaseArticleInfo == null)
      {
        if (QLog.isColorLevel())
        {
          paramView = new StringBuilder();
          paramView.append("getView() article is null, set view gone, position: ");
          paramView.append(paramInt2);
          QLog.d("FrameworkHandler", 2, paramView.toString());
        }
        if (localView.getVisibility() != 8) {
          localView.setVisibility(8);
        }
        if ((localView.getLayoutParams() instanceof AbsListView.LayoutParams))
        {
          paramView = (AbsListView.LayoutParams)localView.getLayoutParams();
          if (paramView.height != 1)
          {
            paramView.height = 1;
            localView.setLayoutParams(paramView);
          }
        }
      }
      else
      {
        if (localView.getVisibility() != 0) {
          localView.setVisibility(0);
        }
        if ((localView.getLayoutParams() instanceof AbsListView.LayoutParams))
        {
          paramView = (AbsListView.LayoutParams)localView.getLayoutParams();
          if (paramView.height != -2)
          {
            paramView.height = -2;
            localView.setLayoutParams(paramView);
          }
        }
      }
    }
    else
    {
      QLog.w("FrameworkHandler", 1, "CellFactoryImpl.getView = null");
    }
    localObject = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    if (localView == null) {
      paramInt1 = 0;
    } else {
      paramInt1 = 1;
    }
    paramView = new StringBuilder();
    paramView.append(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersFrameworkHandler.b());
    paramView.append("");
    String str = paramView.toString();
    if (paramAbsBaseArticleInfo != null) {
      paramView = String.valueOf(paramAbsBaseArticleInfo.mArticleID);
    } else {
      paramView = "";
    }
    paramAbsBaseArticleInfo = new StringBuilder();
    paramAbsBaseArticleInfo.append(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersFrameworkHandler.a());
    paramAbsBaseArticleInfo.append("");
    ((IPublicAccountReportUtils)localObject).publicAccountReportClickEvent(null, "", "0X80095B4", "0X80095B4", 0, paramInt1, str, paramView, paramAbsBaseArticleInfo.toString(), "", false);
    return localView;
  }
  
  private View a(View paramView, AbsBaseArticleInfo paramAbsBaseArticleInfo1, AbsBaseArticleInfo paramAbsBaseArticleInfo2, int paramInt1, int paramInt2)
  {
    paramAbsBaseArticleInfo2 = new ReadInJoyModelImpl(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersFrameworkHandler.a(), paramAbsBaseArticleInfo1, paramInt1, this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersFrameworkHandler.a(), this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersFrameworkHandler.b(), paramInt2, this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersFrameworkHandler.a(), this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersFrameworkHandler.c(), paramAbsBaseArticleInfo2, this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersFrameworkHandler.a());
    paramAbsBaseArticleInfo2.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext);
    long l;
    if ((paramView != null) && ((paramView instanceof ProteusItemView)))
    {
      l = System.currentTimeMillis();
      paramView = (ProteusItemView)paramView;
      ProteusSupportUtil.a(paramView, paramInt1, paramAbsBaseArticleInfo1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersFrameworkHandler.a(), this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersFrameworkHandler.a(), paramAbsBaseArticleInfo2, paramInt2, "default_feeds");
      ((IReadInJoyPTSCostHelper)QRoute.api(IReadInJoyPTSCostHelper.class)).printCost("FrameworkHandler", String.valueOf(paramInt1), "getProteusNormalView.convertview#bindData", System.currentTimeMillis() - l);
    }
    else
    {
      l = System.currentTimeMillis();
      paramView = ProteusSupportUtil.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, paramInt1, paramAbsBaseArticleInfo1);
      ((IReadInJoyPTSCostHelper)QRoute.api(IReadInJoyPTSCostHelper.class)).printCost("FrameworkHandler", String.valueOf(paramInt1), "getProteusNormalView.getView", System.currentTimeMillis() - l);
      l = System.currentTimeMillis();
      ProteusSupportUtil.a(paramView, paramInt1, paramAbsBaseArticleInfo1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersFrameworkHandler.a(), this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersFrameworkHandler.a(), paramAbsBaseArticleInfo2, paramInt2, "default_feeds");
      ((IReadInJoyPTSCostHelper)QRoute.api(IReadInJoyPTSCostHelper.class)).printCost("FrameworkHandler", String.valueOf(paramInt1), "getProteusNormalView.newview#bindData", System.currentTimeMillis() - l);
    }
    if ((paramView != null) && (paramView.a() != null))
    {
      l = System.currentTimeMillis();
      paramAbsBaseArticleInfo1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersFrameworkHandler.a();
      paramView.a().setTag(2131369613, paramAbsBaseArticleInfo1);
      paramView.setTag(2131380884, paramAbsBaseArticleInfo2);
      ((IReadInJoyPTSCostHelper)QRoute.api(IReadInJoyPTSCostHelper.class)).printCost("FrameworkHandler", String.valueOf(paramInt1), "getProteusNormalView.setTag", System.currentTimeMillis() - l);
    }
    return paramView;
  }
  
  private View a(AbsBaseArticleInfo paramAbsBaseArticleInfo, View paramView, ArkAppMessage paramArkAppMessage)
  {
    if (paramAbsBaseArticleInfo == null) {
      return paramView;
    }
    if ((paramView != null) && ((paramView.getTag() instanceof FeedItemCellArk)))
    {
      paramAbsBaseArticleInfo = (FeedItemCellArk)paramView.getTag();
      return paramView;
    }
    paramAbsBaseArticleInfo = new FeedItemCellArk(paramArkAppMessage, paramAbsBaseArticleInfo);
    if (paramAbsBaseArticleInfo.a() != null)
    {
      paramView = paramAbsBaseArticleInfo.a();
      paramView.setTag(paramAbsBaseArticleInfo);
    }
    return paramView;
  }
  
  private View b(View paramView, AbsBaseArticleInfo paramAbsBaseArticleInfo1, AbsBaseArticleInfo paramAbsBaseArticleInfo2, int paramInt1, int paramInt2)
  {
    paramAbsBaseArticleInfo2 = new ReadInJoyModelImpl(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersFrameworkHandler.a(), paramAbsBaseArticleInfo1, paramInt1, this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersFrameworkHandler.a(), this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersFrameworkHandler.b(), paramInt2, this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersFrameworkHandler.a(), this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersFrameworkHandler.c(), paramAbsBaseArticleInfo2, this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersFrameworkHandler.a());
    long l;
    if ((paramView != null) && ((paramView instanceof ProteusItemView)))
    {
      l = System.currentTimeMillis();
      DynamicItemViewHelper localDynamicItemViewHelper = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilDynamicItemViewHelper;
      paramView = (ProteusItemView)paramView;
      localDynamicItemViewHelper.a(paramView, paramInt1, paramAbsBaseArticleInfo1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersFrameworkHandler.a(), this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersFrameworkHandler.a(), paramAbsBaseArticleInfo2, paramInt2);
      ((IReadInJoyPTSCostHelper)QRoute.api(IReadInJoyPTSCostHelper.class)).printCost("FrameworkHandler", String.valueOf(paramInt1), "getDynamicProteusView.convertview#bindData", System.currentTimeMillis() - l);
    }
    else
    {
      l = System.currentTimeMillis();
      paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilDynamicItemViewHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, paramInt1, paramAbsBaseArticleInfo1);
      ((IReadInJoyPTSCostHelper)QRoute.api(IReadInJoyPTSCostHelper.class)).printCost("FrameworkHandler", String.valueOf(paramInt1), "getDynamicProteusView.getView", System.currentTimeMillis() - l);
      l = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilDynamicItemViewHelper.a(paramView, paramInt1, paramAbsBaseArticleInfo1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersFrameworkHandler.a(), this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersFrameworkHandler.a(), paramAbsBaseArticleInfo2, paramInt2);
      ((IReadInJoyPTSCostHelper)QRoute.api(IReadInJoyPTSCostHelper.class)).printCost("FrameworkHandler", String.valueOf(paramInt1), "getDynamicProteusView.newview#bindData", System.currentTimeMillis() - l);
    }
    paramAbsBaseArticleInfo1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersFrameworkHandler.a();
    if (paramView.a() != null) {
      paramView.a().setTag(2131369613, paramAbsBaseArticleInfo1);
    }
    paramView.setTag(2131380884, paramAbsBaseArticleInfo2);
    return paramView;
  }
  
  public void a()
  {
    try
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersFrameworkHandler.a().a();
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilDynamicItemViewHelper = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersFrameworkHandler.a().a();
        this.jdField_a_of_type_Boolean = true;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.handlers.FrameworkHandler.ItemViewBuilder
 * JD-Core Version:    0.7.0.1
 */