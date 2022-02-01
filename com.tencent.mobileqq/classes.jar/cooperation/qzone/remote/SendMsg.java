package cooperation.qzone.remote;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.qphone.base.util.QLog;

public class SendMsg
  implements Parcelable
{
  public static final Parcelable.Creator<SendMsg> CREATOR = new SendMsg.1();
  private static final String tag = "SendMsg";
  public IActionListener actionListener;
  public final Bundle extraData = new Bundle();
  int requestId;
  long sendTime = -1L;
  public String serviceCmd;
  long timeout = -1L;
  
  public SendMsg(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  public SendMsg(String paramString)
  {
    this.serviceCmd = paramString;
  }
  
  /* Error */
  private void readFromParcel(Parcel paramParcel)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 62	android/os/Parcel:readInt	()I
    //   5: putfield 64	cooperation/qzone/remote/SendMsg:requestId	I
    //   8: aload_0
    //   9: aload_1
    //   10: invokevirtual 68	android/os/Parcel:readString	()Ljava/lang/String;
    //   13: putfield 52	cooperation/qzone/remote/SendMsg:serviceCmd	Ljava/lang/String;
    //   16: aload_0
    //   17: aload_1
    //   18: invokevirtual 72	android/os/Parcel:readLong	()J
    //   21: putfield 44	cooperation/qzone/remote/SendMsg:timeout	J
    //   24: aload_0
    //   25: getfield 40	cooperation/qzone/remote/SendMsg:extraData	Landroid/os/Bundle;
    //   28: invokevirtual 75	android/os/Bundle:clear	()V
    //   31: aload_1
    //   32: aload_0
    //   33: invokevirtual 79	java/lang/Object:getClass	()Ljava/lang/Class;
    //   36: invokevirtual 85	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   39: invokevirtual 89	android/os/Parcel:readBundle	(Ljava/lang/ClassLoader;)Landroid/os/Bundle;
    //   42: astore_2
    //   43: aload_2
    //   44: invokestatic 95	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   47: invokestatic 101	cooperation/qzone/QzonePluginProxyActivity:getQZonePluginClassLoader	(Landroid/content/Context;)Ljava/lang/ClassLoader;
    //   50: invokevirtual 105	android/os/Bundle:setClassLoader	(Ljava/lang/ClassLoader;)V
    //   53: aload_0
    //   54: getfield 40	cooperation/qzone/remote/SendMsg:extraData	Landroid/os/Bundle;
    //   57: aload_2
    //   58: invokevirtual 109	android/os/Bundle:putAll	(Landroid/os/Bundle;)V
    //   61: aload_0
    //   62: aload_1
    //   63: invokevirtual 113	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
    //   66: invokestatic 119	cooperation/qzone/remote/IActionListener$Stub:asInterface	(Landroid/os/IBinder;)Lcooperation/qzone/remote/IActionListener;
    //   69: putfield 121	cooperation/qzone/remote/SendMsg:actionListener	Lcooperation/qzone/remote/IActionListener;
    //   72: return
    //   73: astore_3
    //   74: aload_3
    //   75: invokevirtual 124	java/lang/Exception:printStackTrace	()V
    //   78: goto -25 -> 53
    //   81: astore_1
    //   82: ldc 13
    //   84: iconst_1
    //   85: ldc 126
    //   87: aload_1
    //   88: invokestatic 132	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   91: aload_1
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	SendMsg
    //   0	93	1	paramParcel	Parcel
    //   42	16	2	localBundle	Bundle
    //   73	2	3	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   43	53	73	java/lang/Exception
    //   0	43	81	java/lang/RuntimeException
    //   43	53	81	java/lang/RuntimeException
    //   53	72	81	java/lang/RuntimeException
    //   74	78	81	java/lang/RuntimeException
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public IActionListener getActionListener()
  {
    return this.actionListener;
  }
  
  public Bundle getExtraData()
  {
    return this.extraData;
  }
  
  public int getRequestId()
  {
    return this.requestId;
  }
  
  public long getSendTime()
  {
    return this.sendTime;
  }
  
  public String getServiceCmd()
  {
    return this.serviceCmd;
  }
  
  public long getTimeout()
  {
    return this.timeout;
  }
  
  public byte[] getWupBuffer()
  {
    return this.extraData.getByteArray("wup");
  }
  
  public boolean isNeedCallback()
  {
    return this.extraData.getBoolean("needCallback", true);
  }
  
  public void putWupBuffer(byte[] paramArrayOfByte)
  {
    this.extraData.putByteArray("wup", paramArrayOfByte);
  }
  
  public void setNeedCallback(boolean paramBoolean)
  {
    this.extraData.putBoolean("needCallback", paramBoolean);
  }
  
  public void setRequestId(int paramInt)
  {
    this.requestId = paramInt;
  }
  
  public void setSendTime(long paramLong)
  {
    this.sendTime = paramLong;
  }
  
  public void setTimeout(long paramLong)
  {
    this.timeout = paramLong;
  }
  
  public String toString()
  {
    return "SendMsg appSeq:" + this.requestId + " serviceCmd:" + this.serviceCmd + " timeout:" + this.timeout;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    try
    {
      paramParcel.writeInt(this.requestId);
      paramParcel.writeString(this.serviceCmd);
      paramParcel.writeLong(this.timeout);
      paramParcel.writeBundle(this.extraData);
      paramParcel.writeStrongInterface(this.actionListener);
      return;
    }
    catch (RuntimeException paramParcel)
    {
      QLog.w("SendMsg", 1, "writeToParcel RuntimeException", paramParcel);
      throw paramParcel;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.remote.SendMsg
 * JD-Core Version:    0.7.0.1
 */