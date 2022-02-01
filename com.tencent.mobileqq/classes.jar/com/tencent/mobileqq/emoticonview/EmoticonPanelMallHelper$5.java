package com.tencent.mobileqq.emoticonview;

import java.util.List;

class EmoticonPanelMallHelper$5
  implements Runnable
{
  EmoticonPanelMallHelper$5(EmoticonPanelMallHelper paramEmoticonPanelMallHelper) {}
  
  public void run()
  {
    List localList = ((EmoticonPanelController)this.this$0.mPanelController).getPanelDataList();
    if (localList != null)
    {
      EmotionPanelInfo localEmotionPanelInfo = null;
      int i = 0;
      int j = localList.size();
      while (i < j)
      {
        localEmotionPanelInfo = (EmotionPanelInfo)localList.get(i);
        if ((localEmotionPanelInfo != null) && (localEmotionPanelInfo.type == 9)) {
          break label74;
        }
        i += 1;
      }
      i = -1;
      label74:
      if (i == -1) {
        return;
      }
      if ((BasePanelModel.sLastSelectedSecondTabIndex == i) && (((EmoticonPanelController)this.this$0.mPanelController).getPageAdapter() != null)) {
        ((EmoticonPanelController)this.this$0.mPanelController).getPageAdapter().refreshListViewAdapter(localEmotionPanelInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper.5
 * JD-Core Version:    0.7.0.1
 */