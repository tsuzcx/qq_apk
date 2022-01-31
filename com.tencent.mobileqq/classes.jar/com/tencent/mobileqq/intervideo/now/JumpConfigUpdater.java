package com.tencent.mobileqq.intervideo.now;

import adus;
import android.os.Bundle;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class JumpConfigUpdater
  implements HttpWebCgiAsyncTask.Callback
{
  long jdField_a_of_type_Long = 0L;
  adus jdField_a_of_type_Adus;
  String jdField_a_of_type_JavaLangString = "https://now.qq.com/qq/play.html?_bid=2374&_wv=16778245&from=50319";
  boolean jdField_a_of_type_Boolean = false;
  boolean b;
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (paramJSONObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("XProxy|JumpConfigUpdater", 2, "拉取撑量开关 result字段为空");
      }
      if (this.jdField_a_of_type_Adus != null) {
        this.jdField_a_of_type_Adus.a(this.jdField_a_of_type_Boolean);
      }
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    paramInt = paramJSONObject.optInt("retcode", -1);
    if (paramInt == 0)
    {
      paramJSONObject = paramJSONObject.optJSONObject("result");
      paramInt = paramJSONObject.optInt("use_h5");
      if (paramInt == 0) {}
      for (boolean bool = false;; bool = true)
      {
        this.jdField_a_of_type_Boolean = bool;
        if (paramInt > 0) {
          this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("url");
        }
        this.b = true;
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("XProxy|JumpConfigUpdater", 2, "拉取撑量开关失败,默认跳转h5 retcode = " + paramInt);
    }
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.JumpConfigUpdater
 * JD-Core Version:    0.7.0.1
 */