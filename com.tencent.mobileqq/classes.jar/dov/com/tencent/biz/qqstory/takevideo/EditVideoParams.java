package dov.com.tencent.biz.qqstory.takevideo;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import aneb;

public class EditVideoParams
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new aneb();
  public int a;
  public final Bundle a;
  public EditVideoParams.EditSource a;
  public final int b;
  public int c;
  public int d;
  
  public EditVideoParams(int paramInt1, int paramInt2, EditVideoParams.EditSource paramEditSource, Bundle paramBundle)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource = paramEditSource;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public EditVideoParams(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource = ((EditVideoParams.EditSource)paramParcel.readParcelable(EditVideoParams.EditSource.class.getClassLoader()));
    this.jdField_a_of_type_AndroidOsBundle = paramParcel.readBundle(getClass().getClassLoader());
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
  }
  
  public static Bundle a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 101: 
    case 10004: 
      localBundle = new Bundle();
      localBundle.putInt("qq_sub_business_id", 101);
      return localBundle;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("qq_sub_business_id", 102);
    return localBundle;
  }
  
  public int a()
  {
    int j = this.jdField_a_of_type_Int;
    int i = j;
    if (this.jdField_a_of_type_AndroidOsBundle != null)
    {
      i = j;
      if (j == 2) {
        i = this.jdField_a_of_type_AndroidOsBundle.getInt("qq_sub_business_id");
      }
    }
    return i;
  }
  
  public int a(String paramString, int paramInt)
  {
    int i = paramInt;
    if (this.jdField_a_of_type_AndroidOsBundle != null) {
      i = this.jdField_a_of_type_AndroidOsBundle.getInt(paramString, paramInt);
    }
    return i;
  }
  
  public String a()
  {
    Object localObject;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      localObject = "Unknown Business id " + this.jdField_a_of_type_Int;
    }
    String str;
    do
    {
      return localObject;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource == null) {
        return "Can not find edit source";
      }
      str = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b();
      localObject = str;
    } while (str != null);
    return null;
  }
  
  public String a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidOsBundle != null) {
      return this.jdField_a_of_type_AndroidOsBundle.getString(paramString);
    }
    return null;
  }
  
  public boolean a()
  {
    return ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource)) || ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource));
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (this.jdField_a_of_type_AndroidOsBundle != null) {
      bool = this.jdField_a_of_type_AndroidOsBundle.getBoolean(paramString, paramBoolean);
    }
    return bool;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_AndroidOsBundle == null) {
      return 99;
    }
    return this.jdField_a_of_type_AndroidOsBundle.getInt("entrance_type", 99);
  }
  
  public boolean b()
  {
    return ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource)) || ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)) || ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource));
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_AndroidOsBundle == null) {
      return 1;
    }
    return this.jdField_a_of_type_AndroidOsBundle.getInt("expect_fragment_count", 1);
  }
  
  public boolean c()
  {
    return ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource)) || ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource)) || ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource));
  }
  
  public boolean d()
  {
    return ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)) || ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalGifSource;
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeGifSource;
  }
  
  public boolean g()
  {
    return false;
  }
  
  public boolean h()
  {
    if (this.jdField_a_of_type_AndroidOsBundle == null) {
      return false;
    }
    return this.jdField_a_of_type_AndroidOsBundle.getBoolean("enable_hw_encode");
  }
  
  public String toString()
  {
    return "EditVideoParams{mBusinessId=" + this.jdField_a_of_type_Int + ", mEnableMasks=" + this.b + ", mEditSource=" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource + ", entranceType=" + b() + ", mExtra=" + this.jdField_a_of_type_AndroidOsBundle + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.b);
    paramParcel.writeParcelable(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource, paramInt);
    paramParcel.writeBundle(this.jdField_a_of_type_AndroidOsBundle);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoParams
 * JD-Core Version:    0.7.0.1
 */