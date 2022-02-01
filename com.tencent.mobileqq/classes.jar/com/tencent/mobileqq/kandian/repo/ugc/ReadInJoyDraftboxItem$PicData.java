package com.tencent.mobileqq.kandian.repo.ugc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.hotpic.HotPicData;

public class ReadInJoyDraftboxItem$PicData
  implements Parcelable
{
  public static final Parcelable.Creator<PicData> CREATOR = new ReadInJoyDraftboxItem.PicData.1();
  public int a;
  public HotPicData a;
  public String a;
  
  public ReadInJoyDraftboxItem$PicData()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public ReadInJoyDraftboxItem$PicData(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData = ((HotPicData)paramParcel.readParcelable(HotPicData.class.getClassLoader()));
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PicData{hotPicData=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData);
    localStringBuilder.append(", localPic='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicData, paramInt);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.ugc.ReadInJoyDraftboxItem.PicData
 * JD-Core Version:    0.7.0.1
 */