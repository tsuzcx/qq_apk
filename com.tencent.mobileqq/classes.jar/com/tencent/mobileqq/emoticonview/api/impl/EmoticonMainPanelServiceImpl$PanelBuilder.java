package com.tencent.mobileqq.emoticonview.api.impl;

import android.content.Context;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.emoticon.EmotionInjectionInfo;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonListProvider;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel.EmoticonPanelBuilder;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService.PanelBuilder;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import mqq.app.AppRuntime;

class EmoticonMainPanelServiceImpl$PanelBuilder
  implements IEmoticonMainPanelService.PanelBuilder
{
  private EmoticonMainPanel.EmoticonPanelBuilder mBuilder;
  
  public EmoticonMainPanelServiceImpl$PanelBuilder(AppRuntime paramAppRuntime, Context paramContext, int paramInt)
  {
    this.mBuilder = new EmoticonMainPanel.EmoticonPanelBuilder(new QQEmoticonMainPanelApp(paramAppRuntime), paramContext, paramInt);
  }
  
  public IEmoticonMainPanelService.PanelBuilder addEmotionInjectionInfo(String paramString, EmotionInjectionInfo paramEmotionInjectionInfo)
  {
    this.mBuilder.addEmotionInjectionInfo(paramString, paramEmotionInjectionInfo);
    return this;
  }
  
  public IEmoticonMainPanel create()
  {
    return this.mBuilder.create();
  }
  
  public IEmoticonMainPanelApp getEmoticonMainPanelApp()
  {
    return this.mBuilder.getEmoticonMainPanelApp();
  }
  
  public IEmoticonMainPanelService.PanelBuilder setCallBack(EmoticonCallback paramEmoticonCallback)
  {
    this.mBuilder.setCallBack(paramEmoticonCallback);
    return this;
  }
  
  public IEmoticonMainPanelService.PanelBuilder setDefaultEpId(String paramString)
  {
    this.mBuilder.setDefaultEpId(paramString);
    return this;
  }
  
  public IEmoticonMainPanelService.PanelBuilder setDefaultPanelType(int paramInt)
  {
    this.mBuilder.setDefaultPanelType(paramInt);
    return this;
  }
  
  public IEmoticonMainPanelService.PanelBuilder setDisableAutoDownload(boolean paramBoolean)
  {
    this.mBuilder.setDisableAutoDownload(paramBoolean);
    return this;
  }
  
  public IEmoticonMainPanelService.PanelBuilder setDisableGuide(boolean paramBoolean)
  {
    this.mBuilder.setDisableGuide(paramBoolean);
    return this;
  }
  
  public IEmoticonMainPanelService.PanelBuilder setDisableGuideOneTime(boolean paramBoolean)
  {
    this.mBuilder.setDisableGuideOneTime(paramBoolean);
    return this;
  }
  
  public IEmoticonMainPanelService.PanelBuilder setDisableMoreEmotionButton(boolean paramBoolean)
  {
    this.mBuilder.setDisableMoreEmotionButton(paramBoolean);
    return this;
  }
  
  public IEmoticonMainPanelService.PanelBuilder setEmoticonListProvider(EmoticonListProvider paramEmoticonListProvider)
  {
    this.mBuilder.setEmoticonListProvider(paramEmoticonListProvider);
    return this;
  }
  
  public IEmoticonMainPanelService.PanelBuilder setFilterSysFaceBeyond255Enable(boolean paramBoolean)
  {
    this.mBuilder.setFilterSysFaceBeyond255Enable(paramBoolean);
    return this;
  }
  
  public IEmoticonMainPanelService.PanelBuilder setHasBigEmotion(boolean paramBoolean)
  {
    this.mBuilder.setHasBigEmotion(paramBoolean);
    return this;
  }
  
  public IEmoticonMainPanelService.PanelBuilder setHideAllSettingTabs(boolean paramBoolean)
  {
    this.mBuilder.setHideAllSettingTabs(paramBoolean);
    return this;
  }
  
  public IEmoticonMainPanelService.PanelBuilder setHideEmoSettingBtn()
  {
    this.mBuilder.setHideEmoSettingBtn();
    return this;
  }
  
  public IEmoticonMainPanelService.PanelBuilder setIsOnlySysEmotion(boolean paramBoolean)
  {
    this.mBuilder.setIsOnlySysEmotion(paramBoolean);
    return this;
  }
  
  public IEmoticonMainPanelService.PanelBuilder setKanDianBiu(boolean paramBoolean)
  {
    this.mBuilder.setKanDianBiu(paramBoolean);
    return this;
  }
  
  public IEmoticonMainPanelService.PanelBuilder setOnlySysAndEmoji(boolean paramBoolean)
  {
    this.mBuilder.setOnlySysAndEmoji(paramBoolean);
    return this;
  }
  
  public IEmoticonMainPanelService.PanelBuilder setPanelInteractionListener(IPanelInteractionListener paramIPanelInteractionListener)
  {
    this.mBuilder.setPanelInteractionListener(paramIPanelInteractionListener);
    return this;
  }
  
  public IEmoticonMainPanelService.PanelBuilder setSysEmotionOrder(int[] paramArrayOfInt)
  {
    this.mBuilder.setSysEmotionOrder(paramArrayOfInt);
    return this;
  }
  
  public IEmoticonMainPanelService.PanelBuilder setToastOffset(int paramInt)
  {
    this.mBuilder.setToastOffset(paramInt);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.impl.EmoticonMainPanelServiceImpl.PanelBuilder
 * JD-Core Version:    0.7.0.1
 */