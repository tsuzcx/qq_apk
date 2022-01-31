package com.tencent.mobileqq.flutter.engine;

import android.content.res.Resources;
import aqaf;
import com.tencent.TMG.utils.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class FlutterSkinEngineNativeImp$1
  implements Runnable
{
  public FlutterSkinEngineNativeImp$1(aqaf paramaqaf, ArrayList paramArrayList, Resources paramResources) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    Iterator localIterator = aqaf.c.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_AndroidContentResResources.getColorStateList(((Integer)aqaf.c.get(str)).intValue()));
    }
    if (QLog.isColorLevel()) {
      QLog.i("FlutterSkinEngineNativeImp", 0, "init and preCache colors cost:" + (System.currentTimeMillis() - l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.engine.FlutterSkinEngineNativeImp.1
 * JD-Core Version:    0.7.0.1
 */