package com.tencent.mobileqq.data;

import abua;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class IPSiteModel$Goods
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new abua();
  public String cover;
  public String goodsTags;
  public String id;
  public String moreUrl;
  public String name;
  public String price;
  public String saleNum;
  public String saleTags;
  public String svipPrice;
  public String url;
  
  public IPSiteModel$Goods() {}
  
  public IPSiteModel$Goods(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    this.cover = paramString1;
    this.goodsTags = paramString2;
    this.id = paramString3;
    this.name = paramString4;
    this.price = paramString5;
    this.saleTags = paramString6;
    this.svipPrice = paramString7;
    this.url = paramString8;
    this.moreUrl = paramString9;
    this.saleNum = paramString10;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "Goods{cover='" + this.cover + '\'' + ", goodsTags='" + this.goodsTags + '\'' + ", id='" + this.id + '\'' + ", name='" + this.name + '\'' + ", price='" + this.price + '\'' + ", saleTags='" + this.saleTags + '\'' + ", svipPrice='" + this.svipPrice + '\'' + ", url='" + this.url + '\'' + ", moreUrl='" + this.moreUrl + '\'' + ", saleNum='" + this.saleNum + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.cover);
    paramParcel.writeString(this.goodsTags);
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.price);
    paramParcel.writeString(this.saleTags);
    paramParcel.writeString(this.svipPrice);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.moreUrl);
    paramParcel.writeString(this.saleNum);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.IPSiteModel.Goods
 * JD-Core Version:    0.7.0.1
 */