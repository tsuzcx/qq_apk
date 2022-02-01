public class osx
{
  public int a;
  public long a;
  public CharSequence a;
  public String a;
  public CharSequence b;
  
  public osx(String paramString, long paramLong, CharSequence paramCharSequence)
  {
    this(paramString, paramLong, paramCharSequence, 0);
  }
  
  public osx(String paramString, long paramLong, CharSequence paramCharSequence, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong;
    paramString = paramCharSequence;
    if (paramCharSequence == null) {
      paramString = "";
    }
    this.b = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     osx
 * JD-Core Version:    0.7.0.1
 */