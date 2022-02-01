package com.tencent.mobileqq.emoticonview.api;

import com.tencent.mobileqq.emoticon.IEmoticonPackage;
import com.tencent.mobileqq.emoticon.IEmotionPanelDataCallback;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;

@QAPI(process={""})
public abstract interface IFavoriteEmotionService<T>
  extends QRouteApi
{
  public abstract void asyncGetEmotionPanelData(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, int paramInt1, IEmoticonPackage paramIEmoticonPackage, int paramInt2, int paramInt3, boolean paramBoolean, IEmotionPanelDataCallback paramIEmotionPanelDataCallback);
  
  public abstract void cacheAccessibilityEmotionData(IEmoticonMainPanelApp paramIEmoticonMainPanelApp);
  
  public abstract boolean checkPicFavEnable(String paramString);
  
  public abstract void dealResendCameraEmotion(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, T paramT);
  
  public abstract CharSequence getAccessibilityDescription(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, int paramInt);
  
  public abstract List<T> getEmoticonDataList(IEmoticonMainPanelApp paramIEmoticonMainPanelApp);
  
  public abstract void notifyUI(IEmoticonMainPanelApp paramIEmoticonMainPanelApp);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.IFavoriteEmotionService
 * JD-Core Version:    0.7.0.1
 */