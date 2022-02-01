package com.tencent.mobileqq.nearby.profilecard;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.service.gamecenter.AppLaucherHelper;
import com.tencent.open.business.base.AppUtil;
import com.tencent.qconn.protofile.fastauthorize.FastAuthorize.AuthorizeResponse;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

class ProfileQiqiLiveController$2
  implements BusinessObserver
{
  ProfileQiqiLiveController$2(ProfileQiqiLiveController paramProfileQiqiLiveController, String paramString, Context paramContext, int paramInt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    new Bundle();
    String str = this.a;
    Object localObject = str;
    if (paramBoolean)
    {
      localObject = paramBundle.getByteArray("data");
      try
      {
        paramBundle = new FastAuthorize.AuthorizeResponse();
        paramBundle.mergeFrom((byte[])localObject);
        this.d.d.removeMessages(6);
        if ((paramBundle.ret.get().equals("0")) && (paramBundle.apk_name.has()))
        {
          if (paramBundle.access_token.has())
          {
            localObject = paramBundle.access_token.get();
            this.d.b = this.d.b.replace("$AT$", (CharSequence)localObject);
          }
          if (paramBundle.pay_token.has())
          {
            localObject = paramBundle.pay_token.get();
            this.d.b = this.d.b.replace("$PT$", (CharSequence)localObject);
          }
          if (paramBundle.openid.has())
          {
            localObject = paramBundle.openid.get();
            this.d.b = this.d.b.replace("$OPID$", (CharSequence)localObject);
          }
          if (paramBundle.pfkey.has())
          {
            localObject = paramBundle.pfkey.get();
            this.d.b = this.d.b.replace("$PF$", (CharSequence)localObject);
          }
          if (paramBundle.encrykey.has())
          {
            localObject = paramBundle.encrykey.get();
            this.d.b = this.d.b.replace("$ESK$", (CharSequence)localObject);
          }
          localObject = paramBundle.apk_name.get();
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            return;
          }
          if (((String)localObject).contains(this.a)) {}
        }
        else
        {
          QLog.d(this.d.getClass().getSimpleName(), 4, "start without login state");
          localObject = str;
        }
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        localObject = str;
        if (QLog.isColorLevel())
        {
          QLog.d(this.d.getClass().getSimpleName(), 2, paramBundle.getMessage());
          localObject = str;
        }
      }
    }
    for (;;)
    {
      paramBundle = AppLaucherHelper.b(this.d.b);
      if (QLog.isColorLevel()) {
        QLog.d(getClass().getSimpleName(), 2, "lauchApp now");
      }
      AppUtil.a(this.b, (String)localObject, paramBundle, this.c);
      if (this.d.c != null)
      {
        this.d.c.setObserver(null);
        this.d.c = null;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.ProfileQiqiLiveController.2
 * JD-Core Version:    0.7.0.1
 */