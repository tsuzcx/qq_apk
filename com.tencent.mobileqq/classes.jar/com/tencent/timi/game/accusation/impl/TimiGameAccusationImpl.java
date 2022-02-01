package com.tencent.timi.game.accusation.impl;

import android.content.Intent;
import android.os.Handler;
import android.util.Base64;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.base.TimiGameActivityManager;
import com.tencent.timi.game.env.Env;
import com.tencent.timi.game.net.api.NetApi;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.ui.widget.EmptyDialog;
import java.net.URLEncoder;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import mqq.util.WeakReference;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import trpc.yes.common.SafeOuterClass.QQGetUserSafeSercetRsp;

public class TimiGameAccusationImpl
{
  private static WeakReference<EmptyDialog> a;
  private static String b = "";
  
  public static void a(AccusationParams paramAccusationParams)
  {
    if (paramAccusationParams == null)
    {
      if (Env.b()) {
        QLog.d("TimiGameAccusationImpl", 4, "reportParam is empty");
      }
      return;
    }
    c(paramAccusationParams);
    if (Env.b()) {
      QLog.d("TimiGameAccusationImpl", 4, "startReport");
    }
  }
  
  private static String b(String paramString)
  {
    try
    {
      paramString = Base64.decode(paramString, 0);
      localObject = new SecretKeySpec(b.getBytes(), "AES");
      Cipher localCipher = Cipher.getInstance("AES/ECB/NoPadding");
      localCipher.init(2, (Key)localObject);
      paramString = new String(localCipher.doFinal(paramString), "utf-8");
      return paramString;
    }
    catch (Throwable paramString)
    {
      Object localObject;
      if (Env.b())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("decrypt key error! ");
        ((StringBuilder)localObject).append(paramString);
        QLog.e("TimiGameAccusationImpl", 4, ((StringBuilder)localObject).toString());
      }
    }
    return "";
  }
  
  private static void b(AccusationParams paramAccusationParams, String paramString)
  {
    QLog.d("TimiGameAccusationImpl", 4, "navigateToEvilReportPage");
    StringBuilder localStringBuilder = new StringBuilder("https://jubao.qq.com/uniform_impeach/impeach_entry");
    localStringBuilder.append("?system=");
    localStringBuilder.append(paramAccusationParams.a);
    localStringBuilder.append("&version=");
    localStringBuilder.append(paramAccusationParams.b);
    localStringBuilder.append("&uintype=");
    localStringBuilder.append(paramAccusationParams.c);
    localStringBuilder.append("&eviluin=");
    localStringBuilder.append(paramAccusationParams.d);
    localStringBuilder.append("&appname=");
    localStringBuilder.append(paramAccusationParams.e);
    localStringBuilder.append("&appid=");
    localStringBuilder.append(paramAccusationParams.f);
    localStringBuilder.append("&subapp=");
    localStringBuilder.append(paramAccusationParams.g);
    localStringBuilder.append("&scene=");
    localStringBuilder.append(paramAccusationParams.h);
    localStringBuilder.append("&buddyflag=");
    localStringBuilder.append(paramAccusationParams.i);
    localStringBuilder.append("&contentid=");
    localStringBuilder.append(paramAccusationParams.j);
    localStringBuilder.append("&srv_para=");
    localStringBuilder.append(paramAccusationParams.k);
    localStringBuilder.append("&text_evidence=");
    localStringBuilder.append(paramAccusationParams.l);
    localStringBuilder.append("&img_evidence=");
    localStringBuilder.append(URLEncoder.encode(paramAccusationParams.m));
    localStringBuilder.append("&url_evidence=");
    localStringBuilder.append(paramAccusationParams.n);
    localStringBuilder.append("&video_evidence=");
    localStringBuilder.append(URLEncoder.encode(paramAccusationParams.o));
    localStringBuilder.append("&file_evidence=");
    localStringBuilder.append(paramAccusationParams.p);
    localStringBuilder.append("&audio_evidence=");
    localStringBuilder.append(paramAccusationParams.q);
    localStringBuilder.append("&user_input_param=");
    localStringBuilder.append(paramAccusationParams.r);
    localStringBuilder.append("&groupid=");
    localStringBuilder.append(paramAccusationParams.s);
    localStringBuilder.append("&cryptograph=");
    localStringBuilder.append(c(paramAccusationParams, paramString));
    QLog.d("TimiGameAccusationImpl", 4, localStringBuilder.toString());
    try
    {
      paramAccusationParams = TimiGameActivityManager.a();
      paramString = new Intent(paramAccusationParams, QQBrowserActivity.class);
      paramString.putExtra("hide_more_button", true);
      paramString.putExtra("ishiderefresh", true);
      paramString.putExtra("ishidebackforward", true);
      paramAccusationParams.startActivity(paramString.putExtra("url", localStringBuilder.toString()));
      return;
    }
    catch (Exception paramAccusationParams)
    {
      if (Env.b())
      {
        paramString = new StringBuilder();
        paramString.append("doJumpReport exception: ");
        paramString.append(paramAccusationParams.getMessage());
        QLog.d("TimiGameAccusationImpl", 2, paramString.toString());
      }
    }
  }
  
  private static void b(boolean paramBoolean)
  {
    QBaseActivity localQBaseActivity = TimiGameActivityManager.a();
    if (localQBaseActivity == null)
    {
      QLog.e("TimiGameAccusationImpl", 4, "Context is null ");
      return;
    }
    if (paramBoolean)
    {
      QLog.d("TimiGameAccusationImpl", 4, "Post to show Dialog ");
      ThreadManagerV2.getUIHandlerV2().post(new TimiGameAccusationImpl.3(localQBaseActivity));
      return;
    }
    QLog.d("TimiGameAccusationImpl", 4, "Post to hide Dialog ");
    ThreadManagerV2.getUIHandlerV2().post(new TimiGameAccusationImpl.4());
  }
  
  private static String c(AccusationParams paramAccusationParams, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramAccusationParams.a);
    localStringBuilder.append("_");
    localStringBuilder.append(paramAccusationParams.b);
    localStringBuilder.append("_");
    localStringBuilder.append(paramAccusationParams.h);
    localStringBuilder.append("_");
    localStringBuilder.append(b(paramString));
    paramString = MD5.toMD5(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramAccusationParams.d);
    localStringBuilder.append("_");
    localStringBuilder.append(paramAccusationParams.k);
    localStringBuilder.append("_");
    localStringBuilder.append(paramAccusationParams.l);
    localStringBuilder.append("_");
    localStringBuilder.append(paramAccusationParams.m);
    localStringBuilder.append("_");
    localStringBuilder.append(paramAccusationParams.n);
    localStringBuilder.append("_");
    localStringBuilder.append(paramAccusationParams.o);
    localStringBuilder.append("_");
    localStringBuilder.append(paramAccusationParams.p);
    localStringBuilder.append("_");
    localStringBuilder.append(paramAccusationParams.q);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return MD5.toMD5(localStringBuilder.toString());
  }
  
  private static void c(AccusationParams paramAccusationParams)
  {
    b(true);
    ((NetApi)ServiceCenter.a(NetApi.class)).a(GenEncryptedUinServlet.a(paramAccusationParams.d), SafeOuterClass.QQGetUserSafeSercetRsp.class, new TimiGameAccusationImpl.1(paramAccusationParams));
  }
  
  private static void d(AccusationParams paramAccusationParams)
  {
    Request localRequest = new Request.Builder().url("https://jubao.qq.com/uniform_impeach/impeach_cryptokey").build();
    new OkHttpClient().newCall(localRequest).enqueue(new TimiGameAccusationImpl.2(paramAccusationParams));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.accusation.impl.TimiGameAccusationImpl
 * JD-Core Version:    0.7.0.1
 */