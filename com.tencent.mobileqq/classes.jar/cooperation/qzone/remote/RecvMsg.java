package cooperation.qzone.remote;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bmfa;
import com.tencent.qphone.base.util.QLog;

public class RecvMsg
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator<RecvMsg> CREATOR = new bmfa();
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
  
  /* Error */
  public void readFromParcel(Parcel paramParcel)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 105	android/os/Parcel:readInt	()I
    //   5: putfield 46	cooperation/qzone/remote/RecvMsg:reqSeq	I
    //   8: aload_0
    //   9: aload_1
    //   10: invokevirtual 105	android/os/Parcel:readInt	()I
    //   13: putfield 44	cooperation/qzone/remote/RecvMsg:resultCode	I
    //   16: aload_0
    //   17: aload_1
    //   18: invokevirtual 108	android/os/Parcel:readString	()Ljava/lang/String;
    //   21: putfield 48	cooperation/qzone/remote/RecvMsg:serviceCmd	Ljava/lang/String;
    //   24: aload_0
    //   25: aload_1
    //   26: invokevirtual 108	android/os/Parcel:readString	()Ljava/lang/String;
    //   29: putfield 110	cooperation/qzone/remote/RecvMsg:tmpFileName	Ljava/lang/String;
    //   32: aload_0
    //   33: getfield 41	cooperation/qzone/remote/RecvMsg:extraData	Landroid/os/Bundle;
    //   36: invokevirtual 113	android/os/Bundle:clear	()V
    //   39: aload_1
    //   40: aload_0
    //   41: invokevirtual 117	java/lang/Object:getClass	()Ljava/lang/Class;
    //   44: invokevirtual 123	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   47: invokevirtual 127	android/os/Parcel:readBundle	(Ljava/lang/ClassLoader;)Landroid/os/Bundle;
    //   50: astore_1
    //   51: aload_1
    //   52: invokestatic 133	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   55: invokestatic 139	cooperation/qzone/QzonePluginProxyActivity:a	(Landroid/content/Context;)Ljava/lang/ClassLoader;
    //   58: invokevirtual 143	android/os/Bundle:setClassLoader	(Ljava/lang/ClassLoader;)V
    //   61: aload_0
    //   62: getfield 41	cooperation/qzone/remote/RecvMsg:extraData	Landroid/os/Bundle;
    //   65: aload_1
    //   66: invokevirtual 147	android/os/Bundle:putAll	(Landroid/os/Bundle;)V
    //   69: return
    //   70: astore_2
    //   71: aload_2
    //   72: invokevirtual 150	java/lang/Exception:printStackTrace	()V
    //   75: goto -14 -> 61
    //   78: astore_1
    //   79: ldc 18
    //   81: iconst_1
    //   82: ldc 152
    //   84: aload_1
    //   85: invokestatic 158	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	RecvMsg
    //   0	90	1	paramParcel	Parcel
    //   70	2	2	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   51	61	70	java/lang/Exception
    //   0	51	78	java/lang/RuntimeException
    //   51	61	78	java/lang/RuntimeException
    //   61	69	78	java/lang/RuntimeException
    //   71	75	78	java/lang/RuntimeException
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
    return "RecvMsg ssoseq:" + getRequestSsoSeq() + " resultCode:" + this.resultCode + " serviceCmd:" + this.serviceCmd + " appSeq:" + this.reqSeq;
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