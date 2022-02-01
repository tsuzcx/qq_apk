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
import java.util.UUID;

public class TroopFileFromTroopForwarder
{
  protected int a;
  protected long a;
  TroopFileReqCopyToObserver a;
  protected TroopFileTransferManager.Item a;
  protected String a;
  
  protected TroopFileFromTroopForwarder(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileReqCopyToObserver = new TroopFileFromTroopForwarder.1(this);
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
  
  private final void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    paramInt2 = 601;
    if (!paramBoolean)
    {
      ResponseHandler.a(-1);
      TroopFileTransferUtil.Log.a("TroopFileFromTroopForwarder", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onTroop2weiyunResult isSuccess:false ");
      paramString1 = new TroopFileError.SimpleErrorInfo(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName, this.jdField_a_of_type_Long, 5, 601);
      TroopFileDataCenter.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 5, paramString1);
      return;
    }
    TroopFileTransferUtil.Log.c("TroopFileFromTroopForwarder", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onTroop2weiyunResult retCode:" + paramInt1 + " sClientWording:" + paramString3);
    ResponseHandler.a(paramInt1);
    if (paramInt1 != 0)
    {
      switch (paramInt1)
      {
      default: 
        paramInt1 = paramInt2;
      }
      for (;;)
      {
        paramString1 = new TroopFileError.SimpleErrorInfo(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName, this.jdField_a_of_type_Long, 5, paramInt1, paramString3);
        TroopFileDataCenter.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 5, paramString1);
        return;
        paramInt1 = 202;
        continue;
        paramInt1 = 702;
        continue;
        paramInt1 = 703;
        continue;
        paramInt1 = 702;
        continue;
        paramInt1 = 701;
        continue;
        paramInt1 = 705;
        continue;
        paramInt1 = paramInt2;
        if (!TextUtils.isEmpty(paramString3)) {
          paramInt1 = 704;
        }
      }
    }
    paramString1 = new TroopFileError.SimpleErrorInfo(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName, this.jdField_a_of_type_Long, 5, 602);
    TroopFileDataCenter.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 5, paramString1);
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
    TroopFileProtocol.a(localQQAppInterface, true, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, localQQAppInterface.getLongAccountUin(), 0L, this.jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileReqCopyToObserver);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.forward.TroopFileFromTroopForwarder
 * JD-Core Version:    0.7.0.1
 */