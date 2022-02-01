import com.tencent.mobileqq.text.QQText;
import java.util.List;

public class mnk
{
  public static final Object a;
  private static mnk jdField_b_of_type_Mnk;
  private static int jdField_c_of_type_Int;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private QQText jdField_a_of_type_ComTencentMobileqqTextQQText;
  private String jdField_a_of_type_JavaLangString;
  private mnk jdField_a_of_type_Mnk;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private String jdField_c_of_type_JavaLangString;
  private String d;
  private String e;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public static mnk a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_Mnk != null)
      {
        mnk localmnk = jdField_b_of_type_Mnk;
        jdField_b_of_type_Mnk = localmnk.jdField_a_of_type_Mnk;
        localmnk.jdField_a_of_type_Mnk = null;
        jdField_c_of_type_Int -= 1;
        return localmnk;
      }
      return new mnk();
    }
  }
  
  public static void a(List<mnk> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        mnk localmnk = (mnk)paramList.remove(i);
        if (localmnk != null) {
          localmnk.a();
        }
        i -= 1;
      }
    }
  }
  
  public CharSequence a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTextQQText;
  }
  
  public String a()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqTextQQText = null;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_JavaLangString = null;
    this.d = null;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_JavaLangString = null;
    this.e = null;
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_c_of_type_Int < 200)
      {
        this.jdField_a_of_type_Mnk = jdField_b_of_type_Mnk;
        jdField_b_of_type_Mnk = this;
        jdField_c_of_type_Int += 1;
      }
      return;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqTextQQText = lkj.a(paramString, 16);
  }
  
  public String b()
  {
    return this.e;
  }
  
  public void b(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public void c(String paramString)
  {
    this.e = paramString;
  }
  
  public String toString()
  {
    return "VideoChatMessage{type=" + this.jdField_a_of_type_Int + ", content='" + this.jdField_a_of_type_ComTencentMobileqqTextQQText + '\'' + ", filepath='" + this.jdField_a_of_type_JavaLangString + '\'' + ", sendState=" + this.jdField_b_of_type_Int + ", time='" + this.jdField_b_of_type_JavaLangString + '\'' + ", header='" + this.jdField_c_of_type_JavaLangString + '\'' + ", imageUrl='" + this.d + '\'' + ", voiceTime=" + this.jdField_a_of_type_Long + ", msgId='" + this.e + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mnk
 * JD-Core Version:    0.7.0.1
 */