package com.tencent.mobileqq.minigame.data;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class PublishMoodInfo
{
  public static final int MOOD_MAX_PHOTO_AND_VIDEO_COUNT;
  public static final int MOOD_MAX_SINGLE_PHOTO_SIZE;
  public static final int MOOD_MAX_SINGLE_VIDEO_DURATION = QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppMoodMaxSingleVideoDuration", 601000);
  public static final int MOOD_MAX_SINGLE_VIDEO_SIZE;
  public static final int MOOD_MAX_TEXT_COUNT = QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppMoodMaxTextCount", 10000);
  public static final int MOOD_MAX_VIDEO_COUNT;
  private static final String TAG = "[minigame] PublishMoodInfo";
  public ArrayList<String> mAllImageAndVideo = new ArrayList();
  public String mFootnote;
  public ArrayList<PublishMoodInfo.MediaInfo> mMediaInfo = new ArrayList();
  public HashMap<String, LocalMediaInfo> mMediaInfoHashMap = new HashMap();
  public String mPath;
  public String mTag;
  public String mText;
  
  static
  {
    MOOD_MAX_PHOTO_AND_VIDEO_COUNT = QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppMoodMaxPhotoAndVideoCount", 50);
    MOOD_MAX_VIDEO_COUNT = QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppMoodMaxVideoCount", 10);
    MOOD_MAX_SINGLE_PHOTO_SIZE = QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppMoodMaxSinglePhotoSize", 20971520);
    MOOD_MAX_SINGLE_VIDEO_SIZE = QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppMoodMaxSingleVideoSize", 1610612736);
  }
  
  public PublishMoodInfo() {}
  
  public PublishMoodInfo(String paramString1, String paramString2, ArrayList<PublishMoodInfo.MediaInfo> paramArrayList)
  {
    this.mText = paramString1;
    this.mTag = paramString2;
    this.mMediaInfo = paramArrayList;
  }
  
  public static String filterText(String paramString)
  {
    paramString = new StringTokenizer(paramString.toString().replace("\r\n", " ").replace("\n", " "), " ");
    StringBuffer localStringBuffer = new StringBuffer();
    while (paramString.hasMoreTokens()) {
      localStringBuffer.append(paramString.nextToken() + ' ');
    }
    return localStringBuffer.toString().trim();
  }
  
  public static String getFileSizeDesc(long paramLong)
  {
    if (paramLong < 1024L) {}
    try
    {
      return paramLong + "B";
    }
    catch (Exception localException)
    {
      Object localObject;
      double d1;
      double d2;
      QLog.i("[minigame] PublishMoodInfo", 2, "getFileSizeDesc " + paramLong, localException);
    }
    localObject = new DecimalFormat("##0.0");
    d1 = 1024.0D * 1024.0D;
    d2 = 1024.0D * d1;
    if (paramLong < d1) {
      return ((DecimalFormat)localObject).format(paramLong / 1024.0D) + "K";
    }
    if (paramLong < d2) {
      return ((DecimalFormat)localObject).format(paramLong / d1) + "M";
    }
    localObject = ((DecimalFormat)localObject).format(paramLong / d2) + "G";
    return localObject;
    return "";
  }
  
  public String toString()
  {
    int j = 0;
    StringBuilder localStringBuilder = new StringBuilder().append("mText = ").append(this.mText).append(", mTag = ").append(this.mTag).append(", media.size = ");
    if (this.mMediaInfo != null)
    {
      i = this.mMediaInfo.size();
      localStringBuilder = localStringBuilder.append(i).append(", mAllImageAndVideo.size = ");
      if (this.mAllImageAndVideo == null) {
        break label122;
      }
    }
    label122:
    for (int i = this.mAllImageAndVideo.size();; i = 0)
    {
      localStringBuilder = localStringBuilder.append(i).append(", mMediaInfoHashMap.size = ");
      i = j;
      if (this.mMediaInfoHashMap != null) {
        i = this.mMediaInfoHashMap.size();
      }
      return i;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.data.PublishMoodInfo
 * JD-Core Version:    0.7.0.1
 */