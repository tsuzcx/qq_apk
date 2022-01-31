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
  
  /* Error */
  private void readFromParcel(Parcel paramParcel)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 124	android/os/Parcel:readInt	()I
    //   5: putfield 126	com/tencent/qphone/base/remote/ToServiceMsg:appId	I
    //   8: aload_0
    //   9: aload_1
    //   10: invokevirtual 124	android/os/Parcel:readInt	()I
    //   13: putfield 62	com/tencent/qphone/base/remote/ToServiceMsg:appSeq	I
    //   16: aload_0
    //   17: aload_1
    //   18: invokevirtual 130	android/os/Parcel:readString	()Ljava/lang/String;
    //   21: putfield 105	com/tencent/qphone/base/remote/ToServiceMsg:serviceName	Ljava/lang/String;
    //   24: aload_0
    //   25: aload_1
    //   26: invokevirtual 130	android/os/Parcel:readString	()Ljava/lang/String;
    //   29: putfield 107	com/tencent/qphone/base/remote/ToServiceMsg:uin	Ljava/lang/String;
    //   32: aload_0
    //   33: aload_1
    //   34: invokevirtual 134	android/os/Parcel:readByte	()B
    //   37: putfield 93	com/tencent/qphone/base/remote/ToServiceMsg:uinType	B
    //   40: aload_0
    //   41: aload_1
    //   42: invokevirtual 130	android/os/Parcel:readString	()Ljava/lang/String;
    //   45: putfield 109	com/tencent/qphone/base/remote/ToServiceMsg:serviceCmd	Ljava/lang/String;
    //   48: aload_0
    //   49: aload_1
    //   50: invokevirtual 138	android/os/Parcel:readLong	()J
    //   53: putfield 60	com/tencent/qphone/base/remote/ToServiceMsg:timeout	J
    //   56: aload_0
    //   57: getfield 82	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   60: invokevirtual 141	android/os/Bundle:clear	()V
    //   63: aload_0
    //   64: getfield 82	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   67: aload_1
    //   68: invokestatic 147	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   71: invokevirtual 151	java/lang/Thread:getContextClassLoader	()Ljava/lang/ClassLoader;
    //   74: invokevirtual 155	android/os/Parcel:readBundle	(Ljava/lang/ClassLoader;)Landroid/os/Bundle;
    //   77: invokevirtual 159	android/os/Bundle:putAll	(Landroid/os/Bundle;)V
    //   80: aload_0
    //   81: aload_1
    //   82: invokevirtual 163	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
    //   85: invokestatic 169	com/tencent/qphone/base/remote/IBaseActionListener$Stub:asInterface	(Landroid/os/IBinder;)Lcom/tencent/qphone/base/remote/IBaseActionListener;
    //   88: putfield 171	com/tencent/qphone/base/remote/ToServiceMsg:actionListener	Lcom/tencent/qphone/base/remote/IBaseActionListener;
    //   91: aload_0
    //   92: aload_0
    //   93: getfield 82	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   96: ldc 14
    //   98: invokevirtual 175	android/os/Bundle:getByte	(Ljava/lang/String;)B
    //   101: putfield 84	com/tencent/qphone/base/remote/ToServiceMsg:toVersion	B
    //   104: aload_0
    //   105: getfield 84	com/tencent/qphone/base/remote/ToServiceMsg:toVersion	B
    //   108: ifle +96 -> 204
    //   111: aload_0
    //   112: aload_1
    //   113: invokevirtual 179	android/os/Parcel:readSerializable	()Ljava/io/Serializable;
    //   116: checkcast 86	com/tencent/mobileqq/msf/sdk/MsfCommand
    //   119: putfield 91	com/tencent/qphone/base/remote/ToServiceMsg:msfCommand	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   122: aload_0
    //   123: aload_1
    //   124: invokevirtual 138	android/os/Parcel:readLong	()J
    //   127: putfield 58	com/tencent/qphone/base/remote/ToServiceMsg:sendTimeout	J
    //   130: aload_1
    //   131: invokevirtual 134	android/os/Parcel:readByte	()B
    //   134: ifne +94 -> 228
    //   137: iconst_0
    //   138: istore_2
    //   139: aload_0
    //   140: iload_2
    //   141: putfield 66	com/tencent/qphone/base/remote/ToServiceMsg:needResp	Z
    //   144: aload_1
    //   145: invokevirtual 134	android/os/Parcel:readByte	()B
    //   148: ifne +85 -> 233
    //   151: iconst_0
    //   152: istore_2
    //   153: aload_0
    //   154: iload_2
    //   155: putfield 68	com/tencent/qphone/base/remote/ToServiceMsg:mIsSupportRetry	Z
    //   158: aload_0
    //   159: aload_1
    //   160: invokevirtual 124	android/os/Parcel:readInt	()I
    //   163: newarray byte
    //   165: putfield 64	com/tencent/qphone/base/remote/ToServiceMsg:wupBuffer	[B
    //   168: aload_1
    //   169: aload_0
    //   170: getfield 64	com/tencent/qphone/base/remote/ToServiceMsg:wupBuffer	[B
    //   173: invokevirtual 183	android/os/Parcel:readByteArray	([B)V
    //   176: aload_0
    //   177: aload_1
    //   178: invokevirtual 124	android/os/Parcel:readInt	()I
    //   181: putfield 70	com/tencent/qphone/base/remote/ToServiceMsg:ssoSeq	I
    //   184: aload_0
    //   185: getfield 77	com/tencent/qphone/base/remote/ToServiceMsg:attributes	Ljava/util/HashMap;
    //   188: invokevirtual 184	java/util/HashMap:clear	()V
    //   191: aload_1
    //   192: aload_0
    //   193: getfield 77	com/tencent/qphone/base/remote/ToServiceMsg:attributes	Ljava/util/HashMap;
    //   196: ldc 2
    //   198: invokevirtual 189	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   201: invokevirtual 193	android/os/Parcel:readMap	(Ljava/util/Map;Ljava/lang/ClassLoader;)V
    //   204: aload_1
    //   205: invokevirtual 124	android/os/Parcel:readInt	()I
    //   208: iconst_1
    //   209: if_icmpne +29 -> 238
    //   212: iconst_1
    //   213: istore_2
    //   214: aload_0
    //   215: iload_2
    //   216: putfield 95	com/tencent/qphone/base/remote/ToServiceMsg:quickSendEnable	Z
    //   219: aload_0
    //   220: aload_1
    //   221: invokevirtual 124	android/os/Parcel:readInt	()I
    //   224: putfield 97	com/tencent/qphone/base/remote/ToServiceMsg:quickSendStrategy	I
    //   227: return
    //   228: iconst_1
    //   229: istore_2
    //   230: goto -91 -> 139
    //   233: iconst_1
    //   234: istore_2
    //   235: goto -82 -> 153
    //   238: iconst_0
    //   239: istore_2
    //   240: goto -26 -> 214
    //   243: astore_1
    //   244: ldc 12
    //   246: ldc 195
    //   248: aload_1
    //   249: invokestatic 201	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   252: pop
    //   253: aload_1
    //   254: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	255	0	this	ToServiceMsg
    //   0	255	1	paramParcel	Parcel
    //   138	102	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   0	137	243	java/lang/RuntimeException
    //   139	151	243	java/lang/RuntimeException
    //   153	204	243	java/lang/RuntimeException
    //   204	212	243	java/lang/RuntimeException
    //   214	227	243	java/lang/RuntimeException
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
    //   4: getfield 126	com/tencent/qphone/base/remote/ToServiceMsg:appId	I
    //   7: invokevirtual 349	android/os/Parcel:writeInt	(I)V
    //   10: aload_1
    //   11: aload_0
    //   12: getfield 62	com/tencent/qphone/base/remote/ToServiceMsg:appSeq	I
    //   15: invokevirtual 349	android/os/Parcel:writeInt	(I)V
    //   18: aload_1
    //   19: aload_0
    //   20: getfield 105	com/tencent/qphone/base/remote/ToServiceMsg:serviceName	Ljava/lang/String;
    //   23: invokevirtual 352	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   26: aload_1
    //   27: aload_0
    //   28: getfield 107	com/tencent/qphone/base/remote/ToServiceMsg:uin	Ljava/lang/String;
    //   31: invokevirtual 352	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   34: aload_1
    //   35: aload_0
    //   36: getfield 93	com/tencent/qphone/base/remote/ToServiceMsg:uinType	B
    //   39: invokevirtual 356	android/os/Parcel:writeByte	(B)V
    //   42: aload_1
    //   43: aload_0
    //   44: getfield 109	com/tencent/qphone/base/remote/ToServiceMsg:serviceCmd	Ljava/lang/String;
    //   47: invokevirtual 352	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   50: aload_1
    //   51: aload_0
    //   52: getfield 60	com/tencent/qphone/base/remote/ToServiceMsg:timeout	J
    //   55: invokevirtual 359	android/os/Parcel:writeLong	(J)V
    //   58: aload_1
    //   59: aload_0
    //   60: getfield 82	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   63: invokevirtual 362	android/os/Parcel:writeBundle	(Landroid/os/Bundle;)V
    //   66: aload_1
    //   67: aload_0
    //   68: getfield 171	com/tencent/qphone/base/remote/ToServiceMsg:actionListener	Lcom/tencent/qphone/base/remote/IBaseActionListener;
    //   71: invokevirtual 366	android/os/Parcel:writeStrongInterface	(Landroid/os/IInterface;)V
    //   74: aload_0
    //   75: getfield 84	com/tencent/qphone/base/remote/ToServiceMsg:toVersion	B
    //   78: ifle +80 -> 158
    //   81: aload_1
    //   82: aload_0
    //   83: getfield 91	com/tencent/qphone/base/remote/ToServiceMsg:msfCommand	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   86: invokevirtual 370	android/os/Parcel:writeSerializable	(Ljava/io/Serializable;)V
    //   89: aload_1
    //   90: aload_0
    //   91: getfield 58	com/tencent/qphone/base/remote/ToServiceMsg:sendTimeout	J
    //   94: invokevirtual 359	android/os/Parcel:writeLong	(J)V
    //   97: aload_0
    //   98: getfield 66	com/tencent/qphone/base/remote/ToServiceMsg:needResp	Z
    //   101: ifeq +78 -> 179
    //   104: iconst_1
    //   105: istore_3
    //   106: aload_1
    //   107: iload_3
    //   108: invokevirtual 356	android/os/Parcel:writeByte	(B)V
    //   111: aload_0
    //   112: getfield 68	com/tencent/qphone/base/remote/ToServiceMsg:mIsSupportRetry	Z
    //   115: ifeq +69 -> 184
    //   118: iconst_1
    //   119: istore_3
    //   120: aload_1
    //   121: iload_3
    //   122: invokevirtual 356	android/os/Parcel:writeByte	(B)V
    //   125: aload_1
    //   126: aload_0
    //   127: getfield 64	com/tencent/qphone/base/remote/ToServiceMsg:wupBuffer	[B
    //   130: arraylength
    //   131: invokevirtual 349	android/os/Parcel:writeInt	(I)V
    //   134: aload_1
    //   135: aload_0
    //   136: getfield 64	com/tencent/qphone/base/remote/ToServiceMsg:wupBuffer	[B
    //   139: invokevirtual 373	android/os/Parcel:writeByteArray	([B)V
    //   142: aload_1
    //   143: aload_0
    //   144: getfield 70	com/tencent/qphone/base/remote/ToServiceMsg:ssoSeq	I
    //   147: invokevirtual 349	android/os/Parcel:writeInt	(I)V
    //   150: aload_1
    //   151: aload_0
    //   152: getfield 77	com/tencent/qphone/base/remote/ToServiceMsg:attributes	Ljava/util/HashMap;
    //   155: invokevirtual 377	android/os/Parcel:writeMap	(Ljava/util/Map;)V
    //   158: aload_0
    //   159: getfield 95	com/tencent/qphone/base/remote/ToServiceMsg:quickSendEnable	Z
    //   162: ifeq +27 -> 189
    //   165: aload_1
    //   166: iload_2
    //   167: invokevirtual 349	android/os/Parcel:writeInt	(I)V
    //   170: aload_1
    //   171: aload_0
    //   172: getfield 97	com/tencent/qphone/base/remote/ToServiceMsg:quickSendStrategy	I
    //   175: invokevirtual 349	android/os/Parcel:writeInt	(I)V
    //   178: return
    //   179: iconst_0
    //   180: istore_3
    //   181: goto -75 -> 106
    //   184: iconst_0
    //   185: istore_3
    //   186: goto -66 -> 120
    //   189: iconst_0
    //   190: istore_2
    //   191: goto -26 -> 165
    //   194: astore_1
    //   195: ldc 12
    //   197: ldc_w 379
    //   200: aload_1
    //   201: invokestatic 201	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   204: pop
    //   205: aload_1
    //   206: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	this	ToServiceMsg
    //   0	207	1	paramParcel	Parcel
    //   0	207	2	paramInt	int
    //   105	81	3	b	byte
    // Exception table:
    //   from	to	target	type
    //   2	104	194	java/lang/RuntimeException
    //   106	118	194	java/lang/RuntimeException
    //   120	158	194	java/lang/RuntimeException
    //   158	165	194	java/lang/RuntimeException
    //   165	178	194	java/lang/RuntimeException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.remote.ToServiceMsg
 * JD-Core Version:    0.7.0.1
 */