package com.tencent.mobileqq.kandian.repo.webarticle;

import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.webprocess.WebProcessReceiver;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class DataPreloadModule$preloadArticle$runnable$1
  implements Runnable
{
  DataPreloadModule$preloadArticle$runnable$1(AbsBaseArticleInfo paramAbsBaseArticleInfo) {}
  
  public final void run()
  {
    Intent localIntent = new Intent((Context)BaseApplicationImpl.getApplication(), WebProcessReceiver.class);
    localIntent.setAction("action_preload_rij_article_data");
    localIntent.putExtra("attribute_key_rowKey", this.a.innerUniqueID);
    try
    {
      BaseApplicationImpl.getApplication().sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[preload] e = ");
      localStringBuilder.append(localException);
      QLog.e("RIJWebArticlePreloadUtil", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.webarticle.DataPreloadModule.preloadArticle.runnable.1
 * JD-Core Version:    0.7.0.1
 */