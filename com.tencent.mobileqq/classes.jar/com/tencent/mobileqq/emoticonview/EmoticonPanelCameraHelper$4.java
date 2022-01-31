package com.tencent.mobileqq.emoticonview;

import apuo;
import apwv;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class EmoticonPanelCameraHelper$4
  implements Runnable
{
  public EmoticonPanelCameraHelper$4(apuo paramapuo) {}
  
  public void run()
  {
    List localList = this.this$0.a.b;
    int i;
    apwv localapwv;
    if (localList != null)
    {
      i = 0;
      if (i < localList.size())
      {
        localapwv = (apwv)localList.get(i);
        if ((localapwv == null) || (localapwv.a != 11)) {}
      }
    }
    for (;;)
    {
      if ((localapwv != null) && (this.this$0.a.a != null)) {
        this.this$0.a.a.a(localapwv);
      }
      while (!QLog.isColorLevel())
      {
        return;
        i += 1;
        break;
      }
      QLog.d("EmoticonPanelCameraHelper", 2, "updateCameraEmoticonPanel cameraInfo can not find");
      return;
      localapwv = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelCameraHelper.4
 * JD-Core Version:    0.7.0.1
 */