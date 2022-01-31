import java.util.ArrayList;
import java.util.Iterator;

public class qcy
{
  public int a;
  public String a;
  public ArrayList<qcz> a;
  public qcm a;
  public boolean a;
  public int b;
  public ArrayList<qda> b;
  public int c = 0;
  
  public qcy()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private String a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    qcz localqcz;
    for (String str = "["; localIterator.hasNext(); str = str + "{" + localqcz.toString() + "},") {
      localqcz = (qcz)localIterator.next();
    }
    return str + "]";
  }
  
  private String b()
  {
    if (this.jdField_b_of_type_JavaUtilArrayList == null) {
      return null;
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    qda localqda;
    for (String str = "["; localIterator.hasNext(); str = str + "{" + localqda.toString() + "},") {
      localqda = (qda)localIterator.next();
    }
    return str + "]";
  }
  
  public String toString()
  {
    return "PGCFeedsInfo{pGCPicInfos=" + a() + ", pGCVideoInfos=" + b() + ", pgc_comments='" + this.jdField_a_of_type_JavaLangString + '\'' + ", follow_count=" + this.jdField_a_of_type_Int + ", follow_status=" + this.jdField_b_of_type_Int + ", isShortContent=" + this.jdField_a_of_type_Boolean + ", pgcFeedsType=" + this.c + ", galleryPGCFeedsInfo=" + this.jdField_a_of_type_Qcm + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qcy
 * JD-Core Version:    0.7.0.1
 */