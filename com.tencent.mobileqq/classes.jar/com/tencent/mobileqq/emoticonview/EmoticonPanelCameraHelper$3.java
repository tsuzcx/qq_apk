package com.tencent.mobileqq.emoticonview;

import asnf;
import aspt;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class EmoticonPanelCameraHelper$3
  implements Runnable
{
  public EmoticonPanelCameraHelper$3(asnf paramasnf) {}
  
  public void run()
  {
    List localList = this.this$0.a.b;
    int i;
    aspt localaspt;
    if (localList != null)
    {
      i = 0;
      if (i < localList.size())
      {
        localaspt = (aspt)localList.get(i);
        if ((localaspt == null) || (localaspt.a != 11)) {}
      }
    }
    for (;;)
    {
      if ((localaspt != null) && (this.this$0.a.a != null)) {
        this.this$0.a.a.a(localaspt);
      }
      while (!QLog.isColorLevel())
      {
        return;
        i += 1;
        break;
      }
      QLog.d("EmoticonPanelCameraHelper", 2, "updateCameraEmoticonPanel cameraInfo can not find");
      return;
      localaspt = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelCameraHelper.3
 * JD-Core Version:    0.7.0.1
 */