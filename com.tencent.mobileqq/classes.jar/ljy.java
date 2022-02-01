import com.tencent.mobileqq.text.QQText.EmoticonSpan;
import java.util.Comparator;
import java.util.List;

public class ljy
{
  public static final Object a;
  public static final Comparator<ljy> a;
  private static ljy b;
  private static int c;
  public int a;
  public QQText.EmoticonSpan a;
  private ljy a;
  public int b;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_JavaUtilComparator = new ljz();
  }
  
  private ljy(QQText.EmoticonSpan paramEmoticonSpan, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqTextQQText$EmoticonSpan = paramEmoticonSpan;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public static ljy a(QQText.EmoticonSpan paramEmoticonSpan, int paramInt1, int paramInt2)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_Ljy != null)
      {
        ljy localljy = jdField_b_of_type_Ljy;
        jdField_b_of_type_Ljy = localljy.jdField_a_of_type_Ljy;
        localljy.a(paramEmoticonSpan, paramInt1, paramInt2);
        c -= 1;
        return localljy;
      }
      return new ljy(paramEmoticonSpan, paramInt1, paramInt2);
    }
  }
  
  private void a(QQText.EmoticonSpan paramEmoticonSpan, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Ljy = null;
    this.jdField_a_of_type_ComTencentMobileqqTextQQText$EmoticonSpan = paramEmoticonSpan;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public static void a(List<ljy> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        ljy localljy = (ljy)paramList.remove(i);
        if (localljy != null) {
          localljy.a();
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
        this.jdField_a_of_type_Ljy = jdField_b_of_type_Ljy;
        jdField_b_of_type_Ljy = this;
        c += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ljy
 * JD-Core Version:    0.7.0.1
 */