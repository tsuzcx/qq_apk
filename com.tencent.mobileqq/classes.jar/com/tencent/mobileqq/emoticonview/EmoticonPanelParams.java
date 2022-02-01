package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.EmotionPanelInjectionInfoManager;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;

public class EmoticonPanelParams
{
  public BaseAIOContext aioContext;
  public QQEmoticonMainPanelApp app;
  public EmoticonCallback callback;
  public Context context;
  public String defaultEpId;
  public int defaultPanelType = -1;
  public boolean disableAutoDownload = false;
  public boolean disableGuide = false;
  public boolean disableGuideOneTime = false;
  public boolean disableMoreEmotionButton = false;
  public EmotionPanelInjectionInfoManager emoInjectionInfoManager;
  public EmoticonListProvider emoticonListProvider;
  public boolean hasBigEmotion = true;
  public boolean hideAllSettingTabs = false;
  public boolean hideSettingBtn = false;
  public IPanelInteractionListener interactionListener;
  public boolean isFilterSysFaceBeyond255 = false;
  public boolean isInGuildLiveChannel = false;
  public boolean kanDianBiu = false;
  public EmoticonPanelController mController;
  public boolean mIsOnlySysEmotion = false;
  public boolean onlySysAndEmoji = false;
  public int sessionType = 0;
  public boolean showDescInPreview = false;
  public int[] sysEmotionOrder;
  public int toastOffset;
  
  public EmoticonPanelParams() {}
  
  public EmoticonPanelParams(EmoticonPanelController paramEmoticonPanelController)
  {
    this.mController = paramEmoticonPanelController;
    paramEmoticonPanelController = this.mController;
    if (paramEmoticonPanelController != null)
    {
      this.callback = paramEmoticonPanelController.callback;
      this.kanDianBiu = this.mController.getKanDianBiu();
      this.app = this.mController.app;
      this.hasBigEmotion = this.mController.mBasePanelView.hasBigEmotion;
      this.emoticonListProvider = this.mController.getEmoticonListProvider();
      this.isFilterSysFaceBeyond255 = this.mController.isFilterSysFaceBeyond255Enable();
      this.hideAllSettingTabs = this.mController.mBasePanelView.mHideAllSettingTabs;
      this.mIsOnlySysEmotion = this.mController.isOnlySysEmotion();
      this.sysEmotionOrder = this.mController.getSysEmotionOrder();
      this.aioContext = this.mController.mAIOContext;
      this.interactionListener = this.mController.mInteractionListener;
      this.emoInjectionInfoManager = this.mController.mBasePanelModel.mEmotionPanelInjectionInfoManager;
    }
  }
  
  public void apply()
  {
    EmoticonPanelController localEmoticonPanelController = this.mController;
    if (localEmoticonPanelController != null)
    {
      this.disableMoreEmotionButton = false;
      localEmoticonPanelController.mBasePanelModel.mParams = this;
      localEmoticonPanelController = this.mController;
      localEmoticonPanelController.callback = this.callback;
      localEmoticonPanelController.setKanDianBiu(this.kanDianBiu);
      this.mController.setEmoticonApp(this.app);
      this.mController.mBasePanelView.hasBigEmotion = this.hasBigEmotion;
      this.mController.setEmoticonListProvider(this.emoticonListProvider);
      if (this.mController.getEmoticonListProvider() == null)
      {
        localEmoticonPanelController = this.mController;
        localEmoticonPanelController.setEmoticonListProvider(new DefaultEmoticonListProvider(localEmoticonPanelController));
      }
      this.mController.setFilterSysFaceBeyond255Enable(this.isFilterSysFaceBeyond255);
      this.mController.mBasePanelView.mHideAllSettingTabs = this.hideAllSettingTabs;
      this.mController.setOnlySysEmotionEnable(this.mIsOnlySysEmotion);
      localEmoticonPanelController = this.mController;
      localEmoticonPanelController.mAIOContext = this.aioContext;
      localEmoticonPanelController.mInteractionListener = this.interactionListener;
      localEmoticonPanelController.mBasePanelModel.mEmotionPanelInjectionInfoManager = this.emoInjectionInfoManager;
      this.mController.setSysEmotionOrder(this.sysEmotionOrder);
      this.mController.setCurType(this.sessionType);
    }
  }
  
  public IEmoticonMainPanel create()
  {
    EmoticonMainPanel localEmoticonMainPanel = (EmoticonMainPanel)View.inflate(this.context, 2131624746, null);
    this.mController = localEmoticonMainPanel.getEmoController();
    show();
    return localEmoticonMainPanel;
  }
  
  public void show()
  {
    if (this.mController == null) {
      return;
    }
    apply();
    this.mController.getBasePanelView().setViewData(this);
    this.mController.init();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelParams
 * JD-Core Version:    0.7.0.1
 */