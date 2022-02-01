package com.tencent.mobileqq.phonecontact.adapter;

import android.accounts.Account;
import android.annotation.SuppressLint;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.phonecontact.api.IContactSyncService;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class SyncAdapter
  extends AbstractThreadedSyncAdapter
{
  private Context a;
  
  public SyncAdapter(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, paramBoolean);
    this.a = paramContext;
  }
  
  public void onPerformSync(Account paramAccount, Bundle paramBundle, String paramString, ContentProviderClient paramContentProviderClient, SyncResult paramSyncResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.SyncAdapter", 2, "onPerformSync");
    }
    if (!"Success".equals(MobileQQ.sInjectResult)) {
      return;
    }
    paramAccount = null;
    try
    {
      paramBundle = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
      paramAccount = paramBundle;
    }
    catch (Throwable paramBundle)
    {
      QLog.e("ContactSync.SyncAdapter", 1, "onPerformSync exception", paramBundle);
    }
    if ((paramAccount != null) && (paramAccount.isLogin())) {
      try
      {
        ((IContactSyncService)paramAccount.getRuntimeService(IContactSyncService.class, "")).syncAllContacts(1);
        return;
      }
      catch (Throwable paramAccount)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ContactSync.SyncAdapter", 2, "onPerformSync | syncAllContacts exception", paramAccount);
        }
        return;
      }
    }
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onPerformSync | app is null or not login, ");
      paramBundle.append(paramAccount);
      QLog.d("ContactSync.SyncAdapter", 2, paramBundle.toString());
    }
  }
  
  @SuppressLint({"NewApi"})
  public void onSyncCanceled()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.SyncAdapter", 2, "onSyncCanceled()");
    }
    super.onSyncCanceled();
  }
  
  @SuppressLint({"NewApi"})
  public void onSyncCanceled(Thread paramThread)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.SyncAdapter", 2, "onSyncCanceled(thread)");
    }
    super.onSyncCanceled(paramThread);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.adapter.SyncAdapter
 * JD-Core Version:    0.7.0.1
 */