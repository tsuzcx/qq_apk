package com.vivo.push;

import android.content.Context;
import com.vivo.push.b.f;
import java.util.ArrayList;
import java.util.List;

public class PushClient
{
  public static final String DEFAULT_REQUEST_ID = "1";
  private static volatile PushClient sPushClient;
  
  private PushClient(Context paramContext)
  {
    e.a().a(paramContext);
  }
  
  private void checkParam(String paramString)
  {
    if (paramString != null) {
      return;
    }
    throw new IllegalArgumentException("PushManager String param should not be ".concat(String.valueOf(paramString)));
  }
  
  public static PushClient getInstance(Context paramContext)
  {
    try
    {
      if (sPushClient == null) {
        sPushClient = new PushClient(paramContext.getApplicationContext());
      }
      paramContext = sPushClient;
      return paramContext;
    }
    finally {}
  }
  
  public void bindAlias(String paramString, IPushActionListener paramIPushActionListener)
  {
    checkParam(paramString);
    e.a().a(paramString, paramIPushActionListener);
  }
  
  public void checkManifest()
  {
    e.a().b();
  }
  
  public void delTopic(String paramString, IPushActionListener paramIPushActionListener)
  {
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(paramString);
    e.a().b(localArrayList, paramIPushActionListener);
  }
  
  public String getAlias()
  {
    return e.a().j();
  }
  
  public String getRegId()
  {
    return e.a().f();
  }
  
  public List<String> getTopics()
  {
    return e.a().c();
  }
  
  public String getVersion()
  {
    return "3.4.0.0";
  }
  
  public void initialize()
  {
    e.a().a(new f());
  }
  
  public boolean isSupport()
  {
    return e.a().d();
  }
  
  public void setSystemModel(boolean paramBoolean)
  {
    e.a().a(paramBoolean);
  }
  
  public void setTopic(String paramString, IPushActionListener paramIPushActionListener)
  {
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(paramString);
    e.a().a(localArrayList, paramIPushActionListener);
  }
  
  public void turnOffPush(IPushActionListener paramIPushActionListener)
  {
    e.a().b(paramIPushActionListener);
  }
  
  public void turnOnPush(IPushActionListener paramIPushActionListener)
  {
    e.a().a(paramIPushActionListener);
  }
  
  public void unBindAlias(String paramString, IPushActionListener paramIPushActionListener)
  {
    checkParam(paramString);
    e.a().b(paramString, paramIPushActionListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.PushClient
 * JD-Core Version:    0.7.0.1
 */