package com.tencent.mobileqq.colornote.settings;

import com.tencent.mobileqq.colornotebiz.settings.ColorNoteSettingCallback;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ColorNoteSettingUtil
{
  @ConfigInject(configPath="Business/ColorNote-impl/src/main/resources/Inject_ColorNoteSettingConfig.yml", version=1)
  public static ArrayList<Class<? extends IColorNoteSettingCallback>> a = new ArrayList();
  static List<IColorNoteSettingCallback> b = new ArrayList();
  
  static
  {
    a.add(ColorNoteSettingCallback.class);
    try
    {
      Iterator localIterator = a.iterator();
      while (localIterator.hasNext())
      {
        Class localClass = (Class)localIterator.next();
        b.add(localClass.newInstance());
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ColorNoteSettingUtil", 1, "[static]", localException);
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext()) {
      ((IColorNoteSettingCallback)localIterator.next()).a(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.settings.ColorNoteSettingUtil
 * JD-Core Version:    0.7.0.1
 */