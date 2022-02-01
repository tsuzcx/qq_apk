package com.tencent.ttpic.filter.aifilter;

import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PhotoResult
{
  @SerializedName("display_labels")
  @NotNull
  private final DisplayLabel[] displayLabels;
  @SerializedName("pitu_label")
  @NotNull
  private final String pituLabel;
  @SerializedName("retcode")
  @NotNull
  private final String retcode;
  
  public PhotoResult(@NotNull String paramString1, @NotNull String paramString2, @NotNull DisplayLabel[] paramArrayOfDisplayLabel)
  {
    this.retcode = paramString1;
    this.pituLabel = paramString2;
    this.displayLabels = paramArrayOfDisplayLabel;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    Class localClass2 = getClass();
    Class localClass1;
    if (paramObject != null) {
      localClass1 = paramObject.getClass();
    } else {
      localClass1 = null;
    }
    if ((Intrinsics.areEqual(localClass2, localClass1) ^ true)) {
      return false;
    }
    if (paramObject == null) {
      return false;
    }
    paramObject = (PhotoResult)paramObject;
    if ((Intrinsics.areEqual(this.retcode, paramObject.retcode) ^ true)) {
      return false;
    }
    if ((true ^ Intrinsics.areEqual(this.pituLabel, paramObject.pituLabel))) {
      return false;
    }
    return Arrays.equals(this.displayLabels, paramObject.displayLabels);
  }
  
  @NotNull
  public final DisplayLabel[] getDisplayLabels()
  {
    return this.displayLabels;
  }
  
  @NotNull
  public final String getPituLabel()
  {
    return this.pituLabel;
  }
  
  @NotNull
  public final String getRetcode()
  {
    return this.retcode;
  }
  
  public int hashCode()
  {
    return (this.retcode.hashCode() * 31 + this.pituLabel.hashCode()) * 31 + Arrays.hashCode(this.displayLabels);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.filter.aifilter.PhotoResult
 * JD-Core Version:    0.7.0.1
 */