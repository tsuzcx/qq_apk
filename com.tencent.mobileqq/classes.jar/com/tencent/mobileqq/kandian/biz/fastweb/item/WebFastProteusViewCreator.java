package com.tencent.mobileqq.kandian.biz.fastweb.item;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.mobileqq.kandian.biz.fastweb.IStateChangeListener;
import com.tencent.mobileqq.kandian.biz.fastweb.entity.BaseItemViewHolder;
import com.tencent.mobileqq.kandian.biz.pts.ItemCreator;
import com.tencent.mobileqq.kandian.biz.pts.ReadInjoyContext;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.fastweb.FastWebModule;
import com.tencent.mobileqq.kandian.repo.fastweb.FastWebModule.FastWebArticleRichReqCallback;
import com.tencent.mobileqq.kandian.repo.fastweb.entity.ProteusBookData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.widget.AbsListView;

public class WebFastProteusViewCreator
  implements IStateChangeListener, ItemCreator
{
  private static boolean jdField_a_of_type_Boolean;
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  private FastWebModule.FastWebArticleRichReqCallback jdField_a_of_type_ComTencentMobileqqKandianRepoFastwebFastWebModule$FastWebArticleRichReqCallback = new WebFastProteusViewCreator.1(this);
  private AbsBaseArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  
  public int a(BaseData paramBaseData)
  {
    return 16;
  }
  
  public BaseItemViewHolder a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new ReadInjoyContext();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(paramContext);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo == null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramBaseData.b;
    }
    paramViewGroup = (ProteusBookData)paramBaseData;
    Container localContainer = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.getViewFactory().inflate(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, paramViewGroup.a);
    paramViewGroup = localContainer;
    if (localContainer == null) {
      paramViewGroup = new View(paramContext);
    }
    return new WebFastProteusViewCreator.TextViewHolder(paramViewGroup, paramBaseData);
  }
  
  public void a() {}
  
  public void a(AbsListView paramAbsListView, int paramInt) {}
  
  public boolean a(BaseData paramBaseData)
  {
    return paramBaseData.u == 18;
  }
  
  public void b()
  {
    if (jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = false;
      FastWebModule localFastWebModule = ReadInJoyLogicEngine.a().a();
      if (localFastWebModule != null) {
        localFastWebModule.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFastwebFastWebModule$FastWebArticleRichReqCallback, false);
      }
    }
  }
  
  public void c() {}
  
  public void d()
  {
    FastWebModule localFastWebModule = ReadInJoyLogicEngine.a().a();
    if (localFastWebModule != null) {
      localFastWebModule.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFastwebFastWebModule$FastWebArticleRichReqCallback);
    }
  }
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.item.WebFastProteusViewCreator
 * JD-Core Version:    0.7.0.1
 */