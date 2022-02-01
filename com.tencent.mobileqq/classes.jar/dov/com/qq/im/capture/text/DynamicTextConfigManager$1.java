package dov.com.qq.im.capture.text;

import bmvl;
import bmvm;
import bmvo;
import java.util.ArrayList;
import java.util.Iterator;

class DynamicTextConfigManager$1
  implements Runnable
{
  DynamicTextConfigManager$1(DynamicTextConfigManager paramDynamicTextConfigManager, DynamicTextConfigManager.DynamicTextConfigBean paramDynamicTextConfigBean, bmvo parambmvo) {}
  
  public void run()
  {
    Iterator localIterator = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextConfigManager$DynamicTextConfigBean.fontInfos.iterator();
    while (localIterator.hasNext())
    {
      bmvl localbmvl = (bmvl)localIterator.next();
      DynamicTextConfigManager.a(this.this$0).a(localbmvl, this.jdField_a_of_type_Bmvo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.text.DynamicTextConfigManager.1
 * JD-Core Version:    0.7.0.1
 */