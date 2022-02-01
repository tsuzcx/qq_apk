package mqq.app.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.api.SSORequest;
import mqq.app.api.SSOResponse;
import mqq.app.api.SSOResultCallback;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;

public class SSOChannel
  implements BusinessObserver
{
  private static final String KEY_REQUEST_SEQ = "FLUTTER_REQUEST_SEQ";
  private static final String KEY_REQUEST_TIME = "REQUEST_TIME";
  public static final AtomicInteger REQ_FACTORY = new AtomicInteger();
  private static final String TAG = ".SSOChannel";
  private Map<Integer, SSOResultCallback> mResultMethodCache = new HashMap();
  
  private void notifyFlutterResult(String paramString, SSOResponse paramSSOResponse, SSOResultCallback paramSSOResultCallback)
  {
    ThreadManager.getUIHandler().post(new SSOChannel.1(this, paramSSOResponse, paramString, paramSSOResultCallback));
  }
  
  public void doSendRequest(SSORequest paramSSORequest, SSOResultCallback paramSSOResultCallback)
  {
    if ((paramSSORequest == null) || (paramSSOResultCallback == null)) {
      QLog.d(".SSOChannel", 1, "send request, packet == null or result == null");
    }
    int i;
    do
    {
      return;
      AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
      i = REQ_FACTORY.incrementAndGet();
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", localAppRuntime.getAccount(), paramSSORequest.cmd);
      if (paramSSORequest.timeout != null) {
        localToServiceMsg.setTimeout(paramSSORequest.timeout.intValue() * 1000L);
      }
      localToServiceMsg.extraData.putLong("REQUEST_TIME", System.currentTimeMillis());
      localToServiceMsg.extraData.putInt("FLUTTER_REQUEST_SEQ", i);
      this.mResultMethodCache.put(Integer.valueOf(i), paramSSOResultCallback);
      localToServiceMsg.putWupBuffer(paramSSORequest.body);
      paramSSOResultCallback = new NewIntent(MobileQQ.sMobileQQ, SSOEasyServlet.class);
      paramSSOResultCallback.putExtra(ToServiceMsg.class.getSimpleName(), localToServiceMsg);
      paramSSOResultCallback.setObserver(this);
      localAppRuntime.startServlet(paramSSOResultCallback);
    } while (!QLog.isColorLevel());
    QLog.d(".SSOChannel", 2, String.format("send request cmd: %s, request seq: %s", new Object[] { paramSSORequest.cmd, Integer.valueOf(i) }));
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    SSOResponse localSSOResponse = new SSOResponse();
    if (paramBundle == null)
    {
      QLog.e(".SSOChannel", 1, "onReceive, bundle == null");
      return;
    }
    ToServiceMsg localToServiceMsg = (ToServiceMsg)paramBundle.getParcelable(ToServiceMsg.class.getSimpleName());
    paramInt = localToServiceMsg.extraData.getInt("FLUTTER_REQUEST_SEQ");
    SSOResultCallback localSSOResultCallback = (SSOResultCallback)this.mResultMethodCache.remove(Integer.valueOf(paramInt));
    paramBundle = (FromServiceMsg)paramBundle.getParcelable(FromServiceMsg.class.getSimpleName());
    if ((localToServiceMsg == null) || (paramBundle == null))
    {
      QLog.e(".SSOChannel", 1, "request == null || response == null");
      notifyFlutterResult(localToServiceMsg.getServiceCmd(), localSSOResponse, localSSOResultCallback);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = localToServiceMsg.extraData.getLong("REQUEST_TIME");
    if (QLog.isColorLevel()) {
      QLog.d(".SSOChannel", 2, String.format("[onReceive]cmd: %s, app seq: %s, cost: %s, errCode: %s", new Object[] { localToServiceMsg.getServiceCmd(), Integer.valueOf(localToServiceMsg.getAppSeq()), Long.valueOf(l1 - l2), Integer.valueOf(paramBundle.getResultCode()) }));
    }
    byte[] arrayOfByte = paramBundle.getWupBuffer();
    localSSOResponse.isSuc = Boolean.valueOf(paramBundle.isSuccess());
    localSSOResponse.errCode = Integer.valueOf(paramBundle.getResultCode());
    localSSOResponse.body = arrayOfByte;
    notifyFlutterResult(localToServiceMsg.getServiceCmd(), localSSOResponse, localSSOResultCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.app.api.impl.SSOChannel
 * JD-Core Version:    0.7.0.1
 */