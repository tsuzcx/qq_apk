package dov.com.qq.im.ae.data;

import java.util.ArrayList;
import java.util.List;

public class AEMaterialCategory
  implements Cloneable
{
  public int a;
  public String a;
  public List<AEMaterialMetaData> a;
  public boolean a;
  public int b;
  public String b;
  
  public AEMaterialCategory()
  {
    this.jdField_b_of_type_Int = 2;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public AEMaterialCategory(String paramString)
  {
    this.jdField_b_of_type_Int = 2;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public AEMaterialCategory a()
  {
    AEMaterialCategory localAEMaterialCategory = new AEMaterialCategory();
    localAEMaterialCategory.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localAEMaterialCategory.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localAEMaterialCategory.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localAEMaterialCategory.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    localAEMaterialCategory.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    localAEMaterialCategory.jdField_a_of_type_JavaUtilList = new ArrayList();
    localAEMaterialCategory.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
    return localAEMaterialCategory;
  }
  
  public int hashCode()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (int i = 0;; i = this.jdField_a_of_type_JavaUtilList.hashCode()) {
      return i + 31;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.data.AEMaterialCategory
 * JD-Core Version:    0.7.0.1
 */