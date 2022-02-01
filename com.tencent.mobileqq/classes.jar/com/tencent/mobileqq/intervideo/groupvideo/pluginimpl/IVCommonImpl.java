package com.tencent.mobileqq.intervideo.groupvideo.pluginimpl;

import android.os.Bundle;
import com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IVCommonInterface;
import com.tencent.mobileqq.intervideo.groupvideo.plugininterface.IVHostCallback;
import java.util.concurrent.Future;

public class IVCommonImpl
  implements IVCommonInterface
{
  public Future<Bundle> getLocation(String paramString)
  {
    return IVCommonInterfaceImpl.getInstance().getLocation(paramString);
  }
  
  public void setHostActivityCallback(IVHostCallback paramIVHostCallback)
  {
    IVCommonInterfaceImpl.getInstance().setHostActivityCallback(paramIVHostCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.pluginimpl.IVCommonImpl
 * JD-Core Version:    0.7.0.1
 */