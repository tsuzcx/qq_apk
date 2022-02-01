package com.tencent.mobileqq.emoticonview.ipc.proxy;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CameraEmoRoamingHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;

public class CameraEmoRoamingHandlerProxy
  extends AbsHandlerProxy<CameraEmoRoamingHandler>
{
  private static final String TAG = "CameraEmoRoamingHandlerProxy";
  
  public CameraEmoRoamingHandlerProxy(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface, BusinessHandlerFactory.CAMERA_EMOTICON_HANDLER);
  }
  
  public final void notifyUI(int paramInt, boolean paramBoolean, Serializable paramSerializable)
  {
    if (this.businessHandler != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CameraEmoRoamingHandlerProxy", 4, "notifyUI suc：" + paramBoolean);
      }
      ((CameraEmoRoamingHandler)this.businessHandler).notifyUI(paramInt, paramBoolean, paramSerializable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ipc.proxy.CameraEmoRoamingHandlerProxy
 * JD-Core Version:    0.7.0.1
 */