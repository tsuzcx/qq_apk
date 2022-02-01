package com.tencent.mobileqq.download.unite.util;

import android.os.Bundle;
import eipc.EIPCResult;

class UniteDownloadIPCModule$1
  implements UniteDownloadUtil.DownloadDialogListener
{
  UniteDownloadIPCModule$1(UniteDownloadIPCModule paramUniteDownloadIPCModule, int paramInt) {}
  
  public void a(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("result", paramInt);
    this.jdField_a_of_type_ComTencentMobileqqDownloadUniteUtilUniteDownloadIPCModule.callbackResult(this.jdField_a_of_type_Int, EIPCResult.createResult(0, localBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.download.unite.util.UniteDownloadIPCModule.1
 * JD-Core Version:    0.7.0.1
 */