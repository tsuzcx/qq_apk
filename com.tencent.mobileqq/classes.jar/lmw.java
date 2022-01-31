import java.util.Comparator;
import java.util.List;

public class lmw
{
  public static final Object a;
  public static final Comparator<lmw> a;
  private static lmw b;
  private static int c;
  public int a;
  public bain a;
  private lmw a;
  public int b;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_JavaUtilComparator = new lmx();
  }
  
  private lmw(bain parambain, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Bain = parambain;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public static lmw a(bain parambain, int paramInt1, int paramInt2)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_Lmw != null)
      {
        lmw locallmw = jdField_b_of_type_Lmw;
        jdField_b_of_type_Lmw = locallmw.jdField_a_of_type_Lmw;
        locallmw.a(parambain, paramInt1, paramInt2);
        c -= 1;
        return locallmw;
      }
      return new lmw(parambain, paramInt1, paramInt2);
    }
  }
  
  private void a(bain parambain, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Lmw = null;
    this.jdField_a_of_type_Bain = parambain;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public static void a(List<lmw> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        lmw locallmw = (lmw)paramList.remove(i);
        if (locallmw != null) {
          locallmw.a();
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
        this.jdField_a_of_type_Lmw = jdField_b_of_type_Lmw;
        jdField_b_of_type_Lmw = this;
        c += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lmw
 * JD-Core Version:    0.7.0.1
 */