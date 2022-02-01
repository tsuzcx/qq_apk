package com.tencent.mobileqq.kandian.glue.viola.adapter;

import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.adapter.HttpRequset;
import com.tencent.viola.adapter.HttpResponse;
import com.tencent.viola.adapter.IHttpAdapter.OnHttpListener;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Map;

class BaseHttpAdapter$1
  implements Runnable
{
  BaseHttpAdapter$1(BaseHttpAdapter paramBaseHttpAdapter, HttpRequset paramHttpRequset, IHttpAdapter.OnHttpListener paramOnHttpListener) {}
  
  public void run()
  {
    GamePubAccountHelper.a(this.a.url, System.currentTimeMillis());
    Object localObject1 = new HttpResponse();
    Object localObject2 = this.this$0.a();
    try
    {
      localObject3 = BaseHttpAdapter.a(this.this$0, this.a, this.b);
      ((BaseHttpAdapter.IEventReporterDelegate)localObject2).a((HttpURLConnection)localObject3, this.a.body);
      Map localMap = ((HttpURLConnection)localObject3).getHeaderFields();
      int i = ((HttpURLConnection)localObject3).getResponseCode();
      if (this.b != null) {
        this.b.onHeadersReceived(i, localMap);
      }
      ((BaseHttpAdapter.IEventReporterDelegate)localObject2).a();
      ((HttpResponse)localObject1).statusCode = String.valueOf(i);
      if ((i >= 200) && (i <= 299))
      {
        localObject2 = ((BaseHttpAdapter.IEventReporterDelegate)localObject2).a(((HttpURLConnection)localObject3).getInputStream());
        ((HttpResponse)localObject1).originalData = BaseHttpAdapter.a(this.this$0, (InputStream)localObject2, this.b);
      }
      else
      {
        ((HttpResponse)localObject1).errorMsg = BaseHttpAdapter.b(this.this$0, ((HttpURLConnection)localObject3).getErrorStream(), this.b);
      }
      if (this.b != null) {
        this.b.onHttpFinish((HttpResponse)localObject1);
      }
      if (QLog.isColorLevel())
      {
        localObject2 = BaseHttpAdapter.a;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("METHOD_OPEN_REQUEST_NET request url is:");
        ((StringBuilder)localObject3).append(this.a.url);
        ((StringBuilder)localObject3).append("  request body is:");
        ((StringBuilder)localObject3).append(this.a.body);
        ((StringBuilder)localObject3).append(", response code:");
        ((StringBuilder)localObject3).append(((HttpResponse)localObject1).errorCode);
        QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
        return;
      }
    }
    catch (Exception localException)
    {
      BaseHttpAdapter.a(this.this$0, (HttpResponse)localObject1, this.b, localException.getMessage());
      localObject1 = BaseHttpAdapter.a;
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("METHOD_OPEN_REQUEST_NET error! request url is:");
      ((StringBuilder)localObject3).append(this.a.url);
      ((StringBuilder)localObject3).append("  request body is:");
      ((StringBuilder)localObject3).append(this.a.body);
      ((StringBuilder)localObject3).append(",error msg:");
      ((StringBuilder)localObject3).append(localException.getMessage());
      QLog.e((String)localObject1, 2, ((StringBuilder)localObject3).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.adapter.BaseHttpAdapter.1
 * JD-Core Version:    0.7.0.1
 */