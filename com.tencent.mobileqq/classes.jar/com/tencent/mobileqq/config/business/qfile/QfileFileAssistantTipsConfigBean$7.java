package com.tencent.mobileqq.config.business.qfile;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import aopq;
import arng;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class QfileFileAssistantTipsConfigBean$7
  implements Runnable
{
  public QfileFileAssistantTipsConfigBean$7(aopq paramaopq) {}
  
  public void run()
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface)) {}
    Object localObject2;
    for (localObject1 = (QQAppInterface)localObject1;; localObject2 = null)
    {
      if (localObject1 == null)
      {
        QLog.e("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, "app is null!!!");
        return;
      }
      arng.a("0X800AD02");
      localObject1 = ((QQAppInterface)localObject1).getApp().getSharedPreferences("qfile_file_assistant_tips" + ((QQAppInterface)localObject1).c(), 0);
      Object localObject3 = ((SharedPreferences)localObject1).getString("qfile_file_assistant_tips", "{}");
      try
      {
        localObject3 = new JSONObject((String)localObject3);
        aopq.f(this.this$0);
        ((JSONObject)localObject3).put("local_click_times", aopq.g(this.this$0));
        localObject3 = ((JSONObject)localObject3).toString();
        if (QLog.isDebugVersion()) {
          QLog.i("QfileFileAssistantTipsConfigBean<FileAssistant>", 1, (String)localObject3);
        }
        ((SharedPreferences)localObject1).edit().putString("qfile_file_assistant_tips", (String)localObject3).apply();
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qfile.QfileFileAssistantTipsConfigBean.7
 * JD-Core Version:    0.7.0.1
 */