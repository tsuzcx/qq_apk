package mqq.manager;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;
import mqq.observer.HttpVerifyHandler;
import mqq.observer.ServerNotifyObserver;

public abstract interface VerifyCodeManager
  extends Manager
{
  public static final String EXTRA_IMAGE = "image";
  public static final String EXTRA_KEY = "key";
  public static final String EXTRA_NOTE = "note";
  public static final String EXTRA_SEQ = "seq";
  
  public abstract void cancelVerifyCode(ServerNotifyObserver paramServerNotifyObserver);
  
  public abstract boolean checkVerifyCodeResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg);
  
  public abstract void onHttpVerifyCodeFail(String paramString1, String paramString2);
  
  public abstract void onHttpVerifyCodeSucc(String paramString);
  
  public abstract void onRecvHttpVerifyCode(HttpVerifyHandler paramHttpVerifyHandler, byte[] paramArrayOfByte, String paramString, HashMap paramHashMap);
  
  public abstract void refreVerifyCode(ServerNotifyObserver paramServerNotifyObserver);
  
  public abstract void submitPuzzleVerifyCodeTicket(int paramInt, String paramString);
  
  public abstract void submitVerifyCode(ServerNotifyObserver paramServerNotifyObserver, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.manager.VerifyCodeManager
 * JD-Core Version:    0.7.0.1
 */