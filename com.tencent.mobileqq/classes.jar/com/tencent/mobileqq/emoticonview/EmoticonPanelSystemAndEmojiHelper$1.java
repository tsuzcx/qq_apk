package com.tencent.mobileqq.emoticonview;

import java.util.List;

class EmoticonPanelSystemAndEmojiHelper$1
  implements Runnable
{
  EmoticonPanelSystemAndEmojiHelper$1(EmoticonPanelSystemAndEmojiHelper paramEmoticonPanelSystemAndEmojiHelper) {}
  
  public void run()
  {
    List localList = ((EmoticonPanelController)this.this$0.mPanelController).getPanelDataList();
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        localEmotionPanelInfo = (EmotionPanelInfo)localList.get(i);
        if ((localEmotionPanelInfo != null) && (localEmotionPanelInfo.type == 7)) {
          break label66;
        }
        i += 1;
      }
    }
    EmotionPanelInfo localEmotionPanelInfo = null;
    label66:
    if ((localEmotionPanelInfo != null) && (((EmoticonPanelController)this.this$0.mPanelController).getPageAdapter() != null)) {
      ((EmoticonPanelController)this.this$0.mPanelController).getPageAdapter().refreshListViewAdapter(localEmotionPanelInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelSystemAndEmojiHelper.1
 * JD-Core Version:    0.7.0.1
 */