package cooperation.qqreader;

import amat;
import android.os.Handler.Callback;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import mqq.manager.WtloginManager;
import oicq.wlogin_sdk.request.WtloginHelper;

public class QRBridgeUtil
{
  public static final int MESSAGE_TICKET_FAILED = 1001;
  public static final int MESSAGE_TICKET_OK = 1000;
  public static AppRuntime mApp;
  
  public static String getSKey(QQAppInterface paramQQAppInterface)
  {
    String str2 = "";
    String str1 = str2;
    if (paramQQAppInterface != null)
    {
      String str3 = paramQQAppInterface.getCurrentAccountUin();
      str1 = str2;
      if (!TextUtils.isEmpty(str3))
      {
        paramQQAppInterface = (TicketManager)paramQQAppInterface.getManager(2);
        if (paramQQAppInterface == null) {
          break label46;
        }
        str1 = paramQQAppInterface.getSkey(str3);
      }
    }
    return str1;
    label46:
    return "";
  }
  
  public static String getSKey(String paramString)
  {
    if (mApp != null)
    {
      paramString = ((WtloginManager)mApp.getManager(1)).GetLocalSig(paramString, 16L);
      if (paramString != null) {
        return new String(WtloginHelper.GetTicketSig(paramString, 4096));
      }
    }
    return "";
  }
  
  public static String getSid(String paramString)
  {
    if (mApp != null)
    {
      paramString = ((WtloginManager)mApp.getManager(1)).GetLocalSig(paramString, 16L);
      if (paramString != null) {
        return new String(WtloginHelper.GetTicketSig(paramString, 524288));
      }
    }
    return "";
  }
  
  public static void initRuntime(AppRuntime paramAppRuntime)
  {
    mApp = paramAppRuntime;
  }
  
  public static boolean recreateTicket(String paramString, Handler.Callback paramCallback)
  {
    WtloginManager localWtloginManager = (WtloginManager)mApp.getManager(1);
    if (!localWtloginManager.IsNeedLoginWithPasswd(paramString, 16))
    {
      localWtloginManager.GetStWithoutPasswd(paramString, 16L, 16L, new amat(paramCallback));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qqreader.QRBridgeUtil
 * JD-Core Version:    0.7.0.1
 */