package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.app.Activity;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyChannelActivity;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJWeiShiLegacyUtils$setRead$1
  implements Runnable
{
  RIJWeiShiLegacyUtils$setRead$1(QQAppInterface paramQQAppInterface, Activity paramActivity) {}
  
  public final void run()
  {
    Object localObject = new SessionInfo();
    ((SessionInfo)localObject).b = AppConstants.WEISHI_UIN;
    ((SessionInfo)localObject).a = 1008;
    ChatActivityFacade.a(this.a, (BaseSessionInfo)localObject);
    this.a.getMessageFacade().a(AppConstants.WEISHI_UIN, 1008);
    localObject = this.b;
    if ((localObject instanceof ReadInJoyChannelActivity))
    {
      if (localObject != null)
      {
        ((ReadInJoyChannelActivity)localObject).b();
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyChannelActivity");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.RIJWeiShiLegacyUtils.setRead.1
 * JD-Core Version:    0.7.0.1
 */