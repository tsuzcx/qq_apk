package com.tencent.mobileqq.editor.params;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.io.File;

public class EditLocalVideoSource
  implements EditVideoParams.EditSource
{
  public static final Parcelable.Creator<EditLocalVideoSource> CREATOR = new EditLocalVideoSource.1();
  @NonNull
  public final String a;
  @NonNull
  public final LocalMediaInfo b;
  public int c;
  public final int d;
  
  protected EditLocalVideoSource(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = ((LocalMediaInfo)paramParcel.readParcelable(LocalMediaInfo.class.getClassLoader()));
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
  }
  
  public EditLocalVideoSource(String paramString, LocalMediaInfo paramLocalMediaInfo, int paramInt1, int paramInt2)
  {
    this.a = paramString;
    this.b = paramLocalMediaInfo;
    this.c = paramInt1;
    this.d = paramInt2;
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
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Can not find file by sourcePath = ");
      localStringBuilder.append(this.a);
      return localStringBuilder.toString();
    }
    if (this.b == null) {
      return "media info should not be null";
    }
    int i = this.c;
    if (i >= 0)
    {
      int j = this.d;
      if ((j >= 0) && (j >= i)) {
        return null;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startTime(");
    localStringBuilder.append(this.c);
    localStringBuilder.append(") or endTime(");
    localStringBuilder.append(this.d);
    localStringBuilder.append(") is illegal");
    return localStringBuilder.toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeParcelable(this.b, 0);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.editor.params.EditLocalVideoSource
 * JD-Core Version:    0.7.0.1
 */