import androidx.annotation.NonNull;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class nek
  extends neg
{
  public static final String a;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private List<Long> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString;
  private int jdField_f_of_type_Int;
  private String jdField_f_of_type_JavaLangString;
  private String g;
  
  static
  {
    jdField_a_of_type_JavaLangString = nek.class.getName();
  }
  
  public nek(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return this.jdField_f_of_type_Int;
  }
  
  @NonNull
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return b() == 1;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Long >= this.jdField_b_of_type_Long) {
      return 0;
    }
    long l = System.currentTimeMillis() / 1000L;
    if (l >= this.jdField_b_of_type_Long) {
      return 4;
    }
    if (l >= this.jdField_a_of_type_Long) {
      return 3;
    }
    if (this.jdField_a_of_type_Long - l > 900L) {
      return 1;
    }
    return 2;
  }
  
  public String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if ((this.jdField_a_of_type_Long <= 0L) || (this.jdField_b_of_type_Long <= 0L) || (this.jdField_a_of_type_Long > this.jdField_b_of_type_Long)) {
      return "";
    }
    long l1 = this.jdField_b_of_type_Long;
    long l2 = this.jdField_a_of_type_Long;
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MM月dd日 HH:mm");
    localStringBuffer.append("时间：");
    localStringBuffer.append(localSimpleDateFormat.format(Long.valueOf(this.jdField_a_of_type_Long * 1000L)));
    localStringBuffer.append("～");
    if (l1 - l2 >= 86400L) {
      localStringBuffer.append(new SimpleDateFormat("MM月dd日 HH:mm").format(Long.valueOf(this.jdField_b_of_type_Long * 1000L)));
    }
    for (;;)
    {
      return localStringBuffer.toString();
      localStringBuffer.append(new SimpleDateFormat("HH:mm").format(Long.valueOf(this.jdField_b_of_type_Long * 1000L)));
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public void b(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String c()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void c(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void c(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
  }
  
  public boolean c()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public int d()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String d()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void d(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void d(String paramString)
  {
    this.jdField_e_of_type_JavaLangString = paramString;
  }
  
  public int e()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public String e()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public void e(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public void e(String paramString)
  {
    this.jdField_f_of_type_JavaLangString = paramString;
  }
  
  public int f()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public String f()
  {
    return this.jdField_e_of_type_JavaLangString;
  }
  
  public void f(String paramString)
  {
    this.g = paramString;
  }
  
  public String g()
  {
    return this.jdField_f_of_type_JavaLangString;
  }
  
  public String h()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nek
 * JD-Core Version:    0.7.0.1
 */