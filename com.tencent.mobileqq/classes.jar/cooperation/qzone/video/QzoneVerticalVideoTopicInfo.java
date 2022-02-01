package cooperation.qzone.video;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.webkit.URLUtil;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QzoneVerticalVideoTopicInfo
  implements Parcelable
{
  public static final Parcelable.Creator<QzoneVerticalVideoTopicInfo> CREATOR = new QzoneVerticalVideoTopicInfo.1();
  private String TAG = QzoneVerticalVideoTopicInfo.class.getSimpleName();
  private String feedId;
  private String fileId;
  private String musicId;
  private String musicName;
  private String musicUrl;
  private String thumbUrl;
  private String topicId;
  private String topicName;
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getDescName()
  {
    if (!TextUtils.isEmpty(this.topicName)) {
      return this.topicName;
    }
    return this.musicName;
  }
  
  public String getFeedId()
  {
    return this.feedId;
  }
  
  public String getFileId()
  {
    return this.fileId;
  }
  
  public String getMusicId()
  {
    return this.musicId;
  }
  
  public String getMusicName()
  {
    return this.musicName;
  }
  
  public String getMusicUrl()
  {
    return this.musicUrl;
  }
  
  public String getThumbImgUrl()
  {
    Object localObject;
    if ((TextUtils.isEmpty(this.thumbUrl)) || (URLUtil.isHttpUrl(this.thumbUrl)) || (URLUtil.isHttpsUrl(this.thumbUrl))) {
      localObject = this.thumbUrl;
    }
    String str;
    do
    {
      do
      {
        return localObject;
        localObject = Pattern.compile("img:(.*?),").matcher(this.thumbUrl);
        if (!((Matcher)localObject).find()) {
          break;
        }
        str = ((Matcher)localObject).group().replace("img:", "").replace(",", "");
        localObject = str;
      } while (URLUtil.isHttpUrl(str));
      localObject = str;
    } while (URLUtil.isHttpsUrl(str));
    return null;
  }
  
  public String getThumbUrl()
  {
    return this.thumbUrl;
  }
  
  public String getTopicId()
  {
    return this.topicId;
  }
  
  public String getTopicName()
  {
    return this.topicName;
  }
  
  public boolean hasMusic()
  {
    return (!TextUtils.isEmpty(this.musicUrl)) && (!TextUtils.isEmpty(this.musicName));
  }
  
  public QzoneVerticalVideoTopicInfo setFeedId(String paramString)
  {
    this.feedId = paramString;
    return this;
  }
  
  public QzoneVerticalVideoTopicInfo setFileId(String paramString)
  {
    this.fileId = paramString;
    return this;
  }
  
  public QzoneVerticalVideoTopicInfo setMusicId(String paramString)
  {
    this.musicId = paramString;
    return this;
  }
  
  public QzoneVerticalVideoTopicInfo setMusicName(String paramString)
  {
    this.musicName = paramString;
    return this;
  }
  
  public QzoneVerticalVideoTopicInfo setMusicUrl(String paramString)
  {
    this.musicUrl = paramString;
    return this;
  }
  
  public QzoneVerticalVideoTopicInfo setThumbUrl(String paramString)
  {
    this.thumbUrl = paramString;
    return this;
  }
  
  public QzoneVerticalVideoTopicInfo setTopicId(String paramString)
  {
    this.topicId = paramString;
    return this;
  }
  
  public QzoneVerticalVideoTopicInfo setTopicName(String paramString)
  {
    this.topicName = paramString;
    return this;
  }
  
  public String toJSONString()
  {
    QzoneVerticalVideoTopicInfo.MyJSONObject localMyJSONObject = new QzoneVerticalVideoTopicInfo.MyJSONObject(this);
    localMyJSONObject.putData("weishi_feedId", this.feedId).putData("weishi_fileId", this.fileId).putData("weishi_musicId", this.musicId).putData("weishi_musicName", this.musicName).putData("weishi_thumbUrl", this.thumbUrl).putData("weishi_topicID", this.topicId).putData("weishi_topicName", this.topicName);
    return localMyJSONObject.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.feedId);
    paramParcel.writeString(this.fileId);
    paramParcel.writeString(this.musicId);
    paramParcel.writeString(this.musicName);
    paramParcel.writeString(this.musicUrl);
    paramParcel.writeString(this.thumbUrl);
    paramParcel.writeString(this.topicId);
    paramParcel.writeString(this.topicName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.video.QzoneVerticalVideoTopicInfo
 * JD-Core Version:    0.7.0.1
 */