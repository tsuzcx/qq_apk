import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/reward/RIJRewardTask$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/biz/pubaccount/readinjoy/reward/RIJRewardTask;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/biz/pubaccount/readinjoy/reward/RIJRewardTask;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class qxm
  implements Parcelable.Creator<RIJRewardTask>
{
  @NotNull
  public RIJRewardTask a(@NotNull Parcel paramParcel)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    return new RIJRewardTask(paramParcel);
  }
  
  @NotNull
  public RIJRewardTask[] a(int paramInt)
  {
    return new RIJRewardTask[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qxm
 * JD-Core Version:    0.7.0.1
 */