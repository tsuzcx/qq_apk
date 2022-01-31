package com.tencent.mobileqq.flutter.engine;

import android.content.res.Resources;
import arxu;
import com.tencent.TMG.utils.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class QFlutterResourceLoaderNativeImp$1
  implements Runnable
{
  public QFlutterResourceLoaderNativeImp$1(arxu paramarxu, ArrayList paramArrayList, Resources paramResources) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    Iterator localIterator = arxu.c.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_AndroidContentResResources.getColorStateList(((Integer)arxu.c.get(str)).intValue()));
    }
    if (QLog.isColorLevel()) {
      QLog.i("QFlutterResourceLoaderNativeImp", 0, "init and preCache colors cost:" + (System.currentTimeMillis() - l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.engine.QFlutterResourceLoaderNativeImp.1
 * JD-Core Version:    0.7.0.1
 */