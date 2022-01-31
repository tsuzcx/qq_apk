import java.util.HashMap;

public class mxf
{
  public int a;
  public String a;
  public HashMap<String, String> a;
  public mxg a;
  public int b;
  public int c = 60000;
  
  public mxf()
  {
    this.jdField_a_of_type_Int = 3;
    this.jdField_b_of_type_Int = 5000;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mUrl = ").append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(",mConnectionTimeout = ").append(this.jdField_b_of_type_Int);
    localStringBuilder.append(",mSocketTimeout = ").append(this.c);
    if (this.jdField_a_of_type_Mxg != null)
    {
      localStringBuilder.append(",mResult.mIsSucc = ").append(this.jdField_a_of_type_Mxg.jdField_a_of_type_Boolean);
      localStringBuilder.append(",mResult.mFileLength = ").append(this.jdField_a_of_type_Mxg.jdField_a_of_type_Long);
      localStringBuilder.append(",mResult.mErrCode = ").append(this.jdField_a_of_type_Mxg.jdField_a_of_type_Int);
      localStringBuilder.append(",mResult.mErrStr = ").append(this.jdField_a_of_type_Mxg.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(",mResult.mTryCount = ").append(this.jdField_a_of_type_Mxg.jdField_b_of_type_Int);
      localStringBuilder.append(",mResult.mCostTime = ").append(this.jdField_a_of_type_Mxg.jdField_b_of_type_Long).append("ms");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append(",mResult = null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mxf
 * JD-Core Version:    0.7.0.1
 */