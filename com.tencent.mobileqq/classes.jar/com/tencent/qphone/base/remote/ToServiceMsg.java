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
  private HashMap attributes = new HashMap();
  public Bundle extraData = new Bundle();
  private MsfCommand msfCommand = MsfCommand.unknown;
  private boolean needResp = true;
  private boolean quickSendEnable;
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
    //   2: invokevirtual 117	android/os/Parcel:readInt	()I
    //   5: putfield 119	com/tencent/qphone/base/remote/ToServiceMsg:appId	I
    //   8: aload_0
    //   9: aload_1
    //   10: invokevirtual 117	android/os/Parcel:readInt	()I
    //   13: putfield 61	com/tencent/qphone/base/remote/ToServiceMsg:appSeq	I
    //   16: aload_0
    //   17: aload_1
    //   18: invokevirtual 123	android/os/Parcel:readString	()Ljava/lang/String;
    //   21: putfield 98	com/tencent/qphone/base/remote/ToServiceMsg:serviceName	Ljava/lang/String;
    //   24: aload_0
    //   25: aload_1
    //   26: invokevirtual 123	android/os/Parcel:readString	()Ljava/lang/String;
    //   29: putfield 100	com/tencent/qphone/base/remote/ToServiceMsg:uin	Ljava/lang/String;
    //   32: aload_0
    //   33: aload_1
    //   34: invokevirtual 127	android/os/Parcel:readByte	()B
    //   37: putfield 88	com/tencent/qphone/base/remote/ToServiceMsg:uinType	B
    //   40: aload_0
    //   41: aload_1
    //   42: invokevirtual 123	android/os/Parcel:readString	()Ljava/lang/String;
    //   45: putfield 102	com/tencent/qphone/base/remote/ToServiceMsg:serviceCmd	Ljava/lang/String;
    //   48: aload_0
    //   49: aload_1
    //   50: invokevirtual 131	android/os/Parcel:readLong	()J
    //   53: putfield 59	com/tencent/qphone/base/remote/ToServiceMsg:timeout	J
    //   56: aload_0
    //   57: getfield 77	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   60: invokevirtual 134	android/os/Bundle:clear	()V
    //   63: aload_0
    //   64: getfield 77	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   67: aload_1
    //   68: invokestatic 140	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   71: invokevirtual 144	java/lang/Thread:getContextClassLoader	()Ljava/lang/ClassLoader;
    //   74: invokevirtual 148	android/os/Parcel:readBundle	(Ljava/lang/ClassLoader;)Landroid/os/Bundle;
    //   77: invokevirtual 152	android/os/Bundle:putAll	(Landroid/os/Bundle;)V
    //   80: aload_0
    //   81: aload_1
    //   82: invokevirtual 156	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
    //   85: invokestatic 162	com/tencent/qphone/base/remote/IBaseActionListener$Stub:asInterface	(Landroid/os/IBinder;)Lcom/tencent/qphone/base/remote/IBaseActionListener;
    //   88: putfield 164	com/tencent/qphone/base/remote/ToServiceMsg:actionListener	Lcom/tencent/qphone/base/remote/IBaseActionListener;
    //   91: aload_0
    //   92: aload_0
    //   93: getfield 77	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   96: ldc 14
    //   98: invokevirtual 168	android/os/Bundle:getByte	(Ljava/lang/String;)B
    //   101: putfield 79	com/tencent/qphone/base/remote/ToServiceMsg:toVersion	B
    //   104: aload_0
    //   105: getfield 79	com/tencent/qphone/base/remote/ToServiceMsg:toVersion	B
    //   108: ifle +82 -> 190
    //   111: aload_0
    //   112: aload_1
    //   113: invokevirtual 172	android/os/Parcel:readSerializable	()Ljava/io/Serializable;
    //   116: checkcast 81	com/tencent/mobileqq/msf/sdk/MsfCommand
    //   119: putfield 86	com/tencent/qphone/base/remote/ToServiceMsg:msfCommand	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   122: aload_0
    //   123: aload_1
    //   124: invokevirtual 131	android/os/Parcel:readLong	()J
    //   127: putfield 57	com/tencent/qphone/base/remote/ToServiceMsg:sendTimeout	J
    //   130: aload_1
    //   131: invokevirtual 127	android/os/Parcel:readByte	()B
    //   134: ifne +80 -> 214
    //   137: iconst_0
    //   138: istore_2
    //   139: aload_0
    //   140: iload_2
    //   141: putfield 65	com/tencent/qphone/base/remote/ToServiceMsg:needResp	Z
    //   144: aload_0
    //   145: aload_1
    //   146: invokevirtual 117	android/os/Parcel:readInt	()I
    //   149: newarray byte
    //   151: putfield 63	com/tencent/qphone/base/remote/ToServiceMsg:wupBuffer	[B
    //   154: aload_1
    //   155: aload_0
    //   156: getfield 63	com/tencent/qphone/base/remote/ToServiceMsg:wupBuffer	[B
    //   159: invokevirtual 176	android/os/Parcel:readByteArray	([B)V
    //   162: aload_0
    //   163: aload_1
    //   164: invokevirtual 117	android/os/Parcel:readInt	()I
    //   167: putfield 67	com/tencent/qphone/base/remote/ToServiceMsg:ssoSeq	I
    //   170: aload_0
    //   171: getfield 72	com/tencent/qphone/base/remote/ToServiceMsg:attributes	Ljava/util/HashMap;
    //   174: invokevirtual 177	java/util/HashMap:clear	()V
    //   177: aload_1
    //   178: aload_0
    //   179: getfield 72	com/tencent/qphone/base/remote/ToServiceMsg:attributes	Ljava/util/HashMap;
    //   182: ldc 2
    //   184: invokevirtual 182	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   187: invokevirtual 186	android/os/Parcel:readMap	(Ljava/util/Map;Ljava/lang/ClassLoader;)V
    //   190: aload_1
    //   191: invokevirtual 117	android/os/Parcel:readInt	()I
    //   194: iconst_1
    //   195: if_icmpne +24 -> 219
    //   198: iconst_1
    //   199: istore_2
    //   200: aload_0
    //   201: iload_2
    //   202: putfield 188	com/tencent/qphone/base/remote/ToServiceMsg:quickSendEnable	Z
    //   205: aload_0
    //   206: aload_1
    //   207: invokevirtual 117	android/os/Parcel:readInt	()I
    //   210: putfield 90	com/tencent/qphone/base/remote/ToServiceMsg:quickSendStrategy	I
    //   213: return
    //   214: iconst_1
    //   215: istore_2
    //   216: goto -77 -> 139
    //   219: iconst_0
    //   220: istore_2
    //   221: goto -21 -> 200
    //   224: astore_1
    //   225: ldc 12
    //   227: ldc 190
    //   229: aload_1
    //   230: invokestatic 196	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   233: pop
    //   234: aload_1
    //   235: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	236	0	this	ToServiceMsg
    //   0	236	1	paramParcel	Parcel
    //   138	83	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   0	137	224	java/lang/RuntimeException
    //   139	190	224	java/lang/RuntimeException
    //   190	198	224	java/lang/RuntimeException
    //   200	213	224	java/lang/RuntimeException
  }
  
  public Object addAttribute(String paramString, Object paramObject)
  {
    return this.attributes.put(paramString, paramObject);
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
    //   4: getfield 119	com/tencent/qphone/base/remote/ToServiceMsg:appId	I
    //   7: invokevirtual 342	android/os/Parcel:writeInt	(I)V
    //   10: aload_1
    //   11: aload_0
    //   12: getfield 61	com/tencent/qphone/base/remote/ToServiceMsg:appSeq	I
    //   15: invokevirtual 342	android/os/Parcel:writeInt	(I)V
    //   18: aload_1
    //   19: aload_0
    //   20: getfield 98	com/tencent/qphone/base/remote/ToServiceMsg:serviceName	Ljava/lang/String;
    //   23: invokevirtual 345	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   26: aload_1
    //   27: aload_0
    //   28: getfield 100	com/tencent/qphone/base/remote/ToServiceMsg:uin	Ljava/lang/String;
    //   31: invokevirtual 345	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   34: aload_1
    //   35: aload_0
    //   36: getfield 88	com/tencent/qphone/base/remote/ToServiceMsg:uinType	B
    //   39: invokevirtual 349	android/os/Parcel:writeByte	(B)V
    //   42: aload_1
    //   43: aload_0
    //   44: getfield 102	com/tencent/qphone/base/remote/ToServiceMsg:serviceCmd	Ljava/lang/String;
    //   47: invokevirtual 345	android/os/Parcel:writeString	(Ljava/lang/String;)V
    //   50: aload_1
    //   51: aload_0
    //   52: getfield 59	com/tencent/qphone/base/remote/ToServiceMsg:timeout	J
    //   55: invokevirtual 352	android/os/Parcel:writeLong	(J)V
    //   58: aload_1
    //   59: aload_0
    //   60: getfield 77	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   63: invokevirtual 355	android/os/Parcel:writeBundle	(Landroid/os/Bundle;)V
    //   66: aload_1
    //   67: aload_0
    //   68: getfield 164	com/tencent/qphone/base/remote/ToServiceMsg:actionListener	Lcom/tencent/qphone/base/remote/IBaseActionListener;
    //   71: invokevirtual 359	android/os/Parcel:writeStrongInterface	(Landroid/os/IInterface;)V
    //   74: aload_0
    //   75: getfield 79	com/tencent/qphone/base/remote/ToServiceMsg:toVersion	B
    //   78: ifle +66 -> 144
    //   81: aload_1
    //   82: aload_0
    //   83: getfield 86	com/tencent/qphone/base/remote/ToServiceMsg:msfCommand	Lcom/tencent/mobileqq/msf/sdk/MsfCommand;
    //   86: invokevirtual 363	android/os/Parcel:writeSerializable	(Ljava/io/Serializable;)V
    //   89: aload_1
    //   90: aload_0
    //   91: getfield 57	com/tencent/qphone/base/remote/ToServiceMsg:sendTimeout	J
    //   94: invokevirtual 352	android/os/Parcel:writeLong	(J)V
    //   97: aload_0
    //   98: getfield 65	com/tencent/qphone/base/remote/ToServiceMsg:needResp	Z
    //   101: ifeq +64 -> 165
    //   104: iconst_1
    //   105: istore_3
    //   106: aload_1
    //   107: iload_3
    //   108: invokevirtual 349	android/os/Parcel:writeByte	(B)V
    //   111: aload_1
    //   112: aload_0
    //   113: getfield 63	com/tencent/qphone/base/remote/ToServiceMsg:wupBuffer	[B
    //   116: arraylength
    //   117: invokevirtual 342	android/os/Parcel:writeInt	(I)V
    //   120: aload_1
    //   121: aload_0
    //   122: getfield 63	com/tencent/qphone/base/remote/ToServiceMsg:wupBuffer	[B
    //   125: invokevirtual 366	android/os/Parcel:writeByteArray	([B)V
    //   128: aload_1
    //   129: aload_0
    //   130: getfield 67	com/tencent/qphone/base/remote/ToServiceMsg:ssoSeq	I
    //   133: invokevirtual 342	android/os/Parcel:writeInt	(I)V
    //   136: aload_1
    //   137: aload_0
    //   138: getfield 72	com/tencent/qphone/base/remote/ToServiceMsg:attributes	Ljava/util/HashMap;
    //   141: invokevirtual 370	android/os/Parcel:writeMap	(Ljava/util/Map;)V
    //   144: aload_0
    //   145: getfield 188	com/tencent/qphone/base/remote/ToServiceMsg:quickSendEnable	Z
    //   148: ifeq +22 -> 170
    //   151: aload_1
    //   152: iload_2
    //   153: invokevirtual 342	android/os/Parcel:writeInt	(I)V
    //   156: aload_1
    //   157: aload_0
    //   158: getfield 90	com/tencent/qphone/base/remote/ToServiceMsg:quickSendStrategy	I
    //   161: invokevirtual 342	android/os/Parcel:writeInt	(I)V
    //   164: return
    //   165: iconst_0
    //   166: istore_3
    //   167: goto -61 -> 106
    //   170: iconst_0
    //   171: istore_2
    //   172: goto -21 -> 151
    //   175: astore_1
    //   176: ldc 12
    //   178: ldc_w 372
    //   181: aload_1
    //   182: invokestatic 196	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   185: pop
    //   186: aload_1
    //   187: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	this	ToServiceMsg
    //   0	188	1	paramParcel	Parcel
    //   0	188	2	paramInt	int
    //   105	62	3	b	byte
    // Exception table:
    //   from	to	target	type
    //   2	104	175	java/lang/RuntimeException
    //   106	144	175	java/lang/RuntimeException
    //   144	151	175	java/lang/RuntimeException
    //   151	164	175	java/lang/RuntimeException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.remote.ToServiceMsg
 * JD-Core Version:    0.7.0.1
 */