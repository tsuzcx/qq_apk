package com.tencent.mobileqq.emoticonview;

import com.tencent.qphone.base.util.QLog;
import java.util.List;

class EmoticonPanelController$2
  implements EmoticonPanelController.PanelDataCallback
{
  EmoticonPanelController$2(EmoticonPanelController paramEmoticonPanelController, int paramInt, long paramLong) {}
  
  public void callbackInMainThread()
  {
    int j = this.val$originalSelectIndex;
    int i = j;
    if (this.this$0.mMarketPgkDownloaded)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelController", 2, "switchTabMode mMarketPgkDownloaded = true");
      }
      List localList = this.this$0.panelDataList;
      i = j;
      if (localList != null)
      {
        i = j;
        if (localList.size() > 0)
        {
          i = this.this$0.mPanelTabSortHelper.getPkgEndSwitchSelectIndex();
          j = this.this$0.mPanelTabSortHelper.getLastCanSelectedTabIndex();
          if ((j == 0) || (j >= i)) {
            break label129;
          }
          i = j;
        }
      }
    }
    label129:
    for (;;)
    {
      j = this.this$0.findIndexByPanelType(12);
      if (EmoticonPanelController.sLastSelectedSecondTabIndex == j) {
        i = j;
      }
      this.this$0.mMarketPgkDownloaded = false;
      EmoticonPanelController.access$100(this.this$0, this.val$startTime, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelController.2
 * JD-Core Version:    0.7.0.1
 */