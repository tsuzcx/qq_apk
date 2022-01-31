import com.tencent.av.report.VideoConnRateReport;

public class jmh
  implements Runnable
{
  public jmh(VideoConnRateReport paramVideoConnRateReport) {}
  
  public void run()
  {
    synchronized (this.a.a)
    {
      VideoConnRateReport.a(this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jmh
 * JD-Core Version:    0.7.0.1
 */