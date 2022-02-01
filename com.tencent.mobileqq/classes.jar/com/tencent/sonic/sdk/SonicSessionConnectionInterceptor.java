package com.tencent.sonic.sdk;

import android.content.Intent;

public abstract class SonicSessionConnectionInterceptor
{
  public static SonicSessionConnection getSonicSessionConnection(SonicSession paramSonicSession, Intent paramIntent)
  {
    SonicSessionConnectionInterceptor localSonicSessionConnectionInterceptor = paramSonicSession.config.connectionInterceptor;
    if (localSonicSessionConnectionInterceptor != null) {
      return localSonicSessionConnectionInterceptor.getConnection(paramSonicSession, paramIntent);
    }
    return new SonicSessionConnection.SessionConnectionDefaultImpl(paramSonicSession, paramIntent);
  }
  
  public abstract SonicSessionConnection getConnection(SonicSession paramSonicSession, Intent paramIntent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicSessionConnectionInterceptor
 * JD-Core Version:    0.7.0.1
 */