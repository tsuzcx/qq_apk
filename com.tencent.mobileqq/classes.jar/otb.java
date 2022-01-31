import android.support.annotation.NonNull;

class otb
  implements Comparable<otb>
{
  public float a;
  public int a;
  public long a;
  public String a;
  public boolean a;
  public long b;
  public String b;
  public boolean b;
  public long c;
  
  private otb(ota paramota)
  {
    this.jdField_b_of_type_JavaLangString = "nil";
  }
  
  public int a(otb paramotb)
  {
    if (paramotb.jdField_a_of_type_Long > this.jdField_a_of_type_Long) {
      return 1;
    }
    if (paramotb.jdField_a_of_type_Long == this.jdField_a_of_type_Long) {
      return 0;
    }
    return -1;
  }
  
  @NonNull
  public String toString()
  {
    int j = 1;
    StringBuilder localStringBuilder = new StringBuilder().append(this.jdField_b_of_type_Long).append("_").append(this.jdField_a_of_type_Int).append("_").append(this.c).append("_").append(String.format("%.2f", new Object[] { Float.valueOf(this.jdField_a_of_type_Float) })).append("_");
    if (this.jdField_a_of_type_Boolean)
    {
      i = 1;
      localStringBuilder = localStringBuilder.append(i).append("_");
      if (!this.jdField_b_of_type_Boolean) {
        break label128;
      }
    }
    label128:
    for (int i = j;; i = 0)
    {
      return i + "_" + this.jdField_b_of_type_JavaLangString;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     otb
 * JD-Core Version:    0.7.0.1
 */