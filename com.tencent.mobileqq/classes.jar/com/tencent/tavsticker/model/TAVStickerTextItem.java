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
  private static final String TAG = TAVStickerTextItem.class.getSimpleName();
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
    PAGFont localPAGFont = null;
    if (!TextUtils.isEmpty(this.fontPath)) {
      localPAGFont = TAVFontManager.getInstance().fontWithPath(this.fontPath);
    }
    while (TextUtils.isEmpty(this.assetFontPath)) {
      return localPAGFont;
    }
    return TAVFontManager.getInstance().fontWithAssetPath(TAVStickerHelper.getContext(), this.assetFontPath);
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
    return "TAVStickerTextItem {layerIndex : " + this.layerIndex + ", layerName : " + this.layerName + ", layerType : " + this.layerType + ", text : " + this.text + ", defaultText : " + this.defaultText + ", maxLength : " + this.maxLength + ", textColor : " + this.textColor + ", defaultColor : " + this.defaultColor + ", fontPath : " + this.fontPath + ", assetFontPath : " + this.assetFontPath + ", fontFamily : " + this.fontFamily + ", fontStyle : " + this.fontStyle + "}";
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
    if (this.layerName == null)
    {
      str = "";
      paramParcel.writeString(str);
      paramParcel.writeInt(this.layerType);
      if (this.text != null) {
        break label124;
      }
      str = "";
      label41:
      paramParcel.writeString(str);
      if (this.defaultText != null) {
        break label132;
      }
      str = "";
      label56:
      paramParcel.writeString(str);
      paramParcel.writeInt(this.maxLength);
      paramParcel.writeInt(this.textColor);
      paramParcel.writeInt(this.defaultColor);
      if (this.fontPath != null) {
        break label140;
      }
      str = "";
      label95:
      paramParcel.writeString(str);
      if (this.assetFontPath != null) {
        break label148;
      }
    }
    label132:
    label140:
    label148:
    for (String str = "";; str = this.assetFontPath)
    {
      paramParcel.writeString(str);
      return;
      str = this.layerName;
      break;
      label124:
      str = this.text;
      break label41;
      str = this.defaultText;
      break label56;
      str = this.fontPath;
      break label95;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavsticker.model.TAVStickerTextItem
 * JD-Core Version:    0.7.0.1
 */