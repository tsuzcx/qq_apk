package com.tencent.mobileqq.emoticonview.api;

import com.tencent.mobileqq.emoticon.IEmoticonPackage;
import com.tencent.mobileqq.emoticon.IEmotionPanelDataCallback;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={""})
public abstract interface IMagicEmotionService
  extends QRouteApi
{
  public abstract void asyncGetEmotionPanelData(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, int paramInt1, IEmoticonPackage paramIEmoticonPackage, int paramInt2, int paramInt3, boolean paramBoolean, IEmotionPanelDataCallback paramIEmotionPanelDataCallback);
  
  public abstract float getEmoticonPackageLoadingProgress(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, String paramString);
  
  public abstract IEmoticonPackage syncFindEmoticonPackageById(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.IMagicEmotionService
 * JD-Core Version:    0.7.0.1
 */