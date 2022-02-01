import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.SimpleCommentData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/SimpleCommentData$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/SimpleCommentData;", "()V", "RIJ_SHANGHAI_PHP", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "(I)[Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/SimpleCommentData;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class own
  implements Parcelable.Creator<SimpleCommentData>
{
  @NotNull
  public SimpleCommentData a(@NotNull Parcel paramParcel)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    return new SimpleCommentData(paramParcel);
  }
  
  @NotNull
  public SimpleCommentData[] a(int paramInt)
  {
    return new SimpleCommentData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     own
 * JD-Core Version:    0.7.0.1
 */