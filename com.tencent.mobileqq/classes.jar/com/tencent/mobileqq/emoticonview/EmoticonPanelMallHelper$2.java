package com.tencent.mobileqq.emoticonview;

import com.tencent.qphone.base.util.QLog;

class EmoticonPanelMallHelper$2
  implements Runnable
{
  EmoticonPanelMallHelper$2(EmoticonPanelMallHelper paramEmoticonPanelMallHelper) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelMallHelper", 2, "func updateLastEmoticonPanel begins.");
    }
    if (((EmoticonPanelController)this.this$0.mPanelController).getPageAdapter() != null) {
      ((EmoticonPanelController)this.this$0.mPanelController).getPageAdapter().notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper.2
 * JD-Core Version:    0.7.0.1
 */