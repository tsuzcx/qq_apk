import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.FirstCommentCreateData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/FirstCommentCreateData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/FirstCommentCreateData;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/FirstCommentCreateData;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class pgp
  implements Parcelable.Creator<FirstCommentCreateData>
{
  @NotNull
  public FirstCommentCreateData a(@NotNull Parcel paramParcel)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    return new FirstCommentCreateData(paramParcel);
  }
  
  @NotNull
  public FirstCommentCreateData[] a(int paramInt)
  {
    return new FirstCommentCreateData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pgp
 * JD-Core Version:    0.7.0.1
 */