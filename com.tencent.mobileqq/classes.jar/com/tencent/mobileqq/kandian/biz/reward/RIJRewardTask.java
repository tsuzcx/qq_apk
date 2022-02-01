package com.tencent.mobileqq.kandian.biz.reward;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/reward/RIJRewardTask;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "rowKey", "", "contentType", "", "maxTimeInMs", "recordTimeInMs", "(Ljava/lang/String;III)V", "getContentType", "()I", "getMaxTimeInMs", "getRecordTimeInMs", "setRecordTimeInMs", "(I)V", "getRowKey", "()Ljava/lang/String;", "beginTransaction", "Lcom/tencent/mobileqq/kandian/biz/reward/RIJRewardTask$ITransaction;", "describeContents", "toString", "writeToParcel", "", "dest", "flags", "CREATOR", "ITransaction", "Transaction", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJRewardTask
  implements Parcelable
{
  public static final RIJRewardTask.CREATOR CREATOR = new RIJRewardTask.CREATOR(null);
  @NotNull
  private final String a;
  private final int b;
  private final int c;
  private int d;
  
  public RIJRewardTask(@NotNull Parcel paramParcel)
  {
    this(str, paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt());
  }
  
  public RIJRewardTask(@NotNull String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramString;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
  }
  
  @NotNull
  public final RIJRewardTask.ITransaction a()
  {
    return (RIJRewardTask.ITransaction)new RIJRewardTask.Transaction(this);
  }
  
  public final void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  @NotNull
  public final String b()
  {
    return this.a;
  }
  
  public final int c()
  {
    return this.b;
  }
  
  public final int d()
  {
    return this.c;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final int e()
  {
    return this.d;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RIJRewardTask(rowKey='");
    localStringBuilder.append(this.a);
    localStringBuilder.append("', contentType=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", maxTimeInMs=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", currentTimeInMs=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(@Nullable Parcel paramParcel, int paramInt)
  {
    if (paramParcel != null) {
      paramParcel.writeString(this.a);
    }
    if (paramParcel != null) {
      paramParcel.writeInt(this.b);
    }
    if (paramParcel != null) {
      paramParcel.writeInt(this.c);
    }
    if (paramParcel != null) {
      paramParcel.writeInt(this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.RIJRewardTask
 * JD-Core Version:    0.7.0.1
 */