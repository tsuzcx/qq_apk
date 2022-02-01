package com.tencent.mobileqq.contactsync.syncadapter;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.common.AccountDPCHelper;
import com.tencent.mobileqq.phonecontact.adapter.SyncAdapter;
import mqq.app.MobileQQ;

public class SyncService
  extends Service
{
  private static SyncAdapter jdField_a_of_type_ComTencentMobileqqPhonecontactAdapterSyncAdapter = null;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  
  public IBinder onBind(Intent paramIntent)
  {
    return jdField_a_of_type_ComTencentMobileqqPhonecontactAdapterSyncAdapter.getSyncAdapterBinder();
  }
  
  public void onCreate()
  {
    super.onCreate();
    ??? = MobileQQ.sMobileQQ;
    if ((AccountDPCHelper.a(this, false)) && (AccountDPCHelper.b(this, false)))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("k_start_mode", 1);
      ((MobileQQ)???).onActivityCreate(this, localIntent);
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqPhonecontactAdapterSyncAdapter == null) {
        jdField_a_of_type_ComTencentMobileqqPhonecontactAdapterSyncAdapter = new SyncAdapter(getApplicationContext(), true);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.contactsync.syncadapter.SyncService
 * JD-Core Version:    0.7.0.1
 */