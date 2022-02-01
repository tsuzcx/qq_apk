package com.tencent.mobileqq.editor.params;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.io.File;

public class EditLocalPhotoSource
  implements EditVideoParams.EditSource
{
  public static final Parcelable.Creator<EditLocalPhotoSource> CREATOR = new EditLocalPhotoSource.1();
  public final String a;
  public final LocalMediaInfo b;
  
  protected EditLocalPhotoSource(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = ((LocalMediaInfo)paramParcel.readParcelable(LocalMediaInfo.class.getClassLoader()));
  }
  
  public EditLocalPhotoSource(String paramString, LocalMediaInfo paramLocalMediaInfo)
  {
    this.a = paramString;
    this.b = paramLocalMediaInfo;
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
    return this.b.mediaWidth;
  }
  
  public int c()
  {
    return this.b.mediaHeight;
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
    if (this.b == null) {
      return "media info should not be null";
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
    paramParcel.writeParcelable(this.b, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.editor.params.EditLocalPhotoSource
 * JD-Core Version:    0.7.0.1
 */