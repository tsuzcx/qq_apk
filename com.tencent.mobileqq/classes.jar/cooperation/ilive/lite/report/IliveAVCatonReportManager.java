package cooperation.ilive.lite.report;

import com.tencent.livesdk.livesdkplayer.AVCatonReport4Player;
import java.util.LinkedList;
import java.util.Queue;

public class IliveAVCatonReportManager
  extends AVCatonReport4Player
{
  private static IliveAVCatonReportManager b;
  private Queue<IliveAVCatonReport> a = new LinkedList();
  
  public static IliveAVCatonReportManager b()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new IliveAVCatonReportManager();
        }
      }
      finally {}
    }
    return b;
  }
  
  private IliveAVCatonReport c()
  {
    return (IliveAVCatonReport)this.a.peek();
  }
  
  public void a()
  {
    if (c() != null) {
      c().a();
    }
    this.a.poll();
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (c() != null) {
      c().a(paramLong1, paramLong2);
    }
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    if (c() != null) {
      c().a(paramLong1, paramLong2, paramLong3, paramLong4);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if (c() != null) {
      c().a(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
    }
  }
  
  public void a(boolean paramBoolean, long paramLong)
  {
    IliveAVCatonReport localIliveAVCatonReport = new IliveAVCatonReport();
    localIliveAVCatonReport.a(String.valueOf(paramLong));
    localIliveAVCatonReport.a(paramBoolean);
    this.a.offer(localIliveAVCatonReport);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.lite.report.IliveAVCatonReportManager
 * JD-Core Version:    0.7.0.1
 */