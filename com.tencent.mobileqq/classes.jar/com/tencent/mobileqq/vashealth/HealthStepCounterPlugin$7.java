package com.tencent.mobileqq.vashealth;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class HealthStepCounterPlugin$7
  implements SensorEventListener
{
  HealthStepCounterPlugin$7(HealthStepCounterPlugin paramHealthStepCounterPlugin) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    Object localObject = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Current step data:");
    localStringBuilder.append(String.valueOf(paramSensorEvent.values[0]));
    ((HealthStepCounterPlugin)localObject).e = localStringBuilder.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onSensorChanged:");
    ((StringBuilder)localObject).append(this.a.e);
    QLog.d("HealthStepCounterPlugin", 1, ((StringBuilder)localObject).toString());
    if ((HealthStepCounterPlugin.jdField_b_of_type_Int == 1) && (HealthStepCounterPlugin.jdField_b_of_type_Boolean))
    {
      this.a.c = ((int)paramSensorEvent.values[0]);
      HealthStepCounterPlugin.jdField_b_of_type_Boolean = false;
    }
    if (HealthStepCounterPlugin.jdField_b_of_type_Int == 3)
    {
      HealthStepCounterPlugin.jdField_b_of_type_Int = 0;
      this.a.d = ((int)paramSensorEvent.values[0]);
    }
    try
    {
      paramSensorEvent = new JSONObject();
      paramSensorEvent.put("retCode", 0);
      paramSensorEvent.put("step", this.a.d - this.a.c);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("source", "none");
      paramSensorEvent = WebViewPlugin.toJsScript("StepsDetect", paramSensorEvent, (JSONObject)localObject);
      if (!HealthStepCounterPlugin.a) {
        break label370;
      }
      localObject = this.a.mRuntime.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("javascript:");
      localStringBuilder.append(paramSensorEvent);
      ((CustomWebView)localObject).loadUrl(localStringBuilder.toString());
      paramSensorEvent = new StringBuilder();
      paramSensorEvent.append("Steps detect:");
      paramSensorEvent.append(this.a.d - this.a.c);
      QLog.d("HealthStepCounterPlugin", 1, paramSensorEvent.toString());
      HealthStepCounterPlugin.a = false;
    }
    catch (Exception paramSensorEvent)
    {
      label296:
      break label296;
    }
    paramSensorEvent = new JSONObject();
    try
    {
      paramSensorEvent.put("retCode", -1);
      paramSensorEvent.put("step", 0);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("source", "none");
      this.a.dispatchJsEvent("StepsDetect", paramSensorEvent, (JSONObject)localObject);
    }
    catch (JSONException paramSensorEvent)
    {
      paramSensorEvent.printStackTrace();
    }
    if (QLog.isColorLevel()) {
      QLog.i("HealthStepCounterPlugin", 2, "Err StepsDetect");
    }
    label370:
    HealthStepCounterPlugin.jdField_b_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthStepCounterPlugin.7
 * JD-Core Version:    0.7.0.1
 */