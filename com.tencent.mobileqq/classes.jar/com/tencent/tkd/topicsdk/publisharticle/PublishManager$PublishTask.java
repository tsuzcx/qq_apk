package com.tencent.tkd.topicsdk.publisharticle;

import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.topicsdk.framework.Uploader;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/publisharticle/PublishManager$PublishTask;", "", "articleInfo", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "(Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;)V", "getArticleInfo", "()Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "setArticleInfo", "currentUploader", "Lcom/tencent/tkd/topicsdk/framework/Uploader;", "getCurrentUploader", "()Lcom/tencent/tkd/topicsdk/framework/Uploader;", "setCurrentUploader", "(Lcom/tencent/tkd/topicsdk/framework/Uploader;)V", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class PublishManager$PublishTask
{
  @NotNull
  private PublishArticleInfo jdField_a_of_type_ComTencentTkdTopicsdkBeanPublishArticleInfo;
  @Nullable
  private Uploader jdField_a_of_type_ComTencentTkdTopicsdkFrameworkUploader;
  
  public PublishManager$PublishTask(@NotNull PublishArticleInfo paramPublishArticleInfo)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkBeanPublishArticleInfo = paramPublishArticleInfo;
  }
  
  @NotNull
  public final PublishArticleInfo a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkBeanPublishArticleInfo;
  }
  
  @Nullable
  public final Uploader a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkFrameworkUploader;
  }
  
  public final void a(@Nullable Uploader paramUploader)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkFrameworkUploader = paramUploader;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishManager.PublishTask
 * JD-Core Version:    0.7.0.1
 */