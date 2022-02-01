package com.tencent.mobileqq.profilecard.vas;

import android.os.Message;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;

class VasProfileTemplateController$2
  extends CallBacker
{
  VasProfileTemplateController$2(VasProfileTemplateController paramVasProfileTemplateController, ProfileCardTemplate paramProfileCardTemplate, Card paramCard) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if ((paramLong == 15L) && ("cardWZ.zip".equals(paramString1)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTemplateCheckController", 2, String.format("onCardUpdate WZRY template download,  errorCode=%s httpCode=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      }
      if (VasProfileTemplateController.access$100(this.this$0).b != null)
      {
        if (this.val$cardTemplate.a(VasProfileTemplateController.access$200(this.this$0), this.val$card.backgroundColor, this.val$card.lCurrentStyleId)) {
          VasProfileTemplateController.access$000(this.this$0).a = this.val$cardTemplate;
        }
        VasProfileTemplateController.access$100(this.this$0).b.obtainMessage(5, 0, 12, this.val$card).sendToTarget();
      }
      ((IVasQuickUpdateService)VasProfileTemplateController.access$200(this.this$0).getRuntimeService(IVasQuickUpdateService.class, "")).removeCallBacker(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.VasProfileTemplateController.2
 * JD-Core Version:    0.7.0.1
 */