package com.tencent.mobileqq.troop.filemanager.download;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.file.protocol.TroopFileReqDownloadFileObserver;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopFileHandler;
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
    if (!paramBundle.getBoolean("isPreview", false)) {
      return;
    }
    if (paramBundle.getLong("troopUin") != this.a.jdField_a_of_type_Long) {
      return;
    }
    paramBundle = paramBundle.getString("itemKey");
    if (paramBundle == null) {
      return;
    }
    if (!UUID.fromString(paramBundle).equals(this.a.a())) {
      return;
    }
    TroopFileTransferManager.PreviewInfo localPreviewInfo = new TroopFileTransferManager.PreviewInfo();
    localPreviewInfo.jdField_a_of_type_Int = -1;
    try
    {
      localPreviewInfo.e = this.a.a().toString();
    }
    catch (NullPointerException paramBundle)
    {
      label98:
      QQAppInterface localQQAppInterface;
      TroopFileHandler localTroopFileHandler;
      String str;
      int i;
      break label98;
    }
    localPreviewInfo.e = null;
    localQQAppInterface = TroopFileTransferUtil.a();
    if (localQQAppInterface == null)
    {
      paramInt = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
      paramDownloadFileRspBody = new StringBuilder();
      paramDownloadFileRspBody.append("[");
      paramDownloadFileRspBody.append(this.a.jdField_a_of_type_JavaLangString);
      paramDownloadFileRspBody.append("] getPreviewInfoResult app=null");
      TroopFileTransferUtil.Log.a("TroopFilePreviewWorker", paramInt, paramDownloadFileRspBody.toString());
      return;
    }
    localTroopFileHandler = (TroopFileHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_FILE_HANDLER);
    if ((paramDownloadFileRspBody != null) && (paramBoolean))
    {
      paramInt = paramDownloadFileRspBody.int32_ret_code.get();
      localPreviewInfo.jdField_a_of_type_Int = paramInt;
      localPreviewInfo.jdField_a_of_type_Boolean = false;
      str = paramDownloadFileRspBody.str_download_ip.get();
      if (paramDownloadFileRspBody.str_download_dns.get() != null) {
        paramBundle = paramDownloadFileRspBody.str_download_dns.get().toString();
      } else {
        paramBundle = "";
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
        i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
        paramDownloadFileRspBody = new StringBuilder();
        paramDownloadFileRspBody.append("[");
        paramDownloadFileRspBody.append(this.a.jdField_a_of_type_JavaLangString);
        paramDownloadFileRspBody.append("] getPreviewInfoResult fail. retCode:");
        paramDownloadFileRspBody.append(paramInt);
        paramDownloadFileRspBody.append(" retMsg:");
        paramDownloadFileRspBody.append(localPreviewInfo.c);
        TroopFileTransferUtil.Log.a("TroopFilePreviewWorker", i, paramDownloadFileRspBody.toString());
        TroopFileError.a(localQQAppInterface, this.a.jdField_a_of_type_Long, 700);
        if (TextUtils.isEmpty(localPreviewInfo.c)) {
          localPreviewInfo.c = HardCodeUtil.a(2131715128);
        }
        localPreviewInfo.jdField_a_of_type_Boolean = false;
        localTroopFileHandler.c(localPreviewInfo);
        return;
      }
      paramInt = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
      paramDownloadFileRspBody = new StringBuilder();
      paramDownloadFileRspBody.append("[");
      paramDownloadFileRspBody.append(this.a.jdField_a_of_type_JavaLangString);
      paramDownloadFileRspBody.append("] getPreviewInfoResult isSuccess:true  downloadip:");
      paramDownloadFileRspBody.append(str);
      paramDownloadFileRspBody.append(" downloadDns:");
      paramDownloadFileRspBody.append(paramBundle);
      paramDownloadFileRspBody.append(" port:");
      paramDownloadFileRspBody.append(localPreviewInfo.b);
      paramDownloadFileRspBody.append(" downloadKey:");
      paramDownloadFileRspBody.append(localPreviewInfo.d);
      paramDownloadFileRspBody.append(" retMsg:");
      paramDownloadFileRspBody.append(localPreviewInfo.c);
      paramDownloadFileRspBody.append(" httpsDomain:");
      paramDownloadFileRspBody.append(localPreviewInfo.f);
      TroopFileTransferUtil.Log.c("TroopFilePreviewWorker", paramInt, paramDownloadFileRspBody.toString());
      localPreviewInfo.jdField_a_of_type_Boolean = true;
      localTroopFileHandler.c(localPreviewInfo);
      return;
    }
    i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
    paramDownloadFileRspBody = new StringBuilder();
    paramDownloadFileRspBody.append("[");
    paramDownloadFileRspBody.append(this.a.jdField_a_of_type_JavaLangString);
    paramDownloadFileRspBody.append("] getPreviewInfoResult isSuccess:false  errCode:");
    paramDownloadFileRspBody.append(paramInt);
    TroopFileTransferUtil.Log.a("TroopFilePreviewWorker", i, paramDownloadFileRspBody.toString());
    TroopFileError.a(localQQAppInterface, this.a.jdField_a_of_type_Long, 700);
    localPreviewInfo.jdField_a_of_type_Boolean = false;
    localTroopFileHandler.c(localPreviewInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.download.TroopFilePreviewWorker.1
 * JD-Core Version:    0.7.0.1
 */