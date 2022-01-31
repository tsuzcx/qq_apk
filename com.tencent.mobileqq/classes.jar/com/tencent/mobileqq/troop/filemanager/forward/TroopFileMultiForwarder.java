package com.tencent.mobileqq.troop.filemanager.forward;

import ajlz;
import android.text.TextUtils;
import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.biz.troop.file.TroopFileProtocol.ReqCopyToObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
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
import tencent.im.cs.cmd0x383.cmd0x383.RspBody;

public class TroopFileMultiForwarder
{
  protected int a;
  public long a;
  TroopFileProtocol.ReqCopyToObserver a;
  public Map a;
  protected Map b = new HashMap();
  
  protected TroopFileMultiForwarder(long paramLong, List paramList, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_ComTencentBizTroopFileTroopFileProtocol$ReqCopyToObserver = new ajlz(this);
    this.jdField_a_of_type_Long = paramLong;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)paramList.next();
      this.jdField_a_of_type_JavaUtilMap.put(localItem.Id, localItem);
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static TroopFileMultiForwarder a(long paramLong, List paramList)
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
  
  private final void a(TroopFileTransferManager.Item paramItem, boolean paramBoolean, cmd0x383.RspBody paramRspBody)
  {
    if ((!paramBoolean) || (paramRspBody == null))
    {
      ResponseHandler.a(-1);
      this.b.put(paramItem.Id, Integer.valueOf(-1));
      TroopFileTransferUtil.Log.a("TroopFileFromTroopForwarder", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + paramItem.Id.toString() + "] onRspMultiCopyToWeiyun fail. isSuc:" + paramBoolean);
    }
    for (;;)
    {
      return;
      int i = paramRspBody.int32_ret_code.get();
      TroopFileTransferUtil.Log.c("TroopFileFromTroopForwarder", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + paramItem.Id.toString() + "] onRspMultiCopyToWeiyun retCode:" + i);
      ResponseHandler.a(i);
      if (i == 0) {
        this.b.remove(paramItem.Id);
      }
      while (this.b.size() == 0)
      {
        paramRspBody = new TroopFileError.SimpleErrorInfo(paramItem.FileName, this.jdField_a_of_type_Long, 5, 604);
        TroopFileDataCenter.a(this.jdField_a_of_type_Long, paramItem, 5, paramRspBody);
        return;
        this.b.put(paramItem.Id, Integer.valueOf(i));
      }
      paramRspBody = this.b.keySet().iterator();
      UUID localUUID;
      do
      {
        if (!paramRspBody.hasNext()) {
          break;
        }
        localUUID = (UUID)paramRspBody.next();
      } while (((Integer)this.b.get(localUUID)).intValue() != 2147483647);
      for (i = 0; i != 0; i = 1)
      {
        paramRspBody = new TroopFileError.SimpleErrorInfo(paramItem.FileName, this.jdField_a_of_type_Long, 5, 605);
        TroopFileDataCenter.a(this.jdField_a_of_type_Long, paramItem, 5, paramRspBody);
        return;
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
        this.b.put(localItem.Id, Integer.valueOf(2147483647));
        TroopFileProtocol.a(localQQAppInterface, true, this.jdField_a_of_type_Long, localItem, localQQAppInterface.getLongAccountUin(), 0L, this.jdField_a_of_type_ComTencentBizTroopFileTroopFileProtocol$ReqCopyToObserver);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.forward.TroopFileMultiForwarder
 * JD-Core Version:    0.7.0.1
 */