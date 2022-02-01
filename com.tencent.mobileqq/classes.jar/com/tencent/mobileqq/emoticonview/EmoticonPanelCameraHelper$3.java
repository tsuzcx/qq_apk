package com.tencent.mobileqq.emoticonview;

import arxr;
import asaf;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class EmoticonPanelCameraHelper$3
  implements Runnable
{
  public EmoticonPanelCameraHelper$3(arxr paramarxr) {}
  
  public void run()
  {
    List localList = this.this$0.a.b;
    int i;
    asaf localasaf;
    if (localList != null)
    {
      i = 0;
      if (i < localList.size())
      {
        localasaf = (asaf)localList.get(i);
        if ((localasaf == null) || (localasaf.a != 11)) {}
      }
    }
    for (;;)
    {
      if ((localasaf != null) && (this.this$0.a.a != null)) {
        this.this$0.a.a.a(localasaf);
      }
      while (!QLog.isColorLevel())
      {
        return;
        i += 1;
        break;
      }
      QLog.d("EmoticonPanelCameraHelper", 2, "updateCameraEmoticonPanel cameraInfo can not find");
      return;
      localasaf = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelCameraHelper.3
 * JD-Core Version:    0.7.0.1
 */