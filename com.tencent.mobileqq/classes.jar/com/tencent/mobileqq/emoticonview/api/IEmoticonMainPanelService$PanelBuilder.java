package com.tencent.mobileqq.emoticonview.api;

import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.emoticon.EmotionInjectionInfo;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonListProvider;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;

public abstract interface IEmoticonMainPanelService$PanelBuilder
{
  public abstract PanelBuilder addEmotionInjectionInfo(String paramString, EmotionInjectionInfo paramEmotionInjectionInfo);
  
  public abstract IEmoticonMainPanel create();
  
  public abstract IEmoticonMainPanelApp getEmoticonMainPanelApp();
  
  public abstract PanelBuilder setCallBack(EmoticonCallback paramEmoticonCallback);
  
  public abstract PanelBuilder setDefaultEpId(String paramString);
  
  public abstract PanelBuilder setDefaultPanelType(int paramInt);
  
  public abstract PanelBuilder setDisableAutoDownload(boolean paramBoolean);
  
  public abstract PanelBuilder setDisableGuide(boolean paramBoolean);
  
  public abstract PanelBuilder setDisableGuideOneTime(boolean paramBoolean);
  
  public abstract PanelBuilder setDisableMoreEmotionButton(boolean paramBoolean);
  
  public abstract PanelBuilder setEmoticonListProvider(EmoticonListProvider paramEmoticonListProvider);
  
  public abstract PanelBuilder setFilterSysFaceBeyond255Enable(boolean paramBoolean);
  
  public abstract PanelBuilder setHasBigEmotion(boolean paramBoolean);
  
  public abstract PanelBuilder setHideAllSettingTabs(boolean paramBoolean);
  
  public abstract PanelBuilder setHideEmoSettingBtn();
  
  public abstract PanelBuilder setIsGuildLiveChannel(boolean paramBoolean);
  
  public abstract PanelBuilder setIsOnlySysEmotion(boolean paramBoolean);
  
  public abstract PanelBuilder setKanDianBiu(boolean paramBoolean);
  
  public abstract PanelBuilder setOnlySysAndEmoji(boolean paramBoolean);
  
  public abstract PanelBuilder setPanelInteractionListener(IPanelInteractionListener paramIPanelInteractionListener);
  
  public abstract PanelBuilder setSysEmotionOrder(int[] paramArrayOfInt);
  
  public abstract PanelBuilder setToastOffset(int paramInt);
  
  public abstract PanelBuilder showDescribeInPreview(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService.PanelBuilder
 * JD-Core Version:    0.7.0.1
 */