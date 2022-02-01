package com.tencent.tkd.topicsdk.publisharticle.draft;

import com.tencent.tkd.topicsdk.bean.DraftArticleInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/publisharticle/draft/DraftBoxItem;", "", "id", "", "timestamp", "", "key", "", "draftArticleInfo", "Lcom/tencent/tkd/topicsdk/bean/DraftArticleInfo;", "userId", "(IJLjava/lang/String;Lcom/tencent/tkd/topicsdk/bean/DraftArticleInfo;Ljava/lang/String;)V", "getDraftArticleInfo", "()Lcom/tencent/tkd/topicsdk/bean/DraftArticleInfo;", "getId", "()I", "getKey", "()Ljava/lang/String;", "getTimestamp", "()J", "getUserId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class DraftBoxItem
{
  private final int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long;
  @NotNull
  private final DraftArticleInfo jdField_a_of_type_ComTencentTkdTopicsdkBeanDraftArticleInfo;
  @NotNull
  private final String jdField_a_of_type_JavaLangString;
  @NotNull
  private final String b;
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof DraftBoxItem))
      {
        paramObject = (DraftBoxItem)paramObject;
        if ((this.jdField_a_of_type_Int != paramObject.jdField_a_of_type_Int) || (this.jdField_a_of_type_Long != paramObject.jdField_a_of_type_Long) || (!Intrinsics.areEqual(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) || (!Intrinsics.areEqual(this.jdField_a_of_type_ComTencentTkdTopicsdkBeanDraftArticleInfo, paramObject.jdField_a_of_type_ComTencentTkdTopicsdkBeanDraftArticleInfo)) || (!Intrinsics.areEqual(this.b, paramObject.b))) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public int hashCode()
  {
    int k = 0;
    int m = Integer.hashCode(this.jdField_a_of_type_Int);
    int n = Long.hashCode(this.jdField_a_of_type_Long);
    Object localObject = this.jdField_a_of_type_JavaLangString;
    int i;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanDraftArticleInfo;
      if (localObject == null) {
        break label100;
      }
    }
    label100:
    for (int j = localObject.hashCode();; j = 0)
    {
      localObject = this.b;
      if (localObject != null) {
        k = localObject.hashCode();
      }
      return (j + (i + (m * 31 + n) * 31) * 31) * 31 + k;
      i = 0;
      break;
    }
  }
  
  @NotNull
  public String toString()
  {
    return "DraftBoxItem(id=" + this.jdField_a_of_type_Int + ", timestamp=" + this.jdField_a_of_type_Long + ", key=" + this.jdField_a_of_type_JavaLangString + ", draftArticleInfo=" + this.jdField_a_of_type_ComTencentTkdTopicsdkBeanDraftArticleInfo + ", userId=" + this.b + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.draft.DraftBoxItem
 * JD-Core Version:    0.7.0.1
 */