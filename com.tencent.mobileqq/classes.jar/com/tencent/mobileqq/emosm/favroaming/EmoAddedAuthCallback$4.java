package com.tencent.mobileqq.emosm.favroaming;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.List;

class EmoAddedAuthCallback$4
  implements Runnable
{
  EmoAddedAuthCallback$4(EmoAddedAuthCallback paramEmoAddedAuthCallback) {}
  
  public void run()
  {
    int i = ((FavroamingDBManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.FAVROAMING_DB_MANAGER)).b().size();
    if (i != FavEmoConstant.b)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("local_size", String.valueOf(i));
      localHashMap.put("roaming_max_size", String.valueOf(FavEmoConstant.b));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "AddFavEmotionError", false, 0L, 0L, localHashMap, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.EmoAddedAuthCallback.4
 * JD-Core Version:    0.7.0.1
 */