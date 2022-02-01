package com.tencent.mobileqq.kandian.repo.webarticle.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/webarticle/data/IndexInfo;", "", "()V", "accountAvatarUrl", "", "getAccountAvatarUrl", "()Ljava/lang/String;", "setAccountAvatarUrl", "(Ljava/lang/String;)V", "accountName", "getAccountName", "setAccountName", "articleContent", "getArticleContent", "setArticleContent", "articleCss", "getArticleCss", "setArticleCss", "articleId", "", "getArticleId", "()J", "setArticleId", "(J)V", "articleNewCss", "getArticleNewCss", "setArticleNewCss", "beaconWebScript", "getBeaconWebScript", "setBeaconWebScript", "commentBarScript", "getCommentBarScript", "setCommentBarScript", "cookieScript", "getCookieScript", "setCookieScript", "coverImageUrl", "getCoverImageUrl", "setCoverImageUrl", "debugScript", "getDebugScript", "setDebugScript", "extendInfoJson", "getExtendInfoJson", "setExtendInfoJson", "longPressScript", "getLongPressScript", "setLongPressScript", "pUin", "getPUin", "setPUin", "prefixScript", "getPrefixScript", "setPrefixScript", "publishTime", "getPublishTime", "setPublishTime", "readCount", "getReadCount", "setReadCount", "rowKey", "getRowKey", "setRowKey", "seaScript", "getSeaScript", "setSeaScript", "tags", "getTags", "setTags", "title", "getTitle", "setTitle", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class IndexInfo
{
  @NotNull
  private String accountAvatarUrl = "";
  @NotNull
  private String accountName = "";
  @NotNull
  private String articleContent = "";
  @NotNull
  private String articleCss = "";
  private long articleId;
  @NotNull
  private String articleNewCss = "";
  @NotNull
  private String beaconWebScript = "";
  @NotNull
  private String commentBarScript = "";
  @NotNull
  private String cookieScript = "";
  @NotNull
  private String coverImageUrl = "";
  @NotNull
  private String debugScript = "";
  @NotNull
  private String extendInfoJson = "";
  @NotNull
  private String longPressScript = "";
  private long pUin;
  @NotNull
  private String prefixScript = "";
  @NotNull
  private String publishTime = "";
  private long readCount;
  @NotNull
  private String rowKey = "";
  @NotNull
  private String seaScript = "";
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
  public final String getArticleContent()
  {
    return this.articleContent;
  }
  
  @NotNull
  public final String getArticleCss()
  {
    return this.articleCss;
  }
  
  public final long getArticleId()
  {
    return this.articleId;
  }
  
  @NotNull
  public final String getArticleNewCss()
  {
    return this.articleNewCss;
  }
  
  @NotNull
  public final String getBeaconWebScript()
  {
    return this.beaconWebScript;
  }
  
  @NotNull
  public final String getCommentBarScript()
  {
    return this.commentBarScript;
  }
  
  @NotNull
  public final String getCookieScript()
  {
    return this.cookieScript;
  }
  
  @NotNull
  public final String getCoverImageUrl()
  {
    return this.coverImageUrl;
  }
  
  @NotNull
  public final String getDebugScript()
  {
    return this.debugScript;
  }
  
  @NotNull
  public final String getExtendInfoJson()
  {
    return this.extendInfoJson;
  }
  
  @NotNull
  public final String getLongPressScript()
  {
    return this.longPressScript;
  }
  
  public final long getPUin()
  {
    return this.pUin;
  }
  
  @NotNull
  public final String getPrefixScript()
  {
    return this.prefixScript;
  }
  
  @NotNull
  public final String getPublishTime()
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
  public final String getSeaScript()
  {
    return this.seaScript;
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
  
  public final void setArticleContent(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.articleContent = paramString;
  }
  
  public final void setArticleCss(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.articleCss = paramString;
  }
  
  public final void setArticleId(long paramLong)
  {
    this.articleId = paramLong;
  }
  
  public final void setArticleNewCss(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.articleNewCss = paramString;
  }
  
  public final void setBeaconWebScript(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.beaconWebScript = paramString;
  }
  
  public final void setCommentBarScript(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.commentBarScript = paramString;
  }
  
  public final void setCookieScript(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.cookieScript = paramString;
  }
  
  public final void setCoverImageUrl(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.coverImageUrl = paramString;
  }
  
  public final void setDebugScript(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.debugScript = paramString;
  }
  
  public final void setExtendInfoJson(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.extendInfoJson = paramString;
  }
  
  public final void setLongPressScript(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.longPressScript = paramString;
  }
  
  public final void setPUin(long paramLong)
  {
    this.pUin = paramLong;
  }
  
  public final void setPrefixScript(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.prefixScript = paramString;
  }
  
  public final void setPublishTime(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.publishTime = paramString;
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
  
  public final void setSeaScript(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.seaScript = paramString;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.webarticle.data.IndexInfo
 * JD-Core Version:    0.7.0.1
 */