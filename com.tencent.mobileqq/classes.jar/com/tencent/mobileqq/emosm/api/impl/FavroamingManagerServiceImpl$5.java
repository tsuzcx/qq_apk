package com.tencent.mobileqq.emosm.api.impl;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.FavEmoRoamingHandler;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class FavroamingManagerServiceImpl$5
  extends EmoticonPackageDownloadListener
{
  FavroamingManagerServiceImpl$5(FavroamingManagerServiceImpl paramFavroamingManagerServiceImpl) {}
  
  public void onPackageEnd(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    super.onPackageEnd(paramEmoticonPackage, paramInt);
    EmojiListenerManager.a().removeEmoticonPackageDownloadListener(this.a.downloadListener);
    Object localObject1 = (IFavroamingDBManagerService)FavroamingManagerServiceImpl.access$1000(this.a).getRuntimeService(IFavroamingDBManagerService.class);
    Object localObject2 = (IEmoticonManagerService)FavroamingManagerServiceImpl.access$1100(this.a).getRuntimeService(IEmoticonManagerService.class);
    List localList = ((IFavroamingDBManagerService)localObject1).findMagicEmosById(paramEmoticonPackage.epId);
    if (localList != null)
    {
      if (localList.size() <= 0) {
        return;
      }
      paramEmoticonPackage = new ArrayList();
      int i = 0;
      while (i < localList.size())
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)localList.get(i);
        if (((IEmoticonManagerService)localObject2).syncFindEmoticonById(localCustomEmotionData.emoPath, localCustomEmotionData.eId) == null)
        {
          localCustomEmotionData.RomaingType = "needDel";
          ((IFavroamingDBManagerService)localObject1).updateCustomEmotion(localCustomEmotionData);
          if (!TextUtils.isEmpty(localCustomEmotionData.resid)) {
            paramEmoticonPackage.add(localCustomEmotionData.resid);
          }
        }
        FavroamingManagerServiceImpl localFavroamingManagerServiceImpl = this.a;
        boolean bool;
        if (paramInt == 0) {
          bool = true;
        } else {
          bool = false;
        }
        localFavroamingManagerServiceImpl.onFileDone(localCustomEmotionData, bool);
        i += 1;
      }
      localObject1 = (FavEmoRoamingHandler)FavroamingManagerServiceImpl.access$1200(this.a).getBusinessHandler(FavEmoRoamingHandler.a);
      if ((localObject1 != null) && (paramEmoticonPackage.size() > 0))
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("delResId: ");
          ((StringBuilder)localObject2).append(paramEmoticonPackage);
          QLog.d("FavroamingManager", 2, ((StringBuilder)localObject2).toString());
        }
        ((FavEmoRoamingHandler)localObject1).a(paramEmoticonPackage, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.FavroamingManagerServiceImpl.5
 * JD-Core Version:    0.7.0.1
 */