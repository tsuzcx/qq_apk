package com.tencent.mobileqq.colornote.smallscreen;

import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import java.util.ArrayList;

public class ColorNoteServiceLifecycleInjectUtil
{
  @ConfigInject(configPath="Business/ColorNote-impl/src/main/resources/Inject_ColorNoteServiceConfig.yml", version=1)
  public static ArrayList<Class<? extends IColorNoteServiceLifecycleCallback>> a = new ArrayList();
  
  static
  {
    a.add(ColorNoteUpcomingServiceCallback.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.smallscreen.ColorNoteServiceLifecycleInjectUtil
 * JD-Core Version:    0.7.0.1
 */