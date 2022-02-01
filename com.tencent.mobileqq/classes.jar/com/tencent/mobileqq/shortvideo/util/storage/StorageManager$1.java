package com.tencent.mobileqq.shortvideo.util.storage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class StorageManager$1
  extends BroadcastReceiver
{
  StorageManager$1(StorageManager paramStorageManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction() == null) {}
    do
    {
      do
      {
        return;
        paramContext = this.a.jdField_a_of_type_JavaLangString;
        this.a.c();
      } while ((this.a.jdField_a_of_type_ComTencentMobileqqShortvideoUtilStorageStorageManager$OnSdCardChangedListener == null) || (paramContext.equals(this.a.jdField_a_of_type_JavaLangString)));
      if (paramIntent.getAction().equals("android.intent.action.MEDIA_UNMOUNTED"))
      {
        this.a.b();
        this.a.jdField_a_of_type_ComTencentMobileqqShortvideoUtilStorageStorageManager$OnSdCardChangedListener.a(0, this.a.jdField_a_of_type_JavaLangString);
        return;
      }
    } while (!paramIntent.getAction().equals("android.intent.action.MEDIA_MOUNTED"));
    this.a.jdField_a_of_type_ComTencentMobileqqShortvideoUtilStorageStorageManager$OnSdCardChangedListener.a(1, this.a.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.storage.StorageManager.1
 * JD-Core Version:    0.7.0.1
 */