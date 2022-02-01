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
  public static int GIF = 3;
  public static int H5MAGIC = 4;
  public static int MAGIC = 1;
  public static int PAY_1_YUAN = 1;
  public static int PAY_6_YUAN = 6;
  public static int PAY_LIMIT_FREE = 0;
  public static int PNG = 2;
  public static int QFACE = 7;
  public static int RANDOMMAGIC = 8;
  public static int RECOMMEND_ALGORITHM = 2;
  public static int RECOMMEND_DEPLOY = 1;
  public static int SMALL = 5;
  public static int VOICE = 6;
  public String bgColor;
  public String btnDesc;
  public String detailUrl;
  public int exposureNum;
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
  
  public PromotionEmoticonPkg()
  {
    this.exposureNum = 0;
  }
  
  protected PromotionEmoticonPkg(Parcel paramParcel)
  {
    boolean bool = false;
    this.exposureNum = 0;
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
    paramParcel.writeByte((byte)this.isFixedEmoticon);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.PromotionEmoticonPkg
 * JD-Core Version:    0.7.0.1
 */