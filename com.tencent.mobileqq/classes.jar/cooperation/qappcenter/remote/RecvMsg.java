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
  public Bundle a;
  public String a;
  public int b;
  
  public RecvMsg()
  {
    this.jdField_a_of_type_AndroidOsBundle = new Bundle();
  }
  
  public RecvMsg(int paramInt, String paramString)
  {
    this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    this.jdField_a_of_type_Int = 1001;
    this.b = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public RecvMsg(Parcel paramParcel)
  {
    this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    a(paramParcel);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidOsBundle.getInt("_ssoSeqKey", -1);
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidOsBundle.putString("error", paramString);
  }
  
  public void a(Parcel paramParcel)
  {
    try
    {
      this.b = paramParcel.readInt();
      this.jdField_a_of_type_Int = paramParcel.readInt();
      this.jdField_a_of_type_JavaLangString = paramParcel.readString();
      this.jdField_a_of_type_AndroidOsBundle.clear();
      paramParcel = paramParcel.readBundle(getClass().getClassLoader());
      try
      {
        paramParcel.setClassLoader(QzonePluginProxyActivity.getQZonePluginClassLoader(BaseApplicationImpl.getApplication()));
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      this.jdField_a_of_type_AndroidOsBundle.putAll(paramParcel);
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
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" serviceCmd:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" appSeq:");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    try
    {
      paramParcel.writeInt(this.b);
      paramParcel.writeInt(this.jdField_a_of_type_Int);
      paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
      paramParcel.writeBundle(this.jdField_a_of_type_AndroidOsBundle);
      return;
    }
    catch (RuntimeException paramParcel)
    {
      QLog.w("RecvMsg", 1, "writeToParcel RuntimeException", paramParcel);
      throw paramParcel;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qappcenter.remote.RecvMsg
 * JD-Core Version:    0.7.0.1
 */