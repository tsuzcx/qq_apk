package com.tencent.mobileqq.kandian.repo.feeds.entity;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.repo.feeds.api.IKanDianRedDotInfo;
import com.tencent.mobileqq.qroute.QRoute;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class KandianRedDotInfo
  implements Serializable
{
  public static final String REDDOT_TYPE_DAILY = "kandian_daily_red_pnt";
  public static final String REDDOT_TYPE_KANDIAN_DT = "kandian_dt_red_dot_info";
  public static final String REDDOT_TYPE_LOCK_SCREEN = "kandian_red_pnt_lock_screen";
  public static final String REDDOT_TYPE_MAIN_VIDEO_TAB = "kandian_video_tab_reddot_info";
  public long algorithmID;
  public ArrayList<Long> articleIDList = new ArrayList();
  public String cookie;
  public String extInfo;
  public DailyFloatingWindowData floatingWinData = new DailyFloatingWindowData();
  public String forderStatus;
  public byte[] msgData;
  public String rowkey = "";
  public long strategyID;
  public String type;
  
  public KandianRedDotInfo(String paramString)
  {
    this.type = paramString;
  }
  
  public static KandianRedDotInfo getRedDotFromDisk(String paramString, boolean paramBoolean)
  {
    return (KandianRedDotInfo)((IKanDianRedDotInfo)QRoute.api(IKanDianRedDotInfo.class)).getKanDianRedDotFromDisk(paramString, paramBoolean);
  }
  
  public MessageRecord getMessageRecord()
  {
    return ((IKanDianRedDotInfo)QRoute.api(IKanDianRedDotInfo.class)).getMessageRecordFromData(this.msgData, this.type);
  }
  
  public String getRowKey()
  {
    return ((IKanDianRedDotInfo)QRoute.api(IKanDianRedDotInfo.class)).getRowKeyFromMessageRecord(this.msgData, this.type);
  }
  
  public boolean hasArticleID()
  {
    ArrayList localArrayList = this.articleIDList;
    return (localArrayList != null) && (!localArrayList.isEmpty());
  }
  
  public void removeFromDiskAsync(boolean paramBoolean)
  {
    ((IKanDianRedDotInfo)QRoute.api(IKanDianRedDotInfo.class)).removeKanDianRedDotInfoFromDiskAsync(this.type, paramBoolean);
  }
  
  public void saveToDiskAsync()
  {
    ((IKanDianRedDotInfo)QRoute.api(IKanDianRedDotInfo.class)).saveKanDianRedDotInfoToDiskAsync(this.type, this);
  }
  
  public boolean shouldRemoveFloatingRedPntArticleId()
  {
    DailyFloatingWindowData localDailyFloatingWindowData = this.floatingWinData;
    return (localDailyFloatingWindowData != null) && (localDailyFloatingWindowData.remove);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("KandianRedDotInfo{type='");
    localStringBuilder.append(this.type);
    localStringBuilder.append('\'');
    localStringBuilder.append(", articleIDList=");
    localStringBuilder.append(this.articleIDList);
    localStringBuilder.append(", algorithmID=");
    localStringBuilder.append(this.algorithmID);
    localStringBuilder.append(", strategyID=");
    localStringBuilder.append(this.strategyID);
    localStringBuilder.append(", cookie='");
    localStringBuilder.append(this.cookie);
    localStringBuilder.append('\'');
    localStringBuilder.append(", forderStatus='");
    localStringBuilder.append(this.forderStatus);
    localStringBuilder.append('\'');
    localStringBuilder.append(", extInfo='");
    localStringBuilder.append(this.extInfo);
    localStringBuilder.append('\'');
    localStringBuilder.append(", msgData=");
    localStringBuilder.append(Arrays.toString(this.msgData));
    localStringBuilder.append(", rowkey='");
    localStringBuilder.append(this.rowkey);
    localStringBuilder.append('\'');
    localStringBuilder.append(", floatingWinData=");
    localStringBuilder.append(this.floatingWinData);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.KandianRedDotInfo
 * JD-Core Version:    0.7.0.1
 */