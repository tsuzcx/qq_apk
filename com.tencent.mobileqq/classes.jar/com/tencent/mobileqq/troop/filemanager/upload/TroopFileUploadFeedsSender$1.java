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
    if (!paramBoolean) {
      return;
    }
    paramString = paramBundle.getString("itemKey");
    if (paramString == null) {
      return;
    }
    paramString = UUID.fromString(paramString);
    if (!paramString.equals(this.a.a())) {
      return;
    }
    paramInt2 = TroopFileTransferUtil.Log.a;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(this.a.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append("] onReqFeedsResult retCode:");
    ((StringBuilder)localObject).append(paramInt1);
    TroopFileTransferUtil.Log.c("TroopFileUploadFeedsSender", paramInt2, ((StringBuilder)localObject).toString());
    paramBundle = paramBundle.getString("fileId");
    localObject = TroopFileTransferUtil.a(this.a.jdField_a_of_type_Long);
    if (localObject == null)
    {
      paramInt1 = TroopFileTransferUtil.Log.a;
      paramString = new StringBuilder();
      paramString.append("[");
      paramString.append(this.a.jdField_a_of_type_JavaLangString);
      paramString.append("] onReqFeedsResult getTroopFileMgr()=null");
      TroopFileTransferUtil.Log.a("TroopFileUploadFeedsSender", paramInt1, paramString.toString());
      return;
    }
    paramString = ((TroopFileManager)localObject).a(paramString);
    if (paramString == null)
    {
      paramInt1 = TroopFileTransferUtil.Log.a;
      paramString = new StringBuilder();
      paramString.append("[");
      paramString.append(this.a.jdField_a_of_type_JavaLangString);
      paramString.append("] onReqFeedsResult getFileInfo()=null");
      TroopFileTransferUtil.Log.a("TroopFileUploadFeedsSender", paramInt1, paramString.toString());
      return;
    }
    if (paramInt1 == 0)
    {
      paramInt1 = TroopFileTransferUtil.Log.a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.a.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append("] onReqFeedsResult refreshOneFile");
      TroopFileTransferUtil.Log.c("TroopFileUploadFeedsSender", paramInt1, ((StringBuilder)localObject).toString());
      TroopFileProtocol.a(TroopFileTransferUtil.a(), this.a.jdField_a_of_type_Long, paramString.a, paramString.b, this.a.jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileGetOneFileInfoObserver);
      ThreadManager.executeOnSubThread(new TroopFileUploadFeedsSender.1.1(this, paramBundle, paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadFeedsSender.1
 * JD-Core Version:    0.7.0.1
 */