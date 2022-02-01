package com.tencent.mobileqq.emosm.api.impl;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class FavroamingManagerServiceImpl$9
  implements Runnable
{
  FavroamingManagerServiceImpl$9(FavroamingManagerServiceImpl paramFavroamingManagerServiceImpl, BaseQQAppInterface paramBaseQQAppInterface) {}
  
  public void run()
  {
    Object localObject = (IFavroamingDBManagerService)this.a.getRuntimeService(IFavroamingDBManagerService.class);
    IEmoticonManagerService localIEmoticonManagerService = (IEmoticonManagerService)this.a.getRuntimeService(IEmoticonManagerService.class);
    localObject = ((IFavroamingDBManagerService)localObject).getEmoticonDataList();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      HashMap localHashMap = new HashMap();
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)localIterator.next();
        String str = "";
        if (localCustomEmotionData.isMarkFace)
        {
          Emoticon localEmoticon = localIEmoticonManagerService.syncFindEmoticonById(localCustomEmotionData.emoPath, localCustomEmotionData.eId);
          localObject = str;
          if (localEmoticon != null)
          {
            localObject = str;
            if (!TextUtils.isEmpty(localEmoticon.name)) {
              localObject = localEmoticon.name;
            }
          }
        }
        else
        {
          if (!TextUtils.isEmpty(localCustomEmotionData.modifyWord)) {
            str = localCustomEmotionData.modifyWord;
          }
          localObject = str;
          if (TextUtils.isEmpty(str))
          {
            localObject = str;
            if (!TextUtils.isEmpty(localCustomEmotionData.ocrWord)) {
              localObject = localCustomEmotionData.ocrWord;
            }
          }
        }
        localHashMap.put(Integer.valueOf(localCustomEmotionData.emoId), localObject);
      }
      FavroamingManagerServiceImpl.access$2100(this.this$0, localHashMap);
      return;
    }
    QLog.d("FavroamingManager", 2, "[cacheAccessibilityEmotionData] emoticonDataList is empty!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.FavroamingManagerServiceImpl.9
 * JD-Core Version:    0.7.0.1
 */