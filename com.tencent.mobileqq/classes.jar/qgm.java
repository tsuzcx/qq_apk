import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.model.RIJCommentReportModule.CommentReportInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/model/RIJCommentReportModule$CommentReportInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/biz/pubaccount/readinjoy/model/RIJCommentReportModule$CommentReportInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/biz/pubaccount/readinjoy/model/RIJCommentReportModule$CommentReportInfo;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class qgm
  implements Parcelable.Creator<RIJCommentReportModule.CommentReportInfo>
{
  @NotNull
  public RIJCommentReportModule.CommentReportInfo a(@NotNull Parcel paramParcel)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    return new RIJCommentReportModule.CommentReportInfo(paramParcel);
  }
  
  @NotNull
  public RIJCommentReportModule.CommentReportInfo[] a(int paramInt)
  {
    return new RIJCommentReportModule.CommentReportInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qgm
 * JD-Core Version:    0.7.0.1
 */