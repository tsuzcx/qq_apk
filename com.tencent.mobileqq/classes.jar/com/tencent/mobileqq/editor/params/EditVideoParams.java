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
  public int b;
  public final int c;
  public final Bundle d;
  public EditVideoParams.EditSource e;
  public int f = 0;
  public int g = 0;
  public int h = -1;
  
  public EditVideoParams(int paramInt1, int paramInt2, EditVideoParams.EditSource paramEditSource, Bundle paramBundle)
  {
    this.a = paramInt1;
    this.c = paramInt2;
    this.e = paramEditSource;
    this.d = paramBundle;
  }
  
  protected EditVideoParams(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.c = paramParcel.readInt();
    this.e = ((EditVideoParams.EditSource)paramParcel.readParcelable(EditVideoParams.EditSource.class.getClassLoader()));
    this.d = paramParcel.readBundle(getClass().getClassLoader());
    this.f = paramParcel.readInt();
    this.g = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.h = paramParcel.readInt();
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 126) || (paramInt == 127) || (paramInt == 128) || (paramInt == 129) || (paramInt == 130);
  }
  
  public int a(String paramString, int paramInt)
  {
    Bundle localBundle = this.d;
    if (localBundle != null) {
      return localBundle.getInt(paramString, paramInt);
    }
    return paramInt;
  }
  
  public String a()
  {
    int i = this.a;
    if ((i != 2) && (i != 3) && (i != 4) && (i != 5) && (i != 6) && (i != 11) && (i != 12) && (i != 14) && (i != 15))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Unknown Business id ");
      ((StringBuilder)localObject).append(this.a);
      return ((StringBuilder)localObject).toString();
    }
    Object localObject = this.e;
    if (localObject == null) {
      return "Can not find edit source";
    }
    return ((EditVideoParams.EditSource)localObject).d();
  }
  
  public String a(String paramString)
  {
    Bundle localBundle = this.d;
    if (localBundle != null) {
      return localBundle.getString(paramString);
    }
    return null;
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    Bundle localBundle = this.d;
    if (localBundle != null) {
      return localBundle.getBoolean(paramString, paramBoolean);
    }
    return paramBoolean;
  }
  
  public boolean b()
  {
    EditVideoParams.EditSource localEditSource = this.e;
    return ((localEditSource instanceof EditTakePhotoSource)) || ((localEditSource instanceof EditLocalPhotoSource));
  }
  
  public boolean c()
  {
    EditVideoParams.EditSource localEditSource = this.e;
    return ((localEditSource instanceof EditLocalVideoSource)) || ((localEditSource instanceof EditTakeVideoSource));
  }
  
  public boolean d()
  {
    EditVideoParams.EditSource localEditSource = this.e;
    return ((localEditSource instanceof EditTakePhotoSource)) || ((localEditSource instanceof EditTakeVideoSource));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean e()
  {
    EditVideoParams.EditSource localEditSource = this.e;
    return ((localEditSource instanceof EditLocalVideoSource)) || ((localEditSource instanceof EditLocalPhotoSource));
  }
  
  public boolean f()
  {
    Bundle localBundle = this.d;
    if (localBundle == null) {
      return true;
    }
    return localBundle.getBoolean("extra_enable_revert", true);
  }
  
  public boolean g()
  {
    Bundle localBundle = this.d;
    if (localBundle == null) {
      return true;
    }
    return localBundle.getBoolean("extra_enable_slow", true);
  }
  
  public int h()
  {
    int j = this.a;
    Bundle localBundle = this.d;
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
  
  public int i()
  {
    Bundle localBundle = this.d;
    if ((localBundle != null) && (this.a == 2)) {
      return localBundle.getInt("qq_sub_business_id");
    }
    return 0;
  }
  
  public int j()
  {
    Bundle localBundle = this.d;
    if (localBundle == null) {
      return 99;
    }
    return localBundle.getInt("entrance_type", 99);
  }
  
  public boolean k()
  {
    Bundle localBundle = this.d;
    if (localBundle == null) {
      return false;
    }
    return localBundle.getBoolean("enable_hw_encode");
  }
  
  public boolean l()
  {
    Bundle localBundle = this.d;
    return (localBundle != null) && (localBundle.getBoolean("key_multi_edit_pic"));
  }
  
  public boolean m()
  {
    Bundle localBundle = this.d;
    return (localBundle != null) && (localBundle.getBoolean("extra_photo_list_to_edit"));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EditVideoParams{mBusinessId=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mEnableMasks=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mEditSource=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", entranceType=");
    localStringBuilder.append(j());
    localStringBuilder.append(", mExtra=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", entryType=");
    localStringBuilder.append(this.h);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.c);
    paramParcel.writeParcelable(this.e, paramInt);
    paramParcel.writeBundle(this.d);
    paramParcel.writeInt(this.f);
    paramParcel.writeInt(this.g);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.editor.params.EditVideoParams
 * JD-Core Version:    0.7.0.1
 */