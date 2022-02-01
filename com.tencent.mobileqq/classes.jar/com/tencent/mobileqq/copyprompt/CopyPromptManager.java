package com.tencent.mobileqq.copyprompt;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class CopyPromptManager
  implements Manager
{
  private ClipboardManager a;
  private QQAppInterface b;
  private SharedPreferences c = null;
  
  public CopyPromptManager(QQAppInterface paramQQAppInterface)
  {
    this.b = paramQQAppInterface;
  }
  
  private SharedPreferences b()
  {
    if (this.c == null) {
      this.c = PreferenceManager.getDefaultSharedPreferences(this.b.getApp());
    }
    return this.c;
  }
  
  private ClipboardManager c()
  {
    if (this.a == null) {
      this.a = ((ClipboardManager)this.b.getApp().getApplicationContext().getSystemService("clipboard"));
    }
    return this.a;
  }
  
  public String a()
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      long l1 = b().getLong("KEY_LAST_COPY_TIME", 0L);
      Object localObject = c();
      ClipboardMonitor.getPrimaryClipDescription((ClipboardManager)localObject);
      localObject = ((ClipboardManager)localObject).getPrimaryClipDescription();
      if (localObject != null)
      {
        long l2 = ((ClipDescription)localObject).getTimestamp();
        long l3 = System.currentTimeMillis();
        if ((l2 != l1) && (l3 - l2 < 180000L))
        {
          b().edit().putLong("KEY_LAST_COPY_TIME", l2).apply();
          localObject = c();
          ClipboardMonitor.hasPrimaryClip((ClipboardManager)localObject);
          if (((ClipboardManager)localObject).hasPrimaryClip())
          {
            localObject = c();
            ClipboardMonitor.getPrimaryClip((ClipboardManager)localObject);
            localObject = ((ClipboardManager)localObject).getPrimaryClip();
            if ((localObject != null) && (((ClipData)localObject).getItemCount() > 0))
            {
              localObject = ((ClipData)localObject).getItemAt(0);
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("origin copy data : ");
                localStringBuilder.append(localObject);
                QLog.d("CopyPromptManager", 2, localStringBuilder.toString());
              }
              if (localObject != null)
              {
                localObject = ((ClipData.Item)localObject).getText();
                if ((localObject != null) && (!TextUtils.isEmpty((CharSequence)localObject))) {
                  return String.valueOf(localObject);
                }
              }
            }
          }
        }
      }
    }
    return "";
  }
  
  public void onDestroy()
  {
    this.c = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.copyprompt.CopyPromptManager
 * JD-Core Version:    0.7.0.1
 */