package com.tencent.mobileqq.kandian.biz.detail.web.api;

import android.content.Context;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/detail/web/api/IFastWebPTSUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "disLikeAd", "", "context", "Landroid/content/Context;", "adData", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/BaseData;", "getTextFontRatio", "", "()Ljava/lang/Float;", "isArticleContent", "", "baseData", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IFastWebPTSUtils
  extends QRouteApi
{
  public abstract void disLikeAd(@Nullable Context paramContext, @Nullable BaseData paramBaseData);
  
  @Nullable
  public abstract Float getTextFontRatio();
  
  public abstract boolean isArticleContent(@Nullable BaseData paramBaseData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.detail.web.api.IFastWebPTSUtils
 * JD-Core Version:    0.7.0.1
 */