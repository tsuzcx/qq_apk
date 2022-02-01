package com.tencent.mobileqq.qqconnectface.impl;

import com.tencent.mobileqq.identification.FaceVideo;
import com.tencent.mobileqq.qqconnectface.api.IVideoService;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class VideoProxy
  implements IVideoService
{
  @ConfigInject(configPath="Business/qqconnectface-api/src/main/resources/Inject_connect_face_config.yml", version=1)
  private static ArrayList<Class<? extends IVideoService>> a = new ArrayList();
  private IVideoService b;
  
  static
  {
    a.add(FaceVideo.class);
  }
  
  public VideoProxy()
  {
    Class localClass = (Class)a.get(0);
    try
    {
      this.b = ((IVideoService)localClass.newInstance());
      return;
    }
    catch (Exception localException)
    {
      QLog.e("VideoProxy", 1, "IVideoService newInstance", localException);
    }
  }
  
  public boolean a(AppRuntime paramAppRuntime)
  {
    return this.b.a(paramAppRuntime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqconnectface.impl.VideoProxy
 * JD-Core Version:    0.7.0.1
 */