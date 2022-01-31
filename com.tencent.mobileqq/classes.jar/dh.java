import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.dataline.mpfile.MpfileTaskInfo;

public final class dh
  implements Parcelable.Creator<MpfileTaskInfo>
{
  public MpfileTaskInfo a(Parcel paramParcel)
  {
    MpfileTaskInfo localMpfileTaskInfo = new MpfileTaskInfo();
    localMpfileTaskInfo.jdField_f_of_type_Int = paramParcel.readInt();
    localMpfileTaskInfo.jdField_g_of_type_Int = paramParcel.readInt();
    localMpfileTaskInfo.jdField_a_of_type_JavaLangString = paramParcel.readString();
    localMpfileTaskInfo.jdField_b_of_type_JavaLangString = paramParcel.readString();
    localMpfileTaskInfo.jdField_c_of_type_JavaLangString = paramParcel.readString();
    localMpfileTaskInfo.jdField_d_of_type_JavaLangString = paramParcel.readString();
    localMpfileTaskInfo.jdField_e_of_type_JavaLangString = paramParcel.readString();
    localMpfileTaskInfo.jdField_f_of_type_JavaLangString = paramParcel.readString();
    localMpfileTaskInfo.jdField_g_of_type_JavaLangString = paramParcel.readString();
    localMpfileTaskInfo.h = paramParcel.readString();
    localMpfileTaskInfo.jdField_a_of_type_Long = paramParcel.readLong();
    localMpfileTaskInfo.jdField_b_of_type_Long = paramParcel.readLong();
    localMpfileTaskInfo.jdField_c_of_type_Long = paramParcel.readLong();
    localMpfileTaskInfo.jdField_d_of_type_Long = paramParcel.readLong();
    localMpfileTaskInfo.jdField_e_of_type_Long = paramParcel.readLong();
    localMpfileTaskInfo.jdField_f_of_type_Long = paramParcel.readLong();
    localMpfileTaskInfo.jdField_g_of_type_Long = paramParcel.readLong();
    return localMpfileTaskInfo;
  }
  
  public MpfileTaskInfo[] a(int paramInt)
  {
    return new MpfileTaskInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     dh
 * JD-Core Version:    0.7.0.1
 */