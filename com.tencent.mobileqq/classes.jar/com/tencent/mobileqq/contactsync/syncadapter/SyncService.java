package com.tencent.mobileqq.contactsync.syncadapter;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.IBinder;
import anew;
import mqq.app.MobileQQ;

public class SyncService
  extends Service
{
  private static anew jdField_a_of_type_Anew;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences("LIGHT_DPC_CFG", 0).edit();
    paramContext.putBoolean("IS_USER_EXIT_RECEIVING_MSG", paramBoolean);
    paramContext.commit();
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean)
  {
    return paramContext.getSharedPreferences("LIGHT_DPC_CFG", 0).getBoolean("IS_USER_EXIT_RECEIVING_MSG", paramBoolean);
  }
  
  public static void b(Context paramContext, boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences("LIGHT_DPC_CFG", 0).edit();
    paramContext.putBoolean("SUPPORT_SYNC_ACCOUNT_LOGINI", paramBoolean);
    paramContext.commit();
  }
  
  public static boolean b(Context paramContext, boolean paramBoolean)
  {
    return paramContext.getSharedPreferences("LIGHT_DPC_CFG", 0).getBoolean("SUPPORT_SYNC_ACCOUNT_LOGINI", paramBoolean);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return jdField_a_of_type_Anew.getSyncAdapterBinder();
  }
  
  public void onCreate()
  {
    super.onCreate();
    ??? = MobileQQ.sMobileQQ;
    if ((a(this, false)) && (b(this, false)))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("k_start_mode", 1);
      ((MobileQQ)???).onActivityCreate(this, localIntent);
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Anew == null) {
        jdField_a_of_type_Anew = new anew(getApplicationContext(), true);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.contactsync.syncadapter.SyncService
 * JD-Core Version:    0.7.0.1
 */