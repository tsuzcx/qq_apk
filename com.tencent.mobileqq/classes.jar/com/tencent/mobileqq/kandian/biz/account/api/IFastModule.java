package com.tencent.mobileqq.kandian.biz.account.api;

import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={""})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/account/api/IFastModule;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getArticleContent", "", "oriUrl", "", "rowKey", "puin", "reqType", "callback", "Lcom/tencent/mobileqq/kandian/biz/account/api/IFastModule$FastWebContentCallback;", "getFastWebArticleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/FastWebArticleInfo;", "FastWebContentCallback", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IFastModule
  extends QRouteApi
{
  public abstract int getArticleContent(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, int paramInt, @Nullable IFastModule.FastWebContentCallback paramFastWebContentCallback);
  
  @Nullable
  public abstract FastWebArticleInfo getFastWebArticleInfo(@Nullable String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.account.api.IFastModule
 * JD-Core Version:    0.7.0.1
 */