package com.tencent.mobileqq.emoticonview;

import java.util.List;

class EmoticonMainPanel$DefaultEmoticonListProvider
  implements EmoticonListProvider
{
  private EmoticonMainPanel$DefaultEmoticonListProvider(EmoticonMainPanel paramEmoticonMainPanel) {}
  
  public List<EmotionPanelInfo> getEmotionPanelInfo(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean2) || (EmoticonMainPanel.access$100(this.this$0).mParams.mIsOnlySysEmotion)) {
      return EmoticonUtils.getNonBigAndFavEmotionPanelData(EmoticonMainPanel.access$100(this.this$0).app);
    }
    if (!paramBoolean1) {
      return EmoticonUtils.getNonBigEmotionPanelData(EmoticonMainPanel.access$100(this.this$0).app);
    }
    return EmoticonUtils.getAllEmotionPanelData(EmoticonMainPanel.access$100(this.this$0).app, EmoticonMainPanel.access$100(this.this$0).businessType, EmoticonMainPanel.access$100(this.this$0).kanDianBiu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonMainPanel.DefaultEmoticonListProvider
 * JD-Core Version:    0.7.0.1
 */