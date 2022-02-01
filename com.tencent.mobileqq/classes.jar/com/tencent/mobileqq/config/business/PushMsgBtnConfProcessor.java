package com.tencent.mobileqq.config.business;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class PushMsgBtnConfProcessor
  extends IQConfigProcessor<PushMsgBtnBean>
{
  public static int a(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("poke_msg_btn_is_show");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("poke_msg_btn_is_show");
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.apply();
  }
  
  @NonNull
  public PushMsgBtnBean a(int paramInt)
  {
    return new PushMsgBtnBean(0);
  }
  
  @Nullable
  public PushMsgBtnBean a(QConfItem[] paramArrayOfQConfItem)
  {
    int j = 0;
    int i = j;
    if (paramArrayOfQConfItem != null)
    {
      i = j;
      if (paramArrayOfQConfItem.length > 0)
      {
        paramArrayOfQConfItem = paramArrayOfQConfItem[0].a;
        try
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("handlePushMsgBtnConfig. strContent = ");
            localStringBuilder.append(paramArrayOfQConfItem);
            QLog.d("handlePushMsgBtnConfig", 2, localStringBuilder.toString());
          }
          i = new JSONObject(paramArrayOfQConfItem).getInt("isPushSwitchShow");
        }
        catch (Exception paramArrayOfQConfItem)
        {
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.e("handlePushMsgBtnConfig", 2, "PushMsgBtnConfig parse error", paramArrayOfQConfItem);
            i = j;
          }
        }
      }
    }
    return new PushMsgBtnBean(i);
  }
  
  public void a(PushMsgBtnBean paramPushMsgBtnBean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handlePushMsgBtnConfig. onUpdate = ");
      ((StringBuilder)localObject).append(paramPushMsgBtnBean.a);
      QLog.d("handlePushMsgBtnConfig", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    a(((QQAppInterface)localObject).getApp(), ((QQAppInterface)localObject).getAccount(), paramPushMsgBtnBean.a);
  }
  
  public Class clazz()
  {
    return PushMsgBtnBean.class;
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
    return 439;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.PushMsgBtnConfProcessor
 * JD-Core Version:    0.7.0.1
 */