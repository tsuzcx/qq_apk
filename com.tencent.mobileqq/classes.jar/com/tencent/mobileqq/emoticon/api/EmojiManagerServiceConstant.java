package com.tencent.mobileqq.emoticon.api;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.emoticon.TaskStatus;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class EmojiManagerServiceConstant
{
  public static int EMOTION_DOWNLOAD_TIMEOUT = 60000;
  public static boolean EMOTION_TRY_DOWNLOAD = false;
  public static final long ENCRYPT_KEY_TIMEOUT = 35000L;
  public static final long FETCH_PACKAGE_TIMEOUT = 35000L;
  public static final int FETCH_RETRY_MAX = 3;
  public static final String H5MAGIC_SP_ISPLAY_KEY = "h5magic_sp_isplay_key";
  public static final String H5MAGIC_SP_NAME = "h5magic_sp_name";
  public static final long INIT_FAV_TIMEOUT = 35000L;
  public static int JSON_EMOSM_KEYWORD = JSON_EMOSM_MALL + 1;
  public static int JSON_EMOSM_MALL = 1;
  public static final String KEY_PRE = "vipEmoticonKey_";
  public static final int MAGIC_FACE_SEND_INTERVAL = 15000;
  public static final String PARAMS_BUSINESS_TYPE = "businessType";
  public static final String PARAMS_EMOTICON_EID = "emoticonId";
  public static final String PARAMS_EMOTICON_LIST = "emoticonList";
  public static final String PARAMS_IS_SMALLEMOTION = "isSmallEmotion";
  public static final String PARAMS_IS_UPDATE = "isUpdate";
  public static final String PARAMS_JSON_TYPE = "jsonType";
  public static final String PARAMS_KEY_EMOTICONPKG = "emoticonPackage";
  public static final String PARAMS_KEY_MAGIC_ROAMING = "magic_roaming";
  public static final String PARAMS_PKG_NEW_ADD = "newPkgAdd";
  public static final String PARAMS_REQ = "jsonReqParams";
  public static final String PARAMS_SWITCH_TAB = "wifiAutoDownload";
  public static final int S_MAX_CONTINUOUS_PLAY_TIMES = 4;
  
  public static TaskStatus getStatus(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    if (paramBaseQQAppInterface != null)
    {
      paramBaseQQAppInterface = (IEmojiManagerService)paramBaseQQAppInterface.getRuntimeService(IEmojiManagerService.class);
      if (paramBaseQQAppInterface != null) {
        return (TaskStatus)paramBaseQQAppInterface.getStatusMap().get(paramString);
      }
    }
    return null;
  }
  
  public static boolean isCover(int paramInt)
  {
    return (paramInt == 3) || (paramInt == 4) || (paramInt == 2);
  }
  
  public static void printStackTraces(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    Object localObject = Thread.currentThread().getStackTrace();
    int i = Math.min(paramInt, localObject.length);
    paramInt = 2;
    String str1 = "";
    while (paramInt < i)
    {
      String str2 = localObject[paramInt];
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str2.getClassName());
      localStringBuilder.append(".");
      localStringBuilder.append(str2.getMethodName());
      str2 = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str1);
      localStringBuilder.append(" ");
      localStringBuilder.append(str2);
      str1 = localStringBuilder.toString();
      paramInt += 1;
    }
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("epId illegal,stacktrace:");
      ((StringBuilder)localObject).append(str1);
      QLog.d("Q.emoji.EmoDown", 4, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.api.EmojiManagerServiceConstant
 * JD-Core Version:    0.7.0.1
 */