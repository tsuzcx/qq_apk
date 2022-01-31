package com.tencent.mobileqq.troop.filemanager;

import android.os.SystemClock;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileError.SimpleErrorInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item.W2MPauseEnum;

public class TroopFileDataCenter
{
  static long a;
  
  public static void a(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    QQAppInterface localQQAppInterface = TroopFileTransferUtil.a();
    if (localQQAppInterface == null) {
      return;
    }
    if (paramItem.troopuin == 0L)
    {
      TroopFileTransferUtil.Log.b("TroopFileDataCenter", TroopFileTransferUtil.Log.a, "saveStatus. item.troopuin=0, change to:" + paramLong);
      paramItem.troopuin = paramLong;
    }
    if (paramItem.troopuin == 0L)
    {
      TroopFileTransferUtil.Log.a("TroopFileDataCenter", TroopFileTransferUtil.Log.a, "saveStatus. item.troopuin=0 err");
      return;
    }
    localQQAppInterface.a().a().a(paramItem);
  }
  
  public static void a(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt)
  {
    a(paramLong, paramItem, paramInt, 0);
  }
  
  public static void a(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt1, int paramInt2)
  {
    if (paramItem.Status != paramInt1) {}
    for (boolean bool = true;; bool = false)
    {
      paramItem.IsNewStatus = bool;
      if (paramItem.IsNewStatus) {
        TroopFileDataReporter.a(paramLong, paramItem, paramInt1, paramInt2);
      }
      paramItem.Status = paramInt1;
      paramItem.ErrorCode = paramInt2;
      paramItem.Pausing = 0;
      if (paramItem.W2MPause == TroopFileTransferManager.Item.W2MPauseEnum.W2M_PAUSE_NO_RESUME) {
        paramItem.W2MPause = TroopFileTransferManager.Item.W2MPauseEnum.W2M_PAUSE_NONE;
      }
      a(paramLong, paramItem);
      paramItem.StatusUpdateTimeMs = 0L;
      b(paramLong, paramItem);
      paramItem.IsNewStatus = false;
      b(paramLong, paramItem, paramInt2);
      return;
    }
  }
  
  public static void a(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt, TroopFileError.SimpleErrorInfo paramSimpleErrorInfo)
  {
    if (paramItem.Status != paramInt) {}
    for (boolean bool = true;; bool = false)
    {
      paramItem.IsNewStatus = bool;
      paramItem.Status = paramInt;
      paramItem.ErrorCode = paramSimpleErrorInfo.a;
      paramItem.Pausing = 0;
      if (paramItem.W2MPause == TroopFileTransferManager.Item.W2MPauseEnum.W2M_PAUSE_NO_RESUME) {
        paramItem.W2MPause = TroopFileTransferManager.Item.W2MPauseEnum.W2M_PAUSE_NONE;
      }
      a(paramLong, paramItem);
      paramItem.StatusUpdateTimeMs = 0L;
      b(paramLong, paramItem);
      paramItem.IsNewStatus = false;
      TroopFileError.a(TroopFileTransferUtil.a(), paramSimpleErrorInfo);
      return;
    }
  }
  
  public static void b(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    long l1 = SystemClock.uptimeMillis() - a;
    long l2 = SystemClock.uptimeMillis() - paramItem.StatusUpdateTimeMs;
    if ((a == 0L) || (paramItem.StatusUpdateTimeMs == 0L) || (l2 > 5000L) || (l2 < 0L) || (l1 > 1000L) || (l1 < 0L))
    {
      a = l1 + a;
      paramItem.StatusUpdateTimeMs += l2;
      QQAppInterface localQQAppInterface = TroopFileTransferUtil.a();
      if (localQQAppInterface != null) {
        ((BizTroopHandler)localQQAppInterface.a(22)).a(paramItem.getInfo(paramLong));
      }
    }
  }
  
  public static void b(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt)
  {
    TroopFileError.a(TroopFileTransferUtil.a(), paramLong, paramItem.FileName, paramItem.Status, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.TroopFileDataCenter
 * JD-Core Version:    0.7.0.1
 */