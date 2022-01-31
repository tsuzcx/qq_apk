package com.tencent.mobileqq.microapp.d;

import com.squareup.okhttp.Dispatcher;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.ws.WebSocket;
import com.squareup.okhttp.ws.WebSocketCall;
import com.tencent.mobileqq.microapp.appbrand.a.a.av.a;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import okio.Buffer;

public final class a
{
  public static AtomicInteger a = new AtomicInteger();
  private OkHttpClient b;
  private WebSocketCall c;
  private av.a d;
  
  public a(a.a parama, av.a parama1)
  {
    parama1.a = (a.getAndIncrement() + 1);
    Request.Builder localBuilder = new Request.Builder().url(parama.a).build().newBuilder();
    Iterator localIterator = parama.b.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localBuilder.addHeader(str, (String)parama.b.get(str));
    }
    parama = localBuilder.build();
    this.b = new OkHttpClient();
    this.c = WebSocketCall.create(this.b, parama);
    this.c.enqueue(parama1);
    this.d = parama1;
  }
  
  public void a()
  {
    if (this.b != null)
    {
      this.b.getDispatcher().getExecutorService().shutdown();
      this.b = null;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if ((this.d != null) && (this.d.b != null)) {}
    try
    {
      this.d.b.close(paramInt, paramString);
      return;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
      return;
    }
    finally
    {
      this.d.b = null;
    }
  }
  
  public void a(String paramString)
  {
    Object localObject2;
    Object localObject1;
    if ((this.d != null) && (this.d.b != null))
    {
      localObject2 = null;
      localObject1 = null;
    }
    try
    {
      Buffer localBuffer = new Buffer().writeUtf8(paramString);
      localObject1 = localBuffer;
      localObject2 = localBuffer;
      MediaType localMediaType = MediaType.parse("application/vnd.okhttp.websocket+text; charset=utf-8");
      localObject1 = localBuffer;
      localObject2 = localBuffer;
      this.d.b.sendMessage(RequestBody.create(localMediaType, paramString));
      localObject1 = localBuffer;
      localObject2 = localBuffer;
      localBuffer.flush();
      return;
    }
    catch (Exception paramString)
    {
      localObject2 = localObject1;
      paramString.printStackTrace();
      return;
    }
    finally
    {
      if (localObject2 != null) {
        localObject2.close();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.d.a
 * JD-Core Version:    0.7.0.1
 */