package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import aryd;
import java.util.List;

public class VipIPSiteInfo
  implements Parcelable
{
  public static final Parcelable.Creator<VipIPSiteInfo> CREATOR = new aryd();
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
    return "VipIPSiteInfo{ipID=" + this.ipID + ", ipName='" + this.ipName + '\'' + ", ipDesc='" + this.ipDesc + '\'' + ", ipUrl='" + this.ipUrl + '\'' + ", itemSize=" + this.itemSize + ", strType='" + this.strType + '\'' + ", extId=" + this.extId + ", extStr='" + this.extStr + '\'' + ", ipLogo='" + this.ipLogo + '\'' + ", ipContent='" + this.ipContent + '\'' + ", ipList=" + this.ipList + '}';
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.VipIPSiteInfo
 * JD-Core Version:    0.7.0.1
 */