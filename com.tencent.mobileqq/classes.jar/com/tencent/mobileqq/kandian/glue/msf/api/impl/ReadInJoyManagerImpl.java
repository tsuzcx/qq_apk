package com.tencent.mobileqq.kandian.glue.msf.api.impl;

import android.content.Intent;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyManager;
import com.tencent.mobileqq.kandian.biz.reddot.ReadInJoyNotifyRedTouchInfo;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import java.util.List;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/msf/api/impl/ReadInJoyManagerImpl;", "Lcom/tencent/mobileqq/kandian/glue/msf/api/IReadInJoyManager;", "()V", "readInJoyManager", "Lcom/tencent/mobileqq/kandian/biz/common/ReadInJoyManager;", "fillExtraPushInfo", "", "intent", "Landroid/content/Intent;", "handleChannelArticlePush", "channelId", "", "channelName", "", "wording", "articleIdList", "", "obtainCachedAppInfo", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "obtainCachedRedTypeInfo", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo;", "obtainLatestNotifyRedTouchInfo", "Lcom/tencent/mobileqq/kandian/biz/reddot/ReadInJoyNotifyRedTouchInfo;", "onCreate", "appRuntime", "Lmqq/app/AppRuntime;", "onDestroy", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyManagerImpl
  implements IReadInJoyManager
{
  private ReadInJoyManager readInJoyManager;
  
  public void fillExtraPushInfo(@Nullable Intent paramIntent)
  {
    ReadInJoyManager localReadInJoyManager = this.readInJoyManager;
    if (localReadInJoyManager != null) {
      localReadInJoyManager.a(paramIntent);
    }
  }
  
  public void handleChannelArticlePush(long paramLong, @Nullable String paramString1, @Nullable String paramString2, @Nullable List<Long> paramList)
  {
    ReadInJoyManager localReadInJoyManager = this.readInJoyManager;
    if (localReadInJoyManager != null) {
      localReadInJoyManager.a(paramLong, paramString1, paramString2, paramList);
    }
  }
  
  @Nullable
  public BusinessInfoCheckUpdate.AppInfo obtainCachedAppInfo()
  {
    ReadInJoyManager localReadInJoyManager = this.readInJoyManager;
    if (localReadInJoyManager != null) {
      return localReadInJoyManager.b();
    }
    return null;
  }
  
  @Nullable
  public BusinessInfoCheckUpdate.RedTypeInfo obtainCachedRedTypeInfo()
  {
    ReadInJoyManager localReadInJoyManager = this.readInJoyManager;
    if (localReadInJoyManager != null) {
      return localReadInJoyManager.a();
    }
    return null;
  }
  
  @Nullable
  public ReadInJoyNotifyRedTouchInfo obtainLatestNotifyRedTouchInfo()
  {
    ReadInJoyManager localReadInJoyManager = this.readInJoyManager;
    if (localReadInJoyManager != null) {
      return localReadInJoyManager.c();
    }
    return null;
  }
  
  public void onCreate(@Nullable AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime != null) {
      paramAppRuntime = paramAppRuntime.getManager(QQManagerFactory.READINJOY_MANAGER);
    } else {
      paramAppRuntime = null;
    }
    this.readInJoyManager = ((ReadInJoyManager)paramAppRuntime);
  }
  
  public void onDestroy()
  {
    this.readInJoyManager = ((ReadInJoyManager)null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.msf.api.impl.ReadInJoyManagerImpl
 * JD-Core Version:    0.7.0.1
 */