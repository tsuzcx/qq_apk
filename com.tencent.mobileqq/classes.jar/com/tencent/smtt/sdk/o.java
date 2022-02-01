package com.tencent.smtt.sdk;

import android.text.TextUtils;
import com.tencent.smtt.export.external.DexLoader;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

class o
{
  public boolean a = false;
  public boolean b = false;
  private Map<String, String> c = null;
  
  public JSONObject a()
  {
    localJSONObject = new JSONObject();
    Object localObject = this.c;
    if (localObject != null) {
      try
      {
        localObject = ((Map)localObject).entrySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
          localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
        }
        return localJSONObject;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void a(String paramString, byte paramByte)
  {
    for (;;)
    {
      String str;
      try
      {
        boolean bool = TextUtils.isEmpty(paramString);
        if (bool) {
          return;
        }
        str = "";
        if (paramByte == 1)
        {
          str = "_begin";
          Map localMap = this.c;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append(str);
          localMap.put(localStringBuilder.toString(), String.valueOf(System.currentTimeMillis()));
          return;
        }
      }
      finally {}
      if (paramByte == 2) {
        str = "_end";
      }
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        return;
      }
      this.c.put(paramString, String.valueOf(paramLong));
      return;
    }
    finally {}
  }
  
  public boolean a(int paramInt, String paramString)
  {
    try
    {
      Object localObject1 = x.a();
      if (((x)localObject1).b())
      {
        this.b = true;
        this.a = true;
        this.c.put("is_first_init_tbs", String.valueOf(this.b));
        this.c.put("is_first_init_x5", String.valueOf(this.a));
        this.c.put("x5_webview_id", Integer.toString(paramInt));
        this.c.put("current_url", paramString);
        if ((QbSdk.n != null) && (QbSdk.n.containsKey("app_scene_id")))
        {
          paramString = this.c;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("");
          ((StringBuilder)localObject2).append(QbSdk.n.get("app_scene_id"));
          paramString.put("app_scene_id", ((StringBuilder)localObject2).toString());
        }
        paramString = ((x)localObject1).c().b();
        localObject1 = Integer.TYPE;
        Object localObject2 = this.c;
        paramString.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "setTbsInitPerformanceData", new Class[] { localObject1, Map.class }, new Object[] { Integer.valueOf(paramInt), localObject2 });
        return true;
      }
      return false;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.o
 * JD-Core Version:    0.7.0.1
 */