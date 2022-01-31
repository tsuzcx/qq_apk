package com.tencent.mobileqq.troop.filemanager.forward;

import ajma;
import ajmb;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.biz.troop.file.TroopFileProtocol.ReqCopyToObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.filemanager.TroopFileDataCenter;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadFeedsSender;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadMgr;
import com.tencent.mobileqq.troop.utils.TroopFileError.SimpleErrorInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.io.File;
import tencent.im.cs.cmd0x383.cmd0x383.ApplyCopyToRspBody;
import tencent.im.cs.cmd0x383.cmd0x383.RspBody;

public class TroopFileToTroopForwarder
  extends TroopFileUploadFeedsSender
{
  TroopFileProtocol.ReqCopyToObserver a;
  
  protected TroopFileToTroopForwarder(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    super(paramLong, paramItem);
    this.jdField_a_of_type_ComTencentBizTroopFileTroopFileProtocol$ReqCopyToObserver = new ajma(this);
  }
  
  public static TroopFileToTroopForwarder a(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    if (paramLong == 0L)
    {
      TroopFileTransferUtil.Log.a("TroopFileToTroopForwarder", TroopFileTransferUtil.Log.a, "getTroop2TroopForwarder. troopuin=0");
      return null;
    }
    if (paramItem == null)
    {
      TroopFileTransferUtil.Log.a("TroopFileToTroopForwarder", TroopFileTransferUtil.Log.a, "getTroop2TroopForwarder. item=null");
      return null;
    }
    if (paramItem.Id == null)
    {
      TroopFileTransferUtil.Log.a("TroopFileToTroopForwarder", TroopFileTransferUtil.Log.a, "getTroop2TroopForwarder. item.id=null");
      return null;
    }
    if (paramItem.ForwardTroopuin == 0L)
    {
      TroopFileTransferUtil.Log.a("TroopFileToTroopForwarder", TroopFileTransferUtil.Log.a, "getTroop2TroopForwarder. ForwardTroopuin=0");
      return null;
    }
    if ((paramItem.BusId != 102) && (paramItem.BusId != 104))
    {
      TroopFileTransferUtil.Log.a("TroopFileToTroopForwarder", TroopFileTransferUtil.Log.a, "getTroop2TroopForwarder. BusId err:" + paramItem.BusId);
      return null;
    }
    if (TextUtils.isEmpty(paramItem.ForwardPath))
    {
      TroopFileTransferUtil.Log.a("TroopFileToTroopForwarder", TroopFileTransferUtil.Log.a, "getTroop2TroopForwarder. ForwardPath=null");
      return null;
    }
    return new TroopFileToTroopForwarder(paramLong, paramItem);
  }
  
  private final void a(cmd0x383.RspBody paramRspBody)
  {
    int j = 204;
    if (paramRspBody == null)
    {
      paramRspBody = new TroopFileError.SimpleErrorInfo(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName, this.jdField_a_of_type_Long, 5, 207);
      TroopFileDataCenter.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 5, paramRspBody);
      return;
    }
    QQAppInterface localQQAppInterface = TroopFileTransferUtil.a();
    int i = paramRspBody.int32_ret_code.get();
    TroopFileTransferUtil.Log.c("TroopFileToTroopForwarder", TroopFileTransferUtil.Log.a, "[" + this.jdField_a_of_type_JavaLangString + "] onFowardToTroopResult isSuccess:true retCode:" + i);
    if (i < 0)
    {
      localObject = paramRspBody.str_client_wording.get();
      switch (i)
      {
      default: 
        i = 207;
        paramRspBody = (cmd0x383.RspBody)localObject;
      }
      for (;;)
      {
        paramRspBody = new TroopFileError.SimpleErrorInfo(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ForwardTroopuin, 5, i, paramRspBody);
        TroopFileDataCenter.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 5, paramRspBody);
        if (localQQAppInterface == null) {
          break label576;
        }
        paramRspBody = localQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.entrySessionID);
        if (paramRspBody == null) {
          break;
        }
        long l = paramRspBody.structMsgSeq;
        localQQAppInterface.a().b("" + this.jdField_a_of_type_Long, 1, l);
        return;
        i = 202;
        paramRspBody = (cmd0x383.RspBody)localObject;
        continue;
        i = 600;
        paramRspBody = (cmd0x383.RspBody)localObject;
        continue;
        i = 701;
        paramRspBody = (cmd0x383.RspBody)localObject;
        continue;
        i = 706;
        paramRspBody = "转发的群仅允许群主和管理员上传文件";
        continue;
        i = j;
        paramRspBody = (cmd0x383.RspBody)localObject;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.BusId == 102)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.BusId = 104;
          i = j;
          paramRspBody = (cmd0x383.RspBody)localObject;
          if (localQQAppInterface != null)
          {
            TroopFileTransferUtil.Log.b("TroopFileToTroopForwarder", TroopFileTransferUtil.Log.a, "[" + this.jdField_a_of_type_JavaLangString + "] onFowardToTroopResult: space no enough. fowrd temp.");
            TroopFileProtocol.a(localQQAppInterface, false, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Long, 0L, this.jdField_a_of_type_ComTencentBizTroopFileTroopFileProtocol$ReqCopyToObserver);
            return;
            i = -139;
            paramRspBody = (cmd0x383.RspBody)localObject;
            continue;
            if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile)) && (new File(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile).exists()))
            {
              TroopFileTransferUtil.Log.b("TroopFileToTroopForwarder", TroopFileTransferUtil.Log.a, "[" + this.jdField_a_of_type_JavaLangString + "] onFowardToTroopResult: -6101. start local uploadl.");
              TroopFileUploadMgr.a().a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, null);
              return;
            }
            i = 603;
            paramRspBody = (cmd0x383.RspBody)localObject;
            continue;
            i = 705;
            paramRspBody = (cmd0x383.RspBody)localObject;
          }
        }
      }
      label576:
      TroopFileTransferUtil.Log.a("TroopFileToTroopForwarder", TroopFileTransferUtil.Log.a, "[" + this.jdField_a_of_type_JavaLangString + "] onFowardToTroopResult fail. removeMsgByUniseq fail.");
      return;
    }
    new Handler(Looper.getMainLooper()).post(new ajmb(this));
    paramRspBody = ((cmd0x383.ApplyCopyToRspBody)paramRspBody.msg_copy_to_rsp_body.get()).str_save_file_path.get();
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath = paramRspBody;
    TroopFileTransferUtil.Log.c("TroopFileToTroopForwarder", TroopFileTransferUtil.Log.a, "[" + this.jdField_a_of_type_JavaLangString + "] onFowardToTroopResult sucess. mItem.FilePath:" + paramRspBody);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.getInfo(this.jdField_a_of_type_Long);
    if (localObject != null) {
      ((TroopFileStatusInfo)localObject).e = paramRspBody;
    }
    if (localQQAppInterface != null)
    {
      localObject = localQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.entrySessionID);
      if (localObject != null) {
        ((FileManagerEntity)localObject).strTroopFilePath = paramRspBody;
      }
    }
    for (;;)
    {
      TroopFileDataCenter.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 7, 0);
      a();
      return;
      TroopFileTransferUtil.Log.a("TroopFileToTroopForwarder", TroopFileTransferUtil.Log.a, "[" + this.jdField_a_of_type_JavaLangString + "] onFowardToTroopResult sucess. update entity.strTroopFilePath fail.");
    }
  }
  
  private int b()
  {
    QQAppInterface localQQAppInterface = TroopFileTransferUtil.a();
    if (localQQAppInterface == null)
    {
      TroopFileTransferUtil.Log.a("TroopFileToTroopForwarder", TroopFileTransferUtil.Log.a, "[" + this.jdField_a_of_type_JavaLangString + "] startTroop2Troop app=null");
      return -1;
    }
    TroopFileTransferUtil.Log.c("TroopFileToTroopForwarder", TroopFileTransferUtil.Log.a, "[" + this.jdField_a_of_type_JavaLangString + "] startTroop2Troop. BusId:" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.BusId + " ForwardBusId:" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ForwardBusId + " ForwardPath:" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ForwardPath + " entrySessionID:" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.entrySessionID + " with:" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.width + " height:" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.height);
    TroopFileProtocol.a(localQQAppInterface, false, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Long, 0L, this.jdField_a_of_type_ComTencentBizTroopFileTroopFileProtocol$ReqCopyToObserver);
    TroopFileDataCenter.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 4, 0);
    return 0;
  }
  
  public int a()
  {
    return b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.forward.TroopFileToTroopForwarder
 * JD-Core Version:    0.7.0.1
 */