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
  public static ArrayList<Class<? extends IColorNoteSettingCallback>> a;
  static List<IColorNoteSettingCallback> a;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaUtilArrayList.add(ColorNoteSettingCallback.class);
    jdField_a_of_type_JavaUtilList = new ArrayList();
    try
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Class localClass = (Class)localIterator.next();
        jdField_a_of_type_JavaUtilList.add(localClass.newInstance());
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
    Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((IColorNoteSettingCallback)localIterator.next()).a(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.settings.ColorNoteSettingUtil
 * JD-Core Version:    0.7.0.1
 */