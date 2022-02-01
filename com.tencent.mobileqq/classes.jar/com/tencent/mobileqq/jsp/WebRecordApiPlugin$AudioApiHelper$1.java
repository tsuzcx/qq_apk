package com.tencent.mobileqq.jsp;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.ptt.IQQRecorder;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.utils.AudioUtil;
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
    Object localObject;
    WebRecordApiPlugin localWebRecordApiPlugin;
    String str;
    StringBuilder localStringBuilder;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 16711690: 
      localObject = (JSONObject)paramMessage.obj;
      paramMessage = ((JSONObject)localObject).optString("msg", "");
      localObject = ((JSONObject)localObject).optString("path", "");
      localWebRecordApiPlugin = this.a.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin;
      str = WebRecordApiPlugin.a(this.a.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("{'code':1,'recordID':'");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("','msg':'");
      localStringBuilder.append(paramMessage);
      localStringBuilder.append("'}");
      localWebRecordApiPlugin.callJs(str, new String[] { localStringBuilder.toString() });
      return;
    case 16711689: 
      localObject = (JSONObject)paramMessage.obj;
      paramMessage = ((JSONObject)localObject).optString("msg", "");
      localObject = ((JSONObject)localObject).optString("path", "");
      localWebRecordApiPlugin = this.a.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin;
      str = WebRecordApiPlugin.a(this.a.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("{'code':0,'recordID':'");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("','result':");
      localStringBuilder.append(paramMessage);
      localStringBuilder.append("}");
      localWebRecordApiPlugin.callJs(str, new String[] { localStringBuilder.toString() });
      return;
    case 16711687: 
      this.a.a(0);
      return;
    case 16711686: 
      if (QLog.isColorLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("QQRecorder stop() is called,time is:");
        paramMessage.append(System.currentTimeMillis());
        QLog.d("QQRecorder", 2, paramMessage.toString());
      }
      WebRecordApiPlugin.AudioApiHelper.a(this.a).c();
      AudioUtil.b(2131230748, false);
      QQAudioUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, false);
      return;
    }
    this.a.a(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.WebRecordApiPlugin.AudioApiHelper.1
 * JD-Core Version:    0.7.0.1
 */