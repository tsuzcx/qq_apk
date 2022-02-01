package com.tencent.mobileqq.editor.params;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.io.File;

public class EditTakePhotoSource
  implements EditVideoParams.EditSource
{
  public static final Parcelable.Creator<EditTakePhotoSource> CREATOR = new EditTakePhotoSource.1();
  @NonNull
  public final String a;
  public final int b;
  public final int c;
  
  protected EditTakePhotoSource(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
  }
  
  public EditTakePhotoSource(@NonNull String paramString)
  {
    this.a = paramString;
    this.b = 0;
    this.c = 0;
    paramString = d();
    if (paramString == null) {
      return;
    }
    throw new IllegalArgumentException(paramString);
  }
  
  @NonNull
  public String a()
  {
    return this.a;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public String d()
  {
    if (TextUtils.isEmpty(this.a)) {
      return "sourcePath is empty";
    }
    if (!new File(this.a).exists())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Can not find file by sourcePath = ");
      localStringBuilder.append(this.a);
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.editor.params.EditTakePhotoSource
 * JD-Core Version:    0.7.0.1
 */