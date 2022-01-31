package mqq.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.VerifyDevLockManager;
import mqq.manager.VerifyDevLockManager.NotifyType;
import mqq.manager.VerifyDevLockManager.VerifyDevLockObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

public class VerifyDevLockManagerImpl
  implements VerifyDevLockManager
{
  public static final int MSG_NOTIFY_UI_CLOSE = 1;
  public static final int MSG_NOTIFY_UI_RECVED = 0;
  private static final String TAG = VerifyDevLockManagerImpl.class.getSimpleName();
  private final AppRuntime mApp;
  private final Handler mHandler = new VerifyDevLockManagerImpl.1(this, Looper.getMainLooper());
  ConcurrentHashMap<Integer, VerifyDevLockManagerImpl.VerifyDevLockWrapper> mVerifyDevLockWrapperMap = new ConcurrentHashMap();
  
  public VerifyDevLockManagerImpl(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
  }
  
  private VerifyDevLockManager.NotifyType getNoticeType(MsfCommand paramMsfCommand)
  {
    if (paramMsfCommand == MsfCommand.wt_RefreshSMSData) {
      return VerifyDevLockManager.NotifyType.NOTIFY_REFRESH_SMS_RESULT;
    }
    return VerifyDevLockManager.NotifyType.NOTIFY_AUTH_RESULT;
  }
  
  private void notifyApp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    QLog.d(TAG, 2, "notifyApp seq:" + paramFromServiceMsg.getRequestSsoSeq() + " uin:" + paramFromServiceMsg.getUin() + " msfCmd:" + paramFromServiceMsg.getMsfCommand());
    this.mApp.getService().onRecvVerifyManagerCallback(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void notifyClose(VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver, int paramInt1, String paramString, int paramInt2, ErrMsg paramErrMsg)
  {
    QLog.d(TAG, 2, "notifyClose seq:" + paramInt1 + " uin:" + paramString + " ret:" + paramInt2);
    Message localMessage = this.mHandler.obtainMessage();
    localMessage.obj = new Object[] { paramVerifyDevLockObserver, Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2), paramErrMsg };
    localMessage.what = 1;
    localMessage.sendToTarget();
  }
  
  private void notifyUI(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, int paramInt, ErrMsg paramErrMsg, DevlockInfo paramDevlockInfo)
  {
    VerifyDevLockManager.NotifyType localNotifyType = getNoticeType(paramFromServiceMsg.getMsfCommand());
    int i = paramToServiceMsg.getRequestSsoSeq();
    String str2 = paramFromServiceMsg.getUin();
    String str3 = String.valueOf(paramToServiceMsg.getAttribute("process"));
    VerifyDevLockManagerImpl.VerifyDevLockWrapper localVerifyDevLockWrapper = (VerifyDevLockManagerImpl.VerifyDevLockWrapper)this.mVerifyDevLockWrapperMap.get(Integer.valueOf(i));
    paramFromServiceMsg = null;
    String str1 = null;
    if (paramToServiceMsg.getAttribute("from_where") != null)
    {
      paramFromServiceMsg = (String)paramToServiceMsg.getAttribute("from_where");
      str1 = (String)paramToServiceMsg.getAttribute("mainaccount");
    }
    if ((localVerifyDevLockWrapper != null) && (localVerifyDevLockWrapper.mVerifyDevLockObserver != null))
    {
      QLog.d(TAG, 2, "notifyUI already started, notifyType:" + localNotifyType + " seq:" + i + " uin:" + str2 + " ret:" + paramInt);
      paramToServiceMsg = this.mHandler.obtainMessage();
      paramToServiceMsg.obj = new Object[] { localVerifyDevLockWrapper.mVerifyDevLockObserver, localNotifyType, Integer.valueOf(i), str2, Integer.valueOf(paramInt), paramErrMsg, paramDevlockInfo };
      paramToServiceMsg.what = 0;
      paramToServiceMsg.sendToTarget();
      return;
    }
    if (QLog.isColorLevel())
    {
      paramErrMsg = TAG;
      StringBuilder localStringBuilder = new StringBuilder().append("notifyUI wrapper=").append(localVerifyDevLockWrapper).append(" mVerifyDevLockObserver=");
      if (localVerifyDevLockWrapper == null)
      {
        paramToServiceMsg = "null";
        QLog.d(paramErrMsg, 2, paramToServiceMsg);
      }
    }
    else
    {
      QLog.d(TAG, 2, "notifyUI start, notifyType:" + localNotifyType + " seq:" + i + " uin:" + str2 + " ret:" + paramInt);
      paramToServiceMsg = new Intent();
      paramToServiceMsg.setFlags(268435456);
      if (!"com.tencent.mobileqq:openSdk".equals(str3)) {
        break label453;
      }
      paramToServiceMsg.setAction("mqq.opensdk.intent.action.ACTION_VERYFY_LOCK_CODE");
    }
    for (;;)
    {
      paramToServiceMsg.putExtra("DevlockInfo", paramDevlockInfo);
      paramToServiceMsg.putExtra("seq", i);
      paramToServiceMsg.putExtra("uin", str2);
      paramToServiceMsg.putExtra("from_login", true);
      paramToServiceMsg.putExtra("from_where", paramFromServiceMsg);
      paramToServiceMsg.putExtra("mainaccount", str1);
      paramToServiceMsg.putExtra("process", str3);
      this.mApp.getApplication().startActivity(paramToServiceMsg);
      return;
      paramToServiceMsg = localVerifyDevLockWrapper.mVerifyDevLockObserver;
      break;
      label453:
      paramToServiceMsg.setAction("android.intent.action.VIEW");
      paramToServiceMsg.setData(Uri.parse("mqqverifycode://puzzle_verify_code/DEVLOCK_CODE?"));
    }
  }
  
  public void cancelVerify(VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver)
  {
    if (paramVerifyDevLockObserver == null) {
      QLog.d(TAG, 2, "cancelVerify observer==null");
    }
    do
    {
      return;
      paramVerifyDevLockObserver = (VerifyDevLockManagerImpl.VerifyDevLockWrapper)this.mVerifyDevLockWrapperMap.remove(Integer.valueOf(paramVerifyDevLockObserver.getSeq()));
    } while ((paramVerifyDevLockObserver == null) || (paramVerifyDevLockObserver.mToServiceMsg == null));
    QLog.d(TAG, 2, "cancelVerify");
    ToServiceMsg localToServiceMsg = paramVerifyDevLockObserver.mToServiceMsg;
    FromServiceMsg localFromServiceMsg = new FromServiceMsg(localToServiceMsg.getAppId(), localToServiceMsg.getAppSeq(), localToServiceMsg.getUin(), localToServiceMsg.getServiceCmd());
    localFromServiceMsg.setMsfCommand(localToServiceMsg.getMsfCommand());
    localFromServiceMsg.setBusinessFail(2006, "");
    notifyApp(paramVerifyDevLockObserver.mToServiceMsg, localFromServiceMsg);
  }
  
  public boolean checkVerifyDevLockSmsResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i = 1001;
    if (paramFromServiceMsg.attributes.get("ret") != null) {
      i = ((Integer)paramFromServiceMsg.attributes.get("ret")).intValue();
    }
    if (paramFromServiceMsg.attributes.get("lastError") != null) {}
    for (ErrMsg localErrMsg = (ErrMsg)paramFromServiceMsg.attributes.get("lastError");; localErrMsg = null)
    {
      if (paramFromServiceMsg.getAttribute("resp_devlockinfo") != null) {}
      for (DevlockInfo localDevlockInfo = (DevlockInfo)paramFromServiceMsg.getAttribute("resp_devlockinfo");; localDevlockInfo = null) {
        try
        {
          if ((!TextUtils.isEmpty(paramFromServiceMsg.getUin())) && (paramFromServiceMsg.getUin().equals("0")))
          {
            if ((TextUtils.isEmpty(paramToServiceMsg.getUin())) || (paramToServiceMsg.getUin().equals("0"))) {
              break label324;
            }
            QLog.d(TAG, 2, "copy uin from toServiceMsg");
            paramFromServiceMsg.setUin(paramToServiceMsg.getUin());
          }
          for (;;)
          {
            label148:
            QLog.d(TAG, 2, "checkVerifyDevLockSmsResp ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + " msfCmd:" + paramFromServiceMsg.getMsfCommand() + " ret:" + i + " busCode:" + paramFromServiceMsg.getBusinessFailCode());
            if (paramFromServiceMsg.getBusinessFailCode() != 2016) {
              break;
            }
            if (!this.mVerifyDevLockWrapperMap.containsKey(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq())))
            {
              this.mVerifyDevLockWrapperMap.putIfAbsent(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()), new VerifyDevLockManagerImpl.VerifyDevLockWrapper(this, paramToServiceMsg.getRequestSsoSeq()));
              ((VerifyDevLockManagerImpl.VerifyDevLockWrapper)this.mVerifyDevLockWrapperMap.get(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()))).mToServiceMsg = paramToServiceMsg;
            }
            ((VerifyDevLockManagerImpl.VerifyDevLockWrapper)this.mVerifyDevLockWrapperMap.get(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()))).mUin = paramFromServiceMsg.getUin();
            notifyUI(paramToServiceMsg, paramFromServiceMsg, i, localErrMsg, localDevlockInfo);
            return false;
            label324:
            QLog.d(TAG, 2, "all uin is 0");
          }
        }
        catch (Throwable localThrowable)
        {
          break label148;
          if ((paramFromServiceMsg.getBusinessFailCode() == 2017) || (this.mVerifyDevLockWrapperMap.containsKey(Integer.valueOf(paramFromServiceMsg.getRequestSsoSeq()))))
          {
            VerifyDevLockManagerImpl.VerifyDevLockWrapper localVerifyDevLockWrapper = (VerifyDevLockManagerImpl.VerifyDevLockWrapper)this.mVerifyDevLockWrapperMap.get(Integer.valueOf(paramFromServiceMsg.getRequestSsoSeq()));
            if (i == 0)
            {
              this.mVerifyDevLockWrapperMap.remove(Integer.valueOf(paramFromServiceMsg.getRequestSsoSeq()));
              notifyClose(localVerifyDevLockWrapper.mVerifyDevLockObserver, paramFromServiceMsg.getRequestSsoSeq(), paramFromServiceMsg.getUin(), i, localErrMsg);
              paramFromServiceMsg.setMsfCommand(localVerifyDevLockWrapper.mToServiceMsg.getMsfCommand());
              notifyApp(localVerifyDevLockWrapper.mToServiceMsg, paramFromServiceMsg);
              return false;
            }
            if (i == 2)
            {
              this.mVerifyDevLockWrapperMap.remove(Integer.valueOf(paramFromServiceMsg.getRequestSsoSeq()));
              notifyClose(localVerifyDevLockWrapper.mVerifyDevLockObserver, paramFromServiceMsg.getRequestSsoSeq(), paramFromServiceMsg.getUin(), i, localErrMsg);
              return true;
            }
            notifyUI(paramToServiceMsg, paramFromServiceMsg, i, localErrMsg, localDevlockInfo);
            return false;
          }
          return true;
        }
      }
    }
  }
  
  public void onDestroy() {}
  
  public void refreshDevLockSms(VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver)
  {
    if (paramVerifyDevLockObserver == null) {
      QLog.d(TAG, 2, "refreshDevLockSms observer == null!");
    }
    VerifyDevLockManagerImpl.VerifyDevLockWrapper localVerifyDevLockWrapper;
    do
    {
      return;
      localVerifyDevLockWrapper = (VerifyDevLockManagerImpl.VerifyDevLockWrapper)this.mVerifyDevLockWrapperMap.get(Integer.valueOf(paramVerifyDevLockObserver.getSeq()));
    } while (localVerifyDevLockWrapper == null);
    QLog.d(TAG, 2, "refreshDevLockSms");
    localVerifyDevLockWrapper.mVerifyDevLockObserver = paramVerifyDevLockObserver;
    paramVerifyDevLockObserver = this.mApp.getService().msfSub.getRefreshDevLockSmsMsg(localVerifyDevLockWrapper.mUin);
    paramVerifyDevLockObserver.setRequestSsoSeq(localVerifyDevLockWrapper.mSeq);
    paramVerifyDevLockObserver.setAppSeq(localVerifyDevLockWrapper.mSeq);
    this.mApp.getService().msfSub.sendMsg(paramVerifyDevLockObserver);
  }
  
  public void removeVerifyDevlockObserver(VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver)
  {
    if ((this.mVerifyDevLockWrapperMap != null) && (paramVerifyDevLockObserver != null)) {
      this.mVerifyDevLockWrapperMap.remove(Integer.valueOf(paramVerifyDevLockObserver.getSeq()));
    }
  }
  
  public void submitSms(VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver, String paramString)
  {
    if (paramVerifyDevLockObserver == null) {
      QLog.d(TAG, 2, "submitSms observer == null!");
    }
    VerifyDevLockManagerImpl.VerifyDevLockWrapper localVerifyDevLockWrapper;
    do
    {
      return;
      if (TextUtils.isEmpty(paramString))
      {
        QLog.d(TAG, 2, "submitSms smscode is empty!");
        return;
      }
      localVerifyDevLockWrapper = (VerifyDevLockManagerImpl.VerifyDevLockWrapper)this.mVerifyDevLockWrapperMap.get(Integer.valueOf(paramVerifyDevLockObserver.getSeq()));
    } while (localVerifyDevLockWrapper == null);
    QLog.d(TAG, 2, "submitSms smscode:" + paramString);
    Object localObject = localVerifyDevLockWrapper.mToServiceMsg;
    localVerifyDevLockWrapper.mVerifyDevLockObserver = paramVerifyDevLockObserver;
    paramVerifyDevLockObserver = this.mApp.getService().msfSub.getCheckSMSAndGetStMsg(localVerifyDevLockWrapper.mUin, paramString.getBytes());
    paramVerifyDevLockObserver.setRequestSsoSeq(localVerifyDevLockWrapper.mSeq);
    paramVerifyDevLockObserver.setAppSeq(localVerifyDevLockWrapper.mSeq);
    if (((ToServiceMsg)localObject).getAttribute("from_where") != null)
    {
      paramString = (String)((ToServiceMsg)localObject).getAttribute("from_where");
      localObject = (String)((ToServiceMsg)localObject).getAttribute("mainaccount");
      paramVerifyDevLockObserver.addAttribute("from_where", paramString);
      paramVerifyDevLockObserver.addAttribute("mainaccount", localObject);
    }
    this.mApp.getService().msfSub.sendMsg(paramVerifyDevLockObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.app.VerifyDevLockManagerImpl
 * JD-Core Version:    0.7.0.1
 */