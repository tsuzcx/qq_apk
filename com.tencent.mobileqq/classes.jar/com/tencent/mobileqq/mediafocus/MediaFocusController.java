package com.tencent.mobileqq.mediafocus;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import asgi;
import asgj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Stack;

public class MediaFocusController
  extends BroadcastReceiver
{
  private Context jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
  private asgi jdField_a_of_type_Asgi;
  private final Stack<MediaFocusStackItem> jdField_a_of_type_JavaUtilStack = new Stack();
  
  public MediaFocusController(asgi paramasgi)
  {
    this.jdField_a_of_type_Asgi = paramasgi;
    paramasgi = new IntentFilter();
    paramasgi.addAction("tencent.mobileqq.mediafocus.request");
    paramasgi.addAction("tencent.mobileqq.mediafocus.abandon");
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this, paramasgi);
    asgj.a();
  }
  
  private int a(MediaFocusStackItem paramMediaFocusStackItem)
  {
    if (paramMediaFocusStackItem == null) {
      return 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MediaFocusController", 2, new Object[] { "handleRequestMediaFocus size:", Integer.valueOf(this.jdField_a_of_type_JavaUtilStack.size()), " ,from:", paramMediaFocusStackItem.a() });
    }
    try
    {
      if ((!this.jdField_a_of_type_JavaUtilStack.empty()) && (this.jdField_a_of_type_JavaUtilStack.peek() != null) && (((MediaFocusStackItem)this.jdField_a_of_type_JavaUtilStack.peek()).a().equals(paramMediaFocusStackItem.a())) && (((MediaFocusStackItem)this.jdField_a_of_type_JavaUtilStack.peek()).b().equals(paramMediaFocusStackItem.b())))
      {
        if (((MediaFocusStackItem)this.jdField_a_of_type_JavaUtilStack.peek()).a() == paramMediaFocusStackItem.a()) {
          return 0;
        }
        this.jdField_a_of_type_JavaUtilStack.pop();
      }
      a(paramMediaFocusStackItem.a() * -1);
      a(paramMediaFocusStackItem.a(), paramMediaFocusStackItem.b());
      this.jdField_a_of_type_JavaUtilStack.push(paramMediaFocusStackItem);
      return 0;
    }
    finally {}
  }
  
  private int a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaFocusController", 2, new Object[] { "handleAbandonMediaFocus size:", Integer.valueOf(this.jdField_a_of_type_JavaUtilStack.size()), " ,from:", paramString1, " ,pname:", paramString2 });
    }
    try
    {
      try
      {
        a(paramString1, paramString2);
        a(1);
        if (this.jdField_a_of_type_Asgi != null) {
          this.jdField_a_of_type_Asgi.a();
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
  
  private void a(int paramInt)
  {
    MediaFocusStackItem localMediaFocusStackItem;
    if ((!this.jdField_a_of_type_JavaUtilStack.empty()) && (this.jdField_a_of_type_JavaUtilStack.peek() != null))
    {
      localMediaFocusStackItem = (MediaFocusStackItem)this.jdField_a_of_type_JavaUtilStack.peek();
      if (!a(localMediaFocusStackItem.b())) {
        break label64;
      }
      if (this.jdField_a_of_type_Asgi != null) {
        this.jdField_a_of_type_Asgi.a(paramInt, localMediaFocusStackItem.a());
      }
    }
    return;
    label64:
    ThreadManager.executeOnSubThread(new MediaFocusController.1(this, localMediaFocusStackItem, paramInt));
  }
  
  private void a(String paramString1, String paramString2)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilStack.iterator();
    while (localIterator.hasNext())
    {
      MediaFocusStackItem localMediaFocusStackItem = (MediaFocusStackItem)localIterator.next();
      if ((paramString2.equals(localMediaFocusStackItem.b())) && (paramString1.equals(localMediaFocusStackItem.a())))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MediaFocusController", 2, new Object[] { "removeFocusStackEntry : ", localMediaFocusStackItem.toString() });
        }
        localIterator.remove();
      }
    }
  }
  
  private boolean a(String paramString)
  {
    return BaseApplicationImpl.processName.equals(paramString);
  }
  
  public int a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return 1;
    }
    Intent localIntent = new Intent("tencent.mobileqq.mediafocus.request");
    localIntent.setPackage(this.jdField_a_of_type_AndroidContentContext.getPackageName());
    paramString = new MediaFocusStackItem(paramInt, System.currentTimeMillis(), paramString, BaseApplicationImpl.processName);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("focusItem", paramString);
    localIntent.putExtras(localBundle);
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
    return 2;
  }
  
  public int a(String paramString)
  {
    Intent localIntent = new Intent("tencent.mobileqq.mediafocus.abandon");
    localIntent.putExtra("cliendID", paramString);
    localIntent.putExtra("processName", BaseApplicationImpl.processName);
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      localIntent.setPackage(this.jdField_a_of_type_AndroidContentContext.getPackageName());
      this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
      return 0;
    }
    return 1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this);
    this.jdField_a_of_type_JavaUtilStack.clear();
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_Asgi = null;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilStack.iterator();
    while (localIterator.hasNext())
    {
      MediaFocusStackItem localMediaFocusStackItem = (MediaFocusStackItem)localIterator.next();
      if ((paramString2.equals(localMediaFocusStackItem.b())) && (paramString1.equals(localMediaFocusStackItem.a())))
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
    if (QLog.isColorLevel()) {
      QLog.i("MediaFocusController", 2, "onReceive action:" + paramContext);
    }
    if (paramContext != null)
    {
      if (!paramContext.equals("tencent.mobileqq.mediafocus.request")) {
        break label105;
      }
      paramContext = (MediaFocusStackItem)paramIntent.getExtras().getParcelable("focusItem");
      i = a(paramContext);
      if ((a(paramContext.b())) && (i == 0) && (this.jdField_a_of_type_Asgi != null)) {
        this.jdField_a_of_type_Asgi.a(1, paramContext.a());
      }
    }
    label105:
    while (!paramContext.equals("tencent.mobileqq.mediafocus.abandon"))
    {
      int i;
      return;
    }
    a(paramIntent.getStringExtra("cliendID"), paramIntent.getStringExtra("processName"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.mediafocus.MediaFocusController
 * JD-Core Version:    0.7.0.1
 */