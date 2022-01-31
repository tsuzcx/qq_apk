import com.tencent.av.gaudio.AVNotifyCenter;

public class lcu
{
  public int a;
  public long a;
  final String jdField_a_of_type_JavaLangString;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public boolean c;
  public boolean d = false;
  public boolean e = false;
  
  public lcu(AVNotifyCenter paramAVNotifyCenter, String paramString, long paramLong)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_c_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = ("AvChatData_" + paramString + "_" + paramLong);
  }
  
  public String toString()
  {
    return this.jdField_a_of_type_JavaLangString + ", mRelationId[" + this.jdField_a_of_type_Long + "], mRelationType[" + this.jdField_c_of_type_Int + "], mUinType[" + this.jdField_b_of_type_Int + "], mPeerUin[" + this.jdField_b_of_type_JavaLangString + "], mIsChating[" + this.d + "], mIsWaitting[" + this.jdField_c_of_type_Boolean + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     lcu
 * JD-Core Version:    0.7.0.1
 */