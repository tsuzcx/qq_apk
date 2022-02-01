package com.tencent.util;

import android.support.annotation.NonNull;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.app.identity.IQSafeConfigCallback;
import com.tencent.mobileqq.manager.QSafeManagerBean;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ZipConfigCallback
  implements IQSafeConfigCallback
{
  private void b(QSafeManagerBean paramQSafeManagerBean)
  {
    int i;
    if (paramQSafeManagerBean == null) {
      i = 20;
    } else {
      i = paramQSafeManagerBean.c();
    }
    ZipReporter.a(i);
    ZipUtils.setUnzipCallback(new ZipConfigCallback.1(this));
  }
  
  public void a(@NonNull QSafeManagerBean paramQSafeManagerBean)
  {
    paramQSafeManagerBean.a(20);
    b(paramQSafeManagerBean);
  }
  
  public void a(@NonNull QSafeManagerBean paramQSafeManagerBean, String paramString)
  {
    try
    {
      paramQSafeManagerBean.a(new JSONObject(paramString).optInt("zip_unusual_threshold"));
    }
    catch (JSONException paramString)
    {
      QLog.d("ZipConfigCallback", 1, "onParsed JSONException : ", paramString);
    }
    b(paramQSafeManagerBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.util.ZipConfigCallback
 * JD-Core Version:    0.7.0.1
 */