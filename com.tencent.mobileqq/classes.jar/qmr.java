import java.util.ArrayList;
import java.util.Iterator;

public class qmr
{
  public int a;
  public String a;
  public ArrayList<qms> a;
  public qmf a;
  public boolean a;
  public int b;
  public ArrayList<qmt> b;
  public int c = 0;
  
  public qmr()
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
    qms localqms;
    for (String str = "["; localIterator.hasNext(); str = str + "{" + localqms.toString() + "},") {
      localqms = (qms)localIterator.next();
    }
    return str + "]";
  }
  
  private String b()
  {
    if (this.jdField_b_of_type_JavaUtilArrayList == null) {
      return null;
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    qmt localqmt;
    for (String str = "["; localIterator.hasNext(); str = str + "{" + localqmt.toString() + "},") {
      localqmt = (qmt)localIterator.next();
    }
    return str + "]";
  }
  
  public String toString()
  {
    return "PGCFeedsInfo{pGCPicInfos=" + a() + ", pGCVideoInfos=" + b() + ", pgc_comments='" + this.jdField_a_of_type_JavaLangString + '\'' + ", follow_count=" + this.jdField_a_of_type_Int + ", follow_status=" + this.jdField_b_of_type_Int + ", isShortContent=" + this.jdField_a_of_type_Boolean + ", pgcFeedsType=" + this.c + ", galleryPGCFeedsInfo=" + this.jdField_a_of_type_Qmf + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qmr
 * JD-Core Version:    0.7.0.1
 */