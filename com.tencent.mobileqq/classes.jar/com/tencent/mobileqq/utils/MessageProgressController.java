package com.tencent.mobileqq.utils;

import akcz;
import android.text.TextUtils;
import com.tencent.mobileqq.widget.MessageProgressView.RefreshProgressRunnable;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class MessageProgressController
{
  public ConcurrentHashMap a = new ConcurrentHashMap();
  
  public static final MessageProgressController a()
  {
    return akcz.a();
  }
  
  public MessageProgressView.RefreshProgressRunnable a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (this.a.isEmpty()) {
      return null;
    }
    return (MessageProgressView.RefreshProgressRunnable)this.a.get(paramString);
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
      MessageProgressView.RefreshProgressRunnable localRefreshProgressRunnable = (MessageProgressView.RefreshProgressRunnable)this.a.get(paramString);
      if (localRefreshProgressRunnable != null) {
        localRefreshProgressRunnable.a();
      }
      this.a.remove(paramString);
      if (QLog.isColorLevel()) {
        QLog.e("MessageProgressView", 2, " aflter removeAnimRunnable size=" + this.a.size());
      }
    }
  }
  
  public void a(String paramString, MessageProgressView.RefreshProgressRunnable paramRefreshProgressRunnable)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.a.put(paramString, paramRefreshProgressRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.MessageProgressController
 * JD-Core Version:    0.7.0.1
 */