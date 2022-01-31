import com.tencent.av.report.VideoConnRateReport;

public class jol
  implements Runnable
{
  public jol(VideoConnRateReport paramVideoConnRateReport) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jol
 * JD-Core Version:    0.7.0.1
 */