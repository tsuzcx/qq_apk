package com.tencent.mobileqq.emoticonview;

class EmoticonPanelSettingHelper$1
  implements Runnable
{
  EmoticonPanelSettingHelper$1(EmoticonPanelSettingHelper paramEmoticonPanelSettingHelper) {}
  
  public void run()
  {
    if (EmoticonPanelSettingHelper.access$000(this.this$0) == null) {
      return;
    }
    if (EmoticonPanelSettingHelper.access$000(this.this$0).isShowing()) {
      EmoticonPanelSettingHelper.access$000(this.this$0).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelSettingHelper.1
 * JD-Core Version:    0.7.0.1
 */