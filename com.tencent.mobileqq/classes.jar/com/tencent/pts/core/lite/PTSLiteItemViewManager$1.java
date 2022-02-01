package com.tencent.pts.core.lite;

import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.core.itemview.PTSItemData;

class PTSLiteItemViewManager$1
  implements Runnable
{
  PTSLiteItemViewManager$1(PTSLiteItemViewManager paramPTSLiteItemViewManager, PTSItemData paramPTSItemData, PTSAppInstance paramPTSAppInstance) {}
  
  public void run()
  {
    if (!this.val$itemData.equals(this.val$appInstanceTemp.getItemData())) {
      this.val$appInstanceTemp.setItemData(this.val$itemData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pts.core.lite.PTSLiteItemViewManager.1
 * JD-Core Version:    0.7.0.1
 */