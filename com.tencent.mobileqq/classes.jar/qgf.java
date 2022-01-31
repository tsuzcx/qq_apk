import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.device.utils.LightAppSettingInfo;

public final class qgf
  implements Parcelable.Creator
{
  public LightAppSettingInfo a(Parcel paramParcel)
  {
    LightAppSettingInfo localLightAppSettingInfo = new LightAppSettingInfo();
    localLightAppSettingInfo.jdField_a_of_type_Int = paramParcel.readInt();
    localLightAppSettingInfo.jdField_b_of_type_Int = paramParcel.readInt();
    localLightAppSettingInfo.jdField_c_of_type_Int = paramParcel.readInt();
    localLightAppSettingInfo.jdField_a_of_type_Long = paramParcel.readLong();
    localLightAppSettingInfo.jdField_a_of_type_JavaUtilArrayList = paramParcel.readArrayList(ClassLoader.getSystemClassLoader());
    localLightAppSettingInfo.jdField_a_of_type_JavaLangString = paramParcel.readString();
    localLightAppSettingInfo.jdField_b_of_type_JavaLangString = paramParcel.readString();
    localLightAppSettingInfo.jdField_d_of_type_Int = paramParcel.readInt();
    localLightAppSettingInfo.jdField_c_of_type_JavaLangString = paramParcel.readString();
    localLightAppSettingInfo.jdField_d_of_type_JavaLangString = paramParcel.readString();
    localLightAppSettingInfo.jdField_e_of_type_JavaLangString = paramParcel.readString();
    localLightAppSettingInfo.f = paramParcel.readString();
    localLightAppSettingInfo.g = paramParcel.readString();
    localLightAppSettingInfo.jdField_e_of_type_Int = paramParcel.readInt();
    localLightAppSettingInfo.jdField_a_of_type_JavaUtilHashMap = paramParcel.readHashMap(ClassLoader.getSystemClassLoader());
    localLightAppSettingInfo.h = paramParcel.readString();
    return localLightAppSettingInfo;
  }
  
  public LightAppSettingInfo[] a(int paramInt)
  {
    return new LightAppSettingInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     qgf
 * JD-Core Version:    0.7.0.1
 */