package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class IPSiteModel$Goods
  implements Parcelable
{
  public static final Parcelable.Creator<Goods> CREATOR = new IPSiteModel.Goods.1();
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Goods{cover='");
    localStringBuilder.append(this.cover);
    localStringBuilder.append('\'');
    localStringBuilder.append(", goodsTags='");
    localStringBuilder.append(this.goodsTags);
    localStringBuilder.append('\'');
    localStringBuilder.append(", id='");
    localStringBuilder.append(this.id);
    localStringBuilder.append('\'');
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.name);
    localStringBuilder.append('\'');
    localStringBuilder.append(", price='");
    localStringBuilder.append(this.price);
    localStringBuilder.append('\'');
    localStringBuilder.append(", saleTags='");
    localStringBuilder.append(this.saleTags);
    localStringBuilder.append('\'');
    localStringBuilder.append(", svipPrice='");
    localStringBuilder.append(this.svipPrice);
    localStringBuilder.append('\'');
    localStringBuilder.append(", url='");
    localStringBuilder.append(this.url);
    localStringBuilder.append('\'');
    localStringBuilder.append(", moreUrl='");
    localStringBuilder.append(this.moreUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", saleNum='");
    localStringBuilder.append(this.saleNum);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.IPSiteModel.Goods
 * JD-Core Version:    0.7.0.1
 */