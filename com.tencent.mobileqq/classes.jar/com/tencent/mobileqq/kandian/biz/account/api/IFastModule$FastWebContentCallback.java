package com.tencent.mobileqq.kandian.biz.account.api;

import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/account/api/IFastModule$FastWebContentCallback;", "", "onResp", "", "isSucc", "", "useWebView", "data", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/FastWebArticleInfo;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IFastModule$FastWebContentCallback
{
  public abstract void a(boolean paramBoolean1, boolean paramBoolean2, @Nullable FastWebArticleInfo paramFastWebArticleInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.account.api.IFastModule.FastWebContentCallback
 * JD-Core Version:    0.7.0.1
 */