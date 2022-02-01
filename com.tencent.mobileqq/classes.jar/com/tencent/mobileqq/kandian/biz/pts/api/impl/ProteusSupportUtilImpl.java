package com.tencent.mobileqq.kandian.biz.pts.api.impl;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.pts.IProteusItemView;
import com.tencent.mobileqq.kandian.biz.pts.api.IProteusSupportUtil;
import com.tencent.mobileqq.kandian.biz.pts.util.ProteusSettingUtil;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/pts/api/impl/ProteusSupportUtilImpl;", "Lcom/tencent/mobileqq/kandian/biz/pts/api/IProteusSupportUtil;", "()V", "bindData", "", "proteusItemView", "Lcom/tencent/mobileqq/kandian/biz/pts/IProteusItemView;", "adapterViewType", "", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "context", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/VafContext;", "faceDecoder", "Lcom/tencent/mobileqq/app/face/IFaceDecoder;", "adapter", "Lcom/tencent/mobileqq/kandian/biz/common/baseui/IReadInJoyBaseAdapter;", "model", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/api/IReadInJoyModel;", "position", "serviceKey", "", "bindDynamicValue", "view", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;", "viewBean", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/ViewBean;", "getView", "initAdapterProteus", "vafContext", "serviceID", "isSupportProteus", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ProteusSupportUtilImpl
  implements IProteusSupportUtil
{
  public void bindData(@Nullable IProteusItemView paramIProteusItemView, int paramInt1, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo, @Nullable VafContext paramVafContext, @Nullable IFaceDecoder paramIFaceDecoder, @Nullable IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, @Nullable IReadInJoyModel paramIReadInJoyModel, int paramInt2, @Nullable String paramString)
  {
    ProteusSupportUtil.a(paramIProteusItemView, paramInt1, paramAbsBaseArticleInfo, paramVafContext, paramIFaceDecoder, (ReadInJoyBaseAdapter)paramIReadInJoyBaseAdapter, paramIReadInJoyModel, paramInt2, paramString);
  }
  
  public void bindDynamicValue(@Nullable ViewBase paramViewBase, @Nullable ViewBean paramViewBean)
  {
    ProteusSupportUtil.a(paramViewBase, paramViewBean);
  }
  
  @Nullable
  public IProteusItemView getView(@Nullable VafContext paramVafContext, int paramInt, @Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return (IProteusItemView)ProteusSupportUtil.a(paramVafContext, paramInt, paramAbsBaseArticleInfo);
  }
  
  public void initAdapterProteus(@Nullable VafContext paramVafContext, @Nullable String paramString)
  {
    ProteusSupportUtil.a(paramVafContext, paramString);
  }
  
  public boolean isSupportProteus()
  {
    return ProteusSettingUtil.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.api.impl.ProteusSupportUtilImpl
 * JD-Core Version:    0.7.0.1
 */