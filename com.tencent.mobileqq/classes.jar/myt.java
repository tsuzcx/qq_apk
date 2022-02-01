import android.os.SystemClock;

public class myt
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private long b;
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    long l2 = this.jdField_a_of_type_Long;
    long l1 = l2;
    if (this.jdField_a_of_type_Float == 0.0F)
    {
      l1 = l2;
      if (this.b != 0L)
      {
        l1 = SystemClock.elapsedRealtime();
        l2 = this.jdField_a_of_type_Long;
        l1 = ((float)(l1 - this.b) * this.jdField_a_of_type_Float) + l2;
      }
    }
    return l1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Float = 1.0F;
    this.b = 0L;
  }
  
  public void a(int paramInt, long paramLong, float paramFloat)
  {
    this.b = SystemClock.elapsedRealtime();
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(myt parammyt)
  {
    if (parammyt == null) {
      return;
    }
    this.b = SystemClock.elapsedRealtime();
    this.jdField_a_of_type_Int = parammyt.jdField_a_of_type_Int;
    this.jdField_a_of_type_Long = parammyt.jdField_a_of_type_Long;
    this.jdField_a_of_type_Float = parammyt.jdField_a_of_type_Float;
  }
  
  public String toString()
  {
    return "WTSyncPlayInfo[playState: " + this.jdField_a_of_type_Int + ", playTimeMills[" + this.jdField_a_of_type_Long + ", playRate:" + this.jdField_a_of_type_Float + ", syncTimeMills:" + this.b + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     myt
 * JD-Core Version:    0.7.0.1
 */