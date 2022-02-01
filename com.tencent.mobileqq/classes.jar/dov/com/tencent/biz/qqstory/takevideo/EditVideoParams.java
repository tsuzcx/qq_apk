package dov.com.tencent.biz.qqstory.takevideo;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bneb;

public class EditVideoParams
  implements Parcelable
{
  public static final Parcelable.Creator<EditVideoParams> CREATOR = new bneb();
  public int a;
  public final Bundle a;
  public EditVideoParams.EditSource a;
  public int b;
  public final int c;
  public int d;
  public int e;
  public int f = -1;
  
  public EditVideoParams(int paramInt1, int paramInt2, EditVideoParams.EditSource paramEditSource, Bundle paramBundle)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.c = paramInt2;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource = paramEditSource;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public EditVideoParams(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.c = paramParcel.readInt();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource = ((EditVideoParams.EditSource)paramParcel.readParcelable(EditVideoParams.EditSource.class.getClassLoader()));
    this.jdField_a_of_type_AndroidOsBundle = paramParcel.readBundle(getClass().getClassLoader());
    this.d = paramParcel.readInt();
    this.e = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.f = paramParcel.readInt();
  }
  
  public static Bundle a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("qq_sub_business_id", 103);
    return localBundle;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 126) || (paramInt == 127) || (paramInt == 128) || (paramInt == 129) || (paramInt == 130);
  }
  
  public double a(String paramString, double paramDouble)
  {
    double d1 = paramDouble;
    if (this.jdField_a_of_type_AndroidOsBundle != null) {
      d1 = this.jdField_a_of_type_AndroidOsBundle.getDouble(paramString, paramDouble);
    }
    return d1;
  }
  
  public int a()
  {
    int j = this.jdField_a_of_type_Int;
    int i = j;
    if (this.jdField_a_of_type_AndroidOsBundle != null)
    {
      i = j;
      if (j == 2)
      {
        j = this.jdField_a_of_type_AndroidOsBundle.getInt("qq_sub_business_id");
        i = j;
        if (j == 0) {
          return 2;
        }
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
  
  public <T extends Parcelable> T a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidOsBundle != null) {
      return this.jdField_a_of_type_AndroidOsBundle.getParcelable(paramString);
    }
    return null;
  }
  
  public String a()
  {
    Object localObject;
    switch (this.jdField_a_of_type_Int)
    {
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 13: 
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
    int j = 0;
    int i = j;
    if (this.jdField_a_of_type_AndroidOsBundle != null)
    {
      i = j;
      if (this.jdField_a_of_type_Int == 2)
      {
        j = this.jdField_a_of_type_AndroidOsBundle.getInt("qq_sub_business_id");
        i = j;
        if (j == 0) {
          i = this.jdField_a_of_type_AndroidOsBundle.getInt("sub_business_id");
        }
      }
    }
    return i;
  }
  
  public boolean b()
  {
    return ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource)) || ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)) || ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource));
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_AndroidOsBundle == null) {
      return 99;
    }
    return this.jdField_a_of_type_AndroidOsBundle.getInt("entrance_type", 99);
  }
  
  public boolean c()
  {
    return ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource)) || ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource)) || ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource));
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_AndroidOsBundle == null) {
      return 1;
    }
    return this.jdField_a_of_type_AndroidOsBundle.getInt("expect_fragment_count", 1);
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
    if (this.jdField_a_of_type_AndroidOsBundle == null) {
      return true;
    }
    return this.jdField_a_of_type_AndroidOsBundle.getBoolean("extra_enable_revert", true);
  }
  
  public boolean f()
  {
    if (this.jdField_a_of_type_AndroidOsBundle == null) {
      return true;
    }
    return this.jdField_a_of_type_AndroidOsBundle.getBoolean("extra_enable_slow", true);
  }
  
  public boolean g()
  {
    if (this.jdField_a_of_type_AndroidOsBundle == null) {
      return false;
    }
    return this.jdField_a_of_type_AndroidOsBundle.getBoolean("enable_hw_encode");
  }
  
  public boolean h()
  {
    return (this.jdField_a_of_type_AndroidOsBundle != null) && (this.jdField_a_of_type_AndroidOsBundle.getBoolean("key_multi_edit_pic"));
  }
  
  public boolean i()
  {
    return (this.jdField_a_of_type_AndroidOsBundle != null) && (this.jdField_a_of_type_AndroidOsBundle.getBoolean("extra_photo_list_to_edit"));
  }
  
  public String toString()
  {
    return "EditVideoParams{mBusinessId=" + this.jdField_a_of_type_Int + ", mEnableMasks=" + this.c + ", mEditSource=" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource + ", entranceType=" + c() + ", mExtra=" + this.jdField_a_of_type_AndroidOsBundle + ", entryType=" + this.f + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.c);
    paramParcel.writeParcelable(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource, paramInt);
    paramParcel.writeBundle(this.jdField_a_of_type_AndroidOsBundle);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoParams
 * JD-Core Version:    0.7.0.1
 */