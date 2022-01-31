class luz
{
  public long a;
  public final String a;
  public long b;
  public long c;
  
  public luz(String paramString, long paramLong)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong;
    this.b = paramLong;
    this.c = paramLong;
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Long < paramLong) {
      this.jdField_a_of_type_Long = paramLong;
    }
    if (this.b > paramLong) {
      this.b = paramLong;
    }
    this.c = ((this.c + paramLong) / 2L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     luz
 * JD-Core Version:    0.7.0.1
 */