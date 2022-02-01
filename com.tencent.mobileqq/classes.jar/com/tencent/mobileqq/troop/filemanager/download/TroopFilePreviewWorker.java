package com.tencent.mobileqq.troop.filemanager.download;

import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.biz.troop.file.protocol.TroopFileReqDownloadFileObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.filemanager.TroopFileProtoReqMgr.ProtoRequest;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.UUID;

public class TroopFilePreviewWorker
{
  protected long a;
  TroopFileReqDownloadFileObserver a;
  protected TroopFileProtoReqMgr.ProtoRequest a;
  protected TroopFileTransferManager.Item a;
  protected String a;
  
  private TroopFilePreviewWorker(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    this.jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileReqDownloadFileObserver = new TroopFilePreviewWorker.1(this);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item = paramItem;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id != null) {}
    for (paramItem = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.Id.toString();; paramItem = "")
    {
      this.jdField_a_of_type_JavaLangString = paramItem;
      return;
    }
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
    QQAppInterface localQQAppInterface = TroopFileTransferUtil.a();
    if (localQQAppInterface == null)
    {
      TroopFileTransferUtil.Log.a("TroopFilePreviewWorker", TroopFileTransferUtil.Log.a, "[" + this.jdField_a_of_type_JavaLangString + "] getPreviewInfo app=null");
      return false;
    }
    TroopFileTransferUtil.Log.c("TroopFilePreviewWorker", TroopFileTransferUtil.Log.a, "[" + this.jdField_a_of_type_JavaLangString + "] getPreviewInfo");
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequest = TroopFileProtocol.a(localQQAppInterface, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 0, true, false, this.jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileReqDownloadFileObserver);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.download.TroopFilePreviewWorker
 * JD-Core Version:    0.7.0.1
 */