package cooperation.ilive.plugin;

import NS_KING_PUBLIC.stAuth;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.manager.IliveAuthManager.Callback;
import cooperation.ilive.util.ElapseStat;

final class LiveAuth$1
  implements IliveAuthManager.Callback
{
  public void onGetAuthInfo(boolean paramBoolean, stAuth paramstAuth)
  {
    if ((paramBoolean) && (paramstAuth != null))
    {
      if (LiveAuth.access$000() == 1)
      {
        QLog.e("IliveAuth", 1, "onGetAuthInfo drawer stop get PluginToken");
        return;
      }
      LiveAuth.liveToken(paramstAuth.sUid, paramstAuth.sSessionKey);
      ElapseStat.b("refreshToken");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.plugin.LiveAuth.1
 * JD-Core Version:    0.7.0.1
 */