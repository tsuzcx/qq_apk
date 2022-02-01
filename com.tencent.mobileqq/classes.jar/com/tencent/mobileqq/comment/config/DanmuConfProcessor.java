package com.tencent.mobileqq.comment.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class DanmuConfProcessor
  extends IQConfigProcessor<DanmuConfProcessor.DanmuConfBean>
{
  private static boolean a;
  
  public static boolean a()
  {
    DanmuConfProcessor.DanmuConfBean localDanmuConfBean = (DanmuConfProcessor.DanmuConfBean)QConfigManager.a().a(576);
    if ((localDanmuConfBean != null) && (!TextUtils.isEmpty(localDanmuConfBean.a))) {
      a = "1".equals(localDanmuConfBean.a);
    }
    return a;
  }
  
  @NonNull
  public DanmuConfProcessor.DanmuConfBean a(int paramInt)
  {
    return new DanmuConfProcessor.DanmuConfBean();
  }
  
  public DanmuConfProcessor.DanmuConfBean a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("IsDanmuEnable");
      if (QLog.isColorLevel()) {
        QLog.e("DanmuConfProcessor", 2, "parse conf, IsDanmuEnable:" + paramString);
      }
      paramString = new DanmuConfProcessor.DanmuConfBean(paramString.trim());
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  @Nullable
  public DanmuConfProcessor.DanmuConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      DanmuConfProcessor.DanmuConfBean localDanmuConfBean = a(paramArrayOfQConfItem[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("DanmuConfProcessor", 2, "onParsed " + paramArrayOfQConfItem[0].a);
      }
      return localDanmuConfBean;
    }
    return new DanmuConfProcessor.DanmuConfBean();
  }
  
  public void a(DanmuConfProcessor.DanmuConfBean paramDanmuConfBean)
  {
    if ((paramDanmuConfBean != null) && (!TextUtils.isEmpty(paramDanmuConfBean.a)))
    {
      a = "1".equals(paramDanmuConfBean.a);
      if (QLog.isColorLevel()) {
        QLog.e("DanmuConfProcessor", 2, "onUpdate, isDanmuEnable:" + a);
      }
    }
  }
  
  public Class<DanmuConfProcessor.DanmuConfBean> clazz()
  {
    return DanmuConfProcessor.DanmuConfBean.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 576;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.comment.config.DanmuConfProcessor
 * JD-Core Version:    0.7.0.1
 */