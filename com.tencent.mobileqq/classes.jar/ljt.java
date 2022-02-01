import java.util.Comparator;
import java.util.List;

public class ljt
{
  public static final Object a;
  public static final Comparator<ljt> a;
  private static ljt b;
  private static int c;
  public int a;
  public bdoa a;
  private ljt a;
  public int b;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_JavaUtilComparator = new lju();
  }
  
  private ljt(bdoa parambdoa, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Bdoa = parambdoa;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public static ljt a(bdoa parambdoa, int paramInt1, int paramInt2)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_Ljt != null)
      {
        ljt localljt = jdField_b_of_type_Ljt;
        jdField_b_of_type_Ljt = localljt.jdField_a_of_type_Ljt;
        localljt.a(parambdoa, paramInt1, paramInt2);
        c -= 1;
        return localljt;
      }
      return new ljt(parambdoa, paramInt1, paramInt2);
    }
  }
  
  private void a(bdoa parambdoa, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Ljt = null;
    this.jdField_a_of_type_Bdoa = parambdoa;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public static void a(List<ljt> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        ljt localljt = (ljt)paramList.remove(i);
        if (localljt != null) {
          localljt.a();
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
        this.jdField_a_of_type_Ljt = jdField_b_of_type_Ljt;
        jdField_b_of_type_Ljt = this;
        c += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ljt
 * JD-Core Version:    0.7.0.1
 */