package com.tencent.mobileqq.editor.params;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.io.File;

public class EditTakeVideoSource
  implements EditVideoParams.EditSource
{
  public static final Parcelable.Creator<EditTakeVideoSource> CREATOR = new EditTakeVideoSource.1();
  @NonNull
  public final String a;
  @NonNull
  public final LocalMediaInfo b;
  @NonNull
  public final String c;
  public final String d;
  
  protected EditTakeVideoSource(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.c = paramParcel.readString();
    this.b = ((LocalMediaInfo)paramParcel.readParcelable(LocalMediaInfo.class.getClassLoader()));
    this.d = paramParcel.readString();
  }
  
  public EditTakeVideoSource(String paramString1, String paramString2, LocalMediaInfo paramLocalMediaInfo)
  {
    this.a = paramString1;
    this.c = paramString2;
    this.b = paramLocalMediaInfo;
    this.d = "";
    paramString1 = d();
    if (paramString1 == null) {
      return;
    }
    throw new IllegalArgumentException(paramString1);
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
    StringBuilder localStringBuilder;
    if (!new File(this.a).exists())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Can not find file by sourcePath = ");
      localStringBuilder.append(this.a);
      return localStringBuilder.toString();
    }
    if (!new File(this.c).exists())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Can not find file by audioSourcePath = ");
      localStringBuilder.append(this.c);
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
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EditTakeVideoSource: sourcePath=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" audioSourcePath=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" mediaInfo=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" audioBgmSourcePath=");
    localStringBuilder.append(this.d);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.c);
    paramParcel.writeParcelable(this.b, 0);
    paramParcel.writeString(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.editor.params.EditTakeVideoSource
 * JD-Core Version:    0.7.0.1
 */