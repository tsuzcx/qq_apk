package cooperation.ilive.plugin;

import NS_KING_PUBLIC.stAuth;
import blel;
import blet;
import com.tencent.qphone.base.util.QLog;

final class LiveAuth$1
  implements blel
{
  public void onGetAuthInfo(boolean paramBoolean, stAuth paramstAuth)
  {
    if ((paramBoolean) && (paramstAuth != null))
    {
      if (LiveAuth.access$000() == 1) {
        QLog.e("IliveAuth", 1, "onGetAuthInfo drawer stop get PluginToken");
      }
    }
    else {
      return;
    }
    LiveAuth.liveToken(paramstAuth.sUid, paramstAuth.sSessionKey);
    blet.b("refreshToken");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.ilive.plugin.LiveAuth.1
 * JD-Core Version:    0.7.0.1
 */