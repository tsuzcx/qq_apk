package com.tencent.mobileqq.emosm;

import android.os.Bundle;

public abstract class Client$OnRemoteRespObserver
{
  private static int seed = 0;
  public int key;
  
  public Client$OnRemoteRespObserver()
  {
    int i = seed;
    seed = i + 1;
    this.key = i;
  }
  
  public abstract void onBindedToClient();
  
  public abstract void onDisconnectWithService();
  
  public abstract void onPushMsg(Bundle paramBundle);
  
  public abstract void onResponse(Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.Client.OnRemoteRespObserver
 * JD-Core Version:    0.7.0.1
 */