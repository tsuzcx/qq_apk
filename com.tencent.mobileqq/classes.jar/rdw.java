import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mfsdk.persist.DBHandler;
import com.tencent.mfsdk.reporter.IReporter.ReportResultCallback;

public final class rdw
  implements IReporter.ReportResultCallback
{
  public void a(int paramInt)
  {
    MagnifierSDK.a.a("result_objects", paramInt, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rdw
 * JD-Core Version:    0.7.0.1
 */