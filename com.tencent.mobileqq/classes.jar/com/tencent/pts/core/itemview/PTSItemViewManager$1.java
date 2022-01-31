package com.tencent.pts.core.itemview;

import com.tencent.pts.core.PTSAppInstance;

class PTSItemViewManager$1
  implements Runnable
{
  PTSItemViewManager$1(PTSItemViewManager paramPTSItemViewManager, PTSItemData paramPTSItemData, PTSAppInstance paramPTSAppInstance) {}
  
  public void run()
  {
    if (!this.val$itemData.equals(this.val$appInstanceTemp.getItemData())) {
      this.val$appInstanceTemp.setItemData(this.val$itemData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pts.core.itemview.PTSItemViewManager.1
 * JD-Core Version:    0.7.0.1
 */