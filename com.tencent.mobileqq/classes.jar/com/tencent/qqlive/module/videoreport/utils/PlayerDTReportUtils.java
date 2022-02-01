package com.tencent.qqlive.module.videoreport.utils;

import android.support.annotation.NonNull;
import android.util.SparseIntArray;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.vinfo.TVKVideoInfo;

public class PlayerDTReportUtils
{
  private static final int MODE_EXTRA_URL = 6;
  private static final int MODE_LIVE = 3;
  private static final int MODE_LOCAL = 4;
  private static final int MODE_LOOP_VOD = 7;
  private static final int MODE_OFFLINE = 2;
  private static final int MODE_UNKNOWN = 0;
  private static final int MODE_VOD = 1;
  private static final int MODE_XML_VOD = 9;
  private static final int PAY_TYPE_NO_DEFI = 9;
  private static final int PAY_TYPE_NO_NEED_PAY = 0;
  private static final int PAY_TYPE_PAYED = 2;
  private static final int PAY_TYPE_UNPAYED = 1;
  private static final int TVK_VIDEO_INFO_LIMIT_VALUE_0 = 0;
  private static final int TVK_VIDEO_INFO_LIMIT_VALUE_1 = 1;
  private static final int TVK_VIDEO_INFO_PAY_CH_VALUE_0 = 0;
  private static final int TVK_VIDEO_INFO_STATUS_VALUE_2 = 2;
  private static final int TVK_VIDEO_INFO_STATUS_VALUE_8 = 8;
  private static SparseIntArray sPlaySourceMapping = new SparseIntArray();
  
  static
  {
    sPlaySourceMapping.put(1, 3);
    sPlaySourceMapping.put(2, 1);
    sPlaySourceMapping.put(3, 2);
    sPlaySourceMapping.put(4, 4);
    sPlaySourceMapping.put(5, 6);
    sPlaySourceMapping.put(8, 7);
    sPlaySourceMapping.put(9, 9);
  }
  
  public static int getPayType(@NonNull TVKVideoInfo paramTVKVideoInfo)
  {
    if (paramTVKVideoInfo.getJceResponse() != null) {
      return getPayTypeFromJce(paramTVKVideoInfo);
    }
    return getPayTypeFromState(paramTVKVideoInfo);
  }
  
  private static int getPayTypeFromJce(@NonNull TVKVideoInfo paramTVKVideoInfo)
  {
    if (paramTVKVideoInfo.getStatus() != 8) {
      return 0;
    }
    if (paramTVKVideoInfo.getLimit() == 1) {
      return 1;
    }
    if (paramTVKVideoInfo.getLimit() == 0) {
      return 2;
    }
    return 9;
  }
  
  private static int getPayTypeFromState(@NonNull TVKVideoInfo paramTVKVideoInfo)
  {
    int i = paramTVKVideoInfo.getSt();
    if (8 == i) {
      return 1;
    }
    int j = paramTVKVideoInfo.getPayCh();
    if ((j > 0) && (2 == i)) {
      return 2;
    }
    if ((j == 0) && (2 == i)) {
      return 0;
    }
    return 9;
  }
  
  public static int getPlaySource(@NonNull TVKPlayerVideoInfo paramTVKPlayerVideoInfo)
  {
    return sPlaySourceMapping.get(paramTVKPlayerVideoInfo.getPlayType(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.utils.PlayerDTReportUtils
 * JD-Core Version:    0.7.0.1
 */