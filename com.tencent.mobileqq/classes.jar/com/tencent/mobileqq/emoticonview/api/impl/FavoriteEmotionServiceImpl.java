package com.tencent.mobileqq.emoticonview.api.impl;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.favroaming.FavEmoSendControl;
import com.tencent.mobileqq.emosm.favroaming.FavEmoSingleSend;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager;
import com.tencent.mobileqq.emoticon.IEmoticonPackage;
import com.tencent.mobileqq.emoticon.IEmotionPanelDataCallback;
import com.tencent.mobileqq.emoticonview.EmotionPanelDataBuilder;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.api.IFavoriteEmotionService;
import com.tencent.mobileqq.emoticonview.ipc.proxy.FavEmoRoamingHandlerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.FavroamingDBManagerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.FavroamingManagerProxy;
import java.util.List;

public class FavoriteEmotionServiceImpl
  implements IFavoriteEmotionService<CustomEmotionData>
{
  public void asyncGetEmotionPanelData(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, int paramInt1, IEmoticonPackage paramIEmoticonPackage, int paramInt2, int paramInt3, boolean paramBoolean, IEmotionPanelDataCallback paramIEmotionPanelDataCallback)
  {
    EmoticonPackage localEmoticonPackage = null;
    if ((paramIEmoticonPackage instanceof EmoticonPackage)) {
      localEmoticonPackage = (EmoticonPackage)paramIEmoticonPackage;
    }
    EmotionPanelDataBuilder.getInstance().asyncGetEmotionPanelData(paramIEmoticonMainPanelApp, paramInt1, localEmoticonPackage, paramInt2, paramInt3, paramBoolean, paramIEmotionPanelDataCallback);
  }
  
  public void cacheAccessibilityEmotionData(IEmoticonMainPanelApp paramIEmoticonMainPanelApp)
  {
    FavroamingManager.a(paramIEmoticonMainPanelApp).cacheAccessibilityEmotionData();
  }
  
  public boolean checkPicFavEnable(String paramString)
  {
    return FavEmoSendControl.a(paramString);
  }
  
  public void dealResendCameraEmotion(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, CustomEmotionData paramCustomEmotionData)
  {
    ((FavEmoRoamingHandlerProxy)paramIEmoticonMainPanelApp.getBusinessHandler(BusinessHandlerFactory.FAVEMO_ROAMING_HANDLER)).notifyUI(2, true, null);
    com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend.b = false;
    ThreadManager.excute(new FavEmoSingleSend(paramCustomEmotionData, true), 64, null, false);
  }
  
  public CharSequence getAccessibilityDescription(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, int paramInt)
  {
    return FavroamingManager.a(paramIEmoticonMainPanelApp).getAccessibilityDescription(paramInt);
  }
  
  public List<CustomEmotionData> getEmoticonDataList(IEmoticonMainPanelApp paramIEmoticonMainPanelApp)
  {
    return ((FavroamingDBManagerProxy)paramIEmoticonMainPanelApp.getManager(QQManagerFactory.FAVROAMING_DB_MANAGER)).getEmoticonDataList();
  }
  
  public void notifyUI(IEmoticonMainPanelApp paramIEmoticonMainPanelApp)
  {
    ((FavEmoRoamingHandlerProxy)paramIEmoticonMainPanelApp.getBusinessHandler(BusinessHandlerFactory.FAVEMO_ROAMING_HANDLER)).notifyUI(2, true, Integer.valueOf(1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.impl.FavoriteEmotionServiceImpl
 * JD-Core Version:    0.7.0.1
 */