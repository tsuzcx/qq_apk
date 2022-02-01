package com.tencent.mobileqq.kandian.biz.share.api;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/share/api/ShareCallBack;", "", "callback", "", "action", "", "success", "", "msg", "", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface ShareCallBack
{
  public abstract void a(int paramInt, boolean paramBoolean, @Nullable String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.api.ShareCallBack
 * JD-Core Version:    0.7.0.1
 */