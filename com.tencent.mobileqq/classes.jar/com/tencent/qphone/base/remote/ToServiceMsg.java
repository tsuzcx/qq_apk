package com.tencent.qphone.base.remote;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import java.util.HashMap;

public class ToServiceMsg
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new ToServiceMsg.1();
  private static final String tag = "ToServiceMsg";
  private static final String version = "version";
  public IBaseActionListener actionListener;
  private int appId;
  private int appSeq = -1;
  private HashMap attributes = new HashMap(32);
  public Bundle extraData = new Bundle();
  private boolean mIsSupportRetry = false;
  public boolean mSkipBinderWhenMarshall = false;
  private MsfCommand msfCommand = MsfCommand.unknown;
  private boolean needResp = true;
  private boolean quickSendEnable = false;
  private int quickSendStrategy = -1;
  private long sendTimeout = -1L;
  private String serviceCmd;
  private String serviceName;
  private int ssoSeq = -1;
  private long timeout = -1L;
  private byte toVersion = 1;
  private String uin;
  private byte uinType = 0;
  private byte[] wupBuffer = new byte[0];
  
  public ToServiceMsg(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  public ToServiceMsg(String paramString1, String paramString2, String paramString3)
  {
    this.serviceName = paramString1;
    this.uin = paramString2;
    this.serviceCmd = paramString3;
    try
    {
      this.extraData.putByte("version", this.toVersion);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public Object addAttribute(String paramString, Object paramObject)
  {
    try
    {
      paramString = this.attributes.put(paramString, paramObject);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public IBaseActionListener getActionListener()
  {
    return this.actionListener;
  }
  
  public int getAppId()
  {
    return this.appId;
  }
  
  public int getAppSeq()
  {
    return this.appSeq;
  }
  
  public Object getAttribute(String paramString)
  {
    return this.attributes.get(paramString);
  }
  
  public Object getAttribute(String paramString, Object paramObject)
  {
    if (!this.attributes.containsKey(paramString)) {
      return paramObject;
    }
    return this.attributes.get(paramString);
  }
  
  public HashMap getAttributes()
  {
    return this.attributes;
  }
  
  public String getDestServiceId()
  {
    return this.serviceName;
  }
  
  public MsfCommand getMsfCommand()
  {
    return this.msfCommand;
  }
  
  public int getQuickSendStrategy()
  {
    return this.quickSendStrategy;
  }
  
  public int getRequestSsoSeq()
  {
    return this.ssoSeq;
  }
  
  public long getSendTimeout()
  {
    return this.sendTimeout;
  }
  
  public String getServiceCmd()
  {
    return this.serviceCmd;
  }
  
  public String getServiceName()
  {
    return this.serviceName;
  }
  
  public String getShortStringForLog()
  {
    try
    {
      Object localObject = new StringBuffer(256);
      ((StringBuffer)localObject).append("ToServiceMsg");
      ((StringBuffer)localObject).append(" ssoSeq:");
      ((StringBuffer)localObject).append(getRequestSsoSeq());
      ((StringBuffer)localObject).append(" sCmd:");
      ((StringBuffer)localObject).append(this.serviceCmd);
      ((StringBuffer)localObject).append(" appSeq:");
      ((StringBuffer)localObject).append(this.appSeq);
      ((StringBuffer)localObject).append(" t:");
      ((StringBuffer)localObject).append(this.timeout);
      ((StringBuffer)localObject).append(" needResp:");
      ((StringBuffer)localObject).append(this.needResp);
      ((StringBuffer)localObject).append(" needQuickSend:");
      ((StringBuffer)localObject).append(this.quickSendEnable);
      ((StringBuffer)localObject).append("IsSupportRetry");
      ((StringBuffer)localObject).append(this.mIsSupportRetry);
      localObject = ((StringBuffer)localObject).toString();
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "fsm getString error";
  }
  
  public String getStringForLog()
  {
    try
    {
      Object localObject = new StringBuffer(256);
      ((StringBuffer)localObject).append("ToServiceMsg");
      ((StringBuffer)localObject).append(" msName:");
      ((StringBuffer)localObject).append(this.msfCommand);
      ((StringBuffer)localObject).append(" ssoSeq:");
      ((StringBuffer)localObject).append(getRequestSsoSeq());
      ((StringBuffer)localObject).append(" appId:");
      ((StringBuffer)localObject).append(this.appId);
      ((StringBuffer)localObject).append(" appSeq:");
      ((StringBuffer)localObject).append(this.appSeq);
      ((StringBuffer)localObject).append(" sName:");
      ((StringBuffer)localObject).append(this.serviceName);
      ((StringBuffer)localObject).append(" uin:");
      ((StringBuffer)localObject).append(MsfSdkUtils.getShortUin(this.uin));
      ((StringBuffer)localObject).append(" sCmd:");
      ((StringBuffer)localObject).append(this.serviceCmd);
      ((StringBuffer)localObject).append(" t:");
      ((StringBuffer)localObject).append(this.timeout);
      ((StringBuffer)localObject).append(" needResp:");
      ((StringBuffer)localObject).append(this.needResp);
      ((StringBuffer)localObject).append(" needQuickSend:");
      ((StringBuffer)localObject).append(this.quickSendEnable);
      ((StringBuffer)localObject).append(" strategy:");
      ((StringBuffer)localObject).append(this.quickSendStrategy);
      ((StringBuffer)localObject).append("IsSupportRetry");
      ((StringBuffer)localObject).append(this.mIsSupportRetry);
      localObject = ((StringBuffer)localObject).toString();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return "TSM getString error";
  }
  
  public long getTimeout()
  {
    return this.timeout;
  }
  
  public String getUin()
  {
    return this.uin;
  }
  
  public byte getUinType()
  {
    return this.uinType;
  }
  
  public byte[] getWupBuffer()
  {
    return this.wupBuffer;
  }
  
  public boolean isFastResendEnabled()
  {
    return ((Boolean)getAttribute("fastresend", Boolean.valueOf(false))).booleanValue();
  }
  
  public boolean isNeedCallback()
  {
    return this.needResp;
  }
  
  public boolean isNeedRemindSlowNetwork()
  {
    return ((Boolean)getAttribute("remind_slown_network", Boolean.valueOf(false))).booleanValue();
  }
  
  public boolean isQuickSendEnable()
  {
    return this.quickSendEnable;
  }
  
  public boolean isSupportRetry()
  {
    return this.mIsSupportRetry;
  }
  
  public void putWupBuffer(byte[] paramArrayOfByte)
  {
    this.wupBuffer = paramArrayOfByte;
  }
  
  /* Error */
  public void readFromParcel(Parcel paramParcel)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 256	android/os/Parcel:readInt	()I
    //   5: putfield 134	com/tencent/qphone/base/remote/ToServiceMsg:appId	I
    //   8: aload_0
    //   9: aload_1
    //   10: invokevirtual 256	android/os/Parcel:readInt	()I
    //   13: putfield 63	com/tencent/qphone/base/remote/ToServiceMsg:appSeq	I
    //   16: aload_0
    //   17: aload_1
    //   18: invokevirtual 259	android/os/Parcel:readString	()Ljava/lang/String;
    //   21: putfield 108	com/tencent/qphone/base/remote/ToServiceMsg:serviceName	Ljava/lang/String;
    //   24: aload_0
    //   25: aload_1
    //   26: invokevirtual 259	android/os/Parcel:readString	()Ljava/lang/String;
    //   29: putfield 110	com/tencent/qphone/base/remote/ToServiceMsg:uin	Ljava/lang/String;
    //   32: aload_0
    //   33: aload_1
    //   34: invokevirtual 262	android/os/Parcel:readByte	()B
    //   37: putfield 94	com/tencent/qphone/base/remote/ToServiceMsg:uinType	B
    //   40: aload_0
    //   41: aload_1
    //   42: invokevirtual 259	android/os/Parcel:readString	()Ljava/lang/String;
    //   45: putfield 112	com/tencent/qphone/base/remote/ToServiceMsg:serviceCmd	Ljava/lang/String;
    //   48: aload_0
    //   49: aload_1
    //   50: invokevirtual 265	android/os/Parcel:readLong	()J
    //   53: putfield 61	com/tencent/qphone/base/remote/ToServiceMsg:timeout	J
    //   56: aload_0
    //   57: getfield 83	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   60: invokevirtual 268	android/os/Bundle:clear	()V
    //   63: aload_0
    //   64: getfield 83	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   67: aload_1
    //   68: invokestatic 274	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   71: invokevirtual 278	java/lang/Thread:getContextClassLoader	()Ljava/lang/ClassLoader;
    //   74: invokevirtual 282	android/os/Parcel:readBundle	(Ljava/lang/ClassLoader;)Landroid/os/Bundle;
    //   77: invokevirtual 286	android/os/Bundle:putAll	(Landroid/os/Bundle;)V
    //   80: aload_0
    //   81: getfield 100	com/tencent/qphone/base/remote/ToServiceMsg:mSkipBinderWhenMarshall	Z
    //   84: ifne +14 -> 98
    //   87: aload_0
    //   88: aload_1
    //   89: invokevirtual 290	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
    //   92: invokestatic 296	com/tencent/qphone/base/remote/IBaseActionListener$Stub:asInterface	(Landroid/os/IBinder;)Lcom/tencent/qphone/base/remote/IBaseActionListener;
    //   95: putfield 131	com/tencent/qphone/base/remote/ToServiceMsg:actionListener	Lcom/tencent/qphone/base/remote/IBaseActionListener;
    //   98: aload_0
    //   99: aload_0
    //   100: getfield 83	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   103: ldc 14
    //   105: invokevirtual 300	android/os/Bundle:getByte	(Ljava/lang/String;)B
    //   108: putfield 85	com/tencent/qphone/base/remote/ToServiceMsg:toVersion	B
    //   111: aload_0
    //   112: getfield 85	com/tencent/qphone/base/remote/ToServiceMsg:toVersion	B
    //   115: ifle +96 -> 211
    //   118: aload_0
    //   119: aload_1
    //   120: invokevirtual 304	android/os/Parcel:readSerializable	()Ljava/io/Serializable;
    //   123: checkcast 87	com/tencent/mobileqq/msf/sdk/MsfCommand
    //   126: putfield 92	com/tencent/qphone/base/remote/ToServiceMsg:msfCommand	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   129: aload_0
    //   130: aload_1
    //   131: invokevirtual 265	android/os/Parcel:readLong	()J
    //   134: putfield 59	com/tencent/qphone/base/remote/ToServiceMsg:sendTimeout	J
    //   137: aload_1
    //   138: invokevirtual 262	android/os/Parcel:readByte	()B
    //   141: ifne +94 -> 235
    //   144: iconst_0
    //   145: istore_2
    //   146: aload_0
    //   147: iload_2
    //   148: putfield 67	com/tencent/qphone/base/remote/ToServiceMsg:needResp	Z
    //   151: aload_1
    //   152: invokevirtual 262	android/os/Parcel:readByte	()B
    //   155: ifne +85 -> 240
    //   158: iconst_0
    //   159: istore_2
    //   160: aload_0
    //   161: iload_2
    //   162: putfield 69	com/tencent/qphone/base/remote/ToServiceMsg:mIsSupportRetry	Z
    //   165: aload_0
    //   166: aload_1
    //   167: invokevirtual 256	android/os/Parcel:readInt	()I
    //   170: newarray byte
    //   172: putfield 65	com/tencent/qphone/base/remote/ToServiceMsg:wupBuffer	[B
    //   175: aload_1
    //   176: aload_0
    //   177: getfield 65	com/tencent/qphone/base/remote/ToServiceMsg:wupBuffer	[B
    //   180: invokevirtual 307	android/os/Parcel:readByteArray	([B)V
    //   183: aload_0
    //   184: aload_1
    //   185: invokevirtual 256	android/os/Parcel:readInt	()I
    //   188: putfield 71	com/tencent/qphone/base/remote/ToServiceMsg:ssoSeq	I
    //   191: aload_0
    //   192: getfield 78	com/tencent/qphone/base/remote/ToServiceMsg:attributes	Ljava/util/HashMap;
    //   195: invokevirtual 308	java/util/HashMap:clear	()V
    //   198: aload_1
    //   199: aload_0
    //   200: getfield 78	com/tencent/qphone/base/remote/ToServiceMsg:attributes	Ljava/util/HashMap;
    //   203: ldc 2
    //   205: invokevirtual 313	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   208: invokevirtual 317	android/os/Parcel:readMap	(Ljava/util/Map;Ljava/lang/ClassLoader;)V
    //   211: aload_1
    //   212: invokevirtual 256	android/os/Parcel:readInt	()I
    //   215: iconst_1
    //   216: if_icmpne +29 -> 245
    //   219: iconst_1
    //   220: istore_2
    //   221: aload_0
    //   222: iload_2
    //   223: putfield 96	com/tencent/qphone/base/remote/ToServiceMsg:quickSendEnable	Z
    //   226: aload_0
    //   227: aload_1
    //   228: invokevirtual 256	android/os/Parcel:readInt	()I
    //   231: putfield 98	com/tencent/qphone/base/remote/ToServiceMsg:quickSendStrategy	I
    //   234: return
    //   235: iconst_1
    //   236: istore_2
    //   237: goto -91 -> 146
    //   240: iconst_1
    //   241: istore_2
    //   242: goto -82 -> 160
    //   245: iconst_0
    //   246: istore_2
    //   247: goto -26 -> 221
    //   250: astore_1
    //   251: ldc 12
    //   253: ldc_w 319
    //   256: aload_1
    //   257: invokestatic 325	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   260: pop
    //   261: aload_1
    //   262: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	this	ToServiceMsg
    //   0	263	1	paramParcel	Parcel
    //   145	102	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   0	98	250	java/lang/RuntimeException
    //   98	144	250	java/lang/RuntimeException
    //   146	158	250	java/lang/RuntimeException
    //   160	211	250	java/lang/RuntimeException
    //   211	219	250	java/lang/RuntimeException
    //   221	234	250	java/lang/RuntimeException
  }
  
  public void setAppId(int paramInt)
  {
    this.appId = paramInt;
  }
  
  public void setAppSeq(int paramInt)
  {
    this.appSeq = paramInt;
  }
  
  public void setAttributes(HashMap paramHashMap)
  {
    this.attributes = paramHashMap;
  }
  
  public void setEnableFastResend(boolean paramBoolean)
  {
    addAttribute("fastresend", Boolean.valueOf(paramBoolean));
  }
  
  public void setIsSupportRetry(boolean paramBoolean)
  {
    this.mIsSupportRetry = paramBoolean;
  }
  
  public void setMsfCommand(MsfCommand paramMsfCommand)
  {
    this.msfCommand = paramMsfCommand;
  }
  
  public void setNeedCallback(boolean paramBoolean)
  {
    this.needResp = paramBoolean;
  }
  
  public void setNeedRemindSlowNetwork(boolean paramBoolean)
  {
    addAttribute("remind_slown_network", Boolean.valueOf(paramBoolean));
  }
  
  public void setQuickSend(boolean paramBoolean, int paramInt)
  {
    this.quickSendEnable = paramBoolean;
    this.quickSendStrategy = paramInt;
  }
  
  public void setRequestSsoSeq(int paramInt)
  {
    this.ssoSeq = paramInt;
  }
  
  public void setSendTimeout(long paramLong)
  {
    this.sendTimeout = paramLong;
  }
  
  public void setServiceCmd(String paramString)
  {
    this.serviceCmd = paramString;
  }
  
  public void setServiceName(String paramString)
  {
    this.serviceName = paramString;
  }
  
  public void setTimeout(long paramLong)
  {
    this.timeout = paramLong;
  }
  
  public void setUin(String paramString)
  {
    this.uin = paramString;
  }
  
  public void setUinType(byte paramByte)
  {
    this.uinType = paramByte;
  }
  
  public String toString()
  {
    try
    {
      Object localObject = new StringBuffer(256);
      ((StringBuffer)localObject).append("ToServiceMsg");
      ((StringBuffer)localObject).append(" msName:");
      ((StringBuffer)localObject).append(this.msfCommand);
      ((StringBuffer)localObject).append(" ssoSeq:");
      ((StringBuffer)localObject).append(getRequestSsoSeq());
      ((StringBuffer)localObject).append(" appId:");
      ((StringBuffer)localObject).append(this.appId);
      ((StringBuffer)localObject).append(" appSeq:");
      ((StringBuffer)localObject).append(this.appSeq);
      ((StringBuffer)localObject).append(" sName:");
      ((StringBuffer)localObject).append(this.serviceName);
      ((StringBuffer)localObject).append(" uin:");
      ((StringBuffer)localObject).append(this.uin);
      ((StringBuffer)localObject).append(" sCmd:");
      ((StringBuffer)localObject).append(this.serviceCmd);
      ((StringBuffer)localObject).append(" t:");
      ((StringBuffer)localObject).append(this.timeout);
      ((StringBuffer)localObject).append(" needResp:");
      ((StringBuffer)localObject).append(this.needResp);
      ((StringBuffer)localObject).append(" needQuickSend:");
      ((StringBuffer)localObject).append(this.quickSendEnable);
      ((StringBuffer)localObject).append(" strategy:");
      ((StringBuffer)localObject).append(this.quickSendStrategy);
      ((StringBuffer)localObject).append("IsSupportRetry");
      ((StringBuffer)localObject).append(this.mIsSupportRetry);
      localObject = ((StringBuffer)localObject).toString();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return "TSM toString error";
  }
  
  /* Error */
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_1
    //   3: aload_0
    //   4: getfield 134	com/tencent/qphone/base/remote/ToServiceMsg:appId	I
    //   7: invokevirtual 357	android/os/Parcel:writeInt	(I)V
    //   10: aload_1
    //   11: aload_0
    //   12: getfield 63	com/tencent/qphone/base/remote/ToServiceMsg:appSeq	I
    //   15: invokevirtual 357	android/os/Parcel:writeInt	(I)V
    //   18: aload_1
    //   19: aload_0
    //   20: getfield 108	com/tencent/qphone/base/remote/ToServiceMsg:serviceName	Ljava/lang/String;
    //   23: invokevirtual 360	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   26: aload_1
    //   27: aload_0
    //   28: getfield 110	com/tencent/qphone/base/remote/ToServiceMsg:uin	Ljava/lang/String;
    //   31: invokevirtual 360	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   34: aload_1
    //   35: aload_0
    //   36: getfield 94	com/tencent/qphone/base/remote/ToServiceMsg:uinType	B
    //   39: invokevirtual 363	android/os/Parcel:writeByte	(B)V
    //   42: aload_1
    //   43: aload_0
    //   44: getfield 112	com/tencent/qphone/base/remote/ToServiceMsg:serviceCmd	Ljava/lang/String;
    //   47: invokevirtual 360	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   50: aload_1
    //   51: aload_0
    //   52: getfield 61	com/tencent/qphone/base/remote/ToServiceMsg:timeout	J
    //   55: invokevirtual 366	android/os/Parcel:writeLong	(J)V
    //   58: aload_1
    //   59: aload_0
    //   60: getfield 83	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   63: invokevirtual 369	android/os/Parcel:writeBundle	(Landroid/os/Bundle;)V
    //   66: aload_0
    //   67: getfield 100	com/tencent/qphone/base/remote/ToServiceMsg:mSkipBinderWhenMarshall	Z
    //   70: ifne +11 -> 81
    //   73: aload_1
    //   74: aload_0
    //   75: getfield 131	com/tencent/qphone/base/remote/ToServiceMsg:actionListener	Lcom/tencent/qphone/base/remote/IBaseActionListener;
    //   78: invokevirtual 373	android/os/Parcel:writeStrongInterface	(Landroid/os/IInterface;)V
    //   81: aload_0
    //   82: getfield 85	com/tencent/qphone/base/remote/ToServiceMsg:toVersion	B
    //   85: ifle +80 -> 165
    //   88: aload_1
    //   89: aload_0
    //   90: getfield 92	com/tencent/qphone/base/remote/ToServiceMsg:msfCommand	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   93: invokevirtual 377	android/os/Parcel:writeSerializable	(Ljava/io/Serializable;)V
    //   96: aload_1
    //   97: aload_0
    //   98: getfield 59	com/tencent/qphone/base/remote/ToServiceMsg:sendTimeout	J
    //   101: invokevirtual 366	android/os/Parcel:writeLong	(J)V
    //   104: aload_0
    //   105: getfield 67	com/tencent/qphone/base/remote/ToServiceMsg:needResp	Z
    //   108: ifeq +78 -> 186
    //   111: iconst_1
    //   112: istore_3
    //   113: aload_1
    //   114: iload_3
    //   115: invokevirtual 363	android/os/Parcel:writeByte	(B)V
    //   118: aload_0
    //   119: getfield 69	com/tencent/qphone/base/remote/ToServiceMsg:mIsSupportRetry	Z
    //   122: ifeq +69 -> 191
    //   125: iconst_1
    //   126: istore_3
    //   127: aload_1
    //   128: iload_3
    //   129: invokevirtual 363	android/os/Parcel:writeByte	(B)V
    //   132: aload_1
    //   133: aload_0
    //   134: getfield 65	com/tencent/qphone/base/remote/ToServiceMsg:wupBuffer	[B
    //   137: arraylength
    //   138: invokevirtual 357	android/os/Parcel:writeInt	(I)V
    //   141: aload_1
    //   142: aload_0
    //   143: getfield 65	com/tencent/qphone/base/remote/ToServiceMsg:wupBuffer	[B
    //   146: invokevirtual 380	android/os/Parcel:writeByteArray	([B)V
    //   149: aload_1
    //   150: aload_0
    //   151: getfield 71	com/tencent/qphone/base/remote/ToServiceMsg:ssoSeq	I
    //   154: invokevirtual 357	android/os/Parcel:writeInt	(I)V
    //   157: aload_1
    //   158: aload_0
    //   159: getfield 78	com/tencent/qphone/base/remote/ToServiceMsg:attributes	Ljava/util/HashMap;
    //   162: invokevirtual 384	android/os/Parcel:writeMap	(Ljava/util/Map;)V
    //   165: aload_0
    //   166: getfield 96	com/tencent/qphone/base/remote/ToServiceMsg:quickSendEnable	Z
    //   169: ifeq +27 -> 196
    //   172: aload_1
    //   173: iload_2
    //   174: invokevirtual 357	android/os/Parcel:writeInt	(I)V
    //   177: aload_1
    //   178: aload_0
    //   179: getfield 98	com/tencent/qphone/base/remote/ToServiceMsg:quickSendStrategy	I
    //   182: invokevirtual 357	android/os/Parcel:writeInt	(I)V
    //   185: return
    //   186: iconst_0
    //   187: istore_3
    //   188: goto -75 -> 113
    //   191: iconst_0
    //   192: istore_3
    //   193: goto -66 -> 127
    //   196: iconst_0
    //   197: istore_2
    //   198: goto -26 -> 172
    //   201: astore_1
    //   202: ldc 12
    //   204: ldc_w 386
    //   207: aload_1
    //   208: invokestatic 325	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   211: pop
    //   212: aload_1
    //   213: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	this	ToServiceMsg
    //   0	214	1	paramParcel	Parcel
    //   0	214	2	paramInt	int
    //   112	81	3	b	byte
    // Exception table:
    //   from	to	target	type
    //   2	81	201	java/lang/RuntimeException
    //   81	111	201	java/lang/RuntimeException
    //   113	125	201	java/lang/RuntimeException
    //   127	165	201	java/lang/RuntimeException
    //   165	172	201	java/lang/RuntimeException
    //   172	185	201	java/lang/RuntimeException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.remote.ToServiceMsg
 * JD-Core Version:    0.7.0.1
 */