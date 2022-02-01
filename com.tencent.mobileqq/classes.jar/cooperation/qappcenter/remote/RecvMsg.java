package cooperation.qappcenter.remote;

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
  public int a;
  public String b;
  public int c;
  public Bundle d = new Bundle();
  
  public RecvMsg() {}
  
  public RecvMsg(int paramInt, String paramString)
  {
    this.a = 1001;
    this.c = paramInt;
    this.b = paramString;
  }
  
  public RecvMsg(Parcel paramParcel)
  {
    a(paramParcel);
  }
  
  public int a()
  {
    return this.d.getInt("_ssoSeqKey", -1);
  }
  
  public void a(int paramInt, String paramString)
  {
    this.a = paramInt;
    this.d.putString("error", paramString);
  }
  
  public void a(Parcel paramParcel)
  {
    try
    {
      this.c = paramParcel.readInt();
      this.a = paramParcel.readInt();
      this.b = paramParcel.readString();
      this.d.clear();
      paramParcel = paramParcel.readBundle(getClass().getClassLoader());
      try
      {
        paramParcel.setClassLoader(QzonePluginProxyActivity.getQZonePluginClassLoader(BaseApplicationImpl.getApplication()));
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      this.d.putAll(paramParcel);
      return;
    }
    catch (RuntimeException paramParcel)
    {
      QLog.w("RecvMsg", 1, "readFromParcel RuntimeException", paramParcel);
      throw paramParcel;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RecvMsg ssoseq:");
    localStringBuilder.append(a());
    localStringBuilder.append(" resultCode:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" serviceCmd:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" appSeq:");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    try
    {
      paramParcel.writeInt(this.c);
      paramParcel.writeInt(this.a);
      paramParcel.writeString(this.b);
      paramParcel.writeBundle(this.d);
      return;
    }
    catch (RuntimeException paramParcel)
    {
      QLog.w("RecvMsg", 1, "writeToParcel RuntimeException", paramParcel);
      throw paramParcel;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qappcenter.remote.RecvMsg
 * JD-Core Version:    0.7.0.1
 */