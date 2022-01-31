package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bfws;
import java.util.ArrayList;

public class WeishiInterestInfo
  implements Parcelable
{
  public static final Parcelable.Creator<WeishiInterestInfo> CREATOR = new bfws();
  public String a;
  public ArrayList<Long> a;
  
  public WeishiInterestInfo() {}
  
  public WeishiInterestInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramParcel.readArrayList(Long.class.getClassLoader());
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeList(this.jdField_a_of_type_JavaUtilArrayList);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.model.WeishiInterestInfo
 * JD-Core Version:    0.7.0.1
 */