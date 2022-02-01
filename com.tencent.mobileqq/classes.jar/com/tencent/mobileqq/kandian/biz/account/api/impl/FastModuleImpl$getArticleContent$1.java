package com.tencent.mobileqq.kandian.biz.account.api.impl;

import com.tencent.mobileqq.kandian.biz.account.api.IFastModule.FastWebContentCallback;
import com.tencent.mobileqq.kandian.repo.fastweb.FastWebModule.FastWebContentGetCallback;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "isSucc", "", "useWebView", "data", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/FastWebArticleInfo;", "onResp"}, k=3, mv={1, 1, 16})
final class FastModuleImpl$getArticleContent$1
  implements FastWebModule.FastWebContentGetCallback
{
  FastModuleImpl$getArticleContent$1(IFastModule.FastWebContentCallback paramFastWebContentCallback) {}
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, @Nullable FastWebArticleInfo paramFastWebArticleInfo)
  {
    IFastModule.FastWebContentCallback localFastWebContentCallback = this.a;
    if (localFastWebContentCallback != null) {
      localFastWebContentCallback.a(paramBoolean1, paramBoolean2, paramFastWebArticleInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.account.api.impl.FastModuleImpl.getArticleContent.1
 * JD-Core Version:    0.7.0.1
 */