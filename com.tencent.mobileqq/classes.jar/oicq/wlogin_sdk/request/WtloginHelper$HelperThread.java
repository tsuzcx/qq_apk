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
    //   76: ifnull +1490 -> 1566
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
    //   153: goto +1323 -> 1476
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
    //   199: goto +1277 -> 1476
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
    //   253: goto +1223 -> 1476
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
    //   307: goto +1169 -> 1476
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
    //   365: goto +1111 -> 1476
    //   368: aload_0
    //   369: getfield 328	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
    //   372: iconst_5
    //   373: if_icmpne +265 -> 638
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
    //   472: if_icmpne +1338 -> 1810
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
    //   540: ifeq +25 -> 565
    //   543: new 428	oicq/wlogin_sdk/report/event/a
    //   546: dup
    //   547: ldc_w 430
    //   550: iload_2
    //   551: invokestatic 436	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   554: ldc 239
    //   556: invokespecial 439	oicq/wlogin_sdk/report/event/a:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   559: invokestatic 445	oicq/wlogin_sdk/report/event/b:a	(Loicq/wlogin_sdk/report/event/a;)V
    //   562: goto +26 -> 588
    //   565: iload_3
    //   566: bipush 20
    //   568: if_icmpne +20 -> 588
    //   571: new 428	oicq/wlogin_sdk/report/event/a
    //   574: dup
    //   575: ldc_w 447
    //   578: ldc 239
    //   580: ldc 239
    //   582: invokespecial 439	oicq/wlogin_sdk/report/event/a:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   585: invokestatic 445	oicq/wlogin_sdk/report/event/b:a	(Loicq/wlogin_sdk/report/event/a;)V
    //   588: aload 16
    //   590: monitorexit
    //   591: aload_0
    //   592: getfield 91	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
    //   595: astore 15
    //   597: iload_1
    //   598: istore_3
    //   599: iload_3
    //   600: istore_1
    //   601: aload 15
    //   603: new 449	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$7
    //   606: dup
    //   607: aload_0
    //   608: iload_3
    //   609: iload_2
    //   610: invokespecial 450	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$7:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
    //   613: invokevirtual 389	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   616: pop
    //   617: goto +859 -> 1476
    //   620: astore 15
    //   622: goto +967 -> 1589
    //   625: astore 15
    //   627: goto +5 -> 632
    //   630: astore 15
    //   632: aload 16
    //   634: monitorexit
    //   635: aload 15
    //   637: athrow
    //   638: iload_1
    //   639: istore_2
    //   640: iload_2
    //   641: istore_1
    //   642: aload_0
    //   643: getfield 328	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
    //   646: bipush 6
    //   648: if_icmpne +139 -> 787
    //   651: iload_2
    //   652: istore_1
    //   653: aload_0
    //   654: getfield 89	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
    //   657: astore 15
    //   659: iload_2
    //   660: istore_1
    //   661: aload_0
    //   662: getfield 97	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
    //   665: astore 16
    //   667: iload_2
    //   668: istore_1
    //   669: aload_0
    //   670: getfield 122	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mAppid1	J
    //   673: lstore 5
    //   675: iload_2
    //   676: istore_1
    //   677: aload_0
    //   678: getfield 124	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mSubAppid1	J
    //   681: lstore 7
    //   683: iload_2
    //   684: istore_1
    //   685: aload_0
    //   686: getfield 126	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwMainSigMap	I
    //   689: istore_3
    //   690: iload_2
    //   691: istore_1
    //   692: aload_0
    //   693: getfield 145	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mAppName2	[B
    //   696: astore 17
    //   698: iload_2
    //   699: istore_1
    //   700: aload_0
    //   701: getfield 147	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mSsoVer2	J
    //   704: lstore 9
    //   706: iload_2
    //   707: istore_1
    //   708: aload_0
    //   709: getfield 149	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mAppid2	J
    //   712: lstore 11
    //   714: iload_2
    //   715: istore_1
    //   716: aload_0
    //   717: getfield 151	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mSubAppid2	J
    //   720: lstore 13
    //   722: aload 15
    //   724: aload 16
    //   726: lload 5
    //   728: lload 7
    //   730: iload_3
    //   731: aload 17
    //   733: lload 9
    //   735: lload 11
    //   737: lload 13
    //   739: aload_0
    //   740: getfield 153	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mAppVer2	[B
    //   743: aload_0
    //   744: getfield 155	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mAppSign2	[B
    //   747: aload_0
    //   748: getfield 79	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserSigInfo	Loicq/wlogin_sdk/request/WUserSigInfo;
    //   751: aload_0
    //   752: getfield 157	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mFastLoginInfo	Loicq/wlogin_sdk/request/WFastLoginInfo;
    //   755: iconst_1
    //   756: invokestatic 454	oicq/wlogin_sdk/request/WtloginHelper:access$1600	(Loicq/wlogin_sdk/request/WtloginHelper;Ljava/lang/String;JJI[BJJJ[B[BLoicq/wlogin_sdk/request/WUserSigInfo;Loicq/wlogin_sdk/request/WFastLoginInfo;I)I
    //   759: istore_3
    //   760: aload_0
    //   761: getfield 91	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
    //   764: astore 15
    //   766: iload_2
    //   767: istore_1
    //   768: aload 15
    //   770: new 456	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$8
    //   773: dup
    //   774: aload_0
    //   775: iload_2
    //   776: iload_3
    //   777: invokespecial 457	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$8:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
    //   780: invokevirtual 389	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   783: pop
    //   784: goto +692 -> 1476
    //   787: iload_2
    //   788: istore_1
    //   789: aload_0
    //   790: getfield 328	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
    //   793: bipush 7
    //   795: if_icmpne +33 -> 828
    //   798: iload_2
    //   799: istore_1
    //   800: aload_0
    //   801: getfield 89	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
    //   804: iconst_1
    //   805: aload_0
    //   806: getfield 200	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mST1	[B
    //   809: aload_0
    //   810: getfield 202	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mST1Key	[B
    //   813: aload_0
    //   814: getfield 130	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUIN	J
    //   817: aload_0
    //   818: getfield 99	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwAppid	J
    //   821: invokestatic 461	oicq/wlogin_sdk/request/WtloginHelper:access$1700	(Loicq/wlogin_sdk/request/WtloginHelper;I[B[BJJ)I
    //   824: pop
    //   825: goto +651 -> 1476
    //   828: iload_2
    //   829: istore_1
    //   830: aload_0
    //   831: getfield 328	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
    //   834: bipush 9
    //   836: if_icmpne +61 -> 897
    //   839: iload_2
    //   840: istore_1
    //   841: aload_0
    //   842: getfield 89	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
    //   845: iconst_1
    //   846: aload_0
    //   847: getfield 95	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mEncrypt	I
    //   850: aload_0
    //   851: getfield 97	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
    //   854: aload_0
    //   855: getfield 99	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwAppid	J
    //   858: aload_0
    //   859: getfield 101	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mRole	J
    //   862: aload_0
    //   863: getfield 103	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqContext	Loicq/wlogin_sdk/request/TransReqContext;
    //   866: aload_0
    //   867: getfield 79	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserSigInfo	Loicq/wlogin_sdk/request/WUserSigInfo;
    //   870: invokevirtual 465	oicq/wlogin_sdk/request/WtloginHelper:RequestTransport	(IILjava/lang/String;JJLoicq/wlogin_sdk/request/TransReqContext;Loicq/wlogin_sdk/request/WUserSigInfo;)I
    //   873: istore_3
    //   874: iload_2
    //   875: istore_1
    //   876: aload_0
    //   877: getfield 91	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
    //   880: new 467	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$9
    //   883: dup
    //   884: aload_0
    //   885: iload_3
    //   886: iload_2
    //   887: invokespecial 468	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$9:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
    //   890: invokevirtual 389	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   893: pop
    //   894: goto +582 -> 1476
    //   897: iload_2
    //   898: istore_1
    //   899: aload_0
    //   900: getfield 328	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
    //   903: bipush 10
    //   905: if_icmpne +57 -> 962
    //   908: iload_2
    //   909: istore_1
    //   910: aload_0
    //   911: getfield 89	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
    //   914: iconst_1
    //   915: aload_0
    //   916: getfield 95	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mEncrypt	I
    //   919: aload_0
    //   920: getfield 97	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
    //   923: aload_0
    //   924: getfield 99	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwAppid	J
    //   927: aload_0
    //   928: getfield 101	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mRole	J
    //   931: aload_0
    //   932: getfield 103	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqContext	Loicq/wlogin_sdk/request/TransReqContext;
    //   935: invokevirtual 472	oicq/wlogin_sdk/request/WtloginHelper:RequestTransportMsf	(IILjava/lang/String;JJLoicq/wlogin_sdk/request/TransReqContext;)I
    //   938: istore_3
    //   939: iload_2
    //   940: istore_1
    //   941: aload_0
    //   942: getfield 91	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
    //   945: new 474	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$10
    //   948: dup
    //   949: aload_0
    //   950: iload_2
    //   951: iload_3
    //   952: invokespecial 475	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$10:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
    //   955: invokevirtual 389	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   958: pop
    //   959: goto +517 -> 1476
    //   962: iload_2
    //   963: istore_1
    //   964: aload_0
    //   965: getfield 328	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
    //   968: bipush 12
    //   970: if_icmpne +61 -> 1031
    //   973: iload_2
    //   974: istore_1
    //   975: aload_0
    //   976: getfield 89	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
    //   979: aload_0
    //   980: getfield 122	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mAppid1	J
    //   983: aload_0
    //   984: getfield 124	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mSubAppid1	J
    //   987: aload_0
    //   988: getfield 97	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
    //   991: aload_0
    //   992: getfield 87	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mExtraFlag	I
    //   995: aload_0
    //   996: getfield 85	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mExtraUin	J
    //   999: aload_0
    //   1000: getfield 79	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserSigInfo	Loicq/wlogin_sdk/request/WUserSigInfo;
    //   1003: iconst_1
    //   1004: invokestatic 479	oicq/wlogin_sdk/request/WtloginHelper:access$2100	(Loicq/wlogin_sdk/request/WtloginHelper;JJLjava/lang/String;IJLoicq/wlogin_sdk/request/WUserSigInfo;I)I
    //   1007: istore_3
    //   1008: iload_2
    //   1009: istore_1
    //   1010: aload_0
    //   1011: getfield 91	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
    //   1014: new 481	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$11
    //   1017: dup
    //   1018: aload_0
    //   1019: iload_2
    //   1020: iload_3
    //   1021: invokespecial 482	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$11:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
    //   1024: invokevirtual 389	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   1027: pop
    //   1028: goto +448 -> 1476
    //   1031: iload_2
    //   1032: istore_1
    //   1033: aload_0
    //   1034: getfield 328	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
    //   1037: bipush 13
    //   1039: if_icmpne +49 -> 1088
    //   1042: iload_2
    //   1043: istore_1
    //   1044: aload_0
    //   1045: getfield 89	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
    //   1048: aload_0
    //   1049: getfield 97	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
    //   1052: aload_0
    //   1053: getfield 165	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mMsgCode	Ljava/lang/String;
    //   1056: aload_0
    //   1057: getfield 79	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserSigInfo	Loicq/wlogin_sdk/request/WUserSigInfo;
    //   1060: iconst_1
    //   1061: invokestatic 486	oicq/wlogin_sdk/request/WtloginHelper:access$2200	(Loicq/wlogin_sdk/request/WtloginHelper;Ljava/lang/String;Ljava/lang/String;Loicq/wlogin_sdk/request/WUserSigInfo;I)I
    //   1064: istore_3
    //   1065: iload_2
    //   1066: istore_1
    //   1067: aload_0
    //   1068: getfield 91	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
    //   1071: new 488	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$12
    //   1074: dup
    //   1075: aload_0
    //   1076: iload_2
    //   1077: iload_3
    //   1078: invokespecial 489	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$12:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
    //   1081: invokevirtual 389	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   1084: pop
    //   1085: goto +391 -> 1476
    //   1088: iload_2
    //   1089: istore_1
    //   1090: aload_0
    //   1091: getfield 328	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
    //   1094: bipush 14
    //   1096: if_icmpne +45 -> 1141
    //   1099: iload_2
    //   1100: istore_1
    //   1101: aload_0
    //   1102: getfield 89	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
    //   1105: aload_0
    //   1106: getfield 97	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
    //   1109: aload_0
    //   1110: getfield 79	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserSigInfo	Loicq/wlogin_sdk/request/WUserSigInfo;
    //   1113: iconst_1
    //   1114: invokestatic 492	oicq/wlogin_sdk/request/WtloginHelper:access$2400	(Loicq/wlogin_sdk/request/WtloginHelper;Ljava/lang/String;Loicq/wlogin_sdk/request/WUserSigInfo;I)I
    //   1117: istore_3
    //   1118: iload_2
    //   1119: istore_1
    //   1120: aload_0
    //   1121: getfield 91	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
    //   1124: new 494	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$13
    //   1127: dup
    //   1128: aload_0
    //   1129: iload_2
    //   1130: iload_3
    //   1131: invokespecial 495	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$13:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
    //   1134: invokevirtual 389	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   1137: pop
    //   1138: goto +338 -> 1476
    //   1141: iload_2
    //   1142: istore_1
    //   1143: aload_0
    //   1144: getfield 328	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
    //   1147: bipush 8
    //   1149: if_icmpne +37 -> 1186
    //   1152: iload_2
    //   1153: istore_1
    //   1154: aload_0
    //   1155: getfield 89	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
    //   1158: iconst_1
    //   1159: aload_0
    //   1160: getfield 200	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mST1	[B
    //   1163: aload_0
    //   1164: getfield 202	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mST1Key	[B
    //   1167: aload_0
    //   1168: getfield 130	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUIN	J
    //   1171: aload_0
    //   1172: getfield 99	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwAppid	J
    //   1175: aload_0
    //   1176: getfield 204	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReportErrType	I
    //   1179: invokestatic 499	oicq/wlogin_sdk/request/WtloginHelper:access$2500	(Loicq/wlogin_sdk/request/WtloginHelper;I[B[BJJI)I
    //   1182: pop
    //   1183: goto +293 -> 1476
    //   1186: iload_2
    //   1187: istore_1
    //   1188: aload_0
    //   1189: getfield 328	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
    //   1192: bipush 15
    //   1194: if_icmpne +45 -> 1239
    //   1197: iload_2
    //   1198: istore_1
    //   1199: aload_0
    //   1200: getfield 89	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
    //   1203: aload_0
    //   1204: getfield 97	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
    //   1207: aload_0
    //   1208: getfield 170	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:quickLoginParam	Loicq/wlogin_sdk/request/WtloginHelper$QuickLoginParam;
    //   1211: iconst_1
    //   1212: invokestatic 503	oicq/wlogin_sdk/request/WtloginHelper:access$2600	(Loicq/wlogin_sdk/request/WtloginHelper;Ljava/lang/String;Loicq/wlogin_sdk/request/WtloginHelper$QuickLoginParam;I)I
    //   1215: istore_3
    //   1216: iload_2
    //   1217: istore_1
    //   1218: aload_0
    //   1219: getfield 91	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
    //   1222: new 505	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$14
    //   1225: dup
    //   1226: aload_0
    //   1227: iload_2
    //   1228: iload_3
    //   1229: invokespecial 506	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$14:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
    //   1232: invokevirtual 389	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   1235: pop
    //   1236: goto +240 -> 1476
    //   1239: iload_2
    //   1240: istore_1
    //   1241: aload_0
    //   1242: getfield 328	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
    //   1245: bipush 16
    //   1247: if_icmpne +49 -> 1296
    //   1250: iload_2
    //   1251: istore_1
    //   1252: aload_0
    //   1253: getfield 89	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
    //   1256: aload_0
    //   1257: getfield 97	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
    //   1260: aload_0
    //   1261: getfield 168	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:ptSig	Ljava/lang/String;
    //   1264: aload_0
    //   1265: getfield 170	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:quickLoginParam	Loicq/wlogin_sdk/request/WtloginHelper$QuickLoginParam;
    //   1268: iconst_1
    //   1269: invokestatic 510	oicq/wlogin_sdk/request/WtloginHelper:access$2700	(Loicq/wlogin_sdk/request/WtloginHelper;Ljava/lang/String;Ljava/lang/String;Loicq/wlogin_sdk/request/WtloginHelper$QuickLoginParam;I)I
    //   1272: istore_3
    //   1273: iload_2
    //   1274: istore_1
    //   1275: aload_0
    //   1276: getfield 91	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
    //   1279: new 512	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$15
    //   1282: dup
    //   1283: aload_0
    //   1284: iload_2
    //   1285: iload_3
    //   1286: invokespecial 513	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$15:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
    //   1289: invokevirtual 389	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   1292: pop
    //   1293: goto +183 -> 1476
    //   1296: iload_2
    //   1297: istore_1
    //   1298: aload_0
    //   1299: getfield 328	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
    //   1302: bipush 17
    //   1304: if_icmpne +57 -> 1361
    //   1307: iload_2
    //   1308: istore_1
    //   1309: aload_0
    //   1310: getfield 89	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
    //   1313: aload_0
    //   1314: getfield 97	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserAccount	Ljava/lang/String;
    //   1317: aload_0
    //   1318: getfield 99	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwAppid	J
    //   1321: aload_0
    //   1322: getfield 133	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwSubDstAppid	J
    //   1325: aload_0
    //   1326: getfield 126	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwMainSigMap	I
    //   1329: aload_0
    //   1330: getfield 79	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserSigInfo	Loicq/wlogin_sdk/request/WUserSigInfo;
    //   1333: iconst_1
    //   1334: invokestatic 517	oicq/wlogin_sdk/request/WtloginHelper:access$2800	(Loicq/wlogin_sdk/request/WtloginHelper;Ljava/lang/String;JJILoicq/wlogin_sdk/request/WUserSigInfo;I)I
    //   1337: istore_3
    //   1338: iload_2
    //   1339: istore_1
    //   1340: aload_0
    //   1341: getfield 91	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
    //   1344: new 519	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$16
    //   1347: dup
    //   1348: aload_0
    //   1349: iload_2
    //   1350: iload_3
    //   1351: invokespecial 520	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$16:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
    //   1354: invokevirtual 389	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   1357: pop
    //   1358: goto +118 -> 1476
    //   1361: iload_2
    //   1362: istore_1
    //   1363: aload_0
    //   1364: getfield 328	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
    //   1367: bipush 18
    //   1369: if_icmpne +49 -> 1418
    //   1372: iload_2
    //   1373: istore_1
    //   1374: aload_0
    //   1375: getfield 89	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
    //   1378: aload_0
    //   1379: getfield 186	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mWxAppid	[B
    //   1382: aload_0
    //   1383: getfield 184	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:weChatCode	[B
    //   1386: aload_0
    //   1387: getfield 170	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:quickLoginParam	Loicq/wlogin_sdk/request/WtloginHelper$QuickLoginParam;
    //   1390: iconst_1
    //   1391: invokevirtual 524	oicq/wlogin_sdk/request/WtloginHelper:quickLoginByWeChat	([B[BLoicq/wlogin_sdk/request/WtloginHelper$QuickLoginParam;I)I
    //   1394: istore_3
    //   1395: iload_2
    //   1396: istore_1
    //   1397: aload_0
    //   1398: getfield 91	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
    //   1401: new 526	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$17
    //   1404: dup
    //   1405: aload_0
    //   1406: iload_2
    //   1407: iload_3
    //   1408: invokespecial 527	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$17:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
    //   1411: invokevirtual 389	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   1414: pop
    //   1415: goto +61 -> 1476
    //   1418: iload_2
    //   1419: istore_1
    //   1420: aload_0
    //   1421: getfield 328	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
    //   1424: bipush 19
    //   1426: if_icmpne +50 -> 1476
    //   1429: iload_2
    //   1430: istore_1
    //   1431: aload_0
    //   1432: getfield 89	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHelper	Loicq/wlogin_sdk/request/WtloginHelper;
    //   1435: aload_0
    //   1436: getfield 122	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mAppid1	J
    //   1439: aload_0
    //   1440: getfield 124	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mSubAppid1	J
    //   1443: aload_0
    //   1444: getfield 126	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mDwMainSigMap	I
    //   1447: aload_0
    //   1448: getfield 79	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mUserSigInfo	Loicq/wlogin_sdk/request/WUserSigInfo;
    //   1451: iconst_1
    //   1452: invokestatic 531	oicq/wlogin_sdk/request/WtloginHelper:access$2900	(Loicq/wlogin_sdk/request/WtloginHelper;JJILoicq/wlogin_sdk/request/WUserSigInfo;I)I
    //   1455: istore_3
    //   1456: iload_2
    //   1457: istore_1
    //   1458: aload_0
    //   1459: getfield 91	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
    //   1462: new 533	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$18
    //   1465: dup
    //   1466: aload_0
    //   1467: iload_2
    //   1468: iload_3
    //   1469: invokespecial 534	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$18:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;II)V
    //   1472: invokevirtual 389	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   1475: pop
    //   1476: aload_0
    //   1477: getfield 77	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:isSelfLooper	Z
    //   1480: ifeq +6 -> 1486
    //   1483: invokestatic 537	android/os/Looper:loop	()V
    //   1486: aload_0
    //   1487: getfield 328	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
    //   1490: bipush 7
    //   1492: if_icmpeq +211 -> 1703
    //   1495: getstatic 337	oicq/wlogin_sdk/request/WtloginHelper:__sync_top	Ljava/lang/Object;
    //   1498: astore 15
    //   1500: aload 15
    //   1502: monitorenter
    //   1503: getstatic 347	oicq/wlogin_sdk/request/WtloginHelper:__top	I
    //   1506: ifle +11 -> 1517
    //   1509: getstatic 347	oicq/wlogin_sdk/request/WtloginHelper:__top	I
    //   1512: iconst_1
    //   1513: isub
    //   1514: putstatic 347	oicq/wlogin_sdk/request/WtloginHelper:__top	I
    //   1517: new 105	java/lang/StringBuilder
    //   1520: dup
    //   1521: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   1524: astore 16
    //   1526: aload 16
    //   1528: ldc_w 539
    //   1531: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1534: pop
    //   1535: aload 16
    //   1537: getstatic 347	oicq/wlogin_sdk/request/WtloginHelper:__top	I
    //   1540: invokevirtual 272	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1543: pop
    //   1544: aload 16
    //   1546: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1549: ldc 239
    //   1551: invokestatic 276	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1554: aload 15
    //   1556: monitorexit
    //   1557: return
    //   1558: astore 16
    //   1560: aload 15
    //   1562: monitorexit
    //   1563: aload 16
    //   1565: athrow
    //   1566: new 228	java/lang/Exception
    //   1569: dup
    //   1570: ldc_w 541
    //   1573: invokespecial 543	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   1576: athrow
    //   1577: astore 15
    //   1579: goto +10 -> 1589
    //   1582: astore 16
    //   1584: goto +120 -> 1704
    //   1587: astore 15
    //   1589: aload 15
    //   1591: ldc 239
    //   1593: invokestatic 245	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   1596: aload_0
    //   1597: getfield 91	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mHandler	Landroid/os/Handler;
    //   1600: new 545	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$19
    //   1603: dup
    //   1604: aload_0
    //   1605: iload_1
    //   1606: invokespecial 548	oicq/wlogin_sdk/request/WtloginHelper$HelperThread$19:<init>	(Loicq/wlogin_sdk/request/WtloginHelper$HelperThread;I)V
    //   1609: invokevirtual 389	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   1612: pop
    //   1613: aload_0
    //   1614: getfield 77	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:isSelfLooper	Z
    //   1617: ifeq +6 -> 1623
    //   1620: invokestatic 537	android/os/Looper:loop	()V
    //   1623: aload_0
    //   1624: getfield 328	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
    //   1627: bipush 7
    //   1629: if_icmpeq +74 -> 1703
    //   1632: getstatic 337	oicq/wlogin_sdk/request/WtloginHelper:__sync_top	Ljava/lang/Object;
    //   1635: astore 15
    //   1637: aload 15
    //   1639: monitorenter
    //   1640: getstatic 347	oicq/wlogin_sdk/request/WtloginHelper:__top	I
    //   1643: ifle +11 -> 1654
    //   1646: getstatic 347	oicq/wlogin_sdk/request/WtloginHelper:__top	I
    //   1649: iconst_1
    //   1650: isub
    //   1651: putstatic 347	oicq/wlogin_sdk/request/WtloginHelper:__top	I
    //   1654: new 105	java/lang/StringBuilder
    //   1657: dup
    //   1658: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   1661: astore 16
    //   1663: aload 16
    //   1665: ldc_w 539
    //   1668: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1671: pop
    //   1672: aload 16
    //   1674: getstatic 347	oicq/wlogin_sdk/request/WtloginHelper:__top	I
    //   1677: invokevirtual 272	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1680: pop
    //   1681: aload 16
    //   1683: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1686: ldc 239
    //   1688: invokestatic 276	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1691: aload 15
    //   1693: monitorexit
    //   1694: return
    //   1695: astore 16
    //   1697: aload 15
    //   1699: monitorexit
    //   1700: aload 16
    //   1702: athrow
    //   1703: return
    //   1704: aload_0
    //   1705: getfield 77	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:isSelfLooper	Z
    //   1708: ifeq +6 -> 1714
    //   1711: invokestatic 537	android/os/Looper:loop	()V
    //   1714: aload_0
    //   1715: getfield 328	oicq/wlogin_sdk/request/WtloginHelper$HelperThread:mReqType	I
    //   1718: bipush 7
    //   1720: if_icmpeq +76 -> 1796
    //   1723: getstatic 337	oicq/wlogin_sdk/request/WtloginHelper:__sync_top	Ljava/lang/Object;
    //   1726: astore 15
    //   1728: aload 15
    //   1730: monitorenter
    //   1731: getstatic 347	oicq/wlogin_sdk/request/WtloginHelper:__top	I
    //   1734: ifle +11 -> 1745
    //   1737: getstatic 347	oicq/wlogin_sdk/request/WtloginHelper:__top	I
    //   1740: iconst_1
    //   1741: isub
    //   1742: putstatic 347	oicq/wlogin_sdk/request/WtloginHelper:__top	I
    //   1745: new 105	java/lang/StringBuilder
    //   1748: dup
    //   1749: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   1752: astore 17
    //   1754: aload 17
    //   1756: ldc_w 539
    //   1759: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1762: pop
    //   1763: aload 17
    //   1765: getstatic 347	oicq/wlogin_sdk/request/WtloginHelper:__top	I
    //   1768: invokevirtual 272	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1771: pop
    //   1772: aload 17
    //   1774: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1777: ldc 239
    //   1779: invokestatic 276	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1782: aload 15
    //   1784: monitorexit
    //   1785: goto +11 -> 1796
    //   1788: astore 16
    //   1790: aload 15
    //   1792: monitorexit
    //   1793: aload 16
    //   1795: athrow
    //   1796: goto +6 -> 1802
    //   1799: aload 16
    //   1801: athrow
    //   1802: goto -3 -> 1799
    //   1805: astore 15
    //   1807: goto -1175 -> 632
    //   1810: goto -1271 -> 539
    //   1813: astore 15
    //   1815: goto -1183 -> 632
    //   1818: astore 15
    //   1820: iload_2
    //   1821: istore_1
    //   1822: goto -233 -> 1589
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1825	0	this	HelperThread
    //   28	1794	1	i	int
    //   134	1687	2	j	int
    //   466	1003	3	k	int
    //   37	10	4	bool	boolean
    //   400	327	5	l1	long
    //   406	323	7	l2	long
    //   412	322	9	l3	long
    //   423	313	11	l4	long
    //   720	18	13	l5	long
    //   388	214	15	localObject1	Object
    //   620	1	15	localException1	Exception
    //   625	1	15	localObject2	Object
    //   630	6	15	localObject3	Object
    //   1577	1	15	localException2	Exception
    //   1587	3	15	localException3	Exception
    //   1805	1	15	localObject6	Object
    //   1813	1	15	localObject7	Object
    //   1818	1	15	localException4	Exception
    //   379	1166	16	localObject8	Object
    //   1558	6	16	localObject9	Object
    //   1582	1	16	localObject10	Object
    //   1661	21	16	localStringBuilder	StringBuilder
    //   1695	6	16	localObject11	Object
    //   1788	12	16	localObject12	Object
    //   394	1379	17	localObject13	Object
    //   429	16	18	arrayOfLong	long[]
    // Exception table:
    //   from	to	target	type
    //   591	597	620	java/lang/Exception
    //   431	467	625	finally
    //   588	591	625	finally
    //   384	431	630	finally
    //   1503	1517	1558	finally
    //   1517	1557	1558	finally
    //   1560	1563	1558	finally
    //   601	617	1577	java/lang/Exception
    //   635	638	1577	java/lang/Exception
    //   642	651	1577	java/lang/Exception
    //   653	659	1577	java/lang/Exception
    //   661	667	1577	java/lang/Exception
    //   669	675	1577	java/lang/Exception
    //   677	683	1577	java/lang/Exception
    //   685	690	1577	java/lang/Exception
    //   692	698	1577	java/lang/Exception
    //   700	706	1577	java/lang/Exception
    //   708	714	1577	java/lang/Exception
    //   716	722	1577	java/lang/Exception
    //   768	784	1577	java/lang/Exception
    //   789	798	1577	java/lang/Exception
    //   800	825	1577	java/lang/Exception
    //   830	839	1577	java/lang/Exception
    //   841	874	1577	java/lang/Exception
    //   876	894	1577	java/lang/Exception
    //   899	908	1577	java/lang/Exception
    //   910	939	1577	java/lang/Exception
    //   941	959	1577	java/lang/Exception
    //   964	973	1577	java/lang/Exception
    //   975	1008	1577	java/lang/Exception
    //   1010	1028	1577	java/lang/Exception
    //   1033	1042	1577	java/lang/Exception
    //   1044	1065	1577	java/lang/Exception
    //   1067	1085	1577	java/lang/Exception
    //   1090	1099	1577	java/lang/Exception
    //   1101	1118	1577	java/lang/Exception
    //   1120	1138	1577	java/lang/Exception
    //   1143	1152	1577	java/lang/Exception
    //   1154	1183	1577	java/lang/Exception
    //   1188	1197	1577	java/lang/Exception
    //   1199	1216	1577	java/lang/Exception
    //   1218	1236	1577	java/lang/Exception
    //   1241	1250	1577	java/lang/Exception
    //   1252	1273	1577	java/lang/Exception
    //   1275	1293	1577	java/lang/Exception
    //   1298	1307	1577	java/lang/Exception
    //   1309	1338	1577	java/lang/Exception
    //   1340	1358	1577	java/lang/Exception
    //   1363	1372	1577	java/lang/Exception
    //   1374	1395	1577	java/lang/Exception
    //   1397	1415	1577	java/lang/Exception
    //   1420	1429	1577	java/lang/Exception
    //   1431	1456	1577	java/lang/Exception
    //   1458	1476	1577	java/lang/Exception
    //   1566	1577	1577	java/lang/Exception
    //   72	153	1582	finally
    //   156	199	1582	finally
    //   202	253	1582	finally
    //   256	307	1582	finally
    //   310	365	1582	finally
    //   368	384	1582	finally
    //   591	597	1582	finally
    //   601	617	1582	finally
    //   635	638	1582	finally
    //   642	651	1582	finally
    //   653	659	1582	finally
    //   661	667	1582	finally
    //   669	675	1582	finally
    //   677	683	1582	finally
    //   685	690	1582	finally
    //   692	698	1582	finally
    //   700	706	1582	finally
    //   708	714	1582	finally
    //   716	722	1582	finally
    //   722	766	1582	finally
    //   768	784	1582	finally
    //   789	798	1582	finally
    //   800	825	1582	finally
    //   830	839	1582	finally
    //   841	874	1582	finally
    //   876	894	1582	finally
    //   899	908	1582	finally
    //   910	939	1582	finally
    //   941	959	1582	finally
    //   964	973	1582	finally
    //   975	1008	1582	finally
    //   1010	1028	1582	finally
    //   1033	1042	1582	finally
    //   1044	1065	1582	finally
    //   1067	1085	1582	finally
    //   1090	1099	1582	finally
    //   1101	1118	1582	finally
    //   1120	1138	1582	finally
    //   1143	1152	1582	finally
    //   1154	1183	1582	finally
    //   1188	1197	1582	finally
    //   1199	1216	1582	finally
    //   1218	1236	1582	finally
    //   1241	1250	1582	finally
    //   1252	1273	1582	finally
    //   1275	1293	1582	finally
    //   1298	1307	1582	finally
    //   1309	1338	1582	finally
    //   1340	1358	1582	finally
    //   1363	1372	1582	finally
    //   1374	1395	1582	finally
    //   1397	1415	1582	finally
    //   1420	1429	1582	finally
    //   1431	1456	1582	finally
    //   1458	1476	1582	finally
    //   1566	1577	1582	finally
    //   1589	1613	1582	finally
    //   72	153	1587	java/lang/Exception
    //   156	199	1587	java/lang/Exception
    //   202	253	1587	java/lang/Exception
    //   256	307	1587	java/lang/Exception
    //   310	365	1587	java/lang/Exception
    //   368	384	1587	java/lang/Exception
    //   1640	1654	1695	finally
    //   1654	1694	1695	finally
    //   1697	1700	1695	finally
    //   1731	1745	1788	finally
    //   1745	1785	1788	finally
    //   1790	1793	1788	finally
    //   475	536	1805	finally
    //   543	562	1805	finally
    //   571	588	1805	finally
    //   632	635	1813	finally
    //   722	766	1818	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     oicq.wlogin_sdk.request.WtloginHelper.HelperThread
 * JD-Core Version:    0.7.0.1
 */