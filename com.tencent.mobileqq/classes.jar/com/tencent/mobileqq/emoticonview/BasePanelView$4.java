package com.tencent.mobileqq.emoticonview;

import com.tencent.qphone.base.util.QLog;
import java.util.List;

class BasePanelView$4
  implements EmoticonPanelController.PanelDataCallback
{
  BasePanelView$4(BasePanelView paramBasePanelView, int paramInt, long paramLong) {}
  
  public void callbackInMainThread()
  {
    int j = this.val$originalSelectIndex;
    int i = j;
    if (this.this$0.mMarketPgkDownloaded)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BasePanelView", 2, "switchTabMode mMarketPgkDownloaded = true");
      }
      List localList = BasePanelView.access$000(this.this$0).getPanelDataList();
      i = j;
      if (localList != null)
      {
        i = j;
        if (localList.size() > 0)
        {
          j = BasePanelView.access$000(this.this$0).mPanelTabSortHelper.getPkgEndSwitchSelectIndex();
          int k = BasePanelView.access$000(this.this$0).mPanelTabSortHelper.getLastCanSelectedTabIndex();
          i = j;
          if (k != 0)
          {
            i = j;
            if (k < j) {
              i = k;
            }
          }
          j = BasePanelView.access$000(this.this$0).findIndexByPanelType(12);
          if (BasePanelModel.sLastSelectedSecondTabIndex == j) {
            i = j;
          }
        }
      }
      this.this$0.mMarketPgkDownloaded = false;
    }
    BasePanelView.access$100(this.this$0, this.val$startTime, i, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.BasePanelView.4
 * JD-Core Version:    0.7.0.1
 */