package com.tencent.qqperf.debug.tools;

import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.MagnifierSDK;
import com.tencent.qqperf.repoter.ReporterMachine;
import com.tencent.qqperf.repoter.ResultObject;
import java.io.File;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class ObjectForCallback
{
  public boolean equals(Object paramObject)
  {
    String str = (String)paramObject;
    try
    {
      boolean bool = "0".equals(AppSetting.g());
      if (!bool)
      {
        Object localObject = str;
        try
        {
          File localFile = new File(str);
          localObject = str;
          paramObject = str;
          if (localFile.exists())
          {
            localObject = str;
            paramObject = str;
            if (localFile.isDirectory())
            {
              localObject = str;
              paramObject = FileUtil.a(str);
              localObject = paramObject;
              if (paramObject.length() == 0)
              {
                localObject = paramObject;
                if (!QLog.isColorLevel()) {
                  break label255;
                }
                localObject = paramObject;
                QLog.e("IOMonitor", 2, "Magnifier IOMonitor newFileAbsoPath == 0.");
                break label255;
              }
              localObject = paramObject;
              FileUtil.a(localFile);
            }
          }
        }
        catch (Exception localException)
        {
          paramObject = localObject;
          if (QLog.isColorLevel())
          {
            QLog.e("Magnifier IOMonitor", 2, "Magnifier IOMonitor Do zip error.", localException);
            paramObject = localObject;
          }
        }
        localObject = new JSONObject();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("fileObj1", paramObject);
        paramObject = new JSONObject();
        paramObject.put("p_id", MagnifierSDK.b());
        paramObject.put("plugin", String.valueOf(6));
        paramObject.put("processname", ProcessUtil.a(MobileQQ.getContext()));
        ((JSONObject)localObject).put("fileObj", localJSONObject);
        ((JSONObject)localObject).put("clientinfo", paramObject);
        ((JSONObject)localObject).put("newplugin", 106);
        ReporterMachine.a(new ResultObject(0, "testcase", true, 1L, 1L, (JSONObject)localObject, true, true, MagnifierSDK.a));
      }
    }
    catch (Exception paramObject)
    {
      label249:
      break label249;
    }
    return true;
    label255:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.debug.tools.ObjectForCallback
 * JD-Core Version:    0.7.0.1
 */