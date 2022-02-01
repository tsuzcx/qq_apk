package com.tencent.mobileqq.troop.filemanager.upload;

import android.os.Bundle;
import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.biz.troop.file.protocol.TroopFileReqFeedsObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import java.util.UUID;

class TroopFileUploadFeedsSender$1
  extends TroopFileReqFeedsObserver
{
  TroopFileUploadFeedsSender$1(TroopFileUploadFeedsSender paramTroopFileUploadFeedsSender) {}
  
  public void a(boolean paramBoolean, int paramInt1, String paramString, int paramInt2, int paramInt3, Bundle paramBundle)
  {
    if (!paramBoolean) {}
    do
    {
      do
      {
        do
        {
          return;
          paramString = paramBundle.getString("itemKey");
        } while (paramString == null);
        paramString = UUID.fromString(paramString);
      } while (!paramString.equals(this.a.a()));
      TroopFileTransferUtil.Log.c("TroopFileUploadFeedsSender", TroopFileTransferUtil.Log.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqFeedsResult retCode:" + paramInt1);
      paramBundle = paramBundle.getString("fileId");
      TroopFileManager localTroopFileManager = TroopFileTransferUtil.a(this.a.e);
      if (localTroopFileManager == null)
      {
        TroopFileTransferUtil.Log.a("TroopFileUploadFeedsSender", TroopFileTransferUtil.Log.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqFeedsResult getTroopFileMgr()=null");
        return;
      }
      paramString = localTroopFileManager.a(paramString);
      if (paramString == null)
      {
        TroopFileTransferUtil.Log.a("TroopFileUploadFeedsSender", TroopFileTransferUtil.Log.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqFeedsResult getFileInfo()=null");
        return;
      }
    } while (paramInt1 != 0);
    TroopFileTransferUtil.Log.c("TroopFileUploadFeedsSender", TroopFileTransferUtil.Log.a, "[" + this.a.jdField_a_of_type_JavaLangString + "] onReqFeedsResult refreshOneFile");
    TroopFileProtocol.a(TroopFileTransferUtil.a(), this.a.e, paramString.a, paramString.b, this.a.jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileGetOneFileInfoObserver);
    ThreadManager.executeOnSubThread(new TroopFileUploadFeedsSender.1.1(this, paramBundle, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadFeedsSender.1
 * JD-Core Version:    0.7.0.1
 */