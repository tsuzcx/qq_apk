package kotlinx.android.parcel;

import android.os.Parcel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/android/parcel/Parceler;", "T", "", "create", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)Ljava/lang/Object;", "newArray", "", "size", "", "(I)[Ljava/lang/Object;", "write", "", "flags", "(Ljava/lang/Object;Landroid/os/Parcel;I)V", "kotlin-android-extensions-runtime"}, k=1, mv={1, 1, 16})
public abstract interface Parceler<T>
{
  public abstract T create(@NotNull Parcel paramParcel);
  
  @NotNull
  public abstract T[] newArray(int paramInt);
  
  public abstract void write(T paramT, @NotNull Parcel paramParcel, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.android.parcel.Parceler
 * JD-Core Version:    0.7.0.1
 */