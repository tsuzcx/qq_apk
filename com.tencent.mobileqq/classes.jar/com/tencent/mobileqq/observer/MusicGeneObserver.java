package com.tencent.mobileqq.observer;

import android.os.Bundle;
import mqq.observer.BusinessObserver;

public class MusicGeneObserver
  implements BusinessObserver
{
  protected void a(boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, long paramLong) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 10000) {
      if (paramBoolean) {
        if (paramBundle != null) {
          a(paramBoolean, paramBundle.getBoolean("music_get_exist"), paramBundle.getInt("music_get_state"), paramBundle.getLong("music_get_uin"));
        }
      }
    }
    while (paramInt != 10001)
    {
      return;
      a(paramBoolean, false, 0, 0L);
      return;
    }
    a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.observer.MusicGeneObserver
 * JD-Core Version:    0.7.0.1
 */