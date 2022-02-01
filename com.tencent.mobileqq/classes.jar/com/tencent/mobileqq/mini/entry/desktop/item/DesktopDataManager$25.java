package com.tencent.mobileqq.mini.entry.desktop.item;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.mini.apkg.RecommendAppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class DesktopDataManager$25
  implements Runnable
{
  DesktopDataManager$25(DesktopDataManager paramDesktopDataManager, ArrayList paramArrayList) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = DesktopDataManager.getSharedPreferences("app_recommend_exposure");
    if (localSharedPreferences != null)
    {
      localSharedPreferences.edit().clear().commit();
      QLog.d("DesktopDataManager-Recommend", 2, "updateRecommendExposureSp : clear.");
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject = this.val$recommendAppInfoList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        RecommendAppInfo localRecommendAppInfo = (RecommendAppInfo)((Iterator)localObject).next();
        if (localRecommendAppInfo != null)
        {
          localStringBuilder.append(localRecommendAppInfo.getAppId());
          localStringBuilder.append("_");
          localStringBuilder.append(localRecommendAppInfo.getExposuredNum());
          localStringBuilder.append("_");
          localStringBuilder.append(localRecommendAppInfo.getPullTime());
          localStringBuilder.append(";");
        }
      }
      if (localStringBuilder.length() > 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateRecommendExposureSp : ");
        ((StringBuilder)localObject).append(localStringBuilder.toString());
        ((StringBuilder)localObject).append(", recommendAppList size: ");
        ((StringBuilder)localObject).append(this.val$recommendAppInfoList.size());
        QLog.d("DesktopDataManager-Recommend", 2, ((StringBuilder)localObject).toString());
        localSharedPreferences.edit().putString("app_recommend_exposure", localStringBuilder.toString()).commit();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager.25
 * JD-Core Version:    0.7.0.1
 */