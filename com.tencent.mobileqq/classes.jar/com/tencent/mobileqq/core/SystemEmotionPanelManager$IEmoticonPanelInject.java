package com.tencent.mobileqq.core;

import com.tencent.mobileqq.emoticonview.IEmoticonInfoSender;
import com.tencent.mobileqq.emoticonview.IEmoticonPanelLinearLayoutHelper;
import com.tencent.mobileqq.emoticonview.adapter.IEmotionAdapterHelper;

public abstract interface SystemEmotionPanelManager$IEmoticonPanelInject
{
  public abstract IEmoticonPanelLinearLayoutHelper createEmoticonPanelLayoutHelper(boolean paramBoolean);
  
  public abstract <T extends IEmotionAdapterHelper> T createEmotionAdapterHelper(int paramInt);
  
  public abstract <T extends IEmoticonInfoSender> T createEmotionInfoSender(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.core.SystemEmotionPanelManager.IEmoticonPanelInject
 * JD-Core Version:    0.7.0.1
 */