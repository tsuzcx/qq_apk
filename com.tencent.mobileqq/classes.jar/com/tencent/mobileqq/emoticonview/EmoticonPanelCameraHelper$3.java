package com.tencent.mobileqq.emoticonview;

import com.tencent.qphone.base.util.QLog;
import java.util.List;

class EmoticonPanelCameraHelper$3
  implements Runnable
{
  EmoticonPanelCameraHelper$3(EmoticonPanelCameraHelper paramEmoticonPanelCameraHelper) {}
  
  public void run()
  {
    List localList = this.this$0.mPanelController.panelDataList;
    int i;
    EmotionPanelInfo localEmotionPanelInfo;
    if (localList != null)
    {
      i = 0;
      if (i < localList.size())
      {
        localEmotionPanelInfo = (EmotionPanelInfo)localList.get(i);
        if ((localEmotionPanelInfo == null) || (localEmotionPanelInfo.type != 11)) {}
      }
    }
    for (;;)
    {
      if ((localEmotionPanelInfo != null) && (this.this$0.mPanelController.pageAdapter != null)) {
        this.this$0.mPanelController.pageAdapter.refreshListViewAdapter(localEmotionPanelInfo);
      }
      while (!QLog.isColorLevel())
      {
        return;
        i += 1;
        break;
      }
      QLog.d("EmoticonPanelCameraHelper", 2, "updateCameraEmoticonPanel cameraInfo can not find");
      return;
      localEmotionPanelInfo = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelCameraHelper.3
 * JD-Core Version:    0.7.0.1
 */