package com.tencent.mobileqq.emoticonview;

import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.abtest.ABTestController;
import com.tencent.mobileqq.abtest.ExpEntityInfo;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StringUtil;
import java.util.List;

public class EmoticonStoreTabEntryUtils
{
  private static final String KEY_SHOW_EMOTICON_STORY_TAB_GUIDE = "key_show_emoticon_story_tab_guide";
  public static String URL_NEED_REPLEACE_BODY = "_wv=553648128&_cwv=8&_wwv=129";
  public static String URL_REPLEACE_BODY = "_wwv=128";
  private static String mEmoticonStoreHomeURLHeader = null;
  
  public static boolean checkIsMergeStoryEntry()
  {
    boolean bool = false;
    ExpEntityInfo localExpEntityInfo = ABTestController.a("exp_qq_msg_marketface_recommendtab_2");
    if (localExpEntityInfo.a()) {
      bool = true;
    }
    while (!localExpEntityInfo.b()) {
      return bool;
    }
    return false;
  }
  
  public static boolean checkIsNeedShowGuide()
  {
    boolean bool = checkIsMergeStoryEntry();
    Boolean localBoolean = (Boolean)SharedPreUtils.a("key_show_emoticon_story_tab_guide", Boolean.valueOf(true));
    return (bool) && (localBoolean.booleanValue());
  }
  
  public static boolean checkTabListCanShowGuide(List<EmotionPanelInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return false;
    }
    return ((EmotionPanelInfo)paramList.get(0)).type == 13;
  }
  
  public static boolean checkURLIsEmoStore(String paramString1, String paramString2)
  {
    if (StringUtil.a(paramString1)) {
      return false;
    }
    String str = null;
    if (!StringUtil.a(mEmoticonStoreHomeURLHeader)) {
      str = mEmoticonStoreHomeURLHeader;
    }
    while (StringUtil.a(str))
    {
      return false;
      if (!StringUtil.a(paramString2)) {
        str = paramString2;
      }
    }
    boolean bool = paramString1.startsWith(str);
    if ((!bool) && (QLog.isColorLevel())) {
      QLog.d("timweiliu_emoStore", 0, "checkURLIsEmoStore, url not equles compareURL = " + paramString1 + "  \n processHeader = " + str + "  \n orginEmotionStoreURL = " + paramString2);
    }
    return bool;
  }
  
  public static void doOnStoryGuideShowed()
  {
    SharedPreUtils.a("key_show_emoticon_story_tab_guide", Boolean.valueOf(false));
  }
  
  public static String processEmoStoreHomeUrl(String paramString)
  {
    if (StringUtil.a(paramString)) {
      return "";
    }
    return paramString.replace(URL_NEED_REPLEACE_BODY, URL_REPLEACE_BODY);
  }
  
  public static boolean removeSettingAndRecommendEntry(List<EmotionPanelInfo> paramList)
  {
    Object localObject1 = null;
    if ((paramList == null) || (paramList.size() == 0)) {
      return false;
    }
    int i = 0;
    Object localObject2 = null;
    EmotionPanelInfo localEmotionPanelInfo;
    if (i < paramList.size())
    {
      localEmotionPanelInfo = (EmotionPanelInfo)paramList.get(i);
      if (localEmotionPanelInfo.type == 14) {
        localObject2 = localEmotionPanelInfo;
      }
    }
    for (;;)
    {
      i += 1;
      break;
      if (localEmotionPanelInfo.type == 8)
      {
        localObject1 = localEmotionPanelInfo;
        continue;
        if (localObject2 != null) {
          paramList.remove(localObject2);
        }
        if (localObject1 != null) {
          paramList.remove(localObject1);
        }
        return true;
      }
    }
  }
  
  public static void setEmoStoreHomeURL(String paramString)
  {
    if (StringUtil.a(paramString))
    {
      mEmoticonStoreHomeURLHeader = null;
      return;
    }
    int i = paramString.indexOf("?");
    if (i > 0)
    {
      mEmoticonStoreHomeURLHeader = paramString.substring(0, i);
      return;
    }
    mEmoticonStoreHomeURLHeader = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonStoreTabEntryUtils
 * JD-Core Version:    0.7.0.1
 */