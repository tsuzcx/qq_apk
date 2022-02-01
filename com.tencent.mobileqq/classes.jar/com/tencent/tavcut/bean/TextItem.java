package com.tencent.tavcut.bean;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/bean/TextItem;", "", "()V", "assetFontPath", "", "getAssetFontPath", "()Ljava/lang/String;", "setAssetFontPath", "(Ljava/lang/String;)V", "fontPath", "getFontPath", "setFontPath", "text", "getText", "setText", "textColor", "", "getTextColor", "()I", "setTextColor", "(I)V", "clone", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class TextItem
  implements Cloneable
{
  @Nullable
  private String assetFontPath;
  @Nullable
  private String fontPath;
  @Nullable
  private String text;
  private int textColor;
  
  @NotNull
  public TextItem clone()
  {
    TextItem localTextItem = new TextItem();
    localTextItem.text = this.text;
    localTextItem.textColor = this.textColor;
    localTextItem.fontPath = this.fontPath;
    localTextItem.assetFontPath = this.assetFontPath;
    return localTextItem;
  }
  
  @Nullable
  public final String getAssetFontPath()
  {
    return this.assetFontPath;
  }
  
  @Nullable
  public final String getFontPath()
  {
    return this.fontPath;
  }
  
  @Nullable
  public final String getText()
  {
    return this.text;
  }
  
  public final int getTextColor()
  {
    return this.textColor;
  }
  
  public final void setAssetFontPath(@Nullable String paramString)
  {
    this.assetFontPath = paramString;
  }
  
  public final void setFontPath(@Nullable String paramString)
  {
    this.fontPath = paramString;
  }
  
  public final void setText(@Nullable String paramString)
  {
    this.text = paramString;
  }
  
  public final void setTextColor(int paramInt)
  {
    this.textColor = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavcut.bean.TextItem
 * JD-Core Version:    0.7.0.1
 */