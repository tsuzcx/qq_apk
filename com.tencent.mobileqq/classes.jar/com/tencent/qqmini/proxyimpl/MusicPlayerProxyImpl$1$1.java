package com.tencent.qqmini.proxyimpl;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import com.tencent.qphone.base.util.QLog;

class MusicPlayerProxyImpl$1$1
  implements IBinder.DeathRecipient
{
  MusicPlayerProxyImpl$1$1(MusicPlayerProxyImpl.1 param1, IBinder paramIBinder) {}
  
  public void binderDied()
  {
    this.jdField_a_of_type_AndroidOsIBinder.unlinkToDeath(this, 0);
    MusicPlayerProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMusicPlayerProxyImpl$1.a, null);
    QLog.i("MusicPlayerProxyImpl", 2, "linkToDeath binderDied");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MusicPlayerProxyImpl.1.1
 * JD-Core Version:    0.7.0.1
 */