package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.api.IBigEmotionService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class EmotionPanelConstans
  extends EmoticonViewBinder
{
  public static final int COLUMNNUM_CAMERA_EMO = 4;
  public static final int COLUMNNUM_CMSHOW = 4;
  public static final int COLUMNNUM_FAVORITE = 4;
  public static final int COLUMNNUM_HOTPIC_SEARCH = 4;
  public static final int COLUMNNUM_MAGIC_FACE = 4;
  public static final int COLUMNNUM_RECOMMENT = 3;
  public static final int COLUMNNUM_SMALL_EMOTION = 7;
  public static final int COLUMNNUM_SYSTEM_AND_EMOJI = 7;
  public static final int COLUMNUM_BIG_EMOTION = 4;
  public static final int PANEL_TYPE_BIG_EMOTION_COMPLETE_INVALID = 10;
  public static final int PANEL_TYPE_BIG_EMOTION_DOWNLOADED = 6;
  public static final int PANEL_TYPE_BIG_EMOTION_NEED_UPDATE = 8;
  public static final int PANEL_TYPE_CAMERA_EMOTION = 13;
  public static final int PANEL_TYPE_CMSHOW_EMOTION = 15;
  public static final int PANEL_TYPE_EMOTION_COMPLETE_INVALID = 12;
  public static final int PANEL_TYPE_EMOTION_NEED_DOWNLOAD_OR_INVALID = 7;
  public static final int PANEL_TYPE_FAVORITE = 4;
  public static final int PANEL_TYPE_HOTPIC_SEARCH_EMOTION = 14;
  public static final int PANEL_TYPE_MAGIC_FACE = 5;
  public static final int PANEL_TYPE_RECOMMEND = 3;
  public static final int PANEL_TYPE_SMALL_EMOTION_COMPLETE_INVALID = 11;
  public static final int PANEL_TYPE_SMALL_EMOTION_DOWNLOADED = 2;
  public static final int PANEL_TYPE_SMALL_EMOTION_NEED_UPDATE = 9;
  public static final int PANEL_TYPE_SYSTEM_AND_EMOJI = 1;
  public static final String TAG = "EmotionPanelConstans";
  public static final int TYPE_CAMERA_EMOTICON = 11;
  public static final int TYPE_CMSHOW = 15;
  public static final int TYPE_HOTPIC_SEARCH_EMOTICON = 12;
  public static final int TYPE_MAGIC_FACE = 9;
  public static final int TYPE_PLUS_BUTTON = 13;
  public static final int TYPE_RECOMMEND = 8;
  public static final int TYPE_SETTING_BUTTON = 14;
  public static final int TYPE_SMALL_EMOTICON = 10;
  
  public EmotionPanelConstans(int paramInt)
  {
    super(paramInt);
  }
  
  private static int getEmotionPanelType(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, EmotionPanelInfo paramEmotionPanelInfo, boolean paramBoolean)
  {
    if ((paramIEmoticonMainPanelApp == null) || (paramEmotionPanelInfo == null))
    {
      QLog.e("EmotionPanelConstans", 1, "getEmotionPanelType app or panelinfo is null");
      return -1;
    }
    EmoticonPackage localEmoticonPackage = paramEmotionPanelInfo.emotionPkg;
    if (localEmoticonPackage == null)
    {
      QLog.e("EmotionPanelConstans", 1, "getEmotionPanelType emotionPkg is null; type = " + paramEmotionPanelInfo.type);
      return -1;
    }
    boolean bool = ((IBigEmotionService)QRoute.api(IBigEmotionService.class)).emoticonPkgNeedUpdate(localEmoticonPackage.status, localEmoticonPackage.updateFlag);
    int i = localEmoticonPackage.status;
    if (QLog.isColorLevel()) {
      QLog.d("EmotionPanelConstans", 2, "getEmotionPanelType epid = " + localEmoticonPackage.epId + "status = " + i + ";shouldUpdate = " + bool);
    }
    if ((!localEmoticonPackage.valid) || (i == 3) || (!isAuthorized(paramIEmoticonMainPanelApp, localEmoticonPackage)))
    {
      if (i == 2) {
        return 12;
      }
      return 7;
    }
    if (bool)
    {
      if (paramBoolean) {
        return 9;
      }
      return 8;
    }
    if (i != 2) {
      return 7;
    }
    if (paramBoolean) {
      return 2;
    }
    return 6;
  }
  
  public static int getPanelType(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, EmotionPanelInfo paramEmotionPanelInfo)
  {
    if (paramEmotionPanelInfo == null) {
      return -1;
    }
    int i = paramEmotionPanelInfo.type;
    if (QLog.isColorLevel()) {
      QLog.d("EmotionPanelConstans", 2, "getPanelType type = " + i);
    }
    switch (i)
    {
    case 5: 
    case 13: 
    case 14: 
    default: 
      return -1;
    case 4: 
      return 4;
    case 7: 
      return 1;
    case 9: 
      return 5;
    case 8: 
      return 3;
    case 6: 
      return getEmotionPanelType(paramIEmoticonMainPanelApp, paramEmotionPanelInfo, false);
    case 10: 
      return getEmotionPanelType(paramIEmoticonMainPanelApp, paramEmotionPanelInfo, true);
    case 11: 
      return 13;
    case 12: 
      return 14;
    }
    return 15;
  }
  
  public static boolean isAuthorized(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, EmoticonPackage paramEmoticonPackage)
  {
    if ((paramEmoticonPackage == null) || (paramIEmoticonMainPanelApp == null)) {
      return false;
    }
    return ((IBigEmotionService)QRoute.api(IBigEmotionService.class)).isAuthorized(paramIEmoticonMainPanelApp, paramEmoticonPackage.mobileFeetype);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPanelConstans
 * JD-Core Version:    0.7.0.1
 */