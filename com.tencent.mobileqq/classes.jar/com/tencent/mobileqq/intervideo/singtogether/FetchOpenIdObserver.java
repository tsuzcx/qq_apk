package com.tencent.mobileqq.intervideo.singtogether;

import android.os.Bundle;
import mqq.observer.BusinessObserver;

public class FetchOpenIdObserver
  implements BusinessObserver
{
  public void a(boolean paramBoolean, int paramInt, long paramLong, String paramString1, String paramString2) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt != 1) {
      return;
    }
    a(paramBoolean, paramBundle.getInt("appId"), paramBundle.getLong("uin", 0L), paramBundle.getString("openId"), paramBundle.getString("error_msg"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.singtogether.FetchOpenIdObserver
 * JD-Core Version:    0.7.0.1
 */