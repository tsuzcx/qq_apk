package cooperation.qqreader.net;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import bmfq;
import bmfs;
import bmgm;
import bmgr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.util.QQDeviceInfo;
import cooperation.qqreader.QRBridgeUtil;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import okhttp3.MediaType;

public abstract class BaseCgiTask
  implements Runnable
{
  public static String a;
  public static String b = "AND";
  public static String c = "QQPLUGIN_B";
  protected Context a;
  private bmfq jdField_a_of_type_Bmfq;
  private WeakReference<bmfq> jdField_a_of_type_JavaLangRefWeakReference;
  
  static
  {
    jdField_a_of_type_JavaLangString = "8.4.10.0001";
  }
  
  public BaseCgiTask()
  {
    this.jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getApplication();
  }
  
  private bmfq a()
  {
    if (this.jdField_a_of_type_Bmfq != null) {
      return this.jdField_a_of_type_Bmfq;
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      return (bmfq)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    return null;
  }
  
  private String a(String paramString)
  {
    localObject1 = null;
    try
    {
      localObject2 = a();
      localObject1 = localObject2;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Object localObject2;
        bmgm.a("BaseCgiTask", "getRequestContent", localIOException);
        continue;
        localObject1 = a(new String((byte[])localObject1), 100);
      }
    }
    localObject2 = new StringBuilder().append(" request content: ");
    if (localObject1 == null)
    {
      localObject1 = "";
      localObject1 = (String)localObject1;
      return "Request: " + a() + (String)localObject1 + " Response is: " + a(paramString, 300);
    }
  }
  
  private static String a(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramInt > paramString.length())) {
      return paramString;
    }
    return paramString.substring(0, paramInt);
  }
  
  private void a(bmfs parambmfs)
  {
    bmfq localbmfq = a();
    if (localbmfq != null)
    {
      localbmfq.b(parambmfs);
      ThreadManager.getUIHandler().post(new BaseCgiTask.1(this, localbmfq, parambmfs));
      return;
    }
    bmgm.c("BaseCgiTask", getClass().getName() + " request: " + a() + " onConnectionReceiveData callback null");
  }
  
  private void a(BaseCgiTask paramBaseCgiTask, Exception paramException)
  {
    bmfq localbmfq = a();
    if (localbmfq != null)
    {
      bmgm.a("BaseCgiTask", a("failed task:" + getClass().getName()), paramException);
      ThreadManager.getUIHandler().post(new BaseCgiTask.2(this, localbmfq, paramBaseCgiTask, paramException));
      return;
    }
    bmgm.c("BaseCgiTask", getClass().getName() + "onConnectionError callback null");
  }
  
  public static String b()
  {
    String str2 = QQDeviceInfo.getIMEI("674ef4");
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.trim().length() != 0) {}
    }
    else
    {
      str1 = Build.ID + "-" + Build.DEVICE;
    }
    return str1;
  }
  
  public static String c()
  {
    String str1 = URLEncoder.encode(Build.PRODUCT);
    String str2 = URLEncoder.encode(Build.DEVICE);
    return str1 + "#" + str2 + "#" + Build.VERSION.SDK;
  }
  
  private String d()
  {
    return BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin() + "";
  }
  
  private String e()
  {
    Object localObject2 = "";
    EIPCResult localEIPCResult = QIPCClientHelper.getInstance().getClient().callServer("ReaderIPCModule", "get_skey", new Bundle());
    Object localObject1 = localObject2;
    if (localEIPCResult != null)
    {
      localObject1 = localObject2;
      if (localEIPCResult.code == 0)
      {
        localObject1 = localObject2;
        if (localEIPCResult.data != null) {
          localObject1 = localEIPCResult.data.getString("get_skey_value");
        }
      }
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = "";
      bmgm.a("BaseCgiTask", "skey is null");
    }
    return localObject2;
  }
  
  private String f()
  {
    return QRBridgeUtil.getPSkey(d(), "books.qq.com");
  }
  
  private String g()
  {
    String str1 = d();
    String str2 = e();
    String str3 = f();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("o_cookie=").append(str1).append(";p_skey=").append(str3).append(";skey=").append(str2).append(";uin=o");
    int j = str1.length();
    int i = 0;
    while (i < 10 - j)
    {
      localStringBuilder.append("0");
      i += 1;
    }
    localStringBuilder.append(str1);
    return localStringBuilder.toString();
  }
  
  protected abstract BaseCgiTask.RequestType a();
  
  protected abstract String a();
  
  protected abstract HashMap<String, String> a();
  
  protected MediaType a()
  {
    return MediaType.parse("application/json");
  }
  
  public void a()
  {
    ThreadManagerV2.excute(this, 128, null, true);
  }
  
  public void a(bmfq parambmfq, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Bmfq = parambmfq;
      return;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambmfq);
  }
  
  protected byte[] a()
  {
    return null;
  }
  
  protected HashMap<String, String> b()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("qq_version", "8.4.10");
    localHashMap.put("c_platform", "mqqandroid");
    localHashMap.put("qqnum", d());
    localHashMap.put("client_version", jdField_a_of_type_JavaLangString);
    localHashMap.put("client_platform", b);
    localHashMap.put("channel", c);
    localHashMap.put("sid", d());
    localHashMap.put("skey", e());
    localHashMap.put("p_skey", f());
    localHashMap.put("imei", b());
    localHashMap.put("ua", c());
    localHashMap.put("Referer", "https://readercentera.qq.com");
    localHashMap.put("cookie", g());
    localHashMap.put("identify", "skey");
    localHashMap.put("resolution", bmgr.a() + "*" + bmgr.b());
    localHashMap.put("timi", d());
    return localHashMap;
  }
  
  public void run()
  {
    try
    {
      if (BaseCgiTask.RequestType.POST.equals(a())) {}
      for (Object localObject = OkHttpHelper.HttpMethodType.POST;; localObject = OkHttpHelper.HttpMethodType.GET)
      {
        localObject = OkHttpHelper.a(a(), (OkHttpHelper.HttpMethodType)localObject, a(), a(), a());
        a(new bmfs(this, (String)localObject));
        bmgm.c("BaseCgiTask", a((String)localObject));
        return;
      }
      return;
    }
    catch (HttpResponseException localHttpResponseException)
    {
      a(this, localHttpResponseException);
      return;
    }
    catch (IOException localIOException)
    {
      a(this, localIOException);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      a(this, localIllegalArgumentException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqreader.net.BaseCgiTask
 * JD-Core Version:    0.7.0.1
 */