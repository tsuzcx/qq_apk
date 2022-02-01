package com.tencent.mobileqq.kandian.repo.feeds.entity;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/feeds/entity/ArticleInsertInfo;", "", "()V", "hadBeenFiltered", "", "isFeedsDynamicInsert", "leastAdDis", "", "needFilterAd", "toString", "", "kandian-api_release"}, k=1, mv={1, 1, 16})
public final class ArticleInsertInfo
{
  @JvmField
  public int a;
  @JvmField
  public boolean a;
  @JvmField
  public boolean b;
  @JvmField
  public boolean c;
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ArticleInsertInfo(isFeedsDynamicInsert=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", needFilterAd=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", leastAdDis=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", hadBeenFiltered=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.ArticleInsertInfo
 * JD-Core Version:    0.7.0.1
 */