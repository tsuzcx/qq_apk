package com.tencent.qqperf.repoter;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.MagnifierSDK;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import org.json.JSONObject;

public class StackObserver
  implements Observer
{
  public void update(Observable paramObservable, Object paramObject)
  {
    Object localObject = ((StackObservable)paramObservable).a;
    if ("t_held_thread".equals((String)((HashMap)localObject).get("key_type"))) {}
    try
    {
      paramObservable = new JSONObject();
      paramObject = new JSONObject();
      paramObject.put("fileObj1", ((HashMap)localObject).get("filePath"));
      localObject = new JSONObject();
      ((JSONObject)localObject).put("p_id", MagnifierSDK.b());
      paramObservable.put("fileObj", paramObject);
      paramObservable.put("clientinfo", localObject);
      paramObservable.put("newplugin", 123);
      ReporterMachine.a(new ResultObject(0, "testcase", true, 1L, 1L, paramObservable, true, true, MagnifierSDK.a));
      if (QLog.isColorLevel()) {
        QLog.d("StackObserver", 2, "report apm suc");
      }
      return;
    }
    catch (Exception paramObservable)
    {
      QLog.e("StackObserver", 1, "report apm fail", paramObservable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqperf.repoter.StackObserver
 * JD-Core Version:    0.7.0.1
 */