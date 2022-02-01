package com.tencent.mobileqq.emoticonview.api;

import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;

@QAPI(process={""})
public abstract interface ICameraEmotionService<T>
  extends QRouteApi
{
  public abstract List<T> getEmoticonDataList(IEmoticonMainPanelApp paramIEmoticonMainPanelApp);
  
  public abstract void reUploadCameraEmotion(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.ICameraEmotionService
 * JD-Core Version:    0.7.0.1
 */