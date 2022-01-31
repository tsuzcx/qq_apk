package com.tencent.mobileqq.jsp;

import ajyc;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import apvb;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import mqq.util.WeakReference;
import nam;
import org.json.JSONException;
import org.json.JSONObject;

public class WebRecordApiPlugin$AudioUploadTask
  implements Runnable
{
  protected int a;
  protected Handler a;
  protected AudioInfo a;
  protected String a;
  protected WeakReference<BaseActivity> a;
  private String b;
  
  public WebRecordApiPlugin$AudioUploadTask(WebRecordApiPlugin paramWebRecordApiPlugin, BaseActivity paramBaseActivity, Handler paramHandler, String paramString1, String paramString2, AudioInfo paramAudioInfo)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramBaseActivity);
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    if (paramAudioInfo != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = new AudioInfo(paramAudioInfo);
    }
    this.jdField_a_of_type_Int = -1;
  }
  
  public void run()
  {
    this.jdField_a_of_type_Int = 1;
    if (this.jdField_a_of_type_MqqUtilWeakReference == null) {}
    for (localObject1 = null; localObject1 == null; localObject1 = (BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebRecordApiPlugin", 2, "PreUploadTask activity is null!");
      }
      this.jdField_a_of_type_Int = 0;
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo == null) || (!apvb.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.path)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebRecordApiPlugin", 2, "Audio is null!");
      }
      this.jdField_a_of_type_Int = 0;
      return;
    }
    Object localObject2 = ((BaseActivity)localObject1).getAppRuntime();
    localObject1 = ((AppRuntime)localObject2).getAccount();
    localObject2 = ((TicketManager)((AppRuntime)localObject2).getManager(2)).getSkey((String)localObject1);
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      this.jdField_a_of_type_Int = 0;
      return;
    }
    Object localObject4 = new HashMap();
    ((Map)localObject4).put("type", "1");
    ((Map)localObject4).put("name", this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.path);
    ((Map)localObject4).put("fileName", this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.path);
    Object localObject5 = new HashMap();
    ((Map)localObject5).put("file", this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.path);
    HashMap localHashMap = new HashMap();
    localHashMap.put("Connection", "keep-alive");
    localHashMap.put("Referer", "http://www.qq.com");
    if (!TextUtils.isEmpty(this.b)) {
      localHashMap.put("Cookie", this.b);
    }
    localObject4 = nam.a(this.jdField_a_of_type_JavaLangString, (String)localObject1, (String)localObject2, (Map)localObject4, (Map)localObject5, localHashMap);
    localObject5 = new JSONObject();
    for (;;)
    {
      try
      {
        ((JSONObject)localObject5).put("path", this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.path);
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          localObject2 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(16711689);
          localObject1 = localObject2;
        }
        try
        {
          ((JSONObject)localObject5).put("msg", localObject4);
          ((Message)localObject2).obj = localObject5;
          this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
          this.jdField_a_of_type_Int = 0;
          return;
        }
        catch (JSONException localJSONException1) {}
        localObject4 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(16711690);
        localObject1 = localObject4;
        ((JSONObject)localObject5).put("msg", ajyc.a(2131716887));
        localObject2 = localObject4;
        localObject1 = localObject4;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject1 = localObject4;
        QLog.d("WebRecordApiPlugin", 2, "scalePublishImage failed: path = " + this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.path);
        localObject2 = localObject4;
        continue;
      }
      catch (JSONException localJSONException2)
      {
        Object localObject3;
        localObject1 = null;
        continue;
      }
      localJSONException1.printStackTrace();
      localObject3 = localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.WebRecordApiPlugin.AudioUploadTask
 * JD-Core Version:    0.7.0.1
 */