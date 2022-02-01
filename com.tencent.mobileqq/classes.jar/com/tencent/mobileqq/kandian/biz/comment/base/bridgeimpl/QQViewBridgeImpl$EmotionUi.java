package com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService.PanelBuilder;
import com.tencent.mobileqq.kandian.biz.comment.emotion.RIJEmotionListProvider;
import com.tencent.mobileqq.kandian.biz.comment.emotion.cache.RIJEmotionCacheManager;

class QQViewBridgeImpl$EmotionUi
{
  private final EmoticonCallback jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback = new QQViewBridgeImpl.EmotionUi.1(this);
  private IEmoticonMainPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel;
  
  private QQViewBridgeImpl$EmotionUi(QQViewBridgeImpl paramQQViewBridgeImpl) {}
  
  View a(Context paramContext)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel == null)
    {
      IEmoticonMainPanelService.PanelBuilder localPanelBuilder = ((IEmoticonMainPanelService)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentBaseBridgeimplQQViewBridgeImpl.a().getRuntimeService(IEmoticonMainPanelService.class)).newBuilder(paramContext, 1008).setCallBack(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback).setOnlySysAndEmoji(true).setToastOffset(((BaseActivity)paramContext).getTitleBarHeight()).setEmoticonListProvider(new RIJEmotionListProvider()).setHideAllSettingTabs(true);
      RIJEmotionCacheManager.a(localPanelBuilder, localPanelBuilder.getEmoticonMainPanelApp(), paramContext, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel = localPanelBuilder.create();
    }
    return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel.getView();
  }
  
  void a()
  {
    IEmoticonMainPanel localIEmoticonMainPanel = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewIEmoticonMainPanel;
    if (localIEmoticonMainPanel != null) {
      localIEmoticonMainPanel.onDestory();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl.QQViewBridgeImpl.EmotionUi
 * JD-Core Version:    0.7.0.1
 */