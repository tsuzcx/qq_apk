package com.tencent.mobileqq.troop.api;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.troop.recommend.data.RecommendTroopItem;
import java.util.ArrayList;
import java.util.List;
import mqq.app.api.IRuntimeService;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.cmd0x935.oidb_0x935.GPS;
import tencent.im.oidb.cmd0x935.oidb_0x935.NotifyInfo;

@Service(process={""})
public abstract interface IRecommendTroopService
  extends IRuntimeService
{
  public static final int DB_STATUS_NORMAL = 0;
  public static final int DB_STATUS_USER = 1;
  public static final String KEY_CONFIG_SHOW_NEW_RECOMMEND = "show_new_troop_recommend";
  public static final int MAX_LIST_SIZE = 50;
  public static final int RECOMMENDTROOP_CHANNEL_NOTIFICATION = 2;
  public static final int RECOMMENDTROOP_SRC_MSG = 2;
  public static final int RECOMMENDTROOP_SRC_USER = 1;
  public static final String SP_NAME_RECOMMEND_UNREAD_COUNT = "unread_recommend_troop_count";
  
  public abstract void clearGroupSysNotifyReportData();
  
  public abstract void clearRecommendTroop();
  
  public abstract void delRecommendTroopFromMsg(String paramString);
  
  public abstract boolean downloadRecommendTroop();
  
  public abstract List<RecommendTroopItem> getAddedData();
  
  public abstract int getDBDataStatus();
  
  public abstract String getLastMessage();
  
  public abstract void getNotificationRecommendTroopFromServer(long paramLong, oidb_0x935.GPS paramGPS, int paramInt);
  
  public abstract void getRecommendTroopFromServer(int paramInt1, oidb_0x935.GPS paramGPS, int paramInt2, BusinessObserver paramBusinessObserver);
  
  public abstract int getUnreadNum();
  
  public abstract int isEnd();
  
  public abstract void reSetConfig();
  
  public abstract void saveAddedData(List<RecommendTroopItem> paramList);
  
  public abstract void saveGroupSysNotifyReportData(@Nullable ArrayList<oidb_0x935.NotifyInfo> paramArrayList);
  
  public abstract void sendReadConfirm();
  
  public abstract void setEnd(int paramInt);
  
  public abstract void setRecommendTroopDeleted(String paramString, BusinessObserver paramBusinessObserver);
  
  public abstract void setUnreadNum(int paramInt);
  
  public abstract void updateDBStatsus(int paramInt);
  
  public abstract void updateTroopRecommend(String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.IRecommendTroopService
 * JD-Core Version:    0.7.0.1
 */