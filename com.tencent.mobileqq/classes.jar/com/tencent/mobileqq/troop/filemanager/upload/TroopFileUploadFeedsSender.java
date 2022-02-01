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
  protected long a;
  TroopFileGetOneFileInfoObserver jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileGetOneFileInfoObserver = new TroopFileUploadFeedsSender.2(this);
  TroopFileReqFeedsObserver jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileReqFeedsObserver = new TroopFileUploadFeedsSender.1(this);
  protected TroopFileTransferManager.Item a;
  protected String a;
  
  protected TroopFileUploadFeedsSender(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item = paramItem;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id != null) {
      paramItem = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id.toString();
    } else {
      paramItem = "";
    }
    this.jdField_a_of_type_JavaLangString = paramItem;
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
  
  public UUID a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id;
  }
  
  public void a()
  {
    Object localObject = TroopFileTransferUtil.a();
    if (localObject == null)
    {
      i = TroopFileTransferUtil.Log.a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append("] reqFeedMsgV2 app=null");
      TroopFileTransferUtil.Log.a("TroopFileUploadFeedsSender", i, ((StringBuilder)localObject).toString());
      return;
    }
    int i = TroopFileTransferUtil.Log.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("] reqFeedMsgV2");
    TroopFileTransferUtil.Log.c("TroopFileUploadFeedsSender", i, localStringBuilder.toString());
    TroopFileProtocol.a((QQAppInterface)localObject, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileReqFeedsObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadFeedsSender
 * JD-Core Version:    0.7.0.1
 */