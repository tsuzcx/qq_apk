package com.tencent.qqperf.monitor.crash.tools;

import android.content.BroadcastReceiver;
import android.content.Context;
import com.tencent.mobileqq.utils.kapalaiadapter.ReflecterHelper;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ReceiverInfoRecordHelper
{
  public static void a(Context paramContext, StringBuilder paramStringBuilder)
  {
    Object localObject1 = ReflecterHelper.a("android.app.ActivityThread", "currentActivityThread", new Object[0], new Class[0]);
    paramContext = paramContext.getPackageName();
    paramContext = (Map)ReflecterHelper.a("android.app.LoadedApk", ((WeakReference)((Map)ReflecterHelper.a("android.app.ActivityThread", localObject1, "mPackages")).get(paramContext)).get(), "mReceivers");
    localObject1 = paramContext.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      Iterator localIterator = ((Map)paramContext.get(localObject2)).keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject3 = localIterator.next();
        paramStringBuilder.append("\n");
        localObject3 = (BroadcastReceiver)localObject3;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localObject3.getClass().getName());
        localStringBuilder.append(":");
        localStringBuilder.append(localObject3);
        paramStringBuilder.append(localStringBuilder.toString());
        paramStringBuilder.append(" in ");
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(localObject2.getClass().getName());
        ((StringBuilder)localObject3).append(":");
        ((StringBuilder)localObject3).append(localObject2);
        paramStringBuilder.append(((StringBuilder)localObject3).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.monitor.crash.tools.ReceiverInfoRecordHelper
 * JD-Core Version:    0.7.0.1
 */