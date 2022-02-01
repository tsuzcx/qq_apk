package com.tencent.mobileqq.guild.ipc.methods;

import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchGuildInfoCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qphone.base.util.QLog;

class OpenGuildAIOIpcMethod$1
  implements IFetchGuildInfoCallback
{
  OpenGuildAIOIpcMethod$1(OpenGuildAIOIpcMethod paramOpenGuildAIOIpcMethod, String paramString) {}
  
  public void a(int paramInt, String paramString, IGProGuildInfo paramIGProGuildInfo)
  {
    if (paramInt == 0)
    {
      OpenGuildAIOIpcMethod.a(this.b, paramIGProGuildInfo);
      paramString = this.b;
      OpenGuildAIOIpcMethod.a(paramString, OpenGuildAIOIpcMethod.a(paramString).getChannelList(this.a));
      if (OpenGuildAIOIpcMethod.b(this.b))
      {
        OpenGuildAIOIpcMethod.c(this.b).a(null);
        return;
      }
      QLog.e("OpenGuildAIOIpcMethod", 1, "openAIO error, onFetchGuild Success but cann't openAIO");
      OpenGuildAIOIpcMethod.c(this.b).a(-203, this.b.a("无效频道"));
      return;
    }
    QLog.e("OpenGuildAIOIpcMethod", 1, new Object[] { "onFetchGuildInfo error, result=", Integer.valueOf(paramInt), ", errMsg=", paramString });
    OpenGuildAIOIpcMethod.c(this.b).a(paramInt, this.b.a(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.ipc.methods.OpenGuildAIOIpcMethod.1
 * JD-Core Version:    0.7.0.1
 */