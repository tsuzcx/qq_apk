package com.tencent.mobileqq.kandian.biz.pts.api;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.pts.IProteusItemView;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/pts/api/IProteusSupportUtil;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "bindData", "", "proteusItemView", "Lcom/tencent/mobileqq/kandian/biz/pts/IProteusItemView;", "adapterViewType", "", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "context", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/VafContext;", "faceDecoder", "Lcom/tencent/mobileqq/app/face/IFaceDecoder;", "adapter", "Lcom/tencent/mobileqq/kandian/biz/common/baseui/IReadInJoyBaseAdapter;", "model", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/api/IReadInJoyModel;", "position", "serviceKey", "", "bindDynamicValue", "view", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;", "viewBean", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/ViewBean;", "getView", "initAdapterProteus", "vafContext", "serviceID", "isSupportProteus", "", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IProteusSupportUtil
  extends QRouteApi
{
  public abstract void bindData(@Nullable IProteusItemView paramIProteusItemView, int paramInt1, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, int paramInt2, @Nullable String paramString);
  
  public abstract void bindDynamicValue(@Nullable ViewBase paramViewBase, @Nullable ViewBean paramViewBean);
  
  @Nullable
  public abstract IProteusItemView getView(@Nullable VafContext paramVafContext, int paramInt, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract void initAdapterProteus(@Nullable VafContext paramVafContext, @Nullable String paramString);
  
  public abstract boolean isSupportProteus();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.api.IProteusSupportUtil
 * JD-Core Version:    0.7.0.1
 */