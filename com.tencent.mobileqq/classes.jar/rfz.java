import com.tencent.qphone.base.util.QLog;

public class rfz
  implements Cloneable
{
  public int a;
  public long a;
  public String a;
  public int b;
  public long b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public String e;
  public String f;
  public String g;
  
  protected Object clone()
  {
    try
    {
      rfz localrfz = (rfz)super.clone();
      return localrfz;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      QLog.e("NewPolymericInfo", 2, "PackVideoInfo item clone failed. exception = " + localCloneNotSupportedException);
    }
    return null;
  }
  
  public String toString()
  {
    return "PackVideoInfo{businessType=" + this.jdField_a_of_type_Int + ", vid='" + this.jdField_a_of_type_JavaLangString + '\'' + ", width=" + this.jdField_b_of_type_Int + ", height=" + this.jdField_c_of_type_Int + ", duration=" + this.jdField_d_of_type_Int + ", xgFileSize=" + this.jdField_a_of_type_Long + ", thirdUrl='" + this.jdField_b_of_type_JavaLangString + '\'' + ", shareUrl='" + this.jdField_c_of_type_JavaLangString + '\'' + ", thirdUin=" + this.jdField_b_of_type_Long + ", thirdUinName='" + this.jdField_d_of_type_JavaLangString + '\'' + ", thirdName='" + this.e + '\'' + ", thirdIcon='" + this.f + '\'' + ", thirdAction='" + this.g + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rfz
 * JD-Core Version:    0.7.0.1
 */