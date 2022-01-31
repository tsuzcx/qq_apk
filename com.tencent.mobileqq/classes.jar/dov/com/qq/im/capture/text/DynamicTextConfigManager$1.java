package dov.com.qq.im.capture.text;

import blxg;
import blxh;
import blxj;
import java.util.ArrayList;
import java.util.Iterator;

class DynamicTextConfigManager$1
  implements Runnable
{
  DynamicTextConfigManager$1(DynamicTextConfigManager paramDynamicTextConfigManager, DynamicTextConfigManager.DynamicTextConfigBean paramDynamicTextConfigBean, blxj paramblxj) {}
  
  public void run()
  {
    Iterator localIterator = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager$DynamicTextConfigBean.fontInfos.iterator();
    while (localIterator.hasNext())
    {
      blxg localblxg = (blxg)localIterator.next();
      DynamicTextConfigManager.a(this.this$0).a(localblxg, this.jdField_a_of_type_Blxj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.capture.text.DynamicTextConfigManager.1
 * JD-Core Version:    0.7.0.1
 */