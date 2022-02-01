package com.tencent.mobileqq.listentogether.player;

import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import java.lang.ref.WeakReference;

class QQMusicPlayService$NetInfoHandler
  implements INetInfoHandler
{
  long jdField_a_of_type_Long = 0L;
  private final WeakReference<QQMusicPlayService> jdField_a_of_type_JavaLangRefWeakReference;
  
  QQMusicPlayService$NetInfoHandler(QQMusicPlayService paramQQMusicPlayService)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQMusicPlayService);
  }
  
  private void a(int paramInt)
  {
    QQMusicPlayService localQQMusicPlayService = (QQMusicPlayService)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQMusicPlayService == null) {
      return;
    }
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L) {
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 1)
    {
      bool1 = bool2;
      if (paramInt != 2)
      {
        bool1 = bool2;
        if (paramInt != 3) {
          if (paramInt == 6) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
        }
      }
    }
    QQMusicPlayService.a(localQQMusicPlayService, bool1);
  }
  
  public void onNetMobile2None()
  {
    a(4);
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    a(3);
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    a(1);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    a(2);
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    a(6);
  }
  
  public void onNetWifi2None()
  {
    a(5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.player.QQMusicPlayService.NetInfoHandler
 * JD-Core Version:    0.7.0.1
 */