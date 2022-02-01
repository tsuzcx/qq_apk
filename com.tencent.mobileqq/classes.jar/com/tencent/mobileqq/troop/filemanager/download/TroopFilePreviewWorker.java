package com.tencent.mobileqq.troop.filemanager.download;

import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.biz.troop.file.protocol.TroopFileReqDownloadFileObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.ITroopFileProtoReq;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.UUID;

public class TroopFilePreviewWorker
{
  protected long a;
  TroopFileReqDownloadFileObserver a;
  protected ITroopFileProtoReq a;
  protected TroopFileTransferManager.Item a;
  protected String a;
  
  private TroopFilePreviewWorker(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    this.jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileReqDownloadFileObserver = new TroopFilePreviewWorker.1(this);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item = paramItem;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id != null) {
      paramItem = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id.toString();
    } else {
      paramItem = "";
    }
    this.jdField_a_of_type_JavaLangString = paramItem;
  }
  
  public static TroopFilePreviewWorker a(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    if (paramLong == 0L)
    {
      TroopFileTransferUtil.Log.a("TroopFilePreviewWorker", TroopFileTransferUtil.Log.a, "getWoker. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      TroopFileTransferUtil.Log.a("TroopFilePreviewWorker", TroopFileTransferUtil.Log.a, "getWoker. item=null");
      return null;
    }
    if (paramItem.Id == null)
    {
      TroopFileTransferUtil.Log.a("TroopFilePreviewWorker", TroopFileTransferUtil.Log.a, "getWoker. item.id=null");
      return null;
    }
    return new TroopFilePreviewWorker(paramLong, paramItem);
  }
  
  public UUID a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id;
  }
  
  public boolean a()
  {
    Object localObject = TroopFileTransferUtil.a();
    if (localObject == null)
    {
      i = TroopFileTransferUtil.Log.a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append("] getPreviewInfo app=null");
      TroopFileTransferUtil.Log.a("TroopFilePreviewWorker", i, ((StringBuilder)localObject).toString());
      return false;
    }
    int i = TroopFileTransferUtil.Log.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("] getPreviewInfo");
    TroopFileTransferUtil.Log.c("TroopFilePreviewWorker", i, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiITroopFileProtoReq = TroopFileProtocol.a((QQAppInterface)localObject, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 0, true, false, this.jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileReqDownloadFileObserver);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.download.TroopFilePreviewWorker
 * JD-Core Version:    0.7.0.1
 */