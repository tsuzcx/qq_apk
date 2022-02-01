package com.tencent.tmdownloader;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantbase.util.l;
import com.tencent.tmassistantbase.util.r;
import com.tencent.tmassistantsdk.internal.b.a;
import java.util.ArrayList;
import java.util.Iterator;

public class t
  extends Handler
{
  protected static t a;
  protected static HandlerThread b;
  protected static boolean c = true;
  private static long d;
  
  private t(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public static t a()
  {
    try
    {
      if ((a == null) || (!c))
      {
        ab.c("TMAssistantDownloadMessageThread", "recreate mMessagehandlerThread!");
        b = new HandlerThread(l.b.name());
        b.start();
        c = true;
        a = new t(b.getLooper());
        a.sendEmptyMessageDelayed(5, 30000L);
      }
      d = System.currentTimeMillis();
      t localt = a;
      return localt;
    }
    finally {}
  }
  
  public void a(TMAssistantDownloadClient paramTMAssistantDownloadClient, ITMAssistantDownloadClientListener paramITMAssistantDownloadClientListener)
  {
    if (paramITMAssistantDownloadClientListener != null)
    {
      if (paramTMAssistantDownloadClient == null) {
        return;
      }
      Message localMessage = a().obtainMessage();
      localMessage.what = 3;
      localMessage.obj = new r(paramTMAssistantDownloadClient, paramITMAssistantDownloadClientListener);
      localMessage.sendToTarget();
    }
  }
  
  public void a(TMAssistantDownloadClient paramTMAssistantDownloadClient, ITMAssistantDownloadClientListener paramITMAssistantDownloadClientListener, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (paramITMAssistantDownloadClientListener != null)
    {
      if (paramTMAssistantDownloadClient == null) {
        return;
      }
      Message localMessage = a().obtainMessage();
      localMessage.what = 1;
      localMessage.obj = new r(paramTMAssistantDownloadClient, paramITMAssistantDownloadClientListener);
      paramTMAssistantDownloadClient = new Bundle();
      paramTMAssistantDownloadClient.putString("url", paramString1);
      paramTMAssistantDownloadClient.putInt("state", paramInt1);
      paramTMAssistantDownloadClient.putInt("errorCode", paramInt2);
      paramTMAssistantDownloadClient.putString("errorMsg", paramString2);
      localMessage.setData(paramTMAssistantDownloadClient);
      localMessage.sendToTarget();
    }
  }
  
  public void a(TMAssistantDownloadClient paramTMAssistantDownloadClient, ITMAssistantDownloadClientListener paramITMAssistantDownloadClientListener, String paramString, long paramLong1, long paramLong2)
  {
    if ((paramITMAssistantDownloadClientListener != null) && (paramTMAssistantDownloadClient != null))
    {
      Message localMessage = a().obtainMessage();
      localMessage.what = 2;
      localMessage.obj = new r(paramTMAssistantDownloadClient, paramITMAssistantDownloadClientListener);
      paramTMAssistantDownloadClient = new Bundle();
      paramTMAssistantDownloadClient.putString("url", paramString);
      paramTMAssistantDownloadClient.putLong("receiveDataLen", paramLong1);
      paramTMAssistantDownloadClient.putLong("totalDataLen", paramLong2);
      localMessage.setData(paramTMAssistantDownloadClient);
      localMessage.sendToTarget();
      return;
    }
    paramString = new StringBuilder();
    paramString.append("listenr:");
    paramString.append(paramITMAssistantDownloadClientListener);
    paramString.append(" === sdkClient");
    paramString.append(paramTMAssistantDownloadClient);
    ab.c("TMAssistantDownloadSDKMessageThread", paramString.toString());
  }
  
  public void a(byte[] paramArrayOfByte, ArrayList<a> paramArrayList)
  {
    if ((paramArrayOfByte != null) && (paramArrayList != null))
    {
      Message localMessage = a().obtainMessage();
      localMessage.what = 4;
      localMessage.obj = new r(paramArrayOfByte, paramArrayList);
      localMessage.sendToTarget();
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage.what != 5) {
      removeMessages(5);
    }
    int i = paramMessage.what;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (i != 1)
    {
      long l1;
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              break label448;
            }
            ab.c("TMAssistantDownloadMessageThread", "<handleMessage> dealing exit signal");
            l1 = System.currentTimeMillis();
            try
            {
              if (l1 - d < 15000.0D)
              {
                ab.c("TMAssistantDownloadMessageThread", "<handleMessage> exe THREAD_EXIT signal time is too close with sGetInstanceTimeStamp, continue wait 0.5 * DELAY_TIME");
                sendEmptyMessageDelayed(5, 15000L);
              }
              else
              {
                c = false;
                b.quit();
                ab.c("TMAssistantDownloadMessageThread", "<handleMessage> Message Thread exited!!");
              }
              return;
            }
            finally {}
          }
          ab.c("TMAssistantDownloadMessageThread", "<handleMessage> received postActionResult signal");
          localObject1 = (r)paramMessage.obj;
          paramMessage = (byte[])((r)localObject1).a;
          localObject1 = (ArrayList)((r)localObject1).b;
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
        else
        {
          ab.c("TMAssistantDownloadMessageThread", "<handleMessage> received postSDKServiceInvalidMessage signal");
          localObject1 = (r)paramMessage.obj;
          paramMessage = (TMAssistantDownloadClient)((r)localObject1).a;
          localObject1 = (ITMAssistantDownloadClientListener)((r)localObject1).b;
          if (localObject1 != null) {
            ((ITMAssistantDownloadClientListener)localObject1).onDwonloadSDKServiceInvalid(paramMessage);
          }
        }
      }
      else
      {
        ab.c("TMAssistantDownloadMessageThread", "<handleMessage> received postTaskProgressChangedMessage signal");
        localObject2 = (r)paramMessage.obj;
        localObject1 = (TMAssistantDownloadClient)((r)localObject2).a;
        localObject2 = (ITMAssistantDownloadClientListener)((r)localObject2).b;
        paramMessage = paramMessage.getData();
        localObject3 = paramMessage.getString("url");
        l1 = paramMessage.getLong("receiveDataLen");
        long l2 = paramMessage.getLong("totalDataLen");
        if (localObject2 != null) {
          ((ITMAssistantDownloadClientListener)localObject2).onDownloadSDKTaskProgressChanged((TMAssistantDownloadClient)localObject1, (String)localObject3, l1, l2);
        }
      }
    }
    else
    {
      ab.c("TMAssistantDownloadMessageThread", "<handleMessage> received postTaskStateChangedMessage signal");
      localObject2 = (r)paramMessage.obj;
      localObject1 = (TMAssistantDownloadClient)((r)localObject2).a;
      localObject2 = (ITMAssistantDownloadClientListener)((r)localObject2).b;
      localObject3 = paramMessage.getData();
      paramMessage = ((Bundle)localObject3).getString("url");
      i = ((Bundle)localObject3).getInt("state");
      int j = ((Bundle)localObject3).getInt("errorCode");
      localObject3 = ((Bundle)localObject3).getString("errorMsg");
      if (localObject2 != null) {
        ((ITMAssistantDownloadClientListener)localObject2).onDownloadSDKTaskStateChanged((TMAssistantDownloadClient)localObject1, paramMessage, i, j, (String)localObject3);
      }
    }
    label448:
    sendEmptyMessageDelayed(5, 30000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmdownloader.t
 * JD-Core Version:    0.7.0.1
 */