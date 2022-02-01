import com.tencent.pts.core.PTSComposer.IPTSUpdateDataListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "jsonData", "", "kotlin.jvm.PlatformType", "onDataUpdated"}, k=3, mv={1, 1, 16})
final class oop
  implements PTSComposer.IPTSUpdateDataListener
{
  oop(oom paramoom) {}
  
  public final void onDataUpdated(String paramString)
  {
    QLog.i("RIJChannelBannerController", 1, "[onDataUpdated] jsonData = " + paramString);
    oor localoor = oom.a(this.a);
    if (localoor != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(paramString, "jsonData");
      localoor.c(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oop
 * JD-Core Version:    0.7.0.1
 */