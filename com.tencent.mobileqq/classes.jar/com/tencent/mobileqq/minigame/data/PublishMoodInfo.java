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
    while (paramString.hasMoreTokens())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString.nextToken());
      localStringBuilder.append(' ');
      localStringBuffer.append(localStringBuilder.toString());
    }
    return localStringBuffer.toString().trim();
  }
  
  public static String getFileSizeDesc(long paramLong)
  {
    if (paramLong < 1024L) {}
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("B");
      return ((StringBuilder)localObject).toString();
    }
    catch (Exception localException)
    {
      Object localObject;
      double d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getFileSizeDesc ");
      localStringBuilder.append(paramLong);
      QLog.i("[minigame] PublishMoodInfo", 2, localStringBuilder.toString(), localException);
    }
    localObject = new DecimalFormat("##0.0");
    d = paramLong;
    if (d < 1048576.0D)
    {
      localStringBuilder = new StringBuilder();
      Double.isNaN(d);
      d /= 1024.0D;
      localStringBuilder.append(((DecimalFormat)localObject).format(d));
      localStringBuilder.append("K");
      return localStringBuilder.toString();
    }
    if (d < 1073741824.0D)
    {
      localStringBuilder = new StringBuilder();
      Double.isNaN(d);
      d /= 1048576.0D;
      localStringBuilder.append(((DecimalFormat)localObject).format(d));
      localStringBuilder.append("M");
      return localStringBuilder.toString();
    }
    localStringBuilder = new StringBuilder();
    Double.isNaN(d);
    d /= 1073741824.0D;
    localStringBuilder.append(((DecimalFormat)localObject).format(d));
    localStringBuilder.append("G");
    localObject = localStringBuilder.toString();
    return localObject;
    return "";
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mText = ");
    localStringBuilder.append(this.mText);
    localStringBuilder.append(", mTag = ");
    localStringBuilder.append(this.mTag);
    localStringBuilder.append(", media.size = ");
    Object localObject = this.mMediaInfo;
    int j = 0;
    if (localObject != null) {
      i = ((ArrayList)localObject).size();
    } else {
      i = 0;
    }
    localStringBuilder.append(i);
    localStringBuilder.append(", mAllImageAndVideo.size = ");
    localObject = this.mAllImageAndVideo;
    if (localObject != null) {
      i = ((ArrayList)localObject).size();
    } else {
      i = 0;
    }
    localStringBuilder.append(i);
    localStringBuilder.append(", mMediaInfoHashMap.size = ");
    localObject = this.mMediaInfoHashMap;
    int i = j;
    if (localObject != null) {
      i = ((HashMap)localObject).size();
    }
    localStringBuilder.append(i);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.data.PublishMoodInfo
 * JD-Core Version:    0.7.0.1
 */