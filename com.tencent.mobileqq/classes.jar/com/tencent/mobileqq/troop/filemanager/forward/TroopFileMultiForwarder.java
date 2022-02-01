package com.tencent.mobileqq.troop.filemanager.forward;

import android.text.TextUtils;
import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.biz.troop.file.protocol.TroopFileReqCopyToObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.filemanager.TroopFileDataCenter;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.troop.utils.TroopFileError.SimpleErrorInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import cooperation.weiyun.ResponseHandler;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class TroopFileMultiForwarder
{
  protected int a;
  protected long a;
  TroopFileReqCopyToObserver a;
  protected Map<UUID, TroopFileTransferManager.Item> a;
  protected Map<UUID, Integer> b = new HashMap();
  
  protected TroopFileMultiForwarder(long paramLong, List<TroopFileTransferManager.Item> paramList, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileReqCopyToObserver = new TroopFileMultiForwarder.1(this);
    this.jdField_a_of_type_Long = paramLong;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)paramList.next();
      this.jdField_a_of_type_JavaUtilMap.put(localItem.Id, localItem);
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static TroopFileMultiForwarder a(long paramLong, List<TroopFileTransferManager.Item> paramList)
  {
    if (paramLong == 0L)
    {
      TroopFileTransferUtil.Log.a("TroopFileFromTroopForwarder", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "getTroop2WeiyunForwarder. troopuin=0");
      return null;
    }
    if (paramList == null)
    {
      TroopFileTransferUtil.Log.a("TroopFileFromTroopForwarder", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "getTroop2WeiyunForwarder. item=null");
      return null;
    }
    return new TroopFileMultiForwarder(paramLong, paramList, 1);
  }
  
  private final void a(TroopFileTransferManager.Item paramItem, boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    if (!paramBoolean) {}
    try
    {
      ResponseHandler.a(-1);
      this.b.put(paramItem.Id, Integer.valueOf(-1));
      TroopFileTransferUtil.Log.a("TroopFileFromTroopForwarder", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + paramItem.Id.toString() + "] onRspMultiCopyToWeiyun fail. isSuc:" + paramBoolean);
      return;
    }
    finally {}
    TroopFileTransferUtil.Log.c("TroopFileFromTroopForwarder", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + paramItem.Id.toString() + "] onRspMultiCopyToWeiyun retCode:" + paramInt1);
    ResponseHandler.a(paramInt1);
    if (paramInt1 == 0)
    {
      this.b.remove(paramItem.Id);
      if (this.b.size() != 0) {
        break label212;
      }
      paramString1 = new TroopFileError.SimpleErrorInfo(paramItem.FileName, this.jdField_a_of_type_Long, 5, 604);
      TroopFileDataCenter.a(this.jdField_a_of_type_Long, paramItem, 5, paramString1);
    }
    label316:
    for (;;)
    {
      return;
      this.b.put(paramItem.Id, Integer.valueOf(paramInt1));
      break;
      label212:
      paramString1 = this.b.keySet().iterator();
      do
      {
        if (!paramString1.hasNext()) {
          break;
        }
        paramString2 = (UUID)paramString1.next();
      } while (((Integer)this.b.get(paramString2)).intValue() != 2147483647);
      for (paramInt1 = 0;; paramInt1 = 1)
      {
        if (paramInt1 == 0) {
          break label316;
        }
        paramString1 = new TroopFileError.SimpleErrorInfo(paramItem.FileName, this.jdField_a_of_type_Long, 5, 605);
        TroopFileDataCenter.a(this.jdField_a_of_type_Long, paramItem, 5, paramString1);
        break;
      }
    }
  }
  
  private int b()
  {
    QQAppInterface localQQAppInterface = TroopFileTransferUtil.a();
    if (localQQAppInterface == null)
    {
      TroopFileTransferUtil.Log.a("TroopFileFromTroopForwarder", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "multiTroop2weiyun app=null");
      return -1;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext())
    {
      TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)localIterator.next();
      if (localItem.Id == null)
      {
        TroopFileTransferUtil.Log.a("TroopFileFromTroopForwarder", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "multiTroop2weiyun. item.id=null");
      }
      else if (localItem.ForwardTroopuin == 0L)
      {
        TroopFileTransferUtil.Log.a("TroopFileFromTroopForwarder", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "multiTroop2weiyun. ForwardTroopuin=0");
      }
      else if (localItem.BusId != 25)
      {
        TroopFileTransferUtil.Log.a("TroopFileFromTroopForwarder", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "multiTroop2weiyun. BusId err:" + localItem.BusId);
      }
      else if (TextUtils.isEmpty(localItem.ForwardPath))
      {
        TroopFileTransferUtil.Log.a("TroopFileFromTroopForwarder", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "multiTroop2weiyun. ForwardPath=null");
      }
      else
      {
        TroopFileTransferUtil.Log.c("TroopFileFromTroopForwarder", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + localItem.Id.toString() + "] multiTroop2weiyun. BusId:" + localItem.BusId + " ForwardBusId:" + localItem.ForwardBusId + " ForwardPath:" + localItem.ForwardPath);
        try
        {
          this.b.put(localItem.Id, Integer.valueOf(2147483647));
          TroopFileProtocol.a(localQQAppInterface, true, this.jdField_a_of_type_Long, localItem, localQQAppInterface.getLongAccountUin(), 0L, this.jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileReqCopyToObserver);
        }
        finally {}
      }
    }
    return 0;
  }
  
  public int a()
  {
    if (1 == this.jdField_a_of_type_Int) {
      return b();
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.forward.TroopFileMultiForwarder
 * JD-Core Version:    0.7.0.1
 */