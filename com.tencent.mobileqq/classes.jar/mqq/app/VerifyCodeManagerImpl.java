package mqq.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.VerifyCodeInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.VerifyCodeManager;
import mqq.observer.HttpVerifyHandler;
import mqq.observer.ServerNotifyObserver;

public class VerifyCodeManagerImpl
  implements VerifyCodeManager
{
  public static final int MANAGER_HTTPVERIFYCODE_CHANGE = 2;
  public static final int MANAGER_VERIFYCODE_CLOSE = 1;
  public static final int MANAGER_VERIFYCODE_RECEIVE = 0;
  private final AppRuntime app;
  ConcurrentHashMap<String, VerifyCodeManagerImpl.HttpVerifyCodeWrapper> httpVerifyCodeWrapperMap = new ConcurrentHashMap();
  private final Handler mHandler = new VerifyCodeManagerImpl.1(this, Looper.getMainLooper());
  ConcurrentHashMap<Integer, VerifyCodeManagerImpl.VerifyCodeWrapper> verifyCodeWrapperMap = new ConcurrentHashMap();
  
  public VerifyCodeManagerImpl(AppRuntime paramAppRuntime)
  {
    this.app = paramAppRuntime;
  }
  
  public static void addConnectData(ToServiceMsg paramToServiceMsg1, ToServiceMsg paramToServiceMsg2)
  {
    if ((paramToServiceMsg1 == null) || (paramToServiceMsg2 == null)) {
      QLog.d("VerifyCodeManager", 1, "addConnectData null == src || null == to");
    }
    do
    {
      return;
      Object localObject = paramToServiceMsg1.getAttribute("process");
      if (localObject != null) {
        paramToServiceMsg2.addAttribute("process", localObject);
      }
      paramToServiceMsg1 = paramToServiceMsg1.getAttribute("connect_data");
    } while (paramToServiceMsg1 == null);
    paramToServiceMsg2.addAttribute("connect_data", paramToServiceMsg1);
  }
  
  private FromServiceMsg createVerifyCodeCancelResp(ToServiceMsg paramToServiceMsg)
  {
    FromServiceMsg localFromServiceMsg = new FromServiceMsg(paramToServiceMsg.getAppId(), paramToServiceMsg.getAppSeq(), paramToServiceMsg.getUin(), paramToServiceMsg.getServiceCmd());
    localFromServiceMsg.setMsfCommand(paramToServiceMsg.getMsfCommand());
    localFromServiceMsg.setBusinessFail(2006, "");
    return localFromServiceMsg;
  }
  
  private void notifyHttpVerifyCodeActivity(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    Object localObject = (VerifyCodeManagerImpl.HttpVerifyCodeWrapper)this.httpVerifyCodeWrapperMap.get(paramString1);
    if ((localObject != null) && (((VerifyCodeManagerImpl.HttpVerifyCodeWrapper)localObject).serverNotifyObserver != null))
    {
      Message localMessage = this.mHandler.obtainMessage();
      localMessage.obj = new Object[] { ((VerifyCodeManagerImpl.HttpVerifyCodeWrapper)localObject).serverNotifyObserver, paramString1, Integer.valueOf(0), paramString2, paramArrayOfByte };
      localMessage.what = 0;
      localMessage.sendToTarget();
      return;
    }
    localObject = new Intent();
    ((Intent)localObject).setFlags(268435456);
    ((Intent)localObject).setAction("android.intent.action.VIEW");
    ((Intent)localObject).putExtra("key", paramString1);
    ((Intent)localObject).putExtra("note", paramString2);
    ((Intent)localObject).putExtra("image", paramArrayOfByte);
    ((Intent)localObject).setData(Uri.parse("mqqverifycode://puzzle_verify_code/VERIFYCODE?"));
    this.app.getApplication().startActivity((Intent)localObject);
  }
  
  public void cancelVerifyCode(ServerNotifyObserver paramServerNotifyObserver)
  {
    if (paramServerNotifyObserver.getSeq() == 0)
    {
      localObject = (VerifyCodeManagerImpl.HttpVerifyCodeWrapper)this.httpVerifyCodeWrapperMap.remove(paramServerNotifyObserver.getKey());
      if ((localObject != null) && (localObject != null))
      {
        HashMap localHashMap = ((VerifyCodeManagerImpl.HttpVerifyCodeWrapper)localObject).attr;
        ((VerifyCodeManagerImpl.HttpVerifyCodeWrapper)localObject).httpVerifyHandler.cancelVerifyCode(paramServerNotifyObserver.getKey(), localHashMap);
      }
    }
    do
    {
      return;
      paramServerNotifyObserver = (VerifyCodeManagerImpl.VerifyCodeWrapper)this.verifyCodeWrapperMap.remove(Integer.valueOf(paramServerNotifyObserver.getSeq()));
    } while (paramServerNotifyObserver == null);
    Object localObject = createVerifyCodeCancelResp(paramServerNotifyObserver.srcTo);
    notifyApp(paramServerNotifyObserver.srcTo, (FromServiceMsg)localObject);
  }
  
  public boolean checkVerifyCodeResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg.getBusinessFailCode() == 2002)
    {
      if (!this.verifyCodeWrapperMap.containsKey(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq())))
      {
        this.verifyCodeWrapperMap.putIfAbsent(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()), new VerifyCodeManagerImpl.VerifyCodeWrapper(this, paramToServiceMsg.getRequestSsoSeq()));
        ((VerifyCodeManagerImpl.VerifyCodeWrapper)this.verifyCodeWrapperMap.get(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()))).srcTo = paramToServiceMsg;
      }
      paramFromServiceMsg = VerifyCodeInfo.getVerifyCodeInfo(paramFromServiceMsg);
      ((VerifyCodeManagerImpl.VerifyCodeWrapper)this.verifyCodeWrapperMap.get(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()))).verifyCodeInfo = paramFromServiceMsg;
      notifyVerifyCodeActivity(paramToServiceMsg, paramFromServiceMsg.verifyNote, paramFromServiceMsg.verifyimage, paramFromServiceMsg.verifyurl);
      return false;
    }
    if ((paramFromServiceMsg.getBusinessFailCode() == 2003) || (this.verifyCodeWrapperMap.containsKey(Integer.valueOf(paramFromServiceMsg.getRequestSsoSeq()))))
    {
      VerifyCodeManagerImpl.VerifyCodeWrapper localVerifyCodeWrapper = (VerifyCodeManagerImpl.VerifyCodeWrapper)this.verifyCodeWrapperMap.remove(Integer.valueOf(paramFromServiceMsg.getRequestSsoSeq()));
      paramToServiceMsg = "";
      if (!paramFromServiceMsg.isSuccess()) {
        paramToServiceMsg = paramFromServiceMsg.getBusinessFailMsg();
      }
      if (localVerifyCodeWrapper.serverNotifyObserver != null) {
        notifyVerifyCodeActivityClose(localVerifyCodeWrapper.serverNotifyObserver, paramToServiceMsg);
      }
      if (paramFromServiceMsg.getBusinessFailCode() == 2016) {
        return true;
      }
      paramFromServiceMsg.setMsfCommand(localVerifyCodeWrapper.srcTo.getMsfCommand());
      notifyApp(localVerifyCodeWrapper.srcTo, paramFromServiceMsg);
      return false;
    }
    return true;
  }
  
  void notifyApp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    this.app.getService().onRecvVerifyManagerCallback(paramToServiceMsg, paramFromServiceMsg);
  }
  
  void notifyVerifyCodeActivity(ToServiceMsg paramToServiceMsg, String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    int i = paramToServiceMsg.getRequestSsoSeq();
    String str = String.valueOf(paramToServiceMsg.getAttribute("process"));
    paramToServiceMsg = (VerifyCodeManagerImpl.VerifyCodeWrapper)this.verifyCodeWrapperMap.get(Integer.valueOf(i));
    if (paramToServiceMsg.serverNotifyObserver != null)
    {
      localMessage = this.mHandler.obtainMessage();
      localMessage.obj = new Object[] { paramToServiceMsg.serverNotifyObserver, "", Integer.valueOf(i), paramString1, paramArrayOfByte, paramString2 };
      localMessage.what = 0;
      localMessage.sendToTarget();
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setFlags(268435456);
    paramToServiceMsg = "android.intent.action.VIEW";
    Message localMessage = null;
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = "PUZZLEVERIFYCODE";
      localIntent.putExtra("seq", i);
      localIntent.putExtra("url", paramString2);
      localIntent.putExtra("business", 2097152L);
      localIntent.putExtra("hide_operation_bar", true);
      localIntent.putExtra("hide_more_button", true);
      localIntent.putExtra("isSubaccount", true);
      localIntent.putExtra("isShowAd", false);
      paramString2 = paramString1;
      localIntent.setAction(paramToServiceMsg);
      if (!TextUtils.isEmpty(paramString2))
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("mqqverifycode://puzzle_verify_code/");
        paramToServiceMsg.append(paramString2);
        paramToServiceMsg.append("?");
        localIntent.setData(Uri.parse(paramToServiceMsg.toString()));
      }
      this.app.getApplication().startActivity(localIntent);
      return;
    }
    if ("com.tencent.mobileqq:openSdk".equals(str)) {
      paramToServiceMsg = "mqq.opensdk.intent.action.VERIFYCODE";
    }
    for (paramString2 = localMessage;; paramString2 = "VERIFYCODE")
    {
      localIntent.putExtra("seq", i);
      localIntent.putExtra("note", paramString1);
      localIntent.putExtra("image", paramArrayOfByte);
      break;
    }
  }
  
  void notifyVerifyCodeActivityClose(ServerNotifyObserver paramServerNotifyObserver, String paramString)
  {
    Message localMessage = this.mHandler.obtainMessage();
    localMessage.obj = new Object[] { paramServerNotifyObserver, paramString };
    localMessage.what = 1;
    localMessage.sendToTarget();
  }
  
  public void onDestroy() {}
  
  public void onHttpVerifyCodeFail(String paramString1, String paramString2)
  {
    paramString1 = (VerifyCodeManagerImpl.HttpVerifyCodeWrapper)this.httpVerifyCodeWrapperMap.remove(paramString1);
    if (paramString1 != null) {
      notifyVerifyCodeActivityClose(paramString1.serverNotifyObserver, paramString2);
    }
  }
  
  public void onHttpVerifyCodeSucc(String paramString)
  {
    paramString = (VerifyCodeManagerImpl.HttpVerifyCodeWrapper)this.httpVerifyCodeWrapperMap.remove(paramString);
    if (paramString != null) {
      notifyVerifyCodeActivityClose(paramString.serverNotifyObserver, "");
    }
  }
  
  public void onRecvHttpVerifyCode(HttpVerifyHandler paramHttpVerifyHandler, byte[] paramArrayOfByte, String paramString, HashMap paramHashMap)
  {
    String str = (String)paramHashMap.get("key");
    if (!this.httpVerifyCodeWrapperMap.containsKey(str)) {
      this.httpVerifyCodeWrapperMap.putIfAbsent(str, new VerifyCodeManagerImpl.HttpVerifyCodeWrapper(this, str));
    }
    VerifyCodeManagerImpl.HttpVerifyCodeWrapper localHttpVerifyCodeWrapper = (VerifyCodeManagerImpl.HttpVerifyCodeWrapper)this.httpVerifyCodeWrapperMap.get(str);
    if (localHttpVerifyCodeWrapper != null)
    {
      localHttpVerifyCodeWrapper.httpVerifyHandler = paramHttpVerifyHandler;
      localHttpVerifyCodeWrapper.attr = paramHashMap;
      notifyHttpVerifyCodeActivity(str, paramString, paramArrayOfByte);
    }
  }
  
  public void refreVerifyCode(ServerNotifyObserver paramServerNotifyObserver)
  {
    Object localObject;
    if (paramServerNotifyObserver.getSeq() == 0)
    {
      localObject = (VerifyCodeManagerImpl.HttpVerifyCodeWrapper)this.httpVerifyCodeWrapperMap.get(paramServerNotifyObserver.getKey());
      if (localObject != null)
      {
        ((VerifyCodeManagerImpl.HttpVerifyCodeWrapper)localObject).serverNotifyObserver = paramServerNotifyObserver;
        HashMap localHashMap = ((VerifyCodeManagerImpl.HttpVerifyCodeWrapper)localObject).attr;
        ((VerifyCodeManagerImpl.HttpVerifyCodeWrapper)localObject).httpVerifyHandler.refreVerifyCode(paramServerNotifyObserver.getKey(), localHashMap);
      }
    }
    do
    {
      return;
      int i = paramServerNotifyObserver.getSeq();
      localObject = (VerifyCodeManagerImpl.VerifyCodeWrapper)this.verifyCodeWrapperMap.get(Integer.valueOf(i));
      if (localObject != null)
      {
        ((VerifyCodeManagerImpl.VerifyCodeWrapper)localObject).serverNotifyObserver = paramServerNotifyObserver;
        paramServerNotifyObserver = this.app.getService().msfSub.getRefreVerifyCodeMsg(((VerifyCodeManagerImpl.VerifyCodeWrapper)localObject).verifyCodeInfo);
        paramServerNotifyObserver.setAppSeq(((VerifyCodeManagerImpl.VerifyCodeWrapper)localObject).verifyCodeInfo.appSeq);
        addConnectData(((VerifyCodeManagerImpl.VerifyCodeWrapper)localObject).srcTo, paramServerNotifyObserver);
        this.app.getService().msfSub.sendMsg(paramServerNotifyObserver);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("VerifyCodeManager", 2, "wrapper is null");
  }
  
  public void submitPuzzleVerifyCodeTicket(int paramInt, String paramString)
  {
    Object localObject = (VerifyCodeManagerImpl.VerifyCodeWrapper)this.verifyCodeWrapperMap.get(Integer.valueOf(paramInt));
    if (localObject != null)
    {
      ToServiceMsg localToServiceMsg = ((VerifyCodeManagerImpl.VerifyCodeWrapper)localObject).srcTo;
      paramString = this.app.getService().msfSub.getSubmitPuzzleVerifyCodeTicketMsg(paramString, ((VerifyCodeManagerImpl.VerifyCodeWrapper)localObject).verifyCodeInfo);
      paramString.setAppSeq(((VerifyCodeManagerImpl.VerifyCodeWrapper)localObject).verifyCodeInfo.appSeq);
      if (localToServiceMsg.getAttribute("from_where") != null)
      {
        localObject = (String)localToServiceMsg.getAttribute("from_where");
        String str = (String)localToServiceMsg.getAttribute("mainaccount");
        paramString.addAttribute("from_where", localObject);
        paramString.addAttribute("mainaccount", str);
      }
      addConnectData(localToServiceMsg, paramString);
      this.app.getService().msfSub.sendMsg(paramString);
    }
  }
  
  public void submitVerifyCode(ServerNotifyObserver paramServerNotifyObserver, String paramString)
  {
    Object localObject1;
    Object localObject2;
    if (paramServerNotifyObserver.getSeq() == 0)
    {
      localObject1 = (VerifyCodeManagerImpl.HttpVerifyCodeWrapper)this.httpVerifyCodeWrapperMap.get(paramServerNotifyObserver.getKey());
      if (localObject1 != null)
      {
        localObject2 = ((VerifyCodeManagerImpl.HttpVerifyCodeWrapper)localObject1).attr;
        ((VerifyCodeManagerImpl.HttpVerifyCodeWrapper)localObject1).serverNotifyObserver = paramServerNotifyObserver;
        ((VerifyCodeManagerImpl.HttpVerifyCodeWrapper)localObject1).httpVerifyHandler.submitVerifyCode(paramServerNotifyObserver.getKey(), (HashMap)localObject2, paramString);
      }
    }
    do
    {
      return;
      localObject1 = (VerifyCodeManagerImpl.VerifyCodeWrapper)this.verifyCodeWrapperMap.get(Integer.valueOf(paramServerNotifyObserver.getSeq()));
    } while (localObject1 == null);
    ((VerifyCodeManagerImpl.VerifyCodeWrapper)localObject1).serverNotifyObserver = paramServerNotifyObserver;
    paramServerNotifyObserver = ((VerifyCodeManagerImpl.VerifyCodeWrapper)localObject1).srcTo;
    paramString = this.app.getService().msfSub.getSubmitVerifyCodeMsg(paramString, ((VerifyCodeManagerImpl.VerifyCodeWrapper)localObject1).verifyCodeInfo);
    paramString.setAppSeq(((VerifyCodeManagerImpl.VerifyCodeWrapper)localObject1).verifyCodeInfo.appSeq);
    if (paramServerNotifyObserver.getAttribute("from_where") != null)
    {
      localObject1 = (String)paramServerNotifyObserver.getAttribute("from_where");
      localObject2 = (String)paramServerNotifyObserver.getAttribute("mainaccount");
      paramString.addAttribute("from_where", localObject1);
      paramString.addAttribute("mainaccount", localObject2);
    }
    addConnectData(paramServerNotifyObserver, paramString);
    this.app.getService().msfSub.sendMsg(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.app.VerifyCodeManagerImpl
 * JD-Core Version:    0.7.0.1
 */