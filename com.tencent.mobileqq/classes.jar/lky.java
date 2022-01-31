import java.util.Comparator;
import java.util.List;

public class lky
{
  public static final Object a;
  public static final Comparator<lky> a;
  private static lky b;
  private static int c;
  public int a;
  public aykp a;
  private lky a;
  public int b;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_JavaUtilComparator = new lkz();
  }
  
  private lky(aykp paramaykp, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Aykp = paramaykp;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public static lky a(aykp paramaykp, int paramInt1, int paramInt2)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_Lky != null)
      {
        lky locallky = jdField_b_of_type_Lky;
        jdField_b_of_type_Lky = locallky.jdField_a_of_type_Lky;
        locallky.a(paramaykp, paramInt1, paramInt2);
        c -= 1;
        return locallky;
      }
      return new lky(paramaykp, paramInt1, paramInt2);
    }
  }
  
  private void a(aykp paramaykp, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Lky = null;
    this.jdField_a_of_type_Aykp = paramaykp;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public static void a(List<lky> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        lky locallky = (lky)paramList.remove(i);
        if (locallky != null) {
          locallky.a();
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
        this.jdField_a_of_type_Lky = jdField_b_of_type_Lky;
        jdField_b_of_type_Lky = this;
        c += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lky
 * JD-Core Version:    0.7.0.1
 */