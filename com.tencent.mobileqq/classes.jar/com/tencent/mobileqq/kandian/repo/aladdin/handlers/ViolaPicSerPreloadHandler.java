package com.tencent.mobileqq.kandian.repo.aladdin.handlers;

import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.AladdinParseUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ViolaPicSerPreloadHandler
  extends SimpleConfigHandler
{
  public static String a = "ViolaPicSerPreloadHandler";
  public static String b = "viola_service_instance";
  
  public static boolean a()
  {
    return ((Boolean)RIJSPUtils.a(b, Boolean.valueOf(false))).booleanValue();
  }
  
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    super.onReceiveConfig(paramInt1, paramInt2, paramString);
    Object localObject1 = a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[onReceiveConfig] id=");
    ((StringBuilder)localObject2).append(paramInt1);
    ((StringBuilder)localObject2).append(", version=");
    ((StringBuilder)localObject2).append(paramInt2);
    ((StringBuilder)localObject2).append(", content=");
    ((StringBuilder)localObject2).append(paramString);
    QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    localObject1 = AladdinParseUtils.a(paramString);
    localObject2 = ((Map)localObject1).keySet();
    for (;;)
    {
      try
      {
        localObject2 = ((Set)localObject2).iterator();
        Object localObject3;
        if (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          localObject3 = (String)((Map)localObject1).get(str);
          if (!TextUtils.equals(str, "viola_service_instance_open")) {
            continue;
          }
          str = b;
          if (Integer.parseInt((String)localObject3) == 1)
          {
            bool = true;
            RIJSPUtils.a(str, Boolean.valueOf(bool));
          }
        }
        else
        {
          return true;
        }
      }
      catch (Throwable localThrowable)
      {
        localObject2 = a;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("[onReceiveConfig] id=");
        ((StringBuilder)localObject3).append(paramInt1);
        ((StringBuilder)localObject3).append(", version=");
        ((StringBuilder)localObject3).append(paramInt2);
        ((StringBuilder)localObject3).append(", content=");
        ((StringBuilder)localObject3).append(paramString);
        ((StringBuilder)localObject3).append(" , error= ");
        ((StringBuilder)localObject3).append(localThrowable.getMessage());
        QLog.e((String)localObject2, 2, ((StringBuilder)localObject3).toString());
      }
      boolean bool = false;
    }
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
    RIJSPUtils.a(b, Boolean.valueOf(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.handlers.ViolaPicSerPreloadHandler
 * JD-Core Version:    0.7.0.1
 */