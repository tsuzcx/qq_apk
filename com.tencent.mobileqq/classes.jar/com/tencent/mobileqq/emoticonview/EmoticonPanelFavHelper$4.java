package com.tencent.mobileqq.emoticonview;

import arbb;
import arbj;
import bcef;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.qphone.base.util.QLog;

class EmoticonPanelFavHelper$4
  extends arbj<CustomEmotionData>
{
  EmoticonPanelFavHelper$4(EmoticonPanelFavHelper paramEmoticonPanelFavHelper) {}
  
  public void onDownloadFinish(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelFavHelper", 2, "download_finish");
    }
    this.this$0.updateFavEmoticonPanel();
    bcef.b(this.this$0.mPanelController.app, "CliOper", "", "", "0X8005CEE", "0X8005CEE", 0, 0, paramInt + "", "", "", "");
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
      ((arbb)this.this$0.mPanelController.app.getManager(103)).b(this.this$0.sListener);
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