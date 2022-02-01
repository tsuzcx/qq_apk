package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;

public class EmoticonMainPanel$EmoticonPanelBuilder
{
  private final EmoticonPanelController.EmoticonPanelParams mPanelParams;
  
  public EmoticonMainPanel$EmoticonPanelBuilder(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, int paramInt)
  {
    this.mPanelParams = new EmoticonPanelController.EmoticonPanelParams();
    this.mPanelParams.app = paramQQAppInterface;
    this.mPanelParams.mBaseChatPie = paramBaseChatPie;
    this.mPanelParams.sessionType = paramInt;
  }
  
  EmoticonMainPanel$EmoticonPanelBuilder(EmoticonMainPanel paramEmoticonMainPanel, QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, int paramInt)
  {
    this.mPanelParams = new EmoticonPanelController.EmoticonPanelParams(paramEmoticonMainPanel);
    this.mPanelParams.app = paramQQAppInterface;
    this.mPanelParams.mBaseChatPie = paramBaseChatPie;
    this.mPanelParams.sessionType = paramInt;
  }
  
  public EmoticonMainPanel create()
  {
    return this.mPanelParams.create();
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
  
  public EmoticonPanelBuilder setEmoticonCallback(EmoticonCallback paramEmoticonCallback)
  {
    this.mPanelParams.callback = paramEmoticonCallback;
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
  
  public EmoticonPanelBuilder setToastOffset(int paramInt)
  {
    this.mPanelParams.toastOffset = paramInt;
    return this;
  }
  
  void show()
  {
    this.mPanelParams.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonMainPanel.EmoticonPanelBuilder
 * JD-Core Version:    0.7.0.1
 */