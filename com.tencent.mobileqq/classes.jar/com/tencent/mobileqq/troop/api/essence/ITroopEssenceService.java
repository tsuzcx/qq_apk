package com.tencent.mobileqq.troop.api.essence;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.troop.api.essence.data.TroopEssenceMsgItem;
import java.util.ArrayList;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface ITroopEssenceService
  extends IRuntimeService
{
  public abstract void batchReqSetTroopEssenceMsg(long paramLong, ArrayList<TroopEssenceMsgItem> paramArrayList);
  
  public abstract void getEssenceMsgList(String paramString, int paramInt);
  
  public abstract void reqSetTroopEssenceMsg(TroopEssenceMsgItem paramTroopEssenceMsgItem, int paramInt);
  
  public abstract void setEssenceMsgShowInCardSwitch(String paramString, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.essence.ITroopEssenceService
 * JD-Core Version:    0.7.0.1
 */