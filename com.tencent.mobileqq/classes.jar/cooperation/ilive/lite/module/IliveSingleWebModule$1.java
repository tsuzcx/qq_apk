package cooperation.ilive.lite.module;

import android.os.Bundle;
import com.tencent.mobileqq.litelivesdk.api.business.BusinessConfig;
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.lite.event.IliveLiteEventCenter.Observer;

class IliveSingleWebModule$1
  implements IliveLiteEventCenter.Observer
{
  IliveSingleWebModule$1(IliveSingleWebModule paramIliveSingleWebModule) {}
  
  public boolean onCall(String paramString, Bundle paramBundle)
  {
    if ((this.a.b()) && (paramBundle != null))
    {
      if (BusinessManager.a.b().k) {
        return false;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("IliveLiteEventCenter onCall , action = ");
      localStringBuilder.append(paramString);
      QLog.e("IliveSingleWebModule", 1, localStringBuilder.toString());
      if (paramString.equals("ACTION_WEBVIEW_SET_SWITCH"))
      {
        IliveSingleWebModule.c(paramBundle.getString("callback_id"));
        IliveSingleWebModule.b(false);
        IliveSingleWebModule.a(this.a);
        return true;
      }
      if (paramString.equals("ACTION_WEBVIEW_VISIBILITY"))
      {
        IliveSingleWebModule.a(this.a, paramBundle);
        return true;
      }
      if (paramString.equals("ACTION_WEBVIEW_RELOAD"))
      {
        IliveSingleWebModule.b(this.a, paramBundle);
        return true;
      }
      if (paramString.equals("ACTION_WEBVIEW_GET_CURRENT_ROOM_ID"))
      {
        IliveSingleWebModule.c(this.a, paramBundle);
        return true;
      }
      if (paramString.equals("ACTION_WEBVIEW_NEED_SHOW_GIFT_ICON")) {
        IliveSingleWebModule.d(this.a, paramBundle);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.lite.module.IliveSingleWebModule.1
 * JD-Core Version:    0.7.0.1
 */