import java.util.ArrayList;

public class kwy
{
  int jdField_a_of_type_Int = 0;
  public String a;
  final ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList(0);
  final kxb jdField_a_of_type_Kxb;
  boolean jdField_a_of_type_Boolean = false;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = false;
  
  kwy(kxb paramkxb, ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    this.jdField_a_of_type_Kxb = paramkxb;
    this.jdField_a_of_type_Int = 0;
    if (paramArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_Int >= 3;
  }
  
  public String toString()
  {
    return "ItemRecord{" + this.jdField_a_of_type_Kxb + "," + this.jdField_a_of_type_Int + "," + this.jdField_a_of_type_JavaLangString + "," + this.jdField_b_of_type_JavaLangString + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     kwy
 * JD-Core Version:    0.7.0.1
 */