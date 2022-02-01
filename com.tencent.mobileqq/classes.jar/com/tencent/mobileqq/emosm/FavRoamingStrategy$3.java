package com.tencent.mobileqq.emosm;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FunnyPicHelperConstant;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class FavRoamingStrategy$3
  implements Runnable
{
  FavRoamingStrategy$3(FavRoamingStrategy paramFavRoamingStrategy, List paramList) {}
  
  public void run()
  {
    Object localObject1 = (IFavroamingDBManagerService)this.this$0.a.getRuntimeService(IFavroamingDBManagerService.class);
    if (QLog.isColorLevel()) {
      QLog.i("FavRoamingStrategy", 2, "Call getEmoticonDataList-1 from doDelete.");
    }
    Object localObject2 = ((IFavroamingDBManagerService)localObject1).getEmoticonDataList();
    int j = 1;
    int i = 1;
    if (localObject2 != null)
    {
      int k = 0;
      for (;;)
      {
        j = i;
        if (k >= ((List)localObject2).size()) {
          break;
        }
        int m = ((CustomEmotionData)((List)localObject2).get(k)).emoId;
        j = i;
        if (i < m) {
          j = m;
        }
        k += 1;
        i = j;
      }
    }
    localObject2 = new ArrayList();
    Iterator localIterator = this.this$0.d.iterator();
    while (localIterator.hasNext())
    {
      FavoriteEmoticonInfo localFavoriteEmoticonInfo = (FavoriteEmoticonInfo)localIterator.next();
      if (!this.a.contains(localFavoriteEmoticonInfo))
      {
        CustomEmotionData localCustomEmotionData = new CustomEmotionData();
        localCustomEmotionData.uin = this.this$0.a.getCurrentAccountUin();
        localCustomEmotionData.url = localFavoriteEmoticonInfo.path;
        localCustomEmotionData.eId = localFavoriteEmoticonInfo.eId;
        localCustomEmotionData.md5 = localFavoriteEmoticonInfo.action;
        j += 1;
        localCustomEmotionData.emoId = j;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(AppConstants.SDCARD_IMG_FAVORITE);
        localStringBuilder.append(FunnyPicHelperConstant.a(localFavoriteEmoticonInfo.path));
        localCustomEmotionData.emoPath = localStringBuilder.toString();
        ((IFavroamingDBManagerService)localObject1).insertCustomEmotion(localCustomEmotionData);
        ((List)localObject2).add(localCustomEmotionData);
      }
    }
    localObject1 = (IFavroamingManagerService)this.this$0.a.getRuntimeService(IFavroamingManagerService.class);
    if ((localObject1 != null) && (!((List)localObject2).isEmpty())) {
      ((IFavroamingManagerService)localObject1).syncUpload((List)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.FavRoamingStrategy.3
 * JD-Core Version:    0.7.0.1
 */