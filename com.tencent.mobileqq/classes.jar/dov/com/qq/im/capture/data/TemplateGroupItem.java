package dov.com.qq.im.capture.data;

import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.util.ArrayList;
import java.util.List;

public class TemplateGroupItem
  implements Cloneable
{
  public int a;
  public String a;
  public List<PtvTemplateManager.PtvTemplateInfo> a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  
  public TemplateGroupItem() {}
  
  public TemplateGroupItem(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public TemplateGroupItem a()
  {
    TemplateGroupItem localTemplateGroupItem = new TemplateGroupItem();
    localTemplateGroupItem.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localTemplateGroupItem.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localTemplateGroupItem.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    localTemplateGroupItem.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localTemplateGroupItem.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    localTemplateGroupItem.jdField_b_of_type_Boolean = this.jdField_b_of_type_Boolean;
    localTemplateGroupItem.jdField_a_of_type_JavaUtilList = new ArrayList();
    localTemplateGroupItem.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
    return localTemplateGroupItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.data.TemplateGroupItem
 * JD-Core Version:    0.7.0.1
 */