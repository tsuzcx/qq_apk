package com.tencent.mobileqq.emoticonview;

import java.util.List;

class EmoticonPanelSystemAndEmojiHelper$1
  implements Runnable
{
  EmoticonPanelSystemAndEmojiHelper$1(EmoticonPanelSystemAndEmojiHelper paramEmoticonPanelSystemAndEmojiHelper) {}
  
  public void run()
  {
    List localList = this.this$0.mPanelController.panelDataList;
    int i;
    EmotionPanelInfo localEmotionPanelInfo;
    if (localList != null)
    {
      i = 0;
      if (i < localList.size())
      {
        localEmotionPanelInfo = (EmotionPanelInfo)localList.get(i);
        if ((localEmotionPanelInfo == null) || (localEmotionPanelInfo.type != 7)) {}
      }
    }
    for (;;)
    {
      if ((localEmotionPanelInfo != null) && (this.this$0.mPanelController.pageAdapter != null)) {
        this.this$0.mPanelController.pageAdapter.refreshListViewAdapter(localEmotionPanelInfo);
      }
      return;
      i += 1;
      break;
      localEmotionPanelInfo = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelSystemAndEmojiHelper.1
 * JD-Core Version:    0.7.0.1
 */