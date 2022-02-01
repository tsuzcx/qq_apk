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
  protected WeakReference<BaseActivity> a;
  protected String b;
  
  public void run()
  {
    this.jdField_a_of_type_Int = 1;
    Object localObject1 = this.jdField_a_of_type_MqqUtilWeakReference;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = (BaseActivity)((WeakReference)localObject1).get();
    }
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopBarPublishUtils", 2, "AudioUploadTask activity is null!");
      }
      this.jdField_a_of_type_Int = 0;
      return;
    }
    if (!FileUtil.b(this.b))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Audio is null! mAudioPath=");
        ((StringBuilder)localObject1).append(this.b);
        QLog.d("TroopBarPublishUtils", 2, ((StringBuilder)localObject1).toString());
      }
      this.jdField_a_of_type_Int = 0;
      return;
    }
    Object localObject3 = ((BaseActivity)localObject1).getAppRuntime();
    localObject1 = ((AppRuntime)localObject3).getAccount();
    localObject3 = ((TicketManager)((AppRuntime)localObject3).getManager(2)).getSkey((String)localObject1);
    if (TextUtils.isEmpty((CharSequence)localObject3))
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
    localHashMap3.put("Referer", "https://www.qq.com");
    localObject1 = HttpUtil.uploadImage(this.jdField_a_of_type_JavaLangString, (String)localObject1, (String)localObject3, localHashMap1, localHashMap2, localHashMap3);
    if (localObject1 != null)
    {
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        if (((JSONObject)localObject1).optInt("retcode", -1) != 0) {
          break label424;
        }
        localObject1 = ((JSONObject)localObject1).optJSONObject("result");
        if ((localObject1 == null) || (((JSONObject)localObject1).optInt("retcode") != 0)) {
          break label424;
        }
        localObject1 = ((JSONObject)localObject1).optString("url");
        localObject3 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1009);
        ((Message)localObject3).obj = localObject1;
        ((Message)localObject3).arg1 = 1;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject3);
      }
      catch (JSONException localJSONException)
      {
        if (!QLog.isColorLevel()) {
          break label424;
        }
      }
      QLog.d("TroopBarPublishUtils", 2, localJSONException.getMessage());
    }
    else
    {
      Object localObject2 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1004);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("uploadImage failed: path = ");
        ((StringBuilder)localObject2).append(this.b);
        QLog.d("TroopBarPublishUtils", 2, ((StringBuilder)localObject2).toString());
      }
    }
    label424:
    this.jdField_a_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarPublishUtils.AudioUploadTask
 * JD-Core Version:    0.7.0.1
 */