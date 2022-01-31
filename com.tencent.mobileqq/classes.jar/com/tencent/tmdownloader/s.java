package com.tencent.tmdownloader;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.tmassistantbase.util.l;
import com.tencent.tmassistantbase.util.r;
import com.tencent.tmassistantsdk.internal.b.a;
import java.util.ArrayList;
import java.util.Iterator;

public class s
  extends Handler
{
  protected static s a = null;
  protected static HandlerThread b = null;
  
  private s(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public static s a()
  {
    try
    {
      if (a == null)
      {
        b = new HandlerThread("TMAssistantDownloadSDKMessageThread");
        b.start();
        a = new s(b.getLooper());
      }
      s locals = a;
      return locals;
    }
    finally {}
  }
  
  public void a(TMAssistantDownloadClient paramTMAssistantDownloadClient, ITMAssistantDownloadClientListener paramITMAssistantDownloadClientListener)
  {
    if ((paramITMAssistantDownloadClientListener == null) || (paramTMAssistantDownloadClient == null)) {
      return;
    }
    Message localMessage = a().obtainMessage();
    localMessage.what = 3;
    localMessage.obj = new l(paramTMAssistantDownloadClient, paramITMAssistantDownloadClientListener);
    localMessage.sendToTarget();
  }
  
  public void a(TMAssistantDownloadClient paramTMAssistantDownloadClient, ITMAssistantDownloadClientListener paramITMAssistantDownloadClientListener, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if ((paramITMAssistantDownloadClientListener == null) || (paramTMAssistantDownloadClient == null)) {
      return;
    }
    Message localMessage = a().obtainMessage();
    localMessage.what = 1;
    localMessage.obj = new l(paramTMAssistantDownloadClient, paramITMAssistantDownloadClientListener);
    paramTMAssistantDownloadClient = new Bundle();
    paramTMAssistantDownloadClient.putString("url", paramString1);
    paramTMAssistantDownloadClient.putInt("state", paramInt1);
    paramTMAssistantDownloadClient.putInt("errorCode", paramInt2);
    paramTMAssistantDownloadClient.putString("errorMsg", paramString2);
    localMessage.setData(paramTMAssistantDownloadClient);
    localMessage.sendToTarget();
  }
  
  public void a(TMAssistantDownloadClient paramTMAssistantDownloadClient, ITMAssistantDownloadClientListener paramITMAssistantDownloadClientListener, String paramString, long paramLong1, long paramLong2)
  {
    if ((paramITMAssistantDownloadClientListener == null) || (paramTMAssistantDownloadClient == null))
    {
      r.c("TMAssistantDownloadSDKMessageThread", "listenr:" + paramITMAssistantDownloadClientListener + " === sdkClient" + paramTMAssistantDownloadClient);
      return;
    }
    Message localMessage = a().obtainMessage();
    localMessage.what = 2;
    localMessage.obj = new l(paramTMAssistantDownloadClient, paramITMAssistantDownloadClientListener);
    paramTMAssistantDownloadClient = new Bundle();
    paramTMAssistantDownloadClient.putString("url", paramString);
    paramTMAssistantDownloadClient.putLong("receiveDataLen", paramLong1);
    paramTMAssistantDownloadClient.putLong("totalDataLen", paramLong2);
    localMessage.setData(paramTMAssistantDownloadClient);
    localMessage.sendToTarget();
  }
  
  public void a(byte[] paramArrayOfByte, ArrayList<a> paramArrayList)
  {
    if ((paramArrayOfByte != null) && (paramArrayList != null))
    {
      Message localMessage = a().obtainMessage();
      localMessage.what = 4;
      localMessage.obj = new l(paramArrayOfByte, paramArrayList);
      localMessage.sendToTarget();
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return;
      Object localObject2 = (l)paramMessage.obj;
      Object localObject1 = (TMAssistantDownloadClient)((l)localObject2).a;
      localObject2 = (ITMAssistantDownloadClientListener)((l)localObject2).b;
      Object localObject3 = paramMessage.getData();
      paramMessage = ((Bundle)localObject3).getString("url");
      int i = ((Bundle)localObject3).getInt("state");
      int j = ((Bundle)localObject3).getInt("errorCode");
      localObject3 = ((Bundle)localObject3).getString("errorMsg");
      if (localObject2 != null)
      {
        ((ITMAssistantDownloadClientListener)localObject2).onDownloadSDKTaskStateChanged((TMAssistantDownloadClient)localObject1, paramMessage, i, j, (String)localObject3);
        return;
        localObject2 = (l)paramMessage.obj;
        localObject1 = (TMAssistantDownloadClient)((l)localObject2).a;
        localObject2 = (ITMAssistantDownloadClientListener)((l)localObject2).b;
        paramMessage = paramMessage.getData();
        localObject3 = paramMessage.getString("url");
        long l1 = paramMessage.getLong("receiveDataLen");
        long l2 = paramMessage.getLong("totalDataLen");
        if (localObject2 != null)
        {
          ((ITMAssistantDownloadClientListener)localObject2).onDownloadSDKTaskProgressChanged((TMAssistantDownloadClient)localObject1, (String)localObject3, l1, l2);
          return;
          localObject1 = (l)paramMessage.obj;
          paramMessage = (TMAssistantDownloadClient)((l)localObject1).a;
          localObject1 = (ITMAssistantDownloadClientListener)((l)localObject1).b;
          if (localObject1 != null)
          {
            ((ITMAssistantDownloadClientListener)localObject1).onDwonloadSDKServiceInvalid(paramMessage);
            return;
            localObject1 = (l)paramMessage.obj;
            paramMessage = (byte[])((l)localObject1).a;
            localObject1 = (ArrayList)((l)localObject1).b;
            if (localObject1 != null)
            {
              localObject1 = ((ArrayList)localObject1).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (a)((Iterator)localObject1).next();
                if (localObject2 != null) {
                  ((a)localObject2).a(paramMessage);
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmdownloader.s
 * JD-Core Version:    0.7.0.1
 */