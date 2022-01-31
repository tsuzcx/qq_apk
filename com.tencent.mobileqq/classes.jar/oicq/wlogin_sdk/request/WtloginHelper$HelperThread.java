package oicq.wlogin_sdk.request;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.Timer;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tools.util;

public class WtloginHelper$HelperThread
  extends Thread
{
  public static final String THREAD_NAME_PRE = "Wtlogin_";
  boolean isSelfLooper = false;
  byte[] mAppName2;
  byte[] mAppSign2;
  byte[] mAppVer2;
  long mAppid1;
  long mAppid2;
  long mDwAppid;
  long mDwDstAppPri;
  long mDwDstAppid;
  long[] mDwDstSubAppidList;
  int mDwMainSigMap;
  long[] mDwSubAppidList;
  long mDwSubDstAppid;
  int mEncrypt;
  int mExtraFlag = 1;
  long mExtraUin = -1L;
  WFastLoginInfo mFastLoginInfo;
  Handler mHandler;
  WtloginHelper mHelper;
  boolean mIsSmslogin = false;
  String mMsgCode;
  byte[] mPictureData;
  WtTicketPromise mPromise;
  boolean mPwdMd5;
  int mReportErrType;
  TransReqContext mReqContext;
  int mReqType;
  byte[][] mReserve;
  long mRole;
  byte[][] mST;
  byte[] mST1;
  byte[] mST1Key;
  long mSmsAppid;
  long mSsoVer2;
  long mSubAppid1;
  long mSubAppid2;
  long mUIN;
  String mUserAccount;
  byte[] mUserInput;
  String mUserPasswd;
  WUserSigInfo mUserSigInfo = null;
  byte[] mWxAppid;
  String ptSig;
  WtloginHelper.QuickLoginParam quickLoginParam;
  byte[] weChatCode;
  
  WtloginHelper$HelperThread(WtloginHelper paramWtloginHelper1, WtloginHelper paramWtloginHelper2, Handler paramHandler)
  {
    this.mHelper = paramWtloginHelper2;
    this.mHandler = paramHandler;
  }
  
  WtloginHelper$HelperThread(WtloginHelper paramWtloginHelper1, WtloginHelper paramWtloginHelper2, Handler paramHandler, int paramInt, String paramString1, long paramLong1, long paramLong2, TransReqContext paramTransReqContext, String paramString2)
  {
    this.mHelper = paramWtloginHelper2;
    this.mHandler = paramHandler;
    this.mEncrypt = paramInt;
    this.mUserAccount = paramString1;
    this.mDwAppid = paramLong1;
    this.mRole = paramLong2;
    this.mReqContext = paramTransReqContext;
    setName("Wtlogin_" + paramString2);
  }
  
  WtloginHelper$HelperThread(WtloginHelper paramWtloginHelper1, WtloginHelper paramWtloginHelper2, Handler paramHandler, int paramInt, String paramString1, long paramLong1, long paramLong2, TransReqContext paramTransReqContext, WUserSigInfo paramWUserSigInfo, String paramString2)
  {
    this.mHelper = paramWtloginHelper2;
    this.mHandler = paramHandler;
    this.mEncrypt = paramInt;
    this.mUserAccount = paramString1;
    this.mDwAppid = paramLong1;
    this.mRole = paramLong2;
    this.mReqContext = paramTransReqContext;
    this.mUserSigInfo = paramWUserSigInfo;
    setName("Wtlogin_" + paramString2);
  }
  
  WtloginHelper$HelperThread(WtloginHelper paramWtloginHelper1, WtloginHelper paramWtloginHelper2, Handler paramHandler, long paramLong1, long paramLong2, String paramString1, int paramInt, long paramLong3, WUserSigInfo paramWUserSigInfo, String paramString2)
  {
    this.mHelper = paramWtloginHelper2;
    this.mHandler = paramHandler;
    this.mUserAccount = paramString1;
    this.mAppid1 = paramLong1;
    this.mSubAppid1 = paramLong2;
    this.mUserSigInfo = paramWUserSigInfo;
    this.mExtraFlag = paramInt;
    this.mExtraUin = paramLong3;
    setName("Wtlogin_" + paramString2);
  }
  
  WtloginHelper$HelperThread(WtloginHelper paramWtloginHelper1, WtloginHelper paramWtloginHelper2, Handler paramHandler, long paramLong, String paramString)
  {
    this.mHelper = paramWtloginHelper2;
    this.mHandler = paramHandler;
    this.mUIN = paramLong;
    setName("Wtlogin_" + paramString);
  }
  
  WtloginHelper$HelperThread(WtloginHelper paramWtloginHelper1, WtloginHelper paramWtloginHelper2, Handler paramHandler, String paramString1, long paramLong1, int paramInt, long paramLong2, WUserSigInfo paramWUserSigInfo, String paramString2)
  {
    this.mHelper = paramWtloginHelper2;
    this.mHandler = paramHandler;
    this.mUserAccount = paramString1;
    this.mDwAppid = paramLong1;
    this.mDwMainSigMap = paramInt;
    this.mDwSubDstAppid = paramLong2;
    this.mUserSigInfo = paramWUserSigInfo;
    setName("Wtlogin_" + paramString2);
  }
  
  WtloginHelper$HelperThread(WtloginHelper paramWtloginHelper1, WtloginHelper paramWtloginHelper2, Handler paramHandler, String paramString1, long paramLong1, int paramInt, long paramLong2, long[] paramArrayOfLong, boolean paramBoolean1, String paramString2, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte, boolean paramBoolean2, String paramString3)
  {
    this.mHelper = paramWtloginHelper2;
    this.mHandler = paramHandler;
    this.mUserAccount = paramString1;
    this.mDwAppid = paramLong1;
    this.mDwMainSigMap = paramInt;
    this.mDwSubDstAppid = paramLong2;
    this.mDwSubAppidList = paramArrayOfLong;
    this.mPwdMd5 = paramBoolean1;
    this.mUserPasswd = paramString2;
    this.mUserSigInfo = paramWUserSigInfo;
    this.mST = paramArrayOfByte;
    this.mIsSmslogin = paramBoolean2;
    setName("Wtlogin_" + paramString3);
  }
  
  WtloginHelper$HelperThread(WtloginHelper paramWtloginHelper1, WtloginHelper paramWtloginHelper2, Handler paramHandler, String paramString1, long paramLong1, long paramLong2, int paramInt, byte[] paramArrayOfByte1, long paramLong3, long paramLong4, long paramLong5, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, WUserSigInfo paramWUserSigInfo, WFastLoginInfo paramWFastLoginInfo, String paramString2)
  {
    this.mHelper = paramWtloginHelper2;
    this.mHandler = paramHandler;
    this.mUserAccount = paramString1;
    this.mAppid1 = paramLong1;
    this.mSubAppid1 = paramLong2;
    this.mDwMainSigMap = paramInt;
    this.mAppName2 = paramArrayOfByte1;
    this.mSsoVer2 = paramLong4;
    this.mAppid2 = paramLong4;
    this.mSubAppid2 = paramLong5;
    this.mAppVer2 = paramArrayOfByte2;
    this.mAppSign2 = paramArrayOfByte3;
    this.mUserSigInfo = paramWUserSigInfo;
    this.mFastLoginInfo = paramWFastLoginInfo;
    setName("Wtlogin_" + paramString2);
  }
  
  WtloginHelper$HelperThread(WtloginHelper paramWtloginHelper1, WtloginHelper paramWtloginHelper2, Handler paramHandler, String paramString1, long paramLong, WUserSigInfo paramWUserSigInfo, String paramString2)
  {
    this.mHelper = paramWtloginHelper2;
    this.mHandler = paramHandler;
    this.mUserAccount = paramString1;
    this.mSmsAppid = paramLong;
    this.mUserSigInfo = paramWUserSigInfo;
    setName("Wtlogin_" + paramString2);
  }
  
  WtloginHelper$HelperThread(WtloginHelper paramWtloginHelper1, WtloginHelper paramWtloginHelper2, Handler paramHandler, String paramString1, String paramString2, WUserSigInfo paramWUserSigInfo, String paramString3)
  {
    this.mHelper = paramWtloginHelper2;
    this.mHandler = paramHandler;
    this.mUserAccount = paramString1;
    this.mMsgCode = paramString2;
    this.mUserSigInfo = paramWUserSigInfo;
    setName("Wtlogin_" + paramString3);
  }
  
  WtloginHelper$HelperThread(WtloginHelper paramWtloginHelper1, WtloginHelper paramWtloginHelper2, Handler paramHandler, String paramString1, String paramString2, WtloginHelper.QuickLoginParam paramQuickLoginParam, String paramString3)
  {
    this.mHelper = paramWtloginHelper2;
    this.mHandler = paramHandler;
    this.mUserAccount = paramString1;
    this.ptSig = paramString2;
    this.quickLoginParam = paramQuickLoginParam;
    this.mUserSigInfo = paramQuickLoginParam.userSigInfo;
    setName("Wtlogin_" + paramString3);
  }
  
  WtloginHelper$HelperThread(WtloginHelper paramWtloginHelper1, WtloginHelper paramWtloginHelper2, Handler paramHandler, String paramString1, WUserSigInfo paramWUserSigInfo, String paramString2)
  {
    this.mHelper = paramWtloginHelper2;
    this.mHandler = paramHandler;
    this.mUserAccount = paramString1;
    this.mUserSigInfo = paramWUserSigInfo;
    setName("Wtlogin_" + paramString2);
  }
  
  WtloginHelper$HelperThread(WtloginHelper paramWtloginHelper1, WtloginHelper paramWtloginHelper2, Handler paramHandler, String paramString1, WtloginHelper.QuickLoginParam paramQuickLoginParam, String paramString2)
  {
    this.mHelper = paramWtloginHelper2;
    this.mHandler = paramHandler;
    this.mUserAccount = paramString1;
    this.quickLoginParam = paramQuickLoginParam;
    this.mUserSigInfo = paramQuickLoginParam.userSigInfo;
    setName("Wtlogin_" + paramString2);
  }
  
  WtloginHelper$HelperThread(WtloginHelper paramWtloginHelper1, WtloginHelper paramWtloginHelper2, Handler paramHandler, String paramString1, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte1, String paramString2)
  {
    this.mHelper = paramWtloginHelper2;
    this.mHandler = paramHandler;
    this.mUserAccount = paramString1;
    this.mUserInput = paramArrayOfByte;
    this.mUserSigInfo = paramWUserSigInfo;
    this.mST = paramArrayOfByte1;
    setName("Wtlogin_" + paramString2);
  }
  
  WtloginHelper$HelperThread(WtloginHelper paramWtloginHelper1, WtloginHelper paramWtloginHelper2, Handler paramHandler, String paramString1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, WtloginHelper.QuickLoginParam paramQuickLoginParam, String paramString2)
  {
    this.mHelper = paramWtloginHelper2;
    this.mHandler = paramHandler;
    this.mUserAccount = paramString1;
    this.weChatCode = paramArrayOfByte2;
    this.mWxAppid = paramArrayOfByte1;
    this.quickLoginParam = paramQuickLoginParam;
    this.mUserSigInfo = paramQuickLoginParam.userSigInfo;
    setName(paramString2);
  }
  
  WtloginHelper$HelperThread(WtloginHelper paramWtloginHelper1, WtloginHelper paramWtloginHelper2, Handler paramHandler, WtTicketPromise paramWtTicketPromise, String paramString1, long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4, long[] paramArrayOfLong, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte1, byte[][] paramArrayOfByte2, String paramString2)
  {
    this.mHelper = paramWtloginHelper2;
    this.mHandler = paramHandler;
    this.mPromise = paramWtTicketPromise;
    this.mUserAccount = paramString1;
    this.mDwAppid = paramLong1;
    this.mDwDstAppid = paramLong2;
    this.mDwDstAppPri = paramLong3;
    this.mDwMainSigMap = paramInt;
    this.mDwSubDstAppid = paramLong4;
    this.mDwDstSubAppidList = paramArrayOfLong;
    this.mUserSigInfo = paramWUserSigInfo;
    this.mST = paramArrayOfByte1;
    this.mReserve = paramArrayOfByte2;
    setName("Wtlogin_" + paramString2);
  }
  
  WtloginHelper$HelperThread(WtloginHelper paramWtloginHelper1, WtloginHelper paramWtloginHelper2, Handler paramHandler, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong1, long paramLong2, int paramInt, String paramString)
  {
    this.mHelper = paramWtloginHelper2;
    this.mHandler = paramHandler;
    this.mST1 = paramArrayOfByte1;
    this.mST1Key = paramArrayOfByte2;
    this.mUIN = paramLong1;
    this.mDwAppid = paramLong2;
    this.mReportErrType = paramInt;
    setName("Wtlogin_" + paramString);
  }
  
  WtloginHelper$HelperThread(WtloginHelper paramWtloginHelper1, WtloginHelper paramWtloginHelper2, Handler paramHandler, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong1, long paramLong2, String paramString)
  {
    this.mHelper = paramWtloginHelper2;
    this.mHandler = paramHandler;
    this.mST1 = paramArrayOfByte1;
    this.mST1Key = paramArrayOfByte2;
    this.mUIN = paramLong1;
    this.mDwAppid = paramLong2;
    setName("Wtlogin_" + paramString);
  }
  
  private void quitSelfLooper()
  {
    try
    {
      if (this.isSelfLooper)
      {
        Looper localLooper = Looper.myLooper();
        if (localLooper != null) {
          localLooper.quit();
        }
        this.mHandler = null;
      }
      return;
    }
    catch (Exception localException)
    {
      util.printException(localException, "");
    }
  }
  
  private void saveContextDataIntoExtentMap(async_context paramasync_context, int paramInt)
  {
    if ((paramInt == 0) && (paramasync_context.tlv528 != null))
    {
      util.LOGI("context from seq " + this.mUserSigInfo._seqence + " tlv528 length " + paramasync_context.tlv528.get_data_len(), this.mUserAccount);
      this.mUserSigInfo.loginResultTLVMap.put(new Integer(1320), paramasync_context.tlv528);
    }
    if ((paramInt == 0) && (paramasync_context.tlv530 != null))
    {
      util.LOGI("context from seq " + this.mUserSigInfo._seqence + " tlv530 length " + paramasync_context.tlv530.get_data_len(), this.mUserAccount);
      this.mUserSigInfo.loginResultTLVMap.put(new Integer(1328), paramasync_context.tlv530);
    }
    if ((paramInt == 0) && (paramasync_context.tlv113 != null))
    {
      util.LOGI("context from seq " + this.mUserSigInfo._seqence + " tlv113 length " + paramasync_context.tlv113.get_data_len(), this.mUserAccount);
      this.mUserSigInfo.loginResultTLVMap.put(new Integer(275), paramasync_context.tlv113);
    }
  }
  
  public void RunReq(int paramInt)
  {
    this.mReqType = paramInt;
    if (this.mReqType == 7)
    {
      start();
      return;
    }
    synchronized (WtloginHelper.__sync_top)
    {
      Timer localTimer = new Timer();
      WtloginHelper.HelperThread.1 local1 = new WtloginHelper.HelperThread.1(this);
      paramInt = WtloginHelper.__top;
      WtloginHelper.__top = paramInt + 1;
      localTimer.schedule(local1, paramInt * 500);
      util.LOGI("push queue " + WtloginHelper.__top, "");
      return;
    }
  }
  
  public void run()
  {
    if ((WtloginHelper.access$100(this.mHelper) == null) && (this.mPromise == null)) {}
    for (;;)
    {
      return;
      int k = WtloginHelper.access$200(this.mHelper).s;
      boolean bool;
      if (this.mHandler == null)
      {
        bool = true;
        label39:
        this.isSelfLooper = bool;
        if (this.isSelfLooper)
        {
          Looper.prepare();
          this.mHandler = WtloginHelper.access$300(this.this$0);
        }
      }
      try
      {
        if (this.mHandler == null) {
          throw new Exception("Handler should not be null!");
        }
      }
      catch (Exception localException)
      {
        util.printException(localException, "");
        this.mHandler.post(new WtloginHelper.HelperThread.18(this, k));
        if (this.isSelfLooper) {
          Looper.loop();
        }
        if (this.mReqType == 7) {
          continue;
        }
        synchronized (WtloginHelper.__sync_top)
        {
          if (WtloginHelper.__top > 0) {
            WtloginHelper.__top -= 1;
          }
          util.LOGI("pop queue " + WtloginHelper.__top, "");
          return;
        }
        bool = false;
        break label39;
        if (this.mReqType == 0)
        {
          i = WtloginHelper.access$400(this.mHelper, this.mUserAccount, this.mDwAppid, this.mDwMainSigMap, this.mDwSubDstAppid, this.mDwSubAppidList, this.mPwdMd5, this.mUserPasswd, this.mUserSigInfo, this.mST, this.mIsSmslogin, 1);
          this.mHandler.post(new WtloginHelper.HelperThread.2(this, k, i));
        }
        for (;;)
        {
          if (this.isSelfLooper) {
            Looper.loop();
          }
          if (this.mReqType == 7) {
            break;
          }
          synchronized (WtloginHelper.__sync_top)
          {
            if (WtloginHelper.__top > 0) {
              WtloginHelper.__top -= 1;
            }
            util.LOGI("pop queue " + WtloginHelper.__top, "");
            return;
          }
          if (this.mReqType != 1) {
            break label472;
          }
          i = WtloginHelper.access$700(this.mHelper, this.mUserAccount, this.mUserSigInfo, 1);
          this.mHandler.post(new WtloginHelper.HelperThread.3(this, k, i));
        }
      }
      finally
      {
        for (;;)
        {
          int i;
          if (this.isSelfLooper) {
            Looper.loop();
          }
          if (this.mReqType != 7) {}
          synchronized (WtloginHelper.__sync_top)
          {
            if (WtloginHelper.__top > 0) {
              WtloginHelper.__top -= 1;
            }
            util.LOGI("pop queue " + WtloginHelper.__top, "");
            throw localObject4;
            label472:
            if (this.mReqType == 2)
            {
              i = WtloginHelper.access$800(this.mHelper, this.mUserAccount, this.mUserInput, this.mUserSigInfo, this.mST, 1);
              this.mHandler.post(new WtloginHelper.HelperThread.4(this, k, i));
              continue;
            }
            if (this.mReqType == 3)
            {
              i = WtloginHelper.access$900(this.mHelper, this.mUserAccount, this.mSmsAppid, this.mUserSigInfo, 1);
              this.mHandler.post(new WtloginHelper.HelperThread.5(this, k, i));
              continue;
            }
            if (this.mReqType == 4)
            {
              i = WtloginHelper.access$1000(this.mHelper, this.mUserAccount, this.mUserInput, this.mUserSigInfo, this.mST, 1);
              this.mHandler.post(new WtloginHelper.HelperThread.6(this, k, i));
              continue;
            }
            if (this.mReqType == 5) {
              synchronized (WtloginHelper.GET_ST_WITHOUT_PASSWORD_LOCK)
              {
                int j = WtloginHelper.access$1100(this.mHelper, this.mUserAccount, this.mDwAppid, this.mDwDstAppid, this.mDwDstAppPri, this.mDwMainSigMap, this.mDwSubDstAppid, this.mDwDstSubAppidList, this.mUserSigInfo, this.mST, this.mReserve, 1, this.mPromise);
                i = j;
                if (j == 20)
                {
                  util.LOGI("retry ret=0x14", "");
                  i = WtloginHelper.access$1100(this.mHelper, this.mUserAccount, this.mDwAppid, this.mDwDstAppid, this.mDwDstAppPri, this.mDwMainSigMap, this.mDwSubDstAppid, this.mDwDstSubAppidList, this.mUserSigInfo, this.mST, this.mReserve, 1, this.mPromise);
                }
                this.mHandler.post(new WtloginHelper.HelperThread.7(this, k, i));
              }
            }
            if (this.mReqType == 6)
            {
              i = WtloginHelper.access$1300(this.mHelper, this.mUserAccount, this.mAppid1, this.mSubAppid1, this.mDwMainSigMap, this.mAppName2, this.mSsoVer2, this.mAppid2, this.mSubAppid2, this.mAppVer2, this.mAppSign2, this.mUserSigInfo, this.mFastLoginInfo, 1);
              this.mHandler.post(new WtloginHelper.HelperThread.8(this, k, i));
              continue;
            }
            if (this.mReqType == 7)
            {
              WtloginHelper.access$1400(this.mHelper, 1, this.mST1, this.mST1Key, this.mUIN, this.mDwAppid);
              continue;
            }
            if (this.mReqType == 9)
            {
              i = this.mHelper.RequestTransport(1, this.mEncrypt, this.mUserAccount, this.mDwAppid, this.mRole, this.mReqContext, this.mUserSigInfo);
              this.mHandler.post(new WtloginHelper.HelperThread.9(this, i, k));
              continue;
            }
            if (this.mReqType == 10)
            {
              i = this.mHelper.RequestTransportMsf(1, this.mEncrypt, this.mUserAccount, this.mDwAppid, this.mRole, this.mReqContext);
              this.mHandler.post(new WtloginHelper.HelperThread.10(this, k, i));
              continue;
            }
            if (this.mReqType == 12)
            {
              i = WtloginHelper.access$1800(this.mHelper, this.mAppid1, this.mSubAppid1, this.mUserAccount, this.mExtraFlag, this.mExtraUin, this.mUserSigInfo, 1);
              this.mHandler.post(new WtloginHelper.HelperThread.11(this, k, i));
              continue;
            }
            if (this.mReqType == 13)
            {
              i = WtloginHelper.access$1900(this.mHelper, this.mUserAccount, this.mMsgCode, this.mUserSigInfo, 1);
              this.mHandler.post(new WtloginHelper.HelperThread.12(this, k, i));
              continue;
            }
            if (this.mReqType == 14)
            {
              i = WtloginHelper.access$2000(this.mHelper, this.mUserAccount, this.mUserSigInfo, 1);
              this.mHandler.post(new WtloginHelper.HelperThread.13(this, k, i));
              continue;
            }
            if (this.mReqType == 8)
            {
              WtloginHelper.access$2100(this.mHelper, 1, this.mST1, this.mST1Key, this.mUIN, this.mDwAppid, this.mReportErrType);
              continue;
            }
            if (this.mReqType == 15)
            {
              i = WtloginHelper.access$2200(this.mHelper, this.mUserAccount, this.quickLoginParam, 1);
              this.mHandler.post(new WtloginHelper.HelperThread.14(this, k, i));
              continue;
            }
            if (this.mReqType == 16)
            {
              i = WtloginHelper.access$2300(this.mHelper, this.mUserAccount, this.ptSig, this.quickLoginParam, 1);
              this.mHandler.post(new WtloginHelper.HelperThread.15(this, k, i));
              continue;
            }
            if (this.mReqType == 17)
            {
              i = WtloginHelper.access$2400(this.mHelper, this.mUserAccount, this.mDwAppid, this.mDwSubDstAppid, this.mDwMainSigMap, this.mUserSigInfo, 1);
              this.mHandler.post(new WtloginHelper.HelperThread.16(this, k, i));
              continue;
            }
            if (this.mReqType != 18) {
              continue;
            }
            i = this.mHelper.quickLoginByWeChat(this.mWxAppid, this.weChatCode, this.quickLoginParam, 1);
            this.mHandler.post(new WtloginHelper.HelperThread.17(this, k, i));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.WtloginHelper.HelperThread
 * JD-Core Version:    0.7.0.1
 */