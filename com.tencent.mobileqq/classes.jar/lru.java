import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

class lru
{
  public long a;
  public long b;
  public long c;
  public long d;
  public long e;
  public long f;
  public long g;
  
  public void a()
  {
    this.a = 0L;
    this.b = 0L;
    this.c = 0L;
    this.d = 0L;
    this.e = 0L;
    this.f = 0L;
    this.g = 0L;
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    long l = SystemClock.elapsedRealtime();
    this.a += 1L;
    this.b = ((this.b + paramLong1) / 2L);
    this.c = ((this.c + paramLong2) / 2L);
    this.d = ((this.d + paramLong3) / 2L);
    this.e = ((this.e + paramLong4) / 2L);
    this.f = ((this.f + paramLong5) / 2L);
    if (this.g != 0L) {
      paramLong1 = this.g;
    }
    this.g = l;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("PerfData", 2, String.format(Locale.getDefault(), "addPerfData, [count: %s, oes2NormalCost: %s, gpuDrawCost: %s, readPixelCost:%s, sendDataCost:%s, totalCost:%s", new Object[] { Long.valueOf(this.a), Long.valueOf(this.b), Long.valueOf(this.c), Long.valueOf(this.d), Long.valueOf(this.e), Long.valueOf(this.f) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lru
 * JD-Core Version:    0.7.0.1
 */