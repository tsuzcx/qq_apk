package com.tencent.mobileqq.intervideo.groupvideo.plugininterface;

import android.os.Bundle;
import java.util.concurrent.Future;

public abstract interface IVCommonInterface
{
  public abstract Future<Bundle> getLocation(String paramString);
  
  public abstract void setHostActivityCallback(IVHostCallback paramIVHostCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IVCommonInterface
 * JD-Core Version:    0.7.0.1
 */