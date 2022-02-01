package com.tencent.tkd.topicsdk.interfaces;

import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/interfaces/IPublishManager$IPublishListener;", "", "onPublish", "", "articleInfo", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "topicsdk_release"}, k=1, mv={1, 1, 16})
public abstract interface IPublishManager$IPublishListener
{
  public abstract void a(@NotNull PublishArticleInfo paramPublishArticleInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.interfaces.IPublishManager.IPublishListener
 * JD-Core Version:    0.7.0.1
 */