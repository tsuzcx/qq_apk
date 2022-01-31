package cooperation.qqreader;

import android.os.Handler.Callback;
import android.text.TextUtils;
import biyu;
import biyv;
import bjbl;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import mqq.manager.WtloginManager;
import oicq.wlogin_sdk.request.WtloginHelper;

public final class QRBridgeUtil
{
  private static final int MESSAGE_TICKET_FAILED = 1001;
  private static final int MESSAGE_TICKET_OK = 1000;
  private static final String TAG = "QRBridgeUtil";
  private static AppInterface sAppInterface;
  private static Map<String, String> sPSkeyMap = new HashMap();
  
  public static void clearReaderBookCache()
  {
    ThreadManagerV2.executeOnFileThread(new QRBridgeUtil.1());
  }
  
  public static AppInterface getAppInterface()
  {
    if (sAppInterface == null) {
      sAppInterface = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    }
    return sAppInterface;
  }
  
  public static String getPSkey(String paramString1, String paramString2)
  {
    String str = (String)sPSkeyMap.get(paramString2);
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    preloadPSkey(localAppRuntime, paramString1, paramString2);
    if (localAppRuntime != null)
    {
      str = ((TicketManager)localAppRuntime.getManager(2)).getPskey(paramString1, paramString2);
      paramString1 = str;
      if (!TextUtils.isEmpty(str)) {
        sPSkeyMap.put(paramString2, str);
      }
    }
    for (paramString1 = str;; paramString1 = str)
    {
      str = paramString1;
      if (paramString1 != null) {
        break;
      }
      return "";
      bjbl.a("QRBridgeUtil", "mApp null return null skey");
    }
  }
  
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
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null) {
      return ((TicketManager)localAppRuntime.getManager(2)).getSkey(paramString);
    }
    bjbl.a("QRBridgeUtil", "mApp null return null skey");
    return "";
  }
  
  public static String getSid(String paramString)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null)
    {
      paramString = ((WtloginManager)localAppRuntime.getManager(1)).GetLocalSig(paramString, 16L);
      if (paramString != null) {
        return new String(WtloginHelper.GetTicketSig(paramString, 524288));
      }
      bjbl.a("QRBridgeUtil", "get sig info null");
    }
    return "";
  }
  
  public static String preloadPSkey(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    if (paramAppRuntime == null)
    {
      bjbl.a("QRBridgeUtil", "Unable to get pskey due to null app runtime");
      return "";
    }
    bjbl.c("QRBridgeUtil", "Try to preload pSkey");
    paramAppRuntime = (TicketManager)paramAppRuntime.getManager(2);
    biyv localbiyv = new biyv(paramString2);
    paramAppRuntime.GetPskey(paramString1, 16L, new String[] { paramString2 }, localbiyv);
    return "";
  }
  
  public static boolean recreateTicket(String paramString, Handler.Callback paramCallback)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject == null) {
      return false;
    }
    localObject = (WtloginManager)((AppRuntime)localObject).getManager(1);
    if (!((WtloginManager)localObject).IsNeedLoginWithPasswd(paramString, 16)) {
      ((WtloginManager)localObject).GetStWithoutPasswd(paramString, 16L, 16L, new biyu(paramCallback));
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqreader.QRBridgeUtil
 * JD-Core Version:    0.7.0.1
 */