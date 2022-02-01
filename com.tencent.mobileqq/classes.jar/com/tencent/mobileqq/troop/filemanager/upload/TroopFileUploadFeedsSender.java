package com.tencent.mobileqq.troop.filemanager.upload;

import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.biz.troop.file.protocol.TroopFileGetOneFileInfoObserver;
import com.tencent.biz.troop.file.protocol.TroopFileReqFeedsObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.UUID;

public class TroopFileUploadFeedsSender
{
  TroopFileGetOneFileInfoObserver jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileGetOneFileInfoObserver = new TroopFileUploadFeedsSender.2(this);
  TroopFileReqFeedsObserver jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileReqFeedsObserver = new TroopFileUploadFeedsSender.1(this);
  protected TroopFileTransferManager.Item a;
  public String a;
  public long e;
  
  protected TroopFileUploadFeedsSender(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    this.e = paramLong;
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
    return this.e;
  }
  
  public UUID a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id;
  }
  
  public void j()
  {
    QQAppInterface localQQAppInterface = TroopFileTransferUtil.a();
    if (localQQAppInterface == null)
    {
      TroopFileTransferUtil.Log.a("TroopFileUploadFeedsSender", TroopFileTransferUtil.Log.a, "[" + this.jdField_a_of_type_JavaLangString + "] reqFeedMsgV2 app=null");
      return;
    }
    TroopFileTransferUtil.Log.c("TroopFileUploadFeedsSender", TroopFileTransferUtil.Log.a, "[" + this.jdField_a_of_type_JavaLangString + "] reqFeedMsgV2");
    TroopFileProtocol.a(localQQAppInterface, this.e, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileReqFeedsObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadFeedsSender
 * JD-Core Version:    0.7.0.1
 */