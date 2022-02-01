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
    RedpointHandler localRedpointHandler = this.mRedPointHandler;
    if (localRedpointHandler != null) {
      localRedpointHandler.a(paramInt);
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
    RedpointHandler localRedpointHandler = this.mRedPointHandler;
    if (localRedpointHandler != null) {
      localRedpointHandler.a(paramAppRuntime);
    }
  }
  
  public void notifyUI(int paramInt, boolean paramBoolean, Object paramObject)
  {
    RedpointHandler localRedpointHandler = this.mRedPointHandler;
    if (localRedpointHandler != null) {
      localRedpointHandler.notifyUI(paramInt, paramBoolean, paramObject);
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
    RedpointHandler localRedpointHandler = this.mRedPointHandler;
    if (localRedpointHandler != null) {
      localRedpointHandler.onDestroy();
    }
  }
  
  public void sendRedpointReq(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    RedpointHandler localRedpointHandler = this.mRedPointHandler;
    if (localRedpointHandler != null) {
      localRedpointHandler.a(paramBoolean1, paramBoolean2, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.api.impl.RedTouchServerImpl
 * JD-Core Version:    0.7.0.1
 */