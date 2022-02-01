package com.tencent.mobileqq.emosm.favroaming;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FavEmoRoamingHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class FavroamingManager$5
  extends EmoticonPackageDownloadListener
{
  FavroamingManager$5(FavroamingManager paramFavroamingManager) {}
  
  public void onPackageEnd(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    super.onPackageEnd(paramEmoticonPackage, paramInt);
    EmojiListenerManager.a().b(this.a.a);
    Object localObject = (FavroamingDBManager)FavroamingManager.i(this.a).getManager(QQManagerFactory.FAVROAMING_DB_MANAGER);
    EmoticonManager localEmoticonManager = (EmoticonManager)FavroamingManager.j(this.a).getManager(QQManagerFactory.EMOTICON_MANAGER);
    List localList = ((FavroamingDBManager)localObject).c(paramEmoticonPackage.epId);
    if ((localList == null) || (localList.size() <= 0)) {}
    do
    {
      return;
      paramEmoticonPackage = new ArrayList();
      int i = 0;
      if (i < localList.size())
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)localList.get(i);
        if (localEmoticonManager.a(localCustomEmotionData.emoPath, localCustomEmotionData.eId) == null)
        {
          localCustomEmotionData.RomaingType = "needDel";
          ((FavroamingDBManager)localObject).b(localCustomEmotionData);
          if (!TextUtils.isEmpty(localCustomEmotionData.resid)) {
            paramEmoticonPackage.add(localCustomEmotionData.resid);
          }
        }
        FavroamingManager localFavroamingManager = this.a;
        if (paramInt == 0) {}
        for (boolean bool = true;; bool = false)
        {
          localFavroamingManager.a(localCustomEmotionData, bool);
          i += 1;
          break;
        }
      }
      localObject = (FavEmoRoamingHandler)FavroamingManager.k(this.a).getBusinessHandler(BusinessHandlerFactory.FAVEMO_ROAMING_HANDLER);
    } while ((localObject == null) || (paramEmoticonPackage.size() <= 0));
    if (QLog.isColorLevel()) {
      QLog.d("FavroamingManager", 2, "delResId: " + paramEmoticonPackage);
    }
    ((FavEmoRoamingHandler)localObject).a(paramEmoticonPackage, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.FavroamingManager.5
 * JD-Core Version:    0.7.0.1
 */