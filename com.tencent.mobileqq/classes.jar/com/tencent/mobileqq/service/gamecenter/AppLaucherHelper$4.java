package com.tencent.mobileqq.service.gamecenter;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.open.appcommon.OpensdkBusinessObserver;
import com.tencent.open.business.base.AppUtil;
import com.tencent.qconn.protofile.fastauthorize.FastAuthorize.AuthorizeResponse;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.NewIntent;

class AppLaucherHelper$4
  implements OpensdkBusinessObserver
{
  AppLaucherHelper$4(AppLaucherHelper paramAppLaucherHelper, long paramLong, String paramString, Context paramContext, int paramInt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("t=");
      ((StringBuilder)localObject1).append(System.currentTimeMillis() - this.a);
      QLog.d("AppLaucherHelper", 2, ((StringBuilder)localObject1).toString());
      QLog.d(this.e.getClass().getSimpleName(), 2, "onReceive");
    }
    new Bundle();
    Object localObject1 = this.b;
    Object localObject3;
    if (paramBoolean)
    {
      localObject3 = paramBundle.getByteArray("data");
      paramBundle = (Bundle)localObject1;
    }
    label1447:
    for (;;)
    {
      try
      {
        Object localObject2 = new FastAuthorize.AuthorizeResponse();
        paramBundle = (Bundle)localObject1;
        ((FastAuthorize.AuthorizeResponse)localObject2).mergeFrom((byte[])localObject3);
        paramBundle = (Bundle)localObject1;
        paramBoolean = QLog.isColorLevel();
        if (!paramBoolean) {
          break label1447;
        }
        paramBundle = (Bundle)localObject1;
        localObject3 = new StringBuilder();
        paramBundle = (Bundle)localObject1;
        ((StringBuilder)localObject3).append("ret=");
        paramBundle = (Bundle)localObject1;
        ((StringBuilder)localObject3).append(((FastAuthorize.AuthorizeResponse)localObject2).ret.get());
        paramBundle = (Bundle)localObject1;
        ((StringBuilder)localObject3).append(", ");
        paramBundle = (Bundle)localObject1;
        ((StringBuilder)localObject3).append("msg=");
        paramBundle = (Bundle)localObject1;
        ((StringBuilder)localObject3).append(((FastAuthorize.AuthorizeResponse)localObject2).msg.get());
        paramBundle = (Bundle)localObject1;
        ((StringBuilder)localObject3).append(", ");
        paramBundle = (Bundle)localObject1;
        ((StringBuilder)localObject3).append("access_token=");
        paramBundle = (Bundle)localObject1;
        ((StringBuilder)localObject3).append(((FastAuthorize.AuthorizeResponse)localObject2).access_token.get());
        paramBundle = (Bundle)localObject1;
        ((StringBuilder)localObject3).append(", ");
        paramBundle = (Bundle)localObject1;
        ((StringBuilder)localObject3).append("expires_in=");
        paramBundle = (Bundle)localObject1;
        PBInt64Field localPBInt64Field = ((FastAuthorize.AuthorizeResponse)localObject2).expires_in;
        try
        {
          ((StringBuilder)localObject3).append(localPBInt64Field.get());
          ((StringBuilder)localObject3).append(", ");
          ((StringBuilder)localObject3).append("openid=");
          ((StringBuilder)localObject3).append(((FastAuthorize.AuthorizeResponse)localObject2).openid.get());
          ((StringBuilder)localObject3).append(", ");
          ((StringBuilder)localObject3).append("pay_token=");
          ((StringBuilder)localObject3).append(((FastAuthorize.AuthorizeResponse)localObject2).pay_token.get());
          ((StringBuilder)localObject3).append(", ");
          ((StringBuilder)localObject3).append("pf=");
          ((StringBuilder)localObject3).append(((FastAuthorize.AuthorizeResponse)localObject2).pf.get());
          ((StringBuilder)localObject3).append(", ");
          ((StringBuilder)localObject3).append("pfkey=");
          ((StringBuilder)localObject3).append(((FastAuthorize.AuthorizeResponse)localObject2).pfkey.get());
          ((StringBuilder)localObject3).append(", ");
          ((StringBuilder)localObject3).append("encrykey=");
          ((StringBuilder)localObject3).append(((FastAuthorize.AuthorizeResponse)localObject2).encrykey.get());
          ((StringBuilder)localObject3).append(", ");
          ((StringBuilder)localObject3).append("apk_name=");
          ((StringBuilder)localObject3).append(((FastAuthorize.AuthorizeResponse)localObject2).apk_name.get());
          ((StringBuilder)localObject3).append(", ");
          paramBundle = new StringBuilder();
          paramBundle.append("FastAuthorize.AuthorizeResponse=[");
          paramBundle.append(((StringBuilder)localObject3).toString());
          paramBundle.append("]");
          QLog.d("AppLaucherHelper", 2, paramBundle.toString());
          paramBundle = (Bundle)localObject1;
          this.e.c.removeMessages(0);
          this.e.c.removeMessages(1);
          this.e.g.remove(this.b);
          if ((((FastAuthorize.AuthorizeResponse)localObject2).ret.get().equals("0")) && (((FastAuthorize.AuthorizeResponse)localObject2).apk_name.has()))
          {
            if (((FastAuthorize.AuthorizeResponse)localObject2).access_token.has())
            {
              paramBundle = ((FastAuthorize.AuthorizeResponse)localObject2).access_token.get();
              this.e.e = this.e.e.replace("$AT$", paramBundle);
            }
            if (((FastAuthorize.AuthorizeResponse)localObject2).pay_token.has())
            {
              paramBundle = ((FastAuthorize.AuthorizeResponse)localObject2).pay_token.get();
              this.e.e = this.e.e.replace("$PT$", paramBundle);
            }
            if (((FastAuthorize.AuthorizeResponse)localObject2).openid.has())
            {
              paramBundle = ((FastAuthorize.AuthorizeResponse)localObject2).openid.get();
              this.e.e = this.e.e.replace("$OPID$", paramBundle);
            }
            else
            {
              paramBundle = new StringBuilder();
              paramBundle.append("ret=");
              paramBundle.append(((FastAuthorize.AuthorizeResponse)localObject2).ret.get());
              paramBundle.append(", ");
              paramBundle.append("msg=");
              paramBundle.append(((FastAuthorize.AuthorizeResponse)localObject2).msg.get());
              paramBundle.append(", ");
              paramBundle.append("access_token=");
              paramBundle.append(((FastAuthorize.AuthorizeResponse)localObject2).access_token.get());
              paramBundle.append(", ");
              paramBundle.append("expires_in=");
              paramBundle.append(((FastAuthorize.AuthorizeResponse)localObject2).expires_in.get());
              paramBundle.append(", ");
              paramBundle.append("openid=");
              paramBundle.append(((FastAuthorize.AuthorizeResponse)localObject2).openid.get());
              paramBundle.append(", ");
              paramBundle.append("pay_token=");
              paramBundle.append(((FastAuthorize.AuthorizeResponse)localObject2).pay_token.get());
              paramBundle.append(", ");
              paramBundle.append("pf=");
              paramBundle.append(((FastAuthorize.AuthorizeResponse)localObject2).pf.get());
              paramBundle.append(", ");
              paramBundle.append("pfkey=");
              paramBundle.append(((FastAuthorize.AuthorizeResponse)localObject2).pfkey.get());
              paramBundle.append(", ");
              paramBundle.append("encrykey=");
              paramBundle.append(((FastAuthorize.AuthorizeResponse)localObject2).encrykey.get());
              paramBundle.append(", ");
              paramBundle.append("apk_name=");
              paramBundle.append(((FastAuthorize.AuthorizeResponse)localObject2).apk_name.get());
              paramBundle.append(", ");
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("FastAuthorize.AuthorizeResponse=[");
              ((StringBuilder)localObject3).append(paramBundle.toString());
              ((StringBuilder)localObject3).append("]");
              QLog.d("AppLaucherHelper", 1, ((StringBuilder)localObject3).toString());
            }
            if (((FastAuthorize.AuthorizeResponse)localObject2).pfkey.has())
            {
              paramBundle = ((FastAuthorize.AuthorizeResponse)localObject2).pfkey.get();
              this.e.e = this.e.e.replace("$PF$", paramBundle);
            }
            if (((FastAuthorize.AuthorizeResponse)localObject2).encrykey.has())
            {
              paramBundle = ((FastAuthorize.AuthorizeResponse)localObject2).encrykey.get();
              this.e.e = this.e.e.replace("$ESK$", paramBundle);
            }
            if (QLog.isColorLevel())
            {
              paramBundle = this.e.getClass().getSimpleName();
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("mParams=");
              ((StringBuilder)localObject3).append(this.e.e);
              QLog.d(paramBundle, 2, ((StringBuilder)localObject3).toString());
            }
            localObject2 = ((FastAuthorize.AuthorizeResponse)localObject2).apk_name.get();
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              paramBoolean = ((String)localObject2).contains(this.b);
              if (paramBoolean)
              {
                paramBundle = (Bundle)localObject2;
                localObject1 = this.e.getClass().getSimpleName();
                paramBundle = (Bundle)localObject2;
                localObject3 = new StringBuilder();
                paramBundle = (Bundle)localObject2;
                ((StringBuilder)localObject3).append("pkg=");
                paramBundle = (Bundle)localObject2;
                ((StringBuilder)localObject3).append((String)localObject2);
                paramBundle = (Bundle)localObject2;
                QLog.d((String)localObject1, 4, ((StringBuilder)localObject3).toString());
                paramBundle = (Bundle)localObject2;
                break label1354;
              }
            }
            AppLaucherHelper.a = false;
            QLog.d(this.e.getClass().getSimpleName(), 2, "cant't start app pkg invalide");
          }
          else
          {
            QLog.d(this.e.getClass().getSimpleName(), 4, "start without login state");
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1) {}
        paramBundle = (Bundle)localObject1;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
      {
        localObject1 = paramBundle;
      }
      if (QLog.isColorLevel())
      {
        QLog.d(this.e.getClass().getSimpleName(), 2, localInvalidProtocolBufferMicroException2.getMessage());
        paramBundle = (Bundle)localObject1;
      }
      label1354:
      localObject1 = paramBundle;
      break label1368;
      QLog.e("AppLaucherHelper", 1, "FastAuthorize.AuthorizeRequest failed");
      label1368:
      paramBundle = AppLaucherHelper.b(this.e.e);
      if (QLog.isColorLevel()) {
        QLog.d(getClass().getSimpleName(), 2, "lauchApp now");
      }
      AppUtil.a(this.c, (String)localObject1, paramBundle, this.d);
      AppLaucherHelper.a = false;
      if (this.e.b != null)
      {
        this.e.b.setObserver(null);
        this.e.b = null;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.gamecenter.AppLaucherHelper.4
 * JD-Core Version:    0.7.0.1
 */