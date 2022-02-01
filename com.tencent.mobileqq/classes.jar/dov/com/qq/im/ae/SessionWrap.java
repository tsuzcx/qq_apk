package dov.com.qq.im.ae;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import boga;
import com.tencent.mobileqq.activity.aio.SessionInfo;

public class SessionWrap
  implements Parcelable
{
  public static final Parcelable.Creator<SessionWrap> CREATOR = new boga();
  public int a;
  public String a;
  public String b;
  public String c;
  
  public SessionWrap(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.c = paramParcel.readString();
  }
  
  public SessionWrap(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Int = paramInt;
    this.c = paramString3;
  }
  
  public SessionInfo a()
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localSessionInfo.d = this.b;
    localSessionInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localSessionInfo.b = this.c;
    return localSessionInfo;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.SessionWrap
 * JD-Core Version:    0.7.0.1
 */