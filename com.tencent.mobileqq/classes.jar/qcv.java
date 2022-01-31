import java.util.ArrayList;
import java.util.Iterator;

public class qcv
{
  public int a;
  public String a;
  public ArrayList<qcw> a;
  public qcj a;
  public boolean a;
  public int b;
  public ArrayList<qcx> b;
  public int c = 0;
  
  public qcv()
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
    qcw localqcw;
    for (String str = "["; localIterator.hasNext(); str = str + "{" + localqcw.toString() + "},") {
      localqcw = (qcw)localIterator.next();
    }
    return str + "]";
  }
  
  private String b()
  {
    if (this.jdField_b_of_type_JavaUtilArrayList == null) {
      return null;
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    qcx localqcx;
    for (String str = "["; localIterator.hasNext(); str = str + "{" + localqcx.toString() + "},") {
      localqcx = (qcx)localIterator.next();
    }
    return str + "]";
  }
  
  public String toString()
  {
    return "PGCFeedsInfo{pGCPicInfos=" + a() + ", pGCVideoInfos=" + b() + ", pgc_comments='" + this.jdField_a_of_type_JavaLangString + '\'' + ", follow_count=" + this.jdField_a_of_type_Int + ", follow_status=" + this.jdField_b_of_type_Int + ", isShortContent=" + this.jdField_a_of_type_Boolean + ", pgcFeedsType=" + this.c + ", galleryPGCFeedsInfo=" + this.jdField_a_of_type_Qcj + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qcv
 * JD-Core Version:    0.7.0.1
 */