import androidx.annotation.NonNull;

public class nej
  extends neg
{
  public static final String a;
  private static boolean jdField_a_of_type_Boolean;
  private int jdField_a_of_type_Int;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private int d;
  
  static
  {
    jdField_a_of_type_JavaLangString = nej.class.getName();
  }
  
  public nej(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String[] paramArrayOfString, int paramInt4)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    this.d = paramInt4;
  }
  
  public static void a(boolean paramBoolean)
  {
    jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static boolean b()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public int a()
  {
    return this.d;
  }
  
  @NonNull
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void a(String[] paramArrayOfString)
  {
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
  }
  
  public boolean a()
  {
    return this.d == 1;
  }
  
  public String[] a()
  {
    return this.jdField_a_of_type_ArrayOfJavaLangString;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public int c()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String c()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public int d()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public int e()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nej
 * JD-Core Version:    0.7.0.1
 */