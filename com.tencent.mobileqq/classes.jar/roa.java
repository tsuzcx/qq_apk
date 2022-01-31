import org.jetbrains.annotations.NotNull;

class roa
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString;
  int jdField_b_of_type_Int;
  String jdField_b_of_type_JavaLangString;
  
  roa(rny paramrny, String paramString1, String paramString2, int paramInt1, long paramLong, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("PlayParams{vid='").append(this.jdField_a_of_type_JavaLangString).append('\'').append(", url='").append(this.jdField_b_of_type_JavaLangString).append('\'').append(", playType=");
    if (this.jdField_a_of_type_Int == 2) {}
    for (String str = "VOD";; str = "LIVE") {
      return str + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     roa
 * JD-Core Version:    0.7.0.1
 */