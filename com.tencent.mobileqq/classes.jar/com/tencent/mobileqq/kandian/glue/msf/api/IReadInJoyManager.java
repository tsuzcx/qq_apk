package com.tencent.mobileqq.kandian.glue.msf.api;

import android.content.Intent;
import com.tencent.mobileqq.kandian.biz.reddot.ReadInJoyNotifyRedTouchInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import java.util.List;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.Nullable;

@Service(needUin=false, process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/msf/api/IReadInJoyManager;", "Lmqq/app/api/IRuntimeService;", "fillExtraPushInfo", "", "intent", "Landroid/content/Intent;", "handleChannelArticlePush", "channelId", "", "channelName", "", "wording", "articleIdList", "", "obtainCachedAppInfo", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "obtainCachedRedTypeInfo", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo;", "obtainLatestNotifyRedTouchInfo", "Lcom/tencent/mobileqq/kandian/biz/reddot/ReadInJoyNotifyRedTouchInfo;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoyManager
  extends IRuntimeService
{
  public abstract void fillExtraPushInfo(@Nullable Intent paramIntent);
  
  public abstract void handleChannelArticlePush(long paramLong, @Nullable String paramString1, @Nullable String paramString2, @Nullable List<Long> paramList);
  
  @Nullable
  public abstract BusinessInfoCheckUpdate.AppInfo obtainCachedAppInfo();
  
  @Nullable
  public abstract BusinessInfoCheckUpdate.RedTypeInfo obtainCachedRedTypeInfo();
  
  @Nullable
  public abstract ReadInJoyNotifyRedTouchInfo obtainLatestNotifyRedTouchInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyManager
 * JD-Core Version:    0.7.0.1
 */