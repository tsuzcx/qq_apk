package cooperation.vip.jsoninflate.model;

public class AdvReportSsoModel$Builder
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int c;
  private int d;
  
  public Builder a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public Builder a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    return this;
  }
  
  public Builder a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public AdvReportSsoModel a()
  {
    return new AdvReportSsoModel(this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString, this.c, this.jdField_b_of_type_JavaLangString, this.d);
  }
  
  public Builder b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    return this;
  }
  
  public Builder b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
  
  public Builder c(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
  
  public Builder d(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.jsoninflate.model.AdvReportSsoModel.Builder
 * JD-Core Version:    0.7.0.1
 */