package com.tencent.mobileqq.emoticonview.relateemo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class RelatedEmoticonManager$RelatedEmotionSearchResult$SearchResultItem
  implements Parcelable, ISearchResultItem
{
  public static final Parcelable.Creator<SearchResultItem> CREATOR = new RelatedEmoticonManager.RelatedEmotionSearchResult.SearchResultItem.1();
  public int height;
  public String imgOther;
  public long imgSize;
  public String md5;
  public String resourceId;
  public String url;
  public int width;
  
  public RelatedEmoticonManager$RelatedEmotionSearchResult$SearchResultItem() {}
  
  protected RelatedEmoticonManager$RelatedEmotionSearchResult$SearchResultItem(Parcel paramParcel)
  {
    this.md5 = paramParcel.readString();
    this.url = paramParcel.readString();
    this.resourceId = paramParcel.readString();
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.imgSize = paramParcel.readLong();
    this.imgOther = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public void setHeight(int paramInt)
  {
    this.height = paramInt;
  }
  
  public void setImgSize(int paramInt)
  {
    this.imgSize = paramInt;
  }
  
  public void setMd5(String paramString)
  {
    this.md5 = paramString;
  }
  
  public void setResourceId(String paramString)
  {
    this.resourceId = paramString;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
  
  public void setWidth(int paramInt)
  {
    this.width = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SearchResultItem{md5='");
    localStringBuilder.append(this.md5);
    localStringBuilder.append('\'');
    localStringBuilder.append(", url='");
    localStringBuilder.append(this.url);
    localStringBuilder.append('\'');
    localStringBuilder.append(", resourceId='");
    localStringBuilder.append(this.resourceId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", width=");
    localStringBuilder.append(this.width);
    localStringBuilder.append(", height=");
    localStringBuilder.append(this.height);
    localStringBuilder.append(", imgSize=");
    localStringBuilder.append(this.imgSize);
    localStringBuilder.append(", imgOther='");
    localStringBuilder.append(this.imgOther);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.md5);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.resourceId);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    paramParcel.writeLong(this.imgSize);
    paramParcel.writeString(this.imgOther);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.relateemo.RelatedEmoticonManager.RelatedEmotionSearchResult.SearchResultItem
 * JD-Core Version:    0.7.0.1
 */