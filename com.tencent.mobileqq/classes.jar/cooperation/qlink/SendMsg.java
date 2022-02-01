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
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = -1L;
  public final Bundle a;
  public String a;
  long b = -1L;
  
  public SendMsg(Parcel paramParcel)
  {
    this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    a(paramParcel);
  }
  
  public SendMsg(String paramString)
  {
    this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void a(Parcel paramParcel)
  {
    try
    {
      this.jdField_a_of_type_Int = paramParcel.readInt();
      this.jdField_a_of_type_JavaLangString = paramParcel.readString();
      this.jdField_a_of_type_Long = paramParcel.readLong();
      this.jdField_a_of_type_AndroidOsBundle.clear();
      this.jdField_a_of_type_AndroidOsBundle.putAll(paramParcel.readBundle(Thread.currentThread().getContextClassLoader()));
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
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SendMsg appSeq:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" serviceCmd:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" timeout:");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    try
    {
      paramParcel.writeInt(this.jdField_a_of_type_Int);
      paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
      paramParcel.writeLong(this.jdField_a_of_type_Long);
      paramParcel.writeBundle(this.jdField_a_of_type_AndroidOsBundle);
      return;
    }
    catch (RuntimeException paramParcel)
    {
      QLog.d("SendMsg", 2, "writeToParcel RuntimeException", paramParcel);
      throw paramParcel;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qlink.SendMsg
 * JD-Core Version:    0.7.0.1
 */