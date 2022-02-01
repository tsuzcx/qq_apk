package com.tencent.mobileqq.emoticonview.ipc.proxy;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.CameraEmoRoamingHandler;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;

public class CameraEmoRoamingHandlerProxy
  extends AbsHandlerProxy<CameraEmoRoamingHandler>
{
  private static final String TAG = "CameraEmoRoamingHandlerProxy";
  
  public CameraEmoRoamingHandlerProxy(BaseQQAppInterface paramBaseQQAppInterface)
  {
    super(paramBaseQQAppInterface, CameraEmoRoamingHandler.a);
  }
  
  public final void notifyUI(int paramInt, boolean paramBoolean, Serializable paramSerializable)
  {
    if (this.businessHandler != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("notifyUI suc：");
        localStringBuilder.append(paramBoolean);
        QLog.d("CameraEmoRoamingHandlerProxy", 4, localStringBuilder.toString());
      }
      ((CameraEmoRoamingHandler)this.businessHandler).notifyUI(paramInt, paramBoolean, paramSerializable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ipc.proxy.CameraEmoRoamingHandlerProxy
 * JD-Core Version:    0.7.0.1
 */