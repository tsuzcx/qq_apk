package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.EmotionPanelInjectionInfoManager;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.config.business.EmoticonTabSortConfMapping;
import com.tencent.mobileqq.emoticon.EmotionInjectionInfo;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.view.IBasePanelView;

public class EmoticonMainPanel$EmoticonPanelBuilder
{
  private final EmoticonPanelParams mPanelParams;
  
  public EmoticonMainPanel$EmoticonPanelBuilder(QQEmoticonMainPanelApp paramQQEmoticonMainPanelApp, Context paramContext, int paramInt)
  {
    this.mPanelParams = new EmoticonPanelParams();
    EmoticonPanelParams localEmoticonPanelParams = this.mPanelParams;
    localEmoticonPanelParams.app = paramQQEmoticonMainPanelApp;
    localEmoticonPanelParams.context = paramContext;
    localEmoticonPanelParams.sessionType = paramInt;
  }
  
  EmoticonMainPanel$EmoticonPanelBuilder(IBasePanelView paramIBasePanelView, QQEmoticonMainPanelApp paramQQEmoticonMainPanelApp, int paramInt)
  {
    this.mPanelParams = new EmoticonPanelParams(paramIBasePanelView.getController());
    EmoticonPanelParams localEmoticonPanelParams = this.mPanelParams;
    localEmoticonPanelParams.app = paramQQEmoticonMainPanelApp;
    localEmoticonPanelParams.context = paramIBasePanelView.getContext();
    this.mPanelParams.sessionType = paramInt;
  }
  
  public EmoticonPanelBuilder addEmotionInjectionInfo(String paramString, EmotionInjectionInfo paramEmotionInjectionInfo)
  {
    if (this.mPanelParams.emoInjectionInfoManager == null) {
      this.mPanelParams.emoInjectionInfoManager = new EmotionPanelInjectionInfoManager();
    }
    this.mPanelParams.emoInjectionInfoManager.a(paramString, paramEmotionInjectionInfo);
    EmoticonTabSortConfMapping.a(paramEmotionInjectionInfo.emotionType, paramString);
    return this;
  }
  
  public IEmoticonMainPanel create()
  {
    return this.mPanelParams.create();
  }
  
  public IEmoticonMainPanelApp getEmoticonMainPanelApp()
  {
    return this.mPanelParams.app;
  }
  
  public EmoticonPanelBuilder setAIOContext(BaseAIOContext paramBaseAIOContext)
  {
    this.mPanelParams.aioContext = paramBaseAIOContext;
    return this;
  }
  
  public EmoticonPanelBuilder setCallBack(EmoticonCallback paramEmoticonCallback)
  {
    this.mPanelParams.callback = paramEmoticonCallback;
    return this;
  }
  
  public EmoticonPanelBuilder setDefaultEpId(String paramString)
  {
    this.mPanelParams.defaultEpId = paramString;
    return this;
  }
  
  public EmoticonPanelBuilder setDefaultPanelType(int paramInt)
  {
    this.mPanelParams.defaultPanelType = paramInt;
    return this;
  }
  
  public EmoticonPanelBuilder setDisableAutoDownload(boolean paramBoolean)
  {
    this.mPanelParams.disableAutoDownload = paramBoolean;
    return this;
  }
  
  public EmoticonPanelBuilder setDisableGuide(boolean paramBoolean)
  {
    this.mPanelParams.disableGuide = paramBoolean;
    return this;
  }
  
  public EmoticonPanelBuilder setDisableGuideOneTime(boolean paramBoolean)
  {
    this.mPanelParams.disableGuideOneTime = paramBoolean;
    return this;
  }
  
  public EmoticonPanelBuilder setDisableMoreEmotionButton(boolean paramBoolean)
  {
    this.mPanelParams.disableMoreEmotionButton = paramBoolean;
    return this;
  }
  
  public EmoticonPanelBuilder setEmoticonListProvider(EmoticonListProvider paramEmoticonListProvider)
  {
    this.mPanelParams.emoticonListProvider = paramEmoticonListProvider;
    return this;
  }
  
  public EmoticonPanelBuilder setFilterSysFaceBeyond255Enable(boolean paramBoolean)
  {
    this.mPanelParams.isFilterSysFaceBeyond255 = paramBoolean;
    return this;
  }
  
  public EmoticonPanelBuilder setHasBigEmotion(boolean paramBoolean)
  {
    this.mPanelParams.hasBigEmotion = paramBoolean;
    return this;
  }
  
  public EmoticonPanelBuilder setHideAllSettingTabs(boolean paramBoolean)
  {
    this.mPanelParams.hideAllSettingTabs = paramBoolean;
    return this;
  }
  
  public EmoticonPanelBuilder setHideEmoSettingBtn()
  {
    this.mPanelParams.hideSettingBtn = true;
    return this;
  }
  
  public void setIsGuildLiveChannel(boolean paramBoolean)
  {
    this.mPanelParams.isInGuildLiveChannel = paramBoolean;
  }
  
  public EmoticonPanelBuilder setIsOnlySysEmotion(boolean paramBoolean)
  {
    this.mPanelParams.mIsOnlySysEmotion = paramBoolean;
    return this;
  }
  
  public EmoticonPanelBuilder setKanDianBiu(boolean paramBoolean)
  {
    this.mPanelParams.kanDianBiu = paramBoolean;
    return this;
  }
  
  public EmoticonPanelBuilder setOnlySysAndEmoji(boolean paramBoolean)
  {
    this.mPanelParams.onlySysAndEmoji = paramBoolean;
    return this;
  }
  
  public EmoticonPanelBuilder setPanelInteractionListener(IPanelInteractionListener paramIPanelInteractionListener)
  {
    this.mPanelParams.interactionListener = paramIPanelInteractionListener;
    return this;
  }
  
  public EmoticonPanelBuilder setSysEmotionOrder(int[] paramArrayOfInt)
  {
    this.mPanelParams.sysEmotionOrder = paramArrayOfInt;
    return this;
  }
  
  public EmoticonPanelBuilder setToastOffset(int paramInt)
  {
    this.mPanelParams.toastOffset = paramInt;
    return this;
  }
  
  void show()
  {
    this.mPanelParams.show();
  }
  
  public EmoticonPanelBuilder showDescribeInPreview(boolean paramBoolean)
  {
    this.mPanelParams.showDescInPreview = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonMainPanel.EmoticonPanelBuilder
 * JD-Core Version:    0.7.0.1
 */