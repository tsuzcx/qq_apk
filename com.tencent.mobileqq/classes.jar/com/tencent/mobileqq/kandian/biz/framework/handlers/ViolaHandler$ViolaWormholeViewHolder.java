package com.tencent.mobileqq.kandian.biz.framework.handlers;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.glue.viola.wormhole.Wormhole;
import com.tencent.mobileqq.kandian.glue.viola.wormhole.WormholeView;
import com.tencent.mobileqq.kandian.glue.viola.wormhole.WormholeView.WormholeViewLifeListener;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfoKt;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.viola.vinstance.VInstanceAction.VInstanceEventListener;

public class ViolaHandler$ViolaWormholeViewHolder
  implements View.OnClickListener, WormholeView.WormholeViewLifeListener, VInstanceAction.VInstanceEventListener
{
  private int jdField_a_of_type_Int;
  private ViolaHandler jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersViolaHandler;
  private Wormhole jdField_a_of_type_ComTencentMobileqqKandianGlueViolaWormholeWormhole;
  private WormholeView jdField_a_of_type_ComTencentMobileqqKandianGlueViolaWormholeWormholeView;
  private AbsBaseArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  
  public ViolaHandler$ViolaWormholeViewHolder(Wormhole paramWormhole, WormholeView paramWormholeView, ViolaHandler paramViolaHandler)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaWormholeWormhole = paramWormhole;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersViolaHandler = paramViolaHandler;
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaWormholeWormholeView = paramWormholeView;
    paramWormholeView.setLifeListener(this);
    paramWormholeView.a();
    paramWormholeView.setOnErrorViewClickListener(this);
  }
  
  private boolean a(String paramString)
  {
    return (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(BaseArticleInfoKt.b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)));
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(WormholeView paramWormholeView)
  {
    Wormhole localWormhole = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaWormholeWormhole;
    if (localWormhole != null)
    {
      localWormhole.a(paramWormholeView.a(), this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersViolaHandler.a());
      paramWormholeView = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
      if (paramWormholeView != null) {
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaWormholeWormhole.a(BaseArticleInfoKt.b(paramWormholeView), this);
      }
    }
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    WormholeView localWormholeView = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaWormholeWormholeView;
    if (localWormholeView == null) {
      return;
    }
    Wormhole localWormhole = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaWormholeWormhole;
    if ((localWormhole != null) && (localWormhole.a(paramAbsBaseArticleInfo, paramInt, localWormholeView.a())))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaWormholeWormholeView.c();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaWormholeWormholeView.b();
  }
  
  public void b(WormholeView paramWormholeView)
  {
    Wormhole localWormhole = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaWormholeWormhole;
    if (localWormhole != null)
    {
      localWormhole.a(paramWormholeView.a());
      paramWormholeView = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
      if (paramWormholeView != null) {
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaWormholeWormhole.a(BaseArticleInfoKt.b(paramWormholeView));
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131381197)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
      if (paramView != null)
      {
        Wormhole localWormhole = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaWormholeWormhole;
        if (localWormhole != null) {
          localWormhole.a(BaseArticleInfoKt.b(paramView), BaseArticleInfoKt.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo));
        }
      }
    }
  }
  
  public void onError(String paramString)
  {
    if (a(paramString))
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaWormholeWormholeView;
      if (paramString != null) {
        paramString.d();
      }
    }
  }
  
  public void onRefreshItem(String paramString)
  {
    if (a(paramString)) {
      a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.handlers.ViolaHandler.ViolaWormholeViewHolder
 * JD-Core Version:    0.7.0.1
 */