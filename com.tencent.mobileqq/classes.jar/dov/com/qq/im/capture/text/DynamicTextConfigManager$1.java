package dov.com.qq.im.capture.text;

import java.util.ArrayList;
import java.util.Iterator;

class DynamicTextConfigManager$1
  implements Runnable
{
  DynamicTextConfigManager$1(DynamicTextConfigManager paramDynamicTextConfigManager, DynamicTextConfigManager.DynamicTextConfigBean paramDynamicTextConfigBean, DynamicTextConfigManager.IDynamicTextResDownloadCallback paramIDynamicTextResDownloadCallback) {}
  
  public void run()
  {
    Iterator localIterator = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager$DynamicTextConfigBean.fontInfos.iterator();
    while (localIterator.hasNext())
    {
      DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo localDynamicTextFontInfo = (DynamicTextConfigManager.DynamicTextConfigBean.DynamicTextFontInfo)localIterator.next();
      DynamicTextConfigManager.a(this.this$0).a(localDynamicTextFontInfo, this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager$IDynamicTextResDownloadCallback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.text.DynamicTextConfigManager.1
 * JD-Core Version:    0.7.0.1
 */