import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.statistics.GdtImpressionReporter;
import com.tencent.gdtad.views.video.GdtVideoData;

public class qry
{
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = -1L;
  
  public qry(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void c(GdtVideoData paramGdtVideoData, long paramLong)
  {
    if (paramGdtVideoData == null)
    {
      GdtLog.d("GdtVideoStatistics", "return data == null error");
      return;
    }
    if ((this.jdField_a_of_type_Long == -1L) || (paramLong == 0L))
    {
      GdtLog.d("GdtVideoStatistics", "return startPositionMillis =-1");
      return;
    }
    if (this.jdField_a_of_type_Long > paramLong)
    {
      GdtLog.d("GdtVideoStatistics", "startPositionMillis > currentPositionMillis reset startPositionMillis = 0");
      this.jdField_a_of_type_Long = 0L;
    }
    long l = this.jdField_a_of_type_Long;
    if (paramLong == paramGdtVideoData.getDurationMillis()) {}
    for (boolean bool = true;; bool = false)
    {
      String str = GdtImpressionReporter.a(l, paramLong, bool, this.jdField_a_of_type_Int);
      GdtLog.b("GdtVideoStatistics", "report start:" + this.jdField_a_of_type_Long + " end:" + paramLong);
      GdtImpressionReporter.a(paramGdtVideoData.getAd(), str);
      this.jdField_a_of_type_Long = -1L;
      return;
    }
  }
  
  public void a(GdtVideoData paramGdtVideoData)
  {
    GdtLog.b("GdtVideoStatistics", "onError");
    c(paramGdtVideoData, -1L);
  }
  
  public void a(GdtVideoData paramGdtVideoData, long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    GdtLog.b("GdtVideoStatistics", "onStarted start:" + this.jdField_a_of_type_Long);
  }
  
  public void b(GdtVideoData paramGdtVideoData)
  {
    GdtLog.b("GdtVideoStatistics", "onCompleted start:" + this.jdField_a_of_type_Long);
    if (paramGdtVideoData == null) {}
    do
    {
      return;
      c(paramGdtVideoData, paramGdtVideoData.getDurationMillis());
    } while (!paramGdtVideoData.isLoop());
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void b(GdtVideoData paramGdtVideoData, long paramLong)
  {
    GdtLog.b("GdtVideoStatistics", "onStopped start:" + this.jdField_a_of_type_Long + " end:" + paramLong);
    c(paramGdtVideoData, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     qry
 * JD-Core Version:    0.7.0.1
 */