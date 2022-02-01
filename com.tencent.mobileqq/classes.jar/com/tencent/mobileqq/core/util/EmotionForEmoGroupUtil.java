package com.tencent.mobileqq.core.util;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class EmotionForEmoGroupUtil
{
  public static int a(Context paramContext, String paramString)
  {
    paramContext = (BaseQQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    String str = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
    IFavroamingDBManagerService localIFavroamingDBManagerService = (IFavroamingDBManagerService)paramContext.getRuntimeService(IFavroamingDBManagerService.class);
    if (QLog.isColorLevel()) {
      QLog.i("EmotionForEmoGroupUtil", 2, "Call getEmoticonDataList from addCustomEmotionForEmoGroup.");
    }
    Object localObject = localIFavroamingDBManagerService.getEmoticonDataList();
    if (localObject != null)
    {
      int j = 0;
      for (int i = 1;; i = k)
      {
        k = i;
        if (j >= ((List)localObject).size()) {
          break;
        }
        int m = ((CustomEmotionData)((List)localObject).get(j)).emoId;
        if ((paramString != null) && (paramString.equals(((CustomEmotionData)((List)localObject).get(j)).emoPath))) {
          return 2;
        }
        if ((str != null) && (((CustomEmotionData)((List)localObject).get(j)).md5 != null) && (str.equals(((CustomEmotionData)((List)localObject).get(j)).md5)))
        {
          if ("needDel".equals(((CustomEmotionData)((List)localObject).get(j)).RomaingType))
          {
            localIFavroamingDBManagerService.updateDeletedEmoticon((CustomEmotionData)((List)localObject).get(j), j);
            paramContext = ((IEmosmService)QRoute.api(IEmosmService.class)).getChatActivityHander(paramContext);
            if (paramContext != null) {
              paramContext.obtainMessage(10).sendToTarget();
            }
            return 0;
          }
          return 2;
        }
        k = i;
        if (i < m) {
          k = m;
        }
        j += 1;
      }
    }
    int k = 1;
    localObject = new CustomEmotionData();
    ((CustomEmotionData)localObject).uin = paramContext.getCurrentAccountUin();
    ((CustomEmotionData)localObject).emoId = (k + 1);
    ((CustomEmotionData)localObject).emoPath = paramString;
    ((CustomEmotionData)localObject).md5 = str;
    localIFavroamingDBManagerService.insertCustomEmotion((CustomEmotionData)localObject);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith(AppConstants.SDCARD_EMOTIOCN_DIY))) {
      ReportController.b(null, "CliOper", "", "", "ep_mall", "0X800695C", 0, 0, "", "", "", "");
    }
    paramContext = (IFavroamingManagerService)paramContext.getRuntimeService(IFavroamingManagerService.class);
    if (paramContext != null) {
      paramContext.syncUpload((CustomEmotionData)localObject);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.core.util.EmotionForEmoGroupUtil
 * JD-Core Version:    0.7.0.1
 */