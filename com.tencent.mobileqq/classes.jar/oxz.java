import com.tencent.pts.core.PTSComposer.IPTSUpdateDataListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "jsonData", "", "kotlin.jvm.PlatformType", "onDataUpdated"}, k=3, mv={1, 1, 16})
final class oxz
  implements PTSComposer.IPTSUpdateDataListener
{
  oxz(oxw paramoxw) {}
  
  public final void onDataUpdated(String paramString)
  {
    QLog.i("RIJChannelBannerController", 1, "[onDataUpdated] jsonData = " + paramString);
    oyb localoyb = oxw.a(this.a);
    if (localoyb != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(paramString, "jsonData");
      localoyb.c(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oxz
 * JD-Core Version:    0.7.0.1
 */