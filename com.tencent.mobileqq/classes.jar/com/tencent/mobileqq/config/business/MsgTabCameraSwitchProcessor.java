package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class MsgTabCameraSwitchProcessor
  extends IQConfigProcessor<MsgTabCameraConfBean>
{
  public static MsgTabCameraConfBean a()
  {
    return (MsgTabCameraConfBean)QConfigManager.a().a(489);
  }
  
  @NonNull
  public MsgTabCameraConfBean a(int paramInt)
  {
    return new MsgTabCameraConfBean();
  }
  
  @Nullable
  public MsgTabCameraConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgTabCameraSwitchProcessor", 2, "onParsed ");
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return MsgTabCameraConfBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(MsgTabCameraConfBean paramMsgTabCameraConfBean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate ");
      localStringBuilder.append(paramMsgTabCameraConfBean.toString());
      QLog.d("MsgTabCameraSwitchProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public Class<MsgTabCameraConfBean> clazz()
  {
    return MsgTabCameraConfBean.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
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
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReqFailed ");
      localStringBuilder.append(paramInt);
      QLog.d("MsgTabCameraSwitchProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public void onReqNoReceive()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgTabCameraSwitchProcessor", 2, "onReqNoReceive ");
    }
  }
  
  public int type()
  {
    return 489;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.MsgTabCameraSwitchProcessor
 * JD-Core Version:    0.7.0.1
 */