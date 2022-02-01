package com.tencent.mobileqq.vip.lianghao.net;

import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.vip.lianghao.data.LiangHaoStatusRsp;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;

public class CheckRegisterLiangHao
{
  private String a;
  private final String b = "a4d7xwsbelhregistercard";
  private final String c = "https://proxy.vip.qq.com/cgi-bin/srfentry.fcgi";
  private WeakReference<CheckRegisterLiangHao.RequestCallBack> d = new WeakReference(null);
  private long e = 0L;
  
  public CheckRegisterLiangHao(String paramString, CheckRegisterLiangHao.RequestCallBack paramRequestCallBack)
  {
    this.a = paramString;
    this.d = new WeakReference(paramRequestCallBack);
  }
  
  private void a(LiangHaoStatusRsp paramLiangHaoStatusRsp)
  {
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onResponse ");
      if (paramLiangHaoStatusRsp == null) {
        localObject1 = "";
      } else {
        localObject1 = paramLiangHaoStatusRsp.toString();
      }
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.i("CheckRegisterLiangHao", 2, ((StringBuilder)localObject2).toString());
    }
    long l1 = SystemClock.elapsedRealtime();
    long l2 = this.e;
    int i;
    if (paramLiangHaoStatusRsp != null) {
      i = paramLiangHaoStatusRsp.a;
    } else {
      i = -30009;
    }
    Object localObject1 = new HashMap();
    ((HashMap)localObject1).put("param_FailCode", String.valueOf(i));
    Object localObject2 = StatisticCollector.getInstance(BaseApplication.getContext());
    boolean bool;
    if (i == 0) {
      bool = true;
    } else {
      bool = false;
    }
    ((StatisticCollector)localObject2).collectPerformance(null, "reg_lh_check_uin", bool, l1 - l2, 0L, (HashMap)localObject1, "", true);
    localObject1 = (CheckRegisterLiangHao.RequestCallBack)this.d.get();
    if (localObject1 == null) {
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new CheckRegisterLiangHao.2(this, (CheckRegisterLiangHao.RequestCallBack)localObject1, paramLiangHaoStatusRsp));
  }
  
  private LiangHaoStatusRsp b()
  {
    try
    {
      Object localObject = d();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return null;
      }
      localObject = new Request.Builder().url((String)localObject).build();
      localObject = c().newCall((Request)localObject).execute();
      int i = ((Response)localObject).code();
      if (i == 200)
      {
        localObject = ((Response)localObject).body().string();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("json ");
          localStringBuilder.append((String)localObject);
          QLog.i("CheckRegisterLiangHao", 2, localStringBuilder.toString());
        }
        localObject = new JSONObject((String)localObject).optJSONObject("12196");
        if (localObject == null) {
          return null;
        }
        localObject = ((JSONObject)localObject).optJSONObject("data");
        if (localObject == null) {
          return null;
        }
        localObject = ((JSONObject)localObject).optJSONObject("mOut");
        if (localObject == null) {
          return null;
        }
        return new LiangHaoStatusRsp((JSONObject)localObject);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("sendRequest errorCode");
        ((StringBuilder)localObject).append(i);
        QLog.e("CheckRegisterLiangHao", 2, ((StringBuilder)localObject).toString());
      }
      localObject = new LiangHaoStatusRsp();
      ((LiangHaoStatusRsp)localObject).a = i;
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("CheckRegisterLiangHao", 2, localThrowable.toString());
      }
    }
    return null;
  }
  
  private OkHttpClient c()
  {
    return new OkHttpClient().newBuilder().connectTimeout(5L, TimeUnit.SECONDS).readTimeout(5L, TimeUnit.SECONDS).build();
  }
  
  private String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://proxy.vip.qq.com/cgi-bin/srfentry.fcgi?ts=");
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append("&data=");
    localStringBuilder.append(e());
    return localStringBuilder.toString();
  }
  
  private JSONObject e()
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      JSONObject localJSONObject3 = new JSONObject();
      localJSONObject3.put("uin", this.a);
      localJSONObject3.put("sign", f());
      localJSONObject2.put("mIn", localJSONObject3);
      localJSONObject1.put("12196", localJSONObject2);
      return localJSONObject1;
    }
    catch (Throwable localThrowable)
    {
      label67:
      break label67;
    }
    return null;
  }
  
  private String f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin=");
    localStringBuilder.append(this.a);
    localStringBuilder.append("&key=");
    localStringBuilder.append("a4d7xwsbelhregistercard");
    return MD5.toMD5(localStringBuilder.toString()).toUpperCase();
  }
  
  public void a()
  {
    ThreadManagerV2.excute(new CheckRegisterLiangHao.1(this), 16, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.net.CheckRegisterLiangHao
 * JD-Core Version:    0.7.0.1
 */