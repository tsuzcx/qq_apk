package com.tencent.weseevideo.model.template.light;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/weseevideo/model/template/light/LightStickerTextModel;", "", "stickerTextContent", "", "stickerTextColor", "", "(Ljava/lang/String;I)V", "getStickerTextColor", "()I", "setStickerTextColor", "(I)V", "getStickerTextContent", "()Ljava/lang/String;", "setStickerTextContent", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class LightStickerTextModel
{
  private int stickerTextColor;
  @Nullable
  private String stickerTextContent;
  
  public LightStickerTextModel()
  {
    this(null, 0, 3, null);
  }
  
  public LightStickerTextModel(@Nullable String paramString, int paramInt)
  {
    this.stickerTextContent = paramString;
    this.stickerTextColor = paramInt;
  }
  
  @Nullable
  public final String component1()
  {
    return this.stickerTextContent;
  }
  
  public final int component2()
  {
    return this.stickerTextColor;
  }
  
  @NotNull
  public final LightStickerTextModel copy(@Nullable String paramString, int paramInt)
  {
    return new LightStickerTextModel(paramString, paramInt);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof LightStickerTextModel))
      {
        paramObject = (LightStickerTextModel)paramObject;
        if ((Intrinsics.areEqual(this.stickerTextContent, paramObject.stickerTextContent)) && (this.stickerTextColor == paramObject.stickerTextColor)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final int getStickerTextColor()
  {
    return this.stickerTextColor;
  }
  
  @Nullable
  public final String getStickerTextContent()
  {
    return this.stickerTextContent;
  }
  
  public int hashCode()
  {
    String str = this.stickerTextContent;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    return i * 31 + this.stickerTextColor;
  }
  
  public final void setStickerTextColor(int paramInt)
  {
    this.stickerTextColor = paramInt;
  }
  
  public final void setStickerTextContent(@Nullable String paramString)
  {
    this.stickerTextContent = paramString;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LightStickerTextModel(stickerTextContent=");
    localStringBuilder.append(this.stickerTextContent);
    localStringBuilder.append(", stickerTextColor=");
    localStringBuilder.append(this.stickerTextColor);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.model.template.light.LightStickerTextModel
 * JD-Core Version:    0.7.0.1
 */