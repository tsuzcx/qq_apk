package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.emoticonview.EmotionPanelData;

public class PromotionEmoticonPkg
  extends EmotionPanelData
  implements Parcelable
{
  public static final Parcelable.Creator<PromotionEmoticonPkg> CREATOR = new PromotionEmoticonPkg.1();
  public static int GIF;
  public static int H5MAGIC;
  public static int MAGIC = 1;
  public static int PAY_1_YUAN;
  public static int PAY_6_YUAN;
  public static int PAY_LIMIT_FREE;
  public static int PNG = 2;
  public static int QFACE;
  public static int RANDOMMAGIC;
  public static int RECOMMEND_ALGORITHM;
  public static int RECOMMEND_DEPLOY;
  public static int SMALL;
  public static int VOICE;
  public String bgColor;
  public String btnDesc;
  public String detailUrl;
  public int exposureNum = 0;
  public int feeType;
  public String id;
  public String imgUrl;
  public boolean isFixedEmoticon;
  public String pkgDesc;
  public int price;
  public int recommendType;
  public int redpointFlag;
  public String titleColor;
  public int type;
  
  static
  {
    GIF = 3;
    H5MAGIC = 4;
    SMALL = 5;
    VOICE = 6;
    QFACE = 7;
    RANDOMMAGIC = 8;
    PAY_LIMIT_FREE = 0;
    PAY_1_YUAN = 1;
    PAY_6_YUAN = 6;
    RECOMMEND_DEPLOY = 1;
    RECOMMEND_ALGORITHM = 2;
  }
  
  public PromotionEmoticonPkg() {}
  
  protected PromotionEmoticonPkg(Parcel paramParcel)
  {
    this.id = paramParcel.readString();
    this.type = paramParcel.readInt();
    this.feeType = paramParcel.readInt();
    this.imgUrl = paramParcel.readString();
    this.pkgDesc = paramParcel.readString();
    this.btnDesc = paramParcel.readString();
    this.titleColor = paramParcel.readString();
    this.bgColor = paramParcel.readString();
    this.detailUrl = paramParcel.readString();
    this.price = paramParcel.readInt();
    this.recommendType = paramParcel.readInt();
    this.redpointFlag = paramParcel.readInt();
    this.exposureNum = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {
      bool = true;
    }
    this.isFixedEmoticon = bool;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.id);
    paramParcel.writeInt(this.type);
    paramParcel.writeInt(this.feeType);
    paramParcel.writeString(this.imgUrl);
    paramParcel.writeString(this.pkgDesc);
    paramParcel.writeString(this.btnDesc);
    paramParcel.writeString(this.titleColor);
    paramParcel.writeString(this.bgColor);
    paramParcel.writeString(this.detailUrl);
    paramParcel.writeInt(this.price);
    paramParcel.writeInt(this.recommendType);
    paramParcel.writeInt(this.redpointFlag);
    paramParcel.writeInt(this.exposureNum);
    if (this.isFixedEmoticon) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.PromotionEmoticonPkg
 * JD-Core Version:    0.7.0.1
 */