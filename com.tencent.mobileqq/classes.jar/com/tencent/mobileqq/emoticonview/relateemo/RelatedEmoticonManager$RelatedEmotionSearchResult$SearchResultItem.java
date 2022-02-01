package com.tencent.mobileqq.emoticonview.relateemo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class RelatedEmoticonManager$RelatedEmotionSearchResult$SearchResultItem
  implements Parcelable
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
  
  public String toString()
  {
    return "SearchResultItem{md5='" + this.md5 + '\'' + ", url='" + this.url + '\'' + ", resourceId='" + this.resourceId + '\'' + ", width=" + this.width + ", height=" + this.height + ", imgSize=" + this.imgSize + ", imgOther='" + this.imgOther + '\'' + '}';
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