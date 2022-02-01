package com.tencent.mobileqq.jsp;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

class WebRecordApiPlugin$AudioUploadTask
  implements Runnable
{
  protected int a;
  protected Handler a;
  protected AudioInfo a;
  protected String a;
  protected WeakReference<QBaseActivity> a;
  protected boolean a;
  private String b;
  
  public WebRecordApiPlugin$AudioUploadTask(WebRecordApiPlugin paramWebRecordApiPlugin, QBaseActivity paramQBaseActivity, Handler paramHandler, String paramString1, String paramString2, AudioInfo paramAudioInfo)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_MqqUtilWeakReference = null;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = null;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramQBaseActivity);
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    if (paramAudioInfo != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = new AudioInfo(paramAudioInfo);
    }
    this.jdField_a_of_type_Int = -1;
  }
  
  public void run()
  {
    this.jdField_a_of_type_Int = 1;
    Object localObject1 = this.jdField_a_of_type_MqqUtilWeakReference;
    Object localObject2 = null;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = (QBaseActivity)((WeakReference)localObject1).get();
    }
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebRecordApiPlugin", 2, "PreUploadTask activity is null!");
      }
      this.jdField_a_of_type_Int = 0;
      return;
    }
    Object localObject4 = this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo;
    if ((localObject4 != null) && (FileUtil.b(((AudioInfo)localObject4).path)))
    {
      localObject4 = ((QBaseActivity)localObject1).getAppRuntime();
      localObject1 = ((AppRuntime)localObject4).getAccount();
      localObject4 = ((TicketManager)((AppRuntime)localObject4).getManager(2)).getSkey((String)localObject1);
      if (TextUtils.isEmpty((CharSequence)localObject4))
      {
        this.jdField_a_of_type_Int = 0;
        return;
      }
      Object localObject5 = new HashMap();
      ((Map)localObject5).put("type", "1");
      ((Map)localObject5).put("name", this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.path);
      ((Map)localObject5).put("fileName", this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.path);
      HashMap localHashMap1 = new HashMap();
      localHashMap1.put("file", this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.path);
      HashMap localHashMap2 = new HashMap();
      localHashMap2.put("Connection", "keep-alive");
      localHashMap2.put("Referer", "https://www.qq.com");
      if (!TextUtils.isEmpty(this.b)) {
        localHashMap2.put("Cookie", this.b);
      }
      localObject4 = HttpUtil.uploadImage(this.jdField_a_of_type_JavaLangString, (String)localObject1, (String)localObject4, (Map)localObject5, localHashMap1, localHashMap2);
      localObject5 = new JSONObject();
      localObject1 = localObject2;
      Object localObject3;
      try
      {
        ((JSONObject)localObject5).put("path", this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.path);
        localObject1 = localObject2;
        boolean bool = TextUtils.isEmpty((CharSequence)localObject4);
        if (!bool)
        {
          localObject1 = localObject2;
          localObject2 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(16711689);
          localObject1 = localObject2;
          ((JSONObject)localObject5).put("msg", localObject4);
        }
        else
        {
          localObject1 = localObject2;
          localObject4 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(16711690);
          localObject1 = localObject4;
          ((JSONObject)localObject5).put("msg", HardCodeUtil.a(2131716366));
          localObject1 = localObject4;
          localObject2 = localObject4;
          if (QLog.isColorLevel())
          {
            localObject1 = localObject4;
            localObject2 = new StringBuilder();
            localObject1 = localObject4;
            ((StringBuilder)localObject2).append("scalePublishImage failed: path = ");
            localObject1 = localObject4;
            ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo.path);
            localObject1 = localObject4;
            QLog.d("WebRecordApiPlugin", 2, ((StringBuilder)localObject2).toString());
            localObject2 = localObject4;
          }
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        localObject3 = localObject1;
      }
      localObject3.obj = localObject5;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localObject3);
      this.jdField_a_of_type_Int = 0;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebRecordApiPlugin", 2, "Audio is null!");
    }
    this.jdField_a_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.WebRecordApiPlugin.AudioUploadTask
 * JD-Core Version:    0.7.0.1
 */