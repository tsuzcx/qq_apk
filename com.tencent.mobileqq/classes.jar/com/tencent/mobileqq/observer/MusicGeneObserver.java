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
    if (paramInt == 10000)
    {
      if (paramBoolean)
      {
        if (paramBundle != null) {
          a(paramBoolean, paramBundle.getBoolean("music_get_exist"), paramBundle.getInt("music_get_state"), paramBundle.getLong("music_get_uin"));
        }
      }
      else {
        a(paramBoolean, false, 0, 0L);
      }
    }
    else if (paramInt == 10001) {
      a(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.observer.MusicGeneObserver
 * JD-Core Version:    0.7.0.1
 */