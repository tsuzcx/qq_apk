package com.tencent.mobileqq.flutter.plugin;

import android.content.res.Resources;
import com.tencent.TMG.utils.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class QFlutterResourceLoaderNativeImp$1
  implements Runnable
{
  QFlutterResourceLoaderNativeImp$1(QFlutterResourceLoaderNativeImp paramQFlutterResourceLoaderNativeImp, ArrayList paramArrayList, Resources paramResources) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    this.a.clear();
    Object localObject = QFlutterResourceLoaderNativeImp.c.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      this.a.add(this.b.getColorStateList(((Integer)QFlutterResourceLoaderNativeImp.c.get(str)).intValue()));
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("init and preCache colors cost:");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
      QLog.i("QFlutterResourceLoaderNativeImp", 0, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.plugin.QFlutterResourceLoaderNativeImp.1
 * JD-Core Version:    0.7.0.1
 */