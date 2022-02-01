package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class IPSiteModel$Comic
  implements Parcelable
{
  public static final Parcelable.Creator<Comic> CREATOR = new IPSiteModel.Comic.1();
  public List<IPSiteModel.ComicRich> comicRiches;
  public int comicType;
  public String cover;
  public String desc;
  public String id;
  public String jumpUrl;
  public String name;
  public String recommDesc;
  public String typeName;
  
  public IPSiteModel$Comic() {}
  
  public IPSiteModel$Comic(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, List<IPSiteModel.ComicRich> paramList)
  {
    this.comicType = paramInt;
    this.cover = paramString1;
    this.desc = paramString2;
    this.id = paramString3;
    this.jumpUrl = paramString4;
    this.name = paramString5;
    this.recommDesc = paramString6;
    this.typeName = paramString7;
    this.comicRiches = paramList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Comic{comicType=");
    localStringBuilder.append(this.comicType);
    localStringBuilder.append(", cover='");
    localStringBuilder.append(this.cover);
    localStringBuilder.append('\'');
    localStringBuilder.append(", desc='");
    localStringBuilder.append(this.desc);
    localStringBuilder.append('\'');
    localStringBuilder.append(", id='");
    localStringBuilder.append(this.id);
    localStringBuilder.append('\'');
    localStringBuilder.append(", jumpUrl='");
    localStringBuilder.append(this.jumpUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.name);
    localStringBuilder.append('\'');
    localStringBuilder.append(", recommDesc='");
    localStringBuilder.append(this.recommDesc);
    localStringBuilder.append('\'');
    localStringBuilder.append(", typeName='");
    localStringBuilder.append(this.typeName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", comicRiches=");
    localStringBuilder.append(this.comicRiches);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.comicType);
    paramParcel.writeString(this.cover);
    paramParcel.writeString(this.desc);
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.jumpUrl);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.recommDesc);
    paramParcel.writeString(this.typeName);
    paramParcel.writeList(this.comicRiches);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.IPSiteModel.Comic
 * JD-Core Version:    0.7.0.1
 */