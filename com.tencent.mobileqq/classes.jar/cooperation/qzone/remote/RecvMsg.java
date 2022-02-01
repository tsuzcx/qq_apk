package cooperation.qzone.remote;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzonePluginProxyActivity;

public class RecvMsg
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator<RecvMsg> CREATOR = new RecvMsg.1();
  public static final String SSOSEQ_KEY = "_ssoSeqKey";
  private static final String tag = "RecvMsg";
  public Bundle extraData = new Bundle();
  public int reqSeq;
  public int resultCode;
  public String serviceCmd;
  public String tmpFileName;
  
  public RecvMsg() {}
  
  public RecvMsg(int paramInt, String paramString)
  {
    this.resultCode = 1001;
    this.reqSeq = paramInt;
    this.serviceCmd = paramString;
  }
  
  public RecvMsg(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  public RecvMsg(String paramString)
  {
    this(-1, paramString);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getBusinessFailMsg()
  {
    if (this.extraData.containsKey("error")) {
      return this.extraData.getString("error");
    }
    return null;
  }
  
  public int getMsgResultCode()
  {
    return this.resultCode;
  }
  
  public int getRequestId()
  {
    return this.reqSeq;
  }
  
  public int getRequestSsoSeq()
  {
    return this.extraData.getInt("_ssoSeqKey", -1);
  }
  
  public int getResultCode()
  {
    return this.resultCode;
  }
  
  public String getServiceCmd()
  {
    return this.serviceCmd;
  }
  
  public byte[] getWupBuffer()
  {
    if (this.extraData.containsKey("wup")) {
      return (byte[])this.extraData.get("wup");
    }
    return null;
  }
  
  public boolean isSuccess()
  {
    return this.resultCode == 1000;
  }
  
  public void putWupBuffer(byte[] paramArrayOfByte)
  {
    this.extraData.putByteArray("wup", paramArrayOfByte);
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    try
    {
      this.reqSeq = paramParcel.readInt();
      this.resultCode = paramParcel.readInt();
      this.serviceCmd = paramParcel.readString();
      this.tmpFileName = paramParcel.readString();
      this.extraData.clear();
      paramParcel = paramParcel.readBundle(getClass().getClassLoader());
      try
      {
        paramParcel.setClassLoader(QzonePluginProxyActivity.getQZonePluginClassLoader(BaseApplicationImpl.getApplication()));
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      this.extraData.putAll(paramParcel);
      return;
    }
    catch (RuntimeException paramParcel)
    {
      QLog.w("RecvMsg", 1, "readFromParcel RuntimeException", paramParcel);
      throw paramParcel;
    }
  }
  
  public void setBusinessFail()
  {
    this.resultCode = 1001;
  }
  
  public void setBusinessFail(int paramInt, String paramString)
  {
    this.resultCode = paramInt;
    this.extraData.putString("error", paramString);
  }
  
  public void setBusinessFail(String paramString)
  {
    this.resultCode = 1001;
    this.extraData.putString("error", paramString);
  }
  
  public void setMsgFail()
  {
    this.resultCode = 1001;
  }
  
  public void setMsgResult(int paramInt)
  {
    this.resultCode = paramInt;
  }
  
  public void setMsgSuccess()
  {
    this.resultCode = 1000;
  }
  
  public void setRequestId(int paramInt)
  {
    this.reqSeq = paramInt;
  }
  
  public void setRequestSsoSeq(int paramInt)
  {
    this.extraData.putInt("_ssoSeqKey", paramInt);
  }
  
  public void setServiceCmd(String paramString)
  {
    this.serviceCmd = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RecvMsg ssoseq:");
    localStringBuilder.append(getRequestSsoSeq());
    localStringBuilder.append(" resultCode:");
    localStringBuilder.append(this.resultCode);
    localStringBuilder.append(" serviceCmd:");
    localStringBuilder.append(this.serviceCmd);
    localStringBuilder.append(" appSeq:");
    localStringBuilder.append(this.reqSeq);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    try
    {
      paramParcel.writeInt(this.reqSeq);
      paramParcel.writeInt(this.resultCode);
      paramParcel.writeString(this.serviceCmd);
      paramParcel.writeString(this.tmpFileName);
      paramParcel.writeBundle(this.extraData);
      return;
    }
    catch (RuntimeException paramParcel)
    {
      QLog.w("RecvMsg", 1, "writeToParcel RuntimeException", paramParcel);
      throw paramParcel;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.remote.RecvMsg
 * JD-Core Version:    0.7.0.1
 */