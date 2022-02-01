package com.tencent.mobileqq.mediafocus;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Stack;

public class MediaFocusController
  extends BroadcastReceiver
{
  private final Stack<MediaFocusStackItem> a = new Stack();
  private MediaFocusController.IMediaFocusStatusCallback b;
  private Context c = BaseApplication.getContext();
  
  MediaFocusController(MediaFocusController.IMediaFocusStatusCallback paramIMediaFocusStatusCallback)
  {
    this.b = paramIMediaFocusStatusCallback;
    paramIMediaFocusStatusCallback = new IntentFilter();
    paramIMediaFocusStatusCallback.addAction("tencent.mobileqq.mediafocus.request");
    paramIMediaFocusStatusCallback.addAction("tencent.mobileqq.mediafocus.abandon");
    this.c.registerReceiver(this, paramIMediaFocusStatusCallback);
    MediaFocusIpcClient.b();
  }
  
  private int a(MediaFocusStackItem paramMediaFocusStackItem)
  {
    if (paramMediaFocusStackItem == null) {
      return 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MediaFocusController", 2, new Object[] { "handleRequestMediaFocus size:", Integer.valueOf(this.a.size()), " ,from:", paramMediaFocusStackItem.b() });
    }
    try
    {
      if ((!this.a.empty()) && (this.a.peek() != null) && (((MediaFocusStackItem)this.a.peek()).b().equals(paramMediaFocusStackItem.b())) && (((MediaFocusStackItem)this.a.peek()).c().equals(paramMediaFocusStackItem.c())))
      {
        if (((MediaFocusStackItem)this.a.peek()).a() == paramMediaFocusStackItem.a()) {
          return 0;
        }
        this.a.pop();
      }
      a(paramMediaFocusStackItem.a() * -1);
      b(paramMediaFocusStackItem.b(), paramMediaFocusStackItem.c());
      this.a.push(paramMediaFocusStackItem);
      return 0;
    }
    finally {}
  }
  
  private void a(int paramInt)
  {
    if ((!this.a.empty()) && (this.a.peek() != null))
    {
      MediaFocusStackItem localMediaFocusStackItem = (MediaFocusStackItem)this.a.peek();
      if (b(localMediaFocusStackItem.c()))
      {
        MediaFocusController.IMediaFocusStatusCallback localIMediaFocusStatusCallback = this.b;
        if (localIMediaFocusStatusCallback != null) {
          localIMediaFocusStatusCallback.a(paramInt, localMediaFocusStackItem.b());
        }
      }
      else
      {
        ThreadManager.executeOnSubThread(new MediaFocusController.1(this, localMediaFocusStackItem, paramInt));
      }
    }
  }
  
  private void b(String paramString1, String paramString2)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      MediaFocusStackItem localMediaFocusStackItem = (MediaFocusStackItem)localIterator.next();
      if ((paramString2.equals(localMediaFocusStackItem.c())) && (paramString1.equals(localMediaFocusStackItem.b())))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MediaFocusController", 2, new Object[] { "removeFocusStackEntry : ", localMediaFocusStackItem.toString() });
        }
        localIterator.remove();
      }
    }
  }
  
  private boolean b(String paramString)
  {
    return BaseApplication.processName.equals(paramString);
  }
  
  private int c(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaFocusController", 2, new Object[] { "handleAbandonMediaFocus size:", Integer.valueOf(this.a.size()), " ,from:", paramString1, " ,pname:", paramString2 });
    }
    try
    {
      try
      {
        b(paramString1, paramString2);
        a(1);
        if (this.b != null) {
          this.b.a();
        }
        return 0;
      }
      finally {}
      return 0;
    }
    catch (ConcurrentModificationException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MediaFocusController", 2, "handleAbandonMediaFocus FATAL EXCEPTION:", paramString1);
      }
    }
  }
  
  public int a(int paramInt, String paramString)
  {
    if (this.c == null) {
      return 1;
    }
    Intent localIntent = new Intent("tencent.mobileqq.mediafocus.request");
    localIntent.setPackage(this.c.getPackageName());
    paramString = new MediaFocusStackItem(paramInt, System.currentTimeMillis(), paramString, BaseApplication.processName);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("focusItem", paramString);
    localIntent.putExtras(localBundle);
    this.c.sendBroadcast(localIntent);
    return 2;
  }
  
  public int a(String paramString)
  {
    Intent localIntent = new Intent("tencent.mobileqq.mediafocus.abandon");
    localIntent.putExtra("cliendID", paramString);
    localIntent.putExtra("processName", BaseApplication.processName);
    try
    {
      localIntent.setPackage(this.c.getPackageName());
      this.c.sendBroadcast(localIntent);
      return 0;
    }
    catch (NullPointerException paramString)
    {
      label50:
      break label50;
    }
    QLog.d("MediaFocusController", 1, "context is null while sendMediaFocusAbandon");
    return 1;
  }
  
  public void a()
  {
    this.c.unregisterReceiver(this);
    this.a.clear();
    this.c = null;
    this.b = null;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      MediaFocusStackItem localMediaFocusStackItem = (MediaFocusStackItem)localIterator.next();
      if ((paramString2.equals(localMediaFocusStackItem.c())) && (paramString1.equals(localMediaFocusStackItem.b())))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MediaFocusController", 2, new Object[] { "checkMediaFocusItemExisted yes : ", localMediaFocusStackItem.toString() });
        }
        return true;
      }
    }
    return false;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceive action:");
      localStringBuilder.append(paramContext);
      QLog.i("MediaFocusController", 2, localStringBuilder.toString());
    }
    if (paramContext != null) {
      if (paramContext.equals("tencent.mobileqq.mediafocus.request"))
      {
        paramContext = (MediaFocusStackItem)paramIntent.getExtras().getParcelable("focusItem");
        int i = a(paramContext);
        if ((paramContext != null) && (b(paramContext.c())) && (i == 0))
        {
          paramIntent = this.b;
          if (paramIntent != null) {
            paramIntent.a(1, paramContext.b());
          }
        }
      }
      else if (paramContext.equals("tencent.mobileqq.mediafocus.abandon"))
      {
        c(paramIntent.getStringExtra("cliendID"), paramIntent.getStringExtra("processName"));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mediafocus.MediaFocusController
 * JD-Core Version:    0.7.0.1
 */