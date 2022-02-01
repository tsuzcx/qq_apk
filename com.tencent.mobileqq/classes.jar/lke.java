import java.util.Comparator;
import java.util.List;

public class lke
{
  public static final Object a;
  public static final Comparator<lke> a;
  private static lke b;
  private static int c;
  public int a;
  public begw a;
  private lke a;
  public int b;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_JavaUtilComparator = new lkf();
  }
  
  private lke(begw parambegw, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Begw = parambegw;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public static lke a(begw parambegw, int paramInt1, int paramInt2)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_Lke != null)
      {
        lke locallke = jdField_b_of_type_Lke;
        jdField_b_of_type_Lke = locallke.jdField_a_of_type_Lke;
        locallke.a(parambegw, paramInt1, paramInt2);
        c -= 1;
        return locallke;
      }
      return new lke(parambegw, paramInt1, paramInt2);
    }
  }
  
  private void a(begw parambegw, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Lke = null;
    this.jdField_a_of_type_Begw = parambegw;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public static void a(List<lke> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        lke locallke = (lke)paramList.remove(i);
        if (locallke != null) {
          locallke.a();
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
        this.jdField_a_of_type_Lke = jdField_b_of_type_Lke;
        jdField_b_of_type_Lke = this;
        c += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lke
 * JD-Core Version:    0.7.0.1
 */