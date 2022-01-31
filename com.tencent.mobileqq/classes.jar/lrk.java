public class lrk
{
  public int a;
  public long a;
  public int b;
  public long b;
  public int c;
  public int d;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" fid:" + this.jdField_a_of_type_Long);
    localStringBuilder.append(" cn:" + this.jdField_a_of_type_Int);
    localStringBuilder.append(" ic:" + this.jdField_b_of_type_Int);
    localStringBuilder.append(" gid:" + this.jdField_b_of_type_Long);
    localStringBuilder.append(" ic_max:" + this.c);
    localStringBuilder.append(" seg:" + this.d);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lrk
 * JD-Core Version:    0.7.0.1
 */