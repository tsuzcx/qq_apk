package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import com.tencent.mobileqq.EmotionInjectionInfo;
import com.tencent.mobileqq.EmotionPanelManager;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.config.business.EmoticonTabSortConfProcessor;
import com.tencent.mobileqq.core.EmotionPanelBuilderDirector;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.qphone.base.util.QLog;

public class EmotionPanelListViewAdapterBuilder
{
  public static final String TAG = "EmotionPanelListViewAdapterBuilder";
  private static EmotionPanelListViewAdapterBuilder sInstance;
  
  public static EmotionPanelListViewAdapterBuilder getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new EmotionPanelListViewAdapterBuilder();
      }
      return sInstance;
    }
    finally {}
  }
  
  public BaseEmotionAdapter getAdapter(QQEmoticonMainPanelApp paramQQEmoticonMainPanelApp, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, EmoticonCallback paramEmoticonCallback, BaseChatPie paramBaseChatPie, int paramInt4, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionPanelListViewAdapterBuilder", 2, "getAdapter panelType = " + paramInt2);
    }
    switch (paramInt2)
    {
    case 10: 
    case 11: 
    default: 
      paramQQEmoticonMainPanelApp = EmoticonTabSortConfProcessor.a(paramInt3);
      paramQQEmoticonMainPanelApp = EmotionPanelManager.a().a(paramQQEmoticonMainPanelApp);
      if ((paramQQEmoticonMainPanelApp != null) && (paramQQEmoticonMainPanelApp.a != null)) {
        return new EmotionPanelBuilderDirector().a(paramQQEmoticonMainPanelApp.a);
      }
      break;
    case 1: 
      return new SystemAndEmojiAdapter(paramQQEmoticonMainPanelApp, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback, paramInt4);
    case 6: 
      return new BigEmotionDownloadedAdapter(paramQQEmoticonMainPanelApp, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramEmoticonCallback, paramInt4);
    case 8: 
      return new BigEmotionUpdateAdapter(paramQQEmoticonMainPanelApp, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramEmoticonCallback, paramInt4);
    case 7: 
      return new EmotionDownloadOrInvalidAdapter(paramQQEmoticonMainPanelApp, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramEmoticonCallback, paramInt4);
    case 4: 
      return new FavoriteEmotionAdapter(paramQQEmoticonMainPanelApp, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    case 5: 
      return new MagicFaceAdapter(paramQQEmoticonMainPanelApp, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    case 3: 
      return new RecommendEmotionAdapter(paramQQEmoticonMainPanelApp, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback, paramInt4, paramBoolean);
    case 2: 
      return new SmallEmotionDownloadedAdapter(paramQQEmoticonMainPanelApp, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramEmoticonCallback, paramInt4);
    case 9: 
      return new SmallEmotionUpdateAdapter(paramQQEmoticonMainPanelApp, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramEmoticonCallback, paramInt4);
    case 12: 
      return new EmotionCompleteInvalidAdapter(paramQQEmoticonMainPanelApp, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramEmoticonCallback);
    case 13: 
      return new CameraEmotionAdapter(paramQQEmoticonMainPanelApp, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    case 14: 
      return new EmotionHotPicSearchAdapter(paramQQEmoticonMainPanelApp, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPanelListViewAdapterBuilder
 * JD-Core Version:    0.7.0.1
 */