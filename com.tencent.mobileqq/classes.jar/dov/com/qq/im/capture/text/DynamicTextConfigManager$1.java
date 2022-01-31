package dov.com.qq.im.capture.text;

import bjgs;
import bjgt;
import bjgv;
import java.util.ArrayList;
import java.util.Iterator;

class DynamicTextConfigManager$1
  implements Runnable
{
  DynamicTextConfigManager$1(DynamicTextConfigManager paramDynamicTextConfigManager, DynamicTextConfigManager.DynamicTextConfigBean paramDynamicTextConfigBean, bjgv parambjgv) {}
  
  public void run()
  {
    Iterator localIterator = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager$DynamicTextConfigBean.fontInfos.iterator();
    while (localIterator.hasNext())
    {
      bjgs localbjgs = (bjgs)localIterator.next();
      DynamicTextConfigManager.a(this.this$0).a(localbjgs, this.jdField_a_of_type_Bjgv);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.text.DynamicTextConfigManager.1
 * JD-Core Version:    0.7.0.1
 */