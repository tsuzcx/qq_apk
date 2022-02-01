package com.tencent.mobileqq.emosm.vipcomic;

import android.text.TextUtils;
import com.tencent.mobileqq.data.VipComicFavorEmoStructMsgInfo;
import java.util.Map;

public class VipComicMqqManagerConstants
{
  public static String a(Map<String, VipComicFavorEmoStructMsgInfo> paramMap, String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!bool)
    {
      localObject1 = localObject2;
      if (paramMap != null)
      {
        if (paramMap.size() == 0) {
          return null;
        }
        paramMap = (VipComicFavorEmoStructMsgInfo)paramMap.get(paramString.toUpperCase());
        localObject1 = localObject2;
        if (paramMap != null) {
          localObject1 = paramMap.actionData;
        }
      }
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.vipcomic.VipComicMqqManagerConstants
 * JD-Core Version:    0.7.0.1
 */