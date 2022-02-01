package com.tencent.mobileqq.kandian.biz.daily.api;

import android.content.Context;
import android.os.Bundle;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/daily/api/IKandianDailyManager;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getDailyMsgBoxName", "", "message", "Lcom/tencent/imcore/message/Message;", "launchKandianDaily", "", "ctx", "Landroid/content/Context;", "clearTop", "", "bundle", "Landroid/os/Bundle;", "launchFrom", "", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IKandianDailyManager
  extends QRouteApi
{
  @Nullable
  public abstract String getDailyMsgBoxName(@Nullable Message paramMessage);
  
  public abstract void launchKandianDaily(@Nullable Context paramContext);
  
  public abstract void launchKandianDaily(@Nullable Context paramContext, boolean paramBoolean, @Nullable Bundle paramBundle, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.api.IKandianDailyManager
 * JD-Core Version:    0.7.0.1
 */