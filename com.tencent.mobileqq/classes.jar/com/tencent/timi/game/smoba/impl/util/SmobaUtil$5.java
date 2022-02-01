package com.tencent.timi.game.smoba.impl.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService;
import com.tencent.timi.game.smoba.api.SmobaCheckCallback;
import com.tencent.timi.game.smoba.api.SmobaGangupCheckParam;

final class SmobaUtil$5
  implements DialogInterface.OnClickListener
{
  SmobaUtil$5(Activity paramActivity, SmobaCheckCallback paramSmobaCheckCallback, String paramString, SmobaGangupCheckParam paramSmobaGangupCheckParam, boolean paramBoolean) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).a((QBaseActivity)this.a, new SmobaUtil.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.util.SmobaUtil.5
 * JD-Core Version:    0.7.0.1
 */