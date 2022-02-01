package com.tencent.tkd.topicsdk.bean.globalconfig;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/bean/globalconfig/ManageTopicConfig;", "Ljava/io/Serializable;", "()V", "allowSubmitDesc", "", "getAllowSubmitDesc", "()Ljava/lang/String;", "setAllowSubmitDesc", "(Ljava/lang/String;)V", "allowSubmitTitle", "getAllowSubmitTitle", "setAllowSubmitTitle", "briefCountLimit", "", "getBriefCountLimit", "()I", "setBriefCountLimit", "(I)V", "briefHint", "getBriefHint", "setBriefHint", "currentAllowSubmit", "", "getCurrentAllowSubmit", "()Z", "setCurrentAllowSubmit", "(Z)V", "forbidSubmitDesc", "getForbidSubmitDesc", "setForbidSubmitDesc", "forbidSubmitTitle", "getForbidSubmitTitle", "setForbidSubmitTitle", "showSubmit", "getShowSubmit", "setShowSubmit", "titleCountLimit", "getTitleCountLimit", "setTitleCountLimit", "titleHint", "getTitleHint", "setTitleHint", "topicPermissionFlag", "getTopicPermissionFlag", "setTopicPermissionFlag", "videoPermissionFlag", "getVideoPermissionFlag", "setVideoPermissionFlag", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class ManageTopicConfig
  implements Serializable
{
  public static final int BRIEF_COUNT_LIMIT = 30;
  @NotNull
  public static final String BRIEF_HINT = "精彩的简介让人一看就懂";
  public static final ManageTopicConfig.Companion Companion = new ManageTopicConfig.Companion(null);
  @NotNull
  public static final String DEFAULT_ALLOW_SUBMIT_DESC = "允许他人投稿至栏目";
  @NotNull
  public static final String DEFAULT_ALLOW_SUBMIT_TITLE = "允许他人参加创作";
  @NotNull
  public static final String DEFAULT_FORBID_SUBMIT_DESC = "仅栏目创建者可往栏目添加视频";
  @NotNull
  public static final String DEFAULT_FORBID_SUBMIT_TITLE = "仅自己创作";
  public static final int TITLE_COUNT_LIMIT = 12;
  @NotNull
  public static final String TITLE_HINT = "给栏目起个名吧";
  @NotNull
  private String allowSubmitDesc = "允许他人投稿至栏目";
  @NotNull
  private String allowSubmitTitle = "允许他人参加创作";
  private int briefCountLimit = 30;
  @NotNull
  private String briefHint = "精彩的简介让人一看就懂";
  private boolean currentAllowSubmit = true;
  @NotNull
  private String forbidSubmitDesc = "仅栏目创建者可往栏目添加视频";
  @NotNull
  private String forbidSubmitTitle = "仅自己创作";
  private boolean showSubmit;
  private int titleCountLimit = 12;
  @NotNull
  private String titleHint = "给栏目起个名吧";
  private boolean topicPermissionFlag = true;
  private boolean videoPermissionFlag = true;
  
  @NotNull
  public final String getAllowSubmitDesc()
  {
    return this.allowSubmitDesc;
  }
  
  @NotNull
  public final String getAllowSubmitTitle()
  {
    return this.allowSubmitTitle;
  }
  
  public final int getBriefCountLimit()
  {
    return this.briefCountLimit;
  }
  
  @NotNull
  public final String getBriefHint()
  {
    return this.briefHint;
  }
  
  public final boolean getCurrentAllowSubmit()
  {
    return this.currentAllowSubmit;
  }
  
  @NotNull
  public final String getForbidSubmitDesc()
  {
    return this.forbidSubmitDesc;
  }
  
  @NotNull
  public final String getForbidSubmitTitle()
  {
    return this.forbidSubmitTitle;
  }
  
  public final boolean getShowSubmit()
  {
    return this.showSubmit;
  }
  
  public final int getTitleCountLimit()
  {
    return this.titleCountLimit;
  }
  
  @NotNull
  public final String getTitleHint()
  {
    return this.titleHint;
  }
  
  public final boolean getTopicPermissionFlag()
  {
    return this.topicPermissionFlag;
  }
  
  public final boolean getVideoPermissionFlag()
  {
    return this.videoPermissionFlag;
  }
  
  public final void setAllowSubmitDesc(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.allowSubmitDesc = paramString;
  }
  
  public final void setAllowSubmitTitle(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.allowSubmitTitle = paramString;
  }
  
  public final void setBriefCountLimit(int paramInt)
  {
    this.briefCountLimit = paramInt;
  }
  
  public final void setBriefHint(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.briefHint = paramString;
  }
  
  public final void setCurrentAllowSubmit(boolean paramBoolean)
  {
    this.currentAllowSubmit = paramBoolean;
  }
  
  public final void setForbidSubmitDesc(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.forbidSubmitDesc = paramString;
  }
  
  public final void setForbidSubmitTitle(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.forbidSubmitTitle = paramString;
  }
  
  public final void setShowSubmit(boolean paramBoolean)
  {
    this.showSubmit = paramBoolean;
  }
  
  public final void setTitleCountLimit(int paramInt)
  {
    this.titleCountLimit = paramInt;
  }
  
  public final void setTitleHint(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.titleHint = paramString;
  }
  
  public final void setTopicPermissionFlag(boolean paramBoolean)
  {
    this.topicPermissionFlag = paramBoolean;
  }
  
  public final void setVideoPermissionFlag(boolean paramBoolean)
  {
    this.videoPermissionFlag = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.bean.globalconfig.ManageTopicConfig
 * JD-Core Version:    0.7.0.1
 */