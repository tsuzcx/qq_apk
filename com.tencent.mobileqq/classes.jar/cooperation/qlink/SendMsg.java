package cooperation.qlink;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.qphone.base.util.QLog;

public class SendMsg
  implements Parcelable
{
  public static final Parcelable.Creator<SendMsg> CREATOR = new SendMsg.1();
  public String a;
  public final Bundle b = new Bundle();
  long c = -1L;
  long d = -1L;
  int e;
  
  public SendMsg(Parcel paramParcel)
  {
    a(paramParcel);
  }
  
  public SendMsg(String paramString)
  {
    this.a = paramString;
  }
  
  private void a(Parcel paramParcel)
  {
    try
    {
      this.e = paramParcel.readInt();
      this.a = paramParcel.readString();
      this.c = paramParcel.readLong();
      this.b.clear();
      this.b.putAll(paramParcel.readBundle(Thread.currentThread().getContextClassLoader()));
      return;
    }
    catch (RuntimeException paramParcel)
    {
      QLog.d("SendMsg", 2, "readFromParcel RuntimeException", paramParcel);
      throw paramParcel;
    }
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.c = paramLong;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SendMsg appSeq:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" serviceCmd:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" timeout:");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    try
    {
      paramParcel.writeInt(this.e);
      paramParcel.writeString(this.a);
      paramParcel.writeLong(this.c);
      paramParcel.writeBundle(this.b);
      return;
    }
    catch (RuntimeException paramParcel)
    {
      QLog.d("SendMsg", 2, "writeToParcel RuntimeException", paramParcel);
      throw paramParcel;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qlink.SendMsg
 * JD-Core Version:    0.7.0.1
 */