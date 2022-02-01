package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

final class VipIPSiteInfo$1
  implements Parcelable.Creator
{
  public VipIPSiteInfo a(Parcel paramParcel)
  {
    VipIPSiteInfo localVipIPSiteInfo = new VipIPSiteInfo();
    localVipIPSiteInfo.ipID = paramParcel.readInt();
    localVipIPSiteInfo.ipName = paramParcel.readString();
    localVipIPSiteInfo.ipDesc = paramParcel.readString();
    localVipIPSiteInfo.ipUrl = paramParcel.readString();
    localVipIPSiteInfo.itemSize = paramParcel.readInt();
    localVipIPSiteInfo.strType = paramParcel.readString();
    localVipIPSiteInfo.extId = paramParcel.readInt();
    localVipIPSiteInfo.extStr = paramParcel.readString();
    localVipIPSiteInfo.ipLogo = paramParcel.readString();
    localVipIPSiteInfo.ipContent = paramParcel.readString();
    if (localVipIPSiteInfo.ipList == null) {
      localVipIPSiteInfo.ipList = new ArrayList();
    }
    localVipIPSiteInfo.ipList.clear();
    if ("gxzb".equals(localVipIPSiteInfo.strType))
    {
      paramParcel.readList(localVipIPSiteInfo.ipList, IPSiteModel.Gxzb.class.getClassLoader());
      return localVipIPSiteInfo;
    }
    if ("game".equals(localVipIPSiteInfo.strType))
    {
      paramParcel.readList(localVipIPSiteInfo.ipList, IPSiteModel.Game.class.getClassLoader());
      return localVipIPSiteInfo;
    }
    if ("goods".equals(localVipIPSiteInfo.strType))
    {
      paramParcel.readList(localVipIPSiteInfo.ipList, IPSiteModel.Goods.class.getClassLoader());
      return localVipIPSiteInfo;
    }
    if ("video".equals(localVipIPSiteInfo.strType))
    {
      paramParcel.readList(localVipIPSiteInfo.ipList, IPSiteModel.Video.class.getClassLoader());
      return localVipIPSiteInfo;
    }
    if ("book".equals(localVipIPSiteInfo.strType))
    {
      paramParcel.readList(localVipIPSiteInfo.ipList, IPSiteModel.Book.class.getClassLoader());
      return localVipIPSiteInfo;
    }
    if ("comic".equals(localVipIPSiteInfo.strType)) {
      paramParcel.readList(localVipIPSiteInfo.ipList, IPSiteModel.Comic.class.getClassLoader());
    }
    return localVipIPSiteInfo;
  }
  
  public VipIPSiteInfo[] a(int paramInt)
  {
    return new VipIPSiteInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.VipIPSiteInfo.1
 * JD-Core Version:    0.7.0.1
 */