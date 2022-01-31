import com.tencent.av.report.VideoConnRateReport;

public class jok
  implements Runnable
{
  public jok(VideoConnRateReport paramVideoConnRateReport) {}
  
  public void run()
  {
    synchronized (this.a.a)
    {
      VideoConnRateReport.a(this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jok
 * JD-Core Version:    0.7.0.1
 */