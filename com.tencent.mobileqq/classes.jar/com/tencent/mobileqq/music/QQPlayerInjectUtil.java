package com.tencent.mobileqq.music;

import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import java.util.ArrayList;

public class QQPlayerInjectUtil
{
  @ConfigInject(configPath="Foundation/QQAudio/src/main/resources/Inject_QQPlayerConfig.yml", version=1)
  public static ArrayList<Class<? extends IQQPlayerLifeCycleCallback>> a = new ArrayList();
  
  static
  {
    a.add(ColorNoteQQPlayerCallback.class);
    a.add(OnlineMusicStatusPlayerCallback.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.music.QQPlayerInjectUtil
 * JD-Core Version:    0.7.0.1
 */