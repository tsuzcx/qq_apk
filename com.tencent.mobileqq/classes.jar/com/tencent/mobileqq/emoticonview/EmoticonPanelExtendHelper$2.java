package com.tencent.mobileqq.emoticonview;

import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;

class EmoticonPanelExtendHelper$2
  implements Runnable
{
  EmoticonPanelExtendHelper$2(EmoticonPanelExtendHelper paramEmoticonPanelExtendHelper) {}
  
  public void run()
  {
    if (EmoticonPanelExtendHelper.access$100(this.this$0) > XPanelContainer.a) {
      EmoticonPanelExtendHelper.access$102(this.this$0, XPanelContainer.a);
    }
    boolean bool;
    if (EmoticonPanelExtendHelper.access$200() > EmoticonPanelExtendHelper.access$100(this.this$0)) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onShow ");
      localStringBuilder.append(AppSetting.i());
      localStringBuilder.append(" init panelH ");
      localStringBuilder.append(EmoticonPanelExtendHelper.access$100(this.this$0));
      localStringBuilder.append(" needExtendPanel");
      localStringBuilder.append(bool);
      QLog.d("EmoticonPanelExtendHelper", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelExtendHelper.2
 * JD-Core Version:    0.7.0.1
 */