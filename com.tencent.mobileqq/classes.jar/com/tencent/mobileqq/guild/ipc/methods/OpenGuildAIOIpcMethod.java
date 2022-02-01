package com.tencent.mobileqq.guild.ipc.methods;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.guild.api.IGuildOpenApi;
import com.tencent.mobileqq.guild.api.LaunchGuildChatPieParam;
import com.tencent.mobileqq.guild.data.QQGuildOpenData;
import com.tencent.mobileqq.guild.util.QQGuildTabStateUtils;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.Arrays;
import java.util.List;

@AbsIpcMethod.IpcMethod(a=false)
public class OpenGuildAIOIpcMethod
  extends AbsIpcMethod
{
  private Bundle a;
  private IGProGuildInfo b;
  private List<IGProChannelInfo> c;
  private IGPSService d;
  private AbsIpcMethod.IpcContext e;
  
  private boolean a()
  {
    if (!a(this.b, this.c)) {
      return false;
    }
    Object localObject = QQGuildUtil.a(this.c);
    localObject = new LaunchGuildChatPieParam().a(this.b.getGuildID()).b(((IGProChannelInfo)localObject).getChannelUin()).a(this.a).b(false).c(false).b();
    new Handler(Looper.getMainLooper()).post(new -..Lambda.OpenGuildAIOIpcMethod.9Zg6DnNvPlGqV-DxaVC7QCqOaLI((LaunchGuildChatPieParam)localObject));
    return true;
  }
  
  private boolean a(IGProGuildInfo paramIGProGuildInfo, List<IGProChannelInfo> paramList)
  {
    return (paramIGProGuildInfo != null) && (paramList != null) && (!paramList.isEmpty());
  }
  
  private void b(String paramString)
  {
    this.d.fetchGuildInfo(paramString, new OpenGuildAIOIpcMethod.1(this, paramString));
  }
  
  private Bundle c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      QQGuildOpenData localQQGuildOpenData = ((IGuildOpenApi)QQGuildUtil.a(IGuildOpenApi.class, "")).getGuildOpenDataFromApp(paramString);
      if (localQQGuildOpenData != null)
      {
        paramString = new Bundle();
        paramString.putString("guild_from", "guildOpenCreate");
        paramString.putString("guild_from_app_name", localQQGuildOpenData.appName);
        return paramString;
      }
      QLog.e("OpenGuildAIOIpcMethod", 1, new Object[] { "launchGuildChatPie packageId:", paramString, ", but dataFromApp is null" });
    }
    return null;
  }
  
  public EIPCResult a(AbsIpcMethod.IpcContext paramIpcContext, String paramString, Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OpenGuildAIOIpcMethod", 2, new Object[] { "doInvoke: ", Arrays.toString(paramVarArgs), " hash: ", Integer.valueOf(System.identityHashCode(this)) });
    }
    if (!QQGuildTabStateUtils.a())
    {
      paramIpcContext.a(-204, a("TAB未显示"));
      return null;
    }
    paramString = (String)paramVarArgs[0];
    paramVarArgs = (String)paramVarArgs[1];
    if (TextUtils.isEmpty(paramString))
    {
      paramIpcContext.a(-203, a("无效频道"));
      return null;
    }
    this.e = paramIpcContext;
    this.a = c(paramVarArgs);
    this.d = ((IGPSService)QQGuildUtil.b(IGPSService.class));
    this.b = this.d.getGuildInfo(paramString);
    this.c = this.d.getChannelList(paramString);
    if (a())
    {
      paramIpcContext.a(null);
      return null;
    }
    b(paramString);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.ipc.methods.OpenGuildAIOIpcMethod
 * JD-Core Version:    0.7.0.1
 */