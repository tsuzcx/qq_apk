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
    if (!((EmoticonPanelController)this.this$0.mPanelController).getBasePanelModel().addEmoPkgList.contains(this.val$ep)) {
      ((EmoticonPanelController)this.this$0.mPanelController).getBasePanelModel().addEmoPkgList.add(this.val$ep);
    }
    ((EmoticonPanelController)this.this$0.mPanelController).getBasePanelView().mMarketPgkDownloaded = true;
    ((EmoticonPanelController)this.this$0.mPanelController).getPanel().mSecondTabInited = false;
    if (((EmoticonPanelController)this.this$0.mPanelController).getPanel().getVisibility() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelMallHelper", 2, "refresh magic emoji.");
      }
      ((EmoticonPanelController)this.this$0.mPanelController).switchTabMode(BasePanelModel.sLastSelectedSecondTabIndex);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper.7
 * JD-Core Version:    0.7.0.1
 */