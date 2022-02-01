package com.tencent.mobileqq.emoticonview.adapter;

import com.tencent.mobileqq.emoticonview.BaseEmotionAdapter;
import com.tencent.mobileqq.emoticonview.CameraEmoticonInfo;

public abstract interface ICameraEmotionAdapterHelper
  extends IEmotionAdapterHelper
{
  public abstract void reUploadCameraEmotion(CameraEmoticonInfo paramCameraEmoticonInfo);
  
  public abstract void refreshPanelData(BaseEmotionAdapter paramBaseEmotionAdapter, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.adapter.ICameraEmotionAdapterHelper
 * JD-Core Version:    0.7.0.1
 */