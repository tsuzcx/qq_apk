package com.tencent.mobileqq.kandian.biz.hippy.module;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.kandian.biz.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.mobileqq.kandian.biz.framework.RIJCreateArticleInfoForBiu;
import com.tencent.mobileqq.kandian.biz.hippy.api.ParamsFetcher;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/hippy/module/TKDBiuModule$openBiuEditor$1$1", "Lcom/tencent/mobileqq/kandian/biz/hippy/api/ParamsFetcher;", "onGetParams", "", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "adTag", "", "biuType", "sourceUrl", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class TKDBiuModule$openBiuEditor$1$1
  implements ParamsFetcher
{
  public void onGetParams(@NotNull AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, int paramInt2, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsBaseArticleInfo, "articleInfo");
    Intrinsics.checkParameterIsNotNull(paramString, "sourceUrl");
    paramAbsBaseArticleInfo = RIJCreateArticleInfoForBiu.a(new Intent((Context)this.this$0.$activity, ReadInJoyDeliverBiuActivity.class), paramAbsBaseArticleInfo, paramInt2, this.this$0.$wholeContent, this.this$0.$uin, this.this$0.$nickname, 0, paramInt1);
    Intrinsics.checkExpressionValueIsNotNull(paramAbsBaseArticleInfo, "RIJCreateArticleInfoForB…tInfo.OP_TYPE_BIU, adTag)");
    this.this$0.$activity.startActivityForResult(paramAbsBaseArticleInfo, 113);
    this.this$0.$activity.overridePendingTransition(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.module.TKDBiuModule.openBiuEditor.1.1
 * JD-Core Version:    0.7.0.1
 */