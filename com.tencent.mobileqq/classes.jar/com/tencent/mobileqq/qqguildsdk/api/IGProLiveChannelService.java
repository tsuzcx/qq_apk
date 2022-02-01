package com.tencent.mobileqq.qqguildsdk.api;

import com.tencent.mobileqq.qqguildsdk.callback.ICheckUserBannedSpeakInChannelCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchIsLiveChannelOpenCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchLiveChannelAnchorListCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchLiveRoomInfoCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchLiveSecurityTipsCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IQueryTinyIdByLiveUIDCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IResultCallback;
import java.util.List;

public abstract interface IGProLiveChannelService
{
  public abstract void checkUserBannedSpeakInChannel(String paramString1, String paramString2, String paramString3, ICheckUserBannedSpeakInChannelCallback paramICheckUserBannedSpeakInChannelCallback);
  
  public abstract void fetchIsLiveChannelOpen(String paramString, IFetchIsLiveChannelOpenCallback paramIFetchIsLiveChannelOpenCallback);
  
  public abstract void fetchLiveChannelAnchorList(String paramString1, String paramString2, IFetchLiveChannelAnchorListCallback paramIFetchLiveChannelAnchorListCallback);
  
  public abstract void fetchLiveRoomInfoByChannelIds(String paramString, List<String> paramList, IFetchLiveRoomInfoCallback paramIFetchLiveRoomInfoCallback);
  
  public abstract void fetchLiveRoomInfoByRoomIds(List<String> paramList, IFetchLiveRoomInfoCallback paramIFetchLiveRoomInfoCallback);
  
  public abstract void fetchLiveSecurityTips(IFetchLiveSecurityTipsCallback paramIFetchLiveSecurityTipsCallback);
  
  public abstract void queryTinyIdByLiveUID(List<String> paramList, IQueryTinyIdByLiveUIDCallback paramIQueryTinyIdByLiveUIDCallback);
  
  public abstract void requestBeginBroadcast(String paramString1, String paramString2, String paramString3, IResultCallback paramIResultCallback);
  
  public abstract void setLiveChannelAnchorList(String paramString1, String paramString2, List<String> paramList1, List<String> paramList2, IResultCallback paramIResultCallback);
  
  public abstract void setLiveChannelBannedUser(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, IResultCallback paramIResultCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.api.IGProLiveChannelService
 * JD-Core Version:    0.7.0.1
 */