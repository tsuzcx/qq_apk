import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.utils.AudioHelper;

public class lna
{
  public int a;
  final long jdField_a_of_type_Long = AudioHelper.b();
  public int b;
  public long b;
  public int c;
  public long c;
  public int d;
  public int e;
  public int f;
  
  public lna(AVNotifyCenter paramAVNotifyCenter) {}
  
  public boolean a()
  {
    return (this.jdField_b_of_type_Int == 2) && (this.d == 2) && (this.e == 4) && (this.jdField_c_of_type_Int == 0);
  }
  
  public boolean b()
  {
    return (this.jdField_b_of_type_Int == 2) && (this.d == 2) && (this.e == 5) && (this.jdField_c_of_type_Int == 0);
  }
  
  public String toString()
  {
    return "seq[" + this.jdField_a_of_type_Long + "], relationId[" + this.jdField_b_of_type_Long + "], avtype[" + this.jdField_b_of_type_Int + "], roomMode[" + this.d + "], gameId[" + this.e + "], liveExtraMode[" + this.jdField_c_of_type_Int + "], memberNum[" + this.jdField_a_of_type_Int + "], event[" + this.f + "], time[" + this.jdField_c_of_type_Long + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     lna
 * JD-Core Version:    0.7.0.1
 */