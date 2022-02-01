package com.tencent.mobileqq.kandian.base.image.api.impl;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.dns.BaseInnerDns;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class PublicAccountHttpDownloaderImpl$PubAccoutImageReporter
{
  public int a = 0;
  private HashMap<String, String> c = new HashMap();
  private final int d;
  private final String e;
  private int f;
  private long g;
  private long h;
  private boolean i;
  private String j;
  private String k;
  private String l;
  private int m;
  private long n;
  private String o;
  private String p;
  private String q;
  private String r;
  private String s;
  private Map<String, String> t;
  private BaseApplicationImpl u;
  private String[] v = { "2909288299" };
  
  public PublicAccountHttpDownloaderImpl$PubAccoutImageReporter(PublicAccountHttpDownloaderImpl paramPublicAccountHttpDownloaderImpl, BaseApplicationImpl paramBaseApplicationImpl, int paramInt)
  {
    this.f = paramInt;
    this.u = paramBaseApplicationImpl;
    this.d = a();
    paramPublicAccountHttpDownloaderImpl = new StringBuilder();
    paramPublicAccountHttpDownloaderImpl.append("PubAccountHttpDownloader.");
    paramPublicAccountHttpDownloaderImpl.append(this.d);
    this.e = paramPublicAccountHttpDownloaderImpl.toString();
  }
  
  private String a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return "actSubscriptionUnkonw";
            }
            return "actNativeWebImage";
          }
          return "actKandianImage";
        }
        return "actSubscriptionDetail";
      }
      return "actSubscriptionFolder";
    }
    return "actSubscriptionAIO";
  }
  
  private String a(MessageRecord paramMessageRecord)
  {
    Object localObject;
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      localObject = (MessageForStructing)paramMessageRecord;
      if (((MessageForStructing)localObject).structingMsg != null)
      {
        paramMessageRecord = new StringBuilder();
        paramMessageRecord.append("");
        paramMessageRecord.append(((MessageForStructing)localObject).structingMsg.msgId);
        return paramMessageRecord.toString();
      }
    }
    if ((paramMessageRecord instanceof MessageForPubAccount))
    {
      paramMessageRecord = (MessageForPubAccount)paramMessageRecord;
      if (paramMessageRecord.mPAMessage != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(paramMessageRecord.mPAMessage.mMsgId);
        return ((StringBuilder)localObject).toString();
      }
    }
    return null;
  }
  
  private void a(NetResp paramNetResp)
  {
    if (paramNetResp != null)
    {
      if (paramNetResp.mRespProperties != null)
      {
        paramNetResp = (String)paramNetResp.mRespProperties.get("param_rspHeader");
        String str = this.e;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("resp: ");
        localStringBuilder.append(paramNetResp);
        QLog.d(str, 1, localStringBuilder.toString());
        return;
      }
      QLog.d(this.e, 1, "esp headers: empty");
      return;
    }
    QLog.d(this.e, 1, "resp is null");
  }
  
  private boolean a(String paramString)
  {
    if (paramString != null)
    {
      String[] arrayOfString = this.v;
      int i2 = arrayOfString.length;
      int i1 = 0;
      while (i1 < i2)
      {
        if (paramString.equals(arrayOfString[i1])) {
          return true;
        }
        i1 += 1;
      }
    }
    return false;
  }
  
  private void b(String paramString)
  {
    Object localObject = this.u.getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      if (paramString != null)
      {
        int i1 = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType((AppInterface)localObject, paramString);
        if (i1 != -5)
        {
          if (i1 != -4)
          {
            if (i1 != -3)
            {
              if (i1 != -1)
              {
                if (this.f == 0) {
                  return;
                }
                i1 = 0;
              }
              else
              {
                i1 = 1;
              }
            }
            else {
              i1 = 3;
            }
          }
          else {
            i1 = 2;
          }
        }
        else {
          i1 = 4;
        }
        HashMap localHashMap = this.c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(i1);
        localHashMap.put("param_acc_type", localStringBuilder.toString());
        this.c.put("param_puin", paramString);
      }
      paramString = ((QQAppInterface)localObject).getCurrentAccountUin();
      if (paramString != null) {
        this.c.put("param_uin", paramString);
      }
    }
  }
  
  public int a()
  {
    try
    {
      this.a += 1;
      int i1 = this.a;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public URLDrawableHandler a(URLDrawableHandler paramURLDrawableHandler)
  {
    return new PublicAccountHttpDownloaderImpl.PubAccoutImageReporter.WrapURLDrawableHandler(this, paramURLDrawableHandler, this);
  }
  
  public void a(int paramInt, DownloadParams paramDownloadParams)
  {
    boolean bool = this.t.containsKey("puin");
    Object localObject2 = null;
    if (bool)
    {
      paramDownloadParams = (String)this.t.get("puin");
      localObject1 = (String)this.t.get("msgid");
    }
    else if ((paramDownloadParams.mExtraInfo instanceof MessageRecord))
    {
      localObject1 = (MessageRecord)paramDownloadParams.mExtraInfo;
      paramDownloadParams = ((MessageRecord)localObject1).frienduin;
      localObject1 = a((MessageRecord)localObject1);
    }
    else
    {
      localObject1 = null;
      paramDownloadParams = localObject2;
    }
    if (a(paramDownloadParams)) {
      return;
    }
    b(paramDownloadParams);
    if (localObject1 != null) {
      this.c.put("param_msgid", localObject1);
    }
    paramDownloadParams = this.c;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(paramInt);
    paramDownloadParams.put("AttemptCount", ((StringBuilder)localObject1).toString());
    this.c.put("picFormat", this.o);
    this.c.put("netType", this.r);
    this.c.put("plateform", this.q);
    this.c.put("pixDensity", this.s);
    paramDownloadParams = InnerDns.getInstance().reqDnsForIpList(this.k, 1009);
    if (paramDownloadParams != null) {
      paramDownloadParams = TextUtils.join(",", paramDownloadParams);
    } else {
      paramDownloadParams = "";
    }
    this.c.put("IPs", paramDownloadParams);
    this.c.put("ServerIP", "");
    this.c.put("OriginURL", this.j);
    localObject1 = this.c;
    if (this.i) {
      paramDownloadParams = String.valueOf(1);
    } else {
      paramDownloadParams = String.valueOf(0);
    }
    ((HashMap)localObject1).put("Success", paramDownloadParams);
    this.c.put("TotalTime", Long.toString(this.h));
    this.c.put("picType", this.p);
    this.c.put("ReceivedBytes", String.valueOf(this.n));
    this.c.put("ErrorReason", this.l);
    paramDownloadParams = this.c;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.m);
    ((StringBuilder)localObject1).append("");
    paramDownloadParams.put("param_FailCode", ((StringBuilder)localObject1).toString());
    this.c.put("Speed", Float.toString((float)this.n / ((float)this.h / 1000.0F)));
    paramDownloadParams = a(this.f);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("reportTag:");
    ((StringBuilder)localObject1).append(paramDownloadParams);
    ((StringBuilder)localObject1).append(", success:");
    ((StringBuilder)localObject1).append(this.i);
    ((StringBuilder)localObject1).append(", time:");
    ((StringBuilder)localObject1).append(this.h);
    ((StringBuilder)localObject1).append(", size:");
    ((StringBuilder)localObject1).append(this.n);
    ((StringBuilder)localObject1).append(", url:");
    ((StringBuilder)localObject1).append(this.j);
    ((StringBuilder)localObject1).append(", exInfo:");
    ((StringBuilder)localObject1).append(this.c.toString());
    QLog.d(this.e, 1, ((StringBuilder)localObject1).toString());
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, paramDownloadParams, this.i, this.h, this.n, this.c, "", true);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.m == 0) {
      this.m = paramInt;
    }
    this.l = paramString;
    this.i = false;
    this.h = (SystemClock.uptimeMillis() - this.g);
  }
  
  public void a(DownloadParams paramDownloadParams, Map<String, String> paramMap)
  {
    long l1 = NetworkCenter.getInstance().getNetType();
    this.r = "None";
    if ((l1 > 0L) && (l1 < AppConstants.NET_TYPE_NAME.length)) {
      this.r = AppConstants.NET_TYPE_NAME[((int)l1)];
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ANDROID.MOBILE-");
    ((StringBuilder)localObject).append(Build.MODEL);
    ((StringBuilder)localObject).append(".SDK-");
    ((StringBuilder)localObject).append(Build.VERSION.SDK);
    this.q = ((StringBuilder)localObject).toString();
    localObject = BaseApplicationImpl.getApplication().getApplicationContext().getResources().getDisplayMetrics();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((DisplayMetrics)localObject).widthPixels);
    localStringBuilder.append("*");
    localStringBuilder.append(((DisplayMetrics)localObject).heightPixels);
    this.s = localStringBuilder.toString();
    this.j = paramDownloadParams.urlStr;
    this.k = paramDownloadParams.url.getHost();
    this.o = "none";
    int i1 = this.j.lastIndexOf("/");
    if (i1 != -1)
    {
      i1 += 1;
      if ((i1 <= this.j.length()) && (i1 < this.j.length()))
      {
        this.o = this.j.substring(i1);
        i1 = this.o.indexOf("?");
        if (i1 != -1) {
          this.o = this.o.substring(0, i1);
        }
      }
    }
    this.t = paramMap;
  }
  
  public void a(NetResp paramNetResp, String paramString)
  {
    a(paramNetResp);
    if (paramNetResp != null)
    {
      this.p = "none";
      paramString = (String)paramNetResp.mRespProperties.get("Content-Type");
      if ((paramString != null) && (paramString.startsWith("image/"))) {
        this.p = paramString.replace("image/", "");
      }
      this.n = paramNetResp.mTotalFileLen;
      return;
    }
    this.l = paramString;
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    this.i = paramBoolean;
    this.m = paramInt;
    this.h = (SystemClock.uptimeMillis() - this.g);
  }
  
  public void b()
  {
    this.m = 0;
    this.l = null;
  }
  
  public void c()
  {
    this.g = SystemClock.uptimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.api.impl.PublicAccountHttpDownloaderImpl.PubAccoutImageReporter
 * JD-Core Version:    0.7.0.1
 */