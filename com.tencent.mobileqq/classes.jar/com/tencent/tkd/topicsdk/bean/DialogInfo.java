package com.tencent.tkd.topicsdk.bean;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/bean/DialogInfo;", "Ljava/io/Serializable;", "title", "", "content", "cancelText", "confirmText", "jumpUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCancelText", "()Ljava/lang/String;", "getConfirmText", "getContent", "getJumpUrl", "getTitle", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class DialogInfo
  implements Serializable
{
  @NotNull
  private final String cancelText;
  @NotNull
  private final String confirmText;
  @NotNull
  private final String content;
  @NotNull
  private final String jumpUrl;
  @NotNull
  private final String title;
  
  public DialogInfo(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, @NotNull String paramString5)
  {
    this.title = paramString1;
    this.content = paramString2;
    this.cancelText = paramString3;
    this.confirmText = paramString4;
    this.jumpUrl = paramString5;
  }
  
  @NotNull
  public final String component1()
  {
    return this.title;
  }
  
  @NotNull
  public final String component2()
  {
    return this.content;
  }
  
  @NotNull
  public final String component3()
  {
    return this.cancelText;
  }
  
  @NotNull
  public final String component4()
  {
    return this.confirmText;
  }
  
  @NotNull
  public final String component5()
  {
    return this.jumpUrl;
  }
  
  @NotNull
  public final DialogInfo copy(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, @NotNull String paramString5)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "title");
    Intrinsics.checkParameterIsNotNull(paramString2, "content");
    Intrinsics.checkParameterIsNotNull(paramString3, "cancelText");
    Intrinsics.checkParameterIsNotNull(paramString4, "confirmText");
    Intrinsics.checkParameterIsNotNull(paramString5, "jumpUrl");
    return new DialogInfo(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof DialogInfo))
      {
        paramObject = (DialogInfo)paramObject;
        if ((Intrinsics.areEqual(this.title, paramObject.title)) && (Intrinsics.areEqual(this.content, paramObject.content)) && (Intrinsics.areEqual(this.cancelText, paramObject.cancelText)) && (Intrinsics.areEqual(this.confirmText, paramObject.confirmText)) && (Intrinsics.areEqual(this.jumpUrl, paramObject.jumpUrl))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final String getCancelText()
  {
    return this.cancelText;
  }
  
  @NotNull
  public final String getConfirmText()
  {
    return this.confirmText;
  }
  
  @NotNull
  public final String getContent()
  {
    return this.content;
  }
  
  @NotNull
  public final String getJumpUrl()
  {
    return this.jumpUrl;
  }
  
  @NotNull
  public final String getTitle()
  {
    return this.title;
  }
  
  public int hashCode()
  {
    String str = this.title;
    int n = 0;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    str = this.content;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.cancelText;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    str = this.confirmText;
    int m;
    if (str != null) {
      m = str.hashCode();
    } else {
      m = 0;
    }
    str = this.jumpUrl;
    if (str != null) {
      n = str.hashCode();
    }
    return (((i * 31 + j) * 31 + k) * 31 + m) * 31 + n;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DialogInfo(title=");
    localStringBuilder.append(this.title);
    localStringBuilder.append(", content=");
    localStringBuilder.append(this.content);
    localStringBuilder.append(", cancelText=");
    localStringBuilder.append(this.cancelText);
    localStringBuilder.append(", confirmText=");
    localStringBuilder.append(this.confirmText);
    localStringBuilder.append(", jumpUrl=");
    localStringBuilder.append(this.jumpUrl);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.bean.DialogInfo
 * JD-Core Version:    0.7.0.1
 */