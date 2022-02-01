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

public class ImmersiveConfProcessor
  extends IQConfigProcessor<ImmersiveConfProcessor.ImmersiveConfBean>
{
  private static boolean a;
  private static boolean b;
  
  public static boolean a()
  {
    ImmersiveConfProcessor.ImmersiveConfBean localImmersiveConfBean = (ImmersiveConfProcessor.ImmersiveConfBean)QConfigManager.a().a(579);
    if ((localImmersiveConfBean != null) && (!TextUtils.isEmpty(localImmersiveConfBean.a))) {
      a = "1".equals(localImmersiveConfBean.a);
    }
    return a;
  }
  
  public static boolean b()
  {
    ImmersiveConfProcessor.ImmersiveConfBean localImmersiveConfBean = (ImmersiveConfProcessor.ImmersiveConfBean)QConfigManager.a().a(579);
    if ((localImmersiveConfBean != null) && (!TextUtils.isEmpty(localImmersiveConfBean.b))) {
      b = "1".equals(localImmersiveConfBean.b);
    }
    return b;
  }
  
  @NonNull
  public ImmersiveConfProcessor.ImmersiveConfBean a(int paramInt)
  {
    return new ImmersiveConfProcessor.ImmersiveConfBean();
  }
  
  public ImmersiveConfProcessor.ImmersiveConfBean a(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("IsImageImmersiveEnable");
      localObject = ((JSONObject)localObject).optString("IsVideoImmersiveEnable");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ImmersiveConfBean, isImgEnable:");
        localStringBuilder.append(paramString);
        localStringBuilder.append(", isVdoEnable:");
        localStringBuilder.append((String)localObject);
        QLog.e("ImmersiveConfProcessor", 2, localStringBuilder.toString());
      }
      paramString = new ImmersiveConfProcessor.ImmersiveConfBean(paramString.trim(), ((String)localObject).trim());
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  @Nullable
  public ImmersiveConfProcessor.ImmersiveConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      ImmersiveConfProcessor.ImmersiveConfBean localImmersiveConfBean = a(paramArrayOfQConfItem[0].a);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed ");
        localStringBuilder.append(paramArrayOfQConfItem[0].a);
        QLog.d("ImmersiveConfProcessor", 2, localStringBuilder.toString());
      }
      return localImmersiveConfBean;
    }
    return new ImmersiveConfProcessor.ImmersiveConfBean();
  }
  
  public void a(ImmersiveConfProcessor.ImmersiveConfBean paramImmersiveConfBean)
  {
    if (paramImmersiveConfBean != null)
    {
      if (TextUtils.isEmpty(paramImmersiveConfBean.a)) {
        a = "1".equals(paramImmersiveConfBean.a);
      }
      if (TextUtils.isEmpty(paramImmersiveConfBean.b)) {
        b = "1".equals(paramImmersiveConfBean.b);
      }
    }
  }
  
  public Class<ImmersiveConfProcessor.ImmersiveConfBean> clazz()
  {
    return ImmersiveConfProcessor.ImmersiveConfBean.class;
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
    return 579;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.comment.config.ImmersiveConfProcessor
 * JD-Core Version:    0.7.0.1
 */