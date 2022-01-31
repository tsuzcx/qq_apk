package mqq.app;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class AppRuntime$KickParams
{
  public Object fromServiceMsg;
  boolean isSameDevice;
  boolean isTokenExpired;
  public Object toServiceMsg;
  
  public AppRuntime$KickParams(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.toServiceMsg = paramToServiceMsg;
    this.fromServiceMsg = paramFromServiceMsg;
    this.isTokenExpired = paramBoolean1;
    this.isSameDevice = paramBoolean2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.app.AppRuntime.KickParams
 * JD-Core Version:    0.7.0.1
 */