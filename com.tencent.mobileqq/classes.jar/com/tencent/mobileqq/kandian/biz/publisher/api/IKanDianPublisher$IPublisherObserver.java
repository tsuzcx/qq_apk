package com.tencent.mobileqq.kandian.biz.publisher.api;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/api/IKanDianPublisher$IPublisherObserver;", "", "onPublishArticleResult", "", "code", "", "msg", "", "onUploadImageResult", "onUploadVideoResult", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IKanDianPublisher$IPublisherObserver
{
  public abstract void a(int paramInt, @NotNull String paramString);
  
  public abstract void b(int paramInt, @NotNull String paramString);
  
  public abstract void c(int paramInt, @NotNull String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.api.IKanDianPublisher.IPublisherObserver
 * JD-Core Version:    0.7.0.1
 */