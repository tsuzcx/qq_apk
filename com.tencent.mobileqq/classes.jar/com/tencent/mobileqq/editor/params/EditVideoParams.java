package com.tencent.mobileqq.editor.params;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class EditVideoParams
  implements Parcelable
{
  public static final Parcelable.Creator<EditVideoParams> CREATOR = new EditVideoParams.1();
  public int a;
  public final Bundle a;
  public EditVideoParams.EditSource a;
  public int b;
  public final int c;
  public int d = 0;
  public int e = 0;
  public int f = -1;
  
  public EditVideoParams(int paramInt1, int paramInt2, EditVideoParams.EditSource paramEditSource, Bundle paramBundle)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.c = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource = paramEditSource;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  protected EditVideoParams(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.c = paramParcel.readInt();
    this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource = ((EditVideoParams.EditSource)paramParcel.readParcelable(EditVideoParams.EditSource.class.getClassLoader()));
    this.jdField_a_of_type_AndroidOsBundle = paramParcel.readBundle(getClass().getClassLoader());
    this.d = paramParcel.readInt();
    this.e = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.f = paramParcel.readInt();
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 126) || (paramInt == 127) || (paramInt == 128) || (paramInt == 129) || (paramInt == 130);
  }
  
  public int a()
  {
    int j = this.jdField_a_of_type_Int;
    Bundle localBundle = this.jdField_a_of_type_AndroidOsBundle;
    int i = j;
    if (localBundle != null)
    {
      i = j;
      if (j == 2)
      {
        j = localBundle.getInt("qq_sub_business_id");
        i = j;
        if (j == 0) {
          i = 2;
        }
      }
    }
    return i;
  }
  
  public int a(String paramString, int paramInt)
  {
    Bundle localBundle = this.jdField_a_of_type_AndroidOsBundle;
    if (localBundle != null) {
      return localBundle.getInt(paramString, paramInt);
    }
    return paramInt;
  }
  
  public String a()
  {
    int i = this.jdField_a_of_type_Int;
    if ((i != 2) && (i != 3) && (i != 4) && (i != 5) && (i != 6) && (i != 11) && (i != 12) && (i != 14) && (i != 15))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Unknown Business id ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      return ((StringBuilder)localObject).toString();
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource;
    if (localObject == null) {
      return "Can not find edit source";
    }
    return ((EditVideoParams.EditSource)localObject).b();
  }
  
  public String a(String paramString)
  {
    Bundle localBundle = this.jdField_a_of_type_AndroidOsBundle;
    if (localBundle != null) {
      return localBundle.getString(paramString);
    }
    return null;
  }
  
  public boolean a()
  {
    EditVideoParams.EditSource localEditSource = this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource;
    return ((localEditSource instanceof EditTakePhotoSource)) || ((localEditSource instanceof EditLocalPhotoSource));
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    Bundle localBundle = this.jdField_a_of_type_AndroidOsBundle;
    if (localBundle != null) {
      return localBundle.getBoolean(paramString, paramBoolean);
    }
    return paramBoolean;
  }
  
  public int b()
  {
    Bundle localBundle = this.jdField_a_of_type_AndroidOsBundle;
    if ((localBundle != null) && (this.jdField_a_of_type_Int == 2)) {
      return localBundle.getInt("qq_sub_business_id");
    }
    return 0;
  }
  
  public boolean b()
  {
    EditVideoParams.EditSource localEditSource = this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource;
    return ((localEditSource instanceof EditLocalVideoSource)) || ((localEditSource instanceof EditTakeVideoSource));
  }
  
  public int c()
  {
    Bundle localBundle = this.jdField_a_of_type_AndroidOsBundle;
    if (localBundle == null) {
      return 99;
    }
    return localBundle.getInt("entrance_type", 99);
  }
  
  public boolean c()
  {
    EditVideoParams.EditSource localEditSource = this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource;
    return ((localEditSource instanceof EditTakePhotoSource)) || ((localEditSource instanceof EditTakeVideoSource));
  }
  
  public boolean d()
  {
    EditVideoParams.EditSource localEditSource = this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource;
    return ((localEditSource instanceof EditLocalVideoSource)) || ((localEditSource instanceof EditLocalPhotoSource));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean e()
  {
    Bundle localBundle = this.jdField_a_of_type_AndroidOsBundle;
    if (localBundle == null) {
      return true;
    }
    return localBundle.getBoolean("extra_enable_revert", true);
  }
  
  public boolean f()
  {
    Bundle localBundle = this.jdField_a_of_type_AndroidOsBundle;
    if (localBundle == null) {
      return true;
    }
    return localBundle.getBoolean("extra_enable_slow", true);
  }
  
  public boolean g()
  {
    Bundle localBundle = this.jdField_a_of_type_AndroidOsBundle;
    if (localBundle == null) {
      return false;
    }
    return localBundle.getBoolean("enable_hw_encode");
  }
  
  public boolean h()
  {
    Bundle localBundle = this.jdField_a_of_type_AndroidOsBundle;
    return (localBundle != null) && (localBundle.getBoolean("key_multi_edit_pic"));
  }
  
  public boolean i()
  {
    Bundle localBundle = this.jdField_a_of_type_AndroidOsBundle;
    return (localBundle != null) && (localBundle.getBoolean("extra_photo_list_to_edit"));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EditVideoParams{mBusinessId=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", mEnableMasks=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mEditSource=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource);
    localStringBuilder.append(", entranceType=");
    localStringBuilder.append(c());
    localStringBuilder.append(", mExtra=");
    localStringBuilder.append(this.jdField_a_of_type_AndroidOsBundle);
    localStringBuilder.append(", entryType=");
    localStringBuilder.append(this.f);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.c);
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams$EditSource, paramInt);
    paramParcel.writeBundle(this.jdField_a_of_type_AndroidOsBundle);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.editor.params.EditVideoParams
 * JD-Core Version:    0.7.0.1
 */