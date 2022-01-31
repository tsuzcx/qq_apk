import java.util.List;

public class mbm
{
  public static final Object a;
  private static mbm jdField_b_of_type_Mbm;
  private static int jdField_c_of_type_Int;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private axkd jdField_a_of_type_Axkd;
  private String jdField_a_of_type_JavaLangString;
  private mbm jdField_a_of_type_Mbm;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private String jdField_c_of_type_JavaLangString;
  private String d;
  private String e;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public static mbm a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_Mbm != null)
      {
        mbm localmbm = jdField_b_of_type_Mbm;
        jdField_b_of_type_Mbm = localmbm.jdField_a_of_type_Mbm;
        localmbm.jdField_a_of_type_Mbm = null;
        jdField_c_of_type_Int -= 1;
        return localmbm;
      }
      return new mbm();
    }
  }
  
  public static void a(List<mbm> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        mbm localmbm = (mbm)paramList.remove(i);
        if (localmbm != null) {
          localmbm.a();
        }
        i -= 1;
      }
    }
  }
  
  public CharSequence a()
  {
    return this.jdField_a_of_type_Axkd;
  }
  
  public String a()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Axkd = null;
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
        this.jdField_a_of_type_Mbm = jdField_b_of_type_Mbm;
        jdField_b_of_type_Mbm = this;
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
    this.jdField_a_of_type_Axkd = lah.a(paramString, 16);
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
    return "VideoChatMessage{type=" + this.jdField_a_of_type_Int + ", content='" + this.jdField_a_of_type_Axkd + '\'' + ", filepath='" + this.jdField_a_of_type_JavaLangString + '\'' + ", sendState=" + this.jdField_b_of_type_Int + ", time='" + this.jdField_b_of_type_JavaLangString + '\'' + ", header='" + this.jdField_c_of_type_JavaLangString + '\'' + ", imageUrl='" + this.d + '\'' + ", voiceTime=" + this.jdField_a_of_type_Long + ", msgId='" + this.e + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mbm
 * JD-Core Version:    0.7.0.1
 */