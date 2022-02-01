package com.tencent.mobileqq.vip.lianghao.net;

import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.vip.lianghao.data.LiangHaoRsp;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQDeviceInfo;
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
import org.json.JSONException;
import org.json.JSONObject;

public class GetRegisterLiangHaoList
{
  private String a = null;
  private int b;
  private String c;
  private String d = "android";
  private String e = "8.8.17";
  private final String f = "d4e1f57bb381ec80e480aa10c65d05d1";
  private final String g = "https://proxy.vip.qq.com/cgi-bin/srfentry.fcgi";
  private long h = 0L;
  private WeakReference<GetRegisterLiangHaoList.RequestCallBack> i = new WeakReference(null);
  
  public GetRegisterLiangHaoList(String paramString, int paramInt, GetRegisterLiangHaoList.RequestCallBack paramRequestCallBack)
  {
    this.c = paramString;
    this.b = paramInt;
    this.i = new WeakReference(paramRequestCallBack);
  }
  
  private void a(LiangHaoRsp paramLiangHaoRsp)
  {
    if ((paramLiangHaoRsp != null) && (QLog.isColorLevel()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResponse ");
      ((StringBuilder)localObject).append(paramLiangHaoRsp);
      QLog.i("GetRegisterLiangHaoList", 2, ((StringBuilder)localObject).toString());
    }
    long l1 = SystemClock.elapsedRealtime();
    long l2 = this.h;
    int j;
    if (paramLiangHaoRsp != null) {
      j = paramLiangHaoRsp.b;
    } else {
      j = -30009;
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put("param_FailCode", String.valueOf(j));
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
    boolean bool;
    if (j == 0) {
      bool = true;
    } else {
      bool = false;
    }
    localStatisticCollector.collectPerformance(null, "reg_lh_get_list", bool, l1 - l2, 0L, (HashMap)localObject, "", true);
    localObject = (GetRegisterLiangHaoList.RequestCallBack)this.i.get();
    if (localObject == null) {
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new GetRegisterLiangHaoList.2(this, paramLiangHaoRsp, (GetRegisterLiangHaoList.RequestCallBack)localObject));
  }
  
  private LiangHaoRsp b()
  {
    try
    {
      Object localObject = d();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return null;
      }
      localObject = new Request.Builder().url((String)localObject).build();
      localObject = c().newCall((Request)localObject).execute();
      int j = ((Response)localObject).code();
      if (j == 200)
      {
        localObject = ((Response)localObject).body().string();
        if (QLog.isDevelopLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("json ");
          localStringBuilder.append((String)localObject);
          QLog.d("GetRegisterLiangHaoList", 4, localStringBuilder.toString());
        }
        localObject = new JSONObject((String)localObject).optJSONObject("12162");
        if (localObject == null) {
          return null;
        }
        localObject = ((JSONObject)localObject).optJSONObject("data");
        if (localObject == null) {
          return null;
        }
        localObject = ((JSONObject)localObject).optJSONObject("rsp");
        if (localObject == null) {
          return null;
        }
        return new LiangHaoRsp((JSONObject)localObject);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("sendRequest errorCode");
        ((StringBuilder)localObject).append(j);
        QLog.e("GetRegisterLiangHaoList", 2, ((StringBuilder)localObject).toString());
      }
      localObject = new LiangHaoRsp();
      ((LiangHaoRsp)localObject).b = j;
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("GetRegisterLiangHaoList", 2, localThrowable.toString());
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
      localObject = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("imei", f());
      localJSONObject2.put("page", String.valueOf(this.b));
      localJSONObject2.put("phone", this.c);
      localJSONObject2.put("plat", this.d);
      localJSONObject2.put("version", this.e);
      localJSONObject2.put("sign", g());
      ((JSONObject)localObject).put("req", localJSONObject2);
      localJSONObject1.put("12162", localObject);
      return localJSONObject1;
    }
    catch (JSONException localJSONException)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("buildRequestJson ");
        ((StringBuilder)localObject).append(localJSONException);
        QLog.e("GetRegisterLiangHaoList", 2, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  private String f()
  {
    if (this.a == null) {
      try
      {
        this.a = QQDeviceInfo.getIMEI("ecd027");
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("get imei error");
          localStringBuilder.append(localThrowable.toString());
          QLog.e("GetRegisterLiangHaoList", 2, localStringBuilder.toString());
        }
        this.a = "000000000000001";
      }
    }
    return this.a;
  }
  
  private String g()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append(this.b);
    localStringBuilder.append(this.c);
    localStringBuilder.append(this.d);
    localStringBuilder.append(this.e);
    localStringBuilder.append("d4e1f57bb381ec80e480aa10c65d05d1");
    return MD5.toMD5(localStringBuilder.toString()).toUpperCase();
  }
  
  public void a()
  {
    ThreadManagerV2.excute(new GetRegisterLiangHaoList.1(this), 16, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.net.GetRegisterLiangHaoList
 * JD-Core Version:    0.7.0.1
 */