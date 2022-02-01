package com.tencent.mobileqq.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.widget.RefreshProgressRunnable;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class MessageProgressController
{
  public ConcurrentHashMap<String, RefreshProgressRunnable> a = new ConcurrentHashMap();
  
  public static final MessageProgressController a()
  {
    return MessageProgressController.MessageProgressControllerHolder.a();
  }
  
  public RefreshProgressRunnable a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (this.a.isEmpty()) {
      return null;
    }
    return (RefreshProgressRunnable)this.a.get(paramString);
  }
  
  public void a()
  {
    Iterator localIterator = this.a.keySet().iterator();
    while (localIterator.hasNext()) {
      a((String)localIterator.next());
    }
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      RefreshProgressRunnable localRefreshProgressRunnable = (RefreshProgressRunnable)this.a.get(paramString);
      if (localRefreshProgressRunnable != null) {
        localRefreshProgressRunnable.a();
      }
    }
    try
    {
      this.a.remove(paramString);
      if (QLog.isColorLevel()) {
        QLog.e("MessageProgressView", 2, " aflter removeAnimRunnable size=" + this.a.size());
      }
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MessageProgressView", 2, "removeAnimRunnable exception = " + paramString.getMessage());
        }
      }
    }
  }
  
  public void a(String paramString, RefreshProgressRunnable paramRefreshProgressRunnable)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.a.put(paramString, paramRefreshProgressRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.MessageProgressController
 * JD-Core Version:    0.7.0.1
 */