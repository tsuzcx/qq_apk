package com.tencent.mobileqq.kandian.glue.viola.adapter;

import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.viola.adapter.HttpRequset;
import com.tencent.viola.adapter.HttpResponse;
import com.tencent.viola.adapter.IHttpAdapter;
import com.tencent.viola.adapter.IHttpAdapter.OnHttpListener;
import com.tencent.viola.core.ViolaSDKManager;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;

public class BaseHttpAdapter
  implements IHttpAdapter
{
  public static String a = "BaseHttpAdapter";
  public static final String b;
  private static final BaseHttpAdapter.IEventReporterDelegate c = new BaseHttpAdapter.NOPEventReportDelegate(null);
  private ExecutorService d;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQ/8.8.17 Android/0.17 Android/");
    localStringBuilder.append(Build.VERSION.RELEASE);
    b = localStringBuilder.toString();
  }
  
  private HttpURLConnection a(HttpRequset paramHttpRequset, IHttpAdapter.OnHttpListener paramOnHttpListener)
  {
    paramOnHttpListener = a(new URL(paramHttpRequset.url));
    paramOnHttpListener.setConnectTimeout(paramHttpRequset.timeoutMs);
    paramOnHttpListener.setReadTimeout(paramHttpRequset.timeoutMs);
    paramOnHttpListener.setUseCaches(false);
    paramOnHttpListener.setDoInput(true);
    a(paramHttpRequset);
    Object localObject;
    if (paramHttpRequset.paramMap != null)
    {
      localObject = paramHttpRequset.paramMap.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        paramOnHttpListener.addRequestProperty(str, (String)paramHttpRequset.paramMap.get(str));
      }
    }
    if ((paramHttpRequset.paramMap == null) || (!paramHttpRequset.paramMap.containsKey("User-Agent"))) {
      paramOnHttpListener.addRequestProperty("User-Agent", b);
    }
    if ((!"POST".equals(paramHttpRequset.method)) && (!"PUT".equals(paramHttpRequset.method)) && (!"PATCH".equals(paramHttpRequset.method)))
    {
      if (!TextUtils.isEmpty(paramHttpRequset.method))
      {
        paramOnHttpListener.setRequestMethod(paramHttpRequset.method);
        return paramOnHttpListener;
      }
      paramOnHttpListener.setRequestMethod("GET");
      return paramOnHttpListener;
    }
    paramOnHttpListener.setRequestMethod(paramHttpRequset.method);
    if (paramHttpRequset.body != null)
    {
      paramOnHttpListener.setDoOutput(true);
      localObject = new DataOutputStream(paramOnHttpListener.getOutputStream());
      ((DataOutputStream)localObject).write(paramHttpRequset.body.getBytes());
      ((DataOutputStream)localObject).close();
    }
    return paramOnHttpListener;
  }
  
  private void a(HttpRequset paramHttpRequset)
  {
    Object localObject1;
    if ((paramHttpRequset.paramMap != null) && (paramHttpRequset.paramMap.containsKey("Cookie"))) {
      localObject1 = (String)paramHttpRequset.paramMap.get("Cookie");
    } else {
      localObject1 = null;
    }
    int j = 1;
    int i;
    if ((localObject1 != null) && (((String)localObject1).contains("uin="))) {
      i = 1;
    } else {
      i = 0;
    }
    if ((localObject1 == null) || (!((String)localObject1).contains("skey="))) {
      j = 0;
    }
    if ((i != 0) && (j != 0)) {
      return;
    }
    if (!((IHippyAccessHelper)QRoute.api(IHippyAccessHelper.class)).checkUrlPermission(paramHttpRequset.url)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject3 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject2;
    if (localObject3 != null)
    {
      localObject2 = (TicketManager)((AppRuntime)localObject3).getManager(2);
      localObject3 = ((AppRuntime)localObject3).getAccount();
      localObject2 = ((TicketManager)localObject2).getSkey((String)localObject3);
      if (i == 0)
      {
        localStringBuilder.append("uin=");
        localStringBuilder.append('o');
        localStringBuilder.append((String)localObject3);
      }
      if (j == 0)
      {
        if (!TextUtils.isEmpty(localStringBuilder)) {
          localStringBuilder.append(';');
        }
        localStringBuilder.append("skey=");
        localStringBuilder.append((String)localObject2);
      }
    }
    if (TextUtils.isEmpty(localStringBuilder)) {
      return;
    }
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = localStringBuilder.toString();
    }
    else
    {
      localObject2 = localObject1;
      if (!((String)localObject1).endsWith(";"))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(';');
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(localStringBuilder.toString());
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    if (paramHttpRequset.paramMap == null) {
      paramHttpRequset.paramMap = new HashMap();
    }
    paramHttpRequset.paramMap.put("Cookie", localObject1);
  }
  
  private void a(HttpRequset paramHttpRequset, IHttpAdapter.OnHttpListener paramOnHttpListener, boolean paramBoolean)
  {
    if (paramOnHttpListener != null) {
      paramOnHttpListener.onHttpStart();
    }
    a(new BaseHttpAdapter.1(this, paramHttpRequset, paramOnHttpListener), paramBoolean);
  }
  
  private void a(HttpResponse paramHttpResponse, IHttpAdapter.OnHttpListener paramOnHttpListener, String paramString)
  {
    paramHttpResponse.statusCode = "-1";
    paramHttpResponse.errorCode = "-1";
    paramHttpResponse.errorMsg = paramString;
    if (paramOnHttpListener != null) {
      paramOnHttpListener.onHttpFinish(paramHttpResponse);
    }
  }
  
  private void a(Runnable paramRunnable, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ViolaSDKManager.getInstance().postOnThreadPool(paramRunnable);
      return;
    }
    if (this.d == null) {
      this.d = Executors.newFixedThreadPool(6);
    }
    this.d.execute(paramRunnable);
  }
  
  private byte[] a(InputStream paramInputStream, IHttpAdapter.OnHttpListener paramOnHttpListener)
  {
    if (paramInputStream == null) {
      return null;
    }
    paramOnHttpListener = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[2048];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte, 0, arrayOfByte.length);
      if (i == -1) {
        break;
      }
      paramOnHttpListener.write(arrayOfByte, 0, i);
    }
    paramOnHttpListener.flush();
    return paramOnHttpListener.toByteArray();
  }
  
  private String b(InputStream paramInputStream, IHttpAdapter.OnHttpListener paramOnHttpListener)
  {
    if (paramInputStream == null) {
      return null;
    }
    paramOnHttpListener = new StringBuilder();
    paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream));
    char[] arrayOfChar = new char[2048];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfChar);
      if (i == -1) {
        break;
      }
      paramOnHttpListener.append(arrayOfChar, 0, i);
    }
    paramInputStream.close();
    return paramOnHttpListener.toString();
  }
  
  @NonNull
  public BaseHttpAdapter.IEventReporterDelegate a()
  {
    return c;
  }
  
  protected HttpURLConnection a(URL paramURL)
  {
    return (HttpURLConnection)paramURL.openConnection();
  }
  
  public void sendRequest(HttpRequset paramHttpRequset, IHttpAdapter.OnHttpListener paramOnHttpListener, boolean paramBoolean)
  {
    a(paramHttpRequset, paramOnHttpListener, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.adapter.BaseHttpAdapter
 * JD-Core Version:    0.7.0.1
 */