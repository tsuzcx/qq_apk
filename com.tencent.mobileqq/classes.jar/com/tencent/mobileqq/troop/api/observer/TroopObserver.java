package com.tencent.mobileqq.troop.api.observer;

import android.util.Pair;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopInfoExt;
import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.service.troop.TroopNotificationConstants;
import com.tencent.mobileqq.troop.api.ITroopObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

public class TroopObserver
  implements ITroopObserver
{
  private void onUpdate_getMultiTroopInfo(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.c) {}
    do
    {
      return;
      onUpdateTroopNickname(paramBoolean);
    } while (paramObject == null);
    onGetMutilTroopInfoResult(paramBoolean, (ArrayList)paramObject);
  }
  
  private void onUpdate_getSimpleTroopInfo(int paramInt, boolean paramBoolean, Object paramObject)
  {
    String str = null;
    if (paramInt != TroopNotificationConstants.I) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    Object[] arrayOfObject = (Object[])paramObject;
    if ((arrayOfObject.length >= 3) && ((arrayOfObject[2] instanceof TroopInfo)))
    {
      paramObject = (TroopInfo)arrayOfObject[2];
      str = (String)arrayOfObject[5];
    }
    for (;;)
    {
      onGetSimpleTroopInfoResult(paramBoolean, paramObject, str);
      return;
      paramObject = null;
    }
  }
  
  private void onUpdate_getTroopGetMemberList(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.e) {
      return;
    }
    Object[] arrayOfObject = (Object[])paramObject;
    if (arrayOfObject.length == 5)
    {
      String str = (String)arrayOfObject[0];
      if (arrayOfObject[1] == null) {}
      for (paramObject = null;; paramObject = (List)arrayOfObject[1])
      {
        onUpdateTroopGetMemberList(str, paramBoolean, paramObject, ((Integer)arrayOfObject[2]).intValue(), ((Long)arrayOfObject[3]).longValue(), ((Integer)arrayOfObject[4]).intValue());
        return;
      }
    }
    QLog.d("TroopBusinessObserver", 1, "onUpdate,TYPR_GET_TROOP_GETMEMBERLIST datas.length error");
  }
  
  private void onUpdate_getTroopInfo(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.i) {
      return;
    }
    onGetTroopInfoResult(paramBoolean, (String)paramObject);
  }
  
  private void onUpdate_getTroopList(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.b) {
      return;
    }
    onUpdateTroopList(paramBoolean);
    onUpdateRecentList();
  }
  
  private void onUpdate_getTroopMemberCard(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.Y) {
      return;
    }
    onGetTroopMemberCard(paramBoolean, paramObject);
  }
  
  private void onUpdate_getTroopMemberCardList(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.k) {}
    do
    {
      return;
      if (paramObject != null)
      {
        Object localObject = (Object[])paramObject;
        paramObject = (ArrayList)localObject[0];
        localObject = (Boolean)localObject[1];
        if (QLog.isColorLevel()) {
          QLog.d("handlerGetTroopMemberCardInfoList", 2, "TYPE_GET_TROOPMEMEBER_CARD_LIST suc");
        }
        if (QLog.isColorLevel()) {
          QLog.d("handlerGetTroopMemberCardInfoList", 2, "TYPE_GET_TROOPMEMEBER_CARD_LIST bSaved2DBSuccess = " + localObject);
        }
        onGetTroopMemberCardInfoResult(paramBoolean, paramObject);
        onGetTroopMemberCardInfoResult(paramBoolean, paramObject, ((Boolean)localObject).booleanValue());
        return;
      }
      onGetTroopMemberCardInfoResult(paramBoolean, null);
      onGetTroopMemberCardInfoResult(paramBoolean, null, false);
    } while (!QLog.isColorLevel());
    QLog.d("handlerGetTroopMemberCardInfoList", 2, "TYPE_GET_TROOPMEMEBER_CARD_LIST failed");
  }
  
  private void onUpdate_getTroopMemberListBy787(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.bn) {
      return;
    }
    paramObject = (Object[])paramObject;
    onGetTroopMemberListBy0x787((String)paramObject[0], (List)paramObject[1]);
  }
  
  private void onUpdate_modifyTroopMemberCard(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.j) {
      return;
    }
    paramObject = (Object[])paramObject;
    if ((paramObject != null) && (paramObject.length > 1))
    {
      onModifyTroopInfoResult(paramBoolean, (ArrayList)paramObject[0], (String)paramObject[1]);
      return;
    }
    onModifyTroopInfoResult(paramBoolean, null, "");
  }
  
  private void onUpdate_notifyExitTroop(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.bw) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    onPassiveExit((String)paramObject[0], ((Integer)paramObject[1]).intValue());
  }
  
  private void onUpdate_notifyGetTroopInfoExtComplete(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.cj) {}
    do
    {
      do
      {
        return;
      } while ((paramObject == null) || (!(paramObject instanceof Object[])));
      paramObject = (Object[])paramObject;
    } while ((paramObject.length != 2) || (!(paramObject[0] instanceof String)) || (!(paramObject[1] instanceof TroopInfoExt)));
    onGetTroopInfoExtComplete(paramBoolean, (String)paramObject[0], (TroopInfoExt)paramObject[1]);
  }
  
  private void onUpdate_notifyTroopFlagExt3Update(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramInt != TroopNotificationConstants.cb) || (!paramBoolean)) {}
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof Object[]));
      paramObject = (Object[])paramObject;
    } while (paramObject.length < 2);
    onTroopFlagExt3Update((String)paramObject[0], ((Long)paramObject[1]).longValue());
  }
  
  private void onUpdate_notifyUpdateRecentList(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.aC) {
      return;
    }
    onUpdateRecentList();
  }
  
  private void onUpdate_oidb_0x88D_10(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.Z) {
      return;
    }
    paramObject = (Object[])paramObject;
    onOIDB0X88D_10_Ret(paramBoolean, ((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue(), (TroopInfo)paramObject[2], ((Integer)paramObject[3]).intValue(), (String)paramObject[4]);
  }
  
  private void onUpdate_oidb_0x899_0(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.t) {
      return;
    }
    paramObject = (Object[])paramObject;
    onOIDB0X899_0_Ret(paramBoolean, ((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue(), (List)paramObject[2], ((Long)paramObject[3]).longValue(), ((Integer)paramObject[4]).intValue(), (String)paramObject[5]);
  }
  
  private void onUpdate_troopManager(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.f) {
      return;
    }
    paramObject = (Object[])paramObject;
    if ((paramObject[1] instanceof Integer)) {}
    for (paramInt = ((Integer)paramObject[1]).intValue(); paramBoolean; paramInt = ((Byte)paramObject[1]).byteValue())
    {
      onTroopManagerSuccess(((Integer)paramObject[0]).intValue(), paramInt, (String)paramObject[2]);
      return;
    }
    onTroopManagerFailed(((Integer)paramObject[0]).intValue(), paramInt);
  }
  
  protected void onGetMutilTroopInfoResult(boolean paramBoolean, ArrayList<TroopInfo> paramArrayList) {}
  
  protected void onGetSimpleTroopInfoResult(boolean paramBoolean, TroopInfo paramTroopInfo, String paramString) {}
  
  protected void onGetTroopInfoExtComplete(boolean paramBoolean, String paramString, TroopInfoExt paramTroopInfoExt) {}
  
  protected void onGetTroopInfoResult(boolean paramBoolean, String paramString) {}
  
  protected void onGetTroopMemberCard(boolean paramBoolean, Object paramObject) {}
  
  protected void onGetTroopMemberCardInfoResult(boolean paramBoolean, ArrayList<TroopMemberCardInfo> paramArrayList) {}
  
  protected void onGetTroopMemberCardInfoResult(boolean paramBoolean1, ArrayList<TroopMemberCardInfo> paramArrayList, boolean paramBoolean2) {}
  
  protected void onGetTroopMemberListBy0x787(String paramString, List<Pair<String, String>> paramList) {}
  
  protected void onModifyTroopInfoResult(boolean paramBoolean, ArrayList<TroopMemberCardInfo> paramArrayList, String paramString) {}
  
  protected void onOIDB0X88D_10_Ret(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString) {}
  
  protected void onOIDB0X899_0_Ret(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString) {}
  
  protected void onPassiveExit(String paramString, int paramInt) {}
  
  protected void onTroopFlagExt3Update(String paramString, long paramLong) {}
  
  protected void onTroopManagerFailed(int paramInt1, int paramInt2) {}
  
  protected void onTroopManagerSuccess(int paramInt1, int paramInt2, String paramString) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    onUpdate_getTroopList(paramInt, paramBoolean, paramObject);
    onUpdate_notifyUpdateRecentList(paramInt, paramBoolean, paramObject);
    onUpdate_getMultiTroopInfo(paramInt, paramBoolean, paramObject);
    onUpdate_getSimpleTroopInfo(paramInt, paramBoolean, paramObject);
    onUpdate_getTroopInfo(paramInt, paramBoolean, paramObject);
    onUpdate_oidb_0x88D_10(paramInt, paramBoolean, paramObject);
    onUpdate_notifyGetTroopInfoExtComplete(paramInt, paramBoolean, paramObject);
    onUpdate_notifyExitTroop(paramInt, paramBoolean, paramObject);
    onUpdate_troopManager(paramInt, paramBoolean, paramObject);
    onUpdate_notifyTroopFlagExt3Update(paramInt, paramBoolean, paramObject);
    onUpdate_oidb_0x899_0(paramInt, paramBoolean, paramObject);
    onUpdate_modifyTroopMemberCard(paramInt, paramBoolean, paramObject);
    onUpdate_getTroopMemberCardList(paramInt, paramBoolean, paramObject);
    onUpdate_getTroopMemberCard(paramInt, paramBoolean, paramObject);
    onUpdate_getTroopMemberListBy787(paramInt, paramBoolean, paramObject);
    onUpdate_getTroopGetMemberList(paramInt, paramBoolean, paramObject);
  }
  
  protected void onUpdateRecentList() {}
  
  protected void onUpdateTroopGetMemberList(String paramString, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2) {}
  
  protected void onUpdateTroopList(boolean paramBoolean) {}
  
  protected void onUpdateTroopNickname(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.observer.TroopObserver
 * JD-Core Version:    0.7.0.1
 */