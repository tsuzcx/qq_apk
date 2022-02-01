package com.tencent.mobileqq.troop.api.essence.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.troop.api.essence.ITroopEssenceService;
import com.tencent.mobileqq.troop.api.essence.data.TroopEssenceMsgItem;
import com.tencent.mobileqq.troop.api.essence.handler.TroopEssenceMsgHandler;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class TroopEssenceServiceImpl
  implements ITroopEssenceService
{
  private static final String TAG = "QQTroopEssenceServiceImpl";
  private AppRuntime mAppRuntime;
  TroopEssenceMsgHandler mHandler;
  
  public void batchReqSetTroopEssenceMsg(long paramLong, ArrayList<TroopEssenceMsgItem> paramArrayList)
  {
    if (this.mHandler != null) {
      this.mHandler.a(paramLong, paramArrayList);
    }
  }
  
  public void getEssenceMsgList(String paramString, int paramInt)
  {
    if (this.mHandler != null) {
      this.mHandler.a(paramString, paramInt);
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mAppRuntime = paramAppRuntime;
    this.mHandler = ((TroopEssenceMsgHandler)((AppInterface)this.mAppRuntime).getBusinessHandler(TroopEssenceMsgHandler.class.getName()));
  }
  
  public void onDestroy()
  {
    this.mAppRuntime = null;
  }
  
  public void reqSetTroopEssenceMsg(TroopEssenceMsgItem paramTroopEssenceMsgItem, int paramInt)
  {
    if (this.mHandler != null) {
      this.mHandler.a(paramTroopEssenceMsgItem, paramInt);
    }
  }
  
  public void setEssenceMsgShowInCardSwitch(String paramString, boolean paramBoolean)
  {
    if (this.mHandler != null) {
      this.mHandler.a(paramString, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.essence.impl.TroopEssenceServiceImpl
 * JD-Core Version:    0.7.0.1
 */