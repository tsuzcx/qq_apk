package com.tencent.mobileqq.emoticonview;

import android.view.View;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;

class EmoticonPanelController$EmoticonPanelParams
{
  QQEmoticonMainPanelApp app;
  EmoticonCallback callback;
  String defaultEpId;
  int defaultPanelType;
  boolean disableAutoDownload = false;
  boolean disableGuide = false;
  boolean disableGuideOneTime = false;
  boolean disableMoreEmotionButton = false;
  EmoticonListProvider emoticonListProvider;
  EmoticonMainPanel emoticonMainPanel;
  boolean hasBigEmotion = true;
  boolean hideAllSettingTabs = false;
  boolean hideSettingBtn = false;
  boolean isFilterSysFaceBeyond255 = false;
  boolean kanDianBiu = false;
  BaseChatPie mBaseChatPie;
  boolean mIsOnlySysEmotion = false;
  boolean onlySysAndEmoji = false;
  int sessionType = 0;
  int toastOffset;
  
  public EmoticonPanelController$EmoticonPanelParams() {}
  
  public EmoticonPanelController$EmoticonPanelParams(EmoticonMainPanel paramEmoticonMainPanel)
  {
    this.emoticonMainPanel = paramEmoticonMainPanel;
    if (paramEmoticonMainPanel != null)
    {
      paramEmoticonMainPanel = paramEmoticonMainPanel.getEmoController();
      if (paramEmoticonMainPanel != null)
      {
        this.callback = paramEmoticonMainPanel.callback;
        this.kanDianBiu = paramEmoticonMainPanel.kanDianBiu;
        this.app = paramEmoticonMainPanel.app;
        this.hasBigEmotion = paramEmoticonMainPanel.hasBigEmotion;
        this.emoticonListProvider = EmoticonPanelController.access$700(paramEmoticonMainPanel);
        this.mBaseChatPie = paramEmoticonMainPanel.mBaseChatPie;
        this.isFilterSysFaceBeyond255 = EmoticonPanelController.access$800(paramEmoticonMainPanel);
        this.hideAllSettingTabs = paramEmoticonMainPanel.mHideAllSettingTabs;
        this.mIsOnlySysEmotion = paramEmoticonMainPanel.mIsOnlySysEmotion;
      }
    }
  }
  
  public void apply()
  {
    if (this.emoticonMainPanel == null) {}
    EmoticonPanelController localEmoticonPanelController;
    do
    {
      return;
      localEmoticonPanelController = this.emoticonMainPanel.getEmoController();
    } while (localEmoticonPanelController == null);
    this.disableMoreEmotionButton = false;
    localEmoticonPanelController.mParams = this;
    localEmoticonPanelController.callback = this.callback;
    localEmoticonPanelController.kanDianBiu = this.kanDianBiu;
    localEmoticonPanelController.app = this.app;
    localEmoticonPanelController.hasBigEmotion = this.hasBigEmotion;
    EmoticonPanelController.access$702(localEmoticonPanelController, this.emoticonListProvider);
    localEmoticonPanelController.mBaseChatPie = this.mBaseChatPie;
    EmoticonPanelController.access$802(localEmoticonPanelController, this.isFilterSysFaceBeyond255);
    localEmoticonPanelController.mHideAllSettingTabs = this.hideAllSettingTabs;
    localEmoticonPanelController.mIsOnlySysEmotion = this.mIsOnlySysEmotion;
    localEmoticonPanelController.setCurType(this.sessionType);
  }
  
  public EmoticonMainPanel create()
  {
    this.emoticonMainPanel = ((EmoticonMainPanel)View.inflate(this.app.getApp(), 2131559200, null));
    show();
    return this.emoticonMainPanel;
  }
  
  public void show()
  {
    if ((this.emoticonMainPanel == null) || (this.emoticonMainPanel.getEmoController() == null)) {
      return;
    }
    apply();
    this.emoticonMainPanel.getEmoController().init();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelController.EmoticonPanelParams
 * JD-Core Version:    0.7.0.1
 */