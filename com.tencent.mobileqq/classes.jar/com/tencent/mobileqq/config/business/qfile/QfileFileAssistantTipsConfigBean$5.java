package com.tencent.mobileqq.config.business.qfile;

import amyj;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import apue;
import awzy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class QfileFileAssistantTipsConfigBean$5
  implements Runnable
{
  public QfileFileAssistantTipsConfigBean$5(amyj paramamyj) {}
  
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
      apue.a("0X800AD01");
      localObject1 = ((QQAppInterface)localObject1).getApp().getSharedPreferences("qfile_file_assistant_tips" + ((QQAppInterface)localObject1).c(), 0);
      Object localObject3 = ((SharedPreferences)localObject1).getString("qfile_file_assistant_tips", "{}");
      try
      {
        localObject3 = new JSONObject((String)localObject3);
        amyj.a(this.this$0);
        amyj.b(this.this$0);
        ((JSONObject)localObject3).put("local_day_last_time", awzy.a());
        ((JSONObject)localObject3).put("local_day_times", amyj.c(this.this$0));
        ((JSONObject)localObject3).put("local_max_times", amyj.d(this.this$0));
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
 * Qualified Name:     com.tencent.mobileqq.config.business.qfile.QfileFileAssistantTipsConfigBean.5
 * JD-Core Version:    0.7.0.1
 */