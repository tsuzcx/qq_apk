package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.favroaming.SyncListener;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.ipc.proxy.FavroamingManagerProxy;
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
    ReportController.b(this.this$0.mPanelController.app.getQQAppInterface(), "CliOper", "", "", "0X8005CEE", "0X8005CEE", 0, 0, paramInt + "", "", "", "");
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
    if (this.this$0.mPanelController.app != null) {
      ((FavroamingManagerProxy)this.this$0.mPanelController.app.getManager(QQManagerFactory.FAV_ROAMING_MANAGER)).removeSyncListener(this.this$0.sListener);
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