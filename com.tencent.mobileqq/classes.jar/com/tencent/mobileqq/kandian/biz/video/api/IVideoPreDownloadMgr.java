package com.tencent.mobileqq.kandian.biz.video.api;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoPreDownloadMgr;", "", "checkIsCached", "", "url", "", "vid", "updateReportData", "", "isHitCache", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IVideoPreDownloadMgr
{
  public abstract void a(@Nullable String paramString, boolean paramBoolean);
  
  public abstract boolean a(@Nullable String paramString1, @Nullable String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.api.IVideoPreDownloadMgr
 * JD-Core Version:    0.7.0.1
 */