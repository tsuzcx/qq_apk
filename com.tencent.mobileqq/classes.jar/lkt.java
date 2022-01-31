import java.util.Comparator;
import java.util.List;

public class lkt
{
  public static final Object a;
  public static final Comparator<lkt> a;
  private static lkt b;
  private static int c;
  public int a;
  public aykr a;
  private lkt a;
  public int b;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_JavaUtilComparator = new lku();
  }
  
  private lkt(aykr paramaykr, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Aykr = paramaykr;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public static lkt a(aykr paramaykr, int paramInt1, int paramInt2)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_Lkt != null)
      {
        lkt locallkt = jdField_b_of_type_Lkt;
        jdField_b_of_type_Lkt = locallkt.jdField_a_of_type_Lkt;
        locallkt.a(paramaykr, paramInt1, paramInt2);
        c -= 1;
        return locallkt;
      }
      return new lkt(paramaykr, paramInt1, paramInt2);
    }
  }
  
  private void a(aykr paramaykr, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Lkt = null;
    this.jdField_a_of_type_Aykr = paramaykr;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public static void a(List<lkt> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        lkt locallkt = (lkt)paramList.remove(i);
        if (locallkt != null) {
          locallkt.a();
        }
        i -= 1;
      }
    }
  }
  
  public void a()
  {
    a(null, -1, -1);
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (c < 50)
      {
        this.jdField_a_of_type_Lkt = jdField_b_of_type_Lkt;
        jdField_b_of_type_Lkt = this;
        c += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lkt
 * JD-Core Version:    0.7.0.1
 */