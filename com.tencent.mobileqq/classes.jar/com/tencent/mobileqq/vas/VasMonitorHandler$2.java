package com.tencent.mobileqq.vas;

import android.text.TextUtils;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

class VasMonitorHandler$2
  implements Runnable
{
  VasMonitorHandler$2(VasMonitorHandler paramVasMonitorHandler, AppRuntime paramAppRuntime, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject1 = this.a;
    boolean bool2 = this.b;
    boolean bool1 = true;
    Object localObject3 = VasUpdateUtil.a((AppRuntime)localObject1, "monitorAppid", bool2 ^ true, null);
    if (localObject3 != null) {}
    for (;;)
    {
      try
      {
        this.this$0.a.clear();
        localObject1 = ((JSONObject)localObject3).optJSONArray("allAppidControl");
        int i = 0;
        if (localObject1 != null)
        {
          localObject1 = ((JSONArray)localObject1).optJSONObject(0);
          AtomicBoolean localAtomicBoolean = this.this$0.b;
          if ((localObject1 == null) || (!((JSONObject)localObject1).optBoolean("stopAllReport"))) {
            break label239;
          }
          localAtomicBoolean.set(bool1);
          if (this.this$0.b.get()) {
            return;
          }
          localObject3 = ((JSONObject)localObject3).optJSONArray("individualMonitorAppidList");
          if (localObject3 != null) {
            if (i < ((JSONArray)localObject3).length())
            {
              localObject1 = ((JSONArray)localObject3).optJSONObject(i);
              if (localObject1 == null) {
                break label244;
              }
              localObject1 = ((JSONObject)localObject1).optString("appid");
              if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                this.this$0.a.add(localObject1);
              }
              i += 1;
              continue;
            }
          }
          return;
        }
      }
      catch (Exception localException)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("parseBlackList err:");
        ((StringBuilder)localObject3).append(localException.getMessage());
        QLog.i("VasMonitorHandler", 2, ((StringBuilder)localObject3).toString());
      }
      Object localObject2 = null;
      continue;
      label239:
      bool1 = false;
      continue;
      label244:
      localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasMonitorHandler.2
 * JD-Core Version:    0.7.0.1
 */