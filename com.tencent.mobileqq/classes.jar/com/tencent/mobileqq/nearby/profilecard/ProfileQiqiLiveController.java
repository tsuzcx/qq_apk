package com.tencent.mobileqq.nearby.profilecard;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.ProtoServlet;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.service.gamecenter.AppLaucherHelper;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.open.business.base.AppUtil;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.qconn.protofile.fastauthorize.FastAuthorize.AuthorizeRequest;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;

public class ProfileQiqiLiveController
{
  WeakReference<NearbyPeopleProfileActivity> a;
  String b;
  NewIntent c;
  Handler d;
  public String e;
  public String f;
  public String g;
  AsyncTask<Integer, Void, Bundle> h;
  
  public void a()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      if (((WeakReference)localObject).get() == null) {
        return;
      }
      localObject = (Activity)this.a.get();
      if (localObject != null)
      {
        NewIntent localNewIntent = this.c;
        if (localNewIntent != null)
        {
          localNewIntent.setObserver(null);
          this.c = null;
        }
        if (QLog.isColorLevel()) {
          QLog.d(getClass().getSimpleName(), 2, "lauchApp time out");
        }
        AppUtil.a((Context)localObject, "com.guagua.qiqi", AppLaucherHelper.b("pt=$PT$&at=$AT$&openid=$OPID$&pf=$PF$"), 335544320);
      }
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      if (((WeakReference)localObject).get() == null) {
        return;
      }
      localObject = (NearbyPeopleProfileActivity)this.a.get();
      if (localObject != null)
      {
        if (paramInt == 2) {
          this.d.sendEmptyMessage(1);
        }
        if (TextUtils.isEmpty(this.g))
        {
          if (this.h == null)
          {
            this.h = new ProfileQiqiLiveController.1(this);
            this.h.execute(new Integer[] { Integer.valueOf(paramInt) });
          }
          return;
        }
        Bundle localBundle = new Bundle();
        localBundle.putString(DownloadConstants.b, this.f);
        localBundle.putString(DownloadConstants.j, this.g);
        localBundle.putString(DownloadConstants.f, this.e);
        localBundle.putInt(DownloadConstants.k, paramInt);
        localBundle.putString(DownloadConstants.i, "ANDROIDQQ.MSG.QIQI");
        localBundle.putString(DownloadConstants.l, "");
        localBundle.putBoolean(DownloadConstants.y, false);
        localBundle.putBoolean(DownloadConstants.g, true);
        localBundle.putBoolean(DownloadConstants.h, false);
        DownloadApi.a((Activity)localObject, localBundle, "biz_src_yyb", null, 0);
      }
    }
  }
  
  public void a(long paramLong)
  {
    Object localObject = this.a;
    if ((localObject != null) && (((WeakReference)localObject).get() != null))
    {
      if (paramLong == 0L) {
        return;
      }
      localObject = (NearbyPeopleProfileActivity)this.a.get();
      if (localObject != null)
      {
        QQAppInterface localQQAppInterface = ((NearbyPeopleProfileActivity)localObject).app;
        String str = ((TicketManager)localQQAppInterface.getManager(2)).getSkey(localQQAppInterface.getAccount());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("pt=$PT$&at=$AT$&openid=$OPID$&pf=$PF$&roomid=");
        localStringBuilder.append(paramLong);
        this.b = localStringBuilder.toString();
        a(localQQAppInterface, (Context)localObject, "1101674847", "com.guagua.qiqi", str, 335544320);
      }
    }
  }
  
  public void a(AppInterface paramAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    local2 = new ProfileQiqiLiveController.2(this, paramString2, paramContext, paramInt);
    if (this.c == null) {
      this.c = new NewIntent(paramContext, ProtoServlet.class);
    }
    localAuthorizeRequest = new FastAuthorize.AuthorizeRequest();
    l2 = 0L;
    try
    {
      l1 = Long.parseLong(paramAppInterface.getCurrentAccountUin());
    }
    catch (Exception localException)
    {
      try
      {
        l1 = Long.parseLong(paramString1);
        localAuthorizeRequest.client_id.set(l1);
        paramString1 = localAuthorizeRequest.pf;
        String str = "";
        paramString1.set("");
        paramString1 = AppUtil.a(paramContext);
        localAuthorizeRequest.qqv.set(paramString1);
        localAuthorizeRequest.sdkp.set("a");
        paramString1 = Build.DISPLAY;
        localAuthorizeRequest.os.set(paramString1);
        localAuthorizeRequest.skey.set(paramString3);
        if (!(paramAppInterface instanceof QQAppInterface)) {
          break label171;
        }
        paramString1 = ((QQAppInterface)paramAppInterface).getvKeyStr();
        break label174;
        paramString1 = "";
        localAuthorizeRequest.vkey.set(paramString1);
        int i = AppLaucherHelper.a(this.b);
        if (i != 0) {
          break label214;
        }
        AppUtil.a(paramContext, paramString2, AppLaucherHelper.b(this.b), paramInt);
        return;
        localAuthorizeRequest.flags.set(i);
        paramString1 = str;
        try
        {
          Signature[] arrayOfSignature = paramContext.getPackageManager().getPackageInfo(paramString2, 64).signatures;
          paramString1 = str;
          if (arrayOfSignature != null)
          {
            paramString3 = str;
            paramString1 = str;
            try
            {
              MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
              paramString3 = str;
              paramString1 = str;
              localMessageDigest.update(arrayOfSignature[0].toByteArray());
              paramString3 = str;
              paramString1 = str;
              str = HexUtil.bytes2HexStr(localMessageDigest.digest());
              paramString3 = str;
              paramString1 = str;
              str = str.toLowerCase();
              paramString3 = str;
              paramString1 = str;
              localMessageDigest.reset();
              paramString1 = str;
            }
            catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
            {
              paramString1 = paramString3;
              localNoSuchAlgorithmException.printStackTrace();
              paramString1 = paramString3;
            }
          }
        }
        catch (Exception paramString3)
        {
          break label347;
        }
        if (!TextUtils.isEmpty(paramString1)) {
          break label391;
        }
        if (!QLog.isColorLevel()) {
          break label374;
        }
        QLog.d(getClass().getSimpleName(), 2, "no sign");
        AppUtil.a(paramContext, paramString2, AppLaucherHelper.b(this.b), paramInt);
        return;
        localAuthorizeRequest.apk_sign.set(paramString1);
        this.c.putExtra("cmd", "ConnAuthSvr.fast_qq_login");
        try
        {
          this.c.putExtra("data", localAuthorizeRequest.toByteArray());
          this.c.setObserver(local2);
          paramAppInterface.startServlet(this.c);
          this.d.sendEmptyMessageDelayed(6, 3000L);
          return;
        }
        catch (Exception paramAppInterface)
        {
          if (QLog.isColorLevel()) {
            QLog.d(getClass().getSimpleName(), 2, paramAppInterface.getMessage());
          }
          return;
        }
        localException = localException;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          long l1 = l2;
        }
      }
    }
    l1 = 0L;
    localAuthorizeRequest.uin.set(l1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.ProfileQiqiLiveController
 * JD-Core Version:    0.7.0.1
 */