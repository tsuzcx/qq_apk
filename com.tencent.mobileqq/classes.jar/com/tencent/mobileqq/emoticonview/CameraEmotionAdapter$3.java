package com.tencent.mobileqq.emoticonview;

import com.tencent.qphone.base.util.QLog;
import java.util.List;

class CameraEmotionAdapter$3
  implements EmotionPanelDataBuilder.EmotionPanelDataCallback
{
  CameraEmotionAdapter$3(CameraEmotionAdapter paramCameraEmotionAdapter) {}
  
  public void callbackInMainThread(List<EmotionPanelData> paramList)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("refreshPanelData call back dataList = ");
      if (paramList != null) {
        break label60;
      }
    }
    label60:
    for (Object localObject = "null";; localObject = Integer.valueOf(paramList.size()))
    {
      QLog.d("CameraEmotionAdapter", 2, localObject);
      if (paramList != null)
      {
        this.this$0.setData(paramList);
        this.this$0.notifyDataSetChanged();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.CameraEmotionAdapter.3
 * JD-Core Version:    0.7.0.1
 */