package com.tencent.mobileqq.troop.filemanager.forward;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.biz.troop.file.protocol.TroopFileReqCopyToObserver;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.uftwrapper.QFileTroopTransferWrapper;
import com.tencent.mobileqq.troop.filemanager.TroopFileDataCenter;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadFeedsSender;
import com.tencent.mobileqq.troop.utils.TroopFileError.SimpleErrorInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;

public class TroopFileToTroopForwarder
  extends TroopFileUploadFeedsSender
{
  TroopFileReqCopyToObserver a;
  
  protected TroopFileToTroopForwarder(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    super(paramLong, paramItem);
    this.jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileReqCopyToObserver = new TroopFileToTroopForwarder.1(this);
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
      int i = TroopFileTransferUtil.Log.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getTroop2TroopForwarder. BusId err:");
      localStringBuilder.append(paramItem.BusId);
      TroopFileTransferUtil.Log.a("TroopFileToTroopForwarder", i, localStringBuilder.toString());
      return null;
    }
    if (TextUtils.isEmpty(paramItem.ForwardPath))
    {
      TroopFileTransferUtil.Log.a("TroopFileToTroopForwarder", TroopFileTransferUtil.Log.a, "getTroop2TroopForwarder. ForwardPath=null");
      return null;
    }
    return new TroopFileToTroopForwarder(paramLong, paramItem);
  }
  
  private final void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    paramString2 = TroopFileTransferUtil.a();
    paramInt2 = TroopFileTransferUtil.Log.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("] onFowardToTroopResult isSuccess:true retCode:");
    localStringBuilder.append(paramInt1);
    TroopFileTransferUtil.Log.c("TroopFileToTroopForwarder", paramInt2, localStringBuilder.toString());
    if (paramInt1 < 0)
    {
      if ((paramInt1 != -20001) && (paramInt1 != -20000)) {
        if (paramInt1 != -6101)
        {
          if (paramInt1 != -403)
          {
            if (paramInt1 != -36)
            {
              if (paramInt1 != -30)
              {
                if ((paramInt1 != -25) && (paramInt1 != -22))
                {
                  if ((paramInt1 != -139) && (paramInt1 != -138))
                  {
                    if (paramInt1 != -4)
                    {
                      if (paramInt1 != -3)
                      {
                        paramString1 = paramString3;
                        paramInt1 = 207;
                        break label429;
                      }
                      paramString1 = paramString3;
                      paramInt1 = 202;
                      break label429;
                    }
                    paramString1 = paramString3;
                    paramInt1 = 600;
                    break label429;
                  }
                  paramString1 = paramString3;
                  paramInt1 = -139;
                  break label429;
                }
                paramString1 = paramString3;
                paramInt1 = 701;
                break label429;
              }
              paramString1 = paramString3;
              paramInt1 = 705;
              break label429;
            }
            paramString1 = HardCodeUtil.a(2131715125);
            paramInt1 = 706;
            break label429;
          }
        }
        else
        {
          if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile)) && (new VFSFile(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.LocalFile).exists()))
          {
            paramInt1 = TroopFileTransferUtil.Log.a;
            paramString1 = new StringBuilder();
            paramString1.append("[");
            paramString1.append(this.jdField_a_of_type_JavaLangString);
            paramString1.append("] onFowardToTroopResult: -6101. start local uploadl.");
            TroopFileTransferUtil.Log.b("TroopFileToTroopForwarder", paramInt1, paramString1.toString());
            paramString2.getFileManagerEngine().a().a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, null);
            return;
          }
          paramString1 = paramString3;
          paramInt1 = 603;
          break label429;
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.BusId == 102)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.BusId = 104;
        if (paramString2 != null)
        {
          paramInt1 = TroopFileTransferUtil.Log.a;
          paramString1 = new StringBuilder();
          paramString1.append("[");
          paramString1.append(this.jdField_a_of_type_JavaLangString);
          paramString1.append("] onFowardToTroopResult: space no enough. fowrd temp.");
          TroopFileTransferUtil.Log.b("TroopFileToTroopForwarder", paramInt1, paramString1.toString());
          TroopFileProtocol.a(paramString2, false, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Long, 0L, this.jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileReqCopyToObserver);
          return;
        }
      }
      paramString1 = paramString3;
      paramInt1 = 204;
      label429:
      paramString1 = new TroopFileError.SimpleErrorInfo(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FileName, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ForwardTroopuin, 5, paramInt1, paramString1);
      TroopFileDataCenter.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 5, paramString1);
      if (paramString2 != null)
      {
        paramString1 = paramString2.getFileManagerDataCenter().a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.entrySessionID);
        if (paramString1 != null)
        {
          long l = paramString1.structMsgSeq;
          paramString1 = paramString2.getMessageFacade();
          paramString2 = new StringBuilder();
          paramString2.append("");
          paramString2.append(this.jdField_a_of_type_Long);
          paramString1.b(paramString2.toString(), 1, l);
        }
      }
      else
      {
        paramInt1 = TroopFileTransferUtil.Log.a;
        paramString1 = new StringBuilder();
        paramString1.append("[");
        paramString1.append(this.jdField_a_of_type_JavaLangString);
        paramString1.append("] onFowardToTroopResult fail. removeMsgByUniseq fail.");
        TroopFileTransferUtil.Log.a("TroopFileToTroopForwarder", paramInt1, paramString1.toString());
      }
      return;
    }
    new Handler(Looper.getMainLooper()).post(new TroopFileToTroopForwarder.2(this));
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.FilePath = paramString1;
    paramInt1 = TroopFileTransferUtil.Log.a;
    paramString3 = new StringBuilder();
    paramString3.append("[");
    paramString3.append(this.jdField_a_of_type_JavaLangString);
    paramString3.append("] onFowardToTroopResult sucess. mItem.FilePath:");
    paramString3.append(paramString1);
    TroopFileTransferUtil.Log.c("TroopFileToTroopForwarder", paramInt1, paramString3.toString());
    paramString3 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.getInfo(this.jdField_a_of_type_Long);
    if (paramString3 != null) {
      paramString3.e = paramString1;
    }
    if (paramString2 != null)
    {
      paramString2 = paramString2.getFileManagerDataCenter().a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.entrySessionID);
      if (paramString2 != null) {
        paramString2.strTroopFilePath = paramString1;
      }
    }
    else
    {
      paramInt1 = TroopFileTransferUtil.Log.a;
      paramString1 = new StringBuilder();
      paramString1.append("[");
      paramString1.append(this.jdField_a_of_type_JavaLangString);
      paramString1.append("] onFowardToTroopResult sucess. update entity.strTroopFilePath fail.");
      TroopFileTransferUtil.Log.a("TroopFileToTroopForwarder", paramInt1, paramString1.toString());
    }
    TroopFileDataCenter.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 7, 0);
    a();
  }
  
  private int b()
  {
    Object localObject = TroopFileTransferUtil.a();
    if (localObject == null)
    {
      i = TroopFileTransferUtil.Log.a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append("] startTroop2Troop app=null");
      TroopFileTransferUtil.Log.a("TroopFileToTroopForwarder", i, ((StringBuilder)localObject).toString());
      return -1;
    }
    int i = TroopFileTransferUtil.Log.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("] startTroop2Troop. BusId:");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.BusId);
    localStringBuilder.append(" ForwardBusId:");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ForwardBusId);
    localStringBuilder.append(" ForwardPath:");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.ForwardPath);
    localStringBuilder.append(" entrySessionID:");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.entrySessionID);
    localStringBuilder.append(" with:");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.width);
    localStringBuilder.append(" height:");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item.height);
    TroopFileTransferUtil.Log.c("TroopFileToTroopForwarder", i, localStringBuilder.toString());
    TroopFileProtocol.a((QQAppInterface)localObject, false, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, this.jdField_a_of_type_Long, 0L, this.jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileReqCopyToObserver);
    TroopFileDataCenter.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item, 4, 0);
    return 0;
  }
  
  public int a()
  {
    return b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.forward.TroopFileToTroopForwarder
 * JD-Core Version:    0.7.0.1
 */