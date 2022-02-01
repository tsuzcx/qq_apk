package com.tencent.mobileqq.emoticonview;

import java.util.List;

class EmoticonPanelMallHelper$5
  implements Runnable
{
  EmoticonPanelMallHelper$5(EmoticonPanelMallHelper paramEmoticonPanelMallHelper) {}
  
  public void run()
  {
    List localList = this.this$0.mPanelController.panelDataList;
    EmotionPanelInfo localEmotionPanelInfo;
    int i;
    if (localList != null)
    {
      localEmotionPanelInfo = null;
      i = 0;
      int j = localList.size();
      if (i >= j) {
        break label107;
      }
      localEmotionPanelInfo = (EmotionPanelInfo)localList.get(i);
      if ((localEmotionPanelInfo == null) || (localEmotionPanelInfo.type != 9)) {
        break label65;
      }
    }
    for (;;)
    {
      if (i == -1) {}
      label65:
      while ((EmoticonPanelController.sLastSelectedSecondTabIndex != i) || (this.this$0.mPanelController.pageAdapter == null))
      {
        return;
        i += 1;
        break;
      }
      this.this$0.mPanelController.pageAdapter.refreshListViewAdapter(localEmotionPanelInfo);
      return;
      label107:
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper.5
 * JD-Core Version:    0.7.0.1
 */