package com.tencent.mobileqq.qqgamepub.api;

import android.os.Bundle;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import mqq.app.api.IRuntimeService;

@Service(needUin=false, process={""})
public abstract interface IGamePubAccountMsgService
  extends IRuntimeService
{
  public abstract void addObserver(Observer paramObserver);
  
  public abstract void clearUnreadMsg(String paramString);
  
  public abstract void deleteMsg(String paramString, int paramInt, long paramLong);
  
  public abstract void deleteObserver(Observer paramObserver);
  
  public abstract ArrayList<QQGameMsgInfo> findArkMessage(String paramString, int paramInt1, int paramInt2);
  
  public abstract ArrayList<QQGameMsgInfo> findMessage(String paramString, int paramInt);
  
  public abstract ArrayList<QQGameMsgInfo> findMessage(String paramString, int paramInt1, int paramInt2);
  
  public abstract ArrayList<QQGameMsgInfo> findStructMessage(String paramString, int paramInt1, int paramInt2);
  
  public abstract void onGameNewMsg(List<MessageRecord> paramList);
  
  public abstract void saveGalleryDataToMsg(Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.IGamePubAccountMsgService
 * JD-Core Version:    0.7.0.1
 */