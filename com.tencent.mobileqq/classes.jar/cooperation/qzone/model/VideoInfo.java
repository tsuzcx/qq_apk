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
      d = paramLong % 60000L;
      Double.isNaN(d);
      int k = (int)Math.round(d * 1.0D / 1000.0D);
      int j = 0;
      i = k;
      if (k >= 60)
      {
        j = k / 60;
        i = k % 60;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramLong / 60000L + j);
      localStringBuilder.append(":");
      if (i > 9)
      {
        localObject = Integer.valueOf(i);
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("0");
        ((StringBuilder)localObject).append(i);
        localObject = ((StringBuilder)localObject).toString();
      }
      localStringBuilder.append(localObject);
      return localStringBuilder.toString();
    }
    double d = paramLong;
    Double.isNaN(d);
    int i = (int)Math.round(d * 1.0D / 1000.0D);
    if (i > 9)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("0:");
      ((StringBuilder)localObject).append(i);
      return ((StringBuilder)localObject).toString();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("0:0");
    ((StringBuilder)localObject).append(i);
    return ((StringBuilder)localObject).toString();
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
    String str = ":%d";
    if (l2 > 0L)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("%d");
      if (paramLong >= 10L) {
        localObject1 = ":%d";
      } else {
        localObject1 = ":0%d";
      }
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      if (l1 < 10L) {
        str = ":0%d";
      }
      ((StringBuilder)localObject1).append(str);
      return String.format(((StringBuilder)localObject1).toString(), new Object[] { Long.valueOf(l2), Long.valueOf(paramLong), Long.valueOf(l1) });
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("%d");
    if (l1 < 10L) {
      str = ":0%d";
    }
    ((StringBuilder)localObject1).append(str);
    return String.format(((StringBuilder)localObject1).toString(), new Object[] { Long.valueOf(paramLong), Long.valueOf(l1) });
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
    int i = this.playType;
    boolean bool = true;
    if ((i & 0x1) == 0)
    {
      if (this.videoShowType == 1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public boolean isCircle()
  {
    if ((this.playType & 0x2) != 0)
    {
      long l = this.validVideoTime;
      if ((l <= 0L) || (l >= this.videoTime)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isErrorState()
  {
    int i = this.videoStatus;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (i != 1)
    {
      bool1 = bool2;
      if (i != 7)
      {
        bool1 = bool2;
        if (i != 3)
        {
          if (i == 6) {
            return true;
          }
          bool1 = false;
        }
      }
    }
    return bool1;
  }
  
  public boolean isOpenWithFloat()
  {
    int i = this.actionType;
    return (i == 19) || (i == 3);
  }
  
  public boolean isTranscoding()
  {
    return this.videoStatus == 1;
  }
  
  public boolean isVideoUrlIntact()
  {
    VideoUrl localVideoUrl = this.videoUrl;
    return (localVideoUrl != null) && (!TextUtils.isEmpty(localVideoUrl.url)) && (this.videoUrl.url.contains("https://")) && (!this.videoUrl.url.startsWith("?sid"));
  }
  
  public String toDebugString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoInfo{\nvideoId='");
    localStringBuilder.append(this.videoId);
    localStringBuilder.append('\'');
    localStringBuilder.append('\n');
    localStringBuilder.append(", videoUrl=");
    localStringBuilder.append(this.videoUrl);
    localStringBuilder.append('\n');
    localStringBuilder.append(", originUrl=");
    localStringBuilder.append(this.originUrl);
    localStringBuilder.append('\n');
    localStringBuilder.append(", bigUrl=");
    localStringBuilder.append(this.bigUrl);
    localStringBuilder.append('\n');
    localStringBuilder.append(", currentUrl=");
    localStringBuilder.append(this.currentUrl);
    localStringBuilder.append('\n');
    localStringBuilder.append(", coverUrl=");
    localStringBuilder.append(this.coverUrl);
    localStringBuilder.append('\n');
    localStringBuilder.append(", actionType=");
    localStringBuilder.append(this.actionType);
    localStringBuilder.append('\n');
    localStringBuilder.append(", actionUrl='");
    localStringBuilder.append(this.actionUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append('\n');
    localStringBuilder.append(", nativeLikeUrl='");
    localStringBuilder.append(this.nativeLikeUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append('\n');
    localStringBuilder.append(", highBrUrl=");
    localStringBuilder.append(this.highBrUrl);
    localStringBuilder.append('\n');
    localStringBuilder.append(", lowBrUrl=");
    localStringBuilder.append(this.lowBrUrl);
    localStringBuilder.append('\n');
    localStringBuilder.append(", originVideoUrl=");
    localStringBuilder.append(this.originVideoUrl);
    localStringBuilder.append('\n');
    localStringBuilder.append(", h265NormalUrl=");
    localStringBuilder.append(this.h265NormalUrl);
    localStringBuilder.append('\n');
    localStringBuilder.append(", originVideoSize=");
    localStringBuilder.append(this.originVideoSize);
    localStringBuilder.append('\n');
    localStringBuilder.append(", fileType=");
    localStringBuilder.append(this.fileType);
    localStringBuilder.append('\n');
    localStringBuilder.append(", videoType=");
    localStringBuilder.append(this.videoType);
    localStringBuilder.append('\n');
    localStringBuilder.append(", videoTime=");
    localStringBuilder.append(this.videoTime);
    localStringBuilder.append('\n');
    localStringBuilder.append(", showVideoTime='");
    localStringBuilder.append(this.showVideoTime);
    localStringBuilder.append('\'');
    localStringBuilder.append('\n');
    localStringBuilder.append(", playType=");
    localStringBuilder.append(this.playType);
    localStringBuilder.append('\n');
    localStringBuilder.append(", videoShowType=");
    localStringBuilder.append(this.videoShowType);
    localStringBuilder.append('\n');
    localStringBuilder.append(", hasVideoPlayed=");
    localStringBuilder.append(this.hasVideoPlayed);
    localStringBuilder.append('\n');
    localStringBuilder.append(", videoStatus=");
    localStringBuilder.append(this.videoStatus);
    localStringBuilder.append('\n');
    localStringBuilder.append(", lastUseTime=");
    localStringBuilder.append(this.lastUseTime);
    localStringBuilder.append('\n');
    localStringBuilder.append(", width=");
    localStringBuilder.append(this.width);
    localStringBuilder.append('\n');
    localStringBuilder.append(", height=");
    localStringBuilder.append(this.height);
    localStringBuilder.append('\n');
    localStringBuilder.append(", toast='");
    localStringBuilder.append(this.toast);
    localStringBuilder.append('\'');
    localStringBuilder.append('\n');
    localStringBuilder.append(", isFakeFeed=");
    localStringBuilder.append(this.isFakeFeed);
    localStringBuilder.append('\n');
    localStringBuilder.append(", isFloatFirst=");
    localStringBuilder.append(this.isFloatFirst);
    localStringBuilder.append('\n');
    localStringBuilder.append(", isFeedFirst=");
    localStringBuilder.append(this.isFeedFirst);
    localStringBuilder.append('\n');
    localStringBuilder.append(", isFeedFirstComplete=");
    localStringBuilder.append(this.isFeedFirstComplete);
    localStringBuilder.append('\n');
    localStringBuilder.append(", isFeedComplete=");
    localStringBuilder.append(this.isFeedComplete);
    localStringBuilder.append('\n');
    localStringBuilder.append(", isTranscoding=");
    localStringBuilder.append(this.isTranscoding);
    localStringBuilder.append('\n');
    localStringBuilder.append(", isUploading=");
    localStringBuilder.append(this.isUploading);
    localStringBuilder.append('\n');
    localStringBuilder.append(", videoFloatReportParam=");
    localStringBuilder.append(this.videoFloatReportParam);
    localStringBuilder.append('\n');
    localStringBuilder.append(", videoRemark=");
    localStringBuilder.append(this.videoRemark);
    localStringBuilder.append('\n');
    localStringBuilder.append(", validVideoTime=");
    localStringBuilder.append(this.validVideoTime);
    localStringBuilder.append('\n');
    localStringBuilder.append(", validVideoTimeDesc='");
    localStringBuilder.append(this.validVideoTimeDesc);
    localStringBuilder.append('\'');
    localStringBuilder.append('\n');
    localStringBuilder.append(", isCircle=");
    localStringBuilder.append(this.isCircle);
    localStringBuilder.append('\n');
    localStringBuilder.append(", isAutoPlay=");
    localStringBuilder.append(this.isAutoPlay);
    localStringBuilder.append('\n');
    localStringBuilder.append(", writeFrom=");
    localStringBuilder.append(this.writeFrom);
    localStringBuilder.append('\n');
    localStringBuilder.append(", desc='");
    localStringBuilder.append(this.desc);
    localStringBuilder.append('\'');
    localStringBuilder.append('\n');
    localStringBuilder.append(", videoSource=");
    localStringBuilder.append(this.videoSource);
    localStringBuilder.append('\n');
    localStringBuilder.append(", advDelayTime=");
    localStringBuilder.append(this.advDelayTime);
    localStringBuilder.append('\n');
    localStringBuilder.append(", isGetRecommAfterPlay=");
    localStringBuilder.append(this.isGetRecommAfterPlay);
    localStringBuilder.append('\n');
    localStringBuilder.append(", shootTime=");
    localStringBuilder.append(this.shootTime);
    localStringBuilder.append('\n');
    localStringBuilder.append(", videoplaycnt=");
    localStringBuilder.append(this.videoplaycnt);
    localStringBuilder.append('\n');
    localStringBuilder.append(", allowShowPasterVideoAdv=");
    localStringBuilder.append(this.allowShowPasterVideoAdv);
    localStringBuilder.append('\n');
    localStringBuilder.append(", needDeleteLocal=");
    localStringBuilder.append(this.needDeleteLocal);
    localStringBuilder.append('\n');
    localStringBuilder.append(", scrollToNextDelayTime=");
    localStringBuilder.append(this.scrollToNextDelayTime);
    localStringBuilder.append('\n');
    localStringBuilder.append(", seekPosition=");
    localStringBuilder.append(this.seekPosition);
    localStringBuilder.append('\n');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoInfo [videoId=");
    localStringBuilder.append(this.videoId);
    localStringBuilder.append(", videoUrl=");
    localStringBuilder.append(this.videoUrl);
    localStringBuilder.append(", bigUrl=");
    localStringBuilder.append(this.bigUrl);
    localStringBuilder.append(", actionType=");
    localStringBuilder.append(this.actionType);
    localStringBuilder.append(", actionUrl=");
    localStringBuilder.append(this.actionUrl);
    localStringBuilder.append(", highBrUrl=");
    localStringBuilder.append(this.highBrUrl);
    localStringBuilder.append(", lowBrUrl=");
    localStringBuilder.append(this.lowBrUrl);
    localStringBuilder.append(", fileType=");
    localStringBuilder.append(this.fileType);
    localStringBuilder.append(", videoType=");
    localStringBuilder.append(this.videoType);
    localStringBuilder.append(",videoShowType=");
    localStringBuilder.append(this.videoShowType);
    localStringBuilder.append(", videoTime=");
    localStringBuilder.append(this.videoTime);
    localStringBuilder.append(", videoStatus=");
    localStringBuilder.append(this.videoStatus);
    localStringBuilder.append(", originVideoUrl=");
    localStringBuilder.append(this.originVideoUrl);
    localStringBuilder.append(", originVideoSize=");
    localStringBuilder.append(this.originVideoSize);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.model.VideoInfo
 * JD-Core Version:    0.7.0.1
 */