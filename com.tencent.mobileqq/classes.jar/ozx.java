public class ozx
{
  public int a;
  public long a;
  public boolean a;
  
  public ozx(long paramLong, int paramInt)
  {
    this(paramLong, paramInt, false);
  }
  
  public ozx(long paramLong, int paramInt, boolean paramBoolean)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ozx
 * JD-Core Version:    0.7.0.1
 */