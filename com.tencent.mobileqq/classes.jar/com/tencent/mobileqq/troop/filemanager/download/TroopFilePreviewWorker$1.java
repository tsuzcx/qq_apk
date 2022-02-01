package com.tencent.mobileqq.troop.filemanager.download;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.file.protocol.TroopFileReqDownloadFileObserver;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.PreviewInfo;
import com.tencent.mobileqq.utils.HexUtil;
import java.util.UUID;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.DownloadFileRspBody;

class TroopFilePreviewWorker$1
  extends TroopFileReqDownloadFileObserver
{
  TroopFilePreviewWorker$1(TroopFilePreviewWorker paramTroopFilePreviewWorker) {}
  
  public void a(boolean paramBoolean, int paramInt, oidb_0x6d6.DownloadFileRspBody paramDownloadFileRspBody, Bundle paramBundle)
  {
    if (!paramBundle.getBoolean("isPreview", false)) {}
    do
    {
      do
      {
        return;
      } while (paramBundle.getLong("troopUin") != this.a.jdField_a_of_type_Long);
      paramBundle = paramBundle.getString("itemKey");
    } while ((paramBundle == null) || (!UUID.fromString(paramBundle).equals(this.a.a())));
    TroopFileTransferManager.PreviewInfo localPreviewInfo = new TroopFileTransferManager.PreviewInfo();
    localPreviewInfo.jdField_a_of_type_Int = -1;
    try
    {
      localPreviewInfo.e = this.a.a().toString();
      localQQAppInterface = TroopFileTransferUtil.a();
      if (localQQAppInterface == null)
      {
        TroopFileTransferUtil.Log.a("TroopFilePreviewWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] getPreviewInfoResult app=null");
        return;
      }
    }
    catch (NullPointerException paramBundle)
    {
      QQAppInterface localQQAppInterface;
      for (;;)
      {
        localPreviewInfo.e = null;
      }
      BizTroopHandler localBizTroopHandler = (BizTroopHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BIZ_TROOP_HANDLER);
      if ((paramDownloadFileRspBody == null) || (!paramBoolean))
      {
        TroopFileTransferUtil.Log.a("TroopFilePreviewWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] getPreviewInfoResult isSuccess:false  errCode:" + paramInt);
        TroopFileError.a(localQQAppInterface, this.a.jdField_a_of_type_Long, 700);
        localPreviewInfo.jdField_a_of_type_Boolean = false;
        localBizTroopHandler.c(localPreviewInfo);
        return;
      }
      paramInt = paramDownloadFileRspBody.int32_ret_code.get();
      localPreviewInfo.jdField_a_of_type_Int = paramInt;
      localPreviewInfo.jdField_a_of_type_Boolean = false;
      String str = paramDownloadFileRspBody.str_download_ip.get();
      paramBundle = "";
      if (paramDownloadFileRspBody.str_download_dns.get() != null) {
        paramBundle = paramDownloadFileRspBody.str_download_dns.get().toString();
      }
      localPreviewInfo.jdField_a_of_type_JavaLangString = str;
      if ((TextUtils.isEmpty(localPreviewInfo.jdField_a_of_type_JavaLangString)) || (localPreviewInfo.jdField_a_of_type_JavaLangString.equals("0.0.0.0"))) {
        localPreviewInfo.jdField_a_of_type_JavaLangString = paramBundle;
      }
      localPreviewInfo.b = String.valueOf(paramDownloadFileRspBody.uint32_preview_port.get());
      localPreviewInfo.c = paramDownloadFileRspBody.str_ret_msg.get();
      localPreviewInfo.d = HexUtil.bytes2HexStr(paramDownloadFileRspBody.bytes_download_url.get().toByteArray());
      localPreviewInfo.f = paramBundle;
      if (paramInt < 0)
      {
        TroopFileTransferUtil.Log.a("TroopFilePreviewWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] getPreviewInfoResult fail. retCode:" + paramInt + " retMsg:" + localPreviewInfo.c);
        TroopFileError.a(localQQAppInterface, this.a.jdField_a_of_type_Long, 700);
        if (TextUtils.isEmpty(localPreviewInfo.c)) {
          localPreviewInfo.c = HardCodeUtil.a(2131715205);
        }
        localPreviewInfo.jdField_a_of_type_Boolean = false;
        localBizTroopHandler.c(localPreviewInfo);
        return;
      }
      TroopFileTransferUtil.Log.c("TroopFilePreviewWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.a.jdField_a_of_type_JavaLangString + "] getPreviewInfoResult isSuccess:true  downloadip:" + str + " downloadDns:" + paramBundle + " port:" + localPreviewInfo.b + " downloadKey:" + localPreviewInfo.d + " retMsg:" + localPreviewInfo.c + " httpsDomain:" + localPreviewInfo.f);
      localPreviewInfo.jdField_a_of_type_Boolean = true;
      localBizTroopHandler.c(localPreviewInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.download.TroopFilePreviewWorker.1
 * JD-Core Version:    0.7.0.1
 */