import com.tencent.mobileqq.text.QQText.EmoticonSpan;
import java.util.Comparator;
import java.util.List;

public class lkk
{
  public static final Object a;
  public static final Comparator<lkk> a;
  private static lkk b;
  private static int c;
  public int a;
  public QQText.EmoticonSpan a;
  private lkk a;
  public int b;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_JavaUtilComparator = new lkl();
  }
  
  private lkk(QQText.EmoticonSpan paramEmoticonSpan, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqTextQQText$EmoticonSpan = paramEmoticonSpan;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public static lkk a(QQText.EmoticonSpan paramEmoticonSpan, int paramInt1, int paramInt2)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_Lkk != null)
      {
        lkk locallkk = jdField_b_of_type_Lkk;
        jdField_b_of_type_Lkk = locallkk.jdField_a_of_type_Lkk;
        locallkk.a(paramEmoticonSpan, paramInt1, paramInt2);
        c -= 1;
        return locallkk;
      }
      return new lkk(paramEmoticonSpan, paramInt1, paramInt2);
    }
  }
  
  private void a(QQText.EmoticonSpan paramEmoticonSpan, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Lkk = null;
    this.jdField_a_of_type_ComTencentMobileqqTextQQText$EmoticonSpan = paramEmoticonSpan;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public static void a(List<lkk> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        lkk locallkk = (lkk)paramList.remove(i);
        if (locallkk != null) {
          locallkk.a();
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
        this.jdField_a_of_type_Lkk = jdField_b_of_type_Lkk;
        jdField_b_of_type_Lkk = this;
        c += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lkk
 * JD-Core Version:    0.7.0.1
 */