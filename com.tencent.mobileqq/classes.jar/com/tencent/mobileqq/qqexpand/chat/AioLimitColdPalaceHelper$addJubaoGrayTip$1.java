package com.tencent.mobileqq.qqexpand.chat;

import android.content.res.Resources;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class AioLimitColdPalaceHelper$addJubaoGrayTip$1
  implements Runnable
{
  AioLimitColdPalaceHelper$addJubaoGrayTip$1(AioLimitColdPalaceHelper paramAioLimitColdPalaceHelper) {}
  
  public final void run()
  {
    if ((this.this$0.a().a != null) && (this.this$0.a() != null))
    {
      ILimitChatUtils localILimitChatUtils = (ILimitChatUtils)QRoute.api(ILimitChatUtils.class);
      BaseQQAppInterface localBaseQQAppInterface = (BaseQQAppInterface)this.this$0.a();
      Object localObject = this.this$0.a().a;
      if (localObject != null) {
        localObject = ((SessionInfo)localObject).jdField_a_of_type_JavaLangString;
      } else {
        localObject = null;
      }
      localILimitChatUtils.addGrayTipsMessage(localBaseQQAppInterface, (String)localObject, this.this$0.a().a.jdField_a_of_type_Int, this.this$0.a().a.d, this.this$0.a().getResources().getString(2131698771), 459802, this.this$0.a().getResources().getString(2131698770), 57, null);
      ReportController.b(null, "dc00898", "", "", "0X800B2C2", "0X800B2C2", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.chat.AioLimitColdPalaceHelper.addJubaoGrayTip.1
 * JD-Core Version:    0.7.0.1
 */