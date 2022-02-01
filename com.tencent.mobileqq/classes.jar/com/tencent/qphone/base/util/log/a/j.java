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
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("uploadlogpushseq", 0);
    String str = MsfService.getCore().getAccountCenter().i();
    Object localObject = localSharedPreferences.getString("uploadlogpushseq" + str, null);
    if (localObject == null) {}
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put(String.valueOf(paramLong), System.currentTimeMillis());
        localSharedPreferences.edit().putString("uploadlogpushseq" + str, ((JSONObject)localObject).toString()).commit();
        return;
      }
      catch (JSONException localJSONException)
      {
        Iterator localIterator;
        long l;
        localJSONException.printStackTrace();
        return;
      }
      localObject = new JSONObject((String)localObject);
      localIterator = ((JSONObject)localObject).keys();
      if (localIterator.hasNext())
      {
        l = ((Long)((JSONObject)localObject).get((String)localIterator.next())).longValue();
        if (System.currentTimeMillis() - l > 259200000L) {
          localIterator.remove();
        }
      }
    }
  }
  
  public static boolean b(long paramLong)
  {
    Object localObject = BaseApplication.getContext().getSharedPreferences("uploadlogpushseq", 0);
    String str = MsfService.getCore().getAccountCenter().i();
    localObject = ((SharedPreferences)localObject).getString("uploadlogpushseq" + str, null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.log.a.j
 * JD-Core Version:    0.7.0.1
 */