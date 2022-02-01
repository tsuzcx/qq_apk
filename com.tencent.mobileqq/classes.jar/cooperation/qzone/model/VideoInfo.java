package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Map;

public class VideoInfo
  implements Parcelable
{
  public static final Parcelable.Creator<VideoInfo> CREATOR = new VideoInfo.1();
  public static final int STATUS_AUDITING = 4;
  public static final int STATUS_AUDIT_FAILED = 7;
  public static final int STATUS_AUDIT_FINISHED = 5;
  public static final int STATUS_BANNED = 6;
  public static final int STATUS_INIT = 0;
  public static final int STATUS_TRANSCODE_FAILED = 3;
  public static final int STATUS_TRANSCODE_FINISHED = 2;
  public static final int STATUS_TRANSCODING = 1;
  public int actionType;
  public String actionUrl;
  public int advDelayTime;
  public String albumid;
  public boolean allowShowPasterVideoAdv;
  public PictureUrl bigUrl;
  public PictureUrl coverUrl;
  public PictureUrl currentUrl;
  public int currentVideoRate;
  public String desc;
  public int fileType;
  public VideoUrl h265NormalUrl;
  public boolean hasVideoPlayed = false;
  public int height;
  public VideoUrl highBrUrl;
  public boolean isAutoPlay;
  public boolean isCircle;
  public boolean isFakeFeed = false;
  public boolean isFeedComplete = false;
  public boolean isFeedFirst = true;
  public boolean isFeedFirstComplete = false;
  public boolean isFloatFirst = true;
  public int isGetRecommAfterPlay;
  public boolean isTranscoding = false;
  public boolean isUploading = false;
  public long lastUseTime = 0L;
  public String lloc;
  public VideoUrl lowBrUrl;
  public String nativeLikeUrl;
  public boolean needDeleteLocal;
  public PictureUrl originUrl;
  public long originVideoSize;
  public VideoUrl originVideoUrl;
  public byte playType;
  public String pull_weishi_alg_id;
  public int pull_weishi_mask;
  public long scrollToNextDelayTime;
  public long seekPosition;
  public long shootTime;
  public String showVideoTime;
  public String toast;
  public long validVideoTime = -1L;
  public String validVideoTimeDesc;
  public Map<String, String> videoFloatReportParam;
  public String videoId;
  public ArrayList<VideoUrl> videoRateList;
  public VideoInfo.VideoRemark videoRemark;
  public int videoShowType;
  public int videoSource;
  public int videoStatus = 0;
  public long videoTime;
  public int videoType;
  public VideoUrl videoUrl;
  public int videoplaycnt;
  public String weishi_clipbrd;
  public String weishi_download_url;
  public String weishi_pull_schema;
  public int width;
  public int writeFrom;
  
  public static String getShownTimeFromNumeric(long paramLong)
  {
    if (paramLong >= 60000L)
    {
      int k = (int)Math.round(paramLong % 60000L * 1.0D / 1000.0D);
      int j = 0;
      i = k;
      if (k >= 60)
      {
        j = k / 60;
        i = k % 60;
      }
      StringBuilder localStringBuilder = new StringBuilder().append(paramLong / 60000L + j).append(":");
      if (i > 9) {}
      for (Object localObject = Integer.valueOf(i);; localObject = "0" + i) {
        return localObject;
      }
    }
    int i = (int)Math.round(paramLong * 1.0D / 1000.0D);
    if (i > 9) {
      return "0:" + i;
    }
    return "0:0" + i;
  }
  
  private PictureUrl getUrlByPriority(PictureUrl[] paramArrayOfPictureUrl)
  {
    int j = paramArrayOfPictureUrl.length;
    int i = 0;
    while (i < j)
    {
      PictureUrl localPictureUrl = paramArrayOfPictureUrl[i];
      if ((localPictureUrl != null) && (!TextUtils.isEmpty(localPictureUrl.url))) {
        return localPictureUrl;
      }
      i += 1;
    }
    return new PictureUrl();
  }
  
  public static final String getVideoPlayTime(long paramLong)
  {
    if (paramLong < 0L) {
      return "";
    }
    long l1 = Math.round((float)paramLong / 1000.0F);
    paramLong = l1 / 60L;
    l1 %= 60L;
    long l2 = paramLong / 60L;
    paramLong %= 60L;
    if (l2 > 0L)
    {
      localStringBuilder = new StringBuilder().append("%d");
      if (paramLong >= 10L)
      {
        str = ":%d";
        str = str;
        localStringBuilder = new StringBuilder().append(str);
        if (l1 < 10L) {
          break label162;
        }
      }
      label162:
      for (str = ":%d";; str = ":0%d")
      {
        return String.format(str, new Object[] { Long.valueOf(l2), Long.valueOf(paramLong), Long.valueOf(l1) });
        str = ":0%d";
        break;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder().append("%d");
    if (l1 >= 10L) {}
    for (String str = ":%d";; str = ":0%d") {
      return String.format(str, new Object[] { Long.valueOf(paramLong), Long.valueOf(l1) });
    }
  }
  
  public void calcuShowVideoTime(long paramLong)
  {
    if (paramLong > 0L)
    {
      this.showVideoTime = getVideoPlayTime(paramLong);
      return;
    }
    this.showVideoTime = null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public PictureUrl getPicUrlDec()
  {
    return getUrlByPriority(new PictureUrl[] { this.originUrl, this.bigUrl, this.currentUrl });
  }
  
  public boolean hasVideoPlayed()
  {
    return this.hasVideoPlayed;
  }
  
  public boolean isAdvMicroVideo()
  {
    return this.videoShowType == 1;
  }
  
  public boolean isAutoPlay()
  {
    return ((this.playType & 0x1) != 0) || (this.videoShowType == 1);
  }
  
  public boolean isCircle()
  {
    return ((this.playType & 0x2) != 0) && ((this.validVideoTime <= 0L) || (this.validVideoTime >= this.videoTime));
  }
  
  public boolean isErrorState()
  {
    return (this.videoStatus == 1) || (this.videoStatus == 7) || (this.videoStatus == 3) || (this.videoStatus == 6);
  }
  
  public boolean isOpenWithFloat()
  {
    return (this.actionType == 19) || (this.actionType == 3);
  }
  
  public boolean isTranscoding()
  {
    return this.videoStatus == 1;
  }
  
  public boolean isVideoUrlIntact()
  {
    return (this.videoUrl != null) && (!TextUtils.isEmpty(this.videoUrl.url)) && (this.videoUrl.url.contains("https://")) && (!this.videoUrl.url.startsWith("?sid"));
  }
  
  public String toDebugString()
  {
    return "VideoInfo{\nvideoId='" + this.videoId + '\'' + '\n' + ", videoUrl=" + this.videoUrl + '\n' + ", originUrl=" + this.originUrl + '\n' + ", bigUrl=" + this.bigUrl + '\n' + ", currentUrl=" + this.currentUrl + '\n' + ", coverUrl=" + this.coverUrl + '\n' + ", actionType=" + this.actionType + '\n' + ", actionUrl='" + this.actionUrl + '\'' + '\n' + ", nativeLikeUrl='" + this.nativeLikeUrl + '\'' + '\n' + ", highBrUrl=" + this.highBrUrl + '\n' + ", lowBrUrl=" + this.lowBrUrl + '\n' + ", originVideoUrl=" + this.originVideoUrl + '\n' + ", h265NormalUrl=" + this.h265NormalUrl + '\n' + ", originVideoSize=" + this.originVideoSize + '\n' + ", fileType=" + this.fileType + '\n' + ", videoType=" + this.videoType + '\n' + ", videoTime=" + this.videoTime + '\n' + ", showVideoTime='" + this.showVideoTime + '\'' + '\n' + ", playType=" + this.playType + '\n' + ", videoShowType=" + this.videoShowType + '\n' + ", hasVideoPlayed=" + this.hasVideoPlayed + '\n' + ", videoStatus=" + this.videoStatus + '\n' + ", lastUseTime=" + this.lastUseTime + '\n' + ", width=" + this.width + '\n' + ", height=" + this.height + '\n' + ", toast='" + this.toast + '\'' + '\n' + ", isFakeFeed=" + this.isFakeFeed + '\n' + ", isFloatFirst=" + this.isFloatFirst + '\n' + ", isFeedFirst=" + this.isFeedFirst + '\n' + ", isFeedFirstComplete=" + this.isFeedFirstComplete + '\n' + ", isFeedComplete=" + this.isFeedComplete + '\n' + ", isTranscoding=" + this.isTranscoding + '\n' + ", isUploading=" + this.isUploading + '\n' + ", videoFloatReportParam=" + this.videoFloatReportParam + '\n' + ", videoRemark=" + this.videoRemark + '\n' + ", validVideoTime=" + this.validVideoTime + '\n' + ", validVideoTimeDesc='" + this.validVideoTimeDesc + '\'' + '\n' + ", isCircle=" + this.isCircle + '\n' + ", isAutoPlay=" + this.isAutoPlay + '\n' + ", writeFrom=" + this.writeFrom + '\n' + ", desc='" + this.desc + '\'' + '\n' + ", videoSource=" + this.videoSource + '\n' + ", advDelayTime=" + this.advDelayTime + '\n' + ", isGetRecommAfterPlay=" + this.isGetRecommAfterPlay + '\n' + ", shootTime=" + this.shootTime + '\n' + ", videoplaycnt=" + this.videoplaycnt + '\n' + ", allowShowPasterVideoAdv=" + this.allowShowPasterVideoAdv + '\n' + ", needDeleteLocal=" + this.needDeleteLocal + '\n' + ", scrollToNextDelayTime=" + this.scrollToNextDelayTime + '\n' + ", seekPosition=" + this.seekPosition + '\n' + '}';
  }
  
  public String toString()
  {
    return "VideoInfo [videoId=" + this.videoId + ", videoUrl=" + this.videoUrl + ", bigUrl=" + this.bigUrl + ", actionType=" + this.actionType + ", actionUrl=" + this.actionUrl + ", highBrUrl=" + this.highBrUrl + ", lowBrUrl=" + this.lowBrUrl + ", fileType=" + this.fileType + ", videoType=" + this.videoType + ",videoShowType=" + this.videoShowType + ", videoTime=" + this.videoTime + ", videoStatus=" + this.videoStatus + ", originVideoUrl=" + this.originVideoUrl + ", originVideoSize=" + this.originVideoSize + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 1;
    paramParcel.writeString(this.videoId);
    paramParcel.writeParcelable(this.videoUrl, paramInt);
    paramParcel.writeParcelable(this.originUrl, paramInt);
    paramParcel.writeParcelable(this.bigUrl, paramInt);
    paramParcel.writeParcelable(this.currentUrl, paramInt);
    paramParcel.writeParcelable(this.coverUrl, paramInt);
    paramParcel.writeInt(this.actionType);
    paramParcel.writeString(this.actionUrl);
    paramParcel.writeParcelable(this.highBrUrl, paramInt);
    paramParcel.writeParcelable(this.lowBrUrl, paramInt);
    paramParcel.writeParcelable(this.originVideoUrl, paramInt);
    paramParcel.writeParcelable(this.h265NormalUrl, paramInt);
    paramParcel.writeList(this.videoRateList);
    paramParcel.writeInt(this.currentVideoRate);
    paramParcel.writeLong(this.originVideoSize);
    paramParcel.writeInt(this.fileType);
    paramParcel.writeInt(this.videoType);
    paramParcel.writeLong(this.videoTime);
    paramParcel.writeString(this.showVideoTime);
    paramParcel.writeByte(this.playType);
    paramParcel.writeInt(this.videoShowType);
    paramParcel.writeInt(this.videoStatus);
    paramParcel.writeLong(this.lastUseTime);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    paramParcel.writeString(this.toast);
    int i;
    if (this.isFakeFeed)
    {
      i = 1;
      paramParcel.writeInt(i);
      paramParcel.writeParcelable(this.videoRemark, paramInt);
      paramParcel.writeLong(this.validVideoTime);
      paramParcel.writeString(this.validVideoTimeDesc);
      if (!this.isCircle) {
        break label442;
      }
      paramInt = 1;
      label268:
      paramParcel.writeInt(paramInt);
      if (!this.isAutoPlay) {
        break label447;
      }
      paramInt = 1;
      label282:
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.writeFrom);
      paramParcel.writeString(this.desc);
      paramParcel.writeInt(this.videoSource);
      paramParcel.writeInt(this.advDelayTime);
      paramParcel.writeInt(this.isGetRecommAfterPlay);
      paramParcel.writeLong(this.shootTime);
      paramParcel.writeInt(this.videoplaycnt);
      if (!this.allowShowPasterVideoAdv) {
        break label452;
      }
      paramInt = 1;
      label352:
      paramParcel.writeInt(paramInt);
      if (!this.needDeleteLocal) {
        break label457;
      }
    }
    label442:
    label447:
    label452:
    label457:
    for (paramInt = j;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeLong(this.seekPosition);
      paramParcel.writeString(this.lloc);
      paramParcel.writeString(this.albumid);
      paramParcel.writeInt(this.pull_weishi_mask);
      paramParcel.writeString(this.weishi_download_url);
      paramParcel.writeString(this.weishi_pull_schema);
      paramParcel.writeString(this.weishi_clipbrd);
      paramParcel.writeString(this.pull_weishi_alg_id);
      return;
      i = 0;
      break;
      paramInt = 0;
      break label268;
      paramInt = 0;
      break label282;
      paramInt = 0;
      break label352;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.model.VideoInfo
 * JD-Core Version:    0.7.0.1
 */