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
  public final float a;
  public FastWebArticleInfo a;
  public float b;
  public AbsBaseArticleInfo b;
  public boolean f;
  public final int u;
  public int v;
  public int w = 0;
  public int x = -1;
  public int y = -1;
  
  public BaseData(int paramInt)
  {
    this.jdField_b_of_type_Float = -1000.0F;
    this.u = paramInt;
    this.jdField_a_of_type_Float = ((IBaseDataUtil)QRoute.api(IBaseDataUtil.class)).getSortWeight(this);
  }
  
  public BaseData(Parcel paramParcel)
  {
    this.jdField_b_of_type_Float = -1000.0F;
    this.u = paramParcel.readInt();
    this.jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = ((AbsBaseArticleInfo)paramParcel.readParcelable(AbsBaseArticleInfo.class.getClassLoader()));
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo = ((FastWebArticleInfo)paramParcel.readParcelable(FastWebArticleInfo.class.getClassLoader()));
    this.jdField_a_of_type_Float = paramParcel.readFloat();
    this.x = paramParcel.readInt();
    this.y = paramParcel.readInt();
    this.w = paramParcel.readInt();
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
    paramParcel.writeInt(this.u);
    paramParcel.writeParcelable(this.jdField_b_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, 0);
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFastWebArticleInfo, 0);
    paramParcel.writeFloat(this.jdField_a_of_type_Float);
    paramParcel.writeInt(this.x);
    paramParcel.writeInt(this.y);
    paramParcel.writeInt(this.w);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData
 * JD-Core Version:    0.7.0.1
 */