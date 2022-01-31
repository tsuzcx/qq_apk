package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bhfv;
import java.util.HashMap;
import java.util.Map;

public class WeishiOperationInfo
  implements Parcelable
{
  public static final Parcelable.Creator<WeishiOperationInfo> CREATOR = new bhfv();
  public String a;
  public Map<Integer, String> a;
  
  public WeishiOperationInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    paramParcel.readMap(this.jdField_a_of_type_JavaUtilMap, Map.class.getClassLoader());
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
  }
  
  public WeishiOperationInfo(Map<Integer, String> paramMap)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilMap = paramMap;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeMap(this.jdField_a_of_type_JavaUtilMap);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.model.WeishiOperationInfo
 * JD-Core Version:    0.7.0.1
 */