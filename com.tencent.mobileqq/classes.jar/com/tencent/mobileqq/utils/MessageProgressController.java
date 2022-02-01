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
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (!this.a.isEmpty()) {
      return (RefreshProgressRunnable)this.a.get(paramString);
    }
    return null;
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
      Object localObject = (RefreshProgressRunnable)this.a.get(paramString);
      if (localObject != null) {
        ((RefreshProgressRunnable)localObject).a();
      }
      try
      {
        this.a.remove(paramString);
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("removeAnimRunnable exception = ");
          ((StringBuilder)localObject).append(paramString.getMessage());
          QLog.e("MessageProgressView", 2, ((StringBuilder)localObject).toString());
        }
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append(" aflter removeAnimRunnable size=");
        paramString.append(this.a.size());
        QLog.e("MessageProgressView", 2, paramString.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.MessageProgressController
 * JD-Core Version:    0.7.0.1
 */