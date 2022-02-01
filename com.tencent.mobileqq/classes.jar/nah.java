import android.os.CountDownTimer;
import android.os.SystemClock;

class nah
  extends CountDownTimer
{
  nah(nag paramnag, long paramLong1, long paramLong2, long paramLong3, int paramInt)
  {
    super(paramLong1, paramLong2);
  }
  
  public void onFinish()
  {
    int i = (int)(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long);
    nag.a(this.jdField_a_of_type_Nag, this.jdField_a_of_type_Int - i);
  }
  
  public void onTick(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nah
 * JD-Core Version:    0.7.0.1
 */