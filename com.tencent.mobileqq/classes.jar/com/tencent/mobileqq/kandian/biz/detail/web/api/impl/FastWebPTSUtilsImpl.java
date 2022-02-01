package com.tencent.mobileqq.kandian.biz.detail.web.api.impl;

import android.content.Context;
import com.tencent.mobileqq.kandian.biz.detail.web.api.IFastWebPTSUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebPTSUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/detail/web/api/impl/FastWebPTSUtilsImpl;", "Lcom/tencent/mobileqq/kandian/biz/detail/web/api/IFastWebPTSUtils;", "()V", "disLikeAd", "", "context", "Landroid/content/Context;", "adData", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/BaseData;", "getTextFontRatio", "", "()Ljava/lang/Float;", "isArticleContent", "", "baseData", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class FastWebPTSUtilsImpl
  implements IFastWebPTSUtils
{
  public void disLikeAd(@Nullable Context paramContext, @Nullable BaseData paramBaseData)
  {
    if ((paramContext instanceof FastWebActivity)) {
      ((FastWebActivity)paramContext).a(paramBaseData);
    }
  }
  
  @Nullable
  public Float getTextFontRatio()
  {
    return FastWebPTSUtils.b();
  }
  
  public boolean isArticleContent(@Nullable BaseData paramBaseData)
  {
    return FastWebPTSUtils.a(paramBaseData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.detail.web.api.impl.FastWebPTSUtilsImpl
 * JD-Core Version:    0.7.0.1
 */