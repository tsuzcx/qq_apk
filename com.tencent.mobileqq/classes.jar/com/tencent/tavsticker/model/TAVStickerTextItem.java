package com.tencent.tavsticker.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.tavsticker.TAVStickerHelper;
import com.tencent.tavsticker.core.TAVFontManager;
import org.libpag.PAGFont;
import org.libpag.PAGLayer;

public class TAVStickerTextItem
  extends TAVStickerLayerItem
  implements Parcelable
{
  public static final Parcelable.Creator<TAVStickerTextItem> CREATOR = new TAVStickerTextItem.1();
  private static final String TAG = "TAVStickerTextItem";
  private String assetFontPath = "";
  private int defaultColor = -16777216;
  private String defaultText = "";
  private String fontFamily = "";
  private String fontPath = "";
  private String fontStyle = "";
  private int maxLength = -1;
  private String text = "";
  private int textColor = 0;
  
  public TAVStickerTextItem()
  {
    this.layerType = 3;
    init();
  }
  
  protected TAVStickerTextItem(Parcel paramParcel)
  {
    if (paramParcel != null)
    {
      this.layerIndex = paramParcel.readInt();
      this.layerName = paramParcel.readString();
      this.layerType = paramParcel.readInt();
      this.text = paramParcel.readString();
      this.defaultText = paramParcel.readString();
      this.maxLength = paramParcel.readInt();
      this.textColor = paramParcel.readInt();
      this.defaultColor = paramParcel.readInt();
      this.fontPath = paramParcel.readString();
      this.assetFontPath = paramParcel.readString();
    }
  }
  
  public TAVStickerTextItem(PAGLayer paramPAGLayer)
  {
    super(paramPAGLayer);
    init();
  }
  
  private PAGFont getPagFont()
  {
    if (!TextUtils.isEmpty(this.fontPath)) {
      return TAVFontManager.getInstance().fontWithPath(this.fontPath);
    }
    if (!TextUtils.isEmpty(this.assetFontPath)) {
      return TAVFontManager.getInstance().fontWithAssetPath(TAVStickerHelper.getContext(), this.assetFontPath);
    }
    return null;
  }
  
  private void init()
  {
    this.text = "";
    this.defaultText = "";
    this.maxLength = 0;
    this.defaultColor = -16777216;
    this.fontPath = "";
    this.fontFamily = "";
    this.fontStyle = "";
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAssetFontPath()
  {
    return this.assetFontPath;
  }
  
  public int getDefaultColor()
  {
    return this.defaultColor;
  }
  
  public String getDefaultText()
  {
    return this.defaultText;
  }
  
  public String getFontFamily()
  {
    PAGFont localPAGFont = getPagFont();
    if (localPAGFont != null) {
      return localPAGFont.fontFamily;
    }
    return this.fontFamily;
  }
  
  public String getFontPath()
  {
    return this.fontPath;
  }
  
  public String getFontStyle()
  {
    PAGFont localPAGFont = getPagFont();
    if (localPAGFont != null) {
      return localPAGFont.fontStyle;
    }
    return this.fontStyle;
  }
  
  public int getMaxLength()
  {
    return this.maxLength;
  }
  
  public String getText()
  {
    return this.text;
  }
  
  public int getTextColor()
  {
    return this.textColor;
  }
  
  public void setAssetFontPath(String paramString)
  {
    this.assetFontPath = paramString;
  }
  
  public void setDefaultColor(int paramInt)
  {
    this.defaultColor = paramInt;
  }
  
  public void setDefaultText(String paramString)
  {
    this.defaultText = paramString;
  }
  
  public void setFontFamily(String paramString)
  {
    this.fontFamily = paramString;
  }
  
  public void setFontPath(String paramString)
  {
    this.fontPath = paramString;
  }
  
  public void setFontStyle(String paramString)
  {
    this.fontStyle = paramString;
  }
  
  public void setMaxLength(int paramInt)
  {
    this.maxLength = paramInt;
  }
  
  public void setText(String paramString)
  {
    this.text = paramString;
  }
  
  public void setTextColor(int paramInt)
  {
    this.textColor = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TAVStickerTextItem {layerIndex : ");
    localStringBuilder.append(this.layerIndex);
    localStringBuilder.append(", layerName : ");
    localStringBuilder.append(this.layerName);
    localStringBuilder.append(", layerType : ");
    localStringBuilder.append(this.layerType);
    localStringBuilder.append(", text : ");
    localStringBuilder.append(this.text);
    localStringBuilder.append(", defaultText : ");
    localStringBuilder.append(this.defaultText);
    localStringBuilder.append(", maxLength : ");
    localStringBuilder.append(this.maxLength);
    localStringBuilder.append(", textColor : ");
    localStringBuilder.append(this.textColor);
    localStringBuilder.append(", defaultColor : ");
    localStringBuilder.append(this.defaultColor);
    localStringBuilder.append(", fontPath : ");
    localStringBuilder.append(this.fontPath);
    localStringBuilder.append(", assetFontPath : ");
    localStringBuilder.append(this.assetFontPath);
    localStringBuilder.append(", fontFamily : ");
    localStringBuilder.append(this.fontFamily);
    localStringBuilder.append(", fontStyle : ");
    localStringBuilder.append(this.fontStyle);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public TAVStickerTextItem updateData(TAVStickerTextItem paramTAVStickerTextItem)
  {
    if (paramTAVStickerTextItem != null)
    {
      this.text = paramTAVStickerTextItem.text;
      this.defaultText = paramTAVStickerTextItem.defaultText;
      this.maxLength = paramTAVStickerTextItem.maxLength;
      this.textColor = paramTAVStickerTextItem.textColor;
      this.defaultColor = paramTAVStickerTextItem.defaultColor;
      this.fontPath = paramTAVStickerTextItem.fontPath;
      this.assetFontPath = paramTAVStickerTextItem.assetFontPath;
      this.fontFamily = paramTAVStickerTextItem.fontFamily;
      this.fontStyle = paramTAVStickerTextItem.fontStyle;
    }
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.layerIndex);
    if (this.layerName == null) {
      localObject = "";
    } else {
      localObject = this.layerName;
    }
    paramParcel.writeString((String)localObject);
    paramParcel.writeInt(this.layerType);
    String str = this.text;
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    paramParcel.writeString((String)localObject);
    str = this.defaultText;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    paramParcel.writeString((String)localObject);
    paramParcel.writeInt(this.maxLength);
    paramParcel.writeInt(this.textColor);
    paramParcel.writeInt(this.defaultColor);
    str = this.fontPath;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    paramParcel.writeString((String)localObject);
    str = this.assetFontPath;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    paramParcel.writeString((String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavsticker.model.TAVStickerTextItem
 * JD-Core Version:    0.7.0.1
 */