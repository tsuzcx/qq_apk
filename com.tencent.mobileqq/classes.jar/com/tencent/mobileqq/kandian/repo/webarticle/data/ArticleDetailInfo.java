package com.tencent.mobileqq.kandian.repo.webarticle.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/webarticle/data/ArticleDetailInfo;", "", "()V", "accountAvatarUrl", "", "getAccountAvatarUrl", "()Ljava/lang/String;", "setAccountAvatarUrl", "(Ljava/lang/String;)V", "accountName", "getAccountName", "setAccountName", "articleContentJson", "getArticleContentJson", "setArticleContentJson", "articleId", "", "getArticleId", "()J", "setArticleId", "(J)V", "coverImageUrl", "getCoverImageUrl", "setCoverImageUrl", "extendInfoJson", "getExtendInfoJson", "setExtendInfoJson", "isOverLength", "", "()Z", "setOverLength", "(Z)V", "pUin", "getPUin", "setPUin", "publishTime", "getPublishTime", "setPublishTime", "readCount", "getReadCount", "setReadCount", "rowKey", "getRowKey", "setRowKey", "tags", "getTags", "setTags", "title", "getTitle", "setTitle", "toString", "kandian-api_release"}, k=1, mv={1, 1, 16})
public final class ArticleDetailInfo
{
  @NotNull
  private String accountAvatarUrl = "";
  @NotNull
  private String accountName = "";
  @NotNull
  private String articleContentJson = "";
  private long articleId;
  @NotNull
  private String coverImageUrl = "";
  @NotNull
  private String extendInfoJson = "";
  private boolean isOverLength;
  private long pUin;
  private long publishTime;
  private long readCount;
  @NotNull
  private String rowKey = "";
  @NotNull
  private String tags = "";
  @NotNull
  private String title = "";
  
  @NotNull
  public final String getAccountAvatarUrl()
  {
    return this.accountAvatarUrl;
  }
  
  @NotNull
  public final String getAccountName()
  {
    return this.accountName;
  }
  
  @NotNull
  public final String getArticleContentJson()
  {
    return this.articleContentJson;
  }
  
  public final long getArticleId()
  {
    return this.articleId;
  }
  
  @NotNull
  public final String getCoverImageUrl()
  {
    return this.coverImageUrl;
  }
  
  @NotNull
  public final String getExtendInfoJson()
  {
    return this.extendInfoJson;
  }
  
  public final long getPUin()
  {
    return this.pUin;
  }
  
  public final long getPublishTime()
  {
    return this.publishTime;
  }
  
  public final long getReadCount()
  {
    return this.readCount;
  }
  
  @NotNull
  public final String getRowKey()
  {
    return this.rowKey;
  }
  
  @NotNull
  public final String getTags()
  {
    return this.tags;
  }
  
  @NotNull
  public final String getTitle()
  {
    return this.title;
  }
  
  public final boolean isOverLength()
  {
    return this.isOverLength;
  }
  
  public final void setAccountAvatarUrl(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.accountAvatarUrl = paramString;
  }
  
  public final void setAccountName(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.accountName = paramString;
  }
  
  public final void setArticleContentJson(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.articleContentJson = paramString;
  }
  
  public final void setArticleId(long paramLong)
  {
    this.articleId = paramLong;
  }
  
  public final void setCoverImageUrl(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.coverImageUrl = paramString;
  }
  
  public final void setExtendInfoJson(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.extendInfoJson = paramString;
  }
  
  public final void setOverLength(boolean paramBoolean)
  {
    this.isOverLength = paramBoolean;
  }
  
  public final void setPUin(long paramLong)
  {
    this.pUin = paramLong;
  }
  
  public final void setPublishTime(long paramLong)
  {
    this.publishTime = paramLong;
  }
  
  public final void setReadCount(long paramLong)
  {
    this.readCount = paramLong;
  }
  
  public final void setRowKey(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.rowKey = paramString;
  }
  
  public final void setTags(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.tags = paramString;
  }
  
  public final void setTitle(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.title = paramString;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("rowKey = ");
    localStringBuilder.append(this.rowKey);
    localStringBuilder.append(", ");
    localStringBuilder.append("articleId = ");
    localStringBuilder.append(this.articleId);
    localStringBuilder.append(", ");
    localStringBuilder.append("isOverLength = ");
    localStringBuilder.append(this.isOverLength);
    localStringBuilder.append(", ");
    localStringBuilder.append("title = ");
    localStringBuilder.append(this.title);
    localStringBuilder.append(", ");
    localStringBuilder.append("coverImageUrl = ");
    localStringBuilder.append(this.coverImageUrl);
    localStringBuilder.append(", ");
    localStringBuilder.append("readCount = ");
    localStringBuilder.append(this.readCount);
    localStringBuilder.append(", ");
    localStringBuilder.append("publishTime = ");
    localStringBuilder.append(this.publishTime);
    localStringBuilder.append(", ");
    localStringBuilder.append("pUin = ");
    localStringBuilder.append(this.pUin);
    localStringBuilder.append(", ");
    localStringBuilder.append("accountAvatarUrl = ");
    localStringBuilder.append(this.accountAvatarUrl);
    localStringBuilder.append(", ");
    localStringBuilder.append("accountName = ");
    localStringBuilder.append(this.accountName);
    localStringBuilder.append(", ");
    localStringBuilder.append("extendInfoJson = ");
    localStringBuilder.append(this.extendInfoJson);
    localStringBuilder.append(", ");
    localStringBuilder.append("articleContentJson = ");
    localStringBuilder.append(this.articleContentJson);
    localStringBuilder.append(", ");
    localStringBuilder.append("tags = ");
    localStringBuilder.append(this.tags);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.webarticle.data.ArticleDetailInfo
 * JD-Core Version:    0.7.0.1
 */