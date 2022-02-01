package com.tencent.mobileqq.kandian.biz.daily.api.impl;

import android.content.Context;
import android.os.Bundle;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.kandian.biz.daily.api.IKandianDailyManager;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/daily/api/impl/KandianDailyManagerImpl;", "Lcom/tencent/mobileqq/kandian/biz/daily/api/IKandianDailyManager;", "()V", "getDailyMsgBoxName", "", "message", "Lcom/tencent/imcore/message/Message;", "launchKandianDaily", "", "ctx", "Landroid/content/Context;", "clearTop", "", "bundle", "Landroid/os/Bundle;", "launchFrom", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class KandianDailyManagerImpl
  implements IKandianDailyManager
{
  @Nullable
  public String getDailyMsgBoxName(@Nullable Message paramMessage)
  {
    return this.$$delegate_0.getDailyMsgBoxName(paramMessage);
  }
  
  public void launchKandianDaily(@Nullable Context paramContext)
  {
    this.$$delegate_0.launchKandianDaily(paramContext);
  }
  
  public void launchKandianDaily(@Nullable Context paramContext, boolean paramBoolean, @Nullable Bundle paramBundle, int paramInt)
  {
    this.$$delegate_0.launchKandianDaily(paramContext, paramBoolean, paramBundle, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.api.impl.KandianDailyManagerImpl
 * JD-Core Version:    0.7.0.1
 */