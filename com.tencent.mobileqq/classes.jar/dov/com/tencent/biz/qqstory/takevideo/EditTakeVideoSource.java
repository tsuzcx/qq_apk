package dov.com.tencent.biz.qqstory.takevideo;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import bdyh;
import bndf;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.io.File;

public class EditTakeVideoSource
  implements EditVideoParams.EditSource
{
  public static final Parcelable.Creator<EditTakeVideoSource> CREATOR = new bndf();
  @NonNull
  public final LocalMediaInfo a;
  @NonNull
  public final String a;
  @NonNull
  public final String b;
  public final String c;
  
  public EditTakeVideoSource(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = ((LocalMediaInfo)paramParcel.readParcelable(bdyh.class.getClassLoader()));
    this.c = paramParcel.readString();
  }
  
  public EditTakeVideoSource(String paramString1, String paramString2, LocalMediaInfo paramLocalMediaInfo)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = paramLocalMediaInfo;
    this.c = "";
    paramString1 = b();
    if (paramString1 != null) {
      throw new IllegalArgumentException(paramString1);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth;
  }
  
  @NonNull
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight;
  }
  
  public String b()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return "sourcePath is empty";
    }
    if (!new File(this.jdField_a_of_type_JavaLangString).exists()) {
      return "Can not find file by sourcePath = " + this.jdField_a_of_type_JavaLangString;
    }
    if (!new File(this.b).exists()) {
      return "Can not find file by audioSourcePath = " + this.b;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo == null) {
      return "media info should not be null";
    }
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "EditTakeVideoSource: sourcePath=" + this.jdField_a_of_type_JavaLangString + " audioSourcePath=" + this.b + " mediaInfo=" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo + " audioBgmSourcePath=" + this.c;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, 0);
    paramParcel.writeString(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource
 * JD-Core Version:    0.7.0.1
 */