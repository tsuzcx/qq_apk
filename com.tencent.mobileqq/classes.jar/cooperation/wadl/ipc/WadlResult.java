package cooperation.wadl.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bdop;
import bice;

public class WadlResult
  implements Parcelable
{
  public static final Parcelable.Creator<WadlResult> CREATOR = new bice();
  public int a;
  public long a;
  public WadlParams a;
  public String a;
  public int b;
  public long b;
  public String b;
  public int c;
  public long c;
  public int d;
  
  public WadlResult(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_CooperationWadlIpcWadlParams = ((WadlParams)paramParcel.readParcelable(WadlParams.class.getClassLoader()));
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_b_of_type_Long = paramParcel.readLong();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_Long = paramParcel.readLong();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.d = paramParcel.readInt();
  }
  
  public WadlResult(WadlParams paramWadlParams)
  {
    this.jdField_a_of_type_JavaLangString = "";
    if (paramWadlParams != null) {
      this.jdField_a_of_type_CooperationWadlIpcWadlParams = paramWadlParams;
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_CooperationWadlIpcWadlParams != null) {}
    for (String str = this.jdField_a_of_type_CooperationWadlIpcWadlParams.j;; str = "")
    {
      this.jdField_b_of_type_Int = bdop.a(this.jdField_b_of_type_Int, str, this.jdField_b_of_type_JavaLangString);
      if (this.jdField_b_of_type_Int != 0) {
        break;
      }
      return false;
    }
    return true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "WadlResult{wadlParams=" + this.jdField_a_of_type_CooperationWadlIpcWadlParams + ", event=" + this.jdField_a_of_type_Int + ", taskId='" + this.jdField_a_of_type_JavaLangString + '\'' + ", taskStatus=" + this.jdField_b_of_type_Int + ", fileSize=" + this.jdField_a_of_type_Long + ", downloadFileSize=" + this.jdField_b_of_type_Long + ", downloadFilePath='" + this.jdField_b_of_type_JavaLangString + '\'' + ", createTime=" + this.jdField_c_of_type_Long + ", errCode=" + this.jdField_c_of_type_Int + ", progress=" + this.d + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.jdField_a_of_type_CooperationWadlIpcWadlParams, paramInt);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeLong(this.jdField_c_of_type_Long);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeInt(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.wadl.ipc.WadlResult
 * JD-Core Version:    0.7.0.1
 */