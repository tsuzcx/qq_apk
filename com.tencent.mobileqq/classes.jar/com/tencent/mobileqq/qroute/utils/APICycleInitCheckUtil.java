package com.tencent.mobileqq.qroute.utils;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteConfig;
import java.util.ArrayList;

public class APICycleInitCheckUtil
{
  private static final ThreadLocal<ArrayList<String>> API_CYCLE_CHECK = new ThreadLocal();
  
  public static void checkAndRemove(@NonNull String paramString)
  {
    if (!QRoute.getConfig().isForceCheck()) {
      return;
    }
    if ((API_CYCLE_CHECK.get() != null) && (!((ArrayList)API_CYCLE_CHECK.get()).isEmpty()) && (paramString.compareTo((String)((ArrayList)API_CYCLE_CHECK.get()).get(0)) == 0)) {
      API_CYCLE_CHECK.remove();
    }
  }
  
  public static boolean checkAndSet(@NonNull String paramString)
  {
    if (!QRoute.getConfig().isForceCheck()) {
      return true;
    }
    if (API_CYCLE_CHECK.get() == null)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramString);
      API_CYCLE_CHECK.set(localArrayList);
      return true;
    }
    if (((ArrayList)API_CYCLE_CHECK.get()).contains(paramString)) {
      return false;
    }
    ((ArrayList)API_CYCLE_CHECK.get()).add(paramString);
    return true;
  }
  
  public static void removeOnException()
  {
    if (!QRoute.getConfig().isForceCheck()) {
      return;
    }
    if (API_CYCLE_CHECK.get() != null) {
      API_CYCLE_CHECK.remove();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.utils.APICycleInitCheckUtil
 * JD-Core Version:    0.7.0.1
 */