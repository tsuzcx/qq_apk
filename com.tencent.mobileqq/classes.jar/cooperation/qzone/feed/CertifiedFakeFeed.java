package cooperation.qzone.feed;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CertifiedFakeFeed
  implements Parcelable
{
  public static final String BUNDLE_KEY = "KEY_CERTIFIED_FAKE_FEED";
  public static final String BUNDLE_KEY_LIST = "KEY_CERTIFIED_FAKE_FEED_LIST";
  public static final Parcelable.Creator<CertifiedFakeFeed> CREATOR = new CertifiedFakeFeed.1();
  private String clientKey;
  private String content;
  private String coverPath;
  private long createTime;
  private int duration;
  private String feedId;
  private int feedType;
  private int height;
  private String puin;
  private String title;
  private int width;
  
  private CertifiedFakeFeed() {}
  
  public CertifiedFakeFeed(Parcel paramParcel)
  {
    this.feedId = paramParcel.readString();
    this.clientKey = paramParcel.readString();
    this.feedType = paramParcel.readInt();
    this.title = paramParcel.readString();
    this.content = paramParcel.readString();
    this.coverPath = paramParcel.readString();
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.duration = paramParcel.readInt();
    this.createTime = paramParcel.readLong();
    this.puin = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getClientKey()
  {
    return this.clientKey;
  }
  
  public String getContent()
  {
    return this.content;
  }
  
  public String getCoverPath()
  {
    return this.coverPath;
  }
  
  public long getCreateTime()
  {
    return this.createTime;
  }
  
  public int getDuration()
  {
    return this.duration;
  }
  
  public String getFeedId()
  {
    return this.feedId;
  }
  
  public int getFeedType()
  {
    return this.feedType;
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public String getPuin()
  {
    return this.puin;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.feedId);
    paramParcel.writeString(this.clientKey);
    paramParcel.writeInt(this.feedType);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.content);
    paramParcel.writeString(this.coverPath);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    paramParcel.writeInt(this.duration);
    paramParcel.writeLong(this.createTime);
    paramParcel.writeString(this.puin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.feed.CertifiedFakeFeed
 * JD-Core Version:    0.7.0.1
 */