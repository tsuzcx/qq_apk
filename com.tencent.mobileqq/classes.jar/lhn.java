import java.util.ArrayList;

public class lhn
{
  int jdField_a_of_type_Int = 0;
  public String a;
  final ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList(0);
  final lhq jdField_a_of_type_Lhq;
  boolean jdField_a_of_type_Boolean = false;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = false;
  
  lhn(lhq paramlhq, ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    this.jdField_a_of_type_Lhq = paramlhq;
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
    return "ItemRecord{" + this.jdField_a_of_type_Lhq + "," + this.jdField_a_of_type_Int + "," + this.jdField_a_of_type_JavaLangString + "," + this.jdField_b_of_type_JavaLangString + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lhn
 * JD-Core Version:    0.7.0.1
 */