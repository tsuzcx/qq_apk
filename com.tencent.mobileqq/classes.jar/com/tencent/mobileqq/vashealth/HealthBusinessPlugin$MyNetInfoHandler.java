package com.tencent.mobileqq.vashealth;

import android.os.Handler;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

class HealthBusinessPlugin$MyNetInfoHandler
  implements INetInfoHandler
{
  WebViewPlugin jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin;
  
  HealthBusinessPlugin$MyNetInfoHandler(HealthBusinessPlugin paramHealthBusinessPlugin1, HealthBusinessPlugin paramHealthBusinessPlugin2)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin = paramHealthBusinessPlugin2;
    QLog.d("HealthBusinessPlugin", 2, "plugin to do:" + this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin);
  }
  
  public void onNetMobile2None()
  {
    QLog.d("HealthBusinessPlugin", 1, "onNetMobile2None");
    for (;;)
    {
      try
      {
        JSONObject localJSONObject1 = new JSONObject();
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("status", "0");
        localJSONObject1.put("source", "none");
        int i = 0;
        Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.keySet().iterator();
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (((ISuperPlayer)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.get(str)).isPlaying())
          {
            ((ISuperPlayer)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.get(str)).pause();
            this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.a.post(this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.b);
            QLog.d("HealthBusinessPlugin", 1, "onNetMobile2None Broadcast");
            i = 1;
          }
        }
        else
        {
          if (i != 0) {
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.dispatchJsEvent("healthSport_networkStatusChanged", localJSONObject2, localJSONObject1);
          }
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.d("HealthBusinessPlugin", 1, "onNetMobile2None Exception");
        return;
      }
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    QLog.d("HealthBusinessPlugin", 1, "onNetMobile2Wifi");
    try
    {
      paramString = new JSONObject();
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("status", "1");
      paramString.put("source", "none");
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.dispatchJsEvent("healthSport_networkStatusChanged", (JSONObject)localObject, paramString);
      paramString = this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.keySet().iterator();
      while (paramString.hasNext())
      {
        localObject = (String)paramString.next();
        ((ISuperPlayer)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.get(localObject)).start();
      }
      QLog.d("HealthBusinessPlugin", 1, "onNetMobile2Wifi Broadcast");
    }
    catch (Exception paramString)
    {
      QLog.d("HealthBusinessPlugin", 1, "onNetMobile2Wifi Exception");
      return;
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    QLog.d("HealthBusinessPlugin", 1, "onNetNone2Mobile");
    for (;;)
    {
      try
      {
        paramString = new JSONObject();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("status", "2");
        paramString.put("source", "none");
        int i = 0;
        Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.keySet().iterator();
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          QLog.d("HealthBusinessPlugin", 2, "mVideoPlayerManager.get(key).isPlaying():" + ((ISuperPlayer)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.get(str)).isPlaying());
          if (((ISuperPlayer)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.get(str)).isPlaying())
          {
            ((ISuperPlayer)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.get(str)).pause();
            i = 1;
          }
        }
        else
        {
          if (i != 0) {
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.dispatchJsEvent("healthSport_networkStatusChanged", localJSONObject, paramString);
          }
          QLog.d("HealthBusinessPlugin", 1, "onNetNone2Mobile Broadcast");
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.d("HealthBusinessPlugin", 1, "onNetNone2Mobile Exception");
        return;
      }
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    QLog.d("HealthBusinessPlugin", 1, "onNetNone2Wifi");
    try
    {
      paramString = new JSONObject();
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("status", "1");
      paramString.put("source", "none");
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.dispatchJsEvent("healthSport_networkStatusChanged", (JSONObject)localObject, paramString);
      paramString = this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.keySet().iterator();
      while (paramString.hasNext())
      {
        localObject = (String)paramString.next();
        ((ISuperPlayer)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.get(localObject)).start();
      }
      QLog.d("HealthBusinessPlugin", 1, "onNetNone2Wifi Broadcast");
    }
    catch (Exception paramString)
    {
      QLog.d("HealthBusinessPlugin", 1, "onNetNone2Wifi Exception");
      return;
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    QLog.d("HealthBusinessPlugin", 1, "onNetWifi2Mobile");
    for (;;)
    {
      try
      {
        paramString = new JSONObject();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("status", "2");
        paramString.put("source", "none");
        int i = 0;
        Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.keySet().iterator();
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          QLog.d("HealthBusinessPlugin", 2, "mVideoPlayerManager.get(key).isPlaying():" + ((ISuperPlayer)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.get(str)).isPlaying());
          if (((ISuperPlayer)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.get(str)).isPlaying())
          {
            ((ISuperPlayer)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.get(str)).pause();
            i = 1;
          }
        }
        else
        {
          if (i != 0) {
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.dispatchJsEvent("healthSport_networkStatusChanged", localJSONObject, paramString);
          }
          QLog.d("HealthBusinessPlugin", 1, "onNetWifi2Mobile Broadcast");
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.d("HealthBusinessPlugin", 1, "onNetWifi2Mobile Exception");
        return;
      }
    }
  }
  
  public void onNetWifi2None()
  {
    QLog.d("HealthBusinessPlugin", 1, "onNetWifi2None");
    for (;;)
    {
      try
      {
        JSONObject localJSONObject1 = new JSONObject();
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("status", "0");
        localJSONObject1.put("source", "none");
        int i = 0;
        Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.keySet().iterator();
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (((ISuperPlayer)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.get(str)).isPlaying())
          {
            ((ISuperPlayer)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.get(str)).pause();
            this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.a.post(this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.b);
            QLog.d("HealthBusinessPlugin", 1, "onNetWifi2None Broadcast");
            i = 1;
          }
        }
        else
        {
          if (i != 0) {
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.dispatchJsEvent("healthSport_networkStatusChanged", localJSONObject2, localJSONObject1);
          }
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.d("HealthBusinessPlugin", 1, "onNetWifi2None Exception");
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthBusinessPlugin.MyNetInfoHandler
 * JD-Core Version:    0.7.0.1
 */