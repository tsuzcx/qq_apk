public class pow
{
  public int a;
  public long a;
  public boolean a;
  
  public pow(long paramLong, int paramInt)
  {
    this(paramLong, paramInt, false);
  }
  
  public pow(long paramLong, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public String toString()
  {
    return "BatchFollowModel{followUin=" + this.jdField_a_of_type_Long + ", accountType=" + this.jdField_a_of_type_Int + ", isFollowed=" + this.jdField_a_of_type_Boolean + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pow
 * JD-Core Version:    0.7.0.1
 */