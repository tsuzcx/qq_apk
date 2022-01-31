import java.util.Comparator;
import java.util.List;

public class lai
{
  public static final Object a;
  public static final Comparator<lai> a;
  private static lai b;
  private static int c;
  public int a;
  public axkk a;
  private lai a;
  public int b;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_JavaUtilComparator = new laj();
  }
  
  private lai(axkk paramaxkk, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Axkk = paramaxkk;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public static lai a(axkk paramaxkk, int paramInt1, int paramInt2)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_Lai != null)
      {
        lai locallai = jdField_b_of_type_Lai;
        jdField_b_of_type_Lai = locallai.jdField_a_of_type_Lai;
        locallai.a(paramaxkk, paramInt1, paramInt2);
        c -= 1;
        return locallai;
      }
      return new lai(paramaxkk, paramInt1, paramInt2);
    }
  }
  
  private void a(axkk paramaxkk, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Lai = null;
    this.jdField_a_of_type_Axkk = paramaxkk;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public static void a(List<lai> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        lai locallai = (lai)paramList.remove(i);
        if (locallai != null) {
          locallai.a();
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
        this.jdField_a_of_type_Lai = jdField_b_of_type_Lai;
        jdField_b_of_type_Lai = this;
        c += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lai
 * JD-Core Version:    0.7.0.1
 */