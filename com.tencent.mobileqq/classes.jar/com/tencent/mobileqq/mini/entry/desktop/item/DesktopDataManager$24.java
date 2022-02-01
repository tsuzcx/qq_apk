package com.tencent.mobileqq.mini.entry.desktop.item;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.mini.apkg.RecommendAppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class DesktopDataManager$24
  implements Runnable
{
  DesktopDataManager$24(DesktopDataManager paramDesktopDataManager, ArrayList paramArrayList) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = DesktopDataManager.getSharedPreferences("app_recommend_exposure");
    if (localSharedPreferences != null)
    {
      localSharedPreferences.edit().clear().commit();
      QLog.d("DesktopDataManager-Recommend", 2, "updateRecommendExposureSp : clear.");
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.val$recommendAppInfoList.iterator();
      while (localIterator.hasNext())
      {
        RecommendAppInfo localRecommendAppInfo = (RecommendAppInfo)localIterator.next();
        if (localRecommendAppInfo != null) {
          localStringBuilder.append(localRecommendAppInfo.getAppId()).append("_").append(localRecommendAppInfo.getExposuredNum()).append("_").append(localRecommendAppInfo.getPullTime()).append(";");
        }
      }
      if (localStringBuilder.length() > 0)
      {
        QLog.d("DesktopDataManager-Recommend", 2, "updateRecommendExposureSp : " + localStringBuilder.toString() + ", recommendAppList size: " + this.val$recommendAppInfoList.size());
        localSharedPreferences.edit().putString("app_recommend_exposure", localStringBuilder.toString()).commit();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.24
 * JD-Core Version:    0.7.0.1
 */