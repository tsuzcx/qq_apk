package com.tencent.weseevideo.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/weseevideo/model/data/MusicMaterialMetaDataBean$HighlightIndex;", "Landroid/os/Parcelable;", "start", "", "len", "(II)V", "getLen", "()I", "setLen", "(I)V", "getStart", "setStart", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "libtavcut_debug"}, k=1, mv={1, 1, 16})
@Parcelize
public final class MusicMaterialMetaDataBean$HighlightIndex
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new MusicMaterialMetaDataBean.HighlightIndex.Creator();
  private int len;
  private int start;
  
  public MusicMaterialMetaDataBean$HighlightIndex()
  {
    this(0, 0, 3, null);
  }
  
  public MusicMaterialMetaDataBean$HighlightIndex(int paramInt1, int paramInt2)
  {
    this.start = paramInt1;
    this.len = paramInt2;
  }
  
  public final int component1()
  {
    return this.start;
  }
  
  public final int component2()
  {
    return this.len;
  }
  
  @NotNull
  public final HighlightIndex copy(int paramInt1, int paramInt2)
  {
    return new HighlightIndex(paramInt1, paramInt2);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof HighlightIndex))
      {
        paramObject = (HighlightIndex)paramObject;
        if ((this.start == paramObject.start) && (this.len == paramObject.len)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final int getLen()
  {
    return this.len;
  }
  
  public final int getStart()
  {
    return this.start;
  }
  
  public int hashCode()
  {
    return this.start * 31 + this.len;
  }
  
  public final void setLen(int paramInt)
  {
    this.len = paramInt;
  }
  
  public final void setStart(int paramInt)
  {
    this.start = paramInt;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HighlightIndex(start=");
    localStringBuilder.append(this.start);
    localStringBuilder.append(", len=");
    localStringBuilder.append(this.len);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    paramParcel.writeInt(this.start);
    paramParcel.writeInt(this.len);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.model.data.MusicMaterialMetaDataBean.HighlightIndex
 * JD-Core Version:    0.7.0.1
 */