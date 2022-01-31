package com.tencent.mobileqq.troop.filemanager.forward;

import ajly;
import android.text.TextUtils;
import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.biz.troop.file.TroopFileProtocol.ReqCopyToObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.troop.filemanager.TroopFileDataCenter;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.troop.utils.TroopFileError.SimpleErrorInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import cooperation.weiyun.ResponseHandler;
import java.util.UUID;
import tencent.im.cs.cmd0x383.cmd0x383.RspBody;

public class TroopFileFromTroopForwarder
{
  protected int a;
  public long a;
  TroopFileProtocol.ReqCopyToObserver a;
  public TroopFileTransferManager.Item a;
  protected String a;
  
  protected TroopFileFromTroopForwarder(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizTroopFileTroopFileProtocol$ReqCopyToObserver = new ajly(this);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item = paramItem;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id != null) {}
    for (paramItem = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id.toString();; paramItem = "")
    {
      this.jdField_a_of_type_JavaLangString = paramItem;
      this.jdField_a_of_type_Int = paramInt;
      return;
    }
  }
  
  public static TroopFileFromTroopForwarder a(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    if (paramLong == 0L)
    {
      TroopFileTransferUtil.Log.a("TroopFileFromTroopForwarder", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "getTroop2WeiyunForwarder. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      TroopFileTransferUtil.Log.a("TroopFileFromTroopForwarder", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "getTroop2WeiyunForwarder. item=null");
      return null;
    }
    if (paramItem.Id == null)
    {
      TroopFileTransferUtil.Log.a("TroopFileFromTroopForwarder", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "getTroop2WeiyunForwarder. item.id=null");
      return null;
    }
    if (paramItem.ForwardTroopuin == 0L)
    {
      TroopFileTransferUtil.Log.a("TroopFileFromTroopForwarder", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "getTroop2WeiyunForwarder. ForwardTroopuin=0");
      return null;
    }
    if (paramItem.BusId != 25)
    {
      TroopFileTransferUtil.Log.a("TroopFileFromTroopForwarder", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "getTroop2WeiyunForwarder. BusId err:" + paramItem.BusId);
      return null;
    }
    if (TextUtils.isEmpty(paramItem.ForwardPath))
    {
      TroopFileTransferUtil.Log.a("TroopFileFromTroopForwarder", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "get2WeiyunForwarder. ForwardPath=null");
      return null;
    }
    return new TroopFileFromTroopForwarder(paramLong, paramItem, 1);
  }
  
  private final void a(boolean paramBoolean, cmd0x383.RspBody paramRspBody)
  {
    int i = 601;
    if ((!paramBoolean) || (paramRspBody == null))
    {
      ResponseHandler.a(-1);
      TroopFileTransferUtil.Log.a("TroopFileFromTroopForwarder", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onTroop2weiyunResult isSuccess:false ");
      paramRspBody = new TroopFileError.SimpleErrorInfo(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName, this.jdField_a_of_type_Long, 5, 601);
      TroopFileDataCenter.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 5, paramRspBody);
      return;
    }
    int j = paramRspBody.int32_ret_code.get();
    paramRspBody = paramRspBody.str_client_wording.get();
    TroopFileTransferUtil.Log.c("TroopFileFromTroopForwarder", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onTroop2weiyunResult retCode:" + j + " sClientWording:" + paramRspBody);
    ResponseHandler.a(j);
    if (j != 0)
    {
      switch (j)
      {
      }
      for (;;)
      {
        paramRspBody = new TroopFileError.SimpleErrorInfo(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName, this.jdField_a_of_type_Long, 5, i, paramRspBody);
        TroopFileDataCenter.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 5, paramRspBody);
        return;
        i = 202;
        continue;
        i = 702;
        continue;
        i = 703;
        continue;
        i = 702;
        continue;
        i = 701;
        continue;
        i = 705;
        continue;
        if (!TextUtils.isEmpty(paramRspBody)) {
          i = 704;
        }
      }
    }
    paramRspBody = new TroopFileError.SimpleErrorInfo(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName, this.jdField_a_of_type_Long, 5, 602);
    TroopFileDataCenter.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 5, paramRspBody);
  }
  
  private int b()
  {
    QQAppInterface localQQAppInterface = TroopFileTransferUtil.a();
    if (localQQAppInterface == null)
    {
      TroopFileTransferUtil.Log.a("TroopFileFromTroopForwarder", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] troop2weiyun app=null");
      return -1;
    }
    TroopFileTransferUtil.Log.c("TroopFileFromTroopForwarder", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] troop2weiyun. BusId:" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.BusId + " ForwardBusId:" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ForwardBusId + " ForwardPath:" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ForwardPath);
    TroopFileProtocol.a(localQQAppInterface, true, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, localQQAppInterface.getLongAccountUin(), 0L, this.jdField_a_of_type_ComTencentBizTroopFileTroopFileProtocol$ReqCopyToObserver);
    return 0;
  }
  
  public int a()
  {
    if (1 == this.jdField_a_of_type_Int) {
      return b();
    }
    return -1;
  }
  
  public UUID a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.forward.TroopFileFromTroopForwarder
 * JD-Core Version:    0.7.0.1
 */