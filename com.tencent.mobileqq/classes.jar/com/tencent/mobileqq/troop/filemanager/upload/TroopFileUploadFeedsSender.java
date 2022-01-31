package com.tencent.mobileqq.troop.filemanager.upload;

import ajmp;
import ajmr;
import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.biz.troop.file.TroopFileProtocol.GetOneFileInfoObserver;
import com.tencent.biz.troop.file.TroopFileProtocol.ReqFeedsObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.UUID;

public class TroopFileUploadFeedsSender
{
  public long a;
  public TroopFileProtocol.GetOneFileInfoObserver a;
  TroopFileProtocol.ReqFeedsObserver a;
  public TroopFileTransferManager.Item a;
  public String a;
  
  public TroopFileUploadFeedsSender(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    this.jdField_a_of_type_ComTencentBizTroopFileTroopFileProtocol$ReqFeedsObserver = new ajmp(this);
    this.jdField_a_of_type_ComTencentBizTroopFileTroopFileProtocol$GetOneFileInfoObserver = new ajmr(this);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item = paramItem;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id != null) {}
    for (paramItem = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id.toString();; paramItem = "")
    {
      this.jdField_a_of_type_JavaLangString = paramItem;
      return;
    }
  }
  
  public static TroopFileUploadFeedsSender a(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    if (paramLong == 0L)
    {
      TroopFileTransferUtil.Log.a("TroopFileUploadFeedsSender", TroopFileTransferUtil.Log.a, "getSender. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      TroopFileTransferUtil.Log.a("TroopFileUploadFeedsSender", TroopFileTransferUtil.Log.a, "getSender. item=null");
      return null;
    }
    if (paramItem.Id == null) {
      TroopFileTransferUtil.Log.a("TroopFileUploadFeedsSender", TroopFileTransferUtil.Log.a, "getSender. item.id=null");
    }
    return new TroopFileUploadFeedsSender(paramLong, paramItem);
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public UUID a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id;
  }
  
  public void a()
  {
    QQAppInterface localQQAppInterface = TroopFileTransferUtil.a();
    if (localQQAppInterface == null)
    {
      TroopFileTransferUtil.Log.a("TroopFileUploadFeedsSender", TroopFileTransferUtil.Log.a, "[" + this.jdField_a_of_type_JavaLangString + "] reqFeedMsgV2 app=null");
      return;
    }
    TroopFileTransferUtil.Log.c("TroopFileUploadFeedsSender", TroopFileTransferUtil.Log.a, "[" + this.jdField_a_of_type_JavaLangString + "] reqFeedMsgV2");
    TroopFileProtocol.a(localQQAppInterface, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_ComTencentBizTroopFileTroopFileProtocol$ReqFeedsObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadFeedsSender
 * JD-Core Version:    0.7.0.1
 */