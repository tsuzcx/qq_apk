package com.tencent.qphone.base.util.log.a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.auth.b;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class j
{
  private static final String a = "uploadlogpushseq";
  private static final long b = 259200000L;
  
  public static void a(long paramLong)
  {
    Object localObject2 = BaseApplication.getContext().getSharedPreferences("uploadlogpushseq", 0);
    String str = MsfService.getCore().getAccountCenter().i();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("uploadlogpushseq");
    ((StringBuilder)localObject1).append(str);
    localObject1 = ((SharedPreferences)localObject2).getString(((StringBuilder)localObject1).toString(), null);
    if (localObject1 == null) {}
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject();
        continue;
        localObject1 = new JSONObject((String)localObject1);
        Object localObject3 = ((JSONObject)localObject1).keys();
        if (((Iterator)localObject3).hasNext())
        {
          long l = ((Long)((JSONObject)localObject1).get((String)((Iterator)localObject3).next())).longValue();
          if (System.currentTimeMillis() - l > 259200000L)
          {
            ((Iterator)localObject3).remove();
            continue;
            ((JSONObject)localObject1).put(String.valueOf(paramLong), System.currentTimeMillis());
            localObject2 = ((SharedPreferences)localObject2).edit();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("uploadlogpushseq");
            ((StringBuilder)localObject3).append(str);
            ((SharedPreferences.Editor)localObject2).putString(((StringBuilder)localObject3).toString(), ((JSONObject)localObject1).toString()).commit();
            return;
          }
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
    }
  }
  
  public static boolean b(long paramLong)
  {
    Object localObject = BaseApplication.getContext().getSharedPreferences("uploadlogpushseq", 0);
    String str = MsfService.getCore().getAccountCenter().i();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uploadlogpushseq");
    localStringBuilder.append(str);
    localObject = ((SharedPreferences)localObject).getString(localStringBuilder.toString(), null);
    if (localObject == null) {
      return false;
    }
    try
    {
      boolean bool = new JSONObject((String)localObject).has(String.valueOf(paramLong));
      return bool;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qphone.base.util.log.a.j
 * JD-Core Version:    0.7.0.1
 */