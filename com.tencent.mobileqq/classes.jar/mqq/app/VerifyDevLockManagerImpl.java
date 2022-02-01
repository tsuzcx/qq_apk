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
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.VerifyDevLockManager;
import mqq.manager.VerifyDevLockManager.VerifyDevLockObserver;
import mqq.util.LogUtil;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

public class VerifyDevLockManagerImpl
  implements VerifyDevLockManager
{
  private static final int CODE_GATEWAY = 239;
  private static final String KEY_UIN = "uin";
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
  
  private int getNoticeType(MsfCommand paramMsfCommand)
  {
    if (paramMsfCommand == MsfCommand.wt_RefreshSMSData) {
      return 1002;
    }
    return 1001;
  }
  
  private void notifyApp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    QLog.i(TAG, 1, "notifyApp seq:" + paramFromServiceMsg.getRequestSsoSeq() + " uin:" + LogUtil.getSafePrintUin(paramFromServiceMsg.getUin()) + " msfCmd:" + paramFromServiceMsg.getMsfCommand());
    this.mApp.getRuntimeService().onRecvVerifyManagerCallback(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void notifyClose(VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver, int paramInt1, String paramString, int paramInt2, ErrMsg paramErrMsg)
  {
    QLog.i(TAG, 1, "notifyClose seq:" + paramInt1 + " uin:" + LogUtil.getSafePrintUin(paramString) + " ret:" + paramInt2);
    Message localMessage = this.mHandler.obtainMessage();
    localMessage.obj = new Object[] { paramVerifyDevLockObserver, Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2), paramErrMsg };
    localMessage.what = 1;
    localMessage.sendToTarget();
  }
  
  private void notifyUI(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, int paramInt, ErrMsg paramErrMsg, DevlockInfo paramDevlockInfo)
  {
    int i = getNoticeType(paramFromServiceMsg.getMsfCommand());
    if (paramToServiceMsg.getAttribute("smsExtraData") != null) {
      if (i == 1002) {
        i = 1003;
      }
    }
    for (;;)
    {
      int j = paramToServiceMsg.getRequestSsoSeq();
      String str3 = paramFromServiceMsg.getUin();
      String str4 = String.valueOf(paramToServiceMsg.getAttribute("process"));
      VerifyDevLockManagerImpl.VerifyDevLockWrapper localVerifyDevLockWrapper = (VerifyDevLockManagerImpl.VerifyDevLockWrapper)this.mVerifyDevLockWrapperMap.get(Integer.valueOf(j));
      String str1 = null;
      String str2 = null;
      if (paramToServiceMsg.getAttribute("from_where") != null)
      {
        str1 = (String)paramToServiceMsg.getAttribute("from_where");
        str2 = (String)paramToServiceMsg.getAttribute("mainaccount");
      }
      if ((localVerifyDevLockWrapper != null) && (localVerifyDevLockWrapper.mVerifyDevLockObserver != null))
      {
        paramToServiceMsg = null;
        if ((i == 1003) || (i == 1004))
        {
          paramToServiceMsg = paramFromServiceMsg.getAttribute("smsExtraData");
          if (paramToServiceMsg == null) {
            break label302;
          }
        }
        label302:
        for (paramToServiceMsg = (byte[])paramToServiceMsg;; paramToServiceMsg = null)
        {
          QLog.d(TAG, 2, "notifyUI already started, notifyType:" + i + " seq:" + j + " uin:" + str3 + " ret:" + paramInt);
          paramFromServiceMsg = this.mHandler.obtainMessage();
          paramFromServiceMsg.obj = new Object[] { localVerifyDevLockWrapper.mVerifyDevLockObserver, Integer.valueOf(i), Integer.valueOf(j), str3, Integer.valueOf(paramInt), paramErrMsg, paramDevlockInfo, paramToServiceMsg };
          paramFromServiceMsg.what = 0;
          paramFromServiceMsg.sendToTarget();
          return;
          i = 1004;
          break;
        }
      }
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = TAG;
        paramErrMsg = new StringBuilder().append("notifyUI wrapper=").append(localVerifyDevLockWrapper).append(" mVerifyDevLockObserver=");
        if (localVerifyDevLockWrapper == null)
        {
          paramToServiceMsg = "null";
          QLog.d(paramFromServiceMsg, 2, paramToServiceMsg);
        }
      }
      else
      {
        QLog.d(TAG, 2, "notifyUI start, notifyType:" + i + " seq:" + j + " uin:" + str3 + " ret:" + paramInt);
        paramToServiceMsg = new Intent();
        paramToServiceMsg.setFlags(268435456);
        if (!"com.tencent.mobileqq:openSdk".equals(str4)) {
          break label546;
        }
        paramToServiceMsg.setAction("mqq.opensdk.intent.action.ACTION_VERYFY_LOCK_CODE");
        paramToServiceMsg.setPackage(MobileQQ.sMobileQQ.getPackageName());
      }
      for (;;)
      {
        paramToServiceMsg.putExtra("DevlockInfo", paramDevlockInfo);
        paramToServiceMsg.putExtra("seq", j);
        paramToServiceMsg.putExtra("uin", str3);
        paramToServiceMsg.putExtra("from_login", true);
        paramToServiceMsg.putExtra("from_where", str1);
        paramToServiceMsg.putExtra("mainaccount", str2);
        paramToServiceMsg.putExtra("process", str4);
        this.mApp.getApplication().startActivity(paramToServiceMsg);
        return;
        paramToServiceMsg = localVerifyDevLockWrapper.mVerifyDevLockObserver;
        break;
        label546:
        if (paramInt == 239)
        {
          paramToServiceMsg.setAction("android.intent.action.VIEW");
          paramToServiceMsg.setData(Uri.parse("mqqverifycode://puzzle_verify_code/GATEVERIFY?"));
        }
        else
        {
          paramToServiceMsg.setAction("android.intent.action.VIEW");
          paramToServiceMsg.setData(Uri.parse("mqqverifycode://puzzle_verify_code/DEVLOCK_CODE?"));
        }
      }
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
              QLog.i(TAG, 1, "checkVerifyDevLockSmsResp ret == util.S_SUCCESS remove");
              notifySuccess(localVerifyDevLockWrapper.mVerifyDevLockObserver, paramFromServiceMsg.getUin(), paramToServiceMsg, paramFromServiceMsg);
              this.mVerifyDevLockWrapperMap.remove(Integer.valueOf(paramFromServiceMsg.getRequestSsoSeq()));
              notifyClose(localVerifyDevLockWrapper.mVerifyDevLockObserver, paramFromServiceMsg.getRequestSsoSeq(), paramFromServiceMsg.getUin(), i, localErrMsg);
              paramFromServiceMsg.setMsfCommand(localVerifyDevLockWrapper.mToServiceMsg.getMsfCommand());
              notifyApp(localVerifyDevLockWrapper.mToServiceMsg, paramFromServiceMsg);
              return false;
            }
            if (i == 2)
            {
              QLog.i(TAG, 1, "checkVerifyDevLockSmsResp ret == util.S_GET_IMAGE checkVerifyDevLockSmsResp remove");
              this.mVerifyDevLockWrapperMap.remove(Integer.valueOf(paramFromServiceMsg.getRequestSsoSeq()));
              notifyClose(localVerifyDevLockWrapper.mVerifyDevLockObserver, paramFromServiceMsg.getRequestSsoSeq(), paramFromServiceMsg.getUin(), i, localErrMsg);
              return true;
            }
            notifyUI(paramToServiceMsg, paramFromServiceMsg, i, localErrMsg, localDevlockInfo);
            return false;
          }
          if (i == 239)
          {
            notifyUI(paramToServiceMsg, paramFromServiceMsg, i, localErrMsg, localDevlockInfo);
            return false;
          }
          return true;
        }
      }
    }
  }
  
  public void gatewayVerify(VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver, byte[] paramArrayOfByte)
  {
    if (paramVerifyDevLockObserver == null) {
      QLog.d(TAG, 2, "submitSms observer == null!");
    }
    Object localObject;
    do
    {
      return;
      localObject = (VerifyDevLockManagerImpl.VerifyDevLockWrapper)this.mVerifyDevLockWrapperMap.get(Integer.valueOf(paramVerifyDevLockObserver.getSeq()));
    } while (localObject == null);
    ToServiceMsg localToServiceMsg = ((VerifyDevLockManagerImpl.VerifyDevLockWrapper)localObject).mToServiceMsg;
    ((VerifyDevLockManagerImpl.VerifyDevLockWrapper)localObject).mVerifyDevLockObserver = paramVerifyDevLockObserver;
    paramVerifyDevLockObserver = this.mApp.getRuntimeService().msfSub.getCheckSMSAndGetStMsg(((VerifyDevLockManagerImpl.VerifyDevLockWrapper)localObject).mUin, new byte[0]);
    paramVerifyDevLockObserver.setRequestSsoSeq(((VerifyDevLockManagerImpl.VerifyDevLockWrapper)localObject).mSeq);
    paramVerifyDevLockObserver.setAppSeq(((VerifyDevLockManagerImpl.VerifyDevLockWrapper)localObject).mSeq);
    if (localToServiceMsg.getAttribute("from_where") != null)
    {
      localObject = (String)localToServiceMsg.getAttribute("from_where");
      String str = (String)localToServiceMsg.getAttribute("mainaccount");
      paramVerifyDevLockObserver.addAttribute("from_where", localObject);
      paramVerifyDevLockObserver.addAttribute("mainaccount", str);
    }
    paramVerifyDevLockObserver.addAttribute("smsExtraData", paramArrayOfByte);
    VerifyCodeManagerImpl.addConnectData(localToServiceMsg, paramVerifyDevLockObserver);
    this.mApp.getRuntimeService().msfSub.sendMsg(paramVerifyDevLockObserver);
  }
  
  protected void notifySuccess(VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver, String paramString, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramVerifyDevLockObserver != null) {
      paramVerifyDevLockObserver.onVerifySuccess(paramString, paramToServiceMsg, paramFromServiceMsg);
    }
  }
  
  public void onDestroy() {}
  
  public void pullToServiceMsg(int paramInt, ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null)
    {
      QLog.i(TAG, 1, "pullToServiceMsg toServiceMsg = null,seq=" + paramInt);
      return;
    }
    QLog.i(TAG, 1, "pullToServiceMsg seq = " + paramInt);
    VerifyDevLockManagerImpl.VerifyDevLockWrapper localVerifyDevLockWrapper = new VerifyDevLockManagerImpl.VerifyDevLockWrapper(this, paramInt);
    localVerifyDevLockWrapper.mToServiceMsg = paramToServiceMsg;
    localVerifyDevLockWrapper.mUin = paramToServiceMsg.getUin();
    this.mVerifyDevLockWrapperMap.putIfAbsent(Integer.valueOf(paramInt), localVerifyDevLockWrapper);
  }
  
  public void refreshDevLockSms(VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver, HashMap<String, Object> paramHashMap)
  {
    if (paramVerifyDevLockObserver == null)
    {
      QLog.d(TAG, 2, "refreshDevLockSms observer == null!");
      return;
    }
    VerifyDevLockManagerImpl.VerifyDevLockWrapper localVerifyDevLockWrapper = (VerifyDevLockManagerImpl.VerifyDevLockWrapper)this.mVerifyDevLockWrapperMap.get(Integer.valueOf(paramVerifyDevLockObserver.getSeq()));
    if (localVerifyDevLockWrapper != null)
    {
      QLog.i(TAG, 1, "refreshDevLockSms" + paramVerifyDevLockObserver.getSeq());
      localVerifyDevLockWrapper.mVerifyDevLockObserver = paramVerifyDevLockObserver;
      paramVerifyDevLockObserver = this.mApp.getRuntimeService().msfSub.getRefreshDevLockSmsMsg(localVerifyDevLockWrapper.mUin);
      paramVerifyDevLockObserver.setRequestSsoSeq(localVerifyDevLockWrapper.mSeq);
      paramVerifyDevLockObserver.setAppSeq(localVerifyDevLockWrapper.mSeq);
      if (paramHashMap != null)
      {
        Iterator localIterator = paramHashMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          paramVerifyDevLockObserver.addAttribute(str, paramHashMap.get(str));
        }
      }
      VerifyCodeManagerImpl.addConnectData(localVerifyDevLockWrapper.mToServiceMsg, paramVerifyDevLockObserver);
      this.mApp.getRuntimeService().msfSub.sendMsg(paramVerifyDevLockObserver);
      return;
    }
    QLog.i(TAG, 1, "refreshDevLockSms wrapper == null " + paramVerifyDevLockObserver.getSeq());
  }
  
  public void refreshDevLockSms(VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver, byte[] paramArrayOfByte)
  {
    if (paramVerifyDevLockObserver == null) {
      QLog.d(TAG, 1, "refreshDevLockSms2 observer == null!");
    }
    VerifyDevLockManagerImpl.VerifyDevLockWrapper localVerifyDevLockWrapper;
    do
    {
      return;
      localVerifyDevLockWrapper = (VerifyDevLockManagerImpl.VerifyDevLockWrapper)this.mVerifyDevLockWrapperMap.get(Integer.valueOf(paramVerifyDevLockObserver.getSeq()));
    } while (localVerifyDevLockWrapper == null);
    QLog.d(TAG, 1, "refreshDevLockSms2");
    localVerifyDevLockWrapper.mVerifyDevLockObserver = paramVerifyDevLockObserver;
    paramVerifyDevLockObserver = this.mApp.getRuntimeService().msfSub.getRefreshDevLockSmsMsg(localVerifyDevLockWrapper.mUin);
    paramVerifyDevLockObserver.setRequestSsoSeq(localVerifyDevLockWrapper.mSeq);
    paramVerifyDevLockObserver.setAppSeq(localVerifyDevLockWrapper.mSeq);
    paramVerifyDevLockObserver.getAttributes().put("smsExtraData", paramArrayOfByte);
    VerifyCodeManagerImpl.addConnectData(localVerifyDevLockWrapper.mToServiceMsg, paramVerifyDevLockObserver);
    this.mApp.getRuntimeService().msfSub.sendMsg(paramVerifyDevLockObserver);
  }
  
  public void removeVerifyDevlockObserver(VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver)
  {
    if ((this.mVerifyDevLockWrapperMap != null) && (paramVerifyDevLockObserver != null)) {
      this.mVerifyDevLockWrapperMap.remove(Integer.valueOf(paramVerifyDevLockObserver.getSeq()));
    }
  }
  
  public void submitSms(VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver, String paramString, HashMap<String, Object> paramHashMap)
  {
    if (paramVerifyDevLockObserver == null) {
      QLog.d(TAG, 2, "submitSms observer == null!");
    }
    Object localObject;
    do
    {
      return;
      if (TextUtils.isEmpty(paramString))
      {
        QLog.d(TAG, 2, "submitSms smscode is empty!");
        return;
      }
      localObject = (VerifyDevLockManagerImpl.VerifyDevLockWrapper)this.mVerifyDevLockWrapperMap.get(Integer.valueOf(paramVerifyDevLockObserver.getSeq()));
    } while (localObject == null);
    QLog.d(TAG, 2, "submitSms smscode:" + paramString);
    ToServiceMsg localToServiceMsg = ((VerifyDevLockManagerImpl.VerifyDevLockWrapper)localObject).mToServiceMsg;
    ((VerifyDevLockManagerImpl.VerifyDevLockWrapper)localObject).mVerifyDevLockObserver = paramVerifyDevLockObserver;
    paramVerifyDevLockObserver = this.mApp.getRuntimeService().msfSub.getCheckSMSAndGetStMsg(((VerifyDevLockManagerImpl.VerifyDevLockWrapper)localObject).mUin, paramString.getBytes());
    paramVerifyDevLockObserver.setRequestSsoSeq(((VerifyDevLockManagerImpl.VerifyDevLockWrapper)localObject).mSeq);
    paramVerifyDevLockObserver.setAppSeq(((VerifyDevLockManagerImpl.VerifyDevLockWrapper)localObject).mSeq);
    if (localToServiceMsg.getAttribute("from_where") != null)
    {
      paramString = (String)localToServiceMsg.getAttribute("from_where");
      localObject = (String)localToServiceMsg.getAttribute("mainaccount");
      paramVerifyDevLockObserver.addAttribute("from_where", paramString);
      paramVerifyDevLockObserver.addAttribute("mainaccount", localObject);
    }
    if (paramHashMap != null)
    {
      paramString = paramHashMap.keySet().iterator();
      while (paramString.hasNext())
      {
        localObject = (String)paramString.next();
        paramVerifyDevLockObserver.addAttribute((String)localObject, paramHashMap.get(localObject));
      }
    }
    VerifyCodeManagerImpl.addConnectData(localToServiceMsg, paramVerifyDevLockObserver);
    this.mApp.getRuntimeService().msfSub.sendMsg(paramVerifyDevLockObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.app.VerifyDevLockManagerImpl
 * JD-Core Version:    0.7.0.1
 */