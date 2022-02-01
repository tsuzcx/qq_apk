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
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt(paramString + "_" + "poke_msg_btn_is_show", 0);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt(paramString + "_" + "poke_msg_btn_is_show", paramInt);
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
    j = 0;
    i = j;
    if (paramArrayOfQConfItem != null)
    {
      i = j;
      if (paramArrayOfQConfItem.length > 0) {
        paramArrayOfQConfItem = paramArrayOfQConfItem[0].a;
      }
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("handlePushMsgBtnConfig", 2, "handlePushMsgBtnConfig. strContent = " + paramArrayOfQConfItem);
      }
      i = new JSONObject(paramArrayOfQConfItem).getInt("isPushSwitchShow");
    }
    catch (Exception paramArrayOfQConfItem)
    {
      for (;;)
      {
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.e("handlePushMsgBtnConfig", 2, "PushMsgBtnConfig parse error", paramArrayOfQConfItem);
          i = j;
        }
      }
    }
    return new PushMsgBtnBean(i);
  }
  
  public void a(PushMsgBtnBean paramPushMsgBtnBean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("handlePushMsgBtnConfig", 2, "handlePushMsgBtnConfig. onUpdate = " + paramPushMsgBtnBean.a);
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    a(localQQAppInterface.getApp(), localQQAppInterface.getAccount(), paramPushMsgBtnBean.a);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.PushMsgBtnConfProcessor
 * JD-Core Version:    0.7.0.1
 */