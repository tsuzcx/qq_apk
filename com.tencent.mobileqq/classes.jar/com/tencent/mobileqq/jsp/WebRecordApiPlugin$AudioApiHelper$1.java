package com.tencent.mobileqq.jsp;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class WebRecordApiPlugin$AudioApiHelper$1
  extends Handler
{
  WebRecordApiPlugin$AudioApiHelper$1(WebRecordApiPlugin.AudioApiHelper paramAudioApiHelper, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 16711687: 
      this.a.a(0);
      return;
    case 16711686: 
      if (QLog.isColorLevel()) {
        QLog.d("QQRecorder", 2, "QQRecorder stop() is called,time is:" + System.currentTimeMillis());
      }
      WebRecordApiPlugin.AudioApiHelper.a(this.a).c();
      AudioUtil.b(2131230744, false);
      QQAudioUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, false);
      return;
    case 1: 
      this.a.a(1);
      return;
    case 16711689: 
      localObject = (JSONObject)paramMessage.obj;
      paramMessage = ((JSONObject)localObject).optString("msg", "");
      localObject = ((JSONObject)localObject).optString("path", "");
      this.a.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin.callJs(WebRecordApiPlugin.a(this.a.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin), new String[] { "{'code':0,'recordID':'" + (String)localObject + "','result':" + paramMessage + "}" });
      return;
    }
    Object localObject = (JSONObject)paramMessage.obj;
    paramMessage = ((JSONObject)localObject).optString("msg", "");
    localObject = ((JSONObject)localObject).optString("path", "");
    this.a.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin.callJs(WebRecordApiPlugin.a(this.a.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin), new String[] { "{'code':1,'recordID':'" + (String)localObject + "','msg':'" + paramMessage + "'}" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.WebRecordApiPlugin.AudioApiHelper.1
 * JD-Core Version:    0.7.0.1
 */