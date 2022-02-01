package com.tencent.mobileqq.profilecard.vas;

import com.tencent.mobileqq.activity.VipProfileCardDiyActivity;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.qphone.base.util.QLog;

class VasProfileTemplateController$1
  extends CallBacker
{
  VasProfileTemplateController$1(VasProfileTemplateController paramVasProfileTemplateController, int paramInt, IVasQuickUpdateService paramIVasQuickUpdateService) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if (VipProfileCardDiyActivity.a(paramLong, paramString1, this.val$diyTextFontId))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileTemplateCheckController", 2, String.format("onCardUpdate DIY text font download,  errorCode=%s httpCode=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      }
      if (paramInt1 == 0) {
        VasProfileTemplateController.access$000(this.this$0);
      }
      this.val$mgr.removeCallBacker(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.VasProfileTemplateController.1
 * JD-Core Version:    0.7.0.1
 */