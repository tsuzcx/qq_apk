package com.vivo.push.c;

import android.text.TextUtils;
import android.util.Base64;
import com.vivo.push.e;
import com.vivo.push.l;
import com.vivo.push.sdk.PushMessageCallback;
import com.vivo.push.util.t;
import java.security.PublicKey;

public abstract class y
  extends l
{
  protected PushMessageCallback b;
  
  y(com.vivo.push.o paramo)
  {
    super(paramo);
  }
  
  public final void a(PushMessageCallback paramPushMessageCallback)
  {
    this.b = paramPushMessageCallback;
  }
  
  public final boolean a(PublicKey paramPublicKey, String paramString1, String paramString2)
  {
    if (!e.a().d())
    {
      com.vivo.push.util.o.d("OnVerifyCallBackCommand", "vertify is not support , vertify is ignore");
      return true;
    }
    if (paramPublicKey == null)
    {
      com.vivo.push.util.o.d("OnVerifyCallBackCommand", "vertify key is null");
      return false;
    }
    if (TextUtils.isEmpty(paramString1))
    {
      com.vivo.push.util.o.d("OnVerifyCallBackCommand", "contentTag is null");
      return false;
    }
    if (!TextUtils.isEmpty(paramString2)) {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString1.hashCode());
        localStringBuilder.append(" = ");
        localStringBuilder.append(paramString2);
        com.vivo.push.util.o.d("OnVerifyCallBackCommand", localStringBuilder.toString());
        if (t.a(paramString1.getBytes("UTF-8"), paramPublicKey, Base64.decode(paramString2, 2)))
        {
          com.vivo.push.util.o.d("OnVerifyCallBackCommand", "vertify id is success");
          return true;
        }
        com.vivo.push.util.o.d("OnVerifyCallBackCommand", "vertify fail srcDigest is ".concat(String.valueOf(paramString1)));
        com.vivo.push.util.o.c(this.a, "vertify fail srcDigest is ".concat(String.valueOf(paramString1)));
        return false;
      }
      catch (Exception paramPublicKey)
      {
        paramPublicKey.printStackTrace();
        com.vivo.push.util.o.d("OnVerifyCallBackCommand", "vertify exception");
        return false;
      }
    }
    com.vivo.push.util.o.d("OnVerifyCallBackCommand", "vertify id is null");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.c.y
 * JD-Core Version:    0.7.0.1
 */