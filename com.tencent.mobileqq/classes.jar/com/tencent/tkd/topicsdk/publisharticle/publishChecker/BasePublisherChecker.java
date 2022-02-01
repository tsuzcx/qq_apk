package com.tencent.tkd.topicsdk.publisharticle.publishChecker;

import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/publisharticle/publishChecker/BasePublisherChecker;", "", "publishArticleInfo", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "(Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;)V", "countLimit", "", "getCountLimit", "()I", "setCountLimit", "(I)V", "getPublishArticleInfo", "()Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "getValidCode", "isContentNotEmpty", "", "setTextCountLimit", "limit", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public abstract class BasePublisherChecker
{
  public static final BasePublisherChecker.Companion a;
  private int jdField_a_of_type_Int;
  @NotNull
  private final PublishArticleInfo jdField_a_of_type_ComTencentTkdTopicsdkBeanPublishArticleInfo;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkPublisharticlePublishCheckerBasePublisherChecker$Companion = new BasePublisherChecker.Companion(null);
  }
  
  public BasePublisherChecker(@NotNull PublishArticleInfo paramPublishArticleInfo)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkBeanPublishArticleInfo = paramPublishArticleInfo;
    this.jdField_a_of_type_Int = -1;
  }
  
  public int a()
  {
    if (!a()) {
      return 2;
    }
    if ((this.jdField_a_of_type_ComTencentTkdTopicsdkBeanPublishArticleInfo.getContentLength() > this.jdField_a_of_type_Int) && (this.jdField_a_of_type_Int != -1)) {
      return 1;
    }
    return 0;
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
    if (((CharSequence)this.jdField_a_of_type_ComTencentTkdTopicsdkBeanPublishArticleInfo.getContent()).length() > 0)
    {
      i = 1;
      if (i == 0)
      {
        ArrayList localArrayList = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanPublishArticleInfo.getImageList();
        if (localArrayList != null) {
          if (((Collection)localArrayList).isEmpty()) {
            break label72;
          }
        }
      }
    }
    label72:
    for (int i = 1;; i = 0)
    {
      if (i != 1) {
        if (this.jdField_a_of_type_ComTencentTkdTopicsdkBeanPublishArticleInfo.getVideoInfo() == null) {
          break label77;
        }
      }
      return true;
      i = 0;
      break;
    }
    label77:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.publishChecker.BasePublisherChecker
 * JD-Core Version:    0.7.0.1
 */