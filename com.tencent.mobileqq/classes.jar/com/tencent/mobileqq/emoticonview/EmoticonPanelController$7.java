package com.tencent.mobileqq.emoticonview;

import android.content.res.Resources;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.model.QueryCallback;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class EmoticonPanelController$7
  implements QueryCallback<Integer>
{
  EmoticonPanelController$7(EmoticonPanelController paramEmoticonPanelController, long paramLong) {}
  
  public void postQuery(Integer paramInteger)
  {
    boolean bool = EmoticonStoreTabEntryUtils.checkTabListCanShowGuide(this.this$0.panelDataList);
    Integer localInteger = paramInteger;
    if (bool)
    {
      localInteger = paramInteger;
      if (EmoticonStoreTabEntryUtils.checkIsNeedShowGuide()) {
        localInteger = Integer.valueOf(0);
      }
    }
    this.this$0.initTabView(localInteger.intValue());
    this.this$0.switchTabMode(localInteger.intValue());
    if ((!this.this$0.mParams.disableGuide) && (!this.this$0.mParams.disableGuideOneTime)) {
      EmoticonPanelController.access$000(this.this$0).showEmoticonPopupGuide();
    }
    this.this$0.mParams.disableGuideOneTime = false;
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelController", 2, "selectIndex = " + localInteger + "[Performance] initEmoticonView duration:" + (System.currentTimeMillis() - this.val$startTime));
    }
    if (!this.this$0.mParams.disableAutoDownload) {
      EmoticonPanelController.access$300(this.this$0).RoamTenEmoticon();
    }
    paramInteger = this.this$0.panelDataList;
    if (paramInteger.size() > EmoticonPanelController.sRecommendEmoticonViewPoSition) {
      if (((EmotionPanelInfo)paramInteger.get(EmoticonPanelController.sRecommendEmoticonViewPoSition)).type != 8) {
        EmoticonManager.a(this.this$0.app, this.this$0.businessType);
      }
    }
    for (;;)
    {
      EmoticonPanelController.access$400(this.this$0).tryUpdateGuideImg();
      if ((bool) && (EmoticonStoreTabEntryUtils.checkIsNeedShowGuide()))
      {
        int i = (int)EmoticonPanelController.access$500(this.this$0).getResources().getDimension(2131296984);
        int j = ViewUtils.b(8.0F);
        EmoticonPanelController.access$600(this.this$0).showGuideView(EmoticonPanelController.access$500(this.this$0), j, i);
      }
      return;
      EmoticonManager.a(this.this$0.app, this.this$0.businessType);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelController.7
 * JD-Core Version:    0.7.0.1
 */