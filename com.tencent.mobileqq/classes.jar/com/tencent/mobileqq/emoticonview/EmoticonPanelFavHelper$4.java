package com.tencent.mobileqq.emoticonview;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.emosm.favroaming.SyncListener;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.FavroamingManagerServiceProxy;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class EmoticonPanelFavHelper$4
  extends SyncListener<CustomEmotionData>
{
  EmoticonPanelFavHelper$4(EmoticonPanelFavHelper paramEmoticonPanelFavHelper) {}
  
  public void onDownloadFinish(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelFavHelper", 2, "download_finish");
    }
    this.this$0.updateFavEmoticonPanel();
    BaseQQAppInterface localBaseQQAppInterface = ((EmoticonPanelController)this.this$0.mPanelController).app.getQQAppInterface();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    ReportController.b(localBaseQQAppInterface, "CliOper", "", "", "0X8005CEE", "0X8005CEE", 0, 0, localStringBuilder.toString(), "", "", "");
  }
  
  public void onFileDone(CustomEmotionData paramCustomEmotionData, int paramInt1, int paramInt2)
  {
    this.this$0.updateFavEmoticonPanel();
  }
  
  public void onSyncFinish()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelFavHelper", 2, "roaming_finish");
    }
    if (((EmoticonPanelController)this.this$0.mPanelController).app != null) {
      ((FavroamingManagerServiceProxy)((EmoticonPanelController)this.this$0.mPanelController).app.getRuntimeService(IFavroamingManagerService.class)).removeSyncListener(this.this$0.sListener);
    }
    this.this$0.updateFavEmoticonPanel();
  }
  
  public void onUploadFinish()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelFavHelper", 2, "upload_finish");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelFavHelper.4
 * JD-Core Version:    0.7.0.1
 */