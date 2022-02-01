package com.tencent.mobileqq.emoticonview;

import com.tencent.qphone.base.util.QLog;
import java.util.List;

class EmoticonPanelCameraHelper$3
  implements Runnable
{
  EmoticonPanelCameraHelper$3(EmoticonPanelCameraHelper paramEmoticonPanelCameraHelper) {}
  
  public void run()
  {
    List localList = ((EmoticonPanelController)this.this$0.mPanelController).getPanelDataList();
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        localEmotionPanelInfo = (EmotionPanelInfo)localList.get(i);
        if ((localEmotionPanelInfo != null) && (localEmotionPanelInfo.type == 11)) {
          break label66;
        }
        i += 1;
      }
    }
    EmotionPanelInfo localEmotionPanelInfo = null;
    label66:
    if ((localEmotionPanelInfo != null) && (((EmoticonPanelController)this.this$0.mPanelController).getPageAdapter() != null))
    {
      ((EmoticonPanelController)this.this$0.mPanelController).getPageAdapter().refreshListViewAdapter(localEmotionPanelInfo);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelCameraHelper", 2, "updateCameraEmoticonPanel cameraInfo can not find");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelCameraHelper.3
 * JD-Core Version:    0.7.0.1
 */