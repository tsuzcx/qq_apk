package com.tencent.mobileqq.kandian.repo.aladdin.handlers;

import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.AladdinParseUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJMaybeInitializedAladdinConfig;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class VDynamicConfigHandler
  extends SimpleConfigHandler
{
  public static JSONObject a(int paramInt)
  {
    localJSONObject = new JSONObject();
    try
    {
      Object localObject1 = Aladdin.getConfig(paramInt);
      if (localObject1 == null) {
        return localJSONObject;
      }
      localObject1 = ((AladdinConfig)localObject1).getAll().entrySet().iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        localJSONObject.put((String)((Map.Entry)localObject2).getKey(), ((Map.Entry)localObject2).getValue());
      }
      return localJSONObject;
    }
    catch (Throwable localThrowable)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getMultiVideoConfig error: ");
      ((StringBuilder)localObject2).append(localThrowable.getMessage());
      QLog.e("DyHandler", 1, ((StringBuilder)localObject2).toString());
    }
  }
  
  public static int[] a()
  {
    try
    {
      Object localObject1 = (String)RIJSPUtils.b("key_viola_dynamic", "");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return null;
      }
      localObject1 = ((String)localObject1).split("\\|");
      if (localObject1.length == 0) {
        return null;
      }
      localObject2 = new int[localObject1.length];
      int i = 0;
      while (i < localObject1.length)
      {
        localObject2[i] = Integer.parseInt(localObject1[i]);
        i += 1;
      }
      return localObject2;
    }
    catch (Throwable localThrowable)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getDyIds error: ");
      ((StringBuilder)localObject2).append(localThrowable.getMessage());
      QLog.e("DyHandler", 1, ((StringBuilder)localObject2).toString());
    }
    return null;
  }
  
  public static JSONObject b()
  {
    return a(299);
  }
  
  public static JSONObject c()
  {
    return a(291);
  }
  
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    super.onReceiveConfig(paramInt1, paramInt2, paramString);
    try
    {
      paramString = AladdinParseUtils.a(paramString).entrySet().iterator();
      Object localObject1;
      while (paramString.hasNext())
      {
        Object localObject2 = (Map.Entry)paramString.next();
        localObject1 = (String)RIJSPUtils.b("key_viola_dynamic", "");
        localObject2 = (String)((Map.Entry)localObject2).getValue();
        RIJSPUtils.a("key_viola_dynamic", localObject2);
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!((String)localObject2).equals(localObject1)) && (RIJQQAppInterfaceUtil.a() != null)) {
          RIJMaybeInitializedAladdinConfig.b();
        }
      }
      return true;
    }
    catch (Throwable paramString)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("parse dynamic error: ");
      ((StringBuilder)localObject1).append(paramString.getMessage());
      QLog.e("DyHandler", 0, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
    RIJSPUtils.a("key_viola_dynamic", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.handlers.VDynamicConfigHandler
 * JD-Core Version:    0.7.0.1
 */