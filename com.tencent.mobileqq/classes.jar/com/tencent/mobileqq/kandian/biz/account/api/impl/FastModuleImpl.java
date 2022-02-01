package com.tencent.mobileqq.kandian.biz.account.api.impl;

import com.tencent.mobileqq.kandian.biz.account.api.IFastModule;
import com.tencent.mobileqq.kandian.biz.account.api.IFastModule.FastWebContentCallback;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.fastweb.FastWebModule;
import com.tencent.mobileqq.kandian.repo.fastweb.FastWebModule.FastWebContentGetCallback;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/account/api/impl/FastModuleImpl;", "Lcom/tencent/mobileqq/kandian/biz/account/api/IFastModule;", "()V", "getArticleContent", "", "oriUrl", "", "rowKey", "puin", "reqType", "callback", "Lcom/tencent/mobileqq/kandian/biz/account/api/IFastModule$FastWebContentCallback;", "getFastWebArticleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/FastWebArticleInfo;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class FastModuleImpl
  implements IFastModule
{
  public int getArticleContent(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, int paramInt, @Nullable IFastModule.FastWebContentCallback paramFastWebContentCallback)
  {
    FastWebModule localFastWebModule = ReadInJoyLogicEngine.a().d();
    if (localFastWebModule != null) {
      return localFastWebModule.a(paramString1, paramString2, paramString3, paramInt, (FastWebModule.FastWebContentGetCallback)new FastModuleImpl.getArticleContent.1(paramFastWebContentCallback));
    }
    return 0;
  }
  
  @Nullable
  public FastWebArticleInfo getFastWebArticleInfo(@Nullable String paramString)
  {
    FastWebModule localFastWebModule = ReadInJoyLogicEngine.a().d();
    if (localFastWebModule != null) {
      return localFastWebModule.b(paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.account.api.impl.FastModuleImpl
 * JD-Core Version:    0.7.0.1
 */