package dov.com.qq.im.ae.current;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.aio.SessionInfo;

public class SessionWrap
  implements Parcelable
{
  public static final Parcelable.Creator<SessionWrap> CREATOR = new SessionWrap.1();
  public String a;
  public String b;
  public int c;
  public String d;
  
  public SessionWrap(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readInt();
    this.d = paramParcel.readString();
  }
  
  public SessionWrap(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramInt;
    this.d = paramString3;
  }
  
  public SessionInfo a()
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.a = this.c;
    localSessionInfo.e = this.b;
    localSessionInfo.b = this.a;
    localSessionInfo.c = this.d;
    return localSessionInfo;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeString(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     dov.com.qq.im.ae.current.SessionWrap
 * JD-Core Version:    0.7.0.1
 */