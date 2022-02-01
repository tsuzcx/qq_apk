package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class EmoticonPanelMallHelper$7
  implements Runnable
{
  EmoticonPanelMallHelper$7(EmoticonPanelMallHelper paramEmoticonPanelMallHelper, EmoticonPackage paramEmoticonPackage) {}
  
  public void run()
  {
    if (!this.this$0.mPanelController.addEmoPkgList.contains(this.val$ep)) {
      this.this$0.mPanelController.addEmoPkgList.add(this.val$ep);
    }
    this.this$0.mPanelController.mMarketPgkDownloaded = true;
    this.this$0.mPanelController.getPanel().mSecondTabInited = false;
    if (this.this$0.mPanelController.getPanel().getVisibility() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelMallHelper", 2, "refresh magic emoji.");
      }
      this.this$0.mPanelController.switchTabMode(EmoticonPanelController.sLastSelectedSecondTabIndex);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper.7
 * JD-Core Version:    0.7.0.1
 */