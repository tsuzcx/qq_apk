package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bjhi;
import java.util.ArrayList;

public class WeishiShareDataInfo
  implements Parcelable
{
  public static final Parcelable.Creator<WeishiShareDataInfo> CREATOR = new bjhi();
  public String a;
  public ArrayList<WeishiPictureUrl> a;
  public String b;
  
  public WeishiShareDataInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    paramParcel.readTypedList(this.jdField_a_of_type_JavaUtilArrayList, WeishiPictureUrl.CREATOR);
  }
  
  public WeishiShareDataInfo(String paramString1, String paramString2, ArrayList<WeishiPictureUrl> paramArrayList)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeTypedList(this.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.model.WeishiShareDataInfo
 * JD-Core Version:    0.7.0.1
 */