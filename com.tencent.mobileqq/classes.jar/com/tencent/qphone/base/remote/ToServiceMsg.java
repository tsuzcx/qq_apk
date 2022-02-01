package com.tencent.qphone.base.remote;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;
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
  
  public void readFromParcel(Parcel paramParcel)
  {
    for (;;)
    {
      try
      {
        this.appId = paramParcel.readInt();
        this.appSeq = paramParcel.readInt();
        this.serviceName = paramParcel.readString();
        this.uin = paramParcel.readString();
        this.uinType = paramParcel.readByte();
        this.serviceCmd = paramParcel.readString();
        this.timeout = paramParcel.readLong();
        this.extraData.clear();
        this.extraData.putAll(paramParcel.readBundle(Thread.currentThread().getContextClassLoader()));
        if (!this.mSkipBinderWhenMarshall) {
          this.actionListener = IBaseActionListener.Stub.asInterface(paramParcel.readStrongBinder());
        }
        this.toVersion = this.extraData.getByte("version");
        int i = this.toVersion;
        boolean bool2 = false;
        if (i > 0)
        {
          this.msfCommand = ((MsfCommand)paramParcel.readSerializable());
          this.sendTimeout = paramParcel.readLong();
          if (paramParcel.readByte() == 0)
          {
            bool1 = false;
            this.needResp = bool1;
            if (paramParcel.readByte() != 0) {
              break label267;
            }
            bool1 = false;
            this.mIsSupportRetry = bool1;
            this.wupBuffer = new byte[paramParcel.readInt()];
            paramParcel.readByteArray(this.wupBuffer);
            this.ssoSeq = paramParcel.readInt();
            this.attributes.clear();
            paramParcel.readMap(this.attributes, ToServiceMsg.class.getClassLoader());
          }
        }
        else
        {
          bool1 = bool2;
          if (paramParcel.readInt() == 1) {
            bool1 = true;
          }
          this.quickSendEnable = bool1;
          this.quickSendStrategy = paramParcel.readInt();
          return;
        }
      }
      catch (RuntimeException paramParcel)
      {
        Log.d("ToServiceMsg", "readFromParcel RuntimeException", paramParcel);
        throw paramParcel;
      }
      boolean bool1 = true;
      continue;
      label267:
      bool1 = true;
    }
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
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    for (;;)
    {
      try
      {
        paramParcel.writeInt(this.appId);
        paramParcel.writeInt(this.appSeq);
        paramParcel.writeString(this.serviceName);
        paramParcel.writeString(this.uin);
        paramParcel.writeByte(this.uinType);
        paramParcel.writeString(this.serviceCmd);
        paramParcel.writeLong(this.timeout);
        paramParcel.writeBundle(this.extraData);
        if (!this.mSkipBinderWhenMarshall) {
          paramParcel.writeStrongInterface(this.actionListener);
        }
        int i = this.toVersion;
        paramInt = 1;
        if (i > 0)
        {
          paramParcel.writeSerializable(this.msfCommand);
          paramParcel.writeLong(this.sendTimeout);
          if (this.needResp)
          {
            b = 1;
            paramParcel.writeByte(b);
            if (!this.mIsSupportRetry) {
              break label217;
            }
            b = 1;
            paramParcel.writeByte(b);
            paramParcel.writeInt(this.wupBuffer.length);
            paramParcel.writeByteArray(this.wupBuffer);
            paramParcel.writeInt(this.ssoSeq);
            paramParcel.writeMap(this.attributes);
          }
        }
        else
        {
          if (!this.quickSendEnable) {
            break label222;
          }
          paramParcel.writeInt(paramInt);
          paramParcel.writeInt(this.quickSendStrategy);
          return;
        }
      }
      catch (RuntimeException paramParcel)
      {
        Log.d("ToServiceMsg", "writeToParcel RuntimeException", paramParcel);
        throw paramParcel;
      }
      byte b = 0;
      continue;
      label217:
      b = 0;
      continue;
      label222:
      paramInt = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qphone.base.remote.ToServiceMsg
 * JD-Core Version:    0.7.0.1
 */