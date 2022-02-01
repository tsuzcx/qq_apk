package com.tencent.mobileqq.extendfriend.limitchat;

import android.content.res.Resources;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.limitchat.LimitChatUtil;
import com.tencent.mobileqq.statistics.ReportController;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class AioLimitColdPalaceHelper$addBanishColdPalaceGrayTip$1
  implements Runnable
{
  AioLimitColdPalaceHelper$addBanishColdPalaceGrayTip$1(AioLimitColdPalaceHelper paramAioLimitColdPalaceHelper) {}
  
  public final void run()
  {
    QQAppInterface localQQAppInterface;
    if ((this.this$0.a().a != null) && (this.this$0.a() != null))
    {
      localQQAppInterface = this.this$0.a();
      localObject = this.this$0.a().a;
      if (localObject == null) {
        break label144;
      }
    }
    label144:
    for (Object localObject = ((SessionInfo)localObject).jdField_a_of_type_JavaLangString;; localObject = null)
    {
      LimitChatUtil.a(localQQAppInterface, (String)localObject, this.this$0.a().a.jdField_a_of_type_Int, this.this$0.a().a.d, this.this$0.a().getResources().getString(2131698697), 459802, this.this$0.a().getResources().getString(2131698698), 57, false, null, -1);
      ReportController.b(null, "dc00898", "", "", "0X800B2C2", "0X800B2C2", 0, 0, "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.AioLimitColdPalaceHelper.addBanishColdPalaceGrayTip.1
 * JD-Core Version:    0.7.0.1
 */