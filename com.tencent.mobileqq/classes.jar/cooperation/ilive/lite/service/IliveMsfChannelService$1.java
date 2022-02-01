package cooperation.ilive.lite.service;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.falco.base.libapi.login.LoginInfo;
import com.tencent.qphone.base.util.QLog;

class IliveMsfChannelService$1
  implements Runnable
{
  IliveMsfChannelService$1(IliveMsfChannelService paramIliveMsfChannelService, LoginInfo paramLoginInfo) {}
  
  public void run()
  {
    String str = IliveMsfChannelService.a(this.this$0, this.a);
    if (!TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("saveLoginInfo json = ");
        localStringBuilder.append(str);
        QLog.i("IliveMsfChannelService", 2, localStringBuilder.toString());
      }
      IliveMsfChannelService.a(this.this$0).edit().putString(IliveMsfChannelService.b(this.this$0), str).apply();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.lite.service.IliveMsfChannelService.1
 * JD-Core Version:    0.7.0.1
 */