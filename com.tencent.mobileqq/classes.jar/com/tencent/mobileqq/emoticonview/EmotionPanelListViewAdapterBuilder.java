package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.EmotionPanelInjectionInfoManager;
import com.tencent.mobileqq.core.EmotionPanelBuilderDirector;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmotionInjectionInfo;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.qphone.base.util.QLog;

public class EmotionPanelListViewAdapterBuilder
{
  public static final String TAG = "EmotionPanelListViewAdapterBuilder";
  private static EmotionPanelListViewAdapterBuilder sInstance;
  
  public static EmotionPanelListViewAdapterBuilder getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new EmotionPanelListViewAdapterBuilder();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  public BaseEmotionAdapter getAdapter(QQEmoticonMainPanelApp paramQQEmoticonMainPanelApp, Context paramContext, EmotionPanelInjectionInfoManager paramEmotionPanelInjectionInfoManager, IPanelInteractionListener paramIPanelInteractionListener, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, EmoticonCallback paramEmoticonCallback, int paramInt4, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getAdapter panelType = ");
      localStringBuilder.append(paramInt2);
      QLog.d("EmotionPanelListViewAdapterBuilder", 2, localStringBuilder.toString());
    }
    switch (paramInt2)
    {
    case 10: 
    case 11: 
    default: 
      if (paramEmotionPanelInjectionInfoManager != null)
      {
        paramQQEmoticonMainPanelApp = paramEmotionPanelInjectionInfoManager.a(paramInt3);
        if ((paramQQEmoticonMainPanelApp != null) && (paramQQEmoticonMainPanelApp.emotionPanelBuilder != null)) {
          return new EmotionPanelBuilderDirector().a(paramQQEmoticonMainPanelApp.emotionPanelBuilder);
        }
      }
      break;
    case 14: 
      return new EmotionHotPicSearchAdapter(paramQQEmoticonMainPanelApp, paramIPanelInteractionListener, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    case 13: 
      return new CameraEmotionAdapter(paramQQEmoticonMainPanelApp, paramIPanelInteractionListener, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    case 12: 
      return new EmotionCompleteInvalidAdapter(paramQQEmoticonMainPanelApp, paramIPanelInteractionListener, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramEmoticonCallback);
    case 9: 
      return new SmallEmotionUpdateAdapter(paramQQEmoticonMainPanelApp, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramEmoticonCallback, paramInt4);
    case 8: 
      return new BigEmotionUpdateAdapter(paramQQEmoticonMainPanelApp, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramEmoticonCallback, paramInt4);
    case 7: 
      return new EmotionDownloadOrInvalidAdapter(paramQQEmoticonMainPanelApp, paramIPanelInteractionListener, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramEmoticonCallback, paramInt4);
    case 6: 
      return new BigEmotionDownloadedAdapter(paramQQEmoticonMainPanelApp, paramIPanelInteractionListener, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramEmoticonCallback, paramInt4);
    case 5: 
      return new MagicFaceAdapter(paramQQEmoticonMainPanelApp, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    case 4: 
      return new FavoriteEmotionAdapter(paramQQEmoticonMainPanelApp, paramIPanelInteractionListener, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    case 3: 
      return new RecommendEmotionAdapter(paramQQEmoticonMainPanelApp, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback, paramInt4, paramBoolean);
    case 2: 
      return new SmallEmotionDownloadedAdapter(paramQQEmoticonMainPanelApp, paramIPanelInteractionListener, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramEmoticonCallback, paramInt4);
    case 1: 
      return new SystemAndEmojiAdapter(paramQQEmoticonMainPanelApp, paramIPanelInteractionListener, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback, paramInt4);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPanelListViewAdapterBuilder
 * JD-Core Version:    0.7.0.1
 */