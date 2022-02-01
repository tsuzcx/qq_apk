import android.os.CountDownTimer;
import android.os.SystemClock;

class mye
  extends CountDownTimer
{
  mye(myd parammyd, long paramLong1, long paramLong2, long paramLong3, int paramInt)
  {
    super(paramLong1, paramLong2);
  }
  
  public void onFinish()
  {
    int i = (int)(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long);
    myd.a(this.jdField_a_of_type_Myd, this.jdField_a_of_type_Int - i);
  }
  
  public void onTick(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mye
 * JD-Core Version:    0.7.0.1
 */