package com.vivo.push;

import android.content.Intent;
import com.vivo.push.c.y;

public abstract interface IPushClientFactory
{
  public abstract y createReceiveTask(o paramo);
  
  public abstract o createReceiverCommand(Intent paramIntent);
  
  public abstract l createTask(o paramo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.IPushClientFactory
 * JD-Core Version:    0.7.0.1
 */