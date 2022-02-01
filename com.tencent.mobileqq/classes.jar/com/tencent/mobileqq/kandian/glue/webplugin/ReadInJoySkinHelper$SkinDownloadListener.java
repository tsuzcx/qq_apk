package com.tencent.mobileqq.kandian.glue.webplugin;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinManager;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

public class ReadInJoySkinHelper$SkinDownloadListener
  extends DownloadListener
{
  private AppRuntime a;
  private String b;
  private Bundle c;
  private WeakReference<TroopMemberApiService> d;
  
  public ReadInJoySkinHelper$SkinDownloadListener(AppRuntime paramAppRuntime, String paramString, Bundle paramBundle, TroopMemberApiService paramTroopMemberApiService)
  {
    this.a = paramAppRuntime;
    this.b = paramString;
    this.c = paramBundle;
    this.d = new WeakReference(paramTroopMemberApiService);
  }
  
  public void onCancel(DownloadTask paramDownloadTask)
  {
    super.onCancel(paramDownloadTask);
    Object localObject = paramDownloadTask.b().getString("resId");
    paramDownloadTask = (TroopMemberApiService)this.d.get();
    if (TextUtils.equals((CharSequence)localObject, this.b))
    {
      ((ReadInJoySkinManager)this.a.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)).b(this);
      if (paramDownloadTask != null)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putInt("seq", this.c.getInt("seq"));
        ((Bundle)localObject).putInt("retCode", -1);
        ((Bundle)localObject).putString("skinId", this.b);
        ((Bundle)localObject).putInt("rate", 0);
        paramDownloadTask.a(107, (Bundle)localObject);
        if (QLog.isDebugVersion())
        {
          paramDownloadTask = new StringBuilder();
          paramDownloadTask.append("onCancel rsp:");
          paramDownloadTask.append(((Bundle)localObject).toString());
          QLog.d("ReadInJoySkinHelper", 4, paramDownloadTask.toString());
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("readinjoy", 4, "SkinDownloadListener onCancel");
    }
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    Object localObject = paramDownloadTask.b().getString("resId");
    TroopMemberApiService localTroopMemberApiService = (TroopMemberApiService)this.d.get();
    if (TextUtils.equals((CharSequence)localObject, this.b))
    {
      ((ReadInJoySkinManager)this.a.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)).b(this);
      if (localTroopMemberApiService != null)
      {
        localObject = new Bundle();
        if (paramDownloadTask.c == 0)
        {
          ((Bundle)localObject).putInt("seq", this.c.getInt("seq"));
          ((Bundle)localObject).putInt("retCode", 0);
          ((Bundle)localObject).putString("skinId", this.b);
          ((Bundle)localObject).putInt("rate", 100);
          localTroopMemberApiService.a(107, (Bundle)localObject);
        }
        else
        {
          ((Bundle)localObject).putInt("seq", this.c.getInt("seq"));
          ((Bundle)localObject).putInt("retCode", paramDownloadTask.c);
          ((Bundle)localObject).putString("skinId", this.b);
          ((Bundle)localObject).putInt("rate", 0);
          localTroopMemberApiService.a(107, (Bundle)localObject);
        }
        if (QLog.isDebugVersion())
        {
          paramDownloadTask = new StringBuilder();
          paramDownloadTask.append("onDone rsp:");
          paramDownloadTask.append(((Bundle)localObject).toString());
          QLog.d("ReadInJoySkinHelper", 4, paramDownloadTask.toString());
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("readinjoy", 4, "SkinDownloadListener onDone");
    }
  }
  
  public void onProgress(DownloadTask paramDownloadTask)
  {
    super.onProgress(paramDownloadTask);
    Object localObject = paramDownloadTask.b().getString("resId");
    TroopMemberApiService localTroopMemberApiService = (TroopMemberApiService)this.d.get();
    if ((TextUtils.equals((CharSequence)localObject, this.b)) && (localTroopMemberApiService != null))
    {
      localObject = new Bundle();
      ((Bundle)localObject).putInt("seq", this.c.getInt("seq"));
      ((Bundle)localObject).putInt("retCode", 0);
      ((Bundle)localObject).putString("skinId", this.b);
      int i = (int)(paramDownloadTask.k * 100L / paramDownloadTask.j);
      ((Bundle)localObject).putInt("rate", i);
      if (i != 100) {
        localTroopMemberApiService.a(107, (Bundle)localObject);
      }
    }
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    return super.onStart(paramDownloadTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.webplugin.ReadInJoySkinHelper.SkinDownloadListener
 * JD-Core Version:    0.7.0.1
 */