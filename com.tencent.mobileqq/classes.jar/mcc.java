public class mcc
  extends mcb
{
  public static int b;
  public static boolean c;
  public static String d;
  public final int a;
  public final boolean a;
  public final String c;
  
  public mcc(long paramLong, String paramString, boolean paramBoolean, int paramInt)
  {
    super(6100, null);
    a(paramLong, null);
    this.jdField_c_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
    d = paramString;
    jdField_c_of_type_Boolean = paramBoolean;
    b = paramInt;
  }
  
  public String toString()
  {
    return "mId[" + this.jdField_c_of_type_JavaLangString + "], mFrom[" + this.jdField_a_of_type_Int + "], mSender[" + this.jdField_a_of_type_Boolean + "], seq[" + a() + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mcc
 * JD-Core Version:    0.7.0.1
 */