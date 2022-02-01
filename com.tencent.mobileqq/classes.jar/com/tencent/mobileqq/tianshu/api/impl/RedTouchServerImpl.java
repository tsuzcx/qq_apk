package com.tencent.mobileqq.tianshu.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.RedpointHandler;
import com.tencent.mobileqq.tianshu.api.IRedTouchServer;
import com.tencent.mobileqq.tianshu.data.RedPointHolder;
import java.util.List;
import mqq.app.AppRuntime;

public class RedTouchServerImpl
  implements IRedTouchServer
{
  private RedpointHandler mRedPointHandler;
  
  public void forceSendReq(int paramInt)
  {
    if (this.mRedPointHandler != null) {
      this.mRedPointHandler.a(paramInt);
    }
  }
  
  public String getClassName()
  {
    return RedpointHandler.class.getName();
  }
  
  public List<RedPointHolder> getLebaPlugRedPointIds(AppRuntime paramAppRuntime)
  {
    return RedpointHandler.a(paramAppRuntime);
  }
  
  public void notifyRedTouchUpdate(AppRuntime paramAppRuntime)
  {
    if (this.mRedPointHandler != null) {
      this.mRedPointHandler.a(paramAppRuntime);
    }
  }
  
  public void notifyUI(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (this.mRedPointHandler != null) {
      this.mRedPointHandler.notifyUI(paramInt, paramBoolean, paramObject);
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof AppInterface)) {
      this.mRedPointHandler = ((RedpointHandler)((AppInterface)paramAppRuntime).getBusinessHandler(BusinessHandlerFactory.REDPOINT_HANDER));
    }
  }
  
  public void onDestroy()
  {
    if (this.mRedPointHandler != null) {
      this.mRedPointHandler.onDestroy();
    }
  }
  
  public void sendRedpointReq(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (this.mRedPointHandler != null) {
      this.mRedPointHandler.a(paramBoolean1, paramBoolean2, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.api.impl.RedTouchServerImpl
 * JD-Core Version:    0.7.0.1
 */