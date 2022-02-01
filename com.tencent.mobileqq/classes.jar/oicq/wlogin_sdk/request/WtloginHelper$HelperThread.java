package oicq.wlogin_sdk.request;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.Timer;
import oicq.wlogin_sdk.tlv_type.tlv_t;
import oicq.wlogin_sdk.tlv_type.tlv_t104;
import oicq.wlogin_sdk.tlv_type.tlv_t543;
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
  byte[] mExtraData;
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
    paramWtloginHelper1 = new StringBuilder();
    paramWtloginHelper1.append("Wtlogin_");
    paramWtloginHelper1.append(paramString2);
    setName(paramWtloginHelper1.toString());
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
    paramWtloginHelper1 = new StringBuilder();
    paramWtloginHelper1.append("Wtlogin_");
    paramWtloginHelper1.append(paramString2);
    setName(paramWtloginHelper1.toString());
  }
  
  WtloginHelper$HelperThread(WtloginHelper paramWtloginHelper1, WtloginHelper paramWtloginHelper2, Handler paramHandler, long paramLong1, long paramLong2, int paramInt, WUserSigInfo paramWUserSigInfo, String paramString)
  {
    this.mHelper = paramWtloginHelper2;
    this.mHandler = paramHandler;
    this.mAppid1 = paramLong1;
    this.mSubAppid1 = paramLong2;
    this.mUserSigInfo = paramWUserSigInfo;
    this.mDwMainSigMap = paramInt;
    paramWtloginHelper1 = new StringBuilder();
    paramWtloginHelper1.append("Wtlogin_");
    paramWtloginHelper1.append(paramString);
    setName(paramWtloginHelper1.toString());
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
    paramWtloginHelper1 = new StringBuilder();
    paramWtloginHelper1.append("Wtlogin_");
    paramWtloginHelper1.append(paramString2);
    setName(paramWtloginHelper1.toString());
  }
  
  WtloginHelper$HelperThread(WtloginHelper paramWtloginHelper1, WtloginHelper paramWtloginHelper2, Handler paramHandler, long paramLong, String paramString)
  {
    this.mHelper = paramWtloginHelper2;
    this.mHandler = paramHandler;
    this.mUIN = paramLong;
    paramWtloginHelper1 = new StringBuilder();
    paramWtloginHelper1.append("Wtlogin_");
    paramWtloginHelper1.append(paramString);
    setName(paramWtloginHelper1.toString());
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
    paramWtloginHelper1 = new StringBuilder();
    paramWtloginHelper1.append("Wtlogin_");
    paramWtloginHelper1.append(paramString2);
    setName(paramWtloginHelper1.toString());
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
    paramWtloginHelper1 = new StringBuilder();
    paramWtloginHelper1.append("Wtlogin_");
    paramWtloginHelper1.append(paramString3);
    setName(paramWtloginHelper1.toString());
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
    paramWtloginHelper1 = new StringBuilder();
    paramWtloginHelper1.append("Wtlogin_");
    paramWtloginHelper1.append(paramString2);
    setName(paramWtloginHelper1.toString());
  }
  
  WtloginHelper$HelperThread(WtloginHelper paramWtloginHelper1, WtloginHelper paramWtloginHelper2, Handler paramHandler, String paramString1, long paramLong, WUserSigInfo paramWUserSigInfo, byte[] paramArrayOfByte, String paramString2)
  {
    this.mHelper = paramWtloginHelper2;
    this.mHandler = paramHandler;
    this.mUserAccount = paramString1;
    this.mSmsAppid = paramLong;
    this.mUserSigInfo = paramWUserSigInfo;
    this.mExtraData = paramArrayOfByte;
    paramWtloginHelper1 = new StringBuilder();
    paramWtloginHelper1.append("Wtlogin_");
    paramWtloginHelper1.append(paramString2);
    setName(paramWtloginHelper1.toString());
  }
  
  WtloginHelper$HelperThread(WtloginHelper paramWtloginHelper1, WtloginHelper paramWtloginHelper2, Handler paramHandler, String paramString1, String paramString2, WUserSigInfo paramWUserSigInfo, String paramString3)
  {
    this.mHelper = paramWtloginHelper2;
    this.mHandler = paramHandler;
    this.mUserAccount = paramString1;
    this.mMsgCode = paramString2;
    this.mUserSigInfo = paramWUserSigInfo;
    paramWtloginHelper1 = new StringBuilder();
    paramWtloginHelper1.append("Wtlogin_");
    paramWtloginHelper1.append(paramString3);
    setName(paramWtloginHelper1.toString());
  }
  
  WtloginHelper$HelperThread(WtloginHelper paramWtloginHelper1, WtloginHelper paramWtloginHelper2, Handler paramHandler, String paramString1, String paramString2, WtloginHelper.QuickLoginParam paramQuickLoginParam, String paramString3)
  {
    this.mHelper = paramWtloginHelper2;
    this.mHandler = paramHandler;
    this.mUserAccount = paramString1;
    this.ptSig = paramString2;
    this.quickLoginParam = paramQuickLoginParam;
    this.mUserSigInfo = paramQuickLoginParam.userSigInfo;
    paramWtloginHelper1 = new StringBuilder();
    paramWtloginHelper1.append("Wtlogin_");
    paramWtloginHelper1.append(paramString3);
    setName(paramWtloginHelper1.toString());
  }
  
  WtloginHelper$HelperThread(WtloginHelper paramWtloginHelper1, WtloginHelper paramWtloginHelper2, Handler paramHandler, String paramString1, WUserSigInfo paramWUserSigInfo, String paramString2)
  {
    this.mHelper = paramWtloginHelper2;
    this.mHandler = paramHandler;
    this.mUserAccount = paramString1;
    this.mUserSigInfo = paramWUserSigInfo;
    paramWtloginHelper1 = new StringBuilder();
    paramWtloginHelper1.append("Wtlogin_");
    paramWtloginHelper1.append(paramString2);
    setName(paramWtloginHelper1.toString());
  }
  
  WtloginHelper$HelperThread(WtloginHelper paramWtloginHelper1, WtloginHelper paramWtloginHelper2, Handler paramHandler, String paramString1, WtloginHelper.QuickLoginParam paramQuickLoginParam, String paramString2)
  {
    this.mHelper = paramWtloginHelper2;
    this.mHandler = paramHandler;
    this.mUserAccount = paramString1;
    this.quickLoginParam = paramQuickLoginParam;
    this.mUserSigInfo = paramQuickLoginParam.userSigInfo;
    paramWtloginHelper1 = new StringBuilder();
    paramWtloginHelper1.append("Wtlogin_");
    paramWtloginHelper1.append(paramString2);
    setName(paramWtloginHelper1.toString());
  }
  
  WtloginHelper$HelperThread(WtloginHelper paramWtloginHelper1, WtloginHelper paramWtloginHelper2, Handler paramHandler, String paramString1, byte[] paramArrayOfByte, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte1, String paramString2)
  {
    this.mHelper = paramWtloginHelper2;
    this.mHandler = paramHandler;
    this.mUserAccount = paramString1;
    this.mUserInput = paramArrayOfByte;
    this.mUserSigInfo = paramWUserSigInfo;
    this.mST = paramArrayOfByte1;
    paramWtloginHelper1 = new StringBuilder();
    paramWtloginHelper1.append("Wtlogin_");
    paramWtloginHelper1.append(paramString2);
    setName(paramWtloginHelper1.toString());
  }
  
  WtloginHelper$HelperThread(WtloginHelper paramWtloginHelper1, WtloginHelper paramWtloginHelper2, Handler paramHandler, String paramString1, byte[] paramArrayOfByte1, WUserSigInfo paramWUserSigInfo, byte[][] paramArrayOfByte, byte[] paramArrayOfByte2, String paramString2)
  {
    this.mHelper = paramWtloginHelper2;
    this.mHandler = paramHandler;
    this.mUserAccount = paramString1;
    this.mUserInput = paramArrayOfByte1;
    this.mUserSigInfo = paramWUserSigInfo;
    this.mST = paramArrayOfByte;
    this.mExtraData = paramArrayOfByte2;
    paramWtloginHelper1 = new StringBuilder();
    paramWtloginHelper1.append("Wtlogin_");
    paramWtloginHelper1.append(paramString2);
    setName(paramWtloginHelper1.toString());
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
    paramWtloginHelper1 = new StringBuilder();
    paramWtloginHelper1.append("Wtlogin_");
    paramWtloginHelper1.append(paramString2);
    setName(paramWtloginHelper1.toString());
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
    paramWtloginHelper1 = new StringBuilder();
    paramWtloginHelper1.append("Wtlogin_");
    paramWtloginHelper1.append(paramString);
    setName(paramWtloginHelper1.toString());
  }
  
  WtloginHelper$HelperThread(WtloginHelper paramWtloginHelper1, WtloginHelper paramWtloginHelper2, Handler paramHandler, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong1, long paramLong2, String paramString)
  {
    this.mHelper = paramWtloginHelper2;
    this.mHandler = paramHandler;
    this.mST1 = paramArrayOfByte1;
    this.mST1Key = paramArrayOfByte2;
    this.mUIN = paramLong1;
    this.mDwAppid = paramLong2;
    paramWtloginHelper1 = new StringBuilder();
    paramWtloginHelper1.append("Wtlogin_");
    paramWtloginHelper1.append(paramString);
    setName(paramWtloginHelper1.toString());
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
        return;
      }
    }
    catch (Exception localException)
    {
      util.printException(localException, "");
    }
  }
  
  private void saveContextCommonDataIntoExtentMap(async_context paramasync_context)
  {
    StringBuilder localStringBuilder;
    if (paramasync_context._t543 != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("context from seq ");
      localStringBuilder.append(this.mUserSigInfo._seqence);
      localStringBuilder.append(" tlv543 length ");
      localStringBuilder.append(paramasync_context._t543.get_data_len());
      util.LOGI(localStringBuilder.toString(), this.mUserAccount);
      this.mUserSigInfo.loginResultTLVMap.put(new Integer(1347), paramasync_context._t543);
    }
    if (paramasync_context.tlv543In119 != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("context from seq ");
      localStringBuilder.append(this.mUserSigInfo._seqence);
      localStringBuilder.append(" tlv543In119 length ");
      localStringBuilder.append(paramasync_context.tlv543In119.get_data_len());
      util.LOGI(localStringBuilder.toString(), this.mUserAccount);
      this.mUserSigInfo.loginResultTLVMap.put(new Integer(1676611), paramasync_context.tlv543In119);
    }
  }
  
  private void saveContextDataIntoExtentMap(async_context paramasync_context, int paramInt)
  {
    StringBuilder localStringBuilder;
    if ((paramInt == 0) && (paramasync_context.tlv528 != null))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("context from seq ");
      localStringBuilder.append(this.mUserSigInfo._seqence);
      localStringBuilder.append(" tlv528 length ");
      localStringBuilder.append(paramasync_context.tlv528.get_data_len());
      util.LOGI(localStringBuilder.toString(), this.mUserAccount);
      this.mUserSigInfo.loginResultTLVMap.put(new Integer(1320), paramasync_context.tlv528);
    }
    if ((paramInt == 0) && (paramasync_context.tlv530 != null))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("context from seq ");
      localStringBuilder.append(this.mUserSigInfo._seqence);
      localStringBuilder.append(" tlv530 length ");
      localStringBuilder.append(paramasync_context.tlv530.get_data_len());
      util.LOGI(localStringBuilder.toString(), this.mUserAccount);
      this.mUserSigInfo.loginResultTLVMap.put(new Integer(1328), paramasync_context.tlv530);
    }
    if ((paramInt == 0) && (paramasync_context.tlv113 != null))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("context from seq ");
      localStringBuilder.append(this.mUserSigInfo._seqence);
      localStringBuilder.append(" tlv113 length ");
      localStringBuilder.append(paramasync_context.tlv113.get_data_len());
      util.LOGI(localStringBuilder.toString(), this.mUserAccount);
      this.mUserSigInfo.loginResultTLVMap.put(new Integer(275), paramasync_context.tlv113);
    }
  }
  
  private void saveContextSigSessionDataIntoExtentMap(async_context paramasync_context)
  {
    if (paramasync_context._t104 != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("context from seq ");
      localStringBuilder.append(this.mUserSigInfo._seqence);
      localStringBuilder.append(" tlv104 length ");
      localStringBuilder.append(paramasync_context._t104.get_data_len());
      util.LOGI(localStringBuilder.toString(), this.mUserAccount);
      this.mUserSigInfo.loginResultTLVMap.put(new Integer(260), paramasync_context._t104);
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
      Object localObject2 = new Timer();
      WtloginHelper.HelperThread.1 local1 = new WtloginHelper.HelperThread.1(this);
      paramInt = WtloginHelper.__top;
      WtloginHelper.__top = paramInt + 1;
      ((Timer)localObject2).schedule(local1, paramInt * 500);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("push queue ");
      ((StringBuilder)localObject2).append(WtloginHelper.__top);
      util.LOGI(((StringBuilder)localObject2).toString(), "");
      return;
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 89	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
    //   4: invokestatic 358	oicq/wlogin_sdk/request/WtloginHelper:access$200	(Loicq/wlogin_sdk/request/WtloginHelper;)Loicq/wlogin_sdk/request/WtloginListener;
    //   7: ifnonnull +11 -> 18
    //   10: aload_0
    //   11: getfield 189	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mPromise	Loicq/wlogin_sdk/request/WtTicketPromise;
    //   14: ifnonnull +4 -> 18
    //   17: return
    //   18: aload_0
    //   19: getfield 89	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
    //   22: invokestatic 362	oicq/wlogin_sdk/request/WtloginHelper:access$300	(Loicq/wlogin_sdk/request/WtloginHelper;)Loicq/wlogin_sdk/request/t;
    //   25: getfield 367	oicq/wlogin_sdk/request/t:t	I
    //   28: istore_1
    //   29: aload_0
    //   30: getfield 91	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
    //   33: ifnonnull +9 -> 42
    //   36: iconst_1
    //   37: istore 4
    //   39: goto +6 -> 45
    //   42: iconst_0
    //   43: istore 4
    //   45: aload_0
    //   46: iload 4
    //   48: putfield 77	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:isSelfLooper	Z
    //   51: aload_0
    //   52: getfield 77	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:isSelfLooper	Z
    //   55: ifeq +17 -> 72
    //   58: invokestatic 370	android/os/Looper:prepare	()V
    //   61: aload_0
    //   62: aload_0
    //   63: getfield 72	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:this$0	Loicq/wlogin_sdk/request/WtloginHelper;
    //   66: invokestatic 374	oicq/wlogin_sdk/request/WtloginHelper:access$400	(Loicq/wlogin_sdk/request/WtloginHelper;)Landroid/os/Handler;
    //   69: putfield 91	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
    //   72: aload_0
    //   73: getfield 91	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
    //   76: ifnull +1468 -> 1544
    //   79: aload_0
    //   80: getfield 328	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
    //   83: ifne +73 -> 156
    //   86: aload_0
    //   87: getfield 89	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
    //   90: aload_0
    //   91: getfield 97	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
    //   94: aload_0
    //   95: getfield 99	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwAppid	J
    //   98: aload_0
    //   99: getfield 126	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwMainSigMap	I
    //   102: aload_0
    //   103: getfield 133	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwSubDstAppid	J
    //   106: aload_0
    //   107: getfield 136	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwSubAppidList	[J
    //   110: aload_0
    //   111: getfield 138	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mPwdMd5	Z
    //   114: aload_0
    //   115: getfield 140	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserPasswd	Ljava/lang/String;
    //   118: aload_0
    //   119: getfield 79	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserSigInfo	Loicq/wlogin_sdk/request/WUserSigInfo;
    //   122: aload_0
    //   123: getfield 142	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mST	[[B
    //   126: aload_0
    //   127: getfield 81	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mIsSmslogin	Z
    //   130: iconst_1
    //   131: invokestatic 378	oicq/wlogin_sdk/request/WtloginHelper:access$500	(Loicq/wlogin_sdk/request/WtloginHelper;Ljava/lang/String;JIJ[JZLjava/lang/String;Loicq/wlogin_sdk/request/WUserSigInfo;[[BZI)I
    //   134: istore_2
    //   135: aload_0
    //   136: getfield 91	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
    //   139: new 380	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$2
    //   142: dup
    //   143: aload_0
    //   144: iload_1
    //   145: iload_2
    //   146: invokespecial 383	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$2:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
    //   149: invokevirtual 389	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   152: pop
    //   153: goto +1301 -> 1454
    //   156: aload_0
    //   157: getfield 328	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
    //   160: iconst_1
    //   161: if_icmpne +41 -> 202
    //   164: aload_0
    //   165: getfield 89	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
    //   168: aload_0
    //   169: getfield 97	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
    //   172: aload_0
    //   173: getfield 79	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserSigInfo	Loicq/wlogin_sdk/request/WUserSigInfo;
    //   176: iconst_1
    //   177: invokestatic 393	oicq/wlogin_sdk/request/WtloginHelper:access$900	(Loicq/wlogin_sdk/request/WtloginHelper;Ljava/lang/String;Loicq/wlogin_sdk/request/WUserSigInfo;I)I
    //   180: istore_2
    //   181: aload_0
    //   182: getfield 91	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
    //   185: new 395	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$3
    //   188: dup
    //   189: aload_0
    //   190: iload_1
    //   191: iload_2
    //   192: invokespecial 396	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$3:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
    //   195: invokevirtual 389	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   198: pop
    //   199: goto +1255 -> 1454
    //   202: aload_0
    //   203: getfield 328	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
    //   206: iconst_2
    //   207: if_icmpne +49 -> 256
    //   210: aload_0
    //   211: getfield 89	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
    //   214: aload_0
    //   215: getfield 97	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
    //   218: aload_0
    //   219: getfield 180	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserInput	[B
    //   222: aload_0
    //   223: getfield 79	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserSigInfo	Loicq/wlogin_sdk/request/WUserSigInfo;
    //   226: aload_0
    //   227: getfield 142	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mST	[[B
    //   230: iconst_1
    //   231: invokestatic 400	oicq/wlogin_sdk/request/WtloginHelper:access$1000	(Loicq/wlogin_sdk/request/WtloginHelper;Ljava/lang/String;[BLoicq/wlogin_sdk/request/WUserSigInfo;[[BI)I
    //   234: istore_2
    //   235: aload_0
    //   236: getfield 91	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
    //   239: new 402	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$4
    //   242: dup
    //   243: aload_0
    //   244: iload_1
    //   245: iload_2
    //   246: invokespecial 403	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$4:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
    //   249: invokevirtual 389	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   252: pop
    //   253: goto +1201 -> 1454
    //   256: aload_0
    //   257: getfield 328	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
    //   260: iconst_3
    //   261: if_icmpne +49 -> 310
    //   264: aload_0
    //   265: getfield 89	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
    //   268: aload_0
    //   269: getfield 97	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
    //   272: aload_0
    //   273: getfield 160	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mSmsAppid	J
    //   276: aload_0
    //   277: getfield 79	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserSigInfo	Loicq/wlogin_sdk/request/WUserSigInfo;
    //   280: aload_0
    //   281: getfield 162	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mExtraData	[B
    //   284: iconst_1
    //   285: invokestatic 407	oicq/wlogin_sdk/request/WtloginHelper:access$1100	(Loicq/wlogin_sdk/request/WtloginHelper;Ljava/lang/String;JLoicq/wlogin_sdk/request/WUserSigInfo;[BI)I
    //   288: istore_2
    //   289: aload_0
    //   290: getfield 91	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
    //   293: new 409	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$5
    //   296: dup
    //   297: aload_0
    //   298: iload_1
    //   299: iload_2
    //   300: invokespecial 410	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$5:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
    //   303: invokevirtual 389	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   306: pop
    //   307: goto +1147 -> 1454
    //   310: aload_0
    //   311: getfield 328	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
    //   314: iconst_4
    //   315: if_icmpne +53 -> 368
    //   318: aload_0
    //   319: getfield 89	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
    //   322: aload_0
    //   323: getfield 97	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
    //   326: aload_0
    //   327: getfield 180	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserInput	[B
    //   330: aload_0
    //   331: getfield 79	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserSigInfo	Loicq/wlogin_sdk/request/WUserSigInfo;
    //   334: aload_0
    //   335: getfield 142	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mST	[[B
    //   338: aload_0
    //   339: getfield 162	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mExtraData	[B
    //   342: iconst_1
    //   343: invokestatic 414	oicq/wlogin_sdk/request/WtloginHelper:access$1200	(Loicq/wlogin_sdk/request/WtloginHelper;Ljava/lang/String;[BLoicq/wlogin_sdk/request/WUserSigInfo;[[B[BI)I
    //   346: istore_2
    //   347: aload_0
    //   348: getfield 91	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
    //   351: new 416	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$6
    //   354: dup
    //   355: aload_0
    //   356: iload_1
    //   357: iload_2
    //   358: invokespecial 417	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$6:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
    //   361: invokevirtual 389	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   364: pop
    //   365: goto +1089 -> 1454
    //   368: aload_0
    //   369: getfield 328	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
    //   372: iconst_5
    //   373: if_icmpne +243 -> 616
    //   376: getstatic 420	oicq/wlogin_sdk/request/WtloginHelper:GET_ST_WITHOUT_PASSWORD_LOCK	Ljava/lang/Object;
    //   379: astore 16
    //   381: aload 16
    //   383: monitorenter
    //   384: aload_0
    //   385: getfield 89	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
    //   388: astore 15
    //   390: aload_0
    //   391: getfield 97	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
    //   394: astore 17
    //   396: aload_0
    //   397: getfield 99	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwAppid	J
    //   400: lstore 5
    //   402: aload_0
    //   403: getfield 191	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwDstAppid	J
    //   406: lstore 7
    //   408: aload_0
    //   409: getfield 193	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwDstAppPri	J
    //   412: lstore 9
    //   414: aload_0
    //   415: getfield 126	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwMainSigMap	I
    //   418: istore_2
    //   419: aload_0
    //   420: getfield 133	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwSubDstAppid	J
    //   423: lstore 11
    //   425: aload_0
    //   426: getfield 195	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwDstSubAppidList	[J
    //   429: astore 18
    //   431: aload 15
    //   433: aload 17
    //   435: lload 5
    //   437: lload 7
    //   439: lload 9
    //   441: iload_2
    //   442: lload 11
    //   444: aload 18
    //   446: aload_0
    //   447: getfield 79	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserSigInfo	Loicq/wlogin_sdk/request/WUserSigInfo;
    //   450: aload_0
    //   451: getfield 142	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mST	[[B
    //   454: aload_0
    //   455: getfield 197	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReserve	[[B
    //   458: iconst_1
    //   459: aload_0
    //   460: getfield 189	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mPromise	Loicq/wlogin_sdk/request/WtTicketPromise;
    //   463: invokestatic 424	oicq/wlogin_sdk/request/WtloginHelper:access$1400	(Loicq/wlogin_sdk/request/WtloginHelper;Ljava/lang/String;JJJIJ[JLoicq/wlogin_sdk/request/WUserSigInfo;[[B[[BILoicq/wlogin_sdk/request/WtTicketPromise;)I
    //   466: istore_3
    //   467: iload_3
    //   468: istore_2
    //   469: iload_2
    //   470: bipush 20
    //   472: if_icmpne +1316 -> 1788
    //   475: ldc_w 426
    //   478: ldc 239
    //   480: invokestatic 276	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   483: aload_0
    //   484: getfield 89	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
    //   487: aload_0
    //   488: getfield 97	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
    //   491: aload_0
    //   492: getfield 99	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwAppid	J
    //   495: aload_0
    //   496: getfield 191	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwDstAppid	J
    //   499: aload_0
    //   500: getfield 193	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwDstAppPri	J
    //   503: aload_0
    //   504: getfield 126	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwMainSigMap	I
    //   507: aload_0
    //   508: getfield 133	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwSubDstAppid	J
    //   511: aload_0
    //   512: getfield 195	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwDstSubAppidList	[J
    //   515: aload_0
    //   516: getfield 79	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserSigInfo	Loicq/wlogin_sdk/request/WUserSigInfo;
    //   519: aload_0
    //   520: getfield 142	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mST	[[B
    //   523: aload_0
    //   524: getfield 197	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReserve	[[B
    //   527: iconst_1
    //   528: aload_0
    //   529: getfield 189	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mPromise	Loicq/wlogin_sdk/request/WtTicketPromise;
    //   532: invokestatic 424	oicq/wlogin_sdk/request/WtloginHelper:access$1400	(Loicq/wlogin_sdk/request/WtloginHelper;Ljava/lang/String;JJJIJ[JLoicq/wlogin_sdk/request/WUserSigInfo;[[B[[BILoicq/wlogin_sdk/request/WtTicketPromise;)I
    //   535: istore_2
    //   536: goto +3 -> 539
    //   539: iload_2
    //   540: ifne +26 -> 566
    //   543: iload_3
    //   544: bipush 20
    //   546: if_icmpne +20 -> 566
    //   549: new 428	oicq/wlogin_sdk/report/event/b
    //   552: dup
    //   553: ldc_w 430
    //   556: ldc 239
    //   558: ldc 239
    //   560: invokespecial 433	oicq/wlogin_sdk/report/event/b:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   563: invokestatic 439	oicq/wlogin_sdk/report/event/c:a	(Loicq/wlogin_sdk/report/event/b;)V
    //   566: aload 16
    //   568: monitorexit
    //   569: aload_0
    //   570: getfield 91	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
    //   573: astore 15
    //   575: iload_1
    //   576: istore_3
    //   577: iload_3
    //   578: istore_1
    //   579: aload 15
    //   581: new 441	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$7
    //   584: dup
    //   585: aload_0
    //   586: iload_3
    //   587: iload_2
    //   588: invokespecial 442	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$7:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
    //   591: invokevirtual 389	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   594: pop
    //   595: goto +859 -> 1454
    //   598: astore 15
    //   600: goto +967 -> 1567
    //   603: astore 15
    //   605: goto +5 -> 610
    //   608: astore 15
    //   610: aload 16
    //   612: monitorexit
    //   613: aload 15
    //   615: athrow
    //   616: iload_1
    //   617: istore_2
    //   618: iload_2
    //   619: istore_1
    //   620: aload_0
    //   621: getfield 328	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
    //   624: bipush 6
    //   626: if_icmpne +139 -> 765
    //   629: iload_2
    //   630: istore_1
    //   631: aload_0
    //   632: getfield 89	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
    //   635: astore 15
    //   637: iload_2
    //   638: istore_1
    //   639: aload_0
    //   640: getfield 97	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
    //   643: astore 16
    //   645: iload_2
    //   646: istore_1
    //   647: aload_0
    //   648: getfield 122	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mAppid1	J
    //   651: lstore 5
    //   653: iload_2
    //   654: istore_1
    //   655: aload_0
    //   656: getfield 124	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mSubAppid1	J
    //   659: lstore 7
    //   661: iload_2
    //   662: istore_1
    //   663: aload_0
    //   664: getfield 126	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwMainSigMap	I
    //   667: istore_3
    //   668: iload_2
    //   669: istore_1
    //   670: aload_0
    //   671: getfield 145	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mAppName2	[B
    //   674: astore 17
    //   676: iload_2
    //   677: istore_1
    //   678: aload_0
    //   679: getfield 147	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mSsoVer2	J
    //   682: lstore 9
    //   684: iload_2
    //   685: istore_1
    //   686: aload_0
    //   687: getfield 149	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mAppid2	J
    //   690: lstore 11
    //   692: iload_2
    //   693: istore_1
    //   694: aload_0
    //   695: getfield 151	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mSubAppid2	J
    //   698: lstore 13
    //   700: aload 15
    //   702: aload 16
    //   704: lload 5
    //   706: lload 7
    //   708: iload_3
    //   709: aload 17
    //   711: lload 9
    //   713: lload 11
    //   715: lload 13
    //   717: aload_0
    //   718: getfield 153	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mAppVer2	[B
    //   721: aload_0
    //   722: getfield 155	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mAppSign2	[B
    //   725: aload_0
    //   726: getfield 79	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserSigInfo	Loicq/wlogin_sdk/request/WUserSigInfo;
    //   729: aload_0
    //   730: getfield 157	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mFastLoginInfo	Loicq/wlogin_sdk/request/WFastLoginInfo;
    //   733: iconst_1
    //   734: invokestatic 446	oicq/wlogin_sdk/request/WtloginHelper:access$1600	(Loicq/wlogin_sdk/request/WtloginHelper;Ljava/lang/String;JJI[BJJJ[B[BLoicq/wlogin_sdk/request/WUserSigInfo;Loicq/wlogin_sdk/request/WFastLoginInfo;I)I
    //   737: istore_3
    //   738: aload_0
    //   739: getfield 91	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
    //   742: astore 15
    //   744: iload_2
    //   745: istore_1
    //   746: aload 15
    //   748: new 448	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$8
    //   751: dup
    //   752: aload_0
    //   753: iload_2
    //   754: iload_3
    //   755: invokespecial 449	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$8:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
    //   758: invokevirtual 389	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   761: pop
    //   762: goto +692 -> 1454
    //   765: iload_2
    //   766: istore_1
    //   767: aload_0
    //   768: getfield 328	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
    //   771: bipush 7
    //   773: if_icmpne +33 -> 806
    //   776: iload_2
    //   777: istore_1
    //   778: aload_0
    //   779: getfield 89	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
    //   782: iconst_1
    //   783: aload_0
    //   784: getfield 200	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mST1	[B
    //   787: aload_0
    //   788: getfield 202	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mST1Key	[B
    //   791: aload_0
    //   792: getfield 130	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUIN	J
    //   795: aload_0
    //   796: getfield 99	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwAppid	J
    //   799: invokestatic 453	oicq/wlogin_sdk/request/WtloginHelper:access$1700	(Loicq/wlogin_sdk/request/WtloginHelper;I[B[BJJ)I
    //   802: pop
    //   803: goto +651 -> 1454
    //   806: iload_2
    //   807: istore_1
    //   808: aload_0
    //   809: getfield 328	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
    //   812: bipush 9
    //   814: if_icmpne +61 -> 875
    //   817: iload_2
    //   818: istore_1
    //   819: aload_0
    //   820: getfield 89	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
    //   823: iconst_1
    //   824: aload_0
    //   825: getfield 95	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mEncrypt	I
    //   828: aload_0
    //   829: getfield 97	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
    //   832: aload_0
    //   833: getfield 99	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwAppid	J
    //   836: aload_0
    //   837: getfield 101	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mRole	J
    //   840: aload_0
    //   841: getfield 103	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqContext	Loicq/wlogin_sdk/request/TransReqContext;
    //   844: aload_0
    //   845: getfield 79	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserSigInfo	Loicq/wlogin_sdk/request/WUserSigInfo;
    //   848: invokevirtual 457	oicq/wlogin_sdk/request/WtloginHelper:RequestTransport	(IILjava/lang/String;JJLoicq/wlogin_sdk/request/TransReqContext;Loicq/wlogin_sdk/request/WUserSigInfo;)I
    //   851: istore_3
    //   852: iload_2
    //   853: istore_1
    //   854: aload_0
    //   855: getfield 91	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
    //   858: new 459	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$9
    //   861: dup
    //   862: aload_0
    //   863: iload_3
    //   864: iload_2
    //   865: invokespecial 460	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$9:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
    //   868: invokevirtual 389	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   871: pop
    //   872: goto +582 -> 1454
    //   875: iload_2
    //   876: istore_1
    //   877: aload_0
    //   878: getfield 328	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
    //   881: bipush 10
    //   883: if_icmpne +57 -> 940
    //   886: iload_2
    //   887: istore_1
    //   888: aload_0
    //   889: getfield 89	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
    //   892: iconst_1
    //   893: aload_0
    //   894: getfield 95	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mEncrypt	I
    //   897: aload_0
    //   898: getfield 97	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
    //   901: aload_0
    //   902: getfield 99	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwAppid	J
    //   905: aload_0
    //   906: getfield 101	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mRole	J
    //   909: aload_0
    //   910: getfield 103	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqContext	Loicq/wlogin_sdk/request/TransReqContext;
    //   913: invokevirtual 464	oicq/wlogin_sdk/request/WtloginHelper:RequestTransportMsf	(IILjava/lang/String;JJLoicq/wlogin_sdk/request/TransReqContext;)I
    //   916: istore_3
    //   917: iload_2
    //   918: istore_1
    //   919: aload_0
    //   920: getfield 91	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
    //   923: new 466	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$10
    //   926: dup
    //   927: aload_0
    //   928: iload_2
    //   929: iload_3
    //   930: invokespecial 467	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$10:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
    //   933: invokevirtual 389	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   936: pop
    //   937: goto +517 -> 1454
    //   940: iload_2
    //   941: istore_1
    //   942: aload_0
    //   943: getfield 328	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
    //   946: bipush 12
    //   948: if_icmpne +61 -> 1009
    //   951: iload_2
    //   952: istore_1
    //   953: aload_0
    //   954: getfield 89	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
    //   957: aload_0
    //   958: getfield 122	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mAppid1	J
    //   961: aload_0
    //   962: getfield 124	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mSubAppid1	J
    //   965: aload_0
    //   966: getfield 97	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
    //   969: aload_0
    //   970: getfield 87	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mExtraFlag	I
    //   973: aload_0
    //   974: getfield 85	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mExtraUin	J
    //   977: aload_0
    //   978: getfield 79	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserSigInfo	Loicq/wlogin_sdk/request/WUserSigInfo;
    //   981: iconst_1
    //   982: invokestatic 471	oicq/wlogin_sdk/request/WtloginHelper:access$2100	(Loicq/wlogin_sdk/request/WtloginHelper;JJLjava/lang/String;IJLoicq/wlogin_sdk/request/WUserSigInfo;I)I
    //   985: istore_3
    //   986: iload_2
    //   987: istore_1
    //   988: aload_0
    //   989: getfield 91	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
    //   992: new 473	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$11
    //   995: dup
    //   996: aload_0
    //   997: iload_2
    //   998: iload_3
    //   999: invokespecial 474	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$11:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
    //   1002: invokevirtual 389	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   1005: pop
    //   1006: goto +448 -> 1454
    //   1009: iload_2
    //   1010: istore_1
    //   1011: aload_0
    //   1012: getfield 328	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
    //   1015: bipush 13
    //   1017: if_icmpne +49 -> 1066
    //   1020: iload_2
    //   1021: istore_1
    //   1022: aload_0
    //   1023: getfield 89	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
    //   1026: aload_0
    //   1027: getfield 97	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
    //   1030: aload_0
    //   1031: getfield 165	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mMsgCode	Ljava/lang/String;
    //   1034: aload_0
    //   1035: getfield 79	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserSigInfo	Loicq/wlogin_sdk/request/WUserSigInfo;
    //   1038: iconst_1
    //   1039: invokestatic 478	oicq/wlogin_sdk/request/WtloginHelper:access$2200	(Loicq/wlogin_sdk/request/WtloginHelper;Ljava/lang/String;Ljava/lang/String;Loicq/wlogin_sdk/request/WUserSigInfo;I)I
    //   1042: istore_3
    //   1043: iload_2
    //   1044: istore_1
    //   1045: aload_0
    //   1046: getfield 91	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
    //   1049: new 480	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$12
    //   1052: dup
    //   1053: aload_0
    //   1054: iload_2
    //   1055: iload_3
    //   1056: invokespecial 481	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$12:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
    //   1059: invokevirtual 389	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   1062: pop
    //   1063: goto +391 -> 1454
    //   1066: iload_2
    //   1067: istore_1
    //   1068: aload_0
    //   1069: getfield 328	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
    //   1072: bipush 14
    //   1074: if_icmpne +45 -> 1119
    //   1077: iload_2
    //   1078: istore_1
    //   1079: aload_0
    //   1080: getfield 89	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
    //   1083: aload_0
    //   1084: getfield 97	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
    //   1087: aload_0
    //   1088: getfield 79	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserSigInfo	Loicq/wlogin_sdk/request/WUserSigInfo;
    //   1091: iconst_1
    //   1092: invokestatic 484	oicq/wlogin_sdk/request/WtloginHelper:access$2400	(Loicq/wlogin_sdk/request/WtloginHelper;Ljava/lang/String;Loicq/wlogin_sdk/request/WUserSigInfo;I)I
    //   1095: istore_3
    //   1096: iload_2
    //   1097: istore_1
    //   1098: aload_0
    //   1099: getfield 91	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
    //   1102: new 486	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$13
    //   1105: dup
    //   1106: aload_0
    //   1107: iload_2
    //   1108: iload_3
    //   1109: invokespecial 487	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$13:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
    //   1112: invokevirtual 389	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   1115: pop
    //   1116: goto +338 -> 1454
    //   1119: iload_2
    //   1120: istore_1
    //   1121: aload_0
    //   1122: getfield 328	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
    //   1125: bipush 8
    //   1127: if_icmpne +37 -> 1164
    //   1130: iload_2
    //   1131: istore_1
    //   1132: aload_0
    //   1133: getfield 89	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
    //   1136: iconst_1
    //   1137: aload_0
    //   1138: getfield 200	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mST1	[B
    //   1141: aload_0
    //   1142: getfield 202	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mST1Key	[B
    //   1145: aload_0
    //   1146: getfield 130	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUIN	J
    //   1149: aload_0
    //   1150: getfield 99	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwAppid	J
    //   1153: aload_0
    //   1154: getfield 204	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReportErrType	I
    //   1157: invokestatic 491	oicq/wlogin_sdk/request/WtloginHelper:access$2500	(Loicq/wlogin_sdk/request/WtloginHelper;I[B[BJJI)I
    //   1160: pop
    //   1161: goto +293 -> 1454
    //   1164: iload_2
    //   1165: istore_1
    //   1166: aload_0
    //   1167: getfield 328	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
    //   1170: bipush 15
    //   1172: if_icmpne +45 -> 1217
    //   1175: iload_2
    //   1176: istore_1
    //   1177: aload_0
    //   1178: getfield 89	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
    //   1181: aload_0
    //   1182: getfield 97	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
    //   1185: aload_0
    //   1186: getfield 170	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:quickLoginParam	Loicq/wlogin_sdk/request/WtloginHelper$QuickLoginParam;
    //   1189: iconst_1
    //   1190: invokestatic 495	oicq/wlogin_sdk/request/WtloginHelper:access$2600	(Loicq/wlogin_sdk/request/WtloginHelper;Ljava/lang/String;Loicq/wlogin_sdk/request/WtloginHelper$QuickLoginParam;I)I
    //   1193: istore_3
    //   1194: iload_2
    //   1195: istore_1
    //   1196: aload_0
    //   1197: getfield 91	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
    //   1200: new 497	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$14
    //   1203: dup
    //   1204: aload_0
    //   1205: iload_2
    //   1206: iload_3
    //   1207: invokespecial 498	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$14:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
    //   1210: invokevirtual 389	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   1213: pop
    //   1214: goto +240 -> 1454
    //   1217: iload_2
    //   1218: istore_1
    //   1219: aload_0
    //   1220: getfield 328	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
    //   1223: bipush 16
    //   1225: if_icmpne +49 -> 1274
    //   1228: iload_2
    //   1229: istore_1
    //   1230: aload_0
    //   1231: getfield 89	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
    //   1234: aload_0
    //   1235: getfield 97	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
    //   1238: aload_0
    //   1239: getfield 168	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:ptSig	Ljava/lang/String;
    //   1242: aload_0
    //   1243: getfield 170	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:quickLoginParam	Loicq/wlogin_sdk/request/WtloginHelper$QuickLoginParam;
    //   1246: iconst_1
    //   1247: invokestatic 502	oicq/wlogin_sdk/request/WtloginHelper:access$2700	(Loicq/wlogin_sdk/request/WtloginHelper;Ljava/lang/String;Ljava/lang/String;Loicq/wlogin_sdk/request/WtloginHelper$QuickLoginParam;I)I
    //   1250: istore_3
    //   1251: iload_2
    //   1252: istore_1
    //   1253: aload_0
    //   1254: getfield 91	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
    //   1257: new 504	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$15
    //   1260: dup
    //   1261: aload_0
    //   1262: iload_2
    //   1263: iload_3
    //   1264: invokespecial 505	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$15:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
    //   1267: invokevirtual 389	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   1270: pop
    //   1271: goto +183 -> 1454
    //   1274: iload_2
    //   1275: istore_1
    //   1276: aload_0
    //   1277: getfield 328	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
    //   1280: bipush 17
    //   1282: if_icmpne +57 -> 1339
    //   1285: iload_2
    //   1286: istore_1
    //   1287: aload_0
    //   1288: getfield 89	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
    //   1291: aload_0
    //   1292: getfield 97	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
    //   1295: aload_0
    //   1296: getfield 99	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwAppid	J
    //   1299: aload_0
    //   1300: getfield 133	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwSubDstAppid	J
    //   1303: aload_0
    //   1304: getfield 126	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwMainSigMap	I
    //   1307: aload_0
    //   1308: getfield 79	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserSigInfo	Loicq/wlogin_sdk/request/WUserSigInfo;
    //   1311: iconst_1
    //   1312: invokestatic 509	oicq/wlogin_sdk/request/WtloginHelper:access$2800	(Loicq/wlogin_sdk/request/WtloginHelper;Ljava/lang/String;JJILoicq/wlogin_sdk/request/WUserSigInfo;I)I
    //   1315: istore_3
    //   1316: iload_2
    //   1317: istore_1
    //   1318: aload_0
    //   1319: getfield 91	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
    //   1322: new 511	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$16
    //   1325: dup
    //   1326: aload_0
    //   1327: iload_2
    //   1328: iload_3
    //   1329: invokespecial 512	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$16:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
    //   1332: invokevirtual 389	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   1335: pop
    //   1336: goto +118 -> 1454
    //   1339: iload_2
    //   1340: istore_1
    //   1341: aload_0
    //   1342: getfield 328	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
    //   1345: bipush 18
    //   1347: if_icmpne +49 -> 1396
    //   1350: iload_2
    //   1351: istore_1
    //   1352: aload_0
    //   1353: getfield 89	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
    //   1356: aload_0
    //   1357: getfield 186	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mWxAppid	[B
    //   1360: aload_0
    //   1361: getfield 184	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:weChatCode	[B
    //   1364: aload_0
    //   1365: getfield 170	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:quickLoginParam	Loicq/wlogin_sdk/request/WtloginHelper$QuickLoginParam;
    //   1368: iconst_1
    //   1369: invokevirtual 516	oicq/wlogin_sdk/request/WtloginHelper:quickLoginByWeChat	([B[BLoicq/wlogin_sdk/request/WtloginHelper$QuickLoginParam;I)I
    //   1372: istore_3
    //   1373: iload_2
    //   1374: istore_1
    //   1375: aload_0
    //   1376: getfield 91	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
    //   1379: new 518	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$17
    //   1382: dup
    //   1383: aload_0
    //   1384: iload_2
    //   1385: iload_3
    //   1386: invokespecial 519	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$17:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
    //   1389: invokevirtual 389	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   1392: pop
    //   1393: goto +61 -> 1454
    //   1396: iload_2
    //   1397: istore_1
    //   1398: aload_0
    //   1399: getfield 328	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
    //   1402: bipush 19
    //   1404: if_icmpne +50 -> 1454
    //   1407: iload_2
    //   1408: istore_1
    //   1409: aload_0
    //   1410: getfield 89	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
    //   1413: aload_0
    //   1414: getfield 122	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mAppid1	J
    //   1417: aload_0
    //   1418: getfield 124	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mSubAppid1	J
    //   1421: aload_0
    //   1422: getfield 126	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwMainSigMap	I
    //   1425: aload_0
    //   1426: getfield 79	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserSigInfo	Loicq/wlogin_sdk/request/WUserSigInfo;
    //   1429: iconst_1
    //   1430: invokestatic 523	oicq/wlogin_sdk/request/WtloginHelper:access$2900	(Loicq/wlogin_sdk/request/WtloginHelper;JJILoicq/wlogin_sdk/request/WUserSigInfo;I)I
    //   1433: istore_3
    //   1434: iload_2
    //   1435: istore_1
    //   1436: aload_0
    //   1437: getfield 91	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
    //   1440: new 525	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$18
    //   1443: dup
    //   1444: aload_0
    //   1445: iload_2
    //   1446: iload_3
    //   1447: invokespecial 526	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$18:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
    //   1450: invokevirtual 389	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   1453: pop
    //   1454: aload_0
    //   1455: getfield 77	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:isSelfLooper	Z
    //   1458: ifeq +6 -> 1464
    //   1461: invokestatic 529	android/os/Looper:loop	()V
    //   1464: aload_0
    //   1465: getfield 328	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
    //   1468: bipush 7
    //   1470: if_icmpeq +211 -> 1681
    //   1473: getstatic 337	oicq/wlogin_sdk/request/WtloginHelper:__sync_top	Ljava/lang/Object;
    //   1476: astore 15
    //   1478: aload 15
    //   1480: monitorenter
    //   1481: getstatic 347	oicq/wlogin_sdk/request/WtloginHelper:__top	I
    //   1484: ifle +11 -> 1495
    //   1487: getstatic 347	oicq/wlogin_sdk/request/WtloginHelper:__top	I
    //   1490: iconst_1
    //   1491: isub
    //   1492: putstatic 347	oicq/wlogin_sdk/request/WtloginHelper:__top	I
    //   1495: new 105	java/lang/StringBuilder
    //   1498: dup
    //   1499: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   1502: astore 16
    //   1504: aload 16
    //   1506: ldc_w 531
    //   1509: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1512: pop
    //   1513: aload 16
    //   1515: getstatic 347	oicq/wlogin_sdk/request/WtloginHelper:__top	I
    //   1518: invokevirtual 272	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1521: pop
    //   1522: aload 16
    //   1524: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1527: ldc 239
    //   1529: invokestatic 276	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1532: aload 15
    //   1534: monitorexit
    //   1535: return
    //   1536: astore 16
    //   1538: aload 15
    //   1540: monitorexit
    //   1541: aload 16
    //   1543: athrow
    //   1544: new 228	java/lang/Exception
    //   1547: dup
    //   1548: ldc_w 533
    //   1551: invokespecial 535	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   1554: athrow
    //   1555: astore 15
    //   1557: goto +10 -> 1567
    //   1560: astore 16
    //   1562: goto +120 -> 1682
    //   1565: astore 15
    //   1567: aload 15
    //   1569: ldc 239
    //   1571: invokestatic 245	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   1574: aload_0
    //   1575: getfield 91	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
    //   1578: new 537	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$19
    //   1581: dup
    //   1582: aload_0
    //   1583: iload_1
    //   1584: invokespecial 540	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$19:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;I)V
    //   1587: invokevirtual 389	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   1590: pop
    //   1591: aload_0
    //   1592: getfield 77	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:isSelfLooper	Z
    //   1595: ifeq +6 -> 1601
    //   1598: invokestatic 529	android/os/Looper:loop	()V
    //   1601: aload_0
    //   1602: getfield 328	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
    //   1605: bipush 7
    //   1607: if_icmpeq +74 -> 1681
    //   1610: getstatic 337	oicq/wlogin_sdk/request/WtloginHelper:__sync_top	Ljava/lang/Object;
    //   1613: astore 15
    //   1615: aload 15
    //   1617: monitorenter
    //   1618: getstatic 347	oicq/wlogin_sdk/request/WtloginHelper:__top	I
    //   1621: ifle +11 -> 1632
    //   1624: getstatic 347	oicq/wlogin_sdk/request/WtloginHelper:__top	I
    //   1627: iconst_1
    //   1628: isub
    //   1629: putstatic 347	oicq/wlogin_sdk/request/WtloginHelper:__top	I
    //   1632: new 105	java/lang/StringBuilder
    //   1635: dup
    //   1636: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   1639: astore 16
    //   1641: aload 16
    //   1643: ldc_w 531
    //   1646: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1649: pop
    //   1650: aload 16
    //   1652: getstatic 347	oicq/wlogin_sdk/request/WtloginHelper:__top	I
    //   1655: invokevirtual 272	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1658: pop
    //   1659: aload 16
    //   1661: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1664: ldc 239
    //   1666: invokestatic 276	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1669: aload 15
    //   1671: monitorexit
    //   1672: return
    //   1673: astore 16
    //   1675: aload 15
    //   1677: monitorexit
    //   1678: aload 16
    //   1680: athrow
    //   1681: return
    //   1682: aload_0
    //   1683: getfield 77	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:isSelfLooper	Z
    //   1686: ifeq +6 -> 1692
    //   1689: invokestatic 529	android/os/Looper:loop	()V
    //   1692: aload_0
    //   1693: getfield 328	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
    //   1696: bipush 7
    //   1698: if_icmpeq +76 -> 1774
    //   1701: getstatic 337	oicq/wlogin_sdk/request/WtloginHelper:__sync_top	Ljava/lang/Object;
    //   1704: astore 15
    //   1706: aload 15
    //   1708: monitorenter
    //   1709: getstatic 347	oicq/wlogin_sdk/request/WtloginHelper:__top	I
    //   1712: ifle +11 -> 1723
    //   1715: getstatic 347	oicq/wlogin_sdk/request/WtloginHelper:__top	I
    //   1718: iconst_1
    //   1719: isub
    //   1720: putstatic 347	oicq/wlogin_sdk/request/WtloginHelper:__top	I
    //   1723: new 105	java/lang/StringBuilder
    //   1726: dup
    //   1727: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   1730: astore 17
    //   1732: aload 17
    //   1734: ldc_w 531
    //   1737: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1740: pop
    //   1741: aload 17
    //   1743: getstatic 347	oicq/wlogin_sdk/request/WtloginHelper:__top	I
    //   1746: invokevirtual 272	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1749: pop
    //   1750: aload 17
    //   1752: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1755: ldc 239
    //   1757: invokestatic 276	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1760: aload 15
    //   1762: monitorexit
    //   1763: goto +11 -> 1774
    //   1766: astore 16
    //   1768: aload 15
    //   1770: monitorexit
    //   1771: aload 16
    //   1773: athrow
    //   1774: goto +6 -> 1780
    //   1777: aload 16
    //   1779: athrow
    //   1780: goto -3 -> 1777
    //   1783: astore 15
    //   1785: goto -1175 -> 610
    //   1788: goto -1249 -> 539
    //   1791: astore 15
    //   1793: goto -1183 -> 610
    //   1796: astore 15
    //   1798: iload_2
    //   1799: istore_1
    //   1800: goto -233 -> 1567
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1803	0	this	HelperThread
    //   28	1772	1	i	int
    //   134	1665	2	j	int
    //   466	981	3	k	int
    //   37	10	4	bool	boolean
    //   400	305	5	l1	long
    //   406	301	7	l2	long
    //   412	300	9	l3	long
    //   423	291	11	l4	long
    //   698	18	13	l5	long
    //   388	192	15	localObject1	Object
    //   598	1	15	localException1	Exception
    //   603	1	15	localObject2	Object
    //   608	6	15	localObject3	Object
    //   1555	1	15	localException2	Exception
    //   1565	3	15	localException3	Exception
    //   1783	1	15	localObject6	Object
    //   1791	1	15	localObject7	Object
    //   1796	1	15	localException4	Exception
    //   379	1144	16	localObject8	Object
    //   1536	6	16	localObject9	Object
    //   1560	1	16	localObject10	Object
    //   1639	21	16	localStringBuilder	StringBuilder
    //   1673	6	16	localObject11	Object
    //   1766	12	16	localObject12	Object
    //   394	1357	17	localObject13	Object
    //   429	16	18	arrayOfLong	long[]
    // Exception table:
    //   from	to	target	type
    //   569	575	598	java/lang/Exception
    //   431	467	603	finally
    //   566	569	603	finally
    //   384	431	608	finally
    //   1481	1495	1536	finally
    //   1495	1535	1536	finally
    //   1538	1541	1536	finally
    //   579	595	1555	java/lang/Exception
    //   613	616	1555	java/lang/Exception
    //   620	629	1555	java/lang/Exception
    //   631	637	1555	java/lang/Exception
    //   639	645	1555	java/lang/Exception
    //   647	653	1555	java/lang/Exception
    //   655	661	1555	java/lang/Exception
    //   663	668	1555	java/lang/Exception
    //   670	676	1555	java/lang/Exception
    //   678	684	1555	java/lang/Exception
    //   686	692	1555	java/lang/Exception
    //   694	700	1555	java/lang/Exception
    //   746	762	1555	java/lang/Exception
    //   767	776	1555	java/lang/Exception
    //   778	803	1555	java/lang/Exception
    //   808	817	1555	java/lang/Exception
    //   819	852	1555	java/lang/Exception
    //   854	872	1555	java/lang/Exception
    //   877	886	1555	java/lang/Exception
    //   888	917	1555	java/lang/Exception
    //   919	937	1555	java/lang/Exception
    //   942	951	1555	java/lang/Exception
    //   953	986	1555	java/lang/Exception
    //   988	1006	1555	java/lang/Exception
    //   1011	1020	1555	java/lang/Exception
    //   1022	1043	1555	java/lang/Exception
    //   1045	1063	1555	java/lang/Exception
    //   1068	1077	1555	java/lang/Exception
    //   1079	1096	1555	java/lang/Exception
    //   1098	1116	1555	java/lang/Exception
    //   1121	1130	1555	java/lang/Exception
    //   1132	1161	1555	java/lang/Exception
    //   1166	1175	1555	java/lang/Exception
    //   1177	1194	1555	java/lang/Exception
    //   1196	1214	1555	java/lang/Exception
    //   1219	1228	1555	java/lang/Exception
    //   1230	1251	1555	java/lang/Exception
    //   1253	1271	1555	java/lang/Exception
    //   1276	1285	1555	java/lang/Exception
    //   1287	1316	1555	java/lang/Exception
    //   1318	1336	1555	java/lang/Exception
    //   1341	1350	1555	java/lang/Exception
    //   1352	1373	1555	java/lang/Exception
    //   1375	1393	1555	java/lang/Exception
    //   1398	1407	1555	java/lang/Exception
    //   1409	1434	1555	java/lang/Exception
    //   1436	1454	1555	java/lang/Exception
    //   1544	1555	1555	java/lang/Exception
    //   72	153	1560	finally
    //   156	199	1560	finally
    //   202	253	1560	finally
    //   256	307	1560	finally
    //   310	365	1560	finally
    //   368	384	1560	finally
    //   569	575	1560	finally
    //   579	595	1560	finally
    //   613	616	1560	finally
    //   620	629	1560	finally
    //   631	637	1560	finally
    //   639	645	1560	finally
    //   647	653	1560	finally
    //   655	661	1560	finally
    //   663	668	1560	finally
    //   670	676	1560	finally
    //   678	684	1560	finally
    //   686	692	1560	finally
    //   694	700	1560	finally
    //   700	744	1560	finally
    //   746	762	1560	finally
    //   767	776	1560	finally
    //   778	803	1560	finally
    //   808	817	1560	finally
    //   819	852	1560	finally
    //   854	872	1560	finally
    //   877	886	1560	finally
    //   888	917	1560	finally
    //   919	937	1560	finally
    //   942	951	1560	finally
    //   953	986	1560	finally
    //   988	1006	1560	finally
    //   1011	1020	1560	finally
    //   1022	1043	1560	finally
    //   1045	1063	1560	finally
    //   1068	1077	1560	finally
    //   1079	1096	1560	finally
    //   1098	1116	1560	finally
    //   1121	1130	1560	finally
    //   1132	1161	1560	finally
    //   1166	1175	1560	finally
    //   1177	1194	1560	finally
    //   1196	1214	1560	finally
    //   1219	1228	1560	finally
    //   1230	1251	1560	finally
    //   1253	1271	1560	finally
    //   1276	1285	1560	finally
    //   1287	1316	1560	finally
    //   1318	1336	1560	finally
    //   1341	1350	1560	finally
    //   1352	1373	1560	finally
    //   1375	1393	1560	finally
    //   1398	1407	1560	finally
    //   1409	1434	1560	finally
    //   1436	1454	1560	finally
    //   1544	1555	1560	finally
    //   1567	1591	1560	finally
    //   72	153	1565	java/lang/Exception
    //   156	199	1565	java/lang/Exception
    //   202	253	1565	java/lang/Exception
    //   256	307	1565	java/lang/Exception
    //   310	365	1565	java/lang/Exception
    //   368	384	1565	java/lang/Exception
    //   1618	1632	1673	finally
    //   1632	1672	1673	finally
    //   1675	1678	1673	finally
    //   1709	1723	1766	finally
    //   1723	1763	1766	finally
    //   1768	1771	1766	finally
    //   475	536	1783	finally
    //   549	566	1783	finally
    //   610	613	1791	finally
    //   700	744	1796	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     oicq.wlogin_sdk.request.WtloginHelper.HelperThread
 * JD-Core Version:    0.7.0.1
 */