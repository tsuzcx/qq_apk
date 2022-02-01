package cooperation.ilive;

import NS_KING_PUBLIC.stAuth;
import android.content.Context;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.EnterCallback;
import com.tencent.shadow.dynamic.host.PluginManager;
import cooperation.ilive.manager.IliveAuthManager.Callback;
import cooperation.ilive.plugin.IlivePluginCallback;
import cooperation.ilive.plugin.IlivePluginManager;
import cooperation.ilive.util.ElapseStat;

class IliveShadowImpl$AuthCallback
  implements IliveAuthManager.Callback
{
  long a;
  Context b;
  Bundle c;
  EnterCallback d;
  private PluginManager f;
  private boolean g = false;
  
  public IliveShadowImpl$AuthCallback(IliveShadowImpl paramIliveShadowImpl, PluginManager paramPluginManager, long paramLong, Context paramContext, Bundle paramBundle, EnterCallback paramEnterCallback)
  {
    this.f = paramPluginManager;
    this.a = paramLong;
    this.b = paramContext;
    this.c = paramBundle;
    this.d = paramEnterCallback;
  }
  
  public void onGetAuthInfo(boolean paramBoolean, stAuth paramstAuth)
  {
    ElapseStat.b("stAuth");
    if (paramBoolean)
    {
      if (!this.g)
      {
        this.g = true;
        IliveShadowImpl.a(this.e, this.b, this.a, this.f, this.c, paramstAuth, this.d);
      }
    }
    else
    {
      if (IlivePluginManager.getInstance().getPluginCallback() != null) {
        IlivePluginManager.getInstance().getPluginCallback().onPluginLoginFail(-1, "auth login fail");
      }
      QLog.e("IliveAuthShadowImpl", 1, "[enter] pluginManager auth fail!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.IliveShadowImpl.AuthCallback
 * JD-Core Version:    0.7.0.1
 */