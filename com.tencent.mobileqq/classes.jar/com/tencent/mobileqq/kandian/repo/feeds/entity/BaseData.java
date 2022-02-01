package com.tencent.mobileqq.kandian.repo.feeds.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IBaseDataUtil;
import com.tencent.mobileqq.qroute.QRoute;

public class BaseData
  implements Parcelable
{
  public static final Parcelable.Creator<BaseData> CREATOR = new BaseData.1();
  public final int aP;
  public AbsBaseArticleInfo aQ;
  public FastWebArticleInfo aR;
  public boolean aS;
  public int aT;
  public final float aU;
  public float aV = -1000.0F;
  public int aW = 0;
  public int aX = -1;
  public int aY = -1;
  public String aZ = "";
  public String ba = "";
  
  public BaseData(int paramInt)
  {
    this.aP = paramInt;
    this.aU = ((IBaseDataUtil)QRoute.api(IBaseDataUtil.class)).getSortWeight(this);
  }
  
  public BaseData(Parcel paramParcel)
  {
    this.aP = paramParcel.readInt();
    this.aQ = ((AbsBaseArticleInfo)paramParcel.readParcelable(AbsBaseArticleInfo.class.getClassLoader()));
    this.aR = ((FastWebArticleInfo)paramParcel.readParcelable(FastWebArticleInfo.class.getClassLoader()));
    this.aU = paramParcel.readFloat();
    this.aX = paramParcel.readInt();
    this.aY = paramParcel.readInt();
    this.aW = paramParcel.readInt();
    this.aZ = paramParcel.readString();
    this.ba = paramParcel.readString();
  }
  
  public boolean b(BaseData paramBaseData)
  {
    if (paramBaseData == null) {
      return true;
    }
    return ((IBaseDataUtil)QRoute.api(IBaseDataUtil.class)).getSortWeight(this) - ((IBaseDataUtil)QRoute.api(IBaseDataUtil.class)).getSortWeight(paramBaseData) < 0.0F;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.aP);
    paramParcel.writeParcelable(this.aQ, 0);
    paramParcel.writeParcelable(this.aR, 0);
    paramParcel.writeFloat(this.aU);
    paramParcel.writeInt(this.aX);
    paramParcel.writeInt(this.aY);
    paramParcel.writeInt(this.aW);
    paramParcel.writeString(this.aZ);
    paramParcel.writeString(this.ba);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData
 * JD-Core Version:    0.7.0.1
 */