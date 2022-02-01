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
    paramHealthBusinessPlugin1 = new StringBuilder();
    paramHealthBusinessPlugin1.append("plugin to do:");
    paramHealthBusinessPlugin1.append(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin);
    QLog.d("HealthBusinessPlugin", 2, paramHealthBusinessPlugin1.toString());
  }
  
  public void onNetMobile2None()
  {
    QLog.d("HealthBusinessPlugin", 1, "onNetMobile2None");
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("status", "0");
      localJSONObject1.put("source", "none");
      int i = 0;
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.keySet().iterator();
      while (localIterator.hasNext())
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
      if (i == 0) {
        break label181;
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.dispatchJsEvent("healthSport_networkStatusChanged", localJSONObject2, localJSONObject1);
      return;
    }
    catch (Exception localException)
    {
      label173:
      label181:
      break label173;
    }
    QLog.d("HealthBusinessPlugin", 1, "onNetMobile2None Exception");
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
      return;
    }
    catch (Exception paramString)
    {
      label119:
      break label119;
    }
    QLog.d("HealthBusinessPlugin", 1, "onNetMobile2Wifi Exception");
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    QLog.d("HealthBusinessPlugin", 1, "onNetNone2Mobile");
    try
    {
      paramString = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("status", "2");
      paramString.put("source", "none");
      int i = 0;
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mVideoPlayerManager.get(key).isPlaying():");
        localStringBuilder.append(((ISuperPlayer)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.get(str)).isPlaying());
        QLog.d("HealthBusinessPlugin", 2, localStringBuilder.toString());
        if (((ISuperPlayer)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.get(str)).isPlaying())
        {
          ((ISuperPlayer)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.get(str)).pause();
          i = 1;
        }
      }
      if (i != 0) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.dispatchJsEvent("healthSport_networkStatusChanged", localJSONObject, paramString);
      }
      QLog.d("HealthBusinessPlugin", 1, "onNetNone2Mobile Broadcast");
      return;
    }
    catch (Exception paramString)
    {
      label209:
      break label209;
    }
    QLog.d("HealthBusinessPlugin", 1, "onNetNone2Mobile Exception");
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
      return;
    }
    catch (Exception paramString)
    {
      label119:
      break label119;
    }
    QLog.d("HealthBusinessPlugin", 1, "onNetNone2Wifi Exception");
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    QLog.d("HealthBusinessPlugin", 1, "onNetWifi2Mobile");
    try
    {
      paramString = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("status", "2");
      paramString.put("source", "none");
      int i = 0;
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mVideoPlayerManager.get(key).isPlaying():");
        localStringBuilder.append(((ISuperPlayer)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.get(str)).isPlaying());
        QLog.d("HealthBusinessPlugin", 2, localStringBuilder.toString());
        if (((ISuperPlayer)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.get(str)).isPlaying())
        {
          ((ISuperPlayer)this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.get(str)).pause();
          i = 1;
        }
      }
      if (i != 0) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.dispatchJsEvent("healthSport_networkStatusChanged", localJSONObject, paramString);
      }
      QLog.d("HealthBusinessPlugin", 1, "onNetWifi2Mobile Broadcast");
      return;
    }
    catch (Exception paramString)
    {
      label209:
      break label209;
    }
    QLog.d("HealthBusinessPlugin", 1, "onNetWifi2Mobile Exception");
  }
  
  public void onNetWifi2None()
  {
    QLog.d("HealthBusinessPlugin", 1, "onNetWifi2None");
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("status", "0");
      localJSONObject1.put("source", "none");
      int i = 0;
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqVashealthHealthBusinessPlugin.d.keySet().iterator();
      while (localIterator.hasNext())
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
      if (i == 0) {
        break label181;
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.dispatchJsEvent("healthSport_networkStatusChanged", localJSONObject2, localJSONObject1);
      return;
    }
    catch (Exception localException)
    {
      label173:
      label181:
      break label173;
    }
    QLog.d("HealthBusinessPlugin", 1, "onNetWifi2None Exception");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.HealthBusinessPlugin.MyNetInfoHandler
 * JD-Core Version:    0.7.0.1
 */