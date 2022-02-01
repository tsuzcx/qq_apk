package com.tencent.mobileqq.mini.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/mini/model/AppDetainConfig;", "", "content", "", "exitButton", "enterButton", "openLink", "openType", "exitPage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getEnterButton", "getExitButton", "getExitPage", "getOpenLink", "getOpenType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "isValidItem", "toString", "qqmini_impl_release"}, k=1, mv={1, 1, 16})
public final class AppDetainConfig
{
  @NotNull
  private final String content;
  @NotNull
  private final String enterButton;
  @NotNull
  private final String exitButton;
  @Nullable
  private final String exitPage;
  @Nullable
  private final String openLink;
  @Nullable
  private final String openType;
  
  public AppDetainConfig(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @Nullable String paramString4, @Nullable String paramString5, @Nullable String paramString6)
  {
    this.content = paramString1;
    this.exitButton = paramString2;
    this.enterButton = paramString3;
    this.openLink = paramString4;
    this.openType = paramString5;
    this.exitPage = paramString6;
  }
  
  @NotNull
  public final String component1()
  {
    return this.content;
  }
  
  @NotNull
  public final String component2()
  {
    return this.exitButton;
  }
  
  @NotNull
  public final String component3()
  {
    return this.enterButton;
  }
  
  @Nullable
  public final String component4()
  {
    return this.openLink;
  }
  
  @Nullable
  public final String component5()
  {
    return this.openType;
  }
  
  @Nullable
  public final String component6()
  {
    return this.exitPage;
  }
  
  @NotNull
  public final AppDetainConfig copy(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @Nullable String paramString4, @Nullable String paramString5, @Nullable String paramString6)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "content");
    Intrinsics.checkParameterIsNotNull(paramString2, "exitButton");
    Intrinsics.checkParameterIsNotNull(paramString3, "enterButton");
    return new AppDetainConfig(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof AppDetainConfig))
      {
        paramObject = (AppDetainConfig)paramObject;
        if ((Intrinsics.areEqual(this.content, paramObject.content)) && (Intrinsics.areEqual(this.exitButton, paramObject.exitButton)) && (Intrinsics.areEqual(this.enterButton, paramObject.enterButton)) && (Intrinsics.areEqual(this.openLink, paramObject.openLink)) && (Intrinsics.areEqual(this.openType, paramObject.openType)) && (Intrinsics.areEqual(this.exitPage, paramObject.exitPage))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final String getContent()
  {
    return this.content;
  }
  
  @NotNull
  public final String getEnterButton()
  {
    return this.enterButton;
  }
  
  @NotNull
  public final String getExitButton()
  {
    return this.exitButton;
  }
  
  @Nullable
  public final String getExitPage()
  {
    return this.exitPage;
  }
  
  @Nullable
  public final String getOpenLink()
  {
    return this.openLink;
  }
  
  @Nullable
  public final String getOpenType()
  {
    return this.openType;
  }
  
  public int hashCode()
  {
    String str = this.content;
    int i1 = 0;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    str = this.exitButton;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.enterButton;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    str = this.openLink;
    int m;
    if (str != null) {
      m = str.hashCode();
    } else {
      m = 0;
    }
    str = this.openType;
    int n;
    if (str != null) {
      n = str.hashCode();
    } else {
      n = 0;
    }
    str = this.exitPage;
    if (str != null) {
      i1 = str.hashCode();
    }
    return ((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1;
  }
  
  public final boolean isValidItem()
  {
    int i = ((CharSequence)this.content).length();
    boolean bool = true;
    if (i > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (((CharSequence)this.exitButton).length() > 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if (((CharSequence)this.enterButton).length() > 0) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          String str = this.exitPage;
          if (str == null) {
            return bool;
          }
          if (((CharSequence)str).length() > 0) {
            i = 1;
          } else {
            i = 0;
          }
          if (i != 0) {
            return true;
          }
        }
      }
    }
    bool = false;
    return bool;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AppDetainConfig(content=");
    localStringBuilder.append(this.content);
    localStringBuilder.append(", exitButton=");
    localStringBuilder.append(this.exitButton);
    localStringBuilder.append(", enterButton=");
    localStringBuilder.append(this.enterButton);
    localStringBuilder.append(", openLink=");
    localStringBuilder.append(this.openLink);
    localStringBuilder.append(", openType=");
    localStringBuilder.append(this.openType);
    localStringBuilder.append(", exitPage=");
    localStringBuilder.append(this.exitPage);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.model.AppDetainConfig
 * JD-Core Version:    0.7.0.1
 */