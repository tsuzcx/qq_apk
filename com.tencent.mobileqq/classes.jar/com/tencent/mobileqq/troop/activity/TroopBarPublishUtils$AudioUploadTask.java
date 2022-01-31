package com.tencent.mobileqq.troop.activity;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopBarPublishUtils$AudioUploadTask
  implements Runnable
{
  protected int a;
  protected Handler a;
  protected String a;
  protected WeakReference a;
  protected String b;
  
  public TroopBarPublishUtils$AudioUploadTask(BaseActivity paramBaseActivity, Handler paramHandler, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramBaseActivity);
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.b = paramString2;
    this.jdField_a_of_type_Int = -1;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void run()
  {
    this.jdField_a_of_type_Int = 1;
    if (this.jdField_a_of_type_MqqUtilWeakReference == null) {}
    for (Object localObject1 = null; localObject1 == null; localObject1 = (BaseActivity)this.jdField_a_of_type_MqqUtilWeakReference.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopBarPublishUtils", 2, "AudioUploadTask activity is null!");
      }
      this.jdField_a_of_type_Int = 0;
      return;
    }
    if (!FileUtil.a(this.b))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopBarPublishUtils", 2, "Audio is null! mAudioPath=" + this.b);
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
    HashMap localHashMap1 = new HashMap();
    localHashMap1.put("type", "1");
    localHashMap1.put("name", this.b);
    localHashMap1.put("fileName", this.b);
    HashMap localHashMap2 = new HashMap();
    localHashMap2.put("file", this.b);
    HashMap localHashMap3 = new HashMap();
    localHashMap3.put("Connection", "keep-alive");
    localHashMap3.put("Referer", "http://www.qq.com");
    localObject1 = HttpUtil.a(this.jdField_a_of_type_JavaLangString, (String)localObject1, (String)localObject2, localHashMap1, localHashMap2, localHashMap3);
    if (localObject1 != null) {}
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        if (((JSONObject)localObject1).optInt("retcode", -1) == 0)
        {
          localObject1 = ((JSONObject)localObject1).optJSONObject("result");
          if ((localObject1 != null) && (((JSONObject)localObject1).optInt("retcode") == 0))
          {
            localObject1 = ((JSONObject)localObject1).optString("url");
            localObject2 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1009);
            ((Message)localObject2).obj = localObject1;
            ((Message)localObject2).arg1 = 1;
            this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
          }
        }
      }
      catch (JSONException localJSONException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("TroopBarPublishUtils", 2, localJSONException.getMessage());
        continue;
      }
      this.jdField_a_of_type_Int = 0;
      return;
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1004);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      if (QLog.isColorLevel()) {
        QLog.d("TroopBarPublishUtils", 2, "uploadImage failed: path = " + this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarPublishUtils.AudioUploadTask
 * JD-Core Version:    0.7.0.1
 */