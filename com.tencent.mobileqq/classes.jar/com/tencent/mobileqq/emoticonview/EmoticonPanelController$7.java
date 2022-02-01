package com.tencent.mobileqq.emoticonview;

import avtb;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class EmoticonPanelController$7
  implements avtb<Integer>
{
  EmoticonPanelController$7(EmoticonPanelController paramEmoticonPanelController, long paramLong) {}
  
  public void postQuery(Integer paramInteger)
  {
    this.this$0.initTabView(paramInteger.intValue());
    this.this$0.switchTabMode(paramInteger.intValue());
    if ((!this.this$0.mParams.disableGuide) && (!this.this$0.mParams.disableGuideOneTime)) {
      EmoticonPanelController.access$000(this.this$0).showEmoticonPopupGuide();
    }
    this.this$0.mParams.disableGuideOneTime = false;
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelController", 2, "selectIndex = " + paramInteger + "[Performance] initEmoticonView duration:" + (System.currentTimeMillis() - this.val$startTime));
    }
    if (!this.this$0.mParams.disableAutoDownload) {
      EmoticonPanelController.access$300(this.this$0).RoamTenEmoticon();
    }
    paramInteger = this.this$0.panelDataList;
    if (paramInteger.size() > EmoticonPanelController.sRecommendEmoticonViewPoSition) {
      if (((EmotionPanelInfo)paramInteger.get(EmoticonPanelController.sRecommendEmoticonViewPoSition)).type != 8) {
        EmoticonMainPanel.sendRecommendSSORequest(this.this$0.app, this.this$0.businessType);
      }
    }
    for (;;)
    {
      EmoticonPanelController.access$400(this.this$0).tryUpdateGuideImg();
      return;
      EmoticonMainPanel.sendRecommendSSORequest(this.this$0.app, this.this$0.businessType);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelController.7
 * JD-Core Version:    0.7.0.1
 */