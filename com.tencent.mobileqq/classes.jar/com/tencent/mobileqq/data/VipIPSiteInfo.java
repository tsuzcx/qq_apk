package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class VipIPSiteInfo
  implements Parcelable
{
  public static final Parcelable.Creator<VipIPSiteInfo> CREATOR = new VipIPSiteInfo.1();
  public int extId;
  public String extStr;
  public String ipContent;
  public String ipDesc;
  public int ipID;
  public List<Object> ipList;
  public String ipLogo;
  public String ipName;
  public String ipUrl;
  public int itemSize;
  public String strType;
  
  public VipIPSiteInfo() {}
  
  public VipIPSiteInfo(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4, int paramInt3, String paramString5, String paramString6, String paramString7, List<Object> paramList)
  {
    this.ipID = paramInt1;
    this.ipName = paramString1;
    this.ipDesc = paramString2;
    this.ipUrl = paramString3;
    this.itemSize = paramInt2;
    this.strType = paramString4;
    this.extId = paramInt3;
    this.extStr = paramString5;
    this.ipLogo = paramString6;
    this.ipContent = paramString7;
    this.ipList = paramList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VipIPSiteInfo{ipID=");
    localStringBuilder.append(this.ipID);
    localStringBuilder.append(", ipName='");
    localStringBuilder.append(this.ipName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", ipDesc='");
    localStringBuilder.append(this.ipDesc);
    localStringBuilder.append('\'');
    localStringBuilder.append(", ipUrl='");
    localStringBuilder.append(this.ipUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", itemSize=");
    localStringBuilder.append(this.itemSize);
    localStringBuilder.append(", strType='");
    localStringBuilder.append(this.strType);
    localStringBuilder.append('\'');
    localStringBuilder.append(", extId=");
    localStringBuilder.append(this.extId);
    localStringBuilder.append(", extStr='");
    localStringBuilder.append(this.extStr);
    localStringBuilder.append('\'');
    localStringBuilder.append(", ipLogo='");
    localStringBuilder.append(this.ipLogo);
    localStringBuilder.append('\'');
    localStringBuilder.append(", ipContent='");
    localStringBuilder.append(this.ipContent);
    localStringBuilder.append('\'');
    localStringBuilder.append(", ipList=");
    localStringBuilder.append(this.ipList);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.ipID);
    paramParcel.writeString(this.ipName);
    paramParcel.writeString(this.ipDesc);
    paramParcel.writeString(this.ipUrl);
    paramParcel.writeInt(this.itemSize);
    paramParcel.writeString(this.strType);
    paramParcel.writeInt(this.extId);
    paramParcel.writeString(this.extStr);
    paramParcel.writeString(this.ipLogo);
    paramParcel.writeString(this.ipContent);
    paramParcel.writeList(this.ipList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.VipIPSiteInfo
 * JD-Core Version:    0.7.0.1
 */