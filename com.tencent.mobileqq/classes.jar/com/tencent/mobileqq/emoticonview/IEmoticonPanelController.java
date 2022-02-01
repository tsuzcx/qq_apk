package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.emoticon.EmotionInjectionInfo;
import com.tencent.mobileqq.qqemoticon.api.IPanelController;
import java.util.List;

public abstract interface IEmoticonPanelController
  extends IPanelController
{
  public abstract int findIndexByPanelType(int paramInt);
  
  public abstract BaseAIOContext getAIOContext();
  
  public abstract EmotionInjectionInfo getEmotionInjectionInfo(int paramInt);
  
  public abstract <T extends AbstractEmoticonPanelHelper> T getHelper(int paramInt);
  
  public abstract List<EmotionPanelInfo> getPanelDataList();
  
  public abstract boolean isEmoticonOnShow(int paramInt);
  
  public abstract boolean isPanelOpen();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.IEmoticonPanelController
 * JD-Core Version:    0.7.0.1
 */