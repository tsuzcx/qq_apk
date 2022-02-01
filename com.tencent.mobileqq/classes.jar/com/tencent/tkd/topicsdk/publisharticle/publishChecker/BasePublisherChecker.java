package com.tencent.tkd.topicsdk.publisharticle.publishChecker;

import com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/publisharticle/publishChecker/BasePublisherChecker;", "", "publishArticleInfo", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "config", "Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;", "(Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;)V", "getConfig", "()Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;", "countLimit", "", "getCountLimit", "()I", "setCountLimit", "(I)V", "getPublishArticleInfo", "()Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "getValidCode", "isContentNotEmpty", "", "setTextCountLimit", "limit", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public abstract class BasePublisherChecker
{
  public static final BasePublisherChecker.Companion a;
  private int jdField_a_of_type_Int;
  @Nullable
  private final GlobalPublisherConfig jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
  @NotNull
  private final PublishArticleInfo jdField_a_of_type_ComTencentTkdTopicsdkBeanPublishArticleInfo;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkPublisharticlePublishCheckerBasePublisherChecker$Companion = new BasePublisherChecker.Companion(null);
  }
  
  public BasePublisherChecker(@NotNull PublishArticleInfo paramPublishArticleInfo, @Nullable GlobalPublisherConfig paramGlobalPublisherConfig)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkBeanPublishArticleInfo = paramPublishArticleInfo;
    this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig = paramGlobalPublisherConfig;
    this.jdField_a_of_type_Int = -1;
  }
  
  public int a()
  {
    if (!a()) {
      return 2;
    }
    int i = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanPublishArticleInfo.getContentLength();
    int j = this.jdField_a_of_type_Int;
    if ((i > j) && (j != -1)) {
      return 1;
    }
    return 0;
  }
  
  @Nullable
  public final GlobalPublisherConfig a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkBeanGlobalPublisherConfig;
  }
  
  @NotNull
  public final PublishArticleInfo a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkBeanPublishArticleInfo;
  }
  
  @NotNull
  public final BasePublisherChecker a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public boolean a()
  {
    int i = ((CharSequence)this.jdField_a_of_type_ComTencentTkdTopicsdkBeanPublishArticleInfo.getContent()).length();
    boolean bool = false;
    if (i > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      ArrayList localArrayList = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanPublishArticleInfo.getImageList();
      if (((localArrayList == null) || ((((Collection)localArrayList).isEmpty() ^ true) != true)) && (this.jdField_a_of_type_ComTencentTkdTopicsdkBeanPublishArticleInfo.getVideoInfo() == null)) {}
    }
    else
    {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.publishChecker.BasePublisherChecker
 * JD-Core Version:    0.7.0.1
 */