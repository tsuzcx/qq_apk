package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.forward.ForwardStatisticsReporter;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class JumpActionLegacy$18
  implements Runnable
{
  JumpActionLegacy$18(JumpActionLegacy paramJumpActionLegacy, String paramString1, boolean paramBoolean1, String paramString2, boolean paramBoolean2, long paramLong, HashMap paramHashMap) {}
  
  public void run()
  {
    Object localObject = this.a;
    if (this.b) {
      localObject = JumpActionLegacy.a(this.this$0, this.c);
    }
    if (this.d) {
      JumpActionLegacy.b(this.this$0, (String)localObject);
    }
    long l = System.currentTimeMillis() - this.e;
    ForwardStatisticsReporter.a("KEY_STAGE_1_SAVE_IMAGE", l, this.f, true);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("gotoShareMsgCheck cost=");
    ((StringBuilder)localObject).append(l);
    QLog.i("JumpAction", 1, ((StringBuilder)localObject).toString());
    JumpActionLegacy.n(this.this$0);
    if ((!this.this$0.v) && (!((IMiniAppService)QRoute.api(IMiniAppService.class)).isSharingMiniProgram(this.this$0.f)) && ((this.this$0.b instanceof JumpActivity))) {
      ((JumpActivity)this.this$0.b).finish();
    }
    if (((this.this$0.b instanceof GesturePWDUnlockActivity)) && (this.this$0.w)) {
      ((GesturePWDUnlockActivity)this.this$0.b).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.JumpActionLegacy.18
 * JD-Core Version:    0.7.0.1
 */