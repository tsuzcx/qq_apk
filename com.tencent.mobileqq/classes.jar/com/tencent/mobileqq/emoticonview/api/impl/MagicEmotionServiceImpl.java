package com.tencent.mobileqq.emoticonview.api.impl;

import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.emoticon.IEmoticonPackage;
import com.tencent.mobileqq.emoticon.IEmotionPanelDataCallback;
import com.tencent.mobileqq.emoticonview.EmotionPanelDataBuilder;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.api.IMagicEmotionService;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmojiManagerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonManagerProxy;

public class MagicEmotionServiceImpl
  implements IMagicEmotionService
{
  public void asyncGetEmotionPanelData(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, int paramInt1, IEmoticonPackage paramIEmoticonPackage, int paramInt2, int paramInt3, boolean paramBoolean, IEmotionPanelDataCallback paramIEmotionPanelDataCallback)
  {
    EmotionPanelDataBuilder.getInstance().asyncGetEmotionPanelData(paramIEmoticonMainPanelApp, paramInt1, null, paramInt2, 0, paramBoolean, paramIEmotionPanelDataCallback);
  }
  
  public float getEmoticonPackageLoadingProgress(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, String paramString)
  {
    return ((EmojiManagerProxy)paramIEmoticonMainPanelApp.getManager(QQManagerFactory.CHAT_EMOTION_MANAGER)).getEmoticonPackageLoadingProgress(paramString);
  }
  
  public IEmoticonPackage syncFindEmoticonPackageById(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, String paramString)
  {
    return ((EmoticonManagerProxy)paramIEmoticonMainPanelApp.getManager(QQManagerFactory.EMOTICON_MANAGER)).syncFindEmoticonPackageById(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.impl.MagicEmotionServiceImpl
 * JD-Core Version:    0.7.0.1
 */