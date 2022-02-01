package com.tencent.tmassistant;

import android.content.Context;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantbase.util.s;
import com.tencent.tmassistantsdk.internal.b.b;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import com.tencent.tmdownloader.f;
import java.util.ArrayList;
import java.util.Iterator;

public class a
{
  protected static a a;
  protected static ArrayList<TMAssistantDownloadClient> c = new ArrayList();
  protected static ArrayList<b> d = new ArrayList();
  protected Context b = null;
  
  protected a(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public static a a(Context paramContext)
  {
    try
    {
      if (a == null)
      {
        a = new a(paramContext);
        if (!s.a())
        {
          if (GlobalUtil.getInstance().getContext() == null) {
            GlobalUtil.getInstance().setContext(paramContext);
          }
          f.a();
        }
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public b a(String paramString)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<getDownloadOpenSDKClient> clientKey = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",process Name:");
      ((StringBuilder)localObject).append(s.e());
      ab.c("TMAssistantDownloadSDKManager", ((StringBuilder)localObject).toString());
      localObject = d.iterator();
      while (((Iterator)localObject).hasNext())
      {
        b localb = (b)((Iterator)localObject).next();
        boolean bool = localb.mClientKey.equals(paramString);
        if (bool == true) {
          return localb;
        }
      }
      paramString = new b(this.b, paramString, "com.tencent.android.qqdownloader.SDKService");
      if (paramString.initTMAssistantDownloadSDK())
      {
        d.add(paramString);
        return paramString;
      }
      return null;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public boolean b(String paramString)
  {
    try
    {
      Iterator localIterator = c.iterator();
      while (localIterator.hasNext())
      {
        TMAssistantDownloadClient localTMAssistantDownloadClient = (TMAssistantDownloadClient)localIterator.next();
        if ((localTMAssistantDownloadClient != null) && (localTMAssistantDownloadClient.mClientKey.equals(paramString) == true))
        {
          localTMAssistantDownloadClient.unInitTMAssistantDownloadSDK();
          localIterator.remove();
          return true;
        }
      }
      return false;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmassistant.a
 * JD-Core Version:    0.7.0.1
 */