package com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService.PanelBuilder;
import com.tencent.mobileqq.kandian.biz.comment.emotion.RIJEmotionListProvider;
import com.tencent.mobileqq.kandian.biz.comment.emotion.cache.RIJEmotionCacheManager;
import com.tencent.mobileqq.utils.ViewUtils;

class QQViewBridgeImpl$EmotionUi
{
  private IEmoticonMainPanel b;
  private final EmoticonCallback c = new QQViewBridgeImpl.EmotionUi.1(this);
  
  private QQViewBridgeImpl$EmotionUi(QQViewBridgeImpl paramQQViewBridgeImpl) {}
  
  private View b(Context paramContext)
  {
    int i = ViewUtils.dip2px(12.0F);
    paramContext = new ImageView(paramContext);
    paramContext.setImageResource(2097479685);
    paramContext.setPadding(0, i, 0, i);
    paramContext.setOnClickListener(new QQViewBridgeImpl.EmotionUi.2(this));
    return paramContext;
  }
  
  View a(Context paramContext)
  {
    if (this.b == null)
    {
      IEmoticonMainPanelService.PanelBuilder localPanelBuilder = ((IEmoticonMainPanelService)this.a.a().getRuntimeService(IEmoticonMainPanelService.class)).newBuilder(paramContext, 1008).setCallBack(this.c).setOnlySysAndEmoji(true).setToastOffset(((QBaseActivity)paramContext).getTitleBarHeight()).setEmoticonListProvider(new RIJEmotionListProvider()).setHideAllSettingTabs(true);
      RIJEmotionCacheManager.a(localPanelBuilder, localPanelBuilder.getEmoticonMainPanelApp(), paramContext, this.c);
      this.b = localPanelBuilder.create();
      this.b.addTabListAdditionalView(false, b(paramContext));
    }
    return this.b.getView();
  }
  
  void a()
  {
    IEmoticonMainPanel localIEmoticonMainPanel = this.b;
    if (localIEmoticonMainPanel != null) {
      localIEmoticonMainPanel.onDestory();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.base.bridgeimpl.QQViewBridgeImpl.EmotionUi
 * JD-Core Version:    0.7.0.1
 */