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
    Object localObject2 = (String)paramObject;
    try
    {
      boolean bool = "0".equals(AppSetting.g());
      if (!bool)
      {
        localObject1 = localObject2;
        try
        {
          File localFile = new File((String)localObject2);
          paramObject = localObject2;
          if (localFile != null)
          {
            paramObject = localObject2;
            localObject1 = localObject2;
            if (localFile.exists())
            {
              paramObject = localObject2;
              localObject1 = localObject2;
              if (localFile.isDirectory())
              {
                localObject1 = localObject2;
                paramObject = FileUtil.a((String)localObject2);
                localObject1 = paramObject;
                if (paramObject.length() == 0)
                {
                  localObject1 = paramObject;
                  if (!QLog.isColorLevel()) {
                    break label263;
                  }
                  localObject1 = paramObject;
                  QLog.e("IOMonitor", 2, "Magnifier IOMonitor newFileAbsoPath == 0.");
                  return false;
                }
                localObject1 = paramObject;
                FileUtil.a(localFile);
              }
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            paramObject = localObject1;
            if (QLog.isColorLevel())
            {
              QLog.e("Magnifier IOMonitor", 2, "Magnifier IOMonitor Do zip error.", localException);
              paramObject = localObject1;
            }
          }
        }
        localObject1 = new JSONObject();
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("fileObj1", paramObject);
        paramObject = new JSONObject();
        paramObject.put("p_id", MagnifierSDK.b());
        paramObject.put("plugin", String.valueOf(6));
        paramObject.put("processname", ProcessUtil.a(MobileQQ.getContext()));
        ((JSONObject)localObject1).put("fileObj", localObject2);
        ((JSONObject)localObject1).put("clientinfo", paramObject);
        ((JSONObject)localObject1).put("newplugin", 106);
        ReporterMachine.a(new ResultObject(0, "testcase", true, 1L, 1L, (JSONObject)localObject1, true, true, MagnifierSDK.a));
      }
    }
    catch (Exception paramObject)
    {
      Object localObject1;
      break label265;
      label263:
      return false;
    }
    label265:
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqperf.debug.tools.ObjectForCallback
 * JD-Core Version:    0.7.0.1
 */