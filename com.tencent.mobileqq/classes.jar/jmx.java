import com.tencent.av.report.VideoConnRateReport;

public class jmx
  implements Runnable
{
  public jmx(VideoConnRateReport paramVideoConnRateReport) {}
  
  public void run()
  {
    synchronized (this.a.a)
    {
      VideoConnRateReport.a(this.a);
      VideoConnRateReport.b(this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jmx
 * JD-Core Version:    0.7.0.1
 */