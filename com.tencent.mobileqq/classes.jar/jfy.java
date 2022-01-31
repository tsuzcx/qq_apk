import com.tencent.av.AVLog;
import com.tencent.av.business.manager.pendant.AVEffectPendantReport;
import com.tencent.av.business.manager.pendant.PendantItem;
import java.util.ArrayList;
import java.util.Iterator;

public final class jfy
  implements Runnable
{
  public void run()
  {
    if ((AVEffectPendantReport.a() == null) || (AVEffectPendantReport.a().isEmpty()))
    {
      AVEffectPendantReport.e();
      return;
    }
    AVEffectPendantReport.a(0);
    AVEffectPendantReport.b(0);
    Iterator localIterator = AVEffectPendantReport.a().iterator();
    while (localIterator.hasNext())
    {
      PendantItem localPendantItem = (PendantItem)localIterator.next();
      AVEffectPendantReport.a();
      if (AVEffectPendantReport.a(localPendantItem)) {
        AVEffectPendantReport.b();
      }
    }
    AVLog.c("AVEffectPendantReport", "refleshAndSetDownloadInfo()  mTotalCount = " + AVEffectPendantReport.c() + "  mDownloadCount = " + AVEffectPendantReport.d());
    AVEffectPendantReport.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jfy
 * JD-Core Version:    0.7.0.1
 */