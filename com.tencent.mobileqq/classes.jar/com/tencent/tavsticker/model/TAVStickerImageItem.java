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
    return "TAVStickerImageItem {layerIndex : " + this.layerIndex + ", layerName : " + this.layerName + ", layerType : " + this.layerType + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.layerIndex);
    if (this.layerName == null) {}
    for (String str = "";; str = this.layerName)
    {
      paramParcel.writeString(str);
      paramParcel.writeInt(this.layerType);
      paramParcel.writeParcelable(this.bitmap, paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavsticker.model.TAVStickerImageItem
 * JD-Core Version:    0.7.0.1
 */