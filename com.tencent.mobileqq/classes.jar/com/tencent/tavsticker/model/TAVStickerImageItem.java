package com.tencent.tavsticker.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.libpag.PAGLayer;

public class TAVStickerImageItem
  extends TAVStickerLayerItem
  implements Parcelable
{
  public static final Parcelable.Creator<TAVStickerImageItem> CREATOR = new TAVStickerImageItem.1();
  private Bitmap bitmap = null;
  
  public TAVStickerImageItem()
  {
    this.layerType = 5;
  }
  
  protected TAVStickerImageItem(Parcel paramParcel)
  {
    if (paramParcel != null)
    {
      this.layerIndex = paramParcel.readInt();
      this.layerName = paramParcel.readString();
      this.layerType = paramParcel.readInt();
      this.bitmap = ((Bitmap)paramParcel.readParcelable(Bitmap.class.getClassLoader()));
    }
  }
  
  public TAVStickerImageItem(PAGLayer paramPAGLayer)
  {
    super(paramPAGLayer);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Bitmap getBitmap()
  {
    return this.bitmap;
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    this.bitmap = paramBitmap;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TAVStickerImageItem {layerIndex : ");
    localStringBuilder.append(this.layerIndex);
    localStringBuilder.append(", layerName : ");
    localStringBuilder.append(this.layerName);
    localStringBuilder.append(", layerType : ");
    localStringBuilder.append(this.layerType);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.layerIndex);
    String str;
    if (this.layerName == null) {
      str = "";
    } else {
      str = this.layerName;
    }
    paramParcel.writeString(str);
    paramParcel.writeInt(this.layerType);
    paramParcel.writeParcelable(this.bitmap, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavsticker.model.TAVStickerImageItem
 * JD-Core Version:    0.7.0.1
 */