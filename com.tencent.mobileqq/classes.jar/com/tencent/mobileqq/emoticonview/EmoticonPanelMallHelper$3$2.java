package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.webview.util.WebProcessStartListener;

class EmoticonPanelMallHelper$3$2
  implements WebProcessStartListener
{
  EmoticonPanelMallHelper$3$2(EmoticonPanelMallHelper.3 param3) {}
  
  public void onResult(boolean paramBoolean)
  {
    if (paramBoolean) {
      ((EmoticonPanelController)this.this$1.this$0.mPanelController).getBasePanelModel().webPreloadHitSessionBegin();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper.3.2
 * JD-Core Version:    0.7.0.1
 */