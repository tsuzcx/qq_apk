package com.tencent.tkd.topicsdk.publisharticle.draft;

import .r8.java8methods.utility.Integer.hashCode.II;
import .r8.java8methods.utility.Long.hashCode.IJ;
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
    if (this != paramObject) {
      if ((paramObject instanceof DraftBoxItem))
      {
        paramObject = (DraftBoxItem)paramObject;
        if ((this.jdField_a_of_type_Int == paramObject.jdField_a_of_type_Int) && (this.jdField_a_of_type_Long == paramObject.jdField_a_of_type_Long) && (Intrinsics.areEqual(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) && (Intrinsics.areEqual(this.jdField_a_of_type_ComTencentTkdTopicsdkBeanDraftArticleInfo, paramObject.jdField_a_of_type_ComTencentTkdTopicsdkBeanDraftArticleInfo)) && (Intrinsics.areEqual(this.b, paramObject.b))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int m = .r8.java8methods.utility.Integer.hashCode.II.hashCode(this.jdField_a_of_type_Int);
    int n = .r8.java8methods.utility.Long.hashCode.IJ.hashCode(this.jdField_a_of_type_Long);
    Object localObject = this.jdField_a_of_type_JavaLangString;
    int k = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkBeanDraftArticleInfo;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.b;
    if (localObject != null) {
      k = localObject.hashCode();
    }
    return (((m * 31 + n) * 31 + i) * 31 + j) * 31 + k;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DraftBoxItem(id=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", timestamp=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", key=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", draftArticleInfo=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentTkdTopicsdkBeanDraftArticleInfo);
    localStringBuilder.append(", userId=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.draft.DraftBoxItem
 * JD-Core Version:    0.7.0.1
 */