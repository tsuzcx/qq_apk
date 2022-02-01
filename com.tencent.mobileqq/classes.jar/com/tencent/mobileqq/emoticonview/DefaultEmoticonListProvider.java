package com.tencent.mobileqq.emoticonview;

import java.util.List;

public class DefaultEmoticonListProvider
  implements EmoticonListProvider
{
  private EmoticonPanelController mController;
  
  public DefaultEmoticonListProvider(EmoticonPanelController paramEmoticonPanelController)
  {
    this.mController = paramEmoticonPanelController;
  }
  
  public List<EmotionPanelInfo> getEmotionPanelInfo(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean2) && (!this.mController.getParams().mIsOnlySysEmotion))
    {
      if (!paramBoolean1) {
        return EmoticonUtils.getNonBigEmotionPanelData(this.mController.app, this.mController.getEmotionPanelManager());
      }
      return EmoticonUtils.getAllEmotionPanelData(this.mController.app, this.mController.getEmotionPanelManager(), this.mController.getBusinessType(), this.mController.getKanDianBiu());
    }
    return EmoticonUtils.getNonBigAndFavEmotionPanelData(this.mController.app);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.DefaultEmoticonListProvider
 * JD-Core Version:    0.7.0.1
 */