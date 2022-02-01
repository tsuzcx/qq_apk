package com.tencent.mobileqq.kandian.biz.video.click;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdActionUtilService;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.Builder;
import com.tencent.mobileqq.kandian.biz.framework.click.ClickHandler;
import com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler;
import com.tencent.mobileqq.kandian.biz.video.viewholder.VideoFeedsViewHolder;
import com.tencent.mobileqq.kandian.repo.account.RIJUserLevelModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class RIJVideoHandleClick
{
  private Context jdField_a_of_type_AndroidContentContext;
  private RIJDataManager jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager;
  private ClickHandler jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkClickClickHandler = new RIJVideoHandleClick.4(this);
  private HashMap<Integer, ClickHandler> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private ClickHandler b = new RIJVideoHandleClick.5(this);
  private ClickHandler c = new RIJVideoHandleClick.6(this);
  private ClickHandler d = new RIJVideoHandleClick.7(this);
  private ClickHandler e = new RIJVideoHandleClick.8(this);
  private ClickHandler f = new RIJVideoHandleClick.9(this);
  private ClickHandler g = new RIJVideoHandleClick.10(this);
  private ClickHandler h = new RIJVideoHandleClick.11(this);
  private ClickHandler i = new RIJVideoHandleClick.12(this);
  private ClickHandler j = new RIJVideoHandleClick.13(this);
  private ClickHandler k = new RIJVideoHandleClick.14(this);
  private ClickHandler l = new RIJVideoHandleClick.15(this);
  
  public RIJVideoHandleClick(RIJDataManager paramRIJDataManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager = paramRIJDataManager;
    this.jdField_a_of_type_AndroidContentContext = paramRIJDataManager.a().a();
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131376059), this.b);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131368583), this.c);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131380576), this.j);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131369931), this.d);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131376545), this.d);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131369930), this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkClickClickHandler);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131376544), this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkClickClickHandler);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131368461), this.e);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131380660), this.e);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131366750), this.e);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131380736), this.e);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131380652), this.f);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131373223), this.g);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131369963), this.h);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131376577), this.h);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131367807), this.i);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131367809), this.i);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131368584), this.j);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131362086), this.k);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(2131362165), this.l);
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    Object localObject = (VideoFeedsViewHolder)paramView.getTag();
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a(((VideoFeedsViewHolder)localObject).a);
    ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).setAdapterMonitorClickAdParams(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a(), (AbsBaseArticleInfo)localObject, this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a(), 56, paramBoolean);
    ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).doActionAndReport((Activity)this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a(), (AbsBaseArticleInfo)localObject, this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a(), 56, paramBoolean, null);
    VideoHandler.a(paramView);
  }
  
  public void a(View paramView)
  {
    Object localObject = (ClickHandler)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramView.getId()));
    if (localObject != null)
    {
      ((ClickHandler)localObject).onClick(paramView);
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onClick, has no click handler for id(");
    ((StringBuilder)localObject).append(paramView.getId());
    ((StringBuilder)localObject).append("}");
    QLog.e("RIJVideoHandleClick", 1, ((StringBuilder)localObject).toString());
  }
  
  public boolean a(View paramView)
  {
    if (paramView.getId() == 2131368583)
    {
      b(paramView);
      return true;
    }
    return false;
  }
  
  public void b(View paramView)
  {
    paramView = (VideoFeedsViewHolder)paramView.getTag();
    paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a(paramView.a);
    if (paramView == null) {
      return;
    }
    RIJUserLevelModule.getInstance().doActionsByUserLevel(this.jdField_a_of_type_AndroidContentContext, 2, new RIJVideoHandleClick.3(this, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.click.RIJVideoHandleClick
 * JD-Core Version:    0.7.0.1
 */