package com.tencent.mobileqq.tianshu.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.tianshu.data.RedPointHolder;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;

@Service(needUin=false, process={""})
public abstract interface IRedTouchServer
  extends IRuntimeHandler, IRuntimeService
{
  public abstract void forceSendReq(int paramInt);
  
  public abstract List<RedPointHolder> getLebaPlugRedPointIds(AppRuntime paramAppRuntime);
  
  public abstract void notifyRedTouchUpdate(AppRuntime paramAppRuntime);
  
  public abstract void sendRedpointReq(boolean paramBoolean1, boolean paramBoolean2, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.api.IRedTouchServer
 * JD-Core Version:    0.7.0.1
 */