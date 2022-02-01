package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.core.util.EmotionSharedPreUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class EmoticonStoreTabEntryUtils
{
  private static final String KEY_SHOW_EMOTICON_STORY_TAB_GUIDE = "key_show_emoticon_story_tab_guide";
  public static String URL_NEED_REPLEACE_BODY = "_wv=553648128&_cwv=8&_wwv=129";
  public static String URL_REPLEACE_BODY = "_wwv=128";
  
  public static boolean checkIsNeedShowGuide()
  {
    return ((Boolean)EmotionSharedPreUtils.b("key_show_emoticon_story_tab_guide", Boolean.valueOf(true))).booleanValue();
  }
  
  public static boolean checkTabListCanShowGuide(List<EmotionPanelInfo> paramList)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return false;
      }
      bool1 = bool2;
      if (((EmotionPanelInfo)paramList.get(0)).type == 13) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean checkURLIsEmoStore(String paramString1, String paramString2)
  {
    if ((!StringUtil.isEmpty(paramString1)) && (!StringUtil.isEmpty(paramString2)))
    {
      boolean bool = paramString1.startsWith(paramString2);
      if ((!bool) && (QLog.isColorLevel()))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkURLIsEmoStore, url not equles compareURL = ");
        localStringBuilder.append(paramString1);
        localStringBuilder.append("  \n orginEmotionStoreURL = ");
        localStringBuilder.append(paramString2);
        QLog.d("emoStore", 2, localStringBuilder.toString());
      }
      return bool;
    }
    return false;
  }
  
  public static void doOnStoryGuideShowed()
  {
    EmotionSharedPreUtils.a("key_show_emoticon_story_tab_guide", Boolean.valueOf(false));
  }
  
  public static String processEmoStoreHomeUrl(String paramString)
  {
    if (StringUtil.isEmpty(paramString)) {
      return "";
    }
    return paramString.replace(URL_NEED_REPLEACE_BODY, URL_REPLEACE_BODY);
  }
  
  public static boolean removeSettingAndRecommendEntry(List<EmotionPanelInfo> paramList)
  {
    int i = 0;
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return false;
      }
      Object localObject1 = null;
      Object localObject2 = null;
      while (i < paramList.size())
      {
        EmotionPanelInfo localEmotionPanelInfo = (EmotionPanelInfo)paramList.get(i);
        Object localObject3;
        if (localEmotionPanelInfo.type == 14)
        {
          localObject3 = localEmotionPanelInfo;
        }
        else
        {
          localObject3 = localObject1;
          if (localEmotionPanelInfo.type == 8)
          {
            localObject2 = localEmotionPanelInfo;
            localObject3 = localObject1;
          }
        }
        i += 1;
        localObject1 = localObject3;
      }
      if (localObject1 != null) {
        paramList.remove(localObject1);
      }
      if (localObject2 != null) {
        paramList.remove(localObject2);
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonStoreTabEntryUtils
 * JD-Core Version:    0.7.0.1
 */