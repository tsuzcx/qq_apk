import java.util.ArrayList;
import java.util.Iterator;

public class pqz
{
  public int a;
  public String a;
  public ArrayList<pra> a;
  public pqp a;
  public boolean a;
  public int b;
  public ArrayList<prb> b;
  public int c = 0;
  
  public pqz()
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
    pra localpra;
    for (String str = "["; localIterator.hasNext(); str = str + "{" + localpra.toString() + "},") {
      localpra = (pra)localIterator.next();
    }
    return str + "]";
  }
  
  private String b()
  {
    if (this.jdField_b_of_type_JavaUtilArrayList == null) {
      return null;
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    prb localprb;
    for (String str = "["; localIterator.hasNext(); str = str + "{" + localprb.toString() + "},") {
      localprb = (prb)localIterator.next();
    }
    return str + "]";
  }
  
  public String toString()
  {
    return "PGCFeedsInfo{pGCPicInfos=" + a() + ", pGCVideoInfos=" + b() + ", pgc_comments='" + this.jdField_a_of_type_JavaLangString + '\'' + ", follow_count=" + this.jdField_a_of_type_Int + ", follow_status=" + this.jdField_b_of_type_Int + ", isShortContent=" + this.jdField_a_of_type_Boolean + ", pgcFeedsType=" + this.c + ", galleryPGCFeedsInfo=" + this.jdField_a_of_type_Pqp + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pqz
 * JD-Core Version:    0.7.0.1
 */